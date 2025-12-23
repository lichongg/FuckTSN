package com.kwad.sdk.core.network;

import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.utils.bg;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public abstract class a<R extends f> {
    private static final ExecutorService sExecutors = GlobalThreadPools.Jt();
    private Future<?> mTask;

    @NonNull
    protected abstract R createRequest();

    @WorkerThread
    protected abstract void fetchImpl();

    protected abstract void onResponse(R r5, c cVar);

    @CallSuper
    protected void cancel() {
        Future<?> future = this.mTask;
        if (future != null) {
            future.cancel(true);
        }
    }

    protected ExecutorService getExecutor() {
        return sExecutors;
    }

    protected void fetch() {
        this.mTask = getExecutor().submit(new bg() { // from class: com.kwad.sdk.core.network.a.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                a.this.fetchImpl();
            }
        });
    }
}
