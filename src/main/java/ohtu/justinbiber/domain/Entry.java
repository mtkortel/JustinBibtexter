package ohtu.justinbiber.domain;

import java.util.ArrayList;
import java.util.List;
/**
 * Contains a key, an entry type object and a list of fields.
 * 
 */
public class Entry {
    
    private EntryType type;
    private String key;
    private List<Field> fields = new ArrayList<Field>();

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

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
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
    
}
