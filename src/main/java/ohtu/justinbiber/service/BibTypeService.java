package ohtu.justinbiber.service;

import java.util.List;
import ohtu.justinbiber.domain.EntryType;
/**
 * An interface for controlling the entry types.
 * 
 */
public interface BibTypeService {
        /**
     * Returns a list of all the different entry types.
     * @return 
     */
    public List<EntryType> getEntryTypes();
        /**
     * Returns an entry type connected to the given key.
     * @param key
     * @return 
     */
    public EntryType getEntryType(String key);
}
