package com.umeng.commonsdk.internal;

import android.content.Context;
import com.stub.StubApp;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class b {

    /* renamed from: b, reason: collision with root package name */
    private static b f41773b;

    /* renamed from: a, reason: collision with root package name */
    private Context f41774a;

    /* renamed from: c, reason: collision with root package name */
    private c f41775c;

    public static synchronized b a(Context context) {
        b bVar;
        synchronized (b.class) {
            try {
                if (f41773b == null) {
                    f41773b = new b(StubApp.getOrigApplicationContext(context.getApplicationContext()));
                }
                bVar = f41773b;
            } catch (Throwable th) {
                throw th;
            }
        }
        return bVar;
    }

    private b(Context context) {
        this.f41774a = context;
        this.f41775c = new c(context);
    }

    public c a() {
        return this.f41775c;
    }
}
