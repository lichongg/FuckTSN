package org.apache.commons.net.telnet;

import xyz.adscope.common.network.cookie.db.Field;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class j {
    public static final int A = 25;
    public static final int B = 26;
    public static final int C = 27;
    public static final int D = 28;
    public static final int E = 29;
    public static final int F = 30;
    public static final int G = 31;
    public static final int H = 32;
    public static final int I = 33;
    public static final int J = 34;
    public static final int K = 35;
    public static final int L = 36;
    public static final int M = 37;
    public static final int N = 38;
    public static final int O = 39;
    public static final int P = 255;
    private static final int Q = 0;
    private static final int R = 255;
    private static final String[] S = {"BINARY", "ECHO", "RCP", "SUPPRESS GO AHEAD", Field.NAME, "STATUS", "TIMING MARK", "RCTE", "NAOL", "NAOP", "NAOCRD", "NAOHTS", "NAOHTD", "NAOFFD", "NAOVTS", "NAOVTD", "NAOLFD", "EXTEND ASCII", "LOGOUT", "BYTE MACRO", "DATA ENTRY TERMINAL", "SUPDUP", "SUPDUP OUTPUT", "SEND LOCATION", "TERMINAL TYPE", "END OF RECORD", "TACACS UID", "OUTPUT MARKING", "TTYLOC", "3270 REGIME", "X.3 PAD", "NAWS", "TSPEED", "LFLOW", "LINEMODE", "XDISPLOC", "OLD-ENVIRON", "AUTHENTICATION", "ENCRYPT", "NEW-ENVIRON", "TN3270E", "XAUTH", "CHARSET", "RSP", "Com Port Control", "Suppress Local Echo", "Start TLS", "KERMIT", "SEND-URL", "FORWARD_X", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "TELOPT PRAGMA LOGON", "TELOPT SSPI LOGON", "TELOPT PRAGMA HEARTBEAT", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "Extended-Options-List"};

    /* renamed from: a, reason: collision with root package name */
    public static final int f51141a = 255;

    /* renamed from: b, reason: collision with root package name */
    public static final int f51142b = 0;

    /* renamed from: c, reason: collision with root package name */
    public static final int f51143c = 1;

    /* renamed from: d, reason: collision with root package name */
    public static final int f51144d = 2;

    /* renamed from: e, reason: collision with root package name */
    public static final int f51145e = 3;

    /* renamed from: f, reason: collision with root package name */
    public static final int f51146f = 4;

    /* renamed from: g, reason: collision with root package name */
    public static final int f51147g = 5;

    /* renamed from: h, reason: collision with root package name */
    public static final int f51148h = 6;

    /* renamed from: i, reason: collision with root package name */
    public static final int f51149i = 7;

    /* renamed from: j, reason: collision with root package name */
    public static final int f51150j = 8;

    /* renamed from: k, reason: collision with root package name */
    public static final int f51151k = 9;

    /* renamed from: l, reason: collision with root package name */
    public static final int f51152l = 10;

    /* renamed from: m, reason: collision with root package name */
    public static final int f51153m = 11;

    /* renamed from: n, reason: collision with root package name */
    public static final int f51154n = 12;

    /* renamed from: o, reason: collision with root package name */
    public static final int f51155o = 13;

    /* renamed from: p, reason: collision with root package name */
    public static final int f51156p = 14;

    /* renamed from: q, reason: collision with root package name */
    public static final int f51157q = 15;

    /* renamed from: r, reason: collision with root package name */
    public static final int f51158r = 16;

    /* renamed from: s, reason: collision with root package name */
    public static final int f51159s = 17;

    /* renamed from: t, reason: collision with root package name */
    public static final int f51160t = 18;

    /* renamed from: u, reason: collision with root package name */
    public static final int f51161u = 19;

    /* renamed from: v, reason: collision with root package name */
    public static final int f51162v = 20;

    /* renamed from: w, reason: collision with root package name */
    public static final int f51163w = 21;

    /* renamed from: x, reason: collision with root package name */
    public static final int f51164x = 22;

    /* renamed from: y, reason: collision with root package name */
    public static final int f51165y = 23;

    /* renamed from: z, reason: collision with root package name */
    public static final int f51166z = 24;

    public static final String a(int i6) {
        String[] strArr = S;
        return strArr[i6].length() == 0 ? "UNASSIGNED" : strArr[i6];
    }

    public static final boolean b(int i6) {
        return i6 <= 255;
    }

    private j() {
    }
}
