package de.domain.xdoc.create;

import de.domain.xdoc.access.Writer;
import de.domain.xdoc.character.Text;
import de.domain.xdoc.character.XML;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TableOfContentCreator extends TextCreator {

    private static final Logger LOG = LogManager.getLogger(TableOfContentCreator.class.getName());

    /**
     * Die Methode createTableOfContentEnd() erzeugt das Ende eines Inhaltsverzeichnisses.
     */
    public static void createTableOfContentEnd() {
        Writer.write(writer, Text.BLANK_04);
        Writer.write(writer, XML.TABLE_OF_CONTENT_END);
    }

    /**
     * Die Methode createTableOfContentItem() erzeugt einen Eintrag in das Inhaltsverzeichnis
     * @param name Name des Eintrags
     * @param type  Topic oder Content
     * @param htmlPath Pfad zur Webseite
     * @param pdfPath Pfad zum PDF-Dokument
     */
    public static void createTableOfContentItem(String name, String type, String htmlPath, String pdfPath) {

        // Item-Beginn
        Writer.write(writer, Text.BLANK_06);
        Writer.write(writer, XML.TABLE_OF_CONTENT_ITEM_START);

        // HTML-Referenz
        Writer.write(writer, Text.BLANK_08);
        Writer.write(writer, XML.TABLE_OF_CONTENT_ITEM_HTML_NAME);
        Writer.write(writer, name);
        Writer.write(writer, Text.QUOTE);
        Writer.write(writer, XML.LINK);
        Writer.write(writer, htmlPath);
        Writer.write(writer, Text.QUOTE);
        Writer.write(writer, Text.TYPE);
        Writer.write(writer, type);
        Writer.write(writer, Text.TAG_END_QUOTE_CLOSE_CRNL);

        // PDF-Referenz
        Writer.write(writer, Text.BLANK_08);
        Writer.write(writer, XML.TABLE_OF_CONTENT_ITEM_PDF_NAME);
        Writer.write(writer, pdfPath);
        Writer.write(writer, Text.TAG_END_QUOTE_CLOSE_CRNL);

        // Item-Ende
        Writer.write(writer, Text.BLANK_06);
        Writer.write(writer, XML.TABLE_OF_CONTENT_ITEM_END);
    }

    /**
     * Die Methode createTableOfContentStart() erzeugt den Anfang eines Inhaltsverzeichnisses
     */
    public static void createTableOfContentStart() {
        Writer.write(writer, Text.BLANK_04);
        Writer.write(writer, XML.TABLE_OF_CONTENT_START);
    }

}
