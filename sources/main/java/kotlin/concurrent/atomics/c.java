package kotlin.concurrent.atomics;

import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicLongArray;
import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
class c extends b {
    @ExperimentalAtomicApi
    @SinceKotlin(version = "2.2")
    @InlineOnly
    private static final <T> void A(AtomicReferenceArray<T> atomicReferenceArray, int i6, Function1<? super T, ? extends T> transform) {
        T t5;
        g0.p(atomicReferenceArray, "<this>");
        g0.p(transform, "transform");
        do {
            t5 = atomicReferenceArray.get(i6);
        } while (!com.google.common.util.concurrent.b.a(atomicReferenceArray, i6, t5, transform.invoke(t5)));
    }

    @ExperimentalAtomicApi
    @SinceKotlin(version = "2.1")
    @NotNull
    public static final AtomicIntegerArray m(@NotNull AtomicIntegerArray atomicIntegerArray) {
        g0.p(atomicIntegerArray, "<this>");
        return atomicIntegerArray;
    }

    @ExperimentalAtomicApi
    @SinceKotlin(version = "2.1")
    @NotNull
    public static final AtomicLongArray n(@NotNull AtomicLongArray atomicLongArray) {
        g0.p(atomicLongArray, "<this>");
        return atomicLongArray;
    }

    @ExperimentalAtomicApi
    @SinceKotlin(version = "2.1")
    @NotNull
    public static final <T> AtomicReferenceArray<T> o(@NotNull AtomicReferenceArray<T> atomicReferenceArray) {
        g0.p(atomicReferenceArray, "<this>");
        return atomicReferenceArray;
    }

    @ExperimentalAtomicApi
    @SinceKotlin(version = "2.1")
    @NotNull
    public static final AtomicIntegerArray p(@NotNull AtomicIntegerArray atomicIntegerArray) {
        g0.p(atomicIntegerArray, "<this>");
        return atomicIntegerArray;
    }

    @ExperimentalAtomicApi
    @SinceKotlin(version = "2.1")
    @NotNull
    public static final AtomicLongArray q(@NotNull AtomicLongArray atomicLongArray) {
        g0.p(atomicLongArray, "<this>");
        return atomicLongArray;
    }

    @ExperimentalAtomicApi
    @SinceKotlin(version = "2.1")
    @NotNull
    public static final <T> AtomicReferenceArray<T> r(@NotNull AtomicReferenceArray<T> atomicReferenceArray) {
        g0.p(atomicReferenceArray, "<this>");
        return atomicReferenceArray;
    }

    @ExperimentalAtomicApi
    @SinceKotlin(version = "2.2")
    @InlineOnly
    private static final int s(AtomicIntegerArray atomicIntegerArray, int i6, Function1<? super Integer, Integer> transform) {
        int i7;
        g0.p(atomicIntegerArray, "<this>");
        g0.p(transform, "transform");
        do {
            i7 = atomicIntegerArray.get(i6);
        } while (!atomicIntegerArray.compareAndSet(i6, i7, transform.invoke(Integer.valueOf(i7)).intValue()));
        return i7;
    }

    @ExperimentalAtomicApi
    @SinceKotlin(version = "2.2")
    @InlineOnly
    private static final long t(AtomicLongArray atomicLongArray, int i6, Function1<? super Long, Long> transform) {
        g0.p(atomicLongArray, "<this>");
        g0.p(transform, "transform");
        while (true) {
            long j6 = atomicLongArray.get(i6);
            AtomicLongArray atomicLongArray2 = atomicLongArray;
            int i7 = i6;
            if (atomicLongArray2.compareAndSet(i7, j6, transform.invoke(Long.valueOf(j6)).longValue())) {
                return j6;
            }
            atomicLongArray = atomicLongArray2;
            i6 = i7;
        }
    }

    @ExperimentalAtomicApi
    @SinceKotlin(version = "2.2")
    @InlineOnly
    private static final <T> T u(AtomicReferenceArray<T> atomicReferenceArray, int i6, Function1<? super T, ? extends T> transform) {
        T t5;
        g0.p(atomicReferenceArray, "<this>");
        g0.p(transform, "transform");
        do {
            t5 = atomicReferenceArray.get(i6);
        } while (!com.google.common.util.concurrent.b.a(atomicReferenceArray, i6, t5, transform.invoke(t5)));
        return t5;
    }

    @ExperimentalAtomicApi
    @SinceKotlin(version = "2.2")
    @InlineOnly
    private static final int v(AtomicIntegerArray atomicIntegerArray, int i6, Function1<? super Integer, Integer> transform) {
        int i7;
        int intValue;
        g0.p(atomicIntegerArray, "<this>");
        g0.p(transform, "transform");
        do {
            i7 = atomicIntegerArray.get(i6);
            intValue = transform.invoke(Integer.valueOf(i7)).intValue();
        } while (!atomicIntegerArray.compareAndSet(i6, i7, intValue));
        return intValue;
    }

    @ExperimentalAtomicApi
    @SinceKotlin(version = "2.2")
    @InlineOnly
    private static final long w(AtomicLongArray atomicLongArray, int i6, Function1<? super Long, Long> transform) {
        g0.p(atomicLongArray, "<this>");
        g0.p(transform, "transform");
        while (true) {
            long j6 = atomicLongArray.get(i6);
            long longValue = transform.invoke(Long.valueOf(j6)).longValue();
            AtomicLongArray atomicLongArray2 = atomicLongArray;
            int i7 = i6;
            if (atomicLongArray2.compareAndSet(i7, j6, longValue)) {
                return longValue;
            }
            atomicLongArray = atomicLongArray2;
            i6 = i7;
        }
    }

    @ExperimentalAtomicApi
    @SinceKotlin(version = "2.2")
    @InlineOnly
    private static final <T> T x(AtomicReferenceArray<T> atomicReferenceArray, int i6, Function1<? super T, ? extends T> transform) {
        T t5;
        T invoke;
        g0.p(atomicReferenceArray, "<this>");
        g0.p(transform, "transform");
        do {
            t5 = atomicReferenceArray.get(i6);
            invoke = transform.invoke(t5);
        } while (!com.google.common.util.concurrent.b.a(atomicReferenceArray, i6, t5, invoke));
        return invoke;
    }

    @ExperimentalAtomicApi
    @SinceKotlin(version = "2.2")
    @InlineOnly
    private static final void y(AtomicIntegerArray atomicIntegerArray, int i6, Function1<? super Integer, Integer> transform) {
        int i7;
        g0.p(atomicIntegerArray, "<this>");
        g0.p(transform, "transform");
        do {
            i7 = atomicIntegerArray.get(i6);
        } while (!atomicIntegerArray.compareAndSet(i6, i7, transform.invoke(Integer.valueOf(i7)).intValue()));
    }

    @ExperimentalAtomicApi
    @SinceKotlin(version = "2.2")
    @InlineOnly
    private static final void z(AtomicLongArray atomicLongArray, int i6, Function1<? super Long, Long> transform) {
        g0.p(atomicLongArray, "<this>");
        g0.p(transform, "transform");
        while (true) {
            long j6 = atomicLongArray.get(i6);
            AtomicLongArray atomicLongArray2 = atomicLongArray;
            int i7 = i6;
            if (atomicLongArray2.compareAndSet(i7, j6, transform.invoke(Long.valueOf(j6)).longValue())) {
                return;
            }
            atomicLongArray = atomicLongArray2;
            i6 = i7;
        }
    }
}
