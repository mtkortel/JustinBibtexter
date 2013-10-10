package ohtu.justinbiber.jsonp;

// abusing http://stackoverflow.com/questions/7655975/jsonp-with-spring-3-0-and-jackson
import java.io.IOException;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;

public class MappingJackson2JsonpHttpMessageConverter
    extends MappingJackson2HttpMessageConverter {

    @Override
    protected void writeInternal(Object object, HttpOutputMessage outputMessage)
        throws IOException, HttpMessageNotWritableException {
        JsonEncoding encoding = getJsonEncoding(outputMessage.getHeaders().getContentType());
        JsonGenerator jsonGenerator = this.getObjectMapper().getFactory().createJsonGenerator(outputMessage.getBody(), encoding);

        try {
            String jsonPadding = "callback";

            // If the callback doesn't provide, use the default callback
            if (object instanceof JsonpObject) {
                JsonpObject json = (JsonpObject)object;
                String jsonCallback = json.getJsonCallback();
                object = json.getJsonBody();
                if (jsonCallback != null) {
                    jsonPadding = jsonCallback;
                }
            }

            jsonGenerator.writeRaw(jsonPadding);
            jsonGenerator.writeRaw('(');
            this.getObjectMapper().writeValue(jsonGenerator, object);
            jsonGenerator.writeRaw(");");
            jsonGenerator.flush();
        } catch (JsonProcessingException ex) {
            throw new HttpMessageNotWritableException("Could not write JSON: " + ex.getMessage(), ex);
        }
    }
}