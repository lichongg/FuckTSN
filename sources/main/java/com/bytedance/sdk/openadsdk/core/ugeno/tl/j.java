package com.bytedance.sdk.openadsdk.core.ugeno.tl;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.widget.FrameLayout;
import com.bytedance.adsdk.ugeno.cw.av;
import com.bytedance.adsdk.ugeno.cw.az;
import com.bytedance.adsdk.ugeno.cw.kt;
import com.bytedance.adsdk.ugeno.cw.w;
import com.bytedance.adsdk.ugeno.cw.ws;
import com.bytedance.adsdk.ugeno.up.m;
import com.bytedance.adsdk.ugeno.xt.cw;
import com.bytedance.sdk.openadsdk.core.rn.v;
import com.bytedance.sdk.openadsdk.core.tj;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.tj.qv;
import com.bytedance.sdk.openadsdk.core.ugeno.ae;
import com.bytedance.sdk.openadsdk.core.ugeno.webview.PageWebView;
import com.bytedance.sdk.openadsdk.core.v.xt;
import com.bytedance.sdk.openadsdk.core.xt.xt;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j implements kt, w {
    private xt ae;
    private com.bytedance.sdk.openadsdk.core.ugeno.m.j cw;

    /* renamed from: g, reason: collision with root package name */
    private JSONObject f30786g;

    /* renamed from: j, reason: collision with root package name */
    private Context f30787j;

    /* renamed from: m, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.ugeno.r.j f30788m;
    private Map<String, Object> oq;

    /* renamed from: r, reason: collision with root package name */
    private n f30789r;
    private qv tl;
    private cw up;
    private ViewGroup xt;

    @Override // com.bytedance.adsdk.ugeno.cw.w
    public void j(cw cwVar, String str, m.j jVar) {
    }

    public void xt() {
        PageWebView.j(this.f30786g);
    }

    public j(Context context, ViewGroup viewGroup, com.bytedance.sdk.openadsdk.core.ugeno.m.j jVar, n nVar) {
        this.f30787j = context;
        this.xt = viewGroup;
        this.cw = jVar;
        this.f30789r = nVar;
    }

    public void j(com.bytedance.sdk.openadsdk.core.ugeno.r.j jVar) {
        this.f30788m = jVar;
    }

    public void j(DownloadListener downloadListener) {
        PageWebView.j(this.f30786g, downloadListener);
    }

    public void j() {
        com.bytedance.sdk.openadsdk.core.ugeno.m.j jVar = this.cw;
        if (jVar == null) {
            com.bytedance.sdk.openadsdk.core.ugeno.r.j jVar2 = this.f30788m;
            if (jVar2 != null) {
                jVar2.j(-1);
                return;
            }
            return;
        }
        JSONObject j6 = ae.j().j(jVar.j(), this.cw.xt());
        if (j6 == null) {
            com.bytedance.sdk.openadsdk.core.v.xt.j(this.cw, new xt.InterfaceC0490xt() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.tl.j.1
                @Override // com.bytedance.sdk.openadsdk.core.v.xt.InterfaceC0490xt
                public void j(JSONObject jSONObject) {
                    j.this.j(jSONObject);
                }

                @Override // com.bytedance.sdk.openadsdk.core.v.xt.InterfaceC0490xt
                public void j() {
                    if (j.this.f30788m != null) {
                        j.this.f30788m.j(-1);
                    }
                }
            });
        } else {
            j(j6);
        }
    }

    public void j(final JSONObject jSONObject) {
        final az azVar = new az(this.f30787j);
        final JSONObject tv2 = this.f30789r.tv();
        this.f30786g = tv2;
        ws wsVar = new ws();
        wsVar.j(this.f30787j);
        HashMap hashMap = new HashMap();
        hashMap.put("key_reward_page", this.oq);
        wsVar.j(hashMap);
        azVar.j("reward_page", wsVar);
        azVar.j((w) this);
        tj.m().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.tl.j.2
            @Override // java.lang.Runnable
            public void run() {
                j.this.up = azVar.j(jSONObject);
                if (j.this.up == null) {
                    if (j.this.f30788m != null) {
                        j.this.f30788m.j(-1);
                    }
                } else {
                    azVar.xt(tv2);
                    j.this.xt.addView(j.this.up.g(), new FrameLayout.LayoutParams(j.this.up.rn(), j.this.up.wq()));
                    if (j.this.f30788m != null) {
                        j.this.f30788m.j(j.this.up.g());
                    }
                }
            }
        });
    }

    @Override // com.bytedance.adsdk.ugeno.cw.w
    public void j(av avVar, w.xt xtVar, w.j jVar) {
        if (avVar != null && avVar.xt() == 1) {
            j(avVar, avVar.cw());
        }
    }

    private void j(av avVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("type");
        if (TextUtils.isEmpty(optString)) {
            return;
        }
        optString.getClass();
        if (!optString.equals("clickEvent")) {
            if (optString.equals("openPolicy")) {
                com.bytedance.sdk.openadsdk.core.rn.m.j(this.f30787j, this.f30789r);
            }
        } else {
            com.bytedance.sdk.openadsdk.core.xt.xt xtVar = this.ae;
            if (xtVar != null) {
                xtVar.j(avVar.j().g(), this.tl);
            }
        }
    }

    public void j(com.bytedance.sdk.openadsdk.core.xt.xt xtVar) {
        this.ae = xtVar;
    }

    @Override // com.bytedance.adsdk.ugeno.cw.kt
    public void j(cw cwVar, MotionEvent motionEvent) {
        this.tl.cw(motionEvent.getDeviceId());
        this.tl.xt(motionEvent.getToolType(0));
        this.tl.r(motionEvent.getSource());
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked == 1) {
                this.tl.cw(motionEvent.getRawX());
                this.tl.r(motionEvent.getRawY());
                this.tl.xt(System.currentTimeMillis());
                return;
            } else {
                if (actionMasked != 2) {
                    return;
                }
                this.tl.cw(motionEvent.getRawX());
                this.tl.r(motionEvent.getRawY());
                return;
            }
        }
        this.tl.up((int) motionEvent.getRawX());
        this.tl.m((int) motionEvent.getRawY());
        this.tl.j(motionEvent.getRawX());
        this.tl.xt(motionEvent.getRawY());
        this.tl.j(System.currentTimeMillis());
        this.tl.xt(motionEvent.getToolType(0));
        this.tl.cw(motionEvent.getDeviceId());
        this.tl.r(motionEvent.getSource());
        this.tl.j(true);
        v.j(motionEvent);
    }

    public void j(Map<String, Object> map) {
        this.oq = map;
    }
}
