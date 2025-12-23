package org.hamcrest.core;

import org.hamcrest.Factory;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class m<T> extends org.hamcrest.b<T> {

    /* renamed from: a, reason: collision with root package name */
    private final T f51296a;

    @Factory
    public static <T> org.hamcrest.j<T> d(T t5) {
        return new m(t5);
    }

    @Factory
    public static <T> org.hamcrest.j<T> e(T t5) {
        return new m(t5);
    }

    @Override // org.hamcrest.j
    public boolean c(Object obj) {
        return obj == this.f51296a;
    }

    @Override // org.hamcrest.l
    public void describeTo(org.hamcrest.g gVar) {
        gVar.b("sameInstance(").c(this.f51296a).b(")");
    }

    public m(T t5) {
        this.f51296a = t5;
    }
}
