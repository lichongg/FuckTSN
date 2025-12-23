package com.bytedance.sdk.openadsdk.core.i.j;

import com.bytedance.sdk.openadsdk.core.tj.n;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class jy extends com.bytedance.sdk.component.j.up<JSONObject, JSONObject> {

    /* renamed from: j, reason: collision with root package name */
    private WeakReference<com.bytedance.sdk.openadsdk.core.rn> f29139j;
    private n xt;

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0030, code lost:
    
        r0 = r0.getRootWindowInsets();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private org.json.JSONObject cw() {
        /*
            r4 = this;
            java.lang.ref.WeakReference<com.bytedance.sdk.openadsdk.core.rn> r0 = r4.f29139j
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            java.lang.Object r0 = r0.get()
            com.bytedance.sdk.openadsdk.core.rn r0 = (com.bytedance.sdk.openadsdk.core.rn) r0
            if (r0 != 0) goto Lf
            return r1
        Lf:
            android.content.Context r0 = r0.getContext()
            if (r0 != 0) goto L16
            return r1
        L16:
            boolean r2 = r0 instanceof android.app.Activity
            if (r2 == 0) goto L6c
            android.app.Activity r0 = (android.app.Activity) r0
            android.view.Window r0 = r0.getWindow()
            if (r0 != 0) goto L23
            return r1
        L23:
            android.view.View r0 = r0.getDecorView()
            if (r0 != 0) goto L2a
            return r1
        L2a:
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 28
            if (r2 < r3) goto L6c
            android.view.WindowInsets r0 = com.bytedance.sdk.openadsdk.core.i.j.b.a(r0)
            if (r0 != 0) goto L37
            return r1
        L37:
            android.view.DisplayCutout r0 = androidx.core.view.x1.a(r0)
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch: org.json.JSONException -> L65
            r1.<init>()     // Catch: org.json.JSONException -> L65
            java.lang.String r2 = "top"
            int r3 = com.bytedance.sdk.openadsdk.core.i.j.c.a(r0)     // Catch: org.json.JSONException -> L65
            r1.put(r2, r3)     // Catch: org.json.JSONException -> L65
            java.lang.String r2 = "bottom"
            int r3 = com.bytedance.sdk.openadsdk.core.i.j.d.a(r0)     // Catch: org.json.JSONException -> L65
            r1.put(r2, r3)     // Catch: org.json.JSONException -> L65
            java.lang.String r2 = "left"
            int r3 = com.bytedance.sdk.openadsdk.core.i.j.e.a(r0)     // Catch: org.json.JSONException -> L65
            r1.put(r2, r3)     // Catch: org.json.JSONException -> L65
            java.lang.String r2 = "right"
            int r0 = com.bytedance.sdk.openadsdk.core.i.j.k.a(r0)     // Catch: org.json.JSONException -> L65
            r1.put(r2, r0)     // Catch: org.json.JSONException -> L65
            return r1
        L65:
            r0 = move-exception
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            r1.<init>(r0)
            throw r1
        L6c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.i.j.jy.cw():org.json.JSONObject");
    }

    public static void j(com.bytedance.sdk.component.j.i iVar, n nVar, com.bytedance.sdk.openadsdk.core.rn rnVar) {
        iVar.j("getDeviceInfo", (com.bytedance.sdk.component.j.up<?, ?>) new jy(rnVar, nVar));
    }

    public jy(com.bytedance.sdk.openadsdk.core.rn rnVar, n nVar) {
        this.f29139j = new WeakReference<>(rnVar);
        this.xt = nVar;
    }

    @Override // com.bytedance.sdk.component.j.up
    public JSONObject j(JSONObject jSONObject, com.bytedance.sdk.component.j.m mVar) throws Exception {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.putOpt("safeArea", cw());
        n nVar = this.xt;
        if (nVar != null) {
            jSONObject2.put("disableSafeArea", nVar.r());
        }
        return jSONObject2;
    }
}
