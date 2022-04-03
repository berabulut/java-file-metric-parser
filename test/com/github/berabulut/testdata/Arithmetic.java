package com.github.berabulut.testdata;

/* Method   		   count: 3
 * Operand  		   count: 52
 * Binary     operator count: 8
 * Unary 	  operator count: 4
 * Arithmetic operator count: 28
 * Total 	  operator count: 28
 */
public class Arithmetic {
	
	/* Binary     operator count: 8
	 * Arithmetic operator count: 16 
	 * Total      operator count: 16 
	 * Operand 			   count: 24 
	 */ 
    public void test1(int x) {
        x = x + 1;
        x = x - 1;
        x = x / 1;
        x = x % 2;
        x = x & 1;
        x = x | 2;
        x = x ^ 1;
        x = x * 2;
    }
    
    /* Unary 	  operator count: 4
     * Arithmetic operator count: 4
     * Total      operator count: 4
     * Operand count: 4
     */
    public void test2(int x) {  
    	x++;
    	x--;
    	--x;
    	++x;
    }
    
    /* Arithmetic operator count: 8
     * Total 	  operator count: 8
     * Operand count: 24
     */
    public void test3(int x) {  
    	x += 1;
    	x -= 9;
    	x *= 10;
    	x /= 1;
    	x %= 1;
    	x &= 1;
    	x |= 1;
    	x ^= 1;
    }
}
