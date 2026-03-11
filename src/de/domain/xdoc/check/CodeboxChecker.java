package de.domain.xdoc.check;

import de.domain.xdoc.character.Text;

/*****************************************************************************************
 * Die Klasse CodeboxChecker enthält Methoden, um auf Codebox-Strukturen zu prüfen.
 ****************************************************************************************/
public class CodeboxChecker extends TextChecker {

    /*******************************************************************************************
     * Die Methode checkCodeboxLimit() prüft, ob eine übergebene Zeile den Anfang oder das Ende
     * einer Codebox darstellt.
     * @param line übergebene Zeile
     * @return isCodeboxLimit
     *****************************************************************************************/
    public static Boolean checkCodeboxLimit(String line) {
        Boolean isCodeboxLimit = false;
        if (line.matches(Text.CODEBOX)) isCodeboxLimit = true;
        return isCodeboxLimit;
    }

    /*******************************************************************************************
     * Die Methode checkCodeline() prüft, ob eine übergebene Zeile eine Codezeile darstellt.
     * @param line übergebene Zeile
     * @return isCodeboxLimit
     *****************************************************************************************/
    public static Boolean checkCodeline(String line) {
        Boolean isCodeline = false;
        if (line.matches(Text.CODELINE)) isCodeline = true;
        return isCodeline;
    }

}
