package ohtu.justinbiber.test;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import ohtu.justinbiber.domain.Entry;
import ohtu.justinbiber.domain.EntryType;
import ohtu.justinbiber.domain.Field;
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
public class EntryTest {

    public EntryTest() {
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
    public void constructAnEntry() {
        Entry entry = new Entry(EntryType.INPROCEEDINGS);

        assertTrue(entry.getType() == EntryType.INPROCEEDINGS);
        assertTrue(entry.getKey() == null);

    }

    @Test
    public void requiredFieldTypesReturnsApproximatelyRight() {

        FieldType[] fields = new FieldType[8];
        EntryType type = new EntryType("unknown type", fields);
        assertTrue(type.getRequiredFieldTypes().length == 8);

    }

    @Test
    public void setTypeSetsType() {
        Entry entry = new Entry(EntryType.INPROCEEDINGS);

        EntryType type2 = new EntryType("poetry collection", new FieldType[4]);

        entry.setType(type2);
        assertTrue(entry.getType() == type2);
    }

    @Test
    public void settingAndGettingKeys() {
        Entry entry = new Entry(EntryType.INPROCEEDINGS);

        entry.setKey("newKey");

        assertTrue(entry.getKey().equals("newKey"));
    }
    /* Minimal test for getValue method
     */
     @Test
    public void getValue() {
        Entry entry = new Entry(new EntryType("", new FieldType[0]));

        entry.addField("EDITION", "8.");
        
         System.err.println(entry.getValue("EDITION"));

        assertTrue(entry.getValue("EDITION").equals("8."));
    }

    @Test
    public void addFieldAddsAField() {

        Entry entry = new Entry(EntryType.INPROCEEDINGS);

        int length = entry.getFields().size();
        entry.addField("EDITION", "2.");
        assertTrue(length < entry.getFields().size());
    }

    @Test
    public void getTitleReturnsRight() {

        Entry entry = new Entry(new EntryType("poetry collection", new FieldType[0]));

        entry.addField("TITLE", "Hurricane Hunting");
        assertTrue(entry.getTitle().equals("Hurricane Hunting"));

    }
}