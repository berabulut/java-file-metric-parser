package com.github.berabulut;

import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.expr.BinaryExpr;
import com.github.javaparser.ast.expr.UnaryExpr;


public class LogicalOperator extends Operator{
    public boolean SameType(Node node) {
        String operator;
        boolean isRelational;

        boolean isBinary = node instanceof BinaryExpr;
        if (isBinary) {
            BinaryExpr be = (BinaryExpr) node;
            operator = be.getOperator().asString();

            isRelational = operator.equals("&&") || operator.equals("||");
            if (isRelational) {
                return true;
            }
        }

        boolean isUnary = node instanceof UnaryExpr;
        if (isUnary) {
            UnaryExpr ue = (UnaryExpr) node;
            operator = ue.getOperator().asString();

            isRelational = operator.equals("!");
            if (isRelational) {
                return true;
            }
        }

        return false;
    }
}
