package de.domain.xdoc.model;

import de.domain.xdoc.check.SequenceChecker;

/**
 * Die Klasse SequenceModel repräsentiert das Modell einer Abfolge.
 */
public class SequenceModel {

    // State Variables
    private static boolean isSequenceHead;
    private static boolean isSequence;
    private static boolean isSequenceItem;
    private static boolean isSequenceDialogue;
    private static boolean isSequenceLine;

    // Sets the model
    public static void setModel(String line) {
        isSequenceHead = SequenceChecker.checkSequenceHead(line);
        isSequenceDialogue = SequenceChecker.checkSequenceDialogue(line);
        isSequenceItem = SequenceChecker.checkSequenceItem(line);
        isSequenceLine = SequenceChecker.checkSequenceLine(line);
        if (isSequenceHead) isSequence = true;
        if (isSequenceHead) isSequenceItem = false;
    }

    public static boolean isSequenceHead() {
        return isSequenceHead;
    }

    public static void setIsSequenceHead(boolean isSequenceHead) {
        SequenceModel.isSequenceHead = isSequenceHead;
    }

    public static boolean isSequence() {
        return isSequence;
    }

    public static void setIsSequence(boolean isSequence) {
        SequenceModel.isSequence = isSequence;
    }

    public static boolean isSequenceItem() {
        return isSequenceItem;
    }

    public static void setSequenceItem(boolean isSequenceItem) {
        SequenceModel.isSequenceItem = isSequenceItem;
    }

    public static boolean isSequenceDialogue() {
        return isSequenceDialogue;
    }

    public static void setIsSequenceDialogue(boolean isSequenceDialogue) {
        SequenceModel.isSequenceDialogue = isSequenceDialogue;
    }

    public static boolean isSequenceLine() {
        return isSequenceLine;
    }

    public static void setSequenceLine(boolean isSequenceLine) {
        SequenceModel.isSequenceLine = isSequenceLine;
    }
}
