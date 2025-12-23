package com.google.gson.internal;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* renamed from: com.google.gson.internal.$Gson$Preconditions, reason: invalid class name */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class C$Gson$Preconditions {
    public static void checkArgument(boolean z5) {
        if (!z5) {
            throw new IllegalArgumentException();
        }
    }

    private C$Gson$Preconditions() {
        throw new UnsupportedOperationException();
    }

    public static <T> T checkNotNull(T t5) {
        t5.getClass();
        return t5;
    }
}
