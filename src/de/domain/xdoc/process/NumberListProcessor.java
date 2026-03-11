package de.domain.xdoc.process;

import de.domain.xdoc.agent.TextAgent;
import de.domain.xdoc.create.NumberListCreator;
import de.domain.xdoc.model.NumberListModel;

/**
 * Die Klasse ListProcessor verantwortet das Erzeugen von nummerierten Listen-Strukturen.
 */
public class NumberListProcessor {

    /**
     * Die Methode createNumberListEnd() erzeugt das Ende einer nummerierten Liste.
     * Außerdem verändert er das Model der NumberList.
     * @param isBlankline kennzeichnet, ob eine Leerzeile vorliegt
     */
    public static void createNumberListEnd(boolean isBlankline) {
        boolean isNumberList = NumberListModel.isNumberList();
        if (isNumberList && isBlankline) NumberListCreator.createNumberListEnd();
        if (isBlankline) isNumberList = false;
        NumberListModel.setIsNumberList(isNumberList);
    }


    /**
     * Die Methode createNumberList() erzeugt den Anfang und Einträge einer nummerierten Liste.
     * Außerdem verändert er das Model der NumberList.
     * @param line übergebene Zeile
     * @return isListCandidate
     */
    public static void createNumberList(String line) {
        boolean isNumberList = NumberListModel.isNumberList();
        boolean isNumberListCandidate = NumberListModel.isNumberListCandidate();
        boolean isNumberListItem = NumberListModel.isNumberListItem();
        if (isNumberList && isNumberListCandidate) NumberListCreator.createNumberListStart();
        if (isNumberList) isNumberListCandidate = false;
        if (isNumberListItem) TextAgent.createListItem(line);
        NumberListModel.setIsNumberListCandidate(isNumberListCandidate);
    }
}
