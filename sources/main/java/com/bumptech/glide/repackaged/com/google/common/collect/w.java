package com.bumptech.glide.repackaged.com.google.common.collect;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.AbstractSequentialList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class w {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class a<F, T> extends AbstractList<T> implements Serializable, RandomAccess {

        /* renamed from: a, reason: collision with root package name */
        final List<F> f15960a;

        /* renamed from: b, reason: collision with root package name */
        final com.bumptech.glide.repackaged.com.google.common.base.a<? super F, ? extends T> f15961b;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: com.bumptech.glide.repackaged.com.google.common.collect.w$a$a, reason: collision with other inner class name */
        class C0172a extends t0<F, T> {
            C0172a(ListIterator listIterator) {
                super(listIterator);
            }

            @Override // com.bumptech.glide.repackaged.com.google.common.collect.s0
            T a(F f6) {
                return a.this.f15961b.apply(f6);
            }
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public void clear() {
            this.f15960a.clear();
        }

        @Override // java.util.AbstractList, java.util.List
        public T get(int i6) {
            return this.f15961b.apply(this.f15960a.get(i6));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            return this.f15960a.isEmpty();
        }

        @Override // java.util.AbstractList, java.util.List
        public ListIterator<T> listIterator(int i6) {
            return new C0172a(this.f15960a.listIterator(i6));
        }

        @Override // java.util.AbstractList, java.util.List
        public T remove(int i6) {
            return this.f15961b.apply(this.f15960a.remove(i6));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f15960a.size();
        }

        a(List<F> list, com.bumptech.glide.repackaged.com.google.common.base.a<? super F, ? extends T> aVar) {
            this.f15960a = (List) com.bumptech.glide.repackaged.com.google.common.base.d.i(list);
            this.f15961b = (com.bumptech.glide.repackaged.com.google.common.base.a) com.bumptech.glide.repackaged.com.google.common.base.d.i(aVar);
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
        public Iterator<T> iterator() {
            return listIterator();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class b<F, T> extends AbstractSequentialList<T> implements Serializable {

        /* renamed from: a, reason: collision with root package name */
        final List<F> f15963a;

        /* renamed from: b, reason: collision with root package name */
        final com.bumptech.glide.repackaged.com.google.common.base.a<? super F, ? extends T> f15964b;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class a extends t0<F, T> {
            a(ListIterator listIterator) {
                super(listIterator);
            }

            @Override // com.bumptech.glide.repackaged.com.google.common.collect.s0
            T a(F f6) {
                return b.this.f15964b.apply(f6);
            }
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public void clear() {
            this.f15963a.clear();
        }

        @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
        public ListIterator<T> listIterator(int i6) {
            return new a(this.f15963a.listIterator(i6));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f15963a.size();
        }

        b(List<F> list, com.bumptech.glide.repackaged.com.google.common.base.a<? super F, ? extends T> aVar) {
            this.f15963a = (List) com.bumptech.glide.repackaged.com.google.common.base.d.i(list);
            this.f15964b = (com.bumptech.glide.repackaged.com.google.common.base.a) com.bumptech.glide.repackaged.com.google.common.base.d.i(aVar);
        }
    }

    static int b(List<?> list, Object obj) {
        if (list instanceof RandomAccess) {
            return c(list, obj);
        }
        ListIterator<?> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            if (com.bumptech.glide.repackaged.com.google.common.base.c.a(obj, listIterator.next())) {
                return listIterator.previousIndex();
            }
        }
        return -1;
    }

    static int d(List<?> list, Object obj) {
        if (list instanceof RandomAccess) {
            return e(list, obj);
        }
        ListIterator<?> listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            if (com.bumptech.glide.repackaged.com.google.common.base.c.a(obj, listIterator.previous())) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }

    private static int e(List<?> list, Object obj) {
        if (obj == null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                if (list.get(size) == null) {
                    return size;
                }
            }
            return -1;
        }
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            if (obj.equals(list.get(size2))) {
                return size2;
            }
        }
        return -1;
    }

    public static <E> ArrayList<E> f() {
        return new ArrayList<>();
    }

    public static <F, T> List<T> i(List<F> list, com.bumptech.glide.repackaged.com.google.common.base.a<? super F, ? extends T> aVar) {
        return list instanceof RandomAccess ? new a(list, aVar) : new b(list, aVar);
    }

    static boolean a(List<?> list, Object obj) {
        if (obj == com.bumptech.glide.repackaged.com.google.common.base.d.i(list)) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        List list2 = (List) obj;
        int size = list.size();
        if (size != list2.size()) {
            return false;
        }
        if ((list instanceof RandomAccess) && (list2 instanceof RandomAccess)) {
            for (int i6 = 0; i6 < size; i6++) {
                if (!com.bumptech.glide.repackaged.com.google.common.base.c.a(list.get(i6), list2.get(i6))) {
                    return false;
                }
            }
            return true;
        }
        return v.e(list.iterator(), list2.iterator());
    }

    private static int c(List<?> list, Object obj) {
        int size = list.size();
        int i6 = 0;
        if (obj == null) {
            while (i6 < size) {
                if (list.get(i6) == null) {
                    return i6;
                }
                i6++;
            }
            return -1;
        }
        while (i6 < size) {
            if (obj.equals(list.get(i6))) {
                return i6;
            }
            i6++;
        }
        return -1;
    }

    public static <E> ArrayList<E> g(Iterable<? extends E> iterable) {
        com.bumptech.glide.repackaged.com.google.common.base.d.i(iterable);
        if (iterable instanceof Collection) {
            return new ArrayList<>(g.a(iterable));
        }
        return h(iterable.iterator());
    }

    public static <E> ArrayList<E> h(Iterator<? extends E> it) {
        ArrayList<E> f6 = f();
        v.a(f6, it);
        return f6;
    }
}
