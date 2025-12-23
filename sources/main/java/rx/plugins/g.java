package rx.plugins;

import java.util.concurrent.ThreadFactory;
import rx.internal.util.RxThreadFactory;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private static final g f54467a = new g();

    public rx.h g() {
        return null;
    }

    public rx.h i() {
        return null;
    }

    public rx.h j() {
        return null;
    }

    public static rx.h a() {
        return b(new RxThreadFactory("RxComputationScheduler-"));
    }

    public static rx.h b(ThreadFactory threadFactory) {
        if (threadFactory != null) {
            return new rx.internal.schedulers.b(threadFactory);
        }
        throw new NullPointerException("threadFactory == null");
    }

    public static rx.h c() {
        return d(new RxThreadFactory("RxIoScheduler-"));
    }

    public static rx.h d(ThreadFactory threadFactory) {
        if (threadFactory != null) {
            return new rx.internal.schedulers.a(threadFactory);
        }
        throw new NullPointerException("threadFactory == null");
    }

    public static rx.h e() {
        return f(new RxThreadFactory("RxNewThreadScheduler-"));
    }

    public static rx.h f(ThreadFactory threadFactory) {
        if (threadFactory != null) {
            return new rx.internal.schedulers.g(threadFactory);
        }
        throw new NullPointerException("threadFactory == null");
    }

    public static g h() {
        return f54467a;
    }

    @Deprecated
    public rx.functions.a k(rx.functions.a aVar) {
        return aVar;
    }
}
