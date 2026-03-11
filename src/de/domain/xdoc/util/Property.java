package de.domain.xdoc.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Die Klasse Property ist die Property-Klasse der Anwendung. Sie lädt die
 * Properties, setzt die Keys und ermittelt für jeden Key das entsprechende
 * Property.
 *
 * @author schmi
 */

public class Property {

    // Variablen für den Zugriff
    private static File file;
    private static Properties properties;

    // Variablen für die PC-Namen
    private static String metaPC;
    private static String metaOldPC;
    private static String privatPC;
    private static String schmiPC;
    private static String timPC;
    private static String testPC;

    // Variablen für die Logging-Pfade
    private static String logPathTim;
    private static String logPathMeta;
    private static String logPathMetaOld;
    private static String logPathSchmi;
    private static String logPathPrivat;
    private static String logPathTest;

    // Variablen für die Basispfade
    private static String basePathTim;
    private static String basePathMeta;
    private static String basePathMetaOld;
    private static String basePathSchmi;
    private static String basePathPrivat;
    private static String basePathTest;

    // Variablen für die Testumgebungen
    private static String testPathTest;

    // Sonstige Variablen
    private static String userName;
    private static String errorHost;
    private static String localhost;

    /**
     * Die Methode setProperties() definiert das Property-File samt Pfad
     */
    public static void setProperties() {
        // Statische Variablen für den Zugriff auf die Properties
        String directory = System.getProperty("user.dir") + File.separator + "properties";
        file = new File(directory, "xdoc.properties");
        properties = new Properties();
        setKeys();
    }

    /**
     * The Methode setKey() setzt für jedes Property die Keys, um später einen Value
     * auszuwerten
     */
    private static void setKeys() {

        // Keys für die PC-Namen
        metaPC = "meta.pc";
        metaOldPC = "meta.old.pc";
        privatPC = "privat.pc";
        schmiPC = "schmi.pc";
        testPC = "test.pc";
        timPC = "tim.pc";

        // Keys für die Logging-Pfade
        logPathMeta = "logpath.meta";
        logPathMetaOld = "logpath.meta.old";
        logPathPrivat = "logpath.privat";
        logPathSchmi = "logpath.schmi";
        logPathTest = "logpath.test";
        logPathTim = "logpath.tim";

        // Keys für die Basis-Pfade
        basePathMeta = "basepath.meta";
        basePathMetaOld = "basepath.meta.old";
        basePathPrivat = "basepath.privat";
        basePathSchmi = "basepath.schmi";
        basePathTest = "basepath.test";
        basePathTim = "basepath.tim";

        // Sonstige Keys
        errorHost = "error.host";
        localhost = "localhost.xdoc";
        userName = "user.name";
    }

    /**
     * Die Methode load() erzeugt einen Eingabestrom mit Dateinamen und lädt die
     * Properties des Projekts
     */
    public static void load() {
        try {
            FileInputStream inputStream = new FileInputStream(file);
            properties.load(inputStream);
        } catch (IOException ioException) {
            ioException.getMessage();
        }
    }

    //---------------------------//
    // Zugriffe auf die PC-Namen //
    //---------------------------//
    /**
     * Die Methode getTimPC() ermittelt den Computernamen zu Tim-PC
     *
     * @return timPcValue
     */
    public static String getTimPC() {
        return properties.getProperty(timPC);
    }

    /**
     * Die Methode getMetaPC() ermittelt den Computernamen zu Meta-PC
     *
     * @return metaPcValue
     */
    public static String getMetaPC() {
        return properties.getProperty(metaPC);
    }

    /**
     * Die Methode getMetaOldPC() ermittelt den Computernamen zu MetaOld-PC
     *
     * @return metaPcValue
     */
    public static String getMetaOldPC() {
        return properties.getProperty(metaOldPC);
    }

    /**
     * Die Methode getSchmiPC() ermittelt den Computernamen zu Schmi-PC
     *
     * @return schmiPcValue
     */
    public static String getSchmiPC() {
        return properties.getProperty(schmiPC);
    }

    /**
     * Die Methode getPrivatPC() ermittelt den Computernamen zu PRIVAT-PC
     *
     * @return privatPcValue
     */
    public static String getPrivatPC() {
        return properties.getProperty(privatPC);
    }

    /**
     * Die Methode getTestPC() ermittelt den Computernamen zu Test-PC
     *
     * @return testPcValue
     */
    public static String getTestPC() {
        return properties.getProperty(testPC);
    }

    //--------------------------------//
    // Zugriffe für die Logging-Pfade //
    //--------------------------------//
    /**
     * Die Methode getLogPathMeta() ermittelt den Logging Pfad auf Meta-PC
     *
     * @return logPathMetaValue
     */
    public static String getLogPathMeta() {
        return properties.getProperty(logPathMeta);
    }

    /**
     * Die Methode getLogPathMetaOld() ermittelt den Logging Pfad auf MetaOld-PC
     *
     * @return logPathMetaValue
     */
    public static String getLogPathMetaOld() {
        return properties.getProperty(logPathMetaOld);
    }

    /**
     * Die Methode getLogPathSchmi() ermittelt den Logging Pfad auf dem Schmi-PC
     *
     * @return logPathSchmiValue
     */
    public static String getLogPathSchmi() {
        return properties.getProperty(logPathSchmi);
    }

    /**
     * Die Methode getLogPathPrivat() ermittelt den Logging Pfad auf PRIVAT-PC
     *
     * @return logPathPrivatValue
     */
    public static String getLogPathPrivat() {
        return properties.getProperty(logPathPrivat);
    }

    /**
     * Die Methode getLogPathTest() ermittelt den Logging Pfad auf Test-PC
     *
     * @return logPathTestValue
     */
    public static String getLogPathTest() {
        return properties.getProperty(logPathTest);
    }

    /**
     * Die Methode getLogPathTim() ermittelt den Logging Pfad auf Tim-PC
     *
     * @return logPathTimValue
     */
    public static String getLogPathTim() {
        return properties.getProperty(logPathTim);
    }

    //--------------------------------//
    // Zugriffe für die Logging-Pfade //
    //--------------------------------//
    /**
     * Die Methode getBasePathMeta() ermittelt den Basispfad auf dem Meta-PC
     *
     * @return basePathMeta
     */
    public static String getBasePathMeta() {
        return properties.getProperty(basePathMeta);
    }

    /**
     * Die Methode getBasePathMetaOld() ermittelt den Basispfad auf dem MetaOld-PC
     *
     * @return basePathMetaOld
     */
    public static String getBasePathMetaOld() {
        return properties.getProperty(basePathMetaOld);
    }

    /**
     * Die Methode getBasePathPrivat() ermittelt den Basis-Pfad auf PRIVAT-PC
     *
     * @return basePathPrivatValue
     */
    public static String getBasePathPrivat() {
        return properties.getProperty(basePathPrivat);
    }

    /**
     * Die Methode getBasePathSchmi() ermittelt den Basispfad auf dem Schmi-PC
     *
     * @return basePathSchmi
     */
    public static String getBasePathSchmi() {
        return properties.getProperty(basePathSchmi);
    }

    /**
     * Die Methode getBasePathTest() ermittelt den Basis-Pfad auf DESKTOP-LERLCJ6
     *
     * @return basePathTestValue
     */
    public static String getBasePathTest() {
        return properties.getProperty(basePathTest);
    }

    /**
     * Die Methode getBasePathTim() ermittelt den Basispfad auf dem Tim-PC
     *
     * @return basePathTim
     */
    public static String getBasePathTim() {
        return properties.getProperty(basePathTim);
    }

    // Sonstige Zugriffe
    /**
     * Die Methode getErrorHost() ermittelt die Fehlermeldung, wenn kein Rechner
     * definiert wurde
     *
     * @return errorHostValue
     */
    public static String getErrorHost() {
        return properties.getProperty(errorHost);
    }

    /**
     * Die Methode getLocalhost() ermittelt den Localhost-Pfad der Anwendung
     *
     * @return localhostValue
     */
    public static String getLocalhost() {
        return properties.getProperty(localhost);
    }

    /**
     * Die Methode getUserName() ermittelt den Benutzernamen
     *
     * @return userName
     */
    public static String getUserName() {
        return properties.getProperty(userName);
    }
}
