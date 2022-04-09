package com.github.berabulut.testdata;

/* Method   		   count: 1
 * Binary     operator count: 2
 * Unary      operator count: 1
 * Logical 	  operator count: 3
 * Operand  		   count: 5
 */
public class Logical{
 public boolean test(boolean x) {
	 
	 if (x && true)  return x;
	 if (x || false) return x;
	 if (!x) return x;
	 
	 return x;
 }
}
