package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nExceptions.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Exceptions.kt\nkotlinx/coroutines/JobCancellationException\n+ 2 ArrayIntrinsics.kt\nkotlin/ArrayIntrinsicsKt\n*L\n1#1,76:1\n26#2:77\n*S KotlinDebug\n*F\n+ 1 Exceptions.kt\nkotlinx/coroutines/JobCancellationException\n*L\n44#1:77\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class JobCancellationException extends CancellationException implements k0<JobCancellationException> {

    @JvmField
    @NotNull
    public final transient e2 job;

    @Override // kotlinx.coroutines.k0
    @Nullable
    public JobCancellationException createCopy() {
        return null;
    }

    @Override // java.lang.Throwable
    @NotNull
    public Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof JobCancellationException)) {
            return false;
        }
        JobCancellationException jobCancellationException = (JobCancellationException) obj;
        return kotlin.jvm.internal.g0.g(jobCancellationException.getMessage(), getMessage()) && kotlin.jvm.internal.g0.g(jobCancellationException.job, this.job) && kotlin.jvm.internal.g0.g(jobCancellationException.getCause(), getCause());
    }

    @Override // java.lang.Throwable
    @NotNull
    public String toString() {
        return super.toString() + "; job=" + this.job;
    }

    public JobCancellationException(@NotNull String str, @Nullable Throwable th, @NotNull e2 e2Var) {
        super(str);
        this.job = e2Var;
        if (th != null) {
            initCause(th);
        }
    }

    public int hashCode() {
        int i6;
        String message = getMessage();
        kotlin.jvm.internal.g0.m(message);
        int hashCode = ((message.hashCode() * 31) + this.job.hashCode()) * 31;
        Throwable cause = getCause();
        if (cause != null) {
            i6 = cause.hashCode();
        } else {
            i6 = 0;
        }
        return hashCode + i6;
    }
}
