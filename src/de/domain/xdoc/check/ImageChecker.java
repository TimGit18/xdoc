package de.domain.xdoc.check;

import de.domain.xdoc.character.Text;

/*******************************************************************************
 * Die Klasse ImageChecker überprüft, ob ein Bild-Verweis in der Datei vorliegt.
 ******************************************************************************/
public class ImageChecker extends TextChecker {

    /*******************************************************************************
     * Die Methode checkImageLine() überprüft, ob es sich um eine Bildzeile handelt.
     * @param line die zu übergebende Zeile
     * @return isImageLine
     *******************************************************************************/
    public static Boolean checkImageLine(String line) {
        Boolean isImageLine = false;
        if (line.matches(Text.IMAGE_LINE)) isImageLine = true;
        return isImageLine;
    }

    /********************************************************************************************
     * Die Methode checkImageDescripton() überprüft, ob es sich um eine Bildbeschreibung handelt.
     * @param line die zu übergebende Zeile
     * @param isImage Prüfparameter
     * @return isImageDescription
     ********************************************************************************************/
    public static Boolean checkImageDescription(String line, Boolean isImage) {
        Boolean isImageDescription = false;
        if (line.matches(Text.IMAGE_DESCRIPTION) && isImage) isImageDescription = true;
        return isImageDescription;
    }
}
