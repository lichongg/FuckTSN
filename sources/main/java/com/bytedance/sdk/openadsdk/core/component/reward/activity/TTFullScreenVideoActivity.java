package com.bytedance.sdk.openadsdk.core.component.reward.activity;

import com.bytedance.sdk.openadsdk.core.component.reward.j.j;
import com.bytedance.sdk.openadsdk.core.tj.e;
import com.bytedance.sdk.openadsdk.core.v;

/* loaded from: D:\Downloads\app\classes4.dex */
public class TTFullScreenVideoActivity extends TTBaseVideoActivity {
    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    public boolean ch() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    protected void cw(boolean z5) {
        char c6 = 65535;
        if (this.ch) {
            if (v.xt().mp() == 1) {
                c6 = 2000;
            }
        } else if (z5) {
            c6 = 0;
        }
        if (c6 < 0 || this.f28056f.get()) {
            return;
        }
        if (c6 != 0) {
            this.xt.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTFullScreenVideoActivity.1
                @Override // java.lang.Runnable
                public void run() {
                    if (TTFullScreenVideoActivity.this.f28056f.getAndSet(true)) {
                        return;
                    }
                    j.j().j(String.valueOf(TTFullScreenVideoActivity.this.rh));
                }
            }, 2000L);
        } else {
            if (this.f28056f.getAndSet(true)) {
                return;
            }
            j.j().j(String.valueOf(this.rh));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    protected void r(String str) {
        com.bytedance.sdk.openadsdk.core.component.reward.j.j(1, this.ol, str, null);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    protected void s() {
        if (this.cw.getAndSet(true)) {
            return;
        }
        r("onAdClose");
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    public void ol() {
        boolean z5;
        String str;
        super.ol();
        if (e.i(this.up) || this.wq.p()) {
            return;
        }
        if (this.ed.rn()) {
            this.rn.j(false, null, null, true, true);
            return;
        }
        int h6 = ((int) this.ed.h()) / 1000;
        String str2 = this.f28064n.m(false) + "s";
        if (h6 >= this.f28064n.hl()) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (z5) {
            str = "跳过";
        } else if (v.xt().up(String.valueOf(this.rh))) {
            str = (this.f28064n.hl() - h6) + "s后可跳过";
        } else {
            str = null;
        }
        this.rn.j(false, str2, str, false, z5);
    }
}
