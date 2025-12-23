package xyz.adscope.ad;

import android.content.Context;
import com.stub.StubApp;
import xyz.adscope.ad.i4;
import xyz.adscope.ad.n3;
import xyz.adscope.common.v2.dev.info.ScreenUtil;
import xyz.adscope.common.v2.model.IBaseMacrosMappingModel;
import xyz.adscope.common.v2.model.annotation.MacrosReplace;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class s4 extends IBaseMacrosMappingModel {

    @MacrosReplace(macros = "__ABS_ADY__")
    private String A;

    @MacrosReplace(macros = "__ABS_WIDTH__")
    private String B;

    @MacrosReplace(macros = "__ABS_HEIGHT__")
    private String C;

    @MacrosReplace(macros = "__ABS_SRC_DOWN_X__")
    private String D;

    @MacrosReplace(macros = "__ABS_SRC_DOWN_Y__")
    private String E;

    @MacrosReplace(macros = "__ABS_SRC_UP_X__")
    private String F;

    @MacrosReplace(macros = "__ABS_SRC_UP_Y__")
    private String G;

    @MacrosReplace(macros = "__ABS_AD_DOWN_X__")
    private String H;

    @MacrosReplace(macros = "__ABS_AD_DOWN_Y__")
    private String I;

    @MacrosReplace(macros = "__ABS_AD_UP_X__")
    private String J;

    @MacrosReplace(macros = "__ABS_AD_UP_Y__")
    private String K;

    @MacrosReplace(macros = "__ABS_MAT_DOWN_X__")
    private String L;

    @MacrosReplace(macros = "__ABS_MAT_DOWN_Y__")
    private String M;

    @MacrosReplace(macros = "__ABS_MAT_UP_X__")
    private String N;

    @MacrosReplace(macros = "__ABS_MAT_UP_Y__")
    private String O;

    /* renamed from: a, reason: collision with root package name */
    private final String f55934a = "-999";

    /* renamed from: b, reason: collision with root package name */
    private final Context f55935b;

    /* renamed from: c, reason: collision with root package name */
    private int f55936c;

    /* renamed from: d, reason: collision with root package name */
    @MacrosReplace(macros = "__REQUESTUUID__")
    private final String f55937d;

    /* renamed from: e, reason: collision with root package name */
    @MacrosReplace(macros = "__TS__")
    private final String f55938e;

    /* renamed from: f, reason: collision with root package name */
    @MacrosReplace(macros = "__ACTION__")
    private final String f55939f;

    /* renamed from: g, reason: collision with root package name */
    @MacrosReplace(macros = "__INTERACTIVE__")
    private String f55940g;

    /* renamed from: h, reason: collision with root package name */
    @MacrosReplace(macros = "__ADX__")
    private String f55941h;

    /* renamed from: i, reason: collision with root package name */
    @MacrosReplace(macros = "__ADY__")
    private String f55942i;

    /* renamed from: j, reason: collision with root package name */
    @MacrosReplace(macros = "__WIDTH__")
    private String f55943j;

    /* renamed from: k, reason: collision with root package name */
    @MacrosReplace(macros = "__HEIGHT__")
    private String f55944k;

    /* renamed from: l, reason: collision with root package name */
    @MacrosReplace(macros = "__DOWN_TS__")
    private String f55945l;

    /* renamed from: m, reason: collision with root package name */
    @MacrosReplace(macros = "__UP_TS__")
    private String f55946m;

    /* renamed from: n, reason: collision with root package name */
    @MacrosReplace(macros = "__SRC_DOWN_X__")
    private String f55947n;

    /* renamed from: o, reason: collision with root package name */
    @MacrosReplace(macros = "__SRC_DOWN_Y__")
    private String f55948o;

    /* renamed from: p, reason: collision with root package name */
    @MacrosReplace(macros = "__SRC_UP_X__")
    private String f55949p;

    /* renamed from: q, reason: collision with root package name */
    @MacrosReplace(macros = "__SRC_UP_Y__")
    private String f55950q;

    /* renamed from: r, reason: collision with root package name */
    @MacrosReplace(macros = "__AD_DOWN_X__")
    private String f55951r;

    /* renamed from: s, reason: collision with root package name */
    @MacrosReplace(macros = "__AD_DOWN_Y__")
    private String f55952s;

    /* renamed from: t, reason: collision with root package name */
    @MacrosReplace(macros = "__AD_UP_X__")
    private String f55953t;

    /* renamed from: u, reason: collision with root package name */
    @MacrosReplace(macros = "__AD_UP_Y__")
    private String f55954u;

    /* renamed from: v, reason: collision with root package name */
    @MacrosReplace(macros = "__MAT_DOWN_X__")
    private String f55955v;

    /* renamed from: w, reason: collision with root package name */
    @MacrosReplace(macros = "__MAT_DOWN_Y__")
    private String f55956w;

    /* renamed from: x, reason: collision with root package name */
    @MacrosReplace(macros = "__MAT_UP_X__")
    private String f55957x;

    /* renamed from: y, reason: collision with root package name */
    @MacrosReplace(macros = "__MAT_UP_Y__")
    private String f55958y;

    /* renamed from: z, reason: collision with root package name */
    @MacrosReplace(macros = "__ABS_ADX__")
    private String f55959z;

    private void a(i4.b bVar) {
        float d6 = bVar.d();
        float a6 = bVar.a();
        if (this.f55936c != n3.a.CLICK_INTERACTIVE_TRIGGER.getEventCode() && this.f55936c != n3.a.GESTURE_INTERACTIVE_TRIGGER.getEventCode()) {
            this.f55951r = "-999";
            this.H = "-999";
            this.f55955v = "-999";
            this.L = "-999";
            this.f55947n = "-999";
            this.D = "-999";
            return;
        }
        this.f55945l = bVar.c() + "";
        this.f55951r = d6 + "";
        this.H = a(d6) + "";
        this.f55955v = d6 + "";
        this.L = a(d6) + "";
        this.f55947n = a6 + "";
        this.D = a(a6) + "";
    }

    s4(Context context, l2 l2Var, b1 b1Var) {
        this.f55935b = StubApp.getOrigApplicationContext(context.getApplicationContext());
        StringBuilder sb = new StringBuilder();
        sb.append(l2Var.getEventCode());
        String str = "";
        sb.append("");
        this.f55939f = sb.toString();
        this.f55937d = b1Var.t();
        this.f55938e = System.currentTimeMillis() + "";
        int m6 = b1Var.m();
        this.f55936c = m6;
        if (m6 != -1) {
            str = this.f55936c + "";
        }
        this.f55940g = str;
        i4.b x5 = b1Var.x();
        if (x5 != null) {
            g(x5);
            h(x5);
            f(x5);
            e(x5);
            a(x5);
            b(x5);
            c(x5);
            d(x5);
        }
    }

    private void b(i4.b bVar) {
        float e6 = bVar.e();
        float b6 = bVar.b();
        if (this.f55936c != n3.a.CLICK_INTERACTIVE_TRIGGER.getEventCode() && this.f55936c != n3.a.GESTURE_INTERACTIVE_TRIGGER.getEventCode()) {
            this.f55952s = "-999";
            this.I = "-999";
            this.f55956w = "-999";
            this.M = "-999";
            this.f55948o = "-999";
            this.E = "-999";
            return;
        }
        this.f55952s = e6 + "";
        this.I = a(e6) + "";
        this.f55956w = e6 + "";
        this.M = a(e6) + "";
        this.f55948o = b6 + "";
        this.E = a(b6) + "";
    }

    private void c(i4.b bVar) {
        float i6 = bVar.i();
        float f6 = bVar.f();
        if (this.f55936c != n3.a.CLICK_INTERACTIVE_TRIGGER.getEventCode() && this.f55936c != n3.a.GESTURE_INTERACTIVE_TRIGGER.getEventCode()) {
            this.f55953t = "-999";
            this.J = "-999";
            this.f55957x = "-999";
            this.N = "-999";
            this.f55949p = "-999";
            this.F = "-999";
            return;
        }
        this.f55946m = bVar.h() + "";
        this.f55953t = i6 + "";
        this.J = a(i6) + "";
        this.f55957x = i6 + "";
        this.N = a(i6) + "";
        this.f55949p = f6 + "";
        this.F = a(f6) + "";
    }

    private void d(i4.b bVar) {
        float j6 = bVar.j();
        float g6 = bVar.g();
        if (this.f55936c != n3.a.CLICK_INTERACTIVE_TRIGGER.getEventCode() && this.f55936c != n3.a.GESTURE_INTERACTIVE_TRIGGER.getEventCode()) {
            this.f55954u = "-999";
            this.K = "-999";
            this.f55958y = "-999";
            this.O = "-999";
            this.f55950q = "-999";
            this.G = "-999";
            return;
        }
        this.f55954u = j6 + "";
        this.K = a(j6) + "";
        this.f55958y = j6 + "";
        this.O = a(j6) + "";
        this.f55950q = g6 + "";
        this.G = a(g6) + "";
    }

    private void e(i4.b bVar) {
        float k6 = bVar.k();
        this.f55944k = k6 + "";
        this.C = a(k6) + "";
    }

    private void f(i4.b bVar) {
        float l6 = bVar.l();
        this.f55943j = l6 + "";
        this.B = a(l6) + "";
    }

    private void g(i4.b bVar) {
        float m6 = bVar.m();
        this.f55941h = m6 + "";
        this.f55959z = a(m6) + "";
    }

    private void h(i4.b bVar) {
        float n6 = bVar.n();
        this.f55942i = n6 + "";
        this.A = a(n6) + "";
    }

    private String a(float f6) {
        return ScreenUtil.Calculate.px2dip(this.f55935b, f6) + "";
    }
}
