package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
final /* synthetic */ class Uploader$$Lambda$2 implements SynchronizationGuard.CriticalSection {
    private final Uploader arg$1;
    private final TransportContext arg$2;

    public static SynchronizationGuard.CriticalSection lambdaFactory$(Uploader uploader, TransportContext transportContext) {
        return new Uploader$$Lambda$2(uploader, transportContext);
    }

    @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
    public Object execute() {
        return Uploader.lambda$logAndUpdateState$2(this.arg$1, this.arg$2);
    }

    private Uploader$$Lambda$2(Uploader uploader, TransportContext transportContext) {
        this.arg$1 = uploader;
        this.arg$2 = transportContext;
    }
}
