package com.google.android.material.progressindicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import com.google.android.material.color.MaterialColors;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class LinearDrawingDelegate extends DrawingDelegate<LinearProgressIndicatorSpec> {
    private float displayedCornerRadius;
    private Path displayedTrackPath;
    private float displayedTrackThickness;
    private float trackLength;

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public int getPreferredWidth() {
        return -1;
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public void fillIndicator(@NonNull Canvas canvas, @NonNull Paint paint, @FloatRange(from = 0.0d, to = 1.0d) float f6, @FloatRange(from = 0.0d, to = 1.0d) float f7, @ColorInt int i6) {
        if (f6 == f7) {
            return;
        }
        float f8 = this.trackLength;
        float f9 = (-f8) / 2.0f;
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        paint.setColor(i6);
        canvas.save();
        canvas.clipPath(this.displayedTrackPath);
        float f10 = this.displayedTrackThickness;
        RectF rectF = new RectF(((f6 * f8) + f9) - (this.displayedCornerRadius * 2.0f), (-f10) / 2.0f, f9 + (f7 * f8), f10 / 2.0f);
        float f11 = this.displayedCornerRadius;
        canvas.drawRoundRect(rectF, f11, f11, paint);
        canvas.restore();
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    void fillTrack(@NonNull Canvas canvas, @NonNull Paint paint) {
        int compositeARGBWithAlpha = MaterialColors.compositeARGBWithAlpha(((LinearProgressIndicatorSpec) this.spec).trackColor, this.drawable.getAlpha());
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        paint.setColor(compositeARGBWithAlpha);
        Path path = new Path();
        this.displayedTrackPath = path;
        float f6 = this.trackLength;
        float f7 = this.displayedTrackThickness;
        RectF rectF = new RectF((-f6) / 2.0f, (-f7) / 2.0f, f6 / 2.0f, f7 / 2.0f);
        float f8 = this.displayedCornerRadius;
        path.addRoundRect(rectF, f8, f8, Path.Direction.CCW);
        canvas.drawPath(this.displayedTrackPath, paint);
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public int getPreferredHeight() {
        return ((LinearProgressIndicatorSpec) this.spec).trackThickness;
    }

    public LinearDrawingDelegate(@NonNull LinearProgressIndicatorSpec linearProgressIndicatorSpec) {
        super(linearProgressIndicatorSpec);
        this.trackLength = 300.0f;
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public void adjustCanvas(@NonNull Canvas canvas, @NonNull Rect rect, @FloatRange(from = 0.0d, to = 1.0d) float f6) {
        this.trackLength = rect.width();
        float f7 = ((LinearProgressIndicatorSpec) this.spec).trackThickness;
        canvas.translate(rect.left + (rect.width() / 2.0f), rect.top + (rect.height() / 2.0f) + Math.max(0.0f, (rect.height() - ((LinearProgressIndicatorSpec) this.spec).trackThickness) / 2.0f));
        if (((LinearProgressIndicatorSpec) this.spec).drawHorizontallyInverse) {
            canvas.scale(-1.0f, 1.0f);
        }
        if ((this.drawable.isShowing() && ((LinearProgressIndicatorSpec) this.spec).showAnimationBehavior == 1) || (this.drawable.isHiding() && ((LinearProgressIndicatorSpec) this.spec).hideAnimationBehavior == 2)) {
            canvas.scale(1.0f, -1.0f);
        }
        if (this.drawable.isShowing() || this.drawable.isHiding()) {
            canvas.translate(0.0f, (((LinearProgressIndicatorSpec) this.spec).trackThickness * (f6 - 1.0f)) / 2.0f);
        }
        float f8 = this.trackLength;
        canvas.clipRect((-f8) / 2.0f, (-f7) / 2.0f, f8 / 2.0f, f7 / 2.0f);
        S s5 = this.spec;
        this.displayedTrackThickness = ((LinearProgressIndicatorSpec) s5).trackThickness * f6;
        this.displayedCornerRadius = ((LinearProgressIndicatorSpec) s5).trackCornerRadius * f6;
    }
}
