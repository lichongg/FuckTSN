package com.google.mlkit.vision.common;

import androidx.annotation.NonNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public abstract class PointF3D {
    public abstract float getX();

    public abstract float getY();

    public abstract float getZ();

    @NonNull
    public static PointF3D from(float f6, float f7, float f8) {
        return new zza(f6, f7, f8);
    }
}
