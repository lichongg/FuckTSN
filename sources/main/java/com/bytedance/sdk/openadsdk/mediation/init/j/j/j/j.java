package com.bytedance.sdk.openadsdk.mediation.init.j.j.j;

import android.util.SparseArray;
import com.bykv.j.j.j.j.a;
import com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig;
import java.util.Map;
import java.util.function.Supplier;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j {
    public static final SparseArray<Object> j(final IMediationConfig iMediationConfig) {
        a a6 = a.a();
        SparseArray<Object> sparseArray = null;
        if (iMediationConfig == null) {
            return null;
        }
        a6.g(264101, new Supplier<String>() { // from class: com.bytedance.sdk.openadsdk.mediation.init.j.j.j.j.1
            @Override // java.util.function.Supplier
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public String get() {
                return IMediationConfig.this.getPublisherDid();
            }
        });
        a6.g(264102, new Supplier<Boolean>() { // from class: com.bytedance.sdk.openadsdk.mediation.init.j.j.j.j.3
            @Override // java.util.function.Supplier
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                return Boolean.valueOf(IMediationConfig.this.isOpenAdnTest());
            }
        });
        if (iMediationConfig.getMediationConfigUserInfoForSegment() != null) {
            sparseArray = cw.j(iMediationConfig.getMediationConfigUserInfoForSegment());
        }
        a6.g(264103, sparseArray);
        a6.g(264104, new Supplier<Map<String, Object>>() { // from class: com.bytedance.sdk.openadsdk.mediation.init.j.j.j.j.4
            @Override // java.util.function.Supplier
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public Map<String, Object> get() {
                return IMediationConfig.this.getLocalExtra();
            }
        });
        a6.g(264105, new Supplier<Boolean>() { // from class: com.bytedance.sdk.openadsdk.mediation.init.j.j.j.j.5
            @Override // java.util.function.Supplier
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                return Boolean.valueOf(IMediationConfig.this.getHttps());
            }
        });
        a6.g(264106, new Supplier<JSONObject>() { // from class: com.bytedance.sdk.openadsdk.mediation.init.j.j.j.j.6
            @Override // java.util.function.Supplier
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public JSONObject get() {
                return IMediationConfig.this.getCustomLocalConfig();
            }
        });
        a6.g(264107, new Supplier<String>() { // from class: com.bytedance.sdk.openadsdk.mediation.init.j.j.j.j.7
            @Override // java.util.function.Supplier
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public String get() {
                return IMediationConfig.this.getOpensdkVer();
            }
        });
        a6.g(264108, new Supplier<Boolean>() { // from class: com.bytedance.sdk.openadsdk.mediation.init.j.j.j.j.8
            @Override // java.util.function.Supplier
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                return Boolean.valueOf(IMediationConfig.this.isWxInstalled());
            }
        });
        a6.g(264109, new Supplier<Boolean>() { // from class: com.bytedance.sdk.openadsdk.mediation.init.j.j.j.j.9
            @Override // java.util.function.Supplier
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                return Boolean.valueOf(IMediationConfig.this.isSupportH265());
            }
        });
        a6.g(264110, new Supplier<Boolean>() { // from class: com.bytedance.sdk.openadsdk.mediation.init.j.j.j.j.10
            @Override // java.util.function.Supplier
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                return Boolean.valueOf(IMediationConfig.this.isSupportSplashZoomout());
            }
        });
        a6.g(264111, new Supplier<String>() { // from class: com.bytedance.sdk.openadsdk.mediation.init.j.j.j.j.2
            @Override // java.util.function.Supplier
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public String get() {
                return IMediationConfig.this.wxAppId();
            }
        });
        return a6.k().sparseArray();
    }
}
