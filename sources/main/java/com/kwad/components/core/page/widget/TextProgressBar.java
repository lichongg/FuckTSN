package com.kwad.components.core.page.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import com.kwad.sdk.o.m;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class TextProgressBar extends ProgressBar {

    @Nullable
    private String VF;
    private LinearGradient VG;
    private Matrix VH;
    private boolean VI;
    private boolean VJ;
    private boolean VK;
    private int VL;
    private int VM;
    private Drawable VN;
    private int VO;
    private Rect VP;
    private int[] VQ;
    private int VR;
    private int VS;
    private boolean VT;
    private Paint mPaint;
    private RectF mRectF;

    public TextProgressBar(Context context) {
        this(context, null);
    }

    private void setProgressText(int i6) {
        this.VF = String.valueOf((int) (((i6 * 1.0f) / getMax()) * 100.0f)) + "%";
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected synchronized void onDraw(Canvas canvas) {
        int width;
        try {
            if (this.VJ) {
                canvas.save();
                canvas.rotate(90.0f);
                canvas.translate(0.0f, -getWidth());
                super.onDraw(canvas);
                canvas.restore();
            } else {
                super.onDraw(canvas);
            }
            if (!TextUtils.isEmpty(this.VF)) {
                Paint paint = this.mPaint;
                String str = this.VF;
                paint.getTextBounds(str, 0, str.length(), this.VP);
            }
            int height = (getHeight() / 2) - this.VP.centerY();
            Drawable drawable = this.VN;
            if (drawable != null) {
                int intrinsicWidth = drawable.getIntrinsicWidth();
                int intrinsicHeight = this.VN.getIntrinsicHeight();
                int width2 = (((getWidth() - this.VP.width()) - intrinsicWidth) - this.VO) / 2;
                int i6 = intrinsicWidth + width2;
                this.VN.setBounds(width2, (getHeight() - intrinsicHeight) / 2, i6, (getHeight() + intrinsicHeight) / 2);
                this.VN.draw(canvas);
                width = i6 + this.VO;
            } else {
                width = (getWidth() / 2) - this.VP.centerX();
            }
            if (this.VQ != null) {
                float progress = ((getProgress() * 1.0f) / getMax()) * getWidth();
                float f6 = width;
                if (progress >= f6) {
                    if (this.VG == null) {
                        this.VG = new LinearGradient(f6, 0.0f, width + this.VP.width(), 0.0f, this.VQ, (float[]) null, Shader.TileMode.CLAMP);
                        Matrix matrix = new Matrix();
                        this.VH = matrix;
                        this.VG.setLocalMatrix(matrix);
                    }
                    this.mPaint.setShader(this.VG);
                    this.VH.setScale(((progress - f6) * 1.0f) / this.VP.width(), 1.0f, f6, 0.0f);
                    this.VG.setLocalMatrix(this.VH);
                } else {
                    this.mPaint.setShader(null);
                }
                canvas.drawText(this.VF, f6, height, this.mPaint);
                return;
            }
            if (!isIndeterminate() && !this.VT) {
                this.mPaint.setColor(this.VR);
                String str2 = this.VF;
                if (str2 != null) {
                    canvas.drawText(str2, width, height, this.mPaint);
                }
                return;
            }
            float width3 = (getWidth() * getProgress()) / getMax();
            int save = canvas.save();
            this.mRectF.set(width3, 0.0f, getWidth(), getHeight());
            canvas.clipRect(this.mRectF);
            this.mPaint.setColor(this.VS);
            String str3 = this.VF;
            if (str3 != null) {
                canvas.drawText(str3, width, height, this.mPaint);
            }
            canvas.restoreToCount(save);
            int save2 = canvas.save();
            this.mRectF.set(0.0f, 0.0f, width3, getHeight());
            canvas.clipRect(this.mRectF);
            this.mPaint.setColor(this.VR);
            String str4 = this.VF;
            if (str4 != null) {
                canvas.drawText(str4, width, height, this.mPaint);
            }
            canvas.restoreToCount(save2);
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected synchronized void onMeasure(int i6, int i7) {
        try {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams != null && !TextUtils.isEmpty(this.VF)) {
                Rect rect = new Rect();
                Paint paint = this.mPaint;
                String str = this.VF;
                paint.getTextBounds(str, 0, str.length(), rect);
                if (layoutParams.width == -2) {
                    int width = rect.width() + this.VL + this.VM;
                    layoutParams.width = width;
                    i6 = View.MeasureSpec.makeMeasureSpec(width, 1073741824);
                }
                if (layoutParams.height == -2) {
                    int height = rect.height();
                    layoutParams.height = height;
                    i7 = View.MeasureSpec.makeMeasureSpec(height, 1073741824);
                }
            }
            if (!this.VJ) {
                super.onMeasure(i6, i7);
            } else {
                super.onMeasure(i7, i6);
                setMeasuredDimension(getMeasuredHeight(), getMeasuredWidth());
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setTextColor(int i6) {
        this.VT = false;
        this.VR = i6;
        postInvalidate();
    }

    public TextProgressBar(Context context, AttributeSet attributeSet) {
        super(m.wrapContextIfNeed(context), attributeSet);
        this.VJ = false;
        this.VK = true;
        this.VP = new Rect();
        rP();
    }

    private void rP() {
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
        this.mPaint.setColor(-1);
        this.mPaint.setTextSize(com.kwad.sdk.c.a.a.a(getContext(), 12.0f));
        this.VO = com.kwad.sdk.c.a.a.a(getContext(), 2.0f);
        this.mRectF = new RectF();
        this.VR = -1;
        this.VS = -117146;
    }

    public final void e(String str, int i6) {
        this.VF = str;
        this.VI = true;
        setProgress(i6);
        invalidate();
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected void onSizeChanged(int i6, int i7, int i8, int i9) {
        if (this.VJ) {
            super.onSizeChanged(i7, i6, i8, i9);
        } else {
            super.onSizeChanged(i6, i7, i8, i9);
        }
    }

    public void setDrawableLeft(Drawable drawable) {
        this.VN = drawable;
    }

    public void setDrawablePadding(int i6) {
        this.VO = i6;
    }

    public void setHasProgress(boolean z5) {
        this.VK = z5;
    }

    @Override // android.view.View
    public void setPadding(int i6, int i7, int i8, int i9) {
        this.VL = i6;
        this.VM = i8;
    }

    @Override // android.widget.ProgressBar
    public void setProgress(int i6) {
        if (this.VK) {
            super.setProgress(i6);
        } else {
            super.setProgress(0);
        }
    }

    public void setTextDimen(float f6) {
        this.mPaint.setTextSize(f6);
    }

    public void setTextDimenSp(int i6) {
        this.mPaint.setTextSize(TypedValue.applyDimension(2, i6, getResources().getDisplayMetrics()));
    }

    public void setVertical(boolean z5) {
        this.VJ = z5;
    }

    public final void setTextColor(@ColorInt int i6, @ColorInt int i7) {
        this.VT = true;
        this.VR = i6;
        this.VS = i7;
        postInvalidate();
    }
}
