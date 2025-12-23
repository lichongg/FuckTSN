package com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j;

import a1.a;
import a1.b;
import android.util.SparseArray;
import com.bykv.j.j.j.j.e;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.function.Supplier;

/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class up extends cw {

    /* renamed from: j, reason: collision with root package name */
    private SparseArray<Object> f31768j;

    public abstract boolean hasDislike();

    public abstract boolean isExpress();

    public abstract void onPause();

    public abstract void onResume();

    public abstract void setShakeViewListener(com.bytedance.sdk.openadsdk.mediation.ad.j.xt.j.m mVar);

    public abstract void setUseCustomVideo(boolean z5);

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.cw, java.util.function.Function
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        PluginValueSet k6 = e.i(sparseArray).k();
        int intValue = k6.intValue(-99999987);
        k6.objectValue(-99999985, Class.class);
        switch (intValue) {
            case -99999986:
                SparseArray<Object> sparseArray2 = this.f31768j;
                if (sparseArray2 != null) {
                    return sparseArray2;
                }
                SparseArray<Object> j6 = j();
                this.f31768j = j6;
                return j6;
            case 270009:
                setUseCustomVideo(k6.booleanValue(0));
                return null;
            case 270010:
                setShakeViewListener(new com.bytedance.sdk.openadsdk.mediation.ad.j.xt.j.m(b.a(k6.objectValue(0, a.a()))));
                return null;
            case 271048:
                onResume();
                return null;
            case 271049:
                onPause();
                return null;
            default:
                return super.apply(sparseArray);
        }
    }

    private SparseArray<Object> j() {
        com.bytedance.sdk.openadsdk.i.r j6 = com.bytedance.sdk.openadsdk.i.r.j(super.values());
        j6.j(270008, com.bytedance.sdk.openadsdk.i.cw.r.j((Supplier) new Supplier<Boolean>() { // from class: com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.up.1
            @Override // java.util.function.Supplier
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                return Boolean.valueOf(up.this.hasDislike());
            }
        }));
        j6.j(270011, com.bytedance.sdk.openadsdk.i.cw.r.j((Supplier) new Supplier<Boolean>() { // from class: com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.up.2
            @Override // java.util.function.Supplier
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                return Boolean.valueOf(up.this.isExpress());
            }
        }));
        return j6.xt();
    }
}
