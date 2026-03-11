package de.domain.xdoc.process;

import de.domain.xdoc.create.CodeboxCreator;

/**
 * Die Klasse CodeboxProcessor erzeugt eine Codebox bzw. eine Codeline.
 */
public class CodeboxProcessor {

    /**
     * Die Methode createCodebox() erzeugt eine Codebox mit Anfang und Ende sowie eine Codeline
     * @param isCodeboxStart kennzeichnet den Anfang einer Codebox
     * @param isCodeboxEnd kennzeichnet das Ende einer Codebox
     * @param isCodebox kennzeichnet eine Codebox
     * @param isCodeline kennzeichnet eine Codeline
     * @param line ist die übergebene Zeile
     */
    public static void createCodebox(boolean isCodeboxStart, boolean isCodeboxEnd, boolean isCodebox, boolean isCodeline,
                                     String line) {
        if (isCodeboxStart) CodeboxCreator.createCodeboxStart();
        if (isCodeboxEnd) CodeboxCreator.createCodeboxEnd();
        if (isCodebox) CodeboxCreator.createCodeboxLine(line);
        if (isCodeline) CodeboxCreator.createCodeLine(line);

    }
}
