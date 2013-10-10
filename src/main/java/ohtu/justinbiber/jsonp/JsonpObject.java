package ohtu.justinbiber.jsonp;

public interface JsonpObject<T> {
    public String getJsonCallback();
    public T getJsonBody();
}