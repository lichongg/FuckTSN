package androidx.core.util;

import android.util.SparseArray;
import java.util.Iterator;
import kotlin.collections.d1;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nSparseArray.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SparseArray.kt\nandroidx/core/util/SparseArrayKt\n*L\n1#1,94:1\n76#1,4:95\n*S KotlinDebug\n*F\n+ 1 SparseArray.kt\nandroidx/core/util/SparseArrayKt\n*L\n72#1:95,4\n*E\n"})
/* loaded from: D:\Downloads\app\classes.dex */
public final class SparseArrayKt {
    @NotNull
    public static final <T> d1 keyIterator(@NotNull final SparseArray<T> sparseArray) {
        return new d1() { // from class: androidx.core.util.SparseArrayKt$keyIterator$1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < sparseArray.size();
            }

            @Override // kotlin.collections.d1
            public int nextInt() {
                SparseArray<T> sparseArray2 = sparseArray;
                int i6 = this.index;
                this.index = i6 + 1;
                return sparseArray2.keyAt(i6);
            }

            public final void setIndex(int i6) {
                this.index = i6;
            }
        };
    }

    @NotNull
    public static final <T> SparseArray<T> plus(@NotNull SparseArray<T> sparseArray, @NotNull SparseArray<T> sparseArray2) {
        SparseArray<T> sparseArray3 = new SparseArray<>(sparseArray.size() + sparseArray2.size());
        putAll(sparseArray3, sparseArray);
        putAll(sparseArray3, sparseArray2);
        return sparseArray3;
    }

    @NotNull
    public static final <T> Iterator<T> valueIterator(@NotNull SparseArray<T> sparseArray) {
        return new SparseArrayKt$valueIterator$1(sparseArray);
    }

    public static final <T> boolean contains(@NotNull SparseArray<T> sparseArray, int i6) {
        if (sparseArray.indexOfKey(i6) >= 0) {
            return true;
        }
        return false;
    }

    public static final <T> boolean containsKey(@NotNull SparseArray<T> sparseArray, int i6) {
        if (sparseArray.indexOfKey(i6) >= 0) {
            return true;
        }
        return false;
    }

    public static final <T> boolean containsValue(@NotNull SparseArray<T> sparseArray, T t5) {
        if (sparseArray.indexOfValue(t5) >= 0) {
            return true;
        }
        return false;
    }

    public static final <T> void forEach(@NotNull SparseArray<T> sparseArray, @NotNull Function2<? super Integer, ? super T, n1> function2) {
        int size = sparseArray.size();
        for (int i6 = 0; i6 < size; i6++) {
            function2.invoke(Integer.valueOf(sparseArray.keyAt(i6)), sparseArray.valueAt(i6));
        }
    }

    public static final <T> T getOrDefault(@NotNull SparseArray<T> sparseArray, int i6, T t5) {
        T t6 = sparseArray.get(i6);
        if (t6 == null) {
            return t5;
        }
        return t6;
    }

    public static final <T> T getOrElse(@NotNull SparseArray<T> sparseArray, int i6, @NotNull Function0<? extends T> function0) {
        T t5 = sparseArray.get(i6);
        if (t5 == null) {
            return function0.invoke();
        }
        return t5;
    }

    public static final <T> int getSize(@NotNull SparseArray<T> sparseArray) {
        return sparseArray.size();
    }

    public static final <T> boolean isEmpty(@NotNull SparseArray<T> sparseArray) {
        if (sparseArray.size() == 0) {
            return true;
        }
        return false;
    }

    public static final <T> boolean isNotEmpty(@NotNull SparseArray<T> sparseArray) {
        if (sparseArray.size() != 0) {
            return true;
        }
        return false;
    }

    public static final <T> void putAll(@NotNull SparseArray<T> sparseArray, @NotNull SparseArray<T> sparseArray2) {
        int size = sparseArray2.size();
        for (int i6 = 0; i6 < size; i6++) {
            sparseArray.put(sparseArray2.keyAt(i6), sparseArray2.valueAt(i6));
        }
    }

    public static final <T> boolean remove(@NotNull SparseArray<T> sparseArray, int i6, T t5) {
        int indexOfKey = sparseArray.indexOfKey(i6);
        if (indexOfKey >= 0 && g0.g(t5, sparseArray.valueAt(indexOfKey))) {
            sparseArray.removeAt(indexOfKey);
            return true;
        }
        return false;
    }

    public static final <T> void set(@NotNull SparseArray<T> sparseArray, int i6, T t5) {
        sparseArray.put(i6, t5);
    }
}
