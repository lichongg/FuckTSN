package com.bytedance.adsdk.ugeno.up.xt;

import com.bytedance.adsdk.ugeno.up.m;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: D:\Downloads\app\classes3.dex */
public class xt extends j {

    /* renamed from: g, reason: collision with root package name */
    private List<com.bytedance.adsdk.ugeno.up.j.r> f23773g;

    @Override // com.bytedance.adsdk.ugeno.up.xt.j
    public void j() {
        com.bytedance.adsdk.ugeno.up.j.cw j6;
        Map<String, String> map = this.f23770m;
        if (map == null || map.size() <= 0) {
            return;
        }
        String str = this.f23770m.get(CommonNetImpl.NAME);
        com.bytedance.adsdk.ugeno.up.j.j gx = this.cw.gx();
        if (gx == null || (j6 = gx.j(str)) == null) {
            return;
        }
        j6.j(str);
    }

    public xt(com.bytedance.adsdk.ugeno.xt.cw cwVar, String str, m.j jVar) {
        super(cwVar, str, jVar);
        this.f23773g = new CopyOnWriteArrayList();
    }
}
