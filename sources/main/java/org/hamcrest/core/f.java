package org.hamcrest.core;

import org.hamcrest.Factory;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class f<T> extends org.hamcrest.b<T> {

    /* renamed from: a, reason: collision with root package name */
    private final org.hamcrest.j<T> f51289a;

    @Factory
    public static <T> org.hamcrest.j<T> f(org.hamcrest.j<T> jVar) {
        return new f(jVar);
    }

    @Override // org.hamcrest.b, org.hamcrest.j
    public void b(Object obj, org.hamcrest.g gVar) {
        this.f51289a.b(obj, gVar);
    }

    @Override // org.hamcrest.j
    public boolean c(Object obj) {
        return this.f51289a.c(obj);
    }

    @Override // org.hamcrest.l
    public void describeTo(org.hamcrest.g gVar) {
        gVar.b("is ").f(this.f51289a);
    }

    public f(org.hamcrest.j<T> jVar) {
        this.f51289a = jVar;
    }

    @Factory
    @Deprecated
    public static <T> org.hamcrest.j<T> d(Class<T> cls) {
        return f(j.f(cls));
    }

    @Factory
    public static <T> org.hamcrest.j<T> e(T t5) {
        return f(i.h(t5));
    }

    @Factory
    public static <T> org.hamcrest.j<T> g(Class<T> cls) {
        return f(j.f(cls));
    }
}
