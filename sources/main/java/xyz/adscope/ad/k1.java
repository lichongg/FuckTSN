package xyz.adscope.ad;

import com.baidu.mobads.sdk.internal.bn;
import com.umeng.analytics.pro.bi;
import xyz.adscope.common.analyse.model.impl.HistoryDbModel;
import xyz.adscope.common.v2.model.annotation.JsonParseNode;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public final class k1 extends t {

    @JsonParseNode(key = "sdkuid")
    private String A;

    @JsonParseNode(key = "updateMd5")
    private String B;

    @JsonParseNode(key = "requestUrlMD5")
    private String C;

    @JsonParseNode(key = "statisticsMD5")
    private String D;

    @JsonParseNode(key = "spaceStrategyMD5")
    private String E;

    @JsonParseNode(key = "country")
    private String F;

    @JsonParseNode(key = "fileMark")
    private String G;

    @JsonParseNode(key = "deviceName")
    private String H;

    @JsonParseNode(key = "country_CN")
    private int I;

    /* renamed from: a, reason: collision with root package name */
    @JsonParseNode(key = "appId")
    private String f55288a;

    /* renamed from: b, reason: collision with root package name */
    @JsonParseNode(key = HistoryDbModel.COLUMN_API_KEY)
    private String f55289b;

    /* renamed from: c, reason: collision with root package name */
    @JsonParseNode(key = "timeStamp")
    private long f55290c;

    /* renamed from: d, reason: collision with root package name */
    @JsonParseNode(key = "userAgent")
    private String f55291d;

    /* renamed from: e, reason: collision with root package name */
    @JsonParseNode(key = "deviceType")
    private int f55292e;

    /* renamed from: f, reason: collision with root package name */
    @JsonParseNode(key = "manufacturer")
    private String f55293f;

    /* renamed from: g, reason: collision with root package name */
    @JsonParseNode(key = bn.f10754j)
    private String f55294g;

    /* renamed from: h, reason: collision with root package name */
    @JsonParseNode(key = bn.f10753i)
    private String f55295h;

    /* renamed from: i, reason: collision with root package name */
    @JsonParseNode(key = "os")
    private int f55296i;

    /* renamed from: j, reason: collision with root package name */
    @JsonParseNode(key = "osVersion")
    private String f55297j;

    /* renamed from: k, reason: collision with root package name */
    @JsonParseNode(key = bi.P)
    private String f55298k;

    /* renamed from: l, reason: collision with root package name */
    @JsonParseNode(key = "connectType")
    private int f55299l;

    /* renamed from: m, reason: collision with root package name */
    @JsonParseNode(key = "language")
    private String f55300m;

    /* renamed from: n, reason: collision with root package name */
    @JsonParseNode(key = "screenHeight")
    private int f55301n;

    /* renamed from: o, reason: collision with root package name */
    @JsonParseNode(key = "screenWidth")
    private int f55302o;

    /* renamed from: p, reason: collision with root package name */
    @JsonParseNode(key = "resolutionHeight")
    private int f55303p;

    /* renamed from: q, reason: collision with root package name */
    @JsonParseNode(key = "resolutionWidth")
    private int f55304q;

    /* renamed from: r, reason: collision with root package name */
    @JsonParseNode(key = "orientation")
    private int f55305r;

    /* renamed from: s, reason: collision with root package name */
    @JsonParseNode(key = "density")
    private float f55306s;

    /* renamed from: t, reason: collision with root package name */
    @JsonParseNode(key = "ppi")
    private float f55307t;

    /* renamed from: u, reason: collision with root package name */
    @JsonParseNode(key = "updateMark")
    private String f55308u;

    /* renamed from: v, reason: collision with root package name */
    @JsonParseNode(key = "physicalMemory")
    private String f55309v;

    /* renamed from: w, reason: collision with root package name */
    @JsonParseNode(key = "harddiskSize")
    private String f55310w;

    /* renamed from: x, reason: collision with root package name */
    @JsonParseNode(key = "oaid")
    private String f55311x;

    /* renamed from: y, reason: collision with root package name */
    @JsonParseNode(key = "gaid")
    private String f55312y;

    /* renamed from: z, reason: collision with root package name */
    @JsonParseNode(key = "said")
    private String f55313z;

    public void a(String str) {
        this.f55289b = str;
    }

    public void b(String str) {
        this.f55288a = str;
    }

    public void c(int i6) {
        this.f55292e = i6;
    }

    public void d(String str) {
        this.f55298k = str;
    }

    public void e(int i6) {
        this.f55296i = i6;
    }

    public void f(int i6) {
        this.f55303p = i6;
    }

    public void g(int i6) {
        this.f55304q = i6;
    }

    public void h(int i6) {
        this.f55301n = i6;
    }

    public void i(int i6) {
        this.f55302o = i6;
    }

    public void a(long j6) {
        this.f55290c = j6;
    }

    public void b(float f6) {
        this.f55307t = f6;
    }

    public void c(String str) {
        this.f55294g = str;
    }

    public void d(int i6) {
        this.f55305r = i6;
    }

    public void e(String str) {
        this.F = str;
    }

    public void f(String str) {
        this.H = str;
    }

    public void g(String str) {
        this.G = str;
    }

    public void h(String str) {
        this.f55312y = str;
    }

    public void i(String str) {
        this.f55310w = str;
    }

    public void j(String str) {
        this.f55300m = str;
    }

    public void k(String str) {
        this.f55293f = str;
    }

    public void l(String str) {
        this.f55295h = str;
    }

    public void m(String str) {
        this.f55311x = str;
    }

    public void n(String str) {
        this.f55297j = str;
    }

    public void o(String str) {
        this.f55309v = str;
    }

    public void p(String str) {
        this.C = str;
    }

    public void q(String str) {
        this.f55313z = str;
    }

    public void r(String str) {
        this.A = str;
    }

    public void s(String str) {
        this.D = str;
    }

    public void t(String str) {
        this.E = str;
    }

    public void u(String str) {
        this.f55308u = str;
    }

    public void v(String str) {
        this.B = str;
    }

    public void w(String str) {
        this.f55291d = str;
    }

    public void a(int i6) {
        this.f55299l = i6;
    }

    public void b(int i6) {
        this.I = i6;
    }

    public void a(float f6) {
        this.f55306s = f6;
    }
}
