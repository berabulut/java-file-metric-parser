package com.github.berabulut;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.printer.YamlPrinter;

import java.io.File;
import java.io.PrintStream;

public class Main {
    private static final String FILE_PATH = "/Users/berabulut/IdeaProjects/src/com/company/MethodNamePrinter.java";
    public static void main(String[] args) throws Exception{
        File file = new File(FILE_PATH);
       /* CompilationUnit cu = StaticJavaParser.parse(file);
        PrintStream fileOut = new PrintStream("./out.yaml");
        System.setOut(fileOut);
        YamlPrinter printer = new YamlPrinter(true);
        System.out.println(printer.output(cu));*/

        FileMetricParser parser = new FileMetricParser(file);
        parser.Parse();

        System.out.println("Unary: " + parser.getUnaryOperatorCount());
        System.out.println("Binary: " + parser.getBinaryOperatorCount());

        System.out.println("Relational: " + parser.getRelationalOperatorCount());
        System.out.println("Arithmetic: " + parser.getArithmeticOperatorCount());
        System.out.println("Logical: " + parser.getLogicalOperatorCount());

        System.out.println("Operand: " + parser.getOperandCount());

        System.out.println("Method: " + parser.getMethodCount());

    }
}
