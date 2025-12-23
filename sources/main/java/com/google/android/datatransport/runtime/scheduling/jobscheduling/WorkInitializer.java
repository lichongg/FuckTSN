package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import java.util.Iterator;
import java.util.concurrent.Executor;
import javax.inject.Inject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public class WorkInitializer {
    private final Executor executor;
    private final SynchronizationGuard guard;
    private final WorkScheduler scheduler;
    private final EventStore store;

    static /* synthetic */ Object lambda$ensureContextsScheduled$0(WorkInitializer workInitializer) {
        Iterator<TransportContext> it = workInitializer.store.loadActiveContexts().iterator();
        while (it.hasNext()) {
            workInitializer.scheduler.schedule(it.next(), 1);
        }
        return null;
    }

    public void ensureContextsScheduled() {
        this.executor.execute(WorkInitializer$$Lambda$1.lambdaFactory$(this));
    }

    @Inject
    WorkInitializer(Executor executor, EventStore eventStore, WorkScheduler workScheduler, SynchronizationGuard synchronizationGuard) {
        this.executor = executor;
        this.store = eventStore;
        this.scheduler = workScheduler;
        this.guard = synchronizationGuard;
    }
}
