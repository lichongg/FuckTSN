package com.kwad.sdk.utils.a;

import java.util.concurrent.Executor;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class f implements Executor {
    private Runnable bcJ;
    private Runnable bcK;

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void scheduleNext() {
        Runnable runnable = this.bcK;
        this.bcJ = runnable;
        this.bcK = null;
        if (runnable != null) {
            d.getExecutor().execute(this.bcJ);
        }
    }

    @Override // java.util.concurrent.Executor
    public final synchronized void execute(Runnable runnable) {
        if (this.bcJ == null) {
            this.bcJ = d(runnable);
            d.getExecutor().execute(this.bcJ);
        } else {
            if (this.bcK == null) {
                this.bcK = d(runnable);
            }
        }
    }

    private Runnable d(final Runnable runnable) {
        return new Runnable() { // from class: com.kwad.sdk.utils.a.f.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    runnable.run();
                } finally {
                    f.this.scheduleNext();
                }
            }
        };
    }
}
