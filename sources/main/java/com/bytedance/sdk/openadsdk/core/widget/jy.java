package com.bytedance.sdk.openadsdk.core.widget;

import android.app.Activity;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.core.v;
import com.bytedance.sdk.openadsdk.core.widget.cw;
import com.tencent.open.SocialConstants;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class jy extends cw {
    private volatile boolean ae;
    Window cw;

    /* renamed from: m, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.ugeno.tl f31217m;

    /* renamed from: r, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.ugeno.ae.ae f31218r;
    private boolean tl;
    private JSONObject up;

    @Override // com.bytedance.sdk.openadsdk.core.widget.cw
    protected void xt() {
    }

    private void ae() {
        JSONObject jSONObject = this.up;
        if (jSONObject == null) {
            return;
        }
        j(jSONObject.optString("app_name"));
        up(this.up.optString("app_version"));
        m(this.up.optString("reg_number"));
        ae(this.up.optString("reg_url"));
        xt(this.up.optString("icon_url"));
        tl(this.up.optString("developer_name"));
        j(this.up.optInt("score"));
        j(this.up.optJSONArray("creative_tags"));
        r(this.up.optString(SocialConstants.PARAM_COMMENT));
    }

    private void m() {
        JSONObject jSONObject = this.up;
        if (jSONObject == null || this.f31218r == null) {
            return;
        }
        JSONObject xt = com.bytedance.sdk.openadsdk.core.ugeno.oq.xt(this.up.remove("ugen_md5").toString(), jSONObject.remove("ugen_url").toString());
        if (xt == null) {
            this.f31218r.j(11, "uegnTemplate is empty");
            this.ae = true;
        } else {
            final FrameLayout frameLayout = new FrameLayout(this.f31180j);
            frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.f31217m.j(xt, this.up, new com.bytedance.sdk.openadsdk.core.ugeno.ae.ae() { // from class: com.bytedance.sdk.openadsdk.core.widget.jy.1
                @Override // com.bytedance.sdk.openadsdk.core.ugeno.ae.ae
                public void j(int i6, String str) {
                    jy.this.ae = true;
                    if (jy.this.f31218r != null) {
                        FrameLayout frameLayout2 = frameLayout;
                        if (frameLayout2 != null) {
                            frameLayout2.removeAllViews();
                        }
                        jy.this.f31218r.j(i6, str);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.ugeno.ae.ae
                public void j(com.bytedance.adsdk.ugeno.xt.cw<View> cwVar) {
                    jy.this.ae = false;
                    if (jy.this.f31218r != null) {
                        jy.this.f31218r.j(null);
                    }
                    frameLayout.addView(cwVar.g(), new FrameLayout.LayoutParams(cwVar.rn(), cwVar.wq()));
                    jy.this.setContentView(frameLayout);
                }
            });
        }
    }

    private void up() {
        if (this.cw != null) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(-1);
            this.cw.setBackgroundDrawable(gradientDrawable);
            WindowManager.LayoutParams attributes = this.cw.getAttributes();
            attributes.alpha = 1.0f;
            this.cw.setAttributes(attributes);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.cw
    protected void cw() {
        if (this.tl) {
            super.cw();
        }
    }

    public void xt(cw.j jVar) {
        super.j(jVar);
        com.bytedance.sdk.openadsdk.core.ugeno.tl tlVar = this.f31217m;
        if (tlVar != null) {
            tlVar.j(jVar);
        }
    }

    public jy(Activity activity, JSONObject jSONObject, com.bytedance.sdk.openadsdk.core.ugeno.ae.ae aeVar) {
        super(activity);
        Window window;
        if (activity == null) {
            window = null;
        } else {
            window = activity.getWindow();
        }
        this.cw = window;
        this.up = jSONObject;
        this.f31218r = aeVar;
        this.f31217m = new com.bytedance.sdk.openadsdk.core.ugeno.tl(activity);
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.cw
    public void j() {
        if (this.f31180j == null) {
            this.f31180j = v.getContext();
        }
        if (this.f31180j.getResources().getConfiguration().orientation != 1) {
            this.tl = true;
            super.j();
            super.xt();
            ae();
            return;
        }
        up();
        m();
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.cw, android.app.AlertDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.cw, android.app.Dialog
    public void show() {
        super.show();
        if (this.ae) {
            hide();
            dismiss();
        }
    }
}
