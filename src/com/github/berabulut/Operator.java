package com.github.berabulut;

public class Operator {
    private int count;
    private String name;

    Operator(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getCount(){
        return count;
    }

    public void incrementCount(){
        this.count += 1;
    }
}
