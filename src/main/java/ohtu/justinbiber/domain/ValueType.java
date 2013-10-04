package ohtu.justinbiber.domain;
/**
 * Defines the accepted input type to be either in TEXT or NUMBER form.
 */
public class ValueType {
    
    public enum Type {
        TEXT, NUMBER
    }
    
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
