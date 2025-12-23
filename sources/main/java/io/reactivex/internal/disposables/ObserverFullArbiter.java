package io.reactivex.internal.disposables;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class ObserverFullArbiter<T> extends FullArbiterPad1 implements Disposable {
    final Observer<? super T> actual;
    volatile boolean cancelled;
    final SpscLinkedArrayQueue<Object> queue;
    Disposable resource;

    /* renamed from: s, reason: collision with root package name */
    volatile Disposable f43120s = EmptyDisposable.INSTANCE;

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        if (this.cancelled) {
            return;
        }
        this.cancelled = true;
        disposeResource();
    }

    void disposeResource() {
        Disposable disposable = this.resource;
        this.resource = null;
        if (disposable != null) {
            disposable.dispose();
        }
    }

    void drain() {
        if (this.wip.getAndIncrement() != 0) {
            return;
        }
        SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.queue;
        Observer<? super T> observer = this.actual;
        int i6 = 1;
        while (true) {
            Object poll = spscLinkedArrayQueue.poll();
            if (poll == null) {
                i6 = this.wip.addAndGet(-i6);
                if (i6 == 0) {
                    return;
                }
            } else {
                Object poll2 = spscLinkedArrayQueue.poll();
                if (poll == this.f43120s) {
                    if (NotificationLite.isDisposable(poll2)) {
                        Disposable disposable = NotificationLite.getDisposable(poll2);
                        this.f43120s.dispose();
                        if (this.cancelled) {
                            disposable.dispose();
                        } else {
                            this.f43120s = disposable;
                        }
                    } else if (NotificationLite.isError(poll2)) {
                        spscLinkedArrayQueue.clear();
                        disposeResource();
                        Throwable error = NotificationLite.getError(poll2);
                        if (this.cancelled) {
                            RxJavaPlugins.onError(error);
                        } else {
                            this.cancelled = true;
                            observer.onError(error);
                        }
                    } else if (NotificationLite.isComplete(poll2)) {
                        spscLinkedArrayQueue.clear();
                        disposeResource();
                        if (!this.cancelled) {
                            this.cancelled = true;
                            observer.onComplete();
                        }
                    } else {
                        observer.onNext((Object) NotificationLite.getValue(poll2));
                    }
                }
            }
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        Disposable disposable = this.resource;
        return disposable != null ? disposable.isDisposed() : this.cancelled;
    }

    public void onComplete(Disposable disposable) {
        this.queue.offer(disposable, NotificationLite.complete());
        drain();
    }

    public void onError(Throwable th, Disposable disposable) {
        if (this.cancelled) {
            RxJavaPlugins.onError(th);
        } else {
            this.queue.offer(disposable, NotificationLite.error(th));
            drain();
        }
    }

    public boolean onNext(T t5, Disposable disposable) {
        if (this.cancelled) {
            return false;
        }
        this.queue.offer(disposable, NotificationLite.next(t5));
        drain();
        return true;
    }

    public boolean setDisposable(Disposable disposable) {
        if (this.cancelled) {
            return false;
        }
        this.queue.offer(this.f43120s, NotificationLite.disposable(disposable));
        drain();
        return true;
    }

    public ObserverFullArbiter(Observer<? super T> observer, Disposable disposable, int i6) {
        this.actual = observer;
        this.resource = disposable;
        this.queue = new SpscLinkedArrayQueue<>(i6);
    }
}
