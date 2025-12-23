package kotlinx.coroutines;

import com.tencent.connect.common.Constants;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import kotlin.jvm.JvmName;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class v1 {
    @NotNull
    public static final Executor b(@NotNull m0 m0Var) {
        Executor t5;
        t1 t1Var = m0Var instanceof t1 ? (t1) m0Var : null;
        return (t1Var == null || (t5 = t1Var.t()) == null) ? new f1(m0Var) : t5;
    }

    @JvmName(name = Constants.FROM)
    @NotNull
    public static final m0 c(@NotNull Executor executor) {
        m0 m0Var;
        f1 f1Var = executor instanceof f1 ? (f1) executor : null;
        return (f1Var == null || (m0Var = f1Var.f48579a) == null) ? new u1(executor) : m0Var;
    }

    @JvmName(name = Constants.FROM)
    @NotNull
    public static final t1 d(@NotNull ExecutorService executorService) {
        return new u1(executorService);
    }

    @ExperimentalCoroutinesApi
    public static /* synthetic */ void a() {
    }
}
