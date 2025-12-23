package com.google.android.datatransport.runtime.scheduling;

import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.dagger.internal.Preconditions;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import com.google.android.datatransport.runtime.time.Clock;
import javax.inject.Provider;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public final class SchedulingConfigModule_ConfigFactory implements Factory<SchedulerConfig> {
    private final Provider<Clock> clockProvider;

    public static SchedulingConfigModule_ConfigFactory create(Provider<Clock> provider) {
        return new SchedulingConfigModule_ConfigFactory(provider);
    }

    @Override // javax.inject.Provider
    public SchedulerConfig get() {
        return config(this.clockProvider.get());
    }

    public SchedulingConfigModule_ConfigFactory(Provider<Clock> provider) {
        this.clockProvider = provider;
    }

    public static SchedulerConfig config(Clock clock) {
        return (SchedulerConfig) Preconditions.checkNotNull(SchedulingConfigModule.config(clock), "Cannot return null from a non-@Nullable @Provides method");
    }
}
