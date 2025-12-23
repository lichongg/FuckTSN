package kotlinx.coroutines.scheduling;

import kotlin.jvm.JvmName;
import kotlinx.coroutines.scheduling.CoroutineScheduler;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class a {
    @JvmName(name = "isSchedulerWorker")
    public static final boolean a(@NotNull Thread thread) {
        return thread instanceof CoroutineScheduler.c;
    }

    @JvmName(name = "mayNotBlock")
    public static final boolean b(@NotNull Thread thread) {
        return (thread instanceof CoroutineScheduler.c) && ((CoroutineScheduler.c) thread).f49477c == CoroutineScheduler.WorkerState.CPU_ACQUIRED;
    }
}
