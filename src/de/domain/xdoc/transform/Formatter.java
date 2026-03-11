package de.domain.xdoc.transform;

import org.apache.fop.apps.FOUserAgent;
import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.fop.apps.MimeConstants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.transform.*;
import javax.xml.transform.Transformer;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;
import java.awt.event.KeyListener;
import java.io.*;

/**
 * Die Klasse Formatter sorgt für die Formatierung der fo-Dokumente via XSL-FO in ein pdf-Dokument.
 */

public class Formatter {

    private static Logger LOG = LogManager.getLogger(Formatter.class.getName());

    // Private Variablen für die Dokumenten-Formatierung
    private static String documentFopPath;
    private static String documentPdfPath;
    private static String fopConfigPath;
    private static FopFactory fopFactory;

    /**
     * Die Methode initialize() initialisiert die Formatierungsumgebung.
     * @param fopPath Pfad für das fo-Dokument
     * @param pdfPath Pfad für das pdf-Dokument
     * @param fopConfig Pfad für die Konfigurationsdatei
     */

    public static void initialize(String fopPath, String pdfPath, String fopConfig) {

        // Globale Variablen für die Dokumentenverarbeitung
        documentFopPath = fopPath;
        documentPdfPath = pdfPath;
        fopConfigPath = fopConfig;

        // Tracing
        LOG.trace("Dokumenten-FOP-Pfad: " + documentFopPath);
        LOG.trace("Dokumenten-PDF-Pfad: " + documentPdfPath);
        LOG.trace("FOP-Config-Pfad:     " + fopConfigPath);
    }

    /**
     * Die Methode format() führt die Formatierung durch.
     */
    public static void format() {

        File fopConfigurationFile = new File(fopConfigPath);
        File fopFile = new File(documentFopPath);
        File pdfFile = new File(documentPdfPath);

        OutputStream outputStream = null;

        try {

            // Definition einer FopFactory-Instanz und eines User Agenten
            fopFactory = FopFactory.newInstance(fopConfigurationFile);
            FOUserAgent foUserAgent = fopFactory.newFOUserAgent();

            // Definition der Ausgabestr�me
            outputStream = new FileOutputStream(pdfFile);
            outputStream = new BufferedOutputStream(outputStream);

            // Einen neuen Formatting Objects Processer definieren
            Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, foUserAgent, outputStream);

            // Definition einer TransformerFactory-Instanz und eines neuen Transformers
            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer();

            // Quelle und Ziel der FOP-Transformation
            Source source = new StreamSource(fopFile);
            Result result = new SAXResult(fop.getDefaultHandler());

            // FOP-Transformation durchführen
            transformer.transform(source, result);

        } catch (FileNotFoundException fileNotFoundException) {
            LOG.error("FileNotFoundException: " + fileNotFoundException.getMessage());
        } catch (IOException ioException) {
            LOG.error("IOException: " + ioException.getMessage());
        } catch (SAXException saxException) {
            LOG.error("SAXException: " + saxException.getMessage());
        } catch (TransformerConfigurationException transformerConfigurationException) {
            LOG.error("TransformerConfigurationException: " + transformerConfigurationException.getMessage());
        } catch (TransformerException transformerException) {
            LOG.error("TransformerException: " + transformerException.getMessage());
        } finally {}

        try {
           outputStream.close();
        }
        catch (IOException ioe) {
           LOG.error(" IOE: " + ioe.getMessage());
        }
    }
}
