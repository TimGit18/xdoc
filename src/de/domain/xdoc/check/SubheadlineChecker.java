package de.domain.xdoc.check;

import de.domain.xdoc.character.Text;

/*******************************************************************************************************************
 * Die Klasse SubheadlineChecker() überprüft Textbestandteile darauf, ob es sich um Zwischenüberschriften handelt.
 *******************************************************************************************************************/
public class SubheadlineChecker extends TextChecker {

    /***************************************************************************************************************
     * Die Methode checkSubheadlineCandidate() überprüft, ob auf die zu übergebende Zeile möglicherweise eine
     * Überschrift folgt.
     * Muster:
     *              -->   isSubheadlineCandidate == true
     * Überschrift  -->   isSubheadlineCandidate == true
     * ===========  -->   isSubheadlineCandidate == false
     *
     * @param line die zu übergebende Zeile
     * @param isCandidate der zu übergebende Parameter
     * @return der mögliche Kandidat
     ***************************************************************************************************************/
    public static Boolean checkSubheadlineCandidate(String line, Boolean isCandidate){

        // Kriterien, nach denen eine mögliche Überschrift folgt
        Boolean isBoldUnderline = TextChecker.checkBoldHeadline(line);
        Boolean isBlankline = TextChecker.checkBlankline(line);
        Boolean isNewline = TextChecker.checkNewLine(line);

        // Der voher ermittelte Kandidat wird übergeben
        Boolean isSubheadlineCandidate = isCandidate;

        // Falls eine Leerzeile oder eine neue Zeile ermittelt wurde, dann kann eine Überschrift folgen
        if (isBlankline) isSubheadlineCandidate = true;
        if (isNewline) isSubheadlineCandidate = true;

        // Falls eine unterstrichene Zeile ermittelt wurde kann keine Überschrift mehr voliegen
        if (isBoldUnderline) isSubheadlineCandidate = false;

        return isSubheadlineCandidate;
    }

    /*****************************************************************************************************************
     * Die Methode checkSubheadlineItem überprüft, ob ein übergebener Kandidat tatsächlich eine Teilüberschrift
     * darstellt. Falls die aktuelle Zeile, die mit dem Kandidaten übergeben wurde, nämlich eine unterstrichene Zeile
     * ist und der Kandidat nicht zufällig leer ist, so handelt es sich um eine Teilüberschrift.
     * @param line Die zu untersuchende Zeile
     * @param subheadlineCandidate der Kandidat für die Teilüberschrift
     * @return ja oder nein über das gefundene Item
     ****************************************************************************************************************/
    public static Boolean checkSubheadlineItem(String line, String subheadlineCandidate) {

        // Kriterium für eine Teilüberschrift
        Boolean isBoldUnderline = TextChecker.checkBoldHeadline(line);
        Boolean isSubheadlineItem = false;

        // Überprüfung des Kandidaten
        if (isBoldUnderline && !subheadlineCandidate.equals(Text.EMPTY)) isSubheadlineItem = true;

        return isSubheadlineItem;
    }



}
