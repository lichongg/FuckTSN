package com.google.android.gms.common.api.internal;

import java.util.concurrent.locks.Lock;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zav implements Runnable {
    final /* synthetic */ zaaa zaa;

    zav(zaaa zaaaVar) {
        this.zaa = zaaaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Lock lock;
        Lock lock2;
        lock = this.zaa.zam;
        lock.lock();
        try {
            zaaa.zap(this.zaa);
        } finally {
            lock2 = this.zaa.zam;
            lock2.unlock();
        }
    }
}
