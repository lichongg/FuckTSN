package com.kwad.framework.filedownloader.f;

import android.util.Log;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class d {
    public static boolean apD;

    public static void a(Object obj, Throwable th, String str, Object... objArr) {
        a(6, obj, th, str, objArr);
    }

    public static void b(Object obj, String str, Object... objArr) {
        a(4, obj, str, objArr);
    }

    public static void c(Object obj, String str, Object... objArr) {
        a(3, obj, str, objArr);
    }

    public static void d(Object obj, String str, Object... objArr) {
        a(5, obj, str, objArr);
    }

    public static void e(Object obj, String str, Object... objArr) {
        a(2, obj, str, objArr);
    }

    public static void a(Object obj, String str, Object... objArr) {
        a(6, obj, str, objArr);
    }

    private static String g(Object obj) {
        StringBuilder sb = new StringBuilder("FileDownloader.");
        sb.append((obj instanceof Class ? (Class) obj : obj.getClass()).getSimpleName());
        return sb.toString();
    }

    private static void a(int i6, Object obj, String str, Object... objArr) {
        a(i6, obj, null, str, objArr);
    }

    private static void a(int i6, Object obj, Throwable th, String str, Object... objArr) {
        if (i6 < 5 && !apD) {
            return;
        }
        Log.println(i6, g(obj), f.c(str, objArr));
        if (th != null) {
            th.printStackTrace();
        }
    }
}
