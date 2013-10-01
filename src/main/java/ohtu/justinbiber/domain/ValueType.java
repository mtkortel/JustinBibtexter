package ohtu.justinbiber.domain;

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
