package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.backends.BackendRegistry;
import com.google.android.datatransport.runtime.backends.BackendRequest;
import com.google.android.datatransport.runtime.backends.BackendResponse;
import com.google.android.datatransport.runtime.backends.TransportBackend;
import com.google.android.datatransport.runtime.logging.Logging;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.scheduling.persistence.PersistedEvent;
import com.google.android.datatransport.runtime.synchronization.SynchronizationException;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.google.android.datatransport.runtime.time.Clock;
import com.google.android.datatransport.runtime.time.WallTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Executor;
import javax.inject.Inject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public class Uploader {
    private static final String LOG_TAG = "Uploader";
    private final BackendRegistry backendRegistry;
    private final Clock clock;
    private final Context context;
    private final EventStore eventStore;
    private final Executor executor;
    private final SynchronizationGuard guard;
    private final WorkScheduler workScheduler;

    static /* synthetic */ Iterable lambda$logAndUpdateState$2(Uploader uploader, TransportContext transportContext) {
        return uploader.eventStore.loadBatch(transportContext);
    }

    static /* synthetic */ Object lambda$upload$0(Uploader uploader, TransportContext transportContext, int i6) {
        uploader.workScheduler.schedule(transportContext, i6 + 1);
        return null;
    }

    static /* synthetic */ void lambda$upload$1(Uploader uploader, TransportContext transportContext, int i6, Runnable runnable) {
        try {
            try {
                SynchronizationGuard synchronizationGuard = uploader.guard;
                EventStore eventStore = uploader.eventStore;
                eventStore.getClass();
                synchronizationGuard.runCriticalSection(Uploader$$Lambda$4.lambdaFactory$(eventStore));
                if (uploader.isNetworkAvailable()) {
                    uploader.logAndUpdateState(transportContext, i6);
                } else {
                    uploader.guard.runCriticalSection(Uploader$$Lambda$5.lambdaFactory$(uploader, transportContext, i6));
                }
                runnable.run();
            } catch (SynchronizationException unused) {
                uploader.workScheduler.schedule(transportContext, i6 + 1);
                runnable.run();
            }
        } catch (Throwable th) {
            runnable.run();
            throw th;
        }
    }

    boolean isNetworkAvailable() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    void logAndUpdateState(TransportContext transportContext, int i6) {
        BackendResponse send;
        TransportBackend transportBackend = this.backendRegistry.get(transportContext.getBackendName());
        Iterable iterable = (Iterable) this.guard.runCriticalSection(Uploader$$Lambda$2.lambdaFactory$(this, transportContext));
        if (iterable.iterator().hasNext()) {
            if (transportBackend == null) {
                Logging.d(LOG_TAG, "Unknown backend for %s, deleting event batch for it...", transportContext);
                send = BackendResponse.fatalError();
            } else {
                ArrayList arrayList = new ArrayList();
                Iterator it = iterable.iterator();
                while (it.hasNext()) {
                    arrayList.add(((PersistedEvent) it.next()).getEvent());
                }
                send = transportBackend.send(BackendRequest.builder().setEvents(arrayList).setExtras(transportContext.getExtras()).build());
            }
            this.guard.runCriticalSection(Uploader$$Lambda$3.lambdaFactory$(this, send, iterable, transportContext, i6));
        }
    }

    public void upload(TransportContext transportContext, int i6, Runnable runnable) {
        this.executor.execute(Uploader$$Lambda$1.lambdaFactory$(this, transportContext, i6, runnable));
    }

    @Inject
    public Uploader(Context context, BackendRegistry backendRegistry, EventStore eventStore, WorkScheduler workScheduler, Executor executor, SynchronizationGuard synchronizationGuard, @WallTime Clock clock) {
        this.context = context;
        this.backendRegistry = backendRegistry;
        this.eventStore = eventStore;
        this.workScheduler = workScheduler;
        this.executor = executor;
        this.guard = synchronizationGuard;
        this.clock = clock;
    }

    static /* synthetic */ Object lambda$logAndUpdateState$3(Uploader uploader, BackendResponse backendResponse, Iterable iterable, TransportContext transportContext, int i6) {
        if (backendResponse.getStatus() == BackendResponse.Status.TRANSIENT_ERROR) {
            uploader.eventStore.recordFailure(iterable);
            uploader.workScheduler.schedule(transportContext, i6 + 1);
            return null;
        }
        uploader.eventStore.recordSuccess(iterable);
        if (backendResponse.getStatus() == BackendResponse.Status.OK) {
            uploader.eventStore.recordNextCallTime(transportContext, uploader.clock.getTime() + backendResponse.getNextRequestWaitMillis());
        }
        if (uploader.eventStore.hasPendingEventsFor(transportContext)) {
            uploader.workScheduler.schedule(transportContext, 1, true);
            return null;
        }
        return null;
    }
}
