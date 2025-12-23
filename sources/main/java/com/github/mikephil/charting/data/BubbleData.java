package com.github.mikephil.charting.data;

import com.github.mikephil.charting.interfaces.datasets.IBubbleDataSet;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public class BubbleData extends BarLineScatterCandleBubbleData<IBubbleDataSet> {
    public BubbleData() {
    }

    public BubbleData(IBubbleDataSet... iBubbleDataSetArr) {
        super(iBubbleDataSetArr);
    }

    public void setHighlightCircleWidth(float f6) {
        Iterator it = this.mDataSets.iterator();
        while (it.hasNext()) {
            ((IBubbleDataSet) it.next()).setHighlightCircleWidth(f6);
        }
    }

    public BubbleData(List<IBubbleDataSet> list) {
        super(list);
    }
}
