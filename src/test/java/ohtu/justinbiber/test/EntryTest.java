package ohtu.justinbiber.test;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import ohtu.justinbiber.domain.Entry;
import ohtu.justinbiber.domain.EntryType;
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
        EntryType entryType = new EntryType("", new FieldType[0]);

        Entry entry = new Entry(entryType);

        assertTrue(entry.getType() == entryType);
        assertTrue(entry.getEntryKey() == null);

    }

    @Test
    public void requiredFieldTypesReturnsApproximatelyRight() {

        FieldType[] fields = new FieldType[8];
        EntryType type = new EntryType("unknown type", fields);
        assertTrue(type.getRequiredFieldTypes().size() == 8);

    }

    @Test
    public void setTypeSetsType() {
        EntryType entryType = new EntryType("", new FieldType[0]);
        Entry entry = new Entry(entryType);

        EntryType type2 = new EntryType("poetry collection", new FieldType[4]);

        entry.setType(type2);
        assertTrue(entry.getType() == type2);
    }

    @Test
    public void settingAndGettingKeys() {
        EntryType entryType = new EntryType("", new FieldType[0]);
        Entry entry = new Entry(entryType);

        entry.setEntryKey("newKey");

        assertTrue(entry.getEntryKey().equals("newkey"));
    }
    /* Minimal test for getValue method
     */

    @Test
    public void getValue() {
        Entry entry = new Entry(new EntryType("", new FieldType[0]));

        entry.addField("EDITION", "8.");
        entry.addField("SERIES", null);
        entry.addField("TITLE", "alexander");
        entry.addField("INK", "Dubious Hermit");


        assertTrue(entry.getValue("EDITION").equals("8."));
    }

    /* Minimal test for getValue method
     */
    @Test
    public void getValue2() {
        Entry entry = new Entry(new EntryType("", new FieldType[0]));


        entry.addField("SERIES", null);
        entry.addField("TITLE", "alexander");
        entry.addField("INK", "Dubious Hermit");
        entry.addField("EDITION", "10.");

        assertTrue(entry.getValue("EDITION").equals("10."));

    }

    @Test
    public void getValue3() {
        Entry entry = new Entry(new EntryType("", new FieldType[0]));


        entry.addField("SERIES", null);
        entry.addField("TITLE", "alexander");
        entry.addField("INK", "Dubious Hermit");
        entry.addField("EDITION", "10.");

        assertTrue(entry.getValue("SCRIPT") == null);

    }

    @Test
    public void addFieldAddsAField() {
        EntryType entryType = new EntryType("", new FieldType[0]);
        Entry entry = new Entry(entryType);

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