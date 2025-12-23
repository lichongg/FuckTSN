package com.bytedance.sdk.component.cw.xt;

import java.nio.charset.Charset;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: D:\Downloads\app\classes4.dex */
public final class tj {

    /* renamed from: j, reason: collision with root package name */
    private static final Pattern f26368j = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");
    private static final Pattern xt = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");
    private final String cw;

    /* renamed from: m, reason: collision with root package name */
    private final String f26369m;

    /* renamed from: r, reason: collision with root package name */
    private final String f26370r;
    private final String up;

    public static tj j(String str) {
        Matcher matcher = f26368j.matcher(str);
        if (!matcher.lookingAt()) {
            return null;
        }
        String group = matcher.group(1);
        Locale locale = Locale.US;
        String lowerCase = group.toLowerCase(locale);
        String lowerCase2 = matcher.group(2).toLowerCase(locale);
        Matcher matcher2 = xt.matcher(str);
        String str2 = null;
        for (int end = matcher.end(); end < str.length(); end = matcher2.end()) {
            matcher2.region(end, str.length());
            if (!matcher2.lookingAt()) {
                return null;
            }
            String group2 = matcher2.group(1);
            if (group2 != null && group2.equalsIgnoreCase("charset")) {
                String group3 = matcher2.group(2);
                if (group3 == null) {
                    group3 = matcher2.group(3);
                } else if (group3.startsWith("'") && group3.endsWith("'") && group3.length() > 2) {
                    group3 = group3.substring(1, group3.length() - 1);
                }
                if (str2 != null && !group3.equalsIgnoreCase(str2)) {
                    return null;
                }
                str2 = group3;
            }
        }
        return new tj(str, lowerCase, lowerCase2, str2);
    }

    public Charset cw() {
        return j((Charset) null);
    }

    public boolean equals(Object obj) {
        return (obj instanceof tj) && ((tj) obj).cw.equals(this.cw);
    }

    public int hashCode() {
        return this.cw.hashCode();
    }

    public String toString() {
        return this.cw;
    }

    public String xt() {
        return this.up;
    }

    private tj(String str, String str2, String str3, String str4) {
        this.cw = str;
        this.f26370r = str2;
        this.up = str3;
        this.f26369m = str4;
    }

    public String j() {
        return this.f26370r;
    }

    public Charset j(Charset charset) {
        try {
            String str = this.f26369m;
            return str != null ? Charset.forName(str) : charset;
        } catch (IllegalArgumentException unused) {
            return charset;
        }
    }
}
