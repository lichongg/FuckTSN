package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
final /* synthetic */ class WorkInitializer$$Lambda$2 implements SynchronizationGuard.CriticalSection {
    private final WorkInitializer arg$1;

    public static SynchronizationGuard.CriticalSection lambdaFactory$(WorkInitializer workInitializer) {
        return new WorkInitializer$$Lambda$2(workInitializer);
    }

    @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
    public Object execute() {
        return WorkInitializer.lambda$ensureContextsScheduled$0(this.arg$1);
    }

    private WorkInitializer$$Lambda$2(WorkInitializer workInitializer) {
        this.arg$1 = workInitializer;
    }
}
