package androidx.collection;

import androidx.collection.internal.ContainerHelpersKt;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Map;
import kotlin.collections.n;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nSimpleArrayMap.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SimpleArrayMap.kt\nandroidx/collection/SimpleArrayMap\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,769:1\n297#1,5:770\n297#1,5:775\n1#2:780\n*S KotlinDebug\n*F\n+ 1 SimpleArrayMap.kt\nandroidx/collection/SimpleArrayMap\n*L\n276#1:770,5\n291#1:775,5\n*E\n"})
/* loaded from: D:\Downloads\app\classes.dex */
public class SimpleArrayMap<K, V> {

    @NotNull
    private Object[] array;

    @NotNull
    private int[] hashes;
    private int size;

    @JvmOverloads
    public SimpleArrayMap() {
        this(0, 1, null);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        try {
            if (obj instanceof SimpleArrayMap) {
                if (size() != ((SimpleArrayMap) obj).size()) {
                    return false;
                }
                SimpleArrayMap simpleArrayMap = (SimpleArrayMap) obj;
                int i6 = this.size;
                for (int i7 = 0; i7 < i6; i7++) {
                    K keyAt = keyAt(i7);
                    V valueAt = valueAt(i7);
                    Object obj2 = simpleArrayMap.get(keyAt);
                    if (valueAt == null) {
                        if (obj2 != null || !simpleArrayMap.containsKey(keyAt)) {
                            return false;
                        }
                    } else if (!g0.g(valueAt, obj2)) {
                        return false;
                    }
                }
                return true;
            }
            if (!(obj instanceof Map) || size() != ((Map) obj).size()) {
                return false;
            }
            int i8 = this.size;
            for (int i9 = 0; i9 < i8; i9++) {
                K keyAt2 = keyAt(i9);
                V valueAt2 = valueAt(i9);
                Object obj3 = ((Map) obj).get(keyAt2);
                if (valueAt2 == null) {
                    if (obj3 != null || !((Map) obj).containsKey(keyAt2)) {
                        return false;
                    }
                } else if (!g0.g(valueAt2, obj3)) {
                    return false;
                }
            }
            return true;
        } catch (ClassCastException | NullPointerException unused) {
        }
        return false;
    }

    @Nullable
    public V remove(K k6) {
        int indexOfKey = indexOfKey(k6);
        if (indexOfKey >= 0) {
            return removeAt(indexOfKey);
        }
        return null;
    }

    @Nullable
    public V replace(K k6, V v5) {
        int indexOfKey = indexOfKey(k6);
        if (indexOfKey >= 0) {
            return setValueAt(indexOfKey, v5);
        }
        return null;
    }

    @JvmOverloads
    public SimpleArrayMap(int i6) {
        this.hashes = i6 == 0 ? ContainerHelpersKt.EMPTY_INTS : new int[i6];
        this.array = i6 == 0 ? ContainerHelpersKt.EMPTY_OBJECTS : new Object[i6 << 1];
    }

    private final int indexOf(K k6, int i6) {
        int i7 = this.size;
        if (i7 == 0) {
            return -1;
        }
        int binarySearch = ContainerHelpersKt.binarySearch(this.hashes, i7, i6);
        if (binarySearch < 0 || g0.g(k6, this.array[binarySearch << 1])) {
            return binarySearch;
        }
        int i8 = binarySearch + 1;
        while (i8 < i7 && this.hashes[i8] == i6) {
            if (g0.g(k6, this.array[i8 << 1])) {
                return i8;
            }
            i8++;
        }
        for (int i9 = binarySearch - 1; i9 >= 0 && this.hashes[i9] == i6; i9--) {
            if (g0.g(k6, this.array[i9 << 1])) {
                return i9;
            }
        }
        return ~i8;
    }

    private final int indexOfNull() {
        int i6 = this.size;
        if (i6 == 0) {
            return -1;
        }
        int binarySearch = ContainerHelpersKt.binarySearch(this.hashes, i6, 0);
        if (binarySearch < 0 || this.array[binarySearch << 1] == null) {
            return binarySearch;
        }
        int i7 = binarySearch + 1;
        while (i7 < i6 && this.hashes[i7] == 0) {
            if (this.array[i7 << 1] == null) {
                return i7;
            }
            i7++;
        }
        for (int i8 = binarySearch - 1; i8 >= 0 && this.hashes[i8] == 0; i8--) {
            if (this.array[i8 << 1] == null) {
                return i8;
            }
        }
        return ~i7;
    }

    @JvmName(name = "__restricted$indexOfValue")
    public final int __restricted$indexOfValue(V v5) {
        int i6 = this.size * 2;
        Object[] objArr = this.array;
        if (v5 == null) {
            for (int i7 = 1; i7 < i6; i7 += 2) {
                if (objArr[i7] == null) {
                    return i7 >> 1;
                }
            }
            return -1;
        }
        for (int i8 = 1; i8 < i6; i8 += 2) {
            if (g0.g(v5, objArr[i8])) {
                return i8 >> 1;
            }
        }
        return -1;
    }

    public void clear() {
        if (this.size > 0) {
            this.hashes = ContainerHelpersKt.EMPTY_INTS;
            this.array = ContainerHelpersKt.EMPTY_OBJECTS;
            this.size = 0;
        }
        if (this.size > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public void ensureCapacity(int i6) {
        int i7 = this.size;
        int[] iArr = this.hashes;
        if (iArr.length < i6) {
            int[] copyOf = Arrays.copyOf(iArr, i6);
            g0.o(copyOf, "copyOf(this, newSize)");
            this.hashes = copyOf;
            Object[] copyOf2 = Arrays.copyOf(this.array, i6 * 2);
            g0.o(copyOf2, "copyOf(this, newSize)");
            this.array = copyOf2;
        }
        if (this.size != i7) {
            throw new ConcurrentModificationException();
        }
    }

    public int hashCode() {
        int[] iArr = this.hashes;
        Object[] objArr = this.array;
        int i6 = this.size;
        int i7 = 1;
        int i8 = 0;
        int i9 = 0;
        while (i8 < i6) {
            Object obj = objArr[i7];
            i9 += (obj != null ? obj.hashCode() : 0) ^ iArr[i8];
            i8++;
            i7 += 2;
        }
        return i9;
    }

    public int indexOfKey(K k6) {
        return k6 == null ? indexOfNull() : indexOf(k6, k6.hashCode());
    }

    public boolean isEmpty() {
        return this.size <= 0;
    }

    public K keyAt(int i6) {
        if (i6 >= 0 && i6 < this.size) {
            return (K) this.array[i6 << 1];
        }
        throw new IllegalArgumentException(("Expected index to be within 0..size()-1, but was " + i6).toString());
    }

    @Nullable
    public V put(K k6, V v5) {
        int i6 = this.size;
        int hashCode = k6 != null ? k6.hashCode() : 0;
        int indexOf = k6 != null ? indexOf(k6, hashCode) : indexOfNull();
        if (indexOf >= 0) {
            int i7 = (indexOf << 1) + 1;
            Object[] objArr = this.array;
            V v6 = (V) objArr[i7];
            objArr[i7] = v5;
            return v6;
        }
        int i8 = ~indexOf;
        int[] iArr = this.hashes;
        if (i6 >= iArr.length) {
            int i9 = 8;
            if (i6 >= 8) {
                i9 = (i6 >> 1) + i6;
            } else if (i6 < 4) {
                i9 = 4;
            }
            int[] copyOf = Arrays.copyOf(iArr, i9);
            g0.o(copyOf, "copyOf(this, newSize)");
            this.hashes = copyOf;
            Object[] copyOf2 = Arrays.copyOf(this.array, i9 << 1);
            g0.o(copyOf2, "copyOf(this, newSize)");
            this.array = copyOf2;
            if (i6 != this.size) {
                throw new ConcurrentModificationException();
            }
        }
        if (i8 < i6) {
            int[] iArr2 = this.hashes;
            int i10 = i8 + 1;
            n.z0(iArr2, iArr2, i10, i8, i6);
            Object[] objArr2 = this.array;
            n.B0(objArr2, objArr2, i10 << 1, i8 << 1, this.size << 1);
        }
        int i11 = this.size;
        if (i6 == i11) {
            int[] iArr3 = this.hashes;
            if (i8 < iArr3.length) {
                iArr3[i8] = hashCode;
                Object[] objArr3 = this.array;
                int i12 = i8 << 1;
                objArr3[i12] = k6;
                objArr3[i12 + 1] = v5;
                this.size = i11 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public void putAll(@NotNull SimpleArrayMap<? extends K, ? extends V> map) {
        g0.p(map, "map");
        int i6 = map.size;
        ensureCapacity(this.size + i6);
        if (this.size != 0) {
            for (int i7 = 0; i7 < i6; i7++) {
                put(map.keyAt(i7), map.valueAt(i7));
            }
        } else if (i6 > 0) {
            n.z0(map.hashes, this.hashes, 0, 0, i6);
            n.B0(map.array, this.array, 0, 0, i6 << 1);
            this.size = i6;
        }
    }

    public V removeAt(int i6) {
        int i7;
        if (i6 < 0 || i6 >= (i7 = this.size)) {
            throw new IllegalArgumentException(("Expected index to be within 0..size()-1, but was " + i6).toString());
        }
        Object[] objArr = this.array;
        int i8 = i6 << 1;
        V v5 = (V) objArr[i8 + 1];
        if (i7 <= 1) {
            clear();
            return v5;
        }
        int i9 = i7 - 1;
        int[] iArr = this.hashes;
        if (iArr.length <= 8 || i7 >= iArr.length / 3) {
            if (i6 < i9) {
                int i10 = i6 + 1;
                n.z0(iArr, iArr, i6, i10, i7);
                Object[] objArr2 = this.array;
                n.B0(objArr2, objArr2, i8, i10 << 1, i7 << 1);
            }
            Object[] objArr3 = this.array;
            int i11 = i9 << 1;
            objArr3[i11] = null;
            objArr3[i11 + 1] = null;
        } else {
            int i12 = i7 > 8 ? i7 + (i7 >> 1) : 8;
            int[] copyOf = Arrays.copyOf(iArr, i12);
            g0.o(copyOf, "copyOf(this, newSize)");
            this.hashes = copyOf;
            Object[] copyOf2 = Arrays.copyOf(this.array, i12 << 1);
            g0.o(copyOf2, "copyOf(this, newSize)");
            this.array = copyOf2;
            if (i7 != this.size) {
                throw new ConcurrentModificationException();
            }
            if (i6 > 0) {
                n.z0(iArr, this.hashes, 0, 0, i6);
                n.B0(objArr, this.array, 0, 0, i8);
            }
            if (i6 < i9) {
                int i13 = i6 + 1;
                n.z0(iArr, this.hashes, i6, i13, i7);
                n.B0(objArr, this.array, i8, i13 << 1, i7 << 1);
            }
        }
        if (i7 != this.size) {
            throw new ConcurrentModificationException();
        }
        this.size = i9;
        return v5;
    }

    public V setValueAt(int i6, V v5) {
        if (i6 < 0 || i6 >= this.size) {
            throw new IllegalArgumentException(("Expected index to be within 0..size()-1, but was " + i6).toString());
        }
        int i7 = (i6 << 1) + 1;
        Object[] objArr = this.array;
        V v6 = (V) objArr[i7];
        objArr[i7] = v5;
        return v6;
    }

    public int size() {
        return this.size;
    }

    public V valueAt(int i6) {
        if (i6 >= 0 && i6 < this.size) {
            return (V) this.array[(i6 << 1) + 1];
        }
        throw new IllegalArgumentException(("Expected index to be within 0..size()-1, but was " + i6).toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final <T extends V> T getOrDefaultInternal(Object obj, T t5) {
        int indexOfKey = indexOfKey(obj);
        if (indexOfKey >= 0) {
            return (T) this.array[(indexOfKey << 1) + 1];
        }
        return t5;
    }

    public boolean containsKey(K k6) {
        if (indexOfKey(k6) >= 0) {
            return true;
        }
        return false;
    }

    public boolean containsValue(V v5) {
        if (__restricted$indexOfValue(v5) >= 0) {
            return true;
        }
        return false;
    }

    @Nullable
    public V get(K k6) {
        int indexOfKey = indexOfKey(k6);
        if (indexOfKey >= 0) {
            return (V) this.array[(indexOfKey << 1) + 1];
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public V getOrDefault(@Nullable Object obj, V v5) {
        int indexOfKey = indexOfKey(obj);
        if (indexOfKey >= 0) {
            return (V) this.array[(indexOfKey << 1) + 1];
        }
        return v5;
    }

    @Nullable
    public V putIfAbsent(K k6, V v5) {
        V v6 = get(k6);
        if (v6 == null) {
            return put(k6, v5);
        }
        return v6;
    }

    public boolean remove(K k6, V v5) {
        int indexOfKey = indexOfKey(k6);
        if (indexOfKey < 0 || !g0.g(v5, valueAt(indexOfKey))) {
            return false;
        }
        removeAt(indexOfKey);
        return true;
    }

    public boolean replace(K k6, V v5, V v6) {
        int indexOfKey = indexOfKey(k6);
        if (indexOfKey < 0 || !g0.g(v5, valueAt(indexOfKey))) {
            return false;
        }
        setValueAt(indexOfKey, v6);
        return true;
    }

    @NotNull
    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.size * 28);
        sb.append('{');
        int i6 = this.size;
        for (int i7 = 0; i7 < i6; i7++) {
            if (i7 > 0) {
                sb.append(", ");
            }
            K keyAt = keyAt(i7);
            if (keyAt != sb) {
                sb.append(keyAt);
            } else {
                sb.append("(this Map)");
            }
            sb.append('=');
            V valueAt = valueAt(i7);
            if (valueAt != sb) {
                sb.append(valueAt);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        String sb2 = sb.toString();
        g0.o(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    public /* synthetic */ SimpleArrayMap(int i6, int i7, v vVar) {
        this((i7 & 1) != 0 ? 0 : i6);
    }

    public SimpleArrayMap(@Nullable SimpleArrayMap<? extends K, ? extends V> simpleArrayMap) {
        this(0, 1, null);
        if (simpleArrayMap != null) {
            putAll(simpleArrayMap);
        }
    }
}
