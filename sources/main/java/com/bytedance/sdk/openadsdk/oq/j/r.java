package com.bytedance.sdk.openadsdk.oq.j;

import com.bytedance.sdk.component.j.i;
import com.bytedance.sdk.component.j.r;
import com.bytedance.sdk.openadsdk.core.oq;
import com.bytedance.sdk.openadsdk.core.rn;
import com.bytedance.sdk.openadsdk.core.tj.n;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class r extends com.bytedance.sdk.component.j.r<JSONObject, JSONObject> {

    /* renamed from: j, reason: collision with root package name */
    private WeakReference<rn> f31804j;

    public static void j(i iVar, final rn rnVar) {
        iVar.j("adInfoDialog", new r.xt() { // from class: com.bytedance.sdk.openadsdk.oq.j.r.1
            @Override // com.bytedance.sdk.component.j.r.xt
            public com.bytedance.sdk.component.j.r j() {
                return new r(rn.this);
            }
        });
    }

    public r(rn rnVar) {
        this.f31804j = new WeakReference<>(rnVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.component.j.r
    public void j(JSONObject jSONObject, com.bytedance.sdk.component.j.m mVar) throws Exception {
        n tl;
        oq.i().z();
        rn rnVar = this.f31804j.get();
        if (rnVar == null || (tl = rnVar.tl()) == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.rn.m.j(mVar.getContext(), tl.fj());
    }

    @Override // com.bytedance.sdk.component.j.r
    protected void r() {
    }
}
