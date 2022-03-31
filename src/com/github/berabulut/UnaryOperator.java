package com.github.berabulut;

import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.expr.UnaryExpr;

public class UnaryOperator extends Operator{
    public boolean SameType(Node node) {
        return node instanceof UnaryExpr;
    }

    @Override
    public void incrementOperandCount() {
        operandCount += 1;
    }
    
    public int add(int a, int b) {
        return a + b;
    }
}
