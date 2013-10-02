/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.justinbiber.service;

import java.util.List;
import ohtu.justinbiber.domain.Entry;
import ohtu.justinbiber.domain.Field;
import ohtu.justinbiber.domain.Mappings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author mkortelainen
 */
@Service
public class BibConvertService {
    @Autowired
    Mappings map;
    @Autowired
    BibService bib;
    
    public String getBibtext(List<Entry> entries){
        StringBuilder sb = new StringBuilder();
        for(Entry entry: entries){
            sb.append("@").append(entry.getType().getKey().toString()).append("{");
            sb.append(entry.getKey()).append(",\n");
            for(Field field: entry.getFields()){
                sb.append(field.getKey().toString()).append(" = {");
                sb.append(field.getValue().toString()).append("},\n");
            }
            sb.append("}\n\n");
        }
        /*
        StringBuilder sb2 = new StringBuilder();
        for(char c: sb.toString().toCharArray()){
            sb2.append(map.getLatex(c));
        }
        */
        return map.fixMappings(sb.toString());
    }
}
    /*
     
     @inproceedings{VPL11,
     author = {Vihavainen, Arto and Paksula, Matti and Luukkainen, Matti},
     title = {Extreme Apprenticeship Method in Teaching Programming for Beginners.},
     year = {2011},
     booktitle = {SIGCSE '11: Proceedings of the 42nd SIGCSE technical symposium on Computer science education},
     }
     
     */

