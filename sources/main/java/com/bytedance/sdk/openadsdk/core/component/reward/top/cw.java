package com.bytedance.sdk.openadsdk.core.component.reward.top;

import android.view.View;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.kt.ws;
import com.bytedance.sdk.openadsdk.core.tj.e;
import com.bytedance.sdk.openadsdk.core.tj.kt;
import com.bytedance.sdk.openadsdk.core.tj.n;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class cw implements xt {
    protected com.bytedance.sdk.openadsdk.core.component.reward.xt.xt cw;

    /* renamed from: j, reason: collision with root package name */
    protected boolean f28421j;

    /* renamed from: m, reason: collision with root package name */
    protected int f28422m = 0;

    /* renamed from: r, reason: collision with root package name */
    protected com.bytedance.sdk.openadsdk.core.component.reward.xt.up f28423r;
    protected TTBaseVideoActivity up;
    protected n xt;

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.xt
    public void cw(View view) {
        j(1);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.xt
    public void j(View view) {
        j(2);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.xt
    public void m(View view) {
        j(6);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.xt
    public void r(View view) {
        j(4);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.xt
    public void up(View view) {
        j(5);
        this.up.tl(3);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.xt
    public void xt(View view) {
        j(3);
    }

    protected boolean j() {
        if (kt.qv(this.xt) || e.xt() <= 0) {
            return false;
        }
        int i6 = this.f28422m;
        this.f28422m = i6 + 1;
        if (i6 < e.xt()) {
            return false;
        }
        ws.j().j(this.xt, "stats_reward_full_close_force", this.up.b().j(new JSONObject()));
        this.up.finish();
        return true;
    }

    public cw(TTBaseVideoActivity tTBaseVideoActivity, n nVar, com.bytedance.sdk.openadsdk.core.component.reward.xt.xt xtVar, com.bytedance.sdk.openadsdk.core.component.reward.xt.up upVar, boolean z5) {
        this.up = tTBaseVideoActivity;
        this.xt = nVar;
        this.cw = xtVar;
        this.f28423r = upVar;
        this.f28421j = z5;
    }

    protected void j(int i6) {
        this.up.sm();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("topImpl", getClass().getName());
            jSONObject.put("topType", i6);
        } catch (Throwable unused) {
        }
        ws.j().j(this.xt, "stats_reward_full_top_handle", jSONObject);
    }
}
