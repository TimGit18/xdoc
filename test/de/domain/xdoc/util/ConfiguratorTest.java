package de.domain.xdoc.util;

import de.domain.xdoc.character.Text;
import de.domain.xdoc.control.MainRun;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

// Notwendig wegen JUnit 5
// Klasse unter Test

@TestMethodOrder(OrderAnnotation.class)
class ConfiguratorTest {

	// Statische Variablen (Erwartungswerte)
	private static final String BASEPATH = "C:\\Users\\Test\\Daten\\Web\\xdoc";
	private static final String BASEPATH_SYSTEM = "C:\\Users\\Test\\Daten\\Web\\xdoc\\xtest";
	private static final String RESOURCES_PATH = "C:\\Users\\Test\\Daten\\Web\\xdoc\\resources";
	private static final String LOCAL_HOST_PATH = "http://localhost:8080/xdoc";
	private static final String LOCAL_HOST_PATH_SYSTEM = "http://localhost:8080/xdoc/xtest";
	private static final String LIB_PATH = LOCAL_HOST_PATH + Text.FORWARD_SLASH + Text.RESOURCES + Text.FORWARD_SLASH + "lib";
	private static final String CSS_PATH = LOCAL_HOST_PATH + Text.FORWARD_SLASH + Text.RESOURCES + Text.FORWARD_SLASH + "css";
	private static final String LOCAL_IMG_PATH = LOCAL_HOST_PATH_SYSTEM + Text.FORWARD_SLASH + "img";

	private static final String CONFIG_PATH = RESOURCES_PATH + File.separator + "conf";
	private static final String XSL_PATH = RESOURCES_PATH + File.separator + "xsl";

	// Statische Directory-Pfade
	private static final String EXPECTED_CONFIG_PATH = RESOURCES_PATH + File.separator + "conf";
	private static final String EXPECTED_FOP_PATH = BASEPATH_SYSTEM + File.separator + "fo";
	private static final String EXPECTED_HTML_PATH = BASEPATH_SYSTEM + File.separator + "html";
	private static final String EXPECTED_IMAGE_PATH = BASEPATH_SYSTEM + File.separator + "img";
	private static final String EXPECTED_PDF_PATH = BASEPATH_SYSTEM + File.separator + "pdf";
	private static final String EXPECTED_TXT_PATH = BASEPATH_SYSTEM + File.separator + "txt";
	private static final String EXPECTED_XML_PATH = BASEPATH_SYSTEM + File.separator + "xml";
	private static final String EXPECTED_XSL_PATH = RESOURCES_PATH + File.separator + "xsl";

	// Relative Directory-Pfade
	private static final String EXPECTED_CSS_PATH = LOCAL_HOST_PATH + Text.FORWARD_SLASH + Text.RESOURCES+ Text.FORWARD_SLASH + "css";
	private static final String EXPECTED_LOCAL_HTML_PATH = LOCAL_HOST_PATH_SYSTEM + Text.FORWARD_SLASH + "html";
	private static final String EXPECTED_LOCAL_IMAGE_PATH = LOCAL_HOST_PATH_SYSTEM + Text.FORWARD_SLASH + "img";
	private static final String EXPECTED_LIB_PATH = LOCAL_HOST_PATH + Text.FORWARD_SLASH + Text.RESOURCES + Text.FORWARD_SLASH + "lib";

	// Dateipfade
	private static final String EXPECTED_ANGULAR = LIB_PATH + Text.FORWARD_SLASH + "angular.js";
	private static final String EXPECTED_CSS_BOOTSTRAP_MIN = CSS_PATH + Text.FORWARD_SLASH + "bootstrap.min.css";
	private static final String EXPECTED_CSS_BOOTSTRAP_TOC = CSS_PATH + Text.FORWARD_SLASH + "bootstrap-toc.min.css";
	private static final String EXPECTED_CSS_STYLESHEET = CSS_PATH + Text.FORWARD_SLASH + "stylesheet.css";
	private static final String EXPECTED_FAVICON = LOCAL_HOST_PATH + Text.FORWARD_SLASH + Text.RESOURCES + Text.FORWARD_SLASH + "favicon.ico";
	private static final String EXPECTED_FO_STYLESHEET = XSL_PATH + File.separator + "fosheet.xsl";

	private static final String FOP_CONFIG = CONFIG_PATH + File.separator + Text.FOP_CONFIG_XML;
	private static final String JQUERY = "http://localhost:8080/xdoc/resources/lib/jquery-3.2.1.min.js";
	private static final String JS_BOOTSTRAP_MIN = "http://localhost:8080/xdoc/resources/lib/bootstrap.min.js";
	private static final String JS_BOOTSTRAP_TOC = "http://localhost:8080/xdoc/resources/lib/bootstrap-toc.min.js";
	private static final String POPPER = "http://localhost:8080/xdoc/resources/lib/popper.min.js";
	private static final String XML_STYLESHEET = RESOURCES_PATH + Text.BACK_SLASH + Text.XSL + Text.BACK_SLASH + Text.STYLESHEET_XSL;
	private static final String XML_STYLESHEET_TOC = RESOURCES_PATH + Text.BACK_SLASH + Text.XSL + Text.BACK_SLASH + Text.STYLESHEET_TOC_XSL;

	@BeforeAll
	public static void prepare() {
		MainRun.initialize();
		String computerName = MainRun.getHostName();
		String logPath = MainRun.getLogPath(computerName);
		MainRun.setSystemLogPath(logPath);
		// setDirectoryPaths(String basePath, String localHost, String basePathSystem, String localHostSystem){
		Configurator.setDirectoryPaths(BASEPATH, LOCAL_HOST_PATH, BASEPATH_SYSTEM,LOCAL_HOST_PATH_SYSTEM);
		Configurator.setFilePaths(LOCAL_HOST_PATH);
	}

	@Test
	@Order(1)
	public void testGetConfigPath() {
		String configPath = Configurator.getConfigPath();
		assertEquals(EXPECTED_CONFIG_PATH, configPath);
	}

	@Test
	@Order(2)
	public void testGetFopPath() {
		String fopPath = Configurator.getFopPath();
		assertEquals(EXPECTED_FOP_PATH, fopPath);
	}

	@Test
	@Order(3)
	public void testGetHtmlPath() {
		String htmlPath = Configurator.getHtmlPath();
		assertEquals(EXPECTED_HTML_PATH, htmlPath);
	}

	@Test
	@Order(4)
	public void testGetImagePath() {
		String imagePath = Configurator.getImagePath();
		assertEquals(EXPECTED_IMAGE_PATH, imagePath);
	}

	@Test
	@Order(5)
	public void testGetLocalCssPath() {
		String cssPath = Configurator.getCssPath();
		assertEquals(EXPECTED_CSS_PATH, cssPath);
	}

	@Test
	@Order(6)
	public void testGetLocalHtmlPath() {
		String localHtmlPath = Configurator.getLocalHtmlPath();
		assertEquals(EXPECTED_LOCAL_HTML_PATH, localHtmlPath);
	}

	@Test
	@Order(7)
	public void testGetLocalImagePath() {
		String localImagePath = Configurator.getLocalImagePath();
		assertEquals(EXPECTED_LOCAL_IMAGE_PATH, localImagePath);
	}

	@Test
	@Order(8)
	public void testGetLocalLibPath() {
		String localLibPath = Configurator.getLibPath();
		assertEquals(EXPECTED_LIB_PATH, localLibPath);
	}

	@Test
	@Order(9)
	public void testGetPdfPath() {
		String pdfPath = Configurator.getPdfPath();
		assertEquals(EXPECTED_PDF_PATH, pdfPath);
	}

	@Test
	@Order(10)
	public void testGetTextPath() {
		String textPath = Configurator.getTextPath();
		assertEquals(EXPECTED_TXT_PATH, textPath);
	}

	@Test
	@Order(11)
	public void testGetXmlPath() {
		String xmlPath = Configurator.getXmlPath();
		assertEquals(EXPECTED_XML_PATH, xmlPath);
	}

	@Test
	@Order(12)
	public void testGetXslPath() {
		String xslPath = Configurator.getXslPath();
		assertEquals(EXPECTED_XSL_PATH, xslPath);
	}

	@Test
	@Order(13)
	public void testGetAngular() {
		String angular	= Configurator.getAngular();
		assertEquals(EXPECTED_ANGULAR, angular);
	}

	@Test
	@Order(14)
	public void testGetBootstrapMin() {
		String cssBootstrapMin	= Configurator.getCssBootstrapMin();
		assertEquals(EXPECTED_CSS_BOOTSTRAP_MIN, cssBootstrapMin);
	}

	@Test
	@Order(15)
	public void testGetBootstrapToc() {
		String cssBootstrapToc	= Configurator.getCssBootstrapToc();
		assertEquals(EXPECTED_CSS_BOOTSTRAP_TOC, cssBootstrapToc);
	}

	@Test
	@Order(16)
	public void testGetStylesheetCss() {
		String cssStylesheet	= Configurator.getCssStylesheet();
		assertEquals(EXPECTED_CSS_STYLESHEET, cssStylesheet);
	}

	@Test
	@Order(17)
	public void testGetFavicon() {
		String favicon	= Configurator.getFavicon();
		assertEquals(EXPECTED_FAVICON, favicon);
	}

	@Test
	@Order(18)
	public void testGetFoStylesheet() {
		String fosheet	= Configurator.getFoStylesheet();
		assertEquals(EXPECTED_FO_STYLESHEET, fosheet);
	}

	@Test
	@Order(19)
	public void testGetFopConfig() {
		String fopConfig	= Configurator.getFopConfig();
		assertEquals(FOP_CONFIG, fopConfig);
	}

	@Test
	@Order(20)
	public void testGetJquery() {
		String jQuery	= Configurator.getJquery();
		assertEquals(JQUERY, jQuery);
	}

	@Test
	@Order(21)
	public void testGetJsBootstrapMin() {
		String jsBootstrapMin	= Configurator.getJsBootstrapMin();
		assertEquals(JS_BOOTSTRAP_MIN, jsBootstrapMin);
	}

	@Test
	@Order(22)
	public void testGetJsBootstrapToc() {
		String jsBootstrapToc	= Configurator.getJsBootstrapToc();
		assertEquals(JS_BOOTSTRAP_TOC, jsBootstrapToc);
	}

	@Test
	@Order(23)
	public void testGetPopper() {
		String popper	= Configurator.getPopper();
		assertEquals(POPPER, popper);
	}

	@Test
	@Order(24)
	public void testGetXmlStylesheet() {
		String xmlStylesheet	= Configurator.getXmlStylesheet();
		assertEquals(XML_STYLESHEET, xmlStylesheet);
	}

	@Test
	@Order(25)
	public void testGetXmlStylesheetToc() {
		String xmlStylesheetToc	= Configurator.getXmlStylesheetToc();
		assertEquals(XML_STYLESHEET_TOC, xmlStylesheetToc);
	}


}
