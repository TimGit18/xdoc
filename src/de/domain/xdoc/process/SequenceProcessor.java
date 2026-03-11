package de.domain.xdoc.process;

import de.domain.xdoc.character.Text;
import de.domain.xdoc.character.XML;
import de.domain.xdoc.create.SequenceCreator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Die Klasse SequenceProcessor() verantwortet das Erzeugen einer Sequenz.
 */
public class SequenceProcessor {

    // Parameter, um den Workflow zu steuern
    private static Logger LOG = LogManager.getLogger(SequenceProcessor.class.getName());

    /**
     * Die Methode createSequenceFrame() erzeugt den Anfang und das Ende einer Sequenz.
     * @param isSequenceHead kennzeichnet den Kopf einer Sequenz
     * @param isSequence kennzeichnet eine Sequenz
     * @param isBlankline kennzeichnet eine Leerzeile
     * @param line ist die übergebebe Zeile
     * @return isSequence
     */
    public static boolean createSequenceFrame(boolean isSequenceHead, boolean isSequence, boolean isBlankline, String line) {
        if (isSequenceHead) SequenceCreator.createSequenceHead(line);
        if (isBlankline && isSequence) SequenceCreator.createSequenceEnd();
        if (isBlankline && isSequence) isSequence = false;
        return isSequence;
    }

    /**
     * Die Methode createSequence() erzeugt einen Sequenz-Eintrag (Dialog, Element oder Zeile)
     * @param isSequenceDialogue kennzeichnet einen Dialog
     * @param isSequenceLine kennzeichnet eine Sequenzzeile
     * @param isSequence kennzeichnet, ob eine Sequenz vorliegt
     * @param isSequenceItem kennzeichnet einen Sequenzeintrag
     * @param line ist die übergebene Zeile
     */
    public static void createSequence(boolean isSequenceDialogue, boolean isSequenceLine, boolean isSequence,
                                      boolean isSequenceItem, String line) {
        if (isSequenceDialogue) SequenceCreator.createSequenceDialogue(line);
        if (isSequenceLine && !isSequenceDialogue) SequenceCreator.createSequenceLine(line);
        if (isSequence && isSequenceItem) SequenceCreator.createSequenceItem(line);
    }
}
