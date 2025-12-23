package com.bytedance.sdk.openadsdk.mediation.xt.xt.xt;

import a1.a;
import a1.b;
import android.util.SparseArray;
import com.bykv.j.j.j.j.e;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.openadsdk.tj.j.xt.j.cw;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class xt implements Function<SparseArray<Object>, Object> {

    /* renamed from: j, reason: collision with root package name */
    private PluginValueSet f31797j;

    public PluginValueSet j() {
        PluginValueSet pluginValueSet = this.f31797j;
        if (pluginValueSet != null) {
            return pluginValueSet;
        }
        PluginValueSet xt = xt();
        this.f31797j = xt;
        return xt;
    }

    public abstract void j(String str, cw cwVar);

    private PluginValueSet xt() {
        return e.a().k();
    }

    @Override // java.util.function.Function
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        PluginValueSet k6 = e.i(sparseArray).k();
        int intValue = k6.intValue(-99999987);
        k6.objectValue(-99999985, Class.class);
        if (intValue == -99999986) {
            return j().sparseArray();
        }
        if (intValue == 270028) {
            j((String) k6.objectValue(0, String.class), new cw(b.a(k6.objectValue(1, a.a()))));
        }
        return null;
    }
}
