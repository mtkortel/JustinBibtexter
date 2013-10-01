package ohtu.justinbiber.domain;

public class EntryType {
    private String key;
    private FieldType[] requiredFields;

    public EntryType(String key, FieldType[] requiredFields) {
        this.key = key.toLowerCase();
        this.requiredFields = requiredFields;
    }
    
    public String getKey() {
        return key;
    }

    public FieldType[] getRequiredFieldTypes() {
        return requiredFields;
    }
}
