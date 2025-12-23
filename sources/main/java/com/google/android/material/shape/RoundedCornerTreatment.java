package com.google.android.material.shape;

import androidx.annotation.NonNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class RoundedCornerTreatment extends CornerTreatment {
    float radius;

    public RoundedCornerTreatment() {
        this.radius = -1.0f;
    }

    @Override // com.google.android.material.shape.CornerTreatment
    public void getCornerPath(@NonNull ShapePath shapePath, float f6, float f7, float f8) {
        shapePath.reset(0.0f, f8 * f7, 180.0f, 180.0f - f6);
        float f9 = f8 * 2.0f * f7;
        shapePath.addArc(0.0f, 0.0f, f9, f9, 180.0f, f6);
    }

    @Deprecated
    public RoundedCornerTreatment(float f6) {
        this.radius = f6;
    }
}
