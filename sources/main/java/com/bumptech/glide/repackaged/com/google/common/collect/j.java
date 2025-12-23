package com.bumptech.glide.repackaged.com.google.common.collect;

import java.util.Iterator;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class j<E> implements Iterable<E> {

    /* renamed from: a, reason: collision with root package name */
    private final Iterable<E> f15916a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a extends j<E> {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Iterable f15917b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Iterable iterable, Iterable iterable2) {
            super(iterable);
            this.f15917b = iterable2;
        }

        @Override // java.lang.Iterable
        public Iterator<E> iterator() {
            return this.f15917b.iterator();
        }
    }

    protected j() {
        this.f15916a = this;
    }

    public static <E> j<E> e(Iterable<E> iterable) {
        return iterable instanceof j ? (j) iterable : new a(iterable, iterable);
    }

    public final boolean a(com.bumptech.glide.repackaged.com.google.common.base.e<? super E> eVar) {
        return u.a(this.f15916a, eVar);
    }

    public final j<E> d(com.bumptech.glide.repackaged.com.google.common.base.e<? super E> eVar) {
        return e(u.b(this.f15916a, eVar));
    }

    public final ImmutableList<E> g() {
        return ImmutableList.copyOf(this.f15916a);
    }

    public final ImmutableSet<E> j() {
        return ImmutableSet.copyOf(this.f15916a);
    }

    public final <T> j<T> m(com.bumptech.glide.repackaged.com.google.common.base.a<? super E, T> aVar) {
        return e(u.f(this.f15916a, aVar));
    }

    public String toString() {
        return u.e(this.f15916a);
    }

    j(Iterable<E> iterable) {
        this.f15916a = (Iterable) com.bumptech.glide.repackaged.com.google.common.base.d.i(iterable);
    }

    public final String f(com.bumptech.glide.repackaged.com.google.common.base.b bVar) {
        return bVar.d(this);
    }
}
