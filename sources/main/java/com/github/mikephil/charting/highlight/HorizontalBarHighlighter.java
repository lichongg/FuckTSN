package com.github.mikephil.charting.highlight;

import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.utils.MPPointD;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public class HorizontalBarHighlighter extends BarHighlighter {
    @Override // com.github.mikephil.charting.highlight.BarHighlighter, com.github.mikephil.charting.highlight.ChartHighlighter
    protected float getDistance(float f6, float f7, float f8, float f9) {
        return Math.abs(f7 - f9);
    }

    @Override // com.github.mikephil.charting.highlight.ChartHighlighter
    protected List<Highlight> buildHighlights(IDataSet iDataSet, int i6, float f6, DataSet.Rounding rounding) {
        Entry entryForXValue;
        ArrayList arrayList = new ArrayList();
        List<Entry> entriesForXValue = iDataSet.getEntriesForXValue(f6);
        if (entriesForXValue.size() == 0 && (entryForXValue = iDataSet.getEntryForXValue(f6, Float.NaN, rounding)) != null) {
            entriesForXValue = iDataSet.getEntriesForXValue(entryForXValue.getX());
        }
        if (entriesForXValue.size() != 0) {
            for (Entry entry : entriesForXValue) {
                MPPointD pixelForValues = ((BarDataProvider) this.mChart).getTransformer(iDataSet.getAxisDependency()).getPixelForValues(entry.getY(), entry.getX());
                arrayList.add(new Highlight(entry.getX(), entry.getY(), (float) pixelForValues.f32563x, (float) pixelForValues.f32564y, i6, iDataSet.getAxisDependency()));
            }
        }
        return arrayList;
    }

    @Override // com.github.mikephil.charting.highlight.BarHighlighter, com.github.mikephil.charting.highlight.ChartHighlighter, com.github.mikephil.charting.highlight.IHighlighter
    public Highlight getHighlight(float f6, float f7) {
        BarData barData = ((BarDataProvider) this.mChart).getBarData();
        MPPointD valsForTouch = getValsForTouch(f7, f6);
        Highlight highlightForX = getHighlightForX((float) valsForTouch.f32564y, f7, f6);
        if (highlightForX == null) {
            return null;
        }
        IBarDataSet iBarDataSet = (IBarDataSet) barData.getDataSetByIndex(highlightForX.getDataSetIndex());
        if (iBarDataSet.isStacked()) {
            return getStackedHighlight(highlightForX, iBarDataSet, (float) valsForTouch.f32564y, (float) valsForTouch.f32563x);
        }
        MPPointD.recycleInstance(valsForTouch);
        return highlightForX;
    }

    public HorizontalBarHighlighter(BarDataProvider barDataProvider) {
        super(barDataProvider);
    }
}
