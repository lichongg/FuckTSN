package com.huawei.hms.scankit.p;

import android.text.TextUtils;
import com.huawei.hms.ml.scan.HmsScan;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class z extends t6 {

    /* renamed from: b, reason: collision with root package name */
    private static final Pattern f35056b = Pattern.compile("(?:MEBKM:)([\\s\\S]+)", 2);

    /* renamed from: c, reason: collision with root package name */
    private static final Pattern f35057c = Pattern.compile("(?:http:/?(?!/)|http//)([\\s\\S]+)", 2);

    private static String a(String[] strArr, String str) {
        for (String str2 : strArr) {
            if (str2.startsWith(str)) {
                return t6.b(str2.substring(str.length()));
            }
        }
        return "";
    }

    @Override // com.huawei.hms.scankit.p.t6
    public HmsScan b(s6 s6Var) {
        String a6 = t6.a(s6Var);
        if (TextUtils.isEmpty(a6)) {
            return null;
        }
        Matcher matcher = f35056b.matcher(a6);
        if (!matcher.matches()) {
            return null;
        }
        String[] split = matcher.group(1).split("(?<=(?<!\\\\)(?:\\\\\\\\){0,100});");
        String a7 = a(split, "TITLE:");
        String a8 = t6.a(a(split, "URL:"));
        if (a8.length() == 0) {
            return null;
        }
        Matcher matcher2 = f35057c.matcher(a8);
        if (matcher2.matches()) {
            a8 = a8.substring(0, 4) + "://" + matcher2.group(1);
        }
        String str = a8;
        return new HmsScan(s6Var.k(), t6.a(s6Var.c()), str, HmsScan.URL_FORM, s6Var.i(), t6.a(s6Var.j()), null, new z6(new HmsScan.LinkUrl(a7, str)));
    }
}
