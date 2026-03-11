package de.domain.xdoc.check;

import de.domain.xdoc.character.Text;

/***************************************************************************************************************
 * Die Klasse TableChecker überprüft Textteile darauf, ob es sich um Tabellenstrukturen handelt.
 ****************************************************************************************************************/
public class TableChecker extends TextChecker {

    /***********************************************************************************************************
     * Die Methode checkTable() überprüft, ob eine übergebene Zeile zu einer Tabelle gehört bzw. den Anfnag des
     * Bereichs einer Tabelle markiert. Wenn man
     *
     *   ---------------    --> isTable = false
     *    Überschrift       --> isTable = false
     *   ---------------    --> isTable = true
     *    Tabelleninhalt    --> isTable = true
     *   ---------------    --> isTable = true
     *
     * @param line die zu übergebende Zeile
     * @param isTable der Wahrheitswert
     * @param isCandidate der Kandidat
     * @return isTable
     ************************************************************************************************************/
    public static Boolean checkTable(String line, boolean isTable, boolean isCandidate) {

        // Kennzeichner für ja oder nein
        Boolean isTableline = checkTableLine(line);
        Boolean isBlankline = checkBlankline(line);

        if (isCandidate && isTableline) isTable = true;                 // Tabelle wird "betreten"
        if (isBlankline && isTable) isTable = false;                    // Tabelle wird "verlassen"

        return isTable;
    }

    /****************************************************************************************************************
     * Die Methode checkTableCandidate() überprüft, ob auf die zu übergebende Zeile möglicherweise eine
     * Tabelle folgt.
     * Muster:
     *              -->   isTableCandidate == true
     * -----------  -->   isTableCandidate == true
     *  Tabelle     -->   isSTableCandidate == false
     *
     * @param line die zu übergebende Zeile
     * @param isTable der Wahrheitswert
     * @param isCandidate dito
     * @return der mügliche Kandidate
     **********************************************************************************************************/
    public static Boolean checkTableCandidate(String line, Boolean isTable, Boolean isCandidate) {

        // Kriterien nach denen eine mögliche Überschrift folgen kann
        Boolean isBlankline = checkBlankline(line);					    // Tabelle kann nach einer Leerzeile folgen
        Boolean isBoldUnderline = checkBoldHeadline(line);			// Tabelle kann nach einer Teilüberschrift folgen

        // Der voher ermittelte Kandidat wird übergeben
        Boolean isTableCandidate = isCandidate;

        // Falls vorher eine Leerzeile erfolgt ist ein möglicher Kandidat gefunden
        if (isBlankline || isBoldUnderline)	isTableCandidate = true;

        // Falls man schon in einer Tabelle sich befindet, gibt es keinen Kandidaten
        if (isTable) isTableCandidate = false;

        return isTableCandidate;
    }

    /***********************************************************************************************************
     * Die Methode checkTableCaption() überprüft, ob eine übergebene Zeile eine Legende zu einer Tabelle enthält.
     * @param line die zu prüfende Zeile
     * @return isCaptionLine
     ***********************************************************************************************************/
    public static Boolean checkTableCaption(String line, Boolean isTable) {
        Boolean isCaptionLine = false;
        if (line.matches(Text.TABLE_CAPTION) && isTable) isCaptionLine = true;
        return isCaptionLine;
    }

    /************************************************************************
     * Die Methode checkTableEnd prüft genau, wann die Tabelle verlassen wird.
     * @param line die zu übergebende Zeile
     * @param isTable entsprechender Prüfparameter
     * @return isTableEnd
     ************************************************************************/
    public static Boolean checkTableEnd(String line, Boolean isTable) {
        Boolean isTableEnd = false;
        Boolean isBlankLine = checkBlankline(line);

        // Kriterium
        if (isTable && isBlankLine) isTableEnd = true;

        return isTableEnd;
    }

    /**************************************************************************
     * Die Methode checkTableHead() prüft, ob der Tabellenkopf betreten wurde.
     * @param line die zu übergebende Zeile
     * @param isTableStart Prüfparameter, dass die Tabelle schon betreten wurde
     * @param isHead Prüfparameter, ob man sich schon im Kopf befindet
     * @return isTableHead
     **************************************************************************/
    public static Boolean checkTableHead(String line, Boolean isTableStart, Boolean isHead) {
        Boolean isTableHead = isHead;
        Boolean isTableRow = checkTableRow(line);
        if (isTableStart) isTableHead = true;
        if (!isTableStart && isTableRow) isTableHead = false;
        return isTableHead;
    }

    /**********************************************************************************************************
     * Die Methode checkTableHeadline() überprüft, ob die übergebene Zeile eine Tabellenüberschrift beinhaltet.
     * @param line übergebene Zeile
     * @param isTableHead Prüfparameter
     * @return isTableHeadline
     *******************************************************************************************************/
    public static Boolean checkTableHeadline(String line, Boolean isTableHead) {
        Boolean isTableHeadline = false;
        Boolean isTableRow = checkTableRow(line);
        if (isTableHead && isTableRow) isTableHeadline = true;
        return isTableHeadline;
    }

    /**************************************************************************************************
     * Die Methode checkTableItem() überprüft, ob eine Zeile bereits als ein Tabellenelement fungiert.
     * Dazu wird zunächst geprüft, ob man sich in der Tabelle befindet, aber nicht mnehr im Tabellenkopf.
     * Anschließend wird geprüft, ob man sich nicht bereits am Ende der Tabelle befindet. Wenn beide
     * Bedingungen erfüllt sind, dann befindet man sich in einer richtigen Tabellenzeile.
     * @param line übergebene Zeile
     * @param isTable Prüfparameter
     * @param isTableHead Prüfparameter
     * @return isTableItem
     **************************************************************************************************/
    public static Boolean checkTableItem(String line, Boolean isTable, Boolean isTableHead) {
        Boolean isTableItem = false;
        if (isTable && !isTableHead) isTableItem = true;
        if (checkTableLine(line)) isTableItem = false;
        if (checkTableCaption(line, isTable)) isTableItem = false;
        return isTableItem;
    }

    /**********************************************************************************************************
     * Die Methode checkTableLine() überprüft, ob die übergebene Zeile eine Tabellenbegrenzungszeile darstellt.
     * Sie besteht aus einem Leerzeichen und darauffolgeden Bindestrichen ' ----'.
     * @param line übergebene Zeile
     * @return isTableline
     **********************************************************************************************************/
    public static Boolean checkTableLine(String line) {
        Boolean isTableline = false;
        if (line.matches(Text.TABLE_LINE)) isTableline = true;
        return isTableline;
    }

    /**********************************************************************************************************
     * Die Methode checkTableRow() überprüft eine übergebene Zeile, ob sie eine Tabellenzeile darstellt. Das
     * Merkmal für eine Tabellenzeile ist '|', was den Trenner für die einzelnen Tabellenzellen darstellt.
     * @param line die zu übergebende Zeile
     * @return isTableRow
     ***********************************************************************************************************/
    public static Boolean checkTableRow(String line) {
        Boolean isTableRow = false;
        if (line.matches(Text.TABLE_ROW)) isTableRow = true;
        return isTableRow;
    }

    /************************************************************************************************************
     * Die Methode checkTableStart() überprüft, ob eine übergebene Zeile den Start einer Tabelle darstellt. Dabei
     * ist der Start dadurch gekennzeichnet, dass eine Zeile ein Kandidat und eine Tabelle ist. Falls sie kein
     * Kandidat mehr ist, ist sie auch kein Tabellenanfang.
     * @param line übergebene Zeile
     * @param isTable Prüfparameter
     * @param isCandidate Prüfparameter
     * @return isTableStartt
     ************************************************************************************************************/
    public static Boolean checkTableStart(String line, Boolean isTable, Boolean isCandidate) {
        Boolean isTableStart = false;
        if (isCandidate && isTable)	isTableStart = true;
        if (!isCandidate)	isTableStart = false;
        return isTableStart;
    }


}
