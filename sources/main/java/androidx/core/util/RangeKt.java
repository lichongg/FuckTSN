package androidx.core.util;

import android.annotation.SuppressLint;
import android.util.Range;
import androidx.annotation.RequiresApi;
import kotlin.ranges.h;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SuppressLint({"ClassVerificationFailure"})
/* loaded from: D:\Downloads\app\classes.dex */
public final class RangeKt {
    @RequiresApi(21)
    @NotNull
    public static final <T extends Comparable<? super T>> Range<T> plus(@NotNull Range<T> range, @NotNull T t5) {
        return range.extend((Range<T>) t5);
    }

    @RequiresApi(21)
    @NotNull
    public static final <T extends Comparable<? super T>> Range<T> plus(@NotNull Range<T> range, @NotNull Range<T> range2) {
        return range.extend(range2);
    }

    @RequiresApi(21)
    @NotNull
    public static final <T extends Comparable<? super T>> Range<T> rangeTo(@NotNull T t5, @NotNull T t6) {
        return new Range<>(t5, t6);
    }

    @RequiresApi(21)
    @NotNull
    public static final <T extends Comparable<? super T>> kotlin.ranges.h<T> toClosedRange(@NotNull final Range<T> range) {
        return (kotlin.ranges.h<T>) new kotlin.ranges.h<T>() { // from class: androidx.core.util.RangeKt$toClosedRange$1
            /* JADX WARN: Incorrect return type in method signature: ()TT; */
            @Override // kotlin.ranges.h
            public Comparable getEndInclusive() {
                return range.getUpper();
            }

            /* JADX WARN: Incorrect return type in method signature: ()TT; */
            @Override // kotlin.ranges.h
            public Comparable getStart() {
                return range.getLower();
            }

            /* JADX WARN: Incorrect types in method signature: (TT;)Z */
            @Override // kotlin.ranges.h
            public boolean contains(@NotNull Comparable comparable) {
                return h.a.a(this, comparable);
            }

            @Override // kotlin.ranges.h
            public boolean isEmpty() {
                return h.a.b(this);
            }
        };
    }

    @RequiresApi(21)
    @NotNull
    public static final <T extends Comparable<? super T>> Range<T> toRange(@NotNull kotlin.ranges.h<T> hVar) {
        return new Range<>(hVar.getStart(), hVar.getEndInclusive());
    }

    @RequiresApi(21)
    @NotNull
    public static final <T extends Comparable<? super T>> Range<T> and(@NotNull Range<T> range, @NotNull Range<T> range2) {
        return range.intersect(range2);
    }
}
