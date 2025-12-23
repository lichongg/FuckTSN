package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SinceKotlin(version = "1.1")
@SourceDebugExtension({"SMAP\nAbstractList.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AbstractList.kt\nkotlin/collections/AbstractList\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,181:1\n360#2,7:182\n388#2,7:189\n*S KotlinDebug\n*F\n+ 1 AbstractList.kt\nkotlin/collections/AbstractList\n*L\n27#1:182,7\n29#1:189,7\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class d<E> extends kotlin.collections.b<E> implements List<E>, m3.a {

    @NotNull
    public static final a Companion = new a(null);
    private static final int maxArraySize = 2147483639;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.v vVar) {
            this();
        }

        private a() {
        }

        public final void a(int i6, int i7, int i8) {
            if (i6 < 0 || i7 > i8) {
                throw new IndexOutOfBoundsException("startIndex: " + i6 + ", endIndex: " + i7 + ", size: " + i8);
            }
            if (i6 <= i7) {
                return;
            }
            throw new IllegalArgumentException("startIndex: " + i6 + " > endIndex: " + i7);
        }

        public final void b(int i6, int i7) {
            if (i6 < 0 || i6 >= i7) {
                throw new IndexOutOfBoundsException("index: " + i6 + ", size: " + i7);
            }
        }

        public final void c(int i6, int i7) {
            if (i6 < 0 || i6 > i7) {
                throw new IndexOutOfBoundsException("index: " + i6 + ", size: " + i7);
            }
        }

        public final void d(int i6, int i7, int i8) {
            if (i6 < 0 || i7 > i8) {
                throw new IndexOutOfBoundsException("fromIndex: " + i6 + ", toIndex: " + i7 + ", size: " + i8);
            }
            if (i6 <= i7) {
                return;
            }
            throw new IllegalArgumentException("fromIndex: " + i6 + " > toIndex: " + i7);
        }

        public final int e(int i6, int i7) {
            int i8 = i6 + (i6 >> 1);
            if (i8 - i7 < 0) {
                i8 = i7;
            }
            if (i8 - d.maxArraySize <= 0) {
                return i8;
            }
            if (i7 > d.maxArraySize) {
                return Integer.MAX_VALUE;
            }
            return d.maxArraySize;
        }

        public final boolean f(@NotNull Collection<?> c6, @NotNull Collection<?> other) {
            kotlin.jvm.internal.g0.p(c6, "c");
            kotlin.jvm.internal.g0.p(other, "other");
            if (c6.size() != other.size()) {
                return false;
            }
            Iterator<?> it = other.iterator();
            Iterator<?> it2 = c6.iterator();
            while (it2.hasNext()) {
                if (!kotlin.jvm.internal.g0.g(it2.next(), it.next())) {
                    return false;
                }
            }
            return true;
        }

        public final int g(@NotNull Collection<?> c6) {
            kotlin.jvm.internal.g0.p(c6, "c");
            Iterator<?> it = c6.iterator();
            int i6 = 1;
            while (it.hasNext()) {
                Object next = it.next();
                i6 = (i6 * 31) + (next != null ? next.hashCode() : 0);
            }
            return i6;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class b implements Iterator<E>, m3.a {

        /* renamed from: a, reason: collision with root package name */
        private int f43631a;

        public b() {
        }

        protected final int a() {
            return this.f43631a;
        }

        protected final void c(int i6) {
            this.f43631a = i6;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f43631a < d.this.size();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Iterator
        public E next() {
            if (hasNext()) {
                d<E> dVar = d.this;
                int i6 = this.f43631a;
                this.f43631a = i6 + 1;
                return dVar.get(i6);
            }
            throw new NoSuchElementException();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class c extends d<E>.b implements ListIterator<E>, m3.a {
        public c(int i6) {
            super();
            d.Companion.c(i6, d.this.size());
            c(i6);
        }

        @Override // java.util.ListIterator
        public void add(E e6) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.ListIterator
        public void set(E e6) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            if (a() > 0) {
                return true;
            }
            return false;
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return a();
        }

        @Override // java.util.ListIterator
        public E previous() {
            if (hasPrevious()) {
                d<E> dVar = d.this;
                c(a() - 1);
                return dVar.get(a());
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return a() - 1;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: kotlin.collections.d$d, reason: collision with other inner class name */
    private static final class C0859d<E> extends d<E> implements RandomAccess {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        private final d<E> f43634a;

        /* renamed from: b, reason: collision with root package name */
        private final int f43635b;

        /* renamed from: c, reason: collision with root package name */
        private int f43636c;

        /* JADX WARN: Multi-variable type inference failed */
        public C0859d(@NotNull d<? extends E> list, int i6, int i7) {
            kotlin.jvm.internal.g0.p(list, "list");
            this.f43634a = list;
            this.f43635b = i6;
            d.Companion.d(i6, i7, list.size());
            this.f43636c = i7 - i6;
        }

        @Override // kotlin.collections.d, java.util.List
        public E get(int i6) {
            d.Companion.b(i6, this.f43636c);
            return this.f43634a.get(this.f43635b + i6);
        }

        @Override // kotlin.collections.d, kotlin.collections.b
        public int getSize() {
            return this.f43636c;
        }

        @Override // kotlin.collections.d, java.util.List
        @NotNull
        public List<E> subList(int i6, int i7) {
            d.Companion.d(i6, i7, this.f43636c);
            d<E> dVar = this.f43634a;
            int i8 = this.f43635b;
            return new C0859d(dVar, i6 + i8, i8 + i7);
        }
    }

    @Override // java.util.List
    public abstract E get(int i6);

    @Override // kotlin.collections.b
    public abstract int getSize();

    @Override // java.util.List
    @NotNull
    public ListIterator<E> listIterator() {
        return new c(0);
    }

    @Override // java.util.List
    public void add(int i6, E e6) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public boolean addAll(int i6, Collection<? extends E> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection, java.util.List
    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof List) {
            return Companion.f(this, (Collection) obj);
        }
        return false;
    }

    @Override // java.util.Collection, java.util.List
    public int hashCode() {
        return Companion.g(this);
    }

    @Override // kotlin.collections.b, java.util.Collection, java.lang.Iterable
    @NotNull
    public Iterator<E> iterator() {
        return new b();
    }

    @Override // java.util.List
    @NotNull
    public ListIterator<E> listIterator(int i6) {
        return new c(i6);
    }

    @Override // java.util.List
    public E remove(int i6) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public E set(int i6, E e6) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    @NotNull
    public List<E> subList(int i6, int i7) {
        return new C0859d(this, i6, i7);
    }

    protected d() {
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        Iterator<E> it = iterator();
        int i6 = 0;
        while (it.hasNext()) {
            if (kotlin.jvm.internal.g0.g(it.next(), obj)) {
                return i6;
            }
            i6++;
        }
        return -1;
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        ListIterator<E> listIterator = listIterator(size());
        while (listIterator.hasPrevious()) {
            if (kotlin.jvm.internal.g0.g(listIterator.previous(), obj)) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }
}
