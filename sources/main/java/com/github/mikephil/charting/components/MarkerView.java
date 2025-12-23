package com.github.mikephil.charting.components;

import android.content.Context;
import android.graphics.Canvas;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.utils.MPPointF;
import java.lang.ref.WeakReference;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public class MarkerView extends RelativeLayout implements IMarker {
    private MPPointF mOffset;
    private MPPointF mOffset2;
    private WeakReference<Chart> mWeakChart;

    @Override // com.github.mikephil.charting.components.IMarker
    public void refreshContent(Entry entry, Highlight highlight) {
        measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        layout(0, 0, getMeasuredWidth(), getMeasuredHeight());
    }

    public void setOffset(MPPointF mPPointF) {
        this.mOffset = mPPointF;
        if (mPPointF == null) {
            this.mOffset = new MPPointF();
        }
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

    public void setChartView(Chart chart) {
        this.mWeakChart = new WeakReference<>(chart);
    }

    public MarkerView(Context context, int i6) {
        super(context);
        this.mOffset = new MPPointF();
        this.mOffset2 = new MPPointF();
        setupLayoutResource(i6);
    }

    private void setupLayoutResource(int i6) {
        View inflate = LayoutInflater.from(getContext()).inflate(i6, this);
        inflate.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        inflate.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        inflate.layout(0, 0, inflate.getMeasuredWidth(), inflate.getMeasuredHeight());
    }

    @Override // com.github.mikephil.charting.components.IMarker
    public void draw(Canvas canvas, float f6, float f7) {
        MPPointF offsetForDrawingAtPoint = getOffsetForDrawingAtPoint(f6, f7);
        int save = canvas.save();
        canvas.translate(f6 + offsetForDrawingAtPoint.f32565x, f7 + offsetForDrawingAtPoint.f32566y);
        draw(canvas);
        canvas.restoreToCount(save);
    }

    @Override // com.github.mikephil.charting.components.IMarker
    public MPPointF getOffsetForDrawingAtPoint(float f6, float f7) {
        MPPointF offset = getOffset();
        MPPointF mPPointF = this.mOffset2;
        mPPointF.f32565x = offset.f32565x;
        mPPointF.f32566y = offset.f32566y;
        Chart chartView = getChartView();
        float width = getWidth();
        float height = getHeight();
        MPPointF mPPointF2 = this.mOffset2;
        float f8 = mPPointF2.f32565x;
        if (f6 + f8 < 0.0f) {
            mPPointF2.f32565x = -f6;
        } else if (chartView != null && f6 + width + f8 > chartView.getWidth()) {
            this.mOffset2.f32565x = (chartView.getWidth() - f6) - width;
        }
        MPPointF mPPointF3 = this.mOffset2;
        float f9 = mPPointF3.f32566y;
        if (f7 + f9 < 0.0f) {
            mPPointF3.f32566y = -f7;
        } else if (chartView != null && f7 + height + f9 > chartView.getHeight()) {
            this.mOffset2.f32566y = (chartView.getHeight() - f7) - height;
        }
        return this.mOffset2;
    }

    public void setOffset(float f6, float f7) {
        MPPointF mPPointF = this.mOffset;
        mPPointF.f32565x = f6;
        mPPointF.f32566y = f7;
    }
}
