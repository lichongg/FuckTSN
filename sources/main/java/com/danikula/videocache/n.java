package com.danikula.videocache;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public final class n {
    public static void a(Object... objArr) {
        for (Object obj : objArr) {
            obj.getClass();
        }
    }

    static void b(boolean z5) {
        if (!z5) {
            throw new IllegalArgumentException();
        }
    }

    static void c(boolean z5, String str) {
        if (!z5) {
            throw new IllegalArgumentException(str);
        }
    }

    public static <T> T e(T t5, String str) {
        if (t5 != null) {
            return t5;
        }
        throw new NullPointerException(str);
    }

    public static <T> T d(T t5) {
        t5.getClass();
        return t5;
    }
}
