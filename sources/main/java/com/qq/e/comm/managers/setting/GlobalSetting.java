package com.qq.e.comm.managers.setting;

import android.text.TextUtils;
import com.qq.e.comm.util.GDTLogger;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class GlobalSetting {
    public static final String ADMOB_SDK_WRAPPER = "ADMOB";
    public static final String AGREE_PRIVACY_KEY = "agree_privacy";
    public static final String AGREE_READ_AAID = "allow_read_aaid";
    public static final String APPLOVIN_SDK_WRAPPER = "APPLOVIN";
    public static final String BD_SDK_WRAPPER = "BD";
    public static final String CCPA = "ccpa";
    public static final String CONV_OPTIMIZE_KEY = "conv_opt_info";
    public static final String COPPA = "coppa";
    public static final String CUSTOM_INFO_KEY = "custom_info";
    public static final String DARK_MODE_KEY = "dark_mode_info";
    public static final String FACEBOOK_SDK_WRAPPER = "FACEBOOK";
    public static final String GDPR = "gdpr";
    public static final String KS_SDK_WRAPPER = "KS";
    public static final String NATIVE_EXPRESS_AD = "4";
    public static final String NATIVE_UNIFIED_AD = "6";
    public static final String OVERSEA_PRIVACY_INFO = "oversea_privacy_info";
    public static final String PAG_SDK_WRAPPER = "PAG";
    public static final String REWARD_VIDEO_AD = "5";
    public static final String SPLASH_AD = "3";
    public static final String TT_SDK_WRAPPER = "TT";
    public static final String UNIFIED_BANNER_AD = "7";
    public static final String UNIFIED_INTERSTITIAL_FS_AD = "9";
    public static final String UNIFIED_INTERSTITIAL_HS_AD = "8";

    /* renamed from: a, reason: collision with root package name */
    private static volatile Integer f36790a = null;

    /* renamed from: b, reason: collision with root package name */
    private static volatile boolean f36791b = false;

    /* renamed from: c, reason: collision with root package name */
    private static volatile boolean f36792c = true;

    /* renamed from: d, reason: collision with root package name */
    private static volatile Integer f36793d;

    /* renamed from: e, reason: collision with root package name */
    private static volatile Boolean f36794e;

    /* renamed from: f, reason: collision with root package name */
    private static volatile Boolean f36795f;

    /* renamed from: g, reason: collision with root package name */
    private static volatile Boolean f36796g;

    /* renamed from: h, reason: collision with root package name */
    private static volatile Map<String, String> f36797h = new HashMap();

    /* renamed from: i, reason: collision with root package name */
    private static volatile Map<String, String> f36798i = new HashMap();

    /* renamed from: j, reason: collision with root package name */
    private static final Map<String, String> f36799j = new HashMap();

    /* renamed from: k, reason: collision with root package name */
    private static final JSONObject f36800k = new JSONObject();

    /* renamed from: l, reason: collision with root package name */
    private static volatile String f36801l = null;

    /* renamed from: m, reason: collision with root package name */
    private static volatile String f36802m = null;

    /* renamed from: n, reason: collision with root package name */
    private static volatile String f36803n = null;

    /* renamed from: o, reason: collision with root package name */
    private static volatile String f36804o = null;

    /* renamed from: p, reason: collision with root package name */
    private static volatile String f36805p = null;

    public static Boolean getAgreeReadAndroidId() {
        return f36796g;
    }

    public static Boolean getAgreeReadDeviceId() {
        return f36795f;
    }

    public static Integer getChannel() {
        return f36790a;
    }

    public static String getCustomADActivityClassName() {
        return f36801l;
    }

    public static String getCustomLandscapeActivityClassName() {
        return f36804o;
    }

    public static String getCustomPortraitActivityClassName() {
        return f36802m;
    }

    public static String getCustomRewardvideoLandscapeActivityClassName() {
        return f36805p;
    }

    public static String getCustomRewardvideoPortraitActivityClassName() {
        return f36803n;
    }

    public static Map<String, String> getExtraUserData() {
        return Collections.unmodifiableMap(f36797h);
    }

    public static Integer getPersonalizedState() {
        return f36793d;
    }

    public static Map<String, String> getPreloadAdapterMaps() {
        return f36799j;
    }

    public static JSONObject getSettings() {
        return f36800k;
    }

    public static boolean isAgreePrivacyStrategy() {
        return f36794e == null || f36794e.booleanValue();
    }

    public static boolean isAgreeReadAndroidId() {
        if (f36796g == null) {
            return true;
        }
        return f36796g.booleanValue();
    }

    public static boolean isAgreeReadDeviceId() {
        if (f36795f == null) {
            return true;
        }
        return f36795f.booleanValue();
    }

    public static boolean isEnableMediationTool() {
        return f36791b;
    }

    public static boolean isEnableVideoDownloadingCache() {
        return f36792c;
    }

    public static void setAgreePrivacyStrategy(boolean z5) {
        if (f36794e == null) {
            f36794e = Boolean.valueOf(z5);
        }
    }

    public static void setAgreeReadPrivacyInfo(Map<String, Boolean> map) {
        if (map == null || map.size() == 0) {
            return;
        }
        try {
            f36800k.putOpt(AGREE_PRIVACY_KEY, new JSONObject(map));
        } catch (Exception e6) {
            GDTLogger.e("setAgreeReadPrivacyInfo错误：" + e6.toString());
        }
    }

    public static void setChannel(int i6) {
        if (f36790a == null) {
            f36790a = Integer.valueOf(i6);
        }
    }

    public static void setConvOptimizeInfo(Map<String, Boolean> map) {
        if (map == null || map.size() == 0) {
            return;
        }
        try {
            f36800k.putOpt(CONV_OPTIMIZE_KEY, new JSONObject(map));
        } catch (Exception e6) {
            GDTLogger.e("setConvOptimizeInfo错误：" + e6.toString());
        }
    }

    public static void setCustomADActivityClassName(String str) {
        f36801l = str;
    }

    public static void setCustomInfo(Map<String, Map<String, String>> map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        try {
            f36800k.putOpt(CUSTOM_INFO_KEY, new JSONObject(map));
        } catch (Exception e6) {
            GDTLogger.e("setCustomInfo：" + e6);
        }
    }

    public static void setCustomLandscapeActivityClassName(String str) {
        f36804o = str;
    }

    public static void setCustomPortraitActivityClassName(String str) {
        f36802m = str;
    }

    public static void setCustomRewardvideoLandscapeActivityClassName(String str) {
        f36805p = str;
    }

    public static void setCustomRewardvideoPortraitActivityClassName(String str) {
        f36803n = str;
    }

    public static void setEnableCollectAppInstallStatus(boolean z5) {
        try {
            f36800k.putOpt("ecais", Boolean.valueOf(z5));
        } catch (JSONException unused) {
        }
    }

    public static void setEnableMediationTool(boolean z5) {
        f36791b = z5;
    }

    public static void setEnableVideoDownloadingCache(boolean z5) {
        f36792c = z5;
    }

    public static void setExtraUserData(Map<String, String> map) {
        if (map == null) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (TextUtils.isEmpty(entry.getKey()) || TextUtils.isEmpty(entry.getValue())) {
                GDTLogger.e("参数key和value不能为空！");
                return;
            }
        }
        f36797h = map;
    }

    public static void setMediaExtData(Map<String, String> map, boolean z5) {
        if (map == null) {
            return;
        }
        if (z5) {
            f36798i = new HashMap();
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (!TextUtils.isEmpty(entry.getKey()) && !TextUtils.isEmpty(entry.getValue())) {
                f36798i.put(entry.getKey(), entry.getValue());
            }
        }
        try {
            f36800k.putOpt("media_ext", new JSONObject(f36798i));
        } catch (JSONException unused) {
            GDTLogger.e("setMediaExtData失败，请检查");
        }
    }

    public static void setPreloadAdapters(Map<String, String> map) {
        if (map == null) {
            return;
        }
        f36799j.putAll(map);
    }

    @Deprecated
    public static void setAgreeReadAndroidId(boolean z5) {
        f36796g = Boolean.valueOf(z5);
    }

    @Deprecated
    public static void setAgreeReadDeviceId(boolean z5) {
        f36795f = Boolean.valueOf(z5);
    }

    public static void setPersonalizedState(int i6) {
        f36793d = Integer.valueOf(i6);
    }
}
