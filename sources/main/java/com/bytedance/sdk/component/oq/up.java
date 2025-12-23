package com.bytedance.sdk.component.oq;

import java.lang.reflect.Field;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\Downloads\app\classes4.dex */
public final class up {
    public static ThreadGroup xt() {
        try {
            Field declaredField = ThreadGroup.class.getDeclaredField("systemThreadGroup");
            declaredField.setAccessible(true);
            return (ThreadGroup) declaredField.get(ThreadGroup.class);
        } catch (Exception e6) {
            j(e6);
            return null;
        }
    }

    private static void j(Throwable th) {
        th.getMessage();
    }

    public static int j() {
        ThreadGroup xt = xt();
        if (xt == null) {
            return 0;
        }
        int activeCount = xt.activeCount();
        try {
            return xt.enumerate(new Thread[(activeCount / 2) + activeCount]);
        } catch (Throwable unused) {
            return activeCount;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void xt(ThreadPoolExecutor threadPoolExecutor) {
        try {
            threadPoolExecutor.setKeepAliveTime(1L, TimeUnit.MILLISECONDS);
            threadPoolExecutor.allowCoreThreadTimeOut(true);
        } catch (Exception e6) {
            j(e6);
        }
        BlockingQueue<Runnable> queue = threadPoolExecutor.getQueue();
        while (true) {
            if (queue != null) {
                try {
                    if (queue.size() > 0) {
                        while (true) {
                            Runnable poll = queue.poll(0L, TimeUnit.MILLISECONDS);
                            if (poll == null) {
                                break;
                            } else {
                                poll.run();
                            }
                        }
                    }
                } catch (Exception unused) {
                }
            }
            if (threadPoolExecutor.getActiveCount() == 0) {
                threadPoolExecutor.shutdown();
                return;
            }
            Thread.sleep(1000L);
        }
    }

    public static void j(ExecutorService executorService, final ThreadPoolExecutor threadPoolExecutor) {
        if (threadPoolExecutor != null) {
            try {
                threadPoolExecutor.allowCoreThreadTimeOut(true);
                threadPoolExecutor.setKeepAliveTime(2L, TimeUnit.MILLISECONDS);
            } catch (Exception e6) {
                j(e6);
            }
            executorService.execute(new Runnable() { // from class: com.bytedance.sdk.component.oq.up.1
                @Override // java.lang.Runnable
                public void run() {
                    up.xt(threadPoolExecutor);
                }
            });
        }
    }
}
