package com.ss.android.socialbase.appdownloader;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import com.ss.android.socialbase.downloader.ae.up;
import com.ss.android.socialbase.downloader.downloader.kt;
import com.ss.android.socialbase.downloader.downloader.oq;
import com.ss.android.socialbase.downloader.r.az;
import com.ss.android.socialbase.downloader.r.l;
import com.ss.android.socialbase.downloader.r.mi;
import com.ss.android.socialbase.downloader.r.tj;
import com.ss.android.socialbase.downloader.r.wq;
import com.ss.android.socialbase.downloader.r.ws;
import com.ss.android.socialbase.downloader.xt.ae;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes6.dex */
public class e {
    private boolean A;
    private int C;
    private boolean D;
    private String E;
    private boolean G;
    private boolean H;
    private boolean I;
    private int L;
    private l N;
    private az O;
    private x2.h P;
    private tj Q;
    private mi R;
    private boolean S;
    private wq T;
    private boolean U;
    private JSONObject V;
    private String W;
    private int Y;
    private long Z;

    /* renamed from: a, reason: collision with root package name */
    private Activity f38364a;

    /* renamed from: a0, reason: collision with root package name */
    private int f38365a0;

    /* renamed from: b, reason: collision with root package name */
    private Context f38366b;

    /* renamed from: b0, reason: collision with root package name */
    private boolean f38367b0;

    /* renamed from: c, reason: collision with root package name */
    private String f38368c;

    /* renamed from: d, reason: collision with root package name */
    private List<String> f38370d;

    /* renamed from: d0, reason: collision with root package name */
    private String f38371d0;

    /* renamed from: e, reason: collision with root package name */
    private String f38372e;

    /* renamed from: f, reason: collision with root package name */
    private String f38374f;

    /* renamed from: f0, reason: collision with root package name */
    private String f38375f0;

    /* renamed from: g, reason: collision with root package name */
    private String f38376g;

    /* renamed from: g0, reason: collision with root package name */
    private int[] f38377g0;

    /* renamed from: h, reason: collision with root package name */
    private List<up> f38378h;

    /* renamed from: m, reason: collision with root package name */
    private com.ss.android.socialbase.downloader.r.a f38383m;

    /* renamed from: n, reason: collision with root package name */
    private com.ss.android.socialbase.downloader.r.a f38384n;

    /* renamed from: o, reason: collision with root package name */
    private String f38385o;

    /* renamed from: q, reason: collision with root package name */
    private boolean f38387q;

    /* renamed from: r, reason: collision with root package name */
    private com.ss.android.socialbase.downloader.downloader.g f38388r;

    /* renamed from: s, reason: collision with root package name */
    private oq f38389s;

    /* renamed from: t, reason: collision with root package name */
    private kt f38390t;

    /* renamed from: u, reason: collision with root package name */
    private com.ss.android.socialbase.downloader.notification.j f38391u;

    /* renamed from: v, reason: collision with root package name */
    private boolean f38392v;

    /* renamed from: w, reason: collision with root package name */
    private boolean f38393w;

    /* renamed from: x, reason: collision with root package name */
    private String f38394x;

    /* renamed from: y, reason: collision with root package name */
    private String f38395y;

    /* renamed from: z, reason: collision with root package name */
    private long f38396z;

    /* renamed from: i, reason: collision with root package name */
    private boolean f38379i = true;

    /* renamed from: j, reason: collision with root package name */
    private boolean f38380j = false;

    /* renamed from: k, reason: collision with root package name */
    private boolean f38381k = true;

    /* renamed from: l, reason: collision with root package name */
    private boolean f38382l = false;

    /* renamed from: p, reason: collision with root package name */
    private String f38386p = "application/vnd.android.package-archive";
    private int B = 5;
    private boolean F = true;
    private ae J = ae.ENQUEUE_NONE;
    private int K = 150;
    private boolean M = true;
    private List<ws> X = new ArrayList();

    /* renamed from: c0, reason: collision with root package name */
    private boolean f38369c0 = true;

    /* renamed from: e0, reason: collision with root package name */
    private boolean f38373e0 = true;

    public String A() {
        return this.f38371d0;
    }

    public e A0(int i6) {
        this.L = i6;
        return this;
    }

    public boolean B() {
        return this.f38392v;
    }

    public e B0(String str) {
        this.f38385o = str;
        return this;
    }

    public e C(long j6) {
        this.f38396z = j6;
        return this;
    }

    public e C0(boolean z5) {
        this.f38392v = z5;
        return this;
    }

    public e D(com.ss.android.socialbase.downloader.r.a aVar) {
        this.f38383m = aVar;
        return this;
    }

    public boolean D0() {
        return this.f38379i;
    }

    public e E(mi miVar) {
        this.R = miVar;
        return this;
    }

    public int E0() {
        return this.B;
    }

    public e F(tj tjVar) {
        this.Q = tjVar;
        return this;
    }

    public e F0(boolean z5) {
        this.I = z5;
        return this;
    }

    public e G(ws wsVar) {
        synchronized (this.X) {
            if (wsVar != null) {
                try {
                    if (!this.X.contains(wsVar)) {
                        this.X.add(wsVar);
                        return this;
                    }
                } finally {
                }
            }
            return this;
        }
    }

    public String G0() {
        return this.f38386p;
    }

    public e H(ae aeVar) {
        this.J = aeVar;
        return this;
    }

    public boolean H0() {
        return this.f38393w;
    }

    public e I(String str) {
        this.f38372e = str;
        return this;
    }

    public boolean I0() {
        return this.M;
    }

    public e J(List<up> list) {
        this.f38378h = list;
        return this;
    }

    public e J0(boolean z5) {
        this.A = z5;
        return this;
    }

    public e K(JSONObject jSONObject) {
        this.V = jSONObject;
        return this;
    }

    public com.ss.android.socialbase.downloader.notification.j K0() {
        return this.f38391u;
    }

    public e L(boolean z5) {
        this.f38379i = z5;
        return this;
    }

    public int L0() {
        return this.C;
    }

    public String M() {
        return this.f38368c;
    }

    public boolean M0() {
        return this.f38367b0;
    }

    public void N(int i6) {
        this.f38365a0 = i6;
    }

    public e N0(int i6) {
        this.B = i6;
        return this;
    }

    public e O(boolean z5) {
        this.M = z5;
        return this;
    }

    public e O0(String str) {
        this.f38374f = str;
        return this;
    }

    public boolean P() {
        return this.f38387q;
    }

    public e P0(List<String> list) {
        this.f38370d = list;
        return this;
    }

    public boolean Q() {
        return this.f38369c0;
    }

    public e Q0(boolean z5) {
        this.f38380j = z5;
        return this;
    }

    public JSONObject R() {
        return this.V;
    }

    public String R0() {
        return this.f38372e;
    }

    public String S() {
        return this.f38394x;
    }

    public String S0() {
        return this.f38375f0;
    }

    public boolean T() {
        return this.G;
    }

    public List<ws> T0() {
        return this.X;
    }

    public int U() {
        return this.L;
    }

    public mi U0() {
        return this.R;
    }

    public e V(int i6) {
        this.Y = i6;
        return this;
    }

    public e W(String str) {
        this.f38386p = str;
        return this;
    }

    public e X(boolean z5) {
        this.f38393w = z5;
        return this;
    }

    public boolean Y() {
        return this.f38380j;
    }

    public int Z() {
        return this.f38365a0;
    }

    public boolean a() {
        return this.F;
    }

    public l a0() {
        return this.N;
    }

    public e b(String str) {
        this.f38394x = str;
        return this;
    }

    public az b0() {
        return this.O;
    }

    public e c(boolean z5) {
        this.D = z5;
        return this;
    }

    public tj c0() {
        return this.Q;
    }

    public boolean d() {
        return this.f38381k;
    }

    public e d0(String str) {
        this.f38375f0 = str;
        return this;
    }

    public e e(boolean z5) {
        this.f38369c0 = z5;
        return this;
    }

    public e e0(boolean z5) {
        this.G = z5;
        return this;
    }

    public com.ss.android.socialbase.downloader.downloader.g f() {
        return this.f38388r;
    }

    public com.ss.android.socialbase.downloader.r.a f0() {
        return this.f38384n;
    }

    public e g(boolean z5) {
        this.f38367b0 = z5;
        return this;
    }

    public kt g0() {
        return this.f38390t;
    }

    public Activity getActivity() {
        return this.f38364a;
    }

    public Context getContext() {
        return this.f38366b;
    }

    public oq h() {
        return this.f38389s;
    }

    public long h0() {
        return this.Z;
    }

    public boolean i() {
        return this.U;
    }

    public boolean i0() {
        return this.f38373e0;
    }

    public boolean j() {
        return this.A;
    }

    public e j0(String str) {
        this.W = str;
        return this;
    }

    public boolean k() {
        return this.D;
    }

    public e k0(boolean z5) {
        this.H = z5;
        return this;
    }

    public e l(int i6) {
        this.C = i6;
        return this;
    }

    public String l0() {
        return this.f38385o;
    }

    public e m(@NonNull String str) {
        this.f38376g = str;
        return this;
    }

    public e m0(int i6) {
        this.K = i6;
        return this;
    }

    public e n(boolean z5) {
        this.f38382l = z5;
        return this;
    }

    public e n0(String str) {
        this.f38371d0 = str;
        return this;
    }

    public String o() {
        return this.f38376g;
    }

    public e o0(boolean z5) {
        this.f38387q = z5;
        return this;
    }

    public int p() {
        return this.Y;
    }

    public List<up> p0() {
        return this.f38378h;
    }

    public ae q() {
        return this.J;
    }

    public x2.h q0() {
        return this.P;
    }

    public long r() {
        return this.f38396z;
    }

    public boolean r0() {
        return this.I;
    }

    public String s() {
        return this.W;
    }

    public List<String> s0() {
        return this.f38370d;
    }

    public e t(String str) {
        this.E = str;
        return this;
    }

    public String t0() {
        return this.E;
    }

    public e u(boolean z5) {
        this.F = z5;
        return this;
    }

    public int[] u0() {
        return this.f38377g0;
    }

    public com.ss.android.socialbase.downloader.r.a v() {
        return this.f38383m;
    }

    public String v0() {
        return this.f38395y;
    }

    public boolean w() {
        return this.H;
    }

    public e w0(String str) {
        this.f38395y = str;
        return this;
    }

    public String x() {
        return this.f38374f;
    }

    public e x0(boolean z5) {
        this.S = z5;
        return this;
    }

    public int y() {
        return this.K;
    }

    public boolean y0() {
        return this.f38382l;
    }

    public wq z() {
        return this.T;
    }

    public boolean z0() {
        return this.S;
    }

    public e(@NonNull Context context, @NonNull String str) {
        this.f38366b = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.f38368c = str;
    }
}
