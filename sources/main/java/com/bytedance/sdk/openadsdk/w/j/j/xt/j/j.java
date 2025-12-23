package com.bytedance.sdk.openadsdk.w.j.j.xt.j;

import android.os.Bundle;
import android.util.SparseArray;
import com.bykv.j.j.j.j.e;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class j implements Function<SparseArray<Object>, Object> {

    /* renamed from: j, reason: collision with root package name */
    private PluginValueSet f31962j;

    private PluginValueSet j() {
        return e.a().k();
    }

    public abstract void j(Bundle bundle);

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
            if (intValue == 123101) {
                j((Bundle) k6.objectValue(0, Bundle.class));
            }
            return null;
        }
        PluginValueSet pluginValueSet = this.f31962j;
        if (pluginValueSet != null) {
            return pluginValueSet.sparseArray();
        }
        PluginValueSet j6 = j();
        this.f31962j = j6;
        return j6.sparseArray();
    }
}
