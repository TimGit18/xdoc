package de.domain.xdoc.agent;

import de.domain.xdoc.create.TextCreator;
import de.domain.xdoc.access.Writer;
import de.domain.xdoc.create.TableOfContentCreator;
import de.domain.xdoc.model.*;

import java.io.IOException;

import de.domain.xdoc.process.AbstractProcessor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Die Klasse TopicProcessor ist verantwortlich für die Verarbeitung der Inhaltsdokumente. Dabei
 * leitet sie sich von der Klasse TextProcessor ab und überschreibt Methoden von dieser.
 */
public class TopicAgent extends TextAgent {

    private static final Logger LOG = LogManager.getLogger(TopicAgent.class.getName());

    /**
     * Die Methode process() verarbeitet das Topic-Dokument. Dazu wird  der Einleser gestartet, der die weitere
     * Verarbeitung zeilenweise übernimmt. Ist keine Zeile mehr einzulesen, so fällt eine NullPointer-Exception
     * aus. Dann muss der Abschluss der Dokumentenverarbeitung vorgenommen werden.
     * Bevor die Zielstrukturen erzeugt werden, müssen die Modell gesetzt werden. Anschließend werden die eigenen
     * create-Methode oder Creator-Klassen aufgerufen.
     * @param links Web-Dokumente
     */
    public static void process(String name, String[] links) {

        int	lineNumber = 0;

        try {
            String line;
            while (!(line = bufferedReader.readLine()).equals(null)) {
                lineNumber++;
                setModels(line,lineNumber);
                createTexture(line, links, name);
                createTableOfContent(line);
            }
        } catch (IOException ioException) {
            LOG.error(ioException.getMessage());
        } catch (NullPointerException nullPointerException) {
            createTopicEnd();
        }
    }

    /**
     * Die Methode createTableOfContent erzeugt modellabhängig ein Inhaltsverzeichnis. Dabei muss man achten,
     * dass vom TableOfContentModel auch noch die Überschrift als Zeile des Inhaltsverzeichnis erkannt wird.
     * @param line ist die übergebene Zeile
     */
    private static void createTableOfContent(String line) {
        if (TableOfContentModel.isTableOfContentStart()) TextCreator.createHorizontalBar();
        if (TableOfContentModel.isTableOfContentStart()) TableOfContentCreator.createTableOfContentStart();
        if (TableOfContentModel.isTableOfContentItem() && (!HeadlineModel.isHeadline())) createTocItem(line);
    }

    /**
     * Die Methode createTextture() setzt die Text-Strukturelemente (außer dem Text)
     * @param line übergebene Zeile
     * @param links Web-Parameter
     */
    private static void createTexture(String line, String[] links, String name) {

        // Erzeugen von Überschrift und Rahmen
        StartAgent.createStart(HeadlineModel.isHeadline(), line, links, name);

        // Erzeugen des Abstract
        AbstractProcessor.createAbstract(HeadlineModel.isHeadline(), AbstractModel.isAbstract(),
                AbstractModel.isAbstractEnd(), line);
    }

    /**
     * Die Methode createTocItem() erzeugt einen Eintrag in das Inhaltsverzeichnis.
     * @param line die zu übergebende Zeile
     */
    private static void createTocItem(String line) {
        LOG.trace("TocItemCandidate: " +  line);
        for (String nameItem : nameList) {
            LOG.trace("NameItem: " + nameItem);
            if (nameItem.equals(line)) {
                int index = nameList.indexOf(nameItem);
                TableOfContentCreator.createTableOfContentItem(nameItem, typeList.get(index),
                htmlMap.get(index), pdfMap.get(index));
            }
        }
    }

    /**
     * Die Methode createTopciEnd() erzeugt das Ende eines Topic-Dokuments
     */
    private static void createTopicEnd() {
        TableOfContentCreator.createTableOfContentEnd();
        TextCreator.createContentEnd();
        TextCreator.createEpilogue();
        Writer.close(outputStreamWriter);
    }

    /**
     * Die Methode setModels() definiert alle Modelle außer dem Textmodell.
     * @param line übergebene Zeile
     * @param lineNumber übergebene Zeilennummer
     */
    private static void setModels(String line, int lineNumber) {
        TextModel.setModel(line);
        HeadlineModel.setModel(lineNumber);
        AbstractModel.setModel(line, lineNumber);
        TableOfContentModel.setModel(line);
    }
}
