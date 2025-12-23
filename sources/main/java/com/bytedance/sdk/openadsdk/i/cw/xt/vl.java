package com.bytedance.sdk.openadsdk.i.cw.xt;

import android.util.SparseArray;
import com.bykv.j.j.j.j.e;
import java.util.function.Function;
import java.util.function.Supplier;

/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class vl implements Function<SparseArray<Object>, Object> {

    /* renamed from: j, reason: collision with root package name */
    private SparseArray<Object> f31442j;

    public abstract String cw();

    public abstract int j();

    @Override // java.util.function.Function
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray != null && e.i(sparseArray).k().intValue(-99999987) == -99999986) {
            return m();
        }
        return null;
    }

    public abstract double r();

    public abstract boolean up();

    public abstract int xt();

    public SparseArray<Object> m() {
        SparseArray<Object> sparseArray = this.f31442j;
        if (sparseArray != null) {
            return sparseArray;
        }
        SparseArray<Object> ae = ae();
        this.f31442j = ae;
        return ae;
    }

    private SparseArray<Object> ae() {
        com.bytedance.sdk.openadsdk.i.r j6 = com.bytedance.sdk.openadsdk.i.r.j();
        j6.j(230002, com.bytedance.sdk.openadsdk.i.cw.r.j((Supplier) new Supplier<Integer>() { // from class: com.bytedance.sdk.openadsdk.i.cw.xt.vl.1
            @Override // java.util.function.Supplier
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(vl.this.j());
            }
        }));
        j6.j(230001, com.bytedance.sdk.openadsdk.i.cw.r.j((Supplier) new Supplier<Integer>() { // from class: com.bytedance.sdk.openadsdk.i.cw.xt.vl.2
            @Override // java.util.function.Supplier
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(vl.this.xt());
            }
        }));
        j6.j(230003, com.bytedance.sdk.openadsdk.i.cw.r.j((Supplier) new Supplier<String>() { // from class: com.bytedance.sdk.openadsdk.i.cw.xt.vl.3
            @Override // java.util.function.Supplier
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public String get() {
                return vl.this.cw();
            }
        }));
        j6.j(230004, com.bytedance.sdk.openadsdk.i.cw.r.j((Supplier) new Supplier<Double>() { // from class: com.bytedance.sdk.openadsdk.i.cw.xt.vl.4
            @Override // java.util.function.Supplier
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public Double get() {
                return Double.valueOf(vl.this.r());
            }
        }));
        j6.j(230005, com.bytedance.sdk.openadsdk.i.cw.r.j((Supplier) new Supplier<Boolean>() { // from class: com.bytedance.sdk.openadsdk.i.cw.xt.vl.5
            @Override // java.util.function.Supplier
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                return Boolean.valueOf(vl.this.up());
            }
        }));
        return j6.xt();
    }
}
