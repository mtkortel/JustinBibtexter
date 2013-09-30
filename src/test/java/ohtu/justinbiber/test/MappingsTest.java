/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.justinbiber.test;

import ohtu.justinbiber.domain.Mappings;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author danipallo
 */
public class MappingsTest {

    public MappingsTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //

    @Test
    public void simpleFixMappingsTest1() {
        Mappings mappings = new Mappings();


        String fixMappings = mappings.fixMappings("Ä");

        assertTrue("fixMappings palauttaa:" + fixMappings, fixMappings.equals("\\\"{A}"));
    }

    @Test
    public void simpleFixMappingsTest() {
        Mappings mappings = new Mappings();
        String fixMappings = mappings.fixMappings("");
        assertTrue(fixMappings.equals(""));

        fixMappings = mappings.fixMappings("Ö");

        assertTrue("fixMappings palauttaa:" + fixMappings, fixMappings.equals("\\\"{O}"));
    }

    @Test
    public void simpleFixMappingsTest2() {
        Mappings mappings = new Mappings();
        String fixMappings = mappings.fixMappings("");
        assertTrue(fixMappings.equals(""));

        fixMappings = mappings.fixMappings("öä");

        assertTrue("fixMappings palauttaa:" + fixMappings, fixMappings.equals("\\\"{o}\\\"{a}"));
    }
}