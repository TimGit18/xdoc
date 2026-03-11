package de.domain.xdoc.model;

import de.domain.xdoc.check.TextChecker;

/**
 * Die Klasse TableModel repräsentiert das Modell eines Inhaltsverzeichnisses.
 */
public class TableOfContentModel {

    // Zustandsvariablen
    private static boolean isTableOfContent = false;
    private static boolean isTableOfContentStart;
    private static boolean isTableOfContentItem = false;

    /**
     * Die Methode setModel() setzt das Inhaltsverzeichnis-Modell.
     * @param line übergebene Zeile
     */
    public static void setModel(String line){

        // Überprüfung des Inhaltsverzeichnisses (Inhaltselement, Start und Ende)
        isTableOfContentStart = TextChecker.checkTableOfContentStart(line);
        if (isTableOfContentStart) isTableOfContent = true;
        if (isTableOfContent && TextChecker.checkBoldHeadline(line)) isTableOfContentStart = false;
        if (isTableOfContent && TextChecker.checkAlphaNumStart(line) && !isTableOfContentStart)
            isTableOfContentItem = true;
    }

    // Getter

    public static boolean isTableOfContent() {
        return isTableOfContent;
    }

    public static boolean isTableOfContentStart() {
        return isTableOfContentStart;
    }

    public static boolean isTableOfContentItem() {
        return isTableOfContentItem;
    }
}
