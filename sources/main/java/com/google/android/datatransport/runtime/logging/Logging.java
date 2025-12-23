package com.google.android.datatransport.runtime.logging;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public final class Logging {
    public static void d(String str, String str2) {
        getTag(str);
    }

    public static void d(String str, String str2, Object obj) {
        getTag(str);
        String.format(str2, obj);
    }

    private static String getTag(String str) {
        return "TransportRuntime." + str;
    }

    private Logging() {
    }

    public static void d(String str, String str2, Object obj, Object obj2) {
        getTag(str);
        String.format(str2, obj, obj2);
    }

    public static void e(String str, String str2, Throwable th) {
        getTag(str);
    }

    public static void i(String str, String str2) {
        getTag(str);
    }

    public static void w(String str, String str2, Object obj) {
        getTag(str);
        String.format(str2, obj);
    }

    public static void d(String str, String str2, Object... objArr) {
        getTag(str);
        String.format(str2, objArr);
    }
}
