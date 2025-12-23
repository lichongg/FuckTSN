package com.bytedance.sdk.openadsdk.core.widget;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.utils.kt;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.widget.ae;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class tl extends AlertDialog {
    private com.bytedance.sdk.openadsdk.core.ugeno.ae.ae ae;
    private Context cw;

    /* renamed from: j, reason: collision with root package name */
    private JSONObject f31248j;

    /* renamed from: m, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.ugeno.j f31249m;

    /* renamed from: r, reason: collision with root package name */
    private ae.j f31250r;
    private boolean tl;
    private String up;
    private JSONObject xt;

    public tl(String str, Context context, JSONObject jSONObject, JSONObject jSONObject2, com.bytedance.sdk.openadsdk.core.ugeno.ae.ae aeVar, n nVar) {
        super(context, kt.tl(context, "tt_dialog_full"));
        this.ae = aeVar;
        this.cw = context;
        this.f31248j = jSONObject;
        this.up = str;
        this.xt = jSONObject2;
        this.f31249m = new com.bytedance.sdk.openadsdk.core.ugeno.j(context, nVar);
    }

    private void xt() {
        if (this.f31248j == null || this.xt == null || this.f31249m == null) {
            return;
        }
        this.tl = false;
        final FrameLayout frameLayout = new FrameLayout(this.cw);
        this.f31249m.j(this.f31248j, this.xt, new com.bytedance.sdk.openadsdk.core.ugeno.ae.ae() { // from class: com.bytedance.sdk.openadsdk.core.widget.tl.1
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.ae.ae
            public void j(int i6, String str) {
                tl.this.tl = true;
                if (tl.this.ae != null) {
                    FrameLayout frameLayout2 = frameLayout;
                    if (frameLayout2 != null) {
                        frameLayout2.removeAllViews();
                    }
                    tl.this.ae.j(i6, str);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.ae.ae
            public void j(com.bytedance.adsdk.ugeno.xt.cw<View> cwVar) {
                tl.this.tl = false;
                if (tl.this.ae != null) {
                    tl.this.ae.j(null);
                }
                frameLayout.addView(cwVar.g(), new FrameLayout.LayoutParams(cwVar.rn(), cwVar.wq()));
                tl.this.setContentView(frameLayout);
            }
        });
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        ae.j jVar = this.f31250r;
        if (jVar != null) {
            jVar.cw(this);
        }
    }

    public String j() {
        return this.up;
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        xt();
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        if (this.tl) {
            hide();
            dismiss();
        }
    }

    public void j(ae.j jVar) {
        this.f31250r = jVar;
        com.bytedance.sdk.openadsdk.core.ugeno.j jVar2 = this.f31249m;
        if (jVar2 != null) {
            jVar2.j(jVar);
        }
    }

    public void j(com.bytedance.sdk.openadsdk.core.ugeno.ae.ae aeVar) {
        this.ae = aeVar;
    }
}
