package io.netty.util.concurrent;

import io.netty.util.internal.ObjectUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class PromiseCombiner {
    private Promise<Void> aggregatePromise;
    private Throwable cause;
    private int doneCount;
    private final EventExecutor executor;
    private int expectedCount;
    private final GenericFutureListener<Future<?>> listener;

    @Deprecated
    public PromiseCombiner() {
        this(ImmediateEventExecutor.INSTANCE);
    }

    @Deprecated
    public void add(Promise promise) {
        add((Future) promise);
    }

    @Deprecated
    public void addAll(Promise... promiseArr) {
        addAll((Future[]) promiseArr);
    }

    public PromiseCombiner(EventExecutor eventExecutor) {
        this.listener = new GenericFutureListener<Future<?>>() { // from class: io.netty.util.concurrent.PromiseCombiner.1
            static final /* synthetic */ boolean $assertionsDisabled = false;

            /* JADX INFO: Access modifiers changed from: private */
            public void operationComplete0(Future<?> future) {
                PromiseCombiner.access$204(PromiseCombiner.this);
                if (!future.isSuccess() && PromiseCombiner.this.cause == null) {
                    PromiseCombiner.this.cause = future.cause();
                }
                if (PromiseCombiner.this.doneCount != PromiseCombiner.this.expectedCount || PromiseCombiner.this.aggregatePromise == null) {
                    return;
                }
                PromiseCombiner.this.tryPromise();
            }

            @Override // io.netty.util.concurrent.GenericFutureListener
            public void operationComplete(final Future<?> future) {
                if (PromiseCombiner.this.executor.inEventLoop()) {
                    operationComplete0(future);
                } else {
                    PromiseCombiner.this.executor.execute(new Runnable() { // from class: io.netty.util.concurrent.PromiseCombiner.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            operationComplete0(future);
                        }
                    });
                }
            }
        };
        this.executor = (EventExecutor) ObjectUtil.checkNotNull(eventExecutor, "executor");
    }

    static /* synthetic */ int access$204(PromiseCombiner promiseCombiner) {
        int i6 = promiseCombiner.doneCount + 1;
        promiseCombiner.doneCount = i6;
        return i6;
    }

    private void checkAddAllowed() {
        if (this.aggregatePromise != null) {
            throw new IllegalStateException("Adding promises is not allowed after finished adding");
        }
    }

    private void checkInEventLoop() {
        if (!this.executor.inEventLoop()) {
            throw new IllegalStateException("Must be called from EventExecutor thread");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean tryPromise() {
        Throwable th = this.cause;
        return th == null ? this.aggregatePromise.trySuccess(null) : this.aggregatePromise.tryFailure(th);
    }

    public void add(Future future) {
        checkAddAllowed();
        checkInEventLoop();
        this.expectedCount++;
        future.addListener(this.listener);
    }

    public void addAll(Future... futureArr) {
        for (Future future : futureArr) {
            add(future);
        }
    }

    public void finish(Promise<Void> promise) {
        ObjectUtil.checkNotNull(promise, "aggregatePromise");
        checkInEventLoop();
        if (this.aggregatePromise != null) {
            throw new IllegalStateException("Already finished");
        }
        this.aggregatePromise = promise;
        if (this.doneCount == this.expectedCount) {
            tryPromise();
        }
    }
}
