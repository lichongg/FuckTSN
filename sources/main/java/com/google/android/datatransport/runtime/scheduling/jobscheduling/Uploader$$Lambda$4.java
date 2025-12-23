package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
final /* synthetic */ class Uploader$$Lambda$4 implements SynchronizationGuard.CriticalSection {
    private final EventStore arg$1;

    public static SynchronizationGuard.CriticalSection lambdaFactory$(EventStore eventStore) {
        return new Uploader$$Lambda$4(eventStore);
    }

    @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
    public Object execute() {
        return Integer.valueOf(this.arg$1.cleanUp());
    }

    private Uploader$$Lambda$4(EventStore eventStore) {
        this.arg$1 = eventStore;
    }
}
