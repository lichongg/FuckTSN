package com.bumptech.glide.repackaged.com.google.common.collect;

import com.bumptech.glide.repackaged.com.google.common.collect.ImmutableCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class ImmutableList<E> extends ImmutableCollection<E> implements List<E>, RandomAccess {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends com.bumptech.glide.repackaged.com.google.common.collect.a<E> {
        a(int i6, int i7) {
            super(i6, i7);
        }

        @Override // com.bumptech.glide.repackaged.com.google.common.collect.a
        protected E a(int i6) {
            return ImmutableList.this.get(i6);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class b<E> extends ImmutableCollection.a<E> {
        public b() {
            this(4);
        }

        b(int i6) {
            super(i6);
        }

        public ImmutableList<E> h() {
            return ImmutableList.asImmutableList(this.f15862a, this.f15863b);
        }

        @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableCollection.a
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public b<E> a(E e6) {
            super.a(e6);
            return this;
        }

        @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableCollection.b
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public b<E> b(Iterator<? extends E> it) {
            super.b(it);
            return this;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class c<E> extends ImmutableList<E> {

        /* renamed from: a, reason: collision with root package name */
        private final transient ImmutableList<E> f15865a;

        @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableList, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator() {
            return super.listIterator();
        }

        @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableList, com.bumptech.glide.repackaged.com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return this.f15865a.contains(obj);
        }

        @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableList, java.util.List
        public int indexOf(Object obj) {
            int lastIndexOf = this.f15865a.lastIndexOf(obj);
            if (lastIndexOf >= 0) {
                return a(lastIndexOf);
            }
            return -1;
        }

        @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableCollection
        boolean isPartialView() {
            return this.f15865a.isPartialView();
        }

        @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableList, java.util.List
        public int lastIndexOf(Object obj) {
            int indexOf = this.f15865a.indexOf(obj);
            if (indexOf >= 0) {
                return a(indexOf);
            }
            return -1;
        }

        @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableList, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator(int i6) {
            return super.listIterator(i6);
        }

        @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableList
        public ImmutableList<E> reverse() {
            return this.f15865a;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f15865a.size();
        }

        @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableList, java.util.List
        public ImmutableList<E> subList(int i6, int i7) {
            com.bumptech.glide.repackaged.com.google.common.base.d.m(i6, i7, size());
            return this.f15865a.subList(d(i7), d(i6)).reverse();
        }

        c(ImmutableList<E> immutableList) {
            this.f15865a = immutableList;
        }

        private int a(int i6) {
            return (size() - 1) - i6;
        }

        private int d(int i6) {
            return size() - i6;
        }

        @Override // java.util.List
        public E get(int i6) {
            com.bumptech.glide.repackaged.com.google.common.base.d.g(i6, size());
            return this.f15865a.get(a(i6));
        }

        @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableList, com.bumptech.glide.repackaged.com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return super.iterator();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class d extends ImmutableList<E> {

        /* renamed from: a, reason: collision with root package name */
        final transient int f15866a;

        /* renamed from: b, reason: collision with root package name */
        final transient int f15867b;

        @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableCollection
        boolean isPartialView() {
            return true;
        }

        @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableList, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator() {
            return super.listIterator();
        }

        d(int i6, int i7) {
            this.f15866a = i6;
            this.f15867b = i7;
        }

        @Override // java.util.List
        public E get(int i6) {
            com.bumptech.glide.repackaged.com.google.common.base.d.g(i6, this.f15867b);
            return ImmutableList.this.get(i6 + this.f15866a);
        }

        @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableList, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator(int i6) {
            return super.listIterator(i6);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f15867b;
        }

        @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableList, java.util.List
        public ImmutableList<E> subList(int i6, int i7) {
            com.bumptech.glide.repackaged.com.google.common.base.d.m(i6, i7, this.f15867b);
            ImmutableList immutableList = ImmutableList.this;
            int i8 = this.f15866a;
            return immutableList.subList(i6 + i8, i7 + i8);
        }

        @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableList, com.bumptech.glide.repackaged.com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return super.iterator();
        }
    }

    static <E> ImmutableList<E> asImmutableList(Object[] objArr) {
        return asImmutableList(objArr, objArr.length);
    }

    public static <E> ImmutableList<E> copyOf(Iterable<? extends E> iterable) {
        com.bumptech.glide.repackaged.com.google.common.base.d.i(iterable);
        return iterable instanceof Collection ? copyOf((Collection) iterable) : copyOf(iterable.iterator());
    }

    public static <E> ImmutableList<E> of() {
        return (ImmutableList<E>) g0.f15902d;
    }

    static <E> ImmutableList<E> asImmutableList(Object[] objArr, int i6) {
        if (i6 == 0) {
            return of();
        }
        if (i6 == 1) {
            return new o0(objArr[0]);
        }
        if (i6 < objArr.length) {
            objArr = a0.a(objArr, i6);
        }
        return new g0(objArr);
    }

    public static <E> ImmutableList<E> of(E e6) {
        return new o0(e6);
    }

    @Override // java.util.List
    @Deprecated
    public final void add(int i6, E e6) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final boolean addAll(int i6, Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        return w.b(this, obj);
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public u0<E> iterator() {
        return listIterator();
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        return w.d(this, obj);
    }

    @Override // java.util.List
    @Deprecated
    public final E remove(int i6) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final E set(int i6, E e6) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public ImmutableList<E> subList(int i6, int i7) {
        com.bumptech.glide.repackaged.com.google.common.base.d.m(i6, i7, size());
        int i8 = i7 - i6;
        return i8 == size() ? this : i8 != 0 ? i8 != 1 ? subListUnchecked(i6, i7) : of((Object) get(i6)) : of();
    }

    ImmutableList<E> subListUnchecked(int i6, int i7) {
        return new d(i6, i7 - i6);
    }

    ImmutableList() {
    }

    private static <E> ImmutableList<E> construct(Object... objArr) {
        return asImmutableList(a0.c(objArr));
    }

    public static <E> ImmutableList<E> copyOf(Collection<? extends E> collection) {
        if (collection instanceof ImmutableCollection) {
            ImmutableList<E> asList = ((ImmutableCollection) collection).asList();
            return asList.isPartialView() ? asImmutableList(asList.toArray()) : asList;
        }
        return construct(collection.toArray());
    }

    public static <E> ImmutableList<E> of(E e6, E e7) {
        return construct(e6, e7);
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        if (indexOf(obj) >= 0) {
            return true;
        }
        return false;
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableCollection
    int copyIntoArray(Object[] objArr, int i6) {
        int size = size();
        for (int i7 = 0; i7 < size; i7++) {
            objArr[i6 + i7] = get(i7);
        }
        return i6 + size;
    }

    @Override // java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        return w.a(this, obj);
    }

    @Override // java.util.Collection, java.util.List
    public int hashCode() {
        int size = size();
        int i6 = 1;
        for (int i7 = 0; i7 < size; i7++) {
            i6 = ~(~((i6 * 31) + get(i7).hashCode()));
        }
        return i6;
    }

    @Override // java.util.List
    public v0<E> listIterator() {
        return listIterator(0);
    }

    public ImmutableList<E> reverse() {
        if (size() <= 1) {
            return this;
        }
        return new c(this);
    }

    public static <E> ImmutableList<E> of(E e6, E e7, E e8) {
        return construct(e6, e7, e8);
    }

    @Override // java.util.List
    public v0<E> listIterator(int i6) {
        return new a(size(), i6);
    }

    public static <E> ImmutableList<E> copyOf(Iterator<? extends E> it) {
        if (!it.hasNext()) {
            return of();
        }
        E next = it.next();
        if (!it.hasNext()) {
            return of((Object) next);
        }
        return new b().a(next).b(it).h();
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableCollection
    public final ImmutableList<E> asList() {
        return this;
    }
}
