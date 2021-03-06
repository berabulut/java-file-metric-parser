package com.github.berabulut;

import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.expr.AssignExpr;
import com.github.javaparser.ast.expr.BinaryExpr;
import com.github.javaparser.ast.expr.UnaryExpr;
import com.github.javaparser.ast.expr.VariableDeclarationExpr;

import java.util.ArrayList;
import java.util.List;

public class ArithmeticOperator extends Operator{
    List<String> binaryOperators = new ArrayList<String>() {
        {
            add("+");
            add("-");
            add("*");
            add("/");
            add("%");
            add("&");
            add("|");
            add("^");
        }
    };

    public boolean SameType(Node node) {
        String operator;

        boolean isAssignment = node instanceof AssignExpr;
        if (isAssignment) {
            return true;
        }

        boolean isBinary = node instanceof BinaryExpr;
        if (isBinary) {
            BinaryExpr be = (BinaryExpr) node;
            operator = be.getOperator().asString();

            if (binaryOperators.contains(operator)) {
                return true;
            }
        }

        boolean isUnary = node instanceof UnaryExpr;
        if (isUnary) {
            UnaryExpr ue = (UnaryExpr) node;
            operator = ue.getOperator().asString();

            boolean isArithmetic = operator.equals("--") || operator.equals("++");
            if (isArithmetic) {
                return true;
            }
        }

        return false;
    }
}
