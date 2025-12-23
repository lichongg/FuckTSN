package com.bytedance.sdk.openadsdk.core.component.reward.top;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.GravityCompat;
import com.bytedance.sdk.component.utils.kt;
import com.bytedance.sdk.openadsdk.core.kt.ws;
import com.bytedance.sdk.openadsdk.core.rn.ed;
import com.bytedance.sdk.openadsdk.core.rn.uf;
import com.bytedance.sdk.openadsdk.core.tj.l;
import com.bytedance.sdk.openadsdk.core.tj.n;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class TopLayoutImpl extends FrameLayout implements j<TopLayoutImpl> {
    private View ae;
    private n av;
    private xt az;
    private View cw;

    /* renamed from: g, reason: collision with root package name */
    private TextView f28410g;

    /* renamed from: j, reason: collision with root package name */
    private View f28411j;
    private View jy;

    /* renamed from: m, reason: collision with root package name */
    private View f28412m;
    private View oq;
    private TextView qv;

    /* renamed from: r, reason: collision with root package name */
    private View f28413r;
    private View tl;
    private TextView up;
    private View vl;
    private boolean ws;
    private ImageView xt;

    public TopLayoutImpl(Context context) {
        this(context, null);
    }

    public TopLayoutImpl(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void r() {
        ed.j(this.f28411j, new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.top.TopLayoutImpl.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TopLayoutImpl.this.az != null) {
                    TopLayoutImpl.this.az.cw(view);
                }
            }
        }, "top_dislike_button");
        ed.j(this.xt, new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.top.TopLayoutImpl.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TopLayoutImpl.this.ws = !r0.ws;
                kt.j(TopLayoutImpl.this.getContext(), TopLayoutImpl.this.ws ? "tt_mute" : "tt_unmute", TopLayoutImpl.this.xt);
                if (TopLayoutImpl.this.az != null) {
                    TopLayoutImpl.this.az.xt(view);
                }
            }
        }, "top_mute_button");
        ed.j(this.ae, new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.top.TopLayoutImpl.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        }, "top_before_button");
        ed.j(this.oq, new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.top.TopLayoutImpl.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("topListener", TopLayoutImpl.this.az);
                    jSONObject.put("topImpl", 1);
                } catch (Throwable unused) {
                }
                if (!l.j(TopLayoutImpl.this.av) || com.bytedance.sdk.openadsdk.core.ws.r.j(String.valueOf(uf.g(TopLayoutImpl.this.av)))) {
                    ws.j().j(TopLayoutImpl.this.av, "stats_reward_full_click_native_close", jSONObject);
                }
                if (TopLayoutImpl.this.az != null) {
                    TopLayoutImpl.this.az.j(view);
                }
            }
        }, "top_skip_button");
        ed.j(this.cw, new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.top.TopLayoutImpl.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TopLayoutImpl.this.az != null) {
                    TopLayoutImpl.this.az.r(view);
                }
            }
        }, "top_back_button");
        ed.j(this.f28413r, new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.top.TopLayoutImpl.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TopLayoutImpl.this.az != null) {
                    TopLayoutImpl.this.az.up(view);
                }
            }
        }, "top_again_button");
        ed.j(this.f28412m, new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.top.TopLayoutImpl.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TopLayoutImpl.this.az != null) {
                    TopLayoutImpl.this.az.m(view);
                }
            }
        }, "top_skip_border");
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.j
    public void cw() {
        View view = this.f28411j;
        if (view != null) {
            view.performClick();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.j
    public View getCloseButton() {
        return this.oq;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.j
    public boolean getSkipOrCloseVisible() {
        return ed.r(this.oq) || (this.f28412m != null && ed.r(this.qv) && !TextUtils.isEmpty(this.qv.getText()));
    }

    public xt getTopListener() {
        return this.az;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.j
    public void setDislikeLeft(boolean z5) {
        if (this.f28411j.getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f28411j.getLayoutParams();
            layoutParams.gravity = z5 ? GravityCompat.START : GravityCompat.END;
            this.f28411j.setLayoutParams(layoutParams);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.j
    public void setListener(xt xtVar) {
        this.az = xtVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.j
    public void setPlayAgainEntranceText(String str) {
        ed.j(this.up, str);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.j
    public void setShowAgain(boolean z5) {
        ed.j(this.f28413r, z5 ? 0 : 8);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.j
    public void setShowBack(boolean z5) {
        View view = this.cw;
        if (view != null) {
            view.setVisibility(z5 ? 0 : 8);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.j
    public void setShowDislike(boolean z5) {
        View view = this.f28411j;
        if (view != null) {
            view.setVisibility(z5 ? 0 : 8);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.j
    public void setShowSound(boolean z5) {
        ImageView imageView = this.xt;
        if (imageView != null) {
            imageView.setVisibility(z5 ? 0 : 8);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.j
    public void setSoundMute(boolean z5) {
        this.ws = z5;
        kt.j(getContext(), this.ws ? "tt_mute" : "tt_unmute", this.xt);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.j
    public void setVisible(boolean z5) {
        setVisibility(z5 ? 0 : 8);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.j
    public void xt() {
        ImageView imageView = this.xt;
        if (imageView != null) {
            imageView.performClick();
        }
    }

    public TopLayoutImpl(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
    }

    public TopLayoutImpl j(n nVar) {
        this.av = nVar;
        if (com.bytedance.sdk.openadsdk.core.tj.kt.qv(nVar)) {
            addView(com.bytedance.sdk.openadsdk.res.up.ae(getContext()));
        } else {
            addView(com.bytedance.sdk.openadsdk.res.up.m(getContext()));
        }
        this.f28411j = findViewById(2114387851);
        this.xt = (ImageView) findViewById(2114387764);
        this.cw = findViewById(2114387825);
        this.f28413r = findViewById(2114387679);
        this.up = (TextView) findViewById(2114387638);
        this.f28412m = findViewById(2114387719);
        this.ae = findViewById(2114387951);
        this.tl = findViewById(2114387731);
        this.f28410g = (TextView) findViewById(2114387612);
        this.oq = findViewById(2114387641);
        this.qv = (TextView) findViewById(2114387791);
        this.vl = findViewById(2114387744);
        this.jy = findViewById(2114387930);
        View view = this.oq;
        if (view != null) {
            view.setEnabled(false);
            this.oq.setClickable(false);
        }
        r();
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.j
    public void j(boolean z5, String str, String str2, boolean z6, boolean z7) {
        ed.j(this.f28412m, 0);
        boolean z8 = z5 || !TextUtils.isEmpty(str);
        boolean z9 = z6 || !TextUtils.isEmpty(str2);
        boolean z10 = z8 && z9;
        ed.j(this.f28412m, (z8 || z9) ? 0 : 4);
        ed.j(this.ae, z8 ? 0 : 8);
        ed.j(this.oq, z9 ? 0 : 8);
        ed.j(this.jy, z10 ? 0 : 8);
        ed.j(this.tl, z5 ? 0 : 8);
        ed.j((View) this.f28410g, !TextUtils.isEmpty(str) ? 0 : 8);
        ed.j(this.vl, z6 ? 0 : 8);
        ed.j((View) this.qv, TextUtils.isEmpty(str2) ? 8 : 0);
        if (!TextUtils.isEmpty(str)) {
            ed.j(this.f28410g, str);
        }
        if (!TextUtils.isEmpty(str2)) {
            ed.j(this.qv, str2);
        }
        View view = this.oq;
        if (view != null) {
            view.setEnabled(z7);
            this.oq.setClickable(z7);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.j
    public void j() {
        View view = this.oq;
        if (view != null) {
            view.performClick();
        }
    }
}
