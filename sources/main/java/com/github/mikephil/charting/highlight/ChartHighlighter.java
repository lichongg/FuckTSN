package com.github.mikephil.charting.highlight;

import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarLineScatterCandleBubbleData;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.interfaces.dataprovider.BarLineScatterCandleBubbleDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.utils.MPPointD;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public class ChartHighlighter<T extends BarLineScatterCandleBubbleDataProvider> implements IHighlighter {
    protected T mChart;
    protected List<Highlight> mHighlightBuffer = new ArrayList();

    public Highlight getClosestHighlightByPixel(List<Highlight> list, float f6, float f7, YAxis.AxisDependency axisDependency, float f8) {
        Highlight highlight = null;
        for (int i6 = 0; i6 < list.size(); i6++) {
            Highlight highlight2 = list.get(i6);
            if (axisDependency == null || highlight2.getAxis() == axisDependency) {
                float distance = getDistance(f6, f7, highlight2.getXPx(), highlight2.getYPx());
                if (distance < f8) {
                    highlight = highlight2;
                    f8 = distance;
                }
            }
        }
        return highlight;
    }

    protected float getDistance(float f6, float f7, float f8, float f9) {
        return (float) Math.hypot(f6 - f8, f7 - f9);
    }

    protected List<Highlight> buildHighlights(IDataSet iDataSet, int i6, float f6, DataSet.Rounding rounding) {
        Entry entryForXValue;
        ArrayList arrayList = new ArrayList();
        List<Entry> entriesForXValue = iDataSet.getEntriesForXValue(f6);
        if (entriesForXValue.size() == 0 && (entryForXValue = iDataSet.getEntryForXValue(f6, Float.NaN, rounding)) != null) {
            entriesForXValue = iDataSet.getEntriesForXValue(entryForXValue.getX());
        }
        if (entriesForXValue.size() != 0) {
            for (Entry entry : entriesForXValue) {
                MPPointD pixelForValues = this.mChart.getTransformer(iDataSet.getAxisDependency()).getPixelForValues(entry.getX(), entry.getY());
                arrayList.add(new Highlight(entry.getX(), entry.getY(), (float) pixelForValues.f32563x, (float) pixelForValues.f32564y, i6, iDataSet.getAxisDependency()));
            }
        }
        return arrayList;
    }

    protected BarLineScatterCandleBubbleData getData() {
        return this.mChart.getData();
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [com.github.mikephil.charting.interfaces.datasets.IDataSet] */
    protected List<Highlight> getHighlightsAtXValue(float f6, float f7, float f8) {
        this.mHighlightBuffer.clear();
        BarLineScatterCandleBubbleData data = getData();
        if (data == null) {
            return this.mHighlightBuffer;
        }
        int dataSetCount = data.getDataSetCount();
        for (int i6 = 0; i6 < dataSetCount; i6++) {
            ?? dataSetByIndex = data.getDataSetByIndex(i6);
            if (dataSetByIndex.isHighlightEnabled()) {
                this.mHighlightBuffer.addAll(buildHighlights(dataSetByIndex, i6, f6, DataSet.Rounding.CLOSEST));
            }
        }
        return this.mHighlightBuffer;
    }

    protected MPPointD getValsForTouch(float f6, float f7) {
        return this.mChart.getTransformer(YAxis.AxisDependency.LEFT).getValuesByTouchPoint(f6, f7);
    }

    public ChartHighlighter(T t5) {
        this.mChart = t5;
    }

    @Override // com.github.mikephil.charting.highlight.IHighlighter
    public Highlight getHighlight(float f6, float f7) {
        MPPointD valsForTouch = getValsForTouch(f6, f7);
        float f8 = (float) valsForTouch.f32563x;
        MPPointD.recycleInstance(valsForTouch);
        return getHighlightForX(f8, f6, f7);
    }

    protected Highlight getHighlightForX(float f6, float f7, float f8) {
        YAxis.AxisDependency axisDependency;
        List<Highlight> highlightsAtXValue = getHighlightsAtXValue(f6, f7, f8);
        if (highlightsAtXValue.isEmpty()) {
            return null;
        }
        YAxis.AxisDependency axisDependency2 = YAxis.AxisDependency.LEFT;
        float minimumDistance = getMinimumDistance(highlightsAtXValue, f8, axisDependency2);
        YAxis.AxisDependency axisDependency3 = YAxis.AxisDependency.RIGHT;
        if (minimumDistance < getMinimumDistance(highlightsAtXValue, f8, axisDependency3)) {
            axisDependency = axisDependency2;
        } else {
            axisDependency = axisDependency3;
        }
        return getClosestHighlightByPixel(highlightsAtXValue, f7, f8, axisDependency, this.mChart.getMaxHighlightDistance());
    }

    protected float getHighlightPos(Highlight highlight) {
        return highlight.getYPx();
    }

    protected float getMinimumDistance(List<Highlight> list, float f6, YAxis.AxisDependency axisDependency) {
        float f7 = Float.MAX_VALUE;
        for (int i6 = 0; i6 < list.size(); i6++) {
            Highlight highlight = list.get(i6);
            if (highlight.getAxis() == axisDependency) {
                float abs = Math.abs(getHighlightPos(highlight) - f6);
                if (abs < f7) {
                    f7 = abs;
                }
            }
        }
        return f7;
    }
}
