package com.bytedance.sdk.openadsdk.core.ugeno.cw;

import android.content.Context;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.adsdk.ugeno.cw.av;
import com.bytedance.adsdk.ugeno.cw.az;
import com.bytedance.adsdk.ugeno.cw.kt;
import com.bytedance.adsdk.ugeno.cw.w;
import com.bytedance.adsdk.ugeno.up.m;
import com.bytedance.sdk.openadsdk.core.jy.up;
import com.bytedance.sdk.openadsdk.core.tj;
import com.bytedance.sdk.openadsdk.core.ugeno.ae.ae;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt implements kt, w {
    private int ae;
    private com.bytedance.adsdk.ugeno.xt.cw<View> cw;

    /* renamed from: j, reason: collision with root package name */
    private Context f30688j;

    /* renamed from: m, reason: collision with root package name */
    private String f30689m;

    /* renamed from: r, reason: collision with root package name */
    private j f30690r;
    private kt up;
    private up xt;

    interface j {
        void j(av avVar);
    }

    @Override // com.bytedance.adsdk.ugeno.cw.w
    public void j(com.bytedance.adsdk.ugeno.xt.cw cwVar, String str, m.j jVar) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xt(JSONObject jSONObject, JSONObject jSONObject2, ae aeVar) {
        az azVar = new az(this.f30688j);
        com.bytedance.adsdk.ugeno.xt.cw<View> j6 = azVar.j(jSONObject);
        this.cw = j6;
        if (j6 == null) {
            up upVar = this.xt;
            if (upVar != null) {
                upVar.j(-1, "ugeno render fail");
            }
            if (aeVar != null) {
                aeVar.j(-1, "");
                return;
            }
            return;
        }
        azVar.j((kt) this);
        azVar.j((w) this);
        azVar.xt(jSONObject2);
        this.xt.j(0L);
        if (aeVar != null) {
            aeVar.j(this.cw);
        }
    }

    public xt(Context context, up upVar, String str, int i6) {
        this.f30688j = context;
        this.xt = upVar;
        this.f30689m = str;
        this.ae = i6;
    }

    public void j(j jVar) {
        this.f30690r = jVar;
    }

    public void j(kt ktVar) {
        this.up = ktVar;
    }

    public void j(final JSONObject jSONObject, final JSONObject jSONObject2, final ae aeVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            xt(jSONObject, jSONObject2, aeVar);
        } else {
            tj.m().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.cw.xt.1
                @Override // java.lang.Runnable
                public void run() {
                    xt.this.xt(jSONObject, jSONObject2, aeVar);
                }
            });
        }
    }

    @Override // com.bytedance.adsdk.ugeno.cw.w
    public void j(av avVar, w.xt xtVar, w.j jVar) {
        j jVar2;
        if (avVar == null || avVar.xt() != 1 || (jVar2 = this.f30690r) == null) {
            return;
        }
        jVar2.j(avVar);
    }

    @Override // com.bytedance.adsdk.ugeno.cw.kt
    public void j(com.bytedance.adsdk.ugeno.xt.cw cwVar, MotionEvent motionEvent) {
        kt ktVar = this.up;
        if (ktVar != null) {
            ktVar.j(cwVar, motionEvent);
        }
    }
}
