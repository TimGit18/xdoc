package de.domain.xdoc.model;

import de.domain.xdoc.check.TextChecker;

/**
 * Die Klasse NumberListModel repräsentiert das Model einer nummerierten Liste.
 */

public class NumberListModel {

    private static boolean isNumberListItem;
    private static boolean isNumberListCandidate;
    private static boolean isNumberList;

    // private static Logger LOG = LogManager.getLogger(ListModel.class.getName());

    public static boolean isNumberListItem() {
        return isNumberListItem;
    }

    public static void setModel(boolean isBlankline, String line) {
        isNumberListItem = TextChecker.checkNumberListItem(line);
        if (isBlankline) isNumberListCandidate = true;
        if (isNumberListItem) isNumberList = true;
    }

    public static void setIsNumberListCandidate(boolean isNumberListCandidate) {
        NumberListModel.isNumberListCandidate = isNumberListCandidate;
    }

    public static void setIsNumberList(boolean isNumberList) {
        NumberListModel.isNumberList = isNumberList;
    }

    public static boolean isNumberListCandidate() {
        return isNumberListCandidate;
    }

    public static boolean isNumberList() {
        return isNumberList;
    }

}
