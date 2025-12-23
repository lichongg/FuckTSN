package com.bytedance.sdk.openadsdk.v.j.xt.xt;

import android.util.SparseArray;
import com.bykv.j.j.j.j.e;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class j implements Function<SparseArray<Object>, Object> {

    /* renamed from: j, reason: collision with root package name */
    private PluginValueSet f31960j;

    public abstract void cw();

    public abstract void cw(long j6);

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
        if (intValue == -99999986) {
            return up().sparseArray();
        }
        switch (intValue) {
            case 162101:
                return j();
            case 162102:
                xt();
                return null;
            case 162103:
                j(k6.longValue(0));
                return null;
            case 162104:
                xt(k6.longValue(0));
                return null;
            case 162105:
                cw();
                return null;
            case 162106:
                cw(k6.longValue(0));
                return null;
            case 162107:
                r();
                return null;
            case 162108:
                j(k6.intValue(0), k6.intValue(1));
                return null;
            case 162109:
                j(k6.longValue(0), k6.intValue(1), k6.intValue(2));
                return null;
            default:
                return null;
        }
    }

    public abstract String j();

    public abstract void j(int i6, int i7);

    public abstract void j(long j6);

    public abstract void j(long j6, int i6, int i7);

    public abstract void r();

    public abstract void xt();

    public abstract void xt(long j6);

    public PluginValueSet up() {
        PluginValueSet pluginValueSet = this.f31960j;
        if (pluginValueSet != null) {
            return pluginValueSet;
        }
        PluginValueSet m6 = m();
        this.f31960j = m6;
        return m6;
    }

    private PluginValueSet m() {
        return e.a().k();
    }
}
