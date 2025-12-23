package com.google.mlkit.acceleration.internal;

import com.google.android.gms.common.annotation.KeepForSdk;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KeepForSdk
/* loaded from: D:\Downloads\app\classes5.dex */
public abstract class MiniBenchmarkResult {

    @KeepForSdk
    public static final int STABLE = 1;

    @KeepForSdk
    public static final int UNKNOWN = 0;

    @KeepForSdk
    public static final int UNSTABLE = 2;

    @KeepForSdk
    public abstract float getCorrectnessScore();

    @KeepForSdk
    public abstract int getRunLatencyMs();

    @KeepForSdk
    public abstract int getStabilityStatus();

    public abstract boolean zza();
}
