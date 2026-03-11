package de.domain.xdoc.create;

import de.domain.xdoc.access.Writer;
import de.domain.xdoc.character.Text;
import de.domain.xdoc.character.XML;
import de.domain.xdoc.util.Replacer;

/**
 * Die Klasse CodeboxCreator erzeugt Code-Strukturen.
 **/
public class CodeboxCreator extends TextCreator {

    /**
     * Die Methode createCodeboxEnd() erzeugt das Ende einer Codebox
     **/
    public static void createCodeboxEnd() {
        Writer.write(writer, Text.BLANK_04);
        Writer.write(writer, XML.CODEBOX_END);
        Writer.write(writer, Text.NEW_LINE);
    }

    /**
     * Die Methode createCodeboxLine erzeugt den Inhalt einer Codebox.
     * @param line übergebene Zeile
     **/
    public static void createCodeboxLine(String line) {
        line = Replacer.replaceAngleBrackets(line);
        Writer.write(writer, Text.BLANK_06);
        Writer.write(writer, line);
        Writer.write(writer, Text.NEW_LINE);
    }

    /**
     * Die Methode createCodeboxStart() erzeugt den Start einer Codebox.
     **/
     public static void createCodeboxStart() {
        Writer.write(writer, Text.BLANK_04);
        Writer.write(writer, XML.CODEBOX_START);
    }

    /**
     * Die Methode createCodeLine() erzeugt eine einzige Codezeile.
     * @param line übergebene Zeile
     **/
    public static void createCodeLine(String line) {
        Writer.write(writer, Text.BLANK_04);
        line = line.replaceAll(Text.CODELINE_START, Text.EMPTY);
        line = line.replaceAll(Text.CODELINE_END, Text.EMPTY);
        line = line.replaceAll(Text.LESS_THAN_SIGN, XML.OPEN_ANGLE_BRACKET);
        line = line.replaceAll(Text.GREATER_THAN_SIGN, XML.CLOSE_ANGLE_BRACKET);
        Writer.write(writer, XML.CODELINE_START);
        Writer.write(writer, line);
        Writer.write(writer, XML.CODELINE_END);
    }

}
