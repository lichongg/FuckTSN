package com.bytedance.sdk.openadsdk.core.component.reward.cw;

import android.app.Activity;
import android.view.View;
import com.bytedance.sdk.component.utils.kt;
import com.bytedance.sdk.openadsdk.core.component.reward.cw.xt;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.widget.m;

/* loaded from: D:\Downloads\app\classes4.dex */
public class up extends j {

    /* renamed from: i, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.widget.m f28178i;

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.cw.j, com.bytedance.sdk.openadsdk.core.component.reward.cw.xt
    public xt.j xt(final oq oqVar) {
        final com.bytedance.sdk.openadsdk.core.widget.m mVar = new com.bytedance.sdk.openadsdk.core.widget.m(this.tl);
        this.f28178i = mVar;
        mVar.j(kt.cw(this.tl, "tt_retain_gift")).j(g()).cw("继续观看").r("坚持退出");
        mVar.j(com.bytedance.sdk.openadsdk.res.up.vl(this.tl));
        this.f28178i.j(new m.j() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.cw.up.1
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
        this.f28178i.j(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.cw.up.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                mVar.dismiss();
                oq oqVar2 = oqVar;
                if (oqVar2 != null) {
                    oqVar2.cw();
                }
            }
        });
        this.f28178i.show();
        return new xt.j(true, 0, "", this.f28178i);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.cw.xt
    public void cw() {
        com.bytedance.sdk.openadsdk.core.widget.m mVar = this.f28178i;
        if (mVar != null) {
            mVar.dismiss();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.cw.xt
    public String j() {
        return "继续观看" + this.f28167j + "秒可获得奖励\n确定要退出吗？";
    }

    public up(Activity activity, n nVar) {
        super(activity, nVar);
        this.f28178i = null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.cw.xt
    public boolean xt() {
        com.bytedance.sdk.openadsdk.core.widget.m mVar = this.f28178i;
        return mVar != null && mVar.isShowing();
    }
}
