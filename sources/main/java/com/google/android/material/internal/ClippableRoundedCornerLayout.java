package com.google.android.material.internal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: D:\Downloads\app\classes5.dex */
public class ClippableRoundedCornerLayout extends FrameLayout {
    private float cornerRadius;

    @Nullable
    private Path path;

    public ClippableRoundedCornerLayout(@NonNull Context context) {
        super(context);
    }

    public void resetClipBoundsAndCornerRadius() {
        this.path = null;
        this.cornerRadius = 0.0f;
        invalidate();
    }

    public void updateClipBoundsAndCornerRadius(@NonNull Rect rect, float f6) {
        updateClipBoundsAndCornerRadius(rect.left, rect.top, rect.right, rect.bottom, f6);
    }

    public ClippableRoundedCornerLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.path == null) {
            super.dispatchDraw(canvas);
            return;
        }
        int save = canvas.save();
        canvas.clipPath(this.path);
        super.dispatchDraw(canvas);
        canvas.restoreToCount(save);
    }

    public float getCornerRadius() {
        return this.cornerRadius;
    }

    public void updateClipBoundsAndCornerRadius(float f6, float f7, float f8, float f9, float f10) {
        updateClipBoundsAndCornerRadius(new RectF(f6, f7, f8, f9), f10);
    }

    public ClippableRoundedCornerLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
    }

    public void updateClipBoundsAndCornerRadius(@NonNull RectF rectF, float f6) {
        if (this.path == null) {
            this.path = new Path();
        }
        this.cornerRadius = f6;
        this.path.reset();
        this.path.addRoundRect(rectF, f6, f6, Path.Direction.CW);
        this.path.close();
        invalidate();
    }

    public void updateCornerRadius(float f6) {
        updateClipBoundsAndCornerRadius(getLeft(), getTop(), getRight(), getBottom(), f6);
    }
}
