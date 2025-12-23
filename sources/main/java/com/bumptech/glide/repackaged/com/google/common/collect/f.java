package com.bumptech.glide.repackaged.com.google.common.collect;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
final class f {
    static void a(Object obj, Object obj2) {
        if (obj == null) {
            throw new NullPointerException("null key in entry: null=" + obj2);
        }
        if (obj2 != null) {
            return;
        }
        throw new NullPointerException("null value in entry: " + obj + "=null");
    }

    static int b(int i6, String str) {
        if (i6 >= 0) {
            return i6;
        }
        throw new IllegalArgumentException(str + " cannot be negative but was: " + i6);
    }

    static void c(boolean z5) {
        com.bumptech.glide.repackaged.com.google.common.base.d.o(z5, "no calls to next() since the last call to remove()");
    }
}
