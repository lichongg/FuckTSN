package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Path;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.interfaces.datasets.ILineScatterCandleRadarDataSet;
import com.github.mikephil.charting.utils.ViewPortHandler;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class LineScatterCandleRadarRenderer extends BarLineScatterCandleBubbleRenderer {
    private Path mHighlightLinePath;

    protected void drawHighlightLines(Canvas canvas, float f6, float f7, ILineScatterCandleRadarDataSet iLineScatterCandleRadarDataSet) {
        this.mHighlightPaint.setColor(iLineScatterCandleRadarDataSet.getHighLightColor());
        this.mHighlightPaint.setStrokeWidth(iLineScatterCandleRadarDataSet.getHighlightLineWidth());
        this.mHighlightPaint.setPathEffect(iLineScatterCandleRadarDataSet.getDashPathEffectHighlight());
        if (iLineScatterCandleRadarDataSet.isVerticalHighlightIndicatorEnabled()) {
            this.mHighlightLinePath.reset();
            this.mHighlightLinePath.moveTo(f6, this.mViewPortHandler.contentTop());
            this.mHighlightLinePath.lineTo(f6, this.mViewPortHandler.contentBottom());
            canvas.drawPath(this.mHighlightLinePath, this.mHighlightPaint);
        }
        if (iLineScatterCandleRadarDataSet.isHorizontalHighlightIndicatorEnabled()) {
            this.mHighlightLinePath.reset();
            this.mHighlightLinePath.moveTo(this.mViewPortHandler.contentLeft(), f7);
            this.mHighlightLinePath.lineTo(this.mViewPortHandler.contentRight(), f7);
            canvas.drawPath(this.mHighlightLinePath, this.mHighlightPaint);
        }
    }

    public LineScatterCandleRadarRenderer(ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(chartAnimator, viewPortHandler);
        this.mHighlightLinePath = new Path();
    }
}
