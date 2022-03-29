package com.github.berabulut;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.printer.YamlPrinter;

import java.io.File;
import java.io.PrintStream;

public class Main {
    private static final String FILE_PATH = "/Users/berabulut/IdeaProjects/src/com/company/OperatorTest.java";
    public static void main(String[] args) throws Exception{
        File file = new File(FILE_PATH);
        CompilationUnit cu = StaticJavaParser.parse(file);
       /* PrintStream fileOut = new PrintStream("./out.yaml");
        System.setOut(fileOut);
        YamlPrinter printer = new YamlPrinter(true);
        System.out.println(printer.output(cu));*/

        OperatorParser newParser = new OperatorParser(file);
        newParser.Parse();
    }
}
