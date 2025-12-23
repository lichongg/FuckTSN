package com.google.android.material.bottomappbar;

import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.google.android.material.shape.EdgeTreatment;
import com.google.android.material.shape.ShapePath;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class BottomAppBarTopEdgeTreatment extends EdgeTreatment implements Cloneable {
    private static final int ANGLE_LEFT = 180;
    private static final int ANGLE_UP = 270;
    private static final int ARC_HALF = 180;
    private static final int ARC_QUARTER = 90;
    private static final float ROUNDED_CORNER_FAB_OFFSET = 1.75f;
    private float cradleVerticalOffset;
    private float fabCornerSize = -1.0f;
    private float fabDiameter;
    private float fabMargin;
    private float horizontalOffset;
    private float roundedCornerRadius;

    void setCradleVerticalOffset(@FloatRange(from = 0.0d) float f6) {
        if (f6 < 0.0f) {
            throw new IllegalArgumentException("cradleVerticalOffset must be positive.");
        }
        this.cradleVerticalOffset = f6;
    }

    float getCradleVerticalOffset() {
        return this.cradleVerticalOffset;
    }

    @Override // com.google.android.material.shape.EdgeTreatment
    public void getEdgePath(float f6, float f7, float f8, @NonNull ShapePath shapePath) {
        float f9;
        float f10;
        float f11 = this.fabDiameter;
        if (f11 == 0.0f) {
            shapePath.lineTo(f6, 0.0f);
            return;
        }
        float f12 = ((this.fabMargin * 2.0f) + f11) / 2.0f;
        float f13 = f8 * this.roundedCornerRadius;
        float f14 = f7 + this.horizontalOffset;
        float f15 = (this.cradleVerticalOffset * f8) + ((1.0f - f8) * f12);
        if (f15 / f12 >= 1.0f) {
            shapePath.lineTo(f6, 0.0f);
            return;
        }
        float f16 = this.fabCornerSize;
        float f17 = f16 * f8;
        boolean z5 = f16 == -1.0f || Math.abs((f16 * 2.0f) - f11) < 0.1f;
        if (z5) {
            f9 = f15;
            f10 = 0.0f;
        } else {
            f10 = 1.75f;
            f9 = 0.0f;
        }
        float f18 = f12 + f13;
        float f19 = f9 + f13;
        float sqrt = (float) Math.sqrt((f18 * f18) - (f19 * f19));
        float f20 = f14 - sqrt;
        float f21 = f14 + sqrt;
        float degrees = (float) Math.toDegrees(Math.atan(sqrt / f19));
        float f22 = (90.0f - degrees) + f10;
        shapePath.lineTo(f20, 0.0f);
        float f23 = f20 - f13;
        float f24 = f20 + f13;
        float f25 = f13 * 2.0f;
        shapePath.addArc(f23, 0.0f, f24, f25, 270.0f, degrees);
        if (z5) {
            shapePath.addArc(f14 - f12, (-f12) - f9, f14 + f12, f12 - f9, 180.0f - f22, (f22 * 2.0f) - 180.0f);
        } else {
            float f26 = this.fabMargin;
            float f27 = f17 * 2.0f;
            float f28 = f26 + f27;
            float f29 = f14 - f12;
            shapePath.addArc(f29, -(f17 + f26), f28 + f29, f26 + f17, 180.0f - f22, ((f22 * 2.0f) - 180.0f) / 2.0f);
            float f30 = f14 + f12;
            float f31 = this.fabMargin;
            shapePath.lineTo(f30 - ((f31 / 2.0f) + f17), f31 + f17);
            float f32 = this.fabMargin;
            shapePath.addArc(f30 - (f27 + f32), -(f17 + f32), f30, f32 + f17, 90.0f, f22 - 90.0f);
        }
        shapePath.addArc(f21 - f13, 0.0f, f21 + f13, f25, 270.0f - degrees, degrees);
        shapePath.lineTo(f6, 0.0f);
    }

    public float getFabCornerRadius() {
        return this.fabCornerSize;
    }

    float getFabCradleMargin() {
        return this.fabMargin;
    }

    float getFabCradleRoundedCornerRadius() {
        return this.roundedCornerRadius;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public float getFabDiameter() {
        return this.fabDiameter;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public float getHorizontalOffset() {
        return this.horizontalOffset;
    }

    public void setFabCornerSize(float f6) {
        this.fabCornerSize = f6;
    }

    void setFabCradleMargin(float f6) {
        this.fabMargin = f6;
    }

    void setFabCradleRoundedCornerRadius(float f6) {
        this.roundedCornerRadius = f6;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setFabDiameter(float f6) {
        this.fabDiameter = f6;
    }

    void setHorizontalOffset(float f6) {
        this.horizontalOffset = f6;
    }

    public BottomAppBarTopEdgeTreatment(float f6, float f7, float f8) {
        this.fabMargin = f6;
        this.roundedCornerRadius = f7;
        setCradleVerticalOffset(f8);
        this.horizontalOffset = 0.0f;
    }
}
