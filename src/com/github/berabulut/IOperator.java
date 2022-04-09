package com.github.berabulut;

import com.github.javaparser.ast.Node;

public interface IOperator {
    public int getCount();
    public void incrementCount();

    public int getOperandCount();
    public void incrementOperandCount();

    public boolean SameType(Node node);
}
