package com.umeng.analytics.pro;

import java.lang.reflect.InvocationTargetException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class bw {
    public static bv a(Class<? extends bv> cls, int i6) {
        try {
            return (bv) cls.getMethod("findByValue", Integer.TYPE).invoke(null, Integer.valueOf(i6));
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return null;
        }
    }
}
