package com.github.mikephil.charting.formatter;

import java.util.Collection;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public class IndexAxisValueFormatter extends ValueFormatter {
    private int mValueCount;
    private String[] mValues;

    public IndexAxisValueFormatter() {
        this.mValues = new String[0];
        this.mValueCount = 0;
    }

    public String[] getValues() {
        return this.mValues;
    }

    public void setValues(String[] strArr) {
        if (strArr == null) {
            strArr = new String[0];
        }
        this.mValues = strArr;
        this.mValueCount = strArr.length;
    }

    @Override // com.github.mikephil.charting.formatter.ValueFormatter
    public String getFormattedValue(float f6) {
        int round = Math.round(f6);
        if (round >= 0 && round < this.mValueCount && round == ((int) f6)) {
            return this.mValues[round];
        }
        return "";
    }

    public IndexAxisValueFormatter(String[] strArr) {
        this.mValues = new String[0];
        this.mValueCount = 0;
        if (strArr != null) {
            setValues(strArr);
        }
    }

    public IndexAxisValueFormatter(Collection<String> collection) {
        this.mValues = new String[0];
        this.mValueCount = 0;
        if (collection != null) {
            setValues((String[]) collection.toArray(new String[collection.size()]));
        }
    }
}
