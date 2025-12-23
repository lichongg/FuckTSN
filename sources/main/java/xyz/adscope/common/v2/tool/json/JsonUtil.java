package xyz.adscope.common.v2.tool.json;

import android.text.TextUtils;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import xyz.adscope.common.v2.log.SDKLog;
import xyz.adscope.common.v2.model.IBaseFromJsonModel;
import xyz.adscope.common.v2.model.IBaseToJsonModel;
import xyz.adscope.common.v2.model.IJsonMappingModel;
import xyz.adscope.common.v2.model.annotation.JsonParseNode;
import xyz.adscope.common.v2.tool.reflect.ReflectUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class JsonUtil {
    private static final String TAG = "JsonUtil";

    public static String entry2JsonString(Object obj) {
        return entry2JsonObject(obj, false).toString();
    }

    public static Object getObject(JSONObject jSONObject, String str) {
        try {
            if (jSONObject.has(str)) {
                return jSONObject.get(str);
            }
            return null;
        } catch (JSONException e6) {
            SDKLog.stack(e6);
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0028 A[Catch: JSONException -> 0x001e, TryCatch #0 {JSONException -> 0x001e, blocks: (B:6:0x0003, B:8:0x0009, B:10:0x000d, B:12:0x0013, B:15:0x0022, B:17:0x0028, B:19:0x0039, B:21:0x003f, B:24:0x0047), top: B:5:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.util.List<java.lang.Object> jsonArray2List(org.json.JSONArray r3, java.lang.Class<?> r4, java.lang.reflect.Type r5) {
        /*
            r0 = 0
            if (r3 == 0) goto L59
            int r1 = r3.length()     // Catch: org.json.JSONException -> L1e
            if (r1 <= 0) goto L59
            boolean r1 = r5 instanceof java.lang.reflect.ParameterizedType     // Catch: org.json.JSONException -> L1e
            if (r1 == 0) goto L59
            boolean r1 = r4.isInterface()     // Catch: org.json.JSONException -> L1e
            if (r1 != 0) goto L20
            int r1 = r4.getModifiers()     // Catch: org.json.JSONException -> L1e
            boolean r1 = java.lang.reflect.Modifier.isAbstract(r1)     // Catch: org.json.JSONException -> L1e
            if (r1 == 0) goto L22
            goto L20
        L1e:
            r3 = move-exception
            goto L56
        L20:
            java.lang.Class<java.util.ArrayList> r4 = java.util.ArrayList.class
        L22:
            java.util.List r0 = xyz.adscope.common.v2.tool.reflect.ReflectUtil.createNewListInstance(r4)     // Catch: org.json.JSONException -> L1e
            if (r0 == 0) goto L55
            java.lang.reflect.ParameterizedType r5 = (java.lang.reflect.ParameterizedType) r5     // Catch: org.json.JSONException -> L1e
            java.lang.reflect.Type[] r4 = r5.getActualTypeArguments()     // Catch: org.json.JSONException -> L1e
            r5 = 0
            r4 = r4[r5]     // Catch: org.json.JSONException -> L1e
            java.lang.Class r4 = (java.lang.Class) r4     // Catch: org.json.JSONException -> L1e
            int r1 = r3.length()     // Catch: org.json.JSONException -> L1e
        L37:
            if (r5 >= r1) goto L55
            boolean r2 = xyz.adscope.common.v2.tool.reflect.ReflectUtil.isBasicType(r4)     // Catch: org.json.JSONException -> L1e
            if (r2 == 0) goto L47
            java.lang.Object r2 = r3.get(r5)     // Catch: org.json.JSONException -> L1e
            r0.add(r2)     // Catch: org.json.JSONException -> L1e
            goto L52
        L47:
            org.json.JSONObject r2 = r3.getJSONObject(r5)     // Catch: org.json.JSONException -> L1e
            java.lang.Object r2 = xyz.adscope.common.v2.tool.reflect.ReflectUtil.createNewBaseFromJsonModel(r4, r2)     // Catch: org.json.JSONException -> L1e
            r0.add(r2)     // Catch: org.json.JSONException -> L1e
        L52:
            int r5 = r5 + 1
            goto L37
        L55:
            return r0
        L56:
            xyz.adscope.common.v2.log.SDKLog.stack(r3)
        L59:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: xyz.adscope.common.v2.tool.json.JsonUtil.jsonArray2List(org.json.JSONArray, java.lang.Class, java.lang.reflect.Type):java.util.List");
    }

    public static <T> T parseJson2Entry(String str, Class<T> cls) {
        if (isValidJson(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                List<Field> allFields = ReflectUtil.getAllFields(cls);
                T newInstance = cls.getConstructor(String.class).newInstance(str);
                for (Field field : allFields) {
                    setFieldValueByJson(newInstance, field, jSONObject, field.getName(), null);
                }
                return newInstance;
            } catch (IllegalAccessException e6) {
                e = e6;
                SDKLog.stack(e);
                return null;
            } catch (InstantiationException e7) {
                e = e7;
                SDKLog.stack(e);
                return null;
            } catch (NoSuchMethodException e8) {
                throw new RuntimeException(e8);
            } catch (InvocationTargetException e9) {
                e = e9;
                SDKLog.stack(e);
                return null;
            } catch (JSONException e10) {
                e = e10;
                SDKLog.stack(e);
                return null;
            }
        }
        return null;
    }

    public static String parseMap2JsonStr(Map<String, String> map) {
        JSONObject parseMap2JSONObject = parseMap2JSONObject(map, false);
        return parseMap2JSONObject != null ? parseMap2JSONObject.toString() : "";
    }

    public static JSONArray emptyJSONArray() {
        return new JSONArray();
    }

    public static JSONObject emptyJSONObject() {
        return new JSONObject();
    }

    public static int getInt(JSONObject jSONObject, String str, int i6) {
        if (jSONObject != null && jSONObject.has(str)) {
            try {
                return jSONObject.getInt(str);
            } catch (JSONException unused) {
            }
        }
        return i6;
    }

    public static JSONArray getJSONArray(JSONObject jSONObject, String str) {
        if (jSONObject == null || !jSONObject.has(str)) {
            return null;
        }
        try {
            return jSONObject.getJSONArray(str);
        } catch (JSONException e6) {
            SDKLog.stack(e6);
            return null;
        }
    }

    public static String getJSONArrayStr(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            return jSONObject.has(str2) ? jSONObject.getJSONArray(str2).toString() : "";
        } catch (JSONException e6) {
            SDKLog.stack(e6);
            return "";
        }
    }

    public static String getJSONArrayString(String str, String str2) {
        try {
            return getJSONArray(new JSONObject(str), str2).toString();
        } catch (JSONException unused) {
            return "";
        }
    }

    public static JSONObject getJSONObject(JSONObject jSONObject, String str) {
        if (jSONObject == null || !jSONObject.has(str)) {
            return null;
        }
        try {
            return jSONObject.getJSONObject(str);
        } catch (JSONException e6) {
            SDKLog.stack(e6);
            return null;
        }
    }

    public static String getStringFromArray(JSONArray jSONArray, int i6) {
        if (jSONArray == null || jSONArray.length() <= 0) {
            return "";
        }
        try {
            return jSONArray.getString(i6);
        } catch (JSONException e6) {
            SDKLog.stack(e6);
            return "";
        }
    }

    public static String getStringFromJson(JSONObject jSONObject, String str) {
        if (jSONObject == null || !jSONObject.has(str)) {
            return "";
        }
        try {
            return jSONObject.getString(str);
        } catch (JSONException unused) {
            return "";
        }
    }

    public static boolean isEmptyJSONObject(JSONObject jSONObject) {
        return jSONObject == null || jSONObject.length() == 0;
    }

    private static Object jsonArray2Array(JSONArray jSONArray, Class<?> cls) {
        if (jSONArray == null || jSONArray.length() <= 0) {
            return null;
        }
        try {
            Class<?> componentType = cls.getComponentType();
            if (componentType == null) {
                return null;
            }
            int length = jSONArray.length();
            Object newInstance = Array.newInstance(componentType, length);
            for (int i6 = 0; i6 < length; i6++) {
                Array.set(newInstance, i6, ReflectUtil.isBasicType(componentType) ? jSONArray.get(i6) : ReflectUtil.createNewBaseFromJsonModel(componentType, jSONArray.getJSONObject(i6)));
            }
            return newInstance;
        } catch (JSONException e6) {
            SDKLog.stack(e6);
            return null;
        }
    }

    public static JSONObject keepValues(JSONObject jSONObject, String[] strArr) {
        try {
            return new JSONObject(jSONObject, strArr);
        } catch (JSONException e6) {
            SDKLog.stack(e6);
            return null;
        }
    }

    public static JSONObject parseEntry2Json(Object obj) {
        JsonParseNode jsonParseNode;
        if (obj != null) {
            try {
                JSONObject emptyJSONObject = emptyJSONObject();
                List<Field> allFields = ReflectUtil.getAllFields(obj.getClass());
                if (!allFields.isEmpty()) {
                    for (Field field : allFields) {
                        if (ReflectUtil.isAnnotationType(field, JsonParseNode.class) && (jsonParseNode = (JsonParseNode) field.getAnnotation(JsonParseNode.class)) != null) {
                            String key = jsonParseNode.key();
                            if (ReflectUtil.isBasicType(field.getType())) {
                                emptyJSONObject.put(key, ReflectUtil.getFieldValue(obj, field));
                            } else if (IJsonMappingModel.class.isAssignableFrom(field.getType())) {
                                emptyJSONObject.put(key, parseEntry2Json(ReflectUtil.getFieldValue(obj, field)));
                            } else if (List.class.isAssignableFrom(field.getType())) {
                                emptyJSONObject.put(key, list2JSONArray(ReflectUtil.getFieldValue(obj, field), field.getGenericType()));
                            } else if (field.getType().isArray()) {
                                emptyJSONObject.put(key, array2JSONArray(ReflectUtil.getFieldValue(obj, field), field.getGenericType()));
                            }
                        }
                    }
                }
                return emptyJSONObject;
            } catch (JSONException unused) {
            }
        }
        return emptyJSONObject();
    }

    public static JSONArray parseJSONArray(String str) {
        try {
            return new JSONArray(str);
        } catch (JSONException e6) {
            SDKLog.stack(e6);
            return null;
        }
    }

    private static JSONArray parseJSONArrayByIterator(Iterator<Object> it, boolean z5) {
        if (it == null) {
            return null;
        }
        JSONArray emptyJSONArray = emptyJSONArray();
        while (it.hasNext()) {
            Object next = it.next();
            if (ReflectUtil.isBasicType(next.getClass())) {
                emptyJSONArray.put(next);
            } else {
                emptyJSONArray.put(entry2JsonObject(next, z5));
            }
        }
        return emptyJSONArray;
    }

    public static JSONObject parseJSONObject(String str) {
        try {
            return new JSONObject(str);
        } catch (JSONException e6) {
            SDKLog.stack(e6);
            return null;
        }
    }

    public static JSONArray parseList2JSONArray(List<IJsonMappingModel> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        JSONArray emptyJSONArray = emptyJSONArray();
        for (IJsonMappingModel iJsonMappingModel : list) {
            if (iJsonMappingModel instanceof IBaseFromJsonModel) {
                emptyJSONArray.put(((IBaseFromJsonModel) iJsonMappingModel).asJsonObject());
            } else {
                emptyJSONArray.put(parseJSONObject(iJsonMappingModel.toJsonString()));
            }
        }
        return emptyJSONArray;
    }

    public static JSONObject parseMap2JSONObject(Map<String, String> map, boolean z5) {
        if (map == null) {
            return null;
        }
        try {
            if (map.isEmpty()) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (entry != null) {
                    String value = entry.getValue();
                    if (!z5 || TextUtils.isEmpty(value)) {
                        String key = entry.getKey();
                        if (value == null) {
                            value = "";
                        }
                        jSONObject.put(key, value);
                    } else {
                        jSONObject.put(entry.getKey(), entry.getValue());
                    }
                }
            }
            return jSONObject;
        } catch (JSONException e6) {
            SDKLog.stack(e6);
            return null;
        }
    }

    public static JSONArray parseMap2JsonByKeys(Map<String, String> map, String str, String str2) {
        if (map != null) {
            try {
                if (!map.isEmpty()) {
                    JSONArray jSONArray = new JSONArray();
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        JSONObject jSONObject = new JSONObject();
                        if (entry != null) {
                            jSONObject.put(str, entry.getKey());
                            jSONObject.put(str2, entry.getValue());
                        }
                        jSONArray.put(jSONObject);
                    }
                    return jSONArray;
                }
            } catch (JSONException e6) {
                SDKLog.stack(e6);
            }
        }
        return emptyJSONArray();
    }

    public static JSONObject removeJsonObjectKeys(JSONObject jSONObject, String... strArr) {
        if (strArr != null) {
            for (String str : strArr) {
                jSONObject.remove(str);
            }
        }
        return jSONObject;
    }

    private JsonUtil() {
    }

    private static JSONArray array2JSONArray(Object obj, Type type) {
        JSONArray emptyJSONArray = emptyJSONArray();
        if (obj != null && obj.getClass().isArray()) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length > 0) {
                Class cls = (Class) ((ParameterizedType) type).getActualTypeArguments()[0];
                for (Object obj2 : objArr) {
                    if (ReflectUtil.isBasicType(cls)) {
                        emptyJSONArray.put(obj2);
                    } else if (IJsonMappingModel.class.isAssignableFrom(cls)) {
                        emptyJSONArray.put(parseEntry2Json(obj2));
                    }
                }
            }
        }
        return emptyJSONArray;
    }

    public static JSONObject entry2JsonObject(Object obj, boolean z5) {
        JsonParseNode jsonParseNode;
        Class<?> cls = obj.getClass();
        List<Field> allFields = ReflectUtil.getAllFields(cls);
        JSONObject emptyJSONObject = emptyJSONObject();
        for (Field field : allFields) {
            if (ReflectUtil.isAnnotationType(field, JsonParseNode.class) && (jsonParseNode = (JsonParseNode) field.getAnnotation(JsonParseNode.class)) != null && !jsonParseNode.exclude()) {
                Object parseValue = parseValue(obj, field, z5);
                if (z5) {
                    if (parseValue != null) {
                        try {
                            if ((parseValue instanceof String) && !TextUtils.isEmpty(parseValue.toString())) {
                                emptyJSONObject.put(jsonParseNode.key(), parseValue);
                            }
                        } catch (JSONException unused) {
                            SDKLog.e(TAG, "转json异常..." + cls.getSimpleName() + " " + field.getName());
                        }
                    }
                } else {
                    emptyJSONObject.put(jsonParseNode.key(), parseValue);
                }
            }
        }
        return emptyJSONObject;
    }

    public static String getJSONString(JSONObject jSONObject, String str) {
        JSONObject jSONObject2 = getJSONObject(jSONObject, str);
        if (jSONObject2 != null) {
            return jSONObject2.toString();
        }
        return "";
    }

    public static boolean isValidJson(String str) {
        JSONObject parseJSONObject;
        if (TextUtils.isEmpty(str) || (parseJSONObject = parseJSONObject(str)) == null) {
            return false;
        }
        return parseJSONObject.keys().hasNext();
    }

    private static JSONArray list2JSONArray(Object obj, Type type) {
        JSONArray emptyJSONArray = emptyJSONArray();
        if (obj != null && obj.getClass().isArray()) {
            List list = (List) obj;
            if (!list.isEmpty()) {
                Class cls = (Class) ((ParameterizedType) type).getActualTypeArguments()[0];
                for (int i6 = 0; i6 < list.size(); i6++) {
                    if (ReflectUtil.isBasicType(cls)) {
                        emptyJSONArray.put(list.get(i6));
                    } else if (IJsonMappingModel.class.isAssignableFrom(cls)) {
                        emptyJSONArray.put(parseEntry2Json(list.get(i6)));
                    }
                }
            }
        }
        return emptyJSONArray;
    }

    private static Object parseValue(Object obj, Field field, boolean z5) {
        Object fieldValue = ReflectUtil.getFieldValue(obj, field);
        if (ReflectUtil.isBasicType(field.getType())) {
            if (fieldValue != null) {
                return fieldValue;
            }
            if (String.class.isAssignableFrom(field.getType())) {
                return "";
            }
            return 0;
        }
        if (List.class.isAssignableFrom(field.getType())) {
            if (fieldValue != null) {
                List list = (List) fieldValue;
                if (!list.isEmpty()) {
                    return parseJSONArrayByIterator(list.iterator(), z5);
                }
            }
            return emptyJSONArray();
        }
        if (field.getType().isArray()) {
            if (fieldValue != null) {
                Object[] objArr = (Object[]) fieldValue;
                if (objArr.length > 0) {
                    return parseJSONArrayByIterator(Arrays.asList(objArr).iterator(), z5);
                }
            }
            return emptyJSONArray();
        }
        if (fieldValue instanceof IBaseToJsonModel) {
            return entry2JsonObject(fieldValue, z5);
        }
        return null;
    }

    public static void putObject(JSONObject jSONObject, String str, Object obj) {
        try {
            jSONObject.put(str, obj);
        } catch (JSONException e6) {
            SDKLog.stack(e6);
        }
    }

    private static void setFieldValueByJson(Object obj, Field field, JSONObject jSONObject, String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            if (ReflectUtil.isBasicType(field.getType())) {
                if (jSONObject.opt(str) != null) {
                    ReflectUtil.setFieldValue(obj, field, jSONObject.opt(str));
                } else if (!TextUtils.isEmpty(str2)) {
                    ReflectUtil.setFieldValue(obj, field, str2);
                }
            }
            if (jSONObject.has(str)) {
                if (IBaseFromJsonModel.class.isAssignableFrom(field.getType())) {
                    ReflectUtil.setFieldValue(obj, field, ReflectUtil.createNewBaseFromJsonModel(field.getType(), getJSONObject(jSONObject, str)));
                    return;
                } else if (List.class.isAssignableFrom(field.getType())) {
                    ReflectUtil.setFieldValue(obj, field, jsonArray2List(getJSONArray(jSONObject, str), field.getType(), field.getGenericType()));
                    return;
                } else {
                    if (field.getType().isArray()) {
                        ReflectUtil.setFieldValue(obj, field, jsonArray2Array(getJSONArray(jSONObject, str), field.getType()));
                        return;
                    }
                    return;
                }
            }
            return;
        }
        if (IBaseFromJsonModel.class.isAssignableFrom(field.getType())) {
            ReflectUtil.setFieldValue(obj, field, ReflectUtil.createNewBaseFromJsonModel(field.getType(), jSONObject));
        }
    }

    public static void updateJSONValue(JSONObject jSONObject, String str, Object obj) {
        try {
            if (jSONObject.has(str)) {
                jSONObject.remove(str);
            }
            jSONObject.put(str, obj);
        } catch (JSONException e6) {
            SDKLog.stack(e6);
        }
    }

    public static Object getObject(String str, String str2) {
        try {
            return getObject(new JSONObject(str), str2);
        } catch (JSONException e6) {
            SDKLog.stack(e6);
            return null;
        }
    }

    public static void parseJson2Entry(IJsonMappingModel iJsonMappingModel, JSONObject jSONObject) {
        JsonParseNode jsonParseNode;
        if (jSONObject != null) {
            List<Field> allFields = ReflectUtil.getAllFields(iJsonMappingModel.getClass());
            if (allFields.isEmpty()) {
                return;
            }
            for (Field field : allFields) {
                if (ReflectUtil.isAnnotationType(field, JsonParseNode.class) && (jsonParseNode = (JsonParseNode) field.getAnnotation(JsonParseNode.class)) != null) {
                    setFieldValueByJson(iJsonMappingModel, field, jSONObject, jsonParseNode.key(), jsonParseNode.defValue());
                }
            }
        }
    }
}
