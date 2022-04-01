package com.github.berabulut;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.expr.UnaryExpr;

import org.junit.jupiter.api.Test;

class UnaryOperatorTest {
	
	@Test
	public void testSameType() {
	    UnaryOperator operator= new UnaryOperator();
	    var unaryExpr = new UnaryExpr();
	    var expected = true;
	    
	    var got =  operator.SameType(unaryExpr);
	    
	    
	    assertEquals(expected, got);
	}
	
	
	
	@Test
	public void testIncrementOperandCount() {
	    UnaryOperator operator= new UnaryOperator();
	    
	    int operandCount = 5;
	    operator.operandCount = operandCount;
	    var expected = operandCount + 1;
	    
	    operator.incrementOperandCount();
	    
	    
	    assertEquals(expected, operator.operandCount);
	}

}
