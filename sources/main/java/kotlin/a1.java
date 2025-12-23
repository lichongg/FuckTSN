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
@SourceDebugExtension({"SMAP\nUIntArray.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UIntArray.kt\nkotlin/UIntArray\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,82:1\n1740#2,3:83\n*S KotlinDebug\n*F\n+ 1 UIntArray.kt\nkotlin/UIntArray\n*L\n58#1:83,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class a1 implements Collection<z0>, m3.a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final int[] f43575a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class a implements Iterator<z0>, m3.a {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        private final int[] f43576a;

        /* renamed from: b, reason: collision with root package name */
        private int f43577b;

        public a(@NotNull int[] array) {
            kotlin.jvm.internal.g0.p(array, "array");
            this.f43576a = array;
        }

        public int a() {
            int i6 = this.f43577b;
            int[] iArr = this.f43576a;
            if (i6 >= iArr.length) {
                throw new NoSuchElementException(String.valueOf(this.f43577b));
            }
            this.f43577b = i6 + 1;
            return z0.k(iArr[i6]);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f43577b < this.f43576a.length;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ z0 next() {
            return z0.b(a());
        }
    }

    public static int r(int[] iArr) {
        return iArr.length;
    }

    public static boolean v(int[] iArr) {
        return iArr.length == 0;
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        return kotlin.jvm.internal.u.a(this);
    }

    public static final /* synthetic */ a1 d(int[] iArr) {
        return new a1(iArr);
    }

    @NotNull
    public static int[] e(int i6) {
        return f(new int[i6]);
    }

    @PublishedApi
    @NotNull
    public static int[] f(@NotNull int[] storage) {
        kotlin.jvm.internal.g0.p(storage, "storage");
        return storage;
    }

    public static boolean m(int[] iArr, @NotNull Collection<z0> elements) {
        kotlin.jvm.internal.g0.p(elements, "elements");
        Collection<z0> collection = elements;
        if (collection.isEmpty()) {
            return true;
        }
        for (Object obj : collection) {
            if (!(obj instanceof z0) || !kotlin.collections.n.z8(iArr, ((z0) obj).q0())) {
                return false;
            }
        }
        return true;
    }

    public static boolean n(int[] iArr, Object obj) {
        return (obj instanceof a1) && kotlin.jvm.internal.g0.g(iArr, ((a1) obj).z());
    }

    public static final int p(int[] iArr, int i6) {
        return z0.k(iArr[i6]);
    }

    @NotNull
    public static Iterator<z0> w(int[] iArr) {
        return new a(iArr);
    }

    public static final void x(int[] iArr, int i6, int i7) {
        iArr[i6] = i7;
    }

    public static String y(int[] iArr) {
        return "UIntArray(storage=" + Arrays.toString(iArr) + ')';
    }

    public boolean a(int i6) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public /* bridge */ /* synthetic */ boolean add(z0 z0Var) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends z0> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof z0) {
            return g(((z0) obj).q0());
        }
        return false;
    }

    @Override // java.util.Collection
    public boolean containsAll(@NotNull Collection<?> elements) {
        kotlin.jvm.internal.g0.p(elements, "elements");
        return m(this.f43575a, elements);
    }

    @Override // java.util.Collection
    public boolean equals(Object obj) {
        return n(this.f43575a, obj);
    }

    public boolean g(int i6) {
        return j(this.f43575a, i6);
    }

    @Override // java.util.Collection
    public int hashCode() {
        return u(this.f43575a);
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return v(this.f43575a);
    }

    @Override // java.util.Collection, java.lang.Iterable
    @NotNull
    public Iterator<z0> iterator() {
        return w(this.f43575a);
    }

    @Override // java.util.Collection
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public int size() {
        return r(this.f43575a);
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
        return y(this.f43575a);
    }

    public final /* synthetic */ int[] z() {
        return this.f43575a;
    }

    @PublishedApi
    private /* synthetic */ a1(int[] iArr) {
        this.f43575a = iArr;
    }

    public static boolean j(int[] iArr, int i6) {
        return kotlin.collections.n.z8(iArr, i6);
    }

    public static final boolean o(int[] iArr, int[] iArr2) {
        return kotlin.jvm.internal.g0.g(iArr, iArr2);
    }

    public static int u(int[] iArr) {
        return Arrays.hashCode(iArr);
    }

    @PublishedApi
    public static /* synthetic */ void t() {
    }
}
