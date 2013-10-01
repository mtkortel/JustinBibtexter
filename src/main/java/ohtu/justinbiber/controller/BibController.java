package ohtu.justinbiber.controller;

import java.util.List;
import ohtu.justinbiber.domain.Entry;
import ohtu.justinbiber.domain.EntryType;
import ohtu.justinbiber.service.BibConvertService;
import ohtu.justinbiber.service.BibService;
import ohtu.justinbiber.service.BibTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BibController {
 
    @Autowired
    BibService bibService;
    @Autowired
    BibConvertService bibConvert;
    
    @Autowired
    BibTypeService bibTypeService;
    
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list(Model model) {
        List<Entry> entries = bibService.getEntries();
        model.addAttribute("entries", entries);
        return "list";
    }
    
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(){
        return "addnew";
    }
    /**
     * Lisätään syötetty viitetieto listalle ja palataan list-näyttöön
     * 
     * @param parameter
     * @return 
     */
    @RequestMapping(value = "add-bibtext", method = RequestMethod.POST)
    public String addBibtext(@RequestParam String bibtype, @RequestParam String author,
            @RequestParam String title, @RequestParam String booktitle, @RequestParam String year) {
        EntryType inproceedings = bibTypeService.getEntryType("inproceedings");
        Entry entry = new Entry(inproceedings);
        entry.addField("author", author);
        entry.addField("title", title);
        entry.addField("booktitle", booktitle);
        entry.addField("year", year);
        bibService.addEntry(entry);
        return "redirect:list";
    }
    
    @RequestMapping(value = "view-bibtext", method = RequestMethod.GET)
    public String preview(Model model){
        String prev = bibConvert.getBibtext(bibService.getEntries());
        model.addAttribute("preview", prev);
        return "preview";
    }
}
