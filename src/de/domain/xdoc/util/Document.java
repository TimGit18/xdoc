package de.domain.xdoc.util;

// import org.apache.logging.log4j.LogManager;
// import org.apache.logging.log4j.Logger;

import de.domain.xdoc.character.Text;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * System:              Test
 * Name:                Thema
 * Text-Name:			      Thema.txt
 * Root-Pfad:           C:\Users\schmi\Daten\Web\xdoc\Test
 * Text-Pfad:	          C:\Users\schmi\Daten\Web\xdoc\Test\txt\Thema\Thema.txt
 * HTML-Pfad:	          C:\Users\schmi\Daten\Web\xdoc\Test\html\Thema\Thema.html
 * XML-Pfad:	 	        C:\Users\schmi\Daten\Web\xdoc\Test\xml\Thema\Thema.xml
 * FOP-Pfad:	 	        C:\Users\schmi\Daten\Web\xdoc\Test\fo\Thema\Thema.fo
 * PDF-Pfad:	 	        C:\Users\schmi\Daten\Web\xdoc\Test\pdf\Thema\Thema.pdf
 * Bild-Pfad:           file:///C:/Users/schmi/Daten/Web/xdoc/Test/img/Thema/
 * ------------------------------------------------------------------------------------------
 * Lokaler Web-Pfad:    https://localhost:8080/xdoc/Test/
 * Lokaler HTML-Pfad:   https://localhost:8080/xdoc/Test/html/Thema/Thema.html
 * Lokaler PDF-Pfad:    https://localhost:8080/xdoc/Test/pdf/Thema/Thema.pdf
 * Lokaler Konf-Pfad:   https://localhost:8080/xdoc/Test/conf
 * Lokaler Bild-Pfad:   https://localhost:8080/xdoc/Test/img/Thema/
 **/
public class Document {

    private static Logger LOG = LogManager.getLogger(Document.class.getName());

    //----------------------------------------------------------//
    // Deklaration der privaten singulären Felder dieser Klasse //
    //----------------------------------------------------------//
    private static int level;
    private static String name;
    private static String system;
    private static String topic;
    private static String topicPath;
    private static String type;

    //----------------------------------//
    // Deklaration der statischen Pfade //
    //----------------------------------//
    private static String rootPath;
    private static String fopPath;
    private static String htmlPath;
    private static String imagePath;
    private static String pdfPath;
    private static String textName;
    private static String textPath;
    private static String xmlPath;

    //---------------------------//
    // Deklaration der Web-Pfade //
    //---------------------------//
    private static String localhostPath;
    private static String localHtmlPath;
    private static String localPdfPath;
    private static String localImagePath;

    //-----------------------------------------------//
    // Deklaration der öffentlichen Getter-Methoden  //
    //-----------------------------------------------//
    public static String getFopPath() {  return fopPath;   }

    public static String getHtmlPath() { return htmlPath; }

    public static String getImagePath() { return imagePath; }

    public static Integer getLevel() {  return level;    }

    public static String getName() {
        return name;
    }

    public static String getPdfPath() { return pdfPath; }

    public static String getRootPath() { return rootPath; }

    public static String getSystem() { return system; }

    public static String getTextName() {
        return textName;
    }

    public static String getTextPath() {
        return textPath;
    }

    public static String getTopic() {
        return topic;
    }

    public static String getTopicPath() {
        return topicPath;
    }

    public static String getType() {  return type;  }

    public static String getXmlPath() { return xmlPath; }

    public static String getLocalHtmlPath() {  return localHtmlPath;  }

    public static String getLocalPdfPath() { return localPdfPath;  }

    public static String getLocalImagePath() { return localImagePath;  }

    /*****************************************************************************************************************
     * Die Methode initialize() initialisiert zu jedem Text-Element ein zugehöriges (abstraktes) Dokument mit seinen
     * Eigenschaften. Dabei wird die in der Klassenbeschreibung beschriebene Logik injiziert.
     * @param textItemPath ist der Pfad, der zu dem Textdokument gehört
     * @param textBasePath ist der Pfad, der die Ausgangsbasis für alle Textdokumente darstellt
     * @param systemEnvironment ist der Systemkontext
     * @param localhost ist der Pfad des lokalen Web-Servers plus des Anwendungskontexts
     ******************************************************************************************************************/
    public static void initialize(String textItemPath, String textBasePath, String systemEnvironment, String localhost) {

        //----------------------------------//
        // Basisinformationen zum Dokument  //
        //----------------------------------//
        system = systemEnvironment;
        localhostPath = localhost;
        rootPath = textBasePath;
        textPath = textItemPath;
        textName = textPath.split(Text.SEPARATOR)[textPath.split(Text.SEPARATOR).length-1];
        name = textName.replace(Text.SUFFIX_TEXT,Text.NIL);
        level = 0;

        //---------------------------------------//
        // Thematische Informationen  und Level  //
        //---------------------------------------//
        topic = textPath.split(Text.SEPARATOR)[textPath.split(Text.SEPARATOR).length-2];
        setTopicPath();
        setLevel();

        //----------------------//
        // Pfad-Informationen   //
        //----------------------//
        setXmlPath();
        setHtmlPath();
        setImagePath();
        setFopPath();
        setPdfPath();

        setLocalHtmlPath();
        setLocalPdfPath();
        setLocalImagePath();

        //--------------------------//
        // Weitere Informationen    //
        //--------------------------//
        setType();
    }

    /**
     * Der Thema-Pfad wird ermittelt, indem aus dem kompletten Pfad der Dateiname entfernt wird, dann alle Pfad-Elemente
     * bis einschließlich der Textkomponent und anschließend noch der abschließende Pfad-Separator.
     */
    private static void setTopicPath() {
        topicPath = textPath.replaceAll(textName,Text.NIL);
        topicPath = topicPath.replaceAll(Text.START_TO_TEXT,Text.NIL);
        topicPath = topicPath.replaceAll(Text.SEPARATOR_AT_END,Text.NIL);
    }

    /**
     * Der XML-Pfad wird ermittelt, indem aus dem Text-Pfad die entsprechenden Text-Kompenenten entfernt werden und
     * durch die XML-Komponenten ersetzt werden.
     */
    private static void setXmlPath() {
        xmlPath = textPath.replaceAll(Text.TEXT,Text.XML);
        xmlPath = xmlPath.replaceAll(Text.SUFFIX_TEXT,Text.SUFFIX_XML);
    }

    /**
     * Der HTML-Pfad wird ermittelt, indem aus dem Text-Pfad die entsprechenden Text-Kompenenten entfernt werden und
     * durch die Web-Komponenten ersetzt werden.
     */
    private static void setHtmlPath() {
        htmlPath = textPath.replaceAll(Text.TEXT,Text.HTML);
        htmlPath = htmlPath.replaceAll(Text.SUFFIX_TEXT,Text.SUFFIX_HTML);
    }

    /**
     * Der FOP-Pfad wird ermittelt, indem aus dem Text-Pfad die entsprechenden Text-Kompenenten entfernt werden und
     * durch die FOP-Komponenten ersetzt werden.
     */
    private static void setFopPath() {
        fopPath = textPath.replaceAll(Text.TEXT,Text.FOP);
        fopPath = fopPath.replaceAll(Text.SUFFIX_TEXT,Text.SUFFIX_FOP);
    }

    /**
     * Der PDF-Pfad wird ermittelt, indem aus dem Text-Pfad die entsprechenden Text-Kompenenten entfernt werden und
     * durch die PDF-Komponenten ersetzt werden.
     */
    private static void setPdfPath() {
        pdfPath = textPath.replaceAll(Text.TEXT,Text.PDF);
        pdfPath = pdfPath.replaceAll(Text.SUFFIX_TEXT,Text.SUFFIX_PDF);
    }

    /**
     * Der Dokumententyp wird ermittelt, indem der (logische) Name des Dokuments mit dem Namen des Themas verglichen
     * wird. Wenn beide übereinstimmen, dann handelt es sich um einen Dokumententyp TOPIC, andernfalls ein CONTENT.
     */
    private static void setType() {
        if (name.equals(topic)) type = Text.TYPE_TOPIC;
        else {
            if (level==0 && name.equals(system)) type = Text.TYPE_TOPIC;
            else                                 type = Text.TYPE_CONTENT;
        }
    }

    /**
     * Die Methode setLevel ermittelt zu jedem Dokument die Strukturtiefe. Ein Dokument auf der Root-Ebene hat die Tiefe
     * 0. Auf den Ebenen darunter wächst sie inkrementell. Da pro Ebene immer ein Separator hinzukommt, muss dieser bei
     * der Berechnung der Dokumententiefe abgezogen werden.
     */
    private static void setLevel(){
        int totalDocumentLevel = textPath.split(Text.SEPARATOR).length;
        int rootPathLevel = rootPath.split(Text.SEPARATOR).length;
        level = totalDocumentLevel - rootPathLevel - 1;
        LOG.trace("TextPfad: " + textPath + ":" + totalDocumentLevel);
        LOG.trace("RootPfad: " + rootPath + ":" + rootPathLevel);
        LOG.trace("Level: "+ level);
    }

    /**
     * Der lokale HTML-Pfad wird ermittelt, indem aus dem Text-Pfad die entsprechenden Text-Kompenenten entfernt werden
     * und durch die Web-Komponenten relativ zum Web-Server ersetzt werden.
     */
    private static void setLocalHtmlPath() {
        localHtmlPath = textPath.replaceAll(Text.TEXT,Text.HTML);
        localHtmlPath = localHtmlPath.replaceAll(Text.SUFFIX_TEXT, Text.SUFFIX_HTML);

        localHtmlPath = localHtmlPath.replaceAll(Text.BEGIN_OF_LINE + system + Text.SEPARATOR,
                                    localhostPath + Text.FORWARD_SLASH);
        localHtmlPath = localHtmlPath.replaceAll(Text.SEPARATOR, Text.FORWARD_SLASH);
    }

    /**
     * Der lokale PDF-Pfad wird ermittelt, indem aus dem Text-Pfad die entsprechenden Text-Kompenenten entfernt werden
     * und durch die PDF-Komponenten relativ zum Web-Server ersetzt werden.
     */
    private static void setLocalPdfPath() {
        localPdfPath = textPath.replaceAll(Text.TEXT,Text.PDF);
        localPdfPath = localPdfPath.replaceAll(Text.SUFFIX_TEXT, Text.SUFFIX_PDF);
        localPdfPath = localPdfPath.replaceAll(Text.BEGIN_OF_LINE + system + Text.SEPARATOR,
                localhostPath + Text.FORWARD_SLASH);
        localPdfPath = localPdfPath.replaceAll(Text.SEPARATOR, Text.FORWARD_SLASH);
    }

    /**
     * Der lokale Bild-Pfad wird ermittelt, indem aus dem Text-Pfad die entsprechenden Text-Kompenenten entfernt werden
     * und durch die Komponenten relativ zum Web-Server ersetzt werden. Außerdem muss noch der relative Pfad des Images
     * ergänzt werden um den prePath.
     */
    private static void setLocalImagePath() {
        localImagePath = textPath.replaceAll(textName,Text.EMPTY);
        localImagePath = localImagePath.replaceAll(Text.TEXT,Text.IMG);
        localImagePath = localImagePath.replaceAll(Text.BEGIN_OF_LINE + system + Text.SEPARATOR,
                localhostPath + Text.FORWARD_SLASH);
        localImagePath = localImagePath.replaceAll(Text.SEPARATOR, Text.FORWARD_SLASH);
    }

    /**
     * Der globale Bild-Pfad wird als korrekte URI dargestellt, indem aus dem Text-Pfad die entsprechenden Text-
     * Kompenenten entfernt werdenund durch die Komponenten zur File-URI ersetzt werden.
     */
    private static void setImagePath() {
        imagePath = textPath.replaceAll(textName,Text.EMPTY);
        imagePath = imagePath.replaceAll(Text.TEXT,Text.IMG);
        imagePath = imagePath.replaceAll(Text.SEPARATOR, Text.FORWARD_SLASH);
        imagePath = Text.FILE + Text.COLON + Text.TRIPLE_SLASH + imagePath;
    }

}
