package rx.internal.schedulers;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import rx.functions.o;
import rx.internal.util.RxThreadFactory;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
enum e {
    ;


    /* renamed from: a, reason: collision with root package name */
    static final String f54023a = "RxScheduledExecutorPool-";

    /* renamed from: b, reason: collision with root package name */
    static final RxThreadFactory f54024b = new RxThreadFactory(f54023a);

    static ScheduledExecutorService b() {
        return Executors.newScheduledThreadPool(1, c());
    }

    static ThreadFactory c() {
        return f54024b;
    }

    public static ScheduledExecutorService a() {
        o<? extends ScheduledExecutorService> j6 = rx.plugins.c.j();
        if (j6 == null) {
            return b();
        }
        return j6.call();
    }
}
