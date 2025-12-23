package com.tencent.open.utils;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.os.Build;
import android.os.Environment;
import com.baidu.mobads.sdk.internal.by;
import com.stub.StubApp;
import com.tencent.connect.common.Constants;
import com.tencent.open.log.SLog;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.security.MessageDigest;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    private static ConcurrentHashMap<String, com.tencent.a.a.a> f40668a = new ConcurrentHashMap<>();

    public static void a() {
        f40668a.clear();
    }

    public static String b(Context context, String str) {
        SLog.v("openSDK_LOG.SystemUtils", "OpenUi, getSignValidString");
        String str2 = "";
        try {
            String packageName = context.getPackageName();
            Signature[] signatureArr = context.getPackageManager().getPackageInfo(packageName, 64).signatures;
            MessageDigest messageDigest = MessageDigest.getInstance(by.f10823a);
            messageDigest.update(signatureArr[0].toByteArray());
            String a6 = m.a(messageDigest.digest());
            messageDigest.reset();
            SLog.v("openSDK_LOG.SystemUtils", "-->sign: " + a6);
            messageDigest.update(m.j(packageName + "_" + a6 + "_" + str + ""));
            str2 = m.a(messageDigest.digest());
            messageDigest.reset();
            StringBuilder sb = new StringBuilder();
            sb.append("-->signEncryped: ");
            sb.append(str2);
            SLog.v("openSDK_LOG.SystemUtils", sb.toString());
            return str2;
        } catch (Exception e6) {
            SLog.e("openSDK_LOG.SystemUtils", "OpenUi, getSignValidString error", e6);
            return str2;
        }
    }

    public static int c(Context context, String str) {
        return a(a(context, "com.tencent.mobileqq"), str);
    }

    public static int d(Context context, String str) {
        return a(a(context, Constants.PACKAGE_TIM), str);
    }

    private static PackageInfo e(Context context, String str) {
        if (context == null || str == null) {
            return null;
        }
        synchronized (k.class) {
            try {
                if (!f40668a.containsKey(str)) {
                    PackageInfo f6 = f(context, str);
                    f40668a.put(str, new com.tencent.a.a.a(str, f6));
                    return f6;
                }
                com.tencent.a.a.a aVar = f40668a.get(str);
                if (aVar == null) {
                    SLog.e("openSDK_LOG.SystemUtils", "getTargetPackageInfo wrapper is null");
                    return null;
                }
                PackageInfo packageInfo = aVar.f39554b;
                if (packageInfo == null) {
                    SLog.e("openSDK_LOG.SystemUtils", "getTargetPackageInfo wrapper packageInfo is null");
                }
                return packageInfo;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void a(String str) {
        if (str == null) {
            return;
        }
        f40668a.remove(str);
    }

    private static PackageInfo f(Context context, String str) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            if (packageInfo != null) {
                return packageInfo;
            }
            SLog.e("openSDK_LOG.SystemUtils", "realGetPackageInfo null. packageName= " + str);
            return packageInfo;
        } catch (Exception e6) {
            SLog.e("openSDK_LOG.SystemUtils", "realGetPackageInfo exception", e6);
            return null;
        }
    }

    public static String a(Context context, String str) {
        String a6 = h.a(context, c(), str);
        if (a6 != null && !"UNKNOWN".equals(a6)) {
            return a6;
        }
        PackageInfo e6 = e(context, str);
        if (e6 == null) {
            SLog.e("openSDK_LOG.SystemUtils", "getAppVersionName return null. package= " + str);
            return null;
        }
        return e6.versionName;
    }

    public static boolean c(Context context) {
        if (g(context, "com.tencent.mobileqq")) {
            SLog.i("openSDK_LOG.SystemUtils", "isQQBranchInstalled: qq");
            return true;
        }
        if (g(context, Constants.PACKAGE_TIM)) {
            SLog.i("openSDK_LOG.SystemUtils", "isQQBranchInstalled: tim");
            return true;
        }
        if (g(context, Constants.PACKAGE_QQ_PAD)) {
            SLog.i("openSDK_LOG.SystemUtils", "isQQBranchInstalled: pad");
            return true;
        }
        SLog.i("openSDK_LOG.SystemUtils", "isQQBranchInstalled: disable speed");
        return false;
    }

    public static boolean d(Context context) {
        return context != null && context.getApplicationInfo().targetSdkVersion >= 29 && Build.VERSION.SDK_INT >= 29 && !b();
    }

    private static boolean g(Context context, String str) {
        if (h.a(context, c(), str) != null || e(context, str) != null) {
            return true;
        }
        return false;
    }

    public static int a(String str, String str2) {
        if (str == null && str2 == null) {
            return 0;
        }
        if (str != null && str2 == null) {
            return 1;
        }
        if (str == null && str2 != null) {
            return -1;
        }
        String[] split = str.split("\\.");
        String[] split2 = str2.split("\\.");
        int i6 = 0;
        while (i6 < split.length && i6 < split2.length) {
            try {
                int parseInt = Integer.parseInt(split[i6]);
                int parseInt2 = Integer.parseInt(split2[i6]);
                if (parseInt < parseInt2) {
                    return -1;
                }
                if (parseInt > parseInt2) {
                    return 1;
                }
                i6++;
            } catch (NumberFormatException unused) {
                return str.compareTo(str2);
            }
        }
        if (split.length > i6) {
            return 1;
        }
        return split2.length > i6 ? -1 : 0;
    }

    private static String c() {
        String b6 = com.tencent.open.b.b.b();
        if (b6 != null && !b6.isEmpty()) {
            return b6;
        }
        SLog.e("openSDK_LOG.SystemUtils", "getAppId error: " + b6);
        return b6;
    }

    public static boolean a(Context context, String str, String str2) {
        SLog.v("openSDK_LOG.SystemUtils", "OpenUi, validateAppSignatureForPackage");
        try {
            for (Signature signature : context.getPackageManager().getPackageInfo(str, 64).signatures) {
                if (m.g(signature.toCharsString()).equals(str2)) {
                    return true;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }

    public static boolean b(Context context, Intent intent) {
        boolean z5 = false;
        if (context != null && intent != null) {
            ComponentName component = intent.getComponent();
            if (component == null) {
                SLog.i("openSDK_LOG.SystemUtils", "isAgentActivityExist? component null");
                return false;
            }
            String packageName = component.getPackageName();
            String a6 = a(context, packageName);
            if (a6 != null && !a6.isEmpty()) {
                z5 = true;
            }
            SLog.i("openSDK_LOG.SystemUtils", "isAgentActivityExist? packageName = " + packageName + ", appVersionName= " + a6);
        }
        return z5;
    }

    public static String a(Activity activity, String str) {
        if (activity == null) {
            SLog.e("openSDK_LOG.SystemUtils", "getEncryptPkgName activity==null !!!!!!");
            return "";
        }
        try {
            byte[] a6 = e.a(str);
            if (a6 == null) {
                SLog.e("openSDK_LOG.SystemUtils", "getEncryptPkgName shaBytes==null !!!!!!");
                return "";
            }
            byte[] bArr = new byte[8];
            System.arraycopy(a6, 5, bArr, 0, 8);
            byte[] bArr2 = new byte[16];
            System.arraycopy(a6, 8, bArr2, 0, 16);
            return e.a(activity.getPackageName(), e.a(bArr2), bArr);
        } catch (Exception e6) {
            SLog.e("openSDK_LOG.SystemUtils", "getEncryptPkgName", e6);
            return "";
        }
    }

    public static int b(String str) {
        if ("shareToQQ".equals(str)) {
            return 10103;
        }
        if ("shareToQzone".equals(str)) {
            return 10104;
        }
        if ("addToQQFavorites".equals(str)) {
            return Constants.REQUEST_QQ_FAVORITES;
        }
        if ("sendToMyComputer".equals(str)) {
            return Constants.REQUEST_SEND_TO_MY_COMPUTER;
        }
        if ("shareToTroopBar".equals(str)) {
            return Constants.REQUEST_SHARE_TO_TROOP_BAR;
        }
        if ("action_login".equals(str)) {
            return 11101;
        }
        return "action_request".equals(str) ? 10100 : -1;
    }

    public static boolean a(Context context, Intent intent) {
        if (context != null && intent != null) {
            List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
            boolean z5 = queryIntentActivities != null && queryIntentActivities.size() > 0;
            if (!z5) {
                StringBuilder sb = new StringBuilder();
                sb.append("isActivityExist false. result=");
                sb.append(queryIntentActivities == null ? "null" : Integer.valueOf(queryIntentActivities.size()));
                sb.append(" Intent= ");
                sb.append(intent);
                SLog.e("openSDK_LOG.SystemUtils", sb.toString());
            }
            return z5;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("isActivityExist params error! [");
        sb2.append(context == null);
        sb2.append(",");
        sb2.append(intent == null);
        sb2.append("]");
        SLog.e("openSDK_LOG.SystemUtils", sb2.toString());
        return false;
    }

    public static boolean b(Context context) {
        boolean g6 = g(context, "com.tencent.mobileqq");
        SLog.i("openSDK_LOG.SystemUtils", "isQQInstalled " + g6);
        return g6;
    }

    private static boolean b() {
        try {
            return ((Boolean) Environment.class.getMethod("isExternalStorageLegacy", null).invoke(Environment.class, null)).booleanValue();
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return false;
        }
    }

    public static String a(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        try {
            return applicationInfo.loadLabel(context.getPackageManager()).toString();
        } catch (Throwable th) {
            SLog.e("openSDK_LOG.SystemUtils", "getAppName exception", th);
            try {
                int i6 = applicationInfo.labelRes;
                return i6 <= 0 ? applicationInfo.nonLocalizedLabel.toString() : context.getString(i6);
            } catch (Throwable th2) {
                SLog.e("openSDK_LOG.SystemUtils", "getAppName getLabel exception", th2);
                return "";
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x00c5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00be A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @android.annotation.SuppressLint({"SdCardPath"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(java.lang.String r10, java.lang.String r11, int r12) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "-->extractSecureLib, libName: "
            r0.append(r1)
            r0.append(r10)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "openSDK_LOG.SystemUtils"
            com.tencent.open.log.SLog.i(r1, r0)
            android.content.Context r0 = com.tencent.open.utils.g.a()
            r2 = 0
            if (r0 != 0) goto L23
            java.lang.String r10 = "-->extractSecureLib, global context is null. "
            com.tencent.open.log.SLog.i(r1, r10)
            return r2
        L23:
            java.lang.String r3 = "secure_lib"
            android.content.SharedPreferences r3 = r0.getSharedPreferences(r3, r2)
            java.io.File r4 = new java.io.File
            java.io.File r5 = r0.getFilesDir()
            r4.<init>(r5, r11)
            boolean r5 = r4.exists()
            r6 = 1
            java.lang.String r7 = "version"
            if (r5 != 0) goto L50
            java.io.File r5 = r4.getParentFile()
            if (r5 == 0) goto L73
            boolean r5 = r5.mkdirs()
            if (r5 == 0) goto L73
            r4.createNewFile()     // Catch: java.io.IOException -> L4b
            goto L73
        L4b:
            r4 = move-exception
            r4.printStackTrace()
            goto L73
        L50:
            int r4 = r3.getInt(r7, r2)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r8 = "-->extractSecureLib, libVersion: "
            r5.append(r8)
            r5.append(r12)
            java.lang.String r8 = " | oldVersion: "
            r5.append(r8)
            r5.append(r4)
            java.lang.String r5 = r5.toString()
            com.tencent.open.log.SLog.i(r1, r5)
            if (r12 != r4) goto L73
            return r6
        L73:
            r4 = 0
            android.content.res.AssetManager r5 = r0.getAssets()     // Catch: java.lang.Throwable -> La4 java.lang.Exception -> La7
            java.io.InputStream r10 = r5.open(r10)     // Catch: java.lang.Throwable -> La4 java.lang.Exception -> La7
            java.io.FileOutputStream r4 = r0.openFileOutput(r11, r2)     // Catch: java.lang.Throwable -> L9a java.lang.Exception -> L9f
            a(r10, r4)     // Catch: java.lang.Throwable -> L9a java.lang.Exception -> L9f
            android.content.SharedPreferences$Editor r11 = r3.edit()     // Catch: java.lang.Throwable -> L9a java.lang.Exception -> L9f
            r11.putInt(r7, r12)     // Catch: java.lang.Throwable -> L9a java.lang.Exception -> L9f
            r11.commit()     // Catch: java.lang.Throwable -> L9a java.lang.Exception -> L9f
            if (r10 == 0) goto L94
            r10.close()     // Catch: java.io.IOException -> L93
            goto L94
        L93:
        L94:
            if (r4 == 0) goto L99
            r4.close()     // Catch: java.io.IOException -> L99
        L99:
            return r6
        L9a:
            r11 = move-exception
            r9 = r4
            r4 = r10
            r10 = r9
            goto Lbc
        L9f:
            r11 = move-exception
            r9 = r4
            r4 = r10
            r10 = r9
            goto La9
        La4:
            r11 = move-exception
            r10 = r4
            goto Lbc
        La7:
            r11 = move-exception
            r10 = r4
        La9:
            java.lang.String r12 = "-->extractSecureLib, when copy lib execption."
            com.tencent.open.log.SLog.e(r1, r12, r11)     // Catch: java.lang.Throwable -> Lbb
            if (r4 == 0) goto Lb5
            r4.close()     // Catch: java.io.IOException -> Lb4
            goto Lb5
        Lb4:
        Lb5:
            if (r10 == 0) goto Lba
            r10.close()     // Catch: java.io.IOException -> Lba
        Lba:
            return r2
        Lbb:
            r11 = move-exception
        Lbc:
            if (r4 == 0) goto Lc3
            r4.close()     // Catch: java.io.IOException -> Lc2
            goto Lc3
        Lc2:
        Lc3:
            if (r10 == 0) goto Lc8
            r10.close()     // Catch: java.io.IOException -> Lc8
        Lc8:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.utils.k.a(java.lang.String, java.lang.String, int):boolean");
    }

    private static long a(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[8192];
        long j6 = 0;
        while (true) {
            int read = inputStream.read(bArr, 0, 8192);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
                j6 += read;
            } else {
                SLog.i("openSDK_LOG.SystemUtils", "-->copy, copyed size is: " + j6);
                return j6;
            }
        }
    }

    public static String a(int i6) {
        if (i6 == 10103) {
            return "shareToQQ";
        }
        if (i6 == 10104) {
            return "shareToQzone";
        }
        if (i6 == 10105) {
            return "addToQQFavorites";
        }
        if (i6 == 10106) {
            return "sendToMyComputer";
        }
        if (i6 == 10107) {
            return "shareToTroopBar";
        }
        if (i6 == 11101) {
            return "action_login";
        }
        if (i6 == 10100) {
            return "action_request";
        }
        if (i6 != 10114) {
            return null;
        }
        return "action_common_channel";
    }

    public static String a(Activity activity) {
        try {
            ApplicationInfo applicationInfo = activity.getPackageManager().getApplicationInfo(StubApp.getOrigApplicationContext(activity.getApplicationContext()).getPackageName(), 128);
            SLog.i("openSDK_LOG.SystemUtils", "apkPath=" + applicationInfo.sourceDir);
            return applicationInfo.sourceDir;
        } catch (PackageManager.NameNotFoundException e6) {
            SLog.e("openSDK_LOG.SystemUtils", "NameNotFoundException", e6);
            return null;
        } catch (Exception e7) {
            SLog.e("openSDK_LOG.SystemUtils", "Exception", e7);
            return null;
        }
    }
}
