package com.bykv.vk.openvk.component.video.j.xt;

import android.os.Process;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bykv.vk.openvk.component.video.j.xt.g;
import com.bykv.vk.openvk.component.video.j.xt.xt;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\Downloads\app\classes3.dex */
public class r {
    private static volatile r up;
    private volatile com.bykv.vk.openvk.component.video.j.xt.j.cw ae;
    private final xt<Runnable> cw;

    /* renamed from: g, reason: collision with root package name */
    private final HashSet<j> f23087g;

    /* renamed from: j, reason: collision with root package name */
    private volatile int f23088j = 163840;
    private volatile String jy;

    /* renamed from: m, reason: collision with root package name */
    private volatile com.bykv.vk.openvk.component.video.j.xt.xt.cw f23089m;
    private final xt.InterfaceC0313xt oq;
    private volatile cw qv;

    /* renamed from: r, reason: collision with root package name */
    private final ExecutorService f23090r;
    private volatile com.bykv.vk.openvk.component.video.j.xt.j.xt tl;
    private volatile cw vl;
    private volatile boolean ws;
    private final SparseArray<Map<String, com.bykv.vk.openvk.component.video.j.xt.xt>> xt;

    private static final class j {
        final int cw;

        /* renamed from: j, reason: collision with root package name */
        final boolean f23097j;

        /* renamed from: m, reason: collision with root package name */
        final String[] f23098m;

        /* renamed from: r, reason: collision with root package name */
        final String f23099r;
        final Map<String, String> up;
        final boolean xt;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || j.class != obj.getClass()) {
                return false;
            }
            j jVar = (j) obj;
            if (this.f23097j == jVar.f23097j && this.xt == jVar.xt && this.cw == jVar.cw) {
                return this.f23099r.equals(jVar.f23099r);
            }
            return false;
        }

        public int hashCode() {
            return ((((((this.f23097j ? 1 : 0) * 31) + (this.xt ? 1 : 0)) * 31) + this.cw) * 31) + this.f23099r.hashCode();
        }

        j(boolean z5, boolean z6, int i6, String str, Map<String, String> map, String[] strArr) {
            this.f23097j = z5;
            this.xt = z6;
            this.cw = i6;
            this.f23099r = str;
            this.up = map;
            this.f23098m = strArr;
        }
    }

    private static final class xt<T> extends LinkedBlockingDeque<T> {

        /* renamed from: j, reason: collision with root package name */
        private ThreadPoolExecutor f23100j;

        private xt() {
        }

        public void j(ThreadPoolExecutor threadPoolExecutor) {
            synchronized (this) {
                try {
                    if (this.f23100j != null) {
                        throw new IllegalStateException("You can only call setExecutor() once!");
                    }
                    if (threadPoolExecutor == null) {
                        throw new NullPointerException("executor argument can't be null!");
                    }
                    this.f23100j = threadPoolExecutor;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // java.util.concurrent.LinkedBlockingDeque, java.util.Queue, java.util.concurrent.BlockingDeque, java.util.concurrent.BlockingQueue, java.util.Deque
        public boolean offer(T t5) {
            synchronized (this) {
                try {
                    int poolSize = this.f23100j.getPoolSize();
                    int activeCount = this.f23100j.getActiveCount();
                    int maximumPoolSize = this.f23100j.getMaximumPoolSize();
                    if (activeCount < poolSize || poolSize >= maximumPoolSize) {
                        return offerFirst(t5);
                    }
                    if (up.cw) {
                        com.bytedance.sdk.component.utils.vl.j("TAG_PROXY_TT", "create new preloader thread");
                    }
                    return false;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public static r cw() {
        if (up == null) {
            synchronized (r.class) {
                try {
                    if (up == null) {
                        up = new r();
                    }
                } finally {
                }
            }
        }
        return up;
    }

    void j(com.bykv.vk.openvk.component.video.j.xt.j.cw cwVar) {
        this.ae = cwVar;
    }

    public void r() {
        com.bykv.vk.openvk.component.video.j.cw.j.j(new com.bytedance.sdk.component.oq.g("cancelAll") { // from class: com.bykv.vk.openvk.component.video.j.xt.r.3
            @Override // java.lang.Runnable
            public void run() {
                ArrayList<com.bykv.vk.openvk.component.video.j.xt.xt> arrayList = new ArrayList();
                synchronized (r.this.xt) {
                    try {
                        int size = r.this.xt.size();
                        for (int i6 = 0; i6 < size; i6++) {
                            Map map = (Map) r.this.xt.get(r.this.xt.keyAt(i6));
                            if (map != null) {
                                arrayList.addAll(map.values());
                                map.clear();
                            }
                        }
                        r.this.cw.clear();
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                for (com.bykv.vk.openvk.component.video.j.xt.xt xtVar : arrayList) {
                    xtVar.j();
                    if (up.cw) {
                        com.bytedance.sdk.component.utils.vl.xt("TAG_PROXY_Preloader", "PreloadTask: " + xtVar + ", canceled!!!");
                    }
                }
            }
        });
    }

    cw xt() {
        return this.vl;
    }

    private r() {
        SparseArray<Map<String, com.bykv.vk.openvk.component.video.j.xt.xt>> sparseArray = new SparseArray<>(2);
        this.xt = sparseArray;
        this.f23087g = new HashSet<>();
        this.oq = new xt.InterfaceC0313xt() { // from class: com.bykv.vk.openvk.component.video.j.xt.r.1
            @Override // com.bykv.vk.openvk.component.video.j.xt.xt.InterfaceC0313xt
            public void j(com.bykv.vk.openvk.component.video.j.xt.xt xtVar) {
                int m6 = xtVar.m();
                synchronized (r.this.xt) {
                    try {
                        Map map = (Map) r.this.xt.get(m6);
                        if (map != null) {
                            map.remove(xtVar.tl);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                boolean z5 = up.cw;
            }
        };
        xt<Runnable> xtVar = new xt<>();
        this.cw = xtVar;
        ExecutorService j6 = j(xtVar);
        this.f23090r = j6;
        xtVar.j((ThreadPoolExecutor) j6);
        sparseArray.put(0, new HashMap());
        sparseArray.put(1, new HashMap());
    }

    void j(com.bykv.vk.openvk.component.video.j.xt.xt.cw cwVar) {
        this.f23089m = cwVar;
    }

    public void j(int i6) {
        if (i6 > 0) {
            this.f23088j = i6;
        }
        if (up.cw) {
            com.bytedance.sdk.component.utils.vl.j("TAG_PROXY_Preloader", "MaxPreloadSize: ".concat(String.valueOf(i6)));
        }
    }

    cw j() {
        return this.qv;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:37:0x007c
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1179)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    void j(boolean r9, java.lang.String r10) {
        /*
            Method dump skipped, instructions count: 331
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.openvk.component.video.j.xt.r.j(boolean, java.lang.String):void");
    }

    public void j(boolean z5, boolean z6, int i6, String str, String... strArr) {
        j(z5, z6, i6, str, null, strArr);
    }

    public void j(boolean z5, boolean z6, int i6, String str, Map<String, String> map, String... strArr) {
        ArrayList arrayList;
        boolean z7 = up.cw;
        com.bykv.vk.openvk.component.video.j.xt.j.j jVar = z5 ? this.tl : this.ae;
        com.bykv.vk.openvk.component.video.j.xt.xt.cw cwVar = this.f23089m;
        if (jVar == null || cwVar == null) {
            if (z7) {
                com.bytedance.sdk.component.utils.vl.r("TAG_PROXY_Preloader", "cache or videoProxyDB null in Preloader!!!");
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(str) || strArr == null || strArr.length <= 0) {
            return;
        }
        int i7 = i6 <= 0 ? this.f23088j : i6;
        String j6 = z6 ? str : com.bykv.vk.openvk.component.video.api.m.xt.j(str);
        File r5 = jVar.r(j6);
        if (r5 != null && r5.length() >= i7) {
            if (z7) {
                com.bytedance.sdk.component.utils.vl.j("TAG_PROXY_Preloader", "no need preload, file size: " + r5.length() + ", need preload size: " + i7);
                return;
            }
            return;
        }
        if (m.j().j(com.bykv.vk.openvk.component.video.j.xt.xt.xt.j(z5), j6)) {
            if (z7) {
                com.bytedance.sdk.component.utils.vl.xt("TAG_PROXY_Preloader", "has running proxy task, skip preload for key: ".concat(String.valueOf(str)));
                return;
            }
            return;
        }
        synchronized (this.xt) {
            try {
                Map<String, com.bykv.vk.openvk.component.video.j.xt.xt> map2 = this.xt.get(z5 ? 1 : 0);
                if (map2.containsKey(j6)) {
                    return;
                }
                j jVar2 = new j(z5, z6, i7, str, map, strArr);
                String str2 = this.jy;
                if (str2 != null) {
                    int i8 = up.tl;
                    if (i8 == 3) {
                        synchronized (this.f23087g) {
                            this.f23087g.add(jVar2);
                        }
                        if (z7) {
                            com.bytedance.sdk.component.utils.vl.xt("TAG_PROXY_Preloader", "cancel preload: " + str + ", add to pending queue");
                        }
                        return;
                    }
                    if (i8 == 2) {
                        if (z7) {
                            com.bytedance.sdk.component.utils.vl.xt("TAG_PROXY_Preloader", "cancel preload: ".concat(String.valueOf(str)));
                        }
                        return;
                    } else if (i8 == 1 && this.ws == z5 && str2.equals(j6)) {
                        if (z7) {
                            com.bytedance.sdk.component.utils.vl.xt("TAG_PROXY_Preloader", "cancel preload: " + str + ", it is playing");
                        }
                        return;
                    }
                }
                List<g.xt> j7 = com.bykv.vk.openvk.component.video.j.cw.j.j(com.bykv.vk.openvk.component.video.j.cw.j.j(map));
                if (j7 != null) {
                    arrayList = new ArrayList(j7.size());
                    int size = j7.size();
                    for (int i9 = 0; i9 < size; i9++) {
                        g.xt xtVar = j7.get(i9);
                        if (xtVar != null) {
                            arrayList.add(new g.xt(xtVar.f23051j, xtVar.xt));
                        }
                    }
                } else {
                    arrayList = null;
                }
                com.bykv.vk.openvk.component.video.j.xt.xt j8 = new xt.j().j(jVar).j(cwVar).j(str).xt(j6).j(new vl(com.bykv.vk.openvk.component.video.j.cw.j.j(strArr))).j((List<g.xt>) arrayList).j(i7).j(this.oq).j(jVar2).j();
                map2.put(j6, j8);
                this.f23090r.execute(j8);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void j(String str) {
        j(false, false, str);
    }

    public void j(final boolean z5, final boolean z6, final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.bykv.vk.openvk.component.video.j.cw.j.j(new com.bytedance.sdk.component.oq.g("cancel b b S") { // from class: com.bykv.vk.openvk.component.video.j.xt.r.2
            @Override // java.lang.Runnable
            public void run() {
                com.bykv.vk.openvk.component.video.j.xt.xt xtVar;
                synchronized (r.this.xt) {
                    try {
                        Map map = (Map) r.this.xt.get(com.bykv.vk.openvk.component.video.j.xt.xt.xt.j(z5));
                        if (map != null) {
                            xtVar = (com.bykv.vk.openvk.component.video.j.xt.xt) map.remove(z6 ? str : com.bykv.vk.openvk.component.video.api.m.xt.j(str));
                        } else {
                            xtVar = null;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (xtVar != null) {
                    xtVar.j();
                }
            }
        });
    }

    private static ExecutorService j(final xt<Runnable> xtVar) {
        int j6 = com.bykv.vk.openvk.component.video.j.cw.j.j();
        return new com.bytedance.sdk.component.oq.r.r(0, j6 <= 0 ? 1 : j6 > 4 ? 4 : j6, 60L, TimeUnit.SECONDS, xtVar, new ThreadFactory() { // from class: com.bykv.vk.openvk.component.video.j.xt.r.4
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                com.bytedance.sdk.component.oq.r.cw cwVar = new com.bytedance.sdk.component.oq.r.cw(runnable) { // from class: com.bykv.vk.openvk.component.video.j.xt.r.4.1
                    @Override // java.lang.Thread, java.lang.Runnable
                    public void run() {
                        try {
                            Process.setThreadPriority(10);
                        } catch (Throwable th) {
                            com.bytedance.sdk.component.utils.vl.j(th);
                        }
                        super.run();
                    }
                };
                cwVar.setName("csj_video_preload_" + cwVar.getId());
                cwVar.setDaemon(true);
                if (up.cw) {
                    com.bytedance.sdk.component.utils.vl.j("TAG_PROXY_Preloader", "new preload thead: " + cwVar.getName());
                }
                return cwVar;
            }
        }, new RejectedExecutionHandler() { // from class: com.bykv.vk.openvk.component.video.j.xt.r.5
            @Override // java.util.concurrent.RejectedExecutionHandler
            public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
                try {
                    xt.this.offerFirst(runnable);
                    if (up.cw) {
                        com.bytedance.sdk.component.utils.vl.j("TAG_PROXY_TT", "task rejected in preloader, put first!!!");
                    }
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.vl.j(th);
                }
            }
        });
    }
}
