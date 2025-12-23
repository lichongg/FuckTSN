package com.bytedance.sdk.openadsdk.core.qv.j;

import android.util.SparseArray;
import com.bykv.j.j.j.j.e;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.openadsdk.core.h;
import java.util.Map;
import java.util.function.LongSupplier;

/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class r extends com.bytedance.sdk.openadsdk.core.wq.r implements w2.r, LongSupplier {
    @Override // com.bytedance.sdk.openadsdk.core.wq.r
    public <T> T applyFunction(int i6, PluginValueSet pluginValueSet, Class<T> cls) {
        if (pluginValueSet != null && i6 == 223901) {
            if (!com.bytedance.sdk.openadsdk.i.cw.r.j(h.xt)) {
                pluginValueSet = e.i((SparseArray) pluginValueSet.objectValue(-99999979, SparseArray.class)).k();
            }
            if (pluginValueSet != null) {
                return (T) com.bytedance.sdk.openadsdk.i.r.j().j(223902, j((Map) e.i((SparseArray) pluginValueSet.objectValue(-999902, SparseArray.class)).k().objectValue(223902, Map.class))).xt();
            }
        }
        return null;
    }

    @Override // java.util.function.LongSupplier
    public long getAsLong() {
        return -99999981L;
    }
}
