package com.umeng.commonsdk.internal.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.stub.StubApp;
import com.umeng.analytics.pro.au;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.common.ULog;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SuppressLint({"NewApi"})
/* loaded from: D:\Downloads\app\classes7.dex */
public class k {

    /* renamed from: b, reason: collision with root package name */
    public static final String f41832b = "_dsk_s";

    /* renamed from: c, reason: collision with root package name */
    public static final String f41833c = "_thm_z";

    /* renamed from: d, reason: collision with root package name */
    public static final String f41834d = "_gdf_r";

    /* renamed from: a, reason: collision with root package name */
    public static final String f41831a = au.b().b(au.f40914s);

    /* renamed from: e, reason: collision with root package name */
    private static Object f41835e = new Object();

    public static void b(final Context context) {
        if (c(context)) {
            return;
        }
        final String[] strArr = {"unknown", "unknown", "unknown"};
        new Thread() { // from class: com.umeng.commonsdk.internal.utils.k.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                super.run();
                try {
                    strArr[0] = k.c();
                    strArr[1] = k.a();
                    strArr[2] = k.b();
                    ULog.i("diskType = " + strArr[0] + "; ThremalZone = " + strArr[1] + "; GoldFishRc = " + strArr[2]);
                    k.b(context, strArr);
                } catch (Throwable th) {
                    UMCrashManager.reportCrash(context, th);
                }
            }
        }.start();
    }

    public static boolean c(Context context) {
        SharedPreferences sharedPreferences;
        return (context == null || (sharedPreferences = StubApp.getOrigApplicationContext(context.getApplicationContext()).getSharedPreferences(f41831a, 0)) == null || TextUtils.isEmpty(sharedPreferences.getString(f41832b, ""))) ? false : true;
    }

    public static String a(Context context) {
        try {
            SharedPreferences sharedPreferences = StubApp.getOrigApplicationContext(context.getApplicationContext()).getSharedPreferences(f41831a, 0);
            if (sharedPreferences == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            synchronized (f41835e) {
                jSONObject.put(f41832b, sharedPreferences.getString(f41832b, ""));
                jSONObject.put(f41833c, sharedPreferences.getString(f41833c, ""));
                jSONObject.put(f41834d, sharedPreferences.getString(f41834d, ""));
            }
            return jSONObject.toString();
        } catch (Exception e6) {
            UMCrashManager.reportCrash(context, e6);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Context context, String[] strArr) {
        SharedPreferences sharedPreferences;
        if (context == null || (sharedPreferences = StubApp.getOrigApplicationContext(context.getApplicationContext()).getSharedPreferences(f41831a, 0)) == null) {
            return;
        }
        synchronized (f41835e) {
            sharedPreferences.edit().putString(f41832b, strArr[0]).putString(f41833c, strArr[1]).putString(f41834d, strArr[2]).commit();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x003a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String c() {
        /*
            java.lang.String r0 = "mtd"
            java.lang.String r1 = "sda"
            java.lang.String r2 = "mmcblk"
            r3 = 0
            java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L35
            java.io.FileReader r5 = new java.io.FileReader     // Catch: java.lang.Throwable -> L35
            java.lang.String r6 = "/proc/diskstats"
            r5.<init>(r6)     // Catch: java.lang.Throwable -> L35
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L35
        L13:
            java.lang.String r3 = r4.readLine()     // Catch: java.lang.Throwable -> L30
            if (r3 == 0) goto L32
            boolean r5 = r3.contains(r2)     // Catch: java.lang.Throwable -> L30
            if (r5 == 0) goto L21
            r0 = r2
            goto L38
        L21:
            boolean r5 = r3.contains(r1)     // Catch: java.lang.Throwable -> L30
            if (r5 == 0) goto L29
            r0 = r1
            goto L38
        L29:
            boolean r3 = r3.contains(r0)     // Catch: java.lang.Throwable -> L30
            if (r3 == 0) goto L13
            goto L38
        L30:
            r3 = r4
            goto L35
        L32:
            java.lang.String r0 = "unknown"
            goto L38
        L35:
            java.lang.String r0 = "noper"
            r4 = r3
        L38:
            if (r4 == 0) goto L3d
            r4.close()     // Catch: java.lang.Throwable -> L3d
        L3d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.internal.utils.k.c():java.lang.String");
    }

    public static String b() {
        int i6;
        try {
            i6 = a("ls /", "goldfish");
        } catch (Throwable unused) {
            i6 = -1;
        }
        if (i6 > 0) {
            return "goldfish";
        }
        if (i6 < 0) {
            return "noper";
        }
        return "unknown";
    }

    public static int a(String str, String str2) throws IOException {
        int i6;
        if (Build.VERSION.SDK_INT > 28) {
            return -1;
        }
        Process exec = Runtime.getRuntime().exec(str);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()));
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                i6 = -1;
                break;
            }
            if (readLine.contains(str2)) {
                i6 = 1;
                break;
            }
        }
        try {
            if (exec.waitFor() != 0) {
                return -1;
            }
            return i6;
        } catch (InterruptedException unused) {
            return -1;
        }
    }

    public static String a() {
        int i6;
        try {
            i6 = a("ls /sys/class/thermal", "thermal_zone");
        } catch (Throwable unused) {
            i6 = -1;
        }
        if (i6 > 0) {
            return "thermal_zone";
        }
        if (i6 < 0) {
            return "noper";
        }
        return "unknown";
    }
}
