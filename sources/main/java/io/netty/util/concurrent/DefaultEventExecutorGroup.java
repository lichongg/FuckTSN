package io.netty.util.concurrent;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadFactory;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class DefaultEventExecutorGroup extends MultithreadEventExecutorGroup {
    public DefaultEventExecutorGroup(int i6) {
        this(i6, null);
    }

    public DefaultEventExecutorGroup(int i6, ThreadFactory threadFactory) {
        this(i6, threadFactory, SingleThreadEventExecutor.DEFAULT_MAX_PENDING_EXECUTOR_TASKS, RejectedExecutionHandlers.reject());
    }

    @Override // io.netty.util.concurrent.MultithreadEventExecutorGroup
    protected EventExecutor newChild(Executor executor, Object... objArr) throws Exception {
        return new DefaultEventExecutor(this, executor, ((Integer) objArr[0]).intValue(), (RejectedExecutionHandler) objArr[1]);
    }

    public DefaultEventExecutorGroup(int i6, ThreadFactory threadFactory, int i7, RejectedExecutionHandler rejectedExecutionHandler) {
        super(i6, threadFactory, Integer.valueOf(i7), rejectedExecutionHandler);
    }
}
