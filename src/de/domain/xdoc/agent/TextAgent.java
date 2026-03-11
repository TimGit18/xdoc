package de.domain.xdoc.agent;

import de.domain.xdoc.access.Reader;
import de.domain.xdoc.access.Writer;
import de.domain.xdoc.character.Text;
import de.domain.xdoc.create.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.List;

/**
 * Die Klasse TextAgent ist eine Musterklasse für die Verarbeitung der Themadokumente und der
 * Inhaltsdokumente. Sie besitzt die zentralen Felder und Methoden, die in beiden anderen
 * Kind-Prozessoren gleichermaßen verwendet werden.
 */
public class TextAgent {

    // Vererbte Felder der Klasse
    static String textPath;
    static String xmlPath;
    static String localImagePath;
    static String imagePath;
    static String environment;
    static Integer level;

    // Mapper
    static List<String> nameList;
    static List<String> mainList;
    static List<String> typeList;
    static HashMap<Integer, String> htmlMap;
    static HashMap<Integer, String> pdfMap;

    // Deklaration des statischen Loggers
    static Logger LOG = LogManager.getLogger(TextAgent.class.getName());

    // Deklaration des statischen gepufferten Readers und des Ausgabeschreibers
    static BufferedReader bufferedReader = null;
    static OutputStreamWriter outputStreamWriter = null;

    // Typisierung der Links
    static final String LINKTYPE_CSS = "stylesheet";
    static final String LINKTYPE_ICO = "icon";

    /**
     * Die Methode initialize() initialisiert die Prozessoren.
     * @param documentTextPath Dokument-Textpfad
     * @param documentXmlPath Dokument-XML-Pfad
     * @param documentEnvironment Sytemkontext
     * @param documentLocalImagePath
     * @param documentImagePath
     * @param nameMapper Liste der Dokumentennamen
     * @param mainListMapper Liste der Hauptnavigationselemente
     * @param htmlMapper Liste der HTML-Pfade
     * @param pdfMapper Liste der PDF-Pfade
     * @param typeListMapper topic oder content
     * @param documentLevel
     */
    public static void initialize(String documentTextPath, String documentXmlPath, String documentEnvironment,
                                  String documentLocalImagePath, String documentImagePath, List<String> nameMapper, List<String> mainListMapper,
                                  HashMap<Integer, String> htmlMapper, HashMap<Integer, String> pdfMapper,
                                  List<String> typeListMapper, Integer documentLevel) {

        // Initialisierung der Felder
        textPath = documentTextPath;
        xmlPath = documentXmlPath;
        localImagePath = documentLocalImagePath;
        imagePath = documentImagePath;
        environment = documentEnvironment;
        nameList = nameMapper;
        htmlMap = htmlMapper;
        pdfMap = pdfMapper;
        mainList = mainListMapper;
        typeList = typeListMapper;
        level = documentLevel;

        // Erzeugen des Einlesers
        bufferedReader = Reader.createReader(textPath);

        // Erzeugen des XML-Dokuments und Initialisieren des Erzeugers
        outputStreamWriter = Writer.createOutputStreamWriter(xmlPath);
        TextCreator.initialize(outputStreamWriter);
    }

    /**
     * Die Methode createLinks() erzeugt eine Liste von Links, die Stylesheets sowie ein Icon referenzieren.
     * Der relative Pfad muss um den prePath ergänzt werden, der den Level des Dokuments repräsentiert.
     * @param bootstrapMin CSS-Stylesheet für Bootstrap
     * @param bootstrapToc CSS-Stylesheet für Bootstrap Inhaltsverzeichnis
     * @param favicon Favourite Icon
     */
    public static void createLinks(String bootstrapMin, String bootstrapToc, String favicon) {
        LinkCreator.createLinksStart();
        LinkCreator.createLinkItem(bootstrapMin,LINKTYPE_CSS );
        LinkCreator.createLinkItem(bootstrapToc,LINKTYPE_CSS);
        LinkCreator.createLinkItem(favicon,LINKTYPE_ICO);
        LinkCreator.createLinksEnd();
    }

    /**
     * Die Methode createListItem() erzeugt einen Listeneintrag. Dabei wird das Listenmerkmal durch
     * ein Leerzeichen ersetzt.
     * @param line übergebene Zeile
     */
    public static void createListItem(String line) {
        line = line.replaceAll(Text.LIST_ITEM_START, Text.EMPTY);
        line = line.replaceAll(Text.NUMBER_LIST_ITEM_START, Text.EMPTY);
        ListCreator.createListItem(line);
    }

    /**
     * Die Methode createMainArea() erzeugt für das XML-Generat die Hauptnavigationsleiste. Der relative
     * HTML-Pfad muss um den prePath ergänzt werden, der den Level des Dokuments repräsentiert.
     */
    public static void createMainArea() {
        MainCreator.createMainStart();
        for (String mainItem : mainList) {
            int index = nameList.indexOf(mainItem);
            if (mainItem.equals(environment)) mainItem = "Home";
            MainCreator.createMainTopic(mainItem, htmlMap.get(index));
            LOG.trace("mainItem: " + mainItem + " : " + htmlMap.get(index));
        }
        MainCreator.createMainEnd();
    }

    /**
     * Die Methode createNumberListItem() erzeugt einen Listeneintrag. Dabei wird das Listenmerkmal durch
     * ein Leerzeichen ersetzt.
     * @param line übergebene Zeile
     */
    public static void createBoldline(boolean isBoldline, String line) {
        if (isBoldline) TextCreator.createBoldLine(line);
    }

    /**
     * Die Methode createScripts() erzeugt eine Liste von Links, die Script-Bibliotheken referenzieren.
     * Der relative Script-Pfad muss um den prePath ergänzt werden, der den Level des Dokuments repräsentiert.
     * @param angularJs JavaScript-Bibliothek
     * @param jqueryJs JavaScript-Bibliothek
     * @param popperJs JavaScript-Bibliothek
     * @param bootstrapMinJs JavaScript-Bibliothek
     * @param bootstrapTocJs JavaScript-Bibliothek
     */
    public static void createScripts(String angularJs, String jqueryJs, String popperJs, String bootstrapMinJs,
                                      String bootstrapTocJs) {
        ScriptsCreator.createScriptsStart();
        ScriptsCreator.createScriptItem(angularJs);
        ScriptsCreator.createScriptItem(jqueryJs);
        ScriptsCreator.createScriptItem(popperJs);
        ScriptsCreator.createScriptItem(bootstrapMinJs);
        ScriptsCreator.createScriptItem(bootstrapTocJs);
        ScriptsCreator.createScriptsEnd();
    }

    /**
     * Die Methode createText() erzeugt Anfang, Ende und den Textkörper.
     * @param isTextStart kennzeichnet den Textanfang
     * @param isText kennzeichnet den Textkörper
     * @param isTextEnd kennzeichnet das Textende
     * @param line die übergebene Zeile
     */
    static void createText(boolean isTextStart, boolean isText, boolean isTextEnd, String line) {
        if (isTextStart) TextCreator.createTextStart();
        if (isText) TextCreator.createText(line);
        if (isTextEnd) TextCreator.createTextEnd();
    }
}
