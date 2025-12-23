package com.github.mikephil.charting.data;

import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IRadarDataSet;
import java.util.Arrays;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public class RadarData extends ChartData<IRadarDataSet> {
    private List<String> mLabels;

    public RadarData() {
    }

    public void setLabels(List<String> list) {
        this.mLabels = list;
    }

    public RadarData(List<IRadarDataSet> list) {
        super(list);
    }

    public List<String> getLabels() {
        return this.mLabels;
    }

    public void setLabels(String... strArr) {
        this.mLabels = Arrays.asList(strArr);
    }

    public RadarData(IRadarDataSet... iRadarDataSetArr) {
        super(iRadarDataSetArr);
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [com.github.mikephil.charting.data.Entry] */
    @Override // com.github.mikephil.charting.data.ChartData
    public Entry getEntryForHighlight(Highlight highlight) {
        return getDataSetByIndex(highlight.getDataSetIndex()).getEntryForIndex((int) highlight.getX());
    }
}
