package ohtu.justinbiber.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Contains a key and a list of types of the fields related to it.
 */
@Entity
public class EntryType {
    
    @Id
    private Integer id;
    
    private String typekey;
    private FieldType[] requiredFields;

    public EntryType() {
    }

    public EntryType(String typekey, FieldType[] requiredFields) {
        this.typekey = typekey.toLowerCase();
        this.requiredFields = requiredFields;
    }

    public FieldType[] getRequiredFieldTypes() {
        return requiredFields;
    }
    
    /**
     * @return the key
     */
    public String getTypeKey() {
        return typekey;
    }

    /**
     * @param key the key to set
     */
    public void setTypeKey(String key) {
        this.typekey = key;
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }
}
