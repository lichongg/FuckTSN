package com.bytedance.sdk.openadsdk.core.qv.j;

import android.util.SparseArray;
import com.bykv.j.j.j.j.e;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.function.LongSupplier;
import w2.h;

/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class xt extends com.bytedance.sdk.openadsdk.core.wq.r implements h, LongSupplier {
    @Override // com.bytedance.sdk.openadsdk.core.wq.r
    public <T> T applyFunction(int i6, PluginValueSet pluginValueSet, Class<T> cls) {
        if (pluginValueSet == null) {
            return null;
        }
        if (i6 == 223100) {
            if (!com.bytedance.sdk.openadsdk.i.cw.r.j(com.bytedance.sdk.openadsdk.core.h.xt)) {
                pluginValueSet = e.i((SparseArray) pluginValueSet.objectValue(-99999979, SparseArray.class)).k();
            }
            j(e.i((SparseArray) pluginValueSet.objectValue(-999902, SparseArray.class)).k().booleanValue(223101));
        } else if (i6 == 223110) {
            j();
        }
        return null;
    }

    @Override // java.util.function.LongSupplier
    public long getAsLong() {
        return -99999981L;
    }
}
