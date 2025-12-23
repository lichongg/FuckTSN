package com.google.android.material.canvas;

import android.graphics.Canvas;
import android.graphics.RectF;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: D:\Downloads\app\classes5.dex */
public class CanvasCompat {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface CanvasOperation {
        void run(@NonNull Canvas canvas);
    }

    public static int saveLayerAlpha(@NonNull Canvas canvas, @Nullable RectF rectF, int i6) {
        return Build.VERSION.SDK_INT > 21 ? canvas.saveLayerAlpha(rectF, i6) : canvas.saveLayerAlpha(rectF, i6, 31);
    }

    private CanvasCompat() {
    }

    public static int saveLayerAlpha(@NonNull Canvas canvas, float f6, float f7, float f8, float f9, int i6) {
        if (Build.VERSION.SDK_INT > 21) {
            return canvas.saveLayerAlpha(f6, f7, f8, f9, i6);
        }
        return canvas.saveLayerAlpha(f6, f7, f8, f9, i6, 31);
    }
}
