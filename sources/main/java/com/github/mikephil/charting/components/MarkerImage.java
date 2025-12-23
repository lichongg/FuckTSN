package com.github.mikephil.charting.components;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.utils.FSize;
import com.github.mikephil.charting.utils.MPPointF;
import java.lang.ref.WeakReference;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public class MarkerImage implements IMarker {
    private Context mContext;
    private Drawable mDrawable;
    private WeakReference<Chart> mWeakChart;
    private MPPointF mOffset = new MPPointF();
    private MPPointF mOffset2 = new MPPointF();
    private FSize mSize = new FSize();
    private Rect mDrawableBoundsCache = new Rect();

    public void setOffset(MPPointF mPPointF) {
        this.mOffset = mPPointF;
        if (mPPointF == null) {
            this.mOffset = new MPPointF();
        }
    }

    @Override // com.github.mikephil.charting.components.IMarker
    public void draw(Canvas canvas, float f6, float f7) {
        if (this.mDrawable == null) {
            return;
        }
        MPPointF offsetForDrawingAtPoint = getOffsetForDrawingAtPoint(f6, f7);
        FSize fSize = this.mSize;
        float f8 = fSize.width;
        float f9 = fSize.height;
        if (f8 == 0.0f) {
            f8 = this.mDrawable.getIntrinsicWidth();
        }
        if (f9 == 0.0f) {
            f9 = this.mDrawable.getIntrinsicHeight();
        }
        this.mDrawable.copyBounds(this.mDrawableBoundsCache);
        Drawable drawable = this.mDrawable;
        Rect rect = this.mDrawableBoundsCache;
        int i6 = rect.left;
        int i7 = rect.top;
        drawable.setBounds(i6, i7, ((int) f8) + i6, ((int) f9) + i7);
        int save = canvas.save();
        canvas.translate(f6 + offsetForDrawingAtPoint.f32565x, f7 + offsetForDrawingAtPoint.f32566y);
        this.mDrawable.draw(canvas);
        canvas.restoreToCount(save);
        this.mDrawable.setBounds(this.mDrawableBoundsCache);
    }

    public Chart getChartView() {
        WeakReference<Chart> weakReference = this.mWeakChart;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    @Override // com.github.mikephil.charting.components.IMarker
    public MPPointF getOffset() {
        return this.mOffset;
    }

    public FSize getSize() {
        return this.mSize;
    }

    public void setChartView(Chart chart) {
        this.mWeakChart = new WeakReference<>(chart);
    }

    public void setSize(FSize fSize) {
        this.mSize = fSize;
        if (fSize == null) {
            this.mSize = new FSize();
        }
    }

    public MarkerImage(Context context, int i6) {
        this.mContext = context;
        this.mDrawable = context.getResources().getDrawable(i6, null);
    }

    @Override // com.github.mikephil.charting.components.IMarker
    public MPPointF getOffsetForDrawingAtPoint(float f6, float f7) {
        Drawable drawable;
        Drawable drawable2;
        MPPointF offset = getOffset();
        MPPointF mPPointF = this.mOffset2;
        mPPointF.f32565x = offset.f32565x;
        mPPointF.f32566y = offset.f32566y;
        Chart chartView = getChartView();
        FSize fSize = this.mSize;
        float f8 = fSize.width;
        float f9 = fSize.height;
        if (f8 == 0.0f && (drawable2 = this.mDrawable) != null) {
            f8 = drawable2.getIntrinsicWidth();
        }
        if (f9 == 0.0f && (drawable = this.mDrawable) != null) {
            f9 = drawable.getIntrinsicHeight();
        }
        MPPointF mPPointF2 = this.mOffset2;
        float f10 = mPPointF2.f32565x;
        if (f6 + f10 < 0.0f) {
            mPPointF2.f32565x = -f6;
        } else if (chartView != null && f6 + f8 + f10 > chartView.getWidth()) {
            this.mOffset2.f32565x = (chartView.getWidth() - f6) - f8;
        }
        MPPointF mPPointF3 = this.mOffset2;
        float f11 = mPPointF3.f32566y;
        if (f7 + f11 < 0.0f) {
            mPPointF3.f32566y = -f7;
        } else if (chartView != null && f7 + f9 + f11 > chartView.getHeight()) {
            this.mOffset2.f32566y = (chartView.getHeight() - f7) - f9;
        }
        return this.mOffset2;
    }

    public void setOffset(float f6, float f7) {
        MPPointF mPPointF = this.mOffset;
        mPPointF.f32565x = f6;
        mPPointF.f32566y = f7;
    }

    @Override // com.github.mikephil.charting.components.IMarker
    public void refreshContent(Entry entry, Highlight highlight) {
    }
}
