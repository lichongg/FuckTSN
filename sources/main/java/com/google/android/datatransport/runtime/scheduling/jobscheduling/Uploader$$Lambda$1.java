package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.TransportContext;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
final /* synthetic */ class Uploader$$Lambda$1 implements Runnable {
    private final Uploader arg$1;
    private final TransportContext arg$2;
    private final int arg$3;
    private final Runnable arg$4;

    public static Runnable lambdaFactory$(Uploader uploader, TransportContext transportContext, int i6, Runnable runnable) {
        return new Uploader$$Lambda$1(uploader, transportContext, i6, runnable);
    }

    @Override // java.lang.Runnable
    public void run() {
        Uploader.lambda$upload$1(this.arg$1, this.arg$2, this.arg$3, this.arg$4);
    }

    private Uploader$$Lambda$1(Uploader uploader, TransportContext transportContext, int i6, Runnable runnable) {
        this.arg$1 = uploader;
        this.arg$2 = transportContext;
        this.arg$3 = i6;
        this.arg$4 = runnable;
    }
}
