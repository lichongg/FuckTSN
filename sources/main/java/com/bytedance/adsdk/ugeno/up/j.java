package com.bytedance.adsdk.ugeno.up;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\Downloads\app\classes3.dex */
public class j implements tl {
    @Override // com.bytedance.adsdk.ugeno.up.tl
    public List<ae> j() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ae("slide") { // from class: com.bytedance.adsdk.ugeno.up.j.1
            @Override // com.bytedance.adsdk.ugeno.up.ae
            public com.bytedance.adsdk.ugeno.up.cw.xt j(Context context) {
                return new com.bytedance.adsdk.ugeno.up.cw.r(context);
            }
        });
        arrayList.add(new ae("tap") { // from class: com.bytedance.adsdk.ugeno.up.j.2
            @Override // com.bytedance.adsdk.ugeno.up.ae
            public com.bytedance.adsdk.ugeno.up.cw.xt j(Context context) {
                return new com.bytedance.adsdk.ugeno.up.cw.up(context);
            }
        });
        arrayList.add(new ae("timer") { // from class: com.bytedance.adsdk.ugeno.up.j.3
            @Override // com.bytedance.adsdk.ugeno.up.ae
            public com.bytedance.adsdk.ugeno.up.cw.xt j(Context context) {
                return new com.bytedance.adsdk.ugeno.up.cw.m(context);
            }
        });
        arrayList.add(new ae("touchStart") { // from class: com.bytedance.adsdk.ugeno.up.j.4
            @Override // com.bytedance.adsdk.ugeno.up.ae
            public com.bytedance.adsdk.ugeno.up.cw.xt j(Context context) {
                return new com.bytedance.adsdk.ugeno.up.cw.tl(context);
            }
        });
        arrayList.add(new ae("touchEnd") { // from class: com.bytedance.adsdk.ugeno.up.j.5
            @Override // com.bytedance.adsdk.ugeno.up.ae
            public com.bytedance.adsdk.ugeno.up.cw.xt j(Context context) {
                return new com.bytedance.adsdk.ugeno.up.cw.ae(context);
            }
        });
        arrayList.add(new ae("animateState") { // from class: com.bytedance.adsdk.ugeno.up.j.6
            @Override // com.bytedance.adsdk.ugeno.up.ae
            public com.bytedance.adsdk.ugeno.up.cw.xt j(Context context) {
                return new com.bytedance.adsdk.ugeno.up.cw.j(context);
            }
        });
        return arrayList;
    }
}
