package com.bytedance.sdk.openadsdk.core.ugeno.cw;

import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import com.bytedance.adsdk.ugeno.cw.kt;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.core.jy.up;
import com.bytedance.sdk.openadsdk.core.rn.ed;
import com.bytedance.sdk.openadsdk.core.rn.tj;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.tj.oq;
import com.bytedance.sdk.openadsdk.core.v;
import org.json.JSONObject;
import xyz.adscope.amps.common.AMPSConstants;

/* loaded from: D:\Downloads\app\classes4.dex */
public class cw extends j implements kt {
    private float ae;

    /* renamed from: g, reason: collision with root package name */
    private float f30673g;

    /* renamed from: m, reason: collision with root package name */
    private boolean f30674m;
    private float oq;
    private long qv;
    private float tl;
    private com.bytedance.adsdk.ugeno.xt.cw vl;

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.cw.j
    protected void j(JSONObject jSONObject) {
        this.xt.j((kt) this);
        try {
            jSONObject.put("isPlayable", "true");
            jSONObject.put("remainTime", up());
        } catch (Exception e6) {
            vl.j(e6);
        }
    }

    private void m() {
        Animation animation;
        com.bytedance.adsdk.ugeno.xt.cw cwVar = this.vl;
        if (cwVar != null) {
            cwVar.xt(8);
            View g6 = this.vl.g();
            if (g6 == null || (animation = g6.getAnimation()) == null) {
                return;
            }
            animation.cancel();
        }
    }

    private int up() {
        return (int) ((tj.up(this.f30677j) * this.f30677j.nw()) / 100.0d);
    }

    public cw(Activity activity, ViewGroup viewGroup, up upVar, n nVar, String str, int i6, com.bytedance.sdk.openadsdk.core.multipro.xt.j jVar) {
        super(activity, viewGroup, upVar, nVar, str, i6, jVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.cw.j
    public void r() {
        super.r();
        m();
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.cw.j
    protected void j(com.bytedance.adsdk.ugeno.xt.cw<View> cwVar) {
        this.vl = cwVar.r("fl_count_down");
    }

    private void j(MotionEvent motionEvent) {
        if (!this.f30674m) {
            int tl = ed.tl(v.getContext());
            com.bytedance.sdk.openadsdk.core.jy.cw.j(AMPSConstants.FrequencyEventType.FREQUENCY_EVENT_TYPE_CLICK, this.f30677j, new oq.j().m(this.ae).up(this.tl).r(this.f30673g).cw(this.oq).xt(this.qv).j(motionEvent.getEventTime()).cw(motionEvent.getToolType(0)).r(motionEvent.getDeviceId()).up(this.up).xt(com.bytedance.sdk.openadsdk.core.oq.i().cw() ? 1 : 2).j(tl).j(ed.m(v.getContext())).xt(ed.ae(v.getContext())).j(), this.f30679r, true, null, -1, false);
        }
        this.f30674m = true;
    }

    @Override // com.bytedance.adsdk.ugeno.cw.kt
    public void j(com.bytedance.adsdk.ugeno.xt.cw cwVar, MotionEvent motionEvent) {
        if (motionEvent == null || this.f30674m) {
            return;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.qv = motionEvent.getDownTime();
            this.ae = motionEvent.getRawX();
            this.tl = motionEvent.getRawY();
            m();
            return;
        }
        if (action != 1) {
            return;
        }
        this.f30673g = motionEvent.getRawX();
        this.oq = motionEvent.getRawY();
        j(motionEvent);
    }
}
