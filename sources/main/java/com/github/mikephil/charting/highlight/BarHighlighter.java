package com.github.mikephil.charting.highlight;

import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.BarLineScatterCandleBubbleData;
import com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.MPPointD;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public class BarHighlighter extends ChartHighlighter<BarDataProvider> {
    protected int getClosestStackIndex(Range[] rangeArr, float f6) {
        if (rangeArr != null && rangeArr.length != 0) {
            int i6 = 0;
            for (Range range : rangeArr) {
                if (range.contains(f6)) {
                    return i6;
                }
                i6++;
            }
            int max = Math.max(rangeArr.length - 1, 0);
            if (f6 > rangeArr[max].to) {
                return max;
            }
        }
        return 0;
    }

    @Override // com.github.mikephil.charting.highlight.ChartHighlighter
    protected float getDistance(float f6, float f7, float f8, float f9) {
        return Math.abs(f6 - f8);
    }

    @Override // com.github.mikephil.charting.highlight.ChartHighlighter
    protected BarLineScatterCandleBubbleData getData() {
        return ((BarDataProvider) this.mChart).getBarData();
    }

    public BarHighlighter(BarDataProvider barDataProvider) {
        super(barDataProvider);
    }

    @Override // com.github.mikephil.charting.highlight.ChartHighlighter, com.github.mikephil.charting.highlight.IHighlighter
    public Highlight getHighlight(float f6, float f7) {
        Highlight highlight = super.getHighlight(f6, f7);
        if (highlight == null) {
            return null;
        }
        MPPointD valsForTouch = getValsForTouch(f6, f7);
        IBarDataSet iBarDataSet = (IBarDataSet) ((BarDataProvider) this.mChart).getBarData().getDataSetByIndex(highlight.getDataSetIndex());
        if (iBarDataSet.isStacked()) {
            return getStackedHighlight(highlight, iBarDataSet, (float) valsForTouch.f32563x, (float) valsForTouch.f32564y);
        }
        MPPointD.recycleInstance(valsForTouch);
        return highlight;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Highlight getStackedHighlight(Highlight highlight, IBarDataSet iBarDataSet, float f6, float f7) {
        BarEntry barEntry = (BarEntry) iBarDataSet.getEntryForXValue(f6, f7);
        if (barEntry == null) {
            return null;
        }
        if (barEntry.getYVals() == null) {
            return highlight;
        }
        Range[] ranges = barEntry.getRanges();
        if (ranges.length <= 0) {
            return null;
        }
        int closestStackIndex = getClosestStackIndex(ranges, f7);
        MPPointD pixelForValues = ((BarDataProvider) this.mChart).getTransformer(iBarDataSet.getAxisDependency()).getPixelForValues(highlight.getX(), ranges[closestStackIndex].to);
        Highlight highlight2 = new Highlight(barEntry.getX(), barEntry.getY(), (float) pixelForValues.f32563x, (float) pixelForValues.f32564y, highlight.getDataSetIndex(), closestStackIndex, highlight.getAxis());
        MPPointD.recycleInstance(pixelForValues);
        return highlight2;
    }
}
