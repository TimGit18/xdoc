package de.domain.xdoc.control;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import de.domain.xdoc.control.MainRun;

class MainRunTest {

	// Variablen für PC-Namen
	String EXPECTED_META_PC = "19H0116";
	String EXPECTED_PRIVAT_PC = "PRIVAT-PC";
	String EXPECTED_SCHMI_PC = "LAPTOP-LR4C72NS";
	String EXPECTED_TEST_PC = "DESKTOP-LERLCJ6";
	String EXPECTED_TIM_PC = "Tim-PC";

	// Variablen für die Logging-Pfade
	String EXPECTED_LOGPATH_META = "C:\\Users\\TSZ\\Daten\\Java\\Applications\\xdoc\\logs";
	String EXPECTED_LOGPATH_PRIVAT = "C:\\Users\\Administrator\\Daten\\Java\\Applications\\xdoc\\logs";
	String EXPECTED_LOGPATH_SCHMI = "C:\\Users\\schmi\\Daten\\Java\\Applications\\xdoc\\logs";
	String EXPECTED_LOGPATH_TEST = "C:\\Users\\Test\\Daten\\Java\\Applications\\xdoc\\logs";
	String EXPECTED_LOGPATH_TIM = "C:\\Users\\Tim\\Daten\\Java\\Applications\\xdoc\\logs";

	// Variablen für die Basispfade
	String EXPECTED_BASEPATH_META = "C:\\Users\\TSZ\\Daten\\Web\\xdoc";
	String EXPECTED_BASEPATH_PRIVAT = "C:\\Users\\Administrator\\Daten\\Web\\xdoc";
	String EXPECTED_BASEPATH_SCHMI = "C:\\Users\\schmi\\Daten\\Web\\xdoc";
	String EXPECTED_BASEPATH_TEST = "C:\\Users\\Test\\Daten\\Web\\xdoc";
	String EXPECTED_BASEPATH_TIM = "C:\\Users\\Tim\\Daten\\Web\\xdoc";

	// Sonstige Variablen
	String EXPECTED_USER_NAME = "Tim Schmitz";
	String EXPECTED_ERROR_HOST = "Kein Computername definiert";

	/**
	 * Bevor irgendein Testfall ausgeführt wird, müssen erst die Properties gesetzt
	 * und geladen werden
	 */
	@BeforeAll
	public static void prepare() {
		MainRun.initialize();
	}

	@Test
	void testGetHostNameTest() {
		assertEquals(EXPECTED_TEST_PC, MainRun.getHostName());
	}

	@Test
	void testGetLogPathSchmi() { assertEquals(EXPECTED_LOGPATH_SCHMI, MainRun.getLogPath(EXPECTED_SCHMI_PC));
	}

	@Test
	void testGetBasePathSchmi() {
		assertEquals(EXPECTED_BASEPATH_SCHMI, MainRun.getBasePath(EXPECTED_SCHMI_PC));
	}

	@Test
	void testSetSystemLogPath() {
		MainRun.setSystemLogPath(EXPECTED_LOGPATH_TEST);
		System.out.println(System.getProperty("log.path"));
		assertEquals(EXPECTED_LOGPATH_TEST, MainRun.getLogPath(EXPECTED_TEST_PC));
	}
}
