package de.domain.xdoc.process;

import de.domain.xdoc.agent.TextAgent;
import de.domain.xdoc.create.ListCreator;
import de.domain.xdoc.model.ListModel;

/**
 * Die Klasse ListProcessor verantwortet das Erzeugen von Listen-Strukturen
 */
public class ListProcessor {

    /**
     * Die Methode createSimpleListEnd() erzeugt das Ende einer einfachen Liste.
     * @param isBlankline kennzeichnet, ob eine Leerzeile vorliegt
     * @return isList
     */
    public static void createSimpleListEnd(boolean isBlankline) {
        boolean isList = ListModel.isList();
        if (isList && isBlankline) ListCreator.createListEnd();
        if (isBlankline) isList = false;
        ListModel.setIsList(isList);
    }

    /**
     * Die Methode createSimpleList() erzeugt den Anfang und Einträge einer einfachen Liste.
     * @param line übergebene Zeile
     */
    public static void createSimpleList(String line) {
        boolean isList = ListModel.isList();
        boolean isListItem = ListModel.isListItem();
        boolean isListCandidate = ListModel.isListCandidate();
        if (isList && isListCandidate) ListCreator.createListStart();
        if (isList) isListCandidate = false;
        if (isListItem) TextAgent.createListItem(line);
        ListModel.setIsListCandidate(isListCandidate);
    }
}