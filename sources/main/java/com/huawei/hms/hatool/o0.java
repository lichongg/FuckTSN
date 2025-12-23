package com.huawei.hms.hatool;

import android.content.Context;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class o0 {

    /* renamed from: b, reason: collision with root package name */
    private static o0 f33623b;

    /* renamed from: c, reason: collision with root package name */
    private static final Object f33624c = new Object();

    /* renamed from: a, reason: collision with root package name */
    private Context f33625a;

    public static o0 a() {
        if (f33623b == null) {
            d();
        }
        return f33623b;
    }

    private static synchronized void d() {
        synchronized (o0.class) {
            if (f33623b == null) {
                f33623b = new o0();
            }
        }
    }

    public void b(Context context) {
        synchronized (f33624c) {
            try {
                if (this.f33625a != null) {
                    j1.m("hmsSdk", "DataManager already initialized.");
                    return;
                }
                this.f33625a = context;
                d1.e().d().b(this.f33625a);
                d1.e().d().u(context.getPackageName());
                c0.a().d(context);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void c(String str) {
        j1.h("hmsSdk", "HiAnalyticsDataManager.setAppid(String appid) is execute.");
        Context context = this.f33625a;
        if (context == null) {
            j1.l("hmsSdk", "sdk is not init");
        } else {
            d1.e().d().s(n.a("appID", str, "[a-zA-Z0-9_][a-zA-Z0-9. _-]{0,255}", context.getPackageName()));
        }
    }

    private o0() {
    }
}
