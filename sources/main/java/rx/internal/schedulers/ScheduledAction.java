package rx.internal.schedulers;

import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import rx.exceptions.OnErrorNotImplementedException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class ScheduledAction extends AtomicReference<Thread> implements Runnable, rx.m {
    private static final long serialVersionUID = -3962399486978279857L;
    final rx.functions.a action;
    final rx.internal.util.m cancel;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class a implements rx.m {

        /* renamed from: a, reason: collision with root package name */
        private final Future<?> f53961a;

        a(Future<?> future) {
            this.f53961a = future;
        }

        @Override // rx.m
        public boolean isUnsubscribed() {
            return this.f53961a.isCancelled();
        }

        @Override // rx.m
        public void unsubscribe() {
            if (ScheduledAction.this.get() != Thread.currentThread()) {
                this.f53961a.cancel(true);
            } else {
                this.f53961a.cancel(false);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class b extends AtomicBoolean implements rx.m {
        private static final long serialVersionUID = 247232374289553518L;

        /* renamed from: a, reason: collision with root package name */
        final ScheduledAction f53963a;

        /* renamed from: b, reason: collision with root package name */
        final rx.internal.util.m f53964b;

        @Override // rx.m
        public void unsubscribe() {
            if (compareAndSet(false, true)) {
                this.f53964b.e(this.f53963a);
            }
        }

        @Override // rx.m
        public boolean isUnsubscribed() {
            return this.f53963a.isUnsubscribed();
        }

        public b(ScheduledAction scheduledAction, rx.internal.util.m mVar) {
            this.f53963a = scheduledAction;
            this.f53964b = mVar;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class c extends AtomicBoolean implements rx.m {
        private static final long serialVersionUID = 247232374289553518L;

        /* renamed from: a, reason: collision with root package name */
        final ScheduledAction f53965a;

        /* renamed from: b, reason: collision with root package name */
        final rx.subscriptions.b f53966b;

        @Override // rx.m
        public void unsubscribe() {
            if (compareAndSet(false, true)) {
                this.f53966b.f(this.f53965a);
            }
        }

        @Override // rx.m
        public boolean isUnsubscribed() {
            return this.f53965a.isUnsubscribed();
        }

        public c(ScheduledAction scheduledAction, rx.subscriptions.b bVar) {
            this.f53965a = scheduledAction;
            this.f53966b = bVar;
        }
    }

    public ScheduledAction(rx.functions.a aVar) {
        this.action = aVar;
        this.cancel = new rx.internal.util.m();
    }

    public void add(rx.m mVar) {
        this.cancel.a(mVar);
    }

    public void addParent(rx.subscriptions.b bVar) {
        this.cancel.a(new c(this, bVar));
    }

    public void add(Future<?> future) {
        this.cancel.a(new a(future));
    }

    public void addParent(rx.internal.util.m mVar) {
        this.cancel.a(new b(this, mVar));
    }

    @Override // rx.m
    public boolean isUnsubscribed() {
        return this.cancel.isUnsubscribed();
    }

    @Override // rx.m
    public void unsubscribe() {
        if (this.cancel.isUnsubscribed()) {
            return;
        }
        this.cancel.unsubscribe();
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            try {
                lazySet(Thread.currentThread());
                this.action.call();
            } catch (OnErrorNotImplementedException e6) {
                signalError(new IllegalStateException("Exception thrown on Scheduler.Worker thread. Add `onError` handling.", e6));
            } catch (Throwable th) {
                signalError(new IllegalStateException("Fatal Exception thrown on Scheduler.Worker thread.", th));
            }
        } finally {
            unsubscribe();
        }
    }

    void signalError(Throwable th) {
        rx.plugins.c.I(th);
        Thread currentThread = Thread.currentThread();
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
    }

    public ScheduledAction(rx.functions.a aVar, rx.subscriptions.b bVar) {
        this.action = aVar;
        this.cancel = new rx.internal.util.m(new c(this, bVar));
    }

    public ScheduledAction(rx.functions.a aVar, rx.internal.util.m mVar) {
        this.action = aVar;
        this.cancel = new rx.internal.util.m(new b(this, mVar));
    }
}
