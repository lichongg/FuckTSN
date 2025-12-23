package org.hamcrest.core;

import java.util.ArrayList;
import java.util.Arrays;
import org.hamcrest.Factory;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class b<T> extends n<T> {
    @Override // org.hamcrest.core.n, org.hamcrest.j
    public boolean c(Object obj) {
        return e(obj, true);
    }

    @Factory
    public static <T> b<T> f(Iterable<org.hamcrest.j<? super T>> iterable) {
        return new b<>(iterable);
    }

    @Factory
    public static <T> b<T> g(org.hamcrest.j<T> jVar, org.hamcrest.j<? super T> jVar2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(jVar);
        arrayList.add(jVar2);
        return f(arrayList);
    }

    @Factory
    public static <T> b<T> h(org.hamcrest.j<T> jVar, org.hamcrest.j<? super T> jVar2, org.hamcrest.j<? super T> jVar3) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(jVar);
        arrayList.add(jVar2);
        arrayList.add(jVar3);
        return f(arrayList);
    }

    @Factory
    public static <T> b<T> i(org.hamcrest.j<T> jVar, org.hamcrest.j<? super T> jVar2, org.hamcrest.j<? super T> jVar3, org.hamcrest.j<? super T> jVar4) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(jVar);
        arrayList.add(jVar2);
        arrayList.add(jVar3);
        arrayList.add(jVar4);
        return f(arrayList);
    }

    @Factory
    public static <T> b<T> j(org.hamcrest.j<T> jVar, org.hamcrest.j<? super T> jVar2, org.hamcrest.j<? super T> jVar3, org.hamcrest.j<? super T> jVar4, org.hamcrest.j<? super T> jVar5) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(jVar);
        arrayList.add(jVar2);
        arrayList.add(jVar3);
        arrayList.add(jVar4);
        arrayList.add(jVar5);
        return f(arrayList);
    }

    @Factory
    public static <T> b<T> k(org.hamcrest.j<T> jVar, org.hamcrest.j<? super T> jVar2, org.hamcrest.j<? super T> jVar3, org.hamcrest.j<? super T> jVar4, org.hamcrest.j<? super T> jVar5, org.hamcrest.j<? super T> jVar6) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(jVar);
        arrayList.add(jVar2);
        arrayList.add(jVar3);
        arrayList.add(jVar4);
        arrayList.add(jVar5);
        arrayList.add(jVar6);
        return f(arrayList);
    }

    @Override // org.hamcrest.core.n, org.hamcrest.l
    public void describeTo(org.hamcrest.g gVar) {
        d(gVar, "or");
    }

    public b(Iterable<org.hamcrest.j<? super T>> iterable) {
        super(iterable);
    }

    @Factory
    public static <T> b<T> l(org.hamcrest.j<? super T>... jVarArr) {
        return f(Arrays.asList(jVarArr));
    }

    @Override // org.hamcrest.core.n
    public /* bridge */ /* synthetic */ void d(org.hamcrest.g gVar, String str) {
        super.d(gVar, str);
    }
}
