package ohtu.justinbiber.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Contains a key and a list of types of the fields related to it.
 */
@Entity
@Table(name = "justin_entrytype")
public class EntryType implements Serializable {
    
    @Id
    private Integer id;
    
    private String typekey;
    @OneToMany
    private List<FieldType> requiredFields = new ArrayList<FieldType>();

    public EntryType() {
    }

    public EntryType(String typekey, FieldType[] requiredFields) {
        this.typekey = typekey.toLowerCase();
        this.requiredFields = Arrays.asList(requiredFields);
    }

    public List<FieldType> getRequiredFieldTypes() {
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
