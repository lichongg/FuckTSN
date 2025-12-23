package com.huawei.hms.hatool;

import android.content.Context;
import com.stub.StubApp;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    c1 f33572a;

    /* renamed from: b, reason: collision with root package name */
    c1 f33573b;

    /* renamed from: c, reason: collision with root package name */
    Context f33574c;

    /* renamed from: d, reason: collision with root package name */
    String f33575d;

    public g a(int i6, String str) {
        j1.h("hmsSdk", "Builder.setCollectURL(int type,String collectURL) is execute.TYPE : " + i6);
        if (!w0.d(str)) {
            str = "";
        }
        if (i6 == 0) {
            this.f33572a.i(str);
            return this;
        }
        if (i6 != 1) {
            j1.m("hmsSdk", "Builder.setCollectURL(int type,String collectURL): invalid type!");
            return this;
        }
        this.f33573b.i(str);
        return this;
    }

    public g b(String str) {
        j1.h("hmsSdk", "Builder.setAppID is execute");
        this.f33575d = str;
        return this;
    }

    @Deprecated
    public g c(boolean z5) {
        j1.h("hmsSdk", "Builder.setEnableImei(boolean isReportAndroidImei) is execute.");
        this.f33572a.z().b(z5);
        this.f33573b.z().b(z5);
        return this;
    }

    public void d() {
        if (this.f33574c == null) {
            j1.e("hmsSdk", "analyticsConf create(): context is null,create failed!");
            return;
        }
        j1.h("hmsSdk", "Builder.create() is execute.");
        q1 q1Var = new q1("_hms_config_tag");
        q1Var.g(new c1(this.f33572a));
        q1Var.d(new c1(this.f33573b));
        o0.a().b(this.f33574c);
        t.a().c(this.f33574c);
        a1.d().a(q1Var);
        o0.a().c(this.f33575d);
    }

    @Deprecated
    public g e(boolean z5) {
        j1.h("hmsSdk", "Builder.setEnableSN(boolean isReportSN) is execute.");
        this.f33572a.z().d(z5);
        this.f33573b.z().d(z5);
        return this;
    }

    @Deprecated
    public g f(boolean z5) {
        j1.h("hmsSdk", "Builder.setEnableUDID(boolean isReportUDID) is execute.");
        this.f33572a.z().f(z5);
        this.f33573b.z().f(z5);
        return this;
    }

    public g(Context context) {
        if (context != null) {
            this.f33574c = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        this.f33572a = new c1();
        this.f33573b = new c1();
    }
}
