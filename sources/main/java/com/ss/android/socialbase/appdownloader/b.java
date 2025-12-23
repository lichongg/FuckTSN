package com.ss.android.socialbase.appdownloader;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import cn.jiguang.bz.c0;
import com.bytedance.sdk.component.utils.vl;
import com.ss.android.socialbase.downloader.ae.cw;
import com.ss.android.socialbase.downloader.az.m;
import com.ss.android.socialbase.downloader.az.oq;
import com.ss.android.socialbase.downloader.downloader.ae;
import com.ss.android.socialbase.downloader.notification.xt;
import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import x2.k;

/* loaded from: D:\Downloads\app\classes6.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static int f38349a;

    /* renamed from: b, reason: collision with root package name */
    private static NotificationChannel f38350b;

    static class a implements x2.i {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f38351a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f38352b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f38353c;

        a(Context context, int i6, boolean z5) {
            this.f38351a = context;
            this.f38352b = i6;
            this.f38353c = z5;
        }

        @Override // x2.i
        public void j() {
            int unused = b.f38349a = b.G(this.f38351a, this.f38352b, this.f38353c);
        }
    }

    /* renamed from: com.ss.android.socialbase.appdownloader.b$b, reason: collision with other inner class name */
    static class RunnableC0771b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f38354a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f38355b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f38356c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ cw f38357d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ File f38358e;

        RunnableC0771b(Context context, int i6, boolean z5, cw cwVar, File file) {
            this.f38354a = context;
            this.f38355b = i6;
            this.f38356c = z5;
            this.f38357d = cwVar;
            this.f38358e = file;
        }

        @Override // java.lang.Runnable
        public void run() {
            f.L().Q();
            int i6 = b.i(this.f38354a, this.f38355b, this.f38356c, this.f38357d, this.f38358e);
            if (i6 == 1 && f.L().R() != null) {
                f.L().R().j(this.f38357d, null);
            }
            b.O(this.f38357d, this.f38356c, i6);
        }
    }

    public static boolean B(Context context, cw cwVar, PackageInfo packageInfo, boolean z5) {
        PackageInfo packageInfo2;
        if (packageInfo == null) {
            return false;
        }
        String str = packageInfo.packageName;
        int i6 = packageInfo.versionCode;
        if (cwVar != null) {
            cwVar.tl(i6);
        }
        try {
            packageInfo2 = context.getPackageManager().getPackageInfo(str, e());
        } catch (PackageManager.NameNotFoundException unused) {
            packageInfo2 = null;
        }
        if (packageInfo2 == null) {
            return false;
        }
        int i7 = packageInfo2.versionCode;
        return z5 ? i6 < i7 : (cwVar == null || com.ss.android.socialbase.downloader.jy.j.j(cwVar.ae()).j("install_with_same_version_code", 0) != 1) ? i6 <= i7 : i6 < i7;
    }

    public static boolean C(Context context, cw cwVar, String str) {
        if (context == null) {
            return false;
        }
        try {
            File file = new File(cwVar.qv(), cwVar.tl());
            PackageInfo packageInfo = null;
            if (file.exists()) {
                vl.r("AppDownloadUtils", "isPackageNameEqualsWithApk fileName:" + cwVar.tl() + " apkFileSize：" + file.length() + " fileUrl：" + cwVar.oq());
                PackageInfo m6 = m(cwVar, file);
                if (m6 == null || !m6.packageName.equals(str)) {
                    return false;
                }
                int i6 = m6.versionCode;
                try {
                    packageInfo = context.getPackageManager().getPackageInfo(str, e());
                } catch (PackageManager.NameNotFoundException unused) {
                }
                if (packageInfo == null || i6 != packageInfo.versionCode) {
                    return false;
                }
            } else {
                if (!com.ss.android.socialbase.downloader.jy.j.j(cwVar.ae()).j("install_callback_error")) {
                    return false;
                }
                String j6 = m.j(cwVar.vm().get("extra_apk_package_name"), (String) null);
                int j7 = m.j(cwVar.vm().get("extra_apk_version_code"), 0);
                if (j6 == null || TextUtils.isEmpty(j6) || !j6.equals(str)) {
                    return false;
                }
                try {
                    packageInfo = context.getPackageManager().getPackageInfo(str, e());
                } catch (PackageManager.NameNotFoundException unused2) {
                }
                if (packageInfo == null || j7 != packageInfo.versionCode) {
                    return false;
                }
            }
            return true;
        } catch (Exception e6) {
            vl.j(e6);
            return false;
        }
    }

    public static boolean D(Context context, cw cwVar, boolean z5) {
        PackageInfo packageInfo;
        if (cwVar == null) {
            return false;
        }
        String la = cwVar.la();
        int ov = cwVar.ov();
        if (ov <= 0 && z5) {
            return c(context, cwVar);
        }
        try {
            packageInfo = context.getPackageManager().getPackageInfo(la, e());
        } catch (PackageManager.NameNotFoundException unused) {
            packageInfo = null;
        }
        if (packageInfo == null) {
            return false;
        }
        return com.ss.android.socialbase.downloader.jy.j.j(cwVar.ae()).j("install_with_same_version_code", 0) == 1 ? ov < packageInfo.versionCode : ov <= packageInfo.versionCode;
    }

    public static int K(Context context, cw cwVar) {
        if (context != null && cwVar != null && !TextUtils.isEmpty(cwVar.qv()) && !TextUtils.isEmpty(cwVar.tl())) {
            int ov = cwVar.ov();
            if (ov > 0) {
                return ov;
            }
            try {
                PackageInfo l6 = l(context, cwVar, cwVar.qv(), cwVar.tl());
                if (l6 != null) {
                    int i6 = l6.versionCode;
                    cwVar.tl(i6);
                    return i6;
                }
            } catch (Throwable unused) {
            }
        }
        return 0;
    }

    public static String M(long j6) {
        long[] jArr = {1099511627776L, IjkMediaMeta.AV_CH_STEREO_RIGHT, PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED, 1024, 1};
        String[] strArr = {"TB", "GB", "MB", "KB", "B"};
        if (j6 < 1) {
            return "0 " + strArr[4];
        }
        for (int i6 = 0; i6 < 5; i6++) {
            long j7 = jArr[i6];
            if (j6 >= j7) {
                return p(j6, j7, strArr[i6]);
            }
        }
        return null;
    }

    public static boolean P(Context context, cw cwVar, PackageInfo packageInfo) {
        return B(context, cwVar, packageInfo, false);
    }

    public static int f(int i6) {
        if (i6 == 0) {
            return 0;
        }
        if (i6 == -2) {
            return 2;
        }
        if (i6 == 1) {
            return 4;
        }
        if (com.ss.android.socialbase.downloader.xt.m.xt(i6) || i6 == 11) {
            return 1;
        }
        return com.ss.android.socialbase.downloader.xt.m.j(i6) ? 3 : 0;
    }

    public static int j(Context context, Intent intent) {
        try {
            if (f.L().g() != null) {
                if (f.L().g().j(intent)) {
                    return 1;
                }
            }
        } catch (Throwable unused) {
        }
        try {
            context.startActivity(intent);
            return 1;
        } catch (Throwable unused2) {
            return 0;
        }
    }

    public static String o(long j6) {
        return r(j6, true);
    }

    public static String r(long j6, boolean z5) {
        long[] jArr = {1099511627776L, IjkMediaMeta.AV_CH_STEREO_RIGHT, PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED, 1024, 1};
        String[] strArr = {"TB", "GB", "MB", "KB", "B"};
        if (j6 < 1) {
            return "0 " + strArr[4];
        }
        for (int i6 = 0; i6 < 5; i6++) {
            long j7 = jArr[i6];
            if (j6 >= j7) {
                return q(j6, j7, strArr[i6], z5);
            }
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0036, code lost:
    
        if (r4 == null) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean x(android.content.Context r4) {
        /*
            r0 = 0
            if (r4 != 0) goto L4
            return r0
        L4:
            int r1 = com.ss.android.socialbase.appdownloader.i.w()     // Catch: java.lang.Throwable -> L35
            android.content.res.Resources r2 = r4.getResources()     // Catch: java.lang.Throwable -> L35
            int r1 = r2.getColor(r1)     // Catch: java.lang.Throwable -> L35
            int r2 = com.ss.android.socialbase.appdownloader.i.d()     // Catch: java.lang.Throwable -> L35
            int r3 = com.ss.android.socialbase.appdownloader.i.o()     // Catch: java.lang.Throwable -> L35
            int[] r2 = new int[]{r2, r3}     // Catch: java.lang.Throwable -> L35
            int r3 = com.ss.android.socialbase.appdownloader.i.r()     // Catch: java.lang.Throwable -> L35
            android.content.res.TypedArray r4 = r4.obtainStyledAttributes(r3, r2)     // Catch: java.lang.Throwable -> L35
            int r2 = r4.getColor(r0, r0)     // Catch: java.lang.Throwable -> L33
            if (r1 != r2) goto L2f
            r4.recycle()     // Catch: java.lang.Throwable -> L2d
        L2d:
            r4 = 1
            return r4
        L2f:
            r4.recycle()     // Catch: java.lang.Throwable -> L39
            goto L39
        L33:
            goto L36
        L35:
            r4 = 0
        L36:
            if (r4 == 0) goto L39
            goto L2f
        L39:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.b.x(android.content.Context):boolean");
    }

    public static boolean z(Context context, cw cwVar) {
        return D(context, cwVar, true);
    }

    public static boolean A(Context context, cw cwVar, PackageInfo packageInfo) {
        if (packageInfo == null || packageInfo.packageName.equals(cwVar.la())) {
            return false;
        }
        x2.m d6 = f.L().d();
        if (d6 != null) {
            d6.a(cwVar.ae(), 8, cwVar.la(), packageInfo.packageName, "");
            if (d6.j()) {
                return true;
            }
        }
        com.ss.android.socialbase.downloader.r.h g6 = ae.xt(context).g(cwVar.ae());
        if (g6 == null) {
            return false;
        }
        g6.j(8, cwVar, packageInfo.packageName, "");
        k X = f.L().X();
        return (X instanceof x2.f) && ((x2.f) X).a();
    }

    @TargetApi(26)
    public static String N(@NonNull Context context) {
        try {
            if (f38350b == null) {
                cn.jpush.android.f.g.a();
                NotificationChannel a6 = c0.a("111111", "channel_appdownloader", 3);
                f38350b = a6;
                a6.setSound(null, null);
                f38350b.setShowBadge(false);
                ((NotificationManager) context.getSystemService("notification")).createNotificationChannel(f38350b);
            }
        } catch (Throwable th) {
            vl.j(th);
        }
        return "111111";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void O(cw cwVar, boolean z5, int i6) {
        if (cwVar == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("by_user", z5 ? 1 : 2);
            jSONObject.put("view_result", i6);
            jSONObject.put("real_package_name", cwVar.gq());
        } catch (Exception e6) {
            vl.j(e6);
        }
        com.ss.android.socialbase.downloader.downloader.cw.ol().j(cwVar.ae(), "install_view_result", jSONObject);
    }

    public static List<String> b() {
        ArrayList arrayList = new ArrayList(2);
        arrayList.add("application/vnd.android.package-archive");
        arrayList.add("application/ttpatch");
        return arrayList;
    }

    public static boolean c(Context context, cw cwVar) {
        if (context == null || cwVar == null || TextUtils.isEmpty(cwVar.qv()) || TextUtils.isEmpty(cwVar.tl())) {
            return false;
        }
        return P(context, cwVar, l(context, cwVar, cwVar.qv(), cwVar.tl()));
    }

    public static PackageInfo m(cw cwVar, File file) {
        if (cwVar == null) {
            return com.ss.android.socialbase.appdownloader.m.j.f.a(com.ss.android.socialbase.downloader.downloader.cw.nd(), file, e());
        }
        PackageInfo ij = cwVar.ij();
        if (ij != null) {
            return ij;
        }
        PackageInfo a6 = com.ss.android.socialbase.appdownloader.m.j.f.a(com.ss.android.socialbase.downloader.downloader.cw.nd(), file, e());
        cwVar.j(a6);
        return a6;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0021 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.net.Uri n(int r1, com.ss.android.socialbase.downloader.r.tj r2, android.content.Context r3, java.lang.String r4, java.io.File r5) {
        /*
            if (r2 == 0) goto Lb
            java.lang.String r1 = r5.getAbsolutePath()     // Catch: java.lang.Throwable -> L1e
            android.net.Uri r1 = r2.j(r4, r1)     // Catch: java.lang.Throwable -> L1e
            goto L1f
        Lb:
            com.ss.android.socialbase.appdownloader.f r2 = com.ss.android.socialbase.appdownloader.f.L()
            x2.a r2 = r2.I()
            if (r2 == 0) goto L1e
            java.lang.String r0 = r5.getAbsolutePath()     // Catch: java.lang.Throwable -> L1e
            android.net.Uri r1 = r2.j(r1, r4, r0)     // Catch: java.lang.Throwable -> L1e
            goto L1f
        L1e:
            r1 = 0
        L1f:
            if (r1 != 0) goto L3c
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L32
            r0 = 24
            if (r2 < r0) goto L34
            boolean r2 = android.text.TextUtils.isEmpty(r4)     // Catch: java.lang.Throwable -> L32
            if (r2 != 0) goto L34
            android.net.Uri r1 = androidx.core.content.FileProvider.getUriForFile(r3, r4, r5)     // Catch: java.lang.Throwable -> L32
            goto L3c
        L32:
            r2 = move-exception
            goto L39
        L34:
            android.net.Uri r1 = android.net.Uri.fromFile(r5)     // Catch: java.lang.Throwable -> L32
            goto L3c
        L39:
            com.bytedance.sdk.component.utils.vl.j(r2)
        L3c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.b.n(int, com.ss.android.socialbase.downloader.r.tj, android.content.Context, java.lang.String, java.io.File):android.net.Uri");
    }

    private static String p(long j6, long j7, String str) {
        double d6 = j6;
        if (j7 > 1) {
            d6 /= j7;
        }
        if ("MB".equals(str)) {
            return new DecimalFormat("#").format(d6) + str;
        }
        return new DecimalFormat("#.##").format(d6) + str;
    }

    private static String q(long j6, long j7, String str, boolean z5) {
        double d6 = j6;
        if (j7 > 1) {
            d6 /= j7;
        }
        if (z5 || "GB".equals(str) || "TB".equals(str)) {
            return new DecimalFormat("#.##").format(d6) + " " + str;
        }
        return new DecimalFormat("#").format(d6) + " " + str;
    }

    public static String s(String str, com.ss.android.socialbase.downloader.jy.j jVar) {
        JSONObject r5;
        if (jVar == null || (r5 = jVar.r("download_dir")) == null) {
            return "";
        }
        String optString = r5.optString("dir_name");
        if (!TextUtils.isEmpty(optString) && optString.startsWith("/")) {
            optString = optString.substring(1);
        }
        if (TextUtils.isEmpty(optString)) {
            return optString;
        }
        if (optString.contains("%s")) {
            try {
                optString = String.format(optString, str);
            } catch (Throwable unused) {
            }
        } else {
            optString = optString + str;
        }
        return optString.length() > 255 ? optString.substring(optString.length() - 255) : optString;
    }

    public static void u(Activity activity) {
        if (activity != null) {
            try {
                if (activity.isFinishing()) {
                    return;
                }
                activity.finish();
            } catch (Exception e6) {
                vl.j(e6);
            }
        }
    }

    public static void w(cw cwVar, boolean z5, boolean z6) {
        f.L().h(new e(com.ss.android.socialbase.downloader.downloader.cw.nd(), cwVar.oq()).I(cwVar.g()).O0(cwVar.tl()).m(cwVar.qv()).L(cwVar.yl()).Q0(cwVar.qe()).n(cwVar.x() || z6).B0(cwVar.h()).W(cwVar.xw()).J(cwVar.uf()).C0(true).N0(cwVar.c()).l(cwVar.gx()).P0(cwVar.ja()).m0(cwVar.by()).A0(cwVar.fs()).X(z5).o0(cwVar.d()).b(cwVar.la()).w0(cwVar.rn()).C(cwVar.wq()).u(cwVar.az()).e0(cwVar.ln()).F0(cwVar.xp()).H(cwVar.w()).J0(cwVar.ri()).O(cwVar.y()).c(cwVar.wi()).t(cwVar.tk()).K(H(cwVar.hl())).j0(cwVar.et()).V(cwVar.mp()).e(cwVar.px()));
    }

    public static boolean E(cw cwVar, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (!TextUtils.isEmpty(cwVar.la()) && str.equals(cwVar.la())) {
            return true;
        }
        if (TextUtils.isEmpty(cwVar.tl()) || !C(com.ss.android.socialbase.downloader.downloader.cw.nd(), cwVar, str)) {
            return false;
        }
        return true;
    }

    public static boolean F(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
        } catch (JSONException e6) {
            vl.j(e6);
        }
        if (!new JSONObject(str).optBoolean("bind_app", false)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int G(Context context, int i6, boolean z5) {
        if (com.ss.android.socialbase.downloader.jy.j.j(i6).xt("notification_opt_2") == 1) {
            xt.j().m(i6);
        }
        u(g.f().n());
        if (com.ss.android.socialbase.downloader.jy.j.j(i6).j("install_queue_enable", 0) == 1) {
            return g.f().c(context, i6, z5);
        }
        return J(context, i6, z5);
    }

    private static JSONObject H(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return new JSONObject(str);
            } catch (Throwable unused) {
                return null;
            }
        }
        return null;
    }

    public static int J(Context context, int i6, boolean z5) {
        cw tl = ae.xt(context).tl(i6);
        if (tl != null && "application/vnd.android.package-archive".equals(tl.xw()) && !TextUtils.isEmpty(tl.qv()) && !TextUtils.isEmpty(tl.tl())) {
            File file = new File(tl.qv(), tl.tl());
            if (file.exists()) {
                com.ss.android.socialbase.downloader.downloader.cw.xt(new RunnableC0771b(context, i6, z5, tl, file));
                return 1;
            }
        }
        O(tl, z5, 2);
        return 2;
    }

    public static String L() {
        return m.up();
    }

    public static boolean Q(String str) {
        JSONObject jSONObject;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e6) {
            vl.j(e6);
        }
        if (!jSONObject.optBoolean("bind_app", false)) {
            if (jSONObject.optBoolean("auto_install_with_notification", true)) {
                return false;
            }
        }
        return true;
    }

    public static boolean d(String str) {
        if (!TextUtils.isEmpty(str) && str.equals("application/vnd.android.package-archive")) {
            return true;
        }
        return false;
    }

    public static int e() {
        if (f.L().a()) {
            return 16384;
        }
        return 0;
    }

    public static int g(Context context, float f6) {
        return (int) ((f6 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int h(Context context, int i6, boolean z5) {
        x2.j O = f.L().O();
        if (O == null) {
            return G(context, i6, z5);
        }
        cw tl = ae.xt(context).tl(i6);
        f38349a = 1;
        O.a(tl, new a(context, i6, z5));
        return f38349a;
    }

    public static int i(Context context, int i6, boolean z5, cw cwVar, File file) {
        Process process;
        PackageInfo packageInfo;
        Intent k6;
        if (file.getPath().startsWith(Environment.getDataDirectory().getAbsolutePath())) {
            try {
                process = Runtime.getRuntime().exec("chmod 555 " + file.getAbsolutePath());
            } catch (Throwable th) {
                th = th;
                process = null;
            }
            try {
                process.waitFor();
            } catch (Throwable th2) {
                th = th2;
                try {
                    vl.j(th);
                } finally {
                    if (process != null) {
                        process.destroy();
                    }
                }
            }
        }
        try {
            packageInfo = m(cwVar, file);
            if (packageInfo != null) {
                try {
                    cwVar.xt(packageInfo.packageName);
                } catch (Throwable th3) {
                    th = th3;
                }
            }
            th = null;
        } catch (Throwable th4) {
            th = th4;
            packageInfo = null;
        }
        if (f.L().M() != null) {
            if (packageInfo == null) {
                com.ss.android.socialbase.downloader.up.j jVar = new com.ss.android.socialbase.downloader.up.j(2001, th);
                f.L().M().j(cwVar, jVar, jVar.j());
            } else {
                f.L().M().j(cwVar, null, 11);
            }
        }
        if (A(context, cwVar, packageInfo)) {
            return 2;
        }
        if (packageInfo != null && com.ss.android.socialbase.downloader.jy.j.j(cwVar.ae()).j("install_callback_error")) {
            cwVar.vm().put("extra_apk_package_name", packageInfo.packageName);
            cwVar.vm().put("extra_apk_version_code", Integer.valueOf(packageInfo.versionCode));
        }
        int[] iArr = new int[1];
        if (P(context, cwVar, packageInfo)) {
            k6 = context.getPackageManager().getLaunchIntentForPackage(packageInfo.packageName);
        } else {
            if (!z5 && y(context, i6, file)) {
                cwVar.vm().put("extra_silent_install_succeed", Boolean.TRUE);
                return 1;
            }
            k6 = k(context, cwVar, file, z5, iArr);
        }
        if (k6 == null) {
            if (iArr[0] == 1) {
                return 2;
            }
            return 0;
        }
        k6.addFlags(268435456);
        if (cwVar.q() > 0 && com.ss.android.socialbase.downloader.jy.j.j(cwVar.ae()).j("app_install_return_result", 0) == 1) {
            k6.putExtra("android.intent.extra.RETURN_RESULT", true);
        }
        if (iArr[0] == 0 && j.t(context, cwVar, k6, z5)) {
            return 1;
        }
        return j(context, k6);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static Intent k(Context context, cw cwVar, @NonNull File file, boolean z5, int[] iArr) {
        int i6;
        Uri n6 = n(cwVar.ae(), ae.xt(context).vl(cwVar.ae()), context, f.L().P(), file);
        if (n6 == null) {
            return null;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        if (Build.VERSION.SDK_INT >= 24) {
            intent.addFlags(1);
        }
        intent.setDataAndType(n6, "application/vnd.android.package-archive");
        x2.m d6 = f.L().d();
        if (d6 != null) {
            i6 = d6.j(cwVar.ae(), z5);
        } else {
            i6 = 0;
        }
        com.ss.android.socialbase.downloader.r.h g6 = ae.xt(context).g(cwVar.ae());
        int i7 = i6;
        if (g6 != null) {
            i7 = g6.j(z5);
        }
        iArr[0] = i7;
        if (i7 != 0) {
            return null;
        }
        return intent;
    }

    public static PackageInfo l(Context context, cw cwVar, String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        File file = new File(str, str2);
        if (!file.exists()) {
            return null;
        }
        vl.r("AppDownloadUtils", "isApkInstalled apkFileSize：fileName:" + file.getPath() + " apkFileSize" + file.length());
        return m(cwVar, file);
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0056, code lost:
    
        if (android.text.TextUtils.isEmpty(r4) == false) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String t(java.lang.String r3, java.lang.String r4, java.lang.String r5, boolean r6) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r3)
            java.lang.String r1 = ""
            if (r0 == 0) goto L9
            return r1
        L9:
            android.net.Uri r3 = android.net.Uri.parse(r3)
            java.lang.String r0 = "default.apk"
            java.lang.String r2 = ".."
            if (r6 == 0) goto L34
            boolean r6 = android.text.TextUtils.isEmpty(r4)
            if (r6 == 0) goto L5a
            java.lang.String r4 = r3.getLastPathSegment()
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L32
            java.lang.String r4 = r3.getLastPathSegment()
            boolean r4 = r4.contains(r2)
            if (r4 != 0) goto L32
            java.lang.String r4 = r3.getLastPathSegment()
            goto L5a
        L32:
            r4 = r0
            goto L5a
        L34:
            java.lang.String r6 = r3.getLastPathSegment()
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 != 0) goto L4c
            java.lang.String r6 = r3.getLastPathSegment()
            boolean r6 = r6.contains(r2)
            if (r6 != 0) goto L4c
            java.lang.String r1 = r3.getLastPathSegment()
        L4c:
            boolean r3 = android.text.TextUtils.isEmpty(r1)
            if (r3 == 0) goto L59
            boolean r3 = android.text.TextUtils.isEmpty(r4)
            if (r3 != 0) goto L32
            goto L5a
        L59:
            r4 = r1
        L5a:
            boolean r3 = d(r5)
            if (r3 == 0) goto L78
            java.lang.String r3 = ".apk"
            boolean r5 = r4.endsWith(r3)
            if (r5 != 0) goto L78
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r4)
            r5.append(r3)
            java.lang.String r3 = r5.toString()
            return r3
        L78:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.b.t(java.lang.String, java.lang.String, java.lang.String, boolean):java.lang.String");
    }

    public static boolean y(Context context, int i6, File file) {
        if (com.ss.android.socialbase.downloader.jy.j.j(i6).j("back_miui_silent_install", 1) == 1) {
            return false;
        }
        if ((com.ss.android.socialbase.appdownloader.m.e.j() || com.ss.android.socialbase.appdownloader.m.e.u()) && oq.j(context, "com.miui.securitycore", "com.miui.enterprise.service.EntInstallService")) {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.miui.securitycore", "com.miui.enterprise.service.EntInstallService"));
            Bundle bundle = new Bundle();
            bundle.putInt("userId", 0);
            bundle.putInt("flag", 256);
            bundle.putString("apkPath", file.getPath());
            bundle.putString("installerPkg", "com.miui.securitycore");
            intent.putExtras(bundle);
            try {
                context.startService(intent);
                return true;
            } catch (Exception e6) {
                vl.j(e6);
            }
        }
        return false;
    }
}
