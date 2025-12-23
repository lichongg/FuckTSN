package com.github.mikephil.charting.charts;

import android.content.Context;
import android.util.AttributeSet;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.interfaces.dataprovider.LineDataProvider;
import com.github.mikephil.charting.renderer.DataRenderer;
import com.github.mikephil.charting.renderer.LineChartRenderer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public class LineChart extends BarLineChartBase<LineData> implements LineDataProvider {
    public LineChart(Context context) {
        super(context);
    }

    public LineChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.github.mikephil.charting.interfaces.dataprovider.LineDataProvider
    public LineData getLineData() {
        return (LineData) this.mData;
    }

    @Override // com.github.mikephil.charting.charts.Chart, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        DataRenderer dataRenderer = this.mRenderer;
        if (dataRenderer != null && (dataRenderer instanceof LineChartRenderer)) {
            ((LineChartRenderer) dataRenderer).releaseBitmap();
        }
        super.onDetachedFromWindow();
    }

    public LineChart(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase, com.github.mikephil.charting.charts.Chart
    protected void init() {
        super.init();
        this.mRenderer = new LineChartRenderer(this, this.mAnimator, this.mViewPortHandler);
    }
}
