package kotlinx.coroutines;

import java.util.concurrent.Future;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
final /* synthetic */ class i2 {
    public static final void a(@NotNull p<?> pVar, @NotNull Future<?> future) {
        pVar.I(new l(future));
    }

    @InternalCoroutinesApi
    @NotNull
    public static final j1 b(@NotNull e2 e2Var, @NotNull Future<?> future) {
        return e2Var.k(new m(future));
    }
}
