package com.bytedance.adsdk.ugeno.up.xt;

import android.text.TextUtils;
import com.bytedance.adsdk.ugeno.up.m;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes3.dex */
public class up extends j {
    @Override // com.bytedance.adsdk.ugeno.up.xt.j
    public void j() {
        Map<String, String> map = this.f23770m;
        if (map == null || map.size() <= 0) {
            return;
        }
        String str = this.f23770m.get("id");
        if (TextUtils.isEmpty(str)) {
            j(this.cw);
            return;
        }
        com.bytedance.adsdk.ugeno.xt.cw cwVar = this.cw;
        com.bytedance.adsdk.ugeno.xt.cw xt = cwVar.xt(cwVar);
        if (xt == null) {
            return;
        }
        j(xt.r(str));
    }

    public up(com.bytedance.adsdk.ugeno.xt.cw cwVar, String str, m.j jVar) {
        super(cwVar, str, jVar);
    }

    private void j(com.bytedance.adsdk.ugeno.xt.cw cwVar) {
        if (cwVar == null) {
            return;
        }
        for (String str : this.f23770m.keySet()) {
            if (!TextUtils.isEmpty(str) && !TextUtils.equals(str, "id")) {
                cwVar.j(str, this.f23770m.get(str));
            }
        }
        cwVar.j(this.f23770m.containsKey("width"), this.f23770m.containsKey("height"));
        cwVar.xt();
    }
}
