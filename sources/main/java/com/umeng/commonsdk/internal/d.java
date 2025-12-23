package com.umeng.commonsdk.internal;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.inputmethod.InputMethodInfo;
import com.baidu.idl.face.platform.common.ConstantHelper;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.stub.StubApp;
import com.umeng.analytics.pro.au;
import com.umeng.analytics.pro.bi;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMLogDataProtocol;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.internal.utils.a;
import com.umeng.commonsdk.internal.utils.d;
import com.umeng.commonsdk.internal.utils.j;
import com.umeng.commonsdk.internal.utils.k;
import com.umeng.commonsdk.statistics.UMServerURL;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.ULog;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class d {
    public static void a(Context context) {
        Context context2;
        try {
            ULog.i("walle", "[internal] workEvent send envelope");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(bi.aQ, a.f41751e);
            context2 = context;
            try {
                JSONObject buildEnvelopeWithExtHeader = UMEnvelopeBuild.buildEnvelopeWithExtHeader(context2, jSONObject, d(context), UMServerURL.PATH_ANALYTICS, "i", a.f41751e);
                if (buildEnvelopeWithExtHeader == null || buildEnvelopeWithExtHeader.has("exception")) {
                    return;
                }
                ULog.i("walle", "[internal] workEvent send envelope back, result is ok");
            } catch (Exception e6) {
                e = e6;
                UMCrashManager.reportCrash(context2, e);
            }
        } catch (Exception e7) {
            e = e7;
            context2 = context;
        }
    }

    public static void b(Context context) {
        ULog.i("walle", "[internal] begin by stateful--->>>");
        if (context != null) {
            j(context);
        }
    }

    public static void c(Context context) {
        ULog.i("walle", "[internal] begin by stateful--->>>");
        if (context == null || !UMEnvelopeBuild.getTransmissionSendFlag()) {
            return;
        }
        j(context);
    }

    private static JSONArray k(Context context) {
        List<ActivityManager.RunningServiceInfo> runningServices;
        JSONArray jSONArray = null;
        if (context == null) {
            return null;
        }
        try {
            ActivityManager activityManager = (ActivityManager) StubApp.getOrigApplicationContext(context.getApplicationContext()).getSystemService(TTDownloadField.TT_ACTIVITY);
            if (activityManager == null || (runningServices = activityManager.getRunningServices(Integer.MAX_VALUE)) == null || runningServices.isEmpty()) {
                return null;
            }
            for (int i6 = 0; i6 < runningServices.size(); i6++) {
                if (runningServices.get(i6) != null && runningServices.get(i6).service != null && runningServices.get(i6).service.getClassName() != null && runningServices.get(i6).service.getPackageName() != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("sn", runningServices.get(i6).service.getClassName().toString());
                        jSONObject.put("pn", runningServices.get(i6).service.getPackageName().toString());
                        if (jSONArray == null) {
                            jSONArray = new JSONArray();
                        }
                        jSONArray.put(jSONObject);
                    } catch (JSONException unused) {
                    }
                }
            }
            if (jSONArray == null) {
                return jSONArray;
            }
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("ts", System.currentTimeMillis());
                jSONObject2.put("ls", jSONArray);
            } catch (JSONException unused2) {
            }
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put("sers", jSONObject2);
            } catch (JSONException unused3) {
            }
            JSONArray jSONArray2 = new JSONArray();
            try {
                jSONArray2.put(jSONObject3);
                return jSONArray2;
            } catch (Throwable th) {
                th = th;
                jSONArray = jSONArray2;
                UMCrashManager.reportCrash(context, th);
                return jSONArray;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static JSONObject d(Context context) {
        JSONObject b6;
        JSONArray h6;
        JSONObject a6;
        JSONArray l6;
        JSONArray k6;
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        if (context != null) {
            Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
            try {
                if (FieldManager.allow(com.umeng.commonsdk.utils.d.J) && (k6 = k(origApplicationContext)) != null && k6.length() > 0) {
                    jSONObject2.put("rs", k6);
                }
            } catch (Exception e6) {
                UMCrashManager.reportCrash(origApplicationContext, e6);
            }
            try {
                if (FieldManager.allow(com.umeng.commonsdk.utils.d.ao) && (l6 = l(origApplicationContext)) != null && l6.length() > 0) {
                    jSONObject2.put("by", l6);
                }
            } catch (Exception e7) {
                UMCrashManager.reportCrash(origApplicationContext, e7);
            }
            try {
                a(origApplicationContext, jSONObject2);
            } catch (Exception e8) {
                UMCrashManager.reportCrash(origApplicationContext, e8);
            }
            try {
                b(origApplicationContext, jSONObject2);
            } catch (Exception e9) {
                UMCrashManager.reportCrash(origApplicationContext, e9);
            }
            try {
                if (FieldManager.allow(com.umeng.commonsdk.utils.d.ap) && (a6 = a()) != null && a6.length() > 0) {
                    jSONObject2.put("build", a6);
                }
            } catch (Exception e10) {
                UMCrashManager.reportCrash(origApplicationContext, e10);
            }
            try {
                JSONObject e11 = e(origApplicationContext);
                if (e11 != null && e11.length() > 0) {
                    jSONObject2.put("scr", e11);
                }
            } catch (Exception e12) {
                UMCrashManager.reportCrash(origApplicationContext, e12);
            }
            try {
                JSONObject f6 = f(origApplicationContext);
                if (f6 != null && f6.length() > 0) {
                    jSONObject2.put("sinfo", f6);
                }
            } catch (Exception e13) {
                UMCrashManager.reportCrash(origApplicationContext, e13);
            }
            try {
                JSONArray g6 = g(origApplicationContext);
                if (g6 != null && g6.length() > 0) {
                    jSONObject2.put("input", g6);
                }
            } catch (Exception e14) {
                UMCrashManager.reportCrash(origApplicationContext, e14);
            }
            try {
                if (FieldManager.allow(com.umeng.commonsdk.utils.d.ag) && (h6 = h(origApplicationContext)) != null && h6.length() > 0) {
                    jSONObject2.put("appls", h6);
                }
            } catch (Exception e15) {
                UMCrashManager.reportCrash(origApplicationContext, e15);
            }
            try {
                JSONObject i6 = i(origApplicationContext);
                if (i6 != null && i6.length() > 0) {
                    jSONObject2.put("mem", i6);
                }
            } catch (Exception e16) {
                UMCrashManager.reportCrash(origApplicationContext, e16);
            }
            try {
                if (FieldManager.allow(com.umeng.commonsdk.utils.d.aq) && (b6 = b()) != null && b6.length() > 0) {
                    jSONObject2.put("cpu", b6);
                }
            } catch (Exception unused) {
            }
            try {
                jSONObject.put(bi.ax, jSONObject2);
            } catch (JSONException e17) {
                UMCrashManager.reportCrash(origApplicationContext, e17);
            }
        }
        return jSONObject;
    }

    public static JSONObject e(Context context) {
        DisplayMetrics displayMetrics;
        JSONObject jSONObject = new JSONObject();
        if (context != null) {
            try {
                jSONObject.put("a_st_h", com.umeng.commonsdk.internal.utils.a.c(context));
                jSONObject.put("a_nav_h", com.umeng.commonsdk.internal.utils.a.d(context));
                if (context.getResources() != null && (displayMetrics = context.getResources().getDisplayMetrics()) != null) {
                    jSONObject.put("a_den", displayMetrics.density);
                    jSONObject.put("a_dpi", displayMetrics.densityDpi);
                    return jSONObject;
                }
            } catch (Exception e6) {
                UMCrashManager.reportCrash(context, e6);
            }
        }
        return jSONObject;
    }

    public static JSONObject f(Context context) {
        JSONObject jSONObject = new JSONObject();
        if (context != null) {
            Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
            String packageName = origApplicationContext.getPackageName();
            try {
                jSONObject.put("a_fit", com.umeng.commonsdk.internal.utils.a.a(origApplicationContext, packageName));
                jSONObject.put("a_alut", com.umeng.commonsdk.internal.utils.a.b(origApplicationContext, packageName));
                jSONObject.put("a_c", com.umeng.commonsdk.internal.utils.a.c(origApplicationContext, packageName));
                jSONObject.put("a_uid", com.umeng.commonsdk.internal.utils.a.d(origApplicationContext, packageName));
                if (com.umeng.commonsdk.internal.utils.a.a()) {
                    jSONObject.put("a_root", 1);
                } else {
                    jSONObject.put("a_root", 0);
                }
                jSONObject.put("tf", com.umeng.commonsdk.internal.utils.a.b());
                jSONObject.put("s_fs", com.umeng.commonsdk.internal.utils.a.a(origApplicationContext));
                jSONObject.put("a_meid", DeviceConfig.getMeid(origApplicationContext));
                jSONObject.put("a_imsi", DeviceConfig.getImsi(origApplicationContext));
                jSONObject.put("st", com.umeng.commonsdk.internal.utils.a.c());
                String simICCID = DeviceConfig.getSimICCID(origApplicationContext);
                if (!TextUtils.isEmpty(simICCID)) {
                    try {
                        jSONObject.put("a_iccid", simICCID);
                    } catch (Exception unused) {
                    }
                }
                String secondSimIMEi = DeviceConfig.getSecondSimIMEi(origApplicationContext);
                if (!TextUtils.isEmpty(secondSimIMEi)) {
                    try {
                        jSONObject.put("a_simei", secondSimIMEi);
                    } catch (Exception unused2) {
                    }
                }
                jSONObject.put("hn", com.umeng.commonsdk.internal.utils.a.d());
                jSONObject.put("ts", System.currentTimeMillis());
            } catch (Exception e6) {
                UMCrashManager.reportCrash(origApplicationContext, e6);
            }
        }
        return jSONObject;
    }

    public static JSONArray g(Context context) {
        Context origApplicationContext;
        List<InputMethodInfo> f6;
        JSONArray jSONArray = new JSONArray();
        if (context != null && (f6 = com.umeng.commonsdk.internal.utils.a.f((origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext())))) != null) {
            for (InputMethodInfo inputMethodInfo : f6) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("a_id", inputMethodInfo.getId());
                    jSONObject.put("a_pn", inputMethodInfo.getPackageName());
                    jSONObject.put("ts", System.currentTimeMillis());
                    jSONArray.put(jSONObject);
                } catch (Throwable th) {
                    UMCrashManager.reportCrash(origApplicationContext, th);
                }
            }
        }
        return jSONArray;
    }

    public static JSONArray h(Context context) {
        Context origApplicationContext;
        List<a.C0827a> g6;
        JSONArray jSONArray = new JSONArray();
        if (context != null && (g6 = com.umeng.commonsdk.internal.utils.a.g((origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext())))) != null && !g6.isEmpty()) {
            for (a.C0827a c0827a : g6) {
                if (c0827a != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("a_pn", c0827a.f41797a);
                        jSONObject.put("a_la", c0827a.f41798b);
                        jSONObject.put("ts", System.currentTimeMillis());
                        jSONArray.put(jSONObject);
                    } catch (Exception e6) {
                        UMCrashManager.reportCrash(origApplicationContext, e6);
                    }
                }
            }
        }
        return jSONArray;
    }

    public static JSONObject i(Context context) {
        Context origApplicationContext;
        ActivityManager.MemoryInfo h6;
        JSONObject jSONObject = new JSONObject();
        if (context != null && (h6 = com.umeng.commonsdk.internal.utils.a.h((origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext())))) != null) {
            try {
                jSONObject.put(bi.aL, h6.totalMem);
                jSONObject.put("f", h6.availMem);
                jSONObject.put("ts", System.currentTimeMillis());
                return jSONObject;
            } catch (Exception e6) {
                UMCrashManager.reportCrash(origApplicationContext, e6);
            }
        }
        return jSONObject;
    }

    private static void j(Context context) {
        Context context2;
        Context context3;
        try {
            if (UMEnvelopeBuild.isReadyBuild(context, UMLogDataProtocol.UMBusinessType.U_INTERNAL)) {
                context2 = context;
                try {
                    UMWorkDispatch.sendEvent(context2, a.f41752f, b.a(context).a(), null, 5000L);
                } catch (Throwable th) {
                    th = th;
                    UMCrashManager.reportCrash(context2, th);
                }
            } else {
                context2 = context;
            }
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 冷启动：5秒后触发2号数据仓遗留信封检查动作。");
            context3 = context2;
        } catch (Throwable th2) {
            th = th2;
            context2 = context;
        }
        try {
            UMWorkDispatch.sendEvent(context3, a.f41768v, b.a(context2).a(), null, 5000L);
        } catch (Throwable th3) {
            th = th3;
            context2 = context3;
            UMCrashManager.reportCrash(context2, th);
        }
    }

    private static JSONArray l(Context context) {
        JSONArray jSONArray = new JSONArray();
        String a6 = j.a(context);
        if (!TextUtils.isEmpty(a6)) {
            try {
                jSONArray.put(new JSONObject(a6));
            } catch (Exception unused) {
            }
        }
        return jSONArray;
    }

    private static JSONObject b() {
        try {
            d.a a6 = com.umeng.commonsdk.internal.utils.d.a();
            if (a6 == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("pro", a6.f41811a);
                jSONObject.put("pla", a6.f41812b);
                jSONObject.put("cpus", a6.f41813c);
                jSONObject.put("fea", a6.f41814d);
                jSONObject.put(au.f40898c, a6.f41815e);
                jSONObject.put("arc", a6.f41816f);
                jSONObject.put("var", a6.f41817g);
                jSONObject.put("par", a6.f41818h);
                jSONObject.put("rev", a6.f41819i);
                jSONObject.put("har", a6.f41820j);
                jSONObject.put("rev", a6.f41821k);
                jSONObject.put("ser", a6.f41822l);
                jSONObject.put("cur_cpu", com.umeng.commonsdk.internal.utils.d.d());
                jSONObject.put("max_cpu", com.umeng.commonsdk.internal.utils.d.b());
                jSONObject.put("min_cpu", com.umeng.commonsdk.internal.utils.d.c());
                jSONObject.put("ts", System.currentTimeMillis());
                return jSONObject;
            } catch (Exception unused) {
                return jSONObject;
            }
        } catch (Exception unused2) {
            return null;
        }
    }

    private static void a(Context context, JSONObject jSONObject) {
        PackageManager packageManager;
        if (context == null || (packageManager = StubApp.getOrigApplicationContext(context.getApplicationContext()).getPackageManager()) == null) {
            return;
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        a(jSONObject, "gp", packageManager.hasSystemFeature("android.hardware.location.gps"));
        a(jSONObject, "to", packageManager.hasSystemFeature("android.hardware.touchscreen"));
        a(jSONObject, "mo", packageManager.hasSystemFeature("android.hardware.telephony"));
        a(jSONObject, ConstantHelper.LOG_CATE, packageManager.hasSystemFeature("android.hardware.camera"));
        a(jSONObject, "fl", packageManager.hasSystemFeature("android.hardware.camera.flash"));
    }

    private static void a(JSONObject jSONObject, String str, boolean z5) {
        if (jSONObject == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            if (z5) {
                jSONObject.put(str, 1);
            } else {
                jSONObject.put(str, 0);
            }
        } catch (Exception unused) {
        }
    }

    public static JSONObject a() {
        String str;
        int i6;
        String str2;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("a_pr", Build.PRODUCT);
            jSONObject.put("a_bl", Build.BOOTLOADER);
            jSONObject.put("a_rv", Build.getRadioVersion());
            jSONObject.put("a_fp", Build.FINGERPRINT);
            jSONObject.put("a_hw", Build.HARDWARE);
            jSONObject.put("a_host", Build.HOST);
            JSONArray jSONArray = new JSONArray();
            int i7 = 0;
            int i8 = 0;
            while (true) {
                String[] strArr = Build.SUPPORTED_32_BIT_ABIS;
                if (i8 >= strArr.length) {
                    break;
                }
                jSONArray.put(strArr[i8]);
                i8++;
            }
            if (jSONArray.length() > 0) {
                jSONObject.put("a_s32", jSONArray);
            }
            JSONArray jSONArray2 = new JSONArray();
            int i9 = 0;
            while (true) {
                String[] strArr2 = Build.SUPPORTED_64_BIT_ABIS;
                if (i9 >= strArr2.length) {
                    break;
                }
                jSONArray2.put(strArr2[i9]);
                i9++;
            }
            if (jSONArray2.length() > 0) {
                jSONObject.put("a_s64", jSONArray2);
            }
            JSONArray jSONArray3 = new JSONArray();
            while (true) {
                String[] strArr3 = Build.SUPPORTED_ABIS;
                if (i7 >= strArr3.length) {
                    break;
                }
                jSONArray3.put(strArr3[i7]);
                i7++;
            }
            if (jSONArray3.length() > 0) {
                jSONObject.put("a_sa", jSONArray3);
            }
            jSONObject.put("a_ta", Build.TAGS);
            jSONObject.put("a_uk", "unknown");
            jSONObject.put("a_user", Build.USER);
            jSONObject.put("a_cpu1", Build.CPU_ABI);
            jSONObject.put("a_cpu2", Build.CPU_ABI2);
            jSONObject.put("a_ra", Build.RADIO);
            if (Build.VERSION.SDK_INT >= 23) {
                str = Build.VERSION.BASE_OS;
                jSONObject.put("a_bos", str);
                i6 = Build.VERSION.PREVIEW_SDK_INT;
                jSONObject.put("a_pre", i6);
                str2 = Build.VERSION.SECURITY_PATCH;
                jSONObject.put("a_sp", str2);
            }
            jSONObject.put("a_cn", Build.VERSION.CODENAME);
            jSONObject.put("a_intl", Build.VERSION.INCREMENTAL);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private static void b(Context context, JSONObject jSONObject) {
        if (context != null) {
            String a6 = k.a(context);
            if (TextUtils.isEmpty(a6)) {
                return;
            }
            try {
                JSONObject jSONObject2 = new JSONObject(a6);
                if (jSONObject == null) {
                    jSONObject = new JSONObject();
                }
                if (jSONObject2.has(k.f41834d)) {
                    jSONObject.put(k.f41834d, jSONObject2.opt(k.f41834d));
                }
                if (jSONObject2.has(k.f41833c)) {
                    jSONObject.put(k.f41833c, jSONObject2.opt(k.f41833c));
                }
                if (jSONObject2.has(k.f41832b)) {
                    jSONObject.put(k.f41832b, jSONObject2.opt(k.f41832b));
                }
            } catch (Exception unused) {
            }
        }
    }
}
