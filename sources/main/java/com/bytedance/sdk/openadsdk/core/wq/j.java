package com.bytedance.sdk.openadsdk.core.wq;

import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.function.LongSupplier;

/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class j extends r implements LongSupplier {
    public abstract void j();

    public abstract void xt();

    @Override // com.bytedance.sdk.openadsdk.core.wq.r
    public <T> T applyFunction(int i6, PluginValueSet pluginValueSet, Class<T> cls) {
        if (i6 == 0) {
            j();
            return null;
        }
        if (i6 != 1) {
            return null;
        }
        xt();
        return null;
    }

    @Override // java.util.function.LongSupplier
    public long getAsLong() {
        return -99999981L;
    }
}
