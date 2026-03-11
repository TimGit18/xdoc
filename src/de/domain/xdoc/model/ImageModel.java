package de.domain.xdoc.model;

import de.domain.xdoc.check.ImageChecker;

/**
 * Die Klasse ImageModel repräsentiert das Model eines Images.
 */
public class ImageModel {

    // State variables
    private static boolean isImage;
    private static boolean isImageLine;
    private static boolean isImageDescription;

    // Getter
    public static boolean isImage() {
        return isImage;
    }

    public static boolean isImageLine() {
        return isImageLine;
    }

    public static boolean isImageDescription() {
        return isImageDescription;
    }

    // Sets the model
    public static void setModel(String line) {
        isImageLine = ImageChecker.checkImageLine(line);
        if (isImageLine) isImage = true;
        isImageDescription = ImageChecker.checkImageDescription(line, isImage);
        if (isImage && TextModel.isBlankline()) isImage = false;
    }


}
