package de.domain.xdoc.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MetaData {

    /**
     * Die Methode getCurrentDate ermittelt das Systemdatum aus dem Date-Objekt.
     * @return aktuelles Datum
     */
    public static String getCurrentDate() {
        Date date = new Date(); // This object contains the current date value
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        return formatter.format(date);
    }

    /**
     * Die Methode getCuserName ermittelt den Benutzernamen aus den Properties
     * @return userName
     */
    public static String getUserName() {
        return Property.getUserName();
    }




}
