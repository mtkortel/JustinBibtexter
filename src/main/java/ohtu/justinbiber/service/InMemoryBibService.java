package ohtu.justinbiber.service;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import ohtu.justinbiber.domain.Entry;
import ohtu.justinbiber.domain.EntryType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InMemoryBibService {//implements BibService {
    
    @Autowired
    BibTypeService bibTypeService;
   
    

    private List<Entry> list = new ArrayList<Entry>();
    private List<EntryType> types = new ArrayList<EntryType>();
    
    @PostConstruct
    private void init() {
        
        //List<EntryType> types_new = 
        
        EntryType inproceedings = bibTypeService.getEntryType("inproceedings");
        EntryType book = bibTypeService.getEntryType("book");
        EntryType article = bibTypeService.getEntryType("article");
	EntryType misc = bibTypeService.getEntryType("misc");
        types.add(inproceedings);
        types.add(book);
        types.add(article);
	types.add(misc);
        
        /*
        Entry royce70 = new Entry(inproceedings);
        royce70.setKey("royce70");
        royce70.addField("AUTHOR", "Royce, Walker");
        royce70.addField("TITLE", "Managing the Development of Large Software Systems");
        royce70.addField("BOOKTITLE", "Proceedings of IEEE WESCON 26");
        royce70.addField("ORGANIZATION", "TeX Users Group");
        royce70.addField("MONTH", "August");
        royce70.addField("YEAR", "1970");
        
        Entry begel2008 = new Entry(inproceedings);
        begel2008.setKey("Begel_2008");
        begel2008.addField("author", "Begel, Andrew and Simon, Beth");
        begel2008.addField("title", "Struggles of new college graduates in their first software development job");
        begel2008.addField("booktitle", "Proceedings of the SIGCSE '08");
        begel2008.addField("year", "2008");
        begel2008.addField("publisher", "ACM");
        
        list.add(royce70);
        list.add(begel2008);
        */
    }
    
    //@Override
    public List<Entry> getEntries() {
        return list;
    }
    
    //@Override
    public void addEntry(Entry entry){
        list.add(entry);
    }

    //@Override
    public List<EntryType> getEntryTypes() {
        return types;
    }
}
