package ohtu.justinbiber.service;

import javax.annotation.PostConstruct;
import ohtu.justinbiber.domain.EntryType;
import ohtu.justinbiber.domain.FieldType;
import ohtu.justinbiber.domain.ValueType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BibInitialize {

    @Autowired
    private BibTypeService bibTypeService;

    @PostConstruct
    void init() {
        bibTypeService.initialize(new BibTypeServiceInitializer() {
            @Override
            public void initialize(BibTypeServiceManager manager) {
                initTypeData(manager);
            }
        });
    }

    private void initTypeData(BibTypeServiceManager manager) {
        ValueType text = manager.addValueType(new ValueType(ValueType.Type.TEXT));
        ValueType number = manager.addValueType(new ValueType(ValueType.Type.NUMBER));

        FieldType author = manager.addFieldType(new FieldType("author", text));
        FieldType title = manager.addFieldType(new FieldType("title", text));
        FieldType booktitle = manager.addFieldType(new FieldType("booktitle", text));
        FieldType year = manager.addFieldType(new FieldType("year", number));
        FieldType editor = manager.addFieldType(new FieldType("editor", text));
        FieldType publisher = manager.addFieldType(new FieldType("publisher", text));
        FieldType journal = manager.addFieldType(new FieldType("journal", text));
        FieldType howpublished = manager.addFieldType(new FieldType("howpublished", text));
        FieldType month = manager.addFieldType(new FieldType("month", text));
        FieldType note = manager.addFieldType(new FieldType("note", text));
        FieldType key = manager.addFieldType(new FieldType("key", text));

        EntryType inproceedings = manager.addEntryType(new EntryType("inproceedings",
                new FieldType[]{
            author,
            title,
            booktitle,
            year,}));
        EntryType book = manager.addEntryType(new EntryType("book",
                new FieldType[]{
            author,
            title,
            publisher,
            year
        }));
        EntryType article = manager.addEntryType(new EntryType("article",
                new FieldType[]{
            author,
            title,
            journal,
            year
        }));
        EntryType misc = manager.addEntryType(new EntryType("misc",
                new FieldType[]{
            author,
            title,
            howpublished,
            month,
            year,
            note,
            key
        }));
    }
}
