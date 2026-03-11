package de.domain.xdoc.create;

import de.domain.xdoc.access.Writer;
import de.domain.xdoc.character.Text;
import de.domain.xdoc.character.XML;

/**
 * Die Klasse HyperLinkCreator stellt Methoden bereit, um Hyperlinks zu erzeugen.
 */
public class HyperLinkCreator extends TextCreator {

    /**
     * Die Methode createHyperLinksStart() erzeugt den Anfang einer Links-Area.
     */
    public static void createHyperLinksStart() {
        Writer.write(writer, Text.NEW_LINE);
        Writer.write(writer, Text.BLANK_04);
        Writer.write(writer, XML.HYPER_LINKS_START);
    }

    /**
     * Die Methode createHyperLinkItem() erzeugt einen benannten Eintrag in der Links-Area.
     */
    public static void createHyperLinkItem(String line) {
        String name = line.replaceAll(Text.LINK_LINE_END, Text.EMPTY);
        String link = line.replaceAll(Text.LINK_LINE_START, Text.EMPTY);
        Writer.write(writer, Text.BLANK_06);
        Writer.write(writer, XML.HYPER_LINK_START);
        Writer.write(writer, name);
        Writer.write(writer, Text.TAG_END_QUOTE);
        Writer.write(writer, link);
        Writer.write(writer, XML.HYPER_LINK_END);
    }

    /**
     * Die Methode createHyperLinksEnd() erzeugt das Ende einer Links-Area.
     */
    public static void createHyperLinksEnd() {
        Writer.write(writer, Text.BLANK_04);
        Writer.write(writer, XML.HYPER_LINKS_END);
    }

}
