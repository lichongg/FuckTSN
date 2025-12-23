package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscriptions.BasicQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import org.reactivestreams.Subscriber;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class FlowableFromArray<T> extends Flowable<T> {
    final T[] array;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class ArrayConditionalSubscription<T> extends BaseArraySubscription<T> {
        private static final long serialVersionUID = 2587302975077663557L;
        final ConditionalSubscriber<? super T> actual;

        @Override // io.reactivex.internal.operators.flowable.FlowableFromArray.BaseArraySubscription
        void fastPath() {
            T[] tArr = this.array;
            int length = tArr.length;
            ConditionalSubscriber<? super T> conditionalSubscriber = this.actual;
            for (int i6 = this.index; i6 != length; i6++) {
                if (this.cancelled) {
                    return;
                }
                T t5 = tArr[i6];
                if (t5 == null) {
                    conditionalSubscriber.onError(new NullPointerException("array element is null"));
                    return;
                }
                conditionalSubscriber.tryOnNext(t5);
            }
            if (this.cancelled) {
                return;
            }
            conditionalSubscriber.onComplete();
        }

        /* JADX WARN: Code restructure failed: missing block: B:11:0x0042, code lost:
        
            r10.index = r2;
            r11 = addAndGet(-r6);
         */
        @Override // io.reactivex.internal.operators.flowable.FlowableFromArray.BaseArraySubscription
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void slowPath(long r11) {
            /*
                r10 = this;
                T[] r0 = r10.array
                int r1 = r0.length
                int r2 = r10.index
                io.reactivex.internal.fuseable.ConditionalSubscriber<? super T> r3 = r10.actual
                r4 = 0
            L9:
                r6 = r4
            La:
                int r8 = (r6 > r11 ? 1 : (r6 == r11 ? 0 : -1))
                if (r8 == 0) goto L30
                if (r2 == r1) goto L30
                boolean r8 = r10.cancelled
                if (r8 == 0) goto L15
                goto L4d
            L15:
                r8 = r0[r2]
                if (r8 != 0) goto L24
                java.lang.NullPointerException r11 = new java.lang.NullPointerException
                java.lang.String r12 = "array element is null"
                r11.<init>(r12)
                r3.onError(r11)
                return
            L24:
                boolean r8 = r3.tryOnNext(r8)
                if (r8 == 0) goto L2d
                r8 = 1
                long r6 = r6 + r8
            L2d:
                int r2 = r2 + 1
                goto La
            L30:
                if (r2 != r1) goto L3a
                boolean r11 = r10.cancelled
                if (r11 != 0) goto L4d
                r3.onComplete()
                return
            L3a:
                long r11 = r10.get()
                int r8 = (r6 > r11 ? 1 : (r6 == r11 ? 0 : -1))
                if (r8 != 0) goto La
                r10.index = r2
                long r11 = -r6
                long r11 = r10.addAndGet(r11)
                int r6 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
                if (r6 != 0) goto L9
            L4d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableFromArray.ArrayConditionalSubscription.slowPath(long):void");
        }

        ArrayConditionalSubscription(ConditionalSubscriber<? super T> conditionalSubscriber, T[] tArr) {
            super(tArr);
            this.actual = conditionalSubscriber;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class ArraySubscription<T> extends BaseArraySubscription<T> {
        private static final long serialVersionUID = 2587302975077663557L;
        final Subscriber<? super T> actual;

        @Override // io.reactivex.internal.operators.flowable.FlowableFromArray.BaseArraySubscription
        void fastPath() {
            T[] tArr = this.array;
            int length = tArr.length;
            Subscriber<? super T> subscriber = this.actual;
            for (int i6 = this.index; i6 != length; i6++) {
                if (this.cancelled) {
                    return;
                }
                T t5 = tArr[i6];
                if (t5 == null) {
                    subscriber.onError(new NullPointerException("array element is null"));
                    return;
                }
                subscriber.onNext(t5);
            }
            if (this.cancelled) {
                return;
            }
            subscriber.onComplete();
        }

        /* JADX WARN: Code restructure failed: missing block: B:11:0x003f, code lost:
        
            r10.index = r2;
            r11 = addAndGet(-r6);
         */
        @Override // io.reactivex.internal.operators.flowable.FlowableFromArray.BaseArraySubscription
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void slowPath(long r11) {
            /*
                r10 = this;
                T[] r0 = r10.array
                int r1 = r0.length
                int r2 = r10.index
                org.reactivestreams.Subscriber<? super T> r3 = r10.actual
                r4 = 0
            L9:
                r6 = r4
            La:
                int r8 = (r6 > r11 ? 1 : (r6 == r11 ? 0 : -1))
                if (r8 == 0) goto L2d
                if (r2 == r1) goto L2d
                boolean r8 = r10.cancelled
                if (r8 == 0) goto L15
                goto L4a
            L15:
                r8 = r0[r2]
                if (r8 != 0) goto L24
                java.lang.NullPointerException r11 = new java.lang.NullPointerException
                java.lang.String r12 = "array element is null"
                r11.<init>(r12)
                r3.onError(r11)
                return
            L24:
                r3.onNext(r8)
                r8 = 1
                long r6 = r6 + r8
                int r2 = r2 + 1
                goto La
            L2d:
                if (r2 != r1) goto L37
                boolean r11 = r10.cancelled
                if (r11 != 0) goto L4a
                r3.onComplete()
                return
            L37:
                long r11 = r10.get()
                int r8 = (r6 > r11 ? 1 : (r6 == r11 ? 0 : -1))
                if (r8 != 0) goto La
                r10.index = r2
                long r11 = -r6
                long r11 = r10.addAndGet(r11)
                int r6 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
                if (r6 != 0) goto L9
            L4a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableFromArray.ArraySubscription.slowPath(long):void");
        }

        ArraySubscription(Subscriber<? super T> subscriber, T[] tArr) {
            super(tArr);
            this.actual = subscriber;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static abstract class BaseArraySubscription<T> extends BasicQueueSubscription<T> {
        private static final long serialVersionUID = -2252972430506210021L;
        final T[] array;
        volatile boolean cancelled;
        int index;

        @Override // org.reactivestreams.Subscription
        public final void cancel() {
            this.cancelled = true;
        }

        abstract void fastPath();

        abstract void slowPath(long j6);

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final void clear() {
            this.index = this.array.length;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final boolean isEmpty() {
            return this.index == this.array.length;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final T poll() {
            int i6 = this.index;
            T[] tArr = this.array;
            if (i6 == tArr.length) {
                return null;
            }
            this.index = i6 + 1;
            return (T) ObjectHelper.requireNonNull(tArr[i6], "array element is null");
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public final int requestFusion(int i6) {
            return i6 & 1;
        }

        BaseArraySubscription(T[] tArr) {
            this.array = tArr;
        }

        @Override // org.reactivestreams.Subscription
        public final void request(long j6) {
            if (SubscriptionHelper.validate(j6) && BackpressureHelper.add(this, j6) == 0) {
                if (j6 == Long.MAX_VALUE) {
                    fastPath();
                } else {
                    slowPath(j6);
                }
            }
        }
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        if (subscriber instanceof ConditionalSubscriber) {
            subscriber.onSubscribe(new ArrayConditionalSubscription((ConditionalSubscriber) subscriber, this.array));
        } else {
            subscriber.onSubscribe(new ArraySubscription(subscriber, this.array));
        }
    }

    public FlowableFromArray(T[] tArr) {
        this.array = tArr;
    }
}
