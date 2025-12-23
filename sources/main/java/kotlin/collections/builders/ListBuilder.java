package kotlin.collections.builders;

import java.io.InvalidObjectException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.collections.f0;
import kotlin.collections.h;
import kotlin.collections.n;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nListBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ListBuilder.kt\nkotlin/collections/builders/ListBuilder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,722:1\n1#2:723\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class ListBuilder<E> extends h<E> implements List<E>, RandomAccess, Serializable, m3.e {

    @NotNull
    private static final a Companion = new a(null);

    @NotNull
    private static final ListBuilder Empty;

    @NotNull
    private E[] backing;
    private boolean isReadOnly;
    private int length;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class BuilderSubList<E> extends h<E> implements List<E>, RandomAccess, Serializable, m3.e {

        @NotNull
        private E[] backing;
        private int length;
        private final int offset;

        @Nullable
        private final BuilderSubList<E> parent;

        @NotNull
        private final ListBuilder<E> root;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        @SourceDebugExtension({"SMAP\nListBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ListBuilder.kt\nkotlin/collections/builders/ListBuilder$BuilderSubList$Itr\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,722:1\n1#2:723\n*E\n"})
        private static final class a<E> implements ListIterator<E>, m3.f {

            /* renamed from: a, reason: collision with root package name */
            @NotNull
            private final BuilderSubList<E> f43607a;

            /* renamed from: b, reason: collision with root package name */
            private int f43608b;

            /* renamed from: c, reason: collision with root package name */
            private int f43609c;

            /* renamed from: d, reason: collision with root package name */
            private int f43610d;

            public a(@NotNull BuilderSubList<E> list, int i6) {
                g0.p(list, "list");
                this.f43607a = list;
                this.f43608b = i6;
                this.f43609c = -1;
                this.f43610d = ((AbstractList) list).modCount;
            }

            private final void a() {
                if (((AbstractList) ((BuilderSubList) this.f43607a).root).modCount != this.f43610d) {
                    throw new ConcurrentModificationException();
                }
            }

            @Override // java.util.ListIterator, java.util.Iterator
            public boolean hasNext() {
                return this.f43608b < ((BuilderSubList) this.f43607a).length;
            }

            @Override // java.util.ListIterator
            public boolean hasPrevious() {
                return this.f43608b > 0;
            }

            @Override // java.util.ListIterator
            public int nextIndex() {
                return this.f43608b;
            }

            @Override // java.util.ListIterator
            public int previousIndex() {
                return this.f43608b - 1;
            }

            @Override // java.util.ListIterator
            public void add(E e6) {
                a();
                BuilderSubList<E> builderSubList = this.f43607a;
                int i6 = this.f43608b;
                this.f43608b = i6 + 1;
                builderSubList.add(i6, e6);
                this.f43609c = -1;
                this.f43610d = ((AbstractList) this.f43607a).modCount;
            }

            @Override // java.util.ListIterator, java.util.Iterator
            public E next() {
                a();
                if (this.f43608b < ((BuilderSubList) this.f43607a).length) {
                    int i6 = this.f43608b;
                    this.f43608b = i6 + 1;
                    this.f43609c = i6;
                    return (E) ((BuilderSubList) this.f43607a).backing[((BuilderSubList) this.f43607a).offset + this.f43609c];
                }
                throw new NoSuchElementException();
            }

            @Override // java.util.ListIterator
            public E previous() {
                a();
                int i6 = this.f43608b;
                if (i6 > 0) {
                    int i7 = i6 - 1;
                    this.f43608b = i7;
                    this.f43609c = i7;
                    return (E) ((BuilderSubList) this.f43607a).backing[((BuilderSubList) this.f43607a).offset + this.f43609c];
                }
                throw new NoSuchElementException();
            }

            @Override // java.util.ListIterator, java.util.Iterator
            public void remove() {
                a();
                int i6 = this.f43609c;
                if (i6 != -1) {
                    this.f43607a.removeAt(i6);
                    this.f43608b = this.f43609c;
                    this.f43609c = -1;
                    this.f43610d = ((AbstractList) this.f43607a).modCount;
                    return;
                }
                throw new IllegalStateException("Call next() or previous() before removing element from the iterator.");
            }

            @Override // java.util.ListIterator
            public void set(E e6) {
                a();
                int i6 = this.f43609c;
                if (i6 != -1) {
                    this.f43607a.set(i6, e6);
                    return;
                }
                throw new IllegalStateException("Call next() or previous() before replacing element from the iterator.");
            }
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean add(E e6) {
            checkIsMutable();
            checkForComodification();
            addAtInternal(this.offset + this.length, e6);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean addAll(@NotNull Collection<? extends E> elements) {
            g0.p(elements, "elements");
            checkIsMutable();
            checkForComodification();
            int size = elements.size();
            addAllInternal(this.offset + this.length, elements, size);
            return size > 0;
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
        @NotNull
        public Iterator<E> iterator() {
            return listIterator(0);
        }

        @Override // java.util.AbstractList, java.util.List
        @NotNull
        public ListIterator<E> listIterator() {
            return listIterator(0);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        @NotNull
        public <T> T[] toArray(@NotNull T[] array) {
            g0.p(array, "array");
            checkForComodification();
            int length = array.length;
            int i6 = this.length;
            if (length >= i6) {
                E[] eArr = this.backing;
                int i7 = this.offset;
                n.B0(eArr, array, 0, i7, i6 + i7);
                return (T[]) f0.o(this.length, array);
            }
            E[] eArr2 = this.backing;
            int i8 = this.offset;
            T[] tArr = (T[]) Arrays.copyOfRange(eArr2, i8, i6 + i8, array.getClass());
            g0.o(tArr, "copyOfRange(...)");
            return tArr;
        }

        public BuilderSubList(@NotNull E[] backing, int i6, int i7, @Nullable BuilderSubList<E> builderSubList, @NotNull ListBuilder<E> root) {
            g0.p(backing, "backing");
            g0.p(root, "root");
            this.backing = backing;
            this.offset = i6;
            this.length = i7;
            this.parent = builderSubList;
            this.root = root;
            ((AbstractList) this).modCount = ((AbstractList) root).modCount;
        }

        private final void checkForComodification() {
            if (((AbstractList) this.root).modCount != ((AbstractList) this).modCount) {
                throw new ConcurrentModificationException();
            }
        }

        private final boolean contentEquals(List<?> list) {
            boolean h6;
            h6 = kotlin.collections.builders.b.h(this.backing, this.offset, this.length, list);
            return h6;
        }

        private final boolean isReadOnly() {
            return ((ListBuilder) this.root).isReadOnly;
        }

        private final void readObject(ObjectInputStream objectInputStream) {
            throw new InvalidObjectException("Deserialization is supported via proxy only");
        }

        private final void registerModification() {
            ((AbstractList) this).modCount++;
        }

        private final void removeRangeInternal(int i6, int i7) {
            if (i7 > 0) {
                registerModification();
            }
            BuilderSubList<E> builderSubList = this.parent;
            if (builderSubList != null) {
                builderSubList.removeRangeInternal(i6, i7);
            } else {
                this.root.removeRangeInternal(i6, i7);
            }
            this.length -= i7;
        }

        private final int retainOrRemoveAllInternal(int i6, int i7, Collection<? extends E> collection, boolean z5) {
            BuilderSubList<E> builderSubList = this.parent;
            int retainOrRemoveAllInternal = builderSubList != null ? builderSubList.retainOrRemoveAllInternal(i6, i7, collection, z5) : this.root.retainOrRemoveAllInternal(i6, i7, collection, z5);
            if (retainOrRemoveAllInternal > 0) {
                registerModification();
            }
            this.length -= retainOrRemoveAllInternal;
            return retainOrRemoveAllInternal;
        }

        @Override // java.util.AbstractList, java.util.List
        @NotNull
        public ListIterator<E> listIterator(int i6) {
            checkForComodification();
            kotlin.collections.d.Companion.c(i6, this.length);
            return new a(this, i6);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean removeAll(@NotNull Collection<?> elements) {
            g0.p(elements, "elements");
            checkIsMutable();
            checkForComodification();
            return retainOrRemoveAllInternal(this.offset, this.length, elements, false) > 0;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean retainAll(@NotNull Collection<?> elements) {
            g0.p(elements, "elements");
            checkIsMutable();
            checkForComodification();
            return retainOrRemoveAllInternal(this.offset, this.length, elements, true) > 0;
        }

        @Override // java.util.AbstractList, java.util.List
        @NotNull
        public List<E> subList(int i6, int i7) {
            kotlin.collections.d.Companion.d(i6, i7, this.length);
            return new BuilderSubList(this.backing, this.offset + i6, i7 - i6, this, this.root);
        }

        private final void addAllInternal(int i6, Collection<? extends E> collection, int i7) {
            registerModification();
            BuilderSubList<E> builderSubList = this.parent;
            if (builderSubList == null) {
                this.root.addAllInternal(i6, collection, i7);
            } else {
                builderSubList.addAllInternal(i6, collection, i7);
            }
            this.backing = (E[]) ((ListBuilder) this.root).backing;
            this.length += i7;
        }

        private final void addAtInternal(int i6, E e6) {
            registerModification();
            BuilderSubList<E> builderSubList = this.parent;
            if (builderSubList == null) {
                this.root.addAtInternal(i6, e6);
            } else {
                builderSubList.addAtInternal(i6, e6);
            }
            this.backing = (E[]) ((ListBuilder) this.root).backing;
            this.length++;
        }

        private final void checkIsMutable() {
            if (!isReadOnly()) {
            } else {
                throw new UnsupportedOperationException();
            }
        }

        private final E removeAtInternal(int i6) {
            E e6;
            registerModification();
            BuilderSubList<E> builderSubList = this.parent;
            if (builderSubList == null) {
                e6 = (E) this.root.removeAtInternal(i6);
            } else {
                e6 = builderSubList.removeAtInternal(i6);
            }
            this.length--;
            return e6;
        }

        private final Object writeReplace() {
            if (isReadOnly()) {
                return new SerializedCollection(this, 0);
            }
            throw new NotSerializableException("The list cannot be serialized while it is being built.");
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public void clear() {
            checkIsMutable();
            checkForComodification();
            removeRangeInternal(this.offset, this.length);
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(@Nullable Object obj) {
            checkForComodification();
            if (obj != this) {
                if (!(obj instanceof List) || !contentEquals((List) obj)) {
                    return false;
                }
                return true;
            }
            return true;
        }

        @Override // java.util.AbstractList, java.util.List
        public E get(int i6) {
            checkForComodification();
            kotlin.collections.d.Companion.b(i6, this.length);
            return this.backing[this.offset + i6];
        }

        @Override // kotlin.collections.h
        public int getSize() {
            checkForComodification();
            return this.length;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            int i6;
            checkForComodification();
            i6 = kotlin.collections.builders.b.i(this.backing, this.offset, this.length);
            return i6;
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(Object obj) {
            checkForComodification();
            for (int i6 = 0; i6 < this.length; i6++) {
                if (g0.g(this.backing[this.offset + i6], obj)) {
                    return i6;
                }
            }
            return -1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            checkForComodification();
            if (this.length == 0) {
                return true;
            }
            return false;
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(Object obj) {
            checkForComodification();
            for (int i6 = this.length - 1; i6 >= 0; i6--) {
                if (g0.g(this.backing[this.offset + i6], obj)) {
                    return i6;
                }
            }
            return -1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean remove(Object obj) {
            checkIsMutable();
            checkForComodification();
            int indexOf = indexOf(obj);
            if (indexOf >= 0) {
                removeAt(indexOf);
            }
            if (indexOf >= 0) {
                return true;
            }
            return false;
        }

        @Override // kotlin.collections.h
        public E removeAt(int i6) {
            checkIsMutable();
            checkForComodification();
            kotlin.collections.d.Companion.b(i6, this.length);
            return removeAtInternal(this.offset + i6);
        }

        @Override // kotlin.collections.h, java.util.AbstractList, java.util.List
        public E set(int i6, E e6) {
            checkIsMutable();
            checkForComodification();
            kotlin.collections.d.Companion.b(i6, this.length);
            E[] eArr = this.backing;
            int i7 = this.offset;
            E e7 = eArr[i7 + i6];
            eArr[i7 + i6] = e6;
            return e7;
        }

        @Override // java.util.AbstractCollection
        @NotNull
        public String toString() {
            String j6;
            checkForComodification();
            j6 = kotlin.collections.builders.b.j(this.backing, this.offset, this.length, this);
            return j6;
        }

        @Override // kotlin.collections.h, java.util.AbstractList, java.util.List
        public void add(int i6, E e6) {
            checkIsMutable();
            checkForComodification();
            kotlin.collections.d.Companion.c(i6, this.length);
            addAtInternal(this.offset + i6, e6);
        }

        @Override // java.util.AbstractList, java.util.List
        public boolean addAll(int i6, @NotNull Collection<? extends E> elements) {
            g0.p(elements, "elements");
            checkIsMutable();
            checkForComodification();
            kotlin.collections.d.Companion.c(i6, this.length);
            int size = elements.size();
            addAllInternal(this.offset + i6, elements, size);
            return size > 0;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        @NotNull
        public Object[] toArray() {
            checkForComodification();
            E[] eArr = this.backing;
            int i6 = this.offset;
            return n.l1(eArr, i6, this.length + i6);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class a {
        public /* synthetic */ a(v vVar) {
            this();
        }

        private a() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nListBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ListBuilder.kt\nkotlin/collections/builders/ListBuilder$Itr\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,722:1\n1#2:723\n*E\n"})
    private static final class b<E> implements ListIterator<E>, m3.f {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        private final ListBuilder<E> f43611a;

        /* renamed from: b, reason: collision with root package name */
        private int f43612b;

        /* renamed from: c, reason: collision with root package name */
        private int f43613c;

        /* renamed from: d, reason: collision with root package name */
        private int f43614d;

        public b(@NotNull ListBuilder<E> list, int i6) {
            g0.p(list, "list");
            this.f43611a = list;
            this.f43612b = i6;
            this.f43613c = -1;
            this.f43614d = ((AbstractList) list).modCount;
        }

        private final void a() {
            if (((AbstractList) this.f43611a).modCount != this.f43614d) {
                throw new ConcurrentModificationException();
            }
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.f43612b < ((ListBuilder) this.f43611a).length;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.f43612b > 0;
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.f43612b;
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.f43612b - 1;
        }

        @Override // java.util.ListIterator
        public void add(E e6) {
            a();
            ListBuilder<E> listBuilder = this.f43611a;
            int i6 = this.f43612b;
            this.f43612b = i6 + 1;
            listBuilder.add(i6, e6);
            this.f43613c = -1;
            this.f43614d = ((AbstractList) this.f43611a).modCount;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public E next() {
            a();
            if (this.f43612b < ((ListBuilder) this.f43611a).length) {
                int i6 = this.f43612b;
                this.f43612b = i6 + 1;
                this.f43613c = i6;
                return (E) ((ListBuilder) this.f43611a).backing[this.f43613c];
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.ListIterator
        public E previous() {
            a();
            int i6 = this.f43612b;
            if (i6 > 0) {
                int i7 = i6 - 1;
                this.f43612b = i7;
                this.f43613c = i7;
                return (E) ((ListBuilder) this.f43611a).backing[this.f43613c];
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            a();
            int i6 = this.f43613c;
            if (i6 != -1) {
                this.f43611a.removeAt(i6);
                this.f43612b = this.f43613c;
                this.f43613c = -1;
                this.f43614d = ((AbstractList) this.f43611a).modCount;
                return;
            }
            throw new IllegalStateException("Call next() or previous() before removing element from the iterator.");
        }

        @Override // java.util.ListIterator
        public void set(E e6) {
            a();
            int i6 = this.f43613c;
            if (i6 != -1) {
                this.f43611a.set(i6, e6);
                return;
            }
            throw new IllegalStateException("Call next() or previous() before replacing element from the iterator.");
        }
    }

    public ListBuilder() {
        this(0, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int retainOrRemoveAllInternal(int i6, int i7, Collection<? extends E> collection, boolean z5) {
        int i8 = 0;
        int i9 = 0;
        while (i8 < i7) {
            int i10 = i6 + i8;
            if (collection.contains(this.backing[i10]) == z5) {
                E[] eArr = this.backing;
                i8++;
                eArr[i9 + i6] = eArr[i10];
                i9++;
            } else {
                i8++;
            }
        }
        int i11 = i7 - i9;
        E[] eArr2 = this.backing;
        n.B0(eArr2, eArr2, i6 + i9, i7 + i6, this.length);
        E[] eArr3 = this.backing;
        int i12 = this.length;
        kotlin.collections.builders.b.g(eArr3, i12 - i11, i12);
        if (i11 > 0) {
            registerModification();
        }
        this.length -= i11;
        return i11;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E e6) {
        checkIsMutable();
        addAtInternal(this.length, e6);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(@NotNull Collection<? extends E> elements) {
        g0.p(elements, "elements");
        checkIsMutable();
        int size = elements.size();
        addAllInternal(this.length, elements, size);
        return size > 0;
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        for (int i6 = 0; i6 < this.length; i6++) {
            if (g0.g(this.backing[i6], obj)) {
                return i6;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    @NotNull
    public Iterator<E> iterator() {
        return listIterator(0);
    }

    @Override // java.util.AbstractList, java.util.List
    @NotNull
    public ListIterator<E> listIterator() {
        return listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    @NotNull
    public <T> T[] toArray(@NotNull T[] array) {
        g0.p(array, "array");
        int length = array.length;
        int i6 = this.length;
        if (length >= i6) {
            n.B0(this.backing, array, 0, 0, i6);
            return (T[]) f0.o(this.length, array);
        }
        T[] tArr = (T[]) Arrays.copyOfRange(this.backing, 0, i6, array.getClass());
        g0.o(tArr, "copyOfRange(...)");
        return tArr;
    }

    static {
        ListBuilder listBuilder = new ListBuilder(0);
        listBuilder.isReadOnly = true;
        Empty = listBuilder;
    }

    public ListBuilder(int i6) {
        this.backing = (E[]) kotlin.collections.builders.b.d(i6);
    }

    private final void checkIsMutable() {
        if (this.isReadOnly) {
            throw new UnsupportedOperationException();
        }
    }

    private final boolean contentEquals(List<?> list) {
        boolean h6;
        h6 = kotlin.collections.builders.b.h(this.backing, 0, this.length, list);
        return h6;
    }

    private final void ensureCapacityInternal(int i6) {
        if (i6 < 0) {
            throw new OutOfMemoryError();
        }
        E[] eArr = this.backing;
        if (i6 > eArr.length) {
            this.backing = (E[]) kotlin.collections.builders.b.e(this.backing, kotlin.collections.d.Companion.e(eArr.length, i6));
        }
    }

    private final void ensureExtraCapacity(int i6) {
        ensureCapacityInternal(this.length + i6);
    }

    private final void registerModification() {
        ((AbstractList) this).modCount++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void removeRangeInternal(int i6, int i7) {
        if (i7 > 0) {
            registerModification();
        }
        E[] eArr = this.backing;
        n.B0(eArr, eArr, i6, i6 + i7, this.length);
        E[] eArr2 = this.backing;
        int i8 = this.length;
        kotlin.collections.builders.b.g(eArr2, i8 - i7, i8);
        this.length -= i7;
    }

    private final Object writeReplace() {
        if (this.isReadOnly) {
            return new SerializedCollection(this, 0);
        }
        throw new NotSerializableException("The list cannot be serialized while it is being built.");
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(@Nullable Object obj) {
        if (obj != this) {
            return (obj instanceof List) && contentEquals((List) obj);
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int i6) {
        kotlin.collections.d.Companion.b(i6, this.length);
        return this.backing[i6];
    }

    @Override // kotlin.collections.h
    public int getSize() {
        return this.length;
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int i6;
        i6 = kotlin.collections.builders.b.i(this.backing, 0, this.length);
        return i6;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return this.length == 0;
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(Object obj) {
        for (int i6 = this.length - 1; i6 >= 0; i6--) {
            if (g0.g(this.backing[i6], obj)) {
                return i6;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    @NotNull
    public ListIterator<E> listIterator(int i6) {
        kotlin.collections.d.Companion.c(i6, this.length);
        return new b(this, i6);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(@NotNull Collection<?> elements) {
        g0.p(elements, "elements");
        checkIsMutable();
        return retainOrRemoveAllInternal(0, this.length, elements, false) > 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(@NotNull Collection<?> elements) {
        g0.p(elements, "elements");
        checkIsMutable();
        return retainOrRemoveAllInternal(0, this.length, elements, true) > 0;
    }

    @Override // java.util.AbstractList, java.util.List
    @NotNull
    public List<E> subList(int i6, int i7) {
        kotlin.collections.d.Companion.d(i6, i7, this.length);
        return new BuilderSubList(this.backing, i6, i7 - i6, null, this);
    }

    @Override // java.util.AbstractCollection
    @NotNull
    public String toString() {
        String j6;
        j6 = kotlin.collections.builders.b.j(this.backing, 0, this.length, this);
        return j6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void addAllInternal(int i6, Collection<? extends E> collection, int i7) {
        registerModification();
        insertAtInternal(i6, i7);
        Iterator<? extends E> it = collection.iterator();
        for (int i8 = 0; i8 < i7; i8++) {
            this.backing[i6 + i8] = it.next();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void addAtInternal(int i6, E e6) {
        registerModification();
        insertAtInternal(i6, 1);
        this.backing[i6] = e6;
    }

    private final void insertAtInternal(int i6, int i7) {
        ensureExtraCapacity(i7);
        E[] eArr = this.backing;
        n.B0(eArr, eArr, i6 + i7, i6, this.length);
        this.length += i7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final E removeAtInternal(int i6) {
        registerModification();
        E[] eArr = this.backing;
        E e6 = eArr[i6];
        n.B0(eArr, eArr, i6, i6 + 1, this.length);
        kotlin.collections.builders.b.f(this.backing, this.length - 1);
        this.length--;
        return e6;
    }

    @Override // kotlin.collections.h, java.util.AbstractList, java.util.List
    public void add(int i6, E e6) {
        checkIsMutable();
        kotlin.collections.d.Companion.c(i6, this.length);
        addAtInternal(i6, e6);
    }

    @NotNull
    public final List<E> build() {
        checkIsMutable();
        this.isReadOnly = true;
        if (this.length > 0) {
            return this;
        }
        return Empty;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        checkIsMutable();
        removeRangeInternal(0, this.length);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        checkIsMutable();
        int indexOf = indexOf(obj);
        if (indexOf >= 0) {
            removeAt(indexOf);
        }
        if (indexOf >= 0) {
            return true;
        }
        return false;
    }

    @Override // kotlin.collections.h
    public E removeAt(int i6) {
        checkIsMutable();
        kotlin.collections.d.Companion.b(i6, this.length);
        return removeAtInternal(i6);
    }

    @Override // kotlin.collections.h, java.util.AbstractList, java.util.List
    public E set(int i6, E e6) {
        checkIsMutable();
        kotlin.collections.d.Companion.b(i6, this.length);
        E[] eArr = this.backing;
        E e7 = eArr[i6];
        eArr[i6] = e6;
        return e7;
    }

    public /* synthetic */ ListBuilder(int i6, int i7, v vVar) {
        this((i7 & 1) != 0 ? 10 : i6);
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int i6, @NotNull Collection<? extends E> elements) {
        g0.p(elements, "elements");
        checkIsMutable();
        kotlin.collections.d.Companion.c(i6, this.length);
        int size = elements.size();
        addAllInternal(i6, elements, size);
        return size > 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    @NotNull
    public Object[] toArray() {
        return n.l1(this.backing, 0, this.length);
    }
}
