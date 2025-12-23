package androidx.collection;

import androidx.collection.internal.ContainerHelpersKt;
import java.util.Arrays;
import kotlin.Deprecated;
import kotlin.ReplaceWith;
import kotlin.collections.n;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nSparseArrayCompat.jvm.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SparseArrayCompat.jvm.kt\nandroidx/collection/SparseArrayCompat\n+ 2 SparseArrayCompat.kt\nandroidx/collection/SparseArrayCompatKt\n*L\n1#1,273:1\n275#2,9:274\n288#2,5:283\n296#2,5:288\n304#2,8:293\n320#2,9:301\n353#2,40:310\n396#2,2:350\n353#2,47:352\n403#2,3:399\n353#2,40:402\n407#2:442\n412#2,4:443\n419#2:447\n423#2,4:448\n431#2,8:452\n443#2,5:460\n451#2,4:465\n459#2,9:469\n472#2:478\n477#2:479\n459#2,9:480\n482#2,8:489\n493#2,17:497\n513#2,21:514\n*S KotlinDebug\n*F\n+ 1 SparseArrayCompat.jvm.kt\nandroidx/collection/SparseArrayCompat\n*L\n130#1:274,9\n135#1:283,5\n144#1:288,5\n152#1:293,8\n163#1:301,9\n169#1:310,40\n176#1:350,2\n176#1:352,47\n186#1:399,3\n186#1:402,40\n186#1:442\n191#1:443,4\n205#1:447\n212#1:448,4\n218#1:452,8\n224#1:460,5\n234#1:465,4\n246#1:469,9\n249#1:478\n252#1:479\n252#1:480,9\n257#1:489,8\n263#1:497,17\n271#1:514,21\n*E\n"})
/* loaded from: D:\Downloads\app\classes.dex */
public class SparseArrayCompat<E> implements Cloneable {

    @JvmField
    public /* synthetic */ boolean garbage;

    @JvmField
    public /* synthetic */ int[] keys;

    @JvmField
    public /* synthetic */ int size;

    @JvmField
    public /* synthetic */ Object[] values;

    @JvmOverloads
    public SparseArrayCompat() {
        this(0, 1, null);
    }

    @Nullable
    public E get(int i6) {
        return (E) SparseArrayCompatKt.commonGet(this, i6);
    }

    public void remove(int i6) {
        SparseArrayCompatKt.commonRemove(this, i6);
    }

    @Nullable
    public E replace(int i6, E e6) {
        int indexOfKey = indexOfKey(i6);
        if (indexOfKey < 0) {
            return null;
        }
        Object[] objArr = this.values;
        E e7 = (E) objArr[indexOfKey];
        objArr[indexOfKey] = e6;
        return e7;
    }

    @JvmOverloads
    public SparseArrayCompat(int i6) {
        if (i6 == 0) {
            this.keys = ContainerHelpersKt.EMPTY_INTS;
            this.values = ContainerHelpersKt.EMPTY_OBJECTS;
        } else {
            int idealIntArraySize = ContainerHelpersKt.idealIntArraySize(i6);
            this.keys = new int[idealIntArraySize];
            this.values = new Object[idealIntArraySize];
        }
    }

    public void append(int i6, E e6) {
        int i7 = this.size;
        if (i7 != 0 && i6 <= this.keys[i7 - 1]) {
            put(i6, e6);
            return;
        }
        if (this.garbage && i7 >= this.keys.length) {
            SparseArrayCompatKt.gc(this);
        }
        int i8 = this.size;
        if (i8 >= this.keys.length) {
            int idealIntArraySize = ContainerHelpersKt.idealIntArraySize(i8 + 1);
            int[] copyOf = Arrays.copyOf(this.keys, idealIntArraySize);
            g0.o(copyOf, "copyOf(this, newSize)");
            this.keys = copyOf;
            Object[] copyOf2 = Arrays.copyOf(this.values, idealIntArraySize);
            g0.o(copyOf2, "copyOf(this, newSize)");
            this.values = copyOf2;
        }
        this.keys[i8] = i6;
        this.values[i8] = e6;
        this.size = i8 + 1;
    }

    public void clear() {
        int i6 = this.size;
        Object[] objArr = this.values;
        for (int i7 = 0; i7 < i6; i7++) {
            objArr[i7] = null;
        }
        this.size = 0;
        this.garbage = false;
    }

    @NotNull
    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public SparseArrayCompat<E> m26clone() {
        Object clone = super.clone();
        g0.n(clone, "null cannot be cast to non-null type androidx.collection.SparseArrayCompat<E of androidx.collection.SparseArrayCompat>");
        SparseArrayCompat<E> sparseArrayCompat = (SparseArrayCompat) clone;
        sparseArrayCompat.keys = (int[]) this.keys.clone();
        sparseArrayCompat.values = (Object[]) this.values.clone();
        return sparseArrayCompat;
    }

    public boolean containsValue(E e6) {
        if (this.garbage) {
            SparseArrayCompatKt.gc(this);
        }
        int i6 = this.size;
        int i7 = 0;
        while (true) {
            if (i7 >= i6) {
                i7 = -1;
                break;
            }
            if (this.values[i7] == e6) {
                break;
            }
            i7++;
        }
        return i7 >= 0;
    }

    public E get(int i6, E e6) {
        return (E) SparseArrayCompatKt.commonGet(this, i6, e6);
    }

    public int indexOfKey(int i6) {
        if (this.garbage) {
            SparseArrayCompatKt.gc(this);
        }
        return ContainerHelpersKt.binarySearch(this.keys, this.size, i6);
    }

    public int indexOfValue(E e6) {
        if (this.garbage) {
            SparseArrayCompatKt.gc(this);
        }
        int i6 = this.size;
        for (int i7 = 0; i7 < i6; i7++) {
            if (this.values[i7] == e6) {
                return i7;
            }
        }
        return -1;
    }

    public int keyAt(int i6) {
        if (this.garbage) {
            SparseArrayCompatKt.gc(this);
        }
        return this.keys[i6];
    }

    public void put(int i6, E e6) {
        int binarySearch = ContainerHelpersKt.binarySearch(this.keys, this.size, i6);
        if (binarySearch >= 0) {
            this.values[binarySearch] = e6;
            return;
        }
        int i7 = ~binarySearch;
        if (i7 < this.size && this.values[i7] == SparseArrayCompatKt.DELETED) {
            this.keys[i7] = i6;
            this.values[i7] = e6;
            return;
        }
        if (this.garbage && this.size >= this.keys.length) {
            SparseArrayCompatKt.gc(this);
            i7 = ~ContainerHelpersKt.binarySearch(this.keys, this.size, i6);
        }
        int i8 = this.size;
        if (i8 >= this.keys.length) {
            int idealIntArraySize = ContainerHelpersKt.idealIntArraySize(i8 + 1);
            int[] copyOf = Arrays.copyOf(this.keys, idealIntArraySize);
            g0.o(copyOf, "copyOf(this, newSize)");
            this.keys = copyOf;
            Object[] copyOf2 = Arrays.copyOf(this.values, idealIntArraySize);
            g0.o(copyOf2, "copyOf(this, newSize)");
            this.values = copyOf2;
        }
        int i9 = this.size;
        if (i9 - i7 != 0) {
            int[] iArr = this.keys;
            int i10 = i7 + 1;
            n.z0(iArr, iArr, i10, i7, i9);
            Object[] objArr = this.values;
            n.B0(objArr, objArr, i10, i7, this.size);
        }
        this.keys[i7] = i6;
        this.values[i7] = e6;
        this.size++;
    }

    public void putAll(@NotNull SparseArrayCompat<? extends E> other) {
        g0.p(other, "other");
        int size = other.size();
        for (int i6 = 0; i6 < size; i6++) {
            int keyAt = other.keyAt(i6);
            E valueAt = other.valueAt(i6);
            int binarySearch = ContainerHelpersKt.binarySearch(this.keys, this.size, keyAt);
            if (binarySearch >= 0) {
                this.values[binarySearch] = valueAt;
            } else {
                int i7 = ~binarySearch;
                if (i7 >= this.size || this.values[i7] != SparseArrayCompatKt.DELETED) {
                    if (this.garbage && this.size >= this.keys.length) {
                        SparseArrayCompatKt.gc(this);
                        i7 = ~ContainerHelpersKt.binarySearch(this.keys, this.size, keyAt);
                    }
                    int i8 = this.size;
                    if (i8 >= this.keys.length) {
                        int idealIntArraySize = ContainerHelpersKt.idealIntArraySize(i8 + 1);
                        int[] copyOf = Arrays.copyOf(this.keys, idealIntArraySize);
                        g0.o(copyOf, "copyOf(this, newSize)");
                        this.keys = copyOf;
                        Object[] copyOf2 = Arrays.copyOf(this.values, idealIntArraySize);
                        g0.o(copyOf2, "copyOf(this, newSize)");
                        this.values = copyOf2;
                    }
                    int i9 = this.size;
                    if (i9 - i7 != 0) {
                        int[] iArr = this.keys;
                        int i10 = i7 + 1;
                        n.z0(iArr, iArr, i10, i7, i9);
                        Object[] objArr = this.values;
                        n.B0(objArr, objArr, i10, i7, this.size);
                    }
                    this.keys[i7] = keyAt;
                    this.values[i7] = valueAt;
                    this.size++;
                } else {
                    this.keys[i7] = keyAt;
                    this.values[i7] = valueAt;
                }
            }
        }
    }

    public boolean remove(int i6, @Nullable Object obj) {
        int indexOfKey = indexOfKey(i6);
        if (indexOfKey < 0 || !g0.g(obj, valueAt(indexOfKey))) {
            return false;
        }
        removeAt(indexOfKey);
        return true;
    }

    public void removeAt(int i6) {
        if (this.values[i6] != SparseArrayCompatKt.DELETED) {
            this.values[i6] = SparseArrayCompatKt.DELETED;
            this.garbage = true;
        }
    }

    public void removeAtRange(int i6, int i7) {
        int min = Math.min(i7, i6 + i7);
        while (i6 < min) {
            removeAt(i6);
            i6++;
        }
    }

    public void setValueAt(int i6, E e6) {
        if (this.garbage) {
            SparseArrayCompatKt.gc(this);
        }
        this.values[i6] = e6;
    }

    public int size() {
        if (this.garbage) {
            SparseArrayCompatKt.gc(this);
        }
        return this.size;
    }

    public E valueAt(int i6) {
        if (this.garbage) {
            SparseArrayCompatKt.gc(this);
        }
        return (E) this.values[i6];
    }

    public boolean containsKey(int i6) {
        if (indexOfKey(i6) >= 0) {
            return true;
        }
        return false;
    }

    @Deprecated(message = "Alias for remove(int).", replaceWith = @ReplaceWith(expression = "remove(key)", imports = {}))
    public void delete(int i6) {
        remove(i6);
    }

    @JvmName(name = "getIsEmpty")
    public final boolean getIsEmpty() {
        return isEmpty();
    }

    public boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }

    @Nullable
    public E putIfAbsent(int i6, E e6) {
        E e7 = (E) SparseArrayCompatKt.commonGet(this, i6);
        if (e7 == null) {
            int binarySearch = ContainerHelpersKt.binarySearch(this.keys, this.size, i6);
            if (binarySearch >= 0) {
                this.values[binarySearch] = e6;
                return e7;
            }
            int i7 = ~binarySearch;
            if (i7 < this.size && this.values[i7] == SparseArrayCompatKt.DELETED) {
                this.keys[i7] = i6;
                this.values[i7] = e6;
                return e7;
            }
            if (this.garbage && this.size >= this.keys.length) {
                SparseArrayCompatKt.gc(this);
                i7 = ~ContainerHelpersKt.binarySearch(this.keys, this.size, i6);
            }
            int i8 = this.size;
            if (i8 >= this.keys.length) {
                int idealIntArraySize = ContainerHelpersKt.idealIntArraySize(i8 + 1);
                int[] copyOf = Arrays.copyOf(this.keys, idealIntArraySize);
                g0.o(copyOf, "copyOf(this, newSize)");
                this.keys = copyOf;
                Object[] copyOf2 = Arrays.copyOf(this.values, idealIntArraySize);
                g0.o(copyOf2, "copyOf(this, newSize)");
                this.values = copyOf2;
            }
            int i9 = this.size;
            if (i9 - i7 != 0) {
                int[] iArr = this.keys;
                int i10 = i7 + 1;
                n.z0(iArr, iArr, i10, i7, i9);
                Object[] objArr = this.values;
                n.B0(objArr, objArr, i10, i7, this.size);
            }
            this.keys[i7] = i6;
            this.values[i7] = e6;
            this.size++;
        }
        return e7;
    }

    @NotNull
    public String toString() {
        if (size() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.size * 28);
        sb.append('{');
        int i6 = this.size;
        for (int i7 = 0; i7 < i6; i7++) {
            if (i7 > 0) {
                sb.append(", ");
            }
            sb.append(keyAt(i7));
            sb.append('=');
            E valueAt = valueAt(i7);
            if (valueAt != this) {
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

    public boolean replace(int i6, E e6, E e7) {
        int indexOfKey = indexOfKey(i6);
        if (indexOfKey < 0 || !g0.g(this.values[indexOfKey], e6)) {
            return false;
        }
        this.values[indexOfKey] = e7;
        return true;
    }

    public /* synthetic */ SparseArrayCompat(int i6, int i7, v vVar) {
        this((i7 & 1) != 0 ? 10 : i6);
    }
}
