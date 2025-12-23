package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class CompletableMerge extends Completable {
    final boolean delayErrors;
    final int maxConcurrency;
    final Publisher<? extends CompletableSource> source;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class CompletableMergeSubscriber extends AtomicInteger implements Subscriber<CompletableSource>, Disposable {
        private static final long serialVersionUID = -2108443387387077490L;
        final CompletableObserver actual;
        final boolean delayErrors;
        final int maxConcurrency;

        /* renamed from: s, reason: collision with root package name */
        Subscription f43139s;
        final CompositeDisposable set = new CompositeDisposable();
        final AtomicThrowable error = new AtomicThrowable();

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        final class MergeInnerObserver extends AtomicReference<Disposable> implements CompletableObserver, Disposable {
            private static final long serialVersionUID = 251330541679988317L;

            MergeInnerObserver() {
            }

            @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
            public void onComplete() {
                CompletableMergeSubscriber.this.innerComplete(this);
            }

            @Override // io.reactivex.CompletableObserver
            public void onError(Throwable th) {
                CompletableMergeSubscriber.this.innerError(this, th);
            }

            @Override // io.reactivex.disposables.Disposable
            public void dispose() {
                DisposableHelper.dispose(this);
            }

            @Override // io.reactivex.disposables.Disposable
            public boolean isDisposed() {
                return DisposableHelper.isDisposed(get());
            }

            @Override // io.reactivex.CompletableObserver
            public void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this, disposable);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f43139s.cancel();
            this.set.dispose();
        }

        void innerComplete(MergeInnerObserver mergeInnerObserver) {
            this.set.delete(mergeInnerObserver);
            if (decrementAndGet() != 0) {
                if (this.maxConcurrency != Integer.MAX_VALUE) {
                    this.f43139s.request(1L);
                }
            } else {
                Throwable th = this.error.get();
                if (th != null) {
                    this.actual.onError(th);
                } else {
                    this.actual.onComplete();
                }
            }
        }

        void innerError(MergeInnerObserver mergeInnerObserver, Throwable th) {
            this.set.delete(mergeInnerObserver);
            if (!this.delayErrors) {
                this.f43139s.cancel();
                this.set.dispose();
                if (!this.error.addThrowable(th)) {
                    RxJavaPlugins.onError(th);
                    return;
                } else {
                    if (getAndSet(0) > 0) {
                        this.actual.onError(this.error.terminate());
                        return;
                    }
                    return;
                }
            }
            if (!this.error.addThrowable(th)) {
                RxJavaPlugins.onError(th);
            } else if (decrementAndGet() == 0) {
                this.actual.onError(this.error.terminate());
            } else if (this.maxConcurrency != Integer.MAX_VALUE) {
                this.f43139s.request(1L);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.set.isDisposed();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.delayErrors) {
                if (!this.error.addThrowable(th)) {
                    RxJavaPlugins.onError(th);
                    return;
                } else {
                    if (decrementAndGet() == 0) {
                        this.actual.onError(this.error.terminate());
                        return;
                    }
                    return;
                }
            }
            this.set.dispose();
            if (!this.error.addThrowable(th)) {
                RxJavaPlugins.onError(th);
            } else if (getAndSet(0) > 0) {
                this.actual.onError(this.error.terminate());
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(CompletableSource completableSource) {
            getAndIncrement();
            MergeInnerObserver mergeInnerObserver = new MergeInnerObserver();
            this.set.add(mergeInnerObserver);
            completableSource.subscribe(mergeInnerObserver);
        }

        @Override // org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f43139s, subscription)) {
                this.f43139s = subscription;
                this.actual.onSubscribe(this);
                int i6 = this.maxConcurrency;
                if (i6 == Integer.MAX_VALUE) {
                    subscription.request(Long.MAX_VALUE);
                } else {
                    subscription.request(i6);
                }
            }
        }

        CompletableMergeSubscriber(CompletableObserver completableObserver, int i6, boolean z5) {
            this.actual = completableObserver;
            this.maxConcurrency = i6;
            this.delayErrors = z5;
            lazySet(1);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (decrementAndGet() == 0) {
                if (this.error.get() != null) {
                    this.actual.onError(this.error.terminate());
                } else {
                    this.actual.onComplete();
                }
            }
        }
    }

    @Override // io.reactivex.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        this.source.subscribe(new CompletableMergeSubscriber(completableObserver, this.maxConcurrency, this.delayErrors));
    }

    public CompletableMerge(Publisher<? extends CompletableSource> publisher, int i6, boolean z5) {
        this.source = publisher;
        this.maxConcurrency = i6;
        this.delayErrors = z5;
    }
}
