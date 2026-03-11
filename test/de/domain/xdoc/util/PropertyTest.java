package de.domain.xdoc.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Notwendig wegen JUnit 5
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

// Klasse unter Test
import de.domain.xdoc.util.Property;

class PropertyTest {

    // Variablen für PC-Namen
    String EXPECTED_META_PC = "20H0417";
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
        Property.setProperties();
        Property.load();
    }

    /**
     * Test der PC-Namen
     */
    @Test
    void testGetMetaPC() {
        assertEquals(EXPECTED_META_PC, Property.getMetaPC());
    }

    @Test
    void testGetPrivatPC() {
        assertEquals(EXPECTED_PRIVAT_PC, Property.getPrivatPC());
    }

    @Test
    void testGetSchmiPC() {
        assertEquals(EXPECTED_SCHMI_PC, Property.getSchmiPC());
    }

    @Test
    void testGetTestPC() {
        assertEquals(EXPECTED_TEST_PC, Property.getTestPC());
    }

    @Test
    void testGetTimPC() {
        assertEquals(EXPECTED_TIM_PC, Property.getTimPC());
    }

    /**
     * Test der Logging-Pfade
     */

    @Test
    void testGetLogPathMeta() {
        assertEquals(EXPECTED_LOGPATH_META, Property.getLogPathMeta());
    }

    @Test
    void testGetLogPathPrivat() {
        assertEquals(EXPECTED_LOGPATH_PRIVAT, Property.getLogPathPrivat());
    }

    @Test
    void testGetLogPathSchmi() {
        assertEquals(EXPECTED_LOGPATH_SCHMI, Property.getLogPathSchmi());
    }

    @Test
    void testGetLogPathTest() {
        assertEquals(EXPECTED_LOGPATH_TEST, Property.getLogPathTest());
    }

    @Test
    void testGetLogPathTim() {
        assertEquals(EXPECTED_LOGPATH_TIM, Property.getLogPathTim());
    }


    /**
     * Test der Basispfade
     */
    @Test
    void testGetBasePathMeta() {
        assertEquals(EXPECTED_BASEPATH_META, Property.getBasePathMeta());
    }

    @Test
    void testGetBasePathPrivat() {
        assertEquals(EXPECTED_BASEPATH_PRIVAT, Property.getBasePathPrivat());
    }

    @Test
    void testGetBasePathSchmi() {
        assertEquals(EXPECTED_BASEPATH_SCHMI, Property.getBasePathSchmi());
    }

    @Test
    void testGetBasePathTest() {
        assertEquals(EXPECTED_BASEPATH_TEST, Property.getBasePathTest());
    }

    @Test
    void testGetBasePathTim() {
        assertEquals(EXPECTED_BASEPATH_TIM, Property.getBasePathTim());
    }


    /**
     * Test des Benutzernamens
     */
    @Test
    void testGetUserName() {
        assertEquals(EXPECTED_USER_NAME, Property.getUserName());
    }

    /**
     * Test der Fehlermeldung
     */
    @Test
    void testGetErrorHost() {
        assertEquals(EXPECTED_ERROR_HOST, Property.getErrorHost());
    }

}
