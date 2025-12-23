package androidx.collection;

import java.util.Iterator;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.collections.d1;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.g0;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class SparseArrayKt {
    public static final <T> boolean contains(@NotNull SparseArrayCompat<T> sparseArrayCompat, int i6) {
        g0.p(sparseArrayCompat, "<this>");
        return sparseArrayCompat.containsKey(i6);
    }

    public static final <T> void forEach(@NotNull SparseArrayCompat<T> sparseArrayCompat, @NotNull Function2<? super Integer, ? super T, n1> action) {
        g0.p(sparseArrayCompat, "<this>");
        g0.p(action, "action");
        int size = sparseArrayCompat.size();
        for (int i6 = 0; i6 < size; i6++) {
            action.invoke(Integer.valueOf(sparseArrayCompat.keyAt(i6)), sparseArrayCompat.valueAt(i6));
        }
    }

    public static final <T> T getOrDefault(@NotNull SparseArrayCompat<T> sparseArrayCompat, int i6, T t5) {
        g0.p(sparseArrayCompat, "<this>");
        return sparseArrayCompat.get(i6, t5);
    }

    public static final <T> T getOrElse(@NotNull SparseArrayCompat<T> sparseArrayCompat, int i6, @NotNull Function0<? extends T> defaultValue) {
        g0.p(sparseArrayCompat, "<this>");
        g0.p(defaultValue, "defaultValue");
        T t5 = sparseArrayCompat.get(i6);
        return t5 == null ? defaultValue.invoke() : t5;
    }

    public static final <T> int getSize(@NotNull SparseArrayCompat<T> sparseArrayCompat) {
        g0.p(sparseArrayCompat, "<this>");
        return sparseArrayCompat.size();
    }

    public static final <T> boolean isNotEmpty(@NotNull SparseArrayCompat<T> sparseArrayCompat) {
        g0.p(sparseArrayCompat, "<this>");
        return !sparseArrayCompat.isEmpty();
    }

    @NotNull
    public static final <T> d1 keyIterator(@NotNull final SparseArrayCompat<T> sparseArrayCompat) {
        g0.p(sparseArrayCompat, "<this>");
        return new d1() { // from class: androidx.collection.SparseArrayKt$keyIterator$1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < sparseArrayCompat.size();
            }

            @Override // kotlin.collections.d1
            public int nextInt() {
                SparseArrayCompat<T> sparseArrayCompat2 = sparseArrayCompat;
                int i6 = this.index;
                this.index = i6 + 1;
                return sparseArrayCompat2.keyAt(i6);
            }

            public final void setIndex(int i6) {
                this.index = i6;
            }
        };
    }

    @NotNull
    public static final <T> SparseArrayCompat<T> plus(@NotNull SparseArrayCompat<T> sparseArrayCompat, @NotNull SparseArrayCompat<T> other) {
        g0.p(sparseArrayCompat, "<this>");
        g0.p(other, "other");
        SparseArrayCompat<T> sparseArrayCompat2 = new SparseArrayCompat<>(sparseArrayCompat.size() + other.size());
        sparseArrayCompat2.putAll(sparseArrayCompat);
        sparseArrayCompat2.putAll(other);
        return sparseArrayCompat2;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Replaced with member function. Remove extension import!")
    public static final /* synthetic */ boolean remove(SparseArrayCompat sparseArrayCompat, int i6, Object obj) {
        g0.p(sparseArrayCompat, "<this>");
        return sparseArrayCompat.remove(i6, obj);
    }

    public static final <T> void set(@NotNull SparseArrayCompat<T> sparseArrayCompat, int i6, T t5) {
        g0.p(sparseArrayCompat, "<this>");
        sparseArrayCompat.put(i6, t5);
    }

    @NotNull
    public static final <T> Iterator<T> valueIterator(@NotNull SparseArrayCompat<T> sparseArrayCompat) {
        g0.p(sparseArrayCompat, "<this>");
        return new SparseArrayKt$valueIterator$1(sparseArrayCompat);
    }
}
