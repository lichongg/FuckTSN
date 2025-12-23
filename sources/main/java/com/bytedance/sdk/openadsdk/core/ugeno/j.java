package com.bytedance.sdk.openadsdk.core.ugeno;

import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import com.bytedance.adsdk.ugeno.cw.az;
import com.bytedance.adsdk.ugeno.cw.w;
import com.bytedance.adsdk.ugeno.cw.ws;
import com.bytedance.adsdk.ugeno.up.m;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.openadsdk.core.rn;
import com.bytedance.sdk.openadsdk.core.rn.uf;
import com.bytedance.sdk.openadsdk.core.tj;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.widget.ae;
import com.tencent.open.SocialConstants;
import com.umeng.analytics.pro.bi;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j implements w, l.j, xt {
    private com.bytedance.sdk.openadsdk.core.ugeno.ae.ae ae;
    private ae.j cw;

    /* renamed from: j, reason: collision with root package name */
    private com.bytedance.adsdk.ugeno.xt.cw<View> f30750j;

    /* renamed from: r, reason: collision with root package name */
    private rn f30752r;
    private n up;
    private Context xt;
    private AtomicBoolean tl = new AtomicBoolean(false);

    /* renamed from: m, reason: collision with root package name */
    private final l f30751m = new l(Looper.getMainLooper(), this);

    /* JADX INFO: Access modifiers changed from: private */
    public void xt(JSONObject jSONObject, JSONObject jSONObject2, com.bytedance.sdk.openadsdk.core.ugeno.ae.ae aeVar) {
        this.ae = aeVar;
        az azVar = new az(this.xt);
        ws wsVar = new ws();
        wsVar.j(this.xt);
        HashMap hashMap = new HashMap();
        rn rnVar = new rn(this.xt);
        this.f30752r = rnVar;
        rnVar.j(this.cw);
        this.f30752r.j(this);
        this.f30752r.xt(j(jSONObject2));
        String xt = uf.xt(this.up);
        this.f30752r.cw(uf.xt(xt));
        this.f30752r.j(xt);
        hashMap.put("key_js_object", this.f30752r);
        hashMap.put("key_material", this.up);
        wsVar.xt(jSONObject2);
        wsVar.j(hashMap);
        azVar.j("easy_dl_dialog", wsVar);
        com.bytedance.adsdk.ugeno.xt.cw<View> j6 = azVar.j(jSONObject);
        this.f30750j = j6;
        if (j6 == null) {
            com.bytedance.sdk.openadsdk.core.ugeno.ae.ae aeVar2 = this.ae;
            if (aeVar2 != null) {
                aeVar2.j(-1, "UGenWidget is null");
                return;
            }
            return;
        }
        azVar.j(this);
        azVar.xt(jSONObject2);
        l lVar = this.f30751m;
        if (lVar != null) {
            lVar.sendEmptyMessageDelayed(1, 1000L);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.cw.w
    public void j(com.bytedance.adsdk.ugeno.xt.cw cwVar, String str, m.j jVar) {
    }

    public j(Context context, n nVar) {
        this.xt = context;
        this.up = nVar;
    }

    public void j(ae.j jVar) {
        this.cw = jVar;
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
            com.bytedance.sdk.openadsdk.core.widget.ae$j r3 = r1.cw
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
            com.bytedance.sdk.openadsdk.core.widget.ae$j r3 = r1.cw
            r3.r(r2)
            return
        L69:
            com.bytedance.sdk.openadsdk.core.widget.ae$j r3 = r1.cw
            r3.j(r2)
            return
        L6f:
            com.bytedance.sdk.openadsdk.core.widget.ae$j r3 = r1.cw
            r3.cw(r2)
            return
        L75:
            com.bytedance.sdk.openadsdk.core.widget.ae$j r2 = r1.cw
            r2.j()
            return
        L7b:
            com.bytedance.sdk.openadsdk.core.widget.ae$j r3 = r1.cw
            r3.xt(r2)
        L80:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.ugeno.j.j(com.bytedance.adsdk.ugeno.cw.av, com.bytedance.adsdk.ugeno.cw.w$xt, com.bytedance.adsdk.ugeno.cw.w$j):void");
    }

    public void j(final JSONObject jSONObject, final JSONObject jSONObject2, final com.bytedance.sdk.openadsdk.core.ugeno.ae.ae aeVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            xt(jSONObject, jSONObject2, aeVar);
        } else {
            tj.m().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.j.1
                @Override // java.lang.Runnable
                public void run() {
                    j.this.xt(jSONObject, jSONObject2, aeVar);
                }
            });
        }
    }

    private JSONObject j(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject("easy_dl_dialog")) == null) {
            return null;
        }
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject2.put("app_name", optJSONObject.opt("app_name"));
            jSONObject2.put("app_version", optJSONObject.opt("app_version"));
            jSONObject2.put("developer_name", optJSONObject.opt("developer_name"));
            jSONObject2.put(bi.f40972o, optJSONObject.opt(bi.f40972o));
            jSONObject2.put("score", optJSONObject.opt("score"));
            jSONObject2.put("icon_url", optJSONObject.opt("icon_url"));
            jSONObject2.put(SocialConstants.PARAM_COMMENT, optJSONObject.opt(SocialConstants.PARAM_COMMENT));
            jSONObject2.put("creative_tags", optJSONObject.opt("creative_tags"));
            jSONObject2.put("easy_pl_material", optJSONObject.opt("easy_pl_material"));
            jSONObject3.put("ugen_download_dialog", jSONObject2);
            return jSONObject3;
        } catch (JSONException e6) {
            throw new RuntimeException(e6);
        }
    }

    private void xt() {
        l lVar = this.f30751m;
        if (lVar == null) {
            return;
        }
        lVar.removeMessages(1);
    }

    @Override // com.bytedance.sdk.component.utils.l.j
    public void j(Message message) {
        if (message == null || message.what != 1 || this.tl.get()) {
            return;
        }
        if (this.ae != null) {
            this.tl.set(true);
            this.ae.j(10, "load time out");
        }
        xt();
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.xt
    public void j() {
        xt();
        if (this.tl.get() || this.ae == null) {
            return;
        }
        this.tl.set(true);
        this.ae.j(this.f30750j);
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.xt
    public void j(int i6, String str) {
        xt();
        if (this.tl.get() || this.ae == null) {
            return;
        }
        this.tl.set(true);
        this.ae.j(i6, str);
    }
}
