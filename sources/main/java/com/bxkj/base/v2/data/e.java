package com.bxkj.base.v2.data;

import com.bxkj.base.BaseApp;
import com.bxkj.base.user.LoginUser;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import kotlin.s;
import kotlin.t;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class e {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final String f17018b = "user";

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f17017a = new a(null);

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final s<e> f17019c = t.b(LazyThreadSafetyMode.SYNCHRONIZED, new Function0() { // from class: com.bxkj.base.v2.data.d
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            e t5;
            t5 = e.t();
            return t5;
        }
    });

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        public /* synthetic */ a(v vVar) {
            this();
        }

        private a() {
        }

        @NotNull
        public final e a() {
            return (e) e.f17019c.getValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final e t() {
        return new e();
    }

    public final void B(@NotNull String value) {
        g0.p(value, "value");
        com.bxkj.base.v2.data.spp.b.q(BaseApp.c(), "user", "lastUpdateTime", value);
    }

    public final void C(@NotNull String value) {
        g0.p(value, "value");
        com.bxkj.base.v2.data.spp.b.q(BaseApp.c(), "user", "lastUploadTime", value);
    }

    public final void F(@NotNull String value) {
        g0.p(value, "value");
        com.bxkj.base.v2.data.spp.b.q(BaseApp.c(), "user", "isOpenLive", value);
    }

    public final void H(@NotNull String value) {
        g0.p(value, "value");
        com.bxkj.base.v2.data.spp.b.q(BaseApp.c(), "user", "refreshToken", value);
    }

    public final void I(@NotNull String value) {
        g0.p(value, "value");
        com.bxkj.base.v2.data.spp.b.q(BaseApp.c(), "user", "schoolCode", value);
    }

    public final void J(@NotNull String value) {
        g0.p(value, "value");
        com.bxkj.base.v2.data.spp.b.q(BaseApp.c(), "user", "schoolName", value);
    }

    public final void K(@NotNull String value) {
        g0.p(value, "value");
        com.bxkj.base.v2.data.spp.b.q(BaseApp.c(), "user", "userId", value);
    }

    public final void L(@NotNull String value) {
        g0.p(value, "value");
        com.bxkj.base.v2.data.spp.b.q(BaseApp.c(), "user", "userNumber", value);
    }

    public final void M(@NotNull String value) {
        g0.p(value, "value");
        com.bxkj.base.v2.data.spp.b.q(BaseApp.c(), "user", "username", value);
    }

    public final void w(@NotNull String value) {
        g0.p(value, "value");
        com.bxkj.base.v2.data.spp.b.q(BaseApp.c(), "user", "accessToken", value);
    }

    public final void x(@NotNull String value) {
        g0.p(value, "value");
        com.bxkj.base.v2.data.spp.b.q(BaseApp.c(), "user", "appId", value);
    }

    public final void z(@NotNull String value) {
        g0.p(value, "value");
        com.bxkj.base.v2.data.spp.b.q(BaseApp.c(), "user", "dept_id", value);
    }

    private e() {
    }

    public final void A(int i6) {
        com.bxkj.base.v2.data.spp.b.o(BaseApp.c(), "user", "frequency", i6);
    }

    public final void D(boolean z5) {
        com.bxkj.base.v2.data.spp.b.m(BaseApp.c(), "user", "isLogin", z5);
    }

    public final void E(int i6) {
        com.bxkj.base.v2.data.spp.b.o(BaseApp.c(), "user", "nfcCardType", i6);
    }

    public final void G(int i6) {
        com.bxkj.base.v2.data.spp.b.o(BaseApp.c(), "user", "queryStudentType", i6);
    }

    public final void N(boolean z5) {
        com.bxkj.base.v2.data.spp.b.m(BaseApp.c(), "user", "voiceOpen", z5);
    }

    public final void O(int i6) {
        com.bxkj.base.v2.data.spp.b.o(BaseApp.c(), "user", "voiceType", i6);
    }

    @NotNull
    public final String c() {
        String k6 = com.bxkj.base.v2.data.spp.b.k(BaseApp.c(), "user", "accessToken", "");
        g0.o(k6, "getString(...)");
        return k6;
    }

    @NotNull
    public final String d() {
        String k6 = com.bxkj.base.v2.data.spp.b.k(BaseApp.c(), "user", "appId", "");
        g0.o(k6, "getString(...)");
        return k6;
    }

    public final int e() {
        return com.bxkj.base.v2.data.spp.b.g(BaseApp.c(), "user", "bindType", 0);
    }

    @NotNull
    public final String f() {
        String k6 = com.bxkj.base.v2.data.spp.b.k(BaseApp.c(), "user", "dept_id", String.valueOf(LoginUser.getLoginUser().getUserType()));
        g0.o(k6, "getString(...)");
        return k6;
    }

    public final int g() {
        return com.bxkj.base.v2.data.spp.b.g(BaseApp.c(), "user", "frequency", 1);
    }

    @NotNull
    public final String h() {
        String k6 = com.bxkj.base.v2.data.spp.b.k(BaseApp.c(), "user", "lastUpdateTime", "");
        g0.o(k6, "getString(...)");
        return k6;
    }

    @NotNull
    public final String i() {
        String k6 = com.bxkj.base.v2.data.spp.b.k(BaseApp.c(), "user", "lastUploadTime", "");
        g0.o(k6, "getString(...)");
        return k6;
    }

    public final int j() {
        return com.bxkj.base.v2.data.spp.b.g(BaseApp.c(), "user", "nfcCardType", 0);
    }

    public final int k() {
        return com.bxkj.base.v2.data.spp.b.g(BaseApp.c(), "user", "queryStudentType", 0);
    }

    @NotNull
    public final String l() {
        String k6 = com.bxkj.base.v2.data.spp.b.k(BaseApp.c(), "user", "refreshToken", "");
        g0.o(k6, "getString(...)");
        return k6;
    }

    @NotNull
    public final String m() {
        String k6 = com.bxkj.base.v2.data.spp.b.k(BaseApp.c(), "user", "schoolCode", "a");
        g0.o(k6, "getString(...)");
        return k6;
    }

    @NotNull
    public final String n() {
        String k6 = com.bxkj.base.v2.data.spp.b.k(BaseApp.c(), "user", "schoolName", "");
        g0.o(k6, "getString(...)");
        return k6;
    }

    @NotNull
    public final String o() {
        String k6 = com.bxkj.base.v2.data.spp.b.k(BaseApp.c(), "user", "userId", "");
        g0.o(k6, "getString(...)");
        return k6;
    }

    @NotNull
    public final String p() {
        String k6 = com.bxkj.base.v2.data.spp.b.k(BaseApp.c(), "user", "userNumber", "");
        g0.o(k6, "getString(...)");
        return k6;
    }

    @NotNull
    public final String q() {
        String k6 = com.bxkj.base.v2.data.spp.b.k(BaseApp.c(), "user", "username", "");
        g0.o(k6, "getString(...)");
        return k6;
    }

    public final boolean r() {
        return com.bxkj.base.v2.data.spp.b.c(BaseApp.c(), "user", "voiceOpen", false);
    }

    public final int s() {
        return com.bxkj.base.v2.data.spp.b.g(BaseApp.c(), "user", "voiceType", 0);
    }

    public final boolean u() {
        return com.bxkj.base.v2.data.spp.b.c(BaseApp.c(), "user", "isLogin", false);
    }

    @NotNull
    public final String v() {
        String k6 = com.bxkj.base.v2.data.spp.b.k(BaseApp.c(), "user", "isOpenLive", "0");
        g0.o(k6, "getString(...)");
        return k6;
    }

    public final void y(int i6) {
        com.bxkj.base.v2.data.spp.b.o(BaseApp.c(), "user", "bindType", i6);
    }
}
