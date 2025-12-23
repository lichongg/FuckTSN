package xyz.adscope.common.json.util;

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
import xyz.adscope.common.constants.CommonConstants;
import xyz.adscope.common.json.inter.JsonNode;
import xyz.adscope.common.tool.LogUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class JsonResolver {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static abstract class TypeToken<T> {

        /* renamed from: a, reason: collision with root package name */
        final Class<? super T> f56424a;

        /* renamed from: b, reason: collision with root package name */
        final Type f56425b;

        public Class<?> getRawType() {
            return this.f56424a;
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
            return this.f56425b;
        }

        protected TypeToken() {
            Type superclassTypeParameter = getSuperclassTypeParameter(getClass());
            this.f56425b = superclassTypeParameter;
            this.f56424a = (Class<? super T>) getRawType(superclassTypeParameter);
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

    private static String a(Object obj) {
        Object obj2;
        JSONObject jSONObject = new JSONObject();
        for (Field field : a(obj.getClass())) {
            if (!Modifier.isPublic(field.getModifiers())) {
                field.setAccessible(true);
            }
            JsonNode jsonNode = (JsonNode) field.getAnnotation(JsonNode.class);
            if (jsonNode != null && (obj2 = field.get(obj)) != null) {
                String key = jsonNode.key();
                Class<?> type = field.getType();
                if (isBasicType(type)) {
                    if (jSONObject.has(key)) {
                        LogUtil.d("JSON::", "class[" + field.getDeclaringClass().getSimpleName() + "] declares multiple JSON fields named name[" + key + "]..");
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

    public static <T> T fromJson(String str, Type type) {
        if (type instanceof Class) {
            return (T) a(new JSONObject(str), TypeToken.getRawType(type));
        }
        if (type instanceof ParameterizedType) {
            return (T) a(new JSONArray(str), TypeToken.getRawType(type), type);
        }
        if (type instanceof GenericArrayType) {
            return (T) a(new JSONArray(str), TypeToken.getRawType(type));
        }
        throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + type + "> is of type " + (type == null ? "null" : type.getClass().getName()));
    }

    public static boolean isWrapType(Class<?> cls) {
        return ((Class) cls.getField("TYPE").get(null)).isPrimitive();
    }

    public static String toJson(Object obj) {
        return toJson(obj, obj.getClass());
    }

    public static String toJson(Object obj, Class<?> cls) {
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
            return a(obj);
        }
        JSONArray jSONArray2 = new JSONArray();
        for (Object obj2 : (Object[]) obj) {
            jSONArray2.put(new JSONObject(toJson(obj2)));
        }
        return jSONArray2.toString();
    }

    public static boolean isBasicType(Class<?> cls) {
        if (!cls.isPrimitive() && !String.class.isAssignableFrom(cls)) {
            return isWrapType(cls);
        }
        return true;
    }

    public static <T> T fromJson(String str, Class<T> cls) {
        return (T) a(new JSONObject(str), cls);
    }

    private static <T> T a(JSONObject jSONObject, Class<T> cls) {
        T newInstance = cls.newInstance();
        for (Field field : a((Class<?>) cls)) {
            if (!Modifier.isPublic(field.getModifiers())) {
                field.setAccessible(true);
            }
            try {
                a(newInstance, field, jSONObject);
            } catch (JSONException e6) {
                LogUtil.e(CommonConstants.TAG, "e : " + e6);
            }
        }
        return newInstance;
    }

    private static void a(Object obj, Field field, JSONObject jSONObject) {
        JsonNode jsonNode = (JsonNode) field.getAnnotation(JsonNode.class);
        if (jsonNode != null) {
            String key = jsonNode.key();
            if (jSONObject.has(key)) {
                Class<?> type = field.getType();
                if (isBasicType(type)) {
                    Object obj2 = jSONObject.get(key);
                    jSONObject.remove(key);
                    try {
                        if (!isWrapType(type) && !String.class.isAssignableFrom(type)) {
                            field.set(obj, obj2);
                            return;
                        }
                        field.set(obj, type.getConstructor(String.class).newInstance(obj2.toString()));
                        return;
                    } catch (Exception unused) {
                        throw new JSONException("invalid value[" + obj2 + "] for field[" + field.getName() + "]; valueClass[" + obj2.getClass() + "]; annotationName[" + key + "]");
                    }
                }
                Object obj3 = jSONObject.get(key);
                if (obj3 == null || obj3.equals(null)) {
                    return;
                }
                if (List.class.isAssignableFrom(type)) {
                    field.set(obj, a(jSONObject.getJSONArray(key), type, field.getGenericType()));
                } else if (type.isArray()) {
                    field.set(obj, a(jSONObject.getJSONArray(key), type));
                } else {
                    field.set(obj, a(jSONObject.getJSONObject(key), type));
                }
            }
        }
    }

    private static List<Object> a(JSONArray jSONArray, Class<?> cls, Type type) {
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
                list.add(a(jSONArray.getJSONObject(i6), cls2));
            }
        }
        return list;
    }

    private static Object a(JSONArray jSONArray, Class<?> cls) {
        Object a6;
        Class<?> componentType = cls.getComponentType();
        int length = jSONArray.length();
        Object newInstance = Array.newInstance(componentType, length);
        for (int i6 = 0; i6 < length; i6++) {
            if (isBasicType(componentType)) {
                a6 = jSONArray.get(i6);
            } else {
                a6 = a(jSONArray.getJSONObject(i6), componentType);
            }
            Array.set(newInstance, i6, a6);
        }
        return newInstance;
    }

    private static List<Field> a(Class<?> cls) {
        ArrayList arrayList = new ArrayList();
        Collections.addAll(arrayList, cls.getDeclaredFields());
        a(arrayList, cls);
        return arrayList;
    }

    private static void a(List<Field> list, Class<?> cls) {
        Class<? super Object> superclass = cls.getSuperclass();
        if (superclass != null) {
            Field[] declaredFields = superclass.getDeclaredFields();
            if (declaredFields.length > 0) {
                Collections.addAll(list, declaredFields);
                a(list, superclass);
            }
        }
    }
}
