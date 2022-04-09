package com.github.berabulut;

import com.github.javaparser.ast.Node;

public abstract class Operator implements IOperator{
    private int count;
    protected int operandCount;

    public int getCount(){
        return count;
    }
    public void incrementCount(){
        count += 1;
    }

    public int getOperandCount(){
        return operandCount;
    }
    public void incrementOperandCount() {}

    public abstract boolean SameType(Node node);
}
