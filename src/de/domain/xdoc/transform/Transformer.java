package de.domain.xdoc.transform;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * Die Klasse Transformer überführt jeweils ein XML-Dokument in ein entsprechendes HTML-Dokument und ein FO-Dokument,
 * um dieses später in ein PDF-Dokument umzuwandeln. Dazu werden zunächst die entsprechenden Pfade initialisiert.
 */
public class Transformer {

    // Globale Variablen dieser Klasse für die Transformation
    private static String xslPath;
    private static String fopPath;
    private static String foSheetPath;
    private static String htmlPath;
    private static String xmlPath;

    // Globale Variablen für Instantiierung und die Eingabe der Transformation
    private static TransformerFactory transformerFactory;
    private static javax.xml.transform.Transformer htmlTransformer;
    private static javax.xml.transform.Transformer fopTransformer;
    private static StreamSource htmlInputStream;
    private static StreamSource fopInputStream;

    // Globale Variablen für die Verarbeitung und die Ausgabe der Transformation
    private static StreamSource xmlStream;
    private static FileOutputStream htmlOutputStream;
    private static StreamResult htmlStream;
    private static FileOutputStream fopOutputStream;
    private static StreamResult fopStream;

    // Parameter, um den Workflow zu steuern
    private static Logger LOG = LogManager.getLogger(Transformer.class.getName());

    /**
     * Die Methode initialize() initialisiert die Pfade desjenigen XML-Dokuments, das transformiert werden soll.
     * Dazu gehört als Ausgangspfad der XML-Pfad
     * @param documentXslPath
     * @param documentFopPath
     * @param documentFoSheetPath
     * @param documentHtmlPath
     * @param documentXmlPath
     */
    public static void initialize(String documentXslPath, String documentFopPath, String documentFoSheetPath,
                                  String documentHtmlPath, String documentXmlPath) {
        // Zuweisungen
        xslPath = documentXslPath;
        fopPath = documentFopPath;
        foSheetPath = documentFoSheetPath;
        htmlPath = documentHtmlPath;
        xmlPath = documentXmlPath;

        LOG.trace("************************************************************");
        LOG.trace("XSL-Pfad:        " + xslPath);
        LOG.trace("FOP-Pfad:        " + fopPath);
        LOG.trace("foSheet-Pfad:    " + foSheetPath);
        LOG.trace("HTML-Pfad:       " + htmlPath);
        LOG.trace("XML-Pfad:        " + xmlPath);
        LOG.trace("************************************************************");
    }

    /**
     * Die Methode instantiate() instantiiert die Transformer für die XML-Transformation: einmal für die Transformation
     * in die HTML-Dokumente, dann für die Transformation der FOP-Dokumente.
     */
    public static void instantiate() {
        try {
            // Instantiierung der Factory
            transformerFactory = TransformerFactory.newInstance();
            LOG.trace("Instantiierung des Transformers \u00fcber die Factory...");

            // Instantiierung des HTML-Transformers
            htmlInputStream = new StreamSource(xslPath);
            htmlTransformer = transformerFactory.newTransformer(htmlInputStream);
            LOG.trace("Instantiierung des HTML-Transformers \u00fcber "+ xslPath);

            // Instantiierung des FOP-Transformers
            fopInputStream = new StreamSource(foSheetPath);
            fopTransformer = transformerFactory.newTransformer(fopInputStream);
            LOG.trace("Instantiierung des FOP-Transformers \u00fcber "+ foSheetPath);
        }
        catch (TransformerException transformerException) {
            LOG.error("Transformer-Ausnahme: ");
            LOG.error(transformerException.getMessage());
        }
    }

    /**
     * Die Methode prepare() definiert den XML-Eingabestrom für die Transformation sowie jeweils die Ausgabeströme für
     * die HTML-Transformation und für die FOP-Transformation.
     */
    public static void prepare() {
        try {
            // Definition des XML-Eingabestroms
            xmlStream = new StreamSource(xmlPath);
            LOG.trace("Definition des XML-Eingabestrom auf " + xmlPath);

            // Definition des HTML-Ausgabestroms
            htmlOutputStream = new FileOutputStream(htmlPath);
            htmlStream = new StreamResult(htmlOutputStream);
            LOG.trace("Definition des HTML-Ausgabestroms auf " + htmlPath);

            // Definition des FOP-Ausgabestroms
            fopOutputStream = new FileOutputStream(fopPath);
            fopStream = new StreamResult(fopOutputStream);
            LOG.trace("Definition des FOP-Ausgabestroms auf " + fopPath);
        }
        catch (FileNotFoundException fileNotFoundException) {
            LOG.error("File Not Found Exception");
            LOG.error(fileNotFoundException.getMessage());
        }
    }

    /**
     * Die Methode transform() transformiert den XML-Strom in ein HTML- und ein FOP-Dokument.
     */
    public static void transform() {
        try {
            // Transformation nach HTML
            htmlTransformer.transform(xmlStream, htmlStream);
            LOG.trace("Transformation nach HTML...");

            // Transformation nach FOP
            fopTransformer.transform(xmlStream, fopStream);
            LOG.trace("Transformation nach FOP...");

        }
        catch (TransformerException transformerException) {
            LOG.error("Transformer Exception");
            LOG.error(transformerException.getMessage());
        }
    }

}
