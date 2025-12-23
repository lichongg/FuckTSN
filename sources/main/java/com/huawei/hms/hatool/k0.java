package com.huawei.hms.hatool;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class k0 {

    /* renamed from: a, reason: collision with root package name */
    private c1 f33601a;

    /* renamed from: b, reason: collision with root package name */
    private c1 f33602b;

    /* renamed from: c, reason: collision with root package name */
    private c1 f33603c;

    /* renamed from: d, reason: collision with root package name */
    private c1 f33604d;

    public c1 a() {
        return this.f33603c;
    }

    public c1 b(String str) {
        if (str.equals("oper")) {
            return f();
        }
        if (str.equals("maint")) {
            return d();
        }
        if (str.equals("diffprivacy")) {
            return a();
        }
        if (str.equals("preins")) {
            return g();
        }
        j1.m("hmsSdk", "HiAnalyticsInstData.getConfig(type): wrong type: " + str);
        return null;
    }

    public void c(c1 c1Var) {
        this.f33601a = c1Var;
    }

    public c1 d() {
        return this.f33601a;
    }

    public void e(c1 c1Var) {
        this.f33602b = c1Var;
    }

    public c1 f() {
        return this.f33602b;
    }

    public c1 g() {
        return this.f33604d;
    }

    public k0(String str) {
    }
}
