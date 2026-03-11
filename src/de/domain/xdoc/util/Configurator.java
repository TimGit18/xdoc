package de.domain.xdoc.util;

import de.domain.xdoc.character.Text;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

/**
 * Die Klasse Configurator sorgt für die korrekte Konfiguration aller relevanten Pfade der Anwendung.
 */
public class Configurator {

  // Statischer Logger
  private static final Logger LOG = LogManager.getLogger(Configurator.class.getName());

  // Pfadvariablen der Anwendung
  private static String configPath;
  private static String fopPath;
  private static String htmlPath;
  private static String imagePath;
  private static String cssPath;
  private static String localHtmlPath;
  private static String localImagePath;
  private static String libPath;
  private static String resourcePath;
  private static String pdfPath;
  private static String textPath;
  private static String xmlPath;
  private static String xslPath;

  // Variablen der Anwendung für einzelne Dateien
  private static String angular;
  private static String cssBootstrapMin;
  private static String cssBootstrapToc;
  private static String cssStylesheet;
  private static String favicon;
  private static String foStylesheet;
  private static String fopConfig;
  private static String jquery;
  private static String jsBootstrapMin;
  private static String jsBootstrapToc;
  private static String popper;
  private static String xmlStylesheet;
  private static String xmlStylesheetToc;

  //--------------------------------//
  // Getter für die Directory-Pfade //
  //--------------------------------//
  // Holen des Konfigurationspfads
  public static String getConfigPath() { return configPath; }

  // Holen des FOP-Pfads
  public static String getFopPath() {
    return fopPath;
  }

  // Holen des HTML-Pfads
  public static String getHtmlPath() {
    return htmlPath;
  }

  // Holen des Image-Pfads
  public static String getImagePath() {
    return imagePath;
  }

  // Holen des relativen CSS-Pfads
  public static String getCssPath() {
    return cssPath;
  }

  // Holen des relativen HTML-Pfads
  public static String getLocalHtmlPath() { return localHtmlPath; }

  // Holen des relativen Image-Pfads
  public static String getLocalImagePath() { return localImagePath; }

  // Holen des relativen Lib-Pfads
  public static String getLibPath() {
    return libPath;
  }

  // Holen des PDF-Pfads
  public static String getPdfPath() {
    return pdfPath;
  }

  public static String getTextPath() {
    return textPath;
  }

  public static String getXmlPath() {
    return xmlPath;
  }

  public static String getXslPath() { return xslPath;  }

  public static String getAngular() {
    return angular;
  }

  public static String getCssBootstrapMin() {
    return cssBootstrapMin;
  }

  public static String getCssBootstrapToc() {
    return cssBootstrapToc;
  }

  public static String getCssStylesheet() {
    return cssStylesheet;
  }

  public static String getFavicon() {
    return favicon;
  }

  public static String getFoStylesheet() {
    return foStylesheet;
  }

  public static String getFopConfig() {
    return fopConfig;
  }

  public static String getJquery() {
    return jquery;
  }

  public static String getJsBootstrapMin() {
    return jsBootstrapMin;
  }

  public static String getJsBootstrapToc() {
    return jsBootstrapToc;
  }

  public static String getPopper() {
    return popper;
  }

  public static String getXmlStylesheet() {
    return xmlStylesheet;
  }

  public static String getXmlStylesheetToc() {
    return xmlStylesheetToc;
  }

  //---------------------------//
  // Setzen der Umgebungspfade //
  //---------------------------//
  public static void setDirectoryPaths(String basePath, String localHost, String basePathSystem, String localHostSystem){
    setResourcePath(basePath);
    setConfigPath(basePathSystem);
    setFopPath(basePathSystem);
    setHtmlPath(basePathSystem);
    setImagePath(basePathSystem);
    setCssPath(localHost);
    setLocalHtmlPath(localHostSystem);
    setLocalImagePath(localHostSystem);
    setLibPath(localHost);
    setPdfPath(basePathSystem);
    setTextPath(basePathSystem);
    setXmlPath(basePathSystem);
    setXslPath(basePathSystem);
  }

  // Setzen des Ressourcenpfads
  public static void setResourcePath(String basePath) {
    resourcePath = basePath + File.separator + Text.RESOURCES;
    LOG.trace("Initialisieren von " + resourcePath);
  }

  // Setzen des Konfigurationspfads
  private static void setConfigPath(String basePath) {
    configPath = resourcePath + File.separator + Text.CONF;
    LOG.trace("Initialisieren von " + configPath);
  }

   // Setzen des FOP-Pfads
  public static void setFopPath(String basePathSystem) {
    fopPath = basePathSystem + File.separator + Text.FOP;
    LOG.trace("Initialisieren von " + fopPath);
  }

  // Setzen des HTML-Pfads
  public static void setHtmlPath(String basePathSystem) {
    htmlPath = basePathSystem + File.separator + Text.HTML;
    LOG.trace("Initialisieren von " + htmlPath);
  }

  // Setzen des Image-Pfads
  public static void setImagePath(String basePathSystem) {
    imagePath = basePathSystem + File.separator + Text.IMG;
    LOG.trace("Initialisieren von " + imagePath);
  }

  // Setzen des relativen CSS-Pfads
  public static void setCssPath(String localHost) {
    cssPath = localHost + Text.FORWARD_SLASH + Text.RESOURCES + Text.FORWARD_SLASH + Text.CSS;
    LOG.trace("Initialisieren von " + cssPath);
  }

  // Setzen des relativen HTML-Pfads
  public static void setLocalHtmlPath(String localhostPath) {
    localHtmlPath = localhostPath + Text.FORWARD_SLASH + Text.HTML;
    LOG.trace("Initialisieren von " + localHtmlPath);
  }

  // Setzen des relativen Image-Pfads
  public static void setLocalImagePath(String localhostPath) {
    localImagePath =  localhostPath + Text.FORWARD_SLASH + Text.IMG;
    LOG.trace("Initialisieren von " + localImagePath);
  }

  // Setzen des relativen Lib-Pfads
  public static void setLibPath(String localHost) {
    libPath = localHost + Text.FORWARD_SLASH + Text.RESOURCES + Text.FORWARD_SLASH + Text.LIB;
    LOG.trace("Initialisieren von " + libPath);
  }

  // Setzen des PDF-Pfads
  public static void setPdfPath(String basePathSystem) {
    pdfPath = basePathSystem + File.separator + Text.PDF;
    LOG.trace("Initialisieren von " + pdfPath);
  }

  // Setzen des Text-Pfads
  public static void setTextPath(String basePathSystem) {
    textPath = basePathSystem + File.separator + Text.TEXT;
    LOG.trace("Initialisieren von " + textPath);
  }

  // Setzen des XML-Pfads
  public static void setXmlPath(String basePathSystem) {
    xmlPath = basePathSystem + File.separator + Text.XML;
    LOG.trace("Initialisieren von " + xmlPath);
  }

  // Setzen des XSL-Pfads
  public static void setXslPath(String basePath) {
    xslPath = resourcePath + File.separator + Text.XSL;
    LOG.trace("Initialisieren von " + xslPath);
  }

  //------------------------//
  // Setzen der Dateipfade  //
  //------------------------//
  public static void setFilePaths(String localHost){
    setAngular();
    setCssBootstrapMin();
    setCssBootstrapToc();
    setCssStylesheet();
    setFavicon(localHost);
    setFoStylesheet();
    setFopConfig();
    setJquery();
    setJsBootstrapMin();
    setJsBootstrapToc();
    setPopper();
    setXmlStylesheet();
    setXmlStylesheetToc();
  }

  // Setzen des AngularJS-Dateipfads
  public static void setAngular() {
    angular = libPath + Text.FORWARD_SLASH + Text.ANGULAR_JS;
    LOG.trace("Initialisieren von " + angular);
  }

  // Setzen des CSS-BootstrapMin-Dateipfads
  public static void setCssBootstrapMin() {
    cssBootstrapMin = cssPath + Text.FORWARD_SLASH + Text.BOOTSTRAP_MIN_CSS;
    LOG.trace("Initialisieren von " + cssBootstrapMin);
  }

  // Setzen des CSS-BootstrapToc-Dateipfads
  public static void setCssBootstrapToc() {
    cssBootstrapToc = cssPath + Text.FORWARD_SLASH + Text.BOOTSTRAP_TOC_MIN_CSS;
    LOG.trace("Initialisieren von " + cssBootstrapToc);
  }

  // Setzen des CSS-Stylesheet-Dateipfads
  public static void setCssStylesheet() {
    cssStylesheet = cssPath + Text.FORWARD_SLASH + Text.STYLESHEET_CSS;
    LOG.trace("Initialisieren von " + cssStylesheet);
  }

  // Setzen des Favicon-Dateipfads
  public static void setFavicon(String localHost) {
    favicon = localHost + Text.FORWARD_SLASH + Text.RESOURCES + Text.FORWARD_SLASH + Text.FAVICON_ICO;
    LOG.trace("Initialisieren von " + favicon);
  }

  // Setzen des FO-Stylesheet-Dateipfads
  public static void setFoStylesheet() {
    foStylesheet = xslPath + File.separator + Text.FOSHEET_XSL;
    LOG.trace("Initialisieren von " + foStylesheet);
  }

  // Setzen des FOP-Config-Dateipfads
  public static void setFopConfig() {
    fopConfig = configPath + File.separator + Text.FOP_CONFIG_XML;
    LOG.trace("Initialisieren von " + fopConfig);
  }

  // Setzen des JQuery-Min-Dateipfads
  public static void setJquery() {
    jquery = libPath + Text.FORWARD_SLASH + Text.JQUERY_MIN_JS;
    LOG.trace("Initialisieren von " + jquery);
  }

  // Setzen des JsBootstrap-Min-Dateipfads
  public static void setJsBootstrapMin() {
    jsBootstrapMin = libPath + Text.FORWARD_SLASH + Text.BOOTSTRAP_MIN_JS;
    LOG.trace("Initialisieren von " + jsBootstrapMin);
  }

  // Setzen des JsBootstrap-Toc-Dateipfads
  public static void setJsBootstrapToc() {
    jsBootstrapToc = libPath + Text.FORWARD_SLASH + Text.BOOTSTRAP_TOC_MIN_JS;
    LOG.trace("Initialisieren von " + jsBootstrapToc);
  }

  // Setzen des Popper-Dateipfads
  public static void setPopper() {
    popper = libPath + Text.FORWARD_SLASH + Text.POPPER_MIN_JS;
    LOG.trace("Initialisieren von " + popper);
  }

  // Setzen des XML-Stylesheet-Dateipfads
  public static void setXmlStylesheet() {
    xmlStylesheet = xslPath + File.separator + Text.STYLESHEET_XSL;
    LOG.trace("Initialisieren von " + xmlStylesheet);
  }

  // Setzen des XML-Stylesheet-ToC-Dateipfads
  public static void setXmlStylesheetToc() {
    xmlStylesheetToc = xslPath + File.separator + Text.STYLESHEET_TOC_XSL;
    LOG.trace("Initialisieren von " + xmlStylesheetToc);
  }
}
