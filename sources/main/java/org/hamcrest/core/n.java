package org.hamcrest.core;

import java.util.Iterator;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
abstract class n<T> extends org.hamcrest.b<T> {

    /* renamed from: a, reason: collision with root package name */
    private final Iterable<org.hamcrest.j<? super T>> f51297a;

    @Override // org.hamcrest.j
    public abstract boolean c(Object obj);

    @Override // org.hamcrest.l
    public abstract void describeTo(org.hamcrest.g gVar);

    public void d(org.hamcrest.g gVar, String str) {
        gVar.a("(", " " + str + " ", ")", this.f51297a);
    }

    protected boolean e(Object obj, boolean z5) {
        Iterator<org.hamcrest.j<? super T>> it = this.f51297a.iterator();
        while (it.hasNext()) {
            if (it.next().c(obj) == z5) {
                return z5;
            }
        }
        return !z5;
    }

    public n(Iterable<org.hamcrest.j<? super T>> iterable) {
        this.f51297a = iterable;
    }
}
