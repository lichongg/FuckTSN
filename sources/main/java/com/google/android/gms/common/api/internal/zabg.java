package com.google.android.gms.common.api.internal;

import java.util.concurrent.locks.Lock;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
abstract class zabg {
    private final zabf zaa;

    protected abstract void zaa();

    protected zabg(zabf zabfVar) {
        this.zaa = zabfVar;
    }

    public final void zab(zabi zabiVar) {
        Lock lock;
        Lock lock2;
        zabf zabfVar;
        lock = zabiVar.zai;
        lock.lock();
        try {
            zabfVar = zabiVar.zan;
            if (zabfVar == this.zaa) {
                zaa();
            }
        } finally {
            lock2 = zabiVar.zai;
            lock2.unlock();
        }
    }
}
