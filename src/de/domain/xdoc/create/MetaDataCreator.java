package de.domain.xdoc.create;

import de.domain.xdoc.access.Writer;
import de.domain.xdoc.character.Text;
import de.domain.xdoc.character.XML;
import de.domain.xdoc.util.MetaData;

public class MetaDataCreator extends TextCreator {

  public static void createTitle(String title) {
    Writer.write(writer, Text.NEW_LINE);
    Writer.write(writer, Text.BLANK_02);
    Writer.write(writer, XML.TITLE_START);
    Writer.write(writer, title);
    Writer.write(writer, XML.TITLE_END);
  }

  public static void createAuthor() {
    Writer.write(writer, Text.BLANK_02);
    Writer.write(writer, XML.AUTHOR_START);
    Writer.write(writer, MetaData.getUserName());
    Writer.write(writer, XML.AUTHOR_END);
  }

  public static void createDate() {
    Writer.write(writer, Text.BLANK_02);
    Writer.write(writer, XML.DATE_START);
    Writer.write(writer, MetaData.getCurrentDate());
    Writer.write(writer, XML.DATE_END);
  }



}
