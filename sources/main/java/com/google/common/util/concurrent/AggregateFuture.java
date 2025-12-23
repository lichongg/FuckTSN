package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.util.concurrent.AbstractFuture;
import com.google.errorprone.annotations.ForOverride;
import com.google.errorprone.annotations.OverridingMethodsMustInvokeSuper;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@GwtCompatible
/* loaded from: D:\Downloads\app\classes5.dex */
abstract class AggregateFuture<InputT, OutputT> extends AbstractFuture.TrustedFuture<OutputT> {
    private static final Logger logger = Logger.getLogger(AggregateFuture.class.getName());

    @NullableDecl
    private AggregateFuture<InputT, OutputT>.RunningState runningState;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    abstract class RunningState extends AggregateFutureState implements Runnable {
        private final boolean allMustSucceed;
        private final boolean collectsValues;
        private ImmutableCollection<? extends ListenableFuture<? extends InputT>> futures;

        abstract void collectOneValue(boolean z5, int i6, @NullableDecl InputT inputt);

        abstract void handleAllCompleted();

        @ForOverride
        @OverridingMethodsMustInvokeSuper
        void releaseResourcesAfterFailure() {
            this.futures = null;
        }

        RunningState(ImmutableCollection<? extends ListenableFuture<? extends InputT>> immutableCollection, boolean z5, boolean z6) {
            super(immutableCollection.size());
            this.futures = (ImmutableCollection) Preconditions.checkNotNull(immutableCollection);
            this.allMustSucceed = z5;
            this.collectsValues = z6;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        public void handleOneInputDone(int i6, Future<? extends InputT> future) {
            Preconditions.checkState(this.allMustSucceed || !AggregateFuture.this.isDone() || AggregateFuture.this.isCancelled(), "Future was done before all dependencies completed");
            try {
                Preconditions.checkState(future.isDone(), "Tried to set value from future which is not done");
                if (!this.allMustSucceed) {
                    if (!this.collectsValues || future.isCancelled()) {
                        return;
                    }
                    collectOneValue(this.allMustSucceed, i6, Futures.getDone(future));
                    return;
                }
                if (future.isCancelled()) {
                    AggregateFuture.this.runningState = null;
                    AggregateFuture.this.cancel(false);
                } else {
                    Object done = Futures.getDone(future);
                    if (this.collectsValues) {
                        collectOneValue(this.allMustSucceed, i6, done);
                    }
                }
            } catch (ExecutionException e6) {
                handleException(e6.getCause());
            } catch (Throwable th) {
                handleException(th);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void init() {
            if (this.futures.isEmpty()) {
                handleAllCompleted();
                return;
            }
            if (!this.allMustSucceed) {
                UnmodifiableIterator<? extends ListenableFuture<? extends InputT>> it = this.futures.iterator();
                while (it.hasNext()) {
                    it.next().addListener(this, MoreExecutors.directExecutor());
                }
                return;
            }
            UnmodifiableIterator<? extends ListenableFuture<? extends InputT>> it2 = this.futures.iterator();
            final int i6 = 0;
            while (it2.hasNext()) {
                final ListenableFuture<? extends InputT> next = it2.next();
                next.addListener(new Runnable() { // from class: com.google.common.util.concurrent.AggregateFuture.RunningState.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            RunningState.this.handleOneInputDone(i6, next);
                        } finally {
                            RunningState.this.decrementCountAndMaybeComplete();
                        }
                    }
                }, MoreExecutors.directExecutor());
                i6++;
            }
        }

        private void processCompleted() {
            if (this.collectsValues & (!this.allMustSucceed)) {
                UnmodifiableIterator<? extends ListenableFuture<? extends InputT>> it = this.futures.iterator();
                int i6 = 0;
                while (it.hasNext()) {
                    handleOneInputDone(i6, it.next());
                    i6++;
                }
            }
            handleAllCompleted();
        }

        @Override // com.google.common.util.concurrent.AggregateFutureState
        final void addInitialException(Set<Throwable> set) {
            if (AggregateFuture.this.isCancelled()) {
                return;
            }
            AggregateFuture.addCausalChain(set, AggregateFuture.this.tryInternalFastPathGetFailure());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void decrementCountAndMaybeComplete() {
            boolean z5;
            int decrementRemainingAndGet = decrementRemainingAndGet();
            if (decrementRemainingAndGet >= 0) {
                z5 = true;
            } else {
                z5 = false;
            }
            Preconditions.checkState(z5, "Less than 0 remaining futures");
            if (decrementRemainingAndGet == 0) {
                processCompleted();
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:9:0x002a  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private void handleException(java.lang.Throwable r6) {
            /*
                r5 = this;
                com.google.common.base.Preconditions.checkNotNull(r6)
                boolean r0 = r5.allMustSucceed
                r1 = 1
                if (r0 == 0) goto L1e
                com.google.common.util.concurrent.AggregateFuture r0 = com.google.common.util.concurrent.AggregateFuture.this
                boolean r0 = r0.setException(r6)
                if (r0 == 0) goto L15
                r5.releaseResourcesAfterFailure()
            L13:
                r2 = 1
                goto L20
            L15:
                java.util.Set r2 = r5.getOrInitSeenExceptions()
                boolean r2 = com.google.common.util.concurrent.AggregateFuture.access$400(r2, r6)
                goto L20
            L1e:
                r0 = 0
                goto L13
            L20:
                boolean r3 = r6 instanceof java.lang.Error
                boolean r4 = r5.allMustSucceed
                r0 = r0 ^ r1
                r0 = r0 & r4
                r0 = r0 & r2
                r0 = r0 | r3
                if (r0 == 0) goto L3a
                if (r3 == 0) goto L2f
                java.lang.String r0 = "Input Future failed with Error"
                goto L31
            L2f:
                java.lang.String r0 = "Got more than one input Future failure. Logging failures after the first"
            L31:
                java.util.logging.Logger r1 = com.google.common.util.concurrent.AggregateFuture.access$500()
                java.util.logging.Level r2 = java.util.logging.Level.SEVERE
                r1.log(r2, r0, r6)
            L3a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.AggregateFuture.RunningState.handleException(java.lang.Throwable):void");
        }

        @Override // java.lang.Runnable
        public final void run() {
            decrementCountAndMaybeComplete();
        }

        void interruptTask() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean addCausalChain(Set<Throwable> set, Throwable th) {
        while (th != null) {
            if (!set.add(th)) {
                return false;
            }
            th = th.getCause();
        }
        return true;
    }

    final void init(AggregateFuture<InputT, OutputT>.RunningState runningState) {
        this.runningState = runningState;
        runningState.init();
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    protected String pendingToString() {
        ImmutableCollection immutableCollection;
        AggregateFuture<InputT, OutputT>.RunningState runningState = this.runningState;
        if (runningState == null || (immutableCollection = ((RunningState) runningState).futures) == null) {
            return null;
        }
        return "futures=[" + immutableCollection + "]";
    }

    AggregateFuture() {
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    protected final void afterDone() {
        boolean z5;
        super.afterDone();
        AggregateFuture<InputT, OutputT>.RunningState runningState = this.runningState;
        if (runningState != null) {
            this.runningState = null;
            ImmutableCollection immutableCollection = ((RunningState) runningState).futures;
            boolean wasInterrupted = wasInterrupted();
            if (wasInterrupted) {
                runningState.interruptTask();
            }
            boolean isCancelled = isCancelled();
            if (immutableCollection != null) {
                z5 = true;
            } else {
                z5 = false;
            }
            if (isCancelled & z5) {
                UnmodifiableIterator it = immutableCollection.iterator();
                while (it.hasNext()) {
                    ((ListenableFuture) it.next()).cancel(wasInterrupted);
                }
            }
        }
    }
}
