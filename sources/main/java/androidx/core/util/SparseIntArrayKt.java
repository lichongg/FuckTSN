package androidx.core.util;

import android.util.SparseIntArray;
import kotlin.collections.d1;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nSparseIntArray.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SparseIntArray.kt\nandroidx/core/util/SparseIntArrayKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,93:1\n75#1,4:95\n1#2:94\n*S KotlinDebug\n*F\n+ 1 SparseIntArray.kt\nandroidx/core/util/SparseIntArrayKt\n*L\n71#1:95,4\n*E\n"})
/* loaded from: D:\Downloads\app\classes.dex */
public final class SparseIntArrayKt {
    @NotNull
    public static final d1 keyIterator(@NotNull final SparseIntArray sparseIntArray) {
        return new d1() { // from class: androidx.core.util.SparseIntArrayKt$keyIterator$1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < sparseIntArray.size();
            }

            @Override // kotlin.collections.d1
            public int nextInt() {
                SparseIntArray sparseIntArray2 = sparseIntArray;
                int i6 = this.index;
                this.index = i6 + 1;
                return sparseIntArray2.keyAt(i6);
            }

            public final void setIndex(int i6) {
                this.index = i6;
            }
        };
    }

    @NotNull
    public static final SparseIntArray plus(@NotNull SparseIntArray sparseIntArray, @NotNull SparseIntArray sparseIntArray2) {
        SparseIntArray sparseIntArray3 = new SparseIntArray(sparseIntArray.size() + sparseIntArray2.size());
        putAll(sparseIntArray3, sparseIntArray);
        putAll(sparseIntArray3, sparseIntArray2);
        return sparseIntArray3;
    }

    @NotNull
    public static final d1 valueIterator(@NotNull final SparseIntArray sparseIntArray) {
        return new d1() { // from class: androidx.core.util.SparseIntArrayKt$valueIterator$1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < sparseIntArray.size();
            }

            @Override // kotlin.collections.d1
            public int nextInt() {
                SparseIntArray sparseIntArray2 = sparseIntArray;
                int i6 = this.index;
                this.index = i6 + 1;
                return sparseIntArray2.valueAt(i6);
            }

            public final void setIndex(int i6) {
                this.index = i6;
            }
        };
    }

    public static final boolean contains(@NotNull SparseIntArray sparseIntArray, int i6) {
        if (sparseIntArray.indexOfKey(i6) >= 0) {
            return true;
        }
        return false;
    }

    public static final boolean containsKey(@NotNull SparseIntArray sparseIntArray, int i6) {
        if (sparseIntArray.indexOfKey(i6) >= 0) {
            return true;
        }
        return false;
    }

    public static final boolean containsValue(@NotNull SparseIntArray sparseIntArray, int i6) {
        if (sparseIntArray.indexOfValue(i6) >= 0) {
            return true;
        }
        return false;
    }

    public static final void forEach(@NotNull SparseIntArray sparseIntArray, @NotNull Function2<? super Integer, ? super Integer, n1> function2) {
        int size = sparseIntArray.size();
        for (int i6 = 0; i6 < size; i6++) {
            function2.invoke(Integer.valueOf(sparseIntArray.keyAt(i6)), Integer.valueOf(sparseIntArray.valueAt(i6)));
        }
    }

    public static final int getOrDefault(@NotNull SparseIntArray sparseIntArray, int i6, int i7) {
        return sparseIntArray.get(i6, i7);
    }

    public static final int getOrElse(@NotNull SparseIntArray sparseIntArray, int i6, @NotNull Function0<Integer> function0) {
        int indexOfKey = sparseIntArray.indexOfKey(i6);
        if (indexOfKey >= 0) {
            return sparseIntArray.valueAt(indexOfKey);
        }
        return function0.invoke().intValue();
    }

    public static final int getSize(@NotNull SparseIntArray sparseIntArray) {
        return sparseIntArray.size();
    }

    public static final boolean isEmpty(@NotNull SparseIntArray sparseIntArray) {
        if (sparseIntArray.size() == 0) {
            return true;
        }
        return false;
    }

    public static final boolean isNotEmpty(@NotNull SparseIntArray sparseIntArray) {
        if (sparseIntArray.size() != 0) {
            return true;
        }
        return false;
    }

    public static final void putAll(@NotNull SparseIntArray sparseIntArray, @NotNull SparseIntArray sparseIntArray2) {
        int size = sparseIntArray2.size();
        for (int i6 = 0; i6 < size; i6++) {
            sparseIntArray.put(sparseIntArray2.keyAt(i6), sparseIntArray2.valueAt(i6));
        }
    }

    public static final boolean remove(@NotNull SparseIntArray sparseIntArray, int i6, int i7) {
        int indexOfKey = sparseIntArray.indexOfKey(i6);
        if (indexOfKey >= 0 && i7 == sparseIntArray.valueAt(indexOfKey)) {
            sparseIntArray.removeAt(indexOfKey);
            return true;
        }
        return false;
    }

    public static final void set(@NotNull SparseIntArray sparseIntArray, int i6, int i7) {
        sparseIntArray.put(i6, i7);
    }
}
