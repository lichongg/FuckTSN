package androidx.core.util;

import android.util.LongSparseArray;
import java.util.Iterator;
import kotlin.collections.e1;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nLongSparseArray.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LongSparseArray.kt\nandroidx/core/util/LongSparseArrayKt\n*L\n1#1,99:1\n77#1,4:100\n*S KotlinDebug\n*F\n+ 1 LongSparseArray.kt\nandroidx/core/util/LongSparseArrayKt\n*L\n73#1:100,4\n*E\n"})
/* loaded from: D:\Downloads\app\classes.dex */
public final class LongSparseArrayKt {
    @NotNull
    public static final <T> e1 keyIterator(@NotNull final LongSparseArray<T> longSparseArray) {
        return new e1() { // from class: androidx.core.util.LongSparseArrayKt$keyIterator$1
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
    public static final <T> LongSparseArray<T> plus(@NotNull LongSparseArray<T> longSparseArray, @NotNull LongSparseArray<T> longSparseArray2) {
        LongSparseArray<T> longSparseArray3 = new LongSparseArray<>(longSparseArray.size() + longSparseArray2.size());
        putAll(longSparseArray3, longSparseArray);
        putAll(longSparseArray3, longSparseArray2);
        return longSparseArray3;
    }

    @NotNull
    public static final <T> Iterator<T> valueIterator(@NotNull LongSparseArray<T> longSparseArray) {
        return new LongSparseArrayKt$valueIterator$1(longSparseArray);
    }

    public static final <T> boolean contains(@NotNull LongSparseArray<T> longSparseArray, long j6) {
        if (longSparseArray.indexOfKey(j6) >= 0) {
            return true;
        }
        return false;
    }

    public static final <T> boolean containsKey(@NotNull LongSparseArray<T> longSparseArray, long j6) {
        if (longSparseArray.indexOfKey(j6) >= 0) {
            return true;
        }
        return false;
    }

    public static final <T> boolean containsValue(@NotNull LongSparseArray<T> longSparseArray, T t5) {
        if (longSparseArray.indexOfValue(t5) >= 0) {
            return true;
        }
        return false;
    }

    public static final <T> void forEach(@NotNull LongSparseArray<T> longSparseArray, @NotNull Function2<? super Long, ? super T, n1> function2) {
        int size = longSparseArray.size();
        for (int i6 = 0; i6 < size; i6++) {
            function2.invoke(Long.valueOf(longSparseArray.keyAt(i6)), longSparseArray.valueAt(i6));
        }
    }

    public static final <T> T getOrDefault(@NotNull LongSparseArray<T> longSparseArray, long j6, T t5) {
        T t6 = longSparseArray.get(j6);
        if (t6 == null) {
            return t5;
        }
        return t6;
    }

    public static final <T> T getOrElse(@NotNull LongSparseArray<T> longSparseArray, long j6, @NotNull Function0<? extends T> function0) {
        T t5 = longSparseArray.get(j6);
        if (t5 == null) {
            return function0.invoke();
        }
        return t5;
    }

    public static final <T> int getSize(@NotNull LongSparseArray<T> longSparseArray) {
        return longSparseArray.size();
    }

    public static final <T> boolean isEmpty(@NotNull LongSparseArray<T> longSparseArray) {
        if (longSparseArray.size() == 0) {
            return true;
        }
        return false;
    }

    public static final <T> boolean isNotEmpty(@NotNull LongSparseArray<T> longSparseArray) {
        if (longSparseArray.size() != 0) {
            return true;
        }
        return false;
    }

    public static final <T> void putAll(@NotNull LongSparseArray<T> longSparseArray, @NotNull LongSparseArray<T> longSparseArray2) {
        int size = longSparseArray2.size();
        for (int i6 = 0; i6 < size; i6++) {
            longSparseArray.put(longSparseArray2.keyAt(i6), longSparseArray2.valueAt(i6));
        }
    }

    public static final <T> boolean remove(@NotNull LongSparseArray<T> longSparseArray, long j6, T t5) {
        int indexOfKey = longSparseArray.indexOfKey(j6);
        if (indexOfKey >= 0 && g0.g(t5, longSparseArray.valueAt(indexOfKey))) {
            longSparseArray.removeAt(indexOfKey);
            return true;
        }
        return false;
    }

    public static final <T> void set(@NotNull LongSparseArray<T> longSparseArray, long j6, T t5) {
        longSparseArray.put(j6, t5);
    }
}
