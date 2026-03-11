package de.domain.xdoc.character;

public interface Text {

    //----------------------//
    // Globale Bezeichner   //
    //----------------------//
    String NIL ="";
    String CONF = "conf";
    String CSS = "css";
    String FILE = "file";
    String FOP = "fo";
    String HTML = "html";
    String IMG = "img";
    String LIB = "lib";
    String PDF = "pdf";
    String RESOURCES = "resources";
    String TEXT = "txt";
    String XML = "xml";
    String XSL = "xsl";

    //----------------------//
    // Dateibezeichner      //
    //----------------------//
    String ANGULAR_JS = "angular.js";
    String BOOTSTRAP_MIN_CSS = "bootstrap.min.css";
    String BOOTSTRAP_MIN_JS = "bootstrap.min.js";
    String BOOTSTRAP_TOC_MIN_CSS = "bootstrap-toc.min.css";
    String BOOTSTRAP_TOC_MIN_JS = "bootstrap-toc.min.js";
    String JQUERY_MIN_JS = "jquery-3.2.1.min.js";
    String FAVICON_SVG = "favicon.svg";
    String FAVICON_ICO = "favicon.ico";
    String FOP_CONFIG_XML = "fopConfig.xml";
    String FOSHEET_XSL = "fosheet.xsl";
    String POPPER_MIN_JS = "popper.min.js";
    String STYLESHEET_CSS = "stylesheet.css";
    String STYLESHEET_XSL = "stylesheet.xsl";
    String STYLESHEET_TOC_XSL = "stylesheet-toc.xsl";

    //----------------------//
    // Trennzeichen         //
    //----------------------//
    String SEPARATOR = "\\\\";                          // '\\'
    String SEPARATOR_AT_END = "\\\\$";                  // '\\'/n
    String FORWARD_SLASH = "/";                         // '/'
    String BACK_SLASH = "\\";
    String TRIPLE_SLASH ="///";                         // '///'

    //----------------------//
    // Datei-Endungen       //
    //----------------------//
    String SUFFIX_FOP = ".fo";                         // '.fop'
    String SUFFIX_HTML = ".html";                       // .html
    String SUFFIX_PDF = ".pdf";                         // .pdf
    String SUFFIX_TEXT = ".txt";                        // .txt
    String SUFFIX_XML =".xml";                          // .xml

    //----------------------//
    // Pfadbestandteile     //
    //----------------------//
    String START_TO_TEXT = "^(.*)Text\\\\";             // '....Text\\'

    //----------------------//
    // Dokumenten-Typen     //
    //----------------------//
    String TYPE = " type=\"";
    String TYPE_CONTENT = "content";
    String TYPE_TOPIC = "topic";

    //----------//
    // Tabellen //
    //----------//
    String TABLE_LINE = "^\\s\\-\\-(.*)$";		                // ' ----'
    String TABLE_ROW = "^\\|(.*)$";					            // '|'
    String TABLE_ROW_DELIMITER	= "\\|";			            // '  |  '
    String TABLE_CAPTION  = "^Tabelle(.*):(.*)$";               // 'Tabelle 1: Elemente '

    //--------//
    // Bilder //
    //--------//
    String IMAGE_LINE = "^(.*)(\\s+)\\-\\-\\>(.*)(\\S+)$";      // 'Abbildung 1 --> Test-Bild'
    String IMAGE_DESCRIPTION = "^Abbildung(.*):(.*)$";	        // 'Abbildung 1: Bildunterschrift'
    String IMAGE_REF = "^(.*)(\\s+)\\-\\-\\>(\\s+)";            // 'Abbildung 1 --> '

    //----------//
    // Links    //
    //----------//
    String LINK_LINE = "^(.*)(\\s+)\\-\\-\\-\\>(\\s+)(\\S+)$";  // 'Link-Name ---> Referenz"
    String LINK_LINE_START = "^(.*)(\\s+)\\-\\-\\-\\>(\\s+)";   // 'Link-Name ---> "
    String LINK_LINE_END = "(\\s+)\\-\\-\\-\\>(\\s+)(\\S+)$";   // ' ---> Referenz"

    //-----------//
    // Codeboxen //
    //-----------//
    String CODELINE = "^\\_(\\s+)(.*)$";						// '_ ...'
    String CODELINE_START = "^\\_(\\s+)";						// '_   '
    String CODELINE_END = "(\\s+)\\_$";						    // '   _'
    String CODEBOX	= "^\\_$";                                  // '_'

    //-----------//
    // Sequenzen //
    //-----------//
    String START = "start=\"";
	String TARGET = "target=\"";
    String COMMENT = "comment=\"";
    String DIALOGUE = "dialogue=\"yes\"";
    String SEQUENCE_HEAD = "^\\S+(.*)\\s+\\=\\=\\>\\s+(.*)$";		                // 'File    ==> Open Project...'
    String SEQUENCE_HEAD_START = "^\\S+(.*)\\s+\\=\\=\\>\\s+";						// 'Start	==> '
    String SEQUENCE_HEAD_END = "\\s+\\=\\=\\>\\s+(.*)$";						// '        ==>	irgendwas'
    String SEQUENCE_SYMBOL = "^\\s+\\=\\=\\>\\s+";                              // '        ==> '
    String SEQUENCE_DIALOGUE = "^(.*)(\\s+)\\=\\=\\>(\\s+)(.*)-Dialog(.*)$";    // '        ==> Open Project-Dialog'
    String SEQUENCE_LINE = "^(\\s+)\\=\\=\\>(\\s+)(.*)$";                       // '        ==> Name (projectname) '
    String SEQUENCE_ITEM = "^(\\s+)(\\w+)(.*)$";                                // '             Version'
    String SEQUENCE_COMMENT	= "\\s+\\((.*)\\)";									// '  (...) '
    String SEQUENCE_COMMENT_END	= "\\)(.*)$";									//  '  ) '
    String SEQUENCE_COMMENT_FULL	= "^(.*)\\s+\\((.*)\\)(.*)$";				//  '....  (...) ...'
    String SEQUENCE_COMMENT_START = "^(.*)\\(";									//  '  ( '

    //----------------------//
    // Inhaltsverzeichnis   //
    //----------------------//
    String TABLE_OF_CONTENT_START = "^Inhalt$";		    // 'Inhalt'

    // Diskrete Leerzeichen
    String BLANK_01 = " ";                              // ' '
    String BLANK_02 = "  ";                             // '  '
    String BLANK_04 = "    ";                           // '    '
    String BLANK_06 = "      ";                         // '      '
    String BLANK_08 = "        ";                       // '        '
    String BLANK_10 = "          ";                     // '          '
    String BLANK_12 = "            ";                   // '            '

    //--------------------------//
    // Indiskrete Leerzeichen   //
    //--------------------------//
    String BLANK_END = "(\\s+)$";					    // '    '/n
    String BLANK_LINE = "^(\\s*)$";                     // '           '/n
    String BLANK_START = "^(\\s+)";                     // '    asdfadf'

    //--------------------//
    // Reguläre Ausdrücke //
    //--------------------//
    String WORD_CHARACTER       = "^(\\w+)(.*)$";       // [a-zA-Z_0-9]
    String UMLAUT_CHARACTER     = "^[äüößÄÜÖ](.*)$";        // [äÄöÖüÜß]
    String PARENTHESIS_CHAR     = "^\\((.*)$";          // (
    String DOUBLE_QUOTE_CHAR    = "^\\\"(.*)$";         // "
    String SINGLE_QUOTE_CHAR    = "^\\'(.*)$";          // '
    String HYPHEN_CHAR          = "^\\-(.*)$";          // -
    String EQUALS_SIGN_START    = "^=(.*)$";            // '===   '
    String BEGIN_OF_LINE        = "^(.*)";              // '...   '

    //--------------------------------------------------------------//
    // Zeilenumbruch mit neuer Zeile (Carriage Return + New Line)   //
    //--------------------------------------------------------------//
    String EMPTY = "";
    String NEW_LINE = "\r\n";

    //------------------//
    // Doppelpunkte     //
    //------------------//
    String COLON = ":";                                 // ':'
    String COLON_START_LINE = "^\\:(.*)";				// ':asdf  '
    String COLON_START = "^\\:";				        // ':  '

    //-------------------//
    // Sonderzeichen     //
    //-------------------//
    String LESS_THAN_SIGN = "\\<";                      // '<'
    String GREATER_THAN_SIGN = "\\>";                   // '>'
    String AMPERSAND = "\\&";                           // '&'
    String AMPERSAND_LINE = "^(.*)\\&(.*)$";            // '&'

    //-------------------//
    // Listenstrukturen  //
    //-------------------//
    String LIST_ITEM = "^(\\s*)\\*(.*)$";				        // '*....'
    String LIST_ITEM_START	= "^(\\s+)\\*(\\s+)";               // '* Listenelement
    String NUMBER_LIST_ITEM	= "^(\\s*)(\\d+)\\.(.*)$";	        // '1.xxxx'
    String NUMBER_LIST_ITEM_START = "^(\\s*)(\\d+)\\.(\\s+)";	// '1. Erstes Element '

    //-------------------//
    // Anführungsstriche //
    //-------------------//
    String QUOTE = "\"";                            // '"'

    //-------//
    // Tags  //
    //-------//
    String TAG_END_QUOTE = "\">";                   // '">'
    String TAG_END_CRNL = ">\r\n";                  // '>' mit Zeilenumbruch
    String TAG_END_CLOSE_CRNL = "/>\r\n";           // '/>' mit Zeilenumbruch
    String TAG_END_QUOTE_CLOSE_CRNL = "\"/>\r\n";   // '"/>' mit Zeilenumbruch
}
