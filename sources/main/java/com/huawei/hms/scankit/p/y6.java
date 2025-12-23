package com.huawei.hms.scankit.p;

import com.huawei.hms.ml.scan.HmsScan;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class y6 {
    public static HmsScan a(s6 s6Var) {
        HmsScan a6;
        if (s6Var == null) {
            return null;
        }
        return (!r3.f34735f || (a6 = v5.a(s6Var)) == null) ? new HmsScan(s6Var.k(), t6.a(s6Var.c()), s6Var.k(), HmsScan.PURE_TEXT_FORM, s6Var.i(), t6.a(s6Var.j()), null, null).setZoomValue(s6Var.l()) : a6;
    }

    public static HmsScan[] a(s6[] s6VarArr) {
        if (s6VarArr != null && s6VarArr.length > 0) {
            HmsScan[] hmsScanArr = new HmsScan[s6VarArr.length];
            for (int i6 = 0; i6 < s6VarArr.length; i6++) {
                hmsScanArr[i6] = a(s6VarArr[i6]);
            }
            return hmsScanArr;
        }
        return new HmsScan[0];
    }
}
