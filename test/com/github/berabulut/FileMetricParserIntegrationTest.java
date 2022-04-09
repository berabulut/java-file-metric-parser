package com.github.berabulut;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.github.javafaker.Faker;

class FileMetricParserIntegrationTest {
	private static final String FOLDER_PATH = "test/com/github/berabulut/testdata/";
	private static File arithmeticOperatorTestFile;
	private static File logicalOperatorTestFile;
	private static File relationalOperatorTestFile;
	private static File mixOperatorTestFile;
	
	@BeforeAll
	static void setup() {
		arithmeticOperatorTestFile = new File(FOLDER_PATH + "Arithmetic.java");
		if (arithmeticOperatorTestFile.length() == 0) {
			fail("Cannot open Arithmetic.java file");
		}
		logicalOperatorTestFile = new File(FOLDER_PATH + "Logical.java");
		if (logicalOperatorTestFile.length() == 0) {
			fail("Cannot open Logical.java file");
		}
		relationalOperatorTestFile = new File(FOLDER_PATH + "Relational.java");
		if (relationalOperatorTestFile.length() == 0) {
			fail("Cannot open Relational.java file");
		}
		mixOperatorTestFile = new File(FOLDER_PATH + "Mix.java");
		if (mixOperatorTestFile.length() == 0) {
			fail("Cannot open Mix.java file");
		}

		return;
	}

	
	@Test
	void testParse() throws IOException {
		IFileMetricParser parser = new FileMetricParser();
		parser.Parse(arithmeticOperatorTestFile);
	}
	
	@Test
	void testParseNonExistingJavaFile() throws IOException {
		Faker faker = new Faker();
		var file = new File(faker.file().fileName(null, null, "java", null));
		IFileMetricParser parser = new FileMetricParser();
		
		assertThrows(FileNotFoundException.class, ()-> {
			parser.Parse(file);
		});
	}
	
	
	@Test
	void testParseCFile() throws IOException {
		Faker faker = new Faker();
		var file = new File(faker.file().fileName(null, null, "c", null));
		IFileMetricParser parser = new FileMetricParser();
		
		IOException thrown = assertThrows(IOException.class, ()-> {
			parser.Parse(file);
		});
		
		assertTrue(thrown.getMessage().equals("Not a java file"));
	}
	
	@Test
	void testParseYAMLFile() throws IOException {
		Faker faker = new Faker();
		var file = new File(faker.file().fileName(null, null, "yaml", null));
		IFileMetricParser parser = new FileMetricParser();
		
		IOException thrown = assertThrows(IOException.class, ()-> {
			parser.Parse(file);
		});
		
		assertTrue(thrown.getMessage().equals("Not a java file"));
	}
	
	@Test
	void testParseJSONFile() throws IOException {
		Faker faker = new Faker();
		var file = new File(faker.file().fileName(null, null, "json", null));
		IFileMetricParser parser = new FileMetricParser();
		
		IOException thrown = assertThrows(IOException.class, ()-> {
			parser.Parse(file);
		});
		
		assertTrue(thrown.getMessage().equals("Not a java file"));
	}
	
	@Test
	void testParsePythonFile() throws IOException {
		Faker faker = new Faker();
		var file = new File(faker.file().fileName(null, null, "python", null));
		IFileMetricParser parser = new FileMetricParser();
		
		IOException thrown = assertThrows(IOException.class, ()-> {
			parser.Parse(file);
		});
		
		assertTrue(thrown.getMessage().equals("Not a java file"));
	}


	
	@Test
	void testParseWithArithmeticOperators() throws IOException {
		IFileMetricParser parser = new FileMetricParser();
		parser.Parse(arithmeticOperatorTestFile);
		
		// Check Arithmetic.java file to learn where magic numbers come from
		assertEquals(3, parser.getMethodCount());
		assertEquals(52, parser.getOperandCount());
		
		assertEquals(8, parser.getBinaryOperatorCount());
		assertEquals(4, parser.getUnaryOperatorCount());
		assertEquals(28, parser.getArithmeticOperatorCount());
		assertEquals(0, parser.getLogicalOperatorCount());
		assertEquals(0, parser.getRelationalOperatorCount());
	}
	
	@Test
	void testParseWithLogicalOperators() throws IOException {
		IFileMetricParser parser = new FileMetricParser();
		parser.Parse(logicalOperatorTestFile);
		
		// Check Logical.java file to learn where magic numbers come from
		assertEquals(1, parser.getMethodCount());
		assertEquals(5, parser.getOperandCount());
		
		assertEquals(2, parser.getBinaryOperatorCount());
		assertEquals(1, parser.getUnaryOperatorCount());
		assertEquals(3, parser.getLogicalOperatorCount());
		assertEquals(0, parser.getArithmeticOperatorCount());
		assertEquals(0, parser.getRelationalOperatorCount());
	}
	
	@Test
	void testParseWithRelationalOperators() throws IOException {
		IFileMetricParser parser = new FileMetricParser();
		parser.Parse(relationalOperatorTestFile);
		
		// Check Relational.java file to learn where magic numbers come from
		assertEquals(1, parser.getMethodCount());
		assertEquals(14, parser.getOperandCount());
		
		assertEquals(6, parser.getBinaryOperatorCount());
		assertEquals(0, parser.getUnaryOperatorCount());
		assertEquals(6, parser.getRelationalOperatorCount());
		assertEquals(0, parser.getLogicalOperatorCount());
		assertEquals(1, parser.getArithmeticOperatorCount());
	}

	@Test
	void testParseWithMixtureOfOperators() throws IOException {
		IFileMetricParser parser = new FileMetricParser();
		parser.Parse(mixOperatorTestFile);

		// Check Mix.java file to learn where magic numbers come from
		assertEquals(4, parser.getMethodCount());
		assertEquals(47, parser.getOperandCount());

		assertEquals(17, parser.getBinaryOperatorCount());
		assertEquals(3, parser.getUnaryOperatorCount());
		assertEquals(4, parser.getRelationalOperatorCount());
		assertEquals(3, parser.getLogicalOperatorCount());
		assertEquals(18, parser.getArithmeticOperatorCount());
	}

}
