package com.github.berabulut.testdata;

/* Method   		   count: 1
 * Operand  		   count: 14
 * Binary     operator count: 6
 * Relational operator count: 6
 * Arithmetic operator count: 2
 * Total 	  operator count: 8
 */
public class Relational {
	 public boolean test(int x) {
		 
		 boolean t = x > 1;
		 t = x < 1;
		 
		 if (x <= 1) return t;
		 if (x >= 1) return t;
		 if (x == 1) return t;
		 if (x != 1) return t;
		 
		 return t;
	  
	 }
}
