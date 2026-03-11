package de.domain.xdoc.create;

import de.domain.xdoc.access.Writer;
import de.domain.xdoc.character.Text;
import de.domain.xdoc.character.XML;



public class AbstractCreator extends TextCreator {

    /**
     * Die Methode createAbstract() erzeugt den Abstract. Zunächst werden aus dem Text-Abstract alle Zeilenumbr�che
     * entfernt, und und es wird eine einzige Byte-Kette erzeugt. Diese wird dann in den Inhalt des Abstracts
     * geschrieben. Am Ende des Inhalts wird noch einmal ein Zeilenumbruch eingefügt.
     * @param line ist die übergebene Zeile
     */
    public static void createAbstract(String line) {
        Writer.write(writer, Text.BLANK_06);
        Writer.write(writer, line);
        Writer.write(writer, Text.NEW_LINE);
    }

    /**
     * Die Methode createAbstractStart() erzeugt den Anfang eines Abstracts mit einer Einrückung.
     */
    public static void createAbstractStart() {
        Writer.write(writer, Text.BLANK_04);
        Writer.write(writer, XML.ABSTRACT_START);
    }

    /**
     * Die Methode createAbstractEnd() erzeugt das Ende eines Abstracts mit einer Einrückung.
     */
    public static void createAbstractEnd() {
        Writer.write(writer, Text.BLANK_04);
        Writer.write(writer, XML.ABSTRACT_END);
        Writer.write(writer, Text.NEW_LINE);
    }


}
