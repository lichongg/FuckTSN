package com.google.android.material.shape;

import androidx.annotation.NonNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class EdgeTreatment {
    boolean forceIntersection() {
        return false;
    }

    @Deprecated
    public void getEdgePath(float f6, float f7, @NonNull ShapePath shapePath) {
        getEdgePath(f6, f6 / 2.0f, f7, shapePath);
    }

    public void getEdgePath(float f6, float f7, float f8, @NonNull ShapePath shapePath) {
        shapePath.lineTo(f6, 0.0f);
    }
}
