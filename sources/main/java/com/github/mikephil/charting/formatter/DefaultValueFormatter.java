package com.github.mikephil.charting.formatter;

import java.text.DecimalFormat;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public class DefaultValueFormatter extends ValueFormatter {
    protected int mDecimalDigits;
    protected DecimalFormat mFormat;

    public int getDecimalDigits() {
        return this.mDecimalDigits;
    }

    @Override // com.github.mikephil.charting.formatter.ValueFormatter
    public String getFormattedValue(float f6) {
        return this.mFormat.format(f6);
    }

    public void setup(int i6) {
        this.mDecimalDigits = i6;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i7 = 0; i7 < i6; i7++) {
            if (i7 == 0) {
                stringBuffer.append(".");
            }
            stringBuffer.append("0");
        }
        this.mFormat = new DecimalFormat("###,###,###,##0" + stringBuffer.toString());
    }

    public DefaultValueFormatter(int i6) {
        setup(i6);
    }
}
