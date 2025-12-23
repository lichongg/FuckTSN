package org.apache.commons.net.ftp;

import com.huawei.hms.common.util.Logger;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.text.DateFormatSymbols;
import java.util.Collection;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class d {

    /* renamed from: i, reason: collision with root package name */
    public static final String f50597i = "UNIX";

    /* renamed from: j, reason: collision with root package name */
    public static final String f50598j = "UNIX_LTRIM";

    /* renamed from: k, reason: collision with root package name */
    public static final String f50599k = "VMS";

    /* renamed from: l, reason: collision with root package name */
    public static final String f50600l = "WINDOWS";

    /* renamed from: m, reason: collision with root package name */
    public static final String f50601m = "OS/2";

    /* renamed from: n, reason: collision with root package name */
    public static final String f50602n = "OS/400";

    /* renamed from: o, reason: collision with root package name */
    public static final String f50603o = "AS/400";

    /* renamed from: p, reason: collision with root package name */
    public static final String f50604p = "MVS";

    /* renamed from: q, reason: collision with root package name */
    public static final String f50605q = "TYPE: L8";

    /* renamed from: r, reason: collision with root package name */
    public static final String f50606r = "NETWARE";

    /* renamed from: s, reason: collision with root package name */
    public static final String f50607s = "MACOS PETER";

    /* renamed from: t, reason: collision with root package name */
    private static final Map<String, Object> f50608t;

    /* renamed from: a, reason: collision with root package name */
    private final String f50609a;

    /* renamed from: b, reason: collision with root package name */
    private String f50610b;

    /* renamed from: c, reason: collision with root package name */
    private String f50611c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f50612d;

    /* renamed from: e, reason: collision with root package name */
    private String f50613e;

    /* renamed from: f, reason: collision with root package name */
    private String f50614f;

    /* renamed from: g, reason: collision with root package name */
    private String f50615g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f50616h;

    public d(String str) {
        this.f50610b = null;
        this.f50611c = null;
        this.f50612d = true;
        this.f50613e = null;
        this.f50614f = null;
        this.f50615g = null;
        this.f50616h = false;
        this.f50609a = str;
    }

    static {
        TreeMap treeMap = new TreeMap();
        f50608t = treeMap;
        treeMap.put("en", Locale.ENGLISH);
        treeMap.put(SocializeProtocolConstants.PROTOCOL_KEY_DE, Locale.GERMAN);
        treeMap.put("it", Locale.ITALIAN);
        treeMap.put("es", new Locale("es", "", ""));
        treeMap.put("pt", new Locale("pt", "", ""));
        treeMap.put("da", new Locale("da", "", ""));
        treeMap.put("sv", new Locale("sv", "", ""));
        treeMap.put("no", new Locale("no", "", ""));
        treeMap.put("nl", new Locale("nl", "", ""));
        treeMap.put("ro", new Locale("ro", "", ""));
        treeMap.put("sq", new Locale("sq", "", ""));
        treeMap.put(com.snail.antifake.deviceid.e.f37540b, new Locale(com.snail.antifake.deviceid.e.f37540b, "", ""));
        treeMap.put("sk", new Locale("sk", "", ""));
        treeMap.put("sl", new Locale("sl", "", ""));
        treeMap.put(SocializeProtocolConstants.PROTOCOL_KEY_FR, "jan|fév|mar|avr|mai|jun|jui|aoû|sep|oct|nov|déc");
    }

    public static Collection<String> h() {
        return f50608t.keySet();
    }

    public static DateFormatSymbols k(String str) {
        Object obj = f50608t.get(str);
        if (obj != null) {
            if (obj instanceof Locale) {
                return new DateFormatSymbols((Locale) obj);
            }
            if (obj instanceof String) {
                return a((String) obj);
            }
        }
        return new DateFormatSymbols(Locale.US);
    }

    private static String[] s(String str) {
        StringTokenizer stringTokenizer = new StringTokenizer(str, Logger.f33116c);
        if (12 != stringTokenizer.countTokens()) {
            throw new IllegalArgumentException("expecting a pipe-delimited string containing 12 tokens");
        }
        String[] strArr = new String[13];
        int i6 = 0;
        while (stringTokenizer.hasMoreTokens()) {
            strArr[i6] = stringTokenizer.nextToken();
            i6++;
        }
        strArr[i6] = "";
        return strArr;
    }

    public String b() {
        return this.f50610b;
    }

    public String c() {
        return this.f50611c;
    }

    public String d() {
        return this.f50613e;
    }

    public String e() {
        return this.f50609a;
    }

    public String f() {
        return this.f50615g;
    }

    public String g() {
        return this.f50614f;
    }

    public boolean i() {
        return this.f50616h;
    }

    public boolean j() {
        return this.f50612d;
    }

    public void l(String str) {
        this.f50610b = str;
    }

    public void m(boolean z5) {
        this.f50612d = z5;
    }

    public void n(String str) {
        this.f50611c = str;
    }

    public void o(String str) {
        this.f50613e = str;
    }

    public void p(String str) {
        this.f50615g = str;
    }

    public void q(String str) {
        this.f50614f = str;
    }

    public void r(boolean z5) {
        this.f50616h = z5;
    }

    public static DateFormatSymbols a(String str) {
        String[] s5 = s(str);
        DateFormatSymbols dateFormatSymbols = new DateFormatSymbols(Locale.US);
        dateFormatSymbols.setShortMonths(s5);
        return dateFormatSymbols;
    }

    public d() {
        this(f50597i);
    }

    public d(String str, String str2, String str3) {
        this(str);
        this.f50610b = str2;
        this.f50611c = str3;
    }

    public d(String str, String str2, String str3, String str4, String str5, String str6) {
        this(str);
        this.f50610b = str2;
        this.f50611c = str3;
        this.f50613e = str4;
        this.f50614f = str5;
        this.f50615g = str6;
    }

    public d(String str, String str2, String str3, String str4, String str5, String str6, boolean z5, boolean z6) {
        this(str);
        this.f50610b = str2;
        this.f50612d = z5;
        this.f50611c = str3;
        this.f50616h = z6;
        this.f50613e = str4;
        this.f50614f = str5;
        this.f50615g = str6;
    }

    d(String str, d dVar) {
        this.f50610b = null;
        this.f50611c = null;
        this.f50612d = true;
        this.f50613e = null;
        this.f50614f = null;
        this.f50615g = null;
        this.f50616h = false;
        this.f50609a = str;
        this.f50610b = dVar.f50610b;
        this.f50612d = dVar.f50612d;
        this.f50611c = dVar.f50611c;
        this.f50616h = dVar.f50616h;
        this.f50613e = dVar.f50613e;
        this.f50615g = dVar.f50615g;
        this.f50614f = dVar.f50614f;
    }

    public d(d dVar) {
        this.f50610b = null;
        this.f50611c = null;
        this.f50612d = true;
        this.f50613e = null;
        this.f50614f = null;
        this.f50615g = null;
        this.f50616h = false;
        this.f50609a = dVar.f50609a;
        this.f50610b = dVar.f50610b;
        this.f50612d = dVar.f50612d;
        this.f50611c = dVar.f50611c;
        this.f50616h = dVar.f50616h;
        this.f50613e = dVar.f50613e;
        this.f50615g = dVar.f50615g;
        this.f50614f = dVar.f50614f;
    }
}
