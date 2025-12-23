package com.bytedance.sdk.openadsdk.i.j.cw;

import android.util.SparseArray;
import com.bykv.j.j.j.j.a;
import com.bytedance.sdk.openadsdk.AdConfig;
import java.util.Map;
import java.util.function.Supplier;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j {
    public static SparseArray<Object> j(final AdConfig adConfig) {
        if (adConfig == null) {
            return new SparseArray<>();
        }
        a a6 = a.a();
        a6.h(261001, adConfig.getAppId());
        a6.h(261002, adConfig.getAppName());
        a6.i(261003, adConfig.isPaid());
        a6.h(261004, adConfig.getKeywords());
        a6.h(261005, adConfig.getData());
        a6.e(261006, adConfig.getTitleBarTheme());
        a6.i(261007, adConfig.isAllowShowNotify());
        a6.i(261008, adConfig.isDebug());
        a6.g(261009, adConfig.getDirectDownloadNetworkType());
        a6.i(261011, adConfig.isSupportMultiProcess());
        a6.g(261012, r.j(adConfig.getCustomController()));
        a6.g(261013, new Supplier<Integer>() { // from class: com.bytedance.sdk.openadsdk.i.j.cw.j.1
            @Override // java.util.function.Supplier
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(AdConfig.this.getPluginUpdateConfig());
            }
        });
        a6.g(261014, new Supplier<Integer>() { // from class: com.bytedance.sdk.openadsdk.i.j.cw.j.2
            @Override // java.util.function.Supplier
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(AdConfig.this.getAgeGroup());
            }
        });
        a6.g(261015, new Supplier<Integer>() { // from class: com.bytedance.sdk.openadsdk.i.j.cw.j.3
            @Override // java.util.function.Supplier
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(AdConfig.this.getThemeStatus());
            }
        });
        a6.g(261016, adConfig.getMediationConfig() != null ? com.bytedance.sdk.openadsdk.mediation.init.j.j.j.j.j(adConfig.getMediationConfig()) : null);
        a6.i(261017, adConfig.isUseMediation());
        a6.g(261018, new Supplier<Map<String, Object>>() { // from class: com.bytedance.sdk.openadsdk.i.j.cw.j.4
            @Override // java.util.function.Supplier
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public Map<String, Object> get() {
                return AdConfig.this.getInitExtra();
            }
        });
        return a6.k().sparseArray();
    }
}
