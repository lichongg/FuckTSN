package com.google.android.gms.common.api.internal;

import androidx.annotation.WorkerThread;
import java.util.concurrent.locks.Lock;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
abstract class zaav implements Runnable {
    final /* synthetic */ zaaw zab;

    @WorkerThread
    protected abstract void zaa();

    @Override // java.lang.Runnable
    @WorkerThread
    public final void run() {
        Lock lock;
        Lock lock2;
        zabi zabiVar;
        lock = this.zab.zab;
        lock.lock();
        try {
            try {
                if (!Thread.interrupted()) {
                    zaa();
                }
            } catch (RuntimeException e6) {
                zabiVar = this.zab.zaa;
                zabiVar.zam(e6);
            }
        } finally {
            lock2 = this.zab.zab;
            lock2.unlock();
        }
    }
}
