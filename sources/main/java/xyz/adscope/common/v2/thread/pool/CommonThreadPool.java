package xyz.adscope.common.v2.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public final class CommonThreadPool {
    private final int BASIC_CORE_SIZE;
    private final ExecutorService mCacheExecutor;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: xyz.adscope.common.v2.thread.pool.CommonThreadPool$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class InstanceHolder {
        private static CommonThreadPool instance = new CommonThreadPool(null);

        private InstanceHolder() {
        }
    }

    /* synthetic */ CommonThreadPool(AnonymousClass1 anonymousClass1) {
        this();
    }

    private CommonThreadPool() {
        this.BASIC_CORE_SIZE = 6;
        this.mCacheExecutor = Executors.newFixedThreadPool(6);
        if (InstanceHolder.instance != null) {
            throw new RuntimeException("Singleton ...");
        }
    }

    public void executeResourceCacheTask(Runnable runnable) {
        this.mCacheExecutor.execute(runnable);
    }

    public static CommonThreadPool getInstance() {
        return InstanceHolder.instance;
    }
}
