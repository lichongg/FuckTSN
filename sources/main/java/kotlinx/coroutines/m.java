package kotlinx.coroutines;

import java.util.concurrent.Future;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
final class m extends k2 {

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private final Future<?> f49380e;

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ kotlin.n1 invoke(Throwable th) {
        z(th);
        return kotlin.n1.f44123a;
    }

    @Override // kotlinx.coroutines.f0
    public void z(@Nullable Throwable th) {
        if (th != null) {
            this.f49380e.cancel(false);
        }
    }

    public m(@NotNull Future<?> future) {
        this.f49380e = future;
    }
}
