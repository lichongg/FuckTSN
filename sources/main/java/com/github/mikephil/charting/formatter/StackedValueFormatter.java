package com.github.mikephil.charting.formatter;

import com.github.mikephil.charting.data.BarEntry;
import java.text.DecimalFormat;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public class StackedValueFormatter extends ValueFormatter {
    private boolean mDrawWholeStack;
    private DecimalFormat mFormat;
    private String mSuffix;

    @Override // com.github.mikephil.charting.formatter.ValueFormatter
    public String getBarStackedLabel(float f6, BarEntry barEntry) {
        float[] yVals;
        if (this.mDrawWholeStack || (yVals = barEntry.getYVals()) == null) {
            return this.mFormat.format(f6) + this.mSuffix;
        }
        if (yVals[yVals.length - 1] != f6) {
            return "";
        }
        return this.mFormat.format(barEntry.getY()) + this.mSuffix;
    }

    public StackedValueFormatter(boolean z5, String str, int i6) {
        this.mDrawWholeStack = z5;
        this.mSuffix = str;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i7 = 0; i7 < i6; i7++) {
            if (i7 == 0) {
                stringBuffer.append(".");
            }
            stringBuffer.append("0");
        }
        this.mFormat = new DecimalFormat("###,###,###,##0" + stringBuffer.toString());
    }
}
