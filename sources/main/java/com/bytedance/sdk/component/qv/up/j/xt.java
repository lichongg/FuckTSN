package com.bytedance.sdk.component.qv.up.j;

import com.bytedance.sdk.component.qv.up.j.j.ae;
import com.bytedance.sdk.component.qv.up.j.j.cw;
import com.bytedance.sdk.component.qv.up.j.j.m;
import com.bytedance.sdk.component.qv.up.j.j.r;
import com.bytedance.sdk.component.qv.up.j.j.tl;
import com.bytedance.sdk.component.qv.up.j.j.up;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt {

    /* renamed from: j, reason: collision with root package name */
    private static final Map<Class, j> f26747j;

    public static void j(Object obj, Field field, Object obj2) {
        Object j6;
        if (field == null || obj2 == null) {
            return;
        }
        Class<?> type = field.getType();
        try {
            j6 = type.getConstructor(null).newInstance(obj2);
        } catch (Throwable unused) {
            j6 = j(type, obj2);
        }
        try {
            field.setAccessible(true);
            field.set(obj, j6);
        } catch (Throwable unused2) {
        }
    }

    static {
        HashMap hashMap = new HashMap();
        f26747j = hashMap;
        m mVar = new m();
        tl tlVar = new tl();
        ae aeVar = new ae();
        com.bytedance.sdk.component.qv.up.j.j.xt xtVar = new com.bytedance.sdk.component.qv.up.j.j.xt();
        r rVar = new r();
        up upVar = new up();
        com.bytedance.sdk.component.qv.up.j.j.j jVar = new com.bytedance.sdk.component.qv.up.j.j.j();
        cw cwVar = new cw();
        hashMap.put(Integer.class, mVar);
        hashMap.put(Integer.TYPE, mVar);
        hashMap.put(Short.class, tlVar);
        hashMap.put(Short.TYPE, tlVar);
        hashMap.put(Long.class, aeVar);
        hashMap.put(Long.TYPE, aeVar);
        hashMap.put(Byte.class, xtVar);
        hashMap.put(Byte.TYPE, xtVar);
        hashMap.put(Double.class, rVar);
        hashMap.put(Double.TYPE, rVar);
        hashMap.put(Float.class, upVar);
        hashMap.put(Float.TYPE, upVar);
        hashMap.put(Boolean.class, jVar);
        hashMap.put(Boolean.TYPE, jVar);
        hashMap.put(Character.class, cwVar);
        hashMap.put(Character.TYPE, cwVar);
    }

    public static void j(Object obj, Map<String, Object> map, Field field, String str) {
        Object obj2;
        if (field == null || (obj2 = map.get(str)) == null) {
            return;
        }
        field.setAccessible(true);
        try {
            field.set(obj, obj2);
        } catch (Throwable unused) {
            j(obj, field, obj2);
        }
    }

    public static Object j(Class cls, Object obj) {
        String valueOf = String.valueOf(obj);
        if (String.class.equals(cls)) {
            return valueOf;
        }
        j jVar = f26747j.get(cls);
        return jVar == null ? obj : jVar.j(cls, valueOf);
    }
}
