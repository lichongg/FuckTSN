package com.google.android.material.shape;

import android.graphics.RectF;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import java.util.Arrays;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: D:\Downloads\app\classes5.dex */
public final class ClampedCornerSize implements CornerSize {
    private final float target;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ClampedCornerSize) && this.target == ((ClampedCornerSize) obj).target;
    }

    @NonNull
    public static ClampedCornerSize createFromCornerSize(@NonNull AbsoluteCornerSize absoluteCornerSize) {
        return new ClampedCornerSize(absoluteCornerSize.getCornerSize());
    }

    @Override // com.google.android.material.shape.CornerSize
    public float getCornerSize(@NonNull RectF rectF) {
        return Math.min(this.target, getMaxCornerSize(rectF));
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.target)});
    }

    public ClampedCornerSize(float f6) {
        this.target = f6;
    }

    private static float getMaxCornerSize(@NonNull RectF rectF) {
        return Math.min(rectF.width() / 2.0f, rectF.height() / 2.0f);
    }
}
