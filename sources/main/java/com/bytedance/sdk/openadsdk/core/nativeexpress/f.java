package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.core.rn.ed;
import com.bytedance.sdk.openadsdk.core.rn.uf;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.tj.ya;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class f {
    private boolean ae = true;
    private List<com.bytedance.sdk.openadsdk.core.tj.av> cw;

    /* renamed from: g, reason: collision with root package name */
    private NativeExpressView f29647g;

    /* renamed from: j, reason: collision with root package name */
    private double f29648j;

    /* renamed from: m, reason: collision with root package name */
    private List<com.bytedance.adsdk.ugeno.xt.cw<View>> f29649m;

    /* renamed from: r, reason: collision with root package name */
    private int f29650r;
    private int tl;
    private String up;
    private int xt;

    public void j(NativeExpressView nativeExpressView) {
        if (this.cw != null) {
            Context context = nativeExpressView.getContext();
            for (com.bytedance.sdk.openadsdk.core.tj.av avVar : this.cw) {
                View siteGestureView = new SiteGestureView(context, new ya(this.f29650r, this.f29648j, this.xt, this.tl), this);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(ed.cw(context, (float) avVar.cw), ed.cw(context, (float) avVar.f30222r));
                layoutParams.leftMargin = ed.cw(context, (float) avVar.f30221j);
                layoutParams.topMargin = ed.cw(context, (float) avVar.xt);
                try {
                    if (!TextUtils.isEmpty(this.up) && com.bytedance.sdk.component.utils.vl.cw()) {
                        siteGestureView.setBackgroundColor(Color.parseColor(this.up));
                    }
                } catch (Exception e6) {
                    com.bytedance.sdk.component.utils.vl.j(e6);
                }
                nativeExpressView.addView(siteGestureView, layoutParams);
                com.bytedance.sdk.component.utils.vl.j("xdy", "(" + avVar.f30221j + "," + avVar.xt + "," + avVar.cw + "," + avVar.f30222r + ")");
            }
        }
    }

    public void r() {
        this.ae = false;
    }

    public boolean cw() {
        return this.ae;
    }

    public void xt() {
        this.f29647g.kt();
    }

    public f(n nVar, JSONObject jSONObject, NativeExpressView nativeExpressView) {
        com.bytedance.sdk.openadsdk.core.tj.av j6;
        this.f29650r = -1;
        this.tl = -1;
        this.f29647g = nativeExpressView;
        this.tl = uf.j(nVar);
        if (jSONObject != null) {
            this.f29648j = jSONObject.optDouble("slide_threshold", 0.0d);
            this.xt = jSONObject.optInt("direction", 30);
            this.f29650r = jSONObject.optInt("type", -1);
            this.up = jSONObject.optString("rgb_color");
            JSONArray optJSONArray = jSONObject.optJSONArray("rects");
            if (optJSONArray != null) {
                this.cw = new ArrayList();
                for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i6);
                    if (optJSONObject != null && (j6 = com.bytedance.sdk.openadsdk.core.tj.av.j(optJSONObject)) != null) {
                        this.cw.add(j6);
                    }
                }
            }
        }
        List<com.bytedance.sdk.openadsdk.core.tj.av> list = this.cw;
        com.bytedance.sdk.component.utils.vl.j("xdy", "priority:" + this.tl + " dirction:" + this.xt + " type:" + this.f29650r + " hold:" + this.f29648j + " size:" + (list != null ? list.size() : 0));
    }

    public boolean j() {
        View g6;
        List<com.bytedance.adsdk.ugeno.xt.cw<View>> list = this.f29649m;
        if (list == null || list.size() == 0) {
            return false;
        }
        for (com.bytedance.adsdk.ugeno.xt.cw<View> cwVar : this.f29649m) {
            if (cwVar != null && (g6 = cwVar.g()) != null && g6.getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    public void j(List<com.bytedance.adsdk.ugeno.xt.cw<View>> list) {
        this.f29649m = list;
    }

    public void j(MotionEvent motionEvent) {
        this.f29647g.j(motionEvent);
    }

    public void j(View view, int i6, com.bytedance.sdk.component.adexpress.cw cwVar, ya yaVar) {
        NativeExpressView nativeExpressView = this.f29647g;
        if (nativeExpressView != null) {
            nativeExpressView.j(view, i6, cwVar, yaVar);
        }
    }
}
