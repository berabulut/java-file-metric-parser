package com.github.berabulut;

import java.io.File;

public class Main {
    private static final String FILE_PATH = "/Users/berabulut/IdeaProjects/src/com/company/out.yaml";

    public static void main(String[] args) throws Exception {
        File file = new File(FILE_PATH);
        /* CompilationUnit cu = StaticJavaParser.parse(file);
         PrintStream fileOut = new PrintStream("./out.yaml");
         System.setOut(fileOut);
         YamlPrinter printer = new YamlPrinter(true);
         System.out.println(printer.output(cu));*/

        FileMetricParser parser = new FileMetricParser();
        parser.Parse(file);

        System.out.println("Unary: " + parser.getUnaryOperatorCount());
        System.out.println("Binary: " + parser.getBinaryOperatorCount());

    }
}
