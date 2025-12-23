package com.huawei.hms.hatool;

import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class p1 {

    /* renamed from: b, reason: collision with root package name */
    private static p1 f33632b;

    /* renamed from: a, reason: collision with root package name */
    private volatile Map<String, v0> f33633a = new HashMap();

    private v0 a(String str) {
        if (!this.f33633a.containsKey(str)) {
            this.f33633a.put(str, new v0());
        }
        return this.f33633a.get(str);
    }

    public static p1 c() {
        if (f33632b == null) {
            d();
        }
        return f33632b;
    }

    private static synchronized void d() {
        synchronized (p1.class) {
            if (f33632b == null) {
                f33632b = new p1();
            }
        }
    }

    private p1() {
    }

    public v0 b(String str, long j6) {
        v0 a6 = a(str);
        a6.b(j6);
        return a6;
    }
}
