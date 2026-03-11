package de.domain.xdoc.process;

import de.domain.xdoc.create.HyperLinkCreator;

/**
 * Die Klasse HyperLinkProcessor stellt Methoden zur Erzeugung von Hyperlinks bereit.
 */
public class HyperLinkProcessor {

    /**
     * Die Methode createHyperLinksEnd() erzeugt das Ende einer Hyperlinks-Area.
     * @param isHyperLinkList kennzeichnet eine Hyperlinks-Liste
     * @param isBlankline kennzeichnet eine Leerzeile
     * @return isHyperLinkList
     */
    public static boolean createHyperLinksEnd(boolean isHyperLinkList, boolean isBlankline) {
        if (isHyperLinkList && isBlankline) HyperLinkCreator.createHyperLinksEnd();
        if (isBlankline) isHyperLinkList = false;
        return isHyperLinkList;
    }

    /**
     * Die Methode createHyperLinksStart() erzeugt den Anfang einer Hyperlinks-Area.
     * @param isHyperLinkList kennzeichnet eine Hyperlinks-Liste
     * @param isHyperLinkCandidate kennzeichnet einen Hyperlinks-Kandidaten
     * @return isHyperLinkCandidate
     */
    public static boolean createHyperLinksStart(boolean isHyperLinkList, boolean isHyperLinkCandidate) {
        if (isHyperLinkList && isHyperLinkCandidate) HyperLinkCreator.createHyperLinksStart();
        if (isHyperLinkList) isHyperLinkCandidate = false;
        return isHyperLinkCandidate;
    }

    /**
     * Die Methode createHyperLinksItem() erzeugt den Eintrag in eine Hyperlinks-Area.
     * @param isHyperLinkItem kennzeichnet einen Eintrag einer Hyperlink-Liste
     * @param line ist die übergebene Zeile
     */
    public static void createHyperLinksItem(boolean isHyperLinkItem, String line) {
        if (isHyperLinkItem) HyperLinkCreator.createHyperLinkItem(line);
    }

}
