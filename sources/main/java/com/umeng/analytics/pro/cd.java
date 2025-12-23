package com.umeng.analytics.pro;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class cd implements Serializable {

    /* renamed from: d, reason: collision with root package name */
    private static Map<Class<? extends br>, Map<? extends by, cd>> f41079d = new HashMap();

    /* renamed from: a, reason: collision with root package name */
    public final String f41080a;

    /* renamed from: b, reason: collision with root package name */
    public final byte f41081b;

    /* renamed from: c, reason: collision with root package name */
    public final ce f41082c;

    public static void a(Class<? extends br> cls, Map<? extends by, cd> map) {
        f41079d.put(cls, map);
    }

    public static Map<? extends by, cd> a(Class<? extends br> cls) {
        if (!f41079d.containsKey(cls)) {
            try {
                cls.newInstance();
            } catch (IllegalAccessException e6) {
                throw new RuntimeException("IllegalAccessException for TBase class: " + cls.getName() + ", message: " + e6.getMessage());
            } catch (InstantiationException e7) {
                throw new RuntimeException("InstantiationException for TBase class: " + cls.getName() + ", message: " + e7.getMessage());
            }
        }
        return f41079d.get(cls);
    }

    public cd(String str, byte b6, ce ceVar) {
        this.f41080a = str;
        this.f41081b = b6;
        this.f41082c = ceVar;
    }
}
