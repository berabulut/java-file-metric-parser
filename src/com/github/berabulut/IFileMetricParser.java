package com.github.berabulut;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public interface IFileMetricParser {
    public int getMethodCount();

    public int getUnaryOperatorCount();
    public int getBinaryOperatorCount();

    public int getRelationalOperatorCount();
    public int getArithmeticOperatorCount();
    public int getLogicalOperatorCount();

    public int getOperandCount();

    public boolean isJavaFile(File file);

    public void Parse(File file) throws IOException;
}
