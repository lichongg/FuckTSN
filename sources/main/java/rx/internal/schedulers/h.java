package rx.internal.schedulers;

import androidx.camera.view.p;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import rx.h;
import rx.internal.util.RxThreadFactory;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class h extends h.a implements rx.m {

    /* renamed from: d, reason: collision with root package name */
    private static final String f54031d = "rx.scheduler.jdk6.purge-force";

    /* renamed from: e, reason: collision with root package name */
    private static final String f54032e = "RxSchedulerPurge-";

    /* renamed from: f, reason: collision with root package name */
    private static final boolean f54033f;

    /* renamed from: j, reason: collision with root package name */
    private static volatile Object f54037j;

    /* renamed from: a, reason: collision with root package name */
    private final ScheduledExecutorService f54039a;

    /* renamed from: b, reason: collision with root package name */
    volatile boolean f54040b;

    /* renamed from: k, reason: collision with root package name */
    private static final Object f54038k = new Object();

    /* renamed from: h, reason: collision with root package name */
    private static final ConcurrentHashMap<ScheduledThreadPoolExecutor, ScheduledThreadPoolExecutor> f54035h = new ConcurrentHashMap<>();

    /* renamed from: i, reason: collision with root package name */
    private static final AtomicReference<ScheduledExecutorService> f54036i = new AtomicReference<>();

    /* renamed from: c, reason: collision with root package name */
    private static final String f54030c = "rx.scheduler.jdk6.purge-frequency-millis";

    /* renamed from: g, reason: collision with root package name */
    public static final int f54034g = Integer.getInteger(f54030c, 1000).intValue();

    @Override // rx.m
    public void unsubscribe() {
        this.f54040b = true;
        this.f54039a.shutdownNow();
        g(this.f54039a);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            h.s();
        }
    }

    static {
        boolean z5 = Boolean.getBoolean(f54031d);
        int a6 = rx.internal.util.i.a();
        f54033f = !z5 && (a6 == 0 || a6 >= 21);
    }

    public static void A(ScheduledThreadPoolExecutor scheduledThreadPoolExecutor) {
        while (true) {
            AtomicReference<ScheduledExecutorService> atomicReference = f54036i;
            if (atomicReference.get() != null) {
                break;
            }
            ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, new RxThreadFactory(f54032e));
            if (p.a(atomicReference, null, newScheduledThreadPool)) {
                a aVar = new a();
                int i6 = f54034g;
                newScheduledThreadPool.scheduleAtFixedRate(aVar, i6, i6, TimeUnit.MILLISECONDS);
                break;
            }
            newScheduledThreadPool.shutdownNow();
        }
        f54035h.putIfAbsent(scheduledThreadPoolExecutor, scheduledThreadPoolExecutor);
    }

    public static boolean N(ScheduledExecutorService scheduledExecutorService) {
        Method j6;
        if (f54033f) {
            if (scheduledExecutorService instanceof ScheduledThreadPoolExecutor) {
                Object obj = f54037j;
                Object obj2 = f54038k;
                if (obj == obj2) {
                    return false;
                }
                if (obj == null) {
                    j6 = j(scheduledExecutorService);
                    if (j6 != null) {
                        obj2 = j6;
                    }
                    f54037j = obj2;
                } else {
                    j6 = (Method) obj;
                }
            } else {
                j6 = j(scheduledExecutorService);
            }
            if (j6 != null) {
                try {
                    j6.invoke(scheduledExecutorService, Boolean.TRUE);
                    return true;
                } catch (IllegalAccessException e6) {
                    rx.plugins.c.I(e6);
                } catch (IllegalArgumentException e7) {
                    rx.plugins.c.I(e7);
                } catch (InvocationTargetException e8) {
                    rx.plugins.c.I(e8);
                }
            }
        }
        return false;
    }

    public static void g(ScheduledExecutorService scheduledExecutorService) {
        f54035h.remove(scheduledExecutorService);
    }

    static void s() {
        try {
            Iterator<ScheduledThreadPoolExecutor> it = f54035h.keySet().iterator();
            while (it.hasNext()) {
                ScheduledThreadPoolExecutor next = it.next();
                if (next.isShutdown()) {
                    it.remove();
                } else {
                    next.purge();
                }
            }
        } catch (Throwable th) {
            rx.exceptions.a.e(th);
            rx.plugins.c.I(th);
        }
    }

    @Override // rx.h.a
    public rx.m d(rx.functions.a aVar) {
        return e(aVar, 0L, null);
    }

    @Override // rx.h.a
    public rx.m e(rx.functions.a aVar, long j6, TimeUnit timeUnit) {
        return this.f54040b ? rx.subscriptions.f.e() : B(aVar, j6, timeUnit);
    }

    @Override // rx.m
    public boolean isUnsubscribed() {
        return this.f54040b;
    }

    public h(ThreadFactory threadFactory) {
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, threadFactory);
        if (!N(newScheduledThreadPool) && (newScheduledThreadPool instanceof ScheduledThreadPoolExecutor)) {
            A((ScheduledThreadPoolExecutor) newScheduledThreadPool);
        }
        this.f54039a = newScheduledThreadPool;
    }

    static Method j(ScheduledExecutorService scheduledExecutorService) {
        for (Method method : scheduledExecutorService.getClass().getMethods()) {
            if (method.getName().equals("setRemoveOnCancelPolicy")) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length == 1 && parameterTypes[0] == Boolean.TYPE) {
                    return method;
                }
            }
        }
        return null;
    }

    public ScheduledAction B(rx.functions.a aVar, long j6, TimeUnit timeUnit) {
        Future<?> schedule;
        ScheduledAction scheduledAction = new ScheduledAction(rx.plugins.c.P(aVar));
        if (j6 <= 0) {
            schedule = this.f54039a.submit(scheduledAction);
        } else {
            schedule = this.f54039a.schedule(scheduledAction, j6, timeUnit);
        }
        scheduledAction.add(schedule);
        return scheduledAction;
    }

    public ScheduledAction G(rx.functions.a aVar, long j6, TimeUnit timeUnit, rx.internal.util.m mVar) {
        Future<?> schedule;
        ScheduledAction scheduledAction = new ScheduledAction(rx.plugins.c.P(aVar), mVar);
        mVar.a(scheduledAction);
        if (j6 <= 0) {
            schedule = this.f54039a.submit(scheduledAction);
        } else {
            schedule = this.f54039a.schedule(scheduledAction, j6, timeUnit);
        }
        scheduledAction.add(schedule);
        return scheduledAction;
    }

    public ScheduledAction H(rx.functions.a aVar, long j6, TimeUnit timeUnit, rx.subscriptions.b bVar) {
        Future<?> schedule;
        ScheduledAction scheduledAction = new ScheduledAction(rx.plugins.c.P(aVar), bVar);
        bVar.a(scheduledAction);
        if (j6 <= 0) {
            schedule = this.f54039a.submit(scheduledAction);
        } else {
            schedule = this.f54039a.schedule(scheduledAction, j6, timeUnit);
        }
        scheduledAction.add(schedule);
        return scheduledAction;
    }
}
