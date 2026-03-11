package de.domain.xdoc.agent;

import de.domain.xdoc.create.MetaDataCreator;
import de.domain.xdoc.create.TextCreator;

public class StartAgent extends TextAgent {

    /**
     * Die Methode createHeadline() erzeugt eine Überschrift sowie die Meta-Daten zu dieser Überschrift (Prolog,
     * Hauptnavigationsleiste, Links, Scripts und den Beginn des Content-Bereichs). Zunächst wird der Prolog geschrieben,
     * anschließend die anderen Meta-Daten und zum Schluss die Überschrift.
     * @param isHeadline kennzeichnet, ob die Zeile eine Überschrift ist
     * @param line übergebene Zeile
     * @param links Web-Parameters
     */
    static void createStart(boolean isHeadline, String line, String[] links, String name) {

        String bootstrapMin      = links[0];
        String bootstrapToc      = links[1];
        String favicon           = links[2];
        String angularJs         = links[3];
        String jqueryJs          = links[4];
        String popperJs          = links[5];
        String bootstrapMinJs    = links[6];
        String bootstrapTocJs    = links[7];

        // Prolog
        if (isHeadline) TextCreator.createPrologue(environment);

        // Links und Rahmen
        if (isHeadline) createMainArea();
        if (isHeadline) createLinks(bootstrapMin, bootstrapToc, favicon);
        if (isHeadline) createScripts(angularJs, jqueryJs, popperJs, bootstrapMinJs, bootstrapTocJs);

        // Metadaten
        if (isHeadline) MetaDataCreator.createTitle(name);
        if (isHeadline) MetaDataCreator.createAuthor();
        if (isHeadline) MetaDataCreator.createDate();

        // Start des eigentlichen Dokuments
        if (isHeadline) TextCreator.createContentStart();
        if (isHeadline) TextCreator.createHeadline(line);
    }


}
