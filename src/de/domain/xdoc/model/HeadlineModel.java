package de.domain.xdoc.model;

import de.domain.xdoc.check.TextChecker;

public class HeadlineModel {

    // Zustandsvariablen
    private static boolean isHeadline;

    public static void setModel(int lineNumber) {
        isHeadline = TextChecker.checkHeadline(isHeadline, lineNumber);
    }

    public static boolean isHeadline() {
        return isHeadline;
    }


}
