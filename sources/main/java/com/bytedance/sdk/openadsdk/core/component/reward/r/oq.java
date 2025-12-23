package com.bytedance.sdk.openadsdk.core.component.reward.r;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.rn.ed;
import com.bytedance.sdk.openadsdk.core.tj.e;
import com.bytedance.sdk.openadsdk.core.tj.hl;
import com.bytedance.sdk.openadsdk.core.tj.ln;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.tj.oq;
import com.bytedance.sdk.openadsdk.core.v;
import java.util.HashMap;
import xyz.adscope.amps.common.AMPSConstants;

/* loaded from: D:\Downloads\app\classes4.dex */
public class oq extends j {
    boolean rn;
    private boolean wq;

    public static int j(n nVar) {
        return 9;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.xt
    public boolean e() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.j
    public boolean m() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.xt
    public boolean q() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.xt
    public boolean qb() {
        return false;
    }

    private void tl(final boolean z5) {
        if (this.f28366g instanceof com.bytedance.sdk.openadsdk.core.component.reward.layout.g) {
            com.bytedance.sdk.openadsdk.l.ae.j(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.r.oq.2
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.openadsdk.core.component.reward.layout.xt xtVar = oq.this.f28366g;
                    if (xtVar == null) {
                        return;
                    }
                    com.bytedance.sdk.openadsdk.core.component.reward.layout.g gVar = (com.bytedance.sdk.openadsdk.core.component.reward.layout.g) xtVar;
                    if (z5) {
                        gVar.xt();
                    } else {
                        gVar.cw();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zz() {
        if (this.rn) {
            return;
        }
        this.rn = true;
        tl(false);
        this.f28369j.finish();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.j, com.bytedance.sdk.openadsdk.core.component.reward.r.xt
    protected void cw() {
        this.f28369j.xt(true, true);
        this.f28366g.cw(true);
        this.oq.cw(false);
        this.mi.j(false);
        int tl = ed.tl(v.getContext());
        com.bytedance.sdk.openadsdk.core.jy.cw.j(AMPSConstants.FrequencyEventType.FREQUENCY_EVENT_TYPE_CLICK, this.xt, new oq.j().m(-1.0f).up(-1.0f).r(-1.0f).cw(-1.0f).xt(-1L).j(-1L).cw(-1).r(-1).up(-1024).xt(com.bytedance.sdk.openadsdk.core.oq.i().cw() ? 1 : 2).j(tl).j(ed.m(v.getContext())).xt(ed.ae(v.getContext())).j(), this.vl, true, this.f28369j.nd(), -1, false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.j
    public View g() {
        FrameLayout frameLayout = new FrameLayout(this.f28369j);
        frameLayout.setId(2114387959);
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        return frameLayout;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.j
    public int p() {
        return j(this.xt);
    }

    public oq(TTBaseVideoActivity tTBaseVideoActivity, n nVar) {
        super(tTBaseVideoActivity, nVar);
        this.rn = false;
        this.wq = false;
        this.wq = com.bytedance.sdk.openadsdk.core.live.cw.xt.j(nVar) == 1;
    }

    public static boolean j(Context context, n nVar) {
        long m6;
        if (!hl.r(nVar)) {
            return false;
        }
        if (com.bytedance.sdk.openadsdk.core.tj.ed.j(nVar)) {
            m6 = com.bytedance.sdk.openadsdk.core.tj.ed.xt(nVar) * 1000;
        } else {
            m6 = ln.ws(nVar) != null ? (long) (ln.m(nVar) * 1000.0d) : 0L;
        }
        long min = Math.min(e.j(), (long) (m6 * (nVar.nw() / 100.0f)));
        HashMap hashMap = new HashMap(3);
        hashMap.put("reward_countdown", Long.valueOf(min));
        hashMap.put("event_tag", "rewarded_video");
        hashMap.put("reward_live_scene", Integer.valueOf(com.bytedance.sdk.openadsdk.core.live.cw.xt.j(nVar)));
        return com.bytedance.sdk.openadsdk.core.live.xt.j().xt(context, nVar, hashMap) == 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.j
    public com.bytedance.sdk.openadsdk.core.component.reward.layout.xt j(boolean z5) {
        com.bytedance.sdk.openadsdk.core.component.reward.layout.g gVar = new com.bytedance.sdk.openadsdk.core.component.reward.layout.g(this.f28369j, this.xt, z5);
        this.f28366g = gVar;
        return gVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.j
    public void j(int i6, int i7, Intent intent) {
        super.j(i6, i7, intent);
        if (i6 != 1) {
            this.f28369j.finish();
            return;
        }
        if (intent == null || intent.getExtras() == null) {
            this.f28369j.finish();
            return;
        }
        if (intent.getExtras().getLong("csj.reward_countdown_duration_ms") <= 0) {
            int i8 = intent.getExtras().getInt("csj.reward_auth_status", 0);
            if (this.wq && i8 == 1) {
                this.f28369j.finish();
                return;
            }
            com.bytedance.sdk.component.utils.vl.r("rewardAuthFlag", "verify rew....");
            this.f28369j.r(0);
            tl(true);
            this.f28369j.uf().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.r.oq.1
                @Override // java.lang.Runnable
                public void run() {
                    oq.this.zz();
                }
            }, 2000L);
            return;
        }
        this.f28369j.finish();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.xt
    public void ff() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.j
    public void j(int i6) {
        super.j(i6);
        if (i6 == 0) {
            zz();
        }
    }
}
