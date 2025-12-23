package androidx.core.util;

import android.util.SparseBooleanArray;
import kotlin.collections.c0;
import kotlin.collections.d1;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nSparseBooleanArray.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SparseBooleanArray.kt\nandroidx/core/util/SparseBooleanArrayKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,95:1\n77#1,4:97\n1#2:96\n*S KotlinDebug\n*F\n+ 1 SparseBooleanArray.kt\nandroidx/core/util/SparseBooleanArrayKt\n*L\n73#1:97,4\n*E\n"})
/* loaded from: D:\Downloads\app\classes.dex */
public final class SparseBooleanArrayKt {
    @NotNull
    public static final d1 keyIterator(@NotNull final SparseBooleanArray sparseBooleanArray) {
        return new d1() { // from class: androidx.core.util.SparseBooleanArrayKt$keyIterator$1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < sparseBooleanArray.size();
            }

            @Override // kotlin.collections.d1
            public int nextInt() {
                SparseBooleanArray sparseBooleanArray2 = sparseBooleanArray;
                int i6 = this.index;
                this.index = i6 + 1;
                return sparseBooleanArray2.keyAt(i6);
            }

            public final void setIndex(int i6) {
                this.index = i6;
            }
        };
    }

    @NotNull
    public static final SparseBooleanArray plus(@NotNull SparseBooleanArray sparseBooleanArray, @NotNull SparseBooleanArray sparseBooleanArray2) {
        SparseBooleanArray sparseBooleanArray3 = new SparseBooleanArray(sparseBooleanArray.size() + sparseBooleanArray2.size());
        putAll(sparseBooleanArray3, sparseBooleanArray);
        putAll(sparseBooleanArray3, sparseBooleanArray2);
        return sparseBooleanArray3;
    }

    @NotNull
    public static final c0 valueIterator(@NotNull final SparseBooleanArray sparseBooleanArray) {
        return new c0() { // from class: androidx.core.util.SparseBooleanArrayKt$valueIterator$1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < sparseBooleanArray.size();
            }

            @Override // kotlin.collections.c0
            public boolean nextBoolean() {
                SparseBooleanArray sparseBooleanArray2 = sparseBooleanArray;
                int i6 = this.index;
                this.index = i6 + 1;
                return sparseBooleanArray2.valueAt(i6);
            }

            public final void setIndex(int i6) {
                this.index = i6;
            }
        };
    }

    public static final boolean contains(@NotNull SparseBooleanArray sparseBooleanArray, int i6) {
        if (sparseBooleanArray.indexOfKey(i6) >= 0) {
            return true;
        }
        return false;
    }

    public static final boolean containsKey(@NotNull SparseBooleanArray sparseBooleanArray, int i6) {
        if (sparseBooleanArray.indexOfKey(i6) >= 0) {
            return true;
        }
        return false;
    }

    public static final boolean containsValue(@NotNull SparseBooleanArray sparseBooleanArray, boolean z5) {
        if (sparseBooleanArray.indexOfValue(z5) >= 0) {
            return true;
        }
        return false;
    }

    public static final void forEach(@NotNull SparseBooleanArray sparseBooleanArray, @NotNull Function2<? super Integer, ? super Boolean, n1> function2) {
        int size = sparseBooleanArray.size();
        for (int i6 = 0; i6 < size; i6++) {
            function2.invoke(Integer.valueOf(sparseBooleanArray.keyAt(i6)), Boolean.valueOf(sparseBooleanArray.valueAt(i6)));
        }
    }

    public static final boolean getOrDefault(@NotNull SparseBooleanArray sparseBooleanArray, int i6, boolean z5) {
        return sparseBooleanArray.get(i6, z5);
    }

    public static final boolean getOrElse(@NotNull SparseBooleanArray sparseBooleanArray, int i6, @NotNull Function0<Boolean> function0) {
        int indexOfKey = sparseBooleanArray.indexOfKey(i6);
        if (indexOfKey >= 0) {
            return sparseBooleanArray.valueAt(indexOfKey);
        }
        return function0.invoke().booleanValue();
    }

    public static final int getSize(@NotNull SparseBooleanArray sparseBooleanArray) {
        return sparseBooleanArray.size();
    }

    public static final boolean isEmpty(@NotNull SparseBooleanArray sparseBooleanArray) {
        if (sparseBooleanArray.size() == 0) {
            return true;
        }
        return false;
    }

    public static final boolean isNotEmpty(@NotNull SparseBooleanArray sparseBooleanArray) {
        if (sparseBooleanArray.size() != 0) {
            return true;
        }
        return false;
    }

    public static final void putAll(@NotNull SparseBooleanArray sparseBooleanArray, @NotNull SparseBooleanArray sparseBooleanArray2) {
        int size = sparseBooleanArray2.size();
        for (int i6 = 0; i6 < size; i6++) {
            sparseBooleanArray.put(sparseBooleanArray2.keyAt(i6), sparseBooleanArray2.valueAt(i6));
        }
    }

    public static final boolean remove(@NotNull SparseBooleanArray sparseBooleanArray, int i6, boolean z5) {
        int indexOfKey = sparseBooleanArray.indexOfKey(i6);
        if (indexOfKey >= 0 && z5 == sparseBooleanArray.valueAt(indexOfKey)) {
            sparseBooleanArray.delete(i6);
            return true;
        }
        return false;
    }

    public static final void set(@NotNull SparseBooleanArray sparseBooleanArray, int i6, boolean z5) {
        sparseBooleanArray.put(i6, z5);
    }
}
