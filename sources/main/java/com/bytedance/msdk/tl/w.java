package com.bytedance.msdk.tl;

/* loaded from: D:\Downloads\app\classes3.dex */
public class w {
    public static String j(int[] iArr) {
        if (iArr == null || iArr.length == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i6 = 0; i6 < iArr.length; i6++) {
            sb.append(iArr[i6]);
            if (i6 != iArr.length - 1) {
                sb.append(",");
            }
        }
        return sb.toString();
    }
}
