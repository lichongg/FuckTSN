package com.huawei.hms.hatool;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class d1 {

    /* renamed from: b, reason: collision with root package name */
    static Map<String, k0> f33538b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    private static d1 f33539c;

    /* renamed from: a, reason: collision with root package name */
    private u f33540a = new u();

    public static d1 e() {
        if (f33539c == null) {
            f();
        }
        return f33539c;
    }

    private static synchronized void f() {
        synchronized (d1.class) {
            if (f33539c == null) {
                f33539c = new d1();
            }
        }
    }

    public k0 a(String str) {
        return f33538b.get(str);
    }

    public Set<String> b() {
        return f33538b.keySet();
    }

    public void c(String str, k0 k0Var) {
        f33538b.put(str, k0Var);
    }

    public u d() {
        return this.f33540a;
    }

    private d1() {
    }
}
