package kotlin;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SinceKotlin(version = "1.3")
@ExperimentalUnsignedTypes
@JvmInline
@SourceDebugExtension({"SMAP\nULongArray.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ULongArray.kt\nkotlin/ULongArray\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,82:1\n1740#2,3:83\n*S KotlinDebug\n*F\n+ 1 ULongArray.kt\nkotlin/ULongArray\n*L\n58#1:83,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class e1 implements Collection<d1>, m3.a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final long[] f43788a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class a implements Iterator<d1>, m3.a {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        private final long[] f43789a;

        /* renamed from: b, reason: collision with root package name */
        private int f43790b;

        public a(@NotNull long[] array) {
            kotlin.jvm.internal.g0.p(array, "array");
            this.f43789a = array;
        }

        public long a() {
            int i6 = this.f43790b;
            long[] jArr = this.f43789a;
            if (i6 >= jArr.length) {
                throw new NoSuchElementException(String.valueOf(this.f43790b));
            }
            this.f43790b = i6 + 1;
            return d1.k(jArr[i6]);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f43790b < this.f43789a.length;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ d1 next() {
            return d1.b(a());
        }
    }

    public static int r(long[] jArr) {
        return jArr.length;
    }

    public static boolean v(long[] jArr) {
        return jArr.length == 0;
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        return kotlin.jvm.internal.u.a(this);
    }

    public static final /* synthetic */ e1 d(long[] jArr) {
        return new e1(jArr);
    }

    @NotNull
    public static long[] e(int i6) {
        return f(new long[i6]);
    }

    @PublishedApi
    @NotNull
    public static long[] f(@NotNull long[] storage) {
        kotlin.jvm.internal.g0.p(storage, "storage");
        return storage;
    }

    public static boolean m(long[] jArr, @NotNull Collection<d1> elements) {
        kotlin.jvm.internal.g0.p(elements, "elements");
        Collection<d1> collection = elements;
        if (collection.isEmpty()) {
            return true;
        }
        for (Object obj : collection) {
            if (!(obj instanceof d1) || !kotlin.collections.n.A8(jArr, ((d1) obj).q0())) {
                return false;
            }
        }
        return true;
    }

    public static boolean n(long[] jArr, Object obj) {
        return (obj instanceof e1) && kotlin.jvm.internal.g0.g(jArr, ((e1) obj).z());
    }

    public static final long p(long[] jArr, int i6) {
        return d1.k(jArr[i6]);
    }

    @NotNull
    public static Iterator<d1> w(long[] jArr) {
        return new a(jArr);
    }

    public static final void x(long[] jArr, int i6, long j6) {
        jArr[i6] = j6;
    }

    public static String y(long[] jArr) {
        return "ULongArray(storage=" + Arrays.toString(jArr) + ')';
    }

    public boolean a(long j6) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public /* bridge */ /* synthetic */ boolean add(d1 d1Var) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends d1> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof d1) {
            return g(((d1) obj).q0());
        }
        return false;
    }

    @Override // java.util.Collection
    public boolean containsAll(@NotNull Collection<?> elements) {
        kotlin.jvm.internal.g0.p(elements, "elements");
        return m(this.f43788a, elements);
    }

    @Override // java.util.Collection
    public boolean equals(Object obj) {
        return n(this.f43788a, obj);
    }

    public boolean g(long j6) {
        return j(this.f43788a, j6);
    }

    @Override // java.util.Collection
    public int hashCode() {
        return u(this.f43788a);
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return v(this.f43788a);
    }

    @Override // java.util.Collection, java.lang.Iterable
    @NotNull
    public Iterator<d1> iterator() {
        return w(this.f43788a);
    }

    @Override // java.util.Collection
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public int size() {
        return r(this.f43788a);
    }

    @Override // java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] array) {
        kotlin.jvm.internal.g0.p(array, "array");
        return (T[]) kotlin.jvm.internal.u.b(this, array);
    }

    public String toString() {
        return y(this.f43788a);
    }

    public final /* synthetic */ long[] z() {
        return this.f43788a;
    }

    @PublishedApi
    private /* synthetic */ e1(long[] jArr) {
        this.f43788a = jArr;
    }

    public static boolean j(long[] jArr, long j6) {
        return kotlin.collections.n.A8(jArr, j6);
    }

    public static final boolean o(long[] jArr, long[] jArr2) {
        return kotlin.jvm.internal.g0.g(jArr, jArr2);
    }

    public static int u(long[] jArr) {
        return Arrays.hashCode(jArr);
    }

    @PublishedApi
    public static /* synthetic */ void t() {
    }
}
