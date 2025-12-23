package com.kwad.sdk.core.threads;

import android.util.Log;
import androidx.annotation.NonNull;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class GlobalThreadPools {
    private static String TAG;
    private static final int aJs;
    private static final int aJt;
    private static final int aJu;
    private static Map<String, WeakReference<ExecutorService>> aJv;
    private static Map<String, Integer> aJw;
    private static boolean aJx;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    enum ParamType {
        CORE,
        MAX,
        KEEP_ALIVE
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    interface a {
        @NonNull
        ExecutorService JE();
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class b implements a {
        private b() {
        }

        /* synthetic */ b(byte b6) {
            this();
        }

        @Override // com.kwad.sdk.core.threads.GlobalThreadPools.a
        @NonNull
        public final ExecutorService JE() {
            return new com.kwad.sdk.core.threads.a.b(GlobalThreadPools.a("httpIO", ParamType.CORE, GlobalThreadPools.aJt), GlobalThreadPools.a("httpIO", ParamType.MAX, GlobalThreadPools.aJu), GlobalThreadPools.a("httpIO", ParamType.KEEP_ALIVE, 60), TimeUnit.SECONDS, new LinkedBlockingQueue(), new f(5, "diskAndHttp"));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class c implements a {
        private c() {
        }

        /* synthetic */ c(byte b6) {
            this();
        }

        @Override // com.kwad.sdk.core.threads.GlobalThreadPools.a
        @NonNull
        public final ExecutorService JE() {
            int i6 = 5;
            f fVar = new f(5, "ForCore");
            try {
                int a6 = GlobalThreadPools.a("httpIOForCoreV1", ParamType.CORE, 5);
                int a7 = GlobalThreadPools.a("httpIOForCoreV1", ParamType.MAX, 5);
                if (a6 < 0) {
                    a6 = 5;
                }
                if (a7 < 0) {
                    a7 = 5;
                }
                if (a7 < a6) {
                    a7 = 5;
                } else {
                    i6 = a6;
                }
                com.kwad.sdk.core.d.c.d(GlobalThreadPools.TAG, "HttpIOCreatorForCore create, coreSize:" + i6 + ", maxSize:" + a7);
                return new com.kwad.sdk.core.threads.a.b(i6, a7, GlobalThreadPools.a("httpIOForCoreV1", r1, GlobalThreadPools.a("httpIOForCoreV1", ParamType.KEEP_ALIVE, 60) >= 0 ? r5 : 60), TimeUnit.SECONDS, new LinkedBlockingQueue(), fVar);
            } catch (Exception e6) {
                com.kwad.sdk.core.d.c.e(GlobalThreadPools.TAG, Log.getStackTraceString(e6));
                return new com.kwad.sdk.core.threads.a.b(5, 5, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), fVar);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class d implements a {
        private d() {
        }

        /* synthetic */ d(byte b6) {
            this();
        }

        @Override // com.kwad.sdk.core.threads.GlobalThreadPools.a
        @NonNull
        public final ExecutorService JE() {
            return new com.kwad.sdk.core.threads.a.b(GlobalThreadPools.a("httpIOForCoreExtraV1", ParamType.CORE, 0), GlobalThreadPools.a("httpIOForCoreExtraV1", ParamType.MAX, 3), GlobalThreadPools.a("httpIOForCoreExtraV1", ParamType.KEEP_ALIVE, 60), TimeUnit.SECONDS, new SynchronousQueue(), new f(5, "ForCoreExtra"), new ThreadPoolExecutor.DiscardPolicy());
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class e implements a {
        private e() {
        }

        /* synthetic */ e(byte b6) {
            this();
        }

        @Override // com.kwad.sdk.core.threads.GlobalThreadPools.a
        @NonNull
        public final ExecutorService JE() {
            return new com.kwad.sdk.core.threads.a.b(GlobalThreadPools.a("imageLoaderDistributor", ParamType.CORE, 0), GlobalThreadPools.a("imageLoaderDistributor", ParamType.MAX, 10), GlobalThreadPools.a("imageLoaderDistributor", ParamType.KEEP_ALIVE, 60), TimeUnit.SECONDS, new SynchronousQueue(), new f(5, "uil-pool-d-"), new ThreadPoolExecutor.DiscardPolicy());
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class f implements ThreadFactory {
        private static final AtomicInteger poolNumber = new AtomicInteger(1);
        private final String namePrefix;
        private final int threadPriority;
        private final AtomicInteger threadNumber = new AtomicInteger(1);
        private final ThreadGroup group = Thread.currentThread().getThreadGroup();

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            Thread thread = new Thread(this.group, runnable, this.namePrefix + this.threadNumber.getAndIncrement(), 0L);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            thread.setPriority(this.threadPriority);
            return thread;
        }

        public f(int i6, String str) {
            this.threadPriority = i6;
            this.namePrefix = "ksad-" + str + poolNumber.getAndIncrement() + "-thread-";
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class g implements a {
        private g() {
        }

        /* synthetic */ g(byte b6) {
            this();
        }

        @Override // com.kwad.sdk.core.threads.GlobalThreadPools.a
        @NonNull
        public final ExecutorService JE() {
            return new com.kwad.sdk.core.threads.a.b(GlobalThreadPools.a("ksImageLoaderTask", ParamType.CORE, 3), GlobalThreadPools.a("ksImageLoaderTask", ParamType.MAX, 3), GlobalThreadPools.a("ksImageLoaderTask", ParamType.KEEP_ALIVE, 60), TimeUnit.SECONDS, new LinkedBlockingQueue(), new f(5, "uil-pool-"));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class h implements a {
        private h() {
        }

        /* synthetic */ h(byte b6) {
            this();
        }

        @Override // com.kwad.sdk.core.threads.GlobalThreadPools.a
        @NonNull
        public final ExecutorService JE() {
            return new com.kwad.sdk.core.threads.a.b(GlobalThreadPools.a("lruDiskCache", ParamType.CORE, 0), GlobalThreadPools.a("lruDiskCache", ParamType.MAX, 1), GlobalThreadPools.a("lruDiskCache", ParamType.KEEP_ALIVE, 60), TimeUnit.SECONDS, new LinkedBlockingQueue(), new f(5, "lruDiskCache"));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class i implements a {
        private i() {
        }

        /* synthetic */ i(byte b6) {
            this();
        }

        @Override // com.kwad.sdk.core.threads.GlobalThreadPools.a
        @NonNull
        public final ExecutorService JE() {
            return new com.kwad.sdk.core.threads.a.b(GlobalThreadPools.a("report", ParamType.CORE, 1), GlobalThreadPools.a("report", ParamType.MAX, 1), GlobalThreadPools.a("report", ParamType.KEEP_ALIVE, 0), TimeUnit.SECONDS, new LinkedBlockingQueue(), new f(3, "report-"));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class j implements a {
        private j() {
        }

        /* synthetic */ j(byte b6) {
            this();
        }

        @Override // com.kwad.sdk.core.threads.GlobalThreadPools.a
        @NonNull
        public final ExecutorService JE() {
            return new com.kwad.sdk.core.threads.a.b(1, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new f(5, "backSingle"));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class k implements a {
        private k() {
        }

        /* synthetic */ k(byte b6) {
            this();
        }

        @Override // com.kwad.sdk.core.threads.GlobalThreadPools.a
        @NonNull
        public final ExecutorService JE() {
            return new com.kwad.sdk.core.threads.a.b(GlobalThreadPools.a("videoCache", ParamType.CORE, 3), GlobalThreadPools.a("videoCache", ParamType.MAX, 3), GlobalThreadPools.a("videoCache", ParamType.KEEP_ALIVE, 60), TimeUnit.SECONDS, new LinkedBlockingQueue(), new f(5, "videoCache"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(7:0|1|(2:3|(3:5|(1:7)|18)(1:19))(1:20)|8|9|(2:13|14)|18) */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int a(java.lang.String r1, com.kwad.sdk.core.threads.GlobalThreadPools.ParamType r2, int r3) {
        /*
            int[] r0 = com.kwad.sdk.core.threads.GlobalThreadPools.AnonymousClass4.aJy
            int r2 = r2.ordinal()
            r2 = r0[r2]
            r0 = 1
            if (r2 == r0) goto L36
            r0 = 2
            if (r2 == r0) goto L24
            r0 = 3
            if (r2 == r0) goto L12
            goto L64
        L12:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r1)
            java.lang.String r1 = "_keep_alive"
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            goto L47
        L24:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r1)
            java.lang.String r1 = "_max"
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            goto L47
        L36:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r1)
            java.lang.String r1 = "_core"
            r2.append(r1)
            java.lang.String r1 = r2.toString()
        L47:
            java.util.Map<java.lang.String, java.lang.Integer> r2 = com.kwad.sdk.core.threads.GlobalThreadPools.aJw     // Catch: java.lang.Exception -> L64
            boolean r2 = r2.containsKey(r1)     // Catch: java.lang.Exception -> L64
            if (r2 == 0) goto L64
            java.util.Map<java.lang.String, java.lang.Integer> r2 = com.kwad.sdk.core.threads.GlobalThreadPools.aJw     // Catch: java.lang.Exception -> L64
            java.lang.Object r2 = r2.get(r1)     // Catch: java.lang.Exception -> L64
            if (r2 == 0) goto L64
            java.util.Map<java.lang.String, java.lang.Integer> r2 = com.kwad.sdk.core.threads.GlobalThreadPools.aJw     // Catch: java.lang.Exception -> L64
            java.lang.Object r1 = r2.get(r1)     // Catch: java.lang.Exception -> L64
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch: java.lang.Exception -> L64
            int r1 = r1.intValue()     // Catch: java.lang.Exception -> L64
            return r1
        L64:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.threads.GlobalThreadPools.a(java.lang.String, com.kwad.sdk.core.threads.GlobalThreadPools$ParamType, int):int");
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.kwad.sdk.core.threads.GlobalThreadPools$4, reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] aJy;

        static {
            int[] iArr = new int[ParamType.values().length];
            aJy = iArr;
            try {
                iArr[ParamType.CORE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                aJy[ParamType.MAX.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                aJy[ParamType.KEEP_ALIVE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static Set<String> JA() {
        return aJv.keySet();
    }

    public static boolean Jk() {
        return aJx;
    }

    public static void Jl() {
        for (String str : aJv.keySet()) {
            if (aJv.get(str).get() instanceof ThreadPoolExecutor) {
                ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) aJv.get(str).get();
                int corePoolSize = threadPoolExecutor.getCorePoolSize();
                int maximumPoolSize = threadPoolExecutor.getMaximumPoolSize();
                TimeUnit timeUnit = TimeUnit.SECONDS;
                int keepAliveTime = (int) threadPoolExecutor.getKeepAliveTime(timeUnit);
                int a6 = a(str, ParamType.CORE, corePoolSize);
                int a7 = a(str, ParamType.MAX, maximumPoolSize);
                try {
                    threadPoolExecutor.setKeepAliveTime(a(str, ParamType.KEEP_ALIVE, keepAliveTime), timeUnit);
                } catch (IllegalArgumentException e6) {
                    e6.printStackTrace();
                }
                if (corePoolSize != a6 || maximumPoolSize != a7) {
                    if (corePoolSize <= a7) {
                        threadPoolExecutor.setMaximumPoolSize(a7);
                        threadPoolExecutor.setCorePoolSize(a6);
                    } else if (a6 <= maximumPoolSize) {
                        threadPoolExecutor.setCorePoolSize(a6);
                        threadPoolExecutor.setMaximumPoolSize(a7);
                    }
                }
            }
        }
    }

    public static ExecutorService Jn() {
        return a("backSingle", new j((byte) 0));
    }

    public static synchronized ExecutorService Jo() {
        ExecutorService a6;
        synchronized (GlobalThreadPools.class) {
            com.kwad.sdk.core.d.c.d(TAG, "forKsImageLoaderTask");
            a6 = a("ksImageLoaderTask", new g((byte) 0));
        }
        return a6;
    }

    public static synchronized ExecutorService Jp() {
        ExecutorService a6;
        synchronized (GlobalThreadPools.class) {
            com.kwad.sdk.core.d.c.d(TAG, "forKsImageLoaderCachedImages");
            a6 = a("ksImageLoaderTask", new g((byte) 0));
        }
        return a6;
    }

    public static ExecutorService Jq() {
        com.kwad.sdk.core.d.c.d(TAG, "forKsImageLoaderTaskDistributor");
        return a("imageLoaderDistributor", new e((byte) 0));
    }

    public static synchronized ExecutorService Jr() {
        synchronized (GlobalThreadPools.class) {
            com.kwad.sdk.core.d.c.d(TAG, "forBaseBatchReporter");
            if (Jk()) {
                return Jy();
            }
            return a("report", new i((byte) 0));
        }
    }

    public static synchronized ExecutorService Js() {
        synchronized (GlobalThreadPools.class) {
            com.kwad.sdk.core.d.c.d(TAG, "forAdReportManager");
            if (Jk()) {
                return Jy();
            }
            return a("report", new i((byte) 0));
        }
    }

    public static ExecutorService Jt() {
        com.kwad.sdk.core.d.c.d(TAG, "forBaseNetwork");
        return Jk() ? Jy() : a("httpIO", new b((byte) 0));
    }

    public static ExecutorService Ju() {
        com.kwad.sdk.core.d.c.d(TAG, "forCoreNetwork");
        return Jk() ? Jv() : Jt();
    }

    private static ExecutorService Jv() {
        com.kwad.sdk.core.d.c.d(TAG, "getCoreExecutor");
        ExecutorService a6 = a("httpIOForCoreV1", new c(0 == true ? 1 : 0));
        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) a6;
        int poolSize = threadPoolExecutor.getPoolSize();
        int a7 = a("httpIOForCoreV1", ParamType.CORE, 5);
        int a8 = a("httpIOForCoreExtraV1", ParamType.MAX, 3);
        ExecutorService a9 = a("httpIOForCoreExtraV1", new d(0 == true ? 1 : 0));
        ThreadPoolExecutor threadPoolExecutor2 = (ThreadPoolExecutor) a9;
        int poolSize2 = threadPoolExecutor2.getPoolSize();
        int activeCount = threadPoolExecutor.getActiveCount();
        int activeCount2 = threadPoolExecutor2.getActiveCount();
        com.kwad.sdk.core.d.c.d(TAG, "getCoreExecutor currentPoolSize:" + poolSize + " configSize:" + a7);
        com.kwad.sdk.core.d.c.d(TAG, "getCoreExecutor extraPoolSize:" + poolSize2 + " extraConfigSize:" + a8);
        int size = threadPoolExecutor.getQueue() == null ? 0 : threadPoolExecutor.getQueue().size();
        int size2 = threadPoolExecutor2.getQueue() != null ? threadPoolExecutor2.getQueue().size() : 0;
        com.kwad.sdk.core.d.c.e(TAG, "getCoreExecutor queueSize:" + size + " extraQueueSize:" + size2);
        if (poolSize < a7) {
            com.kwad.sdk.core.d.c.d(TAG, "getCoreExecutor currentPoolSize < configSize");
            return a6;
        }
        if (activeCount < a7) {
            com.kwad.sdk.core.d.c.e(TAG, "activeCount < configSize");
            return a6;
        }
        if (activeCount2 == a8) {
            com.kwad.sdk.core.d.c.e(TAG, "extraActiveCount == extraConfigSize");
            return a6;
        }
        com.kwad.sdk.core.d.c.e(TAG, "use extra");
        return a9;
    }

    public static ExecutorService Jw() {
        com.kwad.sdk.core.d.c.d(TAG, "forHttpCacheServer");
        return Jk() ? Jy() : a("videoCache", new k((byte) 0));
    }

    public static ExecutorService Jx() {
        com.kwad.sdk.core.d.c.d(TAG, "forAppStatusHelper");
        return Jk() ? Jy() : new com.kwad.sdk.core.threads.a.b(a("lruDiskCache", ParamType.CORE, 1), a("lruDiskCache", ParamType.MAX, 1), a("lruDiskCache", ParamType.KEEP_ALIVE, 0), TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactory() { // from class: com.kwad.sdk.core.threads.GlobalThreadPools.1
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable, "ksad-ashelper");
                thread.setPriority(3);
                return thread;
            }
        });
    }

    public static ExecutorService Jy() {
        com.kwad.sdk.core.d.c.d(TAG, "forAsync");
        return a("async", new a() { // from class: com.kwad.sdk.core.threads.GlobalThreadPools.2
            @Override // com.kwad.sdk.core.threads.GlobalThreadPools.a
            @NonNull
            public final ExecutorService JE() {
                f fVar = new f(5, "async");
                int i6 = GlobalThreadPools.Jk() ? 5 : 3;
                return new com.kwad.sdk.core.threads.a.b(GlobalThreadPools.a("async", ParamType.CORE, i6), GlobalThreadPools.a("async", ParamType.MAX, i6), GlobalThreadPools.a("async", ParamType.KEEP_ALIVE, 60), TimeUnit.SECONDS, new LinkedBlockingQueue(), fVar);
            }
        });
    }

    public static ScheduledExecutorService Jz() {
        com.kwad.sdk.core.d.c.d(TAG, "forAsyncSchedule");
        ExecutorService a6 = a("async-schedule", new a() { // from class: com.kwad.sdk.core.threads.GlobalThreadPools.3
            @Override // com.kwad.sdk.core.threads.GlobalThreadPools.a
            @NonNull
            public final ExecutorService JE() {
                return new com.kwad.sdk.core.threads.a.a(1, new f(5, "async-schedule"));
            }
        });
        return a6 instanceof ScheduledExecutorService ? (ScheduledExecutorService) a6 : new com.kwad.sdk.core.threads.a.a(1, new f(5, "async-schedule"));
    }

    public static ExecutorService eC(String str) {
        if (!aJv.containsKey(str) || aJv.get(str) == null) {
            return null;
        }
        return aJv.get(str).get();
    }

    public static void q(String str, int i6) {
        aJw.put(str, Integer.valueOf(i6));
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        aJs = availableProcessors;
        if (availableProcessors <= 0) {
            availableProcessors = 9;
        }
        aJt = availableProcessors;
        aJu = availableProcessors;
        TAG = "GlobalThreadPools";
        aJv = new ConcurrentHashMap();
        aJw = new ConcurrentHashMap();
        aJx = true;
    }

    public static ExecutorService Jm() {
        if (Jk()) {
            return Jy();
        }
        return a("lruDiskCache", new h((byte) 0));
    }

    @NonNull
    private static ExecutorService a(String str, @NonNull a aVar) {
        WeakReference<ExecutorService> weakReference = aJv.get(str);
        if (weakReference != null && weakReference.get() != null) {
            return weakReference.get();
        }
        ExecutorService JE = aVar.JE();
        aJv.put(str, new WeakReference<>(JE));
        return JE;
    }

    public static void Jj() {
    }
}
