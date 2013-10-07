package ohtu.justinbiber.domain;

import java.io.Serializable;
import javax.persistence.Entity;
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
    private Integer id;
    
    private String key;
    private String value;
    

    public Field() {
    }

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
