package de.domain.xdoc.model;

import de.domain.xdoc.check.SubheadlineChecker;

/**
 * Die Klasse SubheadlineModel repräsentiert das Model einer Teilüberschrift.
 */
public class SubheadlineModel {

    // State variables
    private static boolean isSubheadlineItem;
    private static boolean isSubheadlineCandidate;
    private static String subheadlineCandidate = "";

    // Sets the model
    public static void setModel(String line, int linenumber) {
        isSubheadlineCandidate = SubheadlineChecker.checkSubheadlineCandidate(line, isSubheadlineCandidate);
        if (isSubheadlineCandidate) subheadlineCandidate = line;
        isSubheadlineItem = SubheadlineChecker.checkSubheadlineItem(line, subheadlineCandidate);
        if (linenumber == 2) isSubheadlineItem = false;
    }

    // Getter
    public static boolean isSubheadlineItem() {
        return isSubheadlineItem;
    }

    public static boolean isSubheadlineCandidate() {
        return isSubheadlineCandidate;
    }

    public static String getSubheadlineCandidate() {
        return subheadlineCandidate;
    }

}
