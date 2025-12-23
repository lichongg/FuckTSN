package com.bumptech.glide.repackaged.com.google.common.collect;

import java.util.Iterator;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class u {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a<T> extends j<T> {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Iterable f15943b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.bumptech.glide.repackaged.com.google.common.base.e f15944c;

        a(Iterable iterable, com.bumptech.glide.repackaged.com.google.common.base.e eVar) {
            this.f15943b = iterable;
            this.f15944c = eVar;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return v.g(this.f15943b.iterator(), this.f15944c);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class b<T> extends j<T> {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Iterable f15945b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.bumptech.glide.repackaged.com.google.common.base.a f15946c;

        b(Iterable iterable, com.bumptech.glide.repackaged.com.google.common.base.a aVar) {
            this.f15945b = iterable;
            this.f15946c = aVar;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return v.p(this.f15945b.iterator(), this.f15946c);
        }
    }

    public static <T> boolean a(Iterable<T> iterable, com.bumptech.glide.repackaged.com.google.common.base.e<? super T> eVar) {
        return v.b(iterable.iterator(), eVar);
    }

    public static <T> Iterable<T> b(Iterable<T> iterable, com.bumptech.glide.repackaged.com.google.common.base.e<? super T> eVar) {
        com.bumptech.glide.repackaged.com.google.common.base.d.i(iterable);
        com.bumptech.glide.repackaged.com.google.common.base.d.i(eVar);
        return new a(iterable, eVar);
    }

    public static <T> T c(Iterable<? extends T> iterable, T t5) {
        return (T) v.j(iterable.iterator(), t5);
    }

    public static <T> T d(Iterable<T> iterable) {
        return (T) v.k(iterable.iterator());
    }

    public static String e(Iterable<?> iterable) {
        return v.o(iterable.iterator());
    }

    public static <F, T> Iterable<T> f(Iterable<F> iterable, com.bumptech.glide.repackaged.com.google.common.base.a<? super F, ? extends T> aVar) {
        com.bumptech.glide.repackaged.com.google.common.base.d.i(iterable);
        com.bumptech.glide.repackaged.com.google.common.base.d.i(aVar);
        return new b(iterable, aVar);
    }
}
