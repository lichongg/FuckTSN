package com.bytedance.sdk.openadsdk.core.ugeno;

import android.content.Context;
import android.os.Looper;
import android.view.View;
import com.bytedance.adsdk.ugeno.cw.az;
import com.bytedance.adsdk.ugeno.cw.w;
import com.bytedance.adsdk.ugeno.cw.ws;
import com.bytedance.adsdk.ugeno.up.m;
import com.bytedance.sdk.openadsdk.core.tj;
import com.bytedance.sdk.openadsdk.core.widget.cw;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class tl implements w {
    private cw.j cw;

    /* renamed from: j, reason: collision with root package name */
    private Context f30783j;
    private com.bytedance.adsdk.ugeno.xt.cw<View> xt;

    @Override // com.bytedance.adsdk.ugeno.cw.w
    public void j(com.bytedance.adsdk.ugeno.xt.cw cwVar, String str, m.j jVar) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xt(JSONObject jSONObject, JSONObject jSONObject2, com.bytedance.sdk.openadsdk.core.ugeno.ae.ae aeVar) {
        az azVar = new az(this.f30783j);
        ws wsVar = new ws();
        wsVar.j(this.f30783j);
        azVar.j("ugen_download_dialog", wsVar);
        com.bytedance.adsdk.ugeno.xt.cw<View> j6 = azVar.j(jSONObject);
        this.xt = j6;
        if (j6 != null) {
            azVar.j(this);
            azVar.xt(jSONObject2);
        }
        if (aeVar == null) {
            return;
        }
        com.bytedance.adsdk.ugeno.xt.cw<View> cwVar = this.xt;
        if (cwVar == null) {
            aeVar.j(-1, "UGenWidget is null");
        } else {
            aeVar.j(cwVar);
        }
    }

    public tl(Context context) {
        this.f30783j = context;
    }

    public void j(cw.j jVar) {
        this.cw = jVar;
    }

    public void j(final JSONObject jSONObject, final JSONObject jSONObject2, final com.bytedance.sdk.openadsdk.core.ugeno.ae.ae aeVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            xt(jSONObject, jSONObject2, aeVar);
        } else {
            tj.m().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.tl.1
                @Override // java.lang.Runnable
                public void run() {
                    tl.this.xt(jSONObject, jSONObject2, aeVar);
                }
            });
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0051, code lost:
    
        if (r2.equals("openAppFunctionDesc") == false) goto L13;
     */
    @Override // com.bytedance.adsdk.ugeno.cw.w
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void j(com.bytedance.adsdk.ugeno.cw.av r2, com.bytedance.adsdk.ugeno.cw.w.xt r3, com.bytedance.adsdk.ugeno.cw.w.j r4) {
        /*
            r1 = this;
            if (r2 == 0) goto L80
            com.bytedance.sdk.openadsdk.core.widget.cw$j r3 = r1.cw
            if (r3 != 0) goto L8
            goto L80
        L8:
            int r3 = r2.xt()
            r4 = 1
            if (r3 != r4) goto L80
            org.json.JSONObject r2 = r2.cw()
            if (r2 != 0) goto L17
            goto L80
        L17:
            java.lang.String r3 = "type"
            java.lang.String r2 = r2.optString(r3)
            r2.getClass()
            int r3 = r2.hashCode()
            r0 = -1
            switch(r3) {
                case -1822902106: goto L54;
                case -459025504: goto L4b;
                case -267096736: goto L40;
                case 7917298: goto L35;
                case 1237425033: goto L2a;
                default: goto L28;
            }
        L28:
            r4 = -1
            goto L5e
        L2a:
            java.lang.String r3 = "openAppPolicy"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L33
            goto L28
        L33:
            r4 = 4
            goto L5e
        L35:
            java.lang.String r3 = "downloadEvent"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L3e
            goto L28
        L3e:
            r4 = 3
            goto L5e
        L40:
            java.lang.String r3 = "closeDialog"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L49
            goto L28
        L49:
            r4 = 2
            goto L5e
        L4b:
            java.lang.String r3 = "openAppFunctionDesc"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L5e
            goto L28
        L54:
            java.lang.String r3 = "openAppPermission"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L5d
            goto L28
        L5d:
            r4 = 0
        L5e:
            r2 = 0
            switch(r4) {
                case 0: goto L7b;
                case 1: goto L75;
                case 2: goto L6f;
                case 3: goto L69;
                case 4: goto L63;
                default: goto L62;
            }
        L62:
            goto L80
        L63:
            com.bytedance.sdk.openadsdk.core.widget.cw$j r3 = r1.cw
            r3.r(r2)
            return
        L69:
            com.bytedance.sdk.openadsdk.core.widget.cw$j r3 = r1.cw
            r3.j(r2)
            return
        L6f:
            com.bytedance.sdk.openadsdk.core.widget.cw$j r3 = r1.cw
            r3.cw(r2)
            return
        L75:
            com.bytedance.sdk.openadsdk.core.widget.cw$j r3 = r1.cw
            r3.up(r2)
            return
        L7b:
            com.bytedance.sdk.openadsdk.core.widget.cw$j r3 = r1.cw
            r3.xt(r2)
        L80:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.ugeno.tl.j(com.bytedance.adsdk.ugeno.cw.av, com.bytedance.adsdk.ugeno.cw.w$xt, com.bytedance.adsdk.ugeno.cw.w$j):void");
    }
}
