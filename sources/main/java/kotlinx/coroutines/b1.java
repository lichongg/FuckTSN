package kotlinx.coroutines;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlinx.coroutines.z0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@InternalCoroutinesApi
/* loaded from: D:\Downloads\app\classes8.dex */
public interface b1 extends z0 {
    @NotNull
    String h(long j6);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated without replacement as an internal method never intended for public use")
        @Nullable
        public static Object a(@NotNull b1 b1Var, long j6, @NotNull kotlin.coroutines.e<? super kotlin.n1> eVar) {
            Object a6 = z0.a.a(b1Var, j6, eVar);
            if (a6 == kotlin.coroutines.intrinsics.a.l()) {
                return a6;
            }
            return kotlin.n1.f44123a;
        }

        @NotNull
        public static j1 b(@NotNull b1 b1Var, long j6, @NotNull Runnable runnable, @NotNull kotlin.coroutines.i iVar) {
            return z0.a.b(b1Var, j6, runnable, iVar);
        }
    }
}
