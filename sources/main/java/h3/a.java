package h3;

import androidx.camera.view.p;
import com.google.common.util.concurrent.b;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class a {
    @SinceKotlin(version = "2.1")
    @PublishedApi
    public static final int a(@NotNull AtomicInteger atomicInteger, int i6, int i7) {
        g0.p(atomicInteger, "<this>");
        do {
            int i8 = atomicInteger.get();
            if (i6 != i8) {
                return i8;
            }
        } while (!atomicInteger.compareAndSet(i6, i7));
        return i6;
    }

    @SinceKotlin(version = "2.1")
    @PublishedApi
    public static final int b(@NotNull AtomicIntegerArray atomicIntegerArray, int i6, int i7, int i8) {
        g0.p(atomicIntegerArray, "<this>");
        do {
            int i9 = atomicIntegerArray.get(i6);
            if (i7 != i9) {
                return i9;
            }
        } while (!atomicIntegerArray.compareAndSet(i6, i7, i8));
        return i7;
    }

    @SinceKotlin(version = "2.1")
    @PublishedApi
    public static final long c(@NotNull AtomicLong atomicLong, long j6, long j7) {
        g0.p(atomicLong, "<this>");
        do {
            long j8 = atomicLong.get();
            if (j6 != j8) {
                return j8;
            }
        } while (!atomicLong.compareAndSet(j6, j7));
        return j6;
    }

    @SinceKotlin(version = "2.1")
    @PublishedApi
    public static final long d(@NotNull AtomicLongArray atomicLongArray, int i6, long j6, long j7) {
        g0.p(atomicLongArray, "<this>");
        do {
            long j8 = atomicLongArray.get(i6);
            if (j6 != j8) {
                return j8;
            }
        } while (!atomicLongArray.compareAndSet(i6, j6, j7));
        return j6;
    }

    @SinceKotlin(version = "2.1")
    @PublishedApi
    public static final <T> T e(@NotNull AtomicReference<T> atomicReference, T t5, T t6) {
        g0.p(atomicReference, "<this>");
        do {
            T t7 = atomicReference.get();
            if (t5 != t7) {
                return t7;
            }
        } while (!p.a(atomicReference, t5, t6));
        return t5;
    }

    @SinceKotlin(version = "2.1")
    @PublishedApi
    public static final <T> T f(@NotNull AtomicReferenceArray<T> atomicReferenceArray, int i6, T t5, T t6) {
        g0.p(atomicReferenceArray, "<this>");
        do {
            T t7 = atomicReferenceArray.get(i6);
            if (t5 != t7) {
                return t7;
            }
        } while (!b.a(atomicReferenceArray, i6, t5, t6));
        return t5;
    }

    @SinceKotlin(version = "2.1")
    @PublishedApi
    public static final boolean g(@NotNull AtomicBoolean atomicBoolean, boolean z5, boolean z6) {
        g0.p(atomicBoolean, "<this>");
        do {
            boolean z7 = atomicBoolean.get();
            if (z5 != z7) {
                return z7;
            }
        } while (!atomicBoolean.compareAndSet(z5, z6));
        return z5;
    }
}
