package com.github.mikephil.charting.formatter;

import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.BubbleEntry;
import com.github.mikephil.charting.data.CandleEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.data.RadarEntry;
import com.github.mikephil.charting.utils.ViewPortHandler;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class ValueFormatter implements IAxisValueFormatter, IValueFormatter {
    @Override // com.github.mikephil.charting.formatter.IAxisValueFormatter
    @Deprecated
    public String getFormattedValue(float f6, AxisBase axisBase) {
        return getFormattedValue(f6);
    }

    @Override // com.github.mikephil.charting.formatter.IValueFormatter
    @Deprecated
    public String getFormattedValue(float f6, Entry entry, int i6, ViewPortHandler viewPortHandler) {
        return getFormattedValue(f6);
    }

    public String getAxisLabel(float f6, AxisBase axisBase) {
        return getFormattedValue(f6);
    }

    public String getBarLabel(BarEntry barEntry) {
        return getFormattedValue(barEntry.getY());
    }

    public String getBarStackedLabel(float f6, BarEntry barEntry) {
        return getFormattedValue(f6);
    }

    public String getBubbleLabel(BubbleEntry bubbleEntry) {
        return getFormattedValue(bubbleEntry.getSize());
    }

    public String getCandleLabel(CandleEntry candleEntry) {
        return getFormattedValue(candleEntry.getHigh());
    }

    public String getFormattedValue(float f6) {
        return String.valueOf(f6);
    }

    public String getPieLabel(float f6, PieEntry pieEntry) {
        return getFormattedValue(f6);
    }

    public String getPointLabel(Entry entry) {
        return getFormattedValue(entry.getY());
    }

    public String getRadarLabel(RadarEntry radarEntry) {
        return getFormattedValue(radarEntry.getY());
    }
}
