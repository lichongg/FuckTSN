package com.google.firebase.encoders.json;

import android.util.Base64;
import android.util.JsonWriter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.ValueEncoder;
import com.google.firebase.encoders.ValueEncoderContext;
import java.io.IOException;
import java.io.Writer;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class JsonValueObjectEncoderContext implements ObjectEncoderContext, ValueEncoderContext {
    private final ObjectEncoder<Object> fallbackEncoder;
    private final boolean ignoreNullValues;
    private final JsonWriter jsonWriter;
    private final Map<Class<?>, ObjectEncoder<?>> objectEncoders;
    private final Map<Class<?>, ValueEncoder<?>> valueEncoders;
    private JsonValueObjectEncoderContext childContext = null;
    private boolean active = true;

    JsonValueObjectEncoderContext(@NonNull Writer writer, @NonNull Map<Class<?>, ObjectEncoder<?>> map, @NonNull Map<Class<?>, ValueEncoder<?>> map2, ObjectEncoder<Object> objectEncoder, boolean z5) {
        this.jsonWriter = new JsonWriter(writer);
        this.objectEncoders = map;
        this.valueEncoders = map2;
        this.fallbackEncoder = objectEncoder;
        this.ignoreNullValues = z5;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    @NonNull
    public ObjectEncoderContext inline(@Nullable Object obj) throws IOException {
        return add(obj, true);
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    @NonNull
    public ObjectEncoderContext nested(@NonNull String str) throws IOException {
        maybeUnNest();
        this.childContext = new JsonValueObjectEncoderContext(this);
        this.jsonWriter.name(str);
        this.jsonWriter.beginObject();
        return this.childContext;
    }

    private boolean cannotBeInline(Object obj) {
        return obj == null || obj.getClass().isArray() || (obj instanceof Collection) || (obj instanceof Date) || (obj instanceof Enum) || (obj instanceof Number);
    }

    private JsonValueObjectEncoderContext internalAddIgnoreNullValues(@NonNull String str, @Nullable Object obj) throws IOException, EncodingException {
        if (obj == null) {
            return this;
        }
        maybeUnNest();
        this.jsonWriter.name(str);
        return add(obj, false);
    }

    private void maybeUnNest() throws IOException {
        if (!this.active) {
            throw new IllegalStateException("Parent context used since this context was created. Cannot use this context anymore.");
        }
        JsonValueObjectEncoderContext jsonValueObjectEncoderContext = this.childContext;
        if (jsonValueObjectEncoderContext != null) {
            jsonValueObjectEncoderContext.maybeUnNest();
            this.childContext.active = false;
            this.childContext = null;
            this.jsonWriter.endObject();
        }
    }

    JsonValueObjectEncoderContext doEncode(ObjectEncoder<Object> objectEncoder, Object obj, boolean z5) throws IOException {
        if (!z5) {
            this.jsonWriter.beginObject();
        }
        objectEncoder.encode(obj, this);
        if (!z5) {
            this.jsonWriter.endObject();
        }
        return this;
    }

    private JsonValueObjectEncoderContext internalAdd(@NonNull String str, @Nullable Object obj) throws IOException, EncodingException {
        maybeUnNest();
        this.jsonWriter.name(str);
        if (obj == null) {
            this.jsonWriter.nullValue();
            return this;
        }
        return add(obj, false);
    }

    void close() throws IOException {
        maybeUnNest();
        this.jsonWriter.flush();
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    @NonNull
    public ObjectEncoderContext nested(@NonNull FieldDescriptor fieldDescriptor) throws IOException {
        return nested(fieldDescriptor.getName());
    }

    private JsonValueObjectEncoderContext(JsonValueObjectEncoderContext jsonValueObjectEncoderContext) {
        this.jsonWriter = jsonValueObjectEncoderContext.jsonWriter;
        this.objectEncoders = jsonValueObjectEncoderContext.objectEncoders;
        this.valueEncoders = jsonValueObjectEncoderContext.valueEncoders;
        this.fallbackEncoder = jsonValueObjectEncoderContext.fallbackEncoder;
        this.ignoreNullValues = jsonValueObjectEncoderContext.ignoreNullValues;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    @NonNull
    public JsonValueObjectEncoderContext add(@NonNull String str, @Nullable Object obj) throws IOException {
        if (this.ignoreNullValues) {
            return internalAddIgnoreNullValues(str, obj);
        }
        return internalAdd(str, obj);
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    @NonNull
    public JsonValueObjectEncoderContext add(@NonNull String str, double d6) throws IOException {
        maybeUnNest();
        this.jsonWriter.name(str);
        return add(d6);
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    @NonNull
    public JsonValueObjectEncoderContext add(@NonNull String str, int i6) throws IOException {
        maybeUnNest();
        this.jsonWriter.name(str);
        return add(i6);
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    @NonNull
    public JsonValueObjectEncoderContext add(@NonNull String str, long j6) throws IOException {
        maybeUnNest();
        this.jsonWriter.name(str);
        return add(j6);
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    @NonNull
    public JsonValueObjectEncoderContext add(@NonNull String str, boolean z5) throws IOException {
        maybeUnNest();
        this.jsonWriter.name(str);
        return add(z5);
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    @NonNull
    public ObjectEncoderContext add(@NonNull FieldDescriptor fieldDescriptor, @Nullable Object obj) throws IOException {
        return add(fieldDescriptor.getName(), obj);
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    @NonNull
    public ObjectEncoderContext add(@NonNull FieldDescriptor fieldDescriptor, float f6) throws IOException {
        return add(fieldDescriptor.getName(), f6);
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    @NonNull
    public ObjectEncoderContext add(@NonNull FieldDescriptor fieldDescriptor, double d6) throws IOException {
        return add(fieldDescriptor.getName(), d6);
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    @NonNull
    public ObjectEncoderContext add(@NonNull FieldDescriptor fieldDescriptor, int i6) throws IOException {
        return add(fieldDescriptor.getName(), i6);
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    @NonNull
    public ObjectEncoderContext add(@NonNull FieldDescriptor fieldDescriptor, long j6) throws IOException {
        return add(fieldDescriptor.getName(), j6);
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    @NonNull
    public ObjectEncoderContext add(@NonNull FieldDescriptor fieldDescriptor, boolean z5) throws IOException {
        return add(fieldDescriptor.getName(), z5);
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    @NonNull
    public JsonValueObjectEncoderContext add(@Nullable String str) throws IOException {
        maybeUnNest();
        this.jsonWriter.value(str);
        return this;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    @NonNull
    public JsonValueObjectEncoderContext add(float f6) throws IOException {
        maybeUnNest();
        this.jsonWriter.value(f6);
        return this;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    @NonNull
    public JsonValueObjectEncoderContext add(double d6) throws IOException {
        maybeUnNest();
        this.jsonWriter.value(d6);
        return this;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    @NonNull
    public JsonValueObjectEncoderContext add(int i6) throws IOException {
        maybeUnNest();
        this.jsonWriter.value(i6);
        return this;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    @NonNull
    public JsonValueObjectEncoderContext add(long j6) throws IOException {
        maybeUnNest();
        this.jsonWriter.value(j6);
        return this;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    @NonNull
    public JsonValueObjectEncoderContext add(boolean z5) throws IOException {
        maybeUnNest();
        this.jsonWriter.value(z5);
        return this;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    @NonNull
    public JsonValueObjectEncoderContext add(@Nullable byte[] bArr) throws IOException {
        maybeUnNest();
        if (bArr == null) {
            this.jsonWriter.nullValue();
            return this;
        }
        this.jsonWriter.value(Base64.encodeToString(bArr, 2));
        return this;
    }

    @NonNull
    JsonValueObjectEncoderContext add(@Nullable Object obj, boolean z5) throws IOException {
        int i6 = 0;
        if (z5 && cannotBeInline(obj)) {
            throw new EncodingException(String.format("%s cannot be encoded inline", obj == null ? null : obj.getClass()));
        }
        if (obj == null) {
            this.jsonWriter.nullValue();
            return this;
        }
        if (obj instanceof Number) {
            this.jsonWriter.value((Number) obj);
            return this;
        }
        if (obj.getClass().isArray()) {
            if (obj instanceof byte[]) {
                return add((byte[]) obj);
            }
            this.jsonWriter.beginArray();
            if (obj instanceof int[]) {
                int length = ((int[]) obj).length;
                while (i6 < length) {
                    this.jsonWriter.value(r6[i6]);
                    i6++;
                }
            } else if (obj instanceof long[]) {
                long[] jArr = (long[]) obj;
                int length2 = jArr.length;
                while (i6 < length2) {
                    add(jArr[i6]);
                    i6++;
                }
            } else if (obj instanceof double[]) {
                double[] dArr = (double[]) obj;
                int length3 = dArr.length;
                while (i6 < length3) {
                    this.jsonWriter.value(dArr[i6]);
                    i6++;
                }
            } else if (obj instanceof boolean[]) {
                boolean[] zArr = (boolean[]) obj;
                int length4 = zArr.length;
                while (i6 < length4) {
                    this.jsonWriter.value(zArr[i6]);
                    i6++;
                }
            } else if (obj instanceof Number[]) {
                for (Number number : (Number[]) obj) {
                    add((Object) number, false);
                }
            } else {
                for (Object obj2 : (Object[]) obj) {
                    add(obj2, false);
                }
            }
            this.jsonWriter.endArray();
            return this;
        }
        if (obj instanceof Collection) {
            this.jsonWriter.beginArray();
            Iterator it = ((Collection) obj).iterator();
            while (it.hasNext()) {
                add(it.next(), false);
            }
            this.jsonWriter.endArray();
            return this;
        }
        if (obj instanceof Map) {
            this.jsonWriter.beginObject();
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                Object key = entry.getKey();
                try {
                    add((String) key, entry.getValue());
                } catch (ClassCastException e6) {
                    throw new EncodingException(String.format("Only String keys are currently supported in maps, got %s of type %s instead.", key, key.getClass()), e6);
                }
            }
            this.jsonWriter.endObject();
            return this;
        }
        ObjectEncoder<?> objectEncoder = this.objectEncoders.get(obj.getClass());
        if (objectEncoder != null) {
            return doEncode(objectEncoder, obj, z5);
        }
        ValueEncoder<?> valueEncoder = this.valueEncoders.get(obj.getClass());
        if (valueEncoder != null) {
            valueEncoder.encode(obj, this);
            return this;
        }
        if (obj instanceof Enum) {
            add(((Enum) obj).name());
            return this;
        }
        return doEncode(this.fallbackEncoder, obj, z5);
    }
}
