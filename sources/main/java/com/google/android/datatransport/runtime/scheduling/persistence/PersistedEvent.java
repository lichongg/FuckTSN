package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.auto.value.AutoValue;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@AutoValue
/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class PersistedEvent {
    public abstract EventInternal getEvent();

    public abstract long getId();

    public abstract TransportContext getTransportContext();

    public static PersistedEvent create(long j6, TransportContext transportContext, EventInternal eventInternal) {
        return new AutoValue_PersistedEvent(j6, transportContext, eventInternal);
    }
}
