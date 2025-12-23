package com.bytedance.sdk.openadsdk.core.qv.j;

import a1.a;
import a1.b;
import android.util.SparseArray;
import com.bykv.j.j.j.j.e;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.openadsdk.core.h;
import com.ss.android.j.j.cw.c;
import java.util.function.Function;
import java.util.function.LongSupplier;
import w2.d;

/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class up extends com.bytedance.sdk.openadsdk.core.wq.r implements d, LongSupplier {
    private void onItemClick(Function<SparseArray<Object>, Object> function, Function<SparseArray<Object>, Object> function2, Function<SparseArray<Object>, Object> function3) {
        onItemClick();
    }

    @Override // com.bytedance.sdk.openadsdk.core.wq.r
    public <T> T applyFunction(int i6, PluginValueSet pluginValueSet, Class<T> cls) {
        if (pluginValueSet == null) {
            return null;
        }
        if (!com.bytedance.sdk.openadsdk.i.cw.r.j(h.xt)) {
            pluginValueSet = e.i((SparseArray) pluginValueSet.objectValue(-99999979, SparseArray.class)).k();
        }
        if (i6 == 223200 && pluginValueSet != null) {
            PluginValueSet k6 = e.i((SparseArray) pluginValueSet.objectValue(-999902, SparseArray.class)).k();
            onItemClick(b.a(k6.objectValue(223201, a.a())), b.a(k6.objectValue(223202, a.a())), b.a(k6.objectValue(223203, a.a())));
        }
        return null;
    }

    public abstract void onItemClick();

    @Override // w2.d
    public void onItemClick(com.ss.android.j.j.cw.b bVar, com.ss.android.j.j.cw.g gVar, c cVar) {
        onItemClick();
    }

    @Override // java.util.function.LongSupplier
    public long getAsLong() {
        return -99999981L;
    }
}
