package kotlin.time;

import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SinceKotlin(version = "1.9")
@WasExperimental(markerClass = {ExperimentalTime.class})
/* loaded from: D:\Downloads\app\classes8.dex */
public interface d0 {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        @NotNull
        public static d0 d(@NotNull d0 d0Var, long j6) {
            return new d(d0Var, j6, null);
        }

        public static boolean a(@NotNull d0 d0Var) {
            return h.V(d0Var.a());
        }

        public static boolean b(@NotNull d0 d0Var) {
            return !h.V(d0Var.a());
        }

        @NotNull
        public static d0 c(@NotNull d0 d0Var, long j6) {
            return d0Var.e(h.n0(j6));
        }
    }

    long a();

    boolean b();

    boolean c();

    @NotNull
    d0 e(long j6);

    @NotNull
    d0 f(long j6);
}
