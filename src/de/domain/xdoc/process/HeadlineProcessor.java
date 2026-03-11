package de.domain.xdoc.process;

import de.domain.xdoc.create.TextCreator;

public class HeadlineProcessor extends TextProcessor{

    /**
     * Die Methode createHeadline() erzeugt eine �berschrift sowie die Meta-Daten zu dieser �berschrift (Prolog,
     * Hauptnavigationsleiste, Links, Scripts und den Beginn des Content-Bereichs). Zun�chst wird der Prolog geschrieben,
     * anschließend die anderen Meta-Daten und zum Schluss die �berschrift.
     * @param isHeadline kennzeichnet, ob die Zeile eine �berschrift ist
     * @param line übergebene Zeile
     * @param links Web-Parameters
     */
    static void createHeadline(boolean isHeadline, String line, String[] links) {

        String bootstrapMin      = links[0];
        String bootstrapToc      = links[1];
        String favicon           = links[2];
        String angularJs         = links[3];
        String jqueryJs          = links[4];
        String popperJs          = links[5];
        String bootstrapMinJs    = links[6];
        String bootstrapTocJs    = links[7];

        if (isHeadline) TextCreator.createPrologue(environment);
        if (isHeadline) createMainArea();
        if (isHeadline) createLinks(bootstrapMin, bootstrapToc, favicon);
        if (isHeadline) createScripts(angularJs, jqueryJs, popperJs, bootstrapMinJs, bootstrapTocJs);
        if (isHeadline) TextCreator.createContentStart();
        if (isHeadline) TextCreator.createHeadline(line);
    }


}
