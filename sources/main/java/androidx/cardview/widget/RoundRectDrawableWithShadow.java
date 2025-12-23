package androidx.cardview.widget;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import androidx.annotation.Nullable;
import androidx.cardview.R;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
class RoundRectDrawableWithShadow extends Drawable {
    private static final double COS_45 = Math.cos(Math.toRadians(45.0d));
    private static final float SHADOW_MULTIPLIER = 1.5f;
    static RoundRectHelper sRoundRectHelper;
    private ColorStateList mBackground;
    private final RectF mCardBounds;
    private float mCornerRadius;
    private Paint mCornerShadowPaint;
    private Path mCornerShadowPath;
    private Paint mEdgeShadowPaint;
    private final int mInsetShadow;
    private float mRawMaxShadowSize;
    private float mRawShadowSize;
    private final int mShadowEndColor;
    private float mShadowSize;
    private final int mShadowStartColor;
    private boolean mDirty = true;
    private boolean mAddPaddingForCorners = true;
    private boolean mPrintedShadowClipWarning = false;
    private Paint mPaint = new Paint(5);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    interface RoundRectHelper {
        void drawRoundRect(Canvas canvas, RectF rectF, float f6, Paint paint);
    }

    private void setShadowSize(float f6, float f7) {
        if (f6 < 0.0f) {
            throw new IllegalArgumentException("Invalid shadow size " + f6 + ". Must be >= 0");
        }
        if (f7 < 0.0f) {
            throw new IllegalArgumentException("Invalid max shadow size " + f7 + ". Must be >= 0");
        }
        float even = toEven(f6);
        float even2 = toEven(f7);
        if (even > even2) {
            if (!this.mPrintedShadowClipWarning) {
                this.mPrintedShadowClipWarning = true;
            }
            even = even2;
        }
        if (this.mRawShadowSize == even && this.mRawMaxShadowSize == even2) {
            return;
        }
        this.mRawShadowSize = even;
        this.mRawMaxShadowSize = even2;
        this.mShadowSize = (int) ((even * 1.5f) + this.mInsetShadow + 0.5f);
        this.mDirty = true;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    void setCornerRadius(float f6) {
        if (f6 < 0.0f) {
            throw new IllegalArgumentException("Invalid radius " + f6 + ". Must be >= 0");
        }
        float f7 = (int) (f6 + 0.5f);
        if (this.mCornerRadius == f7) {
            return;
        }
        this.mCornerRadius = f7;
        this.mDirty = true;
        invalidateSelf();
    }

    private void buildComponents(Rect rect) {
        float f6 = this.mRawMaxShadowSize;
        float f7 = 1.5f * f6;
        this.mCardBounds.set(rect.left + f6, rect.top + f7, rect.right - f6, rect.bottom - f7);
        buildShadowCorners();
    }

    private void buildShadowCorners() {
        float f6 = this.mCornerRadius;
        RectF rectF = new RectF(-f6, -f6, f6, f6);
        RectF rectF2 = new RectF(rectF);
        float f7 = this.mShadowSize;
        rectF2.inset(-f7, -f7);
        Path path = this.mCornerShadowPath;
        if (path == null) {
            this.mCornerShadowPath = new Path();
        } else {
            path.reset();
        }
        this.mCornerShadowPath.setFillType(Path.FillType.EVEN_ODD);
        this.mCornerShadowPath.moveTo(-this.mCornerRadius, 0.0f);
        this.mCornerShadowPath.rLineTo(-this.mShadowSize, 0.0f);
        this.mCornerShadowPath.arcTo(rectF2, 180.0f, 90.0f, false);
        this.mCornerShadowPath.arcTo(rectF, 270.0f, -90.0f, false);
        this.mCornerShadowPath.close();
        float f8 = this.mCornerRadius;
        float f9 = f8 / (this.mShadowSize + f8);
        Paint paint = this.mCornerShadowPaint;
        float f10 = this.mCornerRadius + this.mShadowSize;
        int i6 = this.mShadowStartColor;
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        paint.setShader(new RadialGradient(0.0f, 0.0f, f10, new int[]{i6, i6, this.mShadowEndColor}, new float[]{0.0f, f9, 1.0f}, tileMode));
        Paint paint2 = this.mEdgeShadowPaint;
        float f11 = this.mCornerRadius;
        float f12 = this.mShadowSize;
        float f13 = (-f11) + f12;
        float f14 = (-f11) - f12;
        int i7 = this.mShadowStartColor;
        paint2.setShader(new LinearGradient(0.0f, f13, 0.0f, f14, new int[]{i7, i7, this.mShadowEndColor}, new float[]{0.0f, 0.5f, 1.0f}, tileMode));
        this.mEdgeShadowPaint.setAntiAlias(false);
    }

    static float calculateHorizontalPadding(float f6, float f7, boolean z5) {
        return z5 ? (float) (f6 + ((1.0d - COS_45) * f7)) : f6;
    }

    static float calculateVerticalPadding(float f6, float f7, boolean z5) {
        return z5 ? (float) ((f6 * 1.5f) + ((1.0d - COS_45) * f7)) : f6 * 1.5f;
    }

    private void drawShadow(Canvas canvas) {
        Canvas canvas2;
        float f6 = this.mCornerRadius;
        float f7 = (-f6) - this.mShadowSize;
        float f8 = f6 + this.mInsetShadow + (this.mRawShadowSize / 2.0f);
        float f9 = 2.0f * f8;
        boolean z5 = this.mCardBounds.width() - f9 > 0.0f;
        boolean z6 = this.mCardBounds.height() - f9 > 0.0f;
        int save = canvas.save();
        RectF rectF = this.mCardBounds;
        canvas.translate(rectF.left + f8, rectF.top + f8);
        canvas.drawPath(this.mCornerShadowPath, this.mCornerShadowPaint);
        if (z5) {
            canvas2 = canvas;
            canvas2.drawRect(0.0f, f7, this.mCardBounds.width() - f9, -this.mCornerRadius, this.mEdgeShadowPaint);
        } else {
            canvas2 = canvas;
        }
        canvas2.restoreToCount(save);
        int save2 = canvas2.save();
        RectF rectF2 = this.mCardBounds;
        canvas2.translate(rectF2.right - f8, rectF2.bottom - f8);
        canvas2.rotate(180.0f);
        canvas2.drawPath(this.mCornerShadowPath, this.mCornerShadowPaint);
        if (z5) {
            canvas2.drawRect(0.0f, f7, this.mCardBounds.width() - f9, (-this.mCornerRadius) + this.mShadowSize, this.mEdgeShadowPaint);
        }
        canvas2.restoreToCount(save2);
        int save3 = canvas2.save();
        RectF rectF3 = this.mCardBounds;
        canvas2.translate(rectF3.left + f8, rectF3.bottom - f8);
        canvas2.rotate(270.0f);
        canvas2.drawPath(this.mCornerShadowPath, this.mCornerShadowPaint);
        if (z6) {
            canvas2.drawRect(0.0f, f7, this.mCardBounds.height() - f9, -this.mCornerRadius, this.mEdgeShadowPaint);
        }
        canvas2.restoreToCount(save3);
        int save4 = canvas2.save();
        RectF rectF4 = this.mCardBounds;
        canvas2.translate(rectF4.right - f8, rectF4.top + f8);
        canvas2.rotate(90.0f);
        canvas2.drawPath(this.mCornerShadowPath, this.mCornerShadowPaint);
        if (z6) {
            canvas2.drawRect(0.0f, f7, this.mCardBounds.height() - f9, -this.mCornerRadius, this.mEdgeShadowPaint);
        }
        canvas2.restoreToCount(save4);
    }

    private void setBackground(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.mBackground = colorStateList;
        this.mPaint.setColor(colorStateList.getColorForState(getState(), this.mBackground.getDefaultColor()));
    }

    private int toEven(float f6) {
        int i6 = (int) (f6 + 0.5f);
        return i6 % 2 == 1 ? i6 - 1 : i6;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.mDirty) {
            buildComponents(getBounds());
            this.mDirty = false;
        }
        canvas.translate(0.0f, this.mRawShadowSize / 2.0f);
        drawShadow(canvas);
        canvas.translate(0.0f, (-this.mRawShadowSize) / 2.0f);
        sRoundRectHelper.drawRoundRect(canvas, this.mCardBounds, this.mCornerRadius, this.mPaint);
    }

    ColorStateList getColor() {
        return this.mBackground;
    }

    float getCornerRadius() {
        return this.mCornerRadius;
    }

    float getMaxShadowSize() {
        return this.mRawMaxShadowSize;
    }

    float getMinHeight() {
        float f6 = this.mRawMaxShadowSize;
        return (Math.max(f6, this.mCornerRadius + this.mInsetShadow + ((f6 * 1.5f) / 2.0f)) * 2.0f) + (((this.mRawMaxShadowSize * 1.5f) + this.mInsetShadow) * 2.0f);
    }

    float getMinWidth() {
        float f6 = this.mRawMaxShadowSize;
        return (Math.max(f6, this.mCornerRadius + this.mInsetShadow + (f6 / 2.0f)) * 2.0f) + ((this.mRawMaxShadowSize + this.mInsetShadow) * 2.0f);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        int ceil = (int) Math.ceil(calculateVerticalPadding(this.mRawMaxShadowSize, this.mCornerRadius, this.mAddPaddingForCorners));
        int ceil2 = (int) Math.ceil(calculateHorizontalPadding(this.mRawMaxShadowSize, this.mCornerRadius, this.mAddPaddingForCorners));
        rect.set(ceil2, ceil, ceil2, ceil);
        return true;
    }

    float getShadowSize() {
        return this.mRawShadowSize;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList = this.mBackground;
        return (colorStateList != null && colorStateList.isStateful()) || super.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        ColorStateList colorStateList = this.mBackground;
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        if (this.mPaint.getColor() == colorForState) {
            return false;
        }
        this.mPaint.setColor(colorForState);
        this.mDirty = true;
        invalidateSelf();
        return true;
    }

    void setAddPaddingForCorners(boolean z5) {
        this.mAddPaddingForCorners = z5;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i6) {
        this.mPaint.setAlpha(i6);
        this.mCornerShadowPaint.setAlpha(i6);
        this.mEdgeShadowPaint.setAlpha(i6);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
    }

    void setMaxShadowSize(float f6) {
        setShadowSize(this.mRawShadowSize, f6);
    }

    RoundRectDrawableWithShadow(Resources resources, ColorStateList colorStateList, float f6, float f7, float f8) {
        this.mShadowStartColor = resources.getColor(R.color.cardview_shadow_start_color);
        this.mShadowEndColor = resources.getColor(R.color.cardview_shadow_end_color);
        this.mInsetShadow = resources.getDimensionPixelSize(R.dimen.cardview_compat_inset_shadow);
        setBackground(colorStateList);
        Paint paint = new Paint(5);
        this.mCornerShadowPaint = paint;
        paint.setStyle(Paint.Style.FILL);
        this.mCornerRadius = (int) (f6 + 0.5f);
        this.mCardBounds = new RectF();
        Paint paint2 = new Paint(this.mCornerShadowPaint);
        this.mEdgeShadowPaint = paint2;
        paint2.setAntiAlias(false);
        setShadowSize(f7, f8);
    }

    void getMaxShadowAndCornerPadding(Rect rect) {
        getPadding(rect);
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.mDirty = true;
    }

    void setColor(@Nullable ColorStateList colorStateList) {
        setBackground(colorStateList);
        invalidateSelf();
    }

    void setShadowSize(float f6) {
        setShadowSize(f6, this.mRawMaxShadowSize);
    }
}
