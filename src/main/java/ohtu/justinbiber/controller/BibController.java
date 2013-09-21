package ohtu.justinbiber.controller;

import java.util.List;
import ohtu.justinbiber.domain.Entry;
import ohtu.justinbiber.service.BibService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BibController {
 
    @Autowired
    BibService bibService;
    
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list(Model model) {
        List<Entry> entries = bibService.getEntries();
        model.addAttribute("entries", entries);
        return "list";
    }
}
