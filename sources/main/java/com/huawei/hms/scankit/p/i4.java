package com.huawei.hms.scankit.p;

import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.ml.scan.HmsScanBase;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class i4 extends t6 {
    @Override // com.huawei.hms.scankit.p.t6
    public HmsScan b(s6 s6Var) {
        if (t6.a(s6Var.c()) != HmsScanBase.EAN13_SCAN_TYPE) {
            return null;
        }
        String a6 = t6.a(s6Var);
        if (a6.length() != 13) {
            return null;
        }
        if (!a6.startsWith("978") && !a6.startsWith("979")) {
            return null;
        }
        return new HmsScan(s6Var.k(), t6.a(s6Var.c()), a6, HmsScan.ISBN_NUMBER_FORM, s6Var.i(), t6.a(s6Var.j()), null, null);
    }
}
