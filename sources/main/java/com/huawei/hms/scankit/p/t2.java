package com.huawei.hms.scankit.p;

import android.text.TextUtils;
import com.huawei.hms.ml.scan.HmsScan;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class t2 extends t6 {

    /* renamed from: b, reason: collision with root package name */
    private static final Pattern f34825b = Pattern.compile("(?:MATMSG:TO:|mailto:|SMTP:)([\\s\\S]+)", 2);

    /* renamed from: c, reason: collision with root package name */
    private static final Pattern f34826c = Pattern.compile("mailto:([\\s\\S]+)\\?subject=([\\s\\S]+)&body=([\\s\\S]+)", 2);

    /* renamed from: d, reason: collision with root package name */
    private static final Pattern f34827d = Pattern.compile("MATMSG:TO:([\\s\\S]+);SUB:([\\s\\S]+);BODY:([\\s\\S]+)", 2);

    /* renamed from: e, reason: collision with root package name */
    private static final Pattern f34828e = Pattern.compile("SMTP:([\\s\\S]+):([\\s\\S]+):([\\s\\S]+)", 2);

    static String c(String str) {
        try {
            return URLDecoder.decode(str, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return str;
        }
    }

    @Override // com.huawei.hms.scankit.p.t6
    public HmsScan b(s6 s6Var) {
        Matcher matcher;
        Matcher matcher2;
        Matcher matcher3;
        String group;
        String str;
        String group2;
        String group3;
        String a6 = t6.a(s6Var);
        if (TextUtils.isEmpty(a6) || !f34825b.matcher(a6).matches()) {
            return null;
        }
        try {
            matcher = f34826c.matcher(a6);
            matcher2 = f34827d.matcher(a6);
            matcher3 = f34828e.matcher(a6);
        } catch (RuntimeException | Exception unused) {
        }
        if (matcher.matches()) {
            group3 = matcher.group(1);
            group = matcher.group(2);
            group2 = matcher.group(3);
        } else if (matcher2.matches()) {
            group3 = matcher2.group(1);
            String group4 = matcher2.group(2);
            String group5 = matcher2.group(3);
            group = group4;
            group2 = group5;
        } else {
            if (matcher3.matches()) {
                String group6 = matcher3.group(1);
                group = matcher3.group(2);
                str = group6;
                group2 = matcher3.group(3);
                return new HmsScan(s6Var.k(), t6.a(s6Var.c()), str, HmsScan.EMAIL_CONTENT_FORM, s6Var.i(), t6.a(s6Var.j()), null, new z6(new HmsScan.EmailContent(str, c(group), c(group2), HmsScan.EmailContent.OTHER_USE_TYPE)));
            }
            return null;
        }
        str = group3;
        return new HmsScan(s6Var.k(), t6.a(s6Var.c()), str, HmsScan.EMAIL_CONTENT_FORM, s6Var.i(), t6.a(s6Var.j()), null, new z6(new HmsScan.EmailContent(str, c(group), c(group2), HmsScan.EmailContent.OTHER_USE_TYPE)));
    }
}
