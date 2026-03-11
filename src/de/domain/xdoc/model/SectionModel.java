package de.domain.xdoc.model;

/**
 * Die Klasse SectionModel repräsentiert das Modell eines Abschnitts
 */
public class SectionModel {

    // Zustandsvariablen
    private static boolean isSectionEnd;
    private static boolean isSectionEndCandidate;

    /**
     * Die Methode setModel() setzt das Modell.
     */
    public static void setModel() {
        isSectionEnd = TextModel.isBlankline() && isSectionEndCandidate;
        isSectionEndCandidate = TextModel.isBlankline();
    }

    /**
     * Die Methode isSectionEnd() gibt den Wert der entsprechenden Zustandsvariablen aus.
     * @return isSectionEnd
     */
    public static boolean isSectionEnd() {
        return isSectionEnd;
    }

}
