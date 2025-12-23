package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class CompletableDelay extends Completable {
    final long delay;
    final boolean delayError;
    final Scheduler scheduler;
    final CompletableSource source;
    final TimeUnit unit;

    @Override // io.reactivex.Completable
    protected void subscribeActual(final CompletableObserver completableObserver) {
        final CompositeDisposable compositeDisposable = new CompositeDisposable();
        this.source.subscribe(new CompletableObserver() { // from class: io.reactivex.internal.operators.completable.CompletableDelay.1
            @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
            public void onComplete() {
                CompositeDisposable compositeDisposable2 = compositeDisposable;
                Scheduler scheduler = CompletableDelay.this.scheduler;
                Runnable runnable = new Runnable() { // from class: io.reactivex.internal.operators.completable.CompletableDelay.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        completableObserver.onComplete();
                    }
                };
                CompletableDelay completableDelay = CompletableDelay.this;
                compositeDisposable2.add(scheduler.scheduleDirect(runnable, completableDelay.delay, completableDelay.unit));
            }

            @Override // io.reactivex.CompletableObserver
            public void onError(final Throwable th) {
                CompositeDisposable compositeDisposable2 = compositeDisposable;
                Scheduler scheduler = CompletableDelay.this.scheduler;
                Runnable runnable = new Runnable() { // from class: io.reactivex.internal.operators.completable.CompletableDelay.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        completableObserver.onError(th);
                    }
                };
                CompletableDelay completableDelay = CompletableDelay.this;
                compositeDisposable2.add(scheduler.scheduleDirect(runnable, completableDelay.delayError ? completableDelay.delay : 0L, completableDelay.unit));
            }

            @Override // io.reactivex.CompletableObserver
            public void onSubscribe(Disposable disposable) {
                compositeDisposable.add(disposable);
                completableObserver.onSubscribe(compositeDisposable);
            }
        });
    }

    public CompletableDelay(CompletableSource completableSource, long j6, TimeUnit timeUnit, Scheduler scheduler, boolean z5) {
        this.source = completableSource;
        this.delay = j6;
        this.unit = timeUnit;
        this.scheduler = scheduler;
        this.delayError = z5;
    }
}
