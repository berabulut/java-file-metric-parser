package com.github.berabulut;

import com.github.javaparser.ast.Node;

public class SameTypeSuite {
	Node node;
	boolean expected;
	
	SameTypeSuite(Node node, boolean expected) {
		this.node = node;
		this.expected = expected;
	}
}