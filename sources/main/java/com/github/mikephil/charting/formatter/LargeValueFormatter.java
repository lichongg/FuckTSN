package com.github.mikephil.charting.formatter;

import com.kuaishou.weapon.p0.t;
import com.umeng.analytics.pro.bi;
import java.text.DecimalFormat;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public class LargeValueFormatter extends ValueFormatter {
    private DecimalFormat mFormat;
    private int mMaxLength;
    private String[] mSuffix;
    private String mText;

    public LargeValueFormatter() {
        this.mSuffix = new String[]{"", "k", t.f36152m, "b", bi.aL};
        this.mMaxLength = 5;
        this.mText = "";
        this.mFormat = new DecimalFormat("###E00");
    }

    public int getDecimalDigits() {
        return 0;
    }

    private String makePretty(double d6) {
        String format = this.mFormat.format(d6);
        int numericValue = Character.getNumericValue(format.charAt(format.length() - 1));
        String replaceAll = format.replaceAll("E[0-9][0-9]", this.mSuffix[Integer.valueOf(Character.getNumericValue(format.charAt(format.length() - 2)) + "" + numericValue).intValue() / 3]);
        while (true) {
            if (replaceAll.length() <= this.mMaxLength && !replaceAll.matches("[0-9]+\\.[a-z]")) {
                return replaceAll;
            }
            replaceAll = replaceAll.substring(0, replaceAll.length() - 2) + replaceAll.substring(replaceAll.length() - 1);
        }
    }

    @Override // com.github.mikephil.charting.formatter.ValueFormatter
    public String getFormattedValue(float f6) {
        return makePretty(f6) + this.mText;
    }

    public void setAppendix(String str) {
        this.mText = str;
    }

    public void setMaxLength(int i6) {
        this.mMaxLength = i6;
    }

    public void setSuffix(String[] strArr) {
        this.mSuffix = strArr;
    }

    public LargeValueFormatter(String str) {
        this();
        this.mText = str;
    }
}
