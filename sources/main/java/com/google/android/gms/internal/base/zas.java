package com.google.android.gms.internal.base;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zas implements zaq {
    /* synthetic */ zas(zar zarVar) {
    }

    @Override // com.google.android.gms.internal.base.zaq
    public final ExecutorService zaa(ThreadFactory threadFactory, int i6) {
        return zac(1, threadFactory, 1);
    }

    private zas() {
    }

    @Override // com.google.android.gms.internal.base.zaq
    public final ExecutorService zac(int i6, ThreadFactory threadFactory, int i7) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i6, i6, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), threadFactory);
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return Executors.unconfigurableExecutorService(threadPoolExecutor);
    }

    @Override // com.google.android.gms.internal.base.zaq
    public final ExecutorService zab(int i6, int i7) {
        return zac(4, Executors.defaultThreadFactory(), 2);
    }
}
