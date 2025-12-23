package com.google.gson;

import com.google.gson.internal.Streams;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.MalformedJsonException;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class JsonStreamParser implements Iterator<JsonElement> {
    private final Object lock;
    private final JsonReader parser;

    public JsonStreamParser(String str) {
        this(new StringReader(str));
    }

    public JsonStreamParser(Reader reader) {
        JsonReader jsonReader = new JsonReader(reader);
        this.parser = jsonReader;
        jsonReader.setLenient(true);
        this.lock = new Object();
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        boolean z5;
        synchronized (this.lock) {
            try {
                try {
                    try {
                        z5 = this.parser.peek() != JsonToken.END_DOCUMENT;
                    } catch (MalformedJsonException e6) {
                        throw new JsonSyntaxException(e6);
                    }
                } catch (IOException e7) {
                    throw new JsonIOException(e7);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return z5;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Iterator
    public JsonElement next() throws JsonParseException {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        try {
            return Streams.parse(this.parser);
        } catch (JsonParseException e6) {
            if (e6.getCause() instanceof EOFException) {
                throw new NoSuchElementException();
            }
            throw e6;
        } catch (OutOfMemoryError e7) {
            throw new JsonParseException("Failed parsing JSON source to Json", e7);
        } catch (StackOverflowError e8) {
            throw new JsonParseException("Failed parsing JSON source to Json", e8);
        }
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
