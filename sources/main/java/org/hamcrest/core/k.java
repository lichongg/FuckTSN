package org.hamcrest.core;

import org.hamcrest.Factory;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class k<T> extends org.hamcrest.b<T> {

    /* renamed from: a, reason: collision with root package name */
    private final org.hamcrest.j<T> f51295a;

    @Factory
    public static <T> org.hamcrest.j<T> e(org.hamcrest.j<T> jVar) {
        return new k(jVar);
    }

    @Override // org.hamcrest.j
    public boolean c(Object obj) {
        return !this.f51295a.c(obj);
    }

    @Override // org.hamcrest.l
    public void describeTo(org.hamcrest.g gVar) {
        gVar.b("not ").f(this.f51295a);
    }

    public k(org.hamcrest.j<T> jVar) {
        this.f51295a = jVar;
    }

    @Factory
    public static <T> org.hamcrest.j<T> d(T t5) {
        return e(i.h(t5));
    }
}
