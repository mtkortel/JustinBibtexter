package ohtu.justinbiber.domain;
/**
 * Contains a key and a list of types of the fields related to it.
 */
public class EntryType {
    private String key;
    private FieldType[] requiredFields;

    public EntryType(String key, FieldType[] requiredFields) {
        this.key = key.toLowerCase();
        this.requiredFields = requiredFields;
    }

    public FieldType[] getRequiredFieldTypes() {
        return requiredFields;
    }
    
    /**
     * @return the key
     */
    public String getKey() {
        return key;
    }

    /**
     * @param key the key to set
     */
    public void setKey(String key) {
        this.key = key;
    }
}
