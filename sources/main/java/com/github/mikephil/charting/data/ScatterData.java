package com.github.mikephil.charting.data;

import com.github.mikephil.charting.interfaces.datasets.IScatterDataSet;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public class ScatterData extends BarLineScatterCandleBubbleData<IScatterDataSet> {
    public ScatterData() {
    }

    public ScatterData(List<IScatterDataSet> list) {
        super(list);
    }

    public float getGreatestShapeSize() {
        Iterator it = this.mDataSets.iterator();
        float f6 = 0.0f;
        while (it.hasNext()) {
            float scatterShapeSize = ((IScatterDataSet) it.next()).getScatterShapeSize();
            if (scatterShapeSize > f6) {
                f6 = scatterShapeSize;
            }
        }
        return f6;
    }

    public ScatterData(IScatterDataSet... iScatterDataSetArr) {
        super(iScatterDataSetArr);
    }
}
