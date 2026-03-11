package de.domain.xdoc.check;

import de.domain.xdoc.character.Text;

/*********************************************************************************************************
 * Die Klasse SequenceChecker() stellt Prüfmethoden bereit, mit denen Texte als Sequenzen erkannt werden.
 ********************************************************************************************************/
public class SequenceChecker extends TextChecker {

    /*********************************************************************************************************
     * Die Methode checkSequenceHead() überprüft, ob eine übergebene Zeile den Beginn einer Sequenz darstellt.
     * @param line übergebene Zeile
     * @return isSequenceHead
     *********************************************************************************************************/
    public static boolean checkSequenceHead(String line) {
        Boolean isSequenceHead = false;
        if (line.matches(Text.SEQUENCE_HEAD)) isSequenceHead = true;
        return isSequenceHead;
    }

    /*********************************************************************************************************
     * Die Methode checkSequenceDialogue() überprüft, ob eine übergebene Zeile einen Sequenz-Dialog darstellt.
     * @param line übergebene Zeile
     * @return isSequenceDialogue
     *********************************************************************************************************/
    public static boolean checkSequenceDialogue(String line) {
        Boolean isSequenceDialogue = false;
        if (line.matches(Text.SEQUENCE_DIALOGUE)) isSequenceDialogue = true;
        return isSequenceDialogue;
    }

    /*********************************************************************************************************
     * Die Methode checkSequenceItem() überprüft, ob eine übergebene Zeile einen Sequenz-Eintrag enthält.
     * @param line übergebene Zeile
     * @return isSequenceItem
     *********************************************************************************************************/
    public static boolean checkSequenceItem(String line) {
        Boolean isSequenceItem = false;
        if (line.matches(Text.SEQUENCE_ITEM)) isSequenceItem = true;
        return isSequenceItem;
    }

    /*********************************************************************************************************
     * Die Methode checkSequenceLine() überprüft, ob eine übergebene Zeile eine Sequenz-Zeile darstellt.
     * @param line übergebene Zeile
     * @return isSequenceLine
     *********************************************************************************************************/
    public static boolean checkSequenceLine(String line) {
        Boolean isSequenceLine = false;
        if (line.matches(Text.SEQUENCE_LINE)) isSequenceLine = true;
        return isSequenceLine;
    }

}
