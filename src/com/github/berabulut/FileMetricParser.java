package com.github.berabulut;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitor;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;


public class FileMetricParser implements IFileMetricParser{

    private final IOperator binary;
    private final IOperator unary;
    private final IOperator assignment;

    private final IOperator relational;
    private final IOperator logical;
    private final IOperator arithmetic;

    private int methodCount;

    private final VoidVisitor<Void> nodeVisitor;

    public FileMetricParser() {
        binary = new BinaryOperator();
        unary = new UnaryOperator();
        assignment = new AssignmentOperator();

        relational = new RelationalOperator();
        logical = new LogicalOperator();
        arithmetic = new ArithmeticOperator();

        nodeVisitor = new NodeVisitor();
    }

    private void incrementMethodCount() {
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

    public boolean isJavaFile(File file){
        String fileName = file.toString();
        int index = fileName.lastIndexOf('.');
        if(index > 0) {
            String extension = fileName.substring(index + 1);
            if (extension.equals("java")) {
                return true;
            }
        }
        return false;
    }

    public void Parse(File file) throws IOException {
        if (!isJavaFile(file)) {
            throw new IOException("Not a java file");
        }

        CompilationUnit cu = StaticJavaParser.parse(file);
        nodeVisitor.visit(cu, null);
    }

    private class NodeVisitor extends VoidVisitorAdapter<Void> {
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
