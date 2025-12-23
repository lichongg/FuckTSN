package com.google.android.datatransport.runtime.scheduling.jobscheduling;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
final /* synthetic */ class WorkInitializer$$Lambda$1 implements Runnable {
    private final WorkInitializer arg$1;

    public static Runnable lambdaFactory$(WorkInitializer workInitializer) {
        return new WorkInitializer$$Lambda$1(workInitializer);
    }

    @Override // java.lang.Runnable
    public void run() {
        r0.guard.runCriticalSection(WorkInitializer$$Lambda$2.lambdaFactory$(this.arg$1));
    }

    private WorkInitializer$$Lambda$1(WorkInitializer workInitializer) {
        this.arg$1 = workInitializer;
    }
}
