package com.github.mikephil.charting.interfaces.dataprovider;

import android.graphics.RectF;
import com.github.mikephil.charting.data.ChartData;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.utils.MPPointF;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public interface ChartInterface {
    MPPointF getCenterOfView();

    MPPointF getCenterOffsets();

    RectF getContentRect();

    ChartData getData();

    ValueFormatter getDefaultValueFormatter();

    int getHeight();

    float getMaxHighlightDistance();

    int getMaxVisibleCount();

    int getWidth();

    float getXChartMax();

    float getXChartMin();

    float getXRange();

    float getYChartMax();

    float getYChartMin();
}
