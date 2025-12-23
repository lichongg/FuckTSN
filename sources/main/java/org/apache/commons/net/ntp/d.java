package org.apache.commons.net.ntp;

import java.net.DatagramPacket;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public interface d {

    /* renamed from: a, reason: collision with root package name */
    public static final int f50960a = 123;

    /* renamed from: b, reason: collision with root package name */
    public static final int f50961b = 0;

    /* renamed from: c, reason: collision with root package name */
    public static final int f50962c = 1;

    /* renamed from: d, reason: collision with root package name */
    public static final int f50963d = 2;

    /* renamed from: e, reason: collision with root package name */
    public static final int f50964e = 3;

    /* renamed from: f, reason: collision with root package name */
    public static final int f50965f = 0;

    /* renamed from: g, reason: collision with root package name */
    public static final int f50966g = 1;

    /* renamed from: h, reason: collision with root package name */
    public static final int f50967h = 2;

    /* renamed from: i, reason: collision with root package name */
    public static final int f50968i = 3;

    /* renamed from: j, reason: collision with root package name */
    public static final int f50969j = 4;

    /* renamed from: k, reason: collision with root package name */
    public static final int f50970k = 5;

    /* renamed from: l, reason: collision with root package name */
    public static final int f50971l = 6;

    /* renamed from: m, reason: collision with root package name */
    public static final int f50972m = 7;

    /* renamed from: n, reason: collision with root package name */
    public static final int f50973n = 4;

    /* renamed from: o, reason: collision with root package name */
    public static final int f50974o = 14;

    /* renamed from: p, reason: collision with root package name */
    public static final int f50975p = 1;

    /* renamed from: q, reason: collision with root package name */
    public static final int f50976q = 10;

    /* renamed from: r, reason: collision with root package name */
    public static final int f50977r = 3;

    /* renamed from: s, reason: collision with root package name */
    public static final int f50978s = 4;

    /* renamed from: t, reason: collision with root package name */
    public static final String f50979t = "NTP";

    /* renamed from: u, reason: collision with root package name */
    public static final String f50980u = "ICMP";

    /* renamed from: v, reason: collision with root package name */
    public static final String f50981v = "TIME";

    /* renamed from: w, reason: collision with root package name */
    public static final String f50982w = "DAYTIME";

    double A();

    void B(int i6);

    TimeStamp C();

    void D(DatagramPacket datagramPacket);

    int a();

    int b();

    double c();

    int d();

    long e();

    void f(int i6);

    TimeStamp g();

    int getMode();

    String getType();

    int getVersion();

    void h(int i6);

    void i(TimeStamp timeStamp);

    int j();

    void k(TimeStamp timeStamp);

    void l(TimeStamp timeStamp);

    String m();

    String n();

    void o(int i6);

    int p();

    TimeStamp q();

    void r(int i6);

    DatagramPacket s();

    void setVersion(int i6);

    TimeStamp t();

    void u(int i6);

    int v();

    void w(TimeStamp timeStamp);

    void x(int i6);

    int y();

    void z(int i6);
}
