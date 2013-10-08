/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.justinbiber.test;

import ohtu.justinbiber.domain.FieldType;
import ohtu.justinbiber.domain.ValueType;
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
        ValueType text = new ValueType(ValueType.Type.TEXT);
        FieldType someType = new FieldType("autobiography", text);

        assertTrue(someType.getFieldKey().equals("autobiography"));
    }
}