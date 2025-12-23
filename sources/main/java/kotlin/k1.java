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
@SourceDebugExtension({"SMAP\nUShortArray.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UShortArray.kt\nkotlin/UShortArray\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,82:1\n1740#2,3:83\n*S KotlinDebug\n*F\n+ 1 UShortArray.kt\nkotlin/UShortArray\n*L\n58#1:83,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class k1 implements Collection<j1>, m3.a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final short[] f44108a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class a implements Iterator<j1>, m3.a {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        private final short[] f44109a;

        /* renamed from: b, reason: collision with root package name */
        private int f44110b;

        public a(@NotNull short[] array) {
            kotlin.jvm.internal.g0.p(array, "array");
            this.f44109a = array;
        }

        public short a() {
            int i6 = this.f44110b;
            short[] sArr = this.f44109a;
            if (i6 >= sArr.length) {
                throw new NoSuchElementException(String.valueOf(this.f44110b));
            }
            this.f44110b = i6 + 1;
            return j1.k(sArr[i6]);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f44110b < this.f44109a.length;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ j1 next() {
            return j1.b(a());
        }
    }

    public static int r(short[] sArr) {
        return sArr.length;
    }

    public static boolean v(short[] sArr) {
        return sArr.length == 0;
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        return kotlin.jvm.internal.u.a(this);
    }

    public static final /* synthetic */ k1 d(short[] sArr) {
        return new k1(sArr);
    }

    @NotNull
    public static short[] e(int i6) {
        return f(new short[i6]);
    }

    @PublishedApi
    @NotNull
    public static short[] f(@NotNull short[] storage) {
        kotlin.jvm.internal.g0.p(storage, "storage");
        return storage;
    }

    public static boolean m(short[] sArr, @NotNull Collection<j1> elements) {
        kotlin.jvm.internal.g0.p(elements, "elements");
        Collection<j1> collection = elements;
        if (collection.isEmpty()) {
            return true;
        }
        for (Object obj : collection) {
            if (!(obj instanceof j1) || !kotlin.collections.n.C8(sArr, ((j1) obj).o0())) {
                return false;
            }
        }
        return true;
    }

    public static boolean n(short[] sArr, Object obj) {
        return (obj instanceof k1) && kotlin.jvm.internal.g0.g(sArr, ((k1) obj).z());
    }

    public static final short p(short[] sArr, int i6) {
        return j1.k(sArr[i6]);
    }

    @NotNull
    public static Iterator<j1> w(short[] sArr) {
        return new a(sArr);
    }

    public static final void x(short[] sArr, int i6, short s5) {
        sArr[i6] = s5;
    }

    public static String y(short[] sArr) {
        return "UShortArray(storage=" + Arrays.toString(sArr) + ')';
    }

    public boolean a(short s5) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public /* bridge */ /* synthetic */ boolean add(j1 j1Var) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends j1> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof j1) {
            return g(((j1) obj).o0());
        }
        return false;
    }

    @Override // java.util.Collection
    public boolean containsAll(@NotNull Collection<?> elements) {
        kotlin.jvm.internal.g0.p(elements, "elements");
        return m(this.f44108a, elements);
    }

    @Override // java.util.Collection
    public boolean equals(Object obj) {
        return n(this.f44108a, obj);
    }

    public boolean g(short s5) {
        return j(this.f44108a, s5);
    }

    @Override // java.util.Collection
    public int hashCode() {
        return u(this.f44108a);
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return v(this.f44108a);
    }

    @Override // java.util.Collection, java.lang.Iterable
    @NotNull
    public Iterator<j1> iterator() {
        return w(this.f44108a);
    }

    @Override // java.util.Collection
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public int size() {
        return r(this.f44108a);
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
        return y(this.f44108a);
    }

    public final /* synthetic */ short[] z() {
        return this.f44108a;
    }

    @PublishedApi
    private /* synthetic */ k1(short[] sArr) {
        this.f44108a = sArr;
    }

    public static boolean j(short[] sArr, short s5) {
        return kotlin.collections.n.C8(sArr, s5);
    }

    public static final boolean o(short[] sArr, short[] sArr2) {
        return kotlin.jvm.internal.g0.g(sArr, sArr2);
    }

    public static int u(short[] sArr) {
        return Arrays.hashCode(sArr);
    }

    @PublishedApi
    public static /* synthetic */ void t() {
    }
}
