package com.bytedance.sdk.openadsdk.core.component.reward.business.xt;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.oq.g;
import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.component.utils.kt;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
import com.bytedance.sdk.openadsdk.core.av;
import com.bytedance.sdk.openadsdk.core.component.reward.business.xt.j;
import com.bytedance.sdk.openadsdk.core.component.reward.cw.oq;
import com.bytedance.sdk.openadsdk.core.component.reward.j.up;
import com.bytedance.sdk.openadsdk.core.rn.ed;
import com.bytedance.sdk.openadsdk.core.rn.uf;
import com.bytedance.sdk.openadsdk.core.tj.rh;
import com.bytedance.sdk.openadsdk.core.v;
import com.bytedance.sdk.openadsdk.i.cw.xt.az;
import com.bytedance.sdk.openadsdk.tj.j.xt.j.ae;
import com.bytedance.sdk.openadsdk.widget.TTProgressBar;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt implements j {

    /* renamed from: j, reason: collision with root package name */
    private final j.InterfaceC0439j f28141j;

    /* renamed from: m, reason: collision with root package name */
    private int f28142m;
    private boolean tl;
    private com.bytedance.sdk.openadsdk.core.component.reward.business.xt.j.j xt;
    private final AtomicBoolean cw = new AtomicBoolean(false);

    /* renamed from: r, reason: collision with root package name */
    private final AtomicBoolean f28143r = new AtomicBoolean(false);
    private final AtomicBoolean up = new AtomicBoolean(false);
    private int ae = 0;

    /* renamed from: g, reason: collision with root package name */
    private boolean f28140g = true;
    private String oq = "";
    private String qv = "";
    private String vl = "";
    private String jy = "";
    private String ws = "";

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        try {
            this.cw.set(true);
            String r5 = rh.r(this.f28141j.j());
            if (TextUtils.isEmpty(r5)) {
                r5 = String.valueOf(this.f28142m);
            }
            if (TextUtils.isEmpty(r5)) {
                r5 = String.valueOf(uf.g(this.f28141j.j()));
            }
            up.j().j(com.bytedance.sdk.openadsdk.core.component.reward.j.j.xt.j().j(r5), rh.cw(this.f28141j.j()), this.ae, new com.bytedance.sdk.openadsdk.core.component.reward.j.cw(new ae(null) { // from class: com.bytedance.sdk.openadsdk.core.component.reward.business.xt.xt.3
                @Override // com.bytedance.sdk.openadsdk.tj.j.xt.j.ae
                public void j() {
                }

                @Override // com.bytedance.sdk.openadsdk.tj.j.xt.j.ae
                public void j(int i6, String str) {
                    com.bytedance.sdk.openadsdk.l.ae.j(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.business.xt.xt.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            xt.this.r("当前无新视频，请点击重试");
                            xt.this.cw.set(false);
                            if (xt.this.xt != null) {
                                xt.this.xt.up();
                            }
                            xt.this.f28141j.j(8, null);
                        }
                    });
                }

                @Override // com.bytedance.sdk.openadsdk.tj.j.xt.j.ae
                public void j(final az azVar) {
                    com.bytedance.sdk.openadsdk.l.ae.j(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.business.xt.xt.3.2
                        @Override // java.lang.Runnable
                        public void run() {
                            az azVar2 = azVar;
                            if (azVar2 instanceof com.bytedance.sdk.openadsdk.core.component.reward.cw) {
                                com.bytedance.sdk.openadsdk.core.component.reward.cw cwVar = (com.bytedance.sdk.openadsdk.core.component.reward.cw) azVar2;
                                cwVar.xt(true);
                                cwVar.j(xt.this.f28142m);
                                cwVar.xt(xt.this.ae + 1);
                                cwVar.cw(xt.this.f28141j.xt());
                                if (!TextUtils.isEmpty(xt.this.oq) && !TextUtils.isEmpty(xt.this.qv)) {
                                    cwVar.xt(xt.this.qv);
                                    cwVar.j(xt.this.oq);
                                }
                                cwVar.cw(xt.this.tl);
                                cwVar.j(xt.this.f28141j.getActivity());
                                xt.this.f28141j.up();
                                xt.this.f28143r.set(true);
                            } else {
                                xt.this.r("当前无新视频，请点击重试");
                                xt.this.cw.set(false);
                            }
                            xt.this.f28141j.j(8, null);
                        }
                    });
                }

                @Override // com.bytedance.sdk.openadsdk.tj.j.xt.j.ae
                public void xt(az azVar) {
                }
            }));
        } catch (Throwable unused) {
            this.cw.set(false);
            r("当前无新视频，请退出后重试");
        }
    }

    private boolean oq() {
        if (!rh.xt(this.f28141j.j())) {
            return false;
        }
        if (this.cw.get()) {
            return true;
        }
        oq oqVar = new oq() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.business.xt.xt.4
            @Override // com.bytedance.sdk.openadsdk.core.component.reward.cw.oq
            public void j() {
                if (xt.this.cw.get()) {
                    return;
                }
                if (xt.this.xt != null) {
                    xt.this.xt.r();
                }
                xt.this.g();
                com.bytedance.sdk.openadsdk.core.jy.cw.j(xt.this.f28141j.j(), "reward_endcard", "reward_again", "popup");
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.cw.oq
            public void xt() {
                if (xt.this.cw.get()) {
                    return;
                }
                com.bytedance.sdk.openadsdk.core.jy.cw.j(xt.this.f28141j.j(), "reward_endcard", "popup_cancel", (String) null);
                xt.this.f28141j.cw();
            }
        };
        com.bytedance.sdk.openadsdk.core.component.reward.business.xt.j.xt xtVar = new com.bytedance.sdk.openadsdk.core.component.reward.business.xt.j.xt(this.f28141j.getActivity(), this.f28141j.j());
        this.xt = xtVar;
        xtVar.r(this.oq);
        this.xt.cw(this.qv);
        this.xt.j(this.ws);
        this.f28141j.r();
        return this.xt.j(oqVar).cw();
    }

    private void qv() {
        com.bytedance.sdk.component.oq.ae.xt(new g("executeMultiProcessCallback") { // from class: com.bytedance.sdk.openadsdk.core.component.reward.business.xt.xt.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    av.j.j(com.bytedance.sdk.openadsdk.core.multipro.aidl.j.j(v.getContext()).j(5)).xt(rh.xt(xt.this.f28141j.xt()), "recycleRes", null);
                } catch (Throwable unused) {
                }
            }
        }, 5);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.xt.j
    public String ae() {
        return this.jy;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.xt.j
    public boolean cw(int i6) {
        j.InterfaceC0439j interfaceC0439j = this.f28141j;
        if (interfaceC0439j == null || interfaceC0439j.getActivity() == null || this.f28141j.j() == null || this.cw.get() || !this.f28140g) {
            return false;
        }
        if (i6 == 1) {
            j.InterfaceC0439j interfaceC0439j2 = this.f28141j;
            interfaceC0439j2.j(0, j(interfaceC0439j2.getActivity()));
            g();
            com.bytedance.sdk.openadsdk.core.jy.cw.j(this.f28141j.j(), "reward_endcard", "reward_again", "endcard");
        } else {
            if (i6 == 2) {
                return oq();
            }
            if (i6 == 3) {
                j.InterfaceC0439j interfaceC0439j3 = this.f28141j;
                interfaceC0439j3.j(0, j(interfaceC0439j3.getActivity()));
                g();
                com.bytedance.sdk.openadsdk.core.jy.cw.j(this.f28141j.j(), "reward_endcard", "reward_again", "videoplaying");
            }
        }
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.xt.j
    public String m() {
        return this.vl;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.xt.j
    public void r() {
        j.InterfaceC0439j interfaceC0439j = this.f28141j;
        if (interfaceC0439j == null || interfaceC0439j.getActivity() == null || this.f28141j.j() == null || !rh.j(this.f28141j.j())) {
            return;
        }
        if (!this.tl) {
            boolean z5 = this.ae == 0;
            this.f28141j.j(z5, null, null);
            this.f28140g = z5;
        } else {
            this.f28140g = false;
            this.f28141j.j(false, this.oq, this.qv);
            final int i6 = this.ae + 1;
            com.bytedance.sdk.component.oq.ae.xt(new g("executeMultiProcessCallback") { // from class: com.bytedance.sdk.openadsdk.core.component.reward.business.xt.xt.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        av j6 = av.j.j(com.bytedance.sdk.openadsdk.core.multipro.aidl.j.j(v.getContext()).j(5));
                        Bundle bundle = new Bundle();
                        bundle.putInt("callback_extra_key_next_play_again_count", i6);
                        xt.this.j(j6.xt(rh.xt(xt.this.f28141j.xt()), "getPlayAgainCondition", bundle));
                    } catch (Throwable unused) {
                    }
                }
            }, 5);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.xt.j
    public String tl() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("isPlayAgain", this.up.get());
            jSONObject.put("mSourceRitId", this.f28142m);
            jSONObject.put("mNowPlayAgainCount", this.ae);
            jSONObject.put("isCustomPlayAgain", this.tl);
            jSONObject.put("isCanPlayAgain", this.f28140g);
            jSONObject.put("mPlayAgainRewardName", this.oq);
            jSONObject.put("mPlayAgainRewardAmount", this.qv);
            jSONObject.put("mLastRewardName", this.vl);
            jSONObject.put("mLastRewardAmount", this.jy);
        } catch (Exception unused) {
        }
        return jSONObject.toString();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.xt.j
    public boolean up() {
        com.bytedance.sdk.openadsdk.core.component.reward.business.xt.j.j jVar = this.xt;
        if (jVar == null) {
            return false;
        }
        return jVar.xt();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.xt.j
    public void xt(boolean z5) {
        this.tl = z5;
    }

    public xt(j.InterfaceC0439j interfaceC0439j) {
        this.f28141j = interfaceC0439j;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.xt.j
    public void xt(int i6) {
        this.f28142m = i6;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.xt.j
    public void j(boolean z5) {
        this.up.set(z5);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.xt.j
    public boolean xt() {
        return this.f28143r.get();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.xt.j
    public void j(int i6) {
        this.ae = i6;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.xt.j
    public void xt(String str) {
        this.jy = str;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.xt.j
    public boolean j() {
        return this.up.get();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.xt.j
    public void j(String str) {
        this.vl = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(Bundle bundle) {
        boolean z5 = bundle.getBoolean(TTRewardVideoAd.RewardAdPlayAgainController.KEY_PLAY_AGAIN_ALLOW);
        this.oq = bundle.getString(TTRewardVideoAd.RewardAdPlayAgainController.KEY_PLAY_AGAIN_REWARD_NAME);
        this.qv = bundle.getString(TTRewardVideoAd.RewardAdPlayAgainController.KEY_PLAY_AGAIN_REWARD_AMOUNT);
        this.ws = bundle.getString("extra_info");
        this.f28140g = z5;
        if (z5) {
            com.bytedance.sdk.openadsdk.l.ae.j(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.business.xt.xt.2
                @Override // java.lang.Runnable
                public void run() {
                    xt.this.f28141j.j(true, xt.this.oq, xt.this.qv);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(final String str) {
        j.InterfaceC0439j interfaceC0439j = this.f28141j;
        if (interfaceC0439j == null || interfaceC0439j.getActivity() == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.l.ae.j(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.business.xt.xt.5
            @Override // java.lang.Runnable
            public void run() {
                a.j(xt.this.f28141j.getActivity(), str, 0);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.xt.j
    public void cw() {
        com.bytedance.sdk.openadsdk.core.component.reward.business.xt.j.j jVar = this.xt;
        if (jVar != null) {
            jVar.cw();
        }
        qv();
    }

    private TTProgressBar j(Context context) {
        TTProgressBar tTProgressBar = new TTProgressBar(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(240, 240);
        layoutParams.gravity = 17;
        tTProgressBar.setLayoutParams(layoutParams);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#77000000"));
        gradientDrawable.setCornerRadius(ed.cw(context, 2.0f));
        tTProgressBar.setBackground(gradientDrawable);
        int cw = ed.cw(context, 10.0f);
        tTProgressBar.setPadding(cw, cw, cw, cw);
        tTProgressBar.setIndeterminateDrawable(kt.cw(context, "tt_video_loading_progress_bar"));
        return tTProgressBar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.xt.j
    public void cw(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.up.set(jSONObject.getBoolean("isPlayAgain"));
            this.f28142m = jSONObject.optInt("mSourceRitId");
            this.ae = jSONObject.optInt("mNowPlayAgainCount");
            this.tl = jSONObject.optBoolean("isCustomPlayAgain");
            this.f28140g = jSONObject.optBoolean("isCanPlayAgain");
            this.oq = jSONObject.optString("mPlayAgainRewardName");
            this.qv = jSONObject.optString("mPlayAgainRewardAmount");
            this.vl = jSONObject.optString("mLastRewardName");
            this.qv = jSONObject.optString("mPlayAgainRewardAmount");
        } catch (Exception unused) {
        }
    }
}
