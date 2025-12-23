package com.google.android.material.shadow;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.appcompat.graphics.drawable.DrawableWrapperCompat;
import androidx.core.content.ContextCompat;
import com.google.android.material.R;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Deprecated
/* loaded from: D:\Downloads\app\classes5.dex */
public class ShadowDrawableWrapper extends DrawableWrapperCompat {
    static final double COS_45 = Math.cos(Math.toRadians(45.0d));
    static final float SHADOW_BOTTOM_SCALE = 1.0f;
    static final float SHADOW_HORIZ_SCALE = 0.5f;
    static final float SHADOW_MULTIPLIER = 1.5f;
    static final float SHADOW_TOP_SCALE = 0.25f;
    private boolean addPaddingForCorners;

    @NonNull
    final RectF contentBounds;
    float cornerRadius;

    @NonNull
    final Paint cornerShadowPaint;
    Path cornerShadowPath;
    private boolean dirty;

    @NonNull
    final Paint edgeShadowPaint;
    float maxShadowSize;
    private boolean printedShadowClipWarning;
    float rawMaxShadowSize;
    float rawShadowSize;
    private float rotation;
    private final int shadowEndColor;
    private final int shadowMiddleColor;
    float shadowSize;
    private final int shadowStartColor;

    @Override // androidx.appcompat.graphics.drawable.DrawableWrapperCompat, android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableWrapperCompat, android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        this.dirty = true;
    }

    public void setShadowSize(float f6, float f7) {
        if (f6 < 0.0f || f7 < 0.0f) {
            throw new IllegalArgumentException("invalid shadow size");
        }
        float even = toEven(f6);
        float even2 = toEven(f7);
        if (even > even2) {
            if (!this.printedShadowClipWarning) {
                this.printedShadowClipWarning = true;
            }
            even = even2;
        }
        if (this.rawShadowSize == even && this.rawMaxShadowSize == even2) {
            return;
        }
        this.rawShadowSize = even;
        this.rawMaxShadowSize = even2;
        this.shadowSize = Math.round(even * 1.5f);
        this.maxShadowSize = even2;
        this.dirty = true;
        invalidateSelf();
    }

    private void buildComponents(@NonNull Rect rect) {
        float f6 = this.rawMaxShadowSize;
        float f7 = 1.5f * f6;
        this.contentBounds.set(rect.left + f6, rect.top + f7, rect.right - f6, rect.bottom - f7);
        Drawable drawable = getDrawable();
        RectF rectF = this.contentBounds;
        drawable.setBounds((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
        buildShadowCorners();
    }

    private void buildShadowCorners() {
        float f6 = this.cornerRadius;
        RectF rectF = new RectF(-f6, -f6, f6, f6);
        RectF rectF2 = new RectF(rectF);
        float f7 = this.shadowSize;
        rectF2.inset(-f7, -f7);
        Path path = this.cornerShadowPath;
        if (path == null) {
            this.cornerShadowPath = new Path();
        } else {
            path.reset();
        }
        this.cornerShadowPath.setFillType(Path.FillType.EVEN_ODD);
        this.cornerShadowPath.moveTo(-this.cornerRadius, 0.0f);
        this.cornerShadowPath.rLineTo(-this.shadowSize, 0.0f);
        this.cornerShadowPath.arcTo(rectF2, 180.0f, 90.0f, false);
        this.cornerShadowPath.arcTo(rectF, 270.0f, -90.0f, false);
        this.cornerShadowPath.close();
        float f8 = -rectF2.top;
        if (f8 > 0.0f) {
            float f9 = this.cornerRadius / f8;
            this.cornerShadowPaint.setShader(new RadialGradient(0.0f, 0.0f, f8, new int[]{0, this.shadowStartColor, this.shadowMiddleColor, this.shadowEndColor}, new float[]{0.0f, f9, ((1.0f - f9) / 2.0f) + f9, 1.0f}, Shader.TileMode.CLAMP));
        }
        this.edgeShadowPaint.setShader(new LinearGradient(0.0f, rectF.top, 0.0f, rectF2.top, new int[]{this.shadowStartColor, this.shadowMiddleColor, this.shadowEndColor}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP));
        this.edgeShadowPaint.setAntiAlias(false);
    }

    public static float calculateHorizontalPadding(float f6, float f7, boolean z5) {
        return z5 ? (float) (f6 + ((1.0d - COS_45) * f7)) : f6;
    }

    public static float calculateVerticalPadding(float f6, float f7, boolean z5) {
        return z5 ? (float) ((f6 * 1.5f) + ((1.0d - COS_45) * f7)) : f6 * 1.5f;
    }

    private void drawShadow(@NonNull Canvas canvas) {
        int i6;
        float f6;
        int save = canvas.save();
        canvas.rotate(this.rotation, this.contentBounds.centerX(), this.contentBounds.centerY());
        float f7 = this.cornerRadius;
        float f8 = (-f7) - this.shadowSize;
        float f9 = f7 * 2.0f;
        boolean z5 = this.contentBounds.width() - f9 > 0.0f;
        boolean z6 = this.contentBounds.height() - f9 > 0.0f;
        float f10 = this.rawShadowSize;
        float f11 = f7 / ((f10 - (0.5f * f10)) + f7);
        float f12 = f7 / ((f10 - (0.25f * f10)) + f7);
        float f13 = f7 / ((f10 - (f10 * 1.0f)) + f7);
        int save2 = canvas.save();
        RectF rectF = this.contentBounds;
        canvas.translate(rectF.left + f7, rectF.top + f7);
        canvas.scale(f11, f12);
        canvas.drawPath(this.cornerShadowPath, this.cornerShadowPaint);
        if (z5) {
            canvas.scale(1.0f / f11, 1.0f);
            i6 = save2;
            f6 = 1.0f;
            canvas.drawRect(0.0f, f8, this.contentBounds.width() - f9, -this.cornerRadius, this.edgeShadowPaint);
        } else {
            i6 = save2;
            f6 = 1.0f;
        }
        canvas.restoreToCount(i6);
        int save3 = canvas.save();
        RectF rectF2 = this.contentBounds;
        canvas.translate(rectF2.right - f7, rectF2.bottom - f7);
        canvas.scale(f11, f13);
        canvas.rotate(180.0f);
        canvas.drawPath(this.cornerShadowPath, this.cornerShadowPaint);
        if (z5) {
            canvas.scale(f6 / f11, 1.0f);
            canvas.drawRect(0.0f, f8, this.contentBounds.width() - f9, this.shadowSize + (-this.cornerRadius), this.edgeShadowPaint);
        }
        canvas.restoreToCount(save3);
        int save4 = canvas.save();
        RectF rectF3 = this.contentBounds;
        canvas.translate(rectF3.left + f7, rectF3.bottom - f7);
        canvas.scale(f11, f13);
        canvas.rotate(270.0f);
        canvas.drawPath(this.cornerShadowPath, this.cornerShadowPaint);
        if (z6) {
            canvas.scale(1.0f / f13, 1.0f);
            canvas.drawRect(0.0f, f8, this.contentBounds.height() - f9, -this.cornerRadius, this.edgeShadowPaint);
        }
        canvas.restoreToCount(save4);
        int save5 = canvas.save();
        RectF rectF4 = this.contentBounds;
        canvas.translate(rectF4.right - f7, rectF4.top + f7);
        canvas.scale(f11, f12);
        canvas.rotate(90.0f);
        canvas.drawPath(this.cornerShadowPath, this.cornerShadowPaint);
        if (z6) {
            canvas.scale(1.0f / f12, 1.0f);
            canvas.drawRect(0.0f, f8, this.contentBounds.height() - f9, -this.cornerRadius, this.edgeShadowPaint);
        }
        canvas.restoreToCount(save5);
        canvas.restoreToCount(save);
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableWrapperCompat, android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        if (this.dirty) {
            buildComponents(getBounds());
            this.dirty = false;
        }
        drawShadow(canvas);
        super.draw(canvas);
    }

    public float getCornerRadius() {
        return this.cornerRadius;
    }

    public float getMaxShadowSize() {
        return this.rawMaxShadowSize;
    }

    public float getMinHeight() {
        float f6 = this.rawMaxShadowSize;
        return (Math.max(f6, this.cornerRadius + ((f6 * 1.5f) / 2.0f)) * 2.0f) + (this.rawMaxShadowSize * 1.5f * 2.0f);
    }

    public float getMinWidth() {
        float f6 = this.rawMaxShadowSize;
        return (Math.max(f6, this.cornerRadius + (f6 / 2.0f)) * 2.0f) + (this.rawMaxShadowSize * 2.0f);
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableWrapperCompat, android.graphics.drawable.Drawable
    public boolean getPadding(@NonNull Rect rect) {
        int ceil = (int) Math.ceil(calculateVerticalPadding(this.rawMaxShadowSize, this.cornerRadius, this.addPaddingForCorners));
        int ceil2 = (int) Math.ceil(calculateHorizontalPadding(this.rawMaxShadowSize, this.cornerRadius, this.addPaddingForCorners));
        rect.set(ceil2, ceil, ceil2, ceil);
        return true;
    }

    public float getShadowSize() {
        return this.rawShadowSize;
    }

    public void setAddPaddingForCorners(boolean z5) {
        this.addPaddingForCorners = z5;
        invalidateSelf();
    }

    public void setMaxShadowSize(float f6) {
        setShadowSize(this.rawShadowSize, f6);
    }

    public final void setRotation(float f6) {
        if (this.rotation != f6) {
            this.rotation = f6;
            invalidateSelf();
        }
    }

    public ShadowDrawableWrapper(Context context, Drawable drawable, float f6, float f7, float f8) {
        super(drawable);
        this.dirty = true;
        this.addPaddingForCorners = true;
        this.printedShadowClipWarning = false;
        this.shadowStartColor = ContextCompat.getColor(context, R.color.design_fab_shadow_start_color);
        this.shadowMiddleColor = ContextCompat.getColor(context, R.color.design_fab_shadow_mid_color);
        this.shadowEndColor = ContextCompat.getColor(context, R.color.design_fab_shadow_end_color);
        Paint paint = new Paint(5);
        this.cornerShadowPaint = paint;
        paint.setStyle(Paint.Style.FILL);
        this.cornerRadius = Math.round(f6);
        this.contentBounds = new RectF();
        Paint paint2 = new Paint(paint);
        this.edgeShadowPaint = paint2;
        paint2.setAntiAlias(false);
        setShadowSize(f7, f8);
    }

    private static int toEven(float f6) {
        int round = Math.round(f6);
        if (round % 2 == 1) {
            return round - 1;
        }
        return round;
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableWrapperCompat, android.graphics.drawable.Drawable
    public void setAlpha(int i6) {
        super.setAlpha(i6);
        this.cornerShadowPaint.setAlpha(i6);
        this.edgeShadowPaint.setAlpha(i6);
    }

    public void setCornerRadius(float f6) {
        float round = Math.round(f6);
        if (this.cornerRadius == round) {
            return;
        }
        this.cornerRadius = round;
        this.dirty = true;
        invalidateSelf();
    }

    public void setShadowSize(float f6) {
        setShadowSize(f6, this.rawMaxShadowSize);
    }
}
