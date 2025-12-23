package kotlinx.coroutines.flow.internal;

import java.util.concurrent.CancellationException;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nFlowExceptions.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FlowExceptions.kt\nkotlinx/coroutines/flow/internal/AbortFlowException\n+ 2 ArrayIntrinsics.kt\nkotlin/ArrayIntrinsicsKt\n*L\n1#1,30:1\n26#2:31\n*S KotlinDebug\n*F\n+ 1 FlowExceptions.kt\nkotlinx/coroutines/flow/internal/AbortFlowException\n*L\n17#1:31\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class AbortFlowException extends CancellationException {

    @JvmField
    @NotNull
    public final transient kotlinx.coroutines.flow.j<?> owner;

    @Override // java.lang.Throwable
    @NotNull
    public Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    public AbortFlowException(@NotNull kotlinx.coroutines.flow.j<?> jVar) {
        super("Flow was aborted, no more elements needed");
        this.owner = jVar;
    }
}
