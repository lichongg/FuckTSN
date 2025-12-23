package com.bytedance.sdk.openadsdk.core.component.reward.cw;

import android.app.Activity;
import com.bytedance.sdk.openadsdk.core.component.reward.cw.xt;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.tj.qa;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class m extends j {

    /* renamed from: i, reason: collision with root package name */
    private int f28171i;

    /* renamed from: w, reason: collision with root package name */
    private int f28172w;

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.cw.xt
    public int ae() {
        return 3;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.cw.xt
    protected void j(com.bytedance.sdk.openadsdk.core.widget.m mVar) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.cw.xt
    public String j() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("alert_title", "恭喜获得加速特权");
            jSONObject.put("reduce_time", this.f28171i + "s");
        } catch (JSONException e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
        }
        return jSONObject.toString();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.cw.xt
    public boolean m() {
        int i6;
        qa qaVar = this.f28181g;
        return (qaVar == null || !qaVar.m()) && this.f28171i > 0 && (i6 = this.f28172w) > 0 && this.xt < i6;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.cw.xt
    protected void r(oq oqVar) {
        if (oqVar != null) {
            oqVar.j(this.f28171i);
        }
        this.f28181g.j(true);
        if (oqVar != null) {
            oqVar.j();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.cw.xt
    protected float tl() {
        return 0.75f;
    }

    m(Activity activity, n nVar, qa qaVar) {
        super(activity, nVar, qaVar);
        JSONObject xt;
        qa qaVar2 = this.f28181g;
        if (qaVar2 != null && (xt = qaVar2.xt()) != null) {
            this.f28171i = xt.optInt("reduce_time");
            this.f28172w = xt.optInt("reduce_duration");
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.cw.j, com.bytedance.sdk.openadsdk.core.component.reward.cw.xt
    public xt.j xt(oq oqVar) {
        return cw(oqVar);
    }
}
