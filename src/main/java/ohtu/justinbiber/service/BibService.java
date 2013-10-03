package ohtu.justinbiber.service;

import java.util.List;
import ohtu.justinbiber.domain.Entry;
import ohtu.justinbiber.domain.EntryType;

public interface BibService {
    public List<Entry> getEntries();
    public void addEntry(Entry entry);

    public List<EntryType> getEntryTypes();
}
