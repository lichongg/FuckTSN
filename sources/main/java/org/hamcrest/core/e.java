package org.hamcrest.core;

import org.hamcrest.Factory;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class e<T> extends org.hamcrest.n<Iterable<T>> {

    /* renamed from: c, reason: collision with root package name */
    private final org.hamcrest.j<? super T> f51288c;

    @Factory
    public static <U> org.hamcrest.j<Iterable<U>> e(org.hamcrest.j<U> jVar) {
        return new e(jVar);
    }

    @Override // org.hamcrest.l
    public void describeTo(org.hamcrest.g gVar) {
        gVar.b("every item is ").f(this.f51288c);
    }

    public e(org.hamcrest.j<? super T> jVar) {
        this.f51288c = jVar;
    }

    @Override // org.hamcrest.n
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public boolean d(Iterable<T> iterable, org.hamcrest.g gVar) {
        for (T t5 : iterable) {
            if (!this.f51288c.c(t5)) {
                gVar.b("an item ");
                this.f51288c.b(t5, gVar);
                return false;
            }
        }
        return true;
    }
}
