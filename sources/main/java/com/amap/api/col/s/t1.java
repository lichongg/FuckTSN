package com.amap.api.col.s;

import android.content.Context;
import com.stub.StubApp;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class t1 {

    /* renamed from: c, reason: collision with root package name */
    private static t1 f8477c;

    /* renamed from: a, reason: collision with root package name */
    private final Context f8478a;

    /* renamed from: b, reason: collision with root package name */
    private final String f8479b = a2.d(j1.t("RYW1hcF9kZXZpY2VfYWRpdQ"));

    public final synchronized void b() {
        try {
            if (c1.s() == null) {
                c1.l(x1.a());
            }
        } catch (Throwable unused) {
        }
    }

    public static t1 a(Context context) {
        if (f8477c == null) {
            synchronized (t1.class) {
                try {
                    if (f8477c == null) {
                        f8477c = new t1(context);
                    }
                } finally {
                }
            }
        }
        return f8477c;
    }

    public final void c(String str) {
        u1.b(this.f8478a).d(this.f8479b);
        u1.b(this.f8478a).g(str);
    }

    private t1(Context context) {
        this.f8478a = StubApp.getOrigApplicationContext(context.getApplicationContext());
    }
}
