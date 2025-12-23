package com.bytedance.adsdk.ugeno.up;

import com.bytedance.adsdk.ugeno.up.m;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\Downloads\app\classes3.dex */
public class up implements cw {
    @Override // com.bytedance.adsdk.ugeno.up.cw
    public List<xt> j() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new xt("update") { // from class: com.bytedance.adsdk.ugeno.up.up.1
            @Override // com.bytedance.adsdk.ugeno.up.xt
            public com.bytedance.adsdk.ugeno.up.xt.j j(com.bytedance.adsdk.ugeno.xt.cw cwVar, String str, m.j jVar) {
                return new com.bytedance.adsdk.ugeno.up.xt.up(cwVar, str, jVar);
            }
        });
        arrayList.add(new xt("emit") { // from class: com.bytedance.adsdk.ugeno.up.up.2
            @Override // com.bytedance.adsdk.ugeno.up.xt
            public com.bytedance.adsdk.ugeno.up.xt.j j(com.bytedance.adsdk.ugeno.xt.cw cwVar, String str, m.j jVar) {
                return new com.bytedance.adsdk.ugeno.up.xt.xt(cwVar, str, jVar);
            }
        });
        arrayList.add(new xt("startAnimate") { // from class: com.bytedance.adsdk.ugeno.up.up.3
            @Override // com.bytedance.adsdk.ugeno.up.xt
            public com.bytedance.adsdk.ugeno.up.xt.j j(com.bytedance.adsdk.ugeno.xt.cw cwVar, String str, m.j jVar) {
                return new com.bytedance.adsdk.ugeno.up.xt.r(cwVar, str, jVar);
            }
        });
        return arrayList;
    }
}
