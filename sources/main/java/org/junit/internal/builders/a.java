package org.junit.internal.builders;

import java.util.Arrays;
import java.util.Iterator;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class a extends org.junit.runners.model.f {

    /* renamed from: b, reason: collision with root package name */
    private final boolean f51379b;

    protected b h() {
        return new b(this);
    }

    protected c i() {
        return new c();
    }

    protected e j() {
        return new e();
    }

    protected f k() {
        return new f();
    }

    protected org.junit.runners.model.f l() {
        return this.f51379b ? new h() : new g();
    }

    public a(boolean z5) {
        this.f51379b = z5;
    }

    @Override // org.junit.runners.model.f
    public org.junit.runner.g c(Class<?> cls) throws Throwable {
        Iterator it = Arrays.asList(i(), h(), l(), j(), k()).iterator();
        while (it.hasNext()) {
            org.junit.runner.g g6 = ((org.junit.runners.model.f) it.next()).g(cls);
            if (g6 != null) {
                return g6;
            }
        }
        return null;
    }
}
