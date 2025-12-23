package com.bytedance.sdk.openadsdk.core.ch;

import android.content.Context;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.openadsdk.ats.AutoService;
import com.bytedance.sdk.openadsdk.core.kt.ws;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class g {
    public abstract void j(int i6, tl tlVar);

    public void j(Context context) {
        cw cwVar;
        if (xt() && (cwVar = (cw) AutoService.j(cw.class)) != null && cwVar.cw()) {
            final JSONObject xt = xt(context);
            cwVar.j("common", xt, new com.bytedance.sdk.openadsdk.core.wq.r() { // from class: com.bytedance.sdk.openadsdk.core.ch.g.1
                @Override // com.bytedance.sdk.openadsdk.core.wq.r
                public <T> T applyFunction(int i6, PluginValueSet pluginValueSet, Class<T> cls) {
                    SparseArray sparseArray = (SparseArray) pluginValueSet.objectValue(-99999979, SparseArray.class);
                    ws.j();
                    ws.j((SparseArray<Object>) sparseArray, xt);
                    g.this.j(i6, new tl(sparseArray, i6));
                    return null;
                }
            });
        }
    }

    public abstract JSONObject xt(Context context);

    public abstract boolean xt();
}
