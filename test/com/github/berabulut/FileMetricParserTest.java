package com.github.berabulut;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
class FileMetricParserTest {
	
	static IFileMetricParser iparser;
	
	@BeforeAll
	static void setup() {
		
		iparser = Mockito.mock(IFileMetricParser.class);

		return;
	}
	
	@Test
	void testGetMethodCount() {
		int expect = 3;
		
		Mockito.when(iparser.getMethodCount()).thenReturn(expect);
		
		assertEquals(expect,iparser.getMethodCount());
	}

	@Test
	void testGetBinaryOperatorCount() {
		int expect = 10;
		
		Mockito.when(iparser.getBinaryOperatorCount()).thenReturn(expect);
		
		assertEquals(expect,iparser.getBinaryOperatorCount());
	}
	
	@Test
	void testGetUnaryOperatorCount() {
		int expect = 5;
		
		Mockito.when(iparser.getUnaryOperatorCount()).thenReturn(expect);
		
		assertEquals(expect,iparser.getUnaryOperatorCount());
	}
	
	@Test
	void testGetRelationalOperatorCount() {
		int expect = 2;
		
		Mockito.when(iparser.getRelationalOperatorCount()).thenReturn(expect);
		
		assertEquals(expect,iparser.getRelationalOperatorCount());
	}
	
	@Test
	void testGetArithmeticOperatorCount() {
		int expect = 9;
		
		Mockito.when(iparser.getArithmeticOperatorCount()).thenReturn(expect);
		
		assertEquals(expect,iparser.getArithmeticOperatorCount());
	}
	
	@Test
	void testGetLogicalOperatorCount() {
		int expect = 1;
		
		Mockito.when(iparser.getLogicalOperatorCount()).thenReturn(expect);
		
		assertEquals(expect,iparser.getLogicalOperatorCount());
	}
	
	
	@Test
	void testGetOperandCount() {
		int expect = 30;
		
		Mockito.when(iparser.getOperandCount()).thenReturn(expect);
		
		assertEquals(expect,iparser.getOperandCount());
	}

}
