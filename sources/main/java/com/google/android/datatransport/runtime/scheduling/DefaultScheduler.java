package com.google.android.datatransport.runtime.scheduling;

import com.google.android.datatransport.TransportScheduleCallback;
import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.TransportRuntime;
import com.google.android.datatransport.runtime.backends.BackendRegistry;
import com.google.android.datatransport.runtime.backends.TransportBackend;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import java.util.concurrent.Executor;
import java.util.logging.Logger;
import javax.inject.Inject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public class DefaultScheduler implements Scheduler {
    private static final Logger LOGGER = Logger.getLogger(TransportRuntime.class.getName());
    private final BackendRegistry backendRegistry;
    private final EventStore eventStore;
    private final Executor executor;
    private final SynchronizationGuard guard;
    private final WorkScheduler workScheduler;

    static /* synthetic */ Object lambda$schedule$0(DefaultScheduler defaultScheduler, TransportContext transportContext, EventInternal eventInternal) {
        defaultScheduler.eventStore.persist(transportContext, eventInternal);
        defaultScheduler.workScheduler.schedule(transportContext, 1);
        return null;
    }

    static /* synthetic */ void lambda$schedule$1(DefaultScheduler defaultScheduler, TransportContext transportContext, TransportScheduleCallback transportScheduleCallback, EventInternal eventInternal) {
        try {
            TransportBackend transportBackend = defaultScheduler.backendRegistry.get(transportContext.getBackendName());
            if (transportBackend != null) {
                defaultScheduler.guard.runCriticalSection(DefaultScheduler$$Lambda$2.lambdaFactory$(defaultScheduler, transportContext, transportBackend.decorate(eventInternal)));
                transportScheduleCallback.onSchedule(null);
            } else {
                String format = String.format("Transport backend '%s' is not registered", transportContext.getBackendName());
                LOGGER.warning(format);
                transportScheduleCallback.onSchedule(new IllegalArgumentException(format));
            }
        } catch (Exception e6) {
            LOGGER.warning("Error scheduling event " + e6.getMessage());
            transportScheduleCallback.onSchedule(e6);
        }
    }

    @Override // com.google.android.datatransport.runtime.scheduling.Scheduler
    public void schedule(TransportContext transportContext, EventInternal eventInternal, TransportScheduleCallback transportScheduleCallback) {
        this.executor.execute(DefaultScheduler$$Lambda$1.lambdaFactory$(this, transportContext, transportScheduleCallback, eventInternal));
    }

    @Inject
    public DefaultScheduler(Executor executor, BackendRegistry backendRegistry, WorkScheduler workScheduler, EventStore eventStore, SynchronizationGuard synchronizationGuard) {
        this.executor = executor;
        this.backendRegistry = backendRegistry;
        this.workScheduler = workScheduler;
        this.eventStore = eventStore;
        this.guard = synchronizationGuard;
    }
}
