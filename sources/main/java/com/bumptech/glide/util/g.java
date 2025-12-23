package com.bumptech.glide.util;

import android.annotation.TargetApi;
import android.os.SystemClock;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    private static final double f16329a = 1.0d / Math.pow(10.0d, 6.0d);

    private g() {
    }

    public static double a(long j6) {
        return (b() - j6) * f16329a;
    }

    @TargetApi(17)
    public static long b() {
        return SystemClock.elapsedRealtimeNanos();
    }
}
