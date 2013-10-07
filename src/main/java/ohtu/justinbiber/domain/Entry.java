package ohtu.justinbiber.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
/**
 * Contains a key, an entry type object and a list of fields.
 * 
 */
@Entity
@Table(name = "justin_entry")
public class Entry implements Serializable {
    
    @Id
    private Integer id;
    
    @ManyToOne
    private EntryType type;
    private String keyname;
    @OneToMany
    private List<Field> fields = new ArrayList<Field>();

    public Entry() {
    }

    public Entry(EntryType type) {
        this.type = type;
    }
    
    public void addField(String key, String value) {
        fields.add(new Field(key, value));
    }

    public EntryType getType() {
        return type;
    }

    public void setType(EntryType type) {
        this.type = type;
    }

    public String getKeyname() {
        return keyname;
    }

    public void setKeyname(String key) {
        this.keyname = key;
    }

    public List<Field> getFields() {
        return fields;
    }
        /**
     * Searches for a key from List<Field> fields,
     * if the key is found, returns the value stored with it.
     * @param key
     * @return 
     */
    public String getValue(String key) {
        String k = key.toLowerCase();
        for (Field field : fields) {
            if (field.getKey().equals(k)) {
                return field.getValue();
            }
        }
        return null;
    }
    
    public String getTitle() {
        return getValue("title");
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }
    
}
