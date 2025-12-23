package kotlinx.coroutines.scheduling;

import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.internal.t;
import kotlinx.coroutines.m0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
final class o extends m0 {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final o f49517a = new o();

    @Override // kotlinx.coroutines.m0
    public void dispatch(@NotNull kotlin.coroutines.i iVar, @NotNull Runnable runnable) {
        c.f49485g.v(runnable, n.f49516j, false);
    }

    @Override // kotlinx.coroutines.m0
    @InternalCoroutinesApi
    public void dispatchYield(@NotNull kotlin.coroutines.i iVar, @NotNull Runnable runnable) {
        c.f49485g.v(runnable, n.f49516j, true);
    }

    private o() {
    }

    @Override // kotlinx.coroutines.m0
    @ExperimentalCoroutinesApi
    @NotNull
    public m0 limitedParallelism(int i6) {
        t.a(i6);
        if (i6 >= n.f49510d) {
            return this;
        }
        return super.limitedParallelism(i6);
    }
}
