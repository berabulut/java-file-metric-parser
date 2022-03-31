package com.github.berabulut;

import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.expr.AssignExpr;

public class AssignmentOperator extends Operator{
    public boolean SameType(Node node) {
        return node instanceof AssignExpr;
    }
    @Override
    public void incrementOperandCount() {
        operandCount += 2;
    }
}
