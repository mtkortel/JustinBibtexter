package ohtu.justinbiber.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Contains the value type of a key.
 * 
 */
@Entity
@Table(name = "justin_fieldtype")
public class FieldType implements Serializable {
    
    @Id
    private Integer id;
    private String key;
    @ManyToOne
    private ValueType valueType;

    public FieldType() {
    }

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
