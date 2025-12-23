package com.bxkj.base.v2.data;

import android.content.Intent;
import android.webkit.WebStorage;
import androidx.collection.ArrayMap;
import cn.bluemobi.dylan.base.utils.r;
import cn.bluemobi.dylan.http.JsonParse;
import cn.jpush.android.local.JPushConstants;
import com.alibaba.fastjson.JSON;
import com.bxkj.base.BaseApp;
import com.bxkj.base.v2.netty4android.service.NettySocketService;
import com.orhanobut.logger.j;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.LazyThreadSafetyMode;
import kotlin.collections.i1;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import kotlin.s;
import kotlin.t;
import kotlin.text.u;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class b {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final a f16998d = new a(null);

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static final s<b> f16999e = t.b(LazyThreadSafetyMode.SYNCHRONIZED, new Function0() { // from class: com.bxkj.base.v2.data.a
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            b X;
            X = b.X();
            return X;
        }
    });

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final r f17000a = new r(BaseApp.c());

    /* renamed from: b, reason: collision with root package name */
    private boolean f17001b;

    /* renamed from: c, reason: collision with root package name */
    private long f17002c;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        public /* synthetic */ a(v vVar) {
            this();
        }

        private a() {
        }

        @NotNull
        public final b a() {
            return (b) b.f16999e.getValue();
        }
    }

    public final void c() {
        n0(false);
        Q0(0L);
        R0(0);
        t0(0L);
        u0(0L);
        v0(0L);
        h0("");
        W0("");
        E0(false);
        w0(0L);
        N0("");
        g0(false);
        WebStorage.getInstance().deleteAllData();
        BaseApp.c().deleteDatabase("webview.db");
        BaseApp.c().deleteDatabase("webviewCache.db");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b X() {
        return new b();
    }

    @NotNull
    public final String A() {
        Object b6 = this.f17000a.b("lastUploadTime", e.f17017a.a().i());
        g0.n(b6, "null cannot be cast to non-null type kotlin.String");
        return (String) b6;
    }

    public final void A0(@NotNull String value) {
        g0.p(value, "value");
        this.f17000a.d("nettySocketIp", value);
    }

    @NotNull
    public final String B() {
        Object b6 = this.f17000a.b("nettySocketIp", "");
        g0.n(b6, "null cannot be cast to non-null type kotlin.String");
        return (String) b6;
    }

    public final void B0(int i6) {
        this.f17000a.d("nettySocketPort", Integer.valueOf(i6));
    }

    public final int C() {
        Object b6 = this.f17000a.b("nettySocketPort", 0);
        g0.n(b6, "null cannot be cast to non-null type kotlin.Int");
        return ((Integer) b6).intValue();
    }

    public final void C0(@NotNull String value) {
        g0.p(value, "value");
        this.f17000a.d("nettySocketSecret", value);
    }

    @NotNull
    public final String D() {
        Object b6 = this.f17000a.b("nettySocketSecret", "");
        g0.n(b6, "null cannot be cast to non-null type kotlin.String");
        return (String) b6;
    }

    public final void D0(int i6) {
        this.f17000a.d("nfcCardType", Integer.valueOf(i6));
    }

    public final int E() {
        Object b6 = this.f17000a.b("nfcCardType", Integer.valueOf(e.f17017a.a().j()));
        g0.n(b6, "null cannot be cast to non-null type kotlin.Int");
        return ((Integer) b6).intValue();
    }

    public final void E0(boolean z5) {
        this.f17000a.d("noPrompt", Boolean.valueOf(z5));
    }

    public final boolean F() {
        Object b6 = this.f17000a.b("noPrompt", Boolean.FALSE);
        g0.n(b6, "null cannot be cast to non-null type kotlin.Boolean");
        return ((Boolean) b6).booleanValue();
    }

    public final void F0(int i6) {
        this.f17000a.d("isOpenGGLBT", Integer.valueOf(i6));
    }

    public final int G() {
        Object b6 = this.f17000a.b("openPhoneLogin", 0);
        g0.n(b6, "null cannot be cast to non-null type kotlin.Int");
        return ((Integer) b6).intValue();
    }

    public final void G0(int i6) {
        this.f17000a.d("isOpenLive", Integer.valueOf(i6));
    }

    public final int H() {
        Object b6 = this.f17000a.b("queryStudentType", Integer.valueOf(e.f17017a.a().k()));
        g0.n(b6, "null cannot be cast to non-null type kotlin.Int");
        return ((Integer) b6).intValue();
    }

    public final void H0(int i6) {
        this.f17000a.d("openPhoneLogin", Integer.valueOf(i6));
    }

    @NotNull
    public final String I() {
        Object b6 = this.f17000a.b("refreshToken", e.f17017a.a().l());
        g0.n(b6, "null cannot be cast to non-null type kotlin.String");
        return (String) b6;
    }

    public final void I0(int i6) {
        this.f17000a.d("isOpenSQZS", Integer.valueOf(i6));
    }

    @NotNull
    public final String J() {
        Object b6 = this.f17000a.b("schoolCode", e.f17017a.a().m());
        g0.n(b6, "null cannot be cast to non-null type kotlin.String");
        return (String) b6;
    }

    public final void J0(int i6) {
        this.f17000a.d("queryStudentType", Integer.valueOf(i6));
    }

    @NotNull
    public final String K() {
        Object b6 = this.f17000a.b("schoolLogoUrl", "");
        g0.n(b6, "null cannot be cast to non-null type kotlin.String");
        return (String) b6;
    }

    public final void K0(@NotNull String value) {
        g0.p(value, "value");
        this.f17000a.d("refreshToken", value);
    }

    @NotNull
    public final String L() {
        Object b6 = this.f17000a.b("schoolName", e.f17017a.a().n());
        g0.n(b6, "null cannot be cast to non-null type kotlin.String");
        return (String) b6;
    }

    public final void L0(boolean z5) {
        if (z5) {
            Intent intent = new Intent();
            intent.setAction(BaseApp.c().getPackageName() + ".REFRESH_TOKEN_FINISH");
            BaseApp.c().sendBroadcast(intent, BaseApp.c().getPackageName() + ".sports.permissions.V3_Sports_BROADCAST");
        }
        this.f17001b = z5;
    }

    @NotNull
    public final String M() {
        r rVar = this.f17000a;
        c0.b bVar = c0.b.f1042a;
        BaseApp c6 = BaseApp.c();
        g0.o(c6, "getApp(...)");
        Object b6 = rVar.b("schoolUrl", bVar.l(c6, "05dbfd8c595b3687f8351745f27c449b"));
        g0.n(b6, "null cannot be cast to non-null type kotlin.String");
        String str = (String) b6;
        if (!u.H2(str, JPushConstants.HTTP_PRE, false, 2, null) && !u.H2(str, JPushConstants.HTTPS_PRE, false, 2, null)) {
            BaseApp c7 = BaseApp.c();
            g0.o(c7, "getApp(...)");
            str = bVar.l(c7, "05dbfd8c595b3687f8351745f27c449b");
        }
        if (u.Z1(str, "/", false, 2, null)) {
            return str;
        }
        return str + "/";
    }

    public final void M0(@NotNull String value) {
        g0.p(value, "value");
        this.f17000a.d("schoolCode", value);
    }

    public final long N() {
        Object b6 = this.f17000a.b("serverLastTime", 0L);
        g0.n(b6, "null cannot be cast to non-null type kotlin.Long");
        return ((Long) b6).longValue();
    }

    public final void N0(@NotNull String value) {
        g0.p(value, "value");
        this.f17000a.d("schoolLogoUrl", value);
    }

    public final int O() {
        Object b6 = this.f17000a.b("serverOpen", 0);
        g0.n(b6, "null cannot be cast to non-null type kotlin.Int");
        return ((Integer) b6).intValue();
    }

    public final void O0(@NotNull String value) {
        g0.p(value, "value");
        this.f17000a.d("schoolName", value);
    }

    public final boolean P() {
        Object b6 = this.f17000a.b("skipBindPhone", Boolean.FALSE);
        g0.n(b6, "null cannot be cast to non-null type kotlin.Boolean");
        return ((Boolean) b6).booleanValue();
    }

    public final void P0(@NotNull String value) {
        g0.p(value, "value");
        this.f17000a.d("schoolUrl", value);
    }

    @NotNull
    public final Map<String, Object> Q() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Object b6 = this.f17000a.b("sportsSetMap", "");
        g0.n(b6, "null cannot be cast to non-null type kotlin.String");
        String str = (String) b6;
        if (str.length() <= 0) {
            return linkedHashMap;
        }
        ArrayMap<String, Object> jsonToMap = JsonParse.jsonToMap(str);
        g0.o(jsonToMap, "jsonToMap(...)");
        return i1.J0(jsonToMap);
    }

    public final void Q0(long j6) {
        this.f17000a.d("serverLastTime", Long.valueOf(j6));
    }

    @NotNull
    public final String R() {
        Object b6 = this.f17000a.b("userId", e.f17017a.a().o());
        g0.n(b6, "null cannot be cast to non-null type kotlin.String");
        return (String) b6;
    }

    public final void R0(int i6) {
        this.f17000a.d("serverOpen", Integer.valueOf(i6));
    }

    @NotNull
    public final String S() {
        Object b6 = this.f17000a.b("userNumber", e.f17017a.a().p());
        g0.n(b6, "null cannot be cast to non-null type kotlin.String");
        return (String) b6;
    }

    public final void S0(boolean z5) {
        this.f17000a.d("skipBindPhone", Boolean.valueOf(z5));
    }

    public final void T0(@NotNull Map<String, Object> value) {
        g0.p(value, "value");
        this.f17000a.d("sportsSetMap", JSON.toJSONString(value));
    }

    @NotNull
    public final String U() {
        Object b6 = this.f17000a.b("username", e.f17017a.a().q());
        g0.n(b6, "null cannot be cast to non-null type kotlin.String");
        return (String) b6;
    }

    public final void U0(@NotNull String value) {
        g0.p(value, "value");
        this.f17000a.d("userId", value);
    }

    public final boolean V() {
        Object b6 = this.f17000a.b("voiceOpen", Boolean.valueOf(e.f17017a.a().r()));
        g0.n(b6, "null cannot be cast to non-null type kotlin.Boolean");
        return ((Boolean) b6).booleanValue();
    }

    public final void V0(int i6) {
        this.f17000a.d("isJiguangPush", Integer.valueOf(i6));
    }

    public final int W() {
        Object b6 = this.f17000a.b("voiceType", Integer.valueOf(e.f17017a.a().s()));
        g0.n(b6, "null cannot be cast to non-null type kotlin.Int");
        return ((Integer) b6).intValue();
    }

    public final void W0(@NotNull String value) {
        g0.p(value, "value");
        this.f17000a.d("userNumber", value);
    }

    public final void X0(@NotNull String value) {
        g0.p(value, "value");
        this.f17000a.d("username", value);
    }

    public final boolean Y() {
        Object b6 = this.f17000a.b("isLogin", Boolean.valueOf(e.f17017a.a().u()));
        g0.n(b6, "null cannot be cast to non-null type kotlin.Boolean");
        return ((Boolean) b6).booleanValue();
    }

    public final void Y0(boolean z5) {
        this.f17000a.d("voiceOpen", Boolean.valueOf(z5));
    }

    public final int Z() {
        Object b6 = this.f17000a.b("isOpenGGLBT", 1);
        g0.n(b6, "null cannot be cast to non-null type kotlin.Int");
        return ((Integer) b6).intValue();
    }

    public final void Z0(int i6) {
        this.f17000a.d("voiceType", Integer.valueOf(i6));
    }

    public final int a0() {
        Object b6 = this.f17000a.b("isOpenLive", 0);
        g0.n(b6, "null cannot be cast to non-null type kotlin.Int");
        return ((Integer) b6).intValue();
    }

    public final int b0() {
        Object b6 = this.f17000a.b("isOpenSQZS", 1);
        g0.n(b6, "null cannot be cast to non-null type kotlin.Int");
        return ((Integer) b6).intValue();
    }

    public final boolean c0() {
        return this.f17001b;
    }

    public final void d() {
        a aVar = f16998d;
        aVar.a().f();
        aVar.a().R0(0);
        aVar.a().z0(false);
        aVar.a().U0("");
        aVar.a().X0("");
        aVar.a().e0("");
        aVar.a().K0("");
        aVar.a().E0(false);
        aVar.a().S0(false);
        aVar.a().E0(false);
        g0(false);
        aVar.a().r0("");
    }

    public final int d0() {
        Object b6 = this.f17000a.b("isJiguangPush", 1);
        g0.n(b6, "null cannot be cast to non-null type kotlin.Int");
        return ((Integer) b6).intValue();
    }

    public final void e0(@NotNull String value) {
        g0.p(value, "value");
        this.f17000a.d("accessToken", value);
    }

    public final void f0(boolean z5) {
        this.f17000a.d("adOpen", Boolean.valueOf(z5));
    }

    @NotNull
    public final String g() {
        Object b6 = this.f17000a.b("accessToken", e.f17017a.a().c());
        g0.n(b6, "null cannot be cast to non-null type kotlin.String");
        return (String) b6;
    }

    public final void g0(boolean z5) {
        this.f17000a.d("agreeFace", Boolean.valueOf(z5));
    }

    public final boolean h() {
        Object b6 = this.f17000a.b("adOpen", Boolean.TRUE);
        g0.n(b6, "null cannot be cast to non-null type kotlin.Boolean");
        return ((Boolean) b6).booleanValue();
    }

    public final void h0(@NotNull String value) {
        g0.p(value, "value");
        this.f17000a.d("appId", value);
    }

    public final boolean i() {
        Object b6 = this.f17000a.b("agreeFace", Boolean.FALSE);
        g0.n(b6, "null cannot be cast to non-null type kotlin.Boolean");
        return ((Boolean) b6).booleanValue();
    }

    public final void i0(@NotNull String value) {
        g0.p(value, "value");
        this.f17000a.d("bannerInfo", value);
    }

    @NotNull
    public final String j() {
        Object b6 = this.f17000a.b("appId", "");
        g0.n(b6, "null cannot be cast to non-null type kotlin.String");
        return (String) b6;
    }

    public final void j0(int i6) {
        this.f17000a.d("bindType", Integer.valueOf(i6));
    }

    @NotNull
    public final String k() {
        Object b6 = this.f17000a.b("bannerInfo", "");
        g0.n(b6, "null cannot be cast to non-null type kotlin.String");
        return (String) b6;
    }

    public final void k0(@NotNull String value) {
        g0.p(value, "value");
        this.f17000a.d("dept_id", value);
    }

    public final int l() {
        Object b6 = this.f17000a.b("bindType", Integer.valueOf(e.f17017a.a().e()));
        g0.n(b6, "null cannot be cast to non-null type kotlin.Int");
        return ((Integer) b6).intValue();
    }

    public final void l0(boolean z5) {
        this.f17000a.d("floatActionButtonShow", Boolean.valueOf(z5));
    }

    @NotNull
    public final String m() {
        Object b6 = this.f17000a.b("dept_id", "1");
        g0.n(b6, "null cannot be cast to non-null type kotlin.String");
        return (String) b6;
    }

    public final void m0(int i6) {
        this.f17000a.d("frequency", Integer.valueOf(i6));
    }

    public final boolean n() {
        Object b6 = this.f17000a.b("floatActionButtonShow", Boolean.TRUE);
        g0.n(b6, "null cannot be cast to non-null type kotlin.Boolean");
        return ((Boolean) b6).booleanValue();
    }

    public final void n0(boolean z5) {
        this.f17000a.d("hasShowInsideNetwork", Boolean.valueOf(z5));
    }

    public final int o() {
        Object b6 = this.f17000a.b("frequency", Integer.valueOf(e.f17017a.a().g()));
        g0.n(b6, "null cannot be cast to non-null type kotlin.Int");
        return ((Integer) b6).intValue();
    }

    public final void o0(@NotNull String value) {
        g0.p(value, "value");
        this.f17000a.d("informationLinkUrl", value);
    }

    public final boolean p() {
        Object b6 = this.f17000a.b("hasShowInsideNetwork", Boolean.FALSE);
        g0.n(b6, "null cannot be cast to non-null type kotlin.Boolean");
        return ((Boolean) b6).booleanValue();
    }

    public final void p0(int i6) {
        this.f17000a.d("insideNetwork", Integer.valueOf(i6));
    }

    @NotNull
    public final String q() {
        Object b6 = this.f17000a.b("informationLinkUrl", "");
        g0.n(b6, "null cannot be cast to non-null type kotlin.String");
        return (String) b6;
    }

    public final void q0(@NotNull String value) {
        g0.p(value, "value");
        this.f17000a.d("insideNetworkMsg", value);
    }

    public final int r() {
        Object b6 = this.f17000a.b("insideNetwork", 0);
        g0.n(b6, "null cannot be cast to non-null type kotlin.Int");
        return ((Integer) b6).intValue();
    }

    public final void r0(@NotNull String value) {
        g0.p(value, "value");
        this.f17000a.d("lastExerciseExplanationDate", value);
    }

    @NotNull
    public final String s() {
        Object b6 = this.f17000a.b("insideNetworkMsg", "温馨提示：请连接校园网使用app");
        g0.n(b6, "null cannot be cast to non-null type kotlin.String");
        return (String) b6;
    }

    public final void s0(long j6) {
        this.f17002c = j6;
    }

    @NotNull
    public final String t() {
        Object b6 = this.f17000a.b("lastExerciseExplanationDate", "");
        g0.n(b6, "null cannot be cast to non-null type kotlin.String");
        return (String) b6;
    }

    public final void t0(long j6) {
        this.f17000a.d("lastTimeGetBanner", Long.valueOf(j6));
    }

    public final long u() {
        return this.f17002c;
    }

    public final void u0(long j6) {
        this.f17000a.d("lastTimeGetHomeMenu", Long.valueOf(j6));
    }

    public final long v() {
        Object b6 = this.f17000a.b("lastTimeGetBanner", 0L);
        g0.n(b6, "null cannot be cast to non-null type kotlin.Long");
        return ((Long) b6).longValue();
    }

    public final void v0(long j6) {
        this.f17000a.d("lastTimeGetHomeNotice", Long.valueOf(j6));
    }

    public final long w() {
        Object b6 = this.f17000a.b("lastTimeGetHomeMenu", 0L);
        g0.n(b6, "null cannot be cast to non-null type kotlin.Long");
        return ((Long) b6).longValue();
    }

    public final void w0(long j6) {
        this.f17000a.d("lastTimeGetSchoolLogo", Long.valueOf(j6));
    }

    public final long x() {
        Object b6 = this.f17000a.b("lastTimeGetHomeNotice", 0L);
        g0.n(b6, "null cannot be cast to non-null type kotlin.Long");
        return ((Long) b6).longValue();
    }

    public final void x0(@NotNull String value) {
        g0.p(value, "value");
        this.f17000a.d("lastUpdateTime", value);
    }

    public final long y() {
        Object b6 = this.f17000a.b("lastTimeGetSchoolLogo", 0L);
        g0.n(b6, "null cannot be cast to non-null type kotlin.Long");
        return ((Long) b6).longValue();
    }

    public final void y0(@NotNull String value) {
        g0.p(value, "value");
        this.f17000a.d("lastUploadTime", value);
    }

    @NotNull
    public final String z() {
        Object b6 = this.f17000a.b("lastUpdateTime", e.f17017a.a().h());
        g0.n(b6, "null cannot be cast to non-null type kotlin.String");
        return (String) b6;
    }

    public final void z0(boolean z5) {
        this.f17000a.d("isLogin", Boolean.valueOf(z5));
        Intent intent = new Intent();
        intent.setAction(BaseApp.c().getPackageName() + ".LOGIN_STATUS_CHANGE");
        BaseApp.c().sendBroadcast(intent, BaseApp.c().getPackageName() + ".sports.permissions.V3_Sports_BROADCAST");
    }

    private b() {
    }

    @NotNull
    public final UserType T() {
        if (g0.g(m(), "1")) {
            return UserType.STUDENT;
        }
        return UserType.TEACHER;
    }

    public final void e() {
        try {
            BaseApp.c().startService(new Intent(BaseApp.c(), (Class<?>) NettySocketService.class).putExtra(com.umeng.ccg.a.f41544t, 1));
        } catch (Exception e6) {
            j.e("startService：" + e6.getMessage(), new Object[0]);
        }
    }

    public final void f() {
        try {
            BaseApp.c().startService(new Intent(BaseApp.c(), (Class<?>) NettySocketService.class).putExtra(com.umeng.ccg.a.f41544t, 2));
        } catch (Exception e6) {
            j.e("startService：" + e6.getMessage(), new Object[0]);
        }
    }
}
