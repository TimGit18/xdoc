package de.domain.xdoc.create;

import de.domain.xdoc.access.Writer;
import de.domain.xdoc.character.Text;
import de.domain.xdoc.character.XML;

/**
 * Die Klasse ListCreator erzeugt Listenstrukturen.
 */
public class NumberListCreator extends TextCreator {

    /**
     * Die Methode createListEnd() erzeugt das Ende einer einfachen Liste.
     */
    public static void createNumberListEnd() {
        Writer.write(writer, Text.BLANK_04);
        Writer.write(writer, XML.NUMBER_LIST_END);
        Writer.write(writer, Text.NEW_LINE);
    }

     /**
     * Die Methode createListStart() erzeugt den Anfang einer Liste.
     */
    public static void createNumberListStart() {
        Writer.write(writer,Text.BLANK_04);
        Writer.write(writer,XML.NUMBER_LIST_START);
    }

}
