package de.domain.xdoc.process;

import de.domain.xdoc.create.TextCreator;

/**
 * Die Klasse SubheadlineProcessor sorgt für die Verarbeitung der Teilüberschriften
 */
public class SubheadlineProcessor {

    /**
     * Die Methode createSubheadline() erzeugt eine Teilüberschrift.
     * @param isSubheadlineItem kennzeichnet, ob es sich um eine Teilüberschrift handelt
     * @param subheadlineCandidate übergebene Zeile
     */
    public static void createSubheadline(boolean isSubheadlineItem, String subheadlineCandidate) {
        if (isSubheadlineItem) TextCreator.createSubheadline(subheadlineCandidate);
    }
}
