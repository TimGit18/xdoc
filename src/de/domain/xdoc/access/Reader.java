package de.domain.xdoc.access;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Die Klasse Reader stellt Methoden bereicht, um einen gepufferten Eingabeleser anhande eines übergebenen Dateinamens
 * zu erzeugen.
 */
public class Reader {

    // Statische Deklaration des Loggers
    private static Logger LOG = LogManager.getLogger(Reader.class.getName());

    /**
     * Die Methode createReader() erzeugt den gepufferten Reader anhand des übergebenen Dateinamens. Es wird eine
     * Ausnahme geworfen, falls der Reader auf ein IO-Problem stößt.
     *
     * @param filename Dateiname, der übergeben wird
     * @return Gepufferter Reader
     */
    public static BufferedReader createReader(String filename) {
        BufferedReader reader = null;
        try {
            FileReader fileReader = new FileReader(filename);
            reader = new BufferedReader(fileReader);
        } catch (IOException ioException) {
            LOG.error(ioException.getMessage());
        }
        return reader;
    }
}
