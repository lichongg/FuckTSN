package androidx.collection;

import androidx.collection.internal.ContainerHelpersKt;
import java.util.Arrays;
import kotlin.Deprecated;
import kotlin.ReplaceWith;
import kotlin.collections.n;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nLongSparseArray.jvm.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LongSparseArray.jvm.kt\nandroidx/collection/LongSparseArray\n+ 2 LongSparseArray.kt\nandroidx/collection/LongSparseArrayKt\n*L\n1#1,255:1\n243#2:256\n256#2,6:257\n248#2,14:263\n267#2,8:277\n267#2,8:285\n278#2,9:293\n291#2,5:302\n299#2,8:307\n315#2,9:315\n349#2,12:324\n328#2,18:336\n363#2,26:354\n392#2,5:380\n400#2,5:385\n409#2,2:390\n328#2,18:392\n412#2:410\n416#2:411\n420#2,6:412\n328#2,18:418\n427#2:436\n432#2,6:437\n328#2,18:443\n441#2:461\n446#2,6:462\n328#2,18:468\n453#2,2:486\n458#2,2:488\n328#2,18:490\n461#2:508\n466#2,2:509\n328#2,18:511\n469#2,6:529\n479#2:535\n484#2:536\n489#2,8:537\n500#2,6:545\n328#2,18:551\n507#2,10:569\n520#2,21:579\n*S KotlinDebug\n*F\n+ 1 LongSparseArray.jvm.kt\nandroidx/collection/LongSparseArray\n*L\n93#1:256\n93#1:257,6\n100#1:263,14\n106#1:277,8\n111#1:285,8\n120#1:293,9\n125#1:302,5\n134#1:307,8\n145#1:315,9\n151#1:324,12\n151#1:336,18\n151#1:354,26\n157#1:380,5\n168#1:385,5\n173#1:390,2\n173#1:392,18\n173#1:410\n180#1:411\n192#1:412,6\n192#1:418,18\n192#1:436\n204#1:437,6\n204#1:443,18\n204#1:461\n212#1:462,6\n212#1:468,18\n212#1:486,2\n219#1:488,2\n219#1:490,18\n219#1:508\n228#1:509,2\n228#1:511,18\n228#1:529,6\n231#1:535\n234#1:536\n239#1:537,8\n245#1:545,6\n245#1:551,18\n245#1:569,10\n253#1:579,21\n*E\n"})
/* loaded from: D:\Downloads\app\classes.dex */
public class LongSparseArray<E> implements Cloneable {

    @JvmField
    public /* synthetic */ boolean garbage;

    @JvmField
    public /* synthetic */ long[] keys;

    @JvmField
    public /* synthetic */ int size;

    @JvmField
    public /* synthetic */ Object[] values;

    @JvmOverloads
    public LongSparseArray() {
        this(0, 1, null);
    }

    @Nullable
    public E get(long j6) {
        int binarySearch = ContainerHelpersKt.binarySearch(this.keys, this.size, j6);
        if (binarySearch < 0 || this.values[binarySearch] == LongSparseArrayKt.DELETED) {
            return null;
        }
        return (E) this.values[binarySearch];
    }

    public void remove(long j6) {
        int binarySearch = ContainerHelpersKt.binarySearch(this.keys, this.size, j6);
        if (binarySearch < 0 || this.values[binarySearch] == LongSparseArrayKt.DELETED) {
            return;
        }
        this.values[binarySearch] = LongSparseArrayKt.DELETED;
        this.garbage = true;
    }

    @Nullable
    public E replace(long j6, E e6) {
        int indexOfKey = indexOfKey(j6);
        if (indexOfKey < 0) {
            return null;
        }
        Object[] objArr = this.values;
        E e7 = (E) objArr[indexOfKey];
        objArr[indexOfKey] = e6;
        return e7;
    }

    @JvmOverloads
    public LongSparseArray(int i6) {
        if (i6 == 0) {
            this.keys = ContainerHelpersKt.EMPTY_LONGS;
            this.values = ContainerHelpersKt.EMPTY_OBJECTS;
        } else {
            int idealLongArraySize = ContainerHelpersKt.idealLongArraySize(i6);
            this.keys = new long[idealLongArraySize];
            this.values = new Object[idealLongArraySize];
        }
    }

    public void append(long j6, E e6) {
        int i6 = this.size;
        if (i6 != 0 && j6 <= this.keys[i6 - 1]) {
            put(j6, e6);
            return;
        }
        if (this.garbage) {
            long[] jArr = this.keys;
            if (i6 >= jArr.length) {
                Object[] objArr = this.values;
                int i7 = 0;
                for (int i8 = 0; i8 < i6; i8++) {
                    Object obj = objArr[i8];
                    if (obj != LongSparseArrayKt.DELETED) {
                        if (i8 != i7) {
                            jArr[i7] = jArr[i8];
                            objArr[i7] = obj;
                            objArr[i8] = null;
                        }
                        i7++;
                    }
                }
                this.garbage = false;
                this.size = i7;
            }
        }
        int i9 = this.size;
        if (i9 >= this.keys.length) {
            int idealLongArraySize = ContainerHelpersKt.idealLongArraySize(i9 + 1);
            long[] copyOf = Arrays.copyOf(this.keys, idealLongArraySize);
            g0.o(copyOf, "copyOf(this, newSize)");
            this.keys = copyOf;
            Object[] copyOf2 = Arrays.copyOf(this.values, idealLongArraySize);
            g0.o(copyOf2, "copyOf(this, newSize)");
            this.values = copyOf2;
        }
        this.keys[i9] = j6;
        this.values[i9] = e6;
        this.size = i9 + 1;
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
    public LongSparseArray<E> m25clone() {
        Object clone = super.clone();
        g0.n(clone, "null cannot be cast to non-null type androidx.collection.LongSparseArray<E of androidx.collection.LongSparseArray>");
        LongSparseArray<E> longSparseArray = (LongSparseArray) clone;
        longSparseArray.keys = (long[]) this.keys.clone();
        longSparseArray.values = (Object[]) this.values.clone();
        return longSparseArray;
    }

    @Deprecated(message = "Alias for `remove(key)`.", replaceWith = @ReplaceWith(expression = "remove(key)", imports = {}))
    public void delete(long j6) {
        int binarySearch = ContainerHelpersKt.binarySearch(this.keys, this.size, j6);
        if (binarySearch < 0 || this.values[binarySearch] == LongSparseArrayKt.DELETED) {
            return;
        }
        this.values[binarySearch] = LongSparseArrayKt.DELETED;
        this.garbage = true;
    }

    public int indexOfKey(long j6) {
        if (this.garbage) {
            int i6 = this.size;
            long[] jArr = this.keys;
            Object[] objArr = this.values;
            int i7 = 0;
            for (int i8 = 0; i8 < i6; i8++) {
                Object obj = objArr[i8];
                if (obj != LongSparseArrayKt.DELETED) {
                    if (i8 != i7) {
                        jArr[i7] = jArr[i8];
                        objArr[i7] = obj;
                        objArr[i8] = null;
                    }
                    i7++;
                }
            }
            this.garbage = false;
            this.size = i7;
        }
        return ContainerHelpersKt.binarySearch(this.keys, this.size, j6);
    }

    public int indexOfValue(E e6) {
        if (this.garbage) {
            int i6 = this.size;
            long[] jArr = this.keys;
            Object[] objArr = this.values;
            int i7 = 0;
            for (int i8 = 0; i8 < i6; i8++) {
                Object obj = objArr[i8];
                if (obj != LongSparseArrayKt.DELETED) {
                    if (i8 != i7) {
                        jArr[i7] = jArr[i8];
                        objArr[i7] = obj;
                        objArr[i8] = null;
                    }
                    i7++;
                }
            }
            this.garbage = false;
            this.size = i7;
        }
        int i9 = this.size;
        for (int i10 = 0; i10 < i9; i10++) {
            if (this.values[i10] == e6) {
                return i10;
            }
        }
        return -1;
    }

    public long keyAt(int i6) {
        int i7;
        if (i6 < 0 || i6 >= (i7 = this.size)) {
            throw new IllegalArgumentException(("Expected index to be within 0..size()-1, but was " + i6).toString());
        }
        if (this.garbage) {
            long[] jArr = this.keys;
            Object[] objArr = this.values;
            int i8 = 0;
            for (int i9 = 0; i9 < i7; i9++) {
                Object obj = objArr[i9];
                if (obj != LongSparseArrayKt.DELETED) {
                    if (i9 != i8) {
                        jArr[i8] = jArr[i9];
                        objArr[i8] = obj;
                        objArr[i9] = null;
                    }
                    i8++;
                }
            }
            this.garbage = false;
            this.size = i8;
        }
        return this.keys[i6];
    }

    public void put(long j6, E e6) {
        int binarySearch = ContainerHelpersKt.binarySearch(this.keys, this.size, j6);
        if (binarySearch >= 0) {
            this.values[binarySearch] = e6;
            return;
        }
        int i6 = ~binarySearch;
        if (i6 < this.size && this.values[i6] == LongSparseArrayKt.DELETED) {
            this.keys[i6] = j6;
            this.values[i6] = e6;
            return;
        }
        if (this.garbage) {
            int i7 = this.size;
            long[] jArr = this.keys;
            if (i7 >= jArr.length) {
                Object[] objArr = this.values;
                int i8 = 0;
                for (int i9 = 0; i9 < i7; i9++) {
                    Object obj = objArr[i9];
                    if (obj != LongSparseArrayKt.DELETED) {
                        if (i9 != i8) {
                            jArr[i8] = jArr[i9];
                            objArr[i8] = obj;
                            objArr[i9] = null;
                        }
                        i8++;
                    }
                }
                this.garbage = false;
                this.size = i8;
                i6 = ~ContainerHelpersKt.binarySearch(this.keys, i8, j6);
            }
        }
        int i10 = this.size;
        if (i10 >= this.keys.length) {
            int idealLongArraySize = ContainerHelpersKt.idealLongArraySize(i10 + 1);
            long[] copyOf = Arrays.copyOf(this.keys, idealLongArraySize);
            g0.o(copyOf, "copyOf(this, newSize)");
            this.keys = copyOf;
            Object[] copyOf2 = Arrays.copyOf(this.values, idealLongArraySize);
            g0.o(copyOf2, "copyOf(this, newSize)");
            this.values = copyOf2;
        }
        int i11 = this.size;
        if (i11 - i6 != 0) {
            long[] jArr2 = this.keys;
            int i12 = i6 + 1;
            n.A0(jArr2, jArr2, i12, i6, i11);
            Object[] objArr2 = this.values;
            n.B0(objArr2, objArr2, i12, i6, this.size);
        }
        this.keys[i6] = j6;
        this.values[i6] = e6;
        this.size++;
    }

    public void putAll(@NotNull LongSparseArray<? extends E> other) {
        g0.p(other, "other");
        int size = other.size();
        for (int i6 = 0; i6 < size; i6++) {
            put(other.keyAt(i6), other.valueAt(i6));
        }
    }

    public void removeAt(int i6) {
        if (this.values[i6] != LongSparseArrayKt.DELETED) {
            this.values[i6] = LongSparseArrayKt.DELETED;
            this.garbage = true;
        }
    }

    public void setValueAt(int i6, E e6) {
        int i7;
        if (i6 < 0 || i6 >= (i7 = this.size)) {
            throw new IllegalArgumentException(("Expected index to be within 0..size()-1, but was " + i6).toString());
        }
        if (this.garbage) {
            long[] jArr = this.keys;
            Object[] objArr = this.values;
            int i8 = 0;
            for (int i9 = 0; i9 < i7; i9++) {
                Object obj = objArr[i9];
                if (obj != LongSparseArrayKt.DELETED) {
                    if (i9 != i8) {
                        jArr[i8] = jArr[i9];
                        objArr[i8] = obj;
                        objArr[i9] = null;
                    }
                    i8++;
                }
            }
            this.garbage = false;
            this.size = i8;
        }
        this.values[i6] = e6;
    }

    public int size() {
        if (this.garbage) {
            int i6 = this.size;
            long[] jArr = this.keys;
            Object[] objArr = this.values;
            int i7 = 0;
            for (int i8 = 0; i8 < i6; i8++) {
                Object obj = objArr[i8];
                if (obj != LongSparseArrayKt.DELETED) {
                    if (i8 != i7) {
                        jArr[i7] = jArr[i8];
                        objArr[i7] = obj;
                        objArr[i8] = null;
                    }
                    i7++;
                }
            }
            this.garbage = false;
            this.size = i7;
        }
        return this.size;
    }

    public E valueAt(int i6) {
        int i7;
        if (i6 < 0 || i6 >= (i7 = this.size)) {
            throw new IllegalArgumentException(("Expected index to be within 0..size()-1, but was " + i6).toString());
        }
        if (this.garbage) {
            long[] jArr = this.keys;
            Object[] objArr = this.values;
            int i8 = 0;
            for (int i9 = 0; i9 < i7; i9++) {
                Object obj = objArr[i9];
                if (obj != LongSparseArrayKt.DELETED) {
                    if (i9 != i8) {
                        jArr[i8] = jArr[i9];
                        objArr[i8] = obj;
                        objArr[i9] = null;
                    }
                    i8++;
                }
            }
            this.garbage = false;
            this.size = i8;
        }
        return (E) this.values[i6];
    }

    public boolean containsKey(long j6) {
        if (indexOfKey(j6) >= 0) {
            return true;
        }
        return false;
    }

    public boolean containsValue(E e6) {
        if (indexOfValue(e6) >= 0) {
            return true;
        }
        return false;
    }

    public boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }

    @Nullable
    public E putIfAbsent(long j6, E e6) {
        E e7 = get(j6);
        if (e7 == null) {
            put(j6, e6);
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

    public E get(long j6, E e6) {
        int binarySearch = ContainerHelpersKt.binarySearch(this.keys, this.size, j6);
        return (binarySearch < 0 || this.values[binarySearch] == LongSparseArrayKt.DELETED) ? e6 : (E) this.values[binarySearch];
    }

    public boolean replace(long j6, E e6, E e7) {
        int indexOfKey = indexOfKey(j6);
        if (indexOfKey < 0 || !g0.g(this.values[indexOfKey], e6)) {
            return false;
        }
        this.values[indexOfKey] = e7;
        return true;
    }

    public boolean remove(long j6, E e6) {
        int indexOfKey = indexOfKey(j6);
        if (indexOfKey < 0 || !g0.g(e6, valueAt(indexOfKey))) {
            return false;
        }
        removeAt(indexOfKey);
        return true;
    }

    public /* synthetic */ LongSparseArray(int i6, int i7, v vVar) {
        this((i7 & 1) != 0 ? 10 : i6);
    }
}
