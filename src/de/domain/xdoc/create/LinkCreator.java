package de.domain.xdoc.create;

import de.domain.xdoc.access.Writer;
import de.domain.xdoc.character.Text;
import de.domain.xdoc.character.XML;

/**
 * Die Klasse LinkCreator stellt Methoden bereit, um Links zu erzeugen
 */

public class LinkCreator extends TextCreator {

    /**
     * Die Methode createHyperLinksStart() erzeugt den Anfang einer HyperLinks-Area.
     */
    public static void createLinksStart() {
        Writer.write(writer, Text.NEW_LINE);
        Writer.write(writer, Text.BLANK_02);
        Writer.write(writer, XML.LINKS_START);
    }

    /**
     * Die Methode createLinksItem() erzeugt einen Eintrag in der Links-Area.
     */
    public static void createLinkItem(String link, String type) {
        Writer.write(writer, Text.BLANK_04);
        Writer.write(writer, XML.LINK_START);
        Writer.write(writer, type);
        Writer.write(writer, Text.TAG_END_QUOTE);
        Writer.write(writer, link);
        Writer.write(writer, XML.LINK_END);
    }

    /**
     * Die Methode createLinksEnd() erzeugt das Ende einer Links-Area.
     */
    public static void createLinksEnd() {
        Writer.write(writer, Text.BLANK_02);
        Writer.write(writer, XML.LINKS_END);
    }
}
