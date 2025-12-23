package p3;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import kotlin.ExperimentalStdlibApi;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.collections.f0;
import kotlin.collections.u1;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.g0;
import kotlin.sequences.m;
import kotlin.sequences.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class b {
    @SinceKotlin(version = "1.8")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @NotNull
    public static final <T> m<T> a(@NotNull Optional<? extends T> optional) {
        boolean isPresent;
        Object obj;
        g0.p(optional, "<this>");
        isPresent = optional.isPresent();
        if (!isPresent) {
            return p.l();
        }
        obj = optional.get();
        return p.B(obj);
    }

    @SinceKotlin(version = "1.8")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final <T> T b(@NotNull Optional<? extends T> optional, T t5) {
        boolean isPresent;
        Object obj;
        g0.p(optional, "<this>");
        isPresent = optional.isPresent();
        if (!isPresent) {
            return t5;
        }
        obj = optional.get();
        return (T) obj;
    }

    @SinceKotlin(version = "1.8")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final <T> T c(@NotNull Optional<? extends T> optional, @NotNull Function0<? extends T> defaultValue) {
        boolean isPresent;
        Object obj;
        g0.p(optional, "<this>");
        g0.p(defaultValue, "defaultValue");
        isPresent = optional.isPresent();
        if (!isPresent) {
            return defaultValue.invoke();
        }
        obj = optional.get();
        return (T) obj;
    }

    @SinceKotlin(version = "1.8")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @Nullable
    public static final <T> T d(@NotNull Optional<T> optional) {
        Object orElse;
        g0.p(optional, "<this>");
        orElse = optional.orElse(null);
        return (T) orElse;
    }

    @SinceKotlin(version = "1.8")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @NotNull
    public static final <T, C extends Collection<? super T>> C e(@NotNull Optional<T> optional, @NotNull C destination) {
        boolean isPresent;
        Object obj;
        g0.p(optional, "<this>");
        g0.p(destination, "destination");
        isPresent = optional.isPresent();
        if (isPresent) {
            obj = optional.get();
            g0.o(obj, "get(...)");
            destination.add(obj);
        }
        return destination;
    }

    @SinceKotlin(version = "1.8")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @NotNull
    public static final <T> List<T> f(@NotNull Optional<? extends T> optional) {
        boolean isPresent;
        Object obj;
        g0.p(optional, "<this>");
        isPresent = optional.isPresent();
        if (!isPresent) {
            return f0.J();
        }
        obj = optional.get();
        return f0.l(obj);
    }

    @SinceKotlin(version = "1.8")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @NotNull
    public static final <T> Set<T> g(@NotNull Optional<? extends T> optional) {
        boolean isPresent;
        Object obj;
        g0.p(optional, "<this>");
        isPresent = optional.isPresent();
        if (!isPresent) {
            return u1.k();
        }
        obj = optional.get();
        return u1.f(obj);
    }
}
