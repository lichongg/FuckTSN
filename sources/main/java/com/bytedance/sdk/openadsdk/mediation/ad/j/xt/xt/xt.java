package com.bytedance.sdk.openadsdk.mediation.ad.j.xt.xt;

import android.util.SparseArray;
import com.bykv.j.j.j.j.e;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.Map;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class xt implements Function<SparseArray<Object>, Object> {

    /* renamed from: j, reason: collision with root package name */
    private PluginValueSet f31673j;

    public abstract int ae();

    public abstract int cw();

    public abstract int g();

    public abstract int j();

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
            switch (intValue) {
            }
            return null;
        }
        PluginValueSet pluginValueSet = this.f31673j;
        if (pluginValueSet != null) {
            return pluginValueSet.sparseArray();
        }
        PluginValueSet az = az();
        this.f31673j = az;
        return az.sparseArray();
    }

    public abstract int jy();

    public abstract int m();

    public abstract int oq();

    public abstract int qv();

    public abstract int r();

    public abstract int tl();

    public abstract int up();

    public abstract int vl();

    public abstract Map<String, Integer> ws();

    public abstract int xt();

    private PluginValueSet az() {
        return e.a().k();
    }
}
