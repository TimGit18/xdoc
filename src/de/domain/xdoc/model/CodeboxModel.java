package de.domain.xdoc.model;

import de.domain.xdoc.check.CodeboxChecker;

/**
 * Die Klasse CodeboxModel repräsentiert das Modell einer Codebox.
 */
public class CodeboxModel {

    // Zustandsvariablen
    private static boolean isCodeline;
    private static boolean isCodeboxLimit;
    private static boolean isCodebox;
    private static boolean isCodeboxEnd;
    private static boolean isCodeboxStart;

    /**
     * Die Methode setModel() setzt die Parameter des Modells in Abhängigkeit des Checkers und
     * und von anderen Parametern.
     * @param line übergebene Textzeile
     */
    public static void setModel(String line) {
        isCodeline = CodeboxChecker.checkCodeline(line);
        isCodeboxLimit = CodeboxChecker.checkCodeboxLimit(line);
        if (isCodeboxLimit && isCodebox) isCodeboxEnd = true;
        if (isCodeboxStart) isCodebox = true;
        if (isCodeboxLimit && !isCodebox) isCodeboxStart = true;
        if (isCodebox) isCodeboxStart = false;
        if (isCodeboxEnd) isCodebox = false;
        if (isCodeboxEnd && TextModel.isBlankline()) isCodeboxEnd = false;
    }

    // Getter
    public static boolean isCodeline() {
        return isCodeline;
    }

    public static boolean isCodebox() {
        return isCodebox;
    }

    public static boolean isCodeboxEnd() {
        return isCodeboxEnd;
    }

    public static boolean isCodeboxStart() {
        return isCodeboxStart;
    }

    public static boolean isCodeboxLimit() {
        return isCodeboxLimit;
    }
}
