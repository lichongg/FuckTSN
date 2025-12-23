package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nTimeout.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Timeout.kt\nkotlinx/coroutines/TimeoutCancellationException\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,193:1\n1#2:194\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class TimeoutCancellationException extends CancellationException implements k0<TimeoutCancellationException> {

    @JvmField
    @Nullable
    public final transient e2 coroutine;

    public TimeoutCancellationException(@NotNull String str, @Nullable e2 e2Var) {
        super(str);
        this.coroutine = e2Var;
    }

    @Override // kotlinx.coroutines.k0
    @NotNull
    public TimeoutCancellationException createCopy() {
        String message = getMessage();
        if (message == null) {
            message = "";
        }
        TimeoutCancellationException timeoutCancellationException = new TimeoutCancellationException(message, this.coroutine);
        timeoutCancellationException.initCause(this);
        return timeoutCancellationException;
    }

    public TimeoutCancellationException(@NotNull String str) {
        this(str, null);
    }
}
