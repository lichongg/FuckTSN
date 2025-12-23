package com.huawei.hms.scankit.p;

import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.ml.scan.HmsScanBase;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class g6 extends t6 {

    /* renamed from: b, reason: collision with root package name */
    private static final Pattern f34312b = Pattern.compile("\\d+");

    protected static boolean a(CharSequence charSequence, int i6) {
        return charSequence != null && i6 > 0 && i6 == charSequence.length() && f34312b.matcher(charSequence).matches();
    }

    @Override // com.huawei.hms.scankit.p.t6
    public HmsScan b(s6 s6Var) {
        int a6 = t6.a(s6Var.c());
        if (a6 != HmsScanBase.EAN13_SCAN_TYPE && a6 != HmsScanBase.EAN8_SCAN_TYPE && a6 != HmsScanBase.UPCCODE_A_SCAN_TYPE && a6 != HmsScanBase.UPCCODE_E_SCAN_TYPE) {
            return null;
        }
        String a7 = t6.a(s6Var);
        if (!a(a7, a7.length())) {
            return null;
        }
        return new HmsScan(a7, t6.a(s6Var.c()), a7, HmsScan.ARTICLE_NUMBER_FORM, s6Var.i(), t6.a(s6Var.j()), null, null);
    }
}
