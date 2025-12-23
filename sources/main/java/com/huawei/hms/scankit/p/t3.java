package com.huawei.hms.scankit.p;

import com.huawei.hms.ml.scan.HmsScan;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class t3 extends t6 {

    /* renamed from: b, reason: collision with root package name */
    private static final Pattern f34829b = Pattern.compile("(?:http:|http//|https://)([\\s\\S]+)", 2);

    /* renamed from: c, reason: collision with root package name */
    private static final Pattern f34830c = Pattern.compile("(?:http:/?(?!/)|http//)([\\s\\S]+)", 2);

    @Override // com.huawei.hms.scankit.p.t6
    public HmsScan b(s6 s6Var) {
        String a6 = t6.a(s6Var);
        if (!f34829b.matcher(a6).matches()) {
            return null;
        }
        Matcher matcher = f34830c.matcher(a6);
        if (matcher.matches()) {
            a6 = a6.substring(0, 4) + "://" + matcher.group(1);
        }
        String a7 = t6.a(a6);
        if (a7.length() == 7) {
            return null;
        }
        return new HmsScan(s6Var.k(), t6.a(s6Var.c()), a7, HmsScan.URL_FORM, s6Var.i(), t6.a(s6Var.j()), null, new z6(new HmsScan.LinkUrl("", a7)));
    }
}
