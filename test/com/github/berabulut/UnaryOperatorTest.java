package com.github.berabulut;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UnaryOperatorTest {

	@Test
	public void testAdd() {
	    UnaryOperator operator= new UnaryOperator();
	    int a = 1234;
	    int b = 5678;
	    int actual = operator.add(a, b);
	 
	    int expected = 6912;
	 
	    assertEquals(expected, actual);
	}

}
