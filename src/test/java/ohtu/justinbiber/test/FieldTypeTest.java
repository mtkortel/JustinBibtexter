/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.justinbiber.test;

import ohtu.justinbiber.domain.FieldType;
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
public class FieldTypeTest {

    public FieldTypeTest() {
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
    public void FieldTypeSetKeyWorks() {
        FieldType someType = new FieldType("autobiography");

        assertTrue(someType.getKey().equals("autobiography"));
    }
}