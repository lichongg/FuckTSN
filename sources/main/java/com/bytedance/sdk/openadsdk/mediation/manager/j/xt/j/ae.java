package com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j;

import android.util.SparseArray;
import com.bykv.j.j.j.j.e;
import com.bykv.vk.openvk.api.proto.PluginValueSet;

/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class ae extends cw {

    /* renamed from: j, reason: collision with root package name */
    private SparseArray<Object> f31747j;

    public abstract void destroy();

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.cw, java.util.function.Function
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        PluginValueSet k6 = e.i(sparseArray).k();
        int intValue = k6.intValue(-99999987);
        k6.objectValue(-99999985, Class.class);
        if (intValue == -99999986) {
            return values();
        }
        if (intValue != 270007) {
            return super.apply(sparseArray);
        }
        destroy();
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.cw
    public SparseArray<Object> values() {
        SparseArray<Object> sparseArray = this.f31747j;
        if (sparseArray != null) {
            return sparseArray;
        }
        SparseArray<Object> j6 = j();
        this.f31747j = j6;
        return j6;
    }

    private SparseArray<Object> j() {
        return com.bytedance.sdk.openadsdk.i.r.j(super.values()).xt();
    }
}
