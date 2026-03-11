package de.domain.xdoc.control;

import java.io.IOException;
import java.net.InetAddress;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import de.domain.xdoc.util.Property;

/**
 * Die Klasse MainRun ist die Hauptklasse der Anwendung. Der Start der Anwendung geschieht mit dem
 * Aufruf der Hauptmethode main(). Zuerst wird die System-Umgebung initialisiert.
 * Anschließend inspiziert sie die System-Umgebung der Anwendung und legt in Abhängigkeit von der
 * Umgebung fest, an welcher Stelle die Daten der Anwendung gelogget werden. Zum Schluß wird die
 * Kontrolle der Anwendung übergeben und die Anwendungssteuerung (Control) aufgerufen.
 * @author Tim Schmitz
 */

public class MainRun {

	// Parameter der Anwendung
	private static String TIM_PC = null;
	private static String META_PC = null;
	private static String SCHMI_PC = null;
	private static String PRIVAT_PC = null;
	private static String TEST_PC = null;

	private static String ERROR_HOST = null;

	private static String LOG_PATH_TIM_PC = null;
	private static String LOG_PATH_META_PC = null;
	private static String LOG_PATH_SCHMI_PC = null;
	private static String LOG_PATH_PRIVAT_PC = null;
	private static String LOG_PATH_TEST_PC = null;

	private static String BASE_PATH_TIM_PC = null;
	private static String BASE_PATH_META_PC = null;
	private static String BASE_PATH_SCHMI_PC = null;
	private static String BASE_PATH_PRIVAT_PC = null;
	private static String BASE_PATH_TEST_PC = null;

	/**
	 * Die Hauptmethode der Anwendung initialisiert den Umgebungskontext und setzt die System-Properties.
	 *
	 * <ul>
	 *   <li>Der Computername ist der Name des hostenden Rechners, auf dem die Anwendung läuft.</li>
	 *   <li>Der Localhost ist der Name des Schemas, des Serverhosts plus des Ports und der Anwendung.</li>
	 *   <li>Der Logpath ist der absolute Logging-Path der Anwendung, der von dem Computernamen abhängt.</li>
	 *   <li>Der Basepath ist der sogenannte Basispfad der Anwendung. Seine mittlere Komponente hängt ebenfalls
	 *   		 von dem Computernamen ab.</li>
	 * </ul>
	 *
	 * Anschließend wird der Systemkontext des Loggers initialisiert. Das bedeutet, dass man in der Laufzeitumgebung
	 * ein System-Property setzt, die von der Konfigurationsdatei des Loggers log4j2.xml verwendet wird.
	 *
	 * Zum Schluß wird die Kontrolle der Anwendung an die Hauptsteuerung übergeben.
	 *
	 * @param args Argumente, hier Systemkontext
	 */
	public static void main(String[] args) {

		// Initialisierung
		initialize();

		// Setzen der System-Properties
		String computerName = getHostName();
		String localhost = Property.getLocalhost();
		String logPath = getLogPath(computerName);
		String basePath = getBasePath(computerName);

		// Setzen des System-Logging-Pfades und Übergabe des Umgebungsparameters anhand des Aufrufs der Anwendung
		setSystemLogPath(logPath);
		String systemEnvironment = args[0];

		// Parameter, um den Workflow zu steuern
		Logger LOG = LogManager.getLogger(MainRun.class.getName());
		LOG.trace("LogPath: " + logPath);

		// Check, ob der Environment-Parameter definiert ist
		if (systemEnvironment.isEmpty()) {
			LOG.fatal("Kein Systemkontext-Parameter definiert");
		} else {
			LOG.trace("Systemkontext: " + systemEnvironment);
		}

		// Hauptsteuerung übergeben
		Control.run(basePath,systemEnvironment,localhost);

	}

	/**
	 * Die Methode getHostName() ermittelt den Rechnernamen. Dieser wird später für
	 * den Logging-Kontext und den Basispfad benötigt
	 * @return hostName
	 */
	public static String getHostName() {
		String hostName = "";


		// Den Rechnernamen aus der Umgebung holen
		try {
			hostName = InetAddress.getLocalHost().getHostName();
		} catch (IOException ioException) {
			System.err.println(ioException.getMessage());
		}
		return hostName;
	}

	/**
	 /**
	 * Die Methode getLogPath() ermittelt den (zu setzenden) Logging Path abhänging
	 * vom Rechnernamen.
	 * @param computerName Name des Rechners, auf dem die Anwendung läuft
	 * @return logPath
	 */
	public static String getLogPath(String computerName) {
		String logPath = "";

		// Abfrage des Rechnernamens und setzen des Logging Pfads
		if (TIM_PC.equals(computerName)) {
			logPath = LOG_PATH_TIM_PC;
		} else if (META_PC.equals(computerName)) {
			logPath = LOG_PATH_META_PC;
		} else if (SCHMI_PC.equals(computerName)) {
			logPath = LOG_PATH_SCHMI_PC;
		} else if (PRIVAT_PC.equals(computerName)) {
			logPath = LOG_PATH_PRIVAT_PC;
		} else if (TEST_PC.equals(computerName)) {
			logPath = LOG_PATH_TEST_PC;
		} else {
			System.err.println(ERROR_HOST);
		}

		return logPath;
	}

	/**
	 * Die Methode getBasePath() ermittelt den Basispfad zu dem Rechnernamen. Ebenso
	 * wie der Logging-Pfad hängt der Basispfad vom Rechnernamen ab.
	 * @param computerName Name des Rechners, auf dem die Anwendung läuft
	 * @return basePath
	 */
	public static String getBasePath(String computerName) {
		String basePath = "";

		// Abfrage des Rechnernamens und setzen des Basis-Pfads
		if (TIM_PC.equals(computerName)) {
			 basePath = BASE_PATH_TIM_PC;
		} else if (META_PC.equals(computerName)) {
			 basePath = BASE_PATH_META_PC;
		} else if (SCHMI_PC.equals(computerName)) {
			 basePath = BASE_PATH_SCHMI_PC;
		} else if (PRIVAT_PC.equals(computerName)) {
			basePath = BASE_PATH_PRIVAT_PC;
		} else if (TEST_PC.equals(computerName)) {
			basePath = BASE_PATH_TEST_PC;
		} else {
			System.err.println(ERROR_HOST);
		}

		// Rückgabe des Basis-Pfades
		return basePath;
	}


	/**
	 * Die Methode initialize() setzt die Propiertes und lädt sie. Dann werden die
	 * möglichen Computernamen und ihre zugehörigen Logging-Pfade ermittelt sowie
	 * eine Fehlermeldung
	 */
	public static void initialize() {

		// Properties setzen und laden
		Property.setProperties();
		Property.load();

		// Computernamen ermitteln
		TIM_PC = Property.getTimPC();
		META_PC = Property.getMetaPC();
		SCHMI_PC = Property.getSchmiPC();
		PRIVAT_PC = Property.getPrivatPC();
		TEST_PC = Property.getTestPC();

		// Logging-Pfade ermitteln
		LOG_PATH_TIM_PC = Property.getLogPathTim();
		LOG_PATH_META_PC = Property.getLogPathMeta();
		LOG_PATH_SCHMI_PC = Property.getLogPathSchmi();
		LOG_PATH_PRIVAT_PC = Property.getLogPathPrivat();
		LOG_PATH_TEST_PC = Property.getLogPathTest();

		// Basispfade ermitteln
		BASE_PATH_TIM_PC = Property.getBasePathTim();
		BASE_PATH_META_PC = Property.getBasePathMeta();
		BASE_PATH_SCHMI_PC = Property.getBasePathSchmi();
		BASE_PATH_PRIVAT_PC = Property.getBasePathPrivat();
		BASE_PATH_TEST_PC = Property.getBasePathTest();

		// Error Message ermitteln
		ERROR_HOST = Property.getErrorHost();
	}

	/**
	 * Die Methode setSystemLogPath() setzt den Logging Pfad als System-Property.
	 * Dieses Property bleibt während der Laufzeit der Anwendung erhalten.
	 */

	public static void setSystemLogPath(String logPath) {
		System.setProperty("log.path", logPath);
	}

}
