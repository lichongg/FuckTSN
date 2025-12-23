package com.bykv.vk.component.ttvideo.utils;

import com.bytedance.sdk.component.oq.oq;
import com.bytedance.sdk.component.oq.r.r;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.Future;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\Downloads\app\classes3.dex */
public class LiveThreadPool {
    private static final String TAG = "LiveThreadPool";
    private static final int THREADPOOL_MAX_RUNNING_TASK_SIZE = 5;
    private static volatile ThreadPoolExecutor mExecutorInstance;
    private static Deque<AsyncRunnable> mReadyRunnables = new ArrayDeque();
    private static Deque<AsyncRunnable> mRunningRunnables = new ArrayDeque();

    public static class AsyncRunnable implements Runnable {
        private Runnable mRunnable;

        @Override // java.lang.Runnable
        public void run() {
            this.mRunnable.run();
            LiveThreadPool._finished(this);
        }

        public AsyncRunnable(Runnable runnable) {
            this.mRunnable = runnable;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void _finished(AsyncRunnable asyncRunnable) {
        synchronized (LiveThreadPool.class) {
            mRunningRunnables.remove(asyncRunnable);
            _promoteRunnable();
        }
    }

    private static void _promoteRunnable() {
        if (mReadyRunnables.size() > 0) {
            Iterator<AsyncRunnable> it = mReadyRunnables.iterator();
            if (it.hasNext()) {
                AsyncRunnable next = it.next();
                it.remove();
                mRunningRunnables.add(next);
                mExecutorInstance.execute(next);
            }
        }
    }

    public static synchronized Future addExecuteTask(Runnable runnable) {
        synchronized (LiveThreadPool.class) {
            if (runnable == null) {
                return null;
            }
            try {
                if (mExecutorInstance == null) {
                    getExecutorInstance();
                }
                getPoolSize();
                AsyncRunnable asyncRunnable = new AsyncRunnable(runnable);
                if (mRunningRunnables.size() >= 5) {
                    mReadyRunnables.add(asyncRunnable);
                    return null;
                }
                mRunningRunnables.add(asyncRunnable);
                return mExecutorInstance.submit(asyncRunnable);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static ThreadPoolExecutor getExecutorInstance() {
        if (mExecutorInstance == null) {
            synchronized (LiveThreadPool.class) {
                try {
                    if (mExecutorInstance == null) {
                        mExecutorInstance = new r(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), new oq("iveThreadPool"));
                    }
                } finally {
                }
            }
        }
        return mExecutorInstance;
    }

    public static int getPoolSize() {
        if (mExecutorInstance == null) {
            getExecutorInstance();
        }
        return mExecutorInstance.getPoolSize();
    }

    public static void setExecutorInstance(ThreadPoolExecutor threadPoolExecutor) {
        synchronized (LiveThreadPool.class) {
            mExecutorInstance = threadPoolExecutor;
        }
    }

    public static void shutdown() {
        if (mExecutorInstance != null) {
            mExecutorInstance.shutdown();
        }
    }
}
