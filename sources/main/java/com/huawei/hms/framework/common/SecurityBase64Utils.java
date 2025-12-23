package com.huawei.hms.framework.common;

import android.util.Base64;
import com.huawei.secure.android.common.util.SafeBase64;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class SecurityBase64Utils {

    /* renamed from: a, reason: collision with root package name */
    private static final String f33348a = "com.huawei.secure.android.common.util.SafeBase64";

    /* renamed from: b, reason: collision with root package name */
    private static volatile boolean f33349b;

    private static boolean a(String str) {
        ClassLoader classLoader = SecurityBase64Utils.class.getClassLoader();
        if (classLoader == null) {
            return false;
        }
        try {
            classLoader.loadClass(str);
            synchronized (SecurityBase64Utils.class) {
                f33349b = true;
            }
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static byte[] decode(String str, int i6) {
        if (f33349b || a(f33348a)) {
            return SafeBase64.decode(str, i6);
        }
        try {
            return Base64.decode(str, i6);
        } catch (Exception unused) {
            return new byte[0];
        }
    }

    public static String encodeToString(byte[] bArr, int i6) {
        if (f33349b || a(f33348a)) {
            return SafeBase64.encodeToString(bArr, i6);
        }
        try {
            return Base64.encodeToString(bArr, i6);
        } catch (Exception unused) {
            return null;
        }
    }
}
