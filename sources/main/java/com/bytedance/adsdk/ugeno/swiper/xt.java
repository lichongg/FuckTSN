package com.bytedance.adsdk.ugeno.swiper;

import java.util.Collection;

/* loaded from: D:\Downloads\app\classes3.dex */
public class xt {
    public static int j(boolean z5, int i6, int i7) {
        if (i7 == 0 || !z5) {
            return i6;
        }
        int i8 = i6 - 512;
        int abs = Math.abs(i8) % i7;
        return (i8 >= 0 || abs == 0) ? abs : i7 - abs;
    }

    public static boolean j(int i6, Collection<?> collection) {
        return i6 >= 0 && i6 < collection.size();
    }
}
