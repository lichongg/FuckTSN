package com.bytedance.sdk.openadsdk;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import com.bytedance.sdk.openadsdk.api.j;
import com.bytedance.sdk.openadsdk.api.m;
import com.bytedance.sdk.openadsdk.api.plugin.oq;
import com.bytedance.sdk.openadsdk.api.up;
import com.bytedance.sdk.openadsdk.live.cw;
import com.bytedance.sdk.openadsdk.mediation.IMediationManager;
import com.bytedance.sdk.openadsdk.mediation.MediationManagerVisitor;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes4.dex */
public final class TTAdSdk {
    public static final String BRANCH = "";
    public static final String BUILT_IN_PLUGIN_NAME = "com.byted.pangle";
    public static final String C_H = "eaa0e8245f";
    public static final int EXT_API_VERSION_CODE = 999;
    public static final boolean INCLUDE_LIVE = true;
    public static final String INITIALIZER_CLASS_NAME = "com.bytedance.sdk.openadsdk.core.AdSdkInitializerHolder";
    public static final boolean IS_BOOST = true;
    public static final boolean IS_P = false;
    public static final String LIVE_PLUGIN_PACKAGE_NAME = "com.byted.live.lite";
    public static final boolean ONLY_API = false;
    public static final String PC_KEEP_ABI = "null";
    public static final String PC_KEEP_SO = "null";
    public static final String PLUGIN_ADAPTER_PACKAGE_NAME = "com.byted.mixed";
    public static final int SDK_VERSION_CODE = 7012;
    public static final String SDK_VERSION_NAME = "7.0.1.2";
    public static final String S_C = "main";

    /* renamed from: j, reason: collision with root package name */
    private static final j f27512j = new oq();
    private static volatile TTAdConfig xt;

    public interface Callback extends InitCallback {
    }

    @Deprecated
    public interface InitCallback {
        void fail(int i6, String str);

        void success();
    }

    private static void j(Context context, TTAdConfig tTAdConfig) {
        if (tTAdConfig != null && tTAdConfig.isDebug()) {
            m.j();
        }
        if (Looper.getMainLooper() != Looper.myLooper()) {
            m.xt("Wrong Thread ! Please exec TTAdSdk.init in main thread.");
        }
        j(context, "Context is null, please check.");
        j(tTAdConfig, "TTAdConfig is null, please check.");
        TTAppContextHolder.setContext(context);
        updateConfigAuth(tTAdConfig);
    }

    public static TTAdManager getAdManager() {
        j jVar = f27512j;
        if (jVar != null) {
            return jVar.xt();
        }
        return null;
    }

    public static View getEcMallBackUpView() {
        j.cw xt2 = f27512j.xt();
        if (xt2 == null) {
            return null;
        }
        return (View) xt2.getExtra(View.class, null);
    }

    public static IMediationManager getMediationManager() {
        if (f27512j != null) {
            return MediationManagerVisitor.getInstance().getMediationManager();
        }
        return null;
    }

    public static boolean init(Context context, TTAdConfig tTAdConfig) {
        xt = tTAdConfig;
        j(context, xt);
        return true;
    }

    @Deprecated
    public static boolean isInitSuccess() {
        j jVar = f27512j;
        if (jVar != null) {
            return jVar.j();
        }
        return false;
    }

    public static boolean isSdkReady() {
        j jVar = f27512j;
        if (jVar != null) {
            return jVar.j();
        }
        return false;
    }

    public static void start(Callback callback) {
        j(xt, "TTAdConfig is null, please exec TTAdSdk.init before TTAdSdk.start.");
        j jVar = f27512j;
        if (jVar == null) {
            callback.fail(4100, "Load initializer failed");
        } else {
            jVar.j(TTAppContextHolder.getContext(), xt, callback);
        }
    }

    public static void updatePaid(boolean z5) {
        j.cw xt2 = f27512j.xt();
        if (xt2 == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_paid", z5);
        if (bundle.keySet().isEmpty()) {
            return;
        }
        xt2.getExtra(SparseArray.class, bundle);
    }

    public static boolean isOpenMediationMap() {
        TTAdManager adManager = getAdManager();
        if (adManager != null) {
            Bundle bundle = new Bundle();
            bundle.putString("extra_name", "use_mediation_map");
            Map map = (Map) adManager.getExtra(Map.class, bundle);
            if (map != null && (map.get("use_mediation_map") instanceof Boolean)) {
                return ((Boolean) map.get("use_mediation_map")).booleanValue();
            }
            return false;
        }
        return false;
    }

    public static void updateAdConfig(TTAdConfig tTAdConfig) {
        j.cw xt2;
        if (!up.j() && tTAdConfig != null && (xt2 = f27512j.xt()) != null) {
            Bundle bundle = new Bundle();
            if (!TextUtils.isEmpty(tTAdConfig.getData())) {
                bundle.putString("extra_data", tTAdConfig.getData());
            }
            if (!TextUtils.isEmpty(tTAdConfig.getKeywords())) {
                bundle.putString("keywords", tTAdConfig.getKeywords());
            }
            if (!bundle.keySet().isEmpty()) {
                xt2.getExtra(SparseArray.class, bundle);
            }
            IMediationManager mediationManager = getMediationManager();
            if (mediationManager != null) {
                if (tTAdConfig.getCustomController() != null) {
                    mediationManager.updatePrivacyConfig(tTAdConfig.getCustomController());
                }
                Map<String, Object> initExtra = tTAdConfig.getInitExtra();
                if (initExtra != null && !initExtra.isEmpty()) {
                    mediationManager.updateLocalExtra(tTAdConfig.getInitExtra());
                }
            }
        }
    }

    public static void updateConfigAuth(TTAdConfig tTAdConfig) {
        Map<String, Object> initExtra;
        if (!up.j() && tTAdConfig != null && (initExtra = tTAdConfig.getInitExtra()) != null) {
            Object obj = initExtra.get(TTAdConstant.KEY_INIT_FOR_LIVE);
            if (obj instanceof Map) {
                cw.j().j((Map<String, String>) obj);
            }
        }
    }

    private static void j(Object obj, String str) {
        if (obj == null) {
            throw new IllegalArgumentException(str);
        }
    }
}
