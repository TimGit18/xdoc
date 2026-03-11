package de.domain.xdoc.create;

import de.domain.xdoc.access.Writer;
import de.domain.xdoc.character.Text;
import de.domain.xdoc.character.XML;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Wrapper;

/**
 * Die Klasse SequenceCreator erzeugt Sequenzen abhängig von den Informationen des Aufrufers.
 */
public class SequenceCreator extends TextCreator {

    private static Logger LOG = LogManager.getLogger(SequenceCreator.class.getName());

    /**
     * Die Methode createSequenceHead() erzeugt den Beginn einer Sequenz.
     * @param line übergebene Zeile
     */
    public static void createSequenceHead(String line) 		{
        String sequenceHead = line.replaceAll(Text.SEQUENCE_HEAD_END, Text.EMPTY);
        String sequenceLine	= line.replaceAll(Text.SEQUENCE_HEAD_START, Text.EMPTY);
        Writer.write(writer, Text.BLANK_04);
        Writer.write(writer, XML.SEQUENCE_START);
        Writer.write(writer, Text.BLANK_06);
        Writer.write(writer, XML.SEQUENCE_LINE_START);
        Writer.write(writer, Text.START);
        Writer.write(writer, sequenceHead);
        Writer.write(writer, Text.QUOTE);
        Writer.write(writer, Text.BLANK_01);
        Writer.write(writer, Text.TARGET);
        Writer.write(writer, sequenceLine);
        Writer.write(writer, Text.TAG_END_QUOTE_CLOSE_CRNL);
    }

    /**
     * Die Methode createSequenceEnd() erzeugt das Ende einer Sequenz
     */
    public static void createSequenceEnd() {
        Writer.write(writer, Text.BLANK_04);
        Writer.write(writer, XML.SEQUENCE_END);
    }

    /**
     * Die Methode createSequenceDialogue() erzeugt einen Sequenzeintrag, der einen Dialog darstellt.
     * @param line übergebene Zeile
     */
    public static void createSequenceDialogue(String line) {
        String sequenceItem = line.replaceAll(Text.SEQUENCE_SYMBOL, Text.EMPTY);
        sequenceItem = sequenceItem.replaceAll(Text.BLANK_END, Text.EMPTY);
        Writer.write(writer, Text.BLANK_06);
        Writer.write(writer, XML.SEQUENCE_LINE_START);
        Writer.write(writer, Text.TARGET);
        Writer.write(writer, sequenceItem);
        Writer.write(writer, Text.QUOTE);
        Writer.write(writer, Text.BLANK_01);
        Writer.write(writer, Text.DIALOGUE);
        Writer.write(writer, Text.TAG_END_CLOSE_CRNL);
    }

    /**
     * Die Methode createSequenceLine() erzeugt eine Sequenz-Zeile, die durch einen Pfeil gekennzeichnet ist.
     * @param line übergebene Zeile
     */
    public static void createSequenceLine(String line) {
        String sequenceLine = line.replaceAll(Text.SEQUENCE_SYMBOL, Text.EMPTY);
        sequenceLine = sequenceLine.replaceAll(Text.SEQUENCE_COMMENT, Text.EMPTY);
        sequenceLine = sequenceLine.replaceAll(Text.BLANK_END, Text.EMPTY);

        Writer.write(writer, Text.BLANK_06);
        Writer.write(writer, XML.SEQUENCE_LINE_START);
        Writer.write(writer, Text.TARGET);
        Writer.write(writer, sequenceLine);
        Writer.write(writer, Text.QUOTE);

        // SequenceLine besitzt einen Kommentar
        if (line.matches(Text.SEQUENCE_COMMENT_FULL)) createSequenceComment(line);
        Writer.write(writer, Text.TAG_END_CLOSE_CRNL);
    }

    /**
     * Die Methode createSequenceItem() erzeugt einen Sequenzeintrag ohne Pfeil
     * @param line übergebene Zeile
     */
    public static void createSequenceItem(String line) {
        String sequenceItem = line.replaceAll(Text.BLANK_START, Text.EMPTY);
        sequenceItem = sequenceItem.replaceAll(Text.SEQUENCE_COMMENT, Text.EMPTY);
        sequenceItem = sequenceItem.replaceAll(Text.BLANK_END, Text.EMPTY);

        Writer.write(writer, Text.BLANK_06);
        Writer.write(writer, XML.SEQUENCE_ITEM_START);
        Writer.write(writer, Text.TARGET);
        Writer.write(writer, sequenceItem);
        Writer.write(writer, Text.QUOTE);

        // SequenceItem besitzt einen Kommentar
        if (line.matches(Text.SEQUENCE_COMMENT_FULL)) createSequenceComment(line);
        Writer.write(writer, Text.TAG_END_CLOSE_CRNL);
    }

    /**
     *  Die Methode createSequenceComment() extrahiert den Kommentar aus einer Sequenz und
     *  schreibt ihn in ein eigenes Attribut
     * @param line übergebene Zeile
     */
    private static void createSequenceComment(String line) {
        String sequenceComment = line.replaceAll(Text.SEQUENCE_COMMENT_START, Text.EMPTY);
        sequenceComment = sequenceComment.replaceAll(Text.SEQUENCE_COMMENT_END, Text.EMPTY);
        sequenceComment = sequenceComment.replaceAll(Text.BLANK_END, Text.EMPTY);
        Writer.write(writer, Text.BLANK_01);
        Writer.write(writer, Text.COMMENT);
        Writer.write(writer, sequenceComment);
        Writer.write(writer, Text.QUOTE);

    }


}
