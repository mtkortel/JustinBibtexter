package ohtu.justinbiber.service;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import ohtu.justinbiber.domain.EntryType;
import ohtu.justinbiber.domain.FieldType;
import ohtu.justinbiber.domain.ValueType;
import org.springframework.stereotype.Service;

@Service
public class InMemoryBibTypeService implements BibTypeService {

    private List<EntryType> list = new ArrayList<EntryType>();
    
    @PostConstruct
    private void init() {
        
        FieldType author = new FieldType("author");
        FieldType title = new FieldType("title");
        FieldType booktitle = new FieldType("booktitle");
        FieldType year = new FieldType("year", ValueType.Type.NUMBER);        
        FieldType editor = new FieldType("editor");
        FieldType publisher = new FieldType("publisher");    
        FieldType journal = new FieldType("journal");
	FieldType howpublished = new FieldType("howpublished");
	FieldType month = new FieldType("month", ValueType.Type.NUMBER);
	FieldType note = new FieldType("note");
	FieldType key = new FieldType("key");

        
        EntryType inproceedings = new EntryType("inproceedings",
                new FieldType[] {
                    author,
                    title,
                    booktitle,
                    year,
                });
        
        EntryType book = new EntryType("book",
                new FieldType[] {
                    author,
                    title,
                    publisher,
                    year
                });
        
        EntryType article = new EntryType("article",
                new FieldType[] {
                   author,
                   title,
                   journal,
                   year
                });
        
	EntryType misc = new EntryType("misc",
                new FieldType[] {
                   author,
                   title,
                   howpublished,
		   month,
		   year,
		   note,
		   key
                });
        
        list.add(inproceedings);
        list.add(book);
        list.add(article);
	list.add(misc);
    }
    
    @Override
    public List<EntryType> getEntryTypes() {
        return list;
    }

    @Override
    public EntryType getEntryType(String key) {
        String lc = key.toLowerCase();
        for (EntryType entry : list) {
            if (entry.getKey().equals(lc)) {
                return entry;
            }
        }
        return null;
    }

}
