package com.bytedance.sdk.component.tl.xt.j.xt;

import com.bytedance.sdk.component.tl.j.xt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class j<T extends com.bytedance.sdk.component.tl.j.xt> extends com.bytedance.sdk.component.tl.xt.j.j {
    public com.bytedance.sdk.component.tl.j.up cw;

    /* renamed from: j, reason: collision with root package name */
    public com.bytedance.sdk.component.tl.xt.r.xt.j f26783j;

    /* renamed from: r, reason: collision with root package name */
    private Queue<T> f26784r = new ConcurrentLinkedQueue();
    private Queue<String> up;
    public String xt;

    public com.bytedance.sdk.component.tl.xt.j.xt j(int i6, List<T> list, int i7) {
        com.bytedance.sdk.component.tl.xt.j.xt xtVar = new com.bytedance.sdk.component.tl.xt.j.xt();
        if (list == null || list.size() == 0 || list.get(0) == null || !j(list.get(0))) {
            xtVar.j(false);
            return xtVar;
        }
        xt(i6, list, i7);
        xtVar.j(true);
        return xtVar;
    }

    public void xt(T t5) {
        if (this.f26784r == null || t5 == null || !j(t5)) {
            return;
        }
        this.f26784r.offer(t5);
    }

    public j(com.bytedance.sdk.component.tl.xt.r.xt.j jVar, Queue<String> queue, String str, com.bytedance.sdk.component.tl.j.up upVar) {
        this.f26783j = jVar;
        this.up = queue;
        this.cw = upVar;
        this.xt = str;
    }

    @Override // com.bytedance.sdk.component.tl.xt.j.j
    public List<com.bytedance.sdk.component.tl.j.xt> xt(int i6, com.bytedance.sdk.component.tl.j.xt xtVar, boolean z5, List<String> list, String str) {
        ArrayList arrayList = new ArrayList();
        this.f26784r.size();
        do {
            T poll = this.f26784r.poll();
            if (poll == null) {
                break;
            }
            arrayList.add(poll);
        } while (arrayList.size() != this.f26783j.xt());
        return arrayList;
    }

    private void xt(int i6, List<T> list, int i7) {
        com.bytedance.sdk.component.tl.j.xt xtVar;
        int size = this.f26784r.size();
        if ((i6 == -1 || i6 == 200 || i6 == 509 || i6 == -3) && list != null && list.size() != 0 && size != 0) {
            HashMap hashMap = new HashMap();
            for (T t5 : this.f26784r) {
                if (t5 != null) {
                    hashMap.put(t5.cw(), t5);
                }
            }
            for (T t6 : list) {
                if (t6 != null && (xtVar = (com.bytedance.sdk.component.tl.j.xt) hashMap.get(t6.cw())) != null) {
                    this.f26784r.remove(xtVar);
                }
            }
        }
        this.f26784r.size();
    }

    @Override // com.bytedance.sdk.component.tl.xt.j.j
    public boolean j(String str) {
        return this.f26784r.size() > 0;
    }

    @Override // com.bytedance.sdk.component.tl.xt.j.j
    public boolean xt(int i6, String str, com.bytedance.sdk.component.tl.j.xt xtVar) {
        int size = this.f26784r.size();
        int j6 = this.f26783j.j();
        com.bytedance.sdk.component.tl.xt.cw.j.xt(i6);
        return size >= j6;
    }
}
