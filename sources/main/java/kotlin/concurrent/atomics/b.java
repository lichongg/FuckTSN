package kotlin.concurrent.atomics;

import androidx.exifinterface.media.ExifInterface;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicLongArray;
import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.SinceKotlin;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nAtomicArrays.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AtomicArrays.common.kt\nkotlin/concurrent/atomics/AtomicArraysKt__AtomicArrays_commonKt\n*L\n1#1,768:1\n666#1:769\n*S KotlinDebug\n*F\n+ 1 AtomicArrays.common.kt\nkotlin/concurrent/atomics/AtomicArraysKt__AtomicArrays_commonKt\n*L\n678#1:769\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
class b {
    @ExperimentalAtomicApi
    @SinceKotlin(version = "2.1")
    public static final /* synthetic */ <T> AtomicReferenceArray<T> a(int i6, Function1<? super Integer, ? extends T> init) {
        g0.p(init, "init");
        g0.y(0, ExifInterface.GPS_DIRECTION_TRUE);
        Object[] objArr = new Object[i6];
        for (int i7 = 0; i7 < i6; i7++) {
            objArr[i7] = init.invoke(Integer.valueOf(i7));
        }
        return new AtomicReferenceArray<>(objArr);
    }

    @ExperimentalAtomicApi
    @SinceKotlin(version = "2.1")
    @NotNull
    public static final AtomicIntegerArray b(int i6, @NotNull Function1<? super Integer, Integer> init) {
        g0.p(init, "init");
        int[] iArr = new int[i6];
        for (int i7 = 0; i7 < i6; i7++) {
            iArr[i7] = init.invoke(Integer.valueOf(i7)).intValue();
        }
        return new AtomicIntegerArray(iArr);
    }

    @ExperimentalAtomicApi
    @SinceKotlin(version = "2.1")
    @NotNull
    public static final AtomicLongArray c(int i6, @NotNull Function1<? super Integer, Long> init) {
        g0.p(init, "init");
        long[] jArr = new long[i6];
        for (int i7 = 0; i7 < i6; i7++) {
            jArr[i7] = init.invoke(Integer.valueOf(i7)).longValue();
        }
        return new AtomicLongArray(jArr);
    }

    @ExperimentalAtomicApi
    @SinceKotlin(version = "2.2")
    public static final /* synthetic */ <T> AtomicReferenceArray<T> d(int i6) {
        g0.y(0, "T?");
        Object[] objArr = new Object[i6];
        for (int i7 = 0; i7 < i6; i7++) {
            objArr[i7] = null;
        }
        return new AtomicReferenceArray<>(objArr);
    }

    @ExperimentalAtomicApi
    @SinceKotlin(version = "2.1")
    public static final int e(@NotNull AtomicIntegerArray atomicIntegerArray, int i6) {
        g0.p(atomicIntegerArray, "<this>");
        return atomicIntegerArray.addAndGet(i6, -1);
    }

    @ExperimentalAtomicApi
    @SinceKotlin(version = "2.1")
    public static final long f(@NotNull AtomicLongArray atomicLongArray, int i6) {
        g0.p(atomicLongArray, "<this>");
        return atomicLongArray.addAndGet(i6, -1L);
    }

    @ExperimentalAtomicApi
    @SinceKotlin(version = "2.1")
    public static final int g(@NotNull AtomicIntegerArray atomicIntegerArray, int i6) {
        g0.p(atomicIntegerArray, "<this>");
        return atomicIntegerArray.getAndAdd(i6, -1);
    }

    @ExperimentalAtomicApi
    @SinceKotlin(version = "2.1")
    public static final long h(@NotNull AtomicLongArray atomicLongArray, int i6) {
        g0.p(atomicLongArray, "<this>");
        return atomicLongArray.getAndAdd(i6, -1L);
    }

    @ExperimentalAtomicApi
    @SinceKotlin(version = "2.1")
    public static final int i(@NotNull AtomicIntegerArray atomicIntegerArray, int i6) {
        g0.p(atomicIntegerArray, "<this>");
        return atomicIntegerArray.getAndAdd(i6, 1);
    }

    @ExperimentalAtomicApi
    @SinceKotlin(version = "2.1")
    public static final long j(@NotNull AtomicLongArray atomicLongArray, int i6) {
        g0.p(atomicLongArray, "<this>");
        return atomicLongArray.getAndAdd(i6, 1L);
    }

    @ExperimentalAtomicApi
    @SinceKotlin(version = "2.1")
    public static final int k(@NotNull AtomicIntegerArray atomicIntegerArray, int i6) {
        g0.p(atomicIntegerArray, "<this>");
        return atomicIntegerArray.addAndGet(i6, 1);
    }

    @ExperimentalAtomicApi
    @SinceKotlin(version = "2.1")
    public static final long l(@NotNull AtomicLongArray atomicLongArray, int i6) {
        g0.p(atomicLongArray, "<this>");
        return atomicLongArray.addAndGet(i6, 1L);
    }
}
