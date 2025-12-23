package com.google.android.material.shape;

import android.graphics.RectF;
import androidx.annotation.NonNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class CornerTreatment {
    @Deprecated
    public void getCornerPath(float f6, float f7, @NonNull ShapePath shapePath) {
    }

    public void getCornerPath(@NonNull ShapePath shapePath, float f6, float f7, float f8) {
        getCornerPath(f6, f7, shapePath);
    }

    public void getCornerPath(@NonNull ShapePath shapePath, float f6, float f7, @NonNull RectF rectF, @NonNull CornerSize cornerSize) {
        getCornerPath(shapePath, f6, f7, cornerSize.getCornerSize(rectF));
    }
}
