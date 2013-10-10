package ohtu.justinbiber.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Contains the key and the value of a field.
 *
 */
@Entity
@Table(name = "justin_field")
public class Field implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String fieldKey;
    private String fieldValue;

    public Field() {
    }

    public Field(String key, String value) {
        this.fieldKey = key.toLowerCase();
        this.fieldValue = value;
    }

    public String getKey() {
        return fieldKey;
    }

    public String getValue() {
        return fieldValue;
    }

    public void setKey(String key) {
        this.fieldKey = key.toLowerCase();
    }

    public void setValue(String value) {
        this.fieldValue = value;
    }

    public Integer getId() {
        return id;
    }

}
