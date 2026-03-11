package de.domain.xdoc.model;

import de.domain.xdoc.check.TextChecker;

/**
 * Die Klasse TextModel repräsentiert das Model der Textbausteine.
 */
public class TextModel {

    // Zustandsvariablen
    private static boolean isBlankline;
    private static boolean isBoldline;
    private static boolean isCharline;
    private static boolean isText;
    private static boolean isTextArea;
    private static boolean isTextCandidate;
    private static boolean isTextEnd;
    private static boolean isTextLine;
    private static boolean isTextStart;

    /**
     * Die Methode isBlankline() gibt den Wert der entsprechenden Zustandsvariablen aus.
     * @return isBlankline
     */
    public static boolean isBlankline() {
        return isBlankline;
    }

    /**
     * Die Methode isBoldline() gibt den Wert der entsprechenden Zustandsvariablen aus.
     * @return isBoldline
     */
    public static boolean isBoldline() {
        return isBoldline;
    }

    /**
     * Die Methode isText() gibt den Wert der entsprechenden Zustandsvariablen aus.
     * @return isText
     */
    public static boolean isText() {
        return isText;
    }

    /**
     * Die Methode isTextStart() gibt den Wert der entsprechenden Zustandsvariablen aus.
     * @return isTextStart
     */
    public static boolean isTextStart() {
        return isTextStart;
    }

    /**
     * Die Methode isTextEnd() gibt den Wert der entsprechenden Zustandsvariablen aus.
     * @return isTextEnd
     */
    public static boolean isTextEnd() {
        return isTextEnd;
    }

    /**
     * Die Methode setModel() initialisiert das Text-Modell.
     * @param line übergebene Zeile
     */
    public static void setModel(String line) {
        isBlankline = TextChecker.checkBlankline(line);
        isBoldline = TextChecker.checkBoldline(line);
        isCharline = TextChecker.checkCharline(line);
    }

    /**
     * Die Methode setIsText() legt fest, wann ein Text Inhalt enth�lt. N�mlich wenn man sich
     * im Text-Bereich befindet und man auf eine echte Texzeile st�sst.
     */
    public static void setIsText() {
        isText = isTextLine && isTextArea;
    }

    /**
     * Die Methode setIsTextCandidate() legt fest, wann ein Text beginnen kann. Er kann beginnen,
     * falls eine Teilüberschrift vorliegt oder falls eine Leerzeile vorliegt, aber es ist kein Abschnittsende
     * ist.
     */
    public static void setIsTextCandidate() {
        isTextCandidate = SubheadlineModel.isSubheadlineItem() || (isBlankline && !SectionModel.isSectionEnd());
    }

    /**
     * Die Methode setIsTextEndAndArea() legt fest, wann ein Text endet, nämlich dann
     * wenn der Text-Bereich auf eine Leerzeile trifft, dann wird das Text-Ende markiert.
     */
    public static void setIsTextEndAndArea() {
        if (isBlankline && isTextArea) {
            isTextEnd = true;
            isTextArea = false;
        } else isTextEnd = false;
    }

    /**
     * Die Methode setIsTextLine() legt fest, wann eine Textzeile vorliegt. Eine Textzeile ist eine
     * Zeile, die durch keine der anderen bekannten  Auszeichnungsstrukturen gekennzeichnet ist
     * und mit einem Text beginnt
     */
    public static void setIsTextLine() {
        isTextLine = !isBlankline &&
                !CodeboxModel.isCodeline() &&
                !CodeboxModel.isCodebox() &&
                !CodeboxModel.isCodeboxLimit() &&
                !ImageModel.isImageLine() &&
                !ImageModel.isImageDescription() &&
                !TableModel.isTableCaption() &&
                !SequenceModel.isSequenceHead() &&
                !HyperLinkModel.isHyperLinkItem() &&
                !HeadlineModel.isHeadline() &&
                !AbstractModel.isAbstract() &&
                isCharline;
    }

    /**
     * Die Methode setIsTextStartAndArea() definiert, wann der Text startet. Er startet, wenn
     * ein Text-Kandidat erkannt wurde und bereits ein Text vorliegt
     */
    public static void setIsTextStartAndArea() {
        if (isTextCandidate && isTextLine) {
            isTextStart = true;
            isTextArea = true;
        } else isTextStart = false;
    }
}
