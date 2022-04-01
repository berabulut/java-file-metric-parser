package com.github.berabulut;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.expr.AssignExpr;
import com.github.javaparser.ast.expr.BinaryExpr;
import com.github.javaparser.ast.expr.UnaryExpr;
import com.github.javaparser.ast.expr.VariableDeclarationExpr;

class RelationalOperatorTest {
	
	static Stream<SameTypeSuite> sameTypeArgsProvider() {
		return Stream.of(new SameTypeSuite(new AssignExpr(), false),
				new SameTypeSuite(new VariableDeclarationExpr(), false),
				new SameTypeSuite(new UnaryExpr(), false),
				new SameTypeSuite(new BinaryExpr(), true));
	}
	
	@ParameterizedTest
	@MethodSource("sameTypeArgsProvider")
	void testSameType(SameTypeSuite suite) {
		var got = new RelationalOperator().SameType(suite.node);
		
		assertEquals(suite.expected, got);
	}
	
	
	static Stream<BinaryExpr.Operator> truthyArgsProvider() {
		return Stream.of(BinaryExpr.Operator.GREATER, BinaryExpr.Operator.LESS, 
				BinaryExpr.Operator.GREATER_EQUALS, BinaryExpr.Operator.LESS_EQUALS, 
				BinaryExpr.Operator.EQUALS, BinaryExpr.Operator.NOT_EQUALS);
	}
	
	@ParameterizedTest
	@MethodSource("truthyArgsProvider")
	void testSameTypeWithTruthyOperators(BinaryExpr.Operator operator) {
		RelationalOperator re = new RelationalOperator();
		
		var binaryExpr = new BinaryExpr();
		binaryExpr.setOperator(operator);
		
		var expected = true;
		var got = re.SameType(binaryExpr);
		
		assertEquals(expected, got);

	}
	
	static Stream<BinaryExpr.Operator> falsyArgsProvider() {
		return Stream.of(BinaryExpr.Operator.PLUS, BinaryExpr.Operator.MINUS, 
				BinaryExpr.Operator.BINARY_OR, BinaryExpr.Operator.BINARY_AND, 
				BinaryExpr.Operator.DIVIDE, BinaryExpr.Operator.MULTIPLY);
	}
	
	@ParameterizedTest
	@MethodSource("falsyArgsProvider")
	void testSameTypeWithFalsyOperators(BinaryExpr.Operator operator) {
		RelationalOperator re = new RelationalOperator();
		
		var binaryExpr = new BinaryExpr();
		binaryExpr.setOperator(operator);
		
		var expected = false;
		var got = re.SameType(binaryExpr);
		
		assertEquals(expected, got);

	}

}
