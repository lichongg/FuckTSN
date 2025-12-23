package com.huawei.hms.scankit.p;

import com.huawei.hms.ml.scan.HmsScan;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class n4 extends t6 {

    /* renamed from: b, reason: collision with root package name */
    private static final Pattern f34593b = Pattern.compile("geo:([\\s\\-0-9.]+),([\\s\\-0-9.]+)(?:[,?].*)?", 2);

    @Override // com.huawei.hms.scankit.p.t6
    public HmsScan b(s6 s6Var) {
        String a6 = t6.a(s6Var);
        Matcher matcher = f34593b.matcher(a6);
        if (!matcher.matches()) {
            return null;
        }
        try {
            return new HmsScan(s6Var.k(), t6.a(s6Var.c()), a6, HmsScan.LOCATION_COORDINATE_FORM, s6Var.i(), t6.a(s6Var.j()), null, new z6(new HmsScan.LocationCoordinate(Double.parseDouble(matcher.group(1)), Double.parseDouble(matcher.group(2)))));
        } catch (NumberFormatException unused) {
            return null;
        }
    }
}
