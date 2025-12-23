package rx.internal.schedulers;

import androidx.camera.view.p;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class d implements j {

    /* renamed from: b, reason: collision with root package name */
    private static final ScheduledExecutorService[] f54018b = new ScheduledExecutorService[0];

    /* renamed from: c, reason: collision with root package name */
    private static final ScheduledExecutorService f54019c;

    /* renamed from: d, reason: collision with root package name */
    public static final d f54020d;

    /* renamed from: e, reason: collision with root package name */
    private static int f54021e;

    /* renamed from: a, reason: collision with root package name */
    private final AtomicReference<ScheduledExecutorService[]> f54022a = new AtomicReference<>(f54018b);

    static {
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(0);
        f54019c = newScheduledThreadPool;
        newScheduledThreadPool.shutdown();
        f54020d = new d();
    }

    public static ScheduledExecutorService a() {
        ScheduledExecutorService[] scheduledExecutorServiceArr = f54020d.f54022a.get();
        if (scheduledExecutorServiceArr == f54018b) {
            return f54019c;
        }
        int i6 = f54021e + 1;
        if (i6 >= scheduledExecutorServiceArr.length) {
            i6 = 0;
        }
        f54021e = i6;
        return scheduledExecutorServiceArr[i6];
    }

    @Override // rx.internal.schedulers.j
    public void shutdown() {
        ScheduledExecutorService[] scheduledExecutorServiceArr;
        ScheduledExecutorService[] scheduledExecutorServiceArr2;
        do {
            scheduledExecutorServiceArr = this.f54022a.get();
            scheduledExecutorServiceArr2 = f54018b;
            if (scheduledExecutorServiceArr == scheduledExecutorServiceArr2) {
                return;
            }
        } while (!p.a(this.f54022a, scheduledExecutorServiceArr, scheduledExecutorServiceArr2));
        for (ScheduledExecutorService scheduledExecutorService : scheduledExecutorServiceArr) {
            h.g(scheduledExecutorService);
            scheduledExecutorService.shutdownNow();
        }
    }

    private d() {
        start();
    }

    @Override // rx.internal.schedulers.j
    public void start() {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        if (availableProcessors > 4) {
            availableProcessors /= 2;
        }
        if (availableProcessors > 8) {
            availableProcessors = 8;
        }
        ScheduledExecutorService[] scheduledExecutorServiceArr = new ScheduledExecutorService[availableProcessors];
        int i6 = 0;
        for (int i7 = 0; i7 < availableProcessors; i7++) {
            scheduledExecutorServiceArr[i7] = e.a();
        }
        if (p.a(this.f54022a, f54018b, scheduledExecutorServiceArr)) {
            while (i6 < availableProcessors) {
                ScheduledExecutorService scheduledExecutorService = scheduledExecutorServiceArr[i6];
                if (!h.N(scheduledExecutorService) && (scheduledExecutorService instanceof ScheduledThreadPoolExecutor)) {
                    h.A((ScheduledThreadPoolExecutor) scheduledExecutorService);
                }
                i6++;
            }
            return;
        }
        while (i6 < availableProcessors) {
            scheduledExecutorServiceArr[i6].shutdownNow();
            i6++;
        }
    }
}
