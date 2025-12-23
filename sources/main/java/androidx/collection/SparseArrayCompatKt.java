package androidx.collection;

import androidx.collection.internal.ContainerHelpersKt;
import java.util.Arrays;
import kotlin.collections.n;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nSparseArrayCompat.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SparseArrayCompat.kt\nandroidx/collection/SparseArrayCompatKt\n*L\n1#1,535:1\n244#1,6:536\n244#1,6:542\n353#1,40:548\n353#1,40:588\n459#1,9:628\n*S KotlinDebug\n*F\n+ 1 SparseArrayCompat.kt\nandroidx/collection/SparseArrayCompatKt\n*L\n255#1:536,6\n260#1:542,6\n397#1:548,40\n405#1:588,40\n477#1:628,9\n*E\n"})
/* loaded from: D:\Downloads\app\classes.dex */
public final class SparseArrayCompatKt {

    @NotNull
    private static final Object DELETED = new Object();

    @Nullable
    public static final <E> E commonGet(@NotNull SparseArrayCompat<E> sparseArrayCompat, int i6) {
        E e6;
        g0.p(sparseArrayCompat, "<this>");
        int binarySearch = ContainerHelpersKt.binarySearch(sparseArrayCompat.keys, sparseArrayCompat.size, i6);
        if (binarySearch < 0 || (e6 = (E) sparseArrayCompat.values[binarySearch]) == DELETED) {
            return null;
        }
        return e6;
    }

    public static final <E> void commonRemove(@NotNull SparseArrayCompat<E> sparseArrayCompat, int i6) {
        g0.p(sparseArrayCompat, "<this>");
        int binarySearch = ContainerHelpersKt.binarySearch(sparseArrayCompat.keys, sparseArrayCompat.size, i6);
        if (binarySearch >= 0) {
            Object[] objArr = sparseArrayCompat.values;
            Object obj = objArr[binarySearch];
            Object obj2 = DELETED;
            if (obj != obj2) {
                objArr[binarySearch] = obj2;
                sparseArrayCompat.garbage = true;
            }
        }
    }

    @Nullable
    public static final <E> E commonReplace(@NotNull SparseArrayCompat<E> sparseArrayCompat, int i6, E e6) {
        g0.p(sparseArrayCompat, "<this>");
        int indexOfKey = sparseArrayCompat.indexOfKey(i6);
        if (indexOfKey < 0) {
            return null;
        }
        Object[] objArr = sparseArrayCompat.values;
        E e7 = (E) objArr[indexOfKey];
        objArr[indexOfKey] = e6;
        return e7;
    }

    public static final <E> void commonAppend(@NotNull SparseArrayCompat<E> sparseArrayCompat, int i6, E e6) {
        g0.p(sparseArrayCompat, "<this>");
        int i7 = sparseArrayCompat.size;
        if (i7 != 0 && i6 <= sparseArrayCompat.keys[i7 - 1]) {
            sparseArrayCompat.put(i6, e6);
            return;
        }
        if (sparseArrayCompat.garbage && i7 >= sparseArrayCompat.keys.length) {
            gc(sparseArrayCompat);
        }
        int i8 = sparseArrayCompat.size;
        if (i8 >= sparseArrayCompat.keys.length) {
            int idealIntArraySize = ContainerHelpersKt.idealIntArraySize(i8 + 1);
            int[] copyOf = Arrays.copyOf(sparseArrayCompat.keys, idealIntArraySize);
            g0.o(copyOf, "copyOf(this, newSize)");
            sparseArrayCompat.keys = copyOf;
            Object[] copyOf2 = Arrays.copyOf(sparseArrayCompat.values, idealIntArraySize);
            g0.o(copyOf2, "copyOf(this, newSize)");
            sparseArrayCompat.values = copyOf2;
        }
        sparseArrayCompat.keys[i8] = i6;
        sparseArrayCompat.values[i8] = e6;
        sparseArrayCompat.size = i8 + 1;
    }

    public static final <E> void commonClear(@NotNull SparseArrayCompat<E> sparseArrayCompat) {
        g0.p(sparseArrayCompat, "<this>");
        int i6 = sparseArrayCompat.size;
        Object[] objArr = sparseArrayCompat.values;
        for (int i7 = 0; i7 < i6; i7++) {
            objArr[i7] = null;
        }
        sparseArrayCompat.size = 0;
        sparseArrayCompat.garbage = false;
    }

    public static final <E> boolean commonContainsKey(@NotNull SparseArrayCompat<E> sparseArrayCompat, int i6) {
        g0.p(sparseArrayCompat, "<this>");
        return sparseArrayCompat.indexOfKey(i6) >= 0;
    }

    public static final <E> boolean commonContainsValue(@NotNull SparseArrayCompat<E> sparseArrayCompat, E e6) {
        g0.p(sparseArrayCompat, "<this>");
        if (sparseArrayCompat.garbage) {
            gc(sparseArrayCompat);
        }
        int i6 = sparseArrayCompat.size;
        int i7 = 0;
        while (true) {
            if (i7 >= i6) {
                i7 = -1;
                break;
            }
            if (sparseArrayCompat.values[i7] == e6) {
                break;
            }
            i7++;
        }
        return i7 >= 0;
    }

    public static final <E> int commonIndexOfKey(@NotNull SparseArrayCompat<E> sparseArrayCompat, int i6) {
        g0.p(sparseArrayCompat, "<this>");
        if (sparseArrayCompat.garbage) {
            gc(sparseArrayCompat);
        }
        return ContainerHelpersKt.binarySearch(sparseArrayCompat.keys, sparseArrayCompat.size, i6);
    }

    public static final <E> int commonIndexOfValue(@NotNull SparseArrayCompat<E> sparseArrayCompat, E e6) {
        g0.p(sparseArrayCompat, "<this>");
        if (sparseArrayCompat.garbage) {
            gc(sparseArrayCompat);
        }
        int i6 = sparseArrayCompat.size;
        for (int i7 = 0; i7 < i6; i7++) {
            if (sparseArrayCompat.values[i7] == e6) {
                return i7;
            }
        }
        return -1;
    }

    public static final <E> boolean commonIsEmpty(@NotNull SparseArrayCompat<E> sparseArrayCompat) {
        g0.p(sparseArrayCompat, "<this>");
        return sparseArrayCompat.size() == 0;
    }

    public static final <E> int commonKeyAt(@NotNull SparseArrayCompat<E> sparseArrayCompat, int i6) {
        g0.p(sparseArrayCompat, "<this>");
        if (sparseArrayCompat.garbage) {
            gc(sparseArrayCompat);
        }
        return sparseArrayCompat.keys[i6];
    }

    public static final <E> void commonPut(@NotNull SparseArrayCompat<E> sparseArrayCompat, int i6, E e6) {
        g0.p(sparseArrayCompat, "<this>");
        int binarySearch = ContainerHelpersKt.binarySearch(sparseArrayCompat.keys, sparseArrayCompat.size, i6);
        if (binarySearch >= 0) {
            sparseArrayCompat.values[binarySearch] = e6;
            return;
        }
        int i7 = ~binarySearch;
        if (i7 < sparseArrayCompat.size && sparseArrayCompat.values[i7] == DELETED) {
            sparseArrayCompat.keys[i7] = i6;
            sparseArrayCompat.values[i7] = e6;
            return;
        }
        if (sparseArrayCompat.garbage && sparseArrayCompat.size >= sparseArrayCompat.keys.length) {
            gc(sparseArrayCompat);
            i7 = ~ContainerHelpersKt.binarySearch(sparseArrayCompat.keys, sparseArrayCompat.size, i6);
        }
        int i8 = sparseArrayCompat.size;
        if (i8 >= sparseArrayCompat.keys.length) {
            int idealIntArraySize = ContainerHelpersKt.idealIntArraySize(i8 + 1);
            int[] copyOf = Arrays.copyOf(sparseArrayCompat.keys, idealIntArraySize);
            g0.o(copyOf, "copyOf(this, newSize)");
            sparseArrayCompat.keys = copyOf;
            Object[] copyOf2 = Arrays.copyOf(sparseArrayCompat.values, idealIntArraySize);
            g0.o(copyOf2, "copyOf(this, newSize)");
            sparseArrayCompat.values = copyOf2;
        }
        int i9 = sparseArrayCompat.size;
        if (i9 - i7 != 0) {
            int[] iArr = sparseArrayCompat.keys;
            int i10 = i7 + 1;
            n.z0(iArr, iArr, i10, i7, i9);
            Object[] objArr = sparseArrayCompat.values;
            n.B0(objArr, objArr, i10, i7, sparseArrayCompat.size);
        }
        sparseArrayCompat.keys[i7] = i6;
        sparseArrayCompat.values[i7] = e6;
        sparseArrayCompat.size++;
    }

    public static final <E> void commonPutAll(@NotNull SparseArrayCompat<E> sparseArrayCompat, @NotNull SparseArrayCompat<? extends E> other) {
        g0.p(sparseArrayCompat, "<this>");
        g0.p(other, "other");
        int size = other.size();
        for (int i6 = 0; i6 < size; i6++) {
            int keyAt = other.keyAt(i6);
            E valueAt = other.valueAt(i6);
            int binarySearch = ContainerHelpersKt.binarySearch(sparseArrayCompat.keys, sparseArrayCompat.size, keyAt);
            if (binarySearch >= 0) {
                sparseArrayCompat.values[binarySearch] = valueAt;
            } else {
                int i7 = ~binarySearch;
                if (i7 >= sparseArrayCompat.size || sparseArrayCompat.values[i7] != DELETED) {
                    if (sparseArrayCompat.garbage && sparseArrayCompat.size >= sparseArrayCompat.keys.length) {
                        gc(sparseArrayCompat);
                        i7 = ~ContainerHelpersKt.binarySearch(sparseArrayCompat.keys, sparseArrayCompat.size, keyAt);
                    }
                    int i8 = sparseArrayCompat.size;
                    if (i8 >= sparseArrayCompat.keys.length) {
                        int idealIntArraySize = ContainerHelpersKt.idealIntArraySize(i8 + 1);
                        int[] copyOf = Arrays.copyOf(sparseArrayCompat.keys, idealIntArraySize);
                        g0.o(copyOf, "copyOf(this, newSize)");
                        sparseArrayCompat.keys = copyOf;
                        Object[] copyOf2 = Arrays.copyOf(sparseArrayCompat.values, idealIntArraySize);
                        g0.o(copyOf2, "copyOf(this, newSize)");
                        sparseArrayCompat.values = copyOf2;
                    }
                    int i9 = sparseArrayCompat.size;
                    if (i9 - i7 != 0) {
                        int[] iArr = sparseArrayCompat.keys;
                        int i10 = i7 + 1;
                        n.z0(iArr, iArr, i10, i7, i9);
                        Object[] objArr = sparseArrayCompat.values;
                        n.B0(objArr, objArr, i10, i7, sparseArrayCompat.size);
                    }
                    sparseArrayCompat.keys[i7] = keyAt;
                    sparseArrayCompat.values[i7] = valueAt;
                    sparseArrayCompat.size++;
                } else {
                    sparseArrayCompat.keys[i7] = keyAt;
                    sparseArrayCompat.values[i7] = valueAt;
                }
            }
        }
    }

    @Nullable
    public static final <E> E commonPutIfAbsent(@NotNull SparseArrayCompat<E> sparseArrayCompat, int i6, E e6) {
        g0.p(sparseArrayCompat, "<this>");
        E e7 = (E) commonGet(sparseArrayCompat, i6);
        if (e7 == null) {
            int binarySearch = ContainerHelpersKt.binarySearch(sparseArrayCompat.keys, sparseArrayCompat.size, i6);
            if (binarySearch >= 0) {
                sparseArrayCompat.values[binarySearch] = e6;
                return e7;
            }
            int i7 = ~binarySearch;
            if (i7 < sparseArrayCompat.size && sparseArrayCompat.values[i7] == DELETED) {
                sparseArrayCompat.keys[i7] = i6;
                sparseArrayCompat.values[i7] = e6;
                return e7;
            }
            if (sparseArrayCompat.garbage && sparseArrayCompat.size >= sparseArrayCompat.keys.length) {
                gc(sparseArrayCompat);
                i7 = ~ContainerHelpersKt.binarySearch(sparseArrayCompat.keys, sparseArrayCompat.size, i6);
            }
            int i8 = sparseArrayCompat.size;
            if (i8 >= sparseArrayCompat.keys.length) {
                int idealIntArraySize = ContainerHelpersKt.idealIntArraySize(i8 + 1);
                int[] copyOf = Arrays.copyOf(sparseArrayCompat.keys, idealIntArraySize);
                g0.o(copyOf, "copyOf(this, newSize)");
                sparseArrayCompat.keys = copyOf;
                Object[] copyOf2 = Arrays.copyOf(sparseArrayCompat.values, idealIntArraySize);
                g0.o(copyOf2, "copyOf(this, newSize)");
                sparseArrayCompat.values = copyOf2;
            }
            int i9 = sparseArrayCompat.size;
            if (i9 - i7 != 0) {
                int[] iArr = sparseArrayCompat.keys;
                int i10 = i7 + 1;
                n.z0(iArr, iArr, i10, i7, i9);
                Object[] objArr = sparseArrayCompat.values;
                n.B0(objArr, objArr, i10, i7, sparseArrayCompat.size);
            }
            sparseArrayCompat.keys[i7] = i6;
            sparseArrayCompat.values[i7] = e6;
            sparseArrayCompat.size++;
        }
        return e7;
    }

    public static final <E> void commonRemoveAt(@NotNull SparseArrayCompat<E> sparseArrayCompat, int i6) {
        g0.p(sparseArrayCompat, "<this>");
        if (sparseArrayCompat.values[i6] != DELETED) {
            sparseArrayCompat.values[i6] = DELETED;
            sparseArrayCompat.garbage = true;
        }
    }

    public static final <E> void commonRemoveAtRange(@NotNull SparseArrayCompat<E> sparseArrayCompat, int i6, int i7) {
        g0.p(sparseArrayCompat, "<this>");
        int min = Math.min(i7, i6 + i7);
        while (i6 < min) {
            sparseArrayCompat.removeAt(i6);
            i6++;
        }
    }

    public static final <E> void commonSetValueAt(@NotNull SparseArrayCompat<E> sparseArrayCompat, int i6, E e6) {
        g0.p(sparseArrayCompat, "<this>");
        if (sparseArrayCompat.garbage) {
            gc(sparseArrayCompat);
        }
        sparseArrayCompat.values[i6] = e6;
    }

    public static final <E> int commonSize(@NotNull SparseArrayCompat<E> sparseArrayCompat) {
        g0.p(sparseArrayCompat, "<this>");
        if (sparseArrayCompat.garbage) {
            gc(sparseArrayCompat);
        }
        return sparseArrayCompat.size;
    }

    @NotNull
    public static final <E> String commonToString(@NotNull SparseArrayCompat<E> sparseArrayCompat) {
        g0.p(sparseArrayCompat, "<this>");
        if (sparseArrayCompat.size() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(sparseArrayCompat.size * 28);
        sb.append('{');
        int i6 = sparseArrayCompat.size;
        for (int i7 = 0; i7 < i6; i7++) {
            if (i7 > 0) {
                sb.append(", ");
            }
            sb.append(sparseArrayCompat.keyAt(i7));
            sb.append('=');
            E valueAt = sparseArrayCompat.valueAt(i7);
            if (valueAt != sparseArrayCompat) {
                sb.append(valueAt);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        String sb2 = sb.toString();
        g0.o(sb2, "buffer.toString()");
        return sb2;
    }

    public static final <E> E commonValueAt(@NotNull SparseArrayCompat<E> sparseArrayCompat, int i6) {
        g0.p(sparseArrayCompat, "<this>");
        if (sparseArrayCompat.garbage) {
            gc(sparseArrayCompat);
        }
        return (E) sparseArrayCompat.values[i6];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <E> void gc(SparseArrayCompat<E> sparseArrayCompat) {
        int i6 = sparseArrayCompat.size;
        int[] iArr = sparseArrayCompat.keys;
        Object[] objArr = sparseArrayCompat.values;
        int i7 = 0;
        for (int i8 = 0; i8 < i6; i8++) {
            Object obj = objArr[i8];
            if (obj != DELETED) {
                if (i8 != i7) {
                    iArr[i7] = iArr[i8];
                    objArr[i7] = obj;
                    objArr[i8] = null;
                }
                i7++;
            }
        }
        sparseArrayCompat.garbage = false;
        sparseArrayCompat.size = i7;
    }

    private static final <E, T extends E> T internalGet(SparseArrayCompat<E> sparseArrayCompat, int i6, T t5) {
        T t6;
        int binarySearch = ContainerHelpersKt.binarySearch(sparseArrayCompat.keys, sparseArrayCompat.size, i6);
        return (binarySearch < 0 || (t6 = (T) sparseArrayCompat.values[binarySearch]) == DELETED) ? t5 : t6;
    }

    public static final <E> E commonGet(@NotNull SparseArrayCompat<E> sparseArrayCompat, int i6, E e6) {
        E e7;
        g0.p(sparseArrayCompat, "<this>");
        int binarySearch = ContainerHelpersKt.binarySearch(sparseArrayCompat.keys, sparseArrayCompat.size, i6);
        return (binarySearch < 0 || (e7 = (E) sparseArrayCompat.values[binarySearch]) == DELETED) ? e6 : e7;
    }

    public static final <E> boolean commonReplace(@NotNull SparseArrayCompat<E> sparseArrayCompat, int i6, E e6, E e7) {
        g0.p(sparseArrayCompat, "<this>");
        int indexOfKey = sparseArrayCompat.indexOfKey(i6);
        if (indexOfKey < 0 || !g0.g(sparseArrayCompat.values[indexOfKey], e6)) {
            return false;
        }
        sparseArrayCompat.values[indexOfKey] = e7;
        return true;
    }

    public static final <E> boolean commonRemove(@NotNull SparseArrayCompat<E> sparseArrayCompat, int i6, @Nullable Object obj) {
        g0.p(sparseArrayCompat, "<this>");
        int indexOfKey = sparseArrayCompat.indexOfKey(i6);
        if (indexOfKey < 0 || !g0.g(obj, sparseArrayCompat.valueAt(indexOfKey))) {
            return false;
        }
        sparseArrayCompat.removeAt(indexOfKey);
        return true;
    }
}
