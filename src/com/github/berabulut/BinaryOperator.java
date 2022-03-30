package com.github.berabulut;

import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.expr.BinaryExpr;


public class BinaryOperator extends Operator{
    public boolean SameType(Node node) {
        return node instanceof BinaryExpr;
    }
}
