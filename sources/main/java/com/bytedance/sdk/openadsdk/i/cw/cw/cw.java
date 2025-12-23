package com.bytedance.sdk.openadsdk.i.cw.cw;

import android.util.SparseArray;
import com.bykv.j.j.j.j.e;
import com.bykv.vk.openvk.api.proto.PluginValueSet;

/* loaded from: D:\Downloads\app\classes4.dex */
public class cw {

    /* renamed from: j, reason: collision with root package name */
    public PluginValueSet f31378j;

    public static class j {

        /* renamed from: j, reason: collision with root package name */
        private final com.bytedance.sdk.openadsdk.i.r f31379j = com.bytedance.sdk.openadsdk.i.r.j();

        public j j(double d6) {
            this.f31379j.j(262001, Double.valueOf(d6));
            return this;
        }

        public cw j() {
            return new cw(this.f31379j.xt());
        }

        public j xt(double d6) {
            this.f31379j.j(262002, Double.valueOf(d6));
            return this;
        }
    }

    public double j() {
        return this.f31378j.doubleValue(262001);
    }

    public double xt() {
        return this.f31378j.doubleValue(262002);
    }

    public cw(SparseArray<Object> sparseArray) {
        this.f31378j = e.i(sparseArray).k();
    }
}
