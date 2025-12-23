package kotlin.time;

import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.time.d0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SinceKotlin(version = "1.9")
@WasExperimental(markerClass = {ExperimentalTime.class})
/* loaded from: D:\Downloads\app\classes8.dex */
public interface g extends d0, Comparable<g> {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        public static int a(@NotNull g gVar, @NotNull g other) {
            kotlin.jvm.internal.g0.p(other, "other");
            return h.k(gVar.g(other), h.f48019b.T());
        }

        public static boolean b(@NotNull g gVar) {
            return d0.a.a(gVar);
        }

        public static boolean c(@NotNull g gVar) {
            return d0.a.b(gVar);
        }

        @NotNull
        public static g d(@NotNull g gVar, long j6) {
            return gVar.e(h.n0(j6));
        }
    }

    /* renamed from: N */
    int compareTo(@NotNull g gVar);

    @Override // kotlin.time.d0
    @NotNull
    g e(long j6);

    boolean equals(@Nullable Object obj);

    @Override // kotlin.time.d0
    @NotNull
    g f(long j6);

    long g(@NotNull g gVar);

    int hashCode();
}
