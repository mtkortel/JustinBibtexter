package ohtu.justinbiber.service;

import ohtu.justinbiber.domain.EntryType;
import ohtu.justinbiber.domain.FieldType;
import ohtu.justinbiber.domain.ValueType;

public interface BibTypeServiceManager {
    public EntryType addEntryType(EntryType entryType);
    public FieldType addFieldType(FieldType fieldType);
    public ValueType addValueType(ValueType valueType);
}
