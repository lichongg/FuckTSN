package com.bumptech.glide.repackaged.com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class v {

    /* renamed from: a, reason: collision with root package name */
    static final v0<Object> f15947a = new c();

    /* renamed from: b, reason: collision with root package name */
    private static final Iterator<Object> f15948b = new d();

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a<T> extends com.bumptech.glide.repackaged.com.google.common.collect.a<T> {

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Object[] f15949c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f15950d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(int i6, int i7, Object[] objArr, int i8) {
            super(i6, i7);
            this.f15949c = objArr;
            this.f15950d = i8;
        }

        @Override // com.bumptech.glide.repackaged.com.google.common.collect.a
        protected T a(int i6) {
            return (T) this.f15949c[this.f15950d + i6];
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class b<T> extends u0<T> {

        /* renamed from: a, reason: collision with root package name */
        boolean f15951a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Object f15952b;

        b(Object obj) {
            this.f15952b = obj;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return !this.f15951a;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.f15951a) {
                throw new NoSuchElementException();
            }
            this.f15951a = true;
            return (T) this.f15952b;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class c extends v0<Object> {
        @Override // java.util.Iterator, java.util.ListIterator
        public boolean hasNext() {
            return false;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return false;
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return 0;
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return -1;
        }

        @Override // java.util.Iterator, java.util.ListIterator
        public Object next() {
            throw new NoSuchElementException();
        }

        @Override // java.util.ListIterator
        public Object previous() {
            throw new NoSuchElementException();
        }

        c() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class d implements Iterator<Object> {
        @Override // java.util.Iterator
        public boolean hasNext() {
            return false;
        }

        @Override // java.util.Iterator
        public void remove() {
            com.bumptech.glide.repackaged.com.google.common.collect.f.c(false);
        }

        @Override // java.util.Iterator
        public Object next() {
            throw new NoSuchElementException();
        }

        d() {
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class e<T> extends u0<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Iterator f15953a;

        e(Iterator it) {
            this.f15953a = it;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f15953a.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            return (T) this.f15953a.next();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class f<T> extends com.bumptech.glide.repackaged.com.google.common.collect.b<T> {

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Iterator f15954c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.bumptech.glide.repackaged.com.google.common.base.e f15955d;

        f(Iterator it, com.bumptech.glide.repackaged.com.google.common.base.e eVar) {
            this.f15954c = it;
            this.f15955d = eVar;
        }

        @Override // com.bumptech.glide.repackaged.com.google.common.collect.b
        protected T a() {
            while (this.f15954c.hasNext()) {
                T t5 = (T) this.f15954c.next();
                if (this.f15955d.apply(t5)) {
                    return t5;
                }
            }
            return b();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T, F] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class g<F, T> extends s0<F, T> {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.bumptech.glide.repackaged.com.google.common.base.a f15956b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(Iterator it, com.bumptech.glide.repackaged.com.google.common.base.a aVar) {
            super(it);
            this.f15956b = aVar;
        }

        @Override // com.bumptech.glide.repackaged.com.google.common.collect.s0
        T a(F f6) {
            return (T) this.f15956b.apply(f6);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class h<E> implements c0<E> {

        /* renamed from: a, reason: collision with root package name */
        private final Iterator<? extends E> f15957a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f15958b;

        /* renamed from: c, reason: collision with root package name */
        private E f15959c;

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f15958b || this.f15957a.hasNext();
        }

        @Override // com.bumptech.glide.repackaged.com.google.common.collect.c0, java.util.Iterator
        public E next() {
            if (!this.f15958b) {
                return this.f15957a.next();
            }
            E e6 = this.f15959c;
            this.f15958b = false;
            this.f15959c = null;
            return e6;
        }

        @Override // com.bumptech.glide.repackaged.com.google.common.collect.c0
        public E peek() {
            if (!this.f15958b) {
                this.f15959c = this.f15957a.next();
                this.f15958b = true;
            }
            return this.f15959c;
        }

        @Override // java.util.Iterator
        public void remove() {
            com.bumptech.glide.repackaged.com.google.common.base.d.o(!this.f15958b, "Can't remove after you've peeked at next");
            this.f15957a.remove();
        }

        public h(Iterator<? extends E> it) {
            this.f15957a = (Iterator) com.bumptech.glide.repackaged.com.google.common.base.d.i(it);
        }
    }

    public static <T> u0<T> h(T... tArr) {
        return i(tArr, 0, tArr.length, 0);
    }

    static <T> ListIterator<T> c(Iterator<T> it) {
        return (ListIterator) it;
    }

    static <T> v0<T> f() {
        return (v0<T>) f15947a;
    }

    static <T> v0<T> i(T[] tArr, int i6, int i7, int i8) {
        com.bumptech.glide.repackaged.com.google.common.base.d.d(i7 >= 0);
        com.bumptech.glide.repackaged.com.google.common.base.d.m(i6, i6 + i7, tArr.length);
        com.bumptech.glide.repackaged.com.google.common.base.d.k(i8, i7);
        return i7 == 0 ? f() : new a(i7, i8, tArr, i6);
    }

    public static <T> int l(Iterator<T> it, com.bumptech.glide.repackaged.com.google.common.base.e<? super T> eVar) {
        com.bumptech.glide.repackaged.com.google.common.base.d.j(eVar, "predicate");
        int i6 = 0;
        while (it.hasNext()) {
            if (eVar.apply(it.next())) {
                return i6;
            }
            i6++;
        }
        return -1;
    }

    public static <T> c0<T> m(Iterator<? extends T> it) {
        return it instanceof h ? (h) it : new h(it);
    }

    public static <T> u0<T> n(T t5) {
        return new b(t5);
    }

    public static String o(Iterator<?> it) {
        com.bumptech.glide.repackaged.com.google.common.base.b bVar = com.bumptech.glide.repackaged.com.google.common.collect.g.f15901a;
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        StringBuilder c6 = bVar.c(sb, it);
        c6.append(']');
        return c6.toString();
    }

    public static <T> boolean a(Collection<T> collection, Iterator<? extends T> it) {
        com.bumptech.glide.repackaged.com.google.common.base.d.i(collection);
        com.bumptech.glide.repackaged.com.google.common.base.d.i(it);
        boolean z5 = false;
        while (it.hasNext()) {
            z5 |= collection.add(it.next());
        }
        return z5;
    }

    public static <T> boolean b(Iterator<T> it, com.bumptech.glide.repackaged.com.google.common.base.e<? super T> eVar) {
        if (l(it, eVar) != -1) {
            return true;
        }
        return false;
    }

    public static boolean d(Iterator<?> it, Object obj) {
        return b(it, com.bumptech.glide.repackaged.com.google.common.base.f.a(obj));
    }

    public static boolean e(Iterator<?> it, Iterator<?> it2) {
        while (it.hasNext()) {
            if (!it2.hasNext() || !com.bumptech.glide.repackaged.com.google.common.base.c.a(it.next(), it2.next())) {
                return false;
            }
        }
        return !it2.hasNext();
    }

    public static <T> u0<T> g(Iterator<T> it, com.bumptech.glide.repackaged.com.google.common.base.e<? super T> eVar) {
        com.bumptech.glide.repackaged.com.google.common.base.d.i(it);
        com.bumptech.glide.repackaged.com.google.common.base.d.i(eVar);
        return new f(it, eVar);
    }

    public static <T> T j(Iterator<? extends T> it, T t5) {
        if (it.hasNext()) {
            return it.next();
        }
        return t5;
    }

    public static <T> T k(Iterator<T> it) {
        T next = it.next();
        if (!it.hasNext()) {
            return next;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("expected one element but was: <" + next);
        for (int i6 = 0; i6 < 4 && it.hasNext(); i6++) {
            sb.append(", " + it.next());
        }
        if (it.hasNext()) {
            sb.append(", ...");
        }
        sb.append(kotlin.text.v0.f47962f);
        throw new IllegalArgumentException(sb.toString());
    }

    public static <F, T> Iterator<T> p(Iterator<F> it, com.bumptech.glide.repackaged.com.google.common.base.a<? super F, ? extends T> aVar) {
        com.bumptech.glide.repackaged.com.google.common.base.d.i(aVar);
        return new g(it, aVar);
    }

    public static <T> u0<T> q(Iterator<T> it) {
        com.bumptech.glide.repackaged.com.google.common.base.d.i(it);
        if (it instanceof u0) {
            return (u0) it;
        }
        return new e(it);
    }
}
