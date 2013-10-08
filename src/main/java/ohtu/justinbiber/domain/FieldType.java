package ohtu.justinbiber.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String fieldKey;
    @ManyToOne
    private ValueType valueType;

    public FieldType() {
    }

    public FieldType(String key, ValueType valueType) {
        this.fieldKey = key;
        this.valueType = valueType;
    }

    public void setFieldKey(String key) {
        this.fieldKey = key;
    }

    public String getFieldKey() {
        return fieldKey;
    }

    public ValueType getValueType() {
        return valueType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
