package kotlin.sequences;

import java.util.Iterator;
import kotlin.SinceKotlin;
import kotlin.d1;
import kotlin.j1;
import kotlin.jvm.JvmName;
import kotlin.z0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
class v0 {
    @SinceKotlin(version = "1.5")
    @JvmName(name = "sumOfUByte")
    public static final int a(@NotNull m<kotlin.v0> mVar) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        Iterator<kotlin.v0> it = mVar.iterator();
        int i6 = 0;
        while (it.hasNext()) {
            i6 = z0.k(i6 + z0.k(it.next().o0() & 255));
        }
        return i6;
    }

    @SinceKotlin(version = "1.5")
    @JvmName(name = "sumOfUInt")
    public static final int b(@NotNull m<z0> mVar) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        Iterator<z0> it = mVar.iterator();
        int i6 = 0;
        while (it.hasNext()) {
            i6 = z0.k(i6 + it.next().q0());
        }
        return i6;
    }

    @SinceKotlin(version = "1.5")
    @JvmName(name = "sumOfULong")
    public static final long c(@NotNull m<d1> mVar) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        Iterator<d1> it = mVar.iterator();
        long j6 = 0;
        while (it.hasNext()) {
            j6 = d1.k(j6 + it.next().q0());
        }
        return j6;
    }

    @SinceKotlin(version = "1.5")
    @JvmName(name = "sumOfUShort")
    public static final int d(@NotNull m<j1> mVar) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        Iterator<j1> it = mVar.iterator();
        int i6 = 0;
        while (it.hasNext()) {
            i6 = z0.k(i6 + z0.k(it.next().o0() & j1.f43986d));
        }
        return i6;
    }
}
