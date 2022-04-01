package com.github.berabulut;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import com.github.javaparser.ast.expr.AssignExpr;
import com.github.javaparser.ast.expr.BinaryExpr;
import com.github.javaparser.ast.expr.UnaryExpr;
import com.github.javaparser.ast.expr.VariableDeclarationExpr;

class BinaryOperatorTest {

	static Stream<SameTypeSuite> sameTypeArgsProvider() {
		return Stream.of(new SameTypeSuite(new AssignExpr(), false),
				new SameTypeSuite(new VariableDeclarationExpr(), false),
				new SameTypeSuite(new UnaryExpr(), false),
				new SameTypeSuite(new BinaryExpr(), true));
	}
	
	@ParameterizedTest
	@MethodSource("sameTypeArgsProvider")
	void testSameType(SameTypeSuite suite) {
		var got = new BinaryOperator().SameType(suite.node);
		
		assertEquals(suite.expected, got);
	}
	
	
	@RepeatedTest(3)
	void testIncrementOperandCount() {
		BinaryOperator operator = new BinaryOperator();
	    operator.incrementOperandCount();
	    assertEquals(2, operator.operandCount);
	}
	
	@ParameterizedTest
	@ValueSource(ints = { 3, 6, 15})
	void testIncrementOperandCountWithDifferentValues(int operandCount) {
		BinaryOperator operator = new BinaryOperator();
		operator.operandCount = operandCount;
	    operator.incrementOperandCount();
	    assertEquals(operandCount + 2, operator.operandCount);
	}

}
