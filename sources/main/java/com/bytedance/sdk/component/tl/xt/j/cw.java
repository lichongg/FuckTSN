package com.bytedance.sdk.component.tl.xt.j;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: D:\Downloads\app\classes4.dex */
public class cw implements up {
    private final Queue<String> cw;

    /* renamed from: j, reason: collision with root package name */
    private final up f26763j;

    /* renamed from: r, reason: collision with root package name */
    private com.bytedance.sdk.component.tl.j.up f26764r;
    private com.bytedance.sdk.component.tl.xt.xt.cw.cw up;
    private final r xt;

    @Override // com.bytedance.sdk.component.tl.xt.j.up
    public List<com.bytedance.sdk.component.tl.j.xt> j(int i6, com.bytedance.sdk.component.tl.j.xt xtVar, boolean z5, List<String> list) {
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x001b A[Catch: all -> 0x0012, TRY_LEAVE, TryCatch #0 {all -> 0x0012, blocks: (B:3:0x0001, B:5:0x0009, B:9:0x001b, B:14:0x0014), top: B:2:0x0001 }] */
    @Override // com.bytedance.sdk.component.tl.xt.j.up
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void j(com.bytedance.sdk.component.tl.j.xt r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            com.bytedance.sdk.component.tl.j.up r0 = r1.f26764r     // Catch: java.lang.Throwable -> L12
            boolean r0 = com.bytedance.sdk.component.tl.xt.cw.j.g(r2, r0)     // Catch: java.lang.Throwable -> L12
            if (r0 == 0) goto L14
            com.bytedance.sdk.component.tl.xt.xt.cw.cw r0 = r1.up     // Catch: java.lang.Throwable -> L12
            boolean r0 = r0.r()     // Catch: java.lang.Throwable -> L12
            if (r0 != 0) goto L19
            goto L14
        L12:
            r2 = move-exception
            goto L22
        L14:
            com.bytedance.sdk.component.tl.xt.j.up r0 = r1.f26763j     // Catch: java.lang.Throwable -> L12
            r0.j(r2)     // Catch: java.lang.Throwable -> L12
        L19:
            if (r2 == 0) goto L20
            com.bytedance.sdk.component.tl.xt.j.r r0 = r1.xt     // Catch: java.lang.Throwable -> L12
            r0.j(r2)     // Catch: java.lang.Throwable -> L12
        L20:
            monitor-exit(r1)
            return
        L22:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L12
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.tl.xt.j.cw.j(com.bytedance.sdk.component.tl.j.xt):void");
    }

    public cw(com.bytedance.sdk.component.tl.j.up upVar, com.bytedance.sdk.component.tl.xt.xt.cw.cw cwVar) {
        ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();
        this.cw = concurrentLinkedQueue;
        this.f26764r = upVar;
        this.up = cwVar;
        this.f26763j = new m(concurrentLinkedQueue, upVar);
        this.xt = new r(this.f26764r);
    }

    @Override // com.bytedance.sdk.component.tl.xt.j.up
    public synchronized xt j(int i6, List<com.bytedance.sdk.component.tl.j.xt> list, int i7) {
        xt xtVar;
        try {
            Iterator<com.bytedance.sdk.component.tl.j.xt> it = list.iterator();
            while (it.hasNext()) {
                this.cw.remove(it.next().cw());
            }
        } finally {
            this.f26763j.j(i6, list, i7);
            xtVar = this.xt.j(i6, list, i7);
            return xtVar;
        }
        try {
            this.f26763j.j(i6, list, i7);
        } catch (Throwable th) {
            xt xtVar2 = new xt();
            xtVar2.j(false);
            xtVar2.j("mem exception:" + th.getMessage());
            com.bytedance.sdk.component.tl.xt.cw.cw.cw(th.getMessage(), this.f26764r);
        }
        try {
            xtVar = this.xt.j(i6, list, i7);
        } catch (Exception e6) {
            xt xtVar3 = new xt();
            xtVar3.j(false);
            xtVar3.j("db exception:" + e6.getMessage());
            com.bytedance.sdk.component.tl.xt.cw.cw.cw(e6.getMessage(), this.f26764r);
            xtVar = xtVar3;
        }
        return xtVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.sdk.component.tl.xt.j.up
    public synchronized List<com.bytedance.sdk.component.tl.j.xt> j(int i6, com.bytedance.sdk.component.tl.j.xt xtVar, boolean z5, String str) {
        List<com.bytedance.sdk.component.tl.j.xt> list;
        try {
            List<com.bytedance.sdk.component.tl.j.xt> j6 = this.f26763j.j(i6, xtVar, z5, (List<String>) null);
            if (j6 != 0 && j6.size() != 0) {
                int size = j6.size();
                list = j6;
                if (com.bytedance.sdk.component.tl.xt.cw.j.j(i6)) {
                    List<com.bytedance.sdk.component.tl.j.xt> j7 = this.xt.j((com.bytedance.sdk.component.tl.j.xt) j6.get(0), size, i6, z5);
                    list = j6;
                    if (j7 != null) {
                        list = j6;
                        if (j7.size() != 0) {
                            j7.size();
                            HashMap hashMap = new HashMap();
                            for (com.bytedance.sdk.component.tl.j.xt xtVar2 : j7) {
                                hashMap.put(xtVar2.cw(), xtVar2);
                            }
                            ArrayList arrayList = new ArrayList(this.cw);
                            arrayList.size();
                            for (com.bytedance.sdk.component.tl.j.xt xtVar3 : j7) {
                                Iterator it = arrayList.iterator();
                                while (true) {
                                    if (it.hasNext()) {
                                        if (TextUtils.equals(xtVar3.cw(), (String) it.next())) {
                                            hashMap.remove(xtVar3.cw());
                                            break;
                                        }
                                    }
                                }
                            }
                            for (com.bytedance.sdk.component.tl.j.xt xtVar4 : j6) {
                                hashMap.put(xtVar4.cw(), xtVar4);
                            }
                            j6.clear();
                            Set keySet = hashMap.keySet();
                            hashMap.size();
                            Iterator it2 = keySet.iterator();
                            while (it2.hasNext()) {
                                j6.add(hashMap.get((String) it2.next()));
                            }
                            j7.clear();
                            list = j6;
                        }
                    }
                }
            } else {
                ArrayList<String> arrayList2 = new ArrayList(this.cw);
                int size2 = arrayList2.size();
                List<com.bytedance.sdk.component.tl.j.xt> j8 = this.xt.j(i6, xtVar, z5, arrayList2);
                if (j8 != 0 && j8.size() != 0) {
                    j8.size();
                    HashMap hashMap2 = new HashMap();
                    for (com.bytedance.sdk.component.tl.j.xt xtVar5 : j8) {
                        hashMap2.put(xtVar5.cw(), xtVar5);
                    }
                    if (size2 != 0) {
                        for (String str2 : arrayList2) {
                            if (hashMap2.get(str2) != null) {
                                hashMap2.remove(str2);
                            }
                        }
                    }
                    j8.clear();
                    Set keySet2 = hashMap2.keySet();
                    hashMap2.size();
                    Iterator it3 = keySet2.iterator();
                    while (it3.hasNext()) {
                        j8.add(hashMap2.get((String) it3.next()));
                    }
                }
                list = j8;
            }
            if (list != null && !list.isEmpty()) {
                list.size();
                Iterator<com.bytedance.sdk.component.tl.j.xt> it4 = list.iterator();
                while (it4.hasNext()) {
                    this.cw.offer(it4.next().cw());
                }
                return list;
            }
            return new ArrayList();
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.bytedance.sdk.component.tl.xt.j.up
    public synchronized boolean j(int i6, String str, com.bytedance.sdk.component.tl.j.xt xtVar) {
        if (this.f26763j.j(i6, str, xtVar)) {
            com.bytedance.sdk.component.tl.xt.cw.cw.xt("_opt", "cacheManager check result : memory meet ".concat(String.valueOf(str)), this.f26764r);
            return true;
        }
        if (!com.bytedance.sdk.component.tl.xt.cw.j.j(i6) || !this.xt.j(i6, str, xtVar)) {
            return false;
        }
        com.bytedance.sdk.component.tl.xt.cw.cw.xt("_opt", "cacheManager check result : db meet ".concat(String.valueOf(str)), this.f26764r);
        return true;
    }
}
