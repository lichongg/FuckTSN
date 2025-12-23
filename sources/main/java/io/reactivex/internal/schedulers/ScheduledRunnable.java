package io.reactivex.internal.schedulers;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableContainer;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class ScheduledRunnable extends AtomicReferenceArray<Object> implements Runnable, Callable<Object>, Disposable {
    static final Object DISPOSED = new Object();
    static final Object DONE = new Object();
    static final int FUTURE_INDEX = 1;
    static final int PARENT_INDEX = 0;
    private static final long serialVersionUID = -6120223772001106981L;
    final Runnable actual;

    public ScheduledRunnable(Runnable runnable, DisposableContainer disposableContainer) {
        super(2);
        this.actual = runnable;
        lazySet(0, disposableContainer);
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        Object obj;
        Object obj2;
        Object obj3;
        while (true) {
            Object obj4 = get(1);
            if (obj4 == DONE || obj4 == (obj3 = DISPOSED)) {
                break;
            } else if (compareAndSet(1, obj4, obj3)) {
                if (obj4 != null) {
                    ((Future) obj4).cancel(true);
                }
            }
        }
        do {
            obj = get(0);
            if (obj == DONE || obj == (obj2 = DISPOSED) || obj == null) {
                return;
            }
        } while (!compareAndSet(0, obj, obj2));
        ((DisposableContainer) obj).delete(this);
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        Object obj = get(1);
        return obj == DISPOSED || obj == DONE;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0033 A[SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void run() {
        /*
            r5 = this;
            r0 = 1
            r1 = 0
            java.lang.Runnable r2 = r5.actual     // Catch: java.lang.Throwable -> L8
            r2.run()     // Catch: java.lang.Throwable -> L8
            goto Lc
        L8:
            r2 = move-exception
            io.reactivex.plugins.RxJavaPlugins.onError(r2)     // Catch: java.lang.Throwable -> L34
        Lc:
            java.lang.Object r2 = r5.get(r1)
            java.lang.Object r3 = io.reactivex.internal.schedulers.ScheduledRunnable.DISPOSED
            if (r2 == r3) goto L23
            if (r2 == 0) goto L23
            java.lang.Object r3 = io.reactivex.internal.schedulers.ScheduledRunnable.DONE
            boolean r1 = r5.compareAndSet(r1, r2, r3)
            if (r1 == 0) goto L23
            io.reactivex.internal.disposables.DisposableContainer r2 = (io.reactivex.internal.disposables.DisposableContainer) r2
            r2.delete(r5)
        L23:
            java.lang.Object r1 = r5.get(r0)
            java.lang.Object r2 = io.reactivex.internal.schedulers.ScheduledRunnable.DISPOSED
            if (r1 == r2) goto L33
            java.lang.Object r2 = io.reactivex.internal.schedulers.ScheduledRunnable.DONE
            boolean r1 = r5.compareAndSet(r0, r1, r2)
            if (r1 == 0) goto L23
        L33:
            return
        L34:
            r2 = move-exception
            java.lang.Object r3 = r5.get(r1)
            java.lang.Object r4 = io.reactivex.internal.schedulers.ScheduledRunnable.DISPOSED
            if (r3 == r4) goto L4c
            if (r3 == 0) goto L4c
            java.lang.Object r4 = io.reactivex.internal.schedulers.ScheduledRunnable.DONE
            boolean r1 = r5.compareAndSet(r1, r3, r4)
            if (r1 == 0) goto L4c
            io.reactivex.internal.disposables.DisposableContainer r3 = (io.reactivex.internal.disposables.DisposableContainer) r3
            r3.delete(r5)
        L4c:
            java.lang.Object r1 = r5.get(r0)
            java.lang.Object r3 = io.reactivex.internal.schedulers.ScheduledRunnable.DISPOSED
            if (r1 == r3) goto L5d
            java.lang.Object r3 = io.reactivex.internal.schedulers.ScheduledRunnable.DONE
            boolean r1 = r5.compareAndSet(r0, r1, r3)
            if (r1 != 0) goto L5d
            goto L4c
        L5d:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.schedulers.ScheduledRunnable.run():void");
    }

    public void setFuture(Future<?> future) {
        Object obj;
        do {
            obj = get(1);
            if (obj == DONE) {
                return;
            }
            if (obj == DISPOSED) {
                future.cancel(true);
                return;
            }
        } while (!compareAndSet(1, obj, future));
    }

    @Override // java.util.concurrent.Callable
    public Object call() {
        run();
        return null;
    }
}
