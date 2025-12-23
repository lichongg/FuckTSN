package com.github.mikephil.charting.charts;

import android.content.Context;
import android.util.AttributeSet;
import com.github.mikephil.charting.data.CandleData;
import com.github.mikephil.charting.interfaces.dataprovider.CandleDataProvider;
import com.github.mikephil.charting.renderer.CandleStickChartRenderer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public class CandleStickChart extends BarLineChartBase<CandleData> implements CandleDataProvider {
    public CandleStickChart(Context context) {
        super(context);
    }

    public CandleStickChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.github.mikephil.charting.interfaces.dataprovider.CandleDataProvider
    public CandleData getCandleData() {
        return (CandleData) this.mData;
    }

    public CandleStickChart(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase, com.github.mikephil.charting.charts.Chart
    protected void init() {
        super.init();
        this.mRenderer = new CandleStickChartRenderer(this, this.mAnimator, this.mViewPortHandler);
        getXAxis().setSpaceMin(0.5f);
        getXAxis().setSpaceMax(0.5f);
    }
}
