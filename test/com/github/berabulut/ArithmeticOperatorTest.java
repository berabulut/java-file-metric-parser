package com.github.berabulut;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import com.github.javaparser.ast.expr.AssignExpr;
import com.github.javaparser.ast.expr.BinaryExpr;
import com.github.javaparser.ast.expr.UnaryExpr;
import com.github.javaparser.ast.expr.VariableDeclarationExpr;

class ArithmeticOperatorTest {
		
	static Stream<SameTypeSuite> sameTypeArgsProvider() {
		return Stream.of(new SameTypeSuite(new AssignExpr(), true),
				new SameTypeSuite(new VariableDeclarationExpr(), true));
	}
	
	@ParameterizedTest
	@MethodSource("sameTypeArgsProvider")
	void testSameType(SameTypeSuite suite) {
		var got = new ArithmeticOperator().SameType(suite.node);
		
		assertEquals(suite.expected, got);
	}
	
	
	static Stream<BinaryExpr.Operator> truthyBinaryArgsProvider() {
		return Stream.of(BinaryExpr.Operator.PLUS, BinaryExpr.Operator.MINUS, 
				BinaryExpr.Operator.MULTIPLY, BinaryExpr.Operator.DIVIDE, 
				BinaryExpr.Operator.REMAINDER, BinaryExpr.Operator.XOR,
				BinaryExpr.Operator.BINARY_AND, BinaryExpr.Operator.BINARY_OR);
	}
	
	@ParameterizedTest
	@MethodSource("truthyBinaryArgsProvider")
	void testSameTypeWithTruthyBinaryOperators(BinaryExpr.Operator operator) {

		var be = new BinaryExpr();
		be.setOperator(operator);
		
		var expected = true;
		var got = new ArithmeticOperator().SameType(be);
		
		assertEquals(expected, got);

	}
	
	static Stream<BinaryExpr.Operator> falsyBinaryArgsProvider() {
		return Stream.of(BinaryExpr.Operator.LESS, BinaryExpr.Operator.GREATER);
	}
	
	@ParameterizedTest
	@MethodSource("falsyBinaryArgsProvider")
	void testSameTypeWithFalsyBinaryOperators(BinaryExpr.Operator operator) {

		var be = new BinaryExpr();
		be.setOperator(operator);
		
		var expected = false;
		var got = new ArithmeticOperator().SameType(be);
		
		assertEquals(expected, got);

	}
	
	
	static Stream<UnaryExpr.Operator> truthyUnaryArgsProvider() {
		return Stream.of(UnaryExpr.Operator.POSTFIX_DECREMENT, UnaryExpr.Operator.POSTFIX_INCREMENT,
				UnaryExpr.Operator.PREFIX_DECREMENT, UnaryExpr.Operator.PREFIX_INCREMENT);
	}
	
	@ParameterizedTest
	@MethodSource("truthyUnaryArgsProvider")
	void testSameTypeWithTruthyUnaryOperators(UnaryExpr.Operator operator) {

		var ue = new UnaryExpr();
		ue.setOperator(operator);
		
		var expected = true;
		var got = new ArithmeticOperator().SameType(ue);
		
		assertEquals(expected, got);

	}
	
	static Stream<UnaryExpr.Operator> falsyUnaryArgsProvider() {
		return Stream.of(UnaryExpr.Operator.LOGICAL_COMPLEMENT, UnaryExpr.Operator.PLUS,
				UnaryExpr.Operator.MINUS);
	}
	
	@ParameterizedTest
	@MethodSource("falsyUnaryArgsProvider")
	void testSameTypeWithFalsyUnaryOperators(UnaryExpr.Operator operator) {

		var ue = new UnaryExpr();
		ue.setOperator(operator);
		
		var expected = false;
		var got = new ArithmeticOperator().SameType(ue);
		
		assertEquals(expected, got);

	}
}
