package ohtu.justinbiber.service;

import java.util.List;
import ohtu.justinbiber.domain.Entry;

public interface BibService {
    public List<Entry> getEntries();
    public void addEntry(Entry entry);
}
