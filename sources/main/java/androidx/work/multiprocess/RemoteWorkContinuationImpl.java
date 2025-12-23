package androidx.work.multiprocess;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkContinuation;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: D:\Downloads\app\classes.dex */
public class RemoteWorkContinuationImpl extends RemoteWorkContinuation {
    private final RemoteWorkManagerClient mClient;
    private final WorkContinuation mContinuation;

    @Override // androidx.work.multiprocess.RemoteWorkContinuation
    @NonNull
    public ListenableFuture<Void> enqueue() {
        return this.mClient.enqueue(this.mContinuation);
    }

    @Override // androidx.work.multiprocess.RemoteWorkContinuation
    @NonNull
    @SuppressLint({"EnqueueWork"})
    public RemoteWorkContinuation then(@NonNull List<OneTimeWorkRequest> list) {
        return new RemoteWorkContinuationImpl(this.mClient, this.mContinuation.then(list));
    }

    public RemoteWorkContinuationImpl(@NonNull RemoteWorkManagerClient remoteWorkManagerClient, @NonNull WorkContinuation workContinuation) {
        this.mClient = remoteWorkManagerClient;
        this.mContinuation = workContinuation;
    }

    @Override // androidx.work.multiprocess.RemoteWorkContinuation
    @NonNull
    @SuppressLint({"EnqueueWork"})
    protected RemoteWorkContinuation combineInternal(@NonNull List<RemoteWorkContinuation> list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<RemoteWorkContinuation> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((RemoteWorkContinuationImpl) it.next()).mContinuation);
        }
        return new RemoteWorkContinuationImpl(this.mClient, WorkContinuation.combine(arrayList));
    }
}
