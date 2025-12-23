package com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j;

import android.util.SparseArray;
import com.bykv.j.j.j.j.e;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.function.Function;
import java.util.function.Supplier;

/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class xt implements Function<SparseArray<Object>, Object> {

    /* renamed from: j, reason: collision with root package name */
    private SparseArray<Object> f31771j;

    public abstract String cw();

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
            return null;
        }
        return m();
    }

    public abstract String j();

    public abstract int r();

    public abstract String up();

    public abstract String xt();

    public SparseArray<Object> m() {
        SparseArray<Object> sparseArray = this.f31771j;
        if (sparseArray != null) {
            return sparseArray;
        }
        SparseArray<Object> ae = ae();
        this.f31771j = ae;
        return ae;
    }

    private SparseArray<Object> ae() {
        com.bytedance.sdk.openadsdk.i.r j6 = com.bytedance.sdk.openadsdk.i.r.j();
        j6.j(271001, com.bytedance.sdk.openadsdk.i.cw.r.j((Supplier) new Supplier<String>() { // from class: com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.xt.1
            @Override // java.util.function.Supplier
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public String get() {
                return xt.this.j();
            }
        }));
        j6.j(271002, com.bytedance.sdk.openadsdk.i.cw.r.j((Supplier) new Supplier<String>() { // from class: com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.xt.2
            @Override // java.util.function.Supplier
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public String get() {
                return xt.this.xt();
            }
        }));
        j6.j(271003, com.bytedance.sdk.openadsdk.i.cw.r.j((Supplier) new Supplier<String>() { // from class: com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.xt.3
            @Override // java.util.function.Supplier
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public String get() {
                return xt.this.cw();
            }
        }));
        j6.j(271004, com.bytedance.sdk.openadsdk.i.cw.r.j((Supplier) new Supplier<Integer>() { // from class: com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.xt.4
            @Override // java.util.function.Supplier
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(xt.this.r());
            }
        }));
        j6.j(271005, com.bytedance.sdk.openadsdk.i.cw.r.j((Supplier) new Supplier<String>() { // from class: com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.xt.5
            @Override // java.util.function.Supplier
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public String get() {
                return xt.this.up();
            }
        }));
        return j6.xt();
    }
}
