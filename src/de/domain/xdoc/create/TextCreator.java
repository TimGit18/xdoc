package de.domain.xdoc.create;

import de.domain.xdoc.character.Text;
import de.domain.xdoc.character.XML;
import de.domain.xdoc.access.Writer;
import de.domain.xdoc.util.MetaData;

import java.io.OutputStreamWriter;

/**
 * Die Klasse Creator verwaltet statische Methoden, um die XML-Dokumente zu erzeugen. Für manche Fragmente werden
 * Übergabeparameter verwendet.
 */
public class TextCreator {

    // Übergebener Ausgabeschreiber
     static OutputStreamWriter writer = null;

    /**
     * Die Metohde initialize() initialisiert den Erzeuger mit dem Ausgabeschreiber
     * @param outputStreamWriter ist der übergebene Ausgabeschreiber
     */
     public static void initialize(OutputStreamWriter outputStreamWriter) {
         writer = outputStreamWriter;
    }

    /**
     * Die Methode createBoldline() erzeugt eine Zeile in Fettschrift.
     * @param line die übergebende Teilüberschrift
     */
    public static void createBoldLine(String line) {
        line = line.replaceAll(Text.COLON_START, Text.EMPTY);
        Writer.write(writer, Text.BLANK_04);
        Writer.write(writer, XML.BOLD_START);
        Writer.write(writer, line);
        Writer.write(writer, XML.BOLD_END);
    }

    /**
     * Die Methode createContentStart() erzeugt den Beginn des Content-Bereichs nach einer Leerzeile.
     */
    public static void createContentStart() {
        Writer.write(writer, Text.NEW_LINE);
        Writer.write(writer, Text.BLANK_02);
        Writer.write(writer, XML.CONTENT_START);
    }

    /**
     * Die Methode createContentStart() erzeugt das Ende des Content-Bereichs.
     */
    public static void createContentEnd() {
        Writer.write(writer, Text.BLANK_02);
        Writer.write(writer, XML.CONTENT_END);
    }

    /**
     * Die Methode createEpilogue() schreibt den Abschluss des XML-Dokuments in den Ausgabeschreiber.
     */
    public static void createEpilogue() {
        Writer.write(writer, XML.DOCUMENT_END);
    }

    /**
     * Die Methode createHeadline() erzeugt eine Überschrift aus der übergebenen Zeile.
     * @param line ist die übergebene Zeile
     */
    public static void createHeadline(String line) {
        Writer.write(writer, Text.BLANK_04);
        Writer.write(writer, XML.HEADLINE_START);
        Writer.write(writer, line);
        Writer.write(writer, XML.HEADLINE_END);
    }

    /**
     * Die Methode createHorizontalBar() schreibt eine einfache horizontale Leiste.
     */
    public static void createHorizontalBar() {
        Writer.write(writer, Text.BLANK_04);
        Writer.write(writer, XML.HORIZONTAL);
    }
    /**
     * Die Methode createPrologue() schreibt den Anfang des XML-Dokuments in den Ausgabeschreiber.
     * @param environment
     */
    public static void createPrologue(String environment) {
        Writer.write(writer,XML.PROLOGUE);
        Writer.write(writer,XML.DOCUMENT_START);
        Writer.write(writer,environment);
        Writer.write(writer,Text.QUOTE);
        Writer.write(writer,Text.TAG_END_CRNL);
    }

    /**
     * Die Methode createSubheadline() erzeugt eine Teilüberschrift.
     * @param subheadline die übergebende Teilüberschrift
     */
    public static void createSubheadline(String subheadline) {
        Writer.write(writer, Text.NEW_LINE);
        Writer.write(writer, Text.BLANK_04);
        Writer.write(writer,XML.SUBHEADLINE_START);
        Writer.write(writer,subheadline);
        Writer.write(writer,Text.TAG_END_QUOTE);
        Writer.write(writer,subheadline);
        Writer.write(writer,XML.SUBHEADLINE_END);
    }

    /**
     * Die Methode createTextStart() erzeugt den Beginn eines Textes nach einer Leerzeile.
     */
    public static void createTextStart() {
        Writer.write(writer, Text.NEW_LINE);
        Writer.write(writer, Text.BLANK_04);
        Writer.write(writer, XML.TEXT_START);
    }

    /**
     * Die Methode createTextEnd() erzeugt das Ende einer Text-Area.
     */
    public static void createTextEnd() {
        Writer.write(writer, Text.BLANK_04);
        Writer.write(writer, XML.TEXT_END);
    }

    /**
     * Die Methode createText() erzeugt einen Text-Eintrag.
     * @param line die zu übergebende Zeile
     */
    public static void createText(String line) {
        Writer.write(writer, Text.BLANK_06);
        Writer.write(writer, line);
        Writer.write(writer, Text.NEW_LINE);
    }

}
