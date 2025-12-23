package com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j;

import android.util.SparseArray;
import com.bykv.j.j.j.j.e;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class j implements Function<SparseArray<Object>, Object> {

    /* renamed from: j, reason: collision with root package name */
    private SparseArray<Object> f31749j;

    public abstract String getAbTestId();

    public abstract String getChannel();

    public abstract Map<String, String> getCustomData();

    public abstract String getCustomSdkName();

    public abstract String getEcpm();

    public abstract String getErrorMsg();

    public abstract String getLevelTag();

    public abstract int getReqBiddingType();

    public abstract String getRequestId();

    public abstract String getRitType();

    public abstract String getScenarioId();

    public abstract String getSdkName();

    public abstract String getSegmentId();

    public abstract String getSlotId();

    public abstract String getSubChannel();

    public abstract String getSubRitType();

    @Override // java.util.function.Function
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
        return values();
    }

    public SparseArray<Object> values() {
        SparseArray<Object> sparseArray = this.f31749j;
        if (sparseArray != null) {
            return sparseArray;
        }
        SparseArray<Object> j6 = j();
        this.f31749j = j6;
        return j6;
    }

    private SparseArray<Object> j() {
        com.bytedance.sdk.openadsdk.i.r j6 = com.bytedance.sdk.openadsdk.i.r.j();
        j6.j(271006, com.bytedance.sdk.openadsdk.i.cw.r.j((Supplier) new Supplier<Map<String, String>>() { // from class: com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.j.1
            @Override // java.util.function.Supplier
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public Map<String, String> get() {
                return j.this.getCustomData();
            }
        }));
        j6.j(271007, com.bytedance.sdk.openadsdk.i.cw.r.j((Supplier) new Supplier<String>() { // from class: com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.j.9
            @Override // java.util.function.Supplier
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public String get() {
                return j.this.getSdkName();
            }
        }));
        j6.j(271008, com.bytedance.sdk.openadsdk.i.cw.r.j((Supplier) new Supplier<String>() { // from class: com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.j.10
            @Override // java.util.function.Supplier
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public String get() {
                return j.this.getCustomSdkName();
            }
        }));
        j6.j(271009, com.bytedance.sdk.openadsdk.i.cw.r.j((Supplier) new Supplier<String>() { // from class: com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.j.11
            @Override // java.util.function.Supplier
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public String get() {
                return j.this.getSlotId();
            }
        }));
        j6.j(271010, com.bytedance.sdk.openadsdk.i.cw.r.j((Supplier) new Supplier<String>() { // from class: com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.j.12
            @Override // java.util.function.Supplier
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public String get() {
                return j.this.getLevelTag();
            }
        }));
        j6.j(271011, com.bytedance.sdk.openadsdk.i.cw.r.j((Supplier) new Supplier<String>() { // from class: com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.j.13
            @Override // java.util.function.Supplier
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public String get() {
                return j.this.getEcpm();
            }
        }));
        j6.j(271012, com.bytedance.sdk.openadsdk.i.cw.r.j((Supplier) new Supplier<Integer>() { // from class: com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.j.14
            @Override // java.util.function.Supplier
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(j.this.getReqBiddingType());
            }
        }));
        j6.j(271013, com.bytedance.sdk.openadsdk.i.cw.r.j((Supplier) new Supplier<String>() { // from class: com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.j.15
            @Override // java.util.function.Supplier
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public String get() {
                return j.this.getErrorMsg();
            }
        }));
        j6.j(271014, com.bytedance.sdk.openadsdk.i.cw.r.j((Supplier) new Supplier<String>() { // from class: com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.j.16
            @Override // java.util.function.Supplier
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public String get() {
                return j.this.getRequestId();
            }
        }));
        j6.j(271015, com.bytedance.sdk.openadsdk.i.cw.r.j((Supplier) new Supplier<String>() { // from class: com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.j.2
            @Override // java.util.function.Supplier
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public String get() {
                return j.this.getRitType();
            }
        }));
        j6.j(271016, com.bytedance.sdk.openadsdk.i.cw.r.j((Supplier) new Supplier<String>() { // from class: com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.j.3
            @Override // java.util.function.Supplier
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public String get() {
                return j.this.getSegmentId();
            }
        }));
        j6.j(271017, com.bytedance.sdk.openadsdk.i.cw.r.j((Supplier) new Supplier<String>() { // from class: com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.j.4
            @Override // java.util.function.Supplier
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public String get() {
                return j.this.getChannel();
            }
        }));
        j6.j(271018, com.bytedance.sdk.openadsdk.i.cw.r.j((Supplier) new Supplier<String>() { // from class: com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.j.5
            @Override // java.util.function.Supplier
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public String get() {
                return j.this.getSubChannel();
            }
        }));
        j6.j(271019, com.bytedance.sdk.openadsdk.i.cw.r.j((Supplier) new Supplier<String>() { // from class: com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.j.6
            @Override // java.util.function.Supplier
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public String get() {
                return j.this.getAbTestId();
            }
        }));
        j6.j(271020, com.bytedance.sdk.openadsdk.i.cw.r.j((Supplier) new Supplier<String>() { // from class: com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.j.7
            @Override // java.util.function.Supplier
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public String get() {
                return j.this.getScenarioId();
            }
        }));
        j6.j(271051, com.bytedance.sdk.openadsdk.i.cw.r.j((Supplier) new Supplier<String>() { // from class: com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.j.8
            @Override // java.util.function.Supplier
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public String get() {
                return j.this.getSubRitType();
            }
        }));
        return j6.xt();
    }
}
