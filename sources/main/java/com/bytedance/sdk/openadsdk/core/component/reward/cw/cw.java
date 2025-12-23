package com.bytedance.sdk.openadsdk.core.component.reward.cw;

import android.app.Activity;
import com.bytedance.sdk.component.utils.kt;
import com.bytedance.sdk.openadsdk.core.component.reward.cw.xt;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.widget.m;

/* loaded from: D:\Downloads\app\classes4.dex */
public class cw extends j {

    /* renamed from: i, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.widget.m f28164i;

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.cw.j, com.bytedance.sdk.openadsdk.core.component.reward.cw.xt
    public xt.j xt(final oq oqVar) {
        xt.j xt = super.xt(oqVar);
        if (xt.cw()) {
            return xt;
        }
        final com.bytedance.sdk.openadsdk.core.widget.m mVar = new com.bytedance.sdk.openadsdk.core.widget.m(this.tl);
        this.f28164i = mVar;
        mVar.j(kt.cw(this.tl, "tt_retain_gift")).j(g()).cw("继续观看").r("坚持退出");
        this.f28164i.j(com.bytedance.sdk.openadsdk.res.up.tl(this.tl));
        this.f28164i.j(new m.j() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.cw.cw.1
            @Override // com.bytedance.sdk.openadsdk.core.widget.m.j
            public void j() {
                mVar.dismiss();
                oq oqVar2 = oqVar;
                if (oqVar2 != null) {
                    oqVar2.j();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.m.j
            public void xt() {
                mVar.dismiss();
                oq oqVar2 = oqVar;
                if (oqVar2 != null) {
                    oqVar2.xt();
                }
            }
        });
        this.f28164i.show();
        return new xt.j(true, 0, "", this.f28164i);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.cw.xt
    public void cw() {
        com.bytedance.sdk.openadsdk.core.widget.m mVar = this.f28164i;
        if (mVar != null) {
            mVar.dismiss();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.cw.xt
    public String j() {
        if (this.f28167j > 0 && this.up) {
            return "再看" + this.f28167j + "s，并点击一下广告可领取奖励";
        }
        if (this.up) {
            return "忘记点击广告领取奖励啦～";
        }
        return "再看" + this.f28167j + "s可领取奖励";
    }

    public cw(Activity activity, n nVar) {
        super(activity, nVar);
        this.f28164i = null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.cw.xt
    public boolean xt() {
        com.bytedance.sdk.openadsdk.core.widget.m mVar = this.f28164i;
        return mVar != null && mVar.isShowing();
    }
}
