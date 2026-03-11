package de.domain.xdoc.model;

import de.domain.xdoc.check.HyperLinkChecker;

/**
 * Die Klasse HyperLinkModel repräsentiert das Modell eines Hyperlinks.
 */
public class HyperLinkModel {

    // Statische Zustandsvariablen
    private static boolean isHyperLinkItem;
    private static boolean isHyperLinkCandidate;
    private static boolean isHyperLinkList;

    // Setzen des Modells
    public static void setModel(String line) {
        isHyperLinkItem = HyperLinkChecker.checkHyperLinkLine(line);
        if (TextModel.isBlankline()) isHyperLinkCandidate = true;
        if (isHyperLinkItem) isHyperLinkList = true;
    }

    public static boolean isHyperLinkItem() {
        return isHyperLinkItem;
    }

   public static boolean isHyperLinkCandidate() {
        return isHyperLinkCandidate;
    }

    public static void setIsHyperLinkCandidate(boolean isHyperLinkCandidate) {
        HyperLinkModel.isHyperLinkCandidate = isHyperLinkCandidate;
    }

    public static boolean isHyperLinkList() {
        return isHyperLinkList;
    }

    public static void setIsHyperLinkList(boolean isHyperLinkList) {
        HyperLinkModel.isHyperLinkList = isHyperLinkList;
    }
}
