package kotlin;

import kotlin.jvm.functions.Function3;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SinceKotlin(version = "1.7")
@WasExperimental(markerClass = {ExperimentalStdlibApi.class})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class h<T, R> {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final Function3<j<T, R>, T, kotlin.coroutines.e<? super R>, Object> f43793a;

    /* JADX WARN: Multi-variable type inference failed */
    public h(@NotNull Function3<? super j<T, R>, ? super T, ? super kotlin.coroutines.e<? super R>, ? extends Object> block) {
        kotlin.jvm.internal.g0.p(block, "block");
        this.f43793a = block;
    }

    @NotNull
    public final Function3<j<T, R>, T, kotlin.coroutines.e<? super R>, Object> a() {
        return this.f43793a;
    }
}
