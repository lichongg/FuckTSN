package com.bytedance.pangle.fragment;

import androidx.collection.SimpleArrayMap;
import androidx.fragment.app.Fragment;
import com.bytedance.sdk.openadsdk.api.m;
import java.lang.reflect.Field;

/* loaded from: D:\Downloads\app\classes3.dex */
class j {
    public static void j(Class cls) {
        try {
            if (Fragment.class.getName().contains("support")) {
                ((SimpleArrayMap) j(Fragment.class, "sClassMap").get(null)).put(cls.getName(), cls);
                return;
            }
            Field j6 = j(Fragment.class, "sClassMap");
            if (j6 != null) {
                ((SimpleArrayMap) j6.get(null)).put(cls.getName(), cls);
                return;
            }
            Class j7 = j("androidx.fragment.app.FragmentFactory");
            if (j7 == null) {
                return;
            }
            Field j8 = j(j7, "sClassMap");
            if (j8 != null) {
                ((SimpleArrayMap) j8.get(null)).put(cls.getName(), cls);
                return;
            }
            Field j9 = j(j7, "sClassCacheMap");
            if (j9 != null) {
                SimpleArrayMap simpleArrayMap = (SimpleArrayMap) j9.get(null);
                SimpleArrayMap simpleArrayMap2 = new SimpleArrayMap();
                simpleArrayMap2.put(cls.getName(), cls);
                simpleArrayMap.put(cls.getClassLoader(), simpleArrayMap2);
            }
        } catch (Exception e6) {
            m.j(e6);
        }
    }

    private static Field j(Class cls, String str) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            if (declaredField != null) {
                declaredField.setAccessible(true);
            }
            return declaredField;
        } catch (NoSuchFieldException unused) {
            return null;
        }
    }

    private static Class j(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }
}
