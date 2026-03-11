package de.domain.xdoc.create;

import de.domain.xdoc.access.Writer;
import de.domain.xdoc.character.Text;
import de.domain.xdoc.character.XML;

public class TableCreator extends TextCreator {

    /**
     * Die Methode createSTableStart() erzeugt den Anfang einer Tabelle.
     */
    public static void createTableStart() {
        Writer.write(writer,Text.BLANK_04);
        Writer.write(writer, XML.TABLE_START);
    }

    /**
     * Die Methode createTableEnd() erzeugt das Ende einer Tabelle.
     */
    public static void createTableEnd() {
        Writer.write(writer,Text.BLANK_06);
        Writer.write(writer,XML.TABLE_BODY_END);
        Writer.write(writer,Text.BLANK_04);
        Writer.write(writer,XML.TABLE_END);
    }

    /**
     * Die Methode createTableHeadlineStart() erzeugt den Anfang eines Tabellenkopfes.
     */
    public static void createTableHeadlineStart() {
        Writer.write(writer,Text.BLANK_06);
        Writer.write(writer,XML.TABLE_HEADLINE_START);
        Writer.write(writer,Text.BLANK_08);
        Writer.write(writer,XML.TABLE_ROW_START);
    }

    /**
     * Die Methode createTableHeadlineEnd() erzeugt das Ende eines Tabellenkopfes.
     */
    public static void createTableHeadlineEnd() {
        Writer.write(writer,Text.BLANK_08);
        Writer.write(writer,XML.TABLE_ROW_END);
        Writer.write(writer,Text.BLANK_06);
        Writer.write(writer,XML.TABLE_HEADLINE_END);
        Writer.write(writer,Text.BLANK_06);
        Writer.write(writer,XML.TABLE_BODY_START);
    }

    /**
     * Die Methode createTableHeadlineItem() erzeugt einen Eintrag in die Tabellenüberschrift.
     */
    public static void createTableHeadItem(String item) {
        Writer.write(writer,Text.BLANK_10);
        Writer.write(writer,XML.TABLE_HEADITEM_START);
        Writer.write(writer,item);
        Writer.write(writer,XML.TABLE_HEADITEM_END);
    }

    /**
     * Die Methode createTableHeadItem() erzeugt eine Row in der Tabelle
     */
    public static void createTableItem(String item) {
        Writer.write(writer,Text.BLANK_10);
        Writer.write(writer,XML.TABLE_ITEM_START);
        Writer.write(writer,item);
        Writer.write(writer,XML.TABLE_ITEM_END);
    }

    /**
     * Die Methode createTablelineStart() beginnt eine Tabellenzeile.
     */
    public static void createTablelineStart() {
        Writer.write(writer,Text.BLANK_08);
        Writer.write(writer,XML.TABLE_ROW_START);
    }

    /**
     * Die Methode createTablelineEnd() beendet eine Tabellenzeile.
     */
    public static void createTablelineEnd() {
        Writer.write(writer,Text.BLANK_08);
        Writer.write(writer,XML.TABLE_ROW_END);
    }

    /**
     * Die Methode createTableCaption() erzeugt eine Tabellen-Titelzeile.
     * @param line übergebene Zeile
     */
    public static void createTableCaption(String line) {
        Writer.write(writer, Text.BLANK_08);
        Writer.write(writer,XML.TABLE_CAPTION_START);
        Writer.write(writer,line);
        Writer.write(writer,XML.TABLE_CAPTION_END);
    }


}
