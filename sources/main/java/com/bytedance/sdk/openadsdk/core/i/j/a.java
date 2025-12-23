package com.bytedance.sdk.openadsdk.core.i.j;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.sdk.component.j.r;
import com.bytedance.sdk.openadsdk.core.tj.n;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class a extends com.bytedance.sdk.component.j.r<JSONObject, JSONObject> {
    private com.bytedance.sdk.openadsdk.core.w.up cw;

    /* renamed from: j, reason: collision with root package name */
    private WeakReference<com.bytedance.sdk.openadsdk.core.rn> f29120j;

    /* renamed from: r, reason: collision with root package name */
    private long f29121r;
    private n xt;

    public a(com.bytedance.sdk.openadsdk.core.rn rnVar, n nVar) {
        this.f29120j = new WeakReference<>(rnVar);
        this.xt = nVar;
    }

    public static void j(com.bytedance.sdk.component.j.i iVar, final com.bytedance.sdk.openadsdk.core.rn rnVar, final n nVar) {
        iVar.j("requestVideoDelayCallback", new r.xt() { // from class: com.bytedance.sdk.openadsdk.core.i.j.a.1
            @Override // com.bytedance.sdk.component.j.r.xt
            public com.bytedance.sdk.component.j.r j() {
                return new a(com.bytedance.sdk.openadsdk.core.rn.this, nVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.component.j.r
    public void j(JSONObject jSONObject, com.bytedance.sdk.component.j.m mVar) throws Exception {
        com.bytedance.sdk.openadsdk.core.rn rnVar = this.f29120j.get();
        if (rnVar != null && jSONObject != null) {
            this.cw = new com.bytedance.sdk.openadsdk.core.w.up() { // from class: com.bytedance.sdk.openadsdk.core.i.j.a.2
                @Override // com.bytedance.sdk.openadsdk.core.w.up
                public void j() {
                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.i.j.a.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                a.this.j((a) new JSONObject());
                            } catch (Exception e6) {
                                com.bytedance.sdk.component.utils.vl.r("requestVideoDelay", e6.getMessage());
                            }
                        }
                    }, a.this.f29121r);
                }
            };
            int optInt = jSONObject.optInt("delay", -1);
            if (optInt < 0) {
                return;
            }
            this.f29121r = optInt;
            if (rnVar.cw() != null && rnVar.cw().E_()) {
                this.cw.j();
                return;
            } else {
                rnVar.j(this.cw);
                return;
            }
        }
        cw();
    }

    @Override // com.bytedance.sdk.component.j.r
    protected void r() {
    }
}
