package com.bytedance.sdk.openadsdk.mediation.init.j.j.j;

import android.util.SparseArray;
import com.bykv.j.j.j.j.a;
import com.bytedance.sdk.openadsdk.mediation.init.IMediationPrivacyConfig;
import java.util.List;
import java.util.function.Supplier;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt {
    public static final SparseArray<Object> j(final IMediationPrivacyConfig iMediationPrivacyConfig) {
        a a6 = a.a();
        if (iMediationPrivacyConfig == null) {
            return null;
        }
        a6.g(262114, new Supplier<List<String>>() { // from class: com.bytedance.sdk.openadsdk.mediation.init.j.j.j.xt.1
            @Override // java.util.function.Supplier
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public List<String> get() {
                return IMediationPrivacyConfig.this.getCustomAppList();
            }
        });
        a6.g(262115, new Supplier<List<String>>() { // from class: com.bytedance.sdk.openadsdk.mediation.init.j.j.j.xt.2
            @Override // java.util.function.Supplier
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public List<String> get() {
                return IMediationPrivacyConfig.this.getCustomDevImeis();
            }
        });
        a6.g(262116, new Supplier<Boolean>() { // from class: com.bytedance.sdk.openadsdk.mediation.init.j.j.j.xt.3
            @Override // java.util.function.Supplier
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                return Boolean.valueOf(IMediationPrivacyConfig.this.isCanUseOaid());
            }
        });
        a6.g(262117, new Supplier<Boolean>() { // from class: com.bytedance.sdk.openadsdk.mediation.init.j.j.j.xt.4
            @Override // java.util.function.Supplier
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                return Boolean.valueOf(IMediationPrivacyConfig.this.isLimitPersonalAds());
            }
        });
        a6.g(262118, new Supplier<Boolean>() { // from class: com.bytedance.sdk.openadsdk.mediation.init.j.j.j.xt.5
            @Override // java.util.function.Supplier
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                return Boolean.valueOf(IMediationPrivacyConfig.this.isProgrammaticRecommend());
            }
        });
        return a6.k().sparseArray();
    }
}
