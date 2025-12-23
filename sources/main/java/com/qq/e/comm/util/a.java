package com.qq.e.comm.util;

import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final Map<String, Boolean> f36808a = new HashMap();

    private static String a(Class cls, String str, Class... clsArr) {
        if (cls == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(cls.getName());
        sb.append("#");
        sb.append(str);
        for (Class cls2 : clsArr) {
            sb.append("_");
            sb.append(cls2.getName());
        }
        return sb.toString();
    }

    private static boolean b(Class cls, String str, Class... clsArr) {
        String a6 = a(cls, str, clsArr);
        Map<String, Boolean> map = f36808a;
        Boolean bool = map.get(a6);
        if (bool != null) {
            return Boolean.TRUE.equals(bool);
        }
        try {
            cls.getDeclaredMethod(str, clsArr);
            map.put(a6, Boolean.TRUE);
            return true;
        } catch (NoSuchMethodException unused) {
            f36808a.put(a6, Boolean.FALSE);
            return false;
        }
    }

    public static boolean a(Object obj) {
        if (obj == null) {
            return false;
        }
        return b(obj.getClass(), "onRenderFail", new Class[0]);
    }

    public static boolean b(Object obj) {
        if (obj == null) {
            return false;
        }
        return b(obj.getClass(), "onRenderSuccess", new Class[0]);
    }
}
