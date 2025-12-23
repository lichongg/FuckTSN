package com.bytedance.sdk.component.qv.m;

import android.text.TextUtils;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j extends xt {
    public static j j() {
        if (xt.f26745j != null) {
            return xt.f26745j;
        }
        synchronized (j.class) {
            try {
                if (xt.f26745j != null) {
                    return xt.f26745j;
                }
                j jVar = new j();
                xt.f26745j = jVar;
                return jVar;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private j() {
    }

    public com.bytedance.sdk.component.qv.j.j.j j(com.bytedance.sdk.component.qv.j.j.j jVar) {
        try {
            Class<?> cls = jVar.getClass();
            if (cls.isAnnotationPresent(com.bytedance.sdk.component.qv.xt.xt.class) && !"SINGLETON".equals(((com.bytedance.sdk.component.qv.xt.xt) cls.getAnnotation(com.bytedance.sdk.component.qv.xt.xt.class)).j())) {
                return (com.bytedance.sdk.component.qv.j.j.j) cls.newInstance();
            }
            return jVar;
        } catch (Throwable unused) {
            return jVar;
        }
    }

    public void j(Object obj, Map<String, Object> map) {
        if (obj == null) {
            return;
        }
        Class<?> cls = obj.getClass();
        if (cls.isAnnotationPresent(com.bytedance.sdk.component.qv.xt.xt.class)) {
            j(obj, map, cls);
        }
    }

    private static void j(Object obj, Map<String, Object> map, Class<?> cls) {
        com.bytedance.sdk.component.qv.xt.j jVar;
        for (Field field : j(cls)) {
            if (field != null && field.isAnnotationPresent(com.bytedance.sdk.component.qv.xt.j.class) && (jVar = (com.bytedance.sdk.component.qv.xt.j) field.getAnnotation(com.bytedance.sdk.component.qv.xt.j.class)) != null) {
                field.setAccessible(true);
                String j6 = jVar.j();
                if (TextUtils.isEmpty(j6)) {
                    j6 = com.bytedance.sdk.component.qv.tl.j.j(field.getName(), true);
                }
                if (!TextUtils.isEmpty(j6)) {
                    com.bytedance.sdk.component.qv.up.j.xt.j(obj, map, field, j6);
                }
            }
        }
    }

    public static Field[] j(Class<?> cls) {
        ArrayList arrayList = new ArrayList();
        while (cls != null && cls != Object.class) {
            arrayList.addAll(new ArrayList(Arrays.asList(cls.getDeclaredFields())));
            cls = cls.getSuperclass();
        }
        return (Field[]) arrayList.toArray(new Field[arrayList.size()]);
    }
}
