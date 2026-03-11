package de.domain.xdoc.control;

import de.domain.xdoc.util.Configurator;
import de.domain.xdoc.util.Document;
import de.domain.xdoc.character.Text;
import de.domain.xdoc.agent.ContentAgent;
import de.domain.xdoc.agent.TopicAgent;
import de.domain.xdoc.transform.Formatter;
import de.domain.xdoc.transform.Transformer;
import de.domain.xdoc.util.Directory;
import de.domain.xdoc.util.Mapping;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Die Klasse Control übernimmt die Steuerung der kompletten Anwendung. Sie ist zuständig für die Initialisierung aller
 * Parameter der Anwendung, die Delegation der Aufgaben an weitere Klassen und die korrekte Verarbeitung der zurück-
 * gelieferten Ergebnisse. Die zentrale Methode ist die run(), die von der Main-Klasse von außerhalb gerufen wird.
 */
public class Control {

    // Pfadvariablen der Anwendung
    private static String basePath;
    private static String basePathSystem;
    private static String configPath;
    private static String fopPath;
    private static String htmlPath;
    private static String imagePath;
    private static String localHost;
    private static String localHostSystem;
    private static String localCssPath;
    private static String localHtmlPath;
    private static String localImagePath;
    private static String localLibPath;
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

    // Hilfsarray
    private static String[] links = new String[8];

    // Parameter der Anwendung
    private static String systemEnvironment;

    // Parameter, um den Workflow zu steuern
    private static final Logger LOG = LogManager.getLogger(Control.class.getName());

    // Aufteilung der Dokumente
    private static List<String> topicList = new ArrayList<>();
    private static List<String> contentList = new ArrayList<>();
    private static List<String> nameList = new ArrayList<>();
    private static List<String> mainList = new ArrayList<>();
    private static List<String> typeList = new ArrayList<>();

    // Main-, HTML- und PDF-Maps
    private static HashMap<Integer, String> htmlMap = new HashMap<>();
    private static HashMap<Integer, String> pdfMap = new HashMap<>();

    /**
     * Die Methode run() führt die Erstellung der Dokumentation durch. Zunächst wird die Umgebung initialisiert und
     * anschließend gesäubert. Danach wird die neue Umgebung erzeugt und deren Strukturen angelegt. Im Anschluss werden
     * die Dokumente verarbeitet.
     * @param path Basispfad für die Anwendung
     * @param system Systemkontext
     * @param localhost lokaler Webserver
     */
    static void run(String path, String system, String localhost) {

        // Basispfad und Systemkontext überprüfen
        systemEnvironment = system;
        basePath = path;
        basePathSystem = path + File.separator + system;
        localHost = localhost;
        localHostSystem = localHost + Text.FORWARD_SLASH + systemEnvironment;

        // Check Parameter
        LOG.trace("Basispfad:               " + basePath);
        LOG.trace("Basispfad Systemkontext: " + basePathSystem);
        LOG.trace("Systemumgebungs-Kontext: " + systemEnvironment);
        LOG.trace("Lokaler Host:            " + localHost);
        LOG.trace("Lokaler Host-Pfad:       " + localHostSystem);

        // Initialisierung durchführen, Strukturen säubern und aufbauen, Dokumente verabeiten und transformieren
        setEnvironment();
        setLinks();
        remove();
        create();
        prepare();
        processTopics();
        processContents();
    }

    /**
     * Die Methode setAbsolutePaths() initialisiert die Parameter der Umgebebung, d.h. die Laufzeitpfade
     * der Anwendung in absoluten Pfaden.
     */
    private static void setEnvironment() {

        LOG.trace("************************************");
        LOG.trace("Step 1: Initialisierung der Umgebung");
        LOG.trace("************************************");

        //---------------------------//
        // Setzen der Umgebungspfade //
        //---------------------------//
        Configurator.setDirectoryPaths(basePath, localHost, basePathSystem, localHostSystem);
        Configurator.setFilePaths(localHost);

        //-----------------//
        // Holen der Pfade //
        //-----------------//
        configPath = Configurator.getConfigPath();
        fopPath = Configurator.getFopPath();
        htmlPath = Configurator.getHtmlPath();
        imagePath = Configurator.getImagePath();
        localCssPath = Configurator.getCssPath();
        localHtmlPath = Configurator.getLocalHtmlPath();
        localImagePath =  Configurator.getLocalImagePath();
        localLibPath = Configurator.getLibPath();
        pdfPath = Configurator.getPdfPath();
        textPath = Configurator.getTextPath();
        xmlPath = Configurator.getXmlPath();
        xslPath = Configurator.getXslPath();

        //-------------------//
        // Holen der Dateien //
        //-------------------//
        angular = Configurator.getAngular();
        cssBootstrapMin = Configurator.getCssBootstrapMin();
        cssBootstrapToc = Configurator.getCssBootstrapToc();
        cssStylesheet = Configurator.getCssStylesheet();
        favicon = Configurator.getFavicon();
        foStylesheet = Configurator.getFoStylesheet();
        fopConfig = Configurator.getFopConfig();
        jquery = Configurator.getJquery();
        jsBootstrapMin = Configurator.getJsBootstrapMin();
        jsBootstrapToc = Configurator.getJsBootstrapToc();
        popper = Configurator.getPopper();
        xmlStylesheet = Configurator.getXmlStylesheet();
        xmlStylesheetToc = Configurator.getXmlStylesheetToc();
    }


    /**
     * Die Methode remove() säubert die Zielverzeichnisse des Systemkontexts.
     */
    private static void remove() {
        LOG.trace("******************************");
        LOG.trace("Step 2: S\u00e4uberung der Umgebung");
        LOG.trace("******************************");
        Directory.deleteFile(xmlPath);
        Directory.deleteFile(fopPath);
        Directory.deleteFile(htmlPath);
        Directory.deleteFile(pdfPath);
    }

    /**
     * Die Methode create() erzeugt die Zielverzeichnisse des Systemkontexts und induziert eine Dokumentenstruktur
     * in diesen Zielverzeichnissen.
     */
    private static void create() {

        LOG.trace("*****************************");
        LOG.trace("Step 3: Erzeugen der Umgebung");
        LOG.trace("*****************************");
        Directory.createDirectory(xmlPath);
        Directory.createDirectory(fopPath);
        Directory.createDirectory(htmlPath);
        Directory.createDirectory(pdfPath);

        LOG.trace("*****************************");
        LOG.trace("Step 4: Erzeugen der Struktur");
        LOG.trace("*****************************");
        Directory.createDocumentStructure(textPath, xmlPath);
        Directory.createDocumentStructure(textPath, fopPath);
        Directory.createDocumentStructure(textPath, htmlPath);
        Directory.createDocumentStructure(textPath, pdfPath);
    }

    /**
     * Die Methode prepare() bereitet die Dokumentenverarbeitung vor. Zunächst werden die Quelldokumente geladen.
     * Anschließend wird über jedes Quelldokument iteriert und die Zuordnung wird vergenommen:
     * 1. Die Liste topicList sammelt die Themadokumente auf
     * 2. Die Liste contentList sammelt die Content-Dokumente auf
     * 3. Die Liste mainList sammelt die Kandidaten für die Hauptnavigation auf (die noch sortiert werden muss)
     */
    private static void prepare() {

        LOG.trace("*******************************");
        LOG.trace("Step 5: Ermitteln der Dokumente");
        LOG.trace("*******************************");
        Mapping.initialize(localHostSystem, systemEnvironment, textPath);

        LOG.trace("**************************************************");
        LOG.trace("Step 6: Iterieren \u00fcber die Dokumente und Zuordnen");
        LOG.trace("**************************************************");
        Mapping.assign();

        // Zuordnen zu den Listen
        nameList = Mapping.getNameList();
        mainList = Mapping.getMainList();
        topicList = Mapping.getTopicList();
        contentList = Mapping.getContentList();
        typeList = Mapping.getTypeList();

        // Zuordnen zu den Hash-Tabellen
        htmlMap = Mapping.getHtmlMap();
        pdfMap = Mapping.getPdfMap();

    }

    /**
     * Die Methode processTopics() verarbeitet nur die Thema-Dokumente.
     * Dafür über jedes Element der Thema-Liste iteriert, indem für jedes der entsprechende Thema-Prozessor aufgerufen
     * wird. Anschließend wird das Element von dem Prozessor verarbeitet und in ein entsprechendes XML-Dokument über-
     * führt. Hiernach wird in einem weiteren Schritt das XML-Dokument in ein HTML-Dokument transformtiert (und über
     * eine FO-Zwischentransformation) in ein PDF-Dokument.
     */
    private static void processTopics() {

        LOG.trace("************************************************");
        LOG.trace("Step 10: Iterieren \u00fcber die Topic-Dokumente");
        LOG.trace("************************************************");
        for (String item : topicList) {

            // Assignment
            LOG.trace("Thema-Element: " + item);
            assign(item);

            // Generierung der XML-Dokumente
            LOG.trace("************************************");
            LOG.trace("Step 10a: Erzeugen der XML-Dokumente");
            LOG.trace("************************************");
            TopicAgent.initialize(Document.getTextPath(), Document.getXmlPath(), Document.getSystem(),
                    Document.getLocalImagePath(), Document.getImagePath(), nameList, mainList, htmlMap, pdfMap,
                    typeList, Document.getLevel());
            TopicAgent.process(Document.getName(), links);

            // Generierung von HTML, FO und PDF
            generate(Document.getType());
        }
    }

    /**
     * Die Methode processContents() verarbeitet nur die Inhalt-Dokumente.
     * Dafür über jedes Element der Thema-Liste iteriert, indem für jedes der entsprechende Thema-Prozessor aufgerufen
     * wird. Anschließend wird das Element von dem Prozessor verarbeitet und in ein entsprechendes XML-Dokument über-
     * führt. Hiernach wird in einem weiteren Schritt das XML-Dokument in ein HTML-Dokument transformiert (und über
     * eine FO-Zwischentransformation) in ein PDF-Dokument.
     */
    private static void processContents() {

        LOG.trace("**************************************************");
        LOG.trace("Step 10: Iterieren \u00fcber die Content-Dokumente");
        LOG.trace("**************************************************");
        for (String item : contentList) {
            LOG.trace("Inhaltselement: " + item);
            assign(item);

            // Generierung der XML-Dokumente
            LOG.trace("************************************");
            LOG.trace("Step 10a: Erzeugen der XML-Dokumente");
            LOG.trace("************************************");
            ContentAgent.initialize(Document.getTextPath(), Document.getXmlPath(), Document.getSystem(),
                    Document.getLocalImagePath(), Document.getImagePath(), nameList, mainList, htmlMap, pdfMap,
                    typeList, Document.getLevel());
            ContentAgent.process(Document.getName(),links);

            // Generierung von HTML, FO und PDF
            generate(Document.getType());
        }
    }

    /**
     * Die private Methode assign()  weist jedem Dokument den entsprechenden Wert aus der Dokumentenstruktur zu.
     * @param item zu übergebender Parameter
     */
    private static void assign(String item) {
        // Initialisierung
        Document.initialize(item, textPath, systemEnvironment, localHostSystem);

        // Überprüfung des Assignments
        LOG.trace("********************************************************");
        LOG.trace("Kontext:             " + Document.getSystem());
        LOG.trace("Root-Pfad:           " + Document.getRootPath());
        LOG.trace("Name:                " + Document.getName());
        LOG.trace("Text-Name:           " + Document.getTextName());
        LOG.trace("Text-Pfad:           " + Document.getTextPath());
        LOG.trace("Ebene:               " + Document.getLevel());
        LOG.trace("Thema:               " + Document.getTopic());
        LOG.trace("Thema-Pfad:          " + Document.getTopicPath());
        LOG.trace("XML-Pfad:            " + Document.getXmlPath());
        LOG.trace("HTML-Pfad:           " + Document.getHtmlPath());
        LOG.trace("Bild-Pfad:           " + Document.getImagePath());
        LOG.trace("FOP-Pfad:            " + Document.getFopPath());
        LOG.trace("PDF-Pfad:            " + Document.getPdfPath());
        LOG.trace("Typ:                 " + Document.getType());
        LOG.trace("Lokaler HTML-Pfad:   " + Document.getLocalHtmlPath());
        LOG.trace("Lokaler PDF-Pfad:    " + Document.getLocalPdfPath());
        LOG.trace("Lokaler Bild-Pfad:   " + Document.getLocalImagePath());
        LOG.trace("********************************************************");
    }

    /**
     * Die Funktion generate() generiert für jedes Dokumenten-Item aus dem XML-Modell das zugehörige HTML- und FO-
     * Objekt und aus letzterem das entsprechende PDF-Dokument.
     */
    private static void generate(String documentType) {

        // Je nach Dokumenten-Typ muss ein unterschiedliches Stylesheet verwendet werden
        String xsltSheet = new String();
        if (documentType.equals(Text.TYPE_TOPIC)) {
            xsltSheet = xmlStylesheetToc;
        }
        if (documentType.equals(Text.TYPE_CONTENT)) {
            xsltSheet = xmlStylesheet;
        }

        // Transformation der XML-Dokumente
        LOG.trace("******************************************");
        LOG.trace("Step 10b: Transformieren der XML-Dokumente");
        LOG.trace("******************************************");
        Transformer.initialize(xsltSheet, Document.getFopPath(), foStylesheet, Document.getHtmlPath(),
                Document.getXmlPath());
        Transformer.instantiate();
        Transformer.prepare();
        Transformer.transform();

        // Generieren der PDF-Dokumente
        LOG.trace("**************************************");
        LOG.trace("Step 10c: Generieren der PDF-Dokumente");
        LOG.trace("**************************************");
        Formatter.initialize(Document.getFopPath(), Document.getPdfPath(), fopConfig);
        Formatter.format();
    }

  /**
    * Die Methode setLinks() setzt aus den übergebenen Web-Parametern den Array Links.
    */
  private static void setLinks() {
    links[0] = cssBootstrapMin;
    links[1] = cssBootstrapToc;
    links[2] = favicon;
    links[3] = angular;
    links[4] = jquery;
    links[5] = popper;
    links[6] = jsBootstrapMin;
    links[7] = jsBootstrapToc;
  }
}
