package rx.internal.schedulers;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import rx.h;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class c extends rx.h {

    /* renamed from: a, reason: collision with root package name */
    final Executor f54006a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class a extends h.a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final Executor f54007a;

        /* renamed from: c, reason: collision with root package name */
        final ConcurrentLinkedQueue<ScheduledAction> f54009c = new ConcurrentLinkedQueue<>();

        /* renamed from: d, reason: collision with root package name */
        final AtomicInteger f54010d = new AtomicInteger();

        /* renamed from: b, reason: collision with root package name */
        final rx.subscriptions.b f54008b = new rx.subscriptions.b();

        /* renamed from: e, reason: collision with root package name */
        final ScheduledExecutorService f54011e = d.a();

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: rx.internal.schedulers.c$a$a, reason: collision with other inner class name */
        class C1066a implements rx.functions.a {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ rx.subscriptions.c f54012a;

            C1066a(rx.subscriptions.c cVar) {
                this.f54012a = cVar;
            }

            @Override // rx.functions.a
            public void call() {
                a.this.f54008b.f(this.f54012a);
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class b implements rx.functions.a {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ rx.subscriptions.c f54014a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ rx.functions.a f54015b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ rx.m f54016c;

            b(rx.subscriptions.c cVar, rx.functions.a aVar, rx.m mVar) {
                this.f54014a = cVar;
                this.f54015b = aVar;
                this.f54016c = mVar;
            }

            @Override // rx.functions.a
            public void call() {
                if (this.f54014a.isUnsubscribed()) {
                    return;
                }
                rx.m d6 = a.this.d(this.f54015b);
                this.f54014a.b(d6);
                if (d6.getClass() == ScheduledAction.class) {
                    ((ScheduledAction) d6).add(this.f54016c);
                }
            }
        }

        @Override // rx.h.a
        public rx.m e(rx.functions.a aVar, long j6, TimeUnit timeUnit) {
            if (j6 <= 0) {
                return d(aVar);
            }
            if (isUnsubscribed()) {
                return rx.subscriptions.f.e();
            }
            rx.functions.a P = rx.plugins.c.P(aVar);
            rx.subscriptions.c cVar = new rx.subscriptions.c();
            rx.subscriptions.c cVar2 = new rx.subscriptions.c();
            cVar2.b(cVar);
            this.f54008b.a(cVar2);
            rx.m a6 = rx.subscriptions.f.a(new C1066a(cVar2));
            ScheduledAction scheduledAction = new ScheduledAction(new b(cVar2, P, a6));
            cVar.b(scheduledAction);
            try {
                scheduledAction.add(this.f54011e.schedule(scheduledAction, j6, timeUnit));
                return a6;
            } catch (RejectedExecutionException e6) {
                rx.plugins.c.I(e6);
                throw e6;
            }
        }

        @Override // rx.m
        public boolean isUnsubscribed() {
            return this.f54008b.isUnsubscribed();
        }

        @Override // java.lang.Runnable
        public void run() {
            while (!this.f54008b.isUnsubscribed()) {
                ScheduledAction poll = this.f54009c.poll();
                if (poll == null) {
                    return;
                }
                if (!poll.isUnsubscribed()) {
                    if (this.f54008b.isUnsubscribed()) {
                        this.f54009c.clear();
                        return;
                    }
                    poll.run();
                }
                if (this.f54010d.decrementAndGet() == 0) {
                    return;
                }
            }
            this.f54009c.clear();
        }

        @Override // rx.m
        public void unsubscribe() {
            this.f54008b.unsubscribe();
            this.f54009c.clear();
        }

        public a(Executor executor) {
            this.f54007a = executor;
        }

        @Override // rx.h.a
        public rx.m d(rx.functions.a aVar) {
            if (isUnsubscribed()) {
                return rx.subscriptions.f.e();
            }
            ScheduledAction scheduledAction = new ScheduledAction(rx.plugins.c.P(aVar), this.f54008b);
            this.f54008b.a(scheduledAction);
            this.f54009c.offer(scheduledAction);
            if (this.f54010d.getAndIncrement() == 0) {
                try {
                    this.f54007a.execute(this);
                    return scheduledAction;
                } catch (RejectedExecutionException e6) {
                    this.f54008b.f(scheduledAction);
                    this.f54010d.decrementAndGet();
                    rx.plugins.c.I(e6);
                    throw e6;
                }
            }
            return scheduledAction;
        }
    }

    @Override // rx.h
    public h.a a() {
        return new a(this.f54006a);
    }

    public c(Executor executor) {
        this.f54006a = executor;
    }
}
