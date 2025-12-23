package androidx.core.util;

import android.util.SparseLongArray;
import kotlin.collections.d1;
import kotlin.collections.e1;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nSparseLongArray.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SparseLongArray.kt\nandroidx/core/util/SparseLongArrayKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,93:1\n75#1,4:95\n1#2:94\n*S KotlinDebug\n*F\n+ 1 SparseLongArray.kt\nandroidx/core/util/SparseLongArrayKt\n*L\n71#1:95,4\n*E\n"})
/* loaded from: D:\Downloads\app\classes.dex */
public final class SparseLongArrayKt {
    @NotNull
    public static final d1 keyIterator(@NotNull final SparseLongArray sparseLongArray) {
        return new d1() { // from class: androidx.core.util.SparseLongArrayKt$keyIterator$1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < sparseLongArray.size();
            }

            @Override // kotlin.collections.d1
            public int nextInt() {
                SparseLongArray sparseLongArray2 = sparseLongArray;
                int i6 = this.index;
                this.index = i6 + 1;
                return sparseLongArray2.keyAt(i6);
            }

            public final void setIndex(int i6) {
                this.index = i6;
            }
        };
    }

    @NotNull
    public static final SparseLongArray plus(@NotNull SparseLongArray sparseLongArray, @NotNull SparseLongArray sparseLongArray2) {
        SparseLongArray sparseLongArray3 = new SparseLongArray(sparseLongArray.size() + sparseLongArray2.size());
        putAll(sparseLongArray3, sparseLongArray);
        putAll(sparseLongArray3, sparseLongArray2);
        return sparseLongArray3;
    }

    @NotNull
    public static final e1 valueIterator(@NotNull final SparseLongArray sparseLongArray) {
        return new e1() { // from class: androidx.core.util.SparseLongArrayKt$valueIterator$1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < sparseLongArray.size();
            }

            @Override // kotlin.collections.e1
            public long nextLong() {
                SparseLongArray sparseLongArray2 = sparseLongArray;
                int i6 = this.index;
                this.index = i6 + 1;
                return sparseLongArray2.valueAt(i6);
            }

            public final void setIndex(int i6) {
                this.index = i6;
            }
        };
    }

    public static final boolean contains(@NotNull SparseLongArray sparseLongArray, int i6) {
        if (sparseLongArray.indexOfKey(i6) >= 0) {
            return true;
        }
        return false;
    }

    public static final boolean containsKey(@NotNull SparseLongArray sparseLongArray, int i6) {
        if (sparseLongArray.indexOfKey(i6) >= 0) {
            return true;
        }
        return false;
    }

    public static final boolean containsValue(@NotNull SparseLongArray sparseLongArray, long j6) {
        if (sparseLongArray.indexOfValue(j6) >= 0) {
            return true;
        }
        return false;
    }

    public static final void forEach(@NotNull SparseLongArray sparseLongArray, @NotNull Function2<? super Integer, ? super Long, n1> function2) {
        int size = sparseLongArray.size();
        for (int i6 = 0; i6 < size; i6++) {
            function2.invoke(Integer.valueOf(sparseLongArray.keyAt(i6)), Long.valueOf(sparseLongArray.valueAt(i6)));
        }
    }

    public static final long getOrDefault(@NotNull SparseLongArray sparseLongArray, int i6, long j6) {
        return sparseLongArray.get(i6, j6);
    }

    public static final long getOrElse(@NotNull SparseLongArray sparseLongArray, int i6, @NotNull Function0<Long> function0) {
        int indexOfKey = sparseLongArray.indexOfKey(i6);
        if (indexOfKey >= 0) {
            return sparseLongArray.valueAt(indexOfKey);
        }
        return function0.invoke().longValue();
    }

    public static final int getSize(@NotNull SparseLongArray sparseLongArray) {
        return sparseLongArray.size();
    }

    public static final boolean isEmpty(@NotNull SparseLongArray sparseLongArray) {
        if (sparseLongArray.size() == 0) {
            return true;
        }
        return false;
    }

    public static final boolean isNotEmpty(@NotNull SparseLongArray sparseLongArray) {
        if (sparseLongArray.size() != 0) {
            return true;
        }
        return false;
    }

    public static final void putAll(@NotNull SparseLongArray sparseLongArray, @NotNull SparseLongArray sparseLongArray2) {
        int size = sparseLongArray2.size();
        for (int i6 = 0; i6 < size; i6++) {
            sparseLongArray.put(sparseLongArray2.keyAt(i6), sparseLongArray2.valueAt(i6));
        }
    }

    public static final boolean remove(@NotNull SparseLongArray sparseLongArray, int i6, long j6) {
        int indexOfKey = sparseLongArray.indexOfKey(i6);
        if (indexOfKey >= 0 && j6 == sparseLongArray.valueAt(indexOfKey)) {
            sparseLongArray.removeAt(indexOfKey);
            return true;
        }
        return false;
    }

    public static final void set(@NotNull SparseLongArray sparseLongArray, int i6, long j6) {
        sparseLongArray.put(i6, j6);
    }
}
