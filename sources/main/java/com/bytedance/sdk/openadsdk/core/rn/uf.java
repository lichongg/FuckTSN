package com.bytedance.sdk.openadsdk.core.rn;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.LocaleList;
import android.os.Looper;
import android.os.StatFs;
import android.text.TextUtils;
import android.webkit.WebSettings;
import com.baidu.idl.face.platform.FaceEnvironment;
import com.bytedance.component.sdk.annotation.HungeonFlag;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
import com.bytedance.sdk.openadsdk.core.activity.base.TTNativePageActivity;
import com.bytedance.sdk.openadsdk.core.activity.base.TTVideoScrollWebPageActivity;
import com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity;
import com.bytedance.sdk.openadsdk.core.activity.base.TTWebPageActivity;
import com.bytedance.sdk.openadsdk.core.tj.aq;
import com.bytedance.sdk.openadsdk.core.tj.hh;
import com.bytedance.sdk.openadsdk.core.tj.ln;
import com.bytedance.sdk.openadsdk.core.tj.rr;
import com.bytedance.sdk.openadsdk.core.tj.xp;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.umeng.analytics.pro.bi;
import com.umeng.socialize.common.SocializeConstants;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class uf {
    public static volatile long ae = 0;
    public static volatile int cw = 0;

    /* renamed from: j, reason: collision with root package name */
    public static volatile int f30158j = 0;

    /* renamed from: m, reason: collision with root package name */
    public static volatile long f30159m = 0;
    private static long qv = -1;

    /* renamed from: r, reason: collision with root package name */
    public static volatile String f30160r = null;
    public static volatile int tl = -1;
    public static volatile long up;
    private static volatile boolean vl;
    public static volatile int xt;
    private static final AtomicBoolean jy = new AtomicBoolean(false);
    private static volatile String ws = "";
    private static volatile String az = null;
    private static volatile String av = null;

    /* renamed from: i, reason: collision with root package name */
    private static volatile String f30157i = null;

    /* renamed from: g, reason: collision with root package name */
    public static String f30156g = null;
    public static String oq = null;

    /* renamed from: com.bytedance.sdk.openadsdk.core.rn.uf$4, reason: invalid class name */
    static class AnonymousClass4 implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            try {
                String unused = uf.ws = uf.av(new SSWebView(com.bytedance.sdk.openadsdk.core.v.getContext()).getUserAgentString());
                com.bytedance.sdk.openadsdk.core.cw.r.j().r("sdk_local_web_ua", uf.ws);
            } catch (Exception unused2) {
            }
        }

        AnonymousClass4() {
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.core.rn.uf$5, reason: invalid class name */
    static class AnonymousClass5 implements FilenameFilter {

        /* renamed from: j, reason: collision with root package name */
        private Pattern f30161j = Pattern.compile("^cpu[0-9]+$");

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return this.f30161j.matcher(str).matches();
        }

        AnonymousClass5() {
        }
    }

    public static boolean ae(com.bytedance.sdk.openadsdk.core.tj.n nVar) {
        JSONObject ot;
        if (nVar == null || (ot = nVar.ot()) == null) {
            return false;
        }
        try {
            int optInt = new JSONObject(ot.optString("compliance_data")).optJSONObject(bi.az).optInt("pricing_type");
            return optInt == 3 || optInt == 6;
        } catch (Exception e6) {
            com.bytedance.sdk.component.utils.vl.r("ToolUtils", "error:" + e6.getMessage());
            return false;
        }
    }

    public static String av(com.bytedance.sdk.openadsdk.core.tj.n nVar) {
        if (nVar == null) {
            return "";
        }
        com.bytedance.sdk.openadsdk.core.tj.up by = nVar.by();
        String xt2 = by != null ? by.xt() : null;
        return TextUtils.isEmpty(xt2) ? nVar.w() : xt2;
    }

    public static String ch() {
        return wq.xt(String.format("https://%s", "applog.bytedance.net/service/2/app_log_test/"));
    }

    public static boolean cw(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            if (xt(context)) {
                try {
                    if (context.getPackageManager().getPackageInfo(str, 0) != null) {
                        return true;
                    }
                } catch (Throwable unused) {
                    return false;
                }
            } else if (com.bytedance.sdk.openadsdk.core.v.xt().kj()) {
                return j(str);
            }
        }
        return false;
    }

    public static int f() {
        if (tl >= 0) {
            return tl;
        }
        int xt2 = com.bytedance.sdk.openadsdk.core.cw.r.j().xt("is_root", -1);
        tl = xt2;
        return xt2;
    }

    public static int g(com.bytedance.sdk.openadsdk.core.tj.n nVar) {
        JSONObject ot = nVar.ot();
        if (ot != null) {
            return ot.optInt("rit", 0);
        }
        return 0;
    }

    public static String i(com.bytedance.sdk.openadsdk.core.tj.n nVar) {
        return (nVar.by() == null || TextUtils.isEmpty(nVar.by().cw())) ? !TextUtils.isEmpty(nVar.rs()) ? nVar.rs() : !TextUtils.isEmpty(nVar.hw()) ? nVar.hw() : "" : nVar.by().cw();
    }

    public static boolean j(Context context, String str) {
        Intent xt2;
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                if (xt(context)) {
                    if (!cw(context, str) || (xt2 = xt(context, str)) == null) {
                        return false;
                    }
                    xt2.putExtra("START_ONLY_FOR_ANDROID", true);
                    com.bytedance.sdk.component.utils.xt.j(context, xt2, null);
                    return true;
                }
                Intent xt3 = xt(context, str);
                if (xt3 == null) {
                    return false;
                }
                xt3.putExtra("START_ONLY_FOR_ANDROID", true);
                context.startActivity(xt3);
                return true;
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public static String jy(com.bytedance.sdk.openadsdk.core.tj.n nVar) {
        JSONObject ot = nVar.ot();
        return ot != null ? ot.optString("req_id", "") : "";
    }

    public static long kt() {
        if (ae > 0) {
            return ae;
        }
        long xt2 = com.bytedance.sdk.openadsdk.core.cw.r.j().xt("sdcard_storage", 0L);
        ae = xt2;
        return xt2;
    }

    public static boolean m(com.bytedance.sdk.openadsdk.core.tj.n nVar) {
        if (nVar == null) {
            return false;
        }
        int tl2 = tl(nVar);
        return tl2 == 3 || tl2 == 4;
    }

    public static long mi() {
        if (f30159m > 0) {
            return f30159m;
        }
        long xt2 = com.bytedance.sdk.openadsdk.core.cw.r.j().xt("free_storage", 0L);
        f30159m = xt2;
        return xt2;
    }

    public static String oq(com.bytedance.sdk.openadsdk.core.tj.n nVar) {
        JSONObject ot = nVar.ot();
        return ot != null ? ot.optString("origin_req_id", "") : "";
    }

    public static String qv(com.bytedance.sdk.openadsdk.core.tj.n nVar) {
        JSONObject ot = nVar.ot();
        return ot != null ? ot.optString("customer_id", "") : "";
    }

    public static boolean r() {
        return (com.bytedance.sdk.openadsdk.core.oq.i() == null || com.bytedance.sdk.openadsdk.core.oq.i().j()) ? false : true;
    }

    public static long tj() {
        try {
            if (!c()) {
                return 0L;
            }
            StatFs statFs = new StatFs(com.bytedance.sdk.openadsdk.api.plugin.xt.j(com.bytedance.sdk.openadsdk.core.v.getContext(), null).getPath());
            return statFs.getBlockCount() * statFs.getBlockSize();
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.vl.r("ToolUtils", th.getMessage());
            return 0L;
        }
    }

    public static int tl(com.bytedance.sdk.openadsdk.core.tj.n nVar) {
        JSONObject ot = nVar.ot();
        if (ot != null) {
            return ot.optInt("ad_slot_type", 0);
        }
        return 0;
    }

    public static int up(int i6) {
        if (i6 == 1) {
            return 2;
        }
        if (i6 != 2) {
            return (i6 == 3 || i6 == 4 || i6 == 7 || i6 == 8) ? 5 : 3;
        }
        return 4;
    }

    public static boolean v() {
        try {
            if (!new File("/system/bin/su").exists()) {
                if (!new File("/system/xbin/su").exists()) {
                    return false;
                }
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static double vl(com.bytedance.sdk.openadsdk.core.tj.n nVar) {
        return cw(nVar.ot());
    }

    public static String w(com.bytedance.sdk.openadsdk.core.tj.n nVar) {
        return !TextUtils.isEmpty(nVar.hw()) ? nVar.hw() : !TextUtils.isEmpty(nVar.zk()) ? nVar.zk() : "";
    }

    public static String x() {
        return wq.xt(Uri.parse(String.format("https://%s", w(com.bytedance.sdk.openadsdk.core.v.xt().kt()))).buildUpon().appendQueryParameter("datetime", new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date(new Long(System.currentTimeMillis()).longValue()))).toString());
    }

    public static Intent xt(Context context, String str) {
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
        if (launchIntentForPackage == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT < 33 && !launchIntentForPackage.hasCategory("android.intent.category.LAUNCHER")) {
            launchIntentForPackage.addCategory("android.intent.category.LAUNCHER");
        }
        launchIntentForPackage.setPackage(null);
        launchIntentForPackage.addFlags(2097152);
        launchIntentForPackage.addFlags(268435456);
        return launchIntentForPackage;
    }

    public static void a() {
        if (vl) {
            return;
        }
        vl = true;
        com.bytedance.sdk.component.qv.ae.j j6 = com.bytedance.sdk.component.qv.ae.j.j();
        j6.j("open_sass_live", new com.bytedance.sdk.openadsdk.core.g.j.xt.qv());
        j6.j("open_miniapp", new com.bytedance.sdk.openadsdk.core.g.j.xt.vl());
        j6.j("open_landing_page", new com.bytedance.sdk.openadsdk.core.g.j.xt.oq());
        j6.j("download", new com.bytedance.sdk.openadsdk.core.g.j.xt.ae());
        j6.j("open_scheme", new com.bytedance.sdk.openadsdk.core.g.j.xt.jy());
        j6.j("open_policy", new com.bytedance.sdk.openadsdk.core.g.j.xt.ws());
        j6.j("end_card", new com.bytedance.sdk.openadsdk.core.g.j.xt.g());
        j6.j("common_popup", new com.bytedance.sdk.openadsdk.core.g.j.xt.j());
        j6.j("desc_popup", new com.bytedance.sdk.openadsdk.core.g.j.xt.xt());
        j6.j("permission_popup", new com.bytedance.sdk.openadsdk.core.g.j.xt.cw());
        j6.j("privacy_popup", new com.bytedance.sdk.openadsdk.core.g.j.xt.r());
        j6.j("registration_pop", new com.bytedance.sdk.openadsdk.core.g.j.xt.up());
        j6.j("dislike_popup", new com.bytedance.sdk.openadsdk.core.g.j.xt.m());
        j6.j("download_popup", new com.bytedance.sdk.openadsdk.core.g.j.xt.tl());
        j6.j("reward_again", new com.bytedance.sdk.openadsdk.core.g.j.xt.w());
        j6.j("reward_continue", new com.bytedance.sdk.openadsdk.core.g.j.xt.w());
        j6.j("close_reward", new com.bytedance.sdk.openadsdk.core.g.j.xt.i());
        j6.j("report_event", new com.bytedance.sdk.openadsdk.core.g.j.xt.az());
        j6.j("report_stats", new com.bytedance.sdk.openadsdk.core.g.j.xt.av());
    }

    public static int az(com.bytedance.sdk.openadsdk.core.tj.n nVar) {
        JSONObject ot = nVar.ot();
        if (ot != null) {
            return ot.optInt("price", 0);
        }
        return 0;
    }

    private static boolean c() {
        try {
            return "mounted".equals(com.bytedance.sdk.openadsdk.l.cw.j());
        } catch (Throwable unused) {
            return false;
        }
    }

    public static double m(String str) {
        return cw(cw(str));
    }

    public static boolean r(com.bytedance.sdk.openadsdk.core.tj.n nVar) {
        if (nVar != null) {
            boolean z5 = tl(nVar) == 5;
            if (hh.xt(nVar) == 7 && z5) {
                return true;
            }
        }
        return false;
    }

    public static String s() {
        return g() + ".openadsdk.permission.TT_PANGOLIN";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void uf() {
        com.bytedance.sdk.component.oq.ae.xt(new com.bytedance.sdk.component.oq.g("tt-webua") { // from class: com.bytedance.sdk.openadsdk.core.rn.uf.3
            @Override // java.lang.Runnable
            public void run() {
                uf.ed();
            }
        });
    }

    public static boolean up(com.bytedance.sdk.openadsdk.core.tj.n nVar) {
        if (nVar == null) {
            return false;
        }
        int tl2 = tl(nVar);
        return tl2 == 5 || tl2 == 1 || tl2 == 2;
    }

    public static String v(com.bytedance.sdk.openadsdk.core.tj.n nVar) {
        if (nVar == null) {
            return "";
        }
        String ij = nVar.ij();
        return (!TextUtils.isEmpty(ij) || nVar.et() == null) ? ij : nVar.et().jy();
    }

    public static String vl() {
        if (!TextUtils.isEmpty(f30160r) && !f30160r.equals("0")) {
            return f30160r;
        }
        String cw2 = com.bytedance.sdk.openadsdk.core.cw.r.j().cw("total_memory", "0");
        f30160r = cw2;
        return cw2;
    }

    public static int ws(com.bytedance.sdk.openadsdk.core.tj.n nVar) {
        JSONObject ot = nVar.ot();
        if (ot != null) {
            return ot.optInt("pricing", 0);
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void ed() {
        try {
            ws = av(WebSettings.getDefaultUserAgent(com.bytedance.sdk.openadsdk.core.v.getContext()));
            com.bytedance.sdk.openadsdk.core.cw.r.j().r("sdk_local_web_ua", ws);
            jy.set(false);
        } catch (Throwable unused) {
        }
    }

    @HungeonFlag
    public static String g() {
        if (!TextUtils.isEmpty(f30157i)) {
            return f30157i;
        }
        if (com.bytedance.sdk.openadsdk.core.v.getContext() != null) {
            try {
                f30157i = com.bytedance.sdk.openadsdk.core.v.getContext().getPackageName();
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.vl.cw("ToolUtils", "ToolUtils getPackageName throws exception :", th);
            }
        }
        return f30157i;
    }

    public static void l() {
        String lg = com.bytedance.sdk.openadsdk.core.v.xt().lg();
        try {
            Matcher matcher = Pattern.compile("\\|\\|([a-zA-Z0-9.-]+)\\^").matcher(lg);
            while (matcher.find()) {
                String group = matcher.group(1);
                if (!TextUtils.isEmpty(group)) {
                    com.bytedance.sdk.openadsdk.core.tj.gq.f30275j.add(group);
                }
            }
        } catch (Throwable unused) {
        }
        if (!TextUtils.isEmpty(lg)) {
            Set<String> set = com.bytedance.sdk.openadsdk.core.tj.gq.f30275j;
            if (set.isEmpty()) {
                set.add("empty");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void rn() {
        List<String> ov;
        com.bytedance.sdk.openadsdk.core.p.oq xt2 = com.bytedance.sdk.openadsdk.core.v.xt();
        if (com.bytedance.sdk.openadsdk.core.oq.i().e()) {
            com.bytedance.sdk.openadsdk.core.oq.i().tl(false);
            return;
        }
        if (!xt2.u() && (ov = xt2.ov()) != null) {
            int wo = xt2.wo();
            for (int i6 = 0; i6 < wo && i6 < ov.size(); i6++) {
                Uri parse = Uri.parse(ov.get(i6));
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(parse);
                j(com.bytedance.sdk.openadsdk.core.v.getContext(), intent, true);
            }
        }
    }

    public static String tl() {
        return UUID.randomUUID().toString();
    }

    public static int up(String str) {
        return xt(cw(str));
    }

    private static String wq() {
        String str;
        long j6;
        try {
            String cw2 = com.bytedance.sdk.openadsdk.core.cw.r.j().cw("sdk_local_web_ua", "");
            if (!TextUtils.isEmpty(cw2)) {
                JSONObject jSONObject = new JSONObject(cw2);
                str = jSONObject.getString("value");
                j6 = jSONObject.getLong("time");
                ws = str;
            } else {
                str = null;
                j6 = 0;
            }
            if (TextUtils.isEmpty(str)) {
                ed();
            } else if (System.currentTimeMillis() - j6 > 259200000 && jy.compareAndSet(false, true)) {
                new com.bytedance.sdk.openadsdk.core.r.xt("device_get_webua").j(5).xt(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.rn.uf.2
                    @Override // java.lang.Runnable
                    public void run() {
                        uf.uf();
                    }
                });
            }
        } catch (Throwable unused) {
        }
        return ws;
    }

    public static int az() {
        if (xt > 0) {
            return xt;
        }
        int xt2 = com.bytedance.sdk.openadsdk.core.cw.r.j().xt("cpu_max_freq", 0);
        xt = xt2;
        return xt2;
    }

    public static int jy() {
        return Math.max(Runtime.getRuntime().availableProcessors(), 0);
    }

    public static String m() {
        String str;
        try {
            str = System.getProperty("http.agent");
        } catch (Exception unused) {
            str = "unKnow";
        }
        StringBuilder sb = new StringBuilder();
        if (str == null) {
            return "";
        }
        int lastIndexOf = str.lastIndexOf(";");
        if (lastIndexOf != -1 && str.length() > lastIndexOf) {
            int i6 = lastIndexOf + 1;
            String substring = str.substring(0, i6);
            str = substring.concat(" " + Locale.getDefault().getLanguage() + "-" + Locale.getDefault().getCountry() + ";").concat(str.substring(i6));
        }
        int length = str.length();
        for (int i7 = 0; i7 < length; i7++) {
            char charAt = str.charAt(i7);
            if (charAt <= 31 || charAt >= 127) {
                sb.append(String.format("\\u%04x", Integer.valueOf(charAt)));
            } else {
                sb.append(charAt);
            }
        }
        return sb.toString();
    }

    public static String oq() {
        if (TextUtils.isEmpty(az) && com.bytedance.sdk.openadsdk.core.v.getContext() != null) {
            try {
                PackageInfo packageInfo = com.bytedance.sdk.openadsdk.core.v.getContext().getPackageManager().getPackageInfo(g(), 0);
                az = String.valueOf(packageInfo.versionCode);
                av = packageInfo.versionName;
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.vl.cw("ToolUtils", "ToolUtils getVersionCode throws exception :", th);
            }
        }
        return az;
    }

    public static String qv() {
        if (TextUtils.isEmpty(av) && com.bytedance.sdk.openadsdk.core.v.getContext() != null) {
            try {
                PackageInfo packageInfo = com.bytedance.sdk.openadsdk.core.v.getContext().getPackageManager().getPackageInfo(g(), 0);
                az = String.valueOf(packageInfo.versionCode);
                av = packageInfo.versionName;
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.vl.cw("ToolUtils", "ToolUtils getVersionName throws exception :", th);
            }
        }
        return av;
    }

    public static long r(String str) {
        return j(cw(str));
    }

    public static String tl(String str) {
        return j(str, false, 0);
    }

    public static int ws() {
        if (f30158j > 0) {
            return f30158j;
        }
        int xt2 = com.bytedance.sdk.openadsdk.core.cw.r.j().xt("cpu_cnt", 0);
        f30158j = xt2;
        return xt2;
    }

    public static boolean f(com.bytedance.sdk.openadsdk.core.tj.n nVar) {
        return nVar != null && TextUtils.equals(nVar.so(), nVar.fs()) && nVar.jl() == 3 && !TextUtils.isEmpty(v(nVar));
    }

    public static long jy(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        Matcher matcher = Pattern.compile("/([^/]+)/video/tos/cn").matcher(str);
        if (matcher.find()) {
            String group = matcher.group(1);
            if (TextUtils.isEmpty(group)) {
                return 0L;
            }
            try {
                long parseLong = Long.parseLong(group, 16);
                return str.contains("v3-be-pack") ? parseLong + 10800 : parseLong;
            } catch (Exception unused) {
            }
        }
        return 0L;
    }

    public static boolean kt(com.bytedance.sdk.openadsdk.core.tj.n nVar) {
        if (nVar == null || com.bytedance.sdk.openadsdk.core.tj.kt.r(nVar)) {
            return false;
        }
        int kt = nVar.kt();
        return kt == 5 || kt == 4;
    }

    public static JSONObject mi(com.bytedance.sdk.openadsdk.core.tj.n nVar) {
        if (nVar == null) {
            return null;
        }
        return nVar.ot();
    }

    public static long up() {
        return qv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String av(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i6 = 0; i6 < length; i6++) {
            char charAt = str.charAt(i6);
            if (charAt <= 31 || charAt >= 127) {
                sb.append(String.format("\\u%04x", Integer.valueOf(charAt)));
            } else {
                sb.append(charAt);
            }
        }
        return sb.toString();
    }

    private static String mi(String str) {
        try {
            return Uri.parse(str).buildUpon().appendQueryParameter(CommonNetImpl.AID, "1371").appendQueryParameter("device_platform", FaceEnvironment.OS).appendQueryParameter("version_code", oq()).toString();
        } catch (Exception unused) {
            return str;
        }
    }

    public static String r(Context context, String str) {
        FileReader fileReader;
        BufferedReader bufferedReader;
        String readLine;
        try {
            fileReader = new FileReader("/proc/meminfo");
            try {
                bufferedReader = new BufferedReader(fileReader, 4096);
                do {
                    try {
                        readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                    } catch (Throwable th) {
                        th = th;
                        try {
                            com.bytedance.sdk.component.utils.vl.j(th);
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (Exception unused) {
                                }
                            }
                            if (fileReader != null) {
                                try {
                                    fileReader.close();
                                } catch (Exception unused2) {
                                }
                            }
                            return null;
                        } finally {
                        }
                    }
                } while (!readLine.contains(str));
                if (readLine == null) {
                    try {
                        bufferedReader.close();
                    } catch (Exception unused3) {
                    }
                    try {
                        fileReader.close();
                    } catch (Exception unused4) {
                    }
                    return null;
                }
                String str2 = readLine.split("\\s+")[1];
                try {
                    bufferedReader.close();
                } catch (Exception unused5) {
                }
                try {
                    fileReader.close();
                } catch (Exception unused6) {
                }
                return str2;
            } catch (Throwable th2) {
                th = th2;
                bufferedReader = null;
            }
        } catch (Throwable th3) {
            th = th3;
            fileReader = null;
            bufferedReader = null;
        }
    }

    public static String up(Context context) {
        try {
            return context.getResources().getString(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.labelRes);
        } catch (Exception unused) {
            return "";
        }
    }

    public static boolean vl(String str) {
        long jy2 = jy(str);
        return jy2 != 0 && System.currentTimeMillis() - (jy2 * 1000) > 0;
    }

    public static long w() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return statFs.getBlockCountLong() * statFs.getBlockSizeLong();
        } catch (Throwable unused) {
            return 0L;
        }
    }

    public static String ae() {
        if (!TextUtils.isEmpty(ws)) {
            return ws;
        }
        return wq();
    }

    public static void cw() {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            com.bytedance.sdk.component.utils.tl.j().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.rn.uf.1
                @Override // java.lang.Runnable
                public void run() {
                    uf.rn();
                }
            });
        } else {
            rn();
        }
    }

    public static boolean tj(com.bytedance.sdk.openadsdk.core.tj.n nVar) {
        if (nVar == null) {
            return true;
        }
        int ae2 = com.bytedance.sdk.openadsdk.core.v.xt().ae(g(nVar));
        if (ae2 == 1) {
            return com.bytedance.sdk.component.utils.ws.r(com.bytedance.sdk.openadsdk.core.v.getContext());
        }
        if (ae2 == 2) {
            return com.bytedance.sdk.component.utils.ws.up(com.bytedance.sdk.openadsdk.core.v.getContext()) || com.bytedance.sdk.component.utils.ws.r(com.bytedance.sdk.openadsdk.core.v.getContext()) || com.bytedance.sdk.component.utils.ws.m(com.bytedance.sdk.openadsdk.core.v.getContext());
        }
        if (ae2 != 3) {
            return ae2 != 5 || com.bytedance.sdk.component.utils.ws.r(com.bytedance.sdk.openadsdk.core.v.getContext()) || com.bytedance.sdk.component.utils.ws.m(com.bytedance.sdk.openadsdk.core.v.getContext());
        }
        return false;
    }

    public static boolean xt(Context context, Intent intent, boolean z5) {
        Boolean j6;
        Uri data = intent.getData();
        if (data == null) {
            return false;
        }
        String j7 = s.j(data);
        if (z5 && (j6 = s.j(j7, 86400000L)) != null) {
            return j6.booleanValue();
        }
        boolean xt2 = xt(context, intent);
        s.j(j7, Boolean.valueOf(xt2));
        return xt2;
    }

    public static long i() {
        if (up > 0) {
            return up;
        }
        long xt2 = com.bytedance.sdk.openadsdk.core.cw.r.j().xt("internal_storage", 0L);
        up = xt2;
        return xt2;
    }

    public static String g(String str) {
        return j(str, false, 1);
    }

    public static String x(com.bytedance.sdk.openadsdk.core.tj.n nVar) {
        com.bytedance.sdk.openadsdk.core.tj.m et;
        if (nVar == null) {
            return null;
        }
        com.bytedance.sdk.openadsdk.core.tj.up by = nVar.by();
        String r5 = by != null ? by.r() : null;
        if (TextUtils.isEmpty(r5) && (et = nVar.et()) != null) {
            r5 = et.jy();
        }
        return TextUtils.isEmpty(r5) ? nVar.ij() : r5;
    }

    public static boolean ae(String str) {
        try {
            return Pattern.compile("[一-龥]").matcher(str).find();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static JSONObject cw(String str) {
        if (!TextUtils.isEmpty(str) && str != null && !str.isEmpty()) {
            try {
                return new JSONObject(str);
            } catch (JSONException e6) {
                com.bytedance.sdk.component.utils.vl.j(e6);
            }
        }
        return null;
    }

    public static JSONObject j(Map<String, Object> map) {
        if (map == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            try {
                jSONObject.put(entry.getKey(), entry.getValue());
            } catch (Exception unused) {
            }
        }
        return jSONObject;
    }

    private static String w(String str) {
        if (TextUtils.isEmpty(str)) {
            oq = "empty";
            return "log-api.pangolin-sdk-toutiao-b.com/service/2/app_log/";
        }
        if (!str.contains("service/2/app_log")) {
            oq = str;
            return "log-api.pangolin-sdk-toutiao-b.com/service/2/app_log/";
        }
        oq = null;
        return str;
    }

    private static String i(String str) {
        if (TextUtils.isEmpty(str)) {
            f30156g = "empty";
            return "api-access.pangolin-sdk-toutiao1.com";
        }
        if (!str.contains("api-access")) {
            f30156g = str;
            return "api-access.pangolin-sdk-toutiao1.com";
        }
        f30156g = null;
        return str;
    }

    public static String oq(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (str.contains("KLLK")) {
            return str.replace("KLLK", "OPPO");
        }
        return str.contains("kllk") ? str.replace("kllk", "oppo") : "";
    }

    public static int[] qv(String str) {
        if (TextUtils.isEmpty(str)) {
            return new int[0];
        }
        String[] split = str.split(",");
        int[] iArr = new int[split.length];
        for (int i6 = 0; i6 < split.length; i6++) {
            try {
                iArr[i6] = Integer.parseInt(split[i6]);
            } catch (Exception unused) {
            }
        }
        return iArr;
    }

    public static boolean xt() {
        try {
            PackageInfo packageInfo = com.bytedance.sdk.openadsdk.core.v.getContext().getPackageManager().getPackageInfo(com.bytedance.sdk.openadsdk.core.v.getContext().getPackageName(), 0);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd", Locale.ROOT);
            return simpleDateFormat.format(Long.valueOf(System.currentTimeMillis())).compareTo(simpleDateFormat.format(Long.valueOf(packageInfo.firstInstallTime))) > 0;
        } catch (Throwable unused) {
            return true;
        }
    }

    public static int av() {
        if (cw > 0) {
            return cw;
        }
        int xt2 = com.bytedance.sdk.openadsdk.core.cw.r.j().xt("cpu_min_freq", 0);
        cw = xt2;
        return xt2;
    }

    public static boolean cw(com.bytedance.sdk.openadsdk.core.tj.n nVar) {
        return nVar != null && tl(nVar) == 9;
    }

    private static double cw(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optDouble("pack_time", 0.0d);
        }
        return 0.0d;
    }

    public static boolean j(String str) {
        boolean exists = j("data", str).exists();
        return !exists ? j(SocializeConstants.KEY_PLATFORM, str).exists() : exists;
    }

    public static int cw(int i6) {
        BufferedReader bufferedReader;
        Throwable th;
        BufferedReader bufferedReader2;
        int i7 = 0;
        FileReader fileReader = null;
        BufferedReader bufferedReader3 = null;
        while (true) {
            i6--;
            if (i6 < 0) {
                return i7;
            }
            try {
                FileReader fileReader2 = new FileReader("/sys/devices/system/cpu/cpu" + i6 + "/cpufreq/cpuinfo_max_freq");
                try {
                    bufferedReader2 = new BufferedReader(fileReader2);
                } catch (Throwable th2) {
                    BufferedReader bufferedReader4 = bufferedReader3;
                    th = th2;
                    fileReader = fileReader2;
                    bufferedReader = bufferedReader4;
                }
                try {
                    int parseInt = Integer.parseInt(bufferedReader2.readLine());
                    if (parseInt > i7) {
                        i7 = parseInt;
                    }
                    try {
                        bufferedReader2.close();
                        fileReader2.close();
                    } catch (Exception unused) {
                    }
                    bufferedReader3 = bufferedReader2;
                    fileReader = fileReader2;
                } catch (Throwable th3) {
                    th = th3;
                    bufferedReader = bufferedReader2;
                    fileReader = fileReader2;
                    try {
                        com.bytedance.sdk.component.utils.vl.r("ToolUtils", th.getMessage());
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Exception unused2) {
                                bufferedReader3 = bufferedReader;
                            }
                        }
                        bufferedReader3 = bufferedReader;
                    } finally {
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Exception unused3) {
                            }
                        }
                        if (fileReader != null) {
                            fileReader.close();
                        }
                    }
                }
            } catch (Throwable th4) {
                bufferedReader = bufferedReader3;
                th = th4;
            }
        }
    }

    private static File j(String str, String str2) {
        String str3 = System.getenv("EXTERNAL_STORAGE");
        if (str3 == null) {
            str3 = "/sdcard";
        }
        return new File(str3, "Android/" + str + "/" + str2);
    }

    public static Class m(int i6) {
        if (i6 == 2) {
            return TTNativePageActivity.class;
        }
        if (i6 == 3) {
            return TTVideoWebPageActivity.class;
        }
        if (i6 != 4) {
            return TTWebPageActivity.class;
        }
        return TTVideoScrollWebPageActivity.class;
    }

    private static boolean xt(Context context, Intent intent) {
        try {
            List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 65536);
            if (queryIntentActivities != null) {
                if (queryIntentActivities.size() > 0) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static boolean j(Context context, Intent intent, boolean z5) {
        if (intent == null || context == null || !xt(context)) {
            return false;
        }
        return xt(context, intent, z5);
    }

    public static int r(int i6) {
        BufferedReader bufferedReader;
        Throwable th;
        int i7 = 0;
        FileReader fileReader = null;
        BufferedReader bufferedReader2 = null;
        while (true) {
            i6--;
            if (i6 < 0) {
                return i7;
            }
            try {
                FileReader fileReader2 = new FileReader("/sys/devices/system/cpu/cpu" + i6 + "/cpufreq/cpuinfo_min_freq");
                try {
                    BufferedReader bufferedReader3 = new BufferedReader(fileReader2);
                    try {
                        int parseInt = Integer.parseInt(bufferedReader3.readLine());
                        if (parseInt < i7 || i7 == 0) {
                            i7 = parseInt;
                        }
                        try {
                            bufferedReader3.close();
                            fileReader2.close();
                        } catch (Exception unused) {
                        }
                        bufferedReader2 = bufferedReader3;
                        fileReader = fileReader2;
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedReader = bufferedReader3;
                        fileReader = fileReader2;
                        try {
                            com.bytedance.sdk.component.utils.vl.r("ToolUtils", th.getMessage());
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (Exception unused2) {
                                    bufferedReader2 = bufferedReader;
                                }
                            }
                            bufferedReader2 = bufferedReader;
                        } finally {
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (Exception unused3) {
                                }
                            }
                            if (fileReader != null) {
                                fileReader.close();
                            }
                        }
                    }
                } catch (Throwable th3) {
                    BufferedReader bufferedReader4 = bufferedReader2;
                    th = th3;
                    fileReader = fileReader2;
                    bufferedReader = bufferedReader4;
                }
            } catch (Throwable th4) {
                bufferedReader = bufferedReader2;
                th = th4;
            }
        }
    }

    public static int xt(String str) {
        str.getClass();
        switch (str) {
            case "banner_ad":
                return 2;
            case "rewarded_video":
                return 7;
            case "fullscreen_interstitial_ad":
                return 5;
            case "splash_ad":
            case "cache_splash_ad":
                return 4;
            case "interaction":
                return 3;
            case "draw_ad":
                return 6;
            default:
                return 1;
        }
    }

    public static String xt(int i6) {
        switch (i6) {
            case 1:
                return "banner_ad";
            case 2:
                return "interaction";
            case 3:
            case 4:
                return "splash_ad";
            case 5:
            default:
                return "embeded_ad";
            case 6:
                return "stream";
            case 7:
                return "rewarded_video";
            case 8:
                return "fullscreen_interstitial_ad";
            case 9:
                return "draw_ad";
        }
    }

    public static boolean j(Context context, Intent intent) {
        if (intent == null || context == null || !xt(context)) {
            return false;
        }
        return xt(context, intent, false);
    }

    public static List<String> j() {
        ArrayList arrayList = new ArrayList();
        if (com.bytedance.sdk.openadsdk.core.v.xt().qo() && com.bytedance.sdk.openadsdk.core.oq.i().w().xt()) {
            Intent intent = new Intent("android.intent.action.MAIN");
            PackageManager packageManager = com.bytedance.sdk.openadsdk.core.v.getContext().getPackageManager();
            if (Build.VERSION.SDK_INT >= 23) {
                Iterator<ResolveInfo> it = packageManager.queryIntentActivities(intent, 131072).iterator();
                while (it.hasNext()) {
                    ActivityInfo activityInfo = it.next().activityInfo;
                    if (activityInfo != null) {
                        String str = activityInfo.packageName;
                        if (!TextUtils.isEmpty(str) && !arrayList.contains(str)) {
                            arrayList.add(str);
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    public static long cw(Context context) {
        int i6;
        try {
            i6 = context.getApplicationInfo().targetSdkVersion;
            try {
                com.bytedance.sdk.component.utils.vl.j("ToolUtils", "targetSdkVersion = ", Integer.valueOf(i6));
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            i6 = -1;
        }
        return i6;
    }

    public static String xt(com.bytedance.sdk.openadsdk.core.tj.n nVar) {
        if (nVar == null) {
            return null;
        }
        try {
            return xt(tl(nVar));
        } catch (Throwable unused) {
            return null;
        }
    }

    public static long r(Context context) {
        int i6 = -1;
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                i6 = context.getApplicationInfo().minSdkVersion;
                com.bytedance.sdk.component.utils.vl.j("ToolUtils", "minSdkVersion = ", Integer.valueOf(i6));
            }
        } catch (Throwable unused) {
        }
        return i6;
    }

    private static int xt(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optInt("ut", 0);
        }
        return 0;
    }

    public static Map<String, Object> xt(boolean z5, com.bytedance.sdk.openadsdk.core.tj.n nVar, long j6, long j7, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("creative_id", nVar.fs());
        hashMap.put(com.baidu.mobads.sdk.internal.d.f10986b, Long.valueOf(j6));
        if (!z5) {
            hashMap.put("error_code", Long.valueOf(j7));
            if (TextUtils.isEmpty(str)) {
                str = "unknown";
            }
            hashMap.put("error_message", str);
        }
        return hashMap;
    }

    public static int j(com.bytedance.sdk.openadsdk.core.tj.n nVar) {
        int az2 = com.bytedance.sdk.openadsdk.core.v.xt().az();
        if (az2 == -1) {
            try {
                rr ae2 = hh.ae(nVar);
                aq m6 = hh.m(nVar);
                if (ae2 != null) {
                    String m7 = ae2.m();
                    if (TextUtils.isEmpty(m7)) {
                        return 0;
                    }
                    return Integer.valueOf(m7).intValue();
                }
                if (m6 != null) {
                    String vl2 = m6.vl();
                    if (TextUtils.isEmpty(vl2)) {
                        return 0;
                    }
                    return Integer.valueOf(vl2).intValue();
                }
            } catch (Exception e6) {
                com.bytedance.sdk.component.utils.vl.r("tl", e6.getMessage());
                return 0;
            }
        } else if (az2 != 0 && az2 == 1) {
            return 1;
        }
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0041 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0042 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean xt(android.content.Context r4) {
        /*
            if (r4 == 0) goto L3
            goto L7
        L3:
            android.content.Context r4 = com.bytedance.sdk.openadsdk.core.v.getContext()
        L7:
            r0 = 0
            if (r4 != 0) goto L10
            java.lang.String r4 = "params context is null"
            com.bytedance.sdk.component.utils.vl.cw(r4)
            return r0
        L10:
            android.content.pm.ApplicationInfo r1 = r4.getApplicationInfo()
            int r1 = r1.targetSdkVersion
            r2 = 30
            r3 = 1
            if (r1 < r2) goto L29
            int r1 = android.os.Build.VERSION.SDK_INT
            if (r1 < r2) goto L29
            java.lang.String r1 = "android.permission.QUERY_ALL_PACKAGES"
            int r4 = androidx.core.app.q.a(r4, r1)
            if (r4 == 0) goto L29
            r4 = 1
            goto L2a
        L29:
            r4 = 0
        L2a:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "can query all package = "
            r1.<init>(r2)
            r2 = r4 ^ 1
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "ToolUtils"
            com.bytedance.sdk.component.utils.vl.j(r2, r1)
            if (r4 != 0) goto L42
            return r3
        L42:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.rn.uf.xt(android.content.Context):boolean");
    }

    public static String xt(long j6, long j7) {
        return String.valueOf(((int) (Math.abs(j7 - j6) / 86400000)) + 1);
    }

    public static int xt(com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar) {
        if (xtVar == null) {
            return 0;
        }
        try {
            return Integer.parseInt(xtVar.r());
        } catch (Exception unused) {
            return 0;
        }
    }

    public static String xt(com.bytedance.sdk.openadsdk.core.tj.n nVar, String str) {
        xp al;
        if (nVar == null || (al = nVar.al()) == null || al.xt() != 1 || TextUtils.isEmpty(str)) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str);
        if (str.indexOf("?") != -1) {
            sb.append(ContainerUtils.FIELD_DELIMITER);
        } else {
            sb.append("?");
        }
        sb.append("open_method=");
        if (!com.bytedance.sdk.openadsdk.core.xt.j.xt.r.cw().j()) {
            sb.append(2);
            return sb.toString();
        }
        sb.append(al.m());
        return sb.toString();
    }

    public static String j(int i6) {
        switch (i6) {
            case 1:
                return "embeded_ad_landingpage";
            case 2:
                return "banner_ad_landingpage";
            case 3:
                return "interaction_landingpage";
            case 4:
                return "splash_ad_landingpage";
            case 5:
                return "fullscreen_interstitial_ad_landingpage";
            case 6:
                return "draw_ad_landingpage";
            case 7:
                return "rewarded_video_landingpage";
            default:
                return null;
        }
    }

    private static long j(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optLong("uid", 0L);
        }
        return 0L;
    }

    public static String j(com.bytedance.sdk.openadsdk.core.tj.n nVar, String str) {
        JSONObject ot = nVar.ot();
        return ot != null ? ot.optString("rit", str) : str;
    }

    public static String j(com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar) {
        String str;
        try {
            JSONObject jSONObject = new JSONObject(xtVar.tj());
            int optInt = jSONObject.optInt("cypher");
            String optString = jSONObject.optString(CrashHianalyticsData.MESSAGE);
            if (optInt == 3) {
                str = com.bytedance.sdk.component.utils.j.cw(optString);
            } else if (optInt == 4) {
                str = com.bytedance.sdk.component.panglearmor.g.j().j(optString);
                if (str == null) {
                    str = "";
                }
            } else {
                str = null;
            }
            JSONArray optJSONArray = new JSONObject(str).optJSONArray("creatives");
            StringBuilder sb = new StringBuilder();
            if (optJSONArray != null) {
                for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
                    String optString2 = ((JSONObject) optJSONArray.get(i6)).optString("material_key");
                    if (i6 != 0) {
                        sb.append("," + optString2);
                    } else {
                        sb.append(optString2);
                    }
                }
            }
            return sb.toString();
        } catch (Exception unused) {
            return null;
        }
    }

    public static void xt(Intent intent) {
        if (intent == null) {
            return;
        }
        Uri data = intent.getData();
        if (data == null) {
            intent.addFlags(268435456);
        } else if (com.bytedance.sdk.openadsdk.core.v.xt().mi(data.getScheme())) {
            intent.addFlags(805339136);
        } else {
            intent.addFlags(268435456);
        }
    }

    public static Map<String, Object> j(long j6, com.bytedance.sdk.openadsdk.core.tj.n nVar, com.bykv.vk.openvk.component.video.api.j jVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("video_start_duration", Long.valueOf(j6));
        if (nVar != null) {
            if (!TextUtils.isEmpty(nVar.fs())) {
                hashMap.put("creative_id", nVar.fs());
            }
            com.bykv.vk.openvk.component.video.api.cw.cw ws2 = ln.ws(nVar);
            if (ws2 != null) {
                hashMap.put("video_resolution", ws2.g());
                hashMap.put("video_size", Long.valueOf(ws2.up()));
            }
        }
        j(hashMap, jVar);
        return hashMap;
    }

    public static Map<String, Object> j(boolean z5, com.bytedance.sdk.openadsdk.core.tj.n nVar, long j6, long j7, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("creative_id", nVar.fs());
        hashMap.put(com.baidu.mobads.sdk.internal.d.f10986b, Long.valueOf(j6));
        com.bykv.vk.openvk.component.video.api.cw.cw ws2 = ln.ws(nVar);
        if (ws2 != null) {
            hashMap.put("video_size", Long.valueOf(ws2.up()));
            hashMap.put("video_resolution", ws2.g());
            hashMap.put("video_preload_size", Long.valueOf(Build.VERSION.SDK_INT >= 23 ? ws2.av() : ws2.up()));
        }
        if (!z5) {
            hashMap.put("error_code", Long.valueOf(j7));
            if (TextUtils.isEmpty(str)) {
                str = "unknown";
            }
            hashMap.put("error_message", str);
        }
        return hashMap;
    }

    public static Map<String, Object> j(com.bytedance.sdk.openadsdk.core.tj.n nVar, long j6, com.bykv.vk.openvk.component.video.api.j jVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("creative_id", nVar.fs());
        hashMap.put("buffers_time", Long.valueOf(j6));
        com.bykv.vk.openvk.component.video.api.cw.cw ws2 = ln.ws(nVar);
        if (ws2 != null) {
            hashMap.put("video_size", Long.valueOf(ws2.up()));
            hashMap.put("video_resolution", ws2.g());
        }
        j(hashMap, jVar);
        return hashMap;
    }

    private static void j(Map<String, Object> map, com.bykv.vk.openvk.component.video.api.j jVar) {
        if (map.containsKey("video_resolution") || jVar == null) {
            return;
        }
        try {
            map.put("video_resolution", String.format(Locale.getDefault(), "%d×%d", Integer.valueOf(jVar.qv()), Integer.valueOf(jVar.vl())));
        } catch (Throwable unused) {
        }
    }

    public static String j(Context context) {
        Locale locale;
        LocaleList locales;
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                locales = context.getResources().getConfiguration().getLocales();
                locale = locales.get(0);
            } else {
                locale = Locale.getDefault();
            }
            return locale.getLanguage();
        } catch (Exception e6) {
            com.bytedance.sdk.component.utils.vl.r("ToolUtils", e6.toString());
            return "";
        }
    }

    public static boolean j(boolean z5, com.bytedance.sdk.openadsdk.core.tj.n nVar, String str) {
        if (z5 || nVar == null) {
            return false;
        }
        try {
            com.bytedance.sdk.openadsdk.core.tj.i m111if = nVar.m111if();
            boolean z6 = m111if != null && m111if.cw() == 2 && !m111if.j() && com.bytedance.sdk.openadsdk.core.xt.j().xt("dpl_reject_by_dialog", false);
            if (!nVar.mz() && !z6) {
                return false;
            }
            String yb = nVar.yb();
            if (TextUtils.isEmpty(yb) && m111if != null && m111if.up() == 1 && !TextUtils.isEmpty(m111if.r())) {
                yb = m111if.r();
            }
            if (!TextUtils.isEmpty(yb)) {
                com.bytedance.sdk.openadsdk.core.ed.j(yb, nVar, str);
                return true;
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static String j(String str, boolean z5) {
        return j(str, z5, 0);
    }

    private static String j(String str, boolean z5, int i6) {
        String qv2 = i6 == 0 ? com.bytedance.sdk.openadsdk.core.v.xt().qv() : i(com.bytedance.sdk.openadsdk.core.v.xt().av());
        String str2 = "/ad_union_qa/sdk/get_ads";
        if (com.bytedance.sdk.openadsdk.tools.xt.j() && com.bytedance.sdk.openadsdk.core.oq.i().zz() && TextUtils.equals(str, "/api/ad/union/sdk/get_ads/")) {
            qv2 = com.bytedance.sdk.openadsdk.core.oq.i().kc();
            str = "/ad_union_qa/sdk/get_ads";
        }
        if (com.bytedance.sdk.openadsdk.core.oq.i().st() != null && g().equals("com.pangolin_demo.toutiao") && TextUtils.equals(str, "/api/ad/union/sdk/get_ads/")) {
            qv2 = com.bytedance.sdk.openadsdk.core.oq.i().kc();
        } else {
            str2 = str;
        }
        String format = String.format("https://%s%s", qv2, str2);
        if (wq.j()) {
            if (!z5) {
                format = wq.xt(format);
            }
            String j6 = wq.j("testIp.txt");
            if (j6 != null) {
                format = wq.j(format, j6);
            }
        }
        return z5 ? mi(format) : format;
    }

    public static boolean j(long j6, long j7) {
        long j8 = j7 - j6;
        return j8 < 86400000 && j8 > -86400000 && j(j6) == j(j7);
    }

    public static long j(long j6) {
        return (j6 + TimeZone.getDefault().getOffset(j6)) / 86400000;
    }

    public static Bundle j(int i6, Bundle bundle) {
        int i7 = bundle.getInt("callback_extra_key_reward_amount");
        String string = bundle.getString("callback_extra_key_reward_name");
        int i8 = bundle.getInt("callback_extra_key_error_code");
        String string2 = bundle.getString("callback_extra_key_error_msg");
        float f6 = bundle.getFloat("callback_extra_key_reward_propose");
        boolean z5 = bundle.getBoolean("callback_extra_key_video_complete_reward");
        boolean z6 = bundle.getBoolean("callback_extra_key_is_server_verify");
        Bundle bundle2 = new Bundle();
        bundle2.putInt(TTRewardVideoAd.REWARD_EXTRA_KEY_ERROR_CODE, i8);
        bundle2.putString(TTRewardVideoAd.REWARD_EXTRA_KEY_ERROR_MSG, string2);
        bundle2.putString(TTRewardVideoAd.REWARD_EXTRA_KEY_REWARD_NAME, string);
        bundle2.putInt(TTRewardVideoAd.REWARD_EXTRA_KEY_REWARD_AMOUNT, i7);
        bundle2.putFloat(TTRewardVideoAd.REWARD_EXTRA_KEY_REWARD_PROPOSE, f6);
        bundle2.putBoolean(TTRewardVideoAd.REWARD_EXTRA_KEY_IS_SERVER_VERIFY, z6);
        if (i6 == 0) {
            bundle2.putBoolean(TTRewardVideoAd.REWARD_EXTRA_KEY_HAS_VIDEO_COMPLETE_REWARD, z5);
        }
        return bundle2;
    }

    public static String j(int[] iArr) {
        if (iArr == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i6 = 0; i6 < iArr.length; i6++) {
            if (i6 < iArr.length - 1) {
                sb.append(iArr[i6] + ",");
            } else {
                sb.append(iArr[i6]);
            }
        }
        return sb.toString();
    }

    public static void j(Intent intent, com.bytedance.sdk.openadsdk.core.tj.n nVar) {
        if (nVar == null) {
            return;
        }
        if (!com.bytedance.sdk.openadsdk.core.v.xt().ej()) {
            intent.putExtra("multi_process_materialmeta", nVar.tv().toString());
            return;
        }
        String str = nVar.hashCode() + nVar.ej();
        intent.putExtra("multi_process_materialmeta_key", str);
        if (com.bytedance.sdk.component.utils.i.j(com.bytedance.sdk.openadsdk.core.v.getContext())) {
            com.bytedance.sdk.openadsdk.core.x.j(str, nVar, com.bytedance.sdk.openadsdk.core.tj.n.class);
        } else {
            h.j("sp_meta").j(str, com.bytedance.sdk.component.utils.j.xt(nVar.tv().toString()));
        }
    }

    public static int j(Class cls) {
        if (TTWebPageActivity.class.equals(cls)) {
            return 0;
        }
        if (TTNativePageActivity.class.equals(cls)) {
            return 2;
        }
        if (TTVideoWebPageActivity.class.equals(cls)) {
            return 3;
        }
        return TTVideoScrollWebPageActivity.class.equals(cls) ? 4 : 0;
    }

    public static void j(Map<String, Object> map, com.bytedance.sdk.openadsdk.core.tj.n nVar) {
        if (nVar == null || map == null) {
            return;
        }
        if (!com.bytedance.sdk.openadsdk.core.v.xt().ej()) {
            map.put("multi_process_materialmeta", nVar.tv().toString());
            return;
        }
        String str = nVar.hashCode() + nVar.ej();
        map.put("multi_process_materialmeta_key", str);
        if (com.bytedance.sdk.component.utils.i.j(com.bytedance.sdk.openadsdk.core.v.getContext())) {
            com.bytedance.sdk.openadsdk.core.x.j(str, nVar, com.bytedance.sdk.openadsdk.core.tj.n.class);
        } else {
            h.j("sp_meta").j(str, com.bytedance.sdk.component.utils.j.xt(nVar.tv().toString()));
        }
    }

    public static com.bytedance.sdk.openadsdk.core.tj.n j(Intent intent) {
        if (intent == null) {
            return null;
        }
        try {
            String stringExtra = intent.getStringExtra("multi_process_materialmeta");
            if (!TextUtils.isEmpty(stringExtra)) {
                com.bytedance.sdk.openadsdk.core.tj.n j6 = com.bytedance.sdk.openadsdk.core.j.j(new JSONObject(stringExtra));
                if (j6 != null) {
                    return j6;
                }
            }
        } catch (Exception e6) {
            com.bytedance.sdk.component.utils.vl.cw("ToolUtils", "getMaterialMeta from intent failed", e6);
        }
        String stringExtra2 = intent.getStringExtra("multi_process_materialmeta_key");
        com.bytedance.sdk.openadsdk.core.tj.n nVar = (com.bytedance.sdk.openadsdk.core.tj.n) com.bytedance.sdk.openadsdk.core.x.xt(stringExtra2, com.bytedance.sdk.openadsdk.core.tj.n.class);
        if (nVar != null) {
            return nVar;
        }
        com.bytedance.sdk.component.r.j.xt j7 = h.j("sp_meta");
        String cw2 = com.bytedance.sdk.component.utils.j.cw(j7.xt(stringExtra2, ""));
        try {
            if (TextUtils.isEmpty(cw2)) {
                com.bytedance.sdk.component.utils.vl.r("ToolUtils", "getMaterialMeta from keva failed , md5" + stringExtra2);
                return null;
            }
            return com.bytedance.sdk.openadsdk.core.j.j(new JSONObject(cw2));
        } catch (Exception e7) {
            com.bytedance.sdk.component.utils.vl.j(e7);
            com.bytedance.sdk.component.utils.vl.cw("ToolUtils", "getMaterialMeta from keva failed", e7);
            return null;
        } finally {
            j7.j(stringExtra2);
        }
    }

    public static boolean j(String str, AtomicInteger atomicInteger) {
        if (TextUtils.isEmpty(str) || atomicInteger == null) {
            return true;
        }
        if (atomicInteger.get() == 1) {
            return false;
        }
        if (str.startsWith("bytedance") || str.startsWith("nativeapp")) {
            return true;
        }
        if (!str.startsWith("https:") && !str.startsWith("http:")) {
            return true;
        }
        Set<String> set = com.bytedance.sdk.openadsdk.core.tj.gq.f30275j;
        if (set.isEmpty()) {
            l();
        }
        String host = Uri.parse(str).getHost();
        if (TextUtils.isEmpty(host) || set.isEmpty()) {
            return true;
        }
        for (String str2 : set) {
            if (!TextUtils.isEmpty(str2) && host.contains(str2)) {
                return true;
            }
        }
        return false;
    }
}
