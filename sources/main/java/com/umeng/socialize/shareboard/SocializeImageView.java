package com.umeng.socialize.shareboard;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ImageButton;
import android.widget.ImageView;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class SocializeImageView extends ImageButton {
    public static int BG_SHAPE_CIRCULAR = 1;
    public static int BG_SHAPE_NONE = 0;
    public static int BG_SHAPE_ROUNDED_SQUARE = 2;
    private int mAngle;
    private int mBgShape;
    private int mIconPressedColor;
    private boolean mIsPressEffect;
    private boolean mIsSelected;
    private int mNormalColor;
    protected Paint mNormalPaint;
    private int mPressedColor;
    protected Paint mPressedPaint;
    private RectF mSquareRect;

    public SocializeImageView(Context context) {
        super(context);
        init();
    }

    private void init() {
        setBackground(null);
        setClickable(false);
        setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i6) {
        setBackgroundColor(i6, 0);
    }

    public void setBackgroundShape(int i6) {
        setBackgroundShape(i6, 0);
    }

    private void drawRect(Canvas canvas, Paint paint) {
        if (this.mSquareRect == null) {
            RectF rectF = new RectF();
            this.mSquareRect = rectF;
            rectF.left = 0.0f;
            rectF.top = 0.0f;
            rectF.right = getMeasuredWidth();
            this.mSquareRect.bottom = getMeasuredWidth();
        }
        RectF rectF2 = this.mSquareRect;
        int i6 = this.mAngle;
        canvas.drawRoundRect(rectF2, i6, i6, paint);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Paint paint;
        int i6 = this.mBgShape;
        if (i6 == BG_SHAPE_NONE) {
            super.onDraw(canvas);
            return;
        }
        if (this.mIsSelected) {
            if (this.mIsPressEffect && (paint = this.mPressedPaint) != null) {
                if (i6 == BG_SHAPE_CIRCULAR) {
                    drawCircle(canvas, paint);
                } else if (i6 == BG_SHAPE_ROUNDED_SQUARE) {
                    drawRect(canvas, paint);
                }
            }
        } else if (i6 == BG_SHAPE_CIRCULAR) {
            drawCircle(canvas, this.mNormalPaint);
        } else if (i6 == BG_SHAPE_ROUNDED_SQUARE) {
            drawRect(canvas, this.mNormalPaint);
        }
        super.onDraw(canvas);
    }

    public void setBackgroundColor(int i6, int i7) {
        this.mNormalColor = i6;
        this.mPressedColor = i7;
        setPressEffectEnable(i7 != 0);
        if (this.mNormalColor != 0) {
            Paint paint = new Paint();
            this.mNormalPaint = paint;
            paint.setStyle(Paint.Style.FILL);
            this.mNormalPaint.setAntiAlias(true);
            this.mNormalPaint.setColor(i6);
        }
        if (this.mPressedColor != 0) {
            Paint paint2 = new Paint();
            this.mPressedPaint = paint2;
            paint2.setStyle(Paint.Style.FILL);
            this.mPressedPaint.setAntiAlias(true);
            this.mPressedPaint.setColor(i7);
        }
    }

    public void setBackgroundShape(int i6, int i7) {
        this.mBgShape = i6;
        if (i6 != BG_SHAPE_ROUNDED_SQUARE) {
            this.mAngle = 0;
        } else {
            this.mAngle = (int) ((i7 * getResources().getDisplayMetrics().density) + 0.5f);
        }
    }

    public void setPressEffectEnable(boolean z5) {
        this.mIsPressEffect = z5;
    }

    public void setPressedColor(int i6) {
        setPressEffectEnable(i6 != 0);
        this.mIconPressedColor = i6;
    }

    public SocializeImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void drawCircle(Canvas canvas, Paint paint) {
        float measuredWidth = getMeasuredWidth() / 2;
        canvas.drawCircle(measuredWidth, measuredWidth, measuredWidth, paint);
    }

    protected int dip2px(float f6) {
        return (int) ((f6 * getContext().getResources().getDisplayMetrics().density) + 0.5f);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.mIsPressEffect) {
            if (isPressed()) {
                if (BG_SHAPE_NONE == this.mBgShape) {
                    int i6 = this.mIconPressedColor;
                    if (i6 != 0) {
                        setColorFilter(i6, PorterDuff.Mode.SRC_ATOP);
                        return;
                    }
                    return;
                }
                this.mIsSelected = true;
                invalidate();
                return;
            }
            if (BG_SHAPE_NONE == this.mBgShape) {
                clearColorFilter();
            } else {
                this.mIsSelected = false;
                invalidate();
            }
        }
    }

    public SocializeImageView(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        init();
    }

    @TargetApi(21)
    public SocializeImageView(Context context, AttributeSet attributeSet, int i6, int i7) {
        super(context, attributeSet, i6, i7);
        init();
    }
}
