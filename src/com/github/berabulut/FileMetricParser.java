package com.github.berabulut;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitor;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

import java.io.File;
import java.io.FileNotFoundException;


public class FileMetricParser {

    private static Operator binary;
    private static Operator unary;
    private static Operator assignment;

    private static Operator relational;
    private static Operator logical;
    private static Operator arithmetic;

    private static int methodCount;

    private File file;
    private VoidVisitor<Void> nodeVisitor = new NodeVisitor();

    FileMetricParser(File file) throws FileNotFoundException {
        this.file = file;

        this.binary = new BinaryOperator();
        this.unary = new UnaryOperator();
        this.assignment = new AssignmentOperator();

        this.relational = new RelationalOperator();
        this.logical = new LogicalOperator();
        this.arithmetic = new ArithmeticOperator();
    }

    static private void incrementMethodCount() {
        methodCount += 1;
    }

    public int getMethodCount() {
        return methodCount;
    }

    public int getOperandCount() {
        return binary.getOperandCount() + unary.getOperandCount() + assignment.getOperandCount();
    }

    public int getUnaryOperatorCount() {
        return unary.getCount();
    }
    public int getBinaryOperatorCount() {
        return binary.getCount();
    }
    public int getRelationalOperatorCount() {
        return relational.getCount();
    }
    public int getArithmeticOperatorCount() {
        return arithmetic.getCount();
    }
    public int getLogicalOperatorCount() { return logical.getCount(); }

    public void Parse() throws FileNotFoundException {
        CompilationUnit cu = StaticJavaParser.parse(file);
        nodeVisitor.visit(cu, null);
    }

    private static class NodeVisitor extends VoidVisitorAdapter<Void> {
        @Override
        public void visit(MethodDeclaration md, Void arg) {
            super.visit(md, arg);

            incrementMethodCount();

            md.walk(node -> {
                if (unary.SameType(node)) {
                    unary.incrementCount();
                    unary.incrementOperandCount();
                } else if (binary.SameType(node)) {
                    binary.incrementCount();
                    binary.incrementOperandCount();
                } else if(assignment.SameType(node)) {
                    assignment.incrementOperandCount();
                }

                if (relational.SameType(node)) {
                    relational.incrementCount();
                } else if(logical.SameType(node)){
                    logical.incrementCount();
                } else if(arithmetic.SameType(node)) {
                    arithmetic.incrementCount();
                }
            });
        }
    }
}
