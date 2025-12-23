package com.bytedance.sdk.openadsdk.core.wq;

import android.util.SparseArray;
import com.bykv.j.j.j.j.e;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class r implements Function<SparseArray<Object>, Object> {
    public abstract <T> T applyFunction(int i6, PluginValueSet pluginValueSet, Class<T> cls);

    @Override // java.util.function.Function
    public Object apply(SparseArray<Object> sparseArray) {
        PluginValueSet k6 = e.i(sparseArray).k();
        return applyFunction(k6.intValue(-99999987, 0), k6, (Class) k6.objectValue(-99999985, Class.class));
    }
}
