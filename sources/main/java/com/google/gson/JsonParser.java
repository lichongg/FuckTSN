package com.google.gson;

import com.google.gson.internal.Streams;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.MalformedJsonException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class JsonParser {
    public JsonElement parse(String str) throws JsonSyntaxException {
        return parse(new StringReader(str));
    }

    public JsonElement parse(Reader reader) throws JsonIOException, JsonSyntaxException {
        try {
            JsonReader jsonReader = new JsonReader(reader);
            JsonElement parse = parse(jsonReader);
            if (!parse.isJsonNull() && jsonReader.peek() != JsonToken.END_DOCUMENT) {
                throw new JsonSyntaxException("Did not consume the entire document.");
            }
            return parse;
        } catch (MalformedJsonException e6) {
            throw new JsonSyntaxException(e6);
        } catch (IOException e7) {
            throw new JsonIOException(e7);
        } catch (NumberFormatException e8) {
            throw new JsonSyntaxException(e8);
        }
    }

    public JsonElement parse(JsonReader jsonReader) throws JsonIOException, JsonSyntaxException {
        boolean isLenient = jsonReader.isLenient();
        jsonReader.setLenient(true);
        try {
            try {
                return Streams.parse(jsonReader);
            } catch (OutOfMemoryError e6) {
                throw new JsonParseException("Failed parsing JSON source: " + jsonReader + " to Json", e6);
            } catch (StackOverflowError e7) {
                throw new JsonParseException("Failed parsing JSON source: " + jsonReader + " to Json", e7);
            }
        } finally {
            jsonReader.setLenient(isLenient);
        }
    }
}
