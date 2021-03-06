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

class AssignmentOperatorTest {
	
	static Stream<SameTypeSuite> sameTypeArgsProvider() {
		return Stream.of(new SameTypeSuite(new AssignExpr(), true),
				new SameTypeSuite(new VariableDeclarationExpr(), false),
				new SameTypeSuite(new UnaryExpr(), false),
				new SameTypeSuite(new BinaryExpr(), false));
	}
	
	@ParameterizedTest
	@MethodSource("sameTypeArgsProvider")
	void testSameType(SameTypeSuite suite) {
		var got = new AssignmentOperator().SameType(suite.node);
		
		assertEquals(suite.expected, got);
	}
	
	@RepeatedTest(3)
	void testIncrementOperandCount() {
		AssignmentOperator operator = new AssignmentOperator();
	    operator.incrementOperandCount();
	    assertEquals(2, operator.operandCount);
	}
	
	@ParameterizedTest
	@ValueSource(ints = { 2, 8, 10})
	void testIncrementOperandCountWithDifferentValues(int operandCount) {
		AssignmentOperator operator = new AssignmentOperator();
		operator.operandCount = operandCount;
	    operator.incrementOperandCount();
	    assertEquals(operandCount + 2, operator.operandCount);
	}

}
