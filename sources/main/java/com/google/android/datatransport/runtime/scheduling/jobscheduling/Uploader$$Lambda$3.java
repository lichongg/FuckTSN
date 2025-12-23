package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.backends.BackendResponse;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
final /* synthetic */ class Uploader$$Lambda$3 implements SynchronizationGuard.CriticalSection {
    private final Uploader arg$1;
    private final BackendResponse arg$2;
    private final Iterable arg$3;
    private final TransportContext arg$4;
    private final int arg$5;

    public static SynchronizationGuard.CriticalSection lambdaFactory$(Uploader uploader, BackendResponse backendResponse, Iterable iterable, TransportContext transportContext, int i6) {
        return new Uploader$$Lambda$3(uploader, backendResponse, iterable, transportContext, i6);
    }

    @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
    public Object execute() {
        return Uploader.lambda$logAndUpdateState$3(this.arg$1, this.arg$2, this.arg$3, this.arg$4, this.arg$5);
    }

    private Uploader$$Lambda$3(Uploader uploader, BackendResponse backendResponse, Iterable iterable, TransportContext transportContext, int i6) {
        this.arg$1 = uploader;
        this.arg$2 = backendResponse;
        this.arg$3 = iterable;
        this.arg$4 = transportContext;
        this.arg$5 = i6;
    }
}
