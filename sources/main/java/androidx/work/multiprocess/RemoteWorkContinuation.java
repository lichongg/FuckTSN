package androidx.work.multiprocess;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.work.OneTimeWorkRequest;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Collections;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public abstract class RemoteWorkContinuation {
    @NonNull
    public static RemoteWorkContinuation combine(@NonNull List<RemoteWorkContinuation> continuations) {
        return continuations.get(0).combineInternal(continuations);
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected abstract RemoteWorkContinuation combineInternal(@NonNull List<RemoteWorkContinuation> continuations);

    @NonNull
    public abstract ListenableFuture<Void> enqueue();

    @NonNull
    public final RemoteWorkContinuation then(@NonNull OneTimeWorkRequest work) {
        return then(Collections.singletonList(work));
    }

    @NonNull
    public abstract RemoteWorkContinuation then(@NonNull List<OneTimeWorkRequest> work);

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected RemoteWorkContinuation() {
    }
}
