package com.google.gson.internal.bind;

import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.internal.C$Gson$Types;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.ObjectConstructor;
import com.google.gson.internal.Primitives;
import com.google.gson.internal.reflect.ReflectionAccessor;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class ReflectiveTypeAdapterFactory implements TypeAdapterFactory {
    private final ReflectionAccessor accessor = ReflectionAccessor.getInstance();
    private final ConstructorConstructor constructorConstructor;
    private final Excluder excluder;
    private final FieldNamingStrategy fieldNamingPolicy;
    private final JsonAdapterAnnotationTypeAdapterFactory jsonAdapterFactory;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Adapter<T> extends TypeAdapter<T> {
        private final Map<String, BoundField> boundFields;
        private final ObjectConstructor<T> constructor;

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, T t5) throws IOException {
            if (t5 == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            try {
                for (BoundField boundField : this.boundFields.values()) {
                    if (boundField.writeField(t5)) {
                        jsonWriter.name(boundField.name);
                        boundField.write(jsonWriter, t5);
                    }
                }
                jsonWriter.endObject();
            } catch (IllegalAccessException e6) {
                throw new AssertionError(e6);
            }
        }

        Adapter(ObjectConstructor<T> objectConstructor, Map<String, BoundField> map) {
            this.constructor = objectConstructor;
            this.boundFields = map;
        }

        @Override // com.google.gson.TypeAdapter
        public T read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            T construct = this.constructor.construct();
            try {
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    BoundField boundField = this.boundFields.get(jsonReader.nextName());
                    if (boundField != null && boundField.deserialized) {
                        boundField.read(jsonReader, construct);
                    }
                    jsonReader.skipValue();
                }
                jsonReader.endObject();
                return construct;
            } catch (IllegalAccessException e6) {
                throw new AssertionError(e6);
            } catch (IllegalStateException e7) {
                throw new JsonSyntaxException(e7);
            }
        }
    }

    public boolean excludeField(Field field, boolean z5) {
        return excludeField(field, z5, this.excluder);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static abstract class BoundField {
        final boolean deserialized;
        final String name;
        final boolean serialized;

        abstract void read(JsonReader jsonReader, Object obj) throws IOException, IllegalAccessException;

        abstract void write(JsonWriter jsonWriter, Object obj) throws IOException, IllegalAccessException;

        abstract boolean writeField(Object obj) throws IOException, IllegalAccessException;

        protected BoundField(String str, boolean z5, boolean z6) {
            this.name = str;
            this.serialized = z5;
            this.deserialized = z6;
        }
    }

    static boolean excludeField(Field field, boolean z5, Excluder excluder) {
        return (excluder.excludeClass(field.getType(), z5) || excluder.excludeField(field, z5)) ? false : true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v2, types: [int] */
    /* JADX WARN: Type inference failed for: r13v5 */
    /* JADX WARN: Type inference failed for: r13v6 */
    private Map<String, BoundField> getBoundFields(Gson gson, TypeToken<?> typeToken, Class<?> cls) {
        TypeToken<?> typeToken2;
        ReflectiveTypeAdapterFactory reflectiveTypeAdapterFactory = this;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (!cls.isInterface()) {
            Type type = typeToken.getType();
            TypeToken<?> typeToken3 = typeToken;
            Class<?> cls2 = cls;
            while (cls2 != Object.class) {
                Field[] declaredFields = cls2.getDeclaredFields();
                int length = declaredFields.length;
                boolean z5 = false;
                int i6 = 0;
                ReflectiveTypeAdapterFactory reflectiveTypeAdapterFactory2 = reflectiveTypeAdapterFactory;
                while (i6 < length) {
                    Field field = declaredFields[i6];
                    boolean excludeField = reflectiveTypeAdapterFactory2.excludeField(field, true);
                    boolean excludeField2 = reflectiveTypeAdapterFactory2.excludeField(field, z5);
                    if (excludeField || excludeField2) {
                        reflectiveTypeAdapterFactory2.accessor.makeAccessible(field);
                        Type resolve = C$Gson$Types.resolve(typeToken3.getType(), cls2, field.getGenericType());
                        List<String> fieldNames = reflectiveTypeAdapterFactory2.getFieldNames(field);
                        int size = fieldNames.size();
                        BoundField boundField = null;
                        ReflectiveTypeAdapterFactory reflectiveTypeAdapterFactory3 = reflectiveTypeAdapterFactory2;
                        for (?? r13 = z5; r13 < size; r13++) {
                            String str = fieldNames.get(r13);
                            if (r13 != 0) {
                                excludeField = false;
                            }
                            int i7 = size;
                            List<String> list = fieldNames;
                            TypeToken<?> typeToken4 = typeToken3;
                            BoundField boundField2 = boundField;
                            boolean z6 = excludeField;
                            BoundField boundField3 = (BoundField) linkedHashMap.put(str, reflectiveTypeAdapterFactory3.createBoundField(gson, field, str, TypeToken.get(resolve), z6, excludeField2));
                            if (boundField2 != null) {
                                boundField3 = boundField2;
                            }
                            typeToken3 = typeToken4;
                            excludeField = z6;
                            fieldNames = list;
                            size = i7;
                            boundField = boundField3;
                            reflectiveTypeAdapterFactory3 = this;
                        }
                        typeToken2 = typeToken3;
                        BoundField boundField4 = boundField;
                        if (boundField4 != null) {
                            throw new IllegalArgumentException(type + " declares multiple JSON fields named " + boundField4.name);
                        }
                    } else {
                        typeToken2 = typeToken3;
                    }
                    i6++;
                    z5 = false;
                    reflectiveTypeAdapterFactory2 = this;
                    typeToken3 = typeToken2;
                }
                typeToken3 = TypeToken.get(C$Gson$Types.resolve(typeToken3.getType(), cls2, cls2.getGenericSuperclass()));
                cls2 = typeToken3.getRawType();
                reflectiveTypeAdapterFactory = this;
            }
        }
        return linkedHashMap;
    }

    private List<String> getFieldNames(Field field) {
        SerializedName serializedName = (SerializedName) field.getAnnotation(SerializedName.class);
        if (serializedName == null) {
            return Collections.singletonList(this.fieldNamingPolicy.translateName(field));
        }
        String value = serializedName.value();
        String[] alternate = serializedName.alternate();
        if (alternate.length == 0) {
            return Collections.singletonList(value);
        }
        ArrayList arrayList = new ArrayList(alternate.length + 1);
        arrayList.add(value);
        for (String str : alternate) {
            arrayList.add(str);
        }
        return arrayList;
    }

    public ReflectiveTypeAdapterFactory(ConstructorConstructor constructorConstructor, FieldNamingStrategy fieldNamingStrategy, Excluder excluder, JsonAdapterAnnotationTypeAdapterFactory jsonAdapterAnnotationTypeAdapterFactory) {
        this.constructorConstructor = constructorConstructor;
        this.fieldNamingPolicy = fieldNamingStrategy;
        this.excluder = excluder;
        this.jsonAdapterFactory = jsonAdapterAnnotationTypeAdapterFactory;
    }

    private BoundField createBoundField(final Gson gson, final Field field, String str, final TypeToken<?> typeToken, boolean z5, boolean z6) {
        TypeAdapter<?> typeAdapter;
        final boolean z7;
        final boolean isPrimitive = Primitives.isPrimitive(typeToken.getRawType());
        JsonAdapter jsonAdapter = (JsonAdapter) field.getAnnotation(JsonAdapter.class);
        if (jsonAdapter != null) {
            typeAdapter = this.jsonAdapterFactory.getTypeAdapter(this.constructorConstructor, gson, typeToken, jsonAdapter);
        } else {
            typeAdapter = null;
        }
        if (typeAdapter != null) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (typeAdapter == null) {
            typeAdapter = gson.getAdapter(typeToken);
        }
        final TypeAdapter<?> typeAdapter2 = typeAdapter;
        return new BoundField(str, z5, z6) { // from class: com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.1
            @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.BoundField
            void read(JsonReader jsonReader, Object obj) throws IOException, IllegalAccessException {
                Object read = typeAdapter2.read(jsonReader);
                if (read == null && isPrimitive) {
                    return;
                }
                field.set(obj, read);
            }

            @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.BoundField
            void write(JsonWriter jsonWriter, Object obj) throws IOException, IllegalAccessException {
                (z7 ? typeAdapter2 : new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter2, typeToken.getType())).write(jsonWriter, field.get(obj));
            }

            @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.BoundField
            public boolean writeField(Object obj) throws IOException, IllegalAccessException {
                return this.serialized && field.get(obj) != obj;
            }
        };
    }

    @Override // com.google.gson.TypeAdapterFactory
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        Class<? super T> rawType = typeToken.getRawType();
        if (!Object.class.isAssignableFrom(rawType)) {
            return null;
        }
        return new Adapter(this.constructorConstructor.get(typeToken), getBoundFields(gson, typeToken, rawType));
    }
}
