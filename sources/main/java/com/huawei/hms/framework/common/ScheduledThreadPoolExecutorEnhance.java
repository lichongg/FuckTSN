package com.huawei.hms.framework.common;

import java.util.concurrent.Callable;
import java.util.concurrent.RunnableScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class ScheduledThreadPoolExecutorEnhance extends ScheduledThreadPoolExecutor {

    /* renamed from: a, reason: collision with root package name */
    private static final String f33347a = "ScheduledThreadPoolExec";

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor
    protected <V> RunnableScheduledFuture<V> decorateTask(Runnable runnable, RunnableScheduledFuture<V> runnableScheduledFuture) {
        return new RunnableScheduledFutureEnhance(super.decorateTask(runnable, runnableScheduledFuture));
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    protected void beforeExecute(Thread thread, Runnable runnable) {
        if (runnable instanceof RunnableScheduledFutureEnhance) {
            String parentName = ((RunnableScheduledFutureEnhance) runnable).getParentName();
            int lastIndexOf = parentName.lastIndexOf(" -->");
            if (lastIndexOf != -1) {
                parentName = StringUtils.substring(parentName, lastIndexOf + 4);
            }
            String name = thread.getName();
            int lastIndexOf2 = name.lastIndexOf(" -->");
            if (lastIndexOf2 != -1) {
                name = StringUtils.substring(name, lastIndexOf2 + 4);
            }
            thread.setName(parentName + " -->" + name);
        }
        super.beforeExecute(thread, runnable);
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor
    protected <V> RunnableScheduledFuture<V> decorateTask(Callable<V> callable, RunnableScheduledFuture<V> runnableScheduledFuture) {
        return new RunnableScheduledFutureEnhance(super.decorateTask(callable, runnableScheduledFuture));
    }

    public ScheduledThreadPoolExecutorEnhance(int i6, ThreadFactory threadFactory) {
        super(i6, threadFactory);
    }
}
