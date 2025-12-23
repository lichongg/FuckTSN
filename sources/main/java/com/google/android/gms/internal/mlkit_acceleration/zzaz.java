package com.google.android.gms.internal.mlkit_acceleration;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.LockSupport;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
abstract class zzaz extends AtomicReference implements Runnable {
    private static final Runnable zza = new zzay(null);
    private static final Runnable zzb = new zzay(null);

    abstract Object zza() throws Exception;

    abstract String zzb();

    abstract void zzc(Throwable th);

    abstract void zzd(Object obj);

    abstract boolean zzf();

    zzaz() {
    }

    private final void zzg(Thread thread) {
        Runnable runnable = (Runnable) get();
        zzaw zzawVar = null;
        boolean z5 = false;
        int i6 = 0;
        while (true) {
            if (!(runnable instanceof zzaw)) {
                if (runnable != zzb) {
                    break;
                }
            } else {
                zzawVar = (zzaw) runnable;
            }
            i6++;
            if (i6 > 1000) {
                Runnable runnable2 = zzb;
                if (runnable == runnable2 || compareAndSet(runnable, runnable2)) {
                    if (Thread.interrupted() || z5) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    LockSupport.park(zzawVar);
                }
            } else {
                Thread.yield();
            }
            runnable = (Runnable) get();
        }
        if (z5) {
            thread.interrupt();
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        Thread currentThread = Thread.currentThread();
        Object obj = null;
        if (compareAndSet(null, currentThread)) {
            boolean zzf = zzf();
            if (!zzf) {
                try {
                    obj = zza();
                } catch (Throwable th) {
                    try {
                        if (th instanceof InterruptedException) {
                            Thread.currentThread().interrupt();
                        }
                        if (!compareAndSet(currentThread, zza)) {
                            zzg(currentThread);
                        }
                        zzc(th);
                        return;
                    } catch (Throwable th2) {
                        if (!compareAndSet(currentThread, zza)) {
                            zzg(currentThread);
                        }
                        zzd(null);
                        throw th2;
                    }
                }
            }
            if (!compareAndSet(currentThread, zza)) {
                zzg(currentThread);
            }
            if (!zzf) {
                zzd(obj);
            }
        }
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public final String toString() {
        String str;
        Runnable runnable = (Runnable) get();
        if (runnable == zza) {
            str = "running=[DONE]";
        } else if (runnable instanceof zzaw) {
            str = "running=[INTERRUPTED]";
        } else if (runnable instanceof Thread) {
            str = "running=[RUNNING ON " + ((Thread) runnable).getName() + "]";
        } else {
            str = "running=[NOT STARTED YET]";
        }
        return str + ", " + zzb();
    }

    final void zze() {
        Runnable runnable = (Runnable) get();
        if (runnable instanceof Thread) {
            zzaw zzawVar = new zzaw(this, null);
            super/*java.util.concurrent.locks.AbstractOwnableSynchronizer*/.setExclusiveOwnerThread(Thread.currentThread());
            if (compareAndSet(runnable, zzawVar)) {
                try {
                    Thread thread = (Thread) runnable;
                    thread.interrupt();
                    if (((Runnable) getAndSet(zza)) == zzb) {
                        LockSupport.unpark(thread);
                    }
                } catch (Throwable th) {
                    if (((Runnable) getAndSet(zza)) == zzb) {
                        LockSupport.unpark((Thread) runnable);
                    }
                    throw th;
                }
            }
        }
    }
}
