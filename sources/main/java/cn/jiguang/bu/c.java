package cn.jiguang.bu;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import androidx.core.view.PointerIconCompat;
import cn.jiguang.bb.f;
import cn.jiguang.bp.b;
import cn.jiguang.bz.o;
import cn.jiguang.bz.p;
import cn.jiguang.bz.s;
import cn.jiguang.internal.JConstants;
import com.baidu.mobads.sdk.internal.bn;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.huawei.hms.common.util.Logger;
import com.umeng.analytics.pro.bi;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* loaded from: D:\Downloads\app\classes2.dex */
public final class c {
    private static StatFs a(File file, Context context) {
        String str;
        if (cn.jiguang.bz.a.d()) {
            File b6 = b(file, context);
            if (b6 != null) {
                return new StatFs(b6.getPath());
            }
            str = "Not possible to read external files directory";
        } else {
            str = "External storage is not mounted or emulated.";
        }
        f.f("SentryUtils", str);
        return null;
    }

    private static long b(StatFs statFs) {
        return statFs.getBlockSizeLong();
    }

    private static int c(StatFs statFs) {
        return statFs.getBlockSize();
    }

    private static long d(StatFs statFs) {
        return statFs.getBlockCountLong();
    }

    private static int e(StatFs statFs) {
        return statFs.getBlockCount();
    }

    private static long f(StatFs statFs) {
        return statFs.getAvailableBlocksLong();
    }

    private static int g(StatFs statFs) {
        return statFs.getAvailableBlocks();
    }

    private static b.a h(Context context) {
        Exception e6;
        b.a aVar;
        try {
            aVar = cn.jiguang.bp.b.a(context.getResources().getConfiguration().orientation);
            if (aVar != null) {
                return aVar;
            }
            try {
                f.f("SentryUtils", "No device orientation available (ORIENTATION_SQUARE|ORIENTATION_UNDEFINED)");
                return null;
            } catch (Exception e7) {
                e6 = e7;
                f.a("SentryUtils", "Error getting device orientation.", e6);
                return aVar;
            }
        } catch (Exception e8) {
            e6 = e8;
            aVar = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00b1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.Boolean i(android.content.Context r6) {
        /*
            java.lang.String r0 = "generic"
            java.lang.String r1 = android.os.Build.BRAND     // Catch: java.lang.Exception -> Ld1
            boolean r1 = r1.startsWith(r0)     // Catch: java.lang.Exception -> Ld1
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L14
            java.lang.String r1 = android.os.Build.DEVICE     // Catch: java.lang.Exception -> Ld1
            boolean r1 = r1.startsWith(r0)     // Catch: java.lang.Exception -> Ld1
            if (r1 != 0) goto L39
        L14:
            java.lang.String r1 = android.os.Build.FINGERPRINT     // Catch: java.lang.Exception -> Ld1
            boolean r0 = r1.startsWith(r0)     // Catch: java.lang.Exception -> Ld1
            if (r0 != 0) goto L39
            java.lang.String r0 = "unknown"
            boolean r0 = r1.startsWith(r0)     // Catch: java.lang.Exception -> Ld1
            if (r0 != 0) goto L39
            java.lang.String r0 = android.os.Build.HARDWARE     // Catch: java.lang.Exception -> Ld1
            java.lang.String r1 = "goldfish"
            boolean r1 = r0.contains(r1)     // Catch: java.lang.Exception -> Ld1
            if (r1 != 0) goto L39
            java.lang.String r1 = "ranchu"
            boolean r0 = r0.contains(r1)     // Catch: java.lang.Exception -> Ld1
            if (r0 == 0) goto L37
            goto L39
        L37:
            r0 = 0
            goto L3a
        L39:
            r0 = 1
        L3a:
            cn.jiguang.bz.a r1 = cn.jiguang.bz.a.a()     // Catch: java.lang.Exception -> Ld1
            java.lang.String r1 = r1.t(r6)     // Catch: java.lang.Exception -> Ld1
            boolean r4 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Exception -> Ld1
            java.lang.String r5 = "google_sdk"
            if (r4 != 0) goto L87
            if (r0 != 0) goto L86
            java.lang.String r0 = "sdk_google"
            boolean r0 = r1.contains(r0)     // Catch: java.lang.Exception -> Ld1
            if (r0 != 0) goto L86
            boolean r0 = r1.contains(r5)     // Catch: java.lang.Exception -> Ld1
            if (r0 != 0) goto L86
            java.lang.String r0 = "sdk"
            boolean r0 = r1.contains(r0)     // Catch: java.lang.Exception -> Ld1
            if (r0 != 0) goto L86
            java.lang.String r0 = "sdk_x86"
            boolean r0 = r1.contains(r0)     // Catch: java.lang.Exception -> Ld1
            if (r0 != 0) goto L86
            java.lang.String r0 = "vbox86p"
            boolean r0 = r1.contains(r0)     // Catch: java.lang.Exception -> Ld1
            if (r0 != 0) goto L86
            java.lang.String r0 = "emulator"
            boolean r0 = r1.contains(r0)     // Catch: java.lang.Exception -> Ld1
            if (r0 != 0) goto L86
            java.lang.String r0 = "simulator"
            boolean r0 = r1.contains(r0)     // Catch: java.lang.Exception -> Ld1
            if (r0 == 0) goto L84
            goto L86
        L84:
            r0 = 0
            goto L87
        L86:
            r0 = 1
        L87:
            cn.jiguang.bz.a r1 = cn.jiguang.bz.a.a()     // Catch: java.lang.Exception -> Ld1
            java.lang.String r1 = r1.B(r6)     // Catch: java.lang.Exception -> Ld1
            boolean r4 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Exception -> Ld1
            if (r4 != 0) goto La3
            if (r0 != 0) goto La2
            java.lang.String r0 = "Genymotion"
            boolean r0 = r1.contains(r0)     // Catch: java.lang.Exception -> Ld1
            if (r0 == 0) goto La0
            goto La2
        La0:
            r0 = 0
            goto La3
        La2:
            r0 = 1
        La3:
            cn.jiguang.bz.a r1 = cn.jiguang.bz.a.a()     // Catch: java.lang.Exception -> Ld1
            java.lang.String r6 = r1.y(r6)     // Catch: java.lang.Exception -> Ld1
            boolean r1 = android.text.TextUtils.isEmpty(r6)     // Catch: java.lang.Exception -> Ld1
            if (r1 != 0) goto Lcc
            if (r0 != 0) goto Lcb
            boolean r0 = r6.contains(r5)     // Catch: java.lang.Exception -> Ld1
            if (r0 != 0) goto Lcb
            java.lang.String r0 = "Emulator"
            boolean r0 = r6.contains(r0)     // Catch: java.lang.Exception -> Ld1
            if (r0 != 0) goto Lcb
            java.lang.String r0 = "Android SDK built for x86"
            boolean r6 = r6.contains(r0)     // Catch: java.lang.Exception -> Ld1
            if (r6 == 0) goto Lca
            goto Lcb
        Lca:
            r2 = 0
        Lcb:
            r0 = r2
        Lcc:
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r0)     // Catch: java.lang.Exception -> Ld1
            return r6
        Ld1:
            r6 = move-exception
            java.lang.String r0 = "SentryUtils"
            java.lang.String r1 = "Error checking whether application is running in an emulator."
            cn.jiguang.bb.f.b(r0, r1, r6)
            r6 = 0
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.bu.c.i(android.content.Context):java.lang.Boolean");
    }

    private static Long j(StatFs statFs) {
        try {
            return Long.valueOf(f(statFs) * b(statFs));
        } catch (Exception e6) {
            f.a("SentryUtils", "Error getting unused external storage amount.", e6);
            return null;
        }
    }

    private static Float a(Intent intent) {
        try {
            int intExtra = intent.getIntExtra("level", -1);
            int intExtra2 = intent.getIntExtra("scale", -1);
            if (intExtra != -1 && intExtra2 != -1) {
                return Float.valueOf((intExtra / intExtra2) * 100.0f);
            }
            return null;
        } catch (Exception e6) {
            f.a("SentryUtils", "Error getting device battery level.", e6);
            return null;
        }
    }

    private static File b(File file, Context context) {
        File[] j6 = j(context);
        if (j6 != null) {
            String absolutePath = file != null ? file.getAbsolutePath() : null;
            for (File file2 : j6) {
                if (file2 != null && (absolutePath == null || absolutePath.isEmpty() || !file2.getAbsolutePath().contains(absolutePath))) {
                    return file2;
                }
            }
        } else {
            f.f("SentryUtils", "Not possible to read getExternalFilesDirs");
        }
        return null;
    }

    private static Float c(Intent intent) {
        try {
            int intExtra = intent.getIntExtra("temperature", -1);
            if (intExtra != -1) {
                return Float.valueOf(intExtra / 10.0f);
            }
            return null;
        } catch (Exception e6) {
            f.a("SentryUtils", "Error getting battery temperature.", e6);
            return null;
        }
    }

    private static JSONArray d() {
        JSONArray jSONArray = new JSONArray();
        for (String str : Build.SUPPORTED_ABIS) {
            jSONArray.put(str);
        }
        return jSONArray;
    }

    private static ActivityManager.MemoryInfo e(Context context) {
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            if (activityManager != null) {
                activityManager.getMemoryInfo(memoryInfo);
                return memoryInfo;
            }
            f.c("SentryUtils", "Error getting MemoryInfo.");
            return null;
        } catch (Exception e6) {
            f.a("SentryUtils", "Error getting MemoryInfo.", e6);
            return null;
        }
    }

    private static Intent f(Context context) {
        return s.a(context, null, new IntentFilter("android.intent.action.BATTERY_CHANGED"), false);
    }

    private static String g(Context context) {
        try {
            String y5 = cn.jiguang.bz.a.a().y(context);
            if (TextUtils.isEmpty(y5)) {
                return null;
            }
            return y5.split(" ", -1)[0];
        } catch (Exception e6) {
            f.a("SentryUtils", "Error getting device family.", e6);
            return null;
        }
    }

    private static Long h(StatFs statFs) {
        try {
            return Long.valueOf(f(statFs) * b(statFs));
        } catch (Exception e6) {
            f.a("SentryUtils", "Error getting unused internal storage amount.", e6);
            return null;
        }
    }

    private static Long i(StatFs statFs) {
        try {
            return Long.valueOf(d(statFs) * b(statFs));
        } catch (Exception e6) {
            f.a("SentryUtils", "Error getting total external storage amount.", e6);
            return null;
        }
    }

    private static File[] j(Context context) {
        return context.getExternalFilesDirs(null);
    }

    private static Long a(ActivityManager.MemoryInfo memoryInfo) {
        return Long.valueOf(memoryInfo.totalMem);
    }

    private static Boolean b(Intent intent) {
        try {
            int intExtra = intent.getIntExtra("plugged", -1);
            boolean z5 = true;
            if (intExtra != 1 && intExtra != 2) {
                z5 = false;
            }
            return Boolean.valueOf(z5);
        } catch (Exception e6) {
            f.a("SentryUtils", "Error getting device charging state.", e6);
            return null;
        }
    }

    private static String c() {
        return Build.CPU_ABI2;
    }

    public static JSONObject d(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("build", Build.DISPLAY);
            jSONObject.put("kernel_version", cn.jiguang.bz.a.i());
            jSONObject.put(CommonNetImpl.NAME, "Android");
            jSONObject.put("rooted", cn.jiguang.bz.a.a().p(context));
            jSONObject.put("version", cn.jiguang.bz.a.a().D(context));
            return jSONObject;
        } catch (JSONException e6) {
            f.a("SentryUtils", "Error getting OperatingSystem.", e6);
            return null;
        }
    }

    private static DisplayMetrics k(Context context) {
        try {
            return context.getResources().getDisplayMetrics();
        } catch (Exception e6) {
            f.a("SentryUtils", "Error getting DisplayMetrics.", e6);
            return null;
        }
    }

    private static Long a(StatFs statFs) {
        try {
            return Long.valueOf(d(statFs) * b(statFs));
        } catch (Exception e6) {
            f.a("SentryUtils", "Error getting total internal storage amount.", e6);
            return null;
        }
    }

    private static String b() {
        return Build.CPU_ABI;
    }

    public static JSONObject c(Context context) {
        StatFs a6;
        ActivityManager.MemoryInfo e6;
        try {
            JSONObject jSONObject = new JSONObject();
            if (cn.jiguang.g.a.a().e(1005)) {
                jSONObject.put("archs", d());
            }
            jSONObject.put(CommonNetImpl.NAME, cn.jiguang.bz.a.H(context));
            jSONObject.put("manufacturer", cn.jiguang.bz.a.a().B(context));
            jSONObject.put(bn.f10754j, cn.jiguang.bz.a.a().z(context));
            jSONObject.put(IjkMediaPlayer.OnNativeInvokeListener.ARG_FAMILIY, g(context));
            jSONObject.put(bn.f10753i, cn.jiguang.bz.a.a().y(context));
            jSONObject.put("model_id", Build.ID);
            Intent f6 = f(context);
            if (f6 != null) {
                jSONObject.put("battery_level", a(f6));
                jSONObject.put("charging", b(f6));
                jSONObject.put("battery_temperature", c(f6));
            }
            jSONObject.put("online", o.c());
            jSONObject.put("orientation", h(context));
            jSONObject.put("simulator", i(context));
            if (cn.jiguang.g.a.a().e(PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW) && (e6 = e(context)) != null) {
                jSONObject.put("memory_size", a(e6));
                jSONObject.put("free_memory", e6.availMem);
                jSONObject.put("low_memory", e6.lowMemory);
            }
            File externalFilesDir = context.getExternalFilesDir(null);
            if (externalFilesDir != null) {
                StatFs statFs = new StatFs(externalFilesDir.getPath());
                jSONObject.put("storage_size", a(statFs));
                jSONObject.put("free_storage", h(statFs));
            }
            if (cn.jiguang.g.a.a().e(PointerIconCompat.TYPE_ZOOM_IN) && (a6 = a(externalFilesDir, context)) != null) {
                jSONObject.put("external_storage_size", i(a6));
                jSONObject.put("external_free_storage", j(a6));
            }
            String k6 = cn.jiguang.bz.a.a().k(context);
            if (!TextUtils.isEmpty(k6)) {
                String[] split = k6.split("\\*");
                try {
                    jSONObject.put("screen_width_pixels", split[0]);
                    jSONObject.put("screen_height_pixels", split[1]);
                } catch (Throwable unused) {
                }
            }
            DisplayMetrics k7 = k(context);
            if (k7 != null) {
                jSONObject.put("screen_density", k7.density);
                jSONObject.put("screen_dpi", k7.densityDpi);
            }
            jSONObject.put("boot_time", cn.jiguang.bz.a.a().G(context));
            jSONObject.put(bi.M, cn.jiguang.bz.a.a().C(context));
            jSONObject.put("id", cn.jiguang.d.a.i(context));
            jSONObject.put("language", cn.jiguang.bz.a.a().A(context));
            jSONObject.put("connection_type", o.f());
            return jSONObject;
        } catch (JSONException e7) {
            f.a("SentryUtils", "Error getting Device.", e7);
            return null;
        }
    }

    public static String a(String str) {
        return TextUtils.isEmpty(str) ? "" : str.contains("cn.jpush.im") ? "JMessage" : str.contains("cn.jiguang.analytics") ? "JAnalysis" : str.contains("cn.jiguang.share") ? "JShare" : (str.contains("cn.jiguang.union.ads") || str.contains("cn.jiguang.ads")) ? "JAd" : str.contains("cn.jiguang.verifysdk") ? "JVerification" : str.contains("cn.jiguang.jmlinksdk") ? "JMlink" : str.contains("cn.jiguang.junion") ? "JUnion" : str.contains("cn.jiguang.portrait") ? "JPortrait" : (str.contains("cn.jpush.android") || str.contains("cn.jpush")) ? "JPush" : (str.contains("cn.jiguang.common") || str.contains("cn.jiguang")) ? JConstants.SDK_TYPE : "";
    }

    public static JSONObject b(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", cn.jiguang.ba.a.a(context) + Logger.f33116c + cn.jiguang.d.a.b(context));
            return jSONObject;
        } catch (JSONException e6) {
            f.a("SentryUtils", "Error getting user.", e6);
            return null;
        }
    }

    public static JSONObject a() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(CommonNetImpl.NAME, "sentry.java.android");
            jSONObject.put("version", "5.0.1");
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(CommonNetImpl.NAME, "maven:io.sentry:sentry");
            jSONObject2.put("version", "5.0.1");
            jSONArray.put(jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(CommonNetImpl.NAME, "maven:io.sentry:sentry-android-core");
            jSONObject3.put("version", "5.0.1");
            jSONArray.put(jSONObject3);
            jSONObject.put("packages", jSONArray);
            return jSONObject;
        } catch (JSONException e6) {
            f.a("SentryUtils", "Error getting SDK version.", e6);
            return null;
        }
    }

    public static JSONObject a(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            Pair<String, Long> d6 = cn.jiguang.ba.a.d(context);
            jSONObject.put("app_build", Long.toString(((Long) d6.second).longValue()));
            jSONObject.put("app_identifier", p.a(context));
            jSONObject.put("app_name", cn.jiguang.bz.a.j(context));
            jSONObject.put("app_start_time", cn.jiguang.a.a.f1450h);
            jSONObject.put("app_version", d6.first);
            return jSONObject;
        } catch (JSONException e6) {
            f.a("SentryUtils", "Error getting App.", e6);
            return null;
        }
    }
}
