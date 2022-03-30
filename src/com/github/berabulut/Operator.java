package com.github.berabulut;

import com.github.javaparser.ast.Node;

public abstract class Operator {
    private int count;

    public int getCount(){
        return count;
    }

    public void incrementCount(){
        this.count += 1;
    }

    public abstract boolean SameType(Node node);
}
