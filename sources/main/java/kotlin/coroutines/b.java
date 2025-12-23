package kotlin.coroutines;

import kotlin.ExperimentalStdlibApi;
import kotlin.SinceKotlin;
import kotlin.coroutines.i;
import kotlin.coroutines.i.b;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SinceKotlin(version = "1.3")
@ExperimentalStdlibApi
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class b<B extends i.b, E extends B> implements i.c<E> {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final Function1<i.b, E> f43761a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final i.c<?> f43762b;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [kotlin.coroutines.i$c<?>] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.Object, kotlin.jvm.functions.Function1<? super kotlin.coroutines.i$b, ? extends E extends B>, kotlin.jvm.functions.Function1<kotlin.coroutines.i$b, E extends B>] */
    public b(@NotNull i.c<B> baseKey, @NotNull Function1<? super i.b, ? extends E> safeCast) {
        g0.p(baseKey, "baseKey");
        g0.p(safeCast, "safeCast");
        this.f43761a = safeCast;
        this.f43762b = baseKey instanceof b ? (i.c<B>) ((b) baseKey).f43762b : baseKey;
    }

    public final boolean a(@NotNull i.c<?> key) {
        g0.p(key, "key");
        return key == this || this.f43762b == key;
    }

    /* JADX WARN: Incorrect return type in method signature: (Lkotlin/coroutines/i$b;)TE; */
    @Nullable
    public final i.b b(@NotNull i.b element) {
        g0.p(element, "element");
        return (i.b) this.f43761a.invoke(element);
    }
}
