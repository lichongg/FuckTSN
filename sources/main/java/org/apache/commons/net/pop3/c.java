package org.apache.commons.net.pop3;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final int f50996a = 0;

    /* renamed from: b, reason: collision with root package name */
    public static final int f50997b = 1;

    /* renamed from: c, reason: collision with root package name */
    public static final int f50998c = 2;

    /* renamed from: d, reason: collision with root package name */
    public static final int f50999d = 3;

    /* renamed from: e, reason: collision with root package name */
    public static final int f51000e = 4;

    /* renamed from: f, reason: collision with root package name */
    public static final int f51001f = 5;

    /* renamed from: g, reason: collision with root package name */
    public static final int f51002g = 6;

    /* renamed from: h, reason: collision with root package name */
    public static final int f51003h = 7;

    /* renamed from: i, reason: collision with root package name */
    public static final int f51004i = 8;

    /* renamed from: j, reason: collision with root package name */
    public static final int f51005j = 9;

    /* renamed from: k, reason: collision with root package name */
    public static final int f51006k = 10;

    /* renamed from: l, reason: collision with root package name */
    public static final int f51007l = 11;

    /* renamed from: m, reason: collision with root package name */
    public static final int f51008m = 12;

    /* renamed from: n, reason: collision with root package name */
    public static final int f51009n = 13;

    /* renamed from: o, reason: collision with root package name */
    private static final int f51010o = 14;

    /* renamed from: p, reason: collision with root package name */
    static final String[] f51011p;

    static {
        String[] strArr = {"USER", "PASS", "QUIT", "STAT", "LIST", "RETR", "DELE", "NOOP", "RSET", "APOP", "TOP", "UIDL", "CAPA", "AUTH"};
        f51011p = strArr;
        if (strArr.length != 14) {
            throw new RuntimeException("Error in array definition");
        }
    }

    public static final String a(int i6) {
        return f51011p[i6];
    }

    private c() {
    }
}
