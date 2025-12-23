package org.apache.commons.net.telnet;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public static final int f51085a = 255;

    /* renamed from: b, reason: collision with root package name */
    public static final int f51086b = 255;

    /* renamed from: c, reason: collision with root package name */
    public static final int f51087c = 254;

    /* renamed from: d, reason: collision with root package name */
    public static final int f51088d = 253;

    /* renamed from: e, reason: collision with root package name */
    public static final int f51089e = 252;

    /* renamed from: f, reason: collision with root package name */
    public static final int f51090f = 251;

    /* renamed from: g, reason: collision with root package name */
    public static final int f51091g = 250;

    /* renamed from: h, reason: collision with root package name */
    public static final int f51092h = 249;

    /* renamed from: i, reason: collision with root package name */
    public static final int f51093i = 248;

    /* renamed from: j, reason: collision with root package name */
    public static final int f51094j = 247;

    /* renamed from: k, reason: collision with root package name */
    public static final int f51095k = 246;

    /* renamed from: l, reason: collision with root package name */
    public static final int f51096l = 245;

    /* renamed from: m, reason: collision with root package name */
    public static final int f51097m = 244;

    /* renamed from: n, reason: collision with root package name */
    public static final int f51098n = 243;

    /* renamed from: o, reason: collision with root package name */
    public static final int f51099o = 242;

    /* renamed from: p, reason: collision with root package name */
    public static final int f51100p = 241;

    /* renamed from: q, reason: collision with root package name */
    public static final int f51101q = 240;

    /* renamed from: r, reason: collision with root package name */
    public static final int f51102r = 239;

    /* renamed from: s, reason: collision with root package name */
    public static final int f51103s = 238;

    /* renamed from: t, reason: collision with root package name */
    public static final int f51104t = 237;

    /* renamed from: u, reason: collision with root package name */
    public static final int f51105u = 236;

    /* renamed from: v, reason: collision with root package name */
    public static final int f51106v = 242;

    /* renamed from: w, reason: collision with root package name */
    private static final String[] f51107w = {"IAC", "DONT", "DO", "WONT", "WILL", "SB", "GA", "EL", "EC", "AYT", "AO", "IP", "BRK", "DMARK", "NOP", "SE", "EOR", "ABORT", "SUSP", "EOF"};

    /* renamed from: x, reason: collision with root package name */
    private static final int f51108x = 255;

    /* renamed from: y, reason: collision with root package name */
    private static final int f51109y = 236;

    public static final String a(int i6) {
        return f51107w[255 - i6];
    }

    public static final boolean b(int i6) {
        return i6 <= 255 && i6 >= 236;
    }

    private f() {
    }
}
