package de.domain.xdoc.create;

import de.domain.xdoc.access.Writer;
import de.domain.xdoc.character.Text;
import de.domain.xdoc.character.XML;

public class MainCreator extends TextCreator {

    /**
     * Die Methode createMainEnd() erzeugt das Ende der Navigationsleiste.
     */
    public static void createMainEnd() {
        Writer.write(writer, Text.BLANK_02);
        Writer.write(writer, XML.MAIN_END);
    }

    /**
     * Die Methode createMainStart() erzeugt den Start der Navigationsleiste.
     */
    public static void createMainStart() {
        Writer.write(writer, Text.NEW_LINE);
        Writer.write(writer, Text.BLANK_02);
        Writer.write(writer, XML.MAIN_START);
    }

    /**
     * Die Methode createMainTopic() erzeugt einen Eintrag in der Navigationsleiste.
     */
    public static void createMainTopic(String name, String link) {
        Writer.write(writer, Text.BLANK_04);
        Writer.write(writer,XML.MAIN_TOPIC_START);
        Writer.write(writer, name);
        Writer.write(writer, Text.QUOTE);
        Writer.write(writer, XML.LINK);
        Writer.write(writer, link);
        Writer.write(writer,Text.QUOTE);
        Writer.write(writer,Text.TAG_END_CLOSE_CRNL);
    }


}
