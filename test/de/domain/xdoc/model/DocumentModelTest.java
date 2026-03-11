package de.domain.xdoc.model;

import de.domain.xdoc.character.Text;
import de.domain.xdoc.control.MainRun;
import de.domain.xdoc.model.DocumentModel;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(OrderAnnotation.class)
public class DocumentModelTest {

  // Statische Variablen (Erwartungswerte)
  static String BASEPATH = "C:\\Users\\Test\\Daten\\Web\\xdoc\\Test";
  static String TEXTPATH = BASEPATH + File.separator + "txt";
  static String LOCALHOST_PATH = "https://localhost:8080/xdoc/Test";
  static String SYSTEM_ENVIRONMENT = "Test";
  static String THEMA = "Thema";
  static String TOPIC = "topic";

  static String THEMA_TXT = THEMA + Text.SUFFIX_TEXT;
  static String THEMA_FOP = THEMA + Text.SUFFIX_FOP;
  static String THEMA_HTML = THEMA + Text.SUFFIX_HTML;
  static String THEMA_PDF = THEMA + Text.SUFFIX_PDF;
  static String THEMA_XML = THEMA + Text.SUFFIX_XML;
  static String FILE_URL = "file:///C:/Users/Test/Daten/Web/xdoc/Test/img/";
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
23:02:05:534 TRACE de.domain.xdoc.control.Control - Thema-Pfad:          C:\Users\schmi\Daten\Web\xdoc\Test\txt\Thema
23:02:05:534 TRACE de.domain.xdoc.control.Control - XML-Pfad:            C:\Users\schmi\Daten\Web\xdoc\Test\xml\Thema\Thema.xml
23:02:05:534 TRACE de.domain.xdoc.control.Control - HTML-Pfad:           C:\Users\schmi\Daten\Web\xdoc\Test\html\Thema\Thema.html
23:02:05:534 TRACE de.domain.xdoc.control.Control - Bild-Pfad:           file:///C:/Users/schmi/Daten/Web/xdoc/Test/img/Thema/
23:02:05:534 TRACE de.domain.xdoc.control.Control - FOP-Pfad:            C:\Users\schmi\Daten\Web\xdoc\Test\fo\Thema\Thema.fo
23:02:05:534 TRACE de.domain.xdoc.control.Control - PDF-Pfad:            C:\Users\schmi\Daten\Web\xdoc\Test\pdf\Thema\Thema.pdf
23:02:05:534 TRACE de.domain.xdoc.control.Control - Typ:                 topic
23:02:05:534 TRACE de.domain.xdoc.control.Control - Lokaler HTML-Pfad:   https://localhost:8080/xdoc/Test/html/Thema/Thema.html
23:02:05:534 TRACE de.domain.xdoc.control.Control - Lokaler PDF-Pfad:    https://localhost:8080/xdoc/Test/pdf/Thema/Thema.pdf
23:02:05:534 TRACE de.domain.xdoc.control.Control - Lokaler Bild-Pfad:   https://localhost:8080/xdoc/Test/img/Thema/
  */

  @BeforeAll
  public static void prepare() {
    // Logger initialisieren
    MainRun.initialize();
    String computerName = MainRun.getHostName();
    String logPath = MainRun.getLogPath(computerName);
    MainRun.setSystemLogPath(logPath);
    DocumentModel.initialize(TEXTITEM, TEXTPATH, SYSTEM_ENVIRONMENT, LOCALHOST_PATH);
  }

  @Test
  void testGetFopPath(){
    assertEquals(EXPECTED_FOP_PATH, DocumentModel.getFopPath());
  }

  @Test
  void testGetHtmlPath() {
    assertEquals(EXPECTED_HTML_PATH, DocumentModel.getHtmlPath());
  }

  @Test
  void testGetImagePath() {
    assertEquals(EXPECTED_IMAGE_PATH, DocumentModel.getImagePath());
  }

  @Test
  void testGetLevel() {
    assertEquals(1, DocumentModel.getLevel());
  }

  @Test
  void testGetName() {
    assertEquals(THEMA, DocumentModel.getName());
  }

  @Test
  void testGetPdfPath(){
    assertEquals(EXPECTED_PDF_PATH, DocumentModel.getPdfPath());
  }

  @Test
  void testGetRootPath(){
    assertEquals(TEXTPATH, DocumentModel.getRootPath());
  }

  @Test
  void testGetSystem() {
    assertEquals(SYSTEM_ENVIRONMENT, DocumentModel.getSystem());
  }

  @Test
  void testGetTextName() {
    assertEquals(THEMA_TXT, DocumentModel.getTextName());
  }

  @Test
  void testGetTextPath() {
    assertEquals(TEXTITEM, DocumentModel.getTextPath());
  }

  @Test
  void testGetTopic() {
    assertEquals(THEMA, DocumentModel.getTopic());
  }

  @Test
  void testGetTopicPath() {
    assertEquals(EXPECTED_THEMA_PATH, DocumentModel.getTopicPath());
  }

  @Test
  void testGetType() {
    assertEquals(TOPIC, DocumentModel.getType());
  }

  @Test
  void testGetXmlPath() {
    assertEquals(EXPECTED_XML_PATH, DocumentModel.getXmlPath());
  }

  @Test
  void testGetLocalHtmlPath() {
    assertEquals(EXPECTED_LOCAL_HTML_PATH, DocumentModel.getLocalHtmlPath());
  }

  @Test
  void testGetLocalPdfPath() {
    assertEquals(EXPECTED_LOCAL_PDF_PATH, DocumentModel.getLocalPdfPath());
  }

  @Test
  void testGetLocalImagePath() {
    assertEquals(EXPECTED_LOCAL_IMAGE_PATH, DocumentModel.getLocalImagePath());
  }

  /*

  public static String getLocalImagePath() { return localImagePath;  }
  */

}
