package de.domain.xdoc.create;

import de.domain.xdoc.access.Writer;
import de.domain.xdoc.character.Text;
import de.domain.xdoc.character.XML;

public class ScriptsCreator extends TextCreator {

    /**
     * Die Methode createScriptsStart() erzeugt den Anfang einer Script-Area.
     */
    public static void createScriptsStart() {
        Writer.write(writer, Text.NEW_LINE);
        Writer.write(writer, Text.BLANK_02);
        Writer.write(writer, XML.SCRIPTS_START);
    }

    /**
     * Die Methode createScriptItem() erzeugt einen Script-Eintrag in der Script-Area.
     */
    public static void createScriptItem(String link) {
        Writer.write(writer, Text.BLANK_04);
        Writer.write(writer, XML.SCRIPT_START);
        Writer.write(writer, link);
        Writer.write(writer, XML.SCRIPT_END);
    }

    /**
     * Die Methode createScriptsEnd() erzeugt das Ende einer Script-Area.
     */
    public static void createScriptsEnd() {
        Writer.write(writer, Text.BLANK_02);
        Writer.write(writer, XML.SCRIPTS_END);
    }



}
