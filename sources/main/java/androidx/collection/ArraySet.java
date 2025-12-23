package androidx.collection;

import androidx.collection.internal.ContainerHelpersKt;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Set;
import kotlin.collections.f0;
import kotlin.collections.n;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import m3.b;
import m3.h;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nArraySet.jvm.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ArraySet.jvm.kt\nandroidx/collection/ArraySet\n+ 2 ArraySet.kt\nandroidx/collection/ArraySetKt\n*L\n1#1,300:1\n304#2,10:301\n317#2,14:311\n334#2:325\n339#2:326\n345#2:327\n350#2:328\n355#2,61:329\n420#2,17:390\n440#2,6:407\n450#2,60:413\n518#2,9:473\n531#2,22:482\n557#2,7:504\n568#2,19:511\n591#2,6:530\n601#2,6:536\n611#2,5:542\n620#2,8:547\n*S KotlinDebug\n*F\n+ 1 ArraySet.jvm.kt\nandroidx/collection/ArraySet\n*L\n98#1:301,10\n108#1:311,14\n118#1:325\n128#1:326\n138#1:327\n145#1:328\n157#1:329,61\n167#1:390,17\n177#1:407,6\n188#1:413,60\n197#1:473,9\n224#1:482,22\n231#1:504,7\n240#1:511,19\n267#1:530,6\n276#1:536,6\n286#1:542,5\n297#1:547,8\n*E\n"})
/* loaded from: D:\Downloads\app\classes.dex */
public final class ArraySet<E> implements Collection<E>, Set<E>, b, h {
    private int _size;

    @NotNull
    private Object[] array;

    @NotNull
    private int[] hashes;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private final class ElementIterator extends IndexBasedArrayIterator<E> {
        public ElementIterator() {
            super(ArraySet.this.get_size$collection());
        }

        @Override // androidx.collection.IndexBasedArrayIterator
        protected E elementAt(int i6) {
            return ArraySet.this.valueAt(i6);
        }

        @Override // androidx.collection.IndexBasedArrayIterator
        protected void removeAt(int i6) {
            ArraySet.this.removeAt(i6);
        }
    }

    @JvmOverloads
    public ArraySet() {
        this(0, 1, null);
    }

    public final void addAll(@NotNull ArraySet<? extends E> array) {
        g0.p(array, "array");
        int i6 = array.get_size$collection();
        ensureCapacity(get_size$collection() + i6);
        if (get_size$collection() != 0) {
            for (int i7 = 0; i7 < i6; i7++) {
                add(array.valueAt(i7));
            }
            return;
        }
        if (i6 > 0) {
            n.I0(array.getHashes$collection(), getHashes$collection(), 0, 0, i6, 6, null);
            n.K0(array.getArray$collection(), getArray$collection(), 0, 0, i6, 6, null);
            if (get_size$collection() != 0) {
                throw new ConcurrentModificationException();
            }
            set_size$collection(i6);
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Set) || size() != ((Set) obj).size()) {
            return false;
        }
        try {
            int i6 = get_size$collection();
            for (int i7 = 0; i7 < i6; i7++) {
                if (!((Set) obj).contains(valueAt(i7))) {
                    return false;
                }
            }
            return true;
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    public final boolean removeAll(@NotNull ArraySet<? extends E> array) {
        g0.p(array, "array");
        int i6 = array.get_size$collection();
        int i7 = get_size$collection();
        for (int i8 = 0; i8 < i6; i8++) {
            remove(array.valueAt(i8));
        }
        return i7 != get_size$collection();
    }

    @Override // java.util.Collection, java.util.Set
    @NotNull
    public final Object[] toArray() {
        return n.l1(this.array, 0, this._size);
    }

    @JvmOverloads
    public ArraySet(int i6) {
        this.hashes = ContainerHelpersKt.EMPTY_INTS;
        this.array = ContainerHelpersKt.EMPTY_OBJECTS;
        if (i6 > 0) {
            ArraySetKt.allocArrays(this, i6);
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean add(E e6) {
        int i6;
        int indexOf;
        int i7 = get_size$collection();
        if (e6 == null) {
            indexOf = ArraySetKt.indexOfNull(this);
            i6 = 0;
        } else {
            int hashCode = e6.hashCode();
            i6 = hashCode;
            indexOf = ArraySetKt.indexOf(this, e6, hashCode);
        }
        if (indexOf >= 0) {
            return false;
        }
        int i8 = ~indexOf;
        if (i7 >= getHashes$collection().length) {
            int i9 = 8;
            if (i7 >= 8) {
                i9 = (i7 >> 1) + i7;
            } else if (i7 < 4) {
                i9 = 4;
            }
            int[] hashes$collection = getHashes$collection();
            Object[] array$collection = getArray$collection();
            ArraySetKt.allocArrays(this, i9);
            if (i7 != get_size$collection()) {
                throw new ConcurrentModificationException();
            }
            if (!(getHashes$collection().length == 0)) {
                n.I0(hashes$collection, getHashes$collection(), 0, 0, hashes$collection.length, 6, null);
                n.K0(array$collection, getArray$collection(), 0, 0, array$collection.length, 6, null);
            }
        }
        if (i8 < i7) {
            int i10 = i8 + 1;
            n.z0(getHashes$collection(), getHashes$collection(), i10, i8, i7);
            n.B0(getArray$collection(), getArray$collection(), i10, i8, i7);
        }
        if (i7 != get_size$collection() || i8 >= getHashes$collection().length) {
            throw new ConcurrentModificationException();
        }
        getHashes$collection()[i8] = i6;
        getArray$collection()[i8] = e6;
        set_size$collection(get_size$collection() + 1);
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean containsAll(@NotNull Collection<? extends Object> elements) {
        g0.p(elements, "elements");
        Iterator<? extends Object> it = elements.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @NotNull
    public final Object[] getArray$collection() {
        return this.array;
    }

    @NotNull
    public final int[] getHashes$collection() {
        return this.hashes;
    }

    public int getSize() {
        return this._size;
    }

    public final int get_size$collection() {
        return this._size;
    }

    public final int indexOf(@Nullable Object obj) {
        return obj == null ? ArraySetKt.indexOfNull(this) : ArraySetKt.indexOf(this, obj, obj.hashCode());
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    @NotNull
    public Iterator<E> iterator() {
        return new ElementIterator();
    }

    @Override // java.util.Collection, java.util.Set
    public boolean retainAll(@NotNull Collection<? extends Object> elements) {
        g0.p(elements, "elements");
        boolean z5 = false;
        for (int i6 = get_size$collection() - 1; -1 < i6; i6--) {
            if (!f0.a2(elements, getArray$collection()[i6])) {
                removeAt(i6);
                z5 = true;
            }
        }
        return z5;
    }

    public final void setArray$collection(@NotNull Object[] objArr) {
        g0.p(objArr, "<set-?>");
        this.array = objArr;
    }

    public final void setHashes$collection(@NotNull int[] iArr) {
        g0.p(iArr, "<set-?>");
        this.hashes = iArr;
    }

    public final void set_size$collection(int i6) {
        this._size = i6;
    }

    @Override // java.util.Collection, java.util.Set
    @NotNull
    public final <T> T[] toArray(@NotNull T[] array) {
        g0.p(array, "array");
        T[] result = (T[]) ArraySetJvmUtil.resizeForToArray(array, this._size);
        n.B0(this.array, result, 0, 0, this._size);
        g0.o(result, "result");
        return result;
    }

    @Override // java.util.Collection, java.util.Set
    public void clear() {
        if (get_size$collection() != 0) {
            setHashes$collection(ContainerHelpersKt.EMPTY_INTS);
            setArray$collection(ContainerHelpersKt.EMPTY_OBJECTS);
            set_size$collection(0);
        }
        if (get_size$collection() == 0) {
        } else {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        if (indexOf(obj) >= 0) {
            return true;
        }
        return false;
    }

    public final void ensureCapacity(int i6) {
        int i7 = get_size$collection();
        if (getHashes$collection().length < i6) {
            int[] hashes$collection = getHashes$collection();
            Object[] array$collection = getArray$collection();
            ArraySetKt.allocArrays(this, i6);
            if (get_size$collection() > 0) {
                n.I0(hashes$collection, getHashes$collection(), 0, 0, get_size$collection(), 6, null);
                n.K0(array$collection, getArray$collection(), 0, 0, get_size$collection(), 6, null);
            }
        }
        if (get_size$collection() == i7) {
        } else {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        int[] hashes$collection = getHashes$collection();
        int i6 = get_size$collection();
        int i7 = 0;
        for (int i8 = 0; i8 < i6; i8++) {
            i7 += hashes$collection[i8];
        }
        return i7;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean isEmpty() {
        if (get_size$collection() <= 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        int indexOf = indexOf(obj);
        if (indexOf >= 0) {
            removeAt(indexOf);
            return true;
        }
        return false;
    }

    public final E removeAt(int i6) {
        int i7;
        Object[] objArr;
        int i8 = get_size$collection();
        E e6 = (E) getArray$collection()[i6];
        if (i8 <= 1) {
            clear();
            return e6;
        }
        int i9 = i8 - 1;
        int i10 = 8;
        if (getHashes$collection().length > 8 && get_size$collection() < getHashes$collection().length / 3) {
            if (get_size$collection() > 8) {
                i10 = get_size$collection() + (get_size$collection() >> 1);
            }
            int[] hashes$collection = getHashes$collection();
            Object[] array$collection = getArray$collection();
            ArraySetKt.allocArrays(this, i10);
            if (i6 > 0) {
                n.I0(hashes$collection, getHashes$collection(), 0, 0, i6, 6, null);
                objArr = array$collection;
                n.K0(objArr, getArray$collection(), 0, 0, i6, 6, null);
                i7 = i6;
            } else {
                i7 = i6;
                objArr = array$collection;
            }
            if (i7 < i9) {
                int i11 = i7 + 1;
                n.z0(hashes$collection, getHashes$collection(), i7, i11, i8);
                n.B0(objArr, getArray$collection(), i7, i11, i8);
            }
        } else {
            if (i6 < i9) {
                int i12 = i6 + 1;
                n.z0(getHashes$collection(), getHashes$collection(), i6, i12, i8);
                n.B0(getArray$collection(), getArray$collection(), i6, i12, i8);
            }
            getArray$collection()[i9] = null;
        }
        if (i8 == get_size$collection()) {
            set_size$collection(i9);
            return e6;
        }
        throw new ConcurrentModificationException();
    }

    @Override // java.util.Collection, java.util.Set
    public final /* bridge */ int size() {
        return getSize();
    }

    @NotNull
    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(get_size$collection() * 14);
        sb.append('{');
        int i6 = get_size$collection();
        for (int i7 = 0; i7 < i6; i7++) {
            if (i7 > 0) {
                sb.append(", ");
            }
            E valueAt = valueAt(i7);
            if (valueAt != this) {
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

    public final E valueAt(int i6) {
        return (E) getArray$collection()[i6];
    }

    @Override // java.util.Collection, java.util.Set
    public boolean removeAll(@NotNull Collection<? extends Object> elements) {
        g0.p(elements, "elements");
        Iterator<? extends Object> it = elements.iterator();
        boolean z5 = false;
        while (it.hasNext()) {
            z5 |= remove(it.next());
        }
        return z5;
    }

    public /* synthetic */ ArraySet(int i6, int i7, v vVar) {
        this((i7 & 1) != 0 ? 0 : i6);
    }

    public ArraySet(@Nullable ArraySet<? extends E> arraySet) {
        this(0);
        if (arraySet != null) {
            addAll((ArraySet) arraySet);
        }
    }

    public ArraySet(@Nullable Collection<? extends E> collection) {
        this(0);
        if (collection != null) {
            addAll(collection);
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean addAll(@NotNull Collection<? extends E> elements) {
        g0.p(elements, "elements");
        ensureCapacity(get_size$collection() + elements.size());
        Iterator<? extends E> it = elements.iterator();
        boolean z5 = false;
        while (it.hasNext()) {
            z5 |= add(it.next());
        }
        return z5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ArraySet(@Nullable E[] eArr) {
        this(0);
        if (eArr != null) {
            Iterator a6 = kotlin.jvm.internal.h.a(eArr);
            while (a6.hasNext()) {
                add(a6.next());
            }
        }
    }
}
