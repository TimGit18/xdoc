package de.domain.xdoc.process;

import de.domain.xdoc.create.AbstractCreator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AbstractProcessor {

    private static Logger LOG = LogManager.getLogger(AbstractProcessor.class.getName());

    /**
     * Die Methode createAbstract() erzeugt eine Einleitung des Dokuments. Dabei wird zunächst der Beginn des Abstrakts
     * geschrieben, dann der Abstract selber und zum Schluss das Ende.
     * @param isHeadline kennzeichnet, ob eine Überschrift vorliegt
     * @param isAbstract kennzeichnet, ob man sich in einem Abstract befindet
     * @param isAbstractEnd kennzeichnet das Ende eines Abstracts
     * @param line die zu übergebende Zeile
     */
    public static void createAbstract(boolean isHeadline, boolean isAbstract, boolean isAbstractEnd, String line) {

        if (isHeadline) AbstractCreator.createAbstractStart();
        if (isAbstract) {
            AbstractCreator.createAbstract(line);
            LOG.trace("Abstract: " + line);
        }
        if (isAbstractEnd) {
            AbstractCreator.createAbstractEnd();
            LOG.trace("AbstractEnd: " + line);
        }
    }
}
