package de.domain.xdoc.character;

/**********************************************************************************
 * Das Interface XML stellt XML-Tags für die Generierung von XML-Dokumenten bereit
 **********************************************************************************/
public interface XML {
    //----------//
    // Abstract //
    //----------//
    String ABSTRACT_START = "<abstract>\r\n";
    String ABSTRACT_END = "</abstract>\r\n";

    //--------------//
    // Content-Area //
    //--------------//
    String CONTENT_START = "<content>\r\n";
    String CONTENT_END = "</content>\r\n";

    //------------------//
    // Dokumenten-Tags  //
    //------------------//
    String DOCUMENT_END   = "</document>\r\n";
    String DOCUMENT_START = "<document env=\"";

    //-----------------------------//
    // Character Entity References //
    //-----------------------------//
    String OPEN_ANGLE_BRACKET = "&lt;";
    String CLOSE_ANGLE_BRACKET = "&gt;";
    String AMPERSAND = "&amp;";

    //--------//
    // Autor  //
    //--------//
    String AUTHOR_START = "<author>";
    String AUTHOR_END	= "</author>\r\n";

    //--------//
    // Datum  //
    //--------//
    String DATE_START = "<date>";
    String DATE_END	= "</date>\r\n";

    //--------//
    // Titel  //
    //--------//
    String TITLE_START = "<title>";
    String TITLE_END	= "</title>\r\n";

    //--------------//
    // Überschrift  //
    //--------------//
    String HEADLINE_START = "<headline>";
    String HEADLINE_END	= "</headline>\r\n";

    //-------------------//
    // Horizontalleiste  //
    //-------------------//
    String HORIZONTAL = "<horizontal/>\r\n";

    //-----------------//
    // Einfache Listen //
    //-----------------//
    String LIST_ITEM_END = "</listitem>\r\n";
    String LIST_ITEM_START = "<listitem>";
    String LIST_END	= "</list>\r\n";
    String LIST_START = "<list>\r\n";

    //--------------------//
    // Nummerierte Listen //
    //--------------------//
    String NUMBER_LIST_END	= "</numlist>\r\n";
    String NUMBER_LIST_START = "<numlist>\r\n";

    //--------//
    // Bilder //
    //--------//
    String IMAGE_START ="<figure>\r\n";
    String IMAGE_LINK_START = "<image link=\"";
    String IMAGE_SOURCE_START = "source=\"";
	  String IMAGE_CAPTION_START = "<figurecaption class=\"figure-caption text-left\">\r\n";
	  String IMAGE_CAPTION_END = "</figurecaption>\r\n";
	  String IMAGE_END = "</figure>\r\n";

	  //-------------------//
    // Codebox und -line //
    //-------------------//
    String CODEBOX_END	= "</codebox>\r\n";
    String CODEBOX_START = "<codebox>\r\n";
    String CODELINE_END	 = "</codeline>\r\n";
    String CODELINE_START = "<codeline>";

    //----------//
    // Links    //
    //----------//
    String LINKS_START = "<links>\r\n";
    String LINKS_END = "</links>\r\n";
    String LINK_START = "<link type=\"";
    String LINK_NAME_START = "<link name=\"";
    String LINK_END = "</link>\r\n";

    //-------------//
    // HyperLinks  //
    //-------------//
    String HYPER_LINKS_START = "<hyperlinks>\r\n";
    String HYPER_LINKS_END = "</hyperlinks>\r\n";
    String HYPER_LINK_START = "<hyperlink name=\"";
    String HYPER_LINK_END = "</hyperlink>\r\n";

    //-------------//
    // Main-Area   //
    //-------------//
    String MAIN_START = "<main>\r\n";
    String MAIN_END = "</main>\r\n";
    String MAIN_TOPIC_START = "<topic name=\"";
    String LINK = " link=\"";

    //-------------------------//
    // Start des XML-Dokuments //
    //-------------------------//
    String PROLOGUE = "<?xml version=\"1.0\" encoding=\"utf-8\" standalone=\'yes\'?>\r\n";

    //----------//
    // Scripts  //
    //----------//
    String SCRIPTS_START = "<scripts>\r\n";
    String SCRIPTS_END = "</scripts>\r\n";
    String SCRIPT_START = "<script>";
    String SCRIPT_END = "</script>\r\n";

    //-----------//
    // Sequenzen //
    //-----------//
    String SEQUENCE_START = "<sequence>\r\n";
    String SEQUENCE_ITEM_START = "<sequenceitem ";
    String SEQUENCE_LINE_START = "<sequenceline ";
    String SEQUENCE_END = "</sequence>\r\n";

    //-------------------//
    // Teilüberschriften //
    //-------------------//
    String SUBHEADLINE_START = "<subheadline id=\"";
    String SUBHEADLINE_END = "</subheadline>\r\n";

    //-----------------//
    // Text-Strukturen //
    //-----------------//
    String TEXT_START = "<text>\r\n";
    String TEXT_END = "</text>\r\n";

    //-----------//
    // Fettdruck //
    //-----------//
    String BOLD_START = "<bold>";
    String BOLD_END = "</bold>\r\n";

    /********************
    * Tabellenstrukturen
    ********************/
    //--------------------------------------//
    // Inhaltsverzeichnis: Table of Content //
    //--------------------------------------//
    String TABLE_OF_CONTENT_START = "<tableofcontent>\r\n";
    String TABLE_OF_CONTENT_END = "</tableofcontent>\r\n";
    String TABLE_OF_CONTENT_ITEM_END = "</item>\r\n";
    String TABLE_OF_CONTENT_ITEM_START = "<item>\r\n";
    String TABLE_OF_CONTENT_ITEM_HTML_NAME = "<html name=\"";
    String TABLE_OF_CONTENT_ITEM_PDF_NAME = "<pdf name=\"Als PDF-Dokument\" link=\"";

    //----------------------------------------//
    // Reguläre Tabellenstrukturen mit Inhalt //
    //----------------------------------------//
    String TABLE_START = "<table>\r\n";
    String TABLE_END = "</table>\r\n";
    String TABLE_HEADLINE_START = "<tableheadline>\r\n";
    String TABLE_HEADLINE_END= "</tableheadline>\r\n";
    String TABLE_ROW_START = "<tablerow>\r\n";
    String TABLE_ROW_END = "</tablerow>\r\n";
    String TABLE_HEADITEM_END = "</tableheaditem>\r\n";
    String TABLE_HEADITEM_START	= "<tableheaditem>";
    String TABLE_BODY_END = "</tablebody>\r\n";
    String TABLE_BODY_START	= "<tablebody>\r\n";
    String TABLE_ITEM_END = "</tableitem>\r\n";
    String TABLE_ITEM_START	= "<tableitem>";
    String TABLE_CAPTION_START = "<tablecaption>";
    String TABLE_CAPTION_END = "</tablecaption>\r\n";
}

