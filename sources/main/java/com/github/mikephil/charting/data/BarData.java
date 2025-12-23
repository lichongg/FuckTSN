package com.github.mikephil.charting.data;

import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public class BarData extends BarLineScatterCandleBubbleData<IBarDataSet> {
    private float mBarWidth;

    public BarData() {
        this.mBarWidth = 0.85f;
    }

    public float getBarWidth() {
        return this.mBarWidth;
    }

    public float getGroupWidth(float f6, float f7) {
        return (this.mDataSets.size() * (this.mBarWidth + f7)) + f6;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void groupBars(float f6, float f7, float f8) {
        BarEntry barEntry;
        if (this.mDataSets.size() <= 1) {
            throw new RuntimeException("BarData needs to hold at least 2 BarDataSets to allow grouping.");
        }
        int entryCount = ((IBarDataSet) getMaxEntryCountSet()).getEntryCount();
        float f9 = f7 / 2.0f;
        float f10 = f8 / 2.0f;
        float f11 = this.mBarWidth / 2.0f;
        float groupWidth = getGroupWidth(f7, f8);
        for (int i6 = 0; i6 < entryCount; i6++) {
            float f12 = f6 + f9;
            for (T t5 : this.mDataSets) {
                float f13 = f12 + f10 + f11;
                if (i6 < t5.getEntryCount() && (barEntry = (BarEntry) t5.getEntryForIndex(i6)) != null) {
                    barEntry.setX(f13);
                }
                f12 = f13 + f11 + f10;
            }
            float f14 = f12 + f9;
            float f15 = groupWidth - (f14 - f6);
            if (f15 > 0.0f || f15 < 0.0f) {
                f14 += f15;
            }
            f6 = f14;
        }
        notifyDataChanged();
    }

    public void setBarWidth(float f6) {
        this.mBarWidth = f6;
    }

    public BarData(IBarDataSet... iBarDataSetArr) {
        super(iBarDataSetArr);
        this.mBarWidth = 0.85f;
    }

    public BarData(List<IBarDataSet> list) {
        super(list);
        this.mBarWidth = 0.85f;
    }
}
