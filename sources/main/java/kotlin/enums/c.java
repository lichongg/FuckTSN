package kotlin.enums;

import kotlin.ExperimentalStdlibApi;
import kotlin.NotImplementedError;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class c {
    @SinceKotlin(version = "2.0")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final /* synthetic */ <T extends Enum<T>> a<T> a() {
        throw new NotImplementedError(null, 1, 0 == true ? 1 : 0);
    }

    @SinceKotlin(version = "1.8")
    @PublishedApi
    @NotNull
    public static final <E extends Enum<E>> a<E> b(@NotNull Function0<E[]> entriesProvider) {
        g0.p(entriesProvider, "entriesProvider");
        return new d(entriesProvider.invoke());
    }

    @SinceKotlin(version = "1.8")
    @PublishedApi
    @NotNull
    public static final <E extends Enum<E>> a<E> c(@NotNull E[] entries) {
        g0.p(entries, "entries");
        return new d(entries);
    }
}
