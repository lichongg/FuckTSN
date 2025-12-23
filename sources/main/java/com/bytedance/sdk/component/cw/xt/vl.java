package com.bytedance.sdk.component.cw.xt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okhttp3.internal.http.DateFormattingKt;

/* loaded from: D:\Downloads\app\classes4.dex */
public final class vl {
    private final long ae;

    /* renamed from: g, reason: collision with root package name */
    private final String f26407g;
    private final boolean jy;

    /* renamed from: m, reason: collision with root package name */
    private final String f26408m;
    private final boolean oq;
    private final boolean qv;
    private final String tl;
    private final String up;
    private final boolean vl;

    /* renamed from: j, reason: collision with root package name */
    private static final Pattern f26405j = Pattern.compile("(\\d{2,4})[^\\d]*");
    private static final Pattern xt = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");
    private static final Pattern cw = Pattern.compile("(\\d{1,2})[^\\d]*");

    /* renamed from: r, reason: collision with root package name */
    private static final Pattern f26406r = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");

    public String j() {
        return this.up;
    }

    public String toString() {
        return j(false);
    }

    public String xt() {
        return this.f26408m;
    }

    private static boolean j(String str, String str2) {
        if (str.equals(str2)) {
            return true;
        }
        return str.endsWith(str2) && str.charAt((str.length() - str2.length()) - 1) == '.' && !com.bytedance.sdk.component.cw.xt.j.cw.cw(str);
    }

    private static String xt(String str) {
        if (str.endsWith(".")) {
            throw new IllegalArgumentException();
        }
        if (str.startsWith(".")) {
            str = str.substring(1);
        }
        String j6 = com.bytedance.sdk.component.cw.xt.j.cw.j(str);
        if (j6 != null) {
            return j6;
        }
        throw new IllegalArgumentException();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof vl)) {
            return false;
        }
        vl vlVar = (vl) obj;
        return vlVar.up.equals(this.up) && vlVar.f26408m.equals(this.f26408m) && vlVar.tl.equals(this.tl) && vlVar.f26407g.equals(this.f26407g) && vlVar.ae == this.ae && vlVar.oq == this.oq && vlVar.qv == this.qv && vlVar.vl == this.vl && vlVar.jy == this.jy;
    }

    public int hashCode() {
        int hashCode = (((((((this.up.hashCode() + 527) * 31) + this.f26408m.hashCode()) * 31) + this.tl.hashCode()) * 31) + this.f26407g.hashCode()) * 31;
        long j6 = this.ae;
        return ((((((((hashCode + ((int) (j6 ^ (j6 >>> 32)))) * 31) + (!this.oq ? 1 : 0)) * 31) + (!this.qv ? 1 : 0)) * 31) + (!this.vl ? 1 : 0)) * 31) + (!this.jy ? 1 : 0);
    }

    private vl(String str, String str2, long j6, String str3, String str4, boolean z5, boolean z6, boolean z7, boolean z8) {
        this.up = str;
        this.f26408m = str2;
        this.ae = j6;
        this.tl = str3;
        this.f26407g = str4;
        this.oq = z5;
        this.qv = z6;
        this.jy = z7;
        this.vl = z8;
    }

    public static vl j(mi miVar, String str) {
        return j(System.currentTimeMillis(), miVar, str);
    }

    static vl j(long j6, mi miVar, String str) {
        long j7;
        String str2;
        int length = str.length();
        char c6 = ';';
        int j8 = com.bytedance.sdk.component.cw.xt.j.cw.j(str, 0, length, ';');
        int j9 = com.bytedance.sdk.component.cw.xt.j.cw.j(str, 0, j8, '=');
        String str3 = null;
        if (j9 == j8) {
            return null;
        }
        String cw2 = com.bytedance.sdk.component.cw.xt.j.cw.cw(str, 0, j9);
        if (cw2.isEmpty() || com.bytedance.sdk.component.cw.xt.j.cw.xt(cw2) != -1) {
            return null;
        }
        String cw3 = com.bytedance.sdk.component.cw.xt.j.cw.cw(str, j9 + 1, j8);
        if (com.bytedance.sdk.component.cw.xt.j.cw.xt(cw3) != -1) {
            return null;
        }
        int i6 = j8 + 1;
        String str4 = null;
        long j10 = 253402300799999L;
        long j11 = -1;
        boolean z5 = true;
        boolean z6 = false;
        boolean z7 = false;
        boolean z8 = false;
        while (i6 < length) {
            int j12 = com.bytedance.sdk.component.cw.xt.j.cw.j(str, i6, length, c6);
            int j13 = com.bytedance.sdk.component.cw.xt.j.cw.j(str, i6, j12, '=');
            String cw4 = com.bytedance.sdk.component.cw.xt.j.cw.cw(str, i6, j13);
            String cw5 = j13 < j12 ? com.bytedance.sdk.component.cw.xt.j.cw.cw(str, j13 + 1, j12) : "";
            if (cw4.equalsIgnoreCase("expires")) {
                try {
                    j10 = j(cw5, 0, cw5.length());
                } catch (NumberFormatException | IllegalArgumentException unused) {
                }
            } else if (cw4.equalsIgnoreCase("max-age")) {
                j11 = j(cw5);
            } else {
                if (cw4.equalsIgnoreCase("domain")) {
                    str3 = xt(cw5);
                    z5 = false;
                } else if (cw4.equalsIgnoreCase("path")) {
                    str4 = cw5;
                } else if (cw4.equalsIgnoreCase("secure")) {
                    z7 = true;
                } else if (cw4.equalsIgnoreCase("httponly")) {
                    z8 = true;
                }
                i6 = j12 + 1;
                c6 = ';';
            }
            z6 = true;
            i6 = j12 + 1;
            c6 = ';';
        }
        if (j11 == Long.MIN_VALUE) {
            j7 = Long.MIN_VALUE;
        } else if (j11 != -1) {
            long j14 = j6 + (j11 <= 9223372036854775L ? j11 * 1000 : Long.MAX_VALUE);
            j7 = (j14 < j6 || j14 > DateFormattingKt.MAX_DATE) ? 253402300799999L : j14;
        } else {
            j7 = j10;
        }
        String ae = miVar.ae();
        if (str3 == null) {
            str2 = ae;
        } else {
            if (!j(ae, str3)) {
                return null;
            }
            str2 = str3;
        }
        if (ae.length() != str2.length() && com.bytedance.sdk.component.cw.xt.j.tl.j.j().j(str2) == null) {
            return null;
        }
        String str5 = "/";
        if (str4 == null || !str4.startsWith("/")) {
            String g6 = miVar.g();
            int lastIndexOf = g6.lastIndexOf(47);
            if (lastIndexOf != 0) {
                str5 = g6.substring(0, lastIndexOf);
            }
            str4 = str5;
        }
        return new vl(cw2, cw3, j7, str2, str4, z7, z8, z5, z6);
    }

    private static long j(String str, int i6, int i7) {
        int j6 = j(str, i6, i7, false);
        Matcher matcher = f26406r.matcher(str);
        int i8 = -1;
        int i9 = -1;
        int i10 = -1;
        int i11 = -1;
        int i12 = -1;
        int i13 = -1;
        while (j6 < i7) {
            int j7 = j(str, j6 + 1, i7, true);
            matcher.region(j6, j7);
            if (i9 == -1 && matcher.usePattern(f26406r).matches()) {
                i9 = Integer.parseInt(matcher.group(1));
                i12 = Integer.parseInt(matcher.group(2));
                i13 = Integer.parseInt(matcher.group(3));
            } else if (i10 == -1 && matcher.usePattern(cw).matches()) {
                i10 = Integer.parseInt(matcher.group(1));
            } else {
                if (i11 == -1) {
                    Pattern pattern = xt;
                    if (matcher.usePattern(pattern).matches()) {
                        i11 = pattern.pattern().indexOf(matcher.group(1).toLowerCase(Locale.US)) / 4;
                    }
                }
                if (i8 == -1 && matcher.usePattern(f26405j).matches()) {
                    i8 = Integer.parseInt(matcher.group(1));
                }
            }
            j6 = j(str, j7 + 1, i7, false);
        }
        if (i8 >= 70 && i8 <= 99) {
            i8 += 1900;
        }
        if (i8 >= 0 && i8 <= 69) {
            i8 += 2000;
        }
        if (i8 < 1601) {
            throw new IllegalArgumentException();
        }
        if (i11 == -1) {
            throw new IllegalArgumentException();
        }
        if (i10 <= 0 || i10 > 31) {
            throw new IllegalArgumentException();
        }
        if (i9 < 0 || i9 > 23) {
            throw new IllegalArgumentException();
        }
        if (i12 < 0 || i12 > 59) {
            throw new IllegalArgumentException();
        }
        if (i13 >= 0 && i13 <= 59) {
            GregorianCalendar gregorianCalendar = new GregorianCalendar(com.bytedance.sdk.component.cw.xt.j.cw.ae);
            gregorianCalendar.setLenient(false);
            gregorianCalendar.set(1, i8);
            gregorianCalendar.set(2, i11 - 1);
            gregorianCalendar.set(5, i10);
            gregorianCalendar.set(11, i9);
            gregorianCalendar.set(12, i12);
            gregorianCalendar.set(13, i13);
            gregorianCalendar.set(14, 0);
            return gregorianCalendar.getTimeInMillis();
        }
        throw new IllegalArgumentException();
    }

    private static int j(String str, int i6, int i7, boolean z5) {
        while (i6 < i7) {
            char charAt = str.charAt(i6);
            if (((charAt < ' ' && charAt != '\t') || charAt >= 127 || (charAt >= '0' && charAt <= '9') || ((charAt >= 'a' && charAt <= 'z') || ((charAt >= 'A' && charAt <= 'Z') || charAt == ':'))) == (!z5)) {
                return i6;
            }
            i6++;
        }
        return i7;
    }

    private static long j(String str) {
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong <= 0) {
                return Long.MIN_VALUE;
            }
            return parseLong;
        } catch (NumberFormatException e6) {
            if (str.matches("-?\\d+")) {
                return str.startsWith("-") ? Long.MIN_VALUE : Long.MAX_VALUE;
            }
            throw e6;
        }
    }

    public static List<vl> j(mi miVar, w wVar) {
        List<String> xt2 = wVar.xt("Set-Cookie");
        int size = xt2.size();
        ArrayList arrayList = null;
        for (int i6 = 0; i6 < size; i6++) {
            vl j6 = j(miVar, xt2.get(i6));
            if (j6 != null) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(j6);
            }
        }
        if (arrayList != null) {
            return Collections.unmodifiableList(arrayList);
        }
        return Collections.EMPTY_LIST;
    }

    String j(boolean z5) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.up);
        sb.append('=');
        sb.append(this.f26408m);
        if (this.vl) {
            if (this.ae == Long.MIN_VALUE) {
                sb.append("; max-age=0");
            } else {
                sb.append("; expires=");
                sb.append(com.bytedance.sdk.component.cw.xt.j.cw.r.j(new Date(this.ae)));
            }
        }
        if (!this.jy) {
            sb.append("; domain=");
            if (z5) {
                sb.append(".");
            }
            sb.append(this.tl);
        }
        sb.append("; path=");
        sb.append(this.f26407g);
        if (this.oq) {
            sb.append("; secure");
        }
        if (this.qv) {
            sb.append("; httponly");
        }
        return sb.toString();
    }
}
