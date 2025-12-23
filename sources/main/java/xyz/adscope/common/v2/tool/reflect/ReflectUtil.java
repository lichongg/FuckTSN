package xyz.adscope.common.v2.tool.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import org.json.JSONObject;
import xyz.adscope.common.v2.log.SDKLog;
import xyz.adscope.common.v2.tool.str.StringUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class ReflectUtil {
    public static Object getBasicValue(Class<?> cls, Object obj) {
        if (Integer.TYPE.isAssignableFrom(cls) || Integer.class.isAssignableFrom(cls)) {
            return Integer.valueOf(StringUtil.parseInt(obj.toString()));
        }
        if (Float.TYPE.isAssignableFrom(cls) || Float.class.isAssignableFrom(cls)) {
            return Float.valueOf(StringUtil.parseFloat(obj.toString()));
        }
        if (Boolean.TYPE.isAssignableFrom(cls) || Boolean.class.isAssignableFrom(cls)) {
            if (obj instanceof String) {
                if (!Boolean.parseBoolean(obj.toString())) {
                    return Boolean.valueOf(StringUtil.parseInt(obj.toString()) > 0);
                }
            } else if (obj instanceof Integer) {
                return Boolean.valueOf(StringUtil.parseInt(obj.toString()) > 0);
            }
        } else {
            if (Double.TYPE.isAssignableFrom(cls) || Double.class.isAssignableFrom(cls)) {
                return Double.valueOf(StringUtil.parseDouble(obj.toString()));
            }
            if (Long.TYPE.isAssignableFrom(cls) || Long.class.isAssignableFrom(cls)) {
                return Long.valueOf(StringUtil.parseLong(obj.toString()));
            }
        }
        return obj;
    }

    public static boolean hasSdk(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static boolean isWrapType(Class<?> cls) {
        Object obj;
        try {
            obj = cls.getField("TYPE").get(null);
            Objects.requireNonNull(obj);
        } catch (Exception unused) {
        }
        return ((Class) obj).isPrimitive();
    }

    public static Object createNewBaseFromJsonModel(Class<?> cls, JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            Constructor<?> constructor = cls.getConstructor(JSONObject.class);
            constructor.setAccessible(true);
            return constructor.newInstance(jSONObject);
        } catch (IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e6) {
            SDKLog.stack(e6);
            return null;
        }
    }

    public static List<Field> getAllFields(Class<?> cls) {
        ArrayList arrayList = new ArrayList();
        Collections.addAll(arrayList, cls.getDeclaredFields());
        fillSuperFields(arrayList, cls);
        return arrayList;
    }

    public static List<Field> getDeclaredFields(Class<?> cls) {
        ArrayList arrayList = new ArrayList();
        Collections.addAll(arrayList, cls.getDeclaredFields());
        return arrayList;
    }

    private ReflectUtil() {
    }

    public static List<Object> createNewListInstance(Class<?> cls) {
        try {
            return (List) cls.newInstance();
        } catch (IllegalAccessException | InstantiationException e6) {
            SDKLog.stack(e6);
            return null;
        }
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

    public static Object getFieldValue(Object obj, Field field) {
        try {
            if (!Modifier.isPublic(field.getModifiers())) {
                field.setAccessible(true);
            }
            return field.get(obj);
        } catch (IllegalAccessException e6) {
            SDKLog.stack(e6);
            return null;
        }
    }

    public static boolean isAnnotationType(Field field, Class<? extends Annotation> cls) {
        return field.isAnnotationPresent(cls);
    }

    public static boolean isBasicType(Class<?> cls) {
        if (!cls.isPrimitive() && !String.class.isAssignableFrom(cls)) {
            return isWrapType(cls);
        }
        return true;
    }

    public static void setFieldValue(Object obj, Field field, Object obj2) {
        String str;
        try {
            if (!Modifier.isPublic(field.getModifiers())) {
                field.setAccessible(true);
            }
            Class<?> type = field.getType();
            if (String.class.isAssignableFrom(type)) {
                if (obj2 != null) {
                    str = obj2.toString();
                } else {
                    str = "";
                }
                field.set(obj, str);
                return;
            }
            field.set(obj, getBasicValue(type, obj2));
        } catch (IllegalAccessException | IllegalArgumentException | NullPointerException e6) {
            SDKLog.stack(e6);
        }
    }
}
