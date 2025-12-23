package com.bytedance.sdk.openadsdk.ats;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes4.dex */
public final class xt {

    /* renamed from: j, reason: collision with root package name */
    static final Map<ClassLoader, Map<String, Class>> f27618j = new HashMap();

    public static String j(Class cls) {
        try {
            if (cls.getClassLoader() == ATSApi.class.getClassLoader()) {
                ATSApi aTSApi = (ATSApi) cls.getAnnotation(ATSApi.class);
                if (aTSApi != null) {
                    return aTSApi.value();
                }
                return null;
            }
            Annotation xt = xt(cls, "com.bytedance.sdk.openadsdk.ats.ATSApi");
            if (xt == null) {
                return null;
            }
            return String.valueOf(j(xt));
        } catch (Exception unused) {
            return null;
        }
    }

    public static Annotation xt(Class cls) {
        try {
            return cls.getClassLoader() == ATSApi.class.getClassLoader() ? cls.getAnnotation(ATSApi.class) : xt(cls, "com.bytedance.sdk.openadsdk.ats.ATSApi");
        } catch (Exception unused) {
            return null;
        }
    }

    public static Class cw(Class cls) {
        if (cls.getClassLoader() == ATSMethod.class.getClassLoader()) {
            return ATSMethod.class;
        }
        return j(cls, "com.bytedance.sdk.openadsdk.ats.ATSMethod");
    }

    private static Annotation xt(Class cls, String str) {
        Class<? extends Annotation> j6 = j(cls, str);
        if (j6 != null) {
            return cls.getAnnotation(j6);
        }
        return null;
    }

    public static Annotation j(Class cls, Method method) {
        if (cls.getClassLoader() == ATSMethod.class.getClassLoader()) {
            return method.getAnnotation(ATSMethod.class);
        }
        Class<? extends Annotation> j6 = j(cls, "com.bytedance.sdk.openadsdk.ats.ATSMethod");
        if (j6 == null) {
            return null;
        }
        return method.getAnnotation(j6);
    }

    private static Class<? extends Annotation> j(Class cls, String str) {
        Class<? extends Annotation> cls2;
        try {
            ClassLoader classLoader = cls.getClassLoader();
            if (classLoader == null) {
                return null;
            }
            Map<String, Class> map = f27618j.get(classLoader);
            if (map == null) {
                map = new HashMap<>(8);
                cls2 = null;
            } else {
                cls2 = map.get(str);
            }
            if (cls2 != null) {
                return cls2;
            }
            Class loadClass = classLoader.loadClass(str);
            if (loadClass != null) {
                map.put(str, loadClass);
            }
            return loadClass;
        } catch (Exception unused) {
            return null;
        }
    }

    public static Object j(Annotation annotation) {
        try {
            Method method = annotation.getClass().getMethod("value", null);
            if (method == null) {
                return null;
            }
            return method.invoke(annotation, null);
        } catch (Exception unused) {
            return null;
        }
    }
}
