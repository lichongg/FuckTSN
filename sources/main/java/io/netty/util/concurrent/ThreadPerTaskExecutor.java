package io.netty.util.concurrent;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadFactory;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class ThreadPerTaskExecutor implements Executor {
    private final ThreadFactory threadFactory;

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.threadFactory.newThread(runnable).start();
    }

    public ThreadPerTaskExecutor(ThreadFactory threadFactory) {
        if (threadFactory != null) {
            this.threadFactory = threadFactory;
            return;
        }
        throw new NullPointerException("threadFactory");
    }
}
