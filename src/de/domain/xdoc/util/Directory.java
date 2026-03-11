package de.domain.xdoc.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

/**
 * Die Klasse Directory liefert einige querschnittliche Methoden für die Anwendung, die sich auf die Dateistruktur und
 * die Verzeichnisse beziehen, in denen die Dokumente abgespeichert sind.
 * @author Tim Schmitz
 */

public class Directory {
    // Definition des Loggers
    public static Logger LOG = LogManager.getLogger(Directory.class.getName());

    // Definition der Dokumentenliste
    public static List<String> documentsList = new ArrayList<>();

    /**
     * Die Methode deleteFile() löscht eine Datei oder ein Verzeichnis rekursiv.
     */
    public static void deleteFile(String path) {

        // Initialisierung der Variablen für diese Methode
        String documentPath;
        File file = new File(path);

        String unicodePath = path.replace("ß", "\u00df");
        LOG.trace("S\u00e4uberung von " + path);
        LOG.trace("Zu l\u00f6schendes Verzeichnis: " + unicodePath);

        // Überprüfung, ob es sich um eine richtige Datei handelt oder ein Verzeichnis
        if (file.isDirectory()) {

            LOG.trace(unicodePath + " ist Verzeichnis");
            String[] documentList = file.list();

            if (documentList!=null) {

                // Rekursiver Aufruf der Löschmethode
                for (String document : documentList) {
                    documentPath = path + File.separator + document;
                    deleteFile(documentPath);
                }
            }
        }
        LOG.trace(unicodePath + " ist Datei");
        file.delete();
        LOG.trace(unicodePath + " ist gel\u00f6scht");
    }

    /**
     * Die Methode createDirectory() erzeugt ein Verzeichnis über einen Verzeichnispfad.
     * @param directoryPath
     */
    public static void createDirectory(String directoryPath) {
        LOG.trace("Erzeugen von " + directoryPath);
        File directory = new File(directoryPath);
        directory.mkdir();
    }

    /**
     * Die Methode createDocumentStructure überführt eine Quellstruktur in eine Zielstruktur. Dafür werden rekursive
     * Methodenaufrufe unterstützt.
     * @param sourcePath
     * @param targetPath
     */
    public static void createDocumentStructure(String sourcePath, String targetPath) {
        LOG.trace("Erzeugen von " + targetPath);

        // Lokale Variablen für diese Methode
        String documentPath = new String();
        String createdPath = new String();

        // Dateidefinition von Quell- und Zielpfad
        File sourceFile = new File(sourcePath);
        File targetFile = new File(targetPath);

        // Erzeugen einer Verzeichnisstruktur nur dann, falls das Quellverzeichnis ein richtiges Verzeichnbis ist
        if (sourceFile.isDirectory()) {
            String[] documents = sourceFile.list();

            // Die Überprüfung der folgenden Bedingung ist eigentlich nicht notwendig.
            if (!targetFile.exists())	targetFile.mkdir();

            // Hinunterdriillen der Struktur
            for (String document : documents) {
                documentPath = sourcePath + File.separator + document;
                createdPath = targetPath + File.separator + document;
                createDocumentStructure(documentPath, createdPath);
            }
        }
    }

    /**
     * Die Methode getDocumentsList() ermittelt zu einem gegebenen Quellpfad die Liste aller enthaltener Dokumente.
     * @param sourcePath
     * @return
     */
    public static List<String> getDocumentsList(String sourcePath) {
        // Variablen für die Getter-Methode
        String documentPath = new String();
        File sourceFile = new File(sourcePath);

        // Falls die Quelle eine richtige Datei ist, dann wird sie der Liste hinzugefügt.
        if (sourceFile.isFile()) documentsList.add(sourcePath);

        // Falls die Quelle ein Verzeichnis ist, dann wird über die Verzeichnisinhalte iteriert.
        // Rekursiv wird die Methode dann aufgerufen.
        if (sourceFile.isDirectory()) {
            String[] documents = sourceFile.list();

            // Rekursiver Methodenaufruf
            for (String document : documents) {
                documentPath = sourcePath + File.separator + document;
                getDocumentsList(documentPath);
            }

        }
        return documentsList;
    }
}
