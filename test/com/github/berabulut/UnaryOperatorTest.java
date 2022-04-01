package com.github.berabulut;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import com.github.javaparser.ast.expr.AssignExpr;
import com.github.javaparser.ast.expr.BinaryExpr;
import com.github.javaparser.ast.expr.UnaryExpr;
import com.github.javaparser.ast.expr.VariableDeclarationExpr;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class UnaryOperatorTest {
	
	static Stream<SameTypeSuite> sameTypeArgsProvider() {
		return Stream.of(new SameTypeSuite(new AssignExpr(), false),
				new SameTypeSuite(new VariableDeclarationExpr(), false),
				new SameTypeSuite(new UnaryExpr(), true),
				new SameTypeSuite(new BinaryExpr(), false));
	}
	
	@ParameterizedTest
	@MethodSource("sameTypeArgsProvider")
	void testSameType(SameTypeSuite suite) {
		var got = new UnaryOperator().SameType(suite.node);
		
		assertEquals(suite.expected, got);
	}
	
	
	
	@RepeatedTest(3)
	void testIncrementOperandCount() {
		UnaryOperator operator = new UnaryOperator();
	    operator.incrementOperandCount();
	    assertEquals(1, operator.operandCount);
	}
	
	@ParameterizedTest
	@ValueSource(ints = { 4, 1, 11})
	void testIncrementOperandCountWithDifferentValues(int operandCount) {
		UnaryOperator operator = new UnaryOperator();
		operator.operandCount = operandCount;
	    operator.incrementOperandCount();
	    assertEquals(operandCount + 1, operator.operandCount);
	}

}
