/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.justinbiber.service;

import java.util.ArrayList;
import java.util.List;
import ohtu.justinbiber.domain.Entry;
import ohtu.justinbiber.domain.Field;
import ohtu.justinbiber.domain.Mappings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author mtkortel
 */
@Service
public class BibConvertService {
    @Autowired
    Mappings map;
    @Autowired
    BibService bib;

    private String getBibtexEntry(Entry entry) {
        StringBuilder sb = new StringBuilder();
        sb.append("@").append(entry.getType().getTypeKey().toString()).append("{");
        sb.append(entry.getEntryKey()).append(",\n");
        for(Field field: entry.getFields()){
            sb.append('\t').append(field.getFieldKey().toString()).append(" = {");
            sb.append(field.getFieldValue().toString()).append("},\n");
        }
        sb.append("}\n");
        return map.fixMappings(sb.toString());
    }

    public String getBibtext(List<Entry> entries){
        StringBuilder sb = new StringBuilder();
        for(Entry entry: entries){
            sb.append(getBibtexEntry(entry));
            sb.append('\n');
        }
        return sb.toString();
    }

    public List<EntryBibtex> getBibtexEntries(List<Entry> entries) {
        List<EntryBibtex> ret = new ArrayList<EntryBibtex>();
        for(Entry entry: entries){
            ret.add(new EntryBibtex(entry, getBibtexEntry(entry)));
        }
        return ret;
    }
}
