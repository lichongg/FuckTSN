package com.google.android.material.shape;

import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.NonNull;
import com.google.android.material.internal.ViewUtils;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class MaterialShapeUtils {
    public static void setParentAbsoluteElevation(@NonNull View view) {
        Drawable background = view.getBackground();
        if (background instanceof MaterialShapeDrawable) {
            setParentAbsoluteElevation(view, (MaterialShapeDrawable) background);
        }
    }

    @NonNull
    static CornerTreatment createCornerTreatment(int i6) {
        return i6 != 0 ? i6 != 1 ? createDefaultCornerTreatment() : new CutCornerTreatment() : new RoundedCornerTreatment();
    }

    @NonNull
    static CornerTreatment createDefaultCornerTreatment() {
        return new RoundedCornerTreatment();
    }

    @NonNull
    static EdgeTreatment createDefaultEdgeTreatment() {
        return new EdgeTreatment();
    }

    private MaterialShapeUtils() {
    }

    public static void setElevation(@NonNull View view, float f6) {
        Drawable background = view.getBackground();
        if (background instanceof MaterialShapeDrawable) {
            ((MaterialShapeDrawable) background).setElevation(f6);
        }
    }

    public static void setParentAbsoluteElevation(@NonNull View view, @NonNull MaterialShapeDrawable materialShapeDrawable) {
        if (materialShapeDrawable.isElevationOverlayEnabled()) {
            materialShapeDrawable.setParentAbsoluteElevation(ViewUtils.getParentAbsoluteElevation(view));
        }
    }
}
