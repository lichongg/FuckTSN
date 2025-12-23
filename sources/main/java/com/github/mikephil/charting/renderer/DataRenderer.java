package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.dataprovider.ChartInterface;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class DataRenderer extends Renderer {
    protected ChartAnimator mAnimator;
    protected Paint mDrawPaint;
    protected Paint mHighlightPaint;
    protected Paint mRenderPaint;
    protected Paint mValuePaint;

    public abstract void drawData(Canvas canvas);

    public abstract void drawExtras(Canvas canvas);

    public abstract void drawHighlighted(Canvas canvas, Highlight[] highlightArr);

    public abstract void drawValue(Canvas canvas, String str, float f6, float f7, int i6);

    public abstract void drawValues(Canvas canvas);

    public abstract void initBuffers();

    protected void applyValueTextStyle(IDataSet iDataSet) {
        this.mValuePaint.setTypeface(iDataSet.getValueTypeface());
        this.mValuePaint.setTextSize(iDataSet.getValueTextSize());
    }

    public Paint getPaintHighlight() {
        return this.mHighlightPaint;
    }

    public Paint getPaintRender() {
        return this.mRenderPaint;
    }

    public Paint getPaintValues() {
        return this.mValuePaint;
    }

    public DataRenderer(ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(viewPortHandler);
        this.mAnimator = chartAnimator;
        Paint paint = new Paint(1);
        this.mRenderPaint = paint;
        paint.setStyle(Paint.Style.FILL);
        this.mDrawPaint = new Paint(4);
        Paint paint2 = new Paint(1);
        this.mValuePaint = paint2;
        paint2.setColor(Color.rgb(63, 63, 63));
        this.mValuePaint.setTextAlign(Paint.Align.CENTER);
        this.mValuePaint.setTextSize(Utils.convertDpToPixel(9.0f));
        Paint paint3 = new Paint(1);
        this.mHighlightPaint = paint3;
        paint3.setStyle(Paint.Style.STROKE);
        this.mHighlightPaint.setStrokeWidth(2.0f);
        this.mHighlightPaint.setColor(Color.rgb(255, 187, 115));
    }

    protected boolean isDrawingValuesAllowed(ChartInterface chartInterface) {
        if (chartInterface.getData().getEntryCount() < chartInterface.getMaxVisibleCount() * this.mViewPortHandler.getScaleX()) {
            return true;
        }
        return false;
    }
}
