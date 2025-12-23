package kotlin.time;

import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.n1;
import kotlin.time.e0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nmeasureTime.kt\nKotlin\n*S Kotlin\n*F\n+ 1 measureTime.kt\nkotlin/time/MeasureTimeKt\n*L\n1#1,139:1\n63#1,3:140\n135#1,3:143\n*S KotlinDebug\n*F\n+ 1 measureTime.kt\nkotlin/time/MeasureTimeKt\n*L\n24#1:140,3\n95#1:143,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class z {
    @SinceKotlin(version = "1.9")
    @WasExperimental(markerClass = {ExperimentalTime.class})
    public static final long a(@NotNull Function0<n1> block) {
        kotlin.jvm.internal.g0.p(block, "block");
        long b6 = e0.b.f48005b.b();
        block.invoke();
        return e0.b.a.k(b6);
    }

    @SinceKotlin(version = "1.9")
    @WasExperimental(markerClass = {ExperimentalTime.class})
    public static final long b(@NotNull e0.b bVar, @NotNull Function0<n1> block) {
        kotlin.jvm.internal.g0.p(bVar, "<this>");
        kotlin.jvm.internal.g0.p(block, "block");
        long b6 = bVar.b();
        block.invoke();
        return e0.b.a.k(b6);
    }

    @SinceKotlin(version = "1.9")
    @WasExperimental(markerClass = {ExperimentalTime.class})
    public static final long c(@NotNull e0 e0Var, @NotNull Function0<n1> block) {
        kotlin.jvm.internal.g0.p(e0Var, "<this>");
        kotlin.jvm.internal.g0.p(block, "block");
        d0 a6 = e0Var.a();
        block.invoke();
        return a6.a();
    }

    @SinceKotlin(version = "1.9")
    @WasExperimental(markerClass = {ExperimentalTime.class})
    @NotNull
    public static final <T> f0<T> d(@NotNull Function0<? extends T> block) {
        kotlin.jvm.internal.g0.p(block, "block");
        return new f0<>(block.invoke(), e0.b.a.k(e0.b.f48005b.b()), null);
    }

    @SinceKotlin(version = "1.9")
    @WasExperimental(markerClass = {ExperimentalTime.class})
    @NotNull
    public static final <T> f0<T> e(@NotNull e0.b bVar, @NotNull Function0<? extends T> block) {
        kotlin.jvm.internal.g0.p(bVar, "<this>");
        kotlin.jvm.internal.g0.p(block, "block");
        return new f0<>(block.invoke(), e0.b.a.k(bVar.b()), null);
    }

    @SinceKotlin(version = "1.9")
    @WasExperimental(markerClass = {ExperimentalTime.class})
    @NotNull
    public static final <T> f0<T> f(@NotNull e0 e0Var, @NotNull Function0<? extends T> block) {
        kotlin.jvm.internal.g0.p(e0Var, "<this>");
        kotlin.jvm.internal.g0.p(block, "block");
        return new f0<>(block.invoke(), e0Var.a().a(), null);
    }
}
