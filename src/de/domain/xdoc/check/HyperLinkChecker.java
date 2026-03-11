package de.domain.xdoc.check;

import de.domain.xdoc.character.Text;

/****************************************************************************************
 * Die Klasse HyperLinkChecker überprüft, ob ein Hyperlink-Verweis in der Datei vorliegt.
 ***************************************************************************************/
public class HyperLinkChecker extends TextChecker {

    /******************************************************************************************
     * Die Methode checkHyperLinkLine() überprüft, ob es sich um eine Zeile mit einem Hyperlink
     * handelt.
     * @param line die zu �bergebende Zeile
     * @return isImageLine
     *******************************************************************************/
    public static Boolean checkHyperLinkLine(String line) {
        Boolean isHyperLinkLine = false;
        if (line.matches(Text.LINK_LINE)) isHyperLinkLine = true;
        return isHyperLinkLine;
    }

}