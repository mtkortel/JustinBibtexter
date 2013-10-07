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
public class InMemoryBibServiceTest {
    
    public InMemoryBibServiceTest() {
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
    
    /* Tests adding entries
     */
    /*
     @Test
     public void constructBibService() {
        EntryType entryType = new EntryType("", new FieldType[0]);
        InMemoryBibService service = new InMemoryBibService();
        assertTrue(service.getEntries().isEmpty());
        
        service.addEntry(new Entry(new EntryType("", new FieldType[9])));
        service.addEntry(new Entry(entryType));
        
        assertTrue(service.getEntries().size() == 2);
        
        for (int i =0; i< 1000; ++i) {
        service.addEntry(new Entry(entryType));
        }
        
        assertTrue(service.getEntries().size() == 1002);
     }
     */
     /* Check if the entries get back as they were set
      */
     @Test public void getEntries() {
      
     }
}