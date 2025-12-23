package kotlinx.coroutines;

import java.util.concurrent.Executor;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
final class f1 implements Executor {

    /* renamed from: a, reason: collision with root package name */
    @JvmField
    @NotNull
    public final m0 f48579a;

    @Override // java.util.concurrent.Executor
    public void execute(@NotNull Runnable runnable) {
        m0 m0Var = this.f48579a;
        EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.INSTANCE;
        if (m0Var.isDispatchNeeded(emptyCoroutineContext)) {
            this.f48579a.dispatch(emptyCoroutineContext, runnable);
        } else {
            runnable.run();
        }
    }

    @NotNull
    public String toString() {
        return this.f48579a.toString();
    }

    public f1(@NotNull m0 m0Var) {
        this.f48579a = m0Var;
    }
}
