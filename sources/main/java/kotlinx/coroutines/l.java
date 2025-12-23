package kotlinx.coroutines;

import java.util.concurrent.Future;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
final class l extends n {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final Future<?> f49344a;

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ kotlin.n1 invoke(Throwable th) {
        l(th);
        return kotlin.n1.f44123a;
    }

    @Override // kotlinx.coroutines.o
    public void l(@Nullable Throwable th) {
        if (th != null) {
            this.f49344a.cancel(false);
        }
    }

    @NotNull
    public String toString() {
        return "CancelFutureOnCancel[" + this.f49344a + ']';
    }

    public l(@NotNull Future<?> future) {
        this.f49344a = future;
    }
}
