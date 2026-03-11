package de.domain.xdoc.create;

import de.domain.xdoc.access.Writer;
import de.domain.xdoc.character.Text;
import de.domain.xdoc.character.XML;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ImageCreator extends TextCreator {

    private static Logger LOG = LogManager.getLogger(ImageCreator.class.getName());

    /**
     * Die Methode createImageStart() erzeugt den Beginn einer Bildsequenz.
     */
    public static void createImageStart() {
        Writer.write(writer, Text.BLANK_04);
        Writer.write(writer, XML.IMAGE_START);
    }

    /**
     * Die Methode createImageLink() erzeugt den Verweis auf eine Bilddatei.
     * @param line übergebene Zeile
     * @param localImagePath Lokaler Bild-Pfad
     * @param imagePath
     */
    public static void createImageLink(String line, String localImagePath, String imagePath) {
        LOG.trace("Image-Pfad:  " + imagePath);
        line = line.replaceAll(Text.IMAGE_REF, Text.EMPTY);
        line = line.replaceAll(Text.BLANK_END, Text.EMPTY);
        Writer.write(writer, Text.BLANK_06);
        Writer.write(writer, XML.IMAGE_LINK_START);
        Writer.write(writer, localImagePath);
        Writer.write(writer, line);
        Writer.write(writer, Text.QUOTE);
        Writer.write(writer, Text.BLANK_01);
        Writer.write(writer, XML.IMAGE_SOURCE_START);
        Writer.write(writer, imagePath);
        Writer.write(writer, line);
        Writer.write(writer, Text.TAG_END_QUOTE_CLOSE_CRNL);
    }

    /**
     * Die Methode createImageCaption() erzeugt eine Titelzeile zu dem Bild.
     * @param line übergebene Zeile mit Beschreibung
     */
    public static void createImageCaption(String line) {
       Writer.write(writer, Text.BLANK_06);
       Writer.write(writer, XML.IMAGE_CAPTION_START);
       line = line.replaceAll(Text.BLANK_END, Text.EMPTY);
       Writer.write(writer, Text.BLANK_08);
       Writer.write(writer, line);
       Writer.write(writer, Text.NEW_LINE);
       Writer.write(writer, Text.BLANK_06);
       Writer.write(writer, XML.IMAGE_CAPTION_END);
    }

    public static void createImageEnd() {
        Writer.write(writer, Text.BLANK_04);
        Writer.write(writer, XML.IMAGE_END);
    }
}
