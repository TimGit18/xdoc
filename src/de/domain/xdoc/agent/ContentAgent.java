package de.domain.xdoc.agent;

import de.domain.xdoc.access.Writer;
import de.domain.xdoc.character.Text;
import de.domain.xdoc.character.XML;
import de.domain.xdoc.create.TextCreator;
import de.domain.xdoc.model.*;
import de.domain.xdoc.process.*;
import de.domain.xdoc.util.Replacer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.IOException;

/**
 * Die Klasse ContentProcessor ist verantwortlich für die Verarbeitung der Inhaltsdokumente. Dabei
 * leitet sie sich von der Klasse TextProcessor ab und überschreibt Methoden von dieser.
 */
public class ContentAgent extends TextAgent {

    // Privater Logger
    private static Logger LOG = LogManager.getLogger(ContentAgent.class.getName());

    /**
     * Die Methode process() verarbeitet das Content-Dokument. Dazu wird der Einleser gestartet, der die weitere
     * Verarbeitung zeilenweise übernimmt. Ist keine Zeile mehr einzulesen, so fällt eine NullPointer-Exception
     * aus. Dann muss der Abschluss der Dokumentenverarbeitung vorgenommen werden.
     * Bevor die Zielstrukturen erzeugt werden, müssen die Modelle gesetzt werden. Anschließend werden die eigenen
     * create-Methode oder Creator-Klassen aufgerufen.
     * @param links Web-Dokumente
     */
    public static void process(String name, String[] links) {
        // ContentAgent.prepare();
        int lineNumber = 0;
        try {
            String line;

            while (!(line = bufferedReader.readLine()).equals(null)) {

                // Dekodieren von Sonderzeichen
                line = Replacer.replaceAmpersands(line);
                // line = Replacer.replaceAngleBrackets(line);

                // Inkrementieren
                lineNumber++;

                // Setzen der Modelle
                setModels(line, lineNumber);
                setTextModel();

                // Erzeugen der Strukturen
                createTexture(line, links, name);
                createTable(line);
                createList(line);
                createImage(line);
                createSequence(line);
                createCode(line);
                createHyperLink(line);
                createText(line);
            }
        }
        catch (IOException ioException) {
            LOG.error(ioException.getMessage());
        }
        // Abschluss der Verarbeitung über Ende der Dokumentenverarbeitung //
        catch (NullPointerException nullPointerException) {
            createContentEnd();
        }
    }

    private static void prepare(){
        CodeboxModel.setModel("");
    }


    /**
     * Die Methode createContentEnd() erzeugt den Abschluss eines Content-Dokuments.
     */
    private static void createContentEnd() {
        TextCreator.createContentEnd();
        TextCreator.createEpilogue();
        Writer.close(outputStreamWriter);
    }


    /**
     * Die Methode setModels() definiert alle Modelle au�er dem Textmodell.
     * @param line übergebene Zeile
     * @param lineNumber übergebene Zeilennummer
     */
    private static void setModels(String line, int lineNumber) {
        TextModel.setModel(line);
        HeadlineModel.setModel(lineNumber);
        AbstractModel.setModel(line, lineNumber);
        SubheadlineModel.setModel(line, lineNumber);
        SectionModel.setModel();
        ListModel.setModel(TextModel.isBlankline(), line);
        NumberListModel.setModel(TextModel.isBlankline(), line);
        ImageModel.setModel(line);
        TableModel.setModel(line);
        SequenceModel.setModel(line);
        CodeboxModel.setModel(line);
        HyperLinkModel.setModel(line);
    }

    /**
     * Die Methode setTextModel() setzt das Textmodell.
     */
    private static void setTextModel() {
        TextModel.setIsTextLine();
        TextModel.setIsTextStartAndArea();
        TextModel.setIsTextCandidate();
        TextModel.setIsTextEndAndArea();
        TextModel.setIsText();
    }

    /**
     * Die Methode createTexture() setzt die Text-Strukturelemente (außer dem Text)
     * @param line übergebene Zeile
     * @param links Web-Parameter
     */
    private static void createTexture(String line, String[] links, String name) {

        // Erzeugen von Überschrift und Rahmen
        StartAgent.createStart(HeadlineModel.isHeadline(), line, links, name);

        // Erzeugen des Abstract
        AbstractProcessor.createAbstract(HeadlineModel.isHeadline(), AbstractModel.isAbstract(),
                AbstractModel.isAbstractEnd(), line);

        // Erzeugen von Teilüberschriften
        SubheadlineProcessor.createSubheadline(SubheadlineModel.isSubheadlineItem(),
                SubheadlineModel.getSubheadlineCandidate());

    }

    /**
     * Die Methode createTable() erzeugt eine Tabelle.
     * @param line übergebene Zeile
     */
    private static void createTable(String line) {
        // Erzeugen einer Tabelle
        TableProcessor.createTable(TableModel.isTableStart(), TableModel.isTableHead(),
                TableModel.isTableHeadline(), TableModel.isTableItem(),
                TableModel.isTableCaption(), TableModel.isTableEnd(), line);
    }

    /**
     * Die Methode createList() erzeugt Listen.
     * @param line übergebene Zeile
     */
    private static void createList(String line) {
        // Erzeugen einer einfachen Liste
        ListProcessor.createSimpleListEnd(TextModel.isBlankline());
        ListProcessor.createSimpleList(line);

        // Erzeugen einer nummerierten Liste
        NumberListProcessor.createNumberListEnd(TextModel.isBlankline());
        NumberListProcessor.createNumberList(line);
    }

    /**
     * Die Methode createImage() erzeugt ein Bild.
     * @param line übergebene Zeile
     */
    private static void createImage(String line) {
        // Erzeugen eines Bildes
        ImageProcessor.createImage(ImageModel.isImage(), ImageModel.isImageDescription(),
                ImageModel.isImageLine(), line, localImagePath, imagePath);
    }

    /**
     * Die Methode createSequence() erzeugt eine Sequenz.
     * @param line übergebene Zeile
     */
    private static void createSequence(String line) {
        // Erzeugen einer Sequenz
        SequenceModel.setIsSequence(SequenceProcessor.createSequenceFrame(SequenceModel.isSequenceHead(),
                SequenceModel.isSequence(), TextModel.isBlankline(), line));
        SequenceProcessor.createSequence(SequenceModel.isSequenceDialogue(), SequenceModel.isSequenceLine(),
                SequenceModel.isSequence(), SequenceModel.isSequenceItem(), line);
    }

    /**
     * Die Methode createCode() erzeugt eine Codebox.
     * @param line übergebene Zeile
     */
    private static void createCode(String line) {
        // Erzeugen einer Codebox
        CodeboxProcessor.createCodebox(CodeboxModel.isCodeboxStart(), CodeboxModel.isCodeboxEnd(),
                CodeboxModel.isCodebox(), CodeboxModel.isCodeline(), line);
    }

    /**
     * Die Methode createHyperLink() erzeugt eine Liste von Hyperlinks.
     * @param line übergebene Zeile
     */
    private static void createHyperLink(String line) {
        // Erzeugen einer einfachen Link-Liste
        HyperLinkModel.setIsHyperLinkList(HyperLinkProcessor.createHyperLinksEnd(
                HyperLinkModel.isHyperLinkList(), TextModel.isBlankline()));
        HyperLinkModel.setIsHyperLinkCandidate(HyperLinkProcessor.createHyperLinksStart(
                HyperLinkModel.isHyperLinkList(), HyperLinkModel.isHyperLinkCandidate()));
        HyperLinkProcessor.createHyperLinksItem(HyperLinkModel.isHyperLinkItem(), line);
    }

    /**
     * Die Methode createText() erzeugt Text-Elemente.
     * @param line übergebene Zeile
     */
    private static void createText(String line) {
        // Fettschrift drucken
        TextAgent.createBoldline(TextModel.isBoldline(), line);
        // Textauszeichnung
        TextAgent.createText(TextModel.isTextStart(), TextModel.isText(), TextModel.isTextEnd(), line);
    }
}
