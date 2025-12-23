package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class FlowableZip<T, R> extends Flowable<R> {
    final int bufferSize;
    final boolean delayError;
    final Publisher<? extends T>[] sources;
    final Iterable<? extends Publisher<? extends T>> sourcesIterable;
    final Function<? super Object[], ? extends R> zipper;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class ZipCoordinator<T, R> extends AtomicInteger implements Subscription {
        private static final long serialVersionUID = -2434867452883857743L;
        final Subscriber<? super R> actual;
        volatile boolean cancelled;
        final Object[] current;
        final boolean delayErrors;
        volatile boolean done;
        final AtomicThrowable errors;
        final AtomicLong requested;
        final ZipSubscriber<T, R>[] subscribers;
        final Function<? super Object[], ? extends R> zipper;

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            cancelAll();
        }

        void cancelAll() {
            for (ZipSubscriber<T, R> zipSubscriber : this.subscribers) {
                zipSubscriber.cancel();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:101:0x013c, code lost:
        
            io.reactivex.exceptions.Exceptions.throwIfFatal(r0);
            r20.errors.addThrowable(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:102:0x0146, code lost:
        
            if (r20.delayErrors == false) goto L111;
         */
        /* JADX WARN: Code restructure failed: missing block: B:104:0x0148, code lost:
        
            cancelAll();
            r2.onError(r20.errors.terminate());
         */
        /* JADX WARN: Code restructure failed: missing block: B:105:0x0154, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:110:?, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:112:0x015a, code lost:
        
            if (r12 == r17) goto L100;
         */
        /* JADX WARN: Code restructure failed: missing block: B:113:0x015c, code lost:
        
            r0 = r3.length;
         */
        /* JADX WARN: Code restructure failed: missing block: B:114:0x015d, code lost:
        
            if (r15 >= r0) goto L128;
         */
        /* JADX WARN: Code restructure failed: missing block: B:115:0x015f, code lost:
        
            r3[r15].request(r12);
            r15 = r15 + 1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:118:0x016e, code lost:
        
            if (r8 == Long.MAX_VALUE) goto L100;
         */
        /* JADX WARN: Code restructure failed: missing block: B:119:0x0170, code lost:
        
            r20.requested.addAndGet(-r12);
         */
        /* JADX WARN: Code restructure failed: missing block: B:120:0x0176, code lost:
        
            r7 = addAndGet(-r7);
         */
        /* JADX WARN: Code restructure failed: missing block: B:63:0x00db, code lost:
        
            if (r8 != r12) goto L92;
         */
        /* JADX WARN: Code restructure failed: missing block: B:65:0x00df, code lost:
        
            if (r20.cancelled == false) goto L59;
         */
        /* JADX WARN: Code restructure failed: missing block: B:67:0x00e5, code lost:
        
            if (r20.delayErrors != false) goto L65;
         */
        /* JADX WARN: Code restructure failed: missing block: B:69:0x00ed, code lost:
        
            if (r20.errors.get() == null) goto L65;
         */
        /* JADX WARN: Code restructure failed: missing block: B:71:0x00ef, code lost:
        
            cancelAll();
            r2.onError(r20.errors.terminate());
         */
        /* JADX WARN: Code restructure failed: missing block: B:72:0x00fb, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:73:0x00fc, code lost:
        
            r6 = 0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:74:0x00fd, code lost:
        
            if (r6 >= r4) goto L123;
         */
        /* JADX WARN: Code restructure failed: missing block: B:75:0x00ff, code lost:
        
            r0 = r3[r6];
         */
        /* JADX WARN: Code restructure failed: missing block: B:76:0x0103, code lost:
        
            if (r5[r6] != null) goto L124;
         */
        /* JADX WARN: Code restructure failed: missing block: B:78:0x0105, code lost:
        
            r10 = r0.done;
            r0 = r0.queue;
         */
        /* JADX WARN: Code restructure failed: missing block: B:79:0x0109, code lost:
        
            if (r0 == null) goto L74;
         */
        /* JADX WARN: Code restructure failed: missing block: B:80:0x010b, code lost:
        
            r0 = r0.poll();
         */
        /* JADX WARN: Code restructure failed: missing block: B:81:0x0113, code lost:
        
            if (r0 != null) goto L77;
         */
        /* JADX WARN: Code restructure failed: missing block: B:82:0x0115, code lost:
        
            r11 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:83:0x0118, code lost:
        
            if (r10 == false) goto L84;
         */
        /* JADX WARN: Code restructure failed: missing block: B:84:0x011a, code lost:
        
            if (r11 == false) goto L84;
         */
        /* JADX WARN: Code restructure failed: missing block: B:86:0x011c, code lost:
        
            cancelAll();
         */
        /* JADX WARN: Code restructure failed: missing block: B:87:0x0127, code lost:
        
            if (r20.errors.get() == null) goto L83;
         */
        /* JADX WARN: Code restructure failed: missing block: B:88:0x0129, code lost:
        
            r2.onError(r20.errors.terminate());
         */
        /* JADX WARN: Code restructure failed: missing block: B:89:?, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:90:0x0133, code lost:
        
            r2.onComplete();
         */
        /* JADX WARN: Code restructure failed: missing block: B:91:?, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:92:0x0137, code lost:
        
            if (r11 != false) goto L125;
         */
        /* JADX WARN: Code restructure failed: missing block: B:93:0x0139, code lost:
        
            r5[r6] = r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:95:0x0155, code lost:
        
            r6 = r6 + 1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:97:0x0117, code lost:
        
            r11 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:98:0x0112, code lost:
        
            r0 = null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:99:0x0110, code lost:
        
            r0 = move-exception;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void drain() {
            /*
                Method dump skipped, instructions count: 382
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableZip.ZipCoordinator.drain():void");
        }

        void error(ZipSubscriber<T, R> zipSubscriber, Throwable th) {
            if (!this.errors.addThrowable(th)) {
                RxJavaPlugins.onError(th);
            } else {
                zipSubscriber.done = true;
                drain();
            }
        }

        void subscribe(Publisher<? extends T>[] publisherArr, int i6) {
            ZipSubscriber<T, R>[] zipSubscriberArr = this.subscribers;
            for (int i7 = 0; i7 < i6 && !this.done && !this.cancelled; i7++) {
                if (!this.delayErrors && this.errors.get() != null) {
                    return;
                }
                publisherArr[i7].subscribe(zipSubscriberArr[i7]);
            }
        }

        ZipCoordinator(Subscriber<? super R> subscriber, Function<? super Object[], ? extends R> function, int i6, int i7, boolean z5) {
            this.actual = subscriber;
            this.zipper = function;
            this.delayErrors = z5;
            ZipSubscriber<T, R>[] zipSubscriberArr = new ZipSubscriber[i6];
            for (int i8 = 0; i8 < i6; i8++) {
                zipSubscriberArr[i8] = new ZipSubscriber<>(this, i7, i8);
            }
            this.current = new Object[i6];
            this.subscribers = zipSubscriberArr;
            this.requested = new AtomicLong();
            this.errors = new AtomicThrowable();
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j6) {
            if (SubscriptionHelper.validate(j6)) {
                BackpressureHelper.add(this.requested, j6);
                drain();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class ZipSubscriber<T, R> extends AtomicReference<Subscription> implements Subscriber<T>, Subscription {
        private static final long serialVersionUID = -4627193790118206028L;
        volatile boolean done;
        final int index;
        final int limit;
        final ZipCoordinator<T, R> parent;
        final int prefetch;
        long produced;
        SimpleQueue<T> queue;
        int sourceMode;

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.done = true;
            this.parent.drain();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.parent.error(this, th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t5) {
            if (this.sourceMode != 2) {
                this.queue.offer(t5);
            }
            this.parent.drain();
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j6) {
            if (this.sourceMode != 1) {
                long j7 = this.produced + j6;
                if (j7 < this.limit) {
                    this.produced = j7;
                } else {
                    this.produced = 0L;
                    get().request(j7);
                }
            }
        }

        ZipSubscriber(ZipCoordinator<T, R> zipCoordinator, int i6, int i7) {
            this.parent = zipCoordinator;
            this.prefetch = i6;
            this.index = i7;
            this.limit = i6 - (i6 >> 2);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            SubscriptionHelper.cancel(this);
        }

        @Override // org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.setOnce(this, subscription)) {
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int requestFusion = queueSubscription.requestFusion(3);
                    if (requestFusion == 1) {
                        this.sourceMode = requestFusion;
                        this.queue = queueSubscription;
                        this.done = true;
                        this.parent.drain();
                        return;
                    }
                    if (requestFusion == 2) {
                        this.sourceMode = requestFusion;
                        this.queue = queueSubscription;
                        subscription.request(this.prefetch);
                        return;
                    }
                }
                this.queue = new SpscArrayQueue(this.prefetch);
                subscription.request(this.prefetch);
            }
        }
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super R> subscriber) {
        int length;
        Publisher<? extends T>[] publisherArr = this.sources;
        if (publisherArr == null) {
            publisherArr = new Publisher[8];
            length = 0;
            for (Publisher<? extends T> publisher : this.sourcesIterable) {
                if (length == publisherArr.length) {
                    Publisher<? extends T>[] publisherArr2 = new Publisher[(length >> 2) + length];
                    System.arraycopy(publisherArr, 0, publisherArr2, 0, length);
                    publisherArr = publisherArr2;
                }
                publisherArr[length] = publisher;
                length++;
            }
        } else {
            length = publisherArr.length;
        }
        int i6 = length;
        if (i6 == 0) {
            EmptySubscription.complete(subscriber);
            return;
        }
        ZipCoordinator zipCoordinator = new ZipCoordinator(subscriber, this.zipper, i6, this.bufferSize, this.delayError);
        subscriber.onSubscribe(zipCoordinator);
        zipCoordinator.subscribe(publisherArr, i6);
    }

    public FlowableZip(Publisher<? extends T>[] publisherArr, Iterable<? extends Publisher<? extends T>> iterable, Function<? super Object[], ? extends R> function, int i6, boolean z5) {
        this.sources = publisherArr;
        this.sourcesIterable = iterable;
        this.zipper = function;
        this.bufferSize = i6;
        this.delayError = z5;
    }
}
