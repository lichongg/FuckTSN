package androidx.lifecycle;

import androidx.annotation.MainThread;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.g0;
import kotlin.n1;
import kotlinx.coroutines.e2;
import kotlinx.coroutines.g1;
import kotlinx.coroutines.r0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class BlockRunner<T> {

    @NotNull
    private final Function2<LiveDataScope<T>, kotlin.coroutines.e<? super n1>, Object> block;

    @Nullable
    private e2 cancellationJob;

    @NotNull
    private final CoroutineLiveData<T> liveData;

    @NotNull
    private final Function0<n1> onDone;

    @Nullable
    private e2 runningJob;

    @NotNull
    private final r0 scope;
    private final long timeoutInMs;

    /* JADX WARN: Multi-variable type inference failed */
    public BlockRunner(@NotNull CoroutineLiveData<T> liveData, @NotNull Function2<? super LiveDataScope<T>, ? super kotlin.coroutines.e<? super n1>, ? extends Object> block, long j6, @NotNull r0 scope, @NotNull Function0<n1> onDone) {
        g0.p(liveData, "liveData");
        g0.p(block, "block");
        g0.p(scope, "scope");
        g0.p(onDone, "onDone");
        this.liveData = liveData;
        this.block = block;
        this.timeoutInMs = j6;
        this.scope = scope;
        this.onDone = onDone;
    }

    @MainThread
    public final void cancel() {
        e2 f6;
        if (this.cancellationJob != null) {
            throw new IllegalStateException("Cancel call cannot happen without a maybeRun");
        }
        f6 = kotlinx.coroutines.k.f(this.scope, g1.e().v(), null, new BlockRunner$cancel$1(this, null), 2, null);
        this.cancellationJob = f6;
    }

    @MainThread
    public final void maybeRun() {
        e2 f6;
        e2 e2Var = this.cancellationJob;
        if (e2Var != null) {
            e2.a.b(e2Var, null, 1, null);
        }
        this.cancellationJob = null;
        if (this.runningJob != null) {
            return;
        }
        f6 = kotlinx.coroutines.k.f(this.scope, null, null, new BlockRunner$maybeRun$1(this, null), 3, null);
        this.runningJob = f6;
    }
}
