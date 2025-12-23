package com.bytedance.sdk.openadsdk.i.cw.xt;

import a1.a;
import a1.b;
import android.util.SparseArray;
import com.bykv.j.j.j.j.e;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.function.Function;
import java.util.function.Supplier;

/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class oq extends jy {

    /* renamed from: j, reason: collision with root package name */
    private SparseArray<Object> f31429j;

    public abstract int cw();

    public abstract double j();

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.jy, com.bytedance.sdk.openadsdk.i.cw.xt.tl, java.util.function.Function
    /* renamed from: j */
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        PluginValueSet k6 = e.i(sparseArray).k();
        int intValue = k6.intValue(-99999987);
        k6.objectValue(-99999985, Class.class);
        switch (intValue) {
            case -99999986:
                return u_();
            case 140111:
                Function a6 = b.a(k6.objectValue(0, a.a()));
                j(k6.intValue(1) == 1 ? new com.bytedance.sdk.openadsdk.mediation.ad.j.xt.j.up(a6) : new com.bytedance.sdk.openadsdk.ch.j.xt.j.cw(a6));
                return null;
            case 160101:
                j(new com.bytedance.sdk.openadsdk.v.j.xt.j.j(b.a(k6.objectValue(0, a.a()))));
                return null;
            case 160102:
                j(new com.bytedance.sdk.openadsdk.v.j.xt.j.xt(b.a(k6.objectValue(0, a.a()))));
                return null;
            default:
                return super.apply(sparseArray);
        }
    }

    public abstract void j(com.bytedance.sdk.openadsdk.v.j.xt.j.j jVar);

    public abstract void j(com.bytedance.sdk.openadsdk.v.j.xt.j.xt xtVar);

    public abstract int r();

    public abstract com.bytedance.sdk.openadsdk.v.j.xt.xt.j xt();

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.jy
    public SparseArray<Object> u_() {
        SparseArray<Object> sparseArray = this.f31429j;
        if (sparseArray != null) {
            return sparseArray;
        }
        SparseArray<Object> s5 = s();
        this.f31429j = s5;
        return s5;
    }

    private SparseArray<Object> s() {
        com.bytedance.sdk.openadsdk.i.r j6 = com.bytedance.sdk.openadsdk.i.r.j(super.u_());
        j6.j(160001, com.bytedance.sdk.openadsdk.i.cw.r.j((Supplier) new Supplier<Double>() { // from class: com.bytedance.sdk.openadsdk.i.cw.xt.oq.1
            @Override // java.util.function.Supplier
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public Double get() {
                return Double.valueOf(oq.this.j());
            }
        }));
        j6.j(160002, com.bytedance.sdk.openadsdk.i.cw.r.j((Supplier) new Supplier<com.bytedance.sdk.openadsdk.v.j.xt.xt.j>() { // from class: com.bytedance.sdk.openadsdk.i.cw.xt.oq.2
            @Override // java.util.function.Supplier
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public com.bytedance.sdk.openadsdk.v.j.xt.xt.j get() {
                return oq.this.xt();
            }
        }));
        j6.j(160003, com.bytedance.sdk.openadsdk.i.cw.r.j((Supplier) new Supplier<Integer>() { // from class: com.bytedance.sdk.openadsdk.i.cw.xt.oq.3
            @Override // java.util.function.Supplier
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(oq.this.cw());
            }
        }));
        j6.j(160004, com.bytedance.sdk.openadsdk.i.cw.r.j((Supplier) new Supplier<Integer>() { // from class: com.bytedance.sdk.openadsdk.i.cw.xt.oq.4
            @Override // java.util.function.Supplier
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(oq.this.r());
            }
        }));
        return j6.xt();
    }
}
