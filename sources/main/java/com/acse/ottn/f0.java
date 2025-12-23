package com.acse.ottn;

import com.acse.ottn.activity.AcseHelpManager;
import com.acse.ottn.model.AdInfoModel;
import okhttp3.RequestBody;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class f0 extends m3 {

    /* renamed from: g, reason: collision with root package name */
    public f4 f4515g = (f4) a().g(f4.class);

    @Override // com.acse.ottn.m3
    public String b() {
        return AcseHelpManager.mIsDebug ? "http://t.idazhe.net/ss/" : "http://report.idazhe.net/ss/";
    }

    public rx.e<String> a(RequestBody requestBody) {
        return this.f4515g.h(requestBody);
    }

    public rx.e<String> c(RequestBody requestBody) {
        return this.f4515g.q(requestBody);
    }

    public rx.e<String> d(RequestBody requestBody) {
        return this.f4515g.s(requestBody);
    }

    public rx.e<String> e(RequestBody requestBody) {
        return this.f4515g.A(requestBody);
    }

    public rx.e<String> f(RequestBody requestBody) {
        return this.f4515g.m(requestBody);
    }

    public rx.e<AdInfoModel> g(RequestBody requestBody) {
        return this.f4515g.g(requestBody);
    }

    public rx.e<String> h(RequestBody requestBody) {
        return this.f4515g.p(requestBody);
    }

    public rx.e<String> i(RequestBody requestBody) {
        return this.f4515g.r(requestBody);
    }

    public rx.e<String> j(RequestBody requestBody) {
        return this.f4515g.j(requestBody);
    }

    public rx.e<String> k(RequestBody requestBody) {
        return this.f4515g.d(requestBody);
    }

    public rx.e<String> l(RequestBody requestBody) {
        return this.f4515g.t(requestBody);
    }

    public rx.e<String> m(RequestBody requestBody) {
        return this.f4515g.x(requestBody);
    }

    public rx.e<String> n(RequestBody requestBody) {
        return this.f4515g.w(requestBody);
    }

    public rx.e<String> o(RequestBody requestBody) {
        return this.f4515g.l(requestBody);
    }

    public rx.e<String> b(RequestBody requestBody) {
        return this.f4515g.a(requestBody);
    }
}
