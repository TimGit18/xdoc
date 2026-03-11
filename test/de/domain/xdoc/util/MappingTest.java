package de.domain.xdoc.util;

import de.domain.xdoc.control.MainRun;
import de.domain.xdoc.util.Mapping;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Notwendig wegen JUnit 5
// Klasse unter Test

@TestMethodOrder(OrderAnnotation.class)
class MappingTest {

	// Statische Variablen (Erwartungswerte)
	static String BASEPATH = "C:\\Users\\Test\\Daten\\Web\\xdoc\\xtest";
	static String TEXTPATH = BASEPATH + File.separator + "txt";
	static String LOCALHOST_PATH = "http://localhost:8080/xdoc/xtest";
	static String SYSTEM_ENVIRONMENT = "xtest";

	// Erwartungswerte von TopicList
	static String EXPECTED_TOPIC_ITEM_0 = TEXTPATH + File.separator + "Bereich\\Bereich.txt";
	static String EXPECTED_TOPIC_ITEM_1 = TEXTPATH + File.separator + "Bereich\\Unterbereich\\Unterbereich.txt";
	static String EXPECTED_TOPIC_ITEM_2 = TEXTPATH + File.separator + "Thema\\Thema.txt";
	static String EXPECTED_TOPIC_ITEM_3 = TEXTPATH + File.separator + "xtest.txt";

	// Erwartungswerte von NameList
	static String EXPECTED_NAME_ITEM_0 = "Bereich-Referenz";
	static String EXPECTED_NAME_ITEM_1 = "Bereich";
	static String EXPECTED_NAME_ITEM_2 = "Unterbereich-Referenz";
	static String EXPECTED_NAME_ITEM_3 = "Unterbereich";
	static String EXPECTED_NAME_ITEM_4 = "Test-Referenz";
	static String EXPECTED_NAME_ITEM_5 = "Thema-Referenz";
	static String EXPECTED_NAME_ITEM_6 = "Thema";
	static String EXPECTED_NAME_ITEM_7 = "xtest";

	// Erwartungswerte von MainList
	static String EXPECTED_MAIN_ITEM_0 = "xtest";
	static String EXPECTED_MAIN_ITEM_1 = "Thema";
	static String EXPECTED_MAIN_ITEM_2 = "Bereich";

	// Erwartungswerte von ContentList
	static String EXPECTED_CONTENT_ITEM_0 = TEXTPATH + File.separator + "Bereich\\Bereich-Referenz.txt";
	static String EXPECTED_CONTENT_ITEM_1 = TEXTPATH + File.separator + "Bereich\\Unterbereich\\Unterbereich-Referenz.txt";
	static String EXPECTED_CONTENT_ITEM_2 = TEXTPATH + File.separator + "Test-Referenz.txt";
	static String EXPECTED_CONTENT_ITEM_3 = TEXTPATH + File.separator + "Thema\\Thema-Referenz.txt";

	// Erwartungwerte von TypeList
	static String EXPECTED_TYPE_CONTENT = "content";
	static String EXPECTED_TYPE_TOPIC = "topic";

	// Erwartungswerte von HtmlMap
	static String EXPECTED_HTML_ITEM_0 = "http://localhost:8080/xdoc/xtest/html/Bereich/Bereich-Referenz.html";
	static String EXPECTED_HTML_ITEM_1 = "http://localhost:8080/xdoc/xtest/html/Bereich/Bereich.html";
	static String EXPECTED_HTML_ITEM_2 = "http://localhost:8080/xdoc/xtest/html/Bereich/Unterbereich/Unterbereich-Referenz.html";
	static String EXPECTED_HTML_ITEM_3 = "http://localhost:8080/xdoc/xtest/html/Bereich/Unterbereich/Unterbereich.html";
	static String EXPECTED_HTML_ITEM_4 = "http://localhost:8080/xdoc/xtest/html/Test-Referenz.html";
	static String EXPECTED_HTML_ITEM_5 = "http://localhost:8080/xdoc/xtest/html/Thema/Thema-Referenz.html";
	static String EXPECTED_HTML_ITEM_6 = "http://localhost:8080/xdoc/xtest/html/Thema/Thema.html";
	static String EXPECTED_HTML_ITEM_7 = "http://localhost:8080/xdoc/xtest/html/xtest.html";

	// Erwartungswerte von PdfMap
	static String EXPECTED_PDF_ITEM_0 = "http://localhost:8080/xdoc/xtest/pdf/Bereich/Bereich-Referenz.pdf";
	static String EXPECTED_PDF_ITEM_1 = "http://localhost:8080/xdoc/xtest/pdf/Bereich/Bereich.pdf";
	static String EXPECTED_PDF_ITEM_2 = "http://localhost:8080/xdoc/xtest/pdf/Bereich/Unterbereich/Unterbereich-Referenz.pdf";
	static String EXPECTED_PDF_ITEM_3 = "http://localhost:8080/xdoc/xtest/pdf/Bereich/Unterbereich/Unterbereich.pdf";
	static String EXPECTED_PDF_ITEM_4 = "http://localhost:8080/xdoc/xtest/pdf/Test-Referenz.pdf";
	static String EXPECTED_PDF_ITEM_5 = "http://localhost:8080/xdoc/xtest/pdf/Thema/Thema-Referenz.pdf";
	static String EXPECTED_PDF_ITEM_6 = "http://localhost:8080/xdoc/xtest/pdf/Thema/Thema.pdf";
	static String EXPECTED_PDF_ITEM_7 = "http://localhost:8080/xdoc/xtest/pdf/xtest.pdf";

	@BeforeAll
	public static void prepare() {

		// Logger initialisieren
		MainRun.initialize();
		String computerName = MainRun.getHostName();
		String logPath = MainRun.getLogPath(computerName);
		MainRun.setSystemLogPath(logPath);

		// Mapping initialisieren
		Mapping.initialize(LOCALHOST_PATH, SYSTEM_ENVIRONMENT, TEXTPATH);
		Mapping.assign();
	}

	@Test
	void testGetTopicList() {
		List<String> topicList = Mapping.getTopicList();
		assertEquals(EXPECTED_TOPIC_ITEM_0, topicList.get(0));
		assertEquals(EXPECTED_TOPIC_ITEM_1, topicList.get(1));
		assertEquals(EXPECTED_TOPIC_ITEM_2, topicList.get(2));
		assertEquals(EXPECTED_TOPIC_ITEM_3, topicList.get(3));
	}

	@Test
	void testGetNameList() {
		List<String> nameList = Mapping.getNameList();
		assertEquals(EXPECTED_NAME_ITEM_0, nameList.get(0));
		assertEquals(EXPECTED_NAME_ITEM_1, nameList.get(1));
		assertEquals(EXPECTED_NAME_ITEM_2, nameList.get(2));
		assertEquals(EXPECTED_NAME_ITEM_3, nameList.get(3));
		assertEquals(EXPECTED_NAME_ITEM_4, nameList.get(4));
		assertEquals(EXPECTED_NAME_ITEM_5, nameList.get(5));
		assertEquals(EXPECTED_NAME_ITEM_6, nameList.get(6));
		assertEquals(EXPECTED_NAME_ITEM_7, nameList.get(7));
	}

	@Test
	void testGetMainList() {
		List<String> mainList = Mapping.getMainList();
		assertEquals(EXPECTED_MAIN_ITEM_0, mainList.get(0));
		assertEquals(EXPECTED_MAIN_ITEM_1, mainList.get(1));
		assertEquals(EXPECTED_MAIN_ITEM_2, mainList.get(2));
	}

	@Test
	void testGetContentList() {
		List<String> contentList = Mapping.getContentList();
		assertEquals(EXPECTED_CONTENT_ITEM_0, contentList.get(0));
		assertEquals(EXPECTED_CONTENT_ITEM_1, contentList.get(1));
		assertEquals(EXPECTED_CONTENT_ITEM_2, contentList.get(2));
		assertEquals(EXPECTED_CONTENT_ITEM_3, contentList.get(3));
	}

	@Test
	void testGetTypeList() {
		List<String> typeList = Mapping.getTypeList();
		assertEquals(EXPECTED_TYPE_CONTENT, typeList.get(0));
		assertEquals(EXPECTED_TYPE_TOPIC, typeList.get(1));
		assertEquals(EXPECTED_TYPE_CONTENT, typeList.get(2));
		assertEquals(EXPECTED_TYPE_TOPIC, typeList.get(3));
		assertEquals(EXPECTED_TYPE_CONTENT, typeList.get(4));
		assertEquals(EXPECTED_TYPE_CONTENT, typeList.get(5));
		assertEquals(EXPECTED_TYPE_TOPIC, typeList.get(6));
		assertEquals(EXPECTED_TYPE_TOPIC, typeList.get(7));
	}

	@Test
	void testGetHtmlMap() {
		HashMap<Integer, String> htmlMap = Mapping.getHtmlMap();
		assertEquals(EXPECTED_HTML_ITEM_0, htmlMap.get(0));
		assertEquals(EXPECTED_HTML_ITEM_1, htmlMap.get(1));
		assertEquals(EXPECTED_HTML_ITEM_2, htmlMap.get(2));
		assertEquals(EXPECTED_HTML_ITEM_3, htmlMap.get(3));
		assertEquals(EXPECTED_HTML_ITEM_4, htmlMap.get(4));
		assertEquals(EXPECTED_HTML_ITEM_5, htmlMap.get(5));
		assertEquals(EXPECTED_HTML_ITEM_6, htmlMap.get(6));
		assertEquals(EXPECTED_HTML_ITEM_7, htmlMap.get(7));
	}

	@Test
	void testGetPdfMap() {
		HashMap<Integer, String> pdfMap = Mapping.getPdfMap();
		assertEquals(EXPECTED_PDF_ITEM_0, pdfMap.get(0));
		assertEquals(EXPECTED_PDF_ITEM_1, pdfMap.get(1));
		assertEquals(EXPECTED_PDF_ITEM_2, pdfMap.get(2));
		assertEquals(EXPECTED_PDF_ITEM_3, pdfMap.get(3));
		assertEquals(EXPECTED_PDF_ITEM_4, pdfMap.get(4));
		assertEquals(EXPECTED_PDF_ITEM_5, pdfMap.get(5));
		assertEquals(EXPECTED_PDF_ITEM_6, pdfMap.get(6));
		assertEquals(EXPECTED_PDF_ITEM_7, pdfMap.get(7));
	}


}
