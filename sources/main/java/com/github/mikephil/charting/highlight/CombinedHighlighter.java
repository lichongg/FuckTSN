package com.github.mikephil.charting.highlight;

import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarLineScatterCandleBubbleData;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider;
import com.github.mikephil.charting.interfaces.dataprovider.CombinedDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public class CombinedHighlighter extends ChartHighlighter<CombinedDataProvider> implements IHighlighter {
    protected BarHighlighter barHighlighter;

    @Override // com.github.mikephil.charting.highlight.ChartHighlighter
    protected List<Highlight> getHighlightsAtXValue(float f6, float f7, float f8) {
        this.mHighlightBuffer.clear();
        List<BarLineScatterCandleBubbleData> allData = ((CombinedDataProvider) this.mChart).getCombinedData().getAllData();
        for (int i6 = 0; i6 < allData.size(); i6++) {
            BarLineScatterCandleBubbleData barLineScatterCandleBubbleData = allData.get(i6);
            BarHighlighter barHighlighter = this.barHighlighter;
            if (barHighlighter == null || !(barLineScatterCandleBubbleData instanceof BarData)) {
                int dataSetCount = barLineScatterCandleBubbleData.getDataSetCount();
                for (int i7 = 0; i7 < dataSetCount; i7++) {
                    IDataSet dataSetByIndex = allData.get(i6).getDataSetByIndex(i7);
                    if (dataSetByIndex.isHighlightEnabled()) {
                        for (Highlight highlight : buildHighlights(dataSetByIndex, i7, f6, DataSet.Rounding.CLOSEST)) {
                            highlight.setDataIndex(i6);
                            this.mHighlightBuffer.add(highlight);
                        }
                    }
                }
            } else {
                Highlight highlight2 = barHighlighter.getHighlight(f7, f8);
                if (highlight2 != null) {
                    highlight2.setDataIndex(i6);
                    this.mHighlightBuffer.add(highlight2);
                }
            }
        }
        return this.mHighlightBuffer;
    }

    public CombinedHighlighter(CombinedDataProvider combinedDataProvider, BarDataProvider barDataProvider) {
        super(combinedDataProvider);
        BarHighlighter barHighlighter;
        if (barDataProvider.getBarData() == null) {
            barHighlighter = null;
        } else {
            barHighlighter = new BarHighlighter(barDataProvider);
        }
        this.barHighlighter = barHighlighter;
    }
}
