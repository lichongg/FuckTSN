package org.hamcrest.core;

import java.util.ArrayList;
import org.hamcrest.Factory;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class c<T> extends org.hamcrest.n<T> {

    /* renamed from: c, reason: collision with root package name */
    private final org.hamcrest.j<? super T> f51281c;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a<X> {

        /* renamed from: a, reason: collision with root package name */
        private final org.hamcrest.j<? super X> f51282a;

        public c<X> a(org.hamcrest.j<? super X> jVar) {
            return new c(this.f51282a).e(jVar);
        }

        public a(org.hamcrest.j<? super X> jVar) {
            this.f51282a = jVar;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class b<X> {

        /* renamed from: a, reason: collision with root package name */
        private final org.hamcrest.j<? super X> f51283a;

        public c<X> a(org.hamcrest.j<? super X> jVar) {
            return new c(this.f51283a).h(jVar);
        }

        public b(org.hamcrest.j<? super X> jVar) {
            this.f51283a = jVar;
        }
    }

    @Factory
    public static <LHS> a<LHS> f(org.hamcrest.j<? super LHS> jVar) {
        return new a<>(jVar);
    }

    @Factory
    public static <LHS> b<LHS> g(org.hamcrest.j<? super LHS> jVar) {
        return new b<>(jVar);
    }

    private ArrayList<org.hamcrest.j<? super T>> i(org.hamcrest.j<? super T> jVar) {
        ArrayList<org.hamcrest.j<? super T>> arrayList = new ArrayList<>();
        arrayList.add(this.f51281c);
        arrayList.add(jVar);
        return arrayList;
    }

    @Override // org.hamcrest.n
    protected boolean d(T t5, org.hamcrest.g gVar) {
        if (this.f51281c.c(t5)) {
            return true;
        }
        this.f51281c.b(t5, gVar);
        return false;
    }

    @Override // org.hamcrest.l
    public void describeTo(org.hamcrest.g gVar) {
        gVar.f(this.f51281c);
    }

    public c<T> e(org.hamcrest.j<? super T> jVar) {
        return new c<>(new org.hamcrest.core.a(i(jVar)));
    }

    public c<T> h(org.hamcrest.j<? super T> jVar) {
        return new c<>(new org.hamcrest.core.b(i(jVar)));
    }

    public c(org.hamcrest.j<? super T> jVar) {
        this.f51281c = jVar;
    }
}
