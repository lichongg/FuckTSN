package com.github.mikephil.charting.data;

import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IPieDataSet;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public class PieData extends ChartData<IPieDataSet> {
    public PieData() {
    }

    public float getYValueSum() {
        float f6 = 0.0f;
        for (int i6 = 0; i6 < getDataSet().getEntryCount(); i6++) {
            f6 += getDataSet().getEntryForIndex(i6).getY();
        }
        return f6;
    }

    public PieData(IPieDataSet iPieDataSet) {
        super(iPieDataSet);
    }

    public IPieDataSet getDataSet() {
        return (IPieDataSet) this.mDataSets.get(0);
    }

    @Override // com.github.mikephil.charting.data.ChartData
    public IPieDataSet getDataSetByIndex(int i6) {
        if (i6 == 0) {
            return getDataSet();
        }
        return null;
    }

    @Override // com.github.mikephil.charting.data.ChartData
    public IPieDataSet getDataSetByLabel(String str, boolean z5) {
        if (z5) {
            if (str.equalsIgnoreCase(((IPieDataSet) this.mDataSets.get(0)).getLabel())) {
                return (IPieDataSet) this.mDataSets.get(0);
            }
            return null;
        }
        if (str.equals(((IPieDataSet) this.mDataSets.get(0)).getLabel())) {
            return (IPieDataSet) this.mDataSets.get(0);
        }
        return null;
    }

    public void setDataSet(IPieDataSet iPieDataSet) {
        this.mDataSets.clear();
        this.mDataSets.add(iPieDataSet);
        notifyDataChanged();
    }

    @Override // com.github.mikephil.charting.data.ChartData
    public Entry getEntryForHighlight(Highlight highlight) {
        return getDataSet().getEntryForIndex((int) highlight.getX());
    }
}
