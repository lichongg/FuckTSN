package com.bytedance.sdk.openadsdk.core.component.reward.layout;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.xt.ws;
import com.bytedance.sdk.openadsdk.core.EmptyView;
import com.bytedance.sdk.openadsdk.core.av.j;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.view.FullRewardExpressView;
import com.bytedance.sdk.openadsdk.core.multipro.xt.j;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.qv;
import com.bytedance.sdk.openadsdk.core.rn;
import com.bytedance.sdk.openadsdk.core.tj.n;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class up {
    private String ae;

    /* renamed from: g, reason: collision with root package name */
    private FullRewardExpressView f28343g;

    /* renamed from: j, reason: collision with root package name */
    com.bytedance.sdk.openadsdk.core.qv.xt.cw f28344j;

    /* renamed from: m, reason: collision with root package name */
    private n f28345m;
    private ViewGroup tl;
    private final TTBaseVideoActivity up;
    boolean xt = false;
    boolean cw = false;

    /* renamed from: r, reason: collision with root package name */
    boolean f28346r = false;

    public boolean cw() {
        return this.cw;
    }

    public boolean xt() {
        return this.xt;
    }

    public void ae() {
        FullRewardExpressView fullRewardExpressView = this.f28343g;
        if (fullRewardExpressView == null) {
            return;
        }
        fullRewardExpressView.av();
    }

    public void cw(boolean z5) {
        ViewGroup viewGroup = this.tl;
        if (viewGroup != null) {
            viewGroup.setVisibility(z5 ? 0 : 8);
        }
    }

    public int g() {
        FullRewardExpressView fullRewardExpressView = this.f28343g;
        if (fullRewardExpressView != null) {
            return fullRewardExpressView.getDynamicShowType();
        }
        return 0;
    }

    public void j(n nVar, com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar, String str, boolean z5) {
        if (this.f28346r) {
            return;
        }
        this.f28346r = true;
        this.f28345m = nVar;
        this.ae = str;
        this.f28343g = new FullRewardExpressView(this.up, nVar, xtVar, str, z5);
        FrameLayout expressFrameContainer = this.up.gq().getExpressFrameContainer();
        this.tl = expressFrameContainer;
        expressFrameContainer.addView(this.f28343g, new FrameLayout.LayoutParams(-2, -2));
        this.f28343g.setEasyPlayableContainer(this.up.gq().getEasyPlayableContainer());
    }

    public void jy() {
        FullRewardExpressView fullRewardExpressView = this.f28343g;
        if (fullRewardExpressView != null && fullRewardExpressView.getJsObject() != null) {
            this.f28343g.getJsObject().ae(true);
        }
        j("isVerifyReward", (JSONObject) null);
    }

    public boolean m() {
        FullRewardExpressView fullRewardExpressView = this.f28343g;
        return (fullRewardExpressView == null || fullRewardExpressView.tj()) ? false : true;
    }

    public boolean oq() {
        FullRewardExpressView fullRewardExpressView = this.f28343g;
        if (fullRewardExpressView == null) {
            return true;
        }
        return fullRewardExpressView.ws();
    }

    public ws qv() {
        FullRewardExpressView fullRewardExpressView = this.f28343g;
        if (fullRewardExpressView == null) {
            return null;
        }
        return fullRewardExpressView.getRenderResult();
    }

    public void r() {
        FullRewardExpressView fullRewardExpressView = this.f28343g;
        if (fullRewardExpressView != null) {
            fullRewardExpressView.jy();
        }
    }

    public void tl() {
        FullRewardExpressView fullRewardExpressView = this.f28343g;
        if (fullRewardExpressView != null) {
            fullRewardExpressView.i();
            this.f28343g.w();
        }
    }

    public void up() {
        FullRewardExpressView fullRewardExpressView = this.f28343g;
        if (fullRewardExpressView != null) {
            fullRewardExpressView.w();
        }
    }

    public FullRewardExpressView vl() {
        return this.f28343g;
    }

    public void xt(boolean z5) {
        this.cw = z5;
    }

    public up(TTBaseVideoActivity tTBaseVideoActivity) {
        this.up = tTBaseVideoActivity;
    }

    public void j(CharSequence charSequence, int i6, int i7, boolean z5) {
        if (this.f28343g == null || !m()) {
            return;
        }
        this.f28343g.j(charSequence, i6, i7, z5);
    }

    public FrameLayout j() {
        FullRewardExpressView fullRewardExpressView = this.f28343g;
        if (fullRewardExpressView != null) {
            return fullRewardExpressView.getVideoFrameLayout();
        }
        return null;
    }

    public void j(boolean z5) {
        this.xt = z5;
    }

    public void j(com.bytedance.sdk.openadsdk.core.nativeexpress.m mVar, com.bytedance.sdk.openadsdk.core.nativeexpress.up upVar) {
        n nVar;
        if (this.f28343g == null || (nVar = this.f28345m) == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.qv.xt.cw j6 = j(nVar);
        this.f28344j = j6;
        if (j6 != null) {
            j6.j();
            if (this.f28343g.getContext() != null && (this.f28343g.getContext() instanceof Activity)) {
                this.f28344j.j((Activity) this.f28343g.getContext());
            }
        }
        com.bytedance.sdk.openadsdk.core.jy.cw.j(this.f28345m);
        EmptyView j7 = j((ViewGroup) this.f28343g);
        if (j7 == null) {
            n nVar2 = this.f28345m;
            EmptyView emptyView = new EmptyView(this.up, this.f28343g, nVar2 != null ? nVar2.at() : 1000);
            emptyView.j(this.f28345m, this.ae);
            this.f28343g.addView(emptyView);
            j7 = emptyView;
        }
        j7.setNeedCheckingShow(false);
        j7.setCallback(new EmptyView.j() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.layout.up.1
            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.j
            public void j(View view, Map<String, Object> map) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.j
            public void j(boolean z5) {
                com.bytedance.sdk.openadsdk.core.qv.xt.cw cwVar = up.this.f28344j;
                if (cwVar == null || !z5) {
                    return;
                }
                cwVar.j();
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.j
            public void xt() {
                com.bytedance.sdk.openadsdk.core.qv.xt.cw cwVar = up.this.f28344j;
                if (cwVar != null) {
                    cwVar.xt();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.j
            public void j() {
                com.bytedance.sdk.openadsdk.core.qv.xt.cw cwVar = up.this.f28344j;
                if (cwVar != null) {
                    cwVar.j(false);
                }
            }
        });
        mVar.j(this.f28343g);
        ((com.bytedance.sdk.openadsdk.core.xt.j.j.j) mVar.j(com.bytedance.sdk.openadsdk.core.xt.j.j.j.class)).j(this.f28344j);
        this.f28343g.setClickListener(mVar);
        upVar.j(this.f28343g);
        ((com.bytedance.sdk.openadsdk.core.xt.j.j.j) upVar.j(com.bytedance.sdk.openadsdk.core.xt.j.j.j.class)).j(this.f28344j);
        this.f28343g.setClickCreativeListener(upVar);
        j7.setNeedCheckingShow(false);
        j(this.f28344j, this.f28343g);
    }

    private void j(com.bytedance.sdk.openadsdk.core.qv.xt.cw cwVar, NativeExpressView nativeExpressView) {
        final String str;
        if (cwVar == null || nativeExpressView == null) {
            return;
        }
        n nVar = this.f28345m;
        if (nVar != null) {
            str = nVar.fs();
        } else {
            str = "";
        }
        cwVar.j(new com.bytedance.sdk.openadsdk.core.qv.xt.j() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.layout.up.2
            @Override // com.bytedance.sdk.openadsdk.core.qv.xt.j
            public void j() {
                up.this.up.j("点击开始下载");
                j.C0431j.j(str, 1, 0);
            }

            @Override // com.bytedance.sdk.openadsdk.core.qv.xt.j
            public void cw(long j6, long j7, String str2, String str3) {
                up.this.up.j("下载失败");
                if (j6 > 0) {
                    j.C0431j.j(str, 4, (int) ((j7 * 100) / j6));
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.qv.xt.j
            public void xt(long j6, long j7, String str2, String str3) {
                up.this.up.j("下载暂停");
                if (j6 > 0) {
                    j.C0431j.j(str, 2, (int) ((j7 * 100) / j6));
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.qv.xt.j
            public void j(long j6, long j7, String str2, String str3) {
                if (j6 > 0) {
                    int i6 = (int) ((j7 * 100) / j6);
                    up.this.up.j("已下载" + i6 + "%");
                    j.C0431j.j(str, 3, i6);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.qv.xt.j
            public void j(long j6, String str2, String str3) {
                up.this.up.j("点击安装");
                j.C0431j.j(str, 5, 100);
            }

            @Override // com.bytedance.sdk.openadsdk.core.qv.xt.j
            public void j(String str2, String str3) {
                up.this.up.j("点击打开");
                j.C0431j.j(str, 6, 100);
            }
        });
    }

    private com.bytedance.sdk.openadsdk.core.qv.xt.cw j(n nVar) {
        if (nVar.jl() == 4) {
            return com.bytedance.sdk.openadsdk.core.qv.tl.j((Context) this.up, nVar, this.ae, false);
        }
        return null;
    }

    private EmptyView j(ViewGroup viewGroup) {
        for (int i6 = 0; i6 < viewGroup.getChildCount(); i6++) {
            View childAt = viewGroup.getChildAt(i6);
            if (childAt instanceof EmptyView) {
                return (EmptyView) childAt;
            }
        }
        return null;
    }

    public void j(qv qvVar) {
        FullRewardExpressView fullRewardExpressView = this.f28343g;
        if (fullRewardExpressView == null) {
            return;
        }
        fullRewardExpressView.setExpressVideoListenerProxy(qvVar);
    }

    public void j(com.bytedance.sdk.openadsdk.core.nativeexpress.j jVar) {
        FullRewardExpressView fullRewardExpressView = this.f28343g;
        if (fullRewardExpressView == null) {
            return;
        }
        fullRewardExpressView.setExpressInteractionListener(jVar);
    }

    public void j(com.bykv.vk.openvk.component.video.api.r.cw cwVar) {
        FullRewardExpressView fullRewardExpressView = this.f28343g;
        if (fullRewardExpressView != null) {
            fullRewardExpressView.setVideoController(cwVar);
        }
    }

    public void j(String str, JSONObject jSONObject) {
        rn jsObject;
        FullRewardExpressView fullRewardExpressView = this.f28343g;
        if (fullRewardExpressView == null || (jsObject = fullRewardExpressView.getJsObject()) == null || this.up.isFinishing()) {
            return;
        }
        jsObject.j(str, jSONObject);
    }

    public void j(j.InterfaceC0466j interfaceC0466j) {
        com.bytedance.sdk.openadsdk.core.qv.xt.cw cwVar = this.f28344j;
        if (cwVar != null) {
            cwVar.j(interfaceC0466j);
        }
    }

    public void j(com.bytedance.sdk.openadsdk.core.component.reward.up.cw cwVar) {
        if (this.f28343g != null) {
            this.f28343g.j((int) (cwVar.j() / 1000), cwVar.cw(), cwVar.r(), cwVar.m());
        }
    }
}
