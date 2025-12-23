package com.github.mikephil.charting.interfaces.datasets;

import android.graphics.DashPathEffect;
import android.graphics.Typeface;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.model.GradientColor;
import com.github.mikephil.charting.utils.MPPointF;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public interface IDataSet<T extends Entry> {
    boolean addEntry(T t5);

    void addEntryOrdered(T t5);

    void calcMinMax();

    void calcMinMaxY(float f6, float f7);

    void clear();

    boolean contains(T t5);

    YAxis.AxisDependency getAxisDependency();

    int getColor();

    int getColor(int i6);

    List<Integer> getColors();

    List<T> getEntriesForXValue(float f6);

    int getEntryCount();

    T getEntryForIndex(int i6);

    T getEntryForXValue(float f6, float f7);

    T getEntryForXValue(float f6, float f7, DataSet.Rounding rounding);

    int getEntryIndex(float f6, float f7, DataSet.Rounding rounding);

    int getEntryIndex(T t5);

    Legend.LegendForm getForm();

    DashPathEffect getFormLineDashEffect();

    float getFormLineWidth();

    float getFormSize();

    GradientColor getGradientColor();

    GradientColor getGradientColor(int i6);

    List<GradientColor> getGradientColors();

    MPPointF getIconsOffset();

    int getIndexInEntries(int i6);

    String getLabel();

    ValueFormatter getValueFormatter();

    int getValueTextColor();

    int getValueTextColor(int i6);

    float getValueTextSize();

    Typeface getValueTypeface();

    float getXMax();

    float getXMin();

    float getYMax();

    float getYMin();

    boolean isDrawIconsEnabled();

    boolean isDrawValuesEnabled();

    boolean isHighlightEnabled();

    boolean isVisible();

    boolean needsFormatter();

    boolean removeEntry(int i6);

    boolean removeEntry(T t5);

    boolean removeEntryByXValue(float f6);

    boolean removeFirst();

    boolean removeLast();

    void setAxisDependency(YAxis.AxisDependency axisDependency);

    void setDrawIcons(boolean z5);

    void setDrawValues(boolean z5);

    void setHighlightEnabled(boolean z5);

    void setIconsOffset(MPPointF mPPointF);

    void setLabel(String str);

    void setValueFormatter(ValueFormatter valueFormatter);

    void setValueTextColor(int i6);

    void setValueTextColors(List<Integer> list);

    void setValueTextSize(float f6);

    void setValueTypeface(Typeface typeface);

    void setVisible(boolean z5);
}
