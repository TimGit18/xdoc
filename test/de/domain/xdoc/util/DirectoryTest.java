package de.domain.xdoc.util;

import de.domain.xdoc.control.MainRun;
import de.domain.xdoc.util.Directory;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.io.File;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

// Notwendig wegen JUnit 5
// Klasse unter Test

@TestMethodOrder(OrderAnnotation.class)
class DirectoryTest {

	// Statische Variablen (Erwartungswerte)
	String BASEPATH = "C:\\Users\\Test\\Daten\\Web\\xdoc\\xtest";
	String TEXTPATH = BASEPATH + File.separator + "txt";
	String TEST_DIRECTORY_PATH = TEXTPATH + File.separator + "TestDirectory";
	String TEST_STRUCTURE_PATH = BASEPATH + File.separator + "tst";

	// Erwartungswerte zu getDocumentList
	String EXPECTED_DOCUMENT_O = TEXTPATH + File.separator + "Bereich\\Bereich-Referenz.txt";
	String EXPECTED_DOCUMENT_1 = TEXTPATH + File.separator + "Bereich\\Bereich.txt";
	String EXPECTED_DOCUMENT_2 = TEXTPATH + File.separator + "Bereich\\Unterbereich\\Unterbereich-Referenz.txt";
	String EXPECTED_DOCUMENT_3 = TEXTPATH + File.separator + "Bereich\\Unterbereich\\Unterbereich.txt";
	String EXPECTED_DOCUMENT_4 = TEXTPATH + File.separator + "Test-Referenz.txt";
	String EXPECTED_DOCUMENT_5 = TEXTPATH + File.separator + "Thema\\Thema-Referenz.txt";
	String EXPECTED_DOCUMENT_6 = TEXTPATH + File.separator + "Thema\\Thema.txt";
	String EXPECTED_DOCUMENT_7 = TEXTPATH + File.separator + "xtest.txt";

	@BeforeAll
	public static void prepare() {
		MainRun.initialize();
		String computerName = MainRun.getHostName();
		String logPath = MainRun.getLogPath(computerName);
		MainRun.setSystemLogPath(logPath);
	}

	@Test
	@Order(1)
	void testCreateDirectory() {
		Directory.createDirectory(TEST_DIRECTORY_PATH);
		File newDirectory = new File(TEST_DIRECTORY_PATH);
		assertTrue(newDirectory.isDirectory());
	}

	@Test
	@Order(2)
	void testDeleteFile() {
		Directory.deleteFile(TEST_DIRECTORY_PATH);
		File deletedFile = new File(TEST_DIRECTORY_PATH);
		assertFalse(deletedFile.exists());
	}

	@Test
	@Order(3)
	void testCreateDocumentStructure() {
		Directory.createDocumentStructure(TEXTPATH, TEST_STRUCTURE_PATH);
		File testStructure = new File(TEST_STRUCTURE_PATH);
		assertTrue(testStructure.list().length>0);
	}

	@Test
	@Order(4)
	void testDeleteStructure() {
		Directory.deleteFile(TEST_STRUCTURE_PATH);
		File deletedFile = new File(TEST_STRUCTURE_PATH);
		assertFalse(deletedFile.exists());
	}

	@Test
	@Order(5)
	void testGetDocumentsList() {
		List<String> textList = Directory.getDocumentsList(TEXTPATH);
		assertEquals(EXPECTED_DOCUMENT_O, textList.get(0));
		assertEquals(EXPECTED_DOCUMENT_1, textList.get(1));
		assertEquals(EXPECTED_DOCUMENT_2, textList.get(2));
		assertEquals(EXPECTED_DOCUMENT_3, textList.get(3));
		assertEquals(EXPECTED_DOCUMENT_4, textList.get(4));
		assertEquals(EXPECTED_DOCUMENT_5, textList.get(5));
		assertEquals(EXPECTED_DOCUMENT_6, textList.get(6));
		assertEquals(EXPECTED_DOCUMENT_7, textList.get(7));
	}

}
