package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.SinceKotlin;
import kotlin.jvm.JvmName;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
class e2 {
    @SinceKotlin(version = "1.5")
    @JvmName(name = "sumOfUByte")
    public static final int a(@NotNull Iterable<kotlin.v0> iterable) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        Iterator<kotlin.v0> it = iterable.iterator();
        int i6 = 0;
        while (it.hasNext()) {
            i6 = kotlin.z0.k(i6 + kotlin.z0.k(it.next().o0() & 255));
        }
        return i6;
    }

    @SinceKotlin(version = "1.5")
    @JvmName(name = "sumOfUInt")
    public static final int b(@NotNull Iterable<kotlin.z0> iterable) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        Iterator<kotlin.z0> it = iterable.iterator();
        int i6 = 0;
        while (it.hasNext()) {
            i6 = kotlin.z0.k(i6 + it.next().q0());
        }
        return i6;
    }

    @SinceKotlin(version = "1.5")
    @JvmName(name = "sumOfULong")
    public static final long c(@NotNull Iterable<kotlin.d1> iterable) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        Iterator<kotlin.d1> it = iterable.iterator();
        long j6 = 0;
        while (it.hasNext()) {
            j6 = kotlin.d1.k(j6 + it.next().q0());
        }
        return j6;
    }

    @SinceKotlin(version = "1.5")
    @JvmName(name = "sumOfUShort")
    public static final int d(@NotNull Iterable<kotlin.j1> iterable) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        Iterator<kotlin.j1> it = iterable.iterator();
        int i6 = 0;
        while (it.hasNext()) {
            i6 = kotlin.z0.k(i6 + kotlin.z0.k(it.next().o0() & kotlin.j1.f43986d));
        }
        return i6;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final byte[] e(@NotNull Collection<kotlin.v0> collection) {
        kotlin.jvm.internal.g0.p(collection, "<this>");
        byte[] e6 = kotlin.w0.e(collection.size());
        Iterator<kotlin.v0> it = collection.iterator();
        int i6 = 0;
        while (it.hasNext()) {
            kotlin.w0.x(e6, i6, it.next().o0());
            i6++;
        }
        return e6;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final int[] f(@NotNull Collection<kotlin.z0> collection) {
        kotlin.jvm.internal.g0.p(collection, "<this>");
        int[] e6 = kotlin.a1.e(collection.size());
        Iterator<kotlin.z0> it = collection.iterator();
        int i6 = 0;
        while (it.hasNext()) {
            kotlin.a1.x(e6, i6, it.next().q0());
            i6++;
        }
        return e6;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final long[] g(@NotNull Collection<kotlin.d1> collection) {
        kotlin.jvm.internal.g0.p(collection, "<this>");
        long[] e6 = kotlin.e1.e(collection.size());
        Iterator<kotlin.d1> it = collection.iterator();
        int i6 = 0;
        while (it.hasNext()) {
            kotlin.e1.x(e6, i6, it.next().q0());
            i6++;
        }
        return e6;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final short[] h(@NotNull Collection<kotlin.j1> collection) {
        kotlin.jvm.internal.g0.p(collection, "<this>");
        short[] e6 = kotlin.k1.e(collection.size());
        Iterator<kotlin.j1> it = collection.iterator();
        int i6 = 0;
        while (it.hasNext()) {
            kotlin.k1.x(e6, i6, it.next().o0());
            i6++;
        }
        return e6;
    }
}
