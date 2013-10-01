package ohtu.justinbiber.service;

import java.util.List;
import ohtu.justinbiber.domain.EntryType;

public interface BibTypeService {
    public List<EntryType> getEntryTypes();
    public EntryType getEntryType(String key);
}
