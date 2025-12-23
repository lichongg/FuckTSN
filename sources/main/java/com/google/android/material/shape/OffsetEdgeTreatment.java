package com.google.android.material.shape;

import androidx.annotation.NonNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class OffsetEdgeTreatment extends EdgeTreatment {
    private final float offset;
    private final EdgeTreatment other;

    @Override // com.google.android.material.shape.EdgeTreatment
    boolean forceIntersection() {
        return this.other.forceIntersection();
    }

    @Override // com.google.android.material.shape.EdgeTreatment
    public void getEdgePath(float f6, float f7, float f8, @NonNull ShapePath shapePath) {
        this.other.getEdgePath(f6, f7 - this.offset, f8, shapePath);
    }

    public OffsetEdgeTreatment(@NonNull EdgeTreatment edgeTreatment, float f6) {
        this.other = edgeTreatment;
        this.offset = f6;
    }
}
