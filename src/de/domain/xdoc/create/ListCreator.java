package de.domain.xdoc.create;

import de.domain.xdoc.access.Writer;
import de.domain.xdoc.character.Text;
import de.domain.xdoc.character.XML;

/**
 * Die Klasse ListCreator erzeugt Listenstrukturen.
 */
public class ListCreator extends TextCreator {

    /**
     * Die Methode createListEnd() erzeugt das Ende einer einfachen Liste.
     */
    public static void createListEnd() {
        Writer.write(writer, Text.BLANK_04);
        Writer.write(writer, XML.LIST_END);
        Writer.write(writer, Text.NEW_LINE);
    }

    /**
     *  Die Methode createListItem() erzeugt einen Eintrag in einer einfachen und nummerierten Liste.
     * @param listitem der Listeneintrag
     */
    public static void createListItem(String listitem) {
        Writer.write(writer, Text.BLANK_06);
        Writer.write(writer, XML.LIST_ITEM_START);
        Writer.write(writer,listitem);
        Writer.write(writer,XML.LIST_ITEM_END);
    }

    /**
     * Die Methode createListStart() erzeugt den Anfang einer einfachen Liste.
     */
    public static void createListStart() {
        Writer.write(writer,Text.BLANK_04);
        Writer.write(writer,XML.LIST_START);
    }

}
