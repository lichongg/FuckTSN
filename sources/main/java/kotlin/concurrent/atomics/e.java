package kotlin.concurrent.atomics;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
class e {
    @ExperimentalAtomicApi
    @SinceKotlin(version = "2.1")
    public static final int a(@NotNull AtomicInteger atomicInteger) {
        g0.p(atomicInteger, "<this>");
        return atomicInteger.addAndGet(-1);
    }

    @ExperimentalAtomicApi
    @SinceKotlin(version = "2.1")
    public static final long b(@NotNull AtomicLong atomicLong) {
        g0.p(atomicLong, "<this>");
        return atomicLong.addAndGet(-1L);
    }

    @ExperimentalAtomicApi
    @SinceKotlin(version = "2.1")
    public static final int c(@NotNull AtomicInteger atomicInteger) {
        g0.p(atomicInteger, "<this>");
        return atomicInteger.getAndAdd(-1);
    }

    @ExperimentalAtomicApi
    @SinceKotlin(version = "2.1")
    public static final long d(@NotNull AtomicLong atomicLong) {
        g0.p(atomicLong, "<this>");
        return atomicLong.getAndAdd(-1L);
    }

    @ExperimentalAtomicApi
    @SinceKotlin(version = "2.1")
    public static final int e(@NotNull AtomicInteger atomicInteger) {
        g0.p(atomicInteger, "<this>");
        return atomicInteger.getAndAdd(1);
    }

    @ExperimentalAtomicApi
    @SinceKotlin(version = "2.1")
    public static final long f(@NotNull AtomicLong atomicLong) {
        g0.p(atomicLong, "<this>");
        return atomicLong.getAndAdd(1L);
    }

    @ExperimentalAtomicApi
    @SinceKotlin(version = "2.1")
    public static final int g(@NotNull AtomicInteger atomicInteger) {
        g0.p(atomicInteger, "<this>");
        return atomicInteger.addAndGet(1);
    }

    @ExperimentalAtomicApi
    @SinceKotlin(version = "2.1")
    public static final long h(@NotNull AtomicLong atomicLong) {
        g0.p(atomicLong, "<this>");
        return atomicLong.addAndGet(1L);
    }

    @ExperimentalAtomicApi
    @SinceKotlin(version = "2.1")
    public static final void i(@NotNull AtomicInteger atomicInteger, int i6) {
        g0.p(atomicInteger, "<this>");
        atomicInteger.addAndGet(-i6);
    }

    @ExperimentalAtomicApi
    @SinceKotlin(version = "2.1")
    public static final void j(@NotNull AtomicLong atomicLong, long j6) {
        g0.p(atomicLong, "<this>");
        atomicLong.addAndGet(-j6);
    }

    @ExperimentalAtomicApi
    @SinceKotlin(version = "2.1")
    public static final void k(@NotNull AtomicInteger atomicInteger, int i6) {
        g0.p(atomicInteger, "<this>");
        atomicInteger.addAndGet(i6);
    }

    @ExperimentalAtomicApi
    @SinceKotlin(version = "2.1")
    public static final void l(@NotNull AtomicLong atomicLong, long j6) {
        g0.p(atomicLong, "<this>");
        atomicLong.addAndGet(j6);
    }
}
