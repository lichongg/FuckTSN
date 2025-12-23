package com.bytedance.sdk.openadsdk.core.component.reward.business.xt.j;

import android.app.Activity;
import com.bytedance.sdk.component.utils.kt;
import com.bytedance.sdk.openadsdk.core.component.reward.cw.oq;
import com.bytedance.sdk.openadsdk.core.component.reward.cw.xt;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.tj.rh;
import com.bytedance.sdk.openadsdk.core.widget.m;
import com.bytedance.sdk.openadsdk.res.up;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt extends j {
    private m xt;

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.xt.j.j, com.bytedance.sdk.openadsdk.core.component.reward.cw.xt
    public xt.j j(final oq oqVar) {
        xt.j j6 = super.j(oqVar);
        if (j6.cw()) {
            return j6;
        }
        final m mVar = new m(this.tl);
        this.xt = mVar;
        mVar.j(kt.cw(this.tl, "tt_retain_gift")).j(j()).cw(rh.j(this.ae, this.qv, this.vl)).r("坚持退出");
        mVar.j(up.tl(this.tl));
        this.xt.j(new m.j() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.business.xt.j.xt.1
            @Override // com.bytedance.sdk.openadsdk.core.widget.m.j
            public void j() {
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
        this.xt.show();
        return new xt.j(true, 0, "", this.xt);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.cw.xt
    public void cw() {
        m mVar = this.xt;
        if (mVar != null) {
            mVar.dismiss();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.cw.xt
    public void r() {
        m mVar = this.xt;
        if (mVar != null) {
            mVar.j();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.cw.xt
    public void up() {
        m mVar = this.xt;
        if (mVar != null) {
            mVar.xt();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.cw.xt
    public boolean xt() {
        m mVar = this.xt;
        return mVar != null && mVar.isShowing();
    }

    public xt(Activity activity, n nVar) {
        super(activity, nVar);
        this.xt = null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.cw.xt
    public String j() {
        return "恭喜您已经获得奖励，是否要继续观看视频，再得超值奖励";
    }
}
