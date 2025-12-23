package com.ss.android.xt.j.xt;

import com.ss.android.downloadlib.addownload.m;
import com.ss.android.j.j.cw.g;
import com.ss.android.j.j.up.f;
import com.ss.android.xt.j.j.a;
import com.ss.android.xt.j.j.b;
import com.ss.android.xt.j.j.c;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes6.dex */
public class b implements a {
    private int A;
    private String B;
    private boolean C;
    private String D;
    private boolean E;
    private boolean F;
    private boolean G;
    private String H;
    private String I;
    private boolean J;
    protected boolean K;
    protected boolean L;
    private boolean M;
    public final AtomicBoolean N;
    public final AtomicBoolean O;
    public final AtomicBoolean P;
    private int Q;
    private int R;
    private long S;
    private long T;
    private boolean U;
    private boolean V;
    private long W;
    private long X;
    private String Y;
    private boolean Z;

    /* renamed from: a, reason: collision with root package name */
    private long f39105a;

    /* renamed from: a0, reason: collision with root package name */
    private boolean f39106a0;

    /* renamed from: b, reason: collision with root package name */
    private long f39107b;

    /* renamed from: b0, reason: collision with root package name */
    private boolean f39108b0;

    /* renamed from: c, reason: collision with root package name */
    private String f39109c;

    /* renamed from: c0, reason: collision with root package name */
    private long f39110c0;

    /* renamed from: d, reason: collision with root package name */
    private int f39111d;

    /* renamed from: d0, reason: collision with root package name */
    private transient boolean f39112d0;

    /* renamed from: e, reason: collision with root package name */
    private String f39113e;

    /* renamed from: e0, reason: collision with root package name */
    private boolean f39114e0;

    /* renamed from: f, reason: collision with root package name */
    private String f39115f;

    /* renamed from: f0, reason: collision with root package name */
    private boolean f39116f0;

    /* renamed from: g, reason: collision with root package name */
    private String f39117g;

    /* renamed from: g0, reason: collision with root package name */
    private boolean f39118g0;

    /* renamed from: h, reason: collision with root package name */
    private String f39119h;

    /* renamed from: h0, reason: collision with root package name */
    private boolean f39120h0;

    /* renamed from: i, reason: collision with root package name */
    private int f39121i;

    /* renamed from: i0, reason: collision with root package name */
    private boolean f39122i0;

    /* renamed from: j, reason: collision with root package name */
    private int f39123j;

    /* renamed from: j0, reason: collision with root package name */
    private boolean f39124j0;

    /* renamed from: k, reason: collision with root package name */
    private int f39125k;

    /* renamed from: k0, reason: collision with root package name */
    private String f39126k0;

    /* renamed from: l, reason: collision with root package name */
    private int f39127l;

    /* renamed from: l0, reason: collision with root package name */
    private long f39128l0;

    /* renamed from: m, reason: collision with root package name */
    private String f39129m;

    /* renamed from: n, reason: collision with root package name */
    private String f39130n;

    /* renamed from: o, reason: collision with root package name */
    private String f39131o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f39132p;

    /* renamed from: q, reason: collision with root package name */
    private long f39133q;

    /* renamed from: r, reason: collision with root package name */
    private JSONObject f39134r;

    /* renamed from: s, reason: collision with root package name */
    private int f39135s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f39136t;

    /* renamed from: u, reason: collision with root package name */
    private int f39137u;

    /* renamed from: v, reason: collision with root package name */
    private int f39138v;

    /* renamed from: w, reason: collision with root package name */
    private long f39139w;

    /* renamed from: x, reason: collision with root package name */
    private long f39140x;

    /* renamed from: y, reason: collision with root package name */
    private long f39141y;

    /* renamed from: z, reason: collision with root package name */
    private int f39142z;

    private b() {
        this.f39111d = 1;
        this.f39132p = true;
        this.f39136t = false;
        this.f39137u = 0;
        this.f39138v = 0;
        this.C = false;
        this.E = false;
        this.F = true;
        this.G = true;
        this.K = true;
        this.L = true;
        this.N = new AtomicBoolean(false);
        this.O = new AtomicBoolean(false);
        this.P = new AtomicBoolean(false);
        this.R = 1;
        this.U = true;
        this.f39110c0 = -1L;
    }

    public synchronized void a() {
        this.f39138v++;
    }

    @Override // com.ss.android.xt.j.xt.a
    public JSONObject av() {
        return null;
    }

    @Override // com.ss.android.xt.j.xt.a
    public Object az() {
        return null;
    }

    public void i(boolean z5) {
        this.U = z5;
    }

    @Override // com.ss.android.xt.j.xt.a
    public String j() {
        return this.f39115f;
    }

    @Override // com.ss.android.xt.j.xt.a
    public int kt() {
        return -1;
    }

    public synchronized void n() {
        this.f39137u++;
    }

    @Override // com.ss.android.xt.j.xt.a
    public JSONObject qv() {
        return null;
    }

    @Override // com.ss.android.xt.j.xt.a
    public String r() {
        return this.f39109c;
    }

    @Override // com.ss.android.xt.j.xt.a
    public JSONObject w() {
        return null;
    }

    @Override // com.ss.android.xt.j.xt.a
    public List<String> ws() {
        return null;
    }

    public static b V0(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        b bVar = new b();
        try {
            bVar.q0(u2.b.a(jSONObject, "mId"));
            bVar.H0(u2.b.a(jSONObject, "mExtValue"));
            bVar.q(jSONObject.optString("mLogExtra"));
            bVar.G0(jSONObject.optInt("mDownloadStatus"));
            bVar.Y0(jSONObject.optString("mPackageName"));
            boolean z5 = true;
            bVar.M(jSONObject.optBoolean("mIsAd", true));
            bVar.V(u2.b.a(jSONObject, "mTimeStamp"));
            bVar.U(jSONObject.optInt("mVersionCode"));
            bVar.r0(jSONObject.optString("mVersionName"));
            bVar.b(jSONObject.optInt("mDownloadId"));
            bVar.Z0(jSONObject.optBoolean("mIsV3Event"));
            bVar.B0(jSONObject.optInt("mScene"));
            bVar.W(jSONObject.optString("mEventTag"));
            bVar.d(jSONObject.optString("mEventRefer"));
            bVar.D0(jSONObject.optString("mDownloadUrl"));
            bVar.r(jSONObject.optBoolean("mEnableBackDialog"));
            bVar.N.set(jSONObject.optBoolean("hasSendInstallFinish"));
            bVar.O.set(jSONObject.optBoolean("hasSendDownloadFailedFinally"));
            bVar.P.set(jSONObject.optBoolean("hasDoRebootMarketInstallFinishCheck"));
            bVar.p0(jSONObject.optInt("mLastFailedErrCode"));
            bVar.K(jSONObject.optString("mLastFailedErrMsg"));
            bVar.A(jSONObject.optString("mOpenUrl"));
            bVar.c0(jSONObject.optInt("mLinkMode"));
            bVar.l0(jSONObject.optInt("mDownloadMode"));
            bVar.K0(jSONObject.optInt("mModelType"));
            bVar.e0(jSONObject.optString("mAppName"));
            bVar.n0(jSONObject.optString("mAppIcon"));
            bVar.I(jSONObject.optInt("mDownloadFailedTimes", 0));
            bVar.J(u2.b.a(jSONObject, "mRecentDownloadResumeTime"));
            bVar.W0(jSONObject.optInt("mClickPauseTimes"));
            bVar.X0(u2.b.a(jSONObject, "mJumpInstallTime"));
            bVar.p(u2.b.a(jSONObject, "mCancelInstallTime"));
            bVar.o(jSONObject.optInt("mLastFailedResumeCount"));
            bVar.M0(jSONObject.optString("downloadFinishReason"));
            bVar.z(jSONObject.optLong("clickDownloadSize"));
            bVar.C0(jSONObject.optLong("clickDownloadTime"));
            bVar.E0(jSONObject.optBoolean("mIsUpdateDownload"));
            bVar.N(jSONObject.optString("mOriginMimeType"));
            bVar.B(jSONObject.optBoolean("mIsPatchApplyHandled"));
            bVar.X(jSONObject.optBoolean("installAfterCleanSpace"));
            bVar.y(jSONObject.optInt("funnelType", 1));
            bVar.I0(jSONObject.optString("webUrl"));
            bVar.i(jSONObject.optBoolean("enableShowComplianceDialog", true));
            bVar.H(jSONObject.optBoolean("isAutoDownloadOnCardShow"));
            bVar.O0(jSONObject.optInt("enable_new_activity", 1) == 1);
            bVar.Y(jSONObject.optInt("enable_pause", 1) == 1);
            bVar.R(jSONObject.optInt("enable_ah", 1) == 1);
            if (jSONObject.optInt("enable_am", 1) != 1) {
                z5 = false;
            }
            bVar.A0(z5);
            bVar.L(jSONObject.optJSONObject("mExtras"));
            bVar.u(jSONObject.optBoolean("intent_jump_browser_success"));
            bVar.R0(jSONObject.optString("task_key"));
            bVar.d0(jSONObject.optLong("market_install_finish_check_start_timestamp"));
            bVar.m0(jSONObject.optLong("download_pause_timestamp", 0L));
            bVar.L0(jSONObject.optLong("download_finish_timestamp", 0L));
            return bVar;
        } catch (Exception e6) {
            m.w().j(e6, "NativeDownloadModel fromJson");
            return bVar;
        }
    }

    public void A(String str) {
        this.f39117g = str;
    }

    public void A0(boolean z5) {
        this.L = z5;
    }

    public void B(boolean z5) {
        this.E = z5;
    }

    public void B0(int i6) {
        this.Q = i6;
    }

    public String C() {
        return this.B;
    }

    public void C0(long j6) {
        this.S = j6;
    }

    public boolean D() {
        return this.f39136t;
    }

    public void D0(String str) {
        this.f39115f = str;
    }

    public int E() {
        return this.f39142z;
    }

    public void E0(boolean z5) {
        this.C = z5;
    }

    public boolean F() {
        return this.f39106a0;
    }

    public int F0() {
        return this.f39127l;
    }

    public boolean G() {
        return this.f39108b0;
    }

    public void G0(int i6) {
        this.f39111d = i6;
    }

    public void H(boolean z5) {
        this.V = z5;
    }

    public void H0(long j6) {
        this.f39107b = j6;
    }

    public void I(int i6) {
        this.f39137u = i6;
    }

    public void I0(String str) {
        this.f39119h = str;
    }

    public void J(long j6) {
        this.f39139w = j6;
    }

    public void J0(boolean z5) {
        this.f39106a0 = z5;
    }

    public void K(String str) {
        this.B = str;
    }

    public void K0(int i6) {
        this.f39121i = i6;
    }

    public void L(JSONObject jSONObject) {
        this.f39134r = jSONObject;
    }

    public void L0(long j6) {
        this.X = j6;
    }

    public void M(boolean z5) {
        this.f39132p = z5;
    }

    public void M0(String str) {
        this.Y = str;
    }

    public void N(String str) {
        this.D = str;
    }

    public void N0(boolean z5) {
        this.f39118g0 = z5;
    }

    public void O(boolean z5) {
        this.f39116f0 = z5;
    }

    public void O0(boolean z5) {
        this.F = z5;
    }

    public boolean P() {
        return this.f39118g0;
    }

    public com.ss.android.xt.j.j.b P0() {
        return new b.a().h(this.f39136t).e(this.f39123j).o(this.f39125k).n(this.U).m(this.K).d(this.L).i();
    }

    public boolean Q() {
        return this.f39124j0;
    }

    public long Q0() {
        return this.f39133q;
    }

    public void R(boolean z5) {
        this.K = z5;
    }

    public void R0(String str) {
        this.f39126k0 = str;
    }

    public long S() {
        long j6 = this.f39139w;
        return j6 == 0 ? this.f39133q : j6;
    }

    public void S0(boolean z5) {
        this.f39120h0 = z5;
    }

    public int T() {
        return this.A;
    }

    public int T0() {
        return this.f39137u;
    }

    public void U(int i6) {
        this.f39127l = i6;
    }

    public boolean U0() {
        return this.f39114e0;
    }

    public void V(long j6) {
        if (j6 > 0) {
            this.f39133q = j6;
        }
    }

    public void W(String str) {
        this.H = str;
    }

    public void W0(int i6) {
        this.f39138v = i6;
    }

    public void X(boolean z5) {
        this.M = z5;
    }

    public void X0(long j6) {
        this.f39140x = j6;
    }

    public void Y(boolean z5) {
        this.G = z5;
    }

    public void Y0(String str) {
        this.f39113e = str;
    }

    public long Z() {
        return this.f39110c0;
    }

    public void Z0(boolean z5) {
        this.J = z5;
    }

    public String a0() {
        return this.f39130n;
    }

    public boolean a1() {
        return this.E;
    }

    @Override // com.ss.android.xt.j.xt.a
    public JSONObject ae() {
        return this.f39134r;
    }

    public void b(int i6) {
        this.f39135s = i6;
    }

    public String b0() {
        return this.Y;
    }

    public boolean b1() {
        return this.M;
    }

    public void c(long j6) {
        this.f39110c0 = j6;
    }

    public void c0(int i6) {
        this.f39123j = i6;
    }

    public boolean c1() {
        return this.f39122i0;
    }

    @Override // com.ss.android.xt.j.xt.a
    public boolean cw() {
        return this.f39132p;
    }

    public void d(String str) {
        this.I = str;
    }

    public void d0(long j6) {
        this.f39128l0 = j6;
    }

    public void e(boolean z5) {
        this.f39108b0 = z5;
    }

    public void e0(String str) {
        this.f39130n = str;
    }

    public void f0(boolean z5) {
        this.f39112d0 = z5;
    }

    @Override // com.ss.android.xt.j.xt.a
    public String g() {
        return this.I;
    }

    public long g0() {
        return this.f39140x;
    }

    public String h() {
        return this.f39126k0;
    }

    public com.ss.android.xt.j.j.a h0() {
        return new a.C0804a().I(this.f39105a).y(this.f39107b).J(this.f39109c).e(this.f39113e).q(this.f39134r).r(this.f39132p).H(this.f39127l).x(this.f39129m).D(this.f39115f).i(this.f39121i).B(this.D).a(this.f39130n).z(this.f39131o).G(this.f39126k0).l(new f(this.f39117g, this.f39119h, null)).s();
    }

    @Override // com.ss.android.xt.j.xt.a
    public boolean i() {
        return this.F;
    }

    public boolean i0() {
        return this.C;
    }

    public void j(boolean z5) {
        this.f39122i0 = z5;
    }

    public c j0() {
        return new c.a().g(this.H).l(this.I).c(this.J).j();
    }

    @Override // com.ss.android.xt.j.xt.a
    public boolean jy() {
        return this.J;
    }

    public long k() {
        return this.S;
    }

    public String k0() {
        return this.D;
    }

    public int l() {
        return this.Q;
    }

    public void l0(int i6) {
        this.f39125k = i6;
    }

    @Override // com.ss.android.xt.j.xt.a
    public String m() {
        return this.f39117g;
    }

    public void m0(long j6) {
        this.W = j6;
    }

    @Override // com.ss.android.xt.j.xt.a
    public int mi() {
        return this.f39135s;
    }

    public void n0(String str) {
        this.f39131o = str;
    }

    public void o(int i6) {
        this.f39142z = i6;
    }

    public void o0(boolean z5) {
        this.f39114e0 = z5;
    }

    @Override // com.ss.android.xt.j.xt.a
    public String oq() {
        return this.H;
    }

    public void p(long j6) {
        this.f39141y = j6;
    }

    public void p0(int i6) {
        this.A = i6;
    }

    public void q(String str) {
        this.f39109c = str;
    }

    public void q0(long j6) {
        this.f39105a = j6;
    }

    public void r(boolean z5) {
        this.f39136t = z5;
    }

    public void r0(String str) {
        this.f39129m = str;
    }

    public long s() {
        return this.T;
    }

    public void s0(boolean z5) {
        this.Z = z5;
    }

    public String t() {
        return this.f39129m;
    }

    public int t0() {
        return this.f39123j;
    }

    @Override // com.ss.android.xt.j.xt.a
    public int tl() {
        return this.R;
    }

    public void u(boolean z5) {
        this.f39124j0 = z5;
    }

    public int u0() {
        return this.f39111d;
    }

    @Override // com.ss.android.xt.j.xt.a
    public String up() {
        return this.f39113e;
    }

    public long v0() {
        return this.f39128l0;
    }

    @Override // com.ss.android.xt.j.xt.a
    public long vl() {
        return this.f39107b;
    }

    public boolean w0() {
        return this.f39120h0;
    }

    public boolean x() {
        return this.f39116f0;
    }

    public int x0() {
        return this.f39138v;
    }

    @Override // com.ss.android.xt.j.xt.a
    public long xt() {
        return this.f39105a;
    }

    public void y(int i6) {
        this.R = i6;
    }

    public boolean y0() {
        return this.f39112d0;
    }

    public void z(long j6) {
        this.T = j6;
    }

    public JSONObject z0() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mId", this.f39105a);
            jSONObject.put("mExtValue", this.f39107b);
            jSONObject.put("mLogExtra", this.f39109c);
            jSONObject.put("mDownloadStatus", this.f39111d);
            jSONObject.put("mPackageName", this.f39113e);
            jSONObject.put("mIsAd", this.f39132p);
            jSONObject.put("mTimeStamp", this.f39133q);
            jSONObject.put("mExtras", this.f39134r);
            jSONObject.put("mVersionCode", this.f39127l);
            jSONObject.put("mVersionName", this.f39129m);
            jSONObject.put("mDownloadId", this.f39135s);
            jSONObject.put("mIsV3Event", this.J);
            jSONObject.put("mScene", this.Q);
            jSONObject.put("mEventTag", this.H);
            jSONObject.put("mEventRefer", this.I);
            jSONObject.put("mDownloadUrl", this.f39115f);
            jSONObject.put("mEnableBackDialog", this.f39136t);
            jSONObject.put("hasSendInstallFinish", this.N.get());
            jSONObject.put("hasSendDownloadFailedFinally", this.O.get());
            jSONObject.put("hasDoRebootMarketInstallFinishCheck", this.P.get());
            jSONObject.put("mLastFailedErrCode", this.A);
            jSONObject.put("mLastFailedErrMsg", this.B);
            jSONObject.put("mOpenUrl", this.f39117g);
            jSONObject.put("mLinkMode", this.f39123j);
            jSONObject.put("mDownloadMode", this.f39125k);
            jSONObject.put("mModelType", this.f39121i);
            jSONObject.put("mAppName", this.f39130n);
            jSONObject.put("mAppIcon", this.f39131o);
            jSONObject.put("mDownloadFailedTimes", this.f39137u);
            long j6 = this.f39139w;
            if (j6 == 0) {
                j6 = this.f39133q;
            }
            jSONObject.put("mRecentDownloadResumeTime", j6);
            jSONObject.put("mClickPauseTimes", this.f39138v);
            jSONObject.put("mJumpInstallTime", this.f39140x);
            jSONObject.put("mCancelInstallTime", this.f39141y);
            jSONObject.put("mLastFailedResumeCount", this.f39142z);
            jSONObject.put("mIsUpdateDownload", this.C);
            jSONObject.put("mOriginMimeType", this.D);
            jSONObject.put("mIsPatchApplyHandled", this.E);
            jSONObject.put("downloadFinishReason", this.Y);
            jSONObject.put("clickDownloadTime", this.S);
            jSONObject.put("clickDownloadSize", this.T);
            jSONObject.put("installAfterCleanSpace", this.M);
            jSONObject.put("funnelType", this.R);
            jSONObject.put("webUrl", this.f39119h);
            jSONObject.put("enableShowComplianceDialog", this.U);
            jSONObject.put("isAutoDownloadOnCardShow", this.V);
            jSONObject.put("enable_new_activity", this.F ? 1 : 0);
            jSONObject.put("enable_pause", this.G ? 1 : 0);
            jSONObject.put("enable_ah", this.K ? 1 : 0);
            jSONObject.put("enable_am", this.L ? 1 : 0);
            jSONObject.putOpt("intent_jump_browser_success", Boolean.valueOf(this.f39124j0));
            jSONObject.put("task_key", this.f39126k0);
            jSONObject.putOpt("market_install_finish_check_start_timestamp", Long.valueOf(this.f39128l0));
            jSONObject.putOpt("download_pause_timestamp", Long.valueOf(this.W));
            jSONObject.putOpt("download_finish_timestamp", Long.valueOf(this.X));
            return jSONObject;
        } catch (Exception e6) {
            m.w().j(e6, "NativeDownloadModel toJson");
            return jSONObject;
        }
    }

    @Override // com.ss.android.xt.j.xt.a
    public g f() {
        return j0();
    }

    @Override // com.ss.android.xt.j.xt.a
    public com.ss.android.j.j.cw.b tj() {
        return h0();
    }

    @Override // com.ss.android.xt.j.xt.a
    public com.ss.android.j.j.cw.c v() {
        return P0();
    }

    public b(com.ss.android.j.j.cw.b bVar, g gVar, com.ss.android.j.j.cw.c cVar) {
        this(bVar, gVar, cVar, 0);
    }

    public b(com.ss.android.j.j.cw.b bVar, g gVar, com.ss.android.j.j.cw.c cVar, int i6) {
        this.f39111d = 1;
        this.f39132p = true;
        this.f39136t = false;
        this.f39137u = 0;
        this.f39138v = 0;
        this.C = false;
        this.E = false;
        this.F = true;
        this.G = true;
        this.K = true;
        this.L = true;
        this.N = new AtomicBoolean(false);
        this.O = new AtomicBoolean(false);
        this.P = new AtomicBoolean(false);
        this.R = 1;
        this.U = true;
        this.f39110c0 = -1L;
        this.f39105a = bVar.r();
        this.f39107b = bVar.ae();
        this.f39109c = bVar.ch();
        this.f39113e = bVar.s();
        this.f39134r = bVar.h();
        this.f39132p = bVar.x();
        this.f39127l = bVar.f();
        this.f39129m = bVar.v();
        this.f39115f = bVar.j();
        if (bVar.l() != null) {
            this.f39117g = bVar.l().f();
            this.f39119h = bVar.l().b();
        }
        this.f39121i = bVar.la();
        this.f39130n = bVar.tl();
        this.f39131o = bVar.a();
        this.D = bVar.g();
        this.H = gVar.xt();
        this.I = gVar.j();
        this.J = gVar.jy();
        this.f39136t = cVar.cw();
        this.f39123j = cVar.j();
        this.f39125k = cVar.xt();
        this.U = cVar.vl();
        this.V = cVar.jy();
        this.F = cVar.ws();
        this.K = cVar.az();
        this.L = cVar.av();
        this.f39135s = i6;
        long currentTimeMillis = System.currentTimeMillis();
        this.f39133q = currentTimeMillis;
        this.f39139w = currentTimeMillis;
        this.E = bVar.uf();
        if (bVar instanceof com.ss.android.xt.j.j.a) {
            this.f39126k0 = ((com.ss.android.xt.j.j.a) bVar).k();
        }
    }
}
