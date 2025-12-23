package com.google.gson;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class JsonNull extends JsonElement {
    public static final JsonNull INSTANCE = new JsonNull();

    @Override // com.google.gson.JsonElement
    public JsonNull deepCopy() {
        return INSTANCE;
    }

    public boolean equals(Object obj) {
        return this == obj || (obj instanceof JsonNull);
    }

    public int hashCode() {
        return JsonNull.class.hashCode();
    }

    @Deprecated
    public JsonNull() {
    }
}
