package com.bytedance.msdk.core.xt;

import org.json.JSONArray;

/* loaded from: D:\Downloads\app\classes3.dex */
public class up {
    private final int[] cw;

    /* renamed from: j, reason: collision with root package name */
    private final String f24829j;
    private final float[] xt;

    public int j(float f6) {
        int[] iArr;
        int i6;
        float[] fArr = this.xt;
        int i7 = -1;
        if (fArr != null && fArr.length != 0 && (iArr = this.cw) != null && iArr.length != 0) {
            int length = fArr.length;
            int i8 = 0;
            while (true) {
                if (i8 >= length) {
                    break;
                }
                float[] fArr2 = this.xt;
                float f7 = fArr2[i8];
                if (f6 <= f7 || (i6 = i8 + 1) >= length || f6 > fArr2[i6]) {
                    if (i8 == length - 1 && f6 > f7) {
                        i7 = this.cw[i8];
                    }
                    i8++;
                } else {
                    int[] iArr2 = this.cw;
                    if (i8 < iArr2.length) {
                        return iArr2[i8];
                    }
                }
            }
        }
        return i7;
    }

    public up(String str, JSONArray jSONArray, JSONArray jSONArray2) {
        this.f24829j = str;
        this.xt = new float[jSONArray.length()];
        this.cw = new int[jSONArray2.length()];
        for (int i6 = 0; i6 < jSONArray.length(); i6++) {
            this.xt[i6] = (float) jSONArray.optDouble(i6);
        }
        for (int i7 = 0; i7 < jSONArray2.length(); i7++) {
            this.cw[i7] = jSONArray2.optInt(i7);
        }
    }
}
