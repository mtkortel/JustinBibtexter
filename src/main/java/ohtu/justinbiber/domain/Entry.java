package ohtu.justinbiber.domain;

import java.util.ArrayList;
import java.util.List;

public class Entry {
    
    private EntryType type;
    private String key;
    private List<Field> fields = new ArrayList<>();

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
    
    public String getValue(String key) {
        for (Field field : fields) {
            if (field.getKey().equals(key)) {
                return field.getValue();
            }
        }
        return null;
    }
    
}
