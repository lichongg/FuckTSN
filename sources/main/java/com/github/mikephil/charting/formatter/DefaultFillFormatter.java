package com.github.mikephil.charting.formatter;

import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.interfaces.dataprovider.LineDataProvider;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public class DefaultFillFormatter implements IFillFormatter {
    @Override // com.github.mikephil.charting.formatter.IFillFormatter
    public float getFillLinePosition(ILineDataSet iLineDataSet, LineDataProvider lineDataProvider) {
        float yChartMax = lineDataProvider.getYChartMax();
        float yChartMin = lineDataProvider.getYChartMin();
        LineData lineData = lineDataProvider.getLineData();
        if (iLineDataSet.getYMax() > 0.0f && iLineDataSet.getYMin() < 0.0f) {
            return 0.0f;
        }
        if (lineData.getYMax() > 0.0f) {
            yChartMax = 0.0f;
        }
        if (lineData.getYMin() < 0.0f) {
            yChartMin = 0.0f;
        }
        if (iLineDataSet.getYMin() >= 0.0f) {
            return yChartMin;
        }
        return yChartMax;
    }
}
