package de.domain.xdoc.check;

import de.domain.xdoc.character.Text;

/**
 * Die Klasse TextChecker überprüft verschiedene Strukturelemente des Dokuments. Diese Klasse schreibt keine Resultate,
 * sondern ermittelt nur Tatsachen, die sich aus der Struktur des Dokuments ergeben.
 */
public class TextChecker {

    /**
     * Die Methode checkAbstract() prüft, ob eine übergebene Zeile zu dem Abstract gehört. Ein Abstrakt beginnt immer
     * in der dritten Zeile und endet mit der ersten leeren Zeile.
     * @param line ist die übergebene Zeile
     * @param isAbstract ist der übergebene Status
     * @param number ist die übergebene Zeilennummer
     * @return isAbstract
     */
    public static Boolean checkAbstract(String line, Boolean isAbstract, Integer number) {

        // Ein Abstract beginnt mit der dritten Zeile
        if (number.equals(3)) isAbstract = true;

        // Falls nach dem Abstract eine Leerzeile auftaucht, so endet der Abstract
        if ((isAbstract) && checkBlankline(line)) isAbstract = false;

        return isAbstract;
    }

    /**
     * Die Methode createAbstractEnd() überprüft, ob das Ende eines Abstracts vorliegt.
     * @param isAbstract kennzeichnet einen Abstract
     * @param isBlankline kennzeichnet eine Leerzeile
     * @return isAbstractEnd
     */
    public static boolean checkAbstractEnd(boolean isAbstract, boolean isBlankline) {
        boolean isAbstractEnd;
        isAbstractEnd = isAbstract && isBlankline;
        return isAbstractEnd;
    }

    /**
     * Die Methode checkAlphaNumStart() überprüft, ob eine Zeile mit einem Alphanumerischen Zeichen [a-zA-Z_0-9]
     * beginnt.
     * @param line die zu �bergebende Zeile
     * @return Boolean
     */
    public static Boolean checkAlphaNumStart(String line) {
        return (line.matches(Text.WORD_CHARACTER) || line.matches(Text.UMLAUT_CHARACTER));
    }

    /**
     * Die Methode checkBlankLine() überprüft, ob eine Zeile nur aus Leerzeichen (Space Characters) besteht.
     * @param line die zu übergebende Zeile
     * @return Boolean
     */
    public static Boolean checkBlankline(String line) {
        return line.matches(Text.BLANK_LINE);
    }

    /**
     * Die Methode checkBoldline() überprüft, ob die übergebene Zeile eine Fettdruckzeile ist.
     * @param line übergebene Zeile
     * @return isBoldline
     */
    public static Boolean checkBoldline(String line) {
        boolean isBoldline = false;
        if (line.matches(Text.COLON_START_LINE)) isBoldline =true;
        return isBoldline;
    }

    /**
     * Die Methode checkBoldline() überprüft, ob die zu übergebende Zeile aus mehreren Gleichheitszeichen besteht.
     * beginnt.
     * @param line die zu übergebende Zeile
     * @return Boolean
     */
    public static Boolean checkBoldHeadline(String line) {
        return line.matches(Text.EQUALS_SIGN_START);
    }

    /**
     * Die Methode checkCharline() überprüft, ob eine Zeile aus alphabetischen Zeichen besteht.
     * @param line ist die übergebene Zeile
     * @return isCharline
     */
    public static Boolean checkCharline(String line) {
        return (line.matches(Text.WORD_CHARACTER)
             || line.matches(Text.PARENTHESIS_CHAR)
             || line.matches(Text.DOUBLE_QUOTE_CHAR)
             || line.matches(Text.SINGLE_QUOTE_CHAR)
             || line.matches(Text.HYPHEN_CHAR)
        );
    }

    /**
     * Die Methode checkHeadline() prüft, ob die übergebene Zeile eine Überschrift darstellt. Nur die erste Zeile eines
     * Dokuments ist eine Überschrift, ansonsten nicht. Wenn schon eine Überschrift da war, dann ist es die aktuelle
     * Zeile nicht.
     * @param isHeadline Status, ob die Zeile eine Überschrift ist
     * @param lineNumber Zeilennummer des Dokuments
     * @return isHeadline
     */
    public static Boolean checkHeadline(Boolean isHeadline, int lineNumber) {

        // Die Zeile nach der Überschrift ist keine mehr
        if (isHeadline) isHeadline = false;

        // Die erste Zeile ist definitionsgemäß eine Überschrift
        if (lineNumber == 1) isHeadline = true;

        return isHeadline;
    }

    /**
     * Die Methode checkListItem() überprüft, ob eine übergebene Zeile einen Listeneintrag darstellt.
     * @param line übergebene Zeile
     * @return isListItem
     */
    public static Boolean checkListItem(String line) {
        boolean isListItem = false;
        if (line.matches(Text.LIST_ITEM)) isListItem = true;
        return isListItem;
    }

    /**
     * Die Methode checkNumberListItem() überprüft, ob eine übergebene Zeile einen nummerierten Listeneintrag
     * darstellt.
     * @param line übergebene Zeile
     * @return isNumberListItem
     */
    public static Boolean checkNumberListItem(String line) {
        boolean isNumberListItem = false;
        if (line.matches(Text.NUMBER_LIST_ITEM)) isNumberListItem = true;
        return isNumberListItem;
    }

    /**
     * Die Methode checkNewLine() untersucht, ob die übergebende Zeile einem newLine-Character entspricht.
     * @param line die zu untersuchende Zeile
     * @return Boolean
     */
    public static Boolean checkNewLine(String line) {
        boolean isNewLine = false;
        if (line.matches(Text.NEW_LINE)) isNewLine = true;

        return isNewLine;
    }

    /**
     * Die Methode checkTableOfContentStart() überprüft, ob ein Inhaltsverzeichnis beginnt.
     * @param line die zu übergebende Zeile
     * @return Boolean
     */
    public static Boolean checkTableOfContentStart(String line) {
        boolean isTableOfContentStart = false;
        if (line.matches(Text.TABLE_OF_CONTENT_START)) isTableOfContentStart = true;
        return isTableOfContentStart;
    }
}
