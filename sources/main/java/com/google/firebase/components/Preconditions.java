package com.google.firebase.components;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class Preconditions {
    public static <T> T checkNotNull(T t5) {
        t5.getClass();
        return t5;
    }

    public static void checkArgument(boolean z5, String str) {
        if (!z5) {
            throw new IllegalArgumentException(str);
        }
    }

    public static <T> T checkNotNull(T t5, String str) {
        if (t5 != null) {
            return t5;
        }
        throw new NullPointerException(str);
    }

    public static void checkState(boolean z5, String str) {
        if (!z5) {
            throw new IllegalStateException(str);
        }
    }
}
