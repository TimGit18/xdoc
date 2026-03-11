package de.domain.xdoc.process;

import de.domain.xdoc.create.ImageCreator;

/**
 * Die Klasse ImageProcessor() sorgt für die Enstehung eines Bildes.
 */
public class ImageProcessor {

    /**
     * Die Methode createImage() erzeugt den Anfang, den Verweis, die Beschreibung und das Ende eines Bilds
     * @param isImage
     * @param isImageDescription
     * @param isImageLine
     * @param line
     * @param localImagePath
     * @param imagePath
     */
    public static void createImage(boolean isImage, boolean isImageDescription, boolean isImageLine, String line,
                                   String localImagePath, String imagePath) {
        if (isImage && !isImageDescription) ImageCreator.createImageStart();
        if (isImageLine) ImageCreator.createImageLink(line, localImagePath, imagePath);
        if (isImageDescription) ImageCreator.createImageCaption(line);
        if (isImageDescription) ImageCreator.createImageEnd();
    }

}
