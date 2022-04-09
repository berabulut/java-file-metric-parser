package com.github.berabulut.testdata;

/* Method   		   count: 4
 * Binary     operator count: 17
 * Unary 	  operator count: 3
 * Arithmetic operator count: 18
 * Relational operator count: 4
 * Logical    operator count: 3
 * Operand  		   count: 47
 */
public class Mix {

    /* Binary     operator count: 11
     * Arithmetic operator count: 12
     * Operand 			   count: 24
     */
    public void test1() {
        int a = 12, b = 5;
        a = a + b;
        System.out.println("a + b = " + (a + b));
        System.out.println("a - b = " + (a - b));
        System.out.println("a * b = " + (a * b));
        System.out.println("a / b = " + (a / b));
        System.out.println("a % b = " + (a % b));
    }

    /* Unary 	  operator count: 3 (++, --, !)
     * Binary     operator count: 2 (>, <)
     * Relational operator count: 2 (>, <)
     * Arithmetic operator count: 2 (++, --)
     * Logical    operator count: 1 (!)
     * Operand count: 7
     */
    public void test2(int x) {
        if(x++ > 10) return;
        if(x-- < 10) return;
        if (!true) return;
    }

    /* Arithmetic operator count: 4
     * Operand count: 8
     */
    public void test3(int x) {
        x ^= 2;
        x %= 2;
        x *= 2;
        x &= 2;
    }

    /* Binary     operator count: 4
     * Relational operator count: 2
     * Logical    operator count: 2
     * Operand count: 8
     */
    public void test3(boolean x) {
        if (x == true) return;
        if (x != true) return;
        if (x && true) return;
        if (x || true) return;
    }
}
