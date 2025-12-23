package kotlin.concurrent.atomics;

import androidx.camera.view.p;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
class f extends e {
    @ExperimentalAtomicApi
    @SinceKotlin(version = "2.2")
    @InlineOnly
    private static final void update(AtomicInteger atomicInteger, Function1<? super Integer, Integer> transform) {
        int i6;
        g0.p(atomicInteger, "<this>");
        g0.p(transform, "transform");
        do {
            i6 = atomicInteger.get();
        } while (!atomicInteger.compareAndSet(i6, transform.invoke(Integer.valueOf(i6)).intValue()));
    }

    @ExperimentalAtomicApi
    @SinceKotlin(version = "2.1")
    @NotNull
    public static final AtomicBoolean m(@NotNull AtomicBoolean atomicBoolean) {
        g0.p(atomicBoolean, "<this>");
        return atomicBoolean;
    }

    @ExperimentalAtomicApi
    @SinceKotlin(version = "2.1")
    @NotNull
    public static final AtomicInteger n(@NotNull AtomicInteger atomicInteger) {
        g0.p(atomicInteger, "<this>");
        return atomicInteger;
    }

    @ExperimentalAtomicApi
    @SinceKotlin(version = "2.1")
    @NotNull
    public static final AtomicLong o(@NotNull AtomicLong atomicLong) {
        g0.p(atomicLong, "<this>");
        return atomicLong;
    }

    @ExperimentalAtomicApi
    @SinceKotlin(version = "2.1")
    @NotNull
    public static final <T> AtomicReference<T> p(@NotNull AtomicReference<T> atomicReference) {
        g0.p(atomicReference, "<this>");
        return atomicReference;
    }

    @ExperimentalAtomicApi
    @SinceKotlin(version = "2.1")
    @NotNull
    public static final AtomicBoolean q(@NotNull AtomicBoolean atomicBoolean) {
        g0.p(atomicBoolean, "<this>");
        return atomicBoolean;
    }

    @ExperimentalAtomicApi
    @SinceKotlin(version = "2.1")
    @NotNull
    public static final AtomicInteger r(@NotNull AtomicInteger atomicInteger) {
        g0.p(atomicInteger, "<this>");
        return atomicInteger;
    }

    @ExperimentalAtomicApi
    @SinceKotlin(version = "2.1")
    @NotNull
    public static final AtomicLong s(@NotNull AtomicLong atomicLong) {
        g0.p(atomicLong, "<this>");
        return atomicLong;
    }

    @ExperimentalAtomicApi
    @SinceKotlin(version = "2.1")
    @NotNull
    public static final <T> AtomicReference<T> t(@NotNull AtomicReference<T> atomicReference) {
        g0.p(atomicReference, "<this>");
        return atomicReference;
    }

    @ExperimentalAtomicApi
    @SinceKotlin(version = "2.2")
    @InlineOnly
    private static final int u(AtomicInteger atomicInteger, Function1<? super Integer, Integer> transform) {
        int i6;
        g0.p(atomicInteger, "<this>");
        g0.p(transform, "transform");
        do {
            i6 = atomicInteger.get();
        } while (!atomicInteger.compareAndSet(i6, transform.invoke(Integer.valueOf(i6)).intValue()));
        return i6;
    }

    @ExperimentalAtomicApi
    @SinceKotlin(version = "2.2")
    @InlineOnly
    private static final void update(AtomicLong atomicLong, Function1<? super Long, Long> transform) {
        long j6;
        g0.p(atomicLong, "<this>");
        g0.p(transform, "transform");
        do {
            j6 = atomicLong.get();
        } while (!atomicLong.compareAndSet(j6, transform.invoke(Long.valueOf(j6)).longValue()));
    }

    @ExperimentalAtomicApi
    @SinceKotlin(version = "2.2")
    @InlineOnly
    private static final long v(AtomicLong atomicLong, Function1<? super Long, Long> transform) {
        long j6;
        g0.p(atomicLong, "<this>");
        g0.p(transform, "transform");
        do {
            j6 = atomicLong.get();
        } while (!atomicLong.compareAndSet(j6, transform.invoke(Long.valueOf(j6)).longValue()));
        return j6;
    }

    @ExperimentalAtomicApi
    @SinceKotlin(version = "2.2")
    @InlineOnly
    private static final <T> T w(AtomicReference<T> atomicReference, Function1<? super T, ? extends T> transform) {
        T t5;
        g0.p(atomicReference, "<this>");
        g0.p(transform, "transform");
        do {
            t5 = atomicReference.get();
        } while (!p.a(atomicReference, t5, transform.invoke(t5)));
        return t5;
    }

    @ExperimentalAtomicApi
    @SinceKotlin(version = "2.2")
    @InlineOnly
    private static final int x(AtomicInteger atomicInteger, Function1<? super Integer, Integer> transform) {
        int i6;
        int intValue;
        g0.p(atomicInteger, "<this>");
        g0.p(transform, "transform");
        do {
            i6 = atomicInteger.get();
            intValue = transform.invoke(Integer.valueOf(i6)).intValue();
        } while (!atomicInteger.compareAndSet(i6, intValue));
        return intValue;
    }

    @ExperimentalAtomicApi
    @SinceKotlin(version = "2.2")
    @InlineOnly
    private static final long y(AtomicLong atomicLong, Function1<? super Long, Long> transform) {
        long j6;
        long longValue;
        g0.p(atomicLong, "<this>");
        g0.p(transform, "transform");
        do {
            j6 = atomicLong.get();
            longValue = transform.invoke(Long.valueOf(j6)).longValue();
        } while (!atomicLong.compareAndSet(j6, longValue));
        return longValue;
    }

    @ExperimentalAtomicApi
    @SinceKotlin(version = "2.2")
    @InlineOnly
    private static final <T> T z(AtomicReference<T> atomicReference, Function1<? super T, ? extends T> transform) {
        T t5;
        T invoke;
        g0.p(atomicReference, "<this>");
        g0.p(transform, "transform");
        do {
            t5 = atomicReference.get();
            invoke = transform.invoke(t5);
        } while (!p.a(atomicReference, t5, invoke));
        return invoke;
    }

    @ExperimentalAtomicApi
    @SinceKotlin(version = "2.2")
    @InlineOnly
    private static final <T> void update(AtomicReference<T> atomicReference, Function1<? super T, ? extends T> transform) {
        T t5;
        g0.p(atomicReference, "<this>");
        g0.p(transform, "transform");
        do {
            t5 = atomicReference.get();
        } while (!p.a(atomicReference, t5, transform.invoke(t5)));
    }
}
