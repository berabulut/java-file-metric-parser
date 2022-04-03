package com.github.berabulut.testdata;

/* Method   		   count: 3
 * Operand  		   count: 52
 * Binary     operator count: 8
 * Unary 	  operator count: 4
 * Arithmetic operator count: 28
 * Total 	  operator count: 28
 */
public class Mix {

    /* Binary     operator count: 10
     * Arithmetic operator count: 12
     * Total      operator count: 12
     * Operand 			   count: 22
     */
    public void test1() {
        int a = 12, b = 5;
        System.out.println("a + b = " + (a + b));
        System.out.println("a - b = " + (a - b));
        System.out.println("a * b = " + (a * b));
        System.out.println("a / b = " + (a / b));
        System.out.println("a % b = " + (a % b));
    }

    /* Unary 	  operator count: 4
     * Arithmetic operator count: 4
     * Total      operator count: 4
     * Operand count: 4
     */
    public void test2(int x) {
    }

    /* Arithmetic operator count: 8
     * Total 	  operator count: 8
     * Operand count: 24
     */
    public void test3(int x) {
    }
}
