package com.bytedance.sdk.openadsdk.core.component.reward.swiper;

import com.bykv.vk.openvk.component.video.api.cw.r;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.draw.xt;
import com.bytedance.sdk.openadsdk.core.jy.cw;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.s;
import com.bytedance.sdk.openadsdk.core.rn.rn;
import com.bytedance.sdk.openadsdk.core.tj.l;
import com.bytedance.sdk.openadsdk.core.tj.ln;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.l.oq;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j extends xt {
    private boolean up;

    public void cw(boolean z5) {
        this.up = z5;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.draw.xt
    public void j(NativeExpressView nativeExpressView) {
        Map<String, Object> nd = this.f28221j.nd();
        if (nativeExpressView.getDynamicShowType() == 0) {
            s.j(nd, this.xt, nativeExpressView);
        } else {
            nd.put("dynamic_show_type", Integer.valueOf(nativeExpressView.getDynamicShowType()));
        }
        l ng = this.xt.ng();
        Double d6 = null;
        if (ng != null) {
            nd.put("refresh_num", Integer.valueOf(ng.cw()));
            if (this.up) {
                d6 = this.f28221j.rh();
            }
        }
        cw.j(this.xt, this.cw, nd, d6);
        com.bytedance.sdk.openadsdk.core.a.j.j().r();
        rn.j(this.xt.ae());
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.draw.xt
    public r qv() {
        r j6 = ln.j(1, this.xt);
        j6.xt(this.xt.fs());
        j6.xt(100);
        j6.cw(100);
        j6.cw(this.xt.os());
        j6.xt(this.f28223r);
        if (oq.j(this.xt)) {
            j6.j(true);
        }
        return j6;
    }

    public j(TTBaseVideoActivity tTBaseVideoActivity, n nVar, String str, boolean z5, boolean z6) {
        super(tTBaseVideoActivity, nVar, str, z5, z6);
    }
}
