package com.github.berabulut;

import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.expr.BinaryExpr;

import java.util.ArrayList;
import java.util.List;

public class RelationalOperator extends Operator{
    List<String> operators = new ArrayList<String>() {
        {
            add(">");
            add("<");
            add(">=");
            add("<=");
            add("==");
            add("!=");
        }
    };

    public boolean SameType(Node node) {
        boolean isBinary = node instanceof BinaryExpr;
        if (!isBinary) {
            return false;
        }
        BinaryExpr be = (BinaryExpr) node;
        String operator = be.getOperator().asString();

        if (operators.contains(operator)) {
            return true;
        }

        return false;
    }
}
