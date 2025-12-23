package androidx.collection;

import androidx.collection.internal.ContainerHelpersKt;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.collections.e1;
import kotlin.collections.n;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nLongSparseArray.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LongSparseArray.kt\nandroidx/collection/LongSparseArrayKt\n*L\n1#1,606:1\n256#1,6:607\n256#1,6:613\n328#1,18:619\n328#1,18:637\n328#1,18:655\n328#1,18:673\n328#1,18:691\n328#1,18:709\n328#1,18:727\n328#1,18:745\n*S KotlinDebug\n*F\n+ 1 LongSparseArray.kt\nandroidx/collection/LongSparseArrayKt\n*L\n243#1:607,6\n248#1:613,6\n360#1:619,18\n410#1:637,18\n425#1:655,18\n437#1:673,18\n451#1:691,18\n459#1:709,18\n467#1:727,18\n505#1:745,18\n*E\n"})
/* loaded from: D:\Downloads\app\classes.dex */
public final class LongSparseArrayKt {

    @NotNull
    private static final Object DELETED = new Object();

    @Nullable
    public static final <E> E commonGet(@NotNull LongSparseArray<E> longSparseArray, long j6) {
        g0.p(longSparseArray, "<this>");
        int binarySearch = ContainerHelpersKt.binarySearch(longSparseArray.keys, longSparseArray.size, j6);
        if (binarySearch < 0 || longSparseArray.values[binarySearch] == DELETED) {
            return null;
        }
        return (E) longSparseArray.values[binarySearch];
    }

    public static final <E> void commonRemove(@NotNull LongSparseArray<E> longSparseArray, long j6) {
        g0.p(longSparseArray, "<this>");
        int binarySearch = ContainerHelpersKt.binarySearch(longSparseArray.keys, longSparseArray.size, j6);
        if (binarySearch < 0 || longSparseArray.values[binarySearch] == DELETED) {
            return;
        }
        longSparseArray.values[binarySearch] = DELETED;
        longSparseArray.garbage = true;
    }

    @Nullable
    public static final <E> E commonReplace(@NotNull LongSparseArray<E> longSparseArray, long j6, E e6) {
        g0.p(longSparseArray, "<this>");
        int indexOfKey = longSparseArray.indexOfKey(j6);
        if (indexOfKey < 0) {
            return null;
        }
        Object[] objArr = longSparseArray.values;
        E e7 = (E) objArr[indexOfKey];
        objArr[indexOfKey] = e6;
        return e7;
    }

    public static final <E> void commonAppend(@NotNull LongSparseArray<E> longSparseArray, long j6, E e6) {
        g0.p(longSparseArray, "<this>");
        int i6 = longSparseArray.size;
        if (i6 != 0 && j6 <= longSparseArray.keys[i6 - 1]) {
            longSparseArray.put(j6, e6);
            return;
        }
        if (longSparseArray.garbage) {
            long[] jArr = longSparseArray.keys;
            if (i6 >= jArr.length) {
                Object[] objArr = longSparseArray.values;
                int i7 = 0;
                for (int i8 = 0; i8 < i6; i8++) {
                    Object obj = objArr[i8];
                    if (obj != DELETED) {
                        if (i8 != i7) {
                            jArr[i7] = jArr[i8];
                            objArr[i7] = obj;
                            objArr[i8] = null;
                        }
                        i7++;
                    }
                }
                longSparseArray.garbage = false;
                longSparseArray.size = i7;
            }
        }
        int i9 = longSparseArray.size;
        if (i9 >= longSparseArray.keys.length) {
            int idealLongArraySize = ContainerHelpersKt.idealLongArraySize(i9 + 1);
            long[] copyOf = Arrays.copyOf(longSparseArray.keys, idealLongArraySize);
            g0.o(copyOf, "copyOf(this, newSize)");
            longSparseArray.keys = copyOf;
            Object[] copyOf2 = Arrays.copyOf(longSparseArray.values, idealLongArraySize);
            g0.o(copyOf2, "copyOf(this, newSize)");
            longSparseArray.values = copyOf2;
        }
        longSparseArray.keys[i9] = j6;
        longSparseArray.values[i9] = e6;
        longSparseArray.size = i9 + 1;
    }

    public static final <E> void commonClear(@NotNull LongSparseArray<E> longSparseArray) {
        g0.p(longSparseArray, "<this>");
        int i6 = longSparseArray.size;
        Object[] objArr = longSparseArray.values;
        for (int i7 = 0; i7 < i6; i7++) {
            objArr[i7] = null;
        }
        longSparseArray.size = 0;
        longSparseArray.garbage = false;
    }

    public static final <E> boolean commonContainsKey(@NotNull LongSparseArray<E> longSparseArray, long j6) {
        g0.p(longSparseArray, "<this>");
        return longSparseArray.indexOfKey(j6) >= 0;
    }

    public static final <E> boolean commonContainsValue(@NotNull LongSparseArray<E> longSparseArray, E e6) {
        g0.p(longSparseArray, "<this>");
        return longSparseArray.indexOfValue(e6) >= 0;
    }

    public static final <E> void commonGc(@NotNull LongSparseArray<E> longSparseArray) {
        g0.p(longSparseArray, "<this>");
        int i6 = longSparseArray.size;
        long[] jArr = longSparseArray.keys;
        Object[] objArr = longSparseArray.values;
        int i7 = 0;
        for (int i8 = 0; i8 < i6; i8++) {
            Object obj = objArr[i8];
            if (obj != DELETED) {
                if (i8 != i7) {
                    jArr[i7] = jArr[i8];
                    objArr[i7] = obj;
                    objArr[i8] = null;
                }
                i7++;
            }
        }
        longSparseArray.garbage = false;
        longSparseArray.size = i7;
    }

    public static final <T extends E, E> T commonGetInternal(@NotNull LongSparseArray<E> longSparseArray, long j6, T t5) {
        g0.p(longSparseArray, "<this>");
        int binarySearch = ContainerHelpersKt.binarySearch(longSparseArray.keys, longSparseArray.size, j6);
        return (binarySearch < 0 || longSparseArray.values[binarySearch] == DELETED) ? t5 : (T) longSparseArray.values[binarySearch];
    }

    public static final <E> int commonIndexOfKey(@NotNull LongSparseArray<E> longSparseArray, long j6) {
        g0.p(longSparseArray, "<this>");
        if (longSparseArray.garbage) {
            int i6 = longSparseArray.size;
            long[] jArr = longSparseArray.keys;
            Object[] objArr = longSparseArray.values;
            int i7 = 0;
            for (int i8 = 0; i8 < i6; i8++) {
                Object obj = objArr[i8];
                if (obj != DELETED) {
                    if (i8 != i7) {
                        jArr[i7] = jArr[i8];
                        objArr[i7] = obj;
                        objArr[i8] = null;
                    }
                    i7++;
                }
            }
            longSparseArray.garbage = false;
            longSparseArray.size = i7;
        }
        return ContainerHelpersKt.binarySearch(longSparseArray.keys, longSparseArray.size, j6);
    }

    public static final <E> int commonIndexOfValue(@NotNull LongSparseArray<E> longSparseArray, E e6) {
        g0.p(longSparseArray, "<this>");
        if (longSparseArray.garbage) {
            int i6 = longSparseArray.size;
            long[] jArr = longSparseArray.keys;
            Object[] objArr = longSparseArray.values;
            int i7 = 0;
            for (int i8 = 0; i8 < i6; i8++) {
                Object obj = objArr[i8];
                if (obj != DELETED) {
                    if (i8 != i7) {
                        jArr[i7] = jArr[i8];
                        objArr[i7] = obj;
                        objArr[i8] = null;
                    }
                    i7++;
                }
            }
            longSparseArray.garbage = false;
            longSparseArray.size = i7;
        }
        int i9 = longSparseArray.size;
        for (int i10 = 0; i10 < i9; i10++) {
            if (longSparseArray.values[i10] == e6) {
                return i10;
            }
        }
        return -1;
    }

    public static final <E> boolean commonIsEmpty(@NotNull LongSparseArray<E> longSparseArray) {
        g0.p(longSparseArray, "<this>");
        return longSparseArray.size() == 0;
    }

    public static final <E> long commonKeyAt(@NotNull LongSparseArray<E> longSparseArray, int i6) {
        int i7;
        g0.p(longSparseArray, "<this>");
        if (i6 < 0 || i6 >= (i7 = longSparseArray.size)) {
            throw new IllegalArgumentException(("Expected index to be within 0..size()-1, but was " + i6).toString());
        }
        if (longSparseArray.garbage) {
            long[] jArr = longSparseArray.keys;
            Object[] objArr = longSparseArray.values;
            int i8 = 0;
            for (int i9 = 0; i9 < i7; i9++) {
                Object obj = objArr[i9];
                if (obj != DELETED) {
                    if (i9 != i8) {
                        jArr[i8] = jArr[i9];
                        objArr[i8] = obj;
                        objArr[i9] = null;
                    }
                    i8++;
                }
            }
            longSparseArray.garbage = false;
            longSparseArray.size = i8;
        }
        return longSparseArray.keys[i6];
    }

    public static final <E> void commonPut(@NotNull LongSparseArray<E> longSparseArray, long j6, E e6) {
        g0.p(longSparseArray, "<this>");
        int binarySearch = ContainerHelpersKt.binarySearch(longSparseArray.keys, longSparseArray.size, j6);
        if (binarySearch >= 0) {
            longSparseArray.values[binarySearch] = e6;
            return;
        }
        int i6 = ~binarySearch;
        if (i6 < longSparseArray.size && longSparseArray.values[i6] == DELETED) {
            longSparseArray.keys[i6] = j6;
            longSparseArray.values[i6] = e6;
            return;
        }
        if (longSparseArray.garbage) {
            int i7 = longSparseArray.size;
            long[] jArr = longSparseArray.keys;
            if (i7 >= jArr.length) {
                Object[] objArr = longSparseArray.values;
                int i8 = 0;
                for (int i9 = 0; i9 < i7; i9++) {
                    Object obj = objArr[i9];
                    if (obj != DELETED) {
                        if (i9 != i8) {
                            jArr[i8] = jArr[i9];
                            objArr[i8] = obj;
                            objArr[i9] = null;
                        }
                        i8++;
                    }
                }
                longSparseArray.garbage = false;
                longSparseArray.size = i8;
                i6 = ~ContainerHelpersKt.binarySearch(longSparseArray.keys, i8, j6);
            }
        }
        int i10 = longSparseArray.size;
        if (i10 >= longSparseArray.keys.length) {
            int idealLongArraySize = ContainerHelpersKt.idealLongArraySize(i10 + 1);
            long[] copyOf = Arrays.copyOf(longSparseArray.keys, idealLongArraySize);
            g0.o(copyOf, "copyOf(this, newSize)");
            longSparseArray.keys = copyOf;
            Object[] copyOf2 = Arrays.copyOf(longSparseArray.values, idealLongArraySize);
            g0.o(copyOf2, "copyOf(this, newSize)");
            longSparseArray.values = copyOf2;
        }
        int i11 = longSparseArray.size;
        if (i11 - i6 != 0) {
            long[] jArr2 = longSparseArray.keys;
            int i12 = i6 + 1;
            n.A0(jArr2, jArr2, i12, i6, i11);
            Object[] objArr2 = longSparseArray.values;
            n.B0(objArr2, objArr2, i12, i6, longSparseArray.size);
        }
        longSparseArray.keys[i6] = j6;
        longSparseArray.values[i6] = e6;
        longSparseArray.size++;
    }

    public static final <E> void commonPutAll(@NotNull LongSparseArray<E> longSparseArray, @NotNull LongSparseArray<? extends E> other) {
        g0.p(longSparseArray, "<this>");
        g0.p(other, "other");
        int size = other.size();
        for (int i6 = 0; i6 < size; i6++) {
            longSparseArray.put(other.keyAt(i6), other.valueAt(i6));
        }
    }

    @Nullable
    public static final <E> E commonPutIfAbsent(@NotNull LongSparseArray<E> longSparseArray, long j6, E e6) {
        g0.p(longSparseArray, "<this>");
        E e7 = longSparseArray.get(j6);
        if (e7 == null) {
            longSparseArray.put(j6, e6);
        }
        return e7;
    }

    public static final <E> void commonRemoveAt(@NotNull LongSparseArray<E> longSparseArray, int i6) {
        g0.p(longSparseArray, "<this>");
        if (longSparseArray.values[i6] != DELETED) {
            longSparseArray.values[i6] = DELETED;
            longSparseArray.garbage = true;
        }
    }

    public static final <E> void commonSetValueAt(@NotNull LongSparseArray<E> longSparseArray, int i6, E e6) {
        int i7;
        g0.p(longSparseArray, "<this>");
        if (i6 < 0 || i6 >= (i7 = longSparseArray.size)) {
            throw new IllegalArgumentException(("Expected index to be within 0..size()-1, but was " + i6).toString());
        }
        if (longSparseArray.garbage) {
            long[] jArr = longSparseArray.keys;
            Object[] objArr = longSparseArray.values;
            int i8 = 0;
            for (int i9 = 0; i9 < i7; i9++) {
                Object obj = objArr[i9];
                if (obj != DELETED) {
                    if (i9 != i8) {
                        jArr[i8] = jArr[i9];
                        objArr[i8] = obj;
                        objArr[i9] = null;
                    }
                    i8++;
                }
            }
            longSparseArray.garbage = false;
            longSparseArray.size = i8;
        }
        longSparseArray.values[i6] = e6;
    }

    public static final <E> int commonSize(@NotNull LongSparseArray<E> longSparseArray) {
        g0.p(longSparseArray, "<this>");
        if (longSparseArray.garbage) {
            int i6 = longSparseArray.size;
            long[] jArr = longSparseArray.keys;
            Object[] objArr = longSparseArray.values;
            int i7 = 0;
            for (int i8 = 0; i8 < i6; i8++) {
                Object obj = objArr[i8];
                if (obj != DELETED) {
                    if (i8 != i7) {
                        jArr[i7] = jArr[i8];
                        objArr[i7] = obj;
                        objArr[i8] = null;
                    }
                    i7++;
                }
            }
            longSparseArray.garbage = false;
            longSparseArray.size = i7;
        }
        return longSparseArray.size;
    }

    @NotNull
    public static final <E> String commonToString(@NotNull LongSparseArray<E> longSparseArray) {
        g0.p(longSparseArray, "<this>");
        if (longSparseArray.size() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(longSparseArray.size * 28);
        sb.append('{');
        int i6 = longSparseArray.size;
        for (int i7 = 0; i7 < i6; i7++) {
            if (i7 > 0) {
                sb.append(", ");
            }
            sb.append(longSparseArray.keyAt(i7));
            sb.append('=');
            E valueAt = longSparseArray.valueAt(i7);
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

    public static final <E> E commonValueAt(@NotNull LongSparseArray<E> longSparseArray, int i6) {
        int i7;
        g0.p(longSparseArray, "<this>");
        if (i6 < 0 || i6 >= (i7 = longSparseArray.size)) {
            throw new IllegalArgumentException(("Expected index to be within 0..size()-1, but was " + i6).toString());
        }
        if (longSparseArray.garbage) {
            long[] jArr = longSparseArray.keys;
            Object[] objArr = longSparseArray.values;
            int i8 = 0;
            for (int i9 = 0; i9 < i7; i9++) {
                Object obj = objArr[i9];
                if (obj != DELETED) {
                    if (i9 != i8) {
                        jArr[i8] = jArr[i9];
                        objArr[i8] = obj;
                        objArr[i9] = null;
                    }
                    i8++;
                }
            }
            longSparseArray.garbage = false;
            longSparseArray.size = i8;
        }
        return (E) longSparseArray.values[i6];
    }

    public static final <T> boolean contains(@NotNull LongSparseArray<T> longSparseArray, long j6) {
        g0.p(longSparseArray, "<this>");
        return longSparseArray.containsKey(j6);
    }

    public static final <T> void forEach(@NotNull LongSparseArray<T> longSparseArray, @NotNull Function2<? super Long, ? super T, n1> action) {
        g0.p(longSparseArray, "<this>");
        g0.p(action, "action");
        int size = longSparseArray.size();
        for (int i6 = 0; i6 < size; i6++) {
            action.invoke(Long.valueOf(longSparseArray.keyAt(i6)), longSparseArray.valueAt(i6));
        }
    }

    public static final <T> T getOrDefault(@NotNull LongSparseArray<T> longSparseArray, long j6, T t5) {
        g0.p(longSparseArray, "<this>");
        return longSparseArray.get(j6, t5);
    }

    public static final <T> T getOrElse(@NotNull LongSparseArray<T> longSparseArray, long j6, @NotNull Function0<? extends T> defaultValue) {
        g0.p(longSparseArray, "<this>");
        g0.p(defaultValue, "defaultValue");
        T t5 = longSparseArray.get(j6);
        return t5 == null ? defaultValue.invoke() : t5;
    }

    public static final <T> int getSize(@NotNull LongSparseArray<T> longSparseArray) {
        g0.p(longSparseArray, "<this>");
        return longSparseArray.size();
    }

    public static final <T> boolean isNotEmpty(@NotNull LongSparseArray<T> longSparseArray) {
        g0.p(longSparseArray, "<this>");
        return !longSparseArray.isEmpty();
    }

    @NotNull
    public static final <T> e1 keyIterator(@NotNull final LongSparseArray<T> longSparseArray) {
        g0.p(longSparseArray, "<this>");
        return new e1() { // from class: androidx.collection.LongSparseArrayKt$keyIterator$1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < longSparseArray.size();
            }

            @Override // kotlin.collections.e1
            public long nextLong() {
                LongSparseArray<T> longSparseArray2 = longSparseArray;
                int i6 = this.index;
                this.index = i6 + 1;
                return longSparseArray2.keyAt(i6);
            }

            public final void setIndex(int i6) {
                this.index = i6;
            }
        };
    }

    @NotNull
    public static final <T> LongSparseArray<T> plus(@NotNull LongSparseArray<T> longSparseArray, @NotNull LongSparseArray<T> other) {
        g0.p(longSparseArray, "<this>");
        g0.p(other, "other");
        LongSparseArray<T> longSparseArray2 = new LongSparseArray<>(longSparseArray.size() + other.size());
        longSparseArray2.putAll(longSparseArray);
        longSparseArray2.putAll(other);
        return longSparseArray2;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Replaced with member function. Remove extension import!")
    public static final /* synthetic */ boolean remove(LongSparseArray longSparseArray, long j6, Object obj) {
        g0.p(longSparseArray, "<this>");
        return longSparseArray.remove(j6, obj);
    }

    public static final <T> void set(@NotNull LongSparseArray<T> longSparseArray, long j6, T t5) {
        g0.p(longSparseArray, "<this>");
        longSparseArray.put(j6, t5);
    }

    @NotNull
    public static final <T> Iterator<T> valueIterator(@NotNull LongSparseArray<T> longSparseArray) {
        g0.p(longSparseArray, "<this>");
        return new LongSparseArrayKt$valueIterator$1(longSparseArray);
    }

    public static final <E> E commonGet(@NotNull LongSparseArray<E> longSparseArray, long j6, E e6) {
        g0.p(longSparseArray, "<this>");
        int binarySearch = ContainerHelpersKt.binarySearch(longSparseArray.keys, longSparseArray.size, j6);
        return (binarySearch < 0 || longSparseArray.values[binarySearch] == DELETED) ? e6 : (E) longSparseArray.values[binarySearch];
    }

    public static final <E> boolean commonReplace(@NotNull LongSparseArray<E> longSparseArray, long j6, E e6, E e7) {
        g0.p(longSparseArray, "<this>");
        int indexOfKey = longSparseArray.indexOfKey(j6);
        if (indexOfKey < 0 || !g0.g(longSparseArray.values[indexOfKey], e6)) {
            return false;
        }
        longSparseArray.values[indexOfKey] = e7;
        return true;
    }

    public static final <E> boolean commonRemove(@NotNull LongSparseArray<E> longSparseArray, long j6, E e6) {
        g0.p(longSparseArray, "<this>");
        int indexOfKey = longSparseArray.indexOfKey(j6);
        if (indexOfKey < 0 || !g0.g(e6, longSparseArray.valueAt(indexOfKey))) {
            return false;
        }
        longSparseArray.removeAt(indexOfKey);
        return true;
    }

    public static /* synthetic */ void getSize$annotations(LongSparseArray longSparseArray) {
    }
}
