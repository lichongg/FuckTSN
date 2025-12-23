package com.google.android.datatransport.runtime;

import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.scheduling.Scheduler;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkInitializer;
import com.google.android.datatransport.runtime.time.Clock;
import javax.inject.Provider;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public final class TransportRuntime_Factory implements Factory<TransportRuntime> {
    private final Provider<Clock> eventClockProvider;
    private final Provider<WorkInitializer> initializerProvider;
    private final Provider<Scheduler> schedulerProvider;
    private final Provider<Uploader> uploaderProvider;
    private final Provider<Clock> uptimeClockProvider;

    public static TransportRuntime_Factory create(Provider<Clock> provider, Provider<Clock> provider2, Provider<Scheduler> provider3, Provider<Uploader> provider4, Provider<WorkInitializer> provider5) {
        return new TransportRuntime_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static TransportRuntime newInstance(Clock clock, Clock clock2, Scheduler scheduler, Uploader uploader, WorkInitializer workInitializer) {
        return new TransportRuntime(clock, clock2, scheduler, uploader, workInitializer);
    }

    @Override // javax.inject.Provider
    public TransportRuntime get() {
        return newInstance(this.eventClockProvider.get(), this.uptimeClockProvider.get(), this.schedulerProvider.get(), this.uploaderProvider.get(), this.initializerProvider.get());
    }

    public TransportRuntime_Factory(Provider<Clock> provider, Provider<Clock> provider2, Provider<Scheduler> provider3, Provider<Uploader> provider4, Provider<WorkInitializer> provider5) {
        this.eventClockProvider = provider;
        this.uptimeClockProvider = provider2;
        this.schedulerProvider = provider3;
        this.uploaderProvider = provider4;
        this.initializerProvider = provider5;
    }
}
