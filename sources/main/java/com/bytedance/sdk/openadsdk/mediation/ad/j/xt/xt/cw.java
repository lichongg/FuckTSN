package com.bytedance.sdk.openadsdk.mediation.ad.j.xt.xt;

import a1.a;
import a1.b;
import android.util.SparseArray;
import com.bykv.j.j.j.j.e;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class cw implements Function<SparseArray<Object>, Object> {

    /* renamed from: j, reason: collision with root package name */
    private PluginValueSet f31669j;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // java.util.function.Function
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        PluginValueSet k6 = e.i(sparseArray).k();
        int intValue = k6.intValue(-99999987);
        k6.objectValue(-99999985, Class.class);
        switch (intValue) {
            case -99999986:
                return xt().sparseArray();
            case 270032:
                j();
                return null;
            case 270033:
                j(new com.bytedance.sdk.openadsdk.mediation.ad.j.xt.j.j(b.a(k6.objectValue(0, a.a()))));
                return null;
            default:
                return null;
        }
    }

    public abstract void j();

    public abstract void j(com.bytedance.sdk.openadsdk.mediation.ad.j.xt.j.j jVar);

    public PluginValueSet xt() {
        PluginValueSet pluginValueSet = this.f31669j;
        if (pluginValueSet != null) {
            return pluginValueSet;
        }
        PluginValueSet cw = cw();
        this.f31669j = cw;
        return cw;
    }

    private PluginValueSet cw() {
        return e.a().k();
    }
}
