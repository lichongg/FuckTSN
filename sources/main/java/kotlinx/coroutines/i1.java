package kotlinx.coroutines;

import java.util.concurrent.Future;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
final class i1 implements j1 {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final Future<?> f49214a;

    @Override // kotlinx.coroutines.j1
    public void dispose() {
        this.f49214a.cancel(false);
    }

    @NotNull
    public String toString() {
        return "DisposableFutureHandle[" + this.f49214a + ']';
    }

    public i1(@NotNull Future<?> future) {
        this.f49214a = future;
    }
}
