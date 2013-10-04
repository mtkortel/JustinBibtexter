package ohtu.justinbiber.service;

import java.util.List;
import ohtu.justinbiber.domain.Entry;
import ohtu.justinbiber.domain.EntryType;
/**
 * An interface for controlling the entries.
 * 
 */
public interface BibService {
        /**
     * Returns a list of the added entries.
     * @return 
     */
    public List<Entry> getEntries();
        /**
     * Adds an entry to the list of entries.
     * @param entry 
     */
    public void addEntry(Entry entry);
/**
 * Returns a list of all the different entry types.
 * @return 
 */
    public List<EntryType> getEntryTypes();
}
