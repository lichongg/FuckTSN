package com.bytedance.msdk.cw.cw.xt.j.xt;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.gq;
import com.bytedance.sdk.openadsdk.i.cw.cw.xt;
import com.stub.StubApp;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes3.dex */
public class up extends xt {
    private com.bytedance.msdk.cw.m.xt.xt cw;
    private com.bytedance.msdk.api.j.xt xt;

    @Override // com.bytedance.msdk.cw.cw.xt.j.xt
    public void xt(Context context, com.bytedance.msdk.cw.m.xt.xt xtVar, com.bytedance.msdk.api.j.xt xtVar2, Map<String, Object> map) {
        gq j6;
        this.cw = xtVar;
        this.xt = xtVar2;
        if (xtVar2 == null) {
            j(new com.bytedance.msdk.api.j("load ad fail adSlot is null"));
            return;
        }
        if (map == null || (j6 = j(StubApp.getOrigApplicationContext(context.getApplicationContext()))) == null) {
            return;
        }
        xt.j j7 = com.bytedance.msdk.j.cw.xt.j(this.xt, this.cw, false);
        int ch = this.xt.ch();
        int s5 = this.xt.s();
        if (ch > 0 && s5 > 0) {
            j7.j(ch).xt(s5);
        }
        Object obj = map.get("tt_ad_origin_type");
        if (obj == null) {
            j(new com.bytedance.msdk.api.j("渲染类型错误"));
            return;
        }
        int intValue = ((Integer) obj).intValue();
        if (intValue == 1) {
            j(j6, j7);
        } else if (intValue == 2) {
            xt(j6, j7);
        } else {
            j(new com.bytedance.msdk.api.j("渲染类型错误"));
        }
    }

    private void j(gq gqVar, xt.j jVar) {
        if (this.xt.az() > 0.0f) {
            jVar.j(this.xt.ws()).xt(this.xt.az());
        } else {
            jVar.j(this.xt.ws()).xt(0.0f);
        }
        new r().j(this.cw.j(), gqVar, jVar.j(), this);
    }

    public up(com.bytedance.msdk.cw.j.xt xtVar) {
        super(xtVar);
    }

    private void xt(gq gqVar, xt.j jVar) {
        new cw().j(this.cw.j(), gqVar, jVar.j(), this);
    }
}
