package com.github.berabulut.testdata;

/* Method   		   count: 1
 * Binary     operator count: 6
 * Relational operator count: 6
 * Arithmetic operator count: 1
 * Operand  		   count: 14
 */
public class Relational {
	 public boolean test(int x) {

		 // First '=' is variable declaration, not counting it as an arithmetic operator
		 // Same thing goes with counting operands, not counting operands for '=' when declaring variables
		 // But operands of x > 1 operation counted
		 boolean t = x > 1;
		 // Second '=' is assignment, counting it as an arithmetic operator
		 t = x < 1;
		 
		 if (x <= 1) return t;
		 if (x >= 1) return t;
		 if (x == 1) return t;
		 if (x != 1) return t;
		 
		 return t;
	  
	 }
}
