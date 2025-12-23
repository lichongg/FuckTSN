package com.bytedance.sdk.openadsdk.core.ch;

import android.util.SparseArray;
import com.bykv.j.j.j.j.e;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.openadsdk.core.kt;
import com.bytedance.sdk.openadsdk.core.rn.uf;
import com.bytedance.sdk.openadsdk.core.v;
import java.util.UUID;
import java.util.function.LongSupplier;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class ae extends com.bytedance.sdk.openadsdk.core.wq.r implements LongSupplier {
    protected PluginValueSet j(int i6, r rVar) {
        return null;
    }

    protected PluginValueSet xt(int i6, SparseArray<Object> sparseArray) {
        return null;
    }

    protected PluginValueSet j(int i6, tl tlVar) {
        return null;
    }

    public PluginValueSet xt(int i6) {
        return e.a().g(32, String.valueOf(uf.up())).k();
    }

    @Override // com.bytedance.sdk.openadsdk.core.wq.r
    public <T> T applyFunction(int i6, PluginValueSet pluginValueSet, Class<T> cls) {
        j(i6, (SparseArray<Object>) pluginValueSet.objectValue(-99999979, SparseArray.class));
        return null;
    }

    public PluginValueSet cw(int i6, SparseArray<Object> sparseArray) {
        JSONObject rr = v.xt().rr();
        if (rr != null) {
            return e.a().f(33, rr).k();
        }
        return null;
    }

    @Override // java.util.function.LongSupplier
    public long getAsLong() {
        return -99999981L;
    }

    public PluginValueSet j(int i6, SparseArray<Object> sparseArray) {
        if (i6 == 1) {
            return j(i6);
        }
        if (i6 == 6) {
            return j(i6, new r(sparseArray, i6));
        }
        if (i6 == 3) {
            return cw(i6, sparseArray);
        }
        if (i6 != 4) {
            switch (i6) {
                case 8:
                    return j(i6, new tl(sparseArray, i6));
                case 9:
                    return xt(i6, sparseArray);
                case 10:
                    j(sparseArray);
                    return null;
                default:
                    return null;
            }
        }
        return xt(i6);
    }

    private void j(SparseArray<Object> sparseArray) {
        if (sparseArray != null) {
            try {
                PluginValueSet r5 = new com.bytedance.sdk.openadsdk.i.j(sparseArray).r();
                if (r5 != null) {
                    String stringValue = r5.stringValue(6);
                    JSONObject jSONObject = (JSONObject) r5.objectValue(7, JSONObject.class);
                    jSONObject.put("label", stringValue);
                    com.bytedance.sdk.component.tl.xt.r.j.j jVar = new com.bytedance.sdk.component.tl.xt.r.j.j(UUID.randomUUID().toString(), jSONObject);
                    jVar.j((byte) 0);
                    jVar.xt((byte) 2);
                    com.bytedance.sdk.component.tl.xt.j.j(jVar, "csj");
                }
            } catch (Exception e6) {
                com.bytedance.sdk.component.utils.vl.j(e6);
            }
        }
    }

    public PluginValueSet j(int i6) {
        return e.a().g(31, kt.cw()).k();
    }
}
