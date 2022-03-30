package com.github.berabulut;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.expr.BinaryExpr;
import com.github.javaparser.ast.visitor.VoidVisitor;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import com.github.javaparser.utils.Log;

import java.io.File;
import java.io.FileNotFoundException;


public class OperatorParser {

    static Operator binary;
    static Operator unary;

    static Operator relational;
    static Operator logical;

    CompilationUnit cu;
    VoidVisitor<Void> nodeVisitor = new NodeVisitor();

    OperatorParser(File file) throws FileNotFoundException {
        this.cu = StaticJavaParser.parse(file);

        this.binary = new BinaryOperator();
        this.unary = new UnaryOperator();

        this.relational = new RelationalOperator();
        this.logical = new LogicalOperator();
    }

    public void Parse() {
        nodeVisitor.visit(cu, null);
        System.out.println("Unary: " + unary.getCount());
        System.out.println("Binary: " + binary.getCount());
        System.out.println("Relational: " + relational.getCount());
        System.out.println("Logical: " + logical.getCount());
    }

    private static class NodeVisitor extends VoidVisitorAdapter<Void> {

        @Override
        public void visit(MethodDeclaration md, Void arg) {
            super.visit(md, arg);
            md.walk(node -> {
                if (unary.SameType(node)) {
                    unary.incrementCount();
                }  else if (binary.SameType(node)) {
                    binary.incrementCount();
                    BinaryExpr be = (BinaryExpr) node;
                    be.getOperator();
                }

                if(relational.SameType(node)) {
                    relational.incrementCount();
                } else if(logical.SameType(node)){
                    logical.incrementCount();
                }
            });
        }
    }
}
