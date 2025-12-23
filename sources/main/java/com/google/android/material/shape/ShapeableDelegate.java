package com.google.android.material.shape;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.google.android.material.canvas.CanvasCompat;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: D:\Downloads\app\classes5.dex */
public abstract class ShapeableDelegate {

    @Nullable
    ShapeAppearanceModel shapeAppearanceModel;
    boolean forceCompatClippingEnabled = false;
    boolean offsetZeroCornerEdgeBoundsEnabled = false;
    RectF maskBounds = new RectF();
    final Path shapePath = new Path();

    abstract void invalidateClippingMethod(@NonNull View view);

    abstract boolean shouldUseCompatClipping();

    @NonNull
    public static ShapeableDelegate create(@NonNull View view) {
        int i6 = Build.VERSION.SDK_INT;
        return i6 >= 33 ? new ShapeableDelegateV33(view) : i6 >= 22 ? new ShapeableDelegateV22(view) : new ShapeableDelegateV14();
    }

    private void updateShapePath() {
        if (this.maskBounds.isEmpty() || this.shapeAppearanceModel == null) {
            return;
        }
        ShapeAppearancePathProvider.getInstance().calculatePath(this.shapeAppearanceModel, 1.0f, this.maskBounds, this.shapePath);
    }

    public boolean isForceCompatClippingEnabled() {
        return this.forceCompatClippingEnabled;
    }

    public void onMaskChanged(@NonNull View view, @NonNull RectF rectF) {
        this.maskBounds = rectF;
        updateShapePath();
        invalidateClippingMethod(view);
    }

    public void onShapeAppearanceChanged(@NonNull View view, @NonNull ShapeAppearanceModel shapeAppearanceModel) {
        this.shapeAppearanceModel = shapeAppearanceModel;
        updateShapePath();
        invalidateClippingMethod(view);
    }

    public void setForceCompatClippingEnabled(@NonNull View view, boolean z5) {
        if (z5 != this.forceCompatClippingEnabled) {
            this.forceCompatClippingEnabled = z5;
            invalidateClippingMethod(view);
        }
    }

    public void setOffsetZeroCornerEdgeBoundsEnabled(@NonNull View view, boolean z5) {
        this.offsetZeroCornerEdgeBoundsEnabled = z5;
        invalidateClippingMethod(view);
    }

    public void maybeClip(@NonNull Canvas canvas, @NonNull CanvasCompat.CanvasOperation canvasOperation) {
        if (shouldUseCompatClipping() && !this.shapePath.isEmpty()) {
            canvas.save();
            canvas.clipPath(this.shapePath);
            canvasOperation.run(canvas);
            canvas.restore();
            return;
        }
        canvasOperation.run(canvas);
    }
}
