package com.amap.api.col.p0003l;

import android.content.Context;
import com.stub.StubApp;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class g5 {

    /* renamed from: c, reason: collision with root package name */
    private static g5 f6349c;

    /* renamed from: a, reason: collision with root package name */
    private final Context f6350a;

    /* renamed from: b, reason: collision with root package name */
    private final String f6351b = o5.d(q4.u("RYW1hcF9kZXZpY2VfYWRpdQ"));

    public final synchronized void b() {
        try {
            if (i4.z() == null) {
                i4.q(l5.a());
            }
        } catch (Throwable unused) {
        }
    }

    public static g5 a(Context context) {
        if (f6349c == null) {
            synchronized (g5.class) {
                try {
                    if (f6349c == null) {
                        f6349c = new g5(context);
                    }
                } finally {
                }
            }
        }
        return f6349c;
    }

    public final void c(String str) {
        i5.b(this.f6350a).d(this.f6351b);
        i5.b(this.f6350a).g(str);
    }

    private g5(Context context) {
        this.f6350a = StubApp.getOrigApplicationContext(context.getApplicationContext());
    }
}
