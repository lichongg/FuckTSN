package com.bytedance.sdk.openadsdk.core.component.reward.layout;

import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.swiper.FullSwiperView;
import com.bytedance.sdk.openadsdk.core.rn.uf;
import com.bytedance.sdk.openadsdk.core.tj.n;
import java.util.List;

/* loaded from: D:\Downloads\app\classes4.dex */
public class oq extends xt {
    private FullSwiperView az;
    private float jy;
    private float ws;

    public void j(float[] fArr) {
        this.jy = fArr[0];
        this.ws = fArr[1];
    }

    public void cw() {
        FullSwiperView fullSwiperView = this.az;
        if (fullSwiperView != null) {
            fullSwiperView.cw();
        }
    }

    public void m() {
        FullSwiperView fullSwiperView = this.az;
        if (fullSwiperView != null) {
            fullSwiperView.ae();
        }
    }

    public void r() {
        FullSwiperView fullSwiperView = this.az;
        if (fullSwiperView != null) {
            fullSwiperView.r();
        }
    }

    public int up() {
        FullSwiperView fullSwiperView = this.az;
        if (fullSwiperView != null) {
            return fullSwiperView.getCurrentPosition();
        }
        return 0;
    }

    public void xt() {
        FullSwiperView fullSwiperView = this.az;
        if (fullSwiperView != null) {
            fullSwiperView.xt();
        }
    }

    public oq(TTBaseVideoActivity tTBaseVideoActivity, n nVar, boolean z5) {
        super(tTBaseVideoActivity, nVar, z5);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.layout.xt
    public void j() {
        super.j();
        this.ae.setBackgroundColor(0);
        this.az = new FullSwiperView(this.xt);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.layout.xt
    public void oq() {
        super.oq();
        FullSwiperView fullSwiperView = this.az;
        if (fullSwiperView != null) {
            fullSwiperView.up();
        }
    }

    public void j(List<com.bytedance.sdk.openadsdk.core.component.reward.swiper.j> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.az.j(list).j(this.jy).xt(this.ws).j(String.valueOf(uf.g(this.cw))).j();
        this.ae.addView(this.az, new FrameLayout.LayoutParams(-1, -1));
    }
}
