package com.bumptech.glide.repackaged.com.google.common.collect;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class a0 {

    /* renamed from: a, reason: collision with root package name */
    static final Object[] f15878a = new Object[0];

    static Object[] c(Object... objArr) {
        return d(objArr, objArr.length);
    }

    static Object[] d(Object[] objArr, int i6) {
        for (int i7 = 0; i7 < i6; i7++) {
            b(objArr[i7], i7);
        }
        return objArr;
    }

    static Object b(Object obj, int i6) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException("at index " + i6);
    }

    static <T> T[] a(T[] tArr, int i6) {
        T[] tArr2 = (T[]) e(tArr, i6);
        System.arraycopy(tArr, 0, tArr2, 0, Math.min(tArr.length, i6));
        return tArr2;
    }

    public static <T> T[] e(T[] tArr, int i6) {
        return (T[]) d0.a(tArr, i6);
    }
}
