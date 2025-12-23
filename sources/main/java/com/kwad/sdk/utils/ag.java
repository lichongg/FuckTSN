package com.kwad.sdk.utils;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.service.ServiceProvider;
import com.stub.StubApp;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class ag {
    private static String sAppTag = "";

    public static void QH() {
        b("ksadsdk_perf", "image_load_total", c("ksadsdk_perf", "image_load_total", 0) + 1);
    }

    public static void QI() {
        b("ksadsdk_perf", "image_load_suc", c("ksadsdk_perf", "image_load_suc", 0) + 1);
    }

    public static void QJ() {
        b("ksadsdk_perf", "image_load_failed", c("ksadsdk_perf", "image_load_failed", 0) + 1);
    }

    public static void a(String str, String str2, String str3, boolean z5) {
        Context context = getContext();
        if (context == null) {
            return;
        }
        a(context, str, str2, str3, true);
    }

    public static long b(String str, String str2, long j6) {
        Context context = getContext();
        return context == null ? j6 : b(context, str, str2, j6);
    }

    public static void ba(long j6) {
        b("ksadsdk_perf", "image_load_complete_count", c("ksadsdk_perf", "image_load_complete_count", 0) + 1);
        a("ksadsdk_perf", "image_load_complete_total", b("ksadsdk_perf", "image_load_complete_total", 0L) + j6);
    }

    public static void c(@NonNull Context context, boolean z5) {
        if (context == null) {
            return;
        }
        b(context, "ksadsdk_uaid_enable", "KEY_SDK_UAID_ENABLE", z5);
    }

    public static int cV(@NonNull Context context) {
        if (context == null) {
            return 0;
        }
        return b(context, "ksadsdk_config_request", "KEY_CONFIG_REQUEST_FAIL", 0);
    }

    public static int cX(@NonNull Context context) {
        if (context == null) {
            return 0;
        }
        return b(context, "ksadsdk_reward_full_ad_jump_direct", "KEY_REWARD_AD_SHOW_INTERACT_INTERVAL_SHOW_COUNT", 0);
    }

    public static void e(Context context, String str, long j6) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_pref", str, j6);
    }

    public static void f(Context context, String str, long j6) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_download_package_length", str, j6);
    }

    public static void g(Context context, String str, String str2) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_download_package_md5", str, str2);
    }

    public static String h(String str, String str2, String str3) {
        Context context = getContext();
        return context == null ? str3 : b(context, str, str2, str3);
    }

    public static void l(@NonNull Context context, int i6) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_config_request", "KEY_CONFIG_REQUEST_FAIL", i6);
    }

    public static void m(@NonNull Context context, int i6) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_reward_full_ad_jump_direct", "KEY_REWARD_AD_SHOW_INTERACT_INTERVAL_SHOW_COUNT", i6);
    }

    public static long QF() {
        return b("ksadsdk_push_ad_common", "key_push_last_show_time", -1L);
    }

    public static double QK() {
        int c6 = c("ksadsdk_perf", "image_load_complete_count", 0);
        long b6 = b("ksadsdk_perf", "image_load_complete_total", 0L);
        b("ksadsdk_perf", "image_load_complete_count", 0);
        a("ksadsdk_perf", "image_load_complete_total", 0L);
        if (c6 == 0) {
            return 0.0d;
        }
        return b6 / c6;
    }

    public static int QL() {
        int c6 = c("ksadsdk_perf", "image_load_total", 0);
        com.kwad.sdk.core.d.c.d("Ks_UnionUtils", "imageLoadTotal:" + c6);
        b("ksadsdk_perf", "image_load_total", 0);
        return c6;
    }

    public static int QM() {
        int c6 = c("ksadsdk_perf", "image_load_suc", 0);
        com.kwad.sdk.core.d.c.d("Ks_UnionUtils", "imageLoadSuccess:" + c6);
        b("ksadsdk_perf", "image_load_suc", 0);
        return c6;
    }

    public static int QN() {
        int c6 = c("ksadsdk_perf", "image_load_failed", 0);
        com.kwad.sdk.core.d.c.d("Ks_UnionUtils", "imageLoadFailed:" + c6);
        b("ksadsdk_perf", "image_load_failed", 0);
        return c6;
    }

    public static String Qx() {
        return h("ksadsdk_interstitial_daily_show_count", "KEY_INTERSTITIAL_AUTO_CALL_APP_CARD_SHOW_COUNT", "");
    }

    public static String Qy() {
        if (!TextUtils.isEmpty(sAppTag)) {
            return sAppTag;
        }
        Context context = getContext();
        return context == null ? "" : b(context, "ksadsdk_pref", "appTag", "");
    }

    public static long V(Context context, String str) {
        if (context == null) {
            return 0L;
        }
        return b(context, "ksadsdk_pref", str, 0L);
    }

    public static long W(Context context, String str) {
        if (context == null) {
            return 0L;
        }
        return b(context, "ksadsdk_download_package_length", str, 0L);
    }

    public static String X(Context context, String str) {
        return context == null ? "" : b(context, "ksadsdk_download_package_md5", str, "");
    }

    public static void Y(@NonNull Context context, String str) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_egid", "KEY_SDK_EGID", str);
    }

    public static void Z(@NonNull Context context, String str) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_uaid", "KEY_SDK_UAID", str);
    }

    public static void aZ(long j6) {
        a("ksadsdk_push_ad_common", "key_push_last_show_time", j6);
    }

    public static void aa(@NonNull Context context, String str) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_uaid_token", "KEY_SDK_UAID_TOKEN", str);
    }

    public static void ab(@NonNull Context context, String str) {
        if (context == null) {
            return;
        }
        a("ksadsdk_model", "KEY_SDK_MODEL", str, true);
    }

    public static void ac(Context context, String str) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_interstitial_daily_show_count", "KEY_INTERSTITIAL_DAILY_SHOW_COUNT", str);
    }

    public static void ad(@NonNull Context context, String str) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_reward_full_ad_jump_direct", "KEY_REWARD_INTERACT_AD_SHOW_INFO", str);
    }

    public static void ae(Context context, String str) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_reward_full_ad_jump_direct", "KEY_REWARD_FULL_AD_JUMP_DIRECT", str);
    }

    public static void af(@NonNull Context context, String str) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_splash_local_ad_force_active", "KEY_SPLASH_DAILY_SHOW_COUNT", str);
        bn.RJ();
    }

    public static void ag(Context context, String str) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_reward_full_ad_jump_direct", "KEY_REWARD_AUTO_CALL_APP_CARD_SHOW_COUNT", str);
        bn.RL();
    }

    public static void ah(Context context, String str) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_interstitial_daily_show_count", "KEY_INTERSTITIAL_AUTO_CALL_APP_CARD_SHOW_COUNT", str);
    }

    public static void ai(@NonNull Context context, String str) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_device_sig", "KEY_SDK_DEVICE_SIG", str);
    }

    public static void aj(Context context, final String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        h.execute(new bg() { // from class: com.kwad.sdk.utils.ag.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                ag.ak(ServiceProvider.getContext(), str);
            }
        });
    }

    public static void ak(Context context, String str) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_pref", "appTag", str);
    }

    public static void al(Context context, String str) {
        if (context == null) {
            return;
        }
        a("ksadsdk_pref", "webview_ua", str, true);
    }

    @WorkerThread
    public static void am(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        bn.j(StubApp.getOrigApplicationContext(context.getApplicationContext()), "ksadsdk_sdk_config_data", str);
    }

    public static void an(Context context, String str) {
        if (context == null) {
            return;
        }
        g("ksadsdk_install_tips_show_count", "init_install_tips_show_count", str);
    }

    public static int c(String str, String str2, int i6) {
        Context context = getContext();
        return context == null ? i6 : b(context, str, str2, i6);
    }

    public static String cR(@NonNull Context context) {
        return context == null ? "" : b(context, "ksadsdk_egid", "KEY_SDK_EGID", "");
    }

    private static String cS(@NonNull Context context) {
        return context == null ? "" : b(context, "ksadsdk_uaid", "KEY_SDK_UAID", "");
    }

    public static String cT(@NonNull Context context) {
        return context == null ? "" : b(context, "ksadsdk_uaid_token", "KEY_SDK_UAID_TOKEN", "");
    }

    public static long cU(@NonNull Context context) {
        if (context == null) {
            return 0L;
        }
        return b(context, "ksadsdk_gidExpireTimeMs", "KEY_SDK_EGID", 0L);
    }

    public static String cW(@NonNull Context context) {
        if (context == null) {
            return "";
        }
        String b6 = b(context, "ksadsdk_model", "KEY_SDK_MODEL", "");
        bo.i(b6, "ksadsdk_model", "KEY_SDK_MODEL");
        return b6;
    }

    public static String cY(@NonNull Context context) {
        return context == null ? "" : b(context, "ksadsdk_reward_full_ad_jump_direct", "KEY_REWARD_INTERACT_AD_SHOW_INFO", "");
    }

    public static String cZ(@NonNull Context context) {
        return context == null ? "" : b(context, "ksadsdk_device_sig", "KEY_SDK_DEVICE_SIG", "");
    }

    public static void d(@NonNull Context context, long j6) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_gidExpireTimeMs", "KEY_SDK_EGID", j6);
    }

    public static String da(Context context) {
        if (context == null) {
            return "";
        }
        String h6 = h("ksadsdk_pref", "webview_ua", "");
        bo.i(h6, "ksadsdk_pref", "webview_ua");
        return h6;
    }

    public static void e(@NonNull Context context, long j6) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_uaid_create_time", "KEY_SDK_UAID_CREATE_TIME", j6);
    }

    public static void f(@NonNull Context context, long j6) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_uaid_expire_sec", "KEY_SDK_UAID_EXPIRE_SEC", j6);
    }

    public static void g(String str, String str2, String str3) {
        Context context = getContext();
        if (context == null) {
            return;
        }
        a(context, str, str2, str3);
    }

    public static void l(String str, String str2, boolean z5) {
        Context context = getContext();
        if (context == null) {
            return;
        }
        b(context, str, str2, z5);
    }

    public static boolean m(String str, String str2, boolean z5) {
        Context context = getContext();
        return context == null ? z5 : c(context, str, str2, z5);
    }

    public static String QA() {
        Context context = getContext();
        if (context == null) {
            return "";
        }
        return cS(context);
    }

    public static String QB() {
        Context context = getContext();
        if (context == null) {
            return "";
        }
        return cT(context);
    }

    public static boolean QC() {
        if (!TextUtils.isEmpty(QB())) {
            return true;
        }
        return false;
    }

    public static boolean QD() {
        if (!TextUtils.isEmpty(QA()) && !QE()) {
            return true;
        }
        return false;
    }

    private static boolean QE() {
        long currentTimeMillis = (System.currentTimeMillis() - Qs()) / 1000;
        long Qr = Qr();
        if (Qr == 0 || currentTimeMillis < Qr) {
            return false;
        }
        return true;
    }

    public static String QG() {
        if (getContext() == null) {
            return "";
        }
        return h("ksadsdk_install_tips_show_count", "init_install_tips_show_count", "");
    }

    public static boolean Qq() {
        return c(getContext(), "ksadsdk_uaid_enable", "KEY_SDK_UAID_ENABLE", false);
    }

    public static long Qr() {
        return b(getContext(), "ksadsdk_uaid_expire_sec", "KEY_SDK_UAID_EXPIRE_SEC", 0L);
    }

    private static long Qs() {
        return b(getContext(), "ksadsdk_uaid_create_time", "KEY_SDK_UAID_CREATE_TIME", 0L);
    }

    public static String Qt() {
        Context context = getContext();
        if (context == null) {
            return "";
        }
        return b(context, "ksadsdk_interstitial_daily_show_count", "KEY_INTERSTITIAL_DAILY_SHOW_COUNT", "");
    }

    public static String Qu() {
        Context context = getContext();
        if (context == null) {
            return "";
        }
        return b(context, "ksadsdk_reward_full_ad_jump_direct", "KEY_REWARD_FULL_AD_JUMP_DIRECT", "");
    }

    public static String Qv() {
        Context context = getContext();
        if (context == null) {
            return "";
        }
        if (bn.RK()) {
            return b(context, "ksadsdk_splash_local_ad_force_active", "KEY_SPLASH_DAILY_SHOW_COUNT", "");
        }
        return b(context, "ksadsdk_splash_daily_show_count", "KEY_SPLASH_DAILY_SHOW_COUNT", "");
    }

    public static String Qw() {
        Context context = getContext();
        if (context == null) {
            return "";
        }
        if (bn.RM()) {
            return h("ksadsdk_reward_full_ad_jump_direct", "KEY_REWARD_AUTO_CALL_APP_CARD_SHOW_COUNT", "");
        }
        return b(context, "ksadsdk_reward_auto_call_app_card_show_count", "KEY_REWARD_AUTO_CALL_APP_CARD_SHOW_COUNT", "");
    }

    public static String Qz() {
        Context context = getContext();
        if (context == null) {
            return "";
        }
        return cR(context);
    }

    public static void a(String str, String str2, long j6) {
        Context context = getContext();
        if (context == null) {
            return;
        }
        a(context, str, str2, j6);
    }

    public static void b(String str, String str2, int i6) {
        Context context = getContext();
        if (context == null) {
            return;
        }
        a(context, str, str2, i6);
    }

    @WorkerThread
    public static String db(Context context) {
        if (bn.RH()) {
            return bn.ax(StubApp.getOrigApplicationContext(context.getApplicationContext()), "ksadsdk_sdk_config_data");
        }
        String h6 = bo.h("ksadsdk_sdk_config_data", "config_str", "");
        bn.i(StubApp.getOrigApplicationContext(context.getApplicationContext()), "ksadsdk_sdk_config_data", h6);
        return h6;
    }

    @Nullable
    public static Context getContext() {
        return ServiceProvider.Pp();
    }

    public static void h(Context context, String str, String str2) {
        if (context == null) {
            return;
        }
        if (af.gX(str)) {
            bo.ay(str, str2);
        } else {
            com.kwad.sdk.utils.a.e.ay(context, str).remove(str2);
            af.at(str2, "");
        }
    }

    public static void i(String str, String str2, String str3) {
        if (!af.gX(str2)) {
            return;
        }
        bo.i(str, str2, str3);
    }

    private static boolean c(Context context, String str, String str2, boolean z5) {
        if (context == null) {
            return z5;
        }
        if (af.gX(str)) {
            return bo.m(str, str2, z5);
        }
        return com.kwad.sdk.utils.a.e.ay(context, str).getBoolean(str2, z5);
    }

    public static void a(Context context, @NonNull String str, @NonNull String str2, String str3) {
        if (context == null) {
            return;
        }
        if (af.gX(str)) {
            bo.g(str, str2, str3);
            if (com.kwad.framework.a.a.oz.booleanValue()) {
                com.kwad.sdk.core.d.c.d("Ks_UnionUtils", "putString Sp key:" + str2 + " value:" + str3);
                return;
            }
            return;
        }
        com.kwad.sdk.utils.a.e.ay(context, str).putString(str2, str3);
        if (com.kwad.framework.a.a.oz.booleanValue()) {
            com.kwad.sdk.core.d.c.d("Ks_UnionUtils", "putString key:" + str2 + " value:" + str3);
        }
        af.at(str2, str3);
    }

    public static String b(Context context, String str, String str2, String str3) {
        String string;
        if (context == null) {
            return str3;
        }
        if (af.gX(str)) {
            string = bo.h(str, str2, str3);
            if (com.kwad.framework.a.a.oz.booleanValue()) {
                com.kwad.sdk.core.d.c.d("Ks_UnionUtils", "getString From Sp key:" + str2 + " value:" + string);
            }
        } else {
            string = com.kwad.sdk.utils.a.e.ay(context, str).getString(str2, str3);
            af.au(str2, string);
            if (com.kwad.framework.a.a.oz.booleanValue()) {
                com.kwad.sdk.core.d.c.d("Ks_UnionUtils", "getString key:" + str2 + " value:" + string);
            }
        }
        return com.kwad.sdk.core.a.c.isEncodeKsSdk(string) ? com.kwad.sdk.core.a.c.decodeKsSdk(string) : string;
    }

    private static void a(Context context, @NonNull String str, @NonNull String str2, String str3, boolean z5) {
        if (context == null) {
            return;
        }
        if (af.gX(str)) {
            bo.a(str, str2, str3, z5);
            if (com.kwad.framework.a.a.oz.booleanValue()) {
                com.kwad.sdk.core.d.c.d("Ks_UnionUtils", "putString Sp key:" + str2 + " value:" + str3);
                return;
            }
            return;
        }
        com.kwad.sdk.utils.a.e.ay(context, str).putString(str2, str3);
        if (com.kwad.framework.a.a.oz.booleanValue()) {
            com.kwad.sdk.core.d.c.d("Ks_UnionUtils", "putString key:" + str2 + " value:" + str3);
        }
        af.at(str2, str3);
    }

    private static long b(Context context, String str, String str2, long j6) {
        if (context == null) {
            return j6;
        }
        if (af.gX(str)) {
            return bo.b(str, str2, j6);
        }
        return com.kwad.sdk.utils.a.e.ay(context, str).getLong(str2, j6);
    }

    private static int b(Context context, String str, String str2, int i6) {
        if (context == null) {
            return i6;
        }
        if (af.gX(str)) {
            return bo.c(str, str2, i6);
        }
        return com.kwad.sdk.utils.a.e.ay(context, str).getInt(str2, i6);
    }

    private static void a(Context context, String str, String str2, long j6) {
        if (context == null) {
            return;
        }
        if (af.gX(str)) {
            bo.a(str, str2, j6);
        } else {
            com.kwad.sdk.utils.a.e.ay(context, str).putLong(str2, j6);
        }
    }

    private static void b(Context context, String str, String str2, boolean z5) {
        if (context == null) {
            return;
        }
        if (af.gX(str)) {
            bo.l(str, str2, z5);
        } else {
            com.kwad.sdk.utils.a.e.ay(context, str).putBoolean(str2, z5);
        }
    }

    private static void a(Context context, String str, String str2, int i6) {
        if (context == null) {
            return;
        }
        if (af.gX(str)) {
            bo.b(str, str2, i6);
        } else {
            com.kwad.sdk.utils.a.e.ay(context, str).putInt(str2, i6);
        }
    }
}
