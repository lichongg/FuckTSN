package com.bytedance.msdk.m.xt;

import android.util.SparseArray;
import com.bykv.j.j.j.j.e;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.function.Supplier;

/* loaded from: D:\Downloads\app\classes3.dex */
public class m extends com.bytedance.sdk.openadsdk.core.wq.r implements Supplier<SparseArray<Object>> {

    /* renamed from: j, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.i.cw.cw.cw f25192j;

    public m(com.bytedance.sdk.openadsdk.i.cw.cw.cw cwVar) {
        this.f25192j = cwVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.wq.r
    public <T> T applyFunction(int i6, PluginValueSet pluginValueSet, Class<T> cls) {
        if (i6 == -99999986) {
            return (T) j().sparseArray();
        }
        return null;
    }

    public PluginValueSet j() {
        double d6;
        e a6 = e.a();
        com.bytedance.sdk.openadsdk.i.cw.cw.cw cwVar = this.f25192j;
        double d7 = 0.0d;
        if (cwVar != null) {
            d6 = cwVar.j();
        } else {
            d6 = 0.0d;
        }
        a6.c(8481, d6);
        com.bytedance.sdk.openadsdk.i.cw.cw.cw cwVar2 = this.f25192j;
        if (cwVar2 != null) {
            d7 = cwVar2.xt();
        }
        a6.c(8482, d7);
        return a6.k();
    }

    @Override // java.util.function.Supplier
    /* renamed from: xt, reason: merged with bridge method [inline-methods] */
    public SparseArray<Object> get() {
        PluginValueSet j6 = j();
        if (j6 != null) {
            return j6.sparseArray();
        }
        return null;
    }
}
