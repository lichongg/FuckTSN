package com.bytedance.sdk.openadsdk.oq.j;

import com.bytedance.sdk.component.j.i;
import com.bytedance.sdk.component.j.r;
import com.bytedance.sdk.openadsdk.core.rn;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public final class xt extends com.bytedance.sdk.component.j.r<JSONObject, JSONObject> {

    /* renamed from: j, reason: collision with root package name */
    private static WeakReference<j> f31808j;
    private WeakReference<rn> xt;

    public interface j {
        void j();

        void j(int i6);
    }

    private xt(rn rnVar) {
        this.xt = new WeakReference<>(rnVar);
    }

    public static void j(i iVar, final rn rnVar) {
        iVar.j("onClickBrowseCloseCallback", new r.xt() { // from class: com.bytedance.sdk.openadsdk.oq.j.xt.1
            @Override // com.bytedance.sdk.component.j.r.xt
            public com.bytedance.sdk.component.j.r j() {
                return new xt(rn.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.component.j.r
    public void j(JSONObject jSONObject, com.bytedance.sdk.component.j.m mVar) throws Exception {
        WeakReference<j> weakReference = f31808j;
        j jVar = weakReference != null ? weakReference.get() : null;
        if (this.xt == null || jSONObject == null) {
            if (jVar != null) {
                jVar.j();
                return;
            }
            return;
        }
        int optInt = jSONObject.optInt("remainTime", Integer.MIN_VALUE);
        if (optInt == Integer.MIN_VALUE) {
            if (jVar != null) {
                jVar.j();
            }
        } else if (jVar != null) {
            jVar.j(optInt);
        }
    }

    public static void j(j jVar) {
        f31808j = new WeakReference<>(jVar);
    }

    @Override // com.bytedance.sdk.component.j.r
    protected void r() {
    }
}
