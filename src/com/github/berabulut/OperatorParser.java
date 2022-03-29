package com.github.berabulut;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.expr.AssignExpr;
import com.github.javaparser.ast.expr.BinaryExpr;
import com.github.javaparser.ast.expr.UnaryExpr;
import com.github.javaparser.ast.expr.VariableDeclarationExpr;
import com.github.javaparser.ast.visitor.VoidVisitor;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;

public class OperatorParser {

    static Operator binary;
    static Operator unary;

    CompilationUnit cu;
    VoidVisitor<Void> nodeVisitor = new NodeVisitor();

    OperatorParser(File file) throws FileNotFoundException {
        this.cu = StaticJavaParser.parse(file);
        this.binary = new Operator("Binary");
        this.unary = new Operator("Unary");
    }

    public void Parse() {
        nodeVisitor.visit(cu, null);
        System.out.println(unary.getCount());
    }

    private static class NodeVisitor extends VoidVisitorAdapter<Void> {

        @Override
        public void visit(MethodDeclaration md, Void arg) {
            super.visit(md, arg);
            md.walk(node -> {
                if (node instanceof UnaryExpr) {
                    UnaryExpr ue = (UnaryExpr) node;
                    unary.incrementCount();
                }  else if (node instanceof BinaryExpr) {
                    BinaryExpr be = (BinaryExpr) node;
                    binary.incrementCount();
                }
            });
        }
    }

    private void visit(MethodDeclaration md) {
        md.walk(node -> {
            if (node instanceof UnaryExpr) {
                UnaryExpr ue = (UnaryExpr) node;
                unary.incrementCount();
            }  else if (node instanceof BinaryExpr) {
                BinaryExpr be = (BinaryExpr) node;
                binary.incrementCount();
            }
        });
    }

}
