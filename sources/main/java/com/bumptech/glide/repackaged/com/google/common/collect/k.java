package com.bumptech.glide.repackaged.com.google.common.collect;

import androidx.collection.ScatterMapKt;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
final class k {

    /* renamed from: a, reason: collision with root package name */
    private static int f15919a = 1073741824;

    static int a(int i6, double d6) {
        int max = Math.max(i6, 2);
        int highestOneBit = Integer.highestOneBit(max);
        if (max <= ((int) (d6 * highestOneBit))) {
            return highestOneBit;
        }
        int i7 = highestOneBit << 1;
        return i7 > 0 ? i7 : f15919a;
    }

    static int c(Object obj) {
        return b(obj == null ? 0 : obj.hashCode());
    }

    static int b(int i6) {
        return Integer.rotateLeft(i6 * ScatterMapKt.MurmurHashC1, 15) * 461845907;
    }
}
