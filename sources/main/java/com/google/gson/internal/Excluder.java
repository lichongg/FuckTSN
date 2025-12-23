package com.google.gson.internal;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.Since;
import com.google.gson.annotations.Until;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class Excluder implements TypeAdapterFactory, Cloneable {
    public static final Excluder DEFAULT = new Excluder();
    private static final double IGNORE_VERSIONS = -1.0d;
    private List<ExclusionStrategy> deserializationStrategies;
    private boolean requireExpose;
    private List<ExclusionStrategy> serializationStrategies;
    private double version = IGNORE_VERSIONS;
    private int modifiers = MediaPlayer.MEDIA_PLAYER_OPTION_SET_PIPE_DECLARE_LENGTH;
    private boolean serializeInnerClasses = true;

    private boolean excludeClassChecks(Class<?> cls) {
        if (this.version == IGNORE_VERSIONS || isValidVersion((Since) cls.getAnnotation(Since.class), (Until) cls.getAnnotation(Until.class))) {
            return (!this.serializeInnerClasses && isInnerClass(cls)) || isAnonymousOrLocal(cls);
        }
        return true;
    }

    private boolean excludeClassInStrategy(Class<?> cls, boolean z5) {
        Iterator<ExclusionStrategy> it = (z5 ? this.serializationStrategies : this.deserializationStrategies).iterator();
        while (it.hasNext()) {
            if (it.next().shouldSkipClass(cls)) {
                return true;
            }
        }
        return false;
    }

    private boolean isAnonymousOrLocal(Class<?> cls) {
        if (Enum.class.isAssignableFrom(cls)) {
            return false;
        }
        return cls.isAnonymousClass() || cls.isLocalClass();
    }

    private boolean isValidSince(Since since) {
        return since == null || since.value() <= this.version;
    }

    private boolean isValidUntil(Until until) {
        return until == null || until.value() > this.version;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public Excluder m112clone() {
        try {
            return (Excluder) super.clone();
        } catch (CloneNotSupportedException e6) {
            throw new AssertionError(e6);
        }
    }

    public boolean excludeField(Field field, boolean z5) {
        Expose expose;
        if ((this.modifiers & field.getModifiers()) != 0) {
            return true;
        }
        if ((this.version != IGNORE_VERSIONS && !isValidVersion((Since) field.getAnnotation(Since.class), (Until) field.getAnnotation(Until.class))) || field.isSynthetic()) {
            return true;
        }
        if (this.requireExpose && ((expose = (Expose) field.getAnnotation(Expose.class)) == null || (!z5 ? expose.deserialize() : expose.serialize()))) {
            return true;
        }
        if ((!this.serializeInnerClasses && isInnerClass(field.getType())) || isAnonymousOrLocal(field.getType())) {
            return true;
        }
        List<ExclusionStrategy> list = z5 ? this.serializationStrategies : this.deserializationStrategies;
        if (list.isEmpty()) {
            return false;
        }
        FieldAttributes fieldAttributes = new FieldAttributes(field);
        Iterator<ExclusionStrategy> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().shouldSkipField(fieldAttributes)) {
                return true;
            }
        }
        return false;
    }

    public Excluder() {
        List<ExclusionStrategy> list = Collections.EMPTY_LIST;
        this.serializationStrategies = list;
        this.deserializationStrategies = list;
    }

    private boolean isInnerClass(Class<?> cls) {
        if (cls.isMemberClass() && !isStatic(cls)) {
            return true;
        }
        return false;
    }

    private boolean isStatic(Class<?> cls) {
        if ((cls.getModifiers() & 8) != 0) {
            return true;
        }
        return false;
    }

    private boolean isValidVersion(Since since, Until until) {
        if (isValidSince(since) && isValidUntil(until)) {
            return true;
        }
        return false;
    }

    @Override // com.google.gson.TypeAdapterFactory
    public <T> TypeAdapter<T> create(final Gson gson, final TypeToken<T> typeToken) {
        final boolean z5;
        final boolean z6;
        Class<? super T> rawType = typeToken.getRawType();
        boolean excludeClassChecks = excludeClassChecks(rawType);
        if (!excludeClassChecks && !excludeClassInStrategy(rawType, true)) {
            z5 = false;
        } else {
            z5 = true;
        }
        if (!excludeClassChecks && !excludeClassInStrategy(rawType, false)) {
            z6 = false;
        } else {
            z6 = true;
        }
        if (!z5 && !z6) {
            return null;
        }
        return new TypeAdapter<T>() { // from class: com.google.gson.internal.Excluder.1
            private TypeAdapter<T> delegate;

            private TypeAdapter<T> delegate() {
                TypeAdapter<T> typeAdapter = this.delegate;
                if (typeAdapter != null) {
                    return typeAdapter;
                }
                TypeAdapter<T> delegateAdapter = gson.getDelegateAdapter(Excluder.this, typeToken);
                this.delegate = delegateAdapter;
                return delegateAdapter;
            }

            @Override // com.google.gson.TypeAdapter
            public T read(JsonReader jsonReader) throws IOException {
                if (!z6) {
                    return delegate().read(jsonReader);
                }
                jsonReader.skipValue();
                return null;
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, T t5) throws IOException {
                if (z5) {
                    jsonWriter.nullValue();
                } else {
                    delegate().write(jsonWriter, t5);
                }
            }
        };
    }

    public Excluder disableInnerClassSerialization() {
        Excluder m112clone = m112clone();
        m112clone.serializeInnerClasses = false;
        return m112clone;
    }

    public boolean excludeClass(Class<?> cls, boolean z5) {
        if (!excludeClassChecks(cls) && !excludeClassInStrategy(cls, z5)) {
            return false;
        }
        return true;
    }

    public Excluder excludeFieldsWithoutExposeAnnotation() {
        Excluder m112clone = m112clone();
        m112clone.requireExpose = true;
        return m112clone;
    }

    public Excluder withExclusionStrategy(ExclusionStrategy exclusionStrategy, boolean z5, boolean z6) {
        Excluder m112clone = m112clone();
        if (z5) {
            ArrayList arrayList = new ArrayList(this.serializationStrategies);
            m112clone.serializationStrategies = arrayList;
            arrayList.add(exclusionStrategy);
        }
        if (z6) {
            ArrayList arrayList2 = new ArrayList(this.deserializationStrategies);
            m112clone.deserializationStrategies = arrayList2;
            arrayList2.add(exclusionStrategy);
        }
        return m112clone;
    }

    public Excluder withModifiers(int... iArr) {
        Excluder m112clone = m112clone();
        m112clone.modifiers = 0;
        for (int i6 : iArr) {
            m112clone.modifiers = i6 | m112clone.modifiers;
        }
        return m112clone;
    }

    public Excluder withVersion(double d6) {
        Excluder m112clone = m112clone();
        m112clone.version = d6;
        return m112clone;
    }
}
