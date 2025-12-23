package com.beizi.fusion.model;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class JsonResolver {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static abstract class TypeToken<T> {
        final Class<? super T> rawType;
        final Type type;

        public Class<?> getRawType() {
            return this.rawType;
        }

        public static Class<?> getRawType(Type type) {
            if (type instanceof Class) {
                return (Class) type;
            }
            if (type instanceof ParameterizedType) {
                Type rawType = ((ParameterizedType) type).getRawType();
                if (rawType instanceof Class) {
                    return (Class) rawType;
                }
                throw new IllegalArgumentException();
            }
            if (type instanceof GenericArrayType) {
                return Array.newInstance(getRawType(((GenericArrayType) type).getGenericComponentType()), 0).getClass();
            }
            if (type instanceof TypeVariable) {
                return Object.class;
            }
            if (type instanceof WildcardType) {
                return getRawType(((WildcardType) type).getUpperBounds()[0]);
            }
            throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + type + "> is of type " + (type == null ? "null" : type.getClass().getName()));
        }

        public Type getType() {
            return this.type;
        }

        protected TypeToken() {
            Type superclassTypeParameter = getSuperclassTypeParameter(getClass());
            this.type = superclassTypeParameter;
            this.rawType = (Class<? super T>) getRawType(superclassTypeParameter);
        }

        public static Type getInterfacesTypeParameter(Class<?> cls, Class<?> cls2) {
            for (Type type : cls.getGenericInterfaces()) {
                if ((type instanceof ParameterizedType) && cls2.isAssignableFrom(getRawType(type))) {
                    return ((ParameterizedType) type).getActualTypeArguments()[0];
                }
            }
            return null;
        }

        public static Type getSuperclassTypeParameter(Class<?> cls) {
            Type genericSuperclass = cls.getGenericSuperclass();
            if (!(genericSuperclass instanceof Class)) {
                return ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0];
            }
            throw new RuntimeException("Missing type parameter.");
        }
    }

    public static <T> T fromJson(String str, Type type) throws Exception {
        if (type instanceof Class) {
            return (T) fromJson(new JSONObject(str), TypeToken.getRawType(type));
        }
        if (type instanceof ParameterizedType) {
            return (T) jsonArray2List(new JSONArray(str), TypeToken.getRawType(type), type);
        }
        if (type instanceof GenericArrayType) {
            return (T) jsonArray2Array(new JSONArray(str), TypeToken.getRawType(type));
        }
        throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + type + "> is of type " + (type == null ? "null" : type.getClass().getName()));
    }

    public static boolean isWrapType(Class<?> cls) {
        return ((Class) cls.getField("TYPE").get(null)).isPrimitive();
    }

    public static String toJson(Object obj) throws Exception {
        return toJson(obj, obj.getClass());
    }

    private static void fillField(Object obj, Field field, JSONObject jSONObject) throws Exception {
        JsonNode jsonNode = (JsonNode) field.getAnnotation(JsonNode.class);
        if (jsonNode != null) {
            String key = jsonNode.key();
            if (jSONObject.has(key)) {
                Class<?> type = field.getType();
                if (!isBasicType(type)) {
                    Object obj2 = jSONObject.get(key);
                    if (obj2 == null || obj2.equals(null)) {
                        return;
                    }
                    if (List.class.isAssignableFrom(type)) {
                        field.set(obj, jsonArray2List(jSONObject.getJSONArray(key), type, field.getGenericType()));
                        return;
                    } else if (type.isArray()) {
                        field.set(obj, jsonArray2Array(jSONObject.getJSONArray(key), type));
                        return;
                    } else {
                        field.set(obj, fromJson(jSONObject.getJSONObject(key), type));
                        return;
                    }
                }
                Object obj3 = jSONObject.get(key);
                jSONObject.remove(key);
                try {
                    if (!isWrapType(type) && !String.class.isAssignableFrom(type)) {
                        field.set(obj, obj3);
                        return;
                    }
                    field.set(obj, type.getConstructor(String.class).newInstance(obj3.toString()));
                } catch (Exception unused) {
                    throw new JSONException("invalid value[" + obj3 + "] for field[" + field.getName() + "]; valueClass[" + obj3.getClass() + "]; annotationName[" + key + "]");
                }
            }
        }
    }

    private static List<Field> getAllFields(Class<?> cls) {
        ArrayList arrayList = new ArrayList();
        Collections.addAll(arrayList, cls.getDeclaredFields());
        fillSuperFields(arrayList, cls);
        return arrayList;
    }

    private static List<Object> jsonArray2List(JSONArray jSONArray, Class<?> cls, Type type) throws Exception {
        if (jSONArray == null || !(type instanceof ParameterizedType)) {
            return null;
        }
        if (cls.isInterface() || Modifier.isAbstract(cls.getModifiers())) {
            cls = ArrayList.class;
        }
        List<Object> list = (List) cls.newInstance();
        Class cls2 = (Class) ((ParameterizedType) type).getActualTypeArguments()[0];
        int length = jSONArray.length();
        for (int i6 = 0; i6 < length; i6++) {
            if (isBasicType(cls2)) {
                list.add(jSONArray.get(i6));
            } else {
                list.add(fromJson(jSONArray.getJSONObject(i6), cls2));
            }
        }
        return list;
    }

    private static String object2Json(Object obj) throws Exception {
        Object obj2;
        JSONObject jSONObject = new JSONObject();
        for (Field field : getAllFields(obj.getClass())) {
            if (!Modifier.isPublic(field.getModifiers())) {
                field.setAccessible(true);
            }
            JsonNode jsonNode = (JsonNode) field.getAnnotation(JsonNode.class);
            if (jsonNode != null && (obj2 = field.get(obj)) != null) {
                String key = jsonNode.key();
                Class<?> type = field.getType();
                if (isBasicType(type)) {
                    if (jSONObject.has(key)) {
                        field.getDeclaringClass().getSimpleName();
                    } else {
                        jSONObject.put(key, obj2);
                    }
                } else if (List.class.isAssignableFrom(type)) {
                    JSONArray jSONArray = new JSONArray();
                    for (Object obj3 : (List) obj2) {
                        if (isBasicType(obj3.getClass())) {
                            jSONArray.put(obj3);
                        } else {
                            jSONArray.put(new JSONObject(toJson(obj3)));
                        }
                    }
                    jSONObject.put(key, jSONArray);
                } else if (type.isArray()) {
                    JSONArray jSONArray2 = new JSONArray();
                    for (Object obj4 : (Object[]) obj2) {
                        if (isBasicType(obj4.getClass())) {
                            jSONArray2.put(obj4);
                        } else {
                            jSONArray2.put(new JSONObject(toJson(obj4)));
                        }
                    }
                    jSONObject.put(key, jSONArray2);
                } else {
                    jSONObject.put(key, new JSONObject(toJson(obj2)));
                }
            }
        }
        return jSONObject.toString();
    }

    public static String toJson(Object obj, Class<?> cls) throws Exception {
        if (isBasicType(cls)) {
            return obj.toString();
        }
        if (List.class.isAssignableFrom(cls)) {
            JSONArray jSONArray = new JSONArray();
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                jSONArray.put(new JSONObject(toJson(it.next())));
            }
            return jSONArray.toString();
        }
        if (!cls.isArray()) {
            return object2Json(obj);
        }
        JSONArray jSONArray2 = new JSONArray();
        for (Object obj2 : (Object[]) obj) {
            jSONArray2.put(new JSONObject(toJson(obj2)));
        }
        return jSONArray2.toString();
    }

    private static void fillSuperFields(List<Field> list, Class<?> cls) {
        Class<? super Object> superclass = cls.getSuperclass();
        if (superclass != null) {
            Field[] declaredFields = superclass.getDeclaredFields();
            if (declaredFields.length > 0) {
                Collections.addAll(list, declaredFields);
                fillSuperFields(list, superclass);
            }
        }
    }

    public static boolean isBasicType(Class<?> cls) {
        if (!cls.isPrimitive() && !String.class.isAssignableFrom(cls)) {
            return isWrapType(cls);
        }
        return true;
    }

    private static Object jsonArray2Array(JSONArray jSONArray, Class<?> cls) throws Exception {
        Object fromJson;
        Class<?> componentType = cls.getComponentType();
        int length = jSONArray.length();
        Object newInstance = Array.newInstance(componentType, length);
        for (int i6 = 0; i6 < length; i6++) {
            if (isBasicType(componentType)) {
                fromJson = jSONArray.get(i6);
            } else {
                fromJson = fromJson(jSONArray.getJSONObject(i6), componentType);
            }
            Array.set(newInstance, i6, fromJson);
        }
        return newInstance;
    }

    public static <T> T fromJson(String str, Class<T> cls) throws Exception {
        return (T) fromJson(new JSONObject(str), cls);
    }

    private static <T> T fromJson(JSONObject jSONObject, Class<T> cls) throws Exception {
        T newInstance = cls.newInstance();
        for (Field field : getAllFields(cls)) {
            if (!Modifier.isPublic(field.getModifiers())) {
                field.setAccessible(true);
            }
            try {
                fillField(newInstance, field, jSONObject);
            } catch (JSONException e6) {
                e6.printStackTrace();
            }
        }
        return newInstance;
    }
}
