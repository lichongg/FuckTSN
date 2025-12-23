package xyz.adscope.common.json.util;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import xyz.adscope.common.constants.CommonConstants;
import xyz.adscope.common.tool.LogUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class JsonUtil {
    public static <T> T fromJson(String str, Class<T> cls) {
        return (T) fromJson(new JSONObject(str), cls);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x003a A[Catch: Exception -> 0x001f, TryCatch #0 {Exception -> 0x001f, blocks: (B:6:0x000a, B:8:0x000e, B:10:0x0014, B:13:0x0023, B:15:0x003a, B:17:0x0040, B:20:0x0048), top: B:5:0x000a }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.List<java.lang.Object> jsonArrayToList(org.json.JSONArray r4, java.lang.Class<?> r5, java.lang.reflect.Type r6) {
        /*
            r0 = 0
            if (r4 == 0) goto L6d
            int r1 = r4.length()
            if (r1 != 0) goto La
            goto L6d
        La:
            boolean r1 = r6 instanceof java.lang.reflect.ParameterizedType     // Catch: java.lang.Exception -> L1f
            if (r1 == 0) goto L6d
            boolean r1 = r5.isInterface()     // Catch: java.lang.Exception -> L1f
            if (r1 != 0) goto L21
            int r1 = r5.getModifiers()     // Catch: java.lang.Exception -> L1f
            boolean r1 = java.lang.reflect.Modifier.isAbstract(r1)     // Catch: java.lang.Exception -> L1f
            if (r1 == 0) goto L23
            goto L21
        L1f:
            r4 = move-exception
            goto L57
        L21:
            java.lang.Class<java.util.ArrayList> r5 = java.util.ArrayList.class
        L23:
            java.lang.Object r5 = r5.newInstance()     // Catch: java.lang.Exception -> L1f
            java.util.List r5 = (java.util.List) r5     // Catch: java.lang.Exception -> L1f
            java.lang.reflect.ParameterizedType r6 = (java.lang.reflect.ParameterizedType) r6     // Catch: java.lang.Exception -> L1f
            java.lang.reflect.Type[] r6 = r6.getActualTypeArguments()     // Catch: java.lang.Exception -> L1f
            r1 = 0
            r6 = r6[r1]     // Catch: java.lang.Exception -> L1f
            java.lang.Class r6 = (java.lang.Class) r6     // Catch: java.lang.Exception -> L1f
            int r2 = r4.length()     // Catch: java.lang.Exception -> L1f
        L38:
            if (r1 >= r2) goto L56
            boolean r3 = xyz.adscope.common.json.util.TypeUtil.isBasicType(r6)     // Catch: java.lang.Exception -> L1f
            if (r3 == 0) goto L48
            java.lang.Object r3 = r4.get(r1)     // Catch: java.lang.Exception -> L1f
            r5.add(r3)     // Catch: java.lang.Exception -> L1f
            goto L53
        L48:
            org.json.JSONObject r3 = r4.getJSONObject(r1)     // Catch: java.lang.Exception -> L1f
            java.lang.Object r3 = fromJson(r3, r6)     // Catch: java.lang.Exception -> L1f
            r5.add(r3)     // Catch: java.lang.Exception -> L1f
        L53:
            int r1 = r1 + 1
            goto L38
        L56:
            return r5
        L57:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "e : "
            r5.append(r6)
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            java.lang.String r5 = "common_log"
            xyz.adscope.common.tool.LogUtil.e(r5, r4)
        L6d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: xyz.adscope.common.json.util.JsonUtil.jsonArrayToList(org.json.JSONArray, java.lang.Class, java.lang.reflect.Type):java.util.List");
    }

    public static String addEscapeChar(String str) {
        if (str == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i6 = 0; i6 < str.length(); i6++) {
            char charAt = str.charAt(i6);
            if (charAt == '\t') {
                sb.append("\\t");
            } else if (charAt == '\n') {
                sb.append("\\n");
            } else if (charAt == '\r') {
                sb.append("\\r");
            } else if (charAt == '\"') {
                sb.append("\\\"");
            } else if (charAt != '\\') {
                sb.append(charAt);
            } else {
                sb.append("\\\\");
            }
        }
        return ((Object) sb) + "";
    }

    public static <T> T fromJson(JSONObject jSONObject, Class<T> cls) {
        try {
            T newInstance = cls.newInstance();
            List<Field> allFields = FieldUtil.getAllFields(cls);
            if (allFields != null && allFields.size() > 0) {
                for (Field field : allFields) {
                    if (!Modifier.isPublic(field.getModifiers())) {
                        field.setAccessible(true);
                    }
                    FieldUtil.fillField(jSONObject, newInstance, field);
                }
            }
            return newInstance;
        } catch (IllegalAccessException e6) {
            LogUtil.e(CommonConstants.TAG, "e : " + e6);
            return null;
        } catch (InstantiationException e7) {
            LogUtil.e(CommonConstants.TAG, "e : " + e7);
            return null;
        }
    }

    public static String objectToJson(Object obj) {
        try {
            JSONObject jSONObject = new JSONObject();
            List<Field> allFields = FieldUtil.getAllFields(obj.getClass());
            if (allFields != null && allFields.size() > 0) {
                for (Field field : allFields) {
                    if (!Modifier.isPublic(field.getModifiers()) && field.getModifiers() == 2) {
                        field.setAccessible(true);
                    }
                    a(jSONObject, obj, field);
                }
            }
            return jSONObject.toString();
        } catch (Exception e6) {
            LogUtil.e(CommonConstants.TAG, "e : " + e6);
            return null;
        }
    }

    public static JSONObject objectToJsonObject(Object obj) {
        try {
            JSONObject jSONObject = new JSONObject();
            List<Field> allFields = FieldUtil.getAllFields(obj.getClass());
            if (allFields != null && allFields.size() > 0) {
                for (Field field : allFields) {
                    if (!Modifier.isPublic(field.getModifiers()) && field.getModifiers() == 2) {
                        field.setAccessible(true);
                    }
                    a(jSONObject, obj, field);
                }
            }
            return jSONObject;
        } catch (Exception e6) {
            LogUtil.e(CommonConstants.TAG, "e : " + e6);
            return null;
        }
    }

    public static String toJson(Object obj) {
        if (obj == null) {
            return "";
        }
        try {
            Class<?> cls = obj.getClass();
            if (TypeUtil.isBasicType(cls)) {
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
                return objectToJson(obj);
            }
            JSONArray jSONArray2 = new JSONArray();
            for (Object obj2 : (Object[]) obj) {
                jSONArray2.put(new JSONObject(toJson(obj2)));
            }
            return jSONArray2.toString();
        } catch (JSONException e6) {
            LogUtil.e(CommonConstants.TAG, "e : " + e6);
            return "";
        }
    }

    private static void a(JSONObject jSONObject, Object obj, Field field) {
        try {
            Class<?> type = field.getType();
            String name = field.getName();
            Object obj2 = field.get(obj);
            if (obj2 != null && !obj2.equals(null)) {
                if (TypeUtil.isBasicType(type)) {
                    if (!jSONObject.has(name)) {
                        jSONObject.put(name, obj2);
                        return;
                    }
                    return;
                }
                if (List.class.isAssignableFrom(type)) {
                    JSONArray jSONArray = new JSONArray();
                    for (Object obj3 : (List) obj2) {
                        if (TypeUtil.isBasicType(obj3.getClass())) {
                            jSONArray.put(obj3);
                        } else if (obj3 instanceof JSONObject) {
                            jSONArray.put(obj3);
                        } else {
                            jSONArray.put(new JSONObject(toJson(obj3)));
                        }
                    }
                    jSONObject.put(name, jSONArray);
                    return;
                }
                if (type.isArray()) {
                    JSONArray jSONArray2 = new JSONArray();
                    for (Object obj4 : (Object[]) obj2) {
                        if (TypeUtil.isBasicType(obj4.getClass())) {
                            jSONArray2.put(obj4);
                        } else if (obj4 instanceof JSONObject) {
                            jSONArray2.put(obj4);
                        } else {
                            jSONArray2.put(new JSONObject(toJson(obj4)));
                        }
                    }
                    jSONObject.put(name, jSONArray2);
                    return;
                }
                if (JSONObject.class.isAssignableFrom(type)) {
                    if (obj2 instanceof JSONObject) {
                        jSONObject.put(name, obj2);
                        LogUtil.i("JsonUtil", "valueJsonObject " + obj2);
                        return;
                    }
                    return;
                }
                jSONObject.put(name, new JSONObject(toJson(obj2)));
            }
        } catch (Exception e6) {
            LogUtil.e(CommonConstants.TAG, "e : " + e6);
        }
    }

    public static Object jsonArrayToArray(JSONArray jSONArray, Class<?> cls) {
        Object fromJson;
        try {
            Class<?> componentType = cls.getComponentType();
            int length = jSONArray.length();
            Object newInstance = Array.newInstance(componentType, length);
            for (int i6 = 0; i6 < length; i6++) {
                if (TypeUtil.isBasicType(componentType)) {
                    fromJson = jSONArray.get(i6);
                } else {
                    fromJson = fromJson(jSONArray.getJSONObject(i6), componentType);
                }
                Array.set(newInstance, i6, fromJson);
            }
            return newInstance;
        } catch (Exception e6) {
            LogUtil.e(CommonConstants.TAG, "e : " + e6);
            return null;
        }
    }
}
