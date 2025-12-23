package com.bytedance.sdk.openadsdk.core.playable;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.LruCache;
import com.bytedance.sdk.component.oq.ae;
import com.bytedance.sdk.component.oq.g;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.v;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt {

    /* renamed from: j, reason: collision with root package name */
    private static volatile xt f29861j;
    private final long cw;

    /* renamed from: r, reason: collision with root package name */
    private int f29864r;
    private LruCache<String, com.bytedance.sdk.openadsdk.core.playable.j.j> xt;
    private CopyOnWriteArrayList<String> up = new CopyOnWriteArrayList<>();

    /* renamed from: m, reason: collision with root package name */
    private CopyOnWriteArrayList<String> f29863m = new CopyOnWriteArrayList<>();
    private ConcurrentHashMap<String, WeakReference<com.bytedance.sdk.openadsdk.core.w.cw>> ae = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, Long> tl = new ConcurrentHashMap<>();

    /* renamed from: g, reason: collision with root package name */
    private final Object f29862g = new Object();

    static /* synthetic */ void j(xt xtVar, String str) {
    }

    private void r(final n nVar) {
        if (TextUtils.isEmpty(nVar.of())) {
            return;
        }
        final String of = nVar.of();
        if (this.up.contains(of) || this.f29863m.contains(of) || this.xt.get(of) != null) {
            return;
        }
        this.up.add(of);
        this.tl.put(of, Long.valueOf(System.currentTimeMillis()));
        ae.xt(new g("playable_prefetch") { // from class: com.bytedance.sdk.openadsdk.core.playable.xt.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    xt.this.j(nVar, of);
                } catch (Throwable unused) {
                }
            }
        });
    }

    public long cw(n nVar) {
        try {
            if (this.tl == null || nVar == null || TextUtils.isEmpty(nVar.of())) {
                return 0L;
            }
            return this.tl.get(nVar.of()).longValue();
        } catch (Exception unused) {
            return 0L;
        }
    }

    public void xt(n nVar) {
        if (nVar != null) {
            try {
                if (TextUtils.isEmpty(nVar.of())) {
                    return;
                }
                String of = nVar.of();
                this.f29863m.add(of);
                this.xt.remove(of);
                this.up.remove(of);
                this.ae.remove(of);
                this.tl.remove(of);
                this.xt.size();
                this.up.size();
                this.f29863m.size();
            } catch (Exception unused) {
            }
        }
    }

    private xt() {
        int hw = v.xt().hw();
        this.f29864r = hw;
        if (hw > 30) {
            this.f29864r = 30;
        } else if (hw < 0) {
            this.f29864r = 5;
        }
        this.cw = v.xt().ja() * 1000;
        this.xt = new LruCache<String, com.bytedance.sdk.openadsdk.core.playable.j.j>(this.f29864r) { // from class: com.bytedance.sdk.openadsdk.core.playable.xt.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.util.LruCache
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public int sizeOf(String str, com.bytedance.sdk.openadsdk.core.playable.j.j jVar) {
                return 1;
            }
        };
    }

    public static xt j() {
        if (f29861j == null) {
            synchronized (xt.class) {
                try {
                    if (f29861j == null) {
                        f29861j = new xt();
                    }
                } finally {
                }
            }
        }
        return f29861j;
    }

    public void j(n nVar) {
        if (nVar != null) {
            try {
                if (nVar.oz() == 3) {
                    r(nVar);
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(n nVar, final String str) {
        com.bytedance.sdk.openadsdk.core.v.xt.j(nVar, nVar == null ? null : nVar.ag(), new com.bytedance.sdk.openadsdk.core.w.cw() { // from class: com.bytedance.sdk.openadsdk.core.playable.xt.3
            @Override // com.bytedance.sdk.openadsdk.core.w.cw
            public void j(boolean z5, List<n> list, boolean z6) {
                try {
                    if (xt.this.f29863m != null && xt.this.f29863m.contains(str)) {
                        xt.j(xt.this, "prefetchCache-onAdLoaded.. discardTask. key: " + str);
                        return;
                    }
                    xt.j(xt.this, "prefetchCache-onAdLoaded.. success: ".concat(String.valueOf(z5)));
                    synchronized (xt.this.f29862g) {
                        if (z5 && list != null) {
                            try {
                                if (list.size() > 0) {
                                    com.bytedance.sdk.openadsdk.core.playable.j.j jVar = new com.bytedance.sdk.openadsdk.core.playable.j.j();
                                    jVar.f29860j = list;
                                    jVar.xt = z5;
                                    jVar.cw = SystemClock.elapsedRealtime();
                                    xt.this.xt.put(str, jVar);
                                    xt.j(xt.this, "prefetchCache-onAdLoaded.. 缓存save  key: " + str);
                                }
                            } finally {
                            }
                        }
                        xt.this.up.remove(str);
                    }
                    WeakReference weakReference = (WeakReference) xt.this.ae.get(str);
                    com.bytedance.sdk.openadsdk.core.w.cw cwVar = weakReference == null ? null : (com.bytedance.sdk.openadsdk.core.w.cw) weakReference.get();
                    if (cwVar != null) {
                        cwVar.j(z5, list, true);
                        xt.this.ae.remove(str);
                        xt.j(xt.this, "prefetchCache-onAdLoaded..callback invoke key: " + str);
                    }
                } catch (Exception unused) {
                }
            }
        }, (com.bytedance.sdk.openadsdk.i.cw.cw.xt) null);
    }

    public boolean j(n nVar, com.bytedance.sdk.openadsdk.core.w.cw cwVar) {
        if (nVar != null && !TextUtils.isEmpty(nVar.of())) {
            String of = nVar.of();
            try {
                synchronized (this.f29862g) {
                    try {
                        if (this.up.contains(of)) {
                            this.ae.put(of, new WeakReference<>(cwVar));
                            return true;
                        }
                        com.bytedance.sdk.openadsdk.core.playable.j.j jVar = this.xt.get(of);
                        if (jVar == null) {
                            return false;
                        }
                        if (j(jVar)) {
                            xt(nVar);
                            return false;
                        }
                        if (cwVar != null) {
                            cwVar.j(jVar.xt, jVar.f29860j, true);
                            return true;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            } catch (Exception unused) {
            }
        }
        return false;
    }

    private boolean j(com.bytedance.sdk.openadsdk.core.playable.j.j jVar) {
        return this.cw > 0 && jVar != null && SystemClock.elapsedRealtime() - jVar.cw > this.cw;
    }
}
