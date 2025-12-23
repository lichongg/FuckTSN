package com.bytedance.adsdk.ugeno.up.j;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: D:\Downloads\app\classes3.dex */
public class xt implements cw {

    /* renamed from: j, reason: collision with root package name */
    private List<r> f23757j = new CopyOnWriteArrayList();

    @Override // com.bytedance.adsdk.ugeno.up.j.cw
    public void j(r rVar) {
        this.f23757j.add(rVar);
    }

    @Override // com.bytedance.adsdk.ugeno.up.j.cw
    public void j(String str) {
        if (this.f23757j.isEmpty()) {
            return;
        }
        Iterator<r> it = this.f23757j.iterator();
        while (it.hasNext()) {
            it.next().j(str);
        }
    }
}
