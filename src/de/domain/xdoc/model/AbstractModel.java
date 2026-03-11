package de.domain.xdoc.model;

import de.domain.xdoc.check.TextChecker;

/**
 * Die Klasse AbstractModel repräsentiert das Modell eines Abstracts.
 */
public class AbstractModel {

    // Zustandsvariablen
    private static boolean isAbstract;
    private static boolean isAbstractEnd;

    /**
     * Die Methode setModel() setzt das Modell, indem sie die entsprechenden Methoden des Checkers aufruft.
     * @param line übergebene Zeile
     * @param lineNumber übergebene Zeilennummer
     */
    public static void setModel(String line, int lineNumber) {
        isAbstractEnd = TextChecker.checkAbstractEnd(isAbstract, TextModel.isBlankline());
        isAbstract = TextChecker.checkAbstract(line, isAbstract, lineNumber);
    }

    // Getter
    public static boolean isAbstract() {
        return isAbstract;
    }

    public static boolean isAbstractEnd() {
        return isAbstractEnd;
    }

}
