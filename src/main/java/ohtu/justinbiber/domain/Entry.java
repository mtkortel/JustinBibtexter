package ohtu.justinbiber.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    private EntryType entryType;
    private String entryKey;
    @OneToMany
    private List<Field> fields = new ArrayList<Field>();

    public Entry() {
    }

    public Entry(EntryType type) {
        this.entryType = type;
    }

    public Entry(EntryType entryType, String entryKey, Field[] fields) {
        this.entryType = entryType;
        this.entryKey = entryKey;
        this.fields = Arrays.asList(fields);
    }

    public void addField(String key, String value) {
        fields.add(new Field(key, value));
    }

    public EntryType getType() {
        return entryType;
    }

    public void setType(EntryType type) {
        this.entryType = type;
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
            if (field.getFieldKey().equals(k)) {
                return field.getFieldValue();
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

    public EntryType getEntryType() {
        return entryType;
    }

    public void setEntryType(EntryType entryType) {
        this.entryType = entryType;
    }

    public String getEntryKey() {
        return entryKey;
    }

    public void setEntryKey(String entryKey) {
        this.entryKey = entryKey.toLowerCase();
    }

}
