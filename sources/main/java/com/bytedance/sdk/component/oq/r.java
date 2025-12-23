package com.bytedance.sdk.component.oq;

import java.lang.Thread;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\Downloads\app\classes4.dex */
public class r {

    /* renamed from: j, reason: collision with root package name */
    public static final r f26648j = new r();
    private xt cw;

    /* renamed from: r, reason: collision with root package name */
    private j f26649r;
    private final List<WeakReference<ThreadPoolExecutor>> xt = new ArrayList();

    public interface j {
    }

    public interface xt {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cw() {
        List<ThreadPoolExecutor> j6 = j(null, false, false);
        if (j6 == null || j6.size() == 0) {
            return;
        }
        if (this.cw != null) {
            up.j();
        }
        HashMap hashMap = new HashMap();
        for (ThreadPoolExecutor threadPoolExecutor : j6) {
            if (threadPoolExecutor != null) {
                ThreadFactory threadFactory = threadPoolExecutor.getThreadFactory();
                if (threadFactory instanceof oq) {
                    hashMap.put(((oq) threadFactory).f26631j + "_" + threadPoolExecutor.hashCode(), Integer.valueOf(threadPoolExecutor.getPoolSize()));
                } else if (threadFactory instanceof com.bytedance.sdk.component.oq.j.r) {
                    hashMap.put(((com.bytedance.sdk.component.oq.j.r) threadFactory).j() + "_" + threadPoolExecutor.hashCode(), Integer.valueOf(threadPoolExecutor.getPoolSize()));
                } else {
                    hashMap.put(threadFactory.getClass().getName() + "_" + threadPoolExecutor.hashCode(), Integer.valueOf(threadPoolExecutor.getPoolSize()));
                }
                j(threadPoolExecutor);
            }
        }
        if (this.cw != null) {
            up.j();
        }
    }

    private ScheduledExecutorService xt() {
        return qv.xt.vl();
    }

    public synchronized void j(com.bytedance.sdk.component.oq.r.r rVar) {
        xt(rVar);
        this.xt.add(new WeakReference<>(rVar));
    }

    public synchronized void xt(com.bytedance.sdk.component.oq.r.r rVar) {
        Iterator<WeakReference<ThreadPoolExecutor>> it = this.xt.iterator();
        while (it.hasNext()) {
            if (it.next().get() == rVar) {
                it.remove();
            }
        }
    }

    private r() {
        xt().schedule(new Runnable() { // from class: com.bytedance.sdk.component.oq.r.4
            @Override // java.lang.Runnable
            public void run() {
            }
        }, 1L, TimeUnit.MINUTES);
    }

    public String j(BlockingQueue blockingQueue) {
        if (blockingQueue instanceof com.bytedance.sdk.component.oq.j.j) {
            return ((com.bytedance.sdk.component.oq.j.j) blockingQueue).j();
        }
        return blockingQueue.getClass().getName();
    }

    public ThreadPoolExecutor j(String str, String str2) {
        List<ThreadPoolExecutor> j6 = j(str2, false, true);
        j(j6, str);
        ThreadPoolExecutor threadPoolExecutor = j6.size() > 0 ? j6.get(0) : null;
        j();
        return threadPoolExecutor;
    }

    private synchronized List<ThreadPoolExecutor> j(String str, boolean z5, boolean z6) {
        ArrayList arrayList;
        ThreadPoolExecutor threadPoolExecutor;
        boolean z7;
        try {
            arrayList = new ArrayList();
            for (WeakReference<ThreadPoolExecutor> weakReference : this.xt) {
                if (weakReference != null && (threadPoolExecutor = weakReference.get()) != null) {
                    BlockingQueue<Runnable> queue = threadPoolExecutor.getQueue();
                    if (queue instanceof com.bytedance.sdk.component.oq.j.j) {
                        z7 = ((com.bytedance.sdk.component.oq.j.j) queue).xt() instanceof PriorityBlockingQueue;
                    } else {
                        z7 = queue instanceof PriorityBlockingQueue;
                    }
                    if (!threadPoolExecutor.isShutdown() && !threadPoolExecutor.isTerminated() && !threadPoolExecutor.isTerminating() && threadPoolExecutor.getQueue().isEmpty() && (str == null || !z7)) {
                        if (threadPoolExecutor.getActiveCount() < threadPoolExecutor.getPoolSize()) {
                            arrayList.add(threadPoolExecutor);
                            if (z5) {
                                break;
                            }
                        } else {
                            continue;
                        }
                    }
                }
            }
            if (z6 && !z5) {
                try {
                    Collections.sort(arrayList, new Comparator<ThreadPoolExecutor>() { // from class: com.bytedance.sdk.component.oq.r.1
                        @Override // java.util.Comparator
                        /* renamed from: j, reason: merged with bridge method [inline-methods] */
                        public int compare(ThreadPoolExecutor threadPoolExecutor2, ThreadPoolExecutor threadPoolExecutor3) {
                            int poolSize = threadPoolExecutor2.getPoolSize() - threadPoolExecutor2.getActiveCount();
                            int poolSize2 = threadPoolExecutor3.getPoolSize() - threadPoolExecutor3.getActiveCount();
                            if (poolSize2 > poolSize) {
                                return 1;
                            }
                            if (poolSize > poolSize2) {
                                return -1;
                            }
                            return 0;
                        }
                    });
                } catch (Exception e6) {
                    com.bytedance.sdk.component.utils.vl.j(e6);
                }
            }
            arrayList.size();
            this.xt.size();
        } catch (Throwable th) {
            throw th;
        }
        return arrayList;
    }

    public void j() {
        if (qv.xt.j()) {
            xt().schedule(new Runnable() { // from class: com.bytedance.sdk.component.oq.r.2
                @Override // java.lang.Runnable
                public void run() {
                    r.this.cw();
                }
            }, 100L, TimeUnit.MILLISECONDS);
        }
    }

    private void j(final ThreadPoolExecutor threadPoolExecutor) {
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        final long keepAliveTime = threadPoolExecutor.getKeepAliveTime(timeUnit);
        final boolean allowsCoreThreadTimeOut = threadPoolExecutor.allowsCoreThreadTimeOut();
        threadPoolExecutor.setKeepAliveTime(1L, timeUnit);
        if (allowsCoreThreadTimeOut) {
            threadPoolExecutor.allowCoreThreadTimeOut(false);
        }
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        xt().schedule(new Runnable() { // from class: com.bytedance.sdk.component.oq.r.3
            @Override // java.lang.Runnable
            public void run() {
                ThreadPoolExecutor threadPoolExecutor2 = threadPoolExecutor;
                long j6 = keepAliveTime;
                if (j6 == 0) {
                    j6 = 60;
                }
                threadPoolExecutor2.setKeepAliveTime(j6, TimeUnit.NANOSECONDS);
                threadPoolExecutor.allowCoreThreadTimeOut(allowsCoreThreadTimeOut);
            }
        }, 10L, TimeUnit.MILLISECONDS);
    }

    private void j(List<ThreadPoolExecutor> list, String str) {
        if (list == null || list.size() == 0 || this.f26649r == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        for (ThreadPoolExecutor threadPoolExecutor : list) {
            if (threadPoolExecutor != null) {
                ThreadFactory threadFactory = threadPoolExecutor.getThreadFactory();
                if (threadFactory instanceof oq) {
                    hashMap.put(((oq) threadFactory).f26631j + "_" + threadPoolExecutor.hashCode(), Integer.valueOf(threadPoolExecutor.getPoolSize()));
                } else if (threadFactory instanceof com.bytedance.sdk.component.oq.j.r) {
                    hashMap.put(((com.bytedance.sdk.component.oq.j.r) threadFactory).j() + "_" + threadPoolExecutor.hashCode(), Integer.valueOf(threadPoolExecutor.getPoolSize()));
                } else {
                    hashMap.put(threadFactory.getClass().getName() + "_" + threadPoolExecutor.hashCode(), Integer.valueOf(threadPoolExecutor.getPoolSize()));
                }
            }
        }
        HashMap hashMap2 = new HashMap();
        ThreadGroup xt2 = up.xt();
        int activeCount = xt2.activeCount();
        Thread[] threadArr = new Thread[activeCount + (activeCount / 2)];
        int enumerate = xt2.enumerate(threadArr);
        for (int i6 = 0; i6 < enumerate; i6++) {
            Thread thread = threadArr[i6];
            Thread.State state = thread.getState();
            if (state == Thread.State.BLOCKED || state == Thread.State.WAITING || state == Thread.State.TIMED_WAITING) {
                String replaceAll = thread.getName().replaceAll("[0-9]", "");
                Integer num = (Integer) hashMap2.get(replaceAll);
                hashMap2.put(replaceAll, Integer.valueOf(num != null ? 1 + num.intValue() : 1));
            }
        }
    }

    public void j(String str) {
        List<ThreadPoolExecutor> j6 = j(null, false, true);
        if (j6 == null || j6.size() == 0) {
            return;
        }
        j(j6, str);
        j6.size();
        ThreadPoolExecutor threadPoolExecutor = j6.get(0);
        if (threadPoolExecutor != null) {
            j(threadPoolExecutor);
        }
        j();
    }
}
