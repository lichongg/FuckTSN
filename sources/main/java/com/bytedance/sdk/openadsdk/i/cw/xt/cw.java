package com.bytedance.sdk.openadsdk.i.cw.xt;

import android.util.SparseArray;
import com.bykv.j.j.j.j.e;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class cw implements Function<SparseArray<Object>, Object> {

    /* renamed from: j, reason: collision with root package name */
    private SparseArray<Object> f31395j;

    public abstract String ae();

    public abstract String cw();

    public abstract String g();

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
        return oq();
    }

    public abstract String j();

    public abstract String m();

    public abstract String r();

    public abstract String tl();

    public abstract Map<String, String> up();

    public abstract String xt();

    public SparseArray<Object> oq() {
        SparseArray<Object> sparseArray = this.f31395j;
        if (sparseArray != null) {
            return sparseArray;
        }
        SparseArray<Object> qv = qv();
        this.f31395j = qv;
        return qv;
    }

    private SparseArray<Object> qv() {
        com.bytedance.sdk.openadsdk.i.r j6 = com.bytedance.sdk.openadsdk.i.r.j();
        j6.j(250001, com.bytedance.sdk.openadsdk.i.cw.r.j((Supplier) new Supplier<String>() { // from class: com.bytedance.sdk.openadsdk.i.cw.xt.cw.1
            @Override // java.util.function.Supplier
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public String get() {
                return cw.this.j();
            }
        }));
        j6.j(250002, com.bytedance.sdk.openadsdk.i.cw.r.j((Supplier) new Supplier<String>() { // from class: com.bytedance.sdk.openadsdk.i.cw.xt.cw.2
            @Override // java.util.function.Supplier
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public String get() {
                return cw.this.xt();
            }
        }));
        j6.j(250003, com.bytedance.sdk.openadsdk.i.cw.r.j((Supplier) new Supplier<String>() { // from class: com.bytedance.sdk.openadsdk.i.cw.xt.cw.3
            @Override // java.util.function.Supplier
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public String get() {
                return cw.this.cw();
            }
        }));
        j6.j(250004, com.bytedance.sdk.openadsdk.i.cw.r.j((Supplier) new Supplier<String>() { // from class: com.bytedance.sdk.openadsdk.i.cw.xt.cw.4
            @Override // java.util.function.Supplier
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public String get() {
                return cw.this.r();
            }
        }));
        j6.j(250006, com.bytedance.sdk.openadsdk.i.cw.r.j((Supplier) new Supplier<Map<String, String>>() { // from class: com.bytedance.sdk.openadsdk.i.cw.xt.cw.5
            @Override // java.util.function.Supplier
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public Map<String, String> get() {
                return cw.this.up();
            }
        }));
        j6.j(250005, com.bytedance.sdk.openadsdk.i.cw.r.j((Supplier) new Supplier<String>() { // from class: com.bytedance.sdk.openadsdk.i.cw.xt.cw.6
            @Override // java.util.function.Supplier
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public String get() {
                return cw.this.m();
            }
        }));
        j6.j(250007, com.bytedance.sdk.openadsdk.i.cw.r.j((Supplier) new Supplier<String>() { // from class: com.bytedance.sdk.openadsdk.i.cw.xt.cw.7
            @Override // java.util.function.Supplier
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public String get() {
                return cw.this.ae();
            }
        }));
        j6.j(250008, com.bytedance.sdk.openadsdk.i.cw.r.j((Supplier) new Supplier<String>() { // from class: com.bytedance.sdk.openadsdk.i.cw.xt.cw.8
            @Override // java.util.function.Supplier
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public String get() {
                return cw.this.g();
            }
        }));
        j6.j(250009, com.bytedance.sdk.openadsdk.i.cw.r.j((Supplier) new Supplier<String>() { // from class: com.bytedance.sdk.openadsdk.i.cw.xt.cw.9
            @Override // java.util.function.Supplier
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public String get() {
                return cw.this.tl();
            }
        }));
        return j6.xt();
    }
}
