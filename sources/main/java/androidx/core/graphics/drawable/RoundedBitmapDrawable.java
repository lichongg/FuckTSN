package androidx.core.graphics.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public abstract class RoundedBitmapDrawable extends Drawable {
    private static final int DEFAULT_PAINT_FLAGS = 3;
    final Bitmap mBitmap;
    private int mBitmapHeight;
    private final BitmapShader mBitmapShader;
    private int mBitmapWidth;
    private float mCornerRadius;
    private boolean mIsCircular;
    private int mTargetDensity;
    private int mGravity = 119;
    private final Paint mPaint = new Paint(3);
    private final Matrix mShaderMatrix = new Matrix();
    final Rect mDstRect = new Rect();
    private final RectF mDstRectF = new RectF();
    private boolean mApplyGravity = true;

    public void setTargetDensity(@NonNull Canvas canvas) {
        setTargetDensity(canvas.getDensity());
    }

    private void computeBitmapSize() {
        this.mBitmapWidth = this.mBitmap.getScaledWidth(this.mTargetDensity);
        this.mBitmapHeight = this.mBitmap.getScaledHeight(this.mTargetDensity);
    }

    private void updateCircularCornerRadius() {
        this.mCornerRadius = Math.min(this.mBitmapHeight, this.mBitmapWidth) / 2;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        Bitmap bitmap = this.mBitmap;
        if (bitmap == null) {
            return;
        }
        updateDstRect();
        if (this.mPaint.getShader() == null) {
            canvas.drawBitmap(bitmap, (Rect) null, this.mDstRect, this.mPaint);
            return;
        }
        RectF rectF = this.mDstRectF;
        float f6 = this.mCornerRadius;
        canvas.drawRoundRect(rectF, f6, f6, this.mPaint);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.mPaint.getAlpha();
    }

    @Nullable
    public final Bitmap getBitmap() {
        return this.mBitmap;
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        return this.mPaint.getColorFilter();
    }

    public float getCornerRadius() {
        return this.mCornerRadius;
    }

    public int getGravity() {
        return this.mGravity;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.mBitmapHeight;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.mBitmapWidth;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Bitmap bitmap;
        return (this.mGravity != 119 || this.mIsCircular || (bitmap = this.mBitmap) == null || bitmap.hasAlpha() || this.mPaint.getAlpha() < 255 || isGreaterThanZero(this.mCornerRadius)) ? -3 : -1;
    }

    @NonNull
    public final Paint getPaint() {
        return this.mPaint;
    }

    void gravityCompatApply(int i6, int i7, int i8, Rect rect, Rect rect2) {
        throw new UnsupportedOperationException();
    }

    public boolean hasAntiAlias() {
        return this.mPaint.isAntiAlias();
    }

    public boolean hasMipMap() {
        throw new UnsupportedOperationException();
    }

    public boolean isCircular() {
        return this.mIsCircular;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i6) {
        if (i6 != this.mPaint.getAlpha()) {
            this.mPaint.setAlpha(i6);
            invalidateSelf();
        }
    }

    public void setAntiAlias(boolean z5) {
        this.mPaint.setAntiAlias(z5);
        invalidateSelf();
    }

    public void setCircular(boolean z5) {
        this.mIsCircular = z5;
        this.mApplyGravity = true;
        if (!z5) {
            setCornerRadius(0.0f);
            return;
        }
        updateCircularCornerRadius();
        this.mPaint.setShader(this.mBitmapShader);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public void setCornerRadius(float f6) {
        if (this.mCornerRadius == f6) {
            return;
        }
        this.mIsCircular = false;
        if (isGreaterThanZero(f6)) {
            this.mPaint.setShader(this.mBitmapShader);
        } else {
            this.mPaint.setShader(null);
        }
        this.mCornerRadius = f6;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z5) {
        this.mPaint.setDither(z5);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z5) {
        this.mPaint.setFilterBitmap(z5);
        invalidateSelf();
    }

    public void setGravity(int i6) {
        if (this.mGravity != i6) {
            this.mGravity = i6;
            this.mApplyGravity = true;
            invalidateSelf();
        }
    }

    public void setMipMap(boolean z5) {
        throw new UnsupportedOperationException();
    }

    public void setTargetDensity(@NonNull DisplayMetrics displayMetrics) {
        setTargetDensity(displayMetrics.densityDpi);
    }

    void updateDstRect() {
        RoundedBitmapDrawable roundedBitmapDrawable;
        if (this.mApplyGravity) {
            if (this.mIsCircular) {
                int min = Math.min(this.mBitmapWidth, this.mBitmapHeight);
                roundedBitmapDrawable = this;
                roundedBitmapDrawable.gravityCompatApply(this.mGravity, min, min, getBounds(), this.mDstRect);
                int min2 = Math.min(roundedBitmapDrawable.mDstRect.width(), roundedBitmapDrawable.mDstRect.height());
                roundedBitmapDrawable.mDstRect.inset(Math.max(0, (roundedBitmapDrawable.mDstRect.width() - min2) / 2), Math.max(0, (roundedBitmapDrawable.mDstRect.height() - min2) / 2));
                roundedBitmapDrawable.mCornerRadius = min2 * 0.5f;
            } else {
                roundedBitmapDrawable = this;
                roundedBitmapDrawable.gravityCompatApply(roundedBitmapDrawable.mGravity, roundedBitmapDrawable.mBitmapWidth, roundedBitmapDrawable.mBitmapHeight, getBounds(), roundedBitmapDrawable.mDstRect);
            }
            roundedBitmapDrawable.mDstRectF.set(roundedBitmapDrawable.mDstRect);
            if (roundedBitmapDrawable.mBitmapShader != null) {
                Matrix matrix = roundedBitmapDrawable.mShaderMatrix;
                RectF rectF = roundedBitmapDrawable.mDstRectF;
                matrix.setTranslate(rectF.left, rectF.top);
                roundedBitmapDrawable.mShaderMatrix.preScale(roundedBitmapDrawable.mDstRectF.width() / roundedBitmapDrawable.mBitmap.getWidth(), roundedBitmapDrawable.mDstRectF.height() / roundedBitmapDrawable.mBitmap.getHeight());
                roundedBitmapDrawable.mBitmapShader.setLocalMatrix(roundedBitmapDrawable.mShaderMatrix);
                roundedBitmapDrawable.mPaint.setShader(roundedBitmapDrawable.mBitmapShader);
            }
            roundedBitmapDrawable.mApplyGravity = false;
        }
    }

    RoundedBitmapDrawable(Resources resources, Bitmap bitmap) {
        this.mTargetDensity = 160;
        if (resources != null) {
            this.mTargetDensity = resources.getDisplayMetrics().densityDpi;
        }
        this.mBitmap = bitmap;
        if (bitmap != null) {
            computeBitmapSize();
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            this.mBitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        } else {
            this.mBitmapHeight = -1;
            this.mBitmapWidth = -1;
            this.mBitmapShader = null;
        }
    }

    private static boolean isGreaterThanZero(float f6) {
        if (f6 > 0.05f) {
            return true;
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(@NonNull Rect rect) {
        super.onBoundsChange(rect);
        if (this.mIsCircular) {
            updateCircularCornerRadius();
        }
        this.mApplyGravity = true;
    }

    public void setTargetDensity(int i6) {
        if (this.mTargetDensity != i6) {
            if (i6 == 0) {
                i6 = 160;
            }
            this.mTargetDensity = i6;
            if (this.mBitmap != null) {
                computeBitmapSize();
            }
            invalidateSelf();
        }
    }
}
