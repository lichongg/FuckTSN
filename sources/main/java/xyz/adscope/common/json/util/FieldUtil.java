package xyz.adscope.common.json.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;
import xyz.adscope.common.constants.CommonConstants;
import xyz.adscope.common.tool.LogUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class FieldUtil {
    public static void fillField(JSONObject jSONObject, Object obj, Field field) {
        Object obj2;
        if (jSONObject == null || obj == null || jSONObject.equals("{}") || field == null) {
            return;
        }
        try {
            Class<?> type = field.getType();
            String name = field.getName();
            if (!jSONObject.has(name) || (obj2 = jSONObject.get(name)) == null || obj2.equals(null)) {
                return;
            }
            if (TypeUtil.isBasicType(type)) {
                jSONObject.remove(name);
                if (!TypeUtil.isWrapType(type) && !String.class.isAssignableFrom(type)) {
                    field.set(obj, obj2);
                    return;
                }
                field.set(obj, type.getConstructor(String.class).newInstance(obj2.toString()));
                return;
            }
            if (List.class.isAssignableFrom(type)) {
                field.set(obj, JsonUtil.jsonArrayToList(jSONObject.getJSONArray(name), type, field.getGenericType()));
                return;
            }
            if (!type.isArray()) {
                LogUtil.i("FiledUtil", "fieldClazz bean type ");
                field.set(obj, JsonUtil.fromJson(jSONObject.getJSONObject(name), type));
            } else {
                Object jsonArrayToArray = JsonUtil.jsonArrayToArray(jSONObject.getJSONArray(name), type);
                if (jsonArrayToArray != null) {
                    field.set(obj, jsonArrayToArray);
                }
            }
        } catch (Exception e6) {
            LogUtil.e(CommonConstants.TAG, "e : " + e6);
        }
    }

    public static List<Field> getAllFields(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        while (cls != null) {
            arrayList.addAll(new ArrayList(Arrays.asList(cls.getDeclaredFields())));
            cls = cls.getSuperclass();
        }
        return arrayList;
    }
}
