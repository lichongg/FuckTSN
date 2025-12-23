package com.kwad.components.core.t;

import java.lang.ref.WeakReference;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class p implements Runnable {
    private WeakReference<Runnable> weakReference;

    @Override // java.lang.Runnable
    public final void run() {
        Runnable runnable = this.weakReference.get();
        if (runnable != null) {
            runnable.run();
        }
    }

    public p(Runnable runnable) {
        this.weakReference = new WeakReference<>(runnable);
    }
}
