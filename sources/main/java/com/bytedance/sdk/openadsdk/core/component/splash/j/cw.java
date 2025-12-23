package com.bytedance.sdk.openadsdk.core.component.splash.j;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.component.splash.cw.j.ae;
import com.bytedance.sdk.openadsdk.core.component.splash.cw.j.g;
import com.bytedance.sdk.openadsdk.core.rn.uf;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.tj.sm;
import com.bytedance.sdk.openadsdk.core.tj.tl;
import com.bytedance.sdk.openadsdk.core.up.r.up;
import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: D:\Downloads\app\classes4.dex */
public class cw extends j {
    private volatile up oq;

    /* renamed from: m, reason: collision with root package name */
    static ConcurrentHashMap<String, xt> f28688m = new ConcurrentHashMap<>();
    static ConcurrentHashMap<String, List<String>> ae = new ConcurrentHashMap<>();
    static ReferenceQueue<Object> tl = new ReferenceQueue<>();

    /* renamed from: g, reason: collision with root package name */
    static Map<Object, xt> f28687g = new ConcurrentHashMap();

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.j.j
    public void xt() {
        if (this.oq == null) {
            synchronized (this) {
                try {
                    if (this.oq == null) {
                        r();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.j.j
    public void cw() {
        if (this.oq == null) {
            xt();
        }
        if (this.oq != null) {
            this.oq.j();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.j.j
    public void j(final sm smVar, com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar, boolean z5) {
        if (xtVar == null || smVar == null || smVar.j() == null) {
            return;
        }
        if (this.oq == null) {
            xt();
        }
        try {
            final String r5 = xtVar.r();
            com.bytedance.sdk.openadsdk.core.ae.j.j("lqmt", "saveCache start >>  rit: " + r5 + "  isUsing: " + z5);
            final n j6 = smVar.j();
            String ej = j6.ej();
            String xt = xt(r5, ej);
            if (f28688m.contains(xt)) {
                return;
            }
            com.bytedance.sdk.openadsdk.core.ae.j.j("lqmt", "save-updateMemoryRecord start >>  rit: " + r5 + "  reqId: " + ej);
            j(xt, r5, ej, z5 ? 2 : 1);
            j(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.j.cw.1
                @Override // java.lang.Runnable
                public void run() {
                    long currentTimeMillis = System.currentTimeMillis();
                    cw.this.oq.j(r5, new up.xt(com.bytedance.sdk.component.utils.j.xt(smVar.xt().cw().toString()), j6.id(), 1000 * j6.xj(), j6.ej()), false, uf.az(j6));
                    com.bytedance.sdk.openadsdk.core.ae.j.j("lqmt", "saveMeta >>  rit: " + r5 + " saveDb cost: " + (System.currentTimeMillis() - currentTimeMillis));
                }
            });
        } catch (Throwable unused) {
        }
    }

    private static int m() {
        if (tl.cw() == null) {
            return 1;
        }
        return tl.cw().r();
    }

    private void r() {
        long currentTimeMillis = System.currentTimeMillis();
        this.oq = new up(3);
        com.bytedance.sdk.openadsdk.core.ae.j.j("lqmt", "NewCache 初始化耗时: " + (System.currentTimeMillis() - currentTimeMillis));
    }

    private void up() {
        if (m() == 3) {
            try {
                for (Reference<? extends Object> poll = tl.poll(); poll != null; poll = tl.poll()) {
                    xt xtVar = f28687g.get(poll);
                    if (xtVar != null) {
                        j(xtVar.cw, xtVar.f28704j);
                    }
                    f28687g.remove(poll);
                }
            } catch (Exception unused) {
            }
        }
    }

    private String xt(String str, String str2) {
        return str + str2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
    @Override // com.bytedance.sdk.openadsdk.core.component.splash.j.j
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void j(com.bytedance.sdk.openadsdk.core.component.splash.cw.j.ae r11, final java.lang.String r12, com.bytedance.sdk.openadsdk.core.component.splash.j.j.InterfaceC0450j r13) {
        /*
            Method dump skipped, instructions count: 321
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.component.splash.j.cw.j(com.bytedance.sdk.openadsdk.core.component.splash.cw.j.ae, java.lang.String, com.bytedance.sdk.openadsdk.core.component.splash.j.j$j):void");
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.j.j
    public void j(com.bytedance.sdk.openadsdk.core.component.splash.cw.cw.r<g, ae> rVar, final n nVar, com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar, boolean z5) {
        final String r5;
        String ej;
        String xt;
        if (nVar == null || xtVar == null) {
            return;
        }
        if (this.oq == null) {
            xt();
        }
        try {
            com.bytedance.sdk.openadsdk.core.ae.j.j("lqmt", "removeCache>> start ");
            r5 = xtVar.r();
            ej = nVar.ej();
            xt = xt(r5, ej);
        } catch (Throwable unused) {
        }
        if (this.up.get()) {
            com.bytedance.sdk.openadsdk.core.ae.j.j("lqmt", "removeCache-mIsRemoveCacheAd: true");
            return;
        }
        this.up.set(true);
        j(xt, r5, ej, 3);
        com.bytedance.sdk.openadsdk.core.ae.j.j("lqmt", "removeCache-updateMemoryRecord: 完成");
        j(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.j.cw.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    cw.this.oq.j(r5, nVar.ej());
                    com.bytedance.sdk.openadsdk.core.ae.j.j("lqmt", "removeCache-deleteCacheMeta  rit: " + r5 + "  cost: " + (System.currentTimeMillis() - currentTimeMillis));
                } catch (Throwable unused2) {
                }
            }
        });
        if (rVar != null) {
            rVar.j();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.j.j
    public void j(String str, String str2, boolean z5, boolean z6, Object obj) {
        if (m() != 3 || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            return;
        }
        if (!z6 && z5) {
            j(obj, str, str2);
        } else {
            j(str, str2);
        }
    }

    private void j(final Runnable runnable) {
        if (com.bytedance.sdk.openadsdk.l.ae.j()) {
            com.bytedance.sdk.component.oq.ae.xt(new com.bytedance.sdk.component.oq.g("") { // from class: com.bytedance.sdk.openadsdk.core.component.splash.j.cw.4
                @Override // java.lang.Runnable
                public void run() {
                    runnable.run();
                }
            });
        } else {
            runnable.run();
        }
    }

    private List<String> j(String str) {
        List<String> list = ae.get(str);
        StringBuilder sb = new StringBuilder("getUsedReqIdList: list : ");
        sb.append(list == null ? 0 : list.size());
        com.bytedance.sdk.openadsdk.core.ae.j.j("lqmt", sb.toString());
        return list;
    }

    private void j(String str, String str2, String str3, int i6) {
        int m6 = m();
        com.bytedance.sdk.openadsdk.core.ae.j.j("lqmt", "updateMemoryRecord>> start rit: " + str2 + ", status: " + i6 + ", cacheStrategyType: " + m6);
        if (m6 != 3) {
            return;
        }
        f28688m.put(str, new xt(str3, i6, str2));
        if (i6 <= 1) {
            com.bytedance.sdk.openadsdk.core.ae.j.j("lqmt", "updateMemoryRecord>> :status <= CACHE_STATUS_NOUSE");
            return;
        }
        List<String> list = ae.get(str2);
        StringBuilder sb = new StringBuilder("updateMemoryRecord>>: list1 : ");
        sb.append(list == null ? 0 : list.size());
        com.bytedance.sdk.openadsdk.core.ae.j.j("lqmt", sb.toString());
        if (list == null) {
            list = new CopyOnWriteArrayList<>();
            list.add(str3);
        } else if (list.contains(str3)) {
            return;
        } else {
            list.add(str3);
        }
        com.bytedance.sdk.openadsdk.core.ae.j.j("lqmt", "updateMemoryRecord>>: list2 : " + list.size());
        ae.put(str2, list);
    }

    private void j(Object obj, String str, String str2) {
        try {
            xt xtVar = f28688m.get(xt(str, str2));
            if (xtVar != null && obj != null) {
                PhantomReference phantomReference = new PhantomReference(obj, tl);
                com.bytedance.sdk.openadsdk.core.ae.j.j("lqmt", xtVar.cw + "，uuid：" + xtVar.f28704j + " watching");
                f28687g.put(phantomReference, xtVar);
            }
        } catch (Exception unused) {
        }
    }

    private void j(String str, String str2) {
        f28688m.remove(xt(str, str2));
        List<String> list = ae.get(str);
        StringBuilder sb = new StringBuilder("checkCaches>>: list1 : ");
        sb.append(list == null ? 0 : list.size());
        com.bytedance.sdk.openadsdk.core.ae.j.j("lqmt", sb.toString());
        if (list == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.ae.j.j("lqmt", "checkCaches>>: rmCache : " + str2);
        list.remove(str2);
        ae.put(str, list);
    }
}
