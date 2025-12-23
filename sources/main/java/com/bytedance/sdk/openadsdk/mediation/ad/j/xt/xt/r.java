package com.bytedance.sdk.openadsdk.mediation.ad.j.xt.xt;

import android.util.SparseArray;
import com.bykv.j.j.j.j.e;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.Map;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class r implements Function<SparseArray<Object>, Object> {

    /* renamed from: j, reason: collision with root package name */
    private PluginValueSet f31672j;

    public abstract String ae();

    public abstract long cw();

    public abstract String g();

    @Override // java.util.function.Function
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        PluginValueSet k6 = e.i(sparseArray).k();
        int intValue = k6.intValue(-99999987);
        k6.objectValue(-99999985, Class.class);
        if (intValue != -99999986) {
            if (intValue == 271047) {
                return tl();
            }
            if (intValue == 271051) {
                return g();
            }
            switch (intValue) {
            }
            return null;
        }
        PluginValueSet pluginValueSet = this.f31672j;
        if (pluginValueSet != null) {
            return pluginValueSet.sparseArray();
        }
        PluginValueSet qv = qv();
        this.f31672j = qv;
        return qv.sparseArray();
    }

    public abstract String j();

    public abstract String m();

    public abstract Map<String, Object> oq();

    public abstract String r();

    public abstract String tl();

    public abstract Map<String, String> up();

    public abstract String xt();

    protected PluginValueSet qv() {
        return e.a().k();
    }
}
