package de.domain.xdoc.model;

import de.domain.xdoc.check.TextChecker;

/**
 * Die Klasse ListModel repräsentiert das Modell einer einfachen Liste über Zustandsvariablen.
 */

public class ListModel {

    // Zustandsvariablen
    private static boolean isListItem;
    private static boolean isListCandidate;
    private static boolean isList;

    /**
     * Die Methode isListItem() gibt den Wert der entsprechenden Variablen zurück.
     * @return isListItem
     */
    public static boolean isListItem() {
        return isListItem;
    }

    /**
     * Die Methode isListCandidate() gibt den Wert der entsprechenden Variablen zurück.
     * @return isListCandidate
     */
    public static boolean isListCandidate() {
        return isListCandidate;
    }

    /**
     * Die Methode isList() gibt den Wert der entsprechenden Variablen zurück.
     * @return isList
     */
    public static boolean isList() {
        return isList;
    }

    /**
     * Die Methode setModel() initialisiert das Modell der einfachen Liste. Zuerst wird geprü0
     * ft, ob die übergebene
     * Zeile ein Listeneintrag darstellt. Anschließend wird geprüft, ob ein Listenkandidat vorliegt oder eine
     * tatsächliche Liste.
     * @param isBlankline kennzeichnet eine Leerzeile
     * @param line übergebene Zeile
     */
    public static void setModel(boolean isBlankline, String line) {
        isListItem = TextChecker.checkListItem(line);
        if (isBlankline) isListCandidate = true;
        if (isListItem) isList = true;
    }

    /**
     * Die Methode setIsListCandidate() setzt im Modell die entsprechende Variable.
     * @param isListCandidate kennzeichnet einen Listenkandidaten
     */
    public static void setIsListCandidate(boolean isListCandidate) {
        ListModel.isListCandidate = isListCandidate;
    }

    /**
     * Die Methode setIsList() setzt im Modell die entsprechende Variable.
     * @param isList kennzeichnet eine Liste
     */
    public static void setIsList(boolean isList) {
        ListModel.isList = isList;
    }

}
