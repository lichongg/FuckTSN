package com.snail.antifake.jni;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class PropertiesGet {
    private static native String native_get(String str);

    private static native String native_get(String str, String str2);

    static {
        System.loadLibrary("property_get");
    }

    public static String a(String str) {
        return native_get(str);
    }

    public static String b(String str, String str2) {
        return native_get(str, str2);
    }
}
