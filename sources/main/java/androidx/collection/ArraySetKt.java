package androidx.collection;

import androidx.collection.internal.ContainerHelpersKt;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Set;
import kotlin.collections.f0;
import kotlin.collections.n;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class ArraySetKt {
    public static final int ARRAY_SET_BASE_SIZE = 4;

    public static final <E> void addAllInternal(@NotNull ArraySet<E> arraySet, @NotNull ArraySet<? extends E> array) {
        g0.p(arraySet, "<this>");
        g0.p(array, "array");
        int i6 = array.get_size$collection();
        arraySet.ensureCapacity(arraySet.get_size$collection() + i6);
        if (arraySet.get_size$collection() != 0) {
            for (int i7 = 0; i7 < i6; i7++) {
                arraySet.add(array.valueAt(i7));
            }
            return;
        }
        if (i6 > 0) {
            n.I0(array.getHashes$collection(), arraySet.getHashes$collection(), 0, 0, i6, 6, null);
            n.K0(array.getArray$collection(), arraySet.getArray$collection(), 0, 0, i6, 6, null);
            if (arraySet.get_size$collection() != 0) {
                throw new ConcurrentModificationException();
            }
            arraySet.set_size$collection(i6);
        }
    }

    @NotNull
    public static final <T> ArraySet<T> arraySetOf() {
        return new ArraySet<>(0, 1, null);
    }

    public static final <E> boolean removeAllInternal(@NotNull ArraySet<E> arraySet, @NotNull ArraySet<? extends E> array) {
        g0.p(arraySet, "<this>");
        g0.p(array, "array");
        int i6 = array.get_size$collection();
        int i7 = arraySet.get_size$collection();
        for (int i8 = 0; i8 < i6; i8++) {
            arraySet.remove(array.valueAt(i8));
        }
        return i7 != arraySet.get_size$collection();
    }

    public static final <E> boolean addInternal(@NotNull ArraySet<E> arraySet, E e6) {
        int i6;
        int indexOf;
        g0.p(arraySet, "<this>");
        int i7 = arraySet.get_size$collection();
        if (e6 == null) {
            indexOf = indexOfNull(arraySet);
            i6 = 0;
        } else {
            int hashCode = e6.hashCode();
            i6 = hashCode;
            indexOf = indexOf(arraySet, e6, hashCode);
        }
        if (indexOf >= 0) {
            return false;
        }
        int i8 = ~indexOf;
        if (i7 >= arraySet.getHashes$collection().length) {
            int i9 = 8;
            if (i7 >= 8) {
                i9 = (i7 >> 1) + i7;
            } else if (i7 < 4) {
                i9 = 4;
            }
            int[] hashes$collection = arraySet.getHashes$collection();
            Object[] array$collection = arraySet.getArray$collection();
            allocArrays(arraySet, i9);
            if (i7 != arraySet.get_size$collection()) {
                throw new ConcurrentModificationException();
            }
            if (!(arraySet.getHashes$collection().length == 0)) {
                n.I0(hashes$collection, arraySet.getHashes$collection(), 0, 0, hashes$collection.length, 6, null);
                n.K0(array$collection, arraySet.getArray$collection(), 0, 0, array$collection.length, 6, null);
            }
        }
        if (i8 < i7) {
            int i10 = i8 + 1;
            n.z0(arraySet.getHashes$collection(), arraySet.getHashes$collection(), i10, i8, i7);
            n.B0(arraySet.getArray$collection(), arraySet.getArray$collection(), i10, i8, i7);
        }
        if (i7 != arraySet.get_size$collection() || i8 >= arraySet.getHashes$collection().length) {
            throw new ConcurrentModificationException();
        }
        arraySet.getHashes$collection()[i8] = i6;
        arraySet.getArray$collection()[i8] = e6;
        arraySet.set_size$collection(arraySet.get_size$collection() + 1);
        return true;
    }

    public static final <E> void allocArrays(@NotNull ArraySet<E> arraySet, int i6) {
        g0.p(arraySet, "<this>");
        arraySet.setHashes$collection(new int[i6]);
        arraySet.setArray$collection(new Object[i6]);
    }

    @NotNull
    public static final <T> ArraySet<T> arraySetOf(@NotNull T... values) {
        g0.p(values, "values");
        ArraySet<T> arraySet = new ArraySet<>(values.length);
        for (T t5 : values) {
            arraySet.add(t5);
        }
        return arraySet;
    }

    public static final <E> int binarySearchInternal(@NotNull ArraySet<E> arraySet, int i6) {
        g0.p(arraySet, "<this>");
        try {
            return ContainerHelpersKt.binarySearch(arraySet.getHashes$collection(), arraySet.get_size$collection(), i6);
        } catch (IndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    public static final <E> void clearInternal(@NotNull ArraySet<E> arraySet) {
        g0.p(arraySet, "<this>");
        if (arraySet.get_size$collection() != 0) {
            arraySet.setHashes$collection(ContainerHelpersKt.EMPTY_INTS);
            arraySet.setArray$collection(ContainerHelpersKt.EMPTY_OBJECTS);
            arraySet.set_size$collection(0);
        }
        if (arraySet.get_size$collection() != 0) {
            throw new ConcurrentModificationException();
        }
    }

    public static final <E> boolean containsAllInternal(@NotNull ArraySet<E> arraySet, @NotNull Collection<? extends E> elements) {
        g0.p(arraySet, "<this>");
        g0.p(elements, "elements");
        Iterator<? extends E> it = elements.iterator();
        while (it.hasNext()) {
            if (!arraySet.contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    public static final <E> boolean containsInternal(@NotNull ArraySet<E> arraySet, E e6) {
        g0.p(arraySet, "<this>");
        return arraySet.indexOf(e6) >= 0;
    }

    public static final <E> void ensureCapacityInternal(@NotNull ArraySet<E> arraySet, int i6) {
        g0.p(arraySet, "<this>");
        int i7 = arraySet.get_size$collection();
        if (arraySet.getHashes$collection().length < i6) {
            int[] hashes$collection = arraySet.getHashes$collection();
            Object[] array$collection = arraySet.getArray$collection();
            allocArrays(arraySet, i6);
            if (arraySet.get_size$collection() > 0) {
                n.I0(hashes$collection, arraySet.getHashes$collection(), 0, 0, arraySet.get_size$collection(), 6, null);
                n.K0(array$collection, arraySet.getArray$collection(), 0, 0, arraySet.get_size$collection(), 6, null);
            }
        }
        if (arraySet.get_size$collection() != i7) {
            throw new ConcurrentModificationException();
        }
    }

    public static final <E> boolean equalsInternal(@NotNull ArraySet<E> arraySet, @Nullable Object obj) {
        g0.p(arraySet, "<this>");
        if (arraySet == obj) {
            return true;
        }
        if (!(obj instanceof Set) || arraySet.size() != ((Set) obj).size()) {
            return false;
        }
        try {
            int i6 = arraySet.get_size$collection();
            for (int i7 = 0; i7 < i6; i7++) {
                if (!((Set) obj).contains(arraySet.valueAt(i7))) {
                    return false;
                }
            }
            return true;
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    public static final <E> int hashCodeInternal(@NotNull ArraySet<E> arraySet) {
        g0.p(arraySet, "<this>");
        int[] hashes$collection = arraySet.getHashes$collection();
        int i6 = arraySet.get_size$collection();
        int i7 = 0;
        for (int i8 = 0; i8 < i6; i8++) {
            i7 += hashes$collection[i8];
        }
        return i7;
    }

    public static final <E> int indexOf(@NotNull ArraySet<E> arraySet, @Nullable Object obj, int i6) {
        g0.p(arraySet, "<this>");
        int i7 = arraySet.get_size$collection();
        if (i7 == 0) {
            return -1;
        }
        int binarySearchInternal = binarySearchInternal(arraySet, i6);
        if (binarySearchInternal < 0 || g0.g(obj, arraySet.getArray$collection()[binarySearchInternal])) {
            return binarySearchInternal;
        }
        int i8 = binarySearchInternal + 1;
        while (i8 < i7 && arraySet.getHashes$collection()[i8] == i6) {
            if (g0.g(obj, arraySet.getArray$collection()[i8])) {
                return i8;
            }
            i8++;
        }
        for (int i9 = binarySearchInternal - 1; i9 >= 0 && arraySet.getHashes$collection()[i9] == i6; i9--) {
            if (g0.g(obj, arraySet.getArray$collection()[i9])) {
                return i9;
            }
        }
        return ~i8;
    }

    public static final <E> int indexOfInternal(@NotNull ArraySet<E> arraySet, @Nullable Object obj) {
        g0.p(arraySet, "<this>");
        return obj == null ? indexOfNull(arraySet) : indexOf(arraySet, obj, obj.hashCode());
    }

    public static final <E> int indexOfNull(@NotNull ArraySet<E> arraySet) {
        g0.p(arraySet, "<this>");
        return indexOf(arraySet, null, 0);
    }

    public static final <E> boolean isEmptyInternal(@NotNull ArraySet<E> arraySet) {
        g0.p(arraySet, "<this>");
        return arraySet.get_size$collection() <= 0;
    }

    public static final <E> E removeAtInternal(@NotNull ArraySet<E> arraySet, int i6) {
        int i7;
        Object[] objArr;
        g0.p(arraySet, "<this>");
        int i8 = arraySet.get_size$collection();
        E e6 = (E) arraySet.getArray$collection()[i6];
        if (i8 <= 1) {
            arraySet.clear();
            return e6;
        }
        int i9 = i8 - 1;
        if (arraySet.getHashes$collection().length <= 8 || arraySet.get_size$collection() >= arraySet.getHashes$collection().length / 3) {
            if (i6 < i9) {
                int i10 = i6 + 1;
                n.z0(arraySet.getHashes$collection(), arraySet.getHashes$collection(), i6, i10, i8);
                n.B0(arraySet.getArray$collection(), arraySet.getArray$collection(), i6, i10, i8);
            }
            arraySet.getArray$collection()[i9] = null;
        } else {
            int i11 = arraySet.get_size$collection() > 8 ? arraySet.get_size$collection() + (arraySet.get_size$collection() >> 1) : 8;
            int[] hashes$collection = arraySet.getHashes$collection();
            Object[] array$collection = arraySet.getArray$collection();
            allocArrays(arraySet, i11);
            if (i6 > 0) {
                n.I0(hashes$collection, arraySet.getHashes$collection(), 0, 0, i6, 6, null);
                objArr = array$collection;
                n.K0(objArr, arraySet.getArray$collection(), 0, 0, i6, 6, null);
                i7 = i6;
            } else {
                i7 = i6;
                objArr = array$collection;
            }
            if (i7 < i9) {
                int i12 = i7 + 1;
                n.z0(hashes$collection, arraySet.getHashes$collection(), i7, i12, i8);
                n.B0(objArr, arraySet.getArray$collection(), i7, i12, i8);
            }
        }
        if (i8 != arraySet.get_size$collection()) {
            throw new ConcurrentModificationException();
        }
        arraySet.set_size$collection(i9);
        return e6;
    }

    public static final <E> boolean removeInternal(@NotNull ArraySet<E> arraySet, E e6) {
        g0.p(arraySet, "<this>");
        int indexOf = arraySet.indexOf(e6);
        if (indexOf < 0) {
            return false;
        }
        arraySet.removeAt(indexOf);
        return true;
    }

    public static final <E> boolean retainAllInternal(@NotNull ArraySet<E> arraySet, @NotNull Collection<? extends E> elements) {
        g0.p(arraySet, "<this>");
        g0.p(elements, "elements");
        boolean z5 = false;
        for (int i6 = arraySet.get_size$collection() - 1; -1 < i6; i6--) {
            if (!f0.a2(elements, arraySet.getArray$collection()[i6])) {
                arraySet.removeAt(i6);
                z5 = true;
            }
        }
        return z5;
    }

    @NotNull
    public static final <E> String toStringInternal(@NotNull ArraySet<E> arraySet) {
        g0.p(arraySet, "<this>");
        if (arraySet.isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(arraySet.get_size$collection() * 14);
        sb.append('{');
        int i6 = arraySet.get_size$collection();
        for (int i7 = 0; i7 < i6; i7++) {
            if (i7 > 0) {
                sb.append(", ");
            }
            E valueAt = arraySet.valueAt(i7);
            if (valueAt != arraySet) {
                sb.append(valueAt);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append('}');
        String sb2 = sb.toString();
        g0.o(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    public static final <E> E valueAtInternal(@NotNull ArraySet<E> arraySet, int i6) {
        g0.p(arraySet, "<this>");
        return (E) arraySet.getArray$collection()[i6];
    }

    public static final <E> boolean removeAllInternal(@NotNull ArraySet<E> arraySet, @NotNull Collection<? extends E> elements) {
        g0.p(arraySet, "<this>");
        g0.p(elements, "elements");
        Iterator<? extends E> it = elements.iterator();
        boolean z5 = false;
        while (it.hasNext()) {
            z5 |= arraySet.remove(it.next());
        }
        return z5;
    }

    public static final <E> boolean addAllInternal(@NotNull ArraySet<E> arraySet, @NotNull Collection<? extends E> elements) {
        g0.p(arraySet, "<this>");
        g0.p(elements, "elements");
        arraySet.ensureCapacity(arraySet.get_size$collection() + elements.size());
        Iterator<? extends E> it = elements.iterator();
        boolean z5 = false;
        while (it.hasNext()) {
            z5 |= arraySet.add(it.next());
        }
        return z5;
    }
}
