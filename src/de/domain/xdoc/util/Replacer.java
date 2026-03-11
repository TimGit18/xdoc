package de.domain.xdoc.util;

import de.domain.xdoc.character.Text;
import de.domain.xdoc.character.XML;

public class Replacer {

    public static String replaceAmpersands(String line) {
        line = line.replaceAll(Text.AMPERSAND, XML.AMPERSAND);
        return line;
    }

    public static String replaceAngleBrackets(String line) {
        line = line.replaceAll(Text.LESS_THAN_SIGN, XML.OPEN_ANGLE_BRACKET);
        line = line.replaceAll(Text.GREATER_THAN_SIGN, XML.CLOSE_ANGLE_BRACKET);
        return line;
    }
}
