package org.apache.commons.net.smtp;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class d {
    public static final int A = 8;
    public static final int B = 9;
    public static final int C = 13;
    private static final String[] D;

    /* renamed from: a, reason: collision with root package name */
    public static final int f51026a = 0;

    /* renamed from: b, reason: collision with root package name */
    public static final int f51027b = 1;

    /* renamed from: c, reason: collision with root package name */
    public static final int f51028c = 2;

    /* renamed from: d, reason: collision with root package name */
    public static final int f51029d = 3;

    /* renamed from: e, reason: collision with root package name */
    public static final int f51030e = 4;

    /* renamed from: f, reason: collision with root package name */
    public static final int f51031f = 5;

    /* renamed from: g, reason: collision with root package name */
    public static final int f51032g = 6;

    /* renamed from: h, reason: collision with root package name */
    public static final int f51033h = 7;

    /* renamed from: i, reason: collision with root package name */
    public static final int f51034i = 8;

    /* renamed from: j, reason: collision with root package name */
    public static final int f51035j = 9;

    /* renamed from: k, reason: collision with root package name */
    public static final int f51036k = 10;

    /* renamed from: l, reason: collision with root package name */
    public static final int f51037l = 11;

    /* renamed from: m, reason: collision with root package name */
    public static final int f51038m = 12;

    /* renamed from: n, reason: collision with root package name */
    public static final int f51039n = 13;

    /* renamed from: o, reason: collision with root package name */
    public static final int f51040o = 14;

    /* renamed from: p, reason: collision with root package name */
    public static final int f51041p = 15;

    /* renamed from: q, reason: collision with root package name */
    private static final int f51042q = 16;

    /* renamed from: r, reason: collision with root package name */
    public static final int f51043r = 0;

    /* renamed from: s, reason: collision with root package name */
    public static final int f51044s = 0;

    /* renamed from: t, reason: collision with root package name */
    public static final int f51045t = 1;

    /* renamed from: u, reason: collision with root package name */
    public static final int f51046u = 2;

    /* renamed from: v, reason: collision with root package name */
    public static final int f51047v = 3;

    /* renamed from: w, reason: collision with root package name */
    public static final int f51048w = 4;

    /* renamed from: x, reason: collision with root package name */
    public static final int f51049x = 5;

    /* renamed from: y, reason: collision with root package name */
    public static final int f51050y = 6;

    /* renamed from: z, reason: collision with root package name */
    public static final int f51051z = 7;

    static {
        String[] strArr = {"HELO", "MAIL FROM:", "RCPT TO:", "DATA", "SEND FROM:", "SOML FROM:", "SAML FROM:", "RSET", "VRFY", "EXPN", "HELP", "NOOP", "TURN", "QUIT", "AUTH", "EHLO"};
        D = strArr;
        if (strArr.length != 16) {
            throw new RuntimeException("Error in array definition");
        }
    }

    public static final String a(int i6) {
        return D[i6];
    }

    private d() {
    }
}
