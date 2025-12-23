package kotlin;

import kotlin.Result;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static final Object f43800a;

    static {
        Result.a aVar = Result.Companion;
        f43800a = Result.m130constructorimpl(kotlin.coroutines.intrinsics.a.l());
    }

    @SinceKotlin(version = "1.7")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final <T, R> R b(@NotNull h<T, R> hVar, T t5) {
        kotlin.jvm.internal.g0.p(hVar, "<this>");
        return (R) new k(hVar.a(), t5).j();
    }
}
