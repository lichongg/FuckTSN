package com.bytedance.sdk.openadsdk.core.component.reward.layout;

import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.bytedance.sdk.component.utils.kt;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.rn.ed;
import com.bytedance.sdk.openadsdk.core.tj.hl;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.tj.qv;
import com.bytedance.sdk.openadsdk.widget.RoundImageView;
import java.util.HashMap;

/* loaded from: D:\Downloads\app\classes4.dex */
public class tl extends xt {
    private TextView av;
    private TextView az;

    /* renamed from: f, reason: collision with root package name */
    private boolean f28340f;

    /* renamed from: i, reason: collision with root package name */
    private ImageView f28341i;
    private RoundImageView jy;
    private RelativeLayout kt;
    private TextView mi;
    private RelativeLayout tj;

    /* renamed from: w, reason: collision with root package name */
    private TextView f28342w;
    private RelativeLayout ws;

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.layout.xt
    public void j() {
        String valueOf;
        String valueOf2;
        super.j();
        this.tl = (RelativeLayout) this.xt.findViewById(2114387668);
        this.f28349g = (FrameLayout) this.xt.findViewById(2114387760);
        this.oq = (TextView) this.xt.findViewById(2114387664);
        this.jy = (RoundImageView) this.xt.findViewById(2114387888);
        this.ws = (RelativeLayout) this.xt.findViewById(2114387917);
        this.az = (TextView) this.xt.findViewById(2114387927);
        this.av = (TextView) this.xt.findViewById(2114387856);
        this.f28341i = (ImageView) this.xt.findViewById(2114387887);
        this.f28342w = (TextView) this.xt.findViewById(2114387787);
        this.mi = (TextView) this.xt.findViewById(2114387646);
        this.kt = (RelativeLayout) this.xt.findViewById(2114387669);
        this.tj = (RelativeLayout) this.xt.findViewById(2114387841);
        this.qv = (RelativeLayout) this.xt.findViewById(2114387723);
        ed.j(this.oq, this.cw);
        qv();
        if (com.bytedance.sdk.openadsdk.core.video.cw.j.j(this.cw)) {
            String g6 = com.bytedance.sdk.openadsdk.core.tj.ed.g(this.cw);
            if (TextUtils.isEmpty(g6) || this.jy == null) {
                ed.j((View) this.ws, 8);
            } else {
                ed.j((View) this.ws, 0);
                com.bytedance.sdk.openadsdk.g.xt.j(g6).j(this.jy);
            }
            if (this.az != null) {
                this.az.setText(com.bytedance.sdk.openadsdk.core.tj.ed.cw(this.cw));
            }
            if (this.av != null) {
                int r5 = com.bytedance.sdk.openadsdk.core.tj.ed.r(this.cw);
                if (r5 < 0) {
                    this.av.setVisibility(4);
                    ed.j((View) this.f28341i, 4);
                } else {
                    String j6 = kt.j(this.xt, "tt_live_fans_text");
                    if (r5 > 10000) {
                        valueOf2 = (r5 / 10000.0f) + IAdInterListener.AdReqParam.WIDTH;
                    } else {
                        valueOf2 = String.valueOf(r5);
                    }
                    this.av.setText(String.format(j6, valueOf2));
                }
            }
            if (this.f28342w != null) {
                int up = com.bytedance.sdk.openadsdk.core.tj.ed.up(this.cw);
                if (up < 0) {
                    this.f28342w.setVisibility(4);
                    ed.j((View) this.f28341i, 4);
                } else {
                    String j7 = kt.j(this.xt, "tt_live_watch_text");
                    if (up > 10000) {
                        valueOf = (up / 10000.0f) + IAdInterListener.AdReqParam.WIDTH;
                    } else {
                        valueOf = String.valueOf(up);
                    }
                    this.f28342w.setText(String.format(j7, valueOf));
                }
            }
            if (this.mi != null) {
                this.mi.setText(com.bytedance.sdk.openadsdk.core.tj.ed.m(this.cw));
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.layout.xt
    public void cw(int i6) {
        ed.j((View) this.kt, i6);
        ed.j((View) this.tj, i6);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.layout.xt
    public void r(int i6) {
        if (this.f28340f) {
            return;
        }
        ed.j((View) this.qv, i6);
    }

    public tl(TTBaseVideoActivity tTBaseVideoActivity, n nVar, boolean z5) {
        super(tTBaseVideoActivity, nVar, z5);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.layout.xt
    public void j(com.bytedance.sdk.openadsdk.core.xt.xt xtVar, com.bytedance.sdk.openadsdk.core.xt.xt xtVar2) {
        j(xtVar);
        j((View.OnTouchListener) xtVar);
    }

    private void j(View.OnTouchListener onTouchListener) {
        ed.j(this.tl, onTouchListener, "TTBaseVideoActivity#mRlDownloadBar");
        ed.j(this.f28349g, onTouchListener, "TTBaseVideoActivity#mVideoNativeFrame");
        ed.j(this.mi, onTouchListener, (String) null);
        ed.j(this.av, onTouchListener, (String) null);
        ed.j(this.f28342w, onTouchListener, (String) null);
        ed.j(this.az, onTouchListener, (String) null);
        ed.j(this.jy, onTouchListener, (String) null);
        ed.j(this.qv, onTouchListener, "TTBaseVideoActivity#mLiveBtnLayout");
    }

    private void j(com.bytedance.sdk.openadsdk.core.xt.xt xtVar) {
        j(this.f28349g, xtVar, "click_live_feed");
        j(this.mi, xtVar, "click_live_author_description");
        j(this.av, xtVar, "click_live_author_follower_count");
        j(this.f28342w, xtVar, "click_live_author_following_count");
        j(this.az, xtVar, "click_live_author_nickname");
        j(this.jy, xtVar, "click_live_avata");
        j(this.tl, xtVar, "click_live_button");
        j(this.qv, xtVar, "click_live_btn_layout");
    }

    private void j(View view, final com.bytedance.sdk.openadsdk.core.xt.xt xtVar, final String str) {
        if (view == null || xtVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        TTBaseVideoActivity tTBaseVideoActivity = this.xt;
        n nVar = this.cw;
        boolean z5 = this.f28351m;
        view.setOnClickListener(new com.bytedance.sdk.openadsdk.core.xt.xt(tTBaseVideoActivity, nVar, z5 ? "rewarded_video" : "fullscreen_interstitial_ad", z5 ? 7 : 5) { // from class: com.bytedance.sdk.openadsdk.core.component.reward.layout.tl.1
            @Override // com.bytedance.sdk.openadsdk.core.xt.xt, com.bytedance.sdk.openadsdk.core.xt.r
            public void j(View view2, qv qvVar) {
                HashMap hashMap = new HashMap();
                hashMap.put("click_live_element", str);
                ((com.bytedance.sdk.openadsdk.core.xt.j.cw.j) xtVar.j(com.bytedance.sdk.openadsdk.core.xt.j.cw.j.class)).j(hashMap);
                xtVar.j(view2, qvVar);
            }
        });
    }

    public void j(int i6, int i7) {
        TextView textView;
        if (i6 != 0) {
            this.f28340f = true;
            ed.j((View) this.qv, 8);
            return;
        }
        ed.j((View) this.qv, 0);
        if (i7 >= 0 && com.bytedance.sdk.openadsdk.core.live.xt.j().xt(this.cw) && hl.j(this.cw) && hl.up(this.cw) == 3 && (textView = (TextView) this.xt.findViewById(2114387722)) != null) {
            textView.setText(String.format(kt.j(this.xt, "tt_reward_auto_jump_live"), i7 + "s"));
        }
    }
}
