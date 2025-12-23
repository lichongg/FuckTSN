package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.Multiset;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@GwtCompatible(emulated = true, serializable = true)
/* loaded from: D:\Downloads\app\classes5.dex */
public abstract class ImmutableMultiset<E> extends ImmutableMultisetGwtSerializationDependencies<E> implements Multiset<E> {

    @LazyInit
    private transient ImmutableList<E> asList;

    @LazyInit
    private transient ImmutableSet<Multiset.Entry<E>> entrySet;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class Builder<E> extends ImmutableCollection.Builder<E> {
        boolean buildInvoked;
        ObjectCountHashMap<E> contents;
        boolean isLinkedHash;

        public Builder() {
            this(4);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public /* bridge */ /* synthetic */ ImmutableCollection.Builder add(Object obj) {
            return add((Builder<E>) obj);
        }

        @CanIgnoreReturnValue
        public Builder<E> setCount(E e6, int i6) {
            if (i6 == 0 && !this.isLinkedHash) {
                this.contents = new ObjectCountLinkedHashMap(this.contents);
                this.isLinkedHash = true;
            } else if (this.buildInvoked) {
                this.contents = new ObjectCountHashMap<>(this.contents);
                this.isLinkedHash = false;
            }
            this.buildInvoked = false;
            Preconditions.checkNotNull(e6);
            if (i6 == 0) {
                this.contents.remove(e6);
                return this;
            }
            this.contents.put(Preconditions.checkNotNull(e6), i6);
            return this;
        }

        Builder(int i6) {
            this.buildInvoked = false;
            this.isLinkedHash = false;
            this.contents = ObjectCountHashMap.createWithExpectedSize(i6);
        }

        @NullableDecl
        static <T> ObjectCountHashMap<T> tryGetMap(Iterable<T> iterable) {
            if (iterable instanceof RegularImmutableMultiset) {
                return ((RegularImmutableMultiset) iterable).contents;
            }
            if (iterable instanceof AbstractMapBasedMultiset) {
                return ((AbstractMapBasedMultiset) iterable).backingMap;
            }
            return null;
        }

        @CanIgnoreReturnValue
        public Builder<E> addCopies(E e6, int i6) {
            if (i6 == 0) {
                return this;
            }
            if (this.buildInvoked) {
                this.contents = new ObjectCountHashMap<>(this.contents);
                this.isLinkedHash = false;
            }
            this.buildInvoked = false;
            Preconditions.checkNotNull(e6);
            ObjectCountHashMap<E> objectCountHashMap = this.contents;
            objectCountHashMap.put(e6, i6 + objectCountHashMap.get(e6));
            return this;
        }

        @Override // com.google.common.collect.ImmutableCollection.Builder
        public ImmutableMultiset<E> build() {
            if (this.contents.size() == 0) {
                return ImmutableMultiset.of();
            }
            if (this.isLinkedHash) {
                this.contents = new ObjectCountHashMap<>(this.contents);
                this.isLinkedHash = false;
            }
            this.buildInvoked = true;
            return new RegularImmutableMultiset(this.contents);
        }

        @Override // com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public Builder<E> add(E e6) {
            return addCopies(e6, 1);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public Builder<E> addAll(Iterable<? extends E> iterable) {
            if (iterable instanceof Multiset) {
                Multiset cast = Multisets.cast(iterable);
                ObjectCountHashMap tryGetMap = tryGetMap(cast);
                if (tryGetMap != null) {
                    ObjectCountHashMap<E> objectCountHashMap = this.contents;
                    objectCountHashMap.ensureCapacity(Math.max(objectCountHashMap.size(), tryGetMap.size()));
                    for (int firstIndex = tryGetMap.firstIndex(); firstIndex >= 0; firstIndex = tryGetMap.nextIndex(firstIndex)) {
                        addCopies(tryGetMap.getKey(firstIndex), tryGetMap.getValue(firstIndex));
                    }
                } else {
                    Set<Multiset.Entry<E>> entrySet = cast.entrySet();
                    ObjectCountHashMap<E> objectCountHashMap2 = this.contents;
                    objectCountHashMap2.ensureCapacity(Math.max(objectCountHashMap2.size(), entrySet.size()));
                    for (Multiset.Entry<E> entry : cast.entrySet()) {
                        addCopies(entry.getElement(), entry.getCount());
                    }
                }
                return this;
            }
            super.addAll((Iterable) iterable);
            return this;
        }

        @Override // com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public Builder<E> add(E... eArr) {
            super.add((Object[]) eArr);
            return this;
        }

        Builder(boolean z5) {
            this.buildInvoked = false;
            this.isLinkedHash = false;
            this.contents = null;
        }

        @Override // com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public Builder<E> addAll(Iterator<? extends E> it) {
            super.addAll((Iterator) it);
            return this;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private final class EntrySet extends IndexedImmutableSet<Multiset.Entry<E>> {
        private static final long serialVersionUID = 0;

        private EntrySet() {
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (obj instanceof Multiset.Entry) {
                Multiset.Entry entry = (Multiset.Entry) obj;
                if (entry.getCount() > 0 && ImmutableMultiset.this.count(entry.getElement()) == entry.getCount()) {
                    return true;
                }
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.IndexedImmutableSet
        public Multiset.Entry<E> get(int i6) {
            return ImmutableMultiset.this.getEntry(i6);
        }

        @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
        public int hashCode() {
            return ImmutableMultiset.this.hashCode();
        }

        @Override // com.google.common.collect.ImmutableCollection
        boolean isPartialView() {
            return ImmutableMultiset.this.isPartialView();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return ImmutableMultiset.this.elementSet().size();
        }

        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
        @GwtIncompatible
        Object writeReplace() {
            return new EntrySetSerializedForm(ImmutableMultiset.this);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @GwtIncompatible
    static class EntrySetSerializedForm<E> implements Serializable {
        final ImmutableMultiset<E> multiset;

        Object readResolve() {
            return this.multiset.entrySet();
        }

        EntrySetSerializedForm(ImmutableMultiset<E> immutableMultiset) {
            this.multiset = immutableMultiset;
        }
    }

    public static <E> ImmutableMultiset<E> copyOf(E[] eArr) {
        return copyFromElements(eArr);
    }

    public static <E> ImmutableMultiset<E> of() {
        return RegularImmutableMultiset.EMPTY;
    }

    @Override // com.google.common.collect.Multiset
    public abstract ImmutableSet<E> elementSet();

    abstract Multiset.Entry<E> getEntry(int i6);

    @Override // com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    @Deprecated
    public final int setCount(E e6, int i6) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ImmutableCollection
    @GwtIncompatible
    abstract Object writeReplace();

    public static <E> Builder<E> builder() {
        return new Builder<>();
    }

    private static <E> ImmutableMultiset<E> copyFromElements(E... eArr) {
        return new Builder().add((Object[]) eArr).build();
    }

    static <E> ImmutableMultiset<E> copyFromEntries(Collection<? extends Multiset.Entry<? extends E>> collection) {
        Builder builder = new Builder(collection.size());
        for (Multiset.Entry<? extends E> entry : collection) {
            builder.addCopies(entry.getElement(), entry.getCount());
        }
        return builder.build();
    }

    public static <E> ImmutableMultiset<E> copyOf(Iterable<? extends E> iterable) {
        if (iterable instanceof ImmutableMultiset) {
            ImmutableMultiset<E> immutableMultiset = (ImmutableMultiset) iterable;
            if (!immutableMultiset.isPartialView()) {
                return immutableMultiset;
            }
        }
        Builder builder = new Builder(Multisets.inferDistinctElements(iterable));
        builder.addAll((Iterable) iterable);
        return builder.build();
    }

    public static <E> ImmutableMultiset<E> of(E e6) {
        return copyFromElements(e6);
    }

    @Override // com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    @Deprecated
    public final int add(E e6, int i6) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ImmutableCollection
    public ImmutableList<E> asList() {
        ImmutableList<E> immutableList = this.asList;
        if (immutableList != null) {
            return immutableList;
        }
        ImmutableList<E> asList = super.asList();
        this.asList = asList;
        return asList;
    }

    @Override // com.google.common.collect.Multiset
    public ImmutableSet<Multiset.Entry<E>> entrySet() {
        ImmutableSet<Multiset.Entry<E>> immutableSet = this.entrySet;
        if (immutableSet != null) {
            return immutableSet;
        }
        ImmutableSet<Multiset.Entry<E>> createEntrySet = createEntrySet();
        this.entrySet = createEntrySet;
        return createEntrySet;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet, com.google.common.collect.SortedIterable
    public UnmodifiableIterator<E> iterator() {
        final UnmodifiableIterator<Multiset.Entry<E>> it = entrySet().iterator();
        return new UnmodifiableIterator<E>() { // from class: com.google.common.collect.ImmutableMultiset.1

            @MonotonicNonNullDecl
            E element;
            int remaining;

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.remaining > 0 || it.hasNext();
            }

            @Override // java.util.Iterator
            public E next() {
                if (this.remaining <= 0) {
                    Multiset.Entry entry = (Multiset.Entry) it.next();
                    this.element = (E) entry.getElement();
                    this.remaining = entry.getCount();
                }
                this.remaining--;
                return this.element;
            }
        };
    }

    @Override // com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    @Deprecated
    public final int remove(Object obj, int i6) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    @Deprecated
    public final boolean setCount(E e6, int i6, int i7) {
        throw new UnsupportedOperationException();
    }

    ImmutableMultiset() {
    }

    private ImmutableSet<Multiset.Entry<E>> createEntrySet() {
        if (isEmpty()) {
            return ImmutableSet.of();
        }
        return new EntrySet();
    }

    public static <E> ImmutableMultiset<E> of(E e6, E e7) {
        return copyFromElements(e6, e7);
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(@NullableDecl Object obj) {
        if (count(obj) > 0) {
            return true;
        }
        return false;
    }

    @Override // com.google.common.collect.ImmutableCollection
    @GwtIncompatible
    int copyIntoArray(Object[] objArr, int i6) {
        UnmodifiableIterator<Multiset.Entry<E>> it = entrySet().iterator();
        while (it.hasNext()) {
            Multiset.Entry<E> next = it.next();
            Arrays.fill(objArr, i6, next.getCount() + i6, next.getElement());
            i6 += next.getCount();
        }
        return i6;
    }

    @Override // java.util.Collection, com.google.common.collect.Multiset
    public boolean equals(@NullableDecl Object obj) {
        return Multisets.equalsImpl(this, obj);
    }

    @Override // java.util.Collection, com.google.common.collect.Multiset
    public int hashCode() {
        return Sets.hashCodeImpl(entrySet());
    }

    @Override // java.util.AbstractCollection, com.google.common.collect.Multiset
    public String toString() {
        return entrySet().toString();
    }

    public static <E> ImmutableMultiset<E> of(E e6, E e7, E e8) {
        return copyFromElements(e6, e7, e8);
    }

    public static <E> ImmutableMultiset<E> of(E e6, E e7, E e8, E e9) {
        return copyFromElements(e6, e7, e8, e9);
    }

    public static <E> ImmutableMultiset<E> of(E e6, E e7, E e8, E e9, E e10) {
        return copyFromElements(e6, e7, e8, e9, e10);
    }

    public static <E> ImmutableMultiset<E> of(E e6, E e7, E e8, E e9, E e10, E e11, E... eArr) {
        return new Builder().add((Builder) e6).add((Builder<E>) e7).add((Builder<E>) e8).add((Builder<E>) e9).add((Builder<E>) e10).add((Builder<E>) e11).add((Object[]) eArr).build();
    }

    public static <E> ImmutableMultiset<E> copyOf(Iterator<? extends E> it) {
        return new Builder().addAll((Iterator) it).build();
    }
}
