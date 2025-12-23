package com.bytedance.sdk.openadsdk.i.j.cw;

import android.util.SparseArray;
import com.bykv.j.j.j.j.a;
import com.bytedance.sdk.openadsdk.TTCustomController;
import java.util.Map;
import java.util.function.Supplier;

/* loaded from: D:\Downloads\app\classes4.dex */
public class r {
    public static final SparseArray<Object> j(final TTCustomController tTCustomController) {
        SparseArray<Object> sparseArray;
        a a6 = a.a();
        a6.g(262101, new Supplier<Boolean>() { // from class: com.bytedance.sdk.openadsdk.i.j.cw.r.1
            @Override // java.util.function.Supplier
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                TTCustomController tTCustomController2 = TTCustomController.this;
                return Boolean.valueOf(tTCustomController2 == null || tTCustomController2.isCanUseLocation());
            }
        });
        a6.g(262102, new Supplier<SparseArray<Object>>() { // from class: com.bytedance.sdk.openadsdk.i.j.cw.r.8
            @Override // java.util.function.Supplier
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public SparseArray<Object> get() {
                TTCustomController tTCustomController2 = TTCustomController.this;
                return cw.j(tTCustomController2 == null ? null : tTCustomController2.getTTLocation());
            }
        });
        a6.g(262103, new Supplier<Boolean>() { // from class: com.bytedance.sdk.openadsdk.i.j.cw.r.9
            @Override // java.util.function.Supplier
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                TTCustomController tTCustomController2 = TTCustomController.this;
                return Boolean.valueOf(tTCustomController2 == null || tTCustomController2.alist());
            }
        });
        a6.g(262104, new Supplier<Boolean>() { // from class: com.bytedance.sdk.openadsdk.i.j.cw.r.10
            @Override // java.util.function.Supplier
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                TTCustomController tTCustomController2 = TTCustomController.this;
                return Boolean.valueOf(tTCustomController2 == null || tTCustomController2.isCanUsePhoneState());
            }
        });
        a6.g(262105, new Supplier<String>() { // from class: com.bytedance.sdk.openadsdk.i.j.cw.r.11
            @Override // java.util.function.Supplier
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public String get() {
                TTCustomController tTCustomController2 = TTCustomController.this;
                if (tTCustomController2 == null) {
                    return null;
                }
                return tTCustomController2.getDevImei();
            }
        });
        a6.g(262106, new Supplier<Boolean>() { // from class: com.bytedance.sdk.openadsdk.i.j.cw.r.12
            @Override // java.util.function.Supplier
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                TTCustomController tTCustomController2 = TTCustomController.this;
                return Boolean.valueOf(tTCustomController2 == null || tTCustomController2.isCanUseWifiState());
            }
        });
        a6.g(262107, new Supplier<String>() { // from class: com.bytedance.sdk.openadsdk.i.j.cw.r.13
            @Override // java.util.function.Supplier
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public String get() {
                TTCustomController tTCustomController2 = TTCustomController.this;
                if (tTCustomController2 == null) {
                    return null;
                }
                return tTCustomController2.getMacAddress();
            }
        });
        a6.g(262108, new Supplier<Boolean>() { // from class: com.bytedance.sdk.openadsdk.i.j.cw.r.14
            @Override // java.util.function.Supplier
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                TTCustomController tTCustomController2 = TTCustomController.this;
                return Boolean.valueOf(tTCustomController2 == null || tTCustomController2.isCanUseWriteExternal());
            }
        });
        a6.g(262109, new Supplier<String>() { // from class: com.bytedance.sdk.openadsdk.i.j.cw.r.15
            @Override // java.util.function.Supplier
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public String get() {
                TTCustomController tTCustomController2 = TTCustomController.this;
                if (tTCustomController2 == null) {
                    return null;
                }
                return tTCustomController2.getDevOaid();
            }
        });
        a6.g(262110, new Supplier<Boolean>() { // from class: com.bytedance.sdk.openadsdk.i.j.cw.r.2
            @Override // java.util.function.Supplier
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                TTCustomController tTCustomController2 = TTCustomController.this;
                return Boolean.valueOf(tTCustomController2 == null || tTCustomController2.isCanUseAndroidId());
            }
        });
        if (tTCustomController != null && tTCustomController.getMediationPrivacyConfig() != null) {
            sparseArray = com.bytedance.sdk.openadsdk.mediation.init.j.j.j.xt.j(tTCustomController.getMediationPrivacyConfig());
        } else {
            sparseArray = null;
        }
        a6.g(262113, sparseArray);
        a6.g(262112, new Supplier<String>() { // from class: com.bytedance.sdk.openadsdk.i.j.cw.r.3
            @Override // java.util.function.Supplier
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public String get() {
                TTCustomController tTCustomController2 = TTCustomController.this;
                if (tTCustomController2 == null) {
                    return null;
                }
                return tTCustomController2.getAndroidId();
            }
        });
        a6.g(262111, new Supplier<Boolean>() { // from class: com.bytedance.sdk.openadsdk.i.j.cw.r.4
            @Override // java.util.function.Supplier
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                TTCustomController tTCustomController2 = TTCustomController.this;
                return Boolean.valueOf(tTCustomController2 == null || tTCustomController2.isCanUsePermissionRecordAudio());
            }
        });
        a6.g(262119, new Supplier<Map>() { // from class: com.bytedance.sdk.openadsdk.i.j.cw.r.5
            @Override // java.util.function.Supplier
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public Map get() {
                TTCustomController tTCustomController2 = TTCustomController.this;
                if (tTCustomController2 == null) {
                    return null;
                }
                return tTCustomController2.userPrivacyConfig();
            }
        });
        a6.g(262120, new Supplier<Boolean>() { // from class: com.bytedance.sdk.openadsdk.i.j.cw.r.6
            @Override // java.util.function.Supplier
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                TTCustomController tTCustomController2 = TTCustomController.this;
                return Boolean.valueOf(tTCustomController2 == null || tTCustomController2.isCanUseMessage());
            }
        });
        a6.g(262121, new Supplier<Boolean>() { // from class: com.bytedance.sdk.openadsdk.i.j.cw.r.7
            @Override // java.util.function.Supplier
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                return Boolean.valueOf(TTCustomController.this == null);
            }
        });
        return a6.k().sparseArray();
    }
}
