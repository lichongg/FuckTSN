package com.bumptech.glide.repackaged.com.google.common.collect;

import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class ImmutableCollection<E> extends AbstractCollection<E> implements Serializable {
    private transient ImmutableList<E> asList;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static abstract class a<E> extends b<E> {

        /* renamed from: a, reason: collision with root package name */
        Object[] f15862a;

        /* renamed from: b, reason: collision with root package name */
        int f15863b;

        private void e(int i6) {
            Object[] objArr = this.f15862a;
            if (objArr.length < i6) {
                this.f15862a = a0.a(objArr, b.c(objArr.length, i6));
            }
        }

        a(int i6) {
            f.b(i6, "initialCapacity");
            this.f15862a = new Object[i6];
            this.f15863b = 0;
        }

        @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableCollection.b
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public a<E> a(E e6) {
            com.bumptech.glide.repackaged.com.google.common.base.d.i(e6);
            e(this.f15863b + 1);
            Object[] objArr = this.f15862a;
            int i6 = this.f15863b;
            this.f15863b = i6 + 1;
            objArr[i6] = e6;
            return this;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static abstract class b<E> {
        public abstract b<E> a(E e6);

        static int c(int i6, int i7) {
            if (i7 < 0) {
                throw new AssertionError("cannot store more than MAX_VALUE elements");
            }
            int i8 = i6 + (i6 >> 1) + 1;
            if (i8 < i7) {
                i8 = Integer.highestOneBit(i7 - 1) << 1;
            }
            if (i8 < 0) {
                return Integer.MAX_VALUE;
            }
            return i8;
        }

        b() {
        }

        public b<E> b(Iterator<? extends E> it) {
            while (it.hasNext()) {
                a(it.next());
            }
            return this;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public abstract boolean contains(Object obj);

    abstract boolean isPartialView();

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public abstract u0<E> iterator();

    @Override // java.util.AbstractCollection, java.util.Collection
    public final Object[] toArray() {
        int size = size();
        if (size == 0) {
            return a0.f15878a;
        }
        Object[] objArr = new Object[size];
        copyIntoArray(objArr, 0);
        return objArr;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean add(E e6) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    public ImmutableList<E> asList() {
        ImmutableList<E> immutableList = this.asList;
        if (immutableList != null) {
            return immutableList;
        }
        ImmutableList<E> createAsList = createAsList();
        this.asList = createAsList;
        return createAsList;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    ImmutableCollection() {
    }

    int copyIntoArray(Object[] objArr, int i6) {
        Iterator it = iterator();
        while (it.hasNext()) {
            objArr[i6] = it.next();
            i6++;
        }
        return i6;
    }

    ImmutableList<E> createAsList() {
        int size = size();
        if (size != 0) {
            if (size != 1) {
                return new e0(this, toArray());
            }
            return ImmutableList.of((Object) iterator().next());
        }
        return ImmutableList.of();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final <T> T[] toArray(T[] tArr) {
        com.bumptech.glide.repackaged.com.google.common.base.d.i(tArr);
        int size = size();
        if (tArr.length < size) {
            tArr = (T[]) a0.e(tArr, size);
        } else if (tArr.length > size) {
            tArr[size] = null;
        }
        copyIntoArray(tArr, 0);
        return tArr;
    }
}
