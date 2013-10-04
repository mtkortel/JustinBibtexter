package ohtu.justinbiber.domain;
/**
 * Contains the key and the value of a field.
 * 
 */
public class Field {
    
    private String key;
    private String value;

    public Field(String key, String value) {
        this.key = key.toLowerCase();
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public void setKey(String key) {
        this.key = key.toLowerCase();
    }

    public void setValue(String value) {
        this.value = value;
    }
    
}
