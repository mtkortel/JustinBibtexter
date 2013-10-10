package ohtu.justinbiber.controller;

import java.util.List;
import java.util.Map;
import ohtu.justinbiber.domain.Entry;
import ohtu.justinbiber.domain.EntryType;
import ohtu.justinbiber.jsonp.JsonpObject;
import ohtu.justinbiber.service.BibConvertService;
import ohtu.justinbiber.service.BibService;
import ohtu.justinbiber.service.BibTypeService;
import ohtu.justinbiber.jsonp.JsonpWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BibController {

    @Autowired
    BibService bibService;
    @Autowired
    BibConvertService bibConvert;
    @Autowired
    BibTypeService bibTypeService;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list(Model model, @RequestParam(required = false) String query) {
        List<Entry> entries = bibService.getEntries();
        model.addAttribute("entries", entries);
        model.addAttribute("query", query);
        return "list";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model){
        List<EntryType> types = bibTypeService.getEntryTypes();
        model.addAttribute("types", types);
        return "addnew";
    }
    /**
     * Lisätään syötetty viitetieto listalle ja palataan list-näyttöön
     *
     * @param parameter
     * @return
     */
    @RequestMapping(value = "add-bibtext", method = RequestMethod.POST)
    public String addBibtext(@RequestParam Map<String, String> params) {
        String type = params.get("bibtype");
        Entry entry = new Entry(bibTypeService.getEntryType(type));
        entry.setEntryKey(params.get("key"));
        for (String key: params.keySet()) {
            if (!key.equals("bibtype") && !key.equals("key")) {
                String value = params.get(key);
                if (!value.isEmpty()) {
                    String shortKey = key.substring(type.length() + 1);
                    entry.addField(shortKey, value);
                }
            }
        }
        bibService.addEntry(entry);
        return "redirect:list";
    }

    @RequestMapping(value = "view-bibtext", method = RequestMethod.GET)
    public String preview(Model model) {
        String prev = bibConvert.getBibtext(bibService.getEntries());
        model.addAttribute("preview", prev);
        return "preview";
    }

    @RequestMapping(value = "entries.js", method = RequestMethod.GET, produces = {"application/x-javascript", "application/javascript", "text/javascript"})
    @ResponseBody
    public JsonpObject<List<Entry>> entries() {
        return new JsonpWrapper<List<Entry>>("justin", bibService.getEntries());
    }

}
