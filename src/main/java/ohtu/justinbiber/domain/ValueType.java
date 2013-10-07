package ohtu.justinbiber.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Defines the accepted input type to be either in TEXT or NUMBER form.
 */
@Entity
@Table(name = "justin_valuetype")
public class ValueType implements Serializable {
    
    public enum Type {
        TEXT, NUMBER
    }
    
    @Id
    private Integer id;
    
    private Type type;

    public ValueType(Type type) {
        this.type = type;
    }
    
    public ValueType() {
        this(Type.TEXT);
    }

    public Type getType() {
        return type;
    }
    
}
