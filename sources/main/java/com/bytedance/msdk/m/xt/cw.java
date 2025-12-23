package com.bytedance.msdk.m.xt;

import a1.a;
import a1.b;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes3.dex */
public class cw {

    /* renamed from: j, reason: collision with root package name */
    private final PluginValueSet f25184j;

    public static cw j(PluginValueSet pluginValueSet) {
        return new cw(pluginValueSet);
    }

    private boolean xt() {
        PluginValueSet pluginValueSet = this.f25184j;
        return (pluginValueSet == null || pluginValueSet.isEmpty()) ? false : true;
    }

    public Function<SparseArray<Object>, Object> j() {
        if (xt()) {
            return b.a(this.f25184j.objectValue(8301, a.a()));
        }
        return null;
    }

    private cw(PluginValueSet pluginValueSet) {
        this.f25184j = pluginValueSet;
    }
}
