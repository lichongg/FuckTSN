package kotlin.coroutines;

import kotlin.SinceKotlin;
import kotlin.coroutines.i;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SinceKotlin(version = "1.3")
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class a implements i.b {

    @NotNull
    private final i.c<?> key;

    public a(@NotNull i.c<?> key) {
        g0.p(key, "key");
        this.key = key;
    }

    @Override // kotlin.coroutines.i.b
    @NotNull
    public i.c<?> getKey() {
        return this.key;
    }

    @Override // kotlin.coroutines.i.b, kotlin.coroutines.i
    public /* bridge */ <R> R fold(R r5, @NotNull Function2<? super R, ? super i.b, ? extends R> function2) {
        return (R) i.b.a.a(this, r5, function2);
    }

    @Override // kotlin.coroutines.i.b, kotlin.coroutines.i
    @Nullable
    public /* bridge */ <E extends i.b> E get(@NotNull i.c<E> cVar) {
        return (E) i.b.a.b(this, cVar);
    }

    @Override // kotlin.coroutines.i.b, kotlin.coroutines.i
    @NotNull
    public /* bridge */ i minusKey(@NotNull i.c<?> cVar) {
        return i.b.a.c(this, cVar);
    }

    @Override // kotlin.coroutines.i
    @NotNull
    public /* bridge */ i plus(@NotNull i iVar) {
        return i.b.a.d(this, iVar);
    }
}
