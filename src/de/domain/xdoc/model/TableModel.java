package de.domain.xdoc.model;

import de.domain.xdoc.check.TableChecker;

/**
 * Die Klasse TableModel repräsentiert das Modell einer Tabelle.
 */
public class TableModel {

    // Zustandsvariablen
    private static boolean isTableItem;
    private static boolean isTable;
    private static boolean isTableHead;
    private static boolean isTableHeadline;
    private static boolean isTableCandidate;
    private static boolean isTableEnd;
    private static boolean isTableStart;
    private static boolean isTableCaption;

    /**
     * Die Methode setModel() setzt das Tabellen-Modell.
     * @param line
     */
    public static void setModel(String line){
        isTableItem = TableChecker.checkTableItem(line, isTable, isTableHead);
        isTableCandidate = TableChecker.checkTableCandidate(line, isTable, isTableCandidate);
        isTableEnd = TableChecker.checkTableEnd(line, isTable);
        isTable = TableChecker.checkTable(line, isTable, isTableCandidate);
        isTableStart = TableChecker.checkTableStart(line, isTable, isTableCandidate);
        isTableHeadline = TableChecker.checkTableHeadline(line, isTableHead);
        isTableHead = TableChecker.checkTableHead(line, isTableStart, isTableHead);
        isTableCaption = TableChecker.checkTableCaption(line, isTable);
        if (!isTable) isTableItem = false;
    }

    // Getter
    public static boolean isTableItem() {
        return isTableItem;
    }

    public static boolean isTableHead() {
        return isTableHead;
    }

    public static boolean isTableHeadline() {
        return isTableHeadline;
    }

    public static boolean isTableEnd() {
        return isTableEnd;
    }

    public static boolean isTableStart() {
        return isTableStart;
    }

    public static boolean isTableCaption() {
        return isTableCaption;
    }
}
