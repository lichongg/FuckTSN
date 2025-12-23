package androidx.work.impl.utils.futures;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.concurrent.futures.a;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: D:\Downloads\app\classes.dex */
public abstract class AbstractFuture<V> implements ListenableFuture<V> {
    static final AtomicHelper ATOMIC_HELPER;
    private static final Object NULL;
    private static final long SPIN_THRESHOLD_NANOS = 1000;

    @Nullable
    volatile Listener listeners;

    @Nullable
    volatile Object value;

    @Nullable
    volatile Waiter waiters;
    static final boolean GENERATE_CANCELLATION_CAUSES = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
    private static final Logger log = Logger.getLogger(AbstractFuture.class.getName());

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static abstract class AtomicHelper {
        private AtomicHelper() {
        }

        abstract boolean casListeners(AbstractFuture<?> future, Listener expect, Listener update);

        abstract boolean casValue(AbstractFuture<?> future, Object expect, Object update);

        abstract boolean casWaiters(AbstractFuture<?> future, Waiter expect, Waiter update);

        abstract void putNext(Waiter waiter, Waiter newValue);

        abstract void putThread(Waiter waiter, Thread newValue);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class Cancellation {
        static final Cancellation CAUSELESS_CANCELLED;
        static final Cancellation CAUSELESS_INTERRUPTED;

        @Nullable
        final Throwable cause;
        final boolean wasInterrupted;

        static {
            if (AbstractFuture.GENERATE_CANCELLATION_CAUSES) {
                CAUSELESS_CANCELLED = null;
                CAUSELESS_INTERRUPTED = null;
            } else {
                CAUSELESS_CANCELLED = new Cancellation(false, null);
                CAUSELESS_INTERRUPTED = new Cancellation(true, null);
            }
        }

        Cancellation(boolean wasInterrupted, @Nullable Throwable cause) {
            this.wasInterrupted = wasInterrupted;
            this.cause = cause;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class SafeAtomicHelper extends AtomicHelper {
        final AtomicReferenceFieldUpdater<AbstractFuture, Listener> listenersUpdater;
        final AtomicReferenceFieldUpdater<AbstractFuture, Object> valueUpdater;
        final AtomicReferenceFieldUpdater<Waiter, Waiter> waiterNextUpdater;
        final AtomicReferenceFieldUpdater<Waiter, Thread> waiterThreadUpdater;
        final AtomicReferenceFieldUpdater<AbstractFuture, Waiter> waitersUpdater;

        SafeAtomicHelper(AtomicReferenceFieldUpdater<Waiter, Thread> waiterThreadUpdater, AtomicReferenceFieldUpdater<Waiter, Waiter> waiterNextUpdater, AtomicReferenceFieldUpdater<AbstractFuture, Waiter> waitersUpdater, AtomicReferenceFieldUpdater<AbstractFuture, Listener> listenersUpdater, AtomicReferenceFieldUpdater<AbstractFuture, Object> valueUpdater) {
            super();
            this.waiterThreadUpdater = waiterThreadUpdater;
            this.waiterNextUpdater = waiterNextUpdater;
            this.waitersUpdater = waitersUpdater;
            this.listenersUpdater = listenersUpdater;
            this.valueUpdater = valueUpdater;
        }

        @Override // androidx.work.impl.utils.futures.AbstractFuture.AtomicHelper
        boolean casListeners(AbstractFuture<?> future, Listener expect, Listener update) {
            return a.a(this.listenersUpdater, future, expect, update);
        }

        @Override // androidx.work.impl.utils.futures.AbstractFuture.AtomicHelper
        boolean casValue(AbstractFuture<?> future, Object expect, Object update) {
            return a.a(this.valueUpdater, future, expect, update);
        }

        @Override // androidx.work.impl.utils.futures.AbstractFuture.AtomicHelper
        boolean casWaiters(AbstractFuture<?> future, Waiter expect, Waiter update) {
            return a.a(this.waitersUpdater, future, expect, update);
        }

        @Override // androidx.work.impl.utils.futures.AbstractFuture.AtomicHelper
        void putNext(Waiter waiter, Waiter newValue) {
            this.waiterNextUpdater.lazySet(waiter, newValue);
        }

        @Override // androidx.work.impl.utils.futures.AbstractFuture.AtomicHelper
        void putThread(Waiter waiter, Thread newValue) {
            this.waiterThreadUpdater.lazySet(waiter, newValue);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class SetFuture<V> implements Runnable {
        final ListenableFuture<? extends V> future;
        final AbstractFuture<V> owner;

        @Override // java.lang.Runnable
        public void run() {
            if (this.owner.value != this) {
                return;
            }
            if (AbstractFuture.ATOMIC_HELPER.casValue(this.owner, this, AbstractFuture.getFutureValue(this.future))) {
                AbstractFuture.complete(this.owner);
            }
        }

        SetFuture(AbstractFuture<V> owner, ListenableFuture<? extends V> future) {
            this.owner = owner;
            this.future = future;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class SynchronizedHelper extends AtomicHelper {
        SynchronizedHelper() {
            super();
        }

        @Override // androidx.work.impl.utils.futures.AbstractFuture.AtomicHelper
        boolean casListeners(AbstractFuture<?> future, Listener expect, Listener update) {
            synchronized (future) {
                try {
                    if (future.listeners != expect) {
                        return false;
                    }
                    future.listeners = update;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // androidx.work.impl.utils.futures.AbstractFuture.AtomicHelper
        boolean casValue(AbstractFuture<?> future, Object expect, Object update) {
            synchronized (future) {
                try {
                    if (future.value != expect) {
                        return false;
                    }
                    future.value = update;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // androidx.work.impl.utils.futures.AbstractFuture.AtomicHelper
        boolean casWaiters(AbstractFuture<?> future, Waiter expect, Waiter update) {
            synchronized (future) {
                try {
                    if (future.waiters != expect) {
                        return false;
                    }
                    future.waiters = update;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // androidx.work.impl.utils.futures.AbstractFuture.AtomicHelper
        void putNext(Waiter waiter, Waiter newValue) {
            waiter.next = newValue;
        }

        @Override // androidx.work.impl.utils.futures.AbstractFuture.AtomicHelper
        void putThread(Waiter waiter, Thread newValue) {
            waiter.thread = newValue;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class Waiter {
        static final Waiter TOMBSTONE = new Waiter(false);

        @Nullable
        volatile Waiter next;

        @Nullable
        volatile Thread thread;

        Waiter(boolean unused) {
        }

        Waiter() {
            AbstractFuture.ATOMIC_HELPER.putThread(this, Thread.currentThread());
        }

        void setNext(Waiter next) {
            AbstractFuture.ATOMIC_HELPER.putNext(this, next);
        }

        void unpark() {
            Thread thread = this.thread;
            if (thread != null) {
                this.thread = null;
                LockSupport.unpark(thread);
            }
        }
    }

    static void complete(AbstractFuture<?> abstractFuture) {
        Listener listener = null;
        while (true) {
            abstractFuture.releaseWaiters();
            abstractFuture.afterDone();
            Listener clearListeners = abstractFuture.clearListeners(listener);
            while (clearListeners != null) {
                listener = clearListeners.next;
                Runnable runnable = clearListeners.task;
                if (runnable instanceof SetFuture) {
                    SetFuture setFuture = (SetFuture) runnable;
                    abstractFuture = setFuture.owner;
                    if (abstractFuture.value == setFuture) {
                        if (ATOMIC_HELPER.casValue(abstractFuture, setFuture, getFutureValue(setFuture.future))) {
                            break;
                        }
                    } else {
                        continue;
                    }
                } else {
                    executeListener(runnable, clearListeners.executor);
                }
                clearListeners = listener;
            }
            return;
        }
    }

    private static <V> V getUninterruptibly(Future<V> future) throws ExecutionException {
        V v5;
        boolean z5 = false;
        while (true) {
            try {
                v5 = future.get();
                break;
            } catch (InterruptedException unused) {
                z5 = true;
            } catch (Throwable th) {
                if (z5) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z5) {
            Thread.currentThread().interrupt();
        }
        return v5;
    }

    private void removeWaiter(Waiter node) {
        node.thread = null;
        while (true) {
            Waiter waiter = this.waiters;
            if (waiter == Waiter.TOMBSTONE) {
                return;
            }
            Waiter waiter2 = null;
            while (waiter != null) {
                Waiter waiter3 = waiter.next;
                if (waiter.thread != null) {
                    waiter2 = waiter;
                } else if (waiter2 != null) {
                    waiter2.next = waiter3;
                    if (waiter2.thread == null) {
                        break;
                    }
                } else if (!ATOMIC_HELPER.casWaiters(this, waiter, waiter3)) {
                    break;
                }
                waiter = waiter3;
            }
            return;
        }
    }

    @Override // java.util.concurrent.Future
    public final V get(long timeout, TimeUnit unit) throws InterruptedException, TimeoutException, ExecutionException {
        long nanos = unit.toNanos(timeout);
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj = this.value;
        if ((obj != null) && (!(obj instanceof SetFuture))) {
            return getDoneValue(obj);
        }
        long nanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
        if (nanos >= 1000) {
            Waiter waiter = this.waiters;
            if (waiter != Waiter.TOMBSTONE) {
                Waiter waiter2 = new Waiter();
                do {
                    waiter2.setNext(waiter);
                    if (ATOMIC_HELPER.casWaiters(this, waiter, waiter2)) {
                        do {
                            LockSupport.parkNanos(this, nanos);
                            if (Thread.interrupted()) {
                                removeWaiter(waiter2);
                                throw new InterruptedException();
                            }
                            Object obj2 = this.value;
                            if ((obj2 != null) && (!(obj2 instanceof SetFuture))) {
                                return getDoneValue(obj2);
                            }
                            nanos = nanoTime - System.nanoTime();
                        } while (nanos >= 1000);
                        removeWaiter(waiter2);
                    } else {
                        waiter = this.waiters;
                    }
                } while (waiter != Waiter.TOMBSTONE);
            }
            return getDoneValue(this.value);
        }
        while (nanos > 0) {
            Object obj3 = this.value;
            if ((obj3 != null) && (!(obj3 instanceof SetFuture))) {
                return getDoneValue(obj3);
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            nanos = nanoTime - System.nanoTime();
        }
        String abstractFuture = toString();
        String obj4 = unit.toString();
        Locale locale = Locale.ROOT;
        String lowerCase = obj4.toLowerCase(locale);
        String str = "Waited " + timeout + " " + unit.toString().toLowerCase(locale);
        if (nanos + 1000 < 0) {
            String str2 = str + " (plus ";
            long j6 = -nanos;
            long convert = unit.convert(j6, TimeUnit.NANOSECONDS);
            long nanos2 = j6 - unit.toNanos(convert);
            boolean z5 = convert == 0 || nanos2 > 1000;
            if (convert > 0) {
                String str3 = str2 + convert + " " + lowerCase;
                if (z5) {
                    str3 = str3 + ",";
                }
                str2 = str3 + " ";
            }
            if (z5) {
                str2 = str2 + nanos2 + " nanoseconds ";
            }
            str = str2 + "delay)";
        }
        if (isDone()) {
            throw new TimeoutException(str + " but future completed as timeout expired");
        }
        throw new TimeoutException(str + " for " + abstractFuture);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class Failure {
        static final Failure FALLBACK_INSTANCE = new Failure(new Throwable("Failure occurred while trying to finish a future.") { // from class: androidx.work.impl.utils.futures.AbstractFuture.Failure.1
            @Override // java.lang.Throwable
            public synchronized Throwable fillInStackTrace() {
                return this;
            }
        });
        final Throwable exception;

        Failure(Throwable exception) {
            this.exception = (Throwable) AbstractFuture.checkNotNull(exception);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class Listener {
        static final Listener TOMBSTONE = new Listener(null, null);
        final Executor executor;

        @Nullable
        Listener next;
        final Runnable task;

        Listener(Runnable task, Executor executor) {
            this.task = task;
            this.executor = executor;
        }
    }

    static {
        AtomicHelper synchronizedHelper;
        try {
            synchronizedHelper = new SafeAtomicHelper(AtomicReferenceFieldUpdater.newUpdater(Waiter.class, Thread.class, "thread"), AtomicReferenceFieldUpdater.newUpdater(Waiter.class, Waiter.class, "next"), AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, Waiter.class, "waiters"), AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, Listener.class, "listeners"), AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, Object.class, "value"));
            th = null;
        } catch (Throwable th) {
            th = th;
            synchronizedHelper = new SynchronizedHelper();
        }
        ATOMIC_HELPER = synchronizedHelper;
        if (th != null) {
            log.log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
        }
        NULL = new Object();
    }

    private void addDoneString(StringBuilder builder) {
        try {
            Object uninterruptibly = getUninterruptibly(this);
            builder.append("SUCCESS, result=[");
            builder.append(userObjectToString(uninterruptibly));
            builder.append("]");
        } catch (CancellationException unused) {
            builder.append("CANCELLED");
        } catch (RuntimeException e6) {
            builder.append("UNKNOWN, cause=[");
            builder.append(e6.getClass());
            builder.append(" thrown from get()]");
        } catch (ExecutionException e7) {
            builder.append("FAILURE, cause=[");
            builder.append(e7.getCause());
            builder.append("]");
        }
    }

    private static CancellationException cancellationExceptionWithCause(@Nullable String message, @Nullable Throwable cause) {
        CancellationException cancellationException = new CancellationException(message);
        cancellationException.initCause(cause);
        return cancellationException;
    }

    private Listener clearListeners(Listener onto) {
        Listener listener;
        do {
            listener = this.listeners;
        } while (!ATOMIC_HELPER.casListeners(this, listener, Listener.TOMBSTONE));
        Listener listener2 = onto;
        Listener listener3 = listener;
        while (listener3 != null) {
            Listener listener4 = listener3.next;
            listener3.next = listener2;
            listener2 = listener3;
            listener3 = listener4;
        }
        return listener2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private V getDoneValue(Object obj) throws ExecutionException {
        if (obj instanceof Cancellation) {
            throw cancellationExceptionWithCause("Task was cancelled.", ((Cancellation) obj).cause);
        }
        if (obj instanceof Failure) {
            throw new ExecutionException(((Failure) obj).exception);
        }
        if (obj == NULL) {
            return null;
        }
        return obj;
    }

    static Object getFutureValue(ListenableFuture<?> future) {
        if (future instanceof AbstractFuture) {
            Object obj = ((AbstractFuture) future).value;
            if (!(obj instanceof Cancellation)) {
                return obj;
            }
            Cancellation cancellation = (Cancellation) obj;
            return cancellation.wasInterrupted ? cancellation.cause != null ? new Cancellation(false, cancellation.cause) : Cancellation.CAUSELESS_CANCELLED : obj;
        }
        boolean isCancelled = future.isCancelled();
        if ((!GENERATE_CANCELLATION_CAUSES) && isCancelled) {
            return Cancellation.CAUSELESS_CANCELLED;
        }
        try {
            Object uninterruptibly = getUninterruptibly(future);
            return uninterruptibly == null ? NULL : uninterruptibly;
        } catch (CancellationException e6) {
            if (isCancelled) {
                return new Cancellation(false, e6);
            }
            return new Failure(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: " + future, e6));
        } catch (ExecutionException e7) {
            return new Failure(e7.getCause());
        } catch (Throwable th) {
            return new Failure(th);
        }
    }

    private void releaseWaiters() {
        Waiter waiter;
        do {
            waiter = this.waiters;
        } while (!ATOMIC_HELPER.casWaiters(this, waiter, Waiter.TOMBSTONE));
        while (waiter != null) {
            waiter.unpark();
            waiter = waiter.next;
        }
    }

    private String userObjectToString(Object o5) {
        return o5 == this ? "this future" : String.valueOf(o5);
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x0058, code lost:
    
        return true;
     */
    @Override // java.util.concurrent.Future
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean cancel(boolean r8) {
        /*
            r7 = this;
            java.lang.Object r0 = r7.value
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L8
            r3 = 1
            goto L9
        L8:
            r3 = 0
        L9:
            boolean r4 = r0 instanceof androidx.work.impl.utils.futures.AbstractFuture.SetFuture
            r3 = r3 | r4
            if (r3 == 0) goto L60
            boolean r3 = androidx.work.impl.utils.futures.AbstractFuture.GENERATE_CANCELLATION_CAUSES
            if (r3 == 0) goto L1f
            androidx.work.impl.utils.futures.AbstractFuture$Cancellation r3 = new androidx.work.impl.utils.futures.AbstractFuture$Cancellation
            java.util.concurrent.CancellationException r4 = new java.util.concurrent.CancellationException
            java.lang.String r5 = "Future.cancel() was called."
            r4.<init>(r5)
            r3.<init>(r8, r4)
            goto L26
        L1f:
            if (r8 == 0) goto L24
            androidx.work.impl.utils.futures.AbstractFuture$Cancellation r3 = androidx.work.impl.utils.futures.AbstractFuture.Cancellation.CAUSELESS_INTERRUPTED
            goto L26
        L24:
            androidx.work.impl.utils.futures.AbstractFuture$Cancellation r3 = androidx.work.impl.utils.futures.AbstractFuture.Cancellation.CAUSELESS_CANCELLED
        L26:
            r5 = 0
            r4 = r7
        L28:
            androidx.work.impl.utils.futures.AbstractFuture$AtomicHelper r6 = androidx.work.impl.utils.futures.AbstractFuture.ATOMIC_HELPER
            boolean r6 = r6.casValue(r4, r0, r3)
            if (r6 == 0) goto L59
            if (r8 == 0) goto L35
            r4.interruptTask()
        L35:
            complete(r4)
            boolean r4 = r0 instanceof androidx.work.impl.utils.futures.AbstractFuture.SetFuture
            if (r4 == 0) goto L58
            androidx.work.impl.utils.futures.AbstractFuture$SetFuture r0 = (androidx.work.impl.utils.futures.AbstractFuture.SetFuture) r0
            com.google.common.util.concurrent.ListenableFuture<? extends V> r0 = r0.future
            boolean r4 = r0 instanceof androidx.work.impl.utils.futures.AbstractFuture
            if (r4 == 0) goto L55
            r4 = r0
            androidx.work.impl.utils.futures.AbstractFuture r4 = (androidx.work.impl.utils.futures.AbstractFuture) r4
            java.lang.Object r0 = r4.value
            if (r0 != 0) goto L4d
            r5 = 1
            goto L4e
        L4d:
            r5 = 0
        L4e:
            boolean r6 = r0 instanceof androidx.work.impl.utils.futures.AbstractFuture.SetFuture
            r5 = r5 | r6
            if (r5 == 0) goto L58
            r5 = 1
            goto L28
        L55:
            r0.cancel(r8)
        L58:
            return r1
        L59:
            java.lang.Object r0 = r4.value
            boolean r6 = r0 instanceof androidx.work.impl.utils.futures.AbstractFuture.SetFuture
            if (r6 != 0) goto L28
            return r5
        L60:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.utils.futures.AbstractFuture.cancel(boolean):boolean");
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.value instanceof Cancellation;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return (!(r0 instanceof SetFuture)) & (this.value != null);
    }

    final void maybePropagateCancellationTo(@Nullable Future<?> related) {
        if ((related != null) && isCancelled()) {
            related.cancel(wasInterrupted());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    protected String pendingToString() {
        Object obj = this.value;
        if (obj instanceof SetFuture) {
            return "setFuture=[" + userObjectToString(((SetFuture) obj).future) + "]";
        }
        if (!(this instanceof ScheduledFuture)) {
            return null;
        }
        return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
    }

    protected boolean set(@Nullable V v5) {
        if (v5 == null) {
            v5 = (V) NULL;
        }
        if (!ATOMIC_HELPER.casValue(this, null, v5)) {
            return false;
        }
        complete(this);
        return true;
    }

    protected boolean setException(Throwable throwable) {
        if (!ATOMIC_HELPER.casValue(this, null, new Failure((Throwable) checkNotNull(throwable)))) {
            return false;
        }
        complete(this);
        return true;
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("[status=");
        if (isCancelled()) {
            sb.append("CANCELLED");
        } else if (isDone()) {
            addDoneString(sb);
        } else {
            try {
                str = pendingToString();
            } catch (RuntimeException e6) {
                str = "Exception thrown from implementation: " + e6.getClass();
            }
            if (str != null && !str.isEmpty()) {
                sb.append("PENDING, info=[");
                sb.append(str);
                sb.append("]");
            } else if (isDone()) {
                addDoneString(sb);
            } else {
                sb.append("PENDING");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    protected final boolean wasInterrupted() {
        Object obj = this.value;
        return (obj instanceof Cancellation) && ((Cancellation) obj).wasInterrupted;
    }

    protected AbstractFuture() {
    }

    @NonNull
    static <T> T checkNotNull(@Nullable T reference) {
        reference.getClass();
        return reference;
    }

    private static void executeListener(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e6) {
            log.log(Level.SEVERE, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e6);
        }
    }

    @Override // com.google.common.util.concurrent.ListenableFuture
    public final void addListener(Runnable listener, Executor executor) {
        checkNotNull(listener);
        checkNotNull(executor);
        Listener listener2 = this.listeners;
        if (listener2 != Listener.TOMBSTONE) {
            Listener listener3 = new Listener(listener, executor);
            do {
                listener3.next = listener2;
                if (ATOMIC_HELPER.casListeners(this, listener2, listener3)) {
                    return;
                } else {
                    listener2 = this.listeners;
                }
            } while (listener2 != Listener.TOMBSTONE);
        }
        executeListener(listener, executor);
    }

    protected boolean setFuture(ListenableFuture<? extends V> future) {
        Failure failure;
        checkNotNull(future);
        Object obj = this.value;
        if (obj == null) {
            if (future.isDone()) {
                if (!ATOMIC_HELPER.casValue(this, null, getFutureValue(future))) {
                    return false;
                }
                complete(this);
                return true;
            }
            SetFuture setFuture = new SetFuture(this, future);
            if (ATOMIC_HELPER.casValue(this, null, setFuture)) {
                try {
                    future.addListener(setFuture, DirectExecutor.INSTANCE);
                } catch (Throwable th) {
                    try {
                        failure = new Failure(th);
                    } catch (Throwable unused) {
                        failure = Failure.FALLBACK_INSTANCE;
                    }
                    ATOMIC_HELPER.casValue(this, setFuture, failure);
                }
                return true;
            }
            obj = this.value;
        }
        if (obj instanceof Cancellation) {
            future.cancel(((Cancellation) obj).wasInterrupted);
        }
        return false;
    }

    protected void afterDone() {
    }

    protected void interruptTask() {
    }

    @Override // java.util.concurrent.Future
    public final V get() throws InterruptedException, ExecutionException {
        Object obj;
        if (!Thread.interrupted()) {
            Object obj2 = this.value;
            if ((obj2 != null) & (!(obj2 instanceof SetFuture))) {
                return getDoneValue(obj2);
            }
            Waiter waiter = this.waiters;
            if (waiter != Waiter.TOMBSTONE) {
                Waiter waiter2 = new Waiter();
                do {
                    waiter2.setNext(waiter);
                    if (ATOMIC_HELPER.casWaiters(this, waiter, waiter2)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.value;
                            } else {
                                removeWaiter(waiter2);
                                throw new InterruptedException();
                            }
                        } while (!((obj != null) & (!(obj instanceof SetFuture))));
                        return getDoneValue(obj);
                    }
                    waiter = this.waiters;
                } while (waiter != Waiter.TOMBSTONE);
            }
            return getDoneValue(this.value);
        }
        throw new InterruptedException();
    }
}
