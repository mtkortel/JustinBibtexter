package ohtu.justinbiber.jsonp;

public class JsonpWrapper<T> implements JsonpObject<T> {

    private String callback;
    private T body;

    public JsonpWrapper(String callback, T body) {
        this.callback = callback;
        this.body = body;
    }

    public JsonpWrapper(T body) {
        this(null, body);
    }

    @Override
    public String getJsonCallback() {
        return callback;
    }

    @Override
    public T getJsonBody() {
        return body;
    }
}
