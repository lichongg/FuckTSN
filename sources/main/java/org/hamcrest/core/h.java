package org.hamcrest.core;

import java.util.ArrayList;
import org.hamcrest.Factory;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class h<T> extends org.hamcrest.n<Iterable<? super T>> {

    /* renamed from: c, reason: collision with root package name */
    private final org.hamcrest.j<? super T> f51291c;

    @Factory
    public static <T> org.hamcrest.j<Iterable<? super T>> e(T t5) {
        return new h(i.h(t5));
    }

    @Factory
    public static <T> org.hamcrest.j<Iterable<? super T>> f(org.hamcrest.j<? super T> jVar) {
        return new h(jVar);
    }

    @Factory
    public static <T> org.hamcrest.j<Iterable<T>> g(T... tArr) {
        ArrayList arrayList = new ArrayList(tArr.length);
        for (T t5 : tArr) {
            arrayList.add(e(t5));
        }
        return a.e(arrayList);
    }

    @Factory
    public static <T> org.hamcrest.j<Iterable<T>> h(org.hamcrest.j<? super T>... jVarArr) {
        ArrayList arrayList = new ArrayList(jVarArr.length);
        for (org.hamcrest.j<? super T> jVar : jVarArr) {
            arrayList.add(new h(jVar));
        }
        return a.e(arrayList);
    }

    @Override // org.hamcrest.l
    public void describeTo(org.hamcrest.g gVar) {
        gVar.b("a collection containing ").f(this.f51291c);
    }

    public h(org.hamcrest.j<? super T> jVar) {
        this.f51291c = jVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.hamcrest.n
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public boolean d(Iterable<? super T> iterable, org.hamcrest.g gVar) {
        boolean z5 = false;
        for (T t5 : iterable) {
            if (this.f51291c.c(t5)) {
                return true;
            }
            if (z5) {
                gVar.b(", ");
            }
            this.f51291c.b(t5, gVar);
            z5 = true;
        }
        return false;
    }
}
