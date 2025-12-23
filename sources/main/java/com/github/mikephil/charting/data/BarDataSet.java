package com.github.mikephil.charting.data;

import android.graphics.Color;
import androidx.core.view.ViewCompat;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public class BarDataSet extends BarLineScatterCandleBubbleDataSet<BarEntry> implements IBarDataSet {
    private int mBarBorderColor;
    private float mBarBorderWidth;
    private int mBarShadowColor;
    private int mEntryCountStacks;
    private int mHighLightAlpha;
    private String[] mStackLabels;
    private int mStackSize;

    private void calcEntryCountIncludingStacks(List<BarEntry> list) {
        this.mEntryCountStacks = 0;
        for (int i6 = 0; i6 < list.size(); i6++) {
            float[] yVals = list.get(i6).getYVals();
            if (yVals == null) {
                this.mEntryCountStacks++;
            } else {
                this.mEntryCountStacks += yVals.length;
            }
        }
    }

    private void calcStackSize(List<BarEntry> list) {
        for (int i6 = 0; i6 < list.size(); i6++) {
            float[] yVals = list.get(i6).getYVals();
            if (yVals != null && yVals.length > this.mStackSize) {
                this.mStackSize = yVals.length;
            }
        }
    }

    @Override // com.github.mikephil.charting.data.DataSet
    public DataSet<BarEntry> copy() {
        ArrayList arrayList = new ArrayList();
        for (int i6 = 0; i6 < this.mValues.size(); i6++) {
            arrayList.add(((BarEntry) this.mValues.get(i6)).copy());
        }
        BarDataSet barDataSet = new BarDataSet(arrayList, getLabel());
        copy(barDataSet);
        return barDataSet;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.github.mikephil.charting.data.DataSet
    public void calcMinMax(BarEntry barEntry) {
        if (barEntry == null || Float.isNaN(barEntry.getY())) {
            return;
        }
        if (barEntry.getYVals() == null) {
            if (barEntry.getY() < this.mYMin) {
                this.mYMin = barEntry.getY();
            }
            if (barEntry.getY() > this.mYMax) {
                this.mYMax = barEntry.getY();
            }
        } else {
            if ((-barEntry.getNegativeSum()) < this.mYMin) {
                this.mYMin = -barEntry.getNegativeSum();
            }
            if (barEntry.getPositiveSum() > this.mYMax) {
                this.mYMax = barEntry.getPositiveSum();
            }
        }
        calcMinMaxX(barEntry);
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IBarDataSet
    public int getBarBorderColor() {
        return this.mBarBorderColor;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IBarDataSet
    public float getBarBorderWidth() {
        return this.mBarBorderWidth;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IBarDataSet
    public int getBarShadowColor() {
        return this.mBarShadowColor;
    }

    public int getEntryCountStacks() {
        return this.mEntryCountStacks;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IBarDataSet
    public int getHighLightAlpha() {
        return this.mHighLightAlpha;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IBarDataSet
    public String[] getStackLabels() {
        return this.mStackLabels;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IBarDataSet
    public int getStackSize() {
        return this.mStackSize;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IBarDataSet
    public boolean isStacked() {
        return this.mStackSize > 1;
    }

    public void setBarBorderColor(int i6) {
        this.mBarBorderColor = i6;
    }

    public void setBarBorderWidth(float f6) {
        this.mBarBorderWidth = f6;
    }

    public void setBarShadowColor(int i6) {
        this.mBarShadowColor = i6;
    }

    public void setHighLightAlpha(int i6) {
        this.mHighLightAlpha = i6;
    }

    public void setStackLabels(String[] strArr) {
        this.mStackLabels = strArr;
    }

    public BarDataSet(List<BarEntry> list, String str) {
        super(list, str);
        this.mStackSize = 1;
        this.mBarShadowColor = Color.rgb(215, 215, 215);
        this.mBarBorderWidth = 0.0f;
        this.mBarBorderColor = ViewCompat.MEASURED_STATE_MASK;
        this.mHighLightAlpha = 120;
        this.mEntryCountStacks = 0;
        this.mStackLabels = new String[]{"Stack"};
        this.mHighLightColor = Color.rgb(0, 0, 0);
        calcStackSize(list);
        calcEntryCountIncludingStacks(list);
    }

    protected void copy(BarDataSet barDataSet) {
        super.copy((BarLineScatterCandleBubbleDataSet) barDataSet);
        barDataSet.mStackSize = this.mStackSize;
        barDataSet.mBarShadowColor = this.mBarShadowColor;
        barDataSet.mBarBorderWidth = this.mBarBorderWidth;
        barDataSet.mStackLabels = this.mStackLabels;
        barDataSet.mHighLightAlpha = this.mHighLightAlpha;
    }
}
