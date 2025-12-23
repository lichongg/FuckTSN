package com.google.android.datatransport.runtime.time;

import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.dagger.internal.Preconditions;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public final class TimeModule_UptimeClockFactory implements Factory<Clock> {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class InstanceHolder {
        private static final TimeModule_UptimeClockFactory INSTANCE = new TimeModule_UptimeClockFactory();

        private InstanceHolder() {
        }
    }

    @Override // javax.inject.Provider
    public Clock get() {
        return uptimeClock();
    }

    public static TimeModule_UptimeClockFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static Clock uptimeClock() {
        return (Clock) Preconditions.checkNotNull(TimeModule.uptimeClock(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
