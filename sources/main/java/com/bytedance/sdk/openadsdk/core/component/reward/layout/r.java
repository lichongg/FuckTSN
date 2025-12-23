package com.bytedance.sdk.openadsdk.core.component.reward.layout;

import android.view.View;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.draw.RewardGuideSlideUp;
import com.bytedance.sdk.openadsdk.core.rn.ed;
import com.bytedance.sdk.openadsdk.core.tj.n;

/* loaded from: D:\Downloads\app\classes4.dex */
public class r extends xt {
    private com.bytedance.sdk.openadsdk.core.component.reward.draw.cw av;
    private com.bytedance.sdk.openadsdk.core.component.reward.draw.j az;

    /* renamed from: i, reason: collision with root package name */
    private float f28336i;
    private RewardGuideSlideUp jy;
    private boolean kt;
    private boolean mi;

    /* renamed from: w, reason: collision with root package name */
    private float f28337w;
    private RecyclerView ws;

    public void m() {
        this.mi = false;
        if (this.kt) {
            ed.j((View) this.jy, 8);
            this.jy.xt();
            this.kt = false;
        }
    }

    public com.bytedance.sdk.openadsdk.core.component.reward.draw.j cw() {
        return this.az;
    }

    public com.bytedance.sdk.openadsdk.core.component.reward.draw.cw r() {
        return this.av;
    }

    public void up() {
        if (this.mi) {
            this.ae.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.layout.r.1
                @Override // java.lang.Runnable
                public void run() {
                    if (r.this.mi) {
                        r.this.mi = false;
                        ed.j((View) r.this.jy, 0);
                        r.this.jy.getSlideUpAnimatorSet().start();
                        r.this.kt = true;
                        r.this.ae.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.layout.r.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                r.this.m();
                            }
                        }, 3000L);
                    }
                }
            }, 0L);
        }
    }

    public r(TTBaseVideoActivity tTBaseVideoActivity, n nVar, boolean z5) {
        super(tTBaseVideoActivity, nVar, z5);
        this.mi = true;
    }

    public void j(float[] fArr) {
        this.f28336i = fArr[0];
        this.f28337w = fArr[1];
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.layout.xt
    public void oq() {
        super.oq();
        if (this.jy != null) {
            m();
        }
    }

    public RecyclerView xt() {
        return this.ws;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.layout.xt
    public void j() {
        super.j();
        this.ws = (RecyclerView) this.ae.findViewById(2114387891);
        this.jy = (RewardGuideSlideUp) this.ae.findViewById(2114387966);
        com.bytedance.sdk.openadsdk.core.component.reward.draw.cw cwVar = new com.bytedance.sdk.openadsdk.core.component.reward.draw.cw(this.xt, 1, false);
        this.av = cwVar;
        this.ws.setLayoutManager(cwVar);
        com.bytedance.sdk.openadsdk.core.component.reward.draw.j jVar = new com.bytedance.sdk.openadsdk.core.component.reward.draw.j(this.xt, this.f28336i, this.f28337w);
        this.az = jVar;
        this.ws.setAdapter(jVar);
        this.jy.j();
    }

    public void j(boolean z5) {
        com.bytedance.sdk.openadsdk.core.component.reward.draw.cw cwVar = this.av;
        if (cwVar == null) {
            return;
        }
        cwVar.xt(z5);
    }
}
