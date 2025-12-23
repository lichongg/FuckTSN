package com.bytedance.sdk.openadsdk.core.component.reward.cw;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import com.bytedance.sdk.component.utils.kt;
import com.bytedance.sdk.openadsdk.core.component.reward.cw.xt;
import com.bytedance.sdk.openadsdk.core.rn.tj;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.tj.ol;
import com.bytedance.sdk.openadsdk.core.widget.m;

/* loaded from: D:\Downloads\app\classes4.dex */
public class tl extends j {

    /* renamed from: i, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.widget.m f28175i;

    /* renamed from: w, reason: collision with root package name */
    private String f28176w;

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.cw.xt
    public String j() {
        return this.f28176w;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.cw.j, com.bytedance.sdk.openadsdk.core.component.reward.cw.xt
    public xt.j xt(final oq oqVar) {
        final com.bytedance.sdk.openadsdk.core.widget.m mVar = new com.bytedance.sdk.openadsdk.core.widget.m(this.tl);
        this.f28175i = mVar;
        j(mVar, this.f28169r);
        this.f28175i.j(new m.j() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.cw.tl.1
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
        this.f28175i.show();
        return new xt.j(true, 0, "", this.f28175i);
    }

    private void j(com.bytedance.sdk.openadsdk.core.widget.m mVar, boolean z5) {
        if (tj.xt(this.ae)) {
            int fv = this.ae.fv();
            int j6 = ol.j(this.ae);
            if (fv == 0) {
                String str = "试玩时长达标才能领取奖励";
                if (j6 != 1 && !z5 && !this.cw) {
                    str = "试玩后才能领取奖励";
                }
                this.f28176w = str;
                mVar.j(kt.cw(this.tl, "tt_retain_gift")).j(g()).cw("继续试玩").r("坚持退出");
                mVar.j(com.bytedance.sdk.openadsdk.res.up.tl(this.tl));
                return;
            }
            if (fv != 1) {
                if (fv != 3) {
                    return;
                }
                this.f28176w = "确定退出吗?";
                Activity activity = this.tl;
                if (activity != null) {
                    Intent intent = activity.getIntent();
                    this.f28176w = String.format("再看%s秒可得奖励", Integer.valueOf(intent != null ? intent.getIntExtra("remainTime", 0) : 0));
                }
                j(mVar, g(), "继续观看", "坚持退出");
                mVar.j(Color.parseColor("#FC1D56"));
                return;
            }
            boolean cw = com.bytedance.sdk.openadsdk.core.tj.kt.cw(this.ae);
            if (j6 != 0 || cw) {
                this.f28176w = String.format("再看%s秒可得奖励", Integer.valueOf(this.f28167j));
            } else {
                this.f28176w = "未满足奖励要求，需要继续浏览";
            }
            if (cw) {
                mVar.xt("确定退出吗?");
                j(mVar, g(), "继续观看", "坚持退出");
            } else {
                mVar.j(kt.cw(this.tl, "tt_reward_coin")).j(Color.parseColor("#FC1D56")).j(g()).cw("继续观看").r("坚持退出");
                mVar.j(com.bytedance.sdk.openadsdk.res.up.tl(this.tl));
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.cw.xt
    public void cw() {
        com.bytedance.sdk.openadsdk.core.widget.m mVar = this.f28175i;
        if (mVar != null) {
            mVar.dismiss();
        }
    }

    public tl(Activity activity, n nVar) {
        super(activity, nVar);
        this.f28175i = null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.cw.xt
    public boolean xt() {
        com.bytedance.sdk.openadsdk.core.widget.m mVar = this.f28175i;
        return mVar != null && mVar.isShowing();
    }

    private void j(com.bytedance.sdk.openadsdk.core.widget.m mVar, String str, String str2, String str3) {
        mVar.j(kt.cw(this.tl, "tt_reward_browse_multi_icon")).j(str).cw(str2).r(str3);
        mVar.j(com.bytedance.sdk.openadsdk.res.up.gq(this.tl));
    }
}
