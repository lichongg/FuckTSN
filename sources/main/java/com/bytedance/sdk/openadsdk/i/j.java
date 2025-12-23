package com.bytedance.sdk.openadsdk.i;

import android.util.SparseArray;
import com.bykv.j.j.j.j.e;
import com.bykv.vk.openvk.api.proto.PluginValueSet;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j {
    private String cw;

    /* renamed from: j, reason: collision with root package name */
    private boolean f31459j;

    /* renamed from: r, reason: collision with root package name */
    private PluginValueSet f31460r;
    private int xt;

    public String cw() {
        return this.cw;
    }

    public boolean j() {
        return this.f31459j;
    }

    public PluginValueSet r() {
        return this.f31460r;
    }

    public int xt() {
        return this.xt;
    }

    public j(SparseArray<Object> sparseArray) {
        if (sparseArray != null) {
            PluginValueSet k6 = e.i(sparseArray).k();
            this.f31459j = k6.booleanValue(-999903);
            this.xt = k6.intValue(-999900);
            this.cw = k6.stringValue(-999901);
            this.f31460r = e.i((SparseArray) k6.objectValue(-999902, SparseArray.class)).k();
        }
    }
}
