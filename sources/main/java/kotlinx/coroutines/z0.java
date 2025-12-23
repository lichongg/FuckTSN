package kotlinx.coroutines;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@InternalCoroutinesApi
/* loaded from: D:\Downloads\app\classes8.dex */
public interface z0 {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nDelay.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/Delay$DefaultImpls\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,162:1\n314#2,11:163\n*S KotlinDebug\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/Delay$DefaultImpls\n*L\n30#1:163,11\n*E\n"})
    public static final class a {
        @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated without replacement as an internal method never intended for public use")
        @Nullable
        public static Object a(@NotNull z0 z0Var, long j6, @NotNull kotlin.coroutines.e<? super kotlin.n1> eVar) {
            if (j6 <= 0) {
                return kotlin.n1.f44123a;
            }
            q qVar = new q(kotlin.coroutines.intrinsics.a.e(eVar), 1);
            qVar.Q();
            z0Var.i(j6, qVar);
            Object x5 = qVar.x();
            if (x5 == kotlin.coroutines.intrinsics.a.l()) {
                kotlin.coroutines.jvm.internal.e.c(eVar);
            }
            return x5 == kotlin.coroutines.intrinsics.a.l() ? x5 : kotlin.n1.f44123a;
        }

        @NotNull
        public static j1 b(@NotNull z0 z0Var, long j6, @NotNull Runnable runnable, @NotNull kotlin.coroutines.i iVar) {
            return w0.a().m(j6, runnable, iVar);
        }
    }

    void i(long j6, @NotNull p<? super kotlin.n1> pVar);

    @NotNull
    j1 m(long j6, @NotNull Runnable runnable, @NotNull kotlin.coroutines.i iVar);

    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated without replacement as an internal method never intended for public use")
    @Nullable
    Object r(long j6, @NotNull kotlin.coroutines.e<? super kotlin.n1> eVar);
}
