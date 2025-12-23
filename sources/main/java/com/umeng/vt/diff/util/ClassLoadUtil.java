package com.umeng.vt.diff.util;

import android.text.TextUtils;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class ClassLoadUtil {
    public static Class<?> findClass(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }
}
