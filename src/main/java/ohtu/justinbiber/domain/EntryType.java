package ohtu.justinbiber.domain;

public class EntryType {
    private String key;
    private FieldType[] requiredFields;

    public EntryType(String key, FieldType[] requiredFields) {
        this.key = key;
        this.requiredFields = requiredFields;
    }

    public FieldType[] getRequiredFieldTypes() {
        return requiredFields;
    }
    
    public static final EntryType INPROCEEDINGS = new EntryType(
            "inproceedings",
            new FieldType[] {
                new FieldType("author"),
                new FieldType("title"),
                new FieldType("booktitle"),
                new FieldType("year")
            }
            );

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
