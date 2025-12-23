package com.huawei.hms.scankit.p;

import android.text.TextUtils;
import com.huawei.hms.ml.scan.HmsScan;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class u7 extends t6 {

    /* renamed from: b, reason: collision with root package name */
    private static final Pattern f34880b = Pattern.compile("(?:uri|url):([\\s\\S]*)", 2);

    /* renamed from: c, reason: collision with root package name */
    private static final Pattern f34881c = Pattern.compile("(?:http:/?(?!/)|http//)([\\s\\S]+)", 2);

    @Override // com.huawei.hms.scankit.p.t6
    public HmsScan b(s6 s6Var) {
        String a6 = t6.a(s6Var);
        if (TextUtils.isEmpty(a6) || !f34880b.matcher(a6).matches()) {
            return null;
        }
        String substring = a6.substring(4);
        Matcher matcher = f34881c.matcher(substring);
        if (matcher.matches()) {
            substring = substring.substring(0, 4) + "://" + matcher.group(1);
        }
        return new HmsScan(s6Var.k(), t6.a(s6Var.c()), t6.a(substring), HmsScan.URL_FORM, s6Var.i(), t6.a(s6Var.j()), null, new z6(new HmsScan.LinkUrl("", "")));
    }
}
