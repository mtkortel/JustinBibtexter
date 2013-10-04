package ohtu.justinbiber.domain;
/**
 * Contains the value type of a key.
 * 
 */
public class FieldType {
    
    private String key;
    private ValueType valueType;

    public FieldType(String key, ValueType valueType) {
        this.key = key;
        this.valueType = valueType;
    }
    
    public FieldType(String key, ValueType.Type type) {
        this(key, new ValueType(type));
    }
    
    public FieldType(String key) {
        this(key, new ValueType());
    }

    public String getKey() {
        return key;
    }

    public ValueType getValueType() {
        return valueType;
    }
    
}
