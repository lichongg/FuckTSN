package com.google.android.material.shape;

import android.graphics.RectF;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import java.util.Arrays;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: D:\Downloads\app\classes5.dex */
public final class AdjustedCornerSize implements CornerSize {
    private final float adjustment;
    private final CornerSize other;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdjustedCornerSize)) {
            return false;
        }
        AdjustedCornerSize adjustedCornerSize = (AdjustedCornerSize) obj;
        return this.other.equals(adjustedCornerSize.other) && this.adjustment == adjustedCornerSize.adjustment;
    }

    @Override // com.google.android.material.shape.CornerSize
    public float getCornerSize(@NonNull RectF rectF) {
        return Math.max(0.0f, this.other.getCornerSize(rectF) + this.adjustment);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.other, Float.valueOf(this.adjustment)});
    }

    public AdjustedCornerSize(float f6, @NonNull CornerSize cornerSize) {
        while (cornerSize instanceof AdjustedCornerSize) {
            cornerSize = ((AdjustedCornerSize) cornerSize).other;
            f6 += ((AdjustedCornerSize) cornerSize).adjustment;
        }
        this.other = cornerSize;
        this.adjustment = f6;
    }
}
