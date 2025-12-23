package com.google.android.datatransport.runtime.scheduling;

import android.content.Context;
import com.google.android.datatransport.runtime.dagger.Binds;
import com.google.android.datatransport.runtime.dagger.Module;
import com.google.android.datatransport.runtime.dagger.Provides;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoScheduler;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.time.Clock;
import com.google.android.datatransport.runtime.time.Monotonic;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Module
/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class SchedulingModule {
    @Binds
    abstract Scheduler scheduler(DefaultScheduler defaultScheduler);

    @Provides
    static WorkScheduler workScheduler(Context context, EventStore eventStore, SchedulerConfig schedulerConfig, @Monotonic Clock clock) {
        return new JobInfoScheduler(context, eventStore, schedulerConfig);
    }
}
