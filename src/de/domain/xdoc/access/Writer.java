package de.domain.xdoc.access;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

/**
 * Die Klasse access repräsentiert einen Dateischreiber auf dem Dateisystem. Dabei implementiert die
 * abstrakte Klasse nur eine Methode, nämlich die Erzeugung des OutputStreamWriters.
 */
public class Writer {

    // Deklaration des statischen Loggers
    private static Logger LOG = LogManager.getLogger(Writer.class.getName());

    /**
     * Die Methode createOutputStreamWriter() erzeugt einen OutputStreamWriter anhand des übergebenen
     * XML-Pfades und gibt diesen an den Aufrufer zurück.
     * @return OutputStreamWriter
     */
    public static OutputStreamWriter createOutputStreamWriter(String xmlPath){
        OutputStream outputStream;
        OutputStreamWriter writer = null;
        try
        {
            outputStream = new FileOutputStream(xmlPath);
            writer = new OutputStreamWriter(outputStream);
        }
        catch(IOException ioException)
        {
            LOG.error(ioException.getMessage());
        }
        return writer;
    }

    /**
     * Die Methode write() schreibt in den übergebenen Ausgabeschreiber eine dazu mitübergebene Zeile.
     * @param outputStreamWriter übergebener Ausgabeschreiber
     * @param line übergebene Zeile
     */
    public static void write(OutputStreamWriter outputStreamWriter, String line) {
        try {
            outputStreamWriter.write(line);
        }
        catch (IOException ioException) {
            LOG.error(ioException.getMessage());
        }
    }

    /**
     * Die Medthode close() schreibt das Ende einer Datei in den übergebenen Ausgabeschreiber. Anschließend wird der
     * Ausgabeschreiber geschlossen.
     * @param outputStreamWriter übergebener Ausgabeschreiber
     */
    public static void close(OutputStreamWriter outputStreamWriter){

        // Dokument schließen
        try {
            outputStreamWriter.close();
        } catch (IOException ioException) {
            LOG.error(ioException.getMessage());
        }
    }

}

