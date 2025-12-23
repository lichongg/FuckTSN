package org.junit.rules;

import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
class d {

    /* renamed from: a, reason: collision with root package name */
    private final List<org.hamcrest.j<?>> f51462a = new ArrayList();

    private org.hamcrest.j<Throwable> b() {
        return this.f51462a.size() == 1 ? d(this.f51462a.get(0)) : org.hamcrest.d.a(e());
    }

    private List<org.hamcrest.j<? super Throwable>> e() {
        return new ArrayList(this.f51462a);
    }

    void a(org.hamcrest.j<?> jVar) {
        this.f51462a.add(jVar);
    }

    boolean f() {
        return !this.f51462a.isEmpty();
    }

    d() {
    }

    org.hamcrest.j<Throwable> c() {
        return i5.a.j(b());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private org.hamcrest.j<Throwable> d(org.hamcrest.j<?> jVar) {
        return jVar;
    }
}
