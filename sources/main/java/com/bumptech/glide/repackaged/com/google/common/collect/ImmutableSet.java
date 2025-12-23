package com.bumptech.glide.repackaged.com.google.common.collect;

import com.bumptech.glide.repackaged.com.google.common.collect.ImmutableCollection;
import java.util.Arrays;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class ImmutableSet<E> extends ImmutableCollection<E> implements Set<E> {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class a<E> extends ImmutableCollection.a<E> {
        public a() {
            this(4);
        }

        a(int i6) {
            super(i6);
        }

        public ImmutableSet<E> h() {
            ImmutableSet<E> construct = ImmutableSet.construct(this.f15863b, this.f15862a);
            this.f15863b = construct.size();
            return construct;
        }

        @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableCollection.a
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public a<E> a(E e6) {
            super.a(e6);
            return this;
        }

        @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableCollection.b
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public a<E> b(Iterator<? extends E> it) {
            super.b(it);
            return this;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static abstract class b<E> extends ImmutableSet<E> {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class a extends l<E> {
            a() {
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.bumptech.glide.repackaged.com.google.common.collect.l
            /* renamed from: d, reason: merged with bridge method [inline-methods] */
            public b<E> a() {
                return b.this;
            }

            @Override // java.util.List
            public E get(int i6) {
                return (E) b.this.get(i6);
            }
        }

        abstract E get(int i6);

        @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableCollection
        ImmutableList<E> createAsList() {
            return new a();
        }

        @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableSet, com.bumptech.glide.repackaged.com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public u0<E> iterator() {
            return asList().iterator();
        }

        b() {
        }
    }

    public static <E> ImmutableSet<E> copyOf(Collection<? extends E> collection) {
        if ((collection instanceof ImmutableSet) && !(collection instanceof ImmutableSortedSet)) {
            ImmutableSet<E> immutableSet = (ImmutableSet) collection;
            if (!immutableSet.isPartialView()) {
                return immutableSet;
            }
        } else if (collection instanceof EnumSet) {
            return copyOfEnumSet((EnumSet) collection);
        }
        Object[] array = collection.toArray();
        return construct(array.length, array);
    }

    public static <E> ImmutableSet<E> of() {
        return i0.f15911e;
    }

    boolean isHashCodeFast() {
        return false;
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public abstract u0<E> iterator();

    /* JADX INFO: Access modifiers changed from: private */
    public static <E> ImmutableSet<E> construct(int i6, Object... objArr) {
        if (i6 == 0) {
            return of();
        }
        if (i6 == 1) {
            return of(objArr[0]);
        }
        int chooseTableSize = chooseTableSize(i6);
        Object[] objArr2 = new Object[chooseTableSize];
        int i7 = chooseTableSize - 1;
        int i8 = 0;
        int i9 = 0;
        for (int i10 = 0; i10 < i6; i10++) {
            Object b6 = a0.b(objArr[i10], i10);
            int hashCode = b6.hashCode();
            int b7 = k.b(hashCode);
            while (true) {
                int i11 = b7 & i7;
                Object obj = objArr2[i11];
                if (obj == null) {
                    objArr[i8] = b6;
                    objArr2[i11] = b6;
                    i9 += hashCode;
                    i8++;
                    break;
                }
                if (obj.equals(b6)) {
                    break;
                }
                b7++;
            }
        }
        Arrays.fill(objArr, i8, i6, (Object) null);
        if (i8 == 1) {
            return new p0(objArr[0], i9);
        }
        if (chooseTableSize != chooseTableSize(i8)) {
            return construct(i8, objArr);
        }
        if (i8 < objArr.length) {
            objArr = a0.a(objArr, i8);
        }
        return new i0(objArr, i9, objArr2, i7);
    }

    public static <E> ImmutableSet<E> of(E e6) {
        return new p0(e6);
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof ImmutableSet) && isHashCodeFast() && ((ImmutableSet) obj).isHashCodeFast() && hashCode() != obj.hashCode()) {
            return false;
        }
        return m0.a(this, obj);
    }

    ImmutableSet() {
    }

    static int chooseTableSize(int i6) {
        boolean z5 = true;
        if (i6 < 751619276) {
            int highestOneBit = Integer.highestOneBit(i6 - 1) << 1;
            while (highestOneBit * 0.7d < i6) {
                highestOneBit <<= 1;
            }
            return highestOneBit;
        }
        if (i6 >= 1073741824) {
            z5 = false;
        }
        com.bumptech.glide.repackaged.com.google.common.base.d.e(z5, "collection too large");
        return 1073741824;
    }

    private static ImmutableSet copyOfEnumSet(EnumSet enumSet) {
        return n.a(EnumSet.copyOf(enumSet));
    }

    public static <E> ImmutableSet<E> of(E e6, E e7) {
        return construct(2, e6, e7);
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return m0.b(this);
    }

    public static <E> ImmutableSet<E> copyOf(Iterable<? extends E> iterable) {
        return iterable instanceof Collection ? copyOf((Collection) iterable) : copyOf(iterable.iterator());
    }

    public static <E> ImmutableSet<E> copyOf(Iterator<? extends E> it) {
        if (!it.hasNext()) {
            return of();
        }
        E next = it.next();
        if (!it.hasNext()) {
            return of((Object) next);
        }
        return new a().a(next).b(it).h();
    }
}
