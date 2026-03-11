package de.domain.xdoc.util;

import de.domain.xdoc.character.Text;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Die Klasse Mapping führt die Zuiordnung der verschiedenen Dokumente zu bestimmten Dokumentenstrukturen durch.
 * Die Hauptmethode dieser Klasse ist die Methode assign(), die anhand der Dokumentenspezifika die Zuordnung
 * vornimmt.
 */
public class Mapping {

    // Private Felder dieser Klasse für die Initialisierung
    private static String localhostPath;
    private static String systemEnvironment;
    private static String textPath;

    // Listen für die einfache Zuordnung
    private static List<String> textList = new ArrayList<>();
    private static List<String> topicList = new ArrayList<>();
    private static List<String> contentList = new ArrayList<>();
    private static List<String> typeList = new ArrayList<>();
    private static List<String> nameList = new ArrayList<>();
    private static List<String> mainList = new ArrayList<>();

    // Hash-Maps für die indizierte Zuordnung (HTML und PDF-Dokumentenpfade
    private static HashMap<Integer, String> htmlMap = new HashMap<>();
    private static HashMap<Integer, String> pdfMap = new HashMap<>();

    // Logger
    private static Logger LOG = LogManager.getLogger(Mapping.class.getName());

    /**
     * Die Methode initialize() initialisiert die Felder der Klasse.
     * @param localhost HTTP-Adresse des localhosts
     * @param environment Systemkontext
     * @param path Textpfad
     */
    public static void initialize(String localhost, String environment, String path) {
        LOG.trace("Holen der Dokumente zu: " + path);
        localhostPath = localhost;
        systemEnvironment = environment;
        textPath = path;
        textList = Directory.getDocumentsList(textPath);

        for (String item:textList) {
            LOG.trace(item);
        }

        LOG.trace("Localhost-Pfad:  " + localhost);
        LOG.trace("Systemkontext:   " + systemEnvironment);
        LOG.trace("Textpfad:        " + textPath);
    }

    /**
     * Die Methode assign() weist den verschiedenen Dokumenten und ihren Pfaden die entsprechenden
     * Dokumentenstrukturen zu:
     *  textList    = Liste von Textpfaden
     *  topicList   = Liste von Themadokument-Pfaden
     *  contentList = Liste von Inhaltsdokument-Pfaden
     *  nameList    = Liste der Dokumenten-Namen
     *  mainList    = Liste der Dokumenten-Namen für die Navigationsleiste, die noch sortiert wird
     *  htmlMap     = Hash-Map für die HTML-PFade der Anwendung mit Index als Schlüssel
     *  pdfMap      = Hash-Map für die PDF-Pfade der Anwendung mit Index als Schlüssel
     */
    public static void assign() {

        // Counter als für die Indizierung der Hash-Map-Tabellen
        int htmlCounter = 0;
        int pdfCounter = 0;

        LOG.trace("Iterieren \u00fcber die Dokumente zu " + textPath);
        for (String item : textList) {

            LOG.trace("Element: " + item);
            Document.initialize(item, textPath, systemEnvironment, localhostPath);

            // Mappings und Hilfsliste befüllen
            htmlMap.put(htmlCounter++, Document.getLocalHtmlPath());
            pdfMap.put(pdfCounter++, Document.getLocalPdfPath());
            nameList.add(Document.getName());
            typeList.add(Document.getType());

            // Unterscheidung zwischen Thema- und Inhaltsdokumenten
            if (Document.getType().equals(Text.TYPE_TOPIC)) {
                topicList.add(Document.getTextPath());

                // Nur die Themen der obersten Ebene sind für die Hauptnavigation auszuwählen
                if (Document.getLevel() < 2) {
                    LOG.trace("mainList: " + Document.getTextPath());
                    mainList.add(Document.getName());
                }

            } else if (Document.getType().equals(Text.TYPE_CONTENT)) {
                contentList.add(Document.getTextPath());
            }
        }
        // Sortierung der Hauptliste als Abschluss der Zuordnung
        Mapping.sortMainList(mainList, systemEnvironment);
    }

    /**
     * Die Methode sortMainList() sortiert die Liste der Hauptnavigationsthemen so, dass der Systemkontext an der
     * ersten Stelle der sortierten Liste steht und der bisherige Listenanfang mit diesem die Pl�tze tauscht.
     * Ansonsten wird blo� der Systemkontext an die irreale Stelle geschrieben.
     * @param mainList zu sortierende Liste
     */
    private static void sortMainList(List<String> mainList, String environment) {

        // Initialisierung
        int replacementIndex = -1;

        // Index identifizieren von dem Dokument, das dem Systemkontext entspricht
        for (String item : mainList) {
            if ((mainList.indexOf(item)!= 0) && item.equals(environment)) {
                replacementIndex = mainList.indexOf(item);
            }
        }

        // Austauschprozedur nur ausführen, wenn überhaupt ein Index gefunden wurde
        if (replacementIndex != -1) {
            mainList.set(replacementIndex, mainList.get(0));
            mainList.set(0, environment);
        }
    }

    /**
     * Die Methode getTopicList() gibt die Liste der Thema-Dokumente zur�ck.
     * @return topicList die Thema-Liste
     */
    public static List<String> getTopicList() {
        return topicList;
    }

    /**
     * Die Methode getContentList() gibt die Liste der Content-Dokumente zurück.
     * @return contentList
     */
    public static List<String> getContentList() {
        return contentList;
    }

    /**
     * Die Methode getNameList() gibt die sortierte Liste der Namen aller Dokumente zurück.
     * @return nameList
     */
    public static List<String> getNameList() {
        return nameList;
    }

    /**
     * Die Methode getMainList gibt die (umsortierte) Liste der Navigationsdokumente zurück.
     * @return mainList
     */
    public static List<String> getMainList() {
        return mainList;
    }

    /**
     * Die Methode getHtmlMap() gibt die Hash-Map aller HTML-Links zurück.
     * @return htmlMap
     */
    public static HashMap<Integer, String> getHtmlMap() {
        return htmlMap;
    }

    /**
     * Die Methode getPDFMap() gibt die Hash-Map aller PDF-Links zurück.
     * @return pdfMap
     */
    public static HashMap<Integer, String> getPdfMap() {
        return pdfMap;
    }

    /**
     * Die Methode getTypeList() gibt die Liste der Typen aller Dokumente zurück.
     * @return typeList
     */
    public static List<String> getTypeList() {
        return typeList;
    }



}
