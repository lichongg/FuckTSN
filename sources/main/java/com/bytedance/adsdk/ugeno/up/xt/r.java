package com.bytedance.adsdk.ugeno.up.xt;

import android.text.TextUtils;
import com.bytedance.adsdk.ugeno.up.m;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes3.dex */
public class r extends j {
    @Override // com.bytedance.adsdk.ugeno.up.xt.j
    public void j() {
        com.bytedance.adsdk.ugeno.xt.cw cwVar;
        com.bytedance.adsdk.ugeno.xt.cw xt;
        com.bytedance.adsdk.ugeno.j.j oq;
        Map<String, String> map = this.f23770m;
        if (map == null || map.size() <= 0) {
            return;
        }
        String str = this.f23770m.get(CommonNetImpl.NAME);
        if (TextUtils.isEmpty(str) || (xt = (cwVar = this.cw).xt(cwVar)) == null || (oq = xt.m(str).oq(str)) == null) {
            return;
        }
        oq.xt();
        oq.j(new com.bytedance.adsdk.ugeno.j.xt() { // from class: com.bytedance.adsdk.ugeno.up.xt.r.1
            @Override // com.bytedance.adsdk.ugeno.j.xt
            public void xt() {
                r.this.cw();
            }

            @Override // com.bytedance.adsdk.ugeno.j.xt
            public void j() {
            }
        });
    }

    public r(com.bytedance.adsdk.ugeno.xt.cw cwVar, String str, m.j jVar) {
        super(cwVar, str, jVar);
    }

    @Override // com.bytedance.adsdk.ugeno.up.xt.j
    public void xt() {
    }
}
