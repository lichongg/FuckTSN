package com.google.gson;

import com.google.gson.internal.bind.JsonTreeReader;
import com.google.gson.internal.bind.JsonTreeWriter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public abstract class TypeAdapter<T> {
    public final T fromJson(Reader reader) throws IOException {
        return read(new JsonReader(reader));
    }

    public abstract T read(JsonReader jsonReader) throws IOException;

    public final void toJson(Writer writer, T t5) throws IOException {
        write(new JsonWriter(writer), t5);
    }

    public abstract void write(JsonWriter jsonWriter, T t5) throws IOException;

    public final T fromJsonTree(JsonElement jsonElement) {
        try {
            return read(new JsonTreeReader(jsonElement));
        } catch (IOException e6) {
            throw new JsonIOException(e6);
        }
    }

    public final TypeAdapter<T> nullSafe() {
        return new TypeAdapter<T>() { // from class: com.google.gson.TypeAdapter.1
            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, T t5) throws IOException {
                if (t5 == null) {
                    jsonWriter.nullValue();
                } else {
                    TypeAdapter.this.write(jsonWriter, t5);
                }
            }

            @Override // com.google.gson.TypeAdapter
            public T read(JsonReader jsonReader) throws IOException {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                    return null;
                }
                return (T) TypeAdapter.this.read(jsonReader);
            }
        };
    }

    public final JsonElement toJsonTree(T t5) {
        try {
            JsonTreeWriter jsonTreeWriter = new JsonTreeWriter();
            write(jsonTreeWriter, t5);
            return jsonTreeWriter.get();
        } catch (IOException e6) {
            throw new JsonIOException(e6);
        }
    }

    public final T fromJson(String str) throws IOException {
        return fromJson(new StringReader(str));
    }

    public final String toJson(T t5) {
        StringWriter stringWriter = new StringWriter();
        try {
            toJson(stringWriter, t5);
            return stringWriter.toString();
        } catch (IOException e6) {
            throw new AssertionError(e6);
        }
    }
}
