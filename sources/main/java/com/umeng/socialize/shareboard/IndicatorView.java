package com.umeng.socialize.shareboard;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class IndicatorView extends View {
    private int mIndicatorMargin;
    private int mIndicatorWidth;
    private float mLeftPosition;
    private Paint mNormalPaint;
    private int mPageCount;
    private Paint mSelectPaint;
    private int mSelectPosition;

    public IndicatorView(Context context) {
        super(context);
    }

    public void setIndicator(int i6, int i7) {
        this.mIndicatorMargin = dip2px(i7);
        this.mIndicatorWidth = dip2px(i6);
    }

    public IndicatorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setIndicatorColor(int i6, int i7) {
        Paint paint = new Paint();
        this.mSelectPaint = paint;
        Paint.Style style = Paint.Style.FILL;
        paint.setStyle(style);
        this.mSelectPaint.setAntiAlias(true);
        this.mSelectPaint.setColor(i7);
        Paint paint2 = new Paint();
        this.mNormalPaint = paint2;
        paint2.setStyle(style);
        this.mNormalPaint.setAntiAlias(true);
        this.mNormalPaint.setColor(i6);
    }

    public void setPageCount(int i6) {
        this.mPageCount = i6;
        invalidate();
    }

    public void setSelectedPosition(int i6) {
        this.mSelectPosition = i6;
        invalidate();
    }

    public IndicatorView(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
    }

    private int measureHeight(int i6) {
        int mode = View.MeasureSpec.getMode(i6);
        int size = View.MeasureSpec.getSize(i6);
        if (mode == 1073741824) {
            return size;
        }
        int paddingTop = getPaddingTop() + getPaddingBottom() + (this.mIndicatorWidth * 2);
        if (mode == Integer.MIN_VALUE) {
            return Math.min(paddingTop, size);
        }
        return paddingTop;
    }

    private int measureWidth(int i6) {
        int mode = View.MeasureSpec.getMode(i6);
        int size = View.MeasureSpec.getSize(i6);
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int i7 = this.mIndicatorWidth;
        int i8 = this.mPageCount;
        int i9 = paddingLeft + (i7 * i8 * 2) + (this.mIndicatorMargin * (i8 - 1));
        this.mLeftPosition = ((getMeasuredWidth() - i9) / 2.0f) + getPaddingLeft();
        if (mode == 1073741824) {
            return Math.max(i9, size);
        }
        if (mode == Integer.MIN_VALUE) {
            return Math.min(i9, size);
        }
        return i9;
    }

    protected int dip2px(float f6) {
        return (int) ((f6 * getContext().getResources().getDisplayMetrics().density) + 0.5f);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Paint paint;
        super.onDraw(canvas);
        if (this.mSelectPaint != null && this.mNormalPaint != null) {
            float f6 = this.mLeftPosition + this.mIndicatorWidth;
            for (int i6 = 0; i6 < this.mPageCount; i6++) {
                int i7 = this.mIndicatorWidth;
                float f7 = i7;
                float f8 = i7;
                if (i6 == this.mSelectPosition) {
                    paint = this.mSelectPaint;
                } else {
                    paint = this.mNormalPaint;
                }
                canvas.drawCircle(f6, f7, f8, paint);
                f6 += this.mIndicatorMargin + (this.mIndicatorWidth * 2);
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i6, int i7) {
        setMeasuredDimension(measureWidth(i6), measureHeight(i7));
    }

    @TargetApi(21)
    public IndicatorView(Context context, AttributeSet attributeSet, int i6, int i7) {
        super(context, attributeSet, i6, i7);
    }
}
