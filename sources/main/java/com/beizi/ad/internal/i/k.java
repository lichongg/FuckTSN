package com.beizi.ad.internal.i;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class k {
    public static <T> T a(T t5) {
        t5.getClass();
        return t5;
    }

    public static void a(Object... objArr) {
        for (Object obj : objArr) {
            obj.getClass();
        }
    }

    public static <T> T a(T t5, String str) {
        if (t5 != null) {
            return t5;
        }
        throw new NullPointerException(str);
    }

    static void a(boolean z5) {
        if (!z5) {
            throw new IllegalArgumentException();
        }
    }

    static void a(boolean z5, String str) {
        if (!z5) {
            throw new IllegalArgumentException(str);
        }
    }
}
