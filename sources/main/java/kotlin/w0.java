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
@SourceDebugExtension({"SMAP\nUByteArray.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UByteArray.kt\nkotlin/UByteArray\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,82:1\n1740#2,3:83\n*S KotlinDebug\n*F\n+ 1 UByteArray.kt\nkotlin/UByteArray\n*L\n58#1:83,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class w0 implements Collection<v0>, m3.a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final byte[] f48069a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class a implements Iterator<v0>, m3.a {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        private final byte[] f48070a;

        /* renamed from: b, reason: collision with root package name */
        private int f48071b;

        public a(@NotNull byte[] array) {
            kotlin.jvm.internal.g0.p(array, "array");
            this.f48070a = array;
        }

        public byte a() {
            int i6 = this.f48071b;
            byte[] bArr = this.f48070a;
            if (i6 >= bArr.length) {
                throw new NoSuchElementException(String.valueOf(this.f48071b));
            }
            this.f48071b = i6 + 1;
            return v0.k(bArr[i6]);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f48071b < this.f48070a.length;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ v0 next() {
            return v0.b(a());
        }
    }

    public static int r(byte[] bArr) {
        return bArr.length;
    }

    public static boolean v(byte[] bArr) {
        return bArr.length == 0;
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        return kotlin.jvm.internal.u.a(this);
    }

    public static final /* synthetic */ w0 d(byte[] bArr) {
        return new w0(bArr);
    }

    @NotNull
    public static byte[] e(int i6) {
        return f(new byte[i6]);
    }

    @PublishedApi
    @NotNull
    public static byte[] f(@NotNull byte[] storage) {
        kotlin.jvm.internal.g0.p(storage, "storage");
        return storage;
    }

    public static boolean m(byte[] bArr, @NotNull Collection<v0> elements) {
        kotlin.jvm.internal.g0.p(elements, "elements");
        Collection<v0> collection = elements;
        if (collection.isEmpty()) {
            return true;
        }
        for (Object obj : collection) {
            if (!(obj instanceof v0) || !kotlin.collections.n.v8(bArr, ((v0) obj).o0())) {
                return false;
            }
        }
        return true;
    }

    public static boolean n(byte[] bArr, Object obj) {
        return (obj instanceof w0) && kotlin.jvm.internal.g0.g(bArr, ((w0) obj).z());
    }

    public static final byte p(byte[] bArr, int i6) {
        return v0.k(bArr[i6]);
    }

    @NotNull
    public static Iterator<v0> w(byte[] bArr) {
        return new a(bArr);
    }

    public static final void x(byte[] bArr, int i6, byte b6) {
        bArr[i6] = b6;
    }

    public static String y(byte[] bArr) {
        return "UByteArray(storage=" + Arrays.toString(bArr) + ')';
    }

    public boolean a(byte b6) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public /* bridge */ /* synthetic */ boolean add(v0 v0Var) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends v0> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof v0) {
            return g(((v0) obj).o0());
        }
        return false;
    }

    @Override // java.util.Collection
    public boolean containsAll(@NotNull Collection<?> elements) {
        kotlin.jvm.internal.g0.p(elements, "elements");
        return m(this.f48069a, elements);
    }

    @Override // java.util.Collection
    public boolean equals(Object obj) {
        return n(this.f48069a, obj);
    }

    public boolean g(byte b6) {
        return j(this.f48069a, b6);
    }

    @Override // java.util.Collection
    public int hashCode() {
        return u(this.f48069a);
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return v(this.f48069a);
    }

    @Override // java.util.Collection, java.lang.Iterable
    @NotNull
    public Iterator<v0> iterator() {
        return w(this.f48069a);
    }

    @Override // java.util.Collection
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public int size() {
        return r(this.f48069a);
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
        return y(this.f48069a);
    }

    public final /* synthetic */ byte[] z() {
        return this.f48069a;
    }

    @PublishedApi
    private /* synthetic */ w0(byte[] bArr) {
        this.f48069a = bArr;
    }

    public static boolean j(byte[] bArr, byte b6) {
        return kotlin.collections.n.v8(bArr, b6);
    }

    public static final boolean o(byte[] bArr, byte[] bArr2) {
        return kotlin.jvm.internal.g0.g(bArr, bArr2);
    }

    public static int u(byte[] bArr) {
        return Arrays.hashCode(bArr);
    }

    @PublishedApi
    public static /* synthetic */ void t() {
    }
}
