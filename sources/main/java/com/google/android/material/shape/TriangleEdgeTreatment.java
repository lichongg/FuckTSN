package com.google.android.material.shape;

import androidx.annotation.NonNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class TriangleEdgeTreatment extends EdgeTreatment {
    private final boolean inside;
    private final float size;

    @Override // com.google.android.material.shape.EdgeTreatment
    public void getEdgePath(float f6, float f7, float f8, @NonNull ShapePath shapePath) {
        if (!this.inside) {
            float f9 = this.size;
            shapePath.lineTo(f7 - (f9 * f8), 0.0f, f7, (-f9) * f8);
            shapePath.lineTo(f7 + (this.size * f8), 0.0f, f6, 0.0f);
        } else {
            shapePath.lineTo(f7 - (this.size * f8), 0.0f);
            float f10 = this.size;
            shapePath.lineTo(f7, f10 * f8, (f10 * f8) + f7, 0.0f);
            shapePath.lineTo(f6, 0.0f);
        }
    }

    public TriangleEdgeTreatment(float f6, boolean z5) {
        this.size = f6;
        this.inside = z5;
    }
}
