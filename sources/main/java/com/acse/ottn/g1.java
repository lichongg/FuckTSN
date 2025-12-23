package com.acse.ottn;

import com.acse.ottn.activity.AcseHelpManager;
import com.acse.ottn.model.AccessiblityModel;
import okhttp3.RequestBody;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class g1 extends m3 {

    /* renamed from: g, reason: collision with root package name */
    public f4 f4536g = (f4) a().g(f4.class);

    @Override // com.acse.ottn.m3
    public String b() {
        return AcseHelpManager.mIsDebug ? "http://a.idazhe.net/ss/tongji_oozk_cn/" : "http://tongji.oozk.cn";
    }

    public rx.e<String> a(RequestBody requestBody) {
        return this.f4536g.v(requestBody);
    }

    public rx.e<AccessiblityModel> c(RequestBody requestBody) {
        return this.f4536g.y(requestBody);
    }

    public rx.e<String> d(RequestBody requestBody) {
        return this.f4536g.c(requestBody);
    }

    public rx.e<String> e(RequestBody requestBody) {
        return this.f4536g.i(requestBody);
    }

    public rx.e<String> f(RequestBody requestBody) {
        return this.f4536g.z(requestBody);
    }

    public rx.e<String> g(RequestBody requestBody) {
        return this.f4536g.u(requestBody);
    }

    public rx.e<String> h(RequestBody requestBody) {
        return this.f4536g.o(requestBody);
    }

    public rx.e<String> i(RequestBody requestBody) {
        return this.f4536g.B(requestBody);
    }

    public rx.e<AccessiblityModel> j(RequestBody requestBody) {
        return this.f4536g.k(requestBody);
    }

    public rx.e<String> k(RequestBody requestBody) {
        return this.f4536g.b(requestBody);
    }

    public rx.e<String> l(RequestBody requestBody) {
        return this.f4536g.f(requestBody);
    }

    public rx.e<String> b(RequestBody requestBody) {
        return this.f4536g.e(requestBody);
    }
}
