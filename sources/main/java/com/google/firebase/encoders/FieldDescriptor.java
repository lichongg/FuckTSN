package com.google.firebase.encoders;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.annotation.Annotation;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class FieldDescriptor {
    private final String name;
    private final Map<Class<?>, Object> properties;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.google.firebase.encoders.FieldDescriptor$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Builder {
        private final String name;
        private Map<Class<?>, Object> properties = null;

        @NonNull
        public FieldDescriptor build() {
            return new FieldDescriptor(this.name, this.properties == null ? Collections.EMPTY_MAP : Collections.unmodifiableMap(new HashMap(this.properties)), null);
        }

        @NonNull
        public <T extends Annotation> Builder withProperty(@NonNull T t5) {
            if (this.properties == null) {
                this.properties = new HashMap();
            }
            this.properties.put(t5.annotationType(), t5);
            return this;
        }

        Builder(String str) {
            this.name = str;
        }
    }

    /* synthetic */ FieldDescriptor(String str, Map map, AnonymousClass1 anonymousClass1) {
        this(str, map);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FieldDescriptor)) {
            return false;
        }
        FieldDescriptor fieldDescriptor = (FieldDescriptor) obj;
        return this.name.equals(fieldDescriptor.name) && this.properties.equals(fieldDescriptor.properties);
    }

    private FieldDescriptor(String str, Map<Class<?>, Object> map) {
        this.name = str;
        this.properties = map;
    }

    @NonNull
    public static Builder builder(@NonNull String str) {
        return new Builder(str);
    }

    @NonNull
    public static FieldDescriptor of(@NonNull String str) {
        return new FieldDescriptor(str, Collections.EMPTY_MAP);
    }

    @NonNull
    public String getName() {
        return this.name;
    }

    @Nullable
    public <T extends Annotation> T getProperty(@NonNull Class<T> cls) {
        return (T) this.properties.get(cls);
    }

    public int hashCode() {
        return (this.name.hashCode() * 31) + this.properties.hashCode();
    }

    @NonNull
    public String toString() {
        return "FieldDescriptor{name=" + this.name + ", properties=" + this.properties.values() + "}";
    }
}
