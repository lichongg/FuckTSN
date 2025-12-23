package org.hamcrest.core;

import java.util.ArrayList;
import java.util.Arrays;
import org.hamcrest.Factory;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class a<T> extends org.hamcrest.h<T> {

    /* renamed from: a, reason: collision with root package name */
    private final Iterable<org.hamcrest.j<? super T>> f51280a;

    @Factory
    public static <T> org.hamcrest.j<T> e(Iterable<org.hamcrest.j<? super T>> iterable) {
        return new a(iterable);
    }

    @Factory
    public static <T> org.hamcrest.j<T> f(org.hamcrest.j<? super T> jVar, org.hamcrest.j<? super T> jVar2) {
        ArrayList arrayList = new ArrayList(2);
        arrayList.add(jVar);
        arrayList.add(jVar2);
        return e(arrayList);
    }

    @Factory
    public static <T> org.hamcrest.j<T> g(org.hamcrest.j<? super T> jVar, org.hamcrest.j<? super T> jVar2, org.hamcrest.j<? super T> jVar3) {
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(jVar);
        arrayList.add(jVar2);
        arrayList.add(jVar3);
        return e(arrayList);
    }

    @Factory
    public static <T> org.hamcrest.j<T> h(org.hamcrest.j<? super T> jVar, org.hamcrest.j<? super T> jVar2, org.hamcrest.j<? super T> jVar3, org.hamcrest.j<? super T> jVar4) {
        ArrayList arrayList = new ArrayList(4);
        arrayList.add(jVar);
        arrayList.add(jVar2);
        arrayList.add(jVar3);
        arrayList.add(jVar4);
        return e(arrayList);
    }

    @Factory
    public static <T> org.hamcrest.j<T> i(org.hamcrest.j<? super T> jVar, org.hamcrest.j<? super T> jVar2, org.hamcrest.j<? super T> jVar3, org.hamcrest.j<? super T> jVar4, org.hamcrest.j<? super T> jVar5) {
        ArrayList arrayList = new ArrayList(5);
        arrayList.add(jVar);
        arrayList.add(jVar2);
        arrayList.add(jVar3);
        arrayList.add(jVar4);
        arrayList.add(jVar5);
        return e(arrayList);
    }

    @Factory
    public static <T> org.hamcrest.j<T> j(org.hamcrest.j<? super T> jVar, org.hamcrest.j<? super T> jVar2, org.hamcrest.j<? super T> jVar3, org.hamcrest.j<? super T> jVar4, org.hamcrest.j<? super T> jVar5, org.hamcrest.j<? super T> jVar6) {
        ArrayList arrayList = new ArrayList(6);
        arrayList.add(jVar);
        arrayList.add(jVar2);
        arrayList.add(jVar3);
        arrayList.add(jVar4);
        arrayList.add(jVar5);
        arrayList.add(jVar6);
        return e(arrayList);
    }

    @Override // org.hamcrest.h
    public boolean d(Object obj, org.hamcrest.g gVar) {
        for (org.hamcrest.j<? super T> jVar : this.f51280a) {
            if (!jVar.c(obj)) {
                gVar.f(jVar).b(" ");
                jVar.b(obj, gVar);
                return false;
            }
        }
        return true;
    }

    @Override // org.hamcrest.l
    public void describeTo(org.hamcrest.g gVar) {
        gVar.a("(", " and ", ")", this.f51280a);
    }

    public a(Iterable<org.hamcrest.j<? super T>> iterable) {
        this.f51280a = iterable;
    }

    @Factory
    public static <T> org.hamcrest.j<T> k(org.hamcrest.j<? super T>... jVarArr) {
        return e(Arrays.asList(jVarArr));
    }
}
