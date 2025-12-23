package com.bytedance.sdk.openadsdk.core.component.reward.xt;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.top.RewardBrowserMixTopLayoutImpl;
import com.bytedance.sdk.openadsdk.core.component.reward.top.TopLayoutImpl;
import com.bytedance.sdk.openadsdk.core.component.reward.view.ugen.UgenBanner;
import com.bytedance.sdk.openadsdk.core.tj.kt;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.widget.TopProxyLayout;

/* loaded from: D:\Downloads\app\classes4.dex */
public class up {
    private com.bytedance.sdk.openadsdk.core.component.reward.top.m ae;
    private com.bytedance.sdk.openadsdk.core.component.reward.top.j cw;

    /* renamed from: g, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.component.reward.top.up f28523g;

    /* renamed from: j, reason: collision with root package name */
    private final TTBaseVideoActivity f28524j;

    /* renamed from: m, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.xt.xt f28525m;

    /* renamed from: r, reason: collision with root package name */
    private TextView f28526r;
    private com.bytedance.sdk.openadsdk.core.component.reward.top.r tl;
    private UgenBanner up;
    private n xt;

    public void ae(boolean z5) {
        com.bytedance.sdk.openadsdk.core.component.reward.top.j jVar = this.cw;
        if (jVar != null) {
            jVar.setShowAgain(z5);
        }
    }

    public void cw(boolean z5) {
        com.bytedance.sdk.openadsdk.core.component.reward.top.j jVar = this.cw;
        if (jVar != null) {
            jVar.setDislikeLeft(z5);
        }
    }

    public void m(boolean z5) {
        com.bytedance.sdk.openadsdk.core.component.reward.top.j jVar = this.cw;
        if (jVar != null) {
            jVar.setShowBack(z5);
        }
    }

    public void r(boolean z5) {
        com.bytedance.sdk.openadsdk.core.component.reward.top.j jVar = this.cw;
        if (jVar != null) {
            jVar.setSoundMute(z5);
        }
    }

    public void up(boolean z5) {
        com.bytedance.sdk.openadsdk.core.component.reward.top.j jVar = this.cw;
        if (jVar != null) {
            jVar.setShowSound(z5);
        }
    }

    public void xt(boolean z5) {
        com.bytedance.sdk.openadsdk.core.component.reward.top.j jVar = this.cw;
        if (jVar != null) {
            jVar.setShowDislike(z5);
        }
    }

    private void tl() {
        TopProxyLayout topProxyLayout = (TopProxyLayout) this.f28524j.findViewById(2114387727);
        if (topProxyLayout != null) {
            j(topProxyLayout);
        }
        this.f28526r = (TextView) this.f28524j.findViewById(2114387807);
        this.up = (UgenBanner) this.f28524j.findViewById(2114387907);
    }

    public void j(n nVar, xt xtVar, boolean z5, com.bytedance.sdk.openadsdk.core.xt.xt xtVar2) {
        this.xt = nVar;
        this.f28525m = xtVar2;
        tl();
        this.ae = new com.bytedance.sdk.openadsdk.core.component.reward.top.m(this.f28524j, this.xt, xtVar, this, z5);
        this.f28523g = new com.bytedance.sdk.openadsdk.core.component.reward.top.up(this.f28524j, this.xt, xtVar, this, z5);
        this.tl = new com.bytedance.sdk.openadsdk.core.component.reward.top.r(this.f28524j, this.xt, xtVar, this, z5);
        j(1);
    }

    public up(TTBaseVideoActivity tTBaseVideoActivity) {
        this.f28524j = tTBaseVideoActivity;
    }

    public void ae() {
        UgenBanner ugenBanner = this.up;
        if (ugenBanner == null) {
            return;
        }
        ugenBanner.j();
    }

    public void cw() {
        com.bytedance.sdk.openadsdk.core.component.reward.top.j jVar = this.cw;
        if (jVar != null) {
            jVar.cw();
        }
    }

    public void m() {
        UgenBanner ugenBanner = this.up;
        if (ugenBanner == null) {
            return;
        }
        ugenBanner.j(this.xt, this.f28525m);
    }

    public View r() {
        com.bytedance.sdk.openadsdk.core.component.reward.top.j jVar = this.cw;
        if (jVar != null) {
            return jVar.getCloseButton();
        }
        return null;
    }

    public boolean up() {
        com.bytedance.sdk.openadsdk.core.component.reward.top.j jVar = this.cw;
        if (jVar != null) {
            return jVar.getSkipOrCloseVisible();
        }
        return false;
    }

    public void xt() {
        com.bytedance.sdk.openadsdk.core.component.reward.top.j jVar = this.cw;
        if (jVar != null) {
            jVar.xt();
        }
    }

    public void xt(String str) {
        TextView textView = this.f28526r;
        if (textView != null) {
            textView.setText(str);
            this.f28526r.setVisibility(0);
            this.f28526r.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.xt.up.1
                @Override // java.lang.Runnable
                public void run() {
                    up.this.f28526r.setVisibility(8);
                }
            }, 3000L);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [com.bytedance.sdk.openadsdk.core.component.reward.top.RewardBrowserMixTopLayoutImpl] */
    /* JADX WARN: Type inference failed for: r3v0, types: [com.bytedance.sdk.openadsdk.core.component.reward.xt.up] */
    public void j(TopProxyLayout topProxyLayout) {
        TopLayoutImpl topLayoutImpl;
        if (kt.qv(this.xt)) {
            topLayoutImpl = new RewardBrowserMixTopLayoutImpl(topProxyLayout.getContext()).j(this.xt);
        } else {
            topLayoutImpl = new TopLayoutImpl(topProxyLayout.getContext()).j(this.xt);
        }
        if (topLayoutImpl != null) {
            this.cw = topLayoutImpl;
        } else {
            vl.r("RewardFullTopProxyManager", "view not implements ITopLayout interface");
        }
        ViewParent parent = topProxyLayout.getParent();
        if (parent instanceof ViewGroup) {
            j(topProxyLayout, topLayoutImpl, (ViewGroup) parent);
        }
    }

    private void j(TopProxyLayout topProxyLayout, View view, ViewGroup viewGroup) {
        int indexOfChild = viewGroup.indexOfChild(topProxyLayout);
        viewGroup.removeViewInLayout(topProxyLayout);
        ViewGroup.LayoutParams layoutParams = topProxyLayout.getLayoutParams();
        if (layoutParams != null) {
            viewGroup.addView(view, indexOfChild, layoutParams);
        } else {
            viewGroup.addView(view, indexOfChild);
        }
    }

    public void j(boolean z5) {
        com.bytedance.sdk.openadsdk.core.component.reward.top.j jVar = this.cw;
        if (jVar != null) {
            jVar.setVisible(z5);
        }
    }

    public void j(boolean z5, String str, String str2, boolean z6, boolean z7) {
        com.bytedance.sdk.openadsdk.core.component.reward.top.j jVar = this.cw;
        if (jVar != null) {
            jVar.j(z5, str, str2, z6, z7);
        }
    }

    public void j() {
        com.bytedance.sdk.openadsdk.core.component.reward.top.j jVar = this.cw;
        if (jVar != null) {
            jVar.j();
        }
    }

    public void j(int i6) {
        if (i6 == 2) {
            j(this.tl);
        } else if (i6 != 4) {
            j(this.ae);
        } else {
            j(this.f28523g);
        }
    }

    public void j(com.bytedance.sdk.openadsdk.core.component.reward.top.xt xtVar) {
        com.bytedance.sdk.openadsdk.core.component.reward.top.j jVar = this.cw;
        if (jVar != null) {
            jVar.setListener(xtVar);
        }
    }

    public void j(String str) {
        com.bytedance.sdk.openadsdk.core.component.reward.top.j jVar = this.cw;
        if (jVar != null) {
            jVar.setPlayAgainEntranceText(str);
        }
    }
}
