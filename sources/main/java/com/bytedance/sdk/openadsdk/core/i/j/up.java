package com.bytedance.sdk.openadsdk.core.i.j;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class up extends com.bytedance.sdk.component.j.up<JSONObject, JSONObject> {

    /* renamed from: j, reason: collision with root package name */
    private WeakReference<com.bytedance.sdk.openadsdk.core.rn> f29161j;

    public static void j(com.bytedance.sdk.component.j.i iVar, com.bytedance.sdk.openadsdk.core.rn rnVar) {
        iVar.j("changePlaySpeedRatio", (com.bytedance.sdk.component.j.up<?, ?>) new up(rnVar));
    }

    public up(com.bytedance.sdk.openadsdk.core.rn rnVar) {
        this.f29161j = new WeakReference<>(rnVar);
    }

    @Override // com.bytedance.sdk.component.j.up
    @Nullable
    public JSONObject j(@NonNull JSONObject jSONObject, @NonNull com.bytedance.sdk.component.j.m mVar) throws Exception {
        WeakReference<com.bytedance.sdk.openadsdk.core.rn> weakReference = this.f29161j;
        if (weakReference != null && weakReference.get() != null) {
            float optDouble = (float) jSONObject.optDouble("ratio");
            if (optDouble > 0.0f && optDouble <= 3.0f) {
                this.f29161j.get().j(optDouble);
            }
            return new JSONObject();
        }
        return new JSONObject();
    }
}
