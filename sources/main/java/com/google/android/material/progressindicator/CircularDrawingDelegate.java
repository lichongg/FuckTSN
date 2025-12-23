package com.google.android.material.progressindicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import com.google.android.material.color.MaterialColors;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class CircularDrawingDelegate extends DrawingDelegate<CircularProgressIndicatorSpec> {
    private float adjustedRadius;
    private int arcDirectionFactor;
    private float displayedCornerRadius;
    private float displayedTrackThickness;

    private int getSize() {
        S s5 = this.spec;
        return ((CircularProgressIndicatorSpec) s5).indicatorSize + (((CircularProgressIndicatorSpec) s5).indicatorInset * 2);
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    void fillIndicator(@NonNull Canvas canvas, @NonNull Paint paint, @FloatRange(from = 0.0d, to = 1.0d) float f6, @FloatRange(from = 0.0d, to = 1.0d) float f7, @ColorInt int i6) {
        if (f6 == f7) {
            return;
        }
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.BUTT);
        paint.setAntiAlias(true);
        paint.setColor(i6);
        paint.setStrokeWidth(this.displayedTrackThickness);
        int i7 = this.arcDirectionFactor;
        float f8 = f6 * 360.0f * i7;
        float f9 = (f7 >= f6 ? f7 - f6 : (1.0f + f7) - f6) * 360.0f * i7;
        float f10 = this.adjustedRadius;
        canvas.drawArc(new RectF(-f10, -f10, f10, f10), f8, f9, false, paint);
        if (this.displayedCornerRadius <= 0.0f || Math.abs(f9) >= 360.0f) {
            return;
        }
        paint.setStyle(Paint.Style.FILL);
        drawRoundedEnd(canvas, paint, this.displayedTrackThickness, this.displayedCornerRadius, f8);
        drawRoundedEnd(canvas, paint, this.displayedTrackThickness, this.displayedCornerRadius, f8 + f9);
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    void fillTrack(@NonNull Canvas canvas, @NonNull Paint paint) {
        int compositeARGBWithAlpha = MaterialColors.compositeARGBWithAlpha(((CircularProgressIndicatorSpec) this.spec).trackColor, this.drawable.getAlpha());
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.BUTT);
        paint.setAntiAlias(true);
        paint.setColor(compositeARGBWithAlpha);
        paint.setStrokeWidth(this.displayedTrackThickness);
        float f6 = this.adjustedRadius;
        canvas.drawArc(new RectF(-f6, -f6, f6, f6), 0.0f, 360.0f, false, paint);
    }

    public CircularDrawingDelegate(@NonNull CircularProgressIndicatorSpec circularProgressIndicatorSpec) {
        super(circularProgressIndicatorSpec);
        this.arcDirectionFactor = 1;
    }

    private void drawRoundedEnd(Canvas canvas, Paint paint, float f6, float f7, float f8) {
        canvas.save();
        canvas.rotate(f8);
        float f9 = this.adjustedRadius;
        float f10 = f6 / 2.0f;
        canvas.drawRoundRect(new RectF(f9 - f10, f7, f9 + f10, -f7), f7, f7, paint);
        canvas.restore();
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public void adjustCanvas(@NonNull Canvas canvas, @NonNull Rect rect, @FloatRange(from = 0.0d, to = 1.0d) float f6) {
        int i6;
        float width = rect.width() / getPreferredWidth();
        float height = rect.height() / getPreferredHeight();
        S s5 = this.spec;
        float f7 = (((CircularProgressIndicatorSpec) s5).indicatorSize / 2.0f) + ((CircularProgressIndicatorSpec) s5).indicatorInset;
        canvas.translate((f7 * width) + rect.left, (f7 * height) + rect.top);
        canvas.scale(width, height);
        canvas.rotate(-90.0f);
        float f8 = -f7;
        canvas.clipRect(f8, f8, f7, f7);
        if (((CircularProgressIndicatorSpec) this.spec).indicatorDirection == 0) {
            i6 = 1;
        } else {
            i6 = -1;
        }
        this.arcDirectionFactor = i6;
        this.displayedTrackThickness = ((CircularProgressIndicatorSpec) r8).trackThickness * f6;
        this.displayedCornerRadius = ((CircularProgressIndicatorSpec) r8).trackCornerRadius * f6;
        this.adjustedRadius = (((CircularProgressIndicatorSpec) r8).indicatorSize - ((CircularProgressIndicatorSpec) r8).trackThickness) / 2.0f;
        if ((this.drawable.isShowing() && ((CircularProgressIndicatorSpec) this.spec).showAnimationBehavior == 2) || (this.drawable.isHiding() && ((CircularProgressIndicatorSpec) this.spec).hideAnimationBehavior == 1)) {
            this.adjustedRadius += ((1.0f - f6) * ((CircularProgressIndicatorSpec) this.spec).trackThickness) / 2.0f;
        } else if ((this.drawable.isShowing() && ((CircularProgressIndicatorSpec) this.spec).showAnimationBehavior == 1) || (this.drawable.isHiding() && ((CircularProgressIndicatorSpec) this.spec).hideAnimationBehavior == 2)) {
            this.adjustedRadius -= ((1.0f - f6) * ((CircularProgressIndicatorSpec) this.spec).trackThickness) / 2.0f;
        }
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public int getPreferredHeight() {
        return getSize();
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public int getPreferredWidth() {
        return getSize();
    }
}
