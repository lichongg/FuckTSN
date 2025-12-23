package com.bytedance.sdk.openadsdk.i.cw.xt;

import android.util.SparseArray;
import com.bykv.j.j.j.j.e;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class up implements Function<SparseArray<Object>, Object> {

    /* renamed from: j, reason: collision with root package name */
    private PluginValueSet f31441j;

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
                return cw().sparseArray();
            case 222101:
                j();
                return null;
            case 222102:
                xt();
                return null;
            default:
                return null;
        }
    }

    public abstract void j();

    public abstract void xt();

    public PluginValueSet cw() {
        PluginValueSet pluginValueSet = this.f31441j;
        if (pluginValueSet != null) {
            return pluginValueSet;
        }
        PluginValueSet r5 = r();
        this.f31441j = r5;
        return r5;
    }

    private PluginValueSet r() {
        return e.a().k();
    }
}
