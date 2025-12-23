package com.bytedance.sdk.openadsdk.oq.j;

import com.bytedance.sdk.component.j.i;
import com.bytedance.sdk.component.j.r;
import com.bytedance.sdk.openadsdk.core.rn;
import com.bytedance.sdk.openadsdk.core.tj.n;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class up extends com.bytedance.sdk.component.j.r<JSONObject, JSONObject> {

    /* renamed from: j, reason: collision with root package name */
    private WeakReference<rn> f31806j;

    public static void j(i iVar, final rn rnVar) {
        iVar.j("openPrivacy", new r.xt() { // from class: com.bytedance.sdk.openadsdk.oq.j.up.1
            @Override // com.bytedance.sdk.component.j.r.xt
            public com.bytedance.sdk.component.j.r j() {
                return new up(rn.this);
            }
        });
    }

    public up(rn rnVar) {
        this.f31806j = new WeakReference<>(rnVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.component.j.r
    public void j(JSONObject jSONObject, com.bytedance.sdk.component.j.m mVar) throws Exception {
        rn rnVar;
        n tl;
        WeakReference<rn> weakReference = this.f31806j;
        if (weakReference == null || (rnVar = weakReference.get()) == null || (tl = rnVar.tl()) == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.rn.m.j(mVar.getContext(), tl);
        rnVar.gq();
    }

    @Override // com.bytedance.sdk.component.j.r
    protected void r() {
    }
}
