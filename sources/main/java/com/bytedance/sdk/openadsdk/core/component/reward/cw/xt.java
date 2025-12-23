package com.bytedance.sdk.openadsdk.core.component.reward.cw;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.bytedance.adsdk.ugeno.cw.av;
import com.bytedance.adsdk.ugeno.cw.az;
import com.bytedance.adsdk.ugeno.cw.w;
import com.bytedance.adsdk.ugeno.up.m;
import com.bytedance.sdk.component.qv.j.xt;
import com.bytedance.sdk.openadsdk.core.rn.ed;
import com.bytedance.sdk.openadsdk.core.rn.uf;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.tj.qa;
import com.bytedance.sdk.openadsdk.core.ugeno.ae.up;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class xt {
    protected n ae;
    protected Map<String, Object> av;
    protected String az;

    /* renamed from: g, reason: collision with root package name */
    protected qa f28181g;
    protected j jy;
    protected az oq;
    protected String qv;
    protected Activity tl;
    protected String vl;
    protected AtomicBoolean ws;

    public static class j {
        private String cw;

        /* renamed from: j, reason: collision with root package name */
        private boolean f28189j;

        /* renamed from: r, reason: collision with root package name */
        private Dialog f28190r;
        private int xt;

        public j(boolean z5, int i6, String str, Dialog dialog) {
            this.f28189j = z5;
            this.xt = i6;
            this.cw = str;
            this.f28190r = dialog;
        }

        public boolean cw() {
            return this.f28189j;
        }

        public int j() {
            return this.xt;
        }

        public boolean r() {
            Dialog dialog = this.f28190r;
            if (dialog == null) {
                return false;
            }
            return dialog.isShowing();
        }

        public void up() {
            Dialog dialog = this.f28190r;
            if (dialog != null) {
                dialog.dismiss();
            }
        }

        public String xt() {
            return this.cw;
        }

        public j(boolean z5, int i6, String str) {
            this(z5, i6, str, null);
        }
    }

    public xt(Activity activity, n nVar) {
        this.jy = new j(false, 0, "");
        this.ws = new AtomicBoolean(false);
        this.tl = activity;
        this.ae = nVar;
    }

    public int ae() {
        return 0;
    }

    public void cw() {
    }

    public j j(oq oqVar) {
        return new j(false, 0, "");
    }

    public abstract String j();

    public boolean m() {
        return true;
    }

    public void r() {
    }

    public boolean xt() {
        return false;
    }

    public void cw(String str) {
        this.vl = str;
    }

    protected String g() {
        return !TextUtils.isEmpty(this.az) ? this.az : j();
    }

    public void j(Map<String, Object> map) {
        if (map == null) {
            return;
        }
        Map<String, Object> map2 = this.av;
        if (map2 == null) {
            this.av = map;
        } else {
            map2.putAll(map);
        }
    }

    public void r(String str) {
        this.qv = str;
    }

    public j xt(oq oqVar) {
        return new j(false, 0, "");
    }

    protected j cw(final oq oqVar) {
        if (!m()) {
            return new j(false, 0, "");
        }
        final com.bytedance.sdk.openadsdk.core.widget.m mVar = new com.bytedance.sdk.openadsdk.core.widget.m(this.tl);
        j(mVar);
        final FrameLayout frameLayout = new FrameLayout(this.tl);
        mVar.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.cw.xt.1
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                az azVar = xt.this.oq;
                if (azVar != null) {
                    azVar.j((w) null);
                }
            }
        });
        com.bytedance.sdk.openadsdk.core.ugeno.m.j jVar = new com.bytedance.sdk.openadsdk.core.ugeno.m.j();
        jVar.j(this.f28181g.r());
        jVar.xt(this.f28181g.up());
        jVar.cw(this.f28181g.r());
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        com.bytedance.sdk.openadsdk.core.ugeno.ae.up.j(jVar, new up.j() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.cw.xt.2
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.ae.up.j
            public void j(JSONObject jSONObject) {
                if (xt.this.ws.get()) {
                    return;
                }
                if (jSONObject == null) {
                    xt.this.jy = new j(false, 0, "");
                    countDownLatch.countDown();
                } else {
                    xt.this.j(mVar, frameLayout, oqVar, jSONObject);
                    xt xtVar = xt.this;
                    xtVar.jy = new j(true, xtVar.ae(), xt.this.f28181g.r(), mVar);
                    countDownLatch.countDown();
                }
            }
        });
        try {
            countDownLatch.await(500L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
        }
        this.ws.set(true);
        return this.jy;
    }

    protected void r(oq oqVar) {
        if (oqVar != null) {
            oqVar.j();
        }
    }

    protected float tl() {
        return 0.55f;
    }

    public void xt(String str) {
        this.az = str;
    }

    public void j(final com.bytedance.sdk.openadsdk.core.widget.m mVar, final ViewGroup viewGroup, final oq oqVar, final JSONObject jSONObject) {
        JSONObject jSONObject2;
        try {
            jSONObject2 = new JSONObject(g());
        } catch (JSONException unused) {
            jSONObject2 = new JSONObject();
        }
        final View j6 = j(jSONObject, jSONObject2, new w() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.cw.xt.3
            @Override // com.bytedance.adsdk.ugeno.cw.w
            public void j(com.bytedance.adsdk.ugeno.xt.cw cwVar, String str, m.j jVar) {
            }

            @Override // com.bytedance.adsdk.ugeno.cw.w
            public void j(av avVar, w.xt xtVar, w.j jVar) {
                JSONObject cw = avVar.cw();
                if (cw == null) {
                    return;
                }
                String optString = cw.optString("type");
                JSONObject optJSONObject = jSONObject.optJSONObject("event_template");
                boolean optBoolean = cw.optBoolean("uchain", false);
                if (optJSONObject != null && optBoolean && xt.this.ae != null) {
                    mVar.dismiss();
                    uf.a();
                    com.bytedance.sdk.component.qv.cw.xt.INSTANCE.j(optJSONObject);
                    HashMap hashMap = new HashMap();
                    hashMap.put("reward_dialog_callback", oqVar);
                    new xt.j(optString).j(xt.this.ae.tv()).j(hashMap).j().j();
                    return;
                }
                optString.getClass();
                if (!optString.equals("exit_watch")) {
                    if (optString.equals("continue_watch")) {
                        mVar.dismiss();
                        xt.this.r(oqVar);
                        return;
                    }
                    return;
                }
                mVar.dismiss();
                oq oqVar2 = oqVar;
                if (oqVar2 != null) {
                    oqVar2.xt();
                }
            }
        });
        if (j6 == null) {
            return;
        }
        this.tl.getWindow().getDecorView().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.cw.xt.4
            @Override // java.lang.Runnable
            public void run() {
                viewGroup.addView(j6);
                xt xtVar = xt.this;
                xtVar.j(mVar, j6, xtVar.tl());
                mVar.j(viewGroup);
                mVar.show();
            }
        });
    }

    public xt(Activity activity, n nVar, qa qaVar) {
        this(activity, nVar);
        this.f28181g = qaVar;
    }

    protected void j(com.bytedance.sdk.openadsdk.core.widget.m mVar) {
        mVar.getWindow().setBackgroundDrawable(new ColorDrawable(0));
    }

    public View j(JSONObject jSONObject, JSONObject jSONObject2, w wVar) {
        az azVar = new az(this.tl);
        this.oq = azVar;
        com.bytedance.adsdk.ugeno.xt.cw<View> j6 = azVar.j(jSONObject);
        this.oq.j(wVar);
        this.oq.xt(jSONObject2);
        if (j6 == null) {
            return null;
        }
        return j6.g();
    }

    public void j(Dialog dialog, View view, float f6) {
        if (dialog == null || view == null) {
            return;
        }
        if (this.ae.zw() == 1) {
            WindowManager.LayoutParams attributes = dialog.getWindow().getAttributes();
            attributes.y = ed.cw(this.tl, -20.0f);
            dialog.getWindow().setAttributes(attributes);
        }
        if (this.ae.zw() == 2) {
            view.setScaleX(f6);
            view.setScaleY(f6);
            view.setPivotY(0.0f);
            view.measure(0, 0);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, view.getMeasuredHeight());
            layoutParams.leftMargin = (int) (view.getMeasuredWidth() * (1.0f - f6));
            layoutParams.topMargin = (int) Math.max(((ed.up((Context) this.tl) - (view.getMeasuredHeight() * f6)) / 2.0f) - ed.qv((Context) this.tl), ed.qv((Context) this.tl));
            view.setLayoutParams(layoutParams);
        }
    }

    public void up() {
    }
}
