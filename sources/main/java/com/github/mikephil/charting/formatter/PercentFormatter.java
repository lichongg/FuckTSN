package com.github.mikephil.charting.formatter;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieEntry;
import java.text.DecimalFormat;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public class PercentFormatter extends ValueFormatter {
    public DecimalFormat mFormat;
    private PieChart pieChart;

    public PercentFormatter() {
        this.mFormat = new DecimalFormat("###,###,##0.0");
    }

    @Override // com.github.mikephil.charting.formatter.ValueFormatter
    public String getFormattedValue(float f6) {
        return this.mFormat.format(f6) + " %";
    }

    @Override // com.github.mikephil.charting.formatter.ValueFormatter
    public String getPieLabel(float f6, PieEntry pieEntry) {
        PieChart pieChart = this.pieChart;
        return (pieChart == null || !pieChart.isUsePercentValuesEnabled()) ? this.mFormat.format(f6) : getFormattedValue(f6);
    }

    public PercentFormatter(PieChart pieChart) {
        this();
        this.pieChart = pieChart;
    }
}
