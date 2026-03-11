package de.domain.xdoc.process;

import de.domain.xdoc.character.Text;
import de.domain.xdoc.create.TableCreator;

/**
 * Die Klasse TableProcessor verarbeitet übergebene Zeilen, um Tabellen hieraus zu erstellen.
 */
public class TableProcessor {

    /**
     * Die Methode createTableHeadline() erzeugt eine Tabellenüberschrift durch Aufruf der entsprechenden Creator-
     * Methoden. Dabei wird die übergebene Zeile aufgesplittet und die einzelnen Spalten werden
     * jeweils als Item verarbeitet.
     * @param line die zu übergebende Zeile
     */
    static void createTableHeadline(String line) {
        String[] items = line.split(Text.TABLE_ROW_DELIMITER);
        for (String item : items) {
            item = item.replaceAll(Text.BLANK_END, Text.EMPTY);
            item = item.replaceAll(Text.BLANK_START, Text.EMPTY);
            if (!item.equals(Text.EMPTY)) {
                TableCreator.createTableHeadItem(item);
            }
        }
    }

    /**
     * Die Methode createTableline erzeugt eine Tabellenzeile durch Eintragen einer oder mehrerer
     * Tabelleneinträge.
     * @param line übergebene Zeile
     */
    static void createTableline(String line) {
        String[] items = line.split(Text.TABLE_ROW_DELIMITER);
        for (String item : items) {
            item = item.replaceAll(Text.BLANK_END, Text.EMPTY);
            item = item.replaceAll(Text.BLANK_START, Text.EMPTY);
            if (!item.equals(Text.EMPTY)) {
                TableCreator.createTableItem(item);
            }
        }
    }

    /**
     * Die Methode createTableCaption() erzeugt eine Titelzeile zu der Tabelle.
     * @param line übergebene Zeile
     */
    static void createTableCaption(String line) {
        line = line.replaceAll(Text.BLANK_END, Text.EMPTY);
        TableCreator.createTableCaption(line);
    }

    /**
     * Die Methode createTable() ist die Hauptmethode des TableProcessors. Sie erzeugt den Beginn einer Tabelle, dann
     * ihre Überschrift und dann die Tabelleneinträge. Abschließend wird eine Tabellenbeschreibung und das Tabellen-
     * ende gescrieben.
     * @param isTableStart kennzeichnet den Beginn einer Tabelle
     * @param isTableHead kennzeichnet den Beginn eines Tabellen-Kopfs
     * @param isTableHeadline kennzeichnet den Tabellen-Kopf
     * @param isTableItem kennzeichnet ein Tabellen-Element
     * @param isTableCaption kennzeichnet die Tabellen-Beschreibung
     * @param isTableEnd kennzeichnet das Tabellen-Ende
     * @param line kennzeichnet die übergebene Zeile
     */
    public static void createTable(boolean isTableStart, boolean isTableHead, boolean isTableHeadline,
                                   boolean isTableItem, boolean isTableCaption, boolean isTableEnd, String line) {
        // Start der Tabelle
        if (isTableStart) TableCreator.createTableStart();

        // Erzeugen der Überschrift
        if (isTableHead) TableCreator.createTableHeadlineStart();
        if (isTableHeadline) createTableHeadline(line);
        if (isTableHeadline) TableCreator.createTableHeadlineEnd();

        // Erzeugen einer Tabellenzeile
        if (isTableItem) TableCreator.createTablelineStart();
        if (isTableItem) createTableline(line);
        if (isTableItem) TableCreator.createTablelineEnd();

        // Erzeugen einer Tabellenbeschreibung
        if (isTableCaption) createTableCaption(line);

        // Ende der Tabelle
        if (isTableEnd) TableCreator.createTableEnd();
    }


}
