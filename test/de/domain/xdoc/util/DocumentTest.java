package de.domain.xdoc.util;

import de.domain.xdoc.character.Text;
import de.domain.xdoc.control.MainRun;
import de.domain.xdoc.util.Document;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(OrderAnnotation.class)
public class DocumentTest {

  // Statische Variablen (Erwartungswerte)
  static String BASEPATH = "C:\\Users\\Test\\Daten\\Web\\xdoc\\xtest";
  static String TEXTPATH = BASEPATH + File.separator + "txt";
  static String LOCALHOST_PATH = "http://localhost:8080/xdoc/xtest";
  static String SYSTEM_ENVIRONMENT = "xtest";
  static String THEMA = "Thema";
  static String TOPIC = "topic";

  static String THEMA_TXT = THEMA + Text.SUFFIX_TEXT;
  static String THEMA_FOP = THEMA + Text.SUFFIX_FOP;
  static String THEMA_HTML = THEMA + Text.SUFFIX_HTML;
  static String THEMA_PDF = THEMA + Text.SUFFIX_PDF;
  static String THEMA_XML = THEMA + Text.SUFFIX_XML;
  static String FILE_URL = "file:///C:/Users/Test/Daten/Web/xdoc/xtest/img/";
  static String TEXTITEM = TEXTPATH + File.separator + THEMA + File.separator + THEMA_TXT;

  // Erwartungswerte
  static String EXPECTED_FOP_PATH = BASEPATH + File.separator + Text.FOP + File.separator + THEMA + File.separator + THEMA_FOP;
  static String EXPECTED_HTML_PATH = BASEPATH + File.separator + Text.HTML + File.separator + THEMA + File.separator + THEMA_HTML;
  static String EXPECTED_PDF_PATH = BASEPATH + File.separator + Text.PDF + File.separator + THEMA + File.separator + THEMA_PDF;
  static String EXPECTED_XML_PATH = BASEPATH + File.separator + Text.XML + File.separator + THEMA + File.separator + THEMA_XML;
  static String EXPECTED_IMAGE_PATH = FILE_URL + THEMA + Text.FORWARD_SLASH;
  static String EXPECTED_THEMA_PATH = TEXTPATH + File.separator + THEMA;
  static String EXPECTED_LOCAL_HTML_PATH = LOCALHOST_PATH + Text.FORWARD_SLASH + Text.HTML + Text.FORWARD_SLASH + THEMA + Text.FORWARD_SLASH + THEMA_HTML;
  static String EXPECTED_LOCAL_PDF_PATH = LOCALHOST_PATH + Text.FORWARD_SLASH + Text.PDF + Text.FORWARD_SLASH + THEMA + Text.FORWARD_SLASH + THEMA_PDF;
  static String EXPECTED_LOCAL_IMAGE_PATH = LOCALHOST_PATH + Text.FORWARD_SLASH + Text.IMG + Text.FORWARD_SLASH + THEMA + Text.FORWARD_SLASH;

  /**
  Kontext:             Test
23:02:05:534 TRACE de.domain.xdoc.control.Control - Root-Pfad:           C:\Users\schmi\Daten\Web\xdoc\Test\txt
23:02:05:534 TRACE de.domain.xdoc.control.Control - Name:                Thema
23:02:05:534 TRACE de.domain.xdoc.control.Control - Text-Name:           Thema.txt
23:02:05:534 TRACE de.domain.xdoc.control.Control - Text-Pfad:           C:\Users\schmi\Daten\Web\xdoc\Test\txt\Thema\Thema.txt
23:02:05:534 TRACE de.domain.xdoc.control.Control - Ebene:               1
23:02:05:534 TRACE de.domain.xdoc.control.Control - Thema:               Thema
23:02:05:534 TRACE de.domain.xdoc.control.Control - Thema-Pfad:          C:\Users\Test\Daten\Web\xdoc\xtest\txt\Thema
23:02:05:534 TRACE de.domain.xdoc.control.Control - XML-Pfad:            C:\Users\Test\Daten\Web\xdoc\xtest\xml\Thema\Thema.xml
23:02:05:534 TRACE de.domain.xdoc.control.Control - HTML-Pfad:           C:\Users\Test\Daten\Web\xdoc\xtest\html\Thema\Thema.html
23:02:05:534 TRACE de.domain.xdoc.control.Control - Bild-Pfad:           file:///C:/Users/Test/Daten/Web/xdoc/xtest/img/Thema/
23:02:05:534 TRACE de.domain.xdoc.control.Control - FOP-Pfad:            C:\Users\Test\Daten\Web\xdoc\xtest\fo\Thema\Thema.fo
23:02:05:534 TRACE de.domain.xdoc.control.Control - PDF-Pfad:            C:\Users\Test\Daten\Web\xdoc\xtest\pdf\Thema\Thema.pdf
23:02:05:534 TRACE de.domain.xdoc.control.Control - Typ:                 topic
23:02:05:534 TRACE de.domain.xdoc.control.Control - Lokaler HTML-Pfad:   https://localhost:8080/xdoc/xtest/html/Thema/Thema.html
23:02:05:534 TRACE de.domain.xdoc.control.Control - Lokaler PDF-Pfad:    https://localhost:8080/xdoc/xtest/pdf/Thema/Thema.pdf
23:02:05:534 TRACE de.domain.xdoc.control.Control - Lokaler Bild-Pfad:   https://localhost:8080/xdoc/xtest/img/Thema/
  */

  @BeforeAll
  public static void prepare() {
    // Logger initialisieren
    MainRun.initialize();
    String computerName = MainRun.getHostName();
    String logPath = MainRun.getLogPath(computerName);
    MainRun.setSystemLogPath(logPath);
    Document.initialize(TEXTITEM, TEXTPATH, SYSTEM_ENVIRONMENT, LOCALHOST_PATH);
  }

  @Test
  void testGetFopPath(){
    assertEquals(EXPECTED_FOP_PATH, Document.getFopPath());
  }

  @Test
  void testGetHtmlPath() {
    assertEquals(EXPECTED_HTML_PATH, Document.getHtmlPath());
  }

  @Test
  void testGetImagePath() {
    assertEquals(EXPECTED_IMAGE_PATH, Document.getImagePath());
  }

  @Test
  void testGetLevel() {
    assertEquals(1, Document.getLevel());
  }

  @Test
  void testGetName() {
    assertEquals(THEMA, Document.getName());
  }

  @Test
  void testGetPdfPath(){
    assertEquals(EXPECTED_PDF_PATH, Document.getPdfPath());
  }

  @Test
  void testGetRootPath(){
    assertEquals(TEXTPATH, Document.getRootPath());
  }

  @Test
  void testGetSystem() {
    assertEquals(SYSTEM_ENVIRONMENT, Document.getSystem());
  }

  @Test
  void testGetTextName() {
    assertEquals(THEMA_TXT, Document.getTextName());
  }

  @Test
  void testGetTextPath() {
    assertEquals(TEXTITEM, Document.getTextPath());
  }

  @Test
  void testGetTopic() {
    assertEquals(THEMA, Document.getTopic());
  }

  @Test
  void testGetTopicPath() {
    assertEquals(EXPECTED_THEMA_PATH, Document.getTopicPath());
  }

  @Test
  void testGetType() {
    assertEquals(TOPIC, Document.getType());
  }

  @Test
  void testGetXmlPath() {
    assertEquals(EXPECTED_XML_PATH, Document.getXmlPath());
  }

  @Test
  void testGetLocalHtmlPath() {
    assertEquals(EXPECTED_LOCAL_HTML_PATH, Document.getLocalHtmlPath());
  }

  @Test
  void testGetLocalPdfPath() {
    assertEquals(EXPECTED_LOCAL_PDF_PATH, Document.getLocalPdfPath());
  }

  @Test
  void testGetLocalImagePath() {
    assertEquals(EXPECTED_LOCAL_IMAGE_PATH, Document.getLocalImagePath());
  }


}
