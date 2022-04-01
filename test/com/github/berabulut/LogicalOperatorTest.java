package com.github.berabulut;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import com.github.javaparser.ast.expr.AssignExpr;
import com.github.javaparser.ast.expr.BinaryExpr;
import com.github.javaparser.ast.expr.UnaryExpr;
import com.github.javaparser.ast.expr.VariableDeclarationExpr;

class LogicalOperatorTest {

	static Stream<SameTypeSuite> sameTypeArgsProvider() {
		return Stream.of(new SameTypeSuite(new AssignExpr(), false),
				new SameTypeSuite(new VariableDeclarationExpr(), false));
	}
	
	@ParameterizedTest
	@MethodSource("sameTypeArgsProvider")
	void testSameType(SameTypeSuite suite) {
		var got = new LogicalOperator().SameType(suite.node);
		
		assertEquals(suite.expected, got);
	}
	
	
	static Stream<BinaryExpr.Operator> truthyBinaryArgsProvider() {
		return Stream.of(BinaryExpr.Operator.AND, BinaryExpr.Operator.OR);
	}
	
	@ParameterizedTest
	@MethodSource("truthyBinaryArgsProvider")
	void testSameTypeWithTruthyBinaryOperators(BinaryExpr.Operator operator) {
		var be = new BinaryExpr();
		be.setOperator(operator);
		
		var expected = true;
		var got = new LogicalOperator().SameType(be);
		
		assertEquals(expected, got);
	}
	
	
	static Stream<BinaryExpr.Operator> falsyBinaryArgsProvider() {
		return Stream.of(BinaryExpr.Operator.PLUS, BinaryExpr.Operator.MINUS, 
				BinaryExpr.Operator.MULTIPLY, BinaryExpr.Operator.DIVIDE, 
				BinaryExpr.Operator.REMAINDER, BinaryExpr.Operator.XOR,
				BinaryExpr.Operator.BINARY_AND, BinaryExpr.Operator.BINARY_OR);
	}
	
	@ParameterizedTest
	@MethodSource("falsyBinaryArgsProvider")
	void testSameTypeWithFalsyBinaryOperators(BinaryExpr.Operator operator) {
		var be = new BinaryExpr();
		be.setOperator(operator);
		
		var expected = false;
		var got = new LogicalOperator().SameType(be);
		
		assertEquals(expected, got);
	}
	
	
	static Stream<UnaryExpr.Operator> truthyUnaryArgsProvider() {
		return Stream.of(UnaryExpr.Operator.LOGICAL_COMPLEMENT);
	}
	
	@ParameterizedTest
	@MethodSource("truthyUnaryArgsProvider")
	void testSameTypeWithTruthyUnaryOperators(UnaryExpr.Operator operator) {
		var ue = new UnaryExpr();
		ue.setOperator(operator);
		
		var expected = true;
		var got = new LogicalOperator().SameType(ue);
		
		assertEquals(expected, got);
	}
	
	
	static Stream<UnaryExpr.Operator> falsyUnaryArgsProvider() {
		return Stream.of(UnaryExpr.Operator.PLUS, UnaryExpr.Operator.MINUS,
				UnaryExpr.Operator.POSTFIX_INCREMENT, UnaryExpr.Operator.POSTFIX_DECREMENT,
				UnaryExpr.Operator.PREFIX_INCREMENT, UnaryExpr.Operator.PREFIX_DECREMENT);
	}
	
	@ParameterizedTest
	@MethodSource("falsyUnaryArgsProvider")
	void testSameTypeWithFalsyUnaryOperators(UnaryExpr.Operator operator) {
		var ue = new UnaryExpr();
		ue.setOperator(operator);
		
		var expected = false;
		var got = new LogicalOperator().SameType(ue);
		
		assertEquals(expected, got);
	}

}
