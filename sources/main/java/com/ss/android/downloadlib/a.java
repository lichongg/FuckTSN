package com.ss.android.downloadlib;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.StatFs;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.work.PeriodicWorkRequest;
import cn.jpush.android.api.JThirdPlatFormInterface;
import cn.jpush.android.local.JPushConstants;
import com.baidu.idl.face.platform.common.ConstantHelper;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.huawei.hms.framework.common.ContainerUtils;
import com.ss.android.downloadlib.activity.JumpKllkActivity;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.downloadlib.addownload.o;
import com.ss.android.downloadlib.b;
import com.ss.android.downloadlib.j;
import com.ss.android.socialbase.appdownloader.DownloadHandlerService;
import com.ss.android.socialbase.appdownloader.a;
import com.ss.android.socialbase.downloader.ae.cw;
import com.ss.android.socialbase.downloader.downloader.ae;
import com.ss.android.socialbase.downloader.downloader.tl;
import com.ss.android.socialbase.downloader.j.j;
import com.ss.android.socialbase.downloader.notification.xt;
import com.ss.android.socialbase.downloader.r.wq;
import com.ss.android.socialbase.downloader.xt.up;
import com.umeng.analytics.pro.bi;
import java.io.File;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import w2.u;
import w2.v;
import w2.w;
import w2.x;
import w2.y;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: D:\Downloads\app\classes6.dex */
public class a implements s2.a {

    /* renamed from: com.ss.android.downloadlib.a$a, reason: collision with other inner class name */
    class C0731a implements j.cw {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ y f37556a;

        C0731a(y yVar) {
            this.f37556a = yVar;
        }
    }

    class b implements wq {
        @Override // com.ss.android.socialbase.downloader.r.wq
        public boolean xt(cw cwVar) {
            return false;
        }

        b() {
        }

        @Override // com.ss.android.socialbase.downloader.r.wq
        public boolean cw(cw cwVar) {
            if (cwVar == null) {
                return false;
            }
            com.ss.android.xt.j.xt.b f6 = o.f.c().f(cwVar);
            if (f6 != null) {
                j.g.b(f6);
            } else {
                f.i(com.ss.android.downloadlib.addownload.m.getContext(), cwVar.la());
            }
            xt.j().m(cwVar.ae());
            return true;
        }

        private boolean a(cw cwVar) {
            String e6;
            x y5 = com.ss.android.downloadlib.addownload.m.y();
            if (y5 != null) {
                com.ss.android.xt.j.xt.b f6 = o.f.c().f(cwVar);
                if (f6 != null && f6.cw()) {
                    e6 = com.ss.android.socialbase.downloader.jy.j.j(cwVar.ae()).j("ad_notification_jump_url", (String) null);
                } else {
                    e6 = com.ss.android.downloadlib.addownload.d.e(cwVar);
                }
                if (!TextUtils.isEmpty(e6)) {
                    return y5.j(com.ss.android.downloadlib.addownload.m.getContext(), e6);
                }
                return false;
            }
            return false;
        }

        @Override // com.ss.android.socialbase.downloader.r.wq
        public boolean j(cw cwVar) {
            com.ss.android.socialbase.downloader.jy.j j6 = com.ss.android.socialbase.downloader.jy.j.j(cwVar.ae());
            if (j6.xt("notification_opt_2") == 1) {
                if (cwVar.i() == -2) {
                    DownloadHandlerService.d(com.ss.android.downloadlib.addownload.m.getContext(), cwVar, com.ss.android.socialbase.appdownloader.f.L().d(), ae.xt(com.ss.android.downloadlib.addownload.m.getContext()).g(cwVar.ae()));
                }
                return true;
            }
            boolean a6 = a(cwVar);
            if (j6.j("disable_delete_dialog", 0) == 1) {
                return true;
            }
            return a6;
        }
    }

    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.ss.android.socialbase.appdownloader.m.e.i("");
            if (com.ss.android.socialbase.appdownloader.m.e.c()) {
                com.ss.android.socialbase.downloader.downloader.cw.j(true);
            }
            if (com.ss.android.socialbase.downloader.jy.j.cw().j("disable_security_init", 1) == 1) {
                com.ss.android.socialbase.appdownloader.m.c.d(com.ss.android.downloadlib.addownload.m.getContext());
            }
        }
    }

    public class d {
        public static long a(File file) {
            if (file == null || !file.exists()) {
                return 0L;
            }
            return b(file, file.lastModified(), 0);
        }

        private static long b(File file, long j6, int i6) {
            File[] listFiles;
            if (file != null && file.exists()) {
                j6 = Math.max(j6, file.lastModified());
                int i7 = i6 + 1;
                if (i7 < 50 && file.isDirectory() && (listFiles = file.listFiles()) != null) {
                    for (File file2 : listFiles) {
                        j6 = Math.max(j6, b(file2, j6, i7));
                    }
                }
            }
            return j6;
        }
    }

    public class e<P, R> implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private P f37560a;

        /* renamed from: b, reason: collision with root package name */
        private R f37561b;

        /* renamed from: c, reason: collision with root package name */
        private int f37562c;

        /* renamed from: d, reason: collision with root package name */
        private SoftReference<InterfaceC0732a<P, R>> f37563d;

        /* renamed from: e, reason: collision with root package name */
        private e<?, P> f37564e;

        /* renamed from: f, reason: collision with root package name */
        private e<R, ?> f37565f;

        /* renamed from: com.ss.android.downloadlib.a$e$a, reason: collision with other inner class name */
        public interface InterfaceC0732a<PARAM, RESULT> {
            RESULT j(PARAM param);
        }

        public <NR> e<R, NR> b(InterfaceC0732a<R, NR> interfaceC0732a) {
            return a(0, interfaceC0732a);
        }

        public static <P, R> e<P, R> c(InterfaceC0732a<P, R> interfaceC0732a, P p5) {
            return new e<>(2, interfaceC0732a, p5);
        }

        private R e() {
            return this.f37561b;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public <NR> e<R, NR> a(int i6, InterfaceC0732a<R, NR> interfaceC0732a) {
            e eVar = (e<R, ?>) new e(i6, interfaceC0732a, null);
            this.f37565f = eVar;
            eVar.f37564e = this;
            return eVar;
        }

        public void d() {
            e<?, P> eVar = this.f37564e;
            if (eVar != null) {
                eVar.d();
            } else {
                run();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            e<?, P> eVar;
            if (this.f37562c == 0 && !h.K()) {
                com.ss.android.downloadlib.c.d().s().post(this);
                return;
            }
            if (this.f37562c == 1 && h.K()) {
                com.ss.android.downloadlib.e.c().d(this);
                return;
            }
            if (this.f37562c == 2 && h.K()) {
                com.ss.android.downloadlib.e.c().k(this);
                return;
            }
            if (this.f37560a == null && (eVar = this.f37564e) != null) {
                this.f37560a = eVar.e();
            }
            InterfaceC0732a<P, R> interfaceC0732a = this.f37563d.get();
            if (interfaceC0732a == null) {
                return;
            }
            this.f37561b = interfaceC0732a.j(this.f37560a);
            e<R, ?> eVar2 = this.f37565f;
            if (eVar2 != null) {
                eVar2.run();
            }
        }

        private e(int i6, InterfaceC0732a<P, R> interfaceC0732a, P p5) {
            this.f37562c = i6;
            this.f37563d = new SoftReference<>(interfaceC0732a);
            this.f37560a = p5;
        }
    }

    public class g {

        private static class b implements InvocationHandler {

            /* renamed from: a, reason: collision with root package name */
            private Object f37566a;

            /* synthetic */ b(Object obj, RunnableC0733a runnableC0733a) {
                this(obj);
            }

            private b(Object obj) {
                this.f37566a = obj;
            }

            @Override // java.lang.reflect.InvocationHandler
            public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
                try {
                    if ("startActivity".contains(method.getName())) {
                        g.e(objArr);
                    }
                } catch (Throwable unused) {
                }
                return method.invoke(this.f37566a, objArr);
            }
        }

        /* renamed from: com.ss.android.downloadlib.a$g$a, reason: collision with other inner class name */
        static class RunnableC0733a implements Runnable {
            RunnableC0733a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                com.ss.android.socialbase.appdownloader.m.e.q();
                g.a();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void a() {
            try {
                Field declaredField = Build.VERSION.SDK_INT < 26 ? Class.forName("android.app.ActivityManagerNative").getDeclaredField("gDefault") : Class.forName("android.app.ActivityManager").getDeclaredField("IActivityManagerSingleton");
                declaredField.setAccessible(true);
                RunnableC0733a runnableC0733a = null;
                Object obj = declaredField.get(null);
                Field declaredField2 = Class.forName("android.util.Singleton").getDeclaredField("mInstance");
                declaredField2.setAccessible(true);
                Object obj2 = declaredField2.get(obj);
                if (obj2 == null) {
                    return;
                }
                declaredField2.set(obj, Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{Class.forName("android.app.IActivityManager")}, new b(obj2, runnableC0733a)));
            } catch (Throwable unused) {
            }
        }

        public static int b(String str, String str2) {
            if (TextUtils.isEmpty(str2)) {
                return 5;
            }
            return com.ss.android.cw.a.a(str, new File(str2));
        }

        public static String c(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return com.ss.android.cw.a.g(new File(str));
        }

        public static void d() {
            if (com.ss.android.downloadlib.addownload.m.f().optInt("hook", 0) != 1) {
                return;
            }
            com.ss.android.downloadlib.e.c().e(new RunnableC0733a(), 10000L);
        }

        public static void e(Object[] objArr) {
            if (com.ss.android.downloadlib.addownload.m.f().optInt("hook", 0) == 1 && (objArr[1] instanceof String)) {
                Object obj = objArr[2];
                if (obj instanceof Intent) {
                    Intent intent = (Intent) obj;
                    if ("android.intent.action.VIEW".equals(intent.getAction()) && up.f39040j.equals(intent.getType())) {
                        if (com.ss.android.socialbase.appdownloader.m.e.p()) {
                            String optString = com.ss.android.downloadlib.addownload.m.f().optString("hook_vivo_arg", "com.android.settings");
                            if (!"null".equals(optString)) {
                                objArr[1] = optString;
                                return;
                            }
                            return;
                        }
                        if (com.ss.android.socialbase.appdownloader.m.e.r()) {
                            String optString2 = com.ss.android.downloadlib.addownload.m.f().optString("hook_kllk_arg1", "com." + up.cw + ".market");
                            if (!"null".equals(optString2)) {
                                objArr[1] = optString2;
                            }
                            String optString3 = com.ss.android.downloadlib.addownload.m.f().optString("hook_kllk_arg2", "com.android.browser");
                            String optString4 = com.ss.android.downloadlib.addownload.m.f().optString("hook_kllk_arg3", "m.store." + up.cw + "mobile.com");
                            intent.putExtra(up.cw + "_extra_pkg_name", optString3);
                            intent.putExtra("refererHost", optString4);
                            if (com.ss.android.downloadlib.addownload.m.f().optInt("hook_kllk_arg4", 0) == 1) {
                                Intent intent2 = new Intent();
                                intent2.putExtra(up.cw + "_extra_pkg_name", optString3);
                                intent2.putExtra("refererHost", optString4);
                                intent.putExtra("android.intent.extra.INTENT", intent2);
                                return;
                            }
                            return;
                        }
                        if (com.ss.android.socialbase.appdownloader.m.e.h()) {
                            String optString5 = com.ss.android.downloadlib.addownload.m.f().optString("hook_huawei_arg1", "com.huawei.appmarket");
                            if (!"null".equals(optString5)) {
                                objArr[1] = optString5;
                            }
                            intent.putExtra("caller_package", com.ss.android.downloadlib.addownload.m.f().optString("hook_huawei_arg2", "com.huawei.appmarket"));
                        }
                    }
                }
            }
        }

        public static String f(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                ApplicationInfo applicationInfo = com.ss.android.downloadlib.addownload.m.getContext().getPackageManager().getApplicationInfo(str, 0);
                if (applicationInfo != null) {
                    return applicationInfo.sourceDir;
                }
            } catch (Exception unused) {
            }
            return null;
        }
    }

    public class h {

        /* renamed from: a, reason: collision with root package name */
        private static Object[] f37567a = new Object[0];

        /* renamed from: b, reason: collision with root package name */
        private static Object[] f37568b = new Object[73];

        /* renamed from: c, reason: collision with root package name */
        static final char[] f37569c = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

        /* renamed from: d, reason: collision with root package name */
        private static String f37570d = null;

        public static boolean B(Signature[] signatureArr, Signature[] signatureArr2) {
            if (signatureArr == signatureArr2) {
                return true;
            }
            if (signatureArr == null || signatureArr2 == null || signatureArr.length != signatureArr2.length) {
                return false;
            }
            for (int i6 = 0; i6 < signatureArr.length; i6++) {
                Signature signature = signatureArr[i6];
                if ((signature == null && signatureArr2[i6] != null) || (signature != null && !signature.equals(signatureArr2[i6]))) {
                    return false;
                }
            }
            return true;
        }

        public static boolean C(Context context, String str) {
            PackageInfo packageArchiveInfo;
            PackageInfo packageInfo;
            if (context == null || str == null || TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                File file = new File(str);
                if (!file.exists() || (packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), 0)) == null) {
                    return false;
                }
                String str2 = packageArchiveInfo.packageName;
                int i6 = packageArchiveInfo.versionCode;
                try {
                    packageInfo = context.getPackageManager().getPackageInfo(str2, 0);
                } catch (PackageManager.NameNotFoundException unused) {
                    packageInfo = null;
                }
                if (packageInfo == null) {
                    return false;
                }
                return i6 <= packageInfo.versionCode;
            } catch (Exception e6) {
                vl.j(e6);
                return false;
            }
        }

        public static File D(Context context, String str) {
            File parentFile = context.getExternalFilesDir(null).getParentFile();
            File file = new File((parentFile != null ? parentFile.getParent() : null) + File.separator + str);
            StringBuilder sb = new StringBuilder("getExtDir: file.toString()-->");
            sb.append(file.toString());
            com.ss.android.socialbase.downloader.m.j.xt("ToolUtils", sb.toString());
            return file;
        }

        public static boolean L(Context context, Intent intent) {
            if (intent == null) {
                return false;
            }
            if (context == null) {
                context = com.ss.android.downloadlib.addownload.m.getContext();
            }
            List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 65536);
            return queryIntentActivities != null && queryIntentActivities.size() > 0;
        }

        public static PackageInfo k(com.ss.android.xt.j.xt.b bVar) {
            cw tl;
            if (bVar == null || (tl = ae.xt(com.ss.android.downloadlib.addownload.m.getContext()).tl(bVar.mi())) == null) {
                return null;
            }
            try {
                return com.ss.android.socialbase.appdownloader.b.l(com.ss.android.downloadlib.addownload.m.getContext(), tl, tl.qv(), tl.tl());
            } catch (Throwable unused) {
                return null;
            }
        }

        public static Drawable l(Context context, String str) {
            PackageManager packageManager;
            PackageInfo packageArchiveInfo;
            if (context != null && !TextUtils.isEmpty(str) && (packageArchiveInfo = (packageManager = context.getPackageManager()).getPackageArchiveInfo(str, 0)) != null) {
                ApplicationInfo applicationInfo = packageArchiveInfo.applicationInfo;
                applicationInfo.sourceDir = str;
                applicationInfo.publicSourceDir = str;
                try {
                    return applicationInfo.loadIcon(packageManager);
                } catch (Exception e6) {
                    vl.j(e6);
                }
            }
            return null;
        }

        public static boolean v() {
            try {
                if (com.ss.android.downloadlib.addownload.m.getContext().getPackageManager().getPackageInfo(com.ss.android.downloadlib.addownload.m.getContext().getPackageName(), 0).applicationInfo.targetSdkVersion >= 33) {
                    if (Build.VERSION.SDK_INT >= 33) {
                        return true;
                    }
                }
                return false;
            } catch (PackageManager.NameNotFoundException e6) {
                vl.j(e6);
                return false;
            }
        }

        private static boolean w(int i6, int i7, String str, String str2) {
            if (i7 == 0 && TextUtils.isEmpty(str2)) {
                return true;
            }
            return (i7 > 0 && i6 >= i7) || g(str, str2) >= 0;
        }

        public static boolean x(Context context, Intent intent) {
            try {
                List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 65536);
                if (queryIntentActivities != null) {
                    if (!queryIntentActivities.isEmpty()) {
                        return true;
                    }
                }
            } catch (Exception unused) {
            }
            return false;
        }

        public static boolean y(Context context, String str, String str2) {
            PackageInfo packageArchiveInfo;
            PackageInfo packageInfo;
            if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return false;
            }
            try {
                File file = new File(str);
                if (!file.exists() || (packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), 0)) == null || !packageArchiveInfo.packageName.equals(str2)) {
                    return false;
                }
                int i6 = packageArchiveInfo.versionCode;
                try {
                    packageInfo = context.getPackageManager().getPackageInfo(str2, 0);
                } catch (PackageManager.NameNotFoundException unused) {
                    packageInfo = null;
                }
                if (packageInfo == null) {
                    return false;
                }
                return i6 == packageInfo.versionCode;
            } catch (Exception e6) {
                vl.j(e6);
                return false;
            }
        }

        public static Drawable E(Context context, String str) {
            if (context == null || TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                PackageManager packageManager = context.getPackageManager();
                return packageManager.getApplicationInfo(str, 0).loadIcon(packageManager);
            } catch (PackageManager.NameNotFoundException unused) {
                return null;
            }
        }

        public static boolean G(Context context, String str) {
            if (context == null) {
                context = com.ss.android.downloadlib.addownload.m.getContext();
            }
            if (context != null && !TextUtils.isEmpty(str)) {
                try {
                    if (context.getPackageManager().getPackageInfo(str, 0) != null) {
                        return true;
                    }
                } catch (Exception unused) {
                }
            }
            return false;
        }

        public static int H(Context context, String str) {
            if (context == null || TextUtils.isEmpty(str)) {
                return -1;
            }
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
                if (packageInfo != null) {
                    return packageInfo.versionCode;
                }
                return -1;
            } catch (PackageManager.NameNotFoundException unused) {
                return -1;
            }
        }

        @NonNull
        public static HashMap<String, String> J(JSONObject jSONObject) {
            HashMap<String, String> hashMap = new HashMap<>();
            if (jSONObject != null) {
                try {
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        hashMap.put(next, jSONObject.optString(next));
                    }
                } catch (Exception e6) {
                    vl.j(e6);
                }
            }
            return hashMap;
        }

        public static boolean M(com.ss.android.xt.j.xt.b bVar) {
            if (bVar == null) {
                return false;
            }
            return m(bVar.up(), bVar.F0(), bVar.t()).b();
        }

        public static String b(Context context, String str) {
            if (context == null || TextUtils.isEmpty(str)) {
                return "";
            }
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
                return packageInfo != null ? packageInfo.versionName : "";
            } catch (PackageManager.NameNotFoundException unused) {
                return "";
            }
        }

        public static int g(String str, String str2) {
            try {
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    if (str.equals(str2)) {
                        return 0;
                    }
                    String[] split = str.split("\\.");
                    String[] split2 = str2.split("\\.");
                    int min = Math.min(split.length, split2.length);
                    int i6 = 0;
                    int i7 = 0;
                    while (i6 < min) {
                        i7 = Integer.parseInt(split[i6]) - Integer.parseInt(split2[i6]);
                        if (i7 != 0) {
                            break;
                        }
                        i6++;
                    }
                    if (i7 != 0) {
                        return i7 > 0 ? 1 : -1;
                    }
                    for (int i8 = i6; i8 < split.length; i8++) {
                        if (Integer.parseInt(split[i8]) > 0) {
                            return 1;
                        }
                    }
                    while (i6 < split2.length) {
                        if (Integer.parseInt(split2[i6]) > 0) {
                            return -1;
                        }
                        i6++;
                    }
                    return 0;
                }
            } catch (Exception unused) {
            }
            return -2;
        }

        public static long h(File file) {
            if (file == null) {
                return -1L;
            }
            try {
                return new StatFs(file.getAbsolutePath()).getTotalBytes();
            } catch (Throwable th) {
                vl.j(th);
                return -1L;
            }
        }

        public static long i(File file, long j6) {
            if (file == null) {
                return j6;
            }
            try {
                return com.ss.android.socialbase.downloader.az.m.r(file.getAbsolutePath());
            } catch (Exception e6) {
                vl.j(e6);
                return j6;
            }
        }

        public static o.c m(String str, int i6, String str2) {
            o.c cVar = new o.c();
            if (!TextUtils.isEmpty(str)) {
                try {
                    PackageInfo packageInfo = com.ss.android.downloadlib.addownload.m.getContext().getPackageManager().getPackageInfo(str, 0);
                    if (packageInfo != null) {
                        cVar.d(packageInfo.versionCode);
                        cVar.a(o.c.f37922h);
                        v a6 = com.ss.android.downloadlib.addownload.m.a();
                        if (a6 != null && a6.j() && !w(packageInfo.versionCode, i6, packageInfo.versionName, str2)) {
                            cVar.a(o.c.f37923i);
                            return cVar;
                        }
                    }
                } catch (Exception e6) {
                    com.ss.android.socialbase.downloader.m.j.up("ToolUtils", "getInstalledAppInfo:" + e6.getMessage());
                    return cVar;
                }
            }
            return cVar;
        }

        @NonNull
        public static <T> T n(T... tArr) {
            if (tArr == null) {
                throw new IllegalArgumentException("args is null");
            }
            for (T t5 : tArr) {
                if (t5 != null) {
                    return t5;
                }
            }
            throw new IllegalArgumentException("args is null");
        }

        public static String o(long j6) {
            DecimalFormat decimalFormat = new DecimalFormat("0.00");
            if (j6 >= IjkMediaMeta.AV_CH_STEREO_RIGHT) {
                return (j6 / IjkMediaMeta.AV_CH_STEREO_RIGHT) + "G";
            }
            if (j6 >= PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) {
                return (j6 / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) + "M";
            }
            return decimalFormat.format(j6 / 1048576.0f) + "M";
        }

        public static String p(String str, int i6) {
            return i6 == 0 ? "" : (TextUtils.isEmpty(str) || str.length() <= i6) ? str : str.substring(0, i6);
        }

        public static void u(JSONObject jSONObject, String str, Object obj) {
            if (jSONObject == null || TextUtils.isEmpty(str)) {
                return;
            }
            try {
                jSONObject.putOpt(str, obj);
            } catch (JSONException e6) {
                vl.j(e6);
            }
        }

        public static boolean z(com.ss.android.j.j.cw.b bVar) {
            if (bVar == null) {
                return false;
            }
            return m(bVar.s(), bVar.f(), bVar.v()).b();
        }

        public static boolean A(String str) {
            if (!TextUtils.isEmpty(str)) {
                return new File(str).exists();
            }
            return false;
        }

        public static Signature[] F(Context context, String str) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
                if (packageInfo != null) {
                    return packageInfo.signatures;
                }
                return null;
            } catch (Throwable th) {
                vl.j(th);
                return null;
            }
        }

        public static long I(long j6) {
            try {
                return i(Environment.getExternalStorageDirectory(), j6);
            } catch (Exception e6) {
                vl.j(e6);
                return j6;
            }
        }

        public static boolean K() {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                return true;
            }
            return false;
        }

        public static boolean N(String str) {
            if (TextUtils.isEmpty(str) || !new File(str).exists()) {
                return false;
            }
            return true;
        }

        public static Intent a(Context context, String str) {
            Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
            if (launchIntentForPackage == null) {
                return null;
            }
            if (!launchIntentForPackage.hasCategory("android.intent.category.LAUNCHER")) {
                launchIntentForPackage.addCategory("android.intent.category.LAUNCHER");
            }
            launchIntentForPackage.setPackage(null);
            launchIntentForPackage.addFlags(2097152);
            launchIntentForPackage.addFlags(268435456);
            return launchIntentForPackage;
        }

        @SuppressLint({"MissingPermission"})
        public static void c() {
            ComponentName componentName;
            try {
                if (com.ss.android.downloadlib.addownload.m.E().j(com.ss.android.downloadlib.addownload.m.getContext(), "android.permission.REORDER_TASKS")) {
                    ActivityManager activityManager = (ActivityManager) com.ss.android.downloadlib.addownload.m.getContext().getSystemService(TTDownloadField.TT_ACTIVITY);
                    for (ActivityManager.RunningTaskInfo runningTaskInfo : activityManager.getRunningTasks(20)) {
                        String packageName = com.ss.android.downloadlib.addownload.m.getContext().getPackageName();
                        componentName = runningTaskInfo.topActivity;
                        if (packageName.equals(componentName.getPackageName())) {
                            activityManager.moveTaskToFront(runningTaskInfo.id, 1);
                            return;
                        }
                    }
                }
            } catch (Exception e6) {
                vl.j(e6);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0032, code lost:
        
            if (r3 != false) goto L15;
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x0036, code lost:
        
            return true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x0034, code lost:
        
            if (r1 > 29) goto L16;
         */
        @androidx.annotation.WorkerThread
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static boolean d(java.lang.String r7) {
            /*
                android.content.Context r0 = com.ss.android.downloadlib.addownload.m.getContext()
                boolean r1 = android.text.TextUtils.isEmpty(r7)
                r2 = 0
                if (r1 == 0) goto Lc
                return r2
            Lc:
                boolean r1 = G(r0, r7)
                if (r1 != 0) goto L13
                return r2
            L13:
                android.content.pm.ApplicationInfo r1 = r0.getApplicationInfo()
                int r1 = r1.targetSdkVersion
                org.json.JSONObject r3 = com.ss.android.downloadlib.addownload.m.f()
                java.lang.String r4 = "get_ext_dir_mode"
                int r3 = r3.optInt(r4)
                r5 = 1
                r6 = 29
                if (r3 != 0) goto L37
                int r3 = android.os.Build.VERSION.SDK_INT
                if (r3 < r6) goto L37
                if (r1 != r6) goto L34
                boolean r3 = com.bumptech.glide.load.model.stream.g.a()
                if (r3 == 0) goto L36
            L34:
                if (r1 <= r6) goto L37
            L36:
                return r5
            L37:
                int r1 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Exception -> L52
                if (r1 < r6) goto L54
                android.content.pm.ApplicationInfo r1 = r0.getApplicationInfo()     // Catch: java.lang.Exception -> L52
                int r1 = r1.targetSdkVersion     // Catch: java.lang.Exception -> L52
                if (r1 < r6) goto L54
                org.json.JSONObject r1 = com.ss.android.downloadlib.addownload.m.f()     // Catch: java.lang.Exception -> L52
                int r1 = r1.optInt(r4)     // Catch: java.lang.Exception -> L52
                if (r1 != r5) goto L54
                java.io.File r1 = D(r0, r7)     // Catch: java.lang.Exception -> L52
                goto L6b
            L52:
                r7 = move-exception
                goto L88
            L54:
                java.io.File r1 = new java.io.File     // Catch: java.lang.Exception -> L52
                java.io.File r3 = android.os.Environment.getExternalStorageDirectory()     // Catch: java.lang.Exception -> L52
                java.lang.String r3 = r3.getPath()     // Catch: java.lang.Exception -> L52
                java.lang.String r4 = "android/data/"
                java.lang.String r6 = java.lang.String.valueOf(r7)     // Catch: java.lang.Exception -> L52
                java.lang.String r4 = r4.concat(r6)     // Catch: java.lang.Exception -> L52
                r1.<init>(r3, r4)     // Catch: java.lang.Exception -> L52
            L6b:
                boolean r3 = r1.exists()     // Catch: java.lang.Exception -> L52
                if (r3 != 0) goto L72
                return r2
            L72:
                long r3 = com.ss.android.downloadlib.a.d.a(r1)     // Catch: java.lang.Exception -> L52
                android.content.pm.PackageManager r0 = r0.getPackageManager()     // Catch: java.lang.Exception -> L52
                android.content.pm.PackageInfo r7 = r0.getPackageInfo(r7, r2)     // Catch: java.lang.Exception -> L52
                if (r7 == 0) goto L87
                long r0 = r7.lastUpdateTime     // Catch: java.lang.Exception -> L52
                int r7 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
                if (r7 >= 0) goto L87
                return r5
            L87:
                return r2
            L88:
                com.bytedance.sdk.component.utils.vl.j(r7)
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ss.android.downloadlib.a.h.d(java.lang.String):boolean");
        }

        public static Signature[] e(Context context, String str) {
            try {
                PackageInfo packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(str, 64);
                if (packageArchiveInfo != null) {
                    return packageArchiveInfo.signatures;
                }
                return null;
            } catch (Throwable th) {
                vl.j(th);
                return null;
            }
        }

        public static int f(Context context, float f6) {
            return (int) ((f6 * context.getResources().getDisplayMetrics().density) + 0.5f);
        }

        public static long j(JSONObject jSONObject, String str) {
            return u2.b.a(jSONObject, str);
        }

        public static String q(String... strArr) {
            return u2.b.b(strArr);
        }

        @NonNull
        public static JSONObject r(JSONObject jSONObject) {
            return u2.b.c(jSONObject);
        }

        public static JSONObject s(JSONObject jSONObject, JSONObject jSONObject2) {
            return u2.b.d(jSONObject, jSONObject2);
        }

        @NonNull
        public static JSONObject t(JSONObject... jSONObjectArr) {
            return u2.b.e(jSONObjectArr);
        }
    }

    public class i {
        public static void a(cw cwVar, JSONObject jSONObject) {
            if (cwVar != null) {
                try {
                    jSONObject.putOpt("total_bytes", Long.valueOf(cwVar.ka()));
                    jSONObject.putOpt("cur_bytes", Long.valueOf(cwVar.uq()));
                    jSONObject.putOpt("chunk_count", Integer.valueOf(cwVar.kj()));
                    jSONObject.putOpt("app_name", cwVar.g());
                    jSONObject.putOpt("network_quality", cwVar.wo());
                    jSONObject.putOpt("save_path", cwVar.qv());
                    jSONObject.putOpt("file_name", cwVar.tl());
                    jSONObject.putOpt("download_status", Integer.valueOf(cwVar.v()));
                    com.ss.android.xt.j.xt.b e6 = o.f.c().e(cwVar.ae());
                    if (e6 != null) {
                        jSONObject.putOpt("click_download_time", Long.valueOf(e6.k()));
                        jSONObject.putOpt("click_download_size", Long.valueOf(e6.s()));
                    }
                } catch (Exception e7) {
                    vl.j(e7);
                    return;
                }
            }
            jSONObject.putOpt("permission_notification", Integer.valueOf(com.ss.android.socialbase.appdownloader.up.c.e() ? 1 : 2));
            jSONObject.putOpt("network_available", Integer.valueOf(com.ss.android.socialbase.downloader.az.m.cw(com.ss.android.downloadlib.addownload.m.getContext()) ? 1 : 2));
            jSONObject.putOpt("network_is_wifi", Integer.valueOf(com.ss.android.socialbase.downloader.az.m.xt(com.ss.android.downloadlib.addownload.m.getContext()) ? 1 : 2));
        }

        public static void d(com.ss.android.xt.j.xt.b bVar, JSONObject jSONObject) {
            if (jSONObject == null || bVar == null) {
                return;
            }
            try {
                jSONObject.put("is_patch_apply_handled", bVar.a1() ? 1 : 0);
                jSONObject.put("origin_mime_type", bVar.k0());
            } catch (Throwable th) {
                vl.j(th);
            }
        }

        public static void e(@NonNull JSONObject jSONObject) {
            try {
                jSONObject.putOpt("harmony_api_version", com.ss.android.socialbase.appdownloader.m.d.e());
                jSONObject.putOpt("harmony_release_type", com.ss.android.socialbase.appdownloader.m.d.c());
                jSONObject.putOpt("harmony_build_version", com.ss.android.socialbase.appdownloader.m.d.k());
                jSONObject.putOpt("pure_mode", Integer.valueOf(com.ss.android.socialbase.appdownloader.m.d.h(com.ss.android.downloadlib.addownload.m.getContext()) ? 1 : 2));
                jSONObject.putOpt("pure_mode_enable", Integer.valueOf(com.ss.android.socialbase.appdownloader.m.d.l() ? 1 : 2));
                jSONObject.putOpt("harmony_version", com.ss.android.socialbase.appdownloader.m.d.m());
                jSONObject.putOpt("pure_enhanced_mode", Integer.valueOf(com.ss.android.socialbase.appdownloader.m.d.n(com.ss.android.downloadlib.addownload.m.getContext()) ? 1 : 2));
                jSONObject.putOpt("pure_enhanced_mode_enable", Integer.valueOf(com.ss.android.socialbase.appdownloader.m.d.i() ? 1 : 2));
            } catch (Exception e6) {
                vl.j(e6);
            }
        }

        public static void f(JSONObject jSONObject, int i6) {
            if (jSONObject == null) {
                return;
            }
            JSONArray up = com.ss.android.socialbase.downloader.jy.j.j(i6).up("ah_report_config");
            if (up != null) {
                for (int i7 = 0; i7 < up.length(); i7++) {
                    try {
                        String string = up.getString(i7);
                        a.C0770a b6 = com.ss.android.socialbase.appdownloader.m.b.b(string);
                        if (b6 != null) {
                            jSONObject.put(string.replaceAll("\\.", "_"), b6.i() + "_" + b6.a());
                        }
                    } catch (Throwable th) {
                        vl.j(th);
                    }
                }
            }
            try {
                jSONObject.put("is_unknown_source_enabled", com.ss.android.socialbase.appdownloader.j.n(com.ss.android.socialbase.downloader.downloader.cw.nd()) ? 1 : 2);
            } catch (Throwable unused) {
            }
        }

        public static JSONObject g(@NonNull JSONObject jSONObject, com.ss.android.xt.j.xt.a aVar) {
            h.u(jSONObject, com.ss.android.socialbase.appdownloader.m.e.m().replaceAll("\\.", "_") + " versionCode", Integer.valueOf(h.H(com.ss.android.downloadlib.addownload.m.getContext(), com.ss.android.socialbase.appdownloader.m.e.m())));
            h.u(jSONObject, com.ss.android.socialbase.appdownloader.m.e.m().replaceAll("\\.", "_") + " versionName", h.b(com.ss.android.downloadlib.addownload.m.getContext(), com.ss.android.socialbase.appdownloader.m.e.m()));
            return jSONObject;
        }

        public static void h(cw cwVar, JSONObject jSONObject) {
            com.ss.android.xt.j.xt.b f6;
            if (jSONObject == null || (f6 = o.f.c().f(cwVar)) == null) {
                return;
            }
            try {
                a(cwVar, jSONObject);
                jSONObject.putOpt("time_after_click", Long.valueOf(System.currentTimeMillis() - f6.k()));
                jSONObject.putOpt("click_download_size", Long.valueOf(f6.s()));
                jSONObject.putOpt("download_length", Long.valueOf(cwVar.uq()));
                jSONObject.putOpt("download_apk_size", Long.valueOf(cwVar.ka()));
                f6.a();
                o.d.c().d(f6);
                jSONObject.put("click_pause_times", f6.x0());
                long ka = cwVar.ka();
                long uq = cwVar.uq();
                jSONObject.put("download_percent", (uq < 0 || ka <= 0) ? 0.0d : uq / ka);
                jSONObject.put("download_status", cwVar.v());
                long currentTimeMillis = System.currentTimeMillis();
                long Q0 = f6.Q0();
                if (Q0 > 0) {
                    jSONObject.put("time_from_start_download", currentTimeMillis - Q0);
                }
                long S = f6.S();
                if (S > 0) {
                    jSONObject.put("time_from_download_resume", currentTimeMillis - S);
                }
                jSONObject.putOpt("fail_status", Integer.valueOf(f6.T()));
                jSONObject.putOpt("fail_msg", f6.C());
                jSONObject.put("download_failed_times", f6.T0());
                jSONObject.put("can_show_notification", com.ss.android.socialbase.appdownloader.up.c.e() ? 1 : 2);
                jSONObject.put("first_speed_time", cwVar.ch());
                jSONObject.put("all_connect_time", cwVar.l());
                jSONObject.put("download_prepare_time", cwVar.p());
                jSONObject.put("download_time", cwVar.lx() + cwVar.l() + cwVar.p());
            } catch (Throwable th) {
                vl.j(th);
            }
        }

        public static JSONObject b(@NonNull JSONObject jSONObject, com.ss.android.xt.j.xt.a aVar) {
            h.u(jSONObject, "open_url", h.q(aVar.m(), "open_url_not_exist"));
            return jSONObject;
        }

        public static void c(cw cwVar, JSONObject jSONObject) {
            int i6;
            try {
                a(cwVar, jSONObject);
                com.ss.android.xt.j.xt.b f6 = o.f.c().f(cwVar);
                if (f6 == null) {
                    return;
                }
                if (f6.i0()) {
                    i6 = 1;
                } else {
                    i6 = 2;
                }
                jSONObject.put("is_update_download", i6);
                d(f6, jSONObject);
            } catch (Throwable th) {
                vl.j(th);
            }
        }
    }

    public class j {

        /* renamed from: a, reason: collision with root package name */
        private static Map<String, InterfaceC0734a> f37571a = Collections.synchronizedMap(new HashMap());

        /* renamed from: com.ss.android.downloadlib.a$j$a, reason: collision with other inner class name */
        public interface InterfaceC0734a {
            void j();

            void j(String str);
        }

        public static void e(String[] strArr, InterfaceC0734a interfaceC0734a) {
            if (strArr == null || strArr.length <= 0) {
                return;
            }
            String valueOf = String.valueOf(System.currentTimeMillis());
            c(valueOf, interfaceC0734a);
            TTDelegateActivity.s(valueOf, strArr);
        }

        private static InterfaceC0734a a(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return f37571a.remove(str);
        }

        public static void b(String str) {
            InterfaceC0734a a6;
            if (TextUtils.isEmpty(str) || (a6 = a(str)) == null) {
                return;
            }
            a6.j();
        }

        private static void c(String str, InterfaceC0734a interfaceC0734a) {
            if (!TextUtils.isEmpty(str) && interfaceC0734a != null) {
                f37571a.put(str, interfaceC0734a);
            }
        }

        public static void d(String str, String str2) {
            InterfaceC0734a a6;
            if (TextUtils.isEmpty(str) || (a6 = a(str)) == null) {
                return;
            }
            a6.j(str2);
        }

        public static boolean f(String str) {
            return com.ss.android.downloadlib.addownload.m.E().j(com.ss.android.downloadlib.addownload.m.getContext(), str);
        }
    }

    public class l {
        public static String a(String str, String str2, boolean z5, String str3) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(JThirdPlatFormInterface.KEY_EXTRA, str);
                if (!TextUtils.isEmpty(str2)) {
                    jSONObject.put("notification_jump_url", str2);
                }
                jSONObject.put("show_toast", z5);
                jSONObject.put("business_type", str3);
            } catch (JSONException e6) {
                vl.j(e6);
            }
            return jSONObject.toString();
        }
    }

    public class m {

        /* renamed from: a, reason: collision with root package name */
        private static final String f37572a = "a$m";

        static class b implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Context f37573a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ Intent f37574b;

            b(Context context, Intent intent) {
                this.f37573a = context;
                this.f37574b = intent;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f37573a.startActivity(this.f37574b);
            }
        }

        static class d implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Context f37575a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ Intent f37576b;

            d(Context context, Intent intent) {
                this.f37575a = context;
                this.f37576b = intent;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f37575a.startActivity(this.f37576b);
            }
        }

        static class e implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Context f37577a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f37578b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ o.i f37579c;

            e(Context context, String str, o.i iVar) {
                this.f37577a = context;
                this.f37578b = str;
                this.f37579c = iVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                j.g.a(m.i(this.f37577a, Uri.parse("market://details?id=" + this.f37578b)), this.f37579c, true);
                JSONObject jSONObject = new JSONObject();
                try {
                    JSONObject f6 = com.ss.android.downloadlib.addownload.m.f();
                    Thread.sleep(f6.optInt("m2_delay_millis", 1000));
                    com.ss.android.downloadlib.j.j.a.c().f(this.f37577a, true);
                    com.ss.android.downloadlib.j.j.xt xtVar = new com.ss.android.downloadlib.j.j.xt();
                    xtVar.f38188a = 1;
                    xtVar.f38189b = 0;
                    String b6 = com.ss.android.socialbase.appdownloader.m.a.b(f6.optString("v"), f6.optString("s"));
                    xtVar.f38190c = String.format(b6, this.f37578b);
                    com.ss.android.downloadlib.j.j.a.c().d(xtVar, null);
                    com.ss.android.downloadlib.j.j.a.c().h();
                    m.Q(this.f37579c, jSONObject, -1, 2, String.format(b6, this.f37578b));
                } catch (Throwable th) {
                    vl.j(th);
                    m.Q(this.f37579c, jSONObject, 1, 2, "market://details?id=" + this.f37578b);
                }
            }
        }

        static class f implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f37580a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ Context f37581b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ o.i f37582c;

            /* renamed from: com.ss.android.downloadlib.a$m$f$a, reason: collision with other inner class name */
            class C0736a implements w2.q {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ JSONObject f37583a;

                @Override // w2.q
                public void j(String str) {
                    if (!TextUtils.isEmpty(str)) {
                        String b6 = m.b(str);
                        if (!TextUtils.isEmpty(b6)) {
                            String F = m.F(b6);
                            if (!TextUtils.isEmpty(F)) {
                                f fVar = f.this;
                                m.O(fVar.f37581b, fVar.f37582c, fVar.f37580a, F);
                                return;
                            }
                        }
                    }
                    j.g.a(m.i(f.this.f37581b, Uri.parse("market://details?id=" + f.this.f37580a)), f.this.f37582c, true);
                    m.Q(f.this.f37582c, this.f37583a, 10, 9, "market://details?id=" + f.this.f37580a);
                }

                C0736a(JSONObject jSONObject) {
                    this.f37583a = jSONObject;
                }

                @Override // w2.q
                public void j(Throwable th) {
                    j.g.a(m.i(f.this.f37581b, Uri.parse("market://details?id=" + f.this.f37580a)), f.this.f37582c, true);
                    h.u(this.f37583a, "ttdownloader_message", th != null ? th.getMessage() : "null");
                    m.Q(f.this.f37582c, this.f37583a, 11, 9, "market://details?id=" + f.this.f37580a);
                }
            }

            f(String str, Context context, o.i iVar) {
                this.f37580a = str;
                this.f37581b = context;
                this.f37582c = iVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                JSONObject f6 = com.ss.android.downloadlib.addownload.m.f();
                JSONObject jSONObject = new JSONObject();
                try {
                    String optString = f6.optString("s");
                    String b6 = com.ss.android.socialbase.appdownloader.m.a.b(f6.optString("bw"), optString);
                    String b7 = com.ss.android.socialbase.appdownloader.m.a.b(f6.optString("bx"), optString);
                    String b8 = com.ss.android.socialbase.appdownloader.m.a.b(f6.optString("by"), optString);
                    Uri.Builder builder = new Uri.Builder();
                    builder.scheme(master.flame.danmaku.danmaku.parser.b.f50155b).authority(b6).appendPath(b7).appendQueryParameter(b8, this.f37580a);
                    com.ss.android.downloadlib.addownload.m.B().j("GET", builder.build().toString(), null, new C0736a(jSONObject));
                } catch (Exception e6) {
                    vl.j(e6);
                    m.Q(this.f37582c, jSONObject, 4, 9, "market://details?id=" + this.f37580a);
                }
            }
        }

        static class g implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f37585a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ Context f37586b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ o.i f37587c;

            /* renamed from: com.ss.android.downloadlib.a$m$g$a, reason: collision with other inner class name */
            class C0737a implements w2.q {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ JSONObject f37588a;

                @Override // w2.q
                public void j(String str) {
                    g gVar = g.this;
                    m.P(gVar.f37586b, gVar.f37585a, str, gVar.f37587c, this.f37588a);
                }

                C0737a(JSONObject jSONObject) {
                    this.f37588a = jSONObject;
                }

                @Override // w2.q
                public void j(Throwable th) {
                    j.g.a(m.i(g.this.f37586b, Uri.parse("market://details?id=" + g.this.f37585a)), g.this.f37587c, true);
                    h.u(this.f37588a, "ttdownloader_message", th != null ? th.getMessage() : "null");
                    m.Q(g.this.f37587c, this.f37588a, 7, 5, "market://details?id=" + g.this.f37585a);
                }
            }

            g(String str, Context context, o.i iVar) {
                this.f37585a = str;
                this.f37586b = context;
                this.f37587c = iVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                JSONObject f6 = com.ss.android.downloadlib.addownload.m.f();
                String optString = f6.optString("s");
                JSONObject jSONObject = new JSONObject();
                String b6 = com.ss.android.socialbase.appdownloader.m.a.b(f6.optString("x"), optString);
                JSONObject jSONObject2 = new JSONObject();
                h.u(jSONObject2, bi.aL, "v");
                h.u(jSONObject2, "p", this.f37585a);
                byte[] bytes = jSONObject2.toString().getBytes();
                com.ss.android.downloadlib.addownload.m.B().j(b6, com.ss.android.downloadlib.addownload.m.H().j(bytes, bytes.length), "application/octet-stream;tt-data=a", 0, new C0737a(jSONObject));
            }
        }

        static boolean e(Context context, String str) {
            if (context == null) {
                return false;
            }
            try {
                Uri parse = Uri.parse(str);
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(parse);
                intent.addFlags(268435456);
                intent.putExtra("open_url", str);
                intent.putExtra("start_only_for_android", true);
                context.startActivity(intent);
                return true;
            } catch (Throwable th) {
                vl.j(th);
                return false;
            }
        }

        public static o.b j(Context context, Uri uri, o.i iVar) {
            com.ss.android.xt.j.xt.b bVar;
            if (context == null || !j.i.a(uri)) {
                return new o.b(6, 12);
            }
            try {
                Intent intent = new Intent("android.intent.action.VIEW", uri);
                if (!h.x(context, intent)) {
                    return new o.b(6, 13);
                }
                String m6 = com.ss.android.socialbase.appdownloader.m.e.m();
                if (h.G(context, m6)) {
                    intent.setPackage(m6);
                }
                intent.addFlags(335544320);
                if (com.ss.android.socialbase.downloader.jy.j.cw().xt("test_jump_market_failed") == 1 && "local_test".equals(com.ss.android.downloadlib.addownload.m.z().f38269c)) {
                    com.ss.android.downloadlib.up.a.a().d(false, "jump market error");
                    return new o.b(6, 25);
                }
                intent.putExtra("start_only_for_android", true);
                long optLong = com.ss.android.downloadlib.addownload.m.f().optLong("market_jump_delay", 1000L);
                if (optLong > 0 && iVar != null && (bVar = iVar.f37964e) != null && !bVar.Q()) {
                    com.ss.android.downloadlib.c.d().s().post(new RunnableC0735a());
                }
                com.ss.android.downloadlib.e.c().e(new b(context, intent), optLong);
                return new o.b(5);
            } catch (Exception unused) {
                return new o.b(6, 14);
            }
        }

        static o.b m(Context context, String str, com.ss.android.xt.j.xt.a aVar) {
            Intent g6 = g(context, aVar, str, 1, null);
            if (g6 != null) {
                o.a().b(f37572a, "tryOpenByPackage", "成功构造了跳转中转Activity的intent");
                o.b n6 = n(g6, true, context, str, aVar);
                if (n6.getType() == 3) {
                    return n6;
                }
            }
            Intent a6 = h.a(context, str);
            return a6 == null ? new o.b(4, 22) : n(a6, false, context, str, aVar);
        }

        /* renamed from: com.ss.android.downloadlib.a$m$a, reason: collision with other inner class name */
        static class RunnableC0735a implements Runnable {
            RunnableC0735a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                com.ss.android.downloadlib.addownload.m.d().j(8, com.ss.android.downloadlib.addownload.m.getContext(), null, "浏览器跳转失败，正在前往应用商店", null, 0);
            }
        }

        static class c implements Runnable {
            c() {
            }

            @Override // java.lang.Runnable
            public void run() {
                com.ss.android.downloadlib.addownload.m.d().j(12, com.ss.android.downloadlib.addownload.m.getContext(), null, "正在前往浏览器下载", null, 0);
            }
        }

        private static boolean A(@NonNull Activity activity, @NonNull String str, @NonNull HashMap<String, String> hashMap) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse("market://details?id=" + str));
            intent.putExtra("start_only_for_android", true);
            intent.putExtra("param", hashMap);
            String m6 = com.ss.android.socialbase.appdownloader.m.e.m();
            if (h.G(com.ss.android.downloadlib.addownload.m.getContext(), m6)) {
                intent.setPackage(m6);
            }
            if (!h.x(com.ss.android.downloadlib.addownload.m.getContext(), intent)) {
                return false;
            }
            try {
                activity.startActivity(intent);
                return true;
            } catch (Exception e6) {
                com.ss.android.downloadlib.up.a.a().j(e6, "start v1");
                return false;
            }
        }

        private static o.b D(Context context, o.i iVar, String str) {
            Intent intent = new Intent(context, (Class<?>) JumpKllkActivity.class);
            intent.addFlags(268435456);
            intent.putExtra("dl", true);
            intent.putExtra("p", str);
            intent.putExtra("id", iVar.f37960a);
            if (Build.VERSION.SDK_INT >= 29) {
                intent.putExtra("bk", "com.heytap.browser");
            } else if (h.G(context, "com.android.browser")) {
                intent.putExtra("bk", "com.android.browser");
            } else {
                if (!h.G(context, "com.coloros.browser")) {
                    return i(context, Uri.parse("market://details?id=" + str));
                }
                intent.putExtra("bk", "com.coloros.browser");
            }
            intent.putExtra("start_only_for_android", true);
            JSONObject jSONObject = new JSONObject();
            try {
                context.startActivity(intent);
                return new o.b(7, "am_kllk3");
            } catch (Throwable unused) {
                Q(iVar, jSONObject, 1, 3, "market://details?id=" + str);
                return i(context, Uri.parse("market://details?id=" + str));
            }
        }

        private static o.b E(@NonNull Context context, @NonNull String str) {
            try {
                Uri parse = Uri.parse("https://www.samsungapps.com/appquery/appDetail.as?appId=" + str);
                Intent intent = new Intent();
                intent.setClassName("com.sec.android.app.samsungapps", "com.sec.android.app.samsungapps.Main");
                intent.setData(parse);
                if (!(context instanceof Activity)) {
                    intent.addFlags(268435456);
                }
                intent.putExtra("start_only_for_android", true);
                context.startActivity(intent);
                return new o.b(5);
            } catch (Exception unused) {
                return new o.b(6, 14);
            }
        }

        private static o.b I(Context context, o.i iVar, String str) {
            Intent intent = new Intent(context, (Class<?>) JumpKllkActivity.class);
            intent.addFlags(268435456);
            intent.putExtra("p", str);
            intent.putExtra("id", iVar.f37960a);
            intent.putExtra("start_only_for_android", true);
            JSONObject jSONObject = new JSONObject();
            try {
                context.startActivity(intent);
                return new o.b(7, "am_kllk2");
            } catch (Throwable unused) {
                Q(iVar, jSONObject, 1, 3, "market://details?id=" + str);
                return i(context, Uri.parse("market://details?id=" + str));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void O(Context context, @NonNull o.i iVar, @NonNull String str, @NonNull String str2) {
            JSONObject jSONObject = new JSONObject();
            try {
                TTDelegateActivity.z(str, iVar.f37960a, str2);
            } catch (Exception unused) {
                j.g.a(i(context, Uri.parse("market://details?id=" + str)), iVar, true);
                Q(iVar, jSONObject, 12, 9, "market://details?id=" + str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void P(Context context, String str, String str2, @NonNull o.i iVar, @NonNull JSONObject jSONObject) {
            h.u(jSONObject, "ttdownloader_type", 5);
            try {
                String a6 = com.ss.android.socialbase.appdownloader.m.a.a(new JSONObject(str2).optString("a"));
                if (!TextUtils.isEmpty(a6)) {
                    TTDelegateActivity.q(str, iVar.f37960a, a6, jSONObject);
                    return;
                }
                j.g.a(i(context, Uri.parse("market://details?id=" + str)), iVar, true);
                Q(iVar, jSONObject, 5, 5, "market://details?id=" + str);
            } catch (Exception unused) {
                j.g.a(i(context, Uri.parse("market://details?id=" + str)), iVar, true);
                Q(iVar, jSONObject, 6, 5, "market://details?id=" + str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void Q(o.i iVar, JSONObject jSONObject, int i6, int i7, String str) {
            h.u(jSONObject, "error_code", Integer.valueOf(i6));
            h.u(jSONObject, "ttdownloader_type", Integer.valueOf(i7));
            h.u(jSONObject, "rmu", str);
            h.u(jSONObject, com.ss.android.socialbase.appdownloader.m.e.m(), Integer.valueOf(h.H(com.ss.android.downloadlib.addownload.m.getContext(), com.ss.android.socialbase.appdownloader.m.e.m())));
            com.ss.android.downloadlib.r.b.a().x("am_result", jSONObject, iVar);
        }

        public static boolean R(@NonNull Activity activity, Uri uri) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(uri);
            intent.putExtra("start_only_for_android", true);
            String m6 = com.ss.android.socialbase.appdownloader.m.e.m();
            if (h.G(com.ss.android.downloadlib.addownload.m.getContext(), m6)) {
                intent.setPackage(m6);
            }
            if (!h.x(com.ss.android.downloadlib.addownload.m.getContext(), intent)) {
                return false;
            }
            try {
                activity.startActivity(intent);
                return true;
            } catch (Exception e6) {
                com.ss.android.downloadlib.up.a.a().j(e6, "start HM1");
                return false;
            }
        }

        private static void a(Context context, o.i iVar, String str) {
            JSONObject jSONObject = new JSONObject();
            try {
                TTDelegateActivity.o(str, iVar.f37960a);
            } catch (Exception unused) {
                j.g.a(i(context, Uri.parse("market://details?id=" + str)), iVar, true);
                Q(iVar, jSONObject, 13, 10, "market://details?id=" + str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static String b(String str) {
            Matcher matcher = Pattern.compile("<input[\\s\\S]*>\\n").matcher(str);
            String group = matcher.find() ? matcher.group() : "";
            if (!group.equals(null) && group.length() > 0) {
                for (String str2 : group.split("\\n")) {
                    if (str2.startsWith("<input")) {
                        for (String str3 : str2.split("\\s")) {
                            if (str3.startsWith("value")) {
                                return str3.substring(7, str3.length() - 1);
                            }
                        }
                    }
                }
            }
            return null;
        }

        private static void c(Context context, o.i iVar, String str) {
            JSONObject jSONObject = new JSONObject();
            try {
                TTDelegateActivity.g(context, str, iVar.f37960a);
            } catch (Exception unused) {
                j.g.a(i(context, Uri.parse("market://details?id=" + str)), iVar, true);
                Q(iVar, jSONObject, 14, 11, "market://details?id=" + str);
            }
        }

        public static boolean d(@NonNull Activity activity, Uri uri) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(uri);
            intent.putExtra("start_only_for_android", true);
            String m6 = com.ss.android.socialbase.appdownloader.m.e.m();
            if (h.G(com.ss.android.downloadlib.addownload.m.getContext(), m6)) {
                intent.setPackage(m6);
            }
            if (!h.x(com.ss.android.downloadlib.addownload.m.getContext(), intent)) {
                return false;
            }
            try {
                activity.startActivity(intent);
                return true;
            } catch (Exception e6) {
                com.ss.android.downloadlib.up.a.a().j(e6, "start HM2");
                return false;
            }
        }

        private static void f(Context context, o.i iVar, String str) {
            JSONObject jSONObject = new JSONObject();
            try {
                TTDelegateActivity.p(str, iVar.f37960a, "need_comment");
            } catch (Exception unused) {
                j.g.a(i(context, Uri.parse("market://details?id=" + str)), iVar, true);
                Q(iVar, jSONObject, 9, 8, "market://details?id=" + str);
            }
        }

        private static o.b h(Context context, Intent intent, com.ss.android.xt.j.xt.a aVar, boolean z5, String str) {
            if (context == null) {
                context = com.ss.android.downloadlib.addownload.m.getContext();
            }
            if (!h.L(context, intent)) {
                return new o.b(2, 24);
            }
            if (com.ss.android.downloadlib.addownload.m.f().optInt("open_url_mode") == 0 && com.ss.android.downloadlib.addownload.m.G() != null && com.ss.android.downloadlib.addownload.m.G().j() && Build.VERSION.SDK_INT >= 26 && aVar.i() && !z5) {
                TTDelegateActivity.r(str, aVar);
                return new o.b(1);
            }
            try {
                context.startActivity(intent);
                return new o.b(1);
            } catch (Exception e6) {
                if (z5) {
                    o.a().c(f37572a, "realTryOpenByUrl", "商店直投注入clickId优化url调起场景，抛出异常，没接转化SDK，回退普通调起" + e6.getMessage());
                    return new o.b(9);
                }
                o.a().c(f37572a, "realTryOpenByUrl", "url调起失败了，抛出异常" + e6.getMessage());
                return new o.b(2);
            }
        }

        public static o.b k(Context context, o.i iVar, String str) {
            if (context == null || TextUtils.isEmpty(str)) {
                return new o.b(6, 11);
            }
            if (com.ss.android.socialbase.appdownloader.m.e.a() && h.G(context, "com.sec.android.app.samsungapps")) {
                return E(context, str);
            }
            if (!iVar.f37961b.x() || !iVar.f37963d.av()) {
                return i(context, Uri.parse("market://details?id=" + str));
            }
            JSONArray optJSONArray = com.ss.android.downloadlib.addownload.m.f().optJSONArray("am_plans");
            if (com.ss.android.socialbase.appdownloader.m.e.r() && com.ss.android.socialbase.appdownloader.m.b.d(optJSONArray, "am_3")) {
                return I(context, iVar, str);
            }
            if (com.ss.android.socialbase.appdownloader.m.e.k() && com.ss.android.socialbase.appdownloader.m.b.d(optJSONArray, "am_2")) {
                H(context, iVar, str);
                return new o.b(7, "am_m2");
            }
            if (com.ss.android.socialbase.appdownloader.m.e.p() && com.ss.android.socialbase.appdownloader.m.b.d(optJSONArray, "am_5")) {
                G(context, iVar, str);
                return new o.b(7, "am_v1");
            }
            if (com.ss.android.socialbase.appdownloader.m.e.r() && com.ss.android.socialbase.appdownloader.m.b.d(optJSONArray, "am_7")) {
                com.ss.android.j.j.cw.c cVar = iVar.f37963d;
                if ((cVar instanceof com.ss.android.xt.j.j.b) && ((com.ss.android.xt.j.j.b) cVar).b()) {
                    return D(context, iVar, str);
                }
            }
            if (com.ss.android.socialbase.appdownloader.m.e.p() && com.ss.android.socialbase.appdownloader.m.b.d(optJSONArray, "am_8") && h.g(h.b(context, "com.bbk.appstore"), "8.7.2.0") >= 0) {
                f(context, iVar, str);
                return new o.b(7, "am_v2");
            }
            if ((com.ss.android.socialbase.appdownloader.m.e.h() || com.ss.android.socialbase.appdownloader.m.e.w()) && com.ss.android.socialbase.appdownloader.m.b.d(optJSONArray, "am_9")) {
                C(context, iVar, str);
                return new o.b(7, "am_hr");
            }
            if ((com.ss.android.socialbase.appdownloader.m.e.h() || com.ss.android.socialbase.appdownloader.m.e.w()) && com.ss.android.socialbase.appdownloader.m.b.d(optJSONArray, "am_10")) {
                a(context, iVar, str);
                return new o.b(7, "am_hr2");
            }
            com.ss.android.j.j.cw.c cVar2 = iVar.f37963d;
            if (!(cVar2 instanceof com.ss.android.xt.j.j.b) || !((com.ss.android.xt.j.j.b) cVar2).b() || ((com.ss.android.xt.j.j.b) iVar.f37963d).h() == null || iVar.f37961b.w().optInt("is_use_obm_convert", 0) != 1) {
                return i(context, u2.a.a(context, str));
            }
            c(context, iVar, str);
            return new o.b(7, "am_kllk4");
        }

        public static o.b l(Context context, String str) {
            return (context == null || TextUtils.isEmpty(str)) ? new o.b(6, 11) : (com.ss.android.socialbase.appdownloader.m.e.a() && h.G(context, "com.sec.android.app.samsungapps")) ? E(context, str) : i(context, u2.a.a(context, str));
        }

        private static o.b n(Intent intent, boolean z5, Context context, String str, com.ss.android.xt.j.xt.a aVar) {
            if (Build.VERSION.SDK_INT >= 26 && com.ss.android.downloadlib.addownload.m.f().optInt("open_package_mode") == 1 && com.ss.android.downloadlib.addownload.m.G() != null && com.ss.android.downloadlib.addownload.m.G().j() && aVar.i() && !z5) {
                TTDelegateActivity.A(str, aVar);
                return new o.b(3);
            }
            intent.putExtra("start_only_for_android", true);
            try {
                context.startActivity(intent);
                return new o.b(3);
            } catch (Exception e6) {
                if (z5) {
                    o.a().c(f37572a, "realTryOpenByPackage", "调起中转Activity出现异常，可能是没接转化SDK，回退普通调起" + e6.getMessage());
                    return new o.b(8, 23);
                }
                o.a().c(f37572a, "realTryOpenByPackage", "包名调起失败了，抛出异常" + e6.getMessage());
                return new o.b(4, 23);
            }
        }

        public static void t(@NonNull Activity activity, String str, long j6, String str2, String str3) {
            JSONObject jSONObject;
            try {
                jSONObject = new JSONObject(str3);
            } catch (JSONException unused) {
                jSONObject = new JSONObject();
            }
            o.i r5 = o.f.c().r(j6);
            try {
                JSONObject f6 = com.ss.android.downloadlib.addownload.m.f();
                boolean g6 = com.ss.android.socialbase.appdownloader.m.b.g(f6, activity, com.ss.android.socialbase.appdownloader.m.a.b(f6.optString("bg"), f6.optString("s")));
                HashMap<String, String> J = h.J(new JSONObject(str2));
                if (g6 && !J.isEmpty() && A(activity, str, J)) {
                    Q(r5, jSONObject, -1, 5, "market://details?id=" + str);
                    j.g.d("am_v1", jSONObject, r5, true);
                    return;
                }
                Q(r5, jSONObject, g6 ? J.isEmpty() ? 1 : 2 : 3, 5, "market://details?id=" + str);
                j.g.a(i(activity, Uri.parse("market://details?id=" + str)), r5, true);
            } catch (Exception unused2) {
                j.g.a(i(com.ss.android.downloadlib.addownload.m.getContext(), Uri.parse("market://details?id=" + str)), r5, true);
                Q(r5, jSONObject, 4, 5, "market://details?id=" + str);
            }
        }

        public static void v(Context context, String str, long j6, String str2, boolean z5) {
            JSONObject jSONObject = new JSONObject();
            o.i r5 = o.f.c().r(j6);
            try {
                JSONObject f6 = com.ss.android.downloadlib.addownload.m.f();
                String optString = f6.optString("s");
                String b6 = com.ss.android.socialbase.appdownloader.m.a.b(f6.optString("br"), optString);
                String b7 = com.ss.android.socialbase.appdownloader.m.a.b(f6.optString("bs_1"), optString);
                String b8 = com.ss.android.socialbase.appdownloader.m.a.b(f6.optString("bs_2"), optString);
                String b9 = com.ss.android.socialbase.appdownloader.m.a.b(f6.optString("bs_3"), optString);
                String b10 = com.ss.android.socialbase.appdownloader.m.a.b(f6.optString("bt"), optString);
                String b11 = com.ss.android.socialbase.appdownloader.m.a.b(f6.optString("bu"), optString);
                StringBuilder sb = new StringBuilder(String.format(JPushConstants.HTTPS_PRE, new Object[0]));
                sb.append(b6);
                sb.append(b7);
                sb.append(b8);
                sb.append(b9);
                sb.append(b10);
                sb.append(b11);
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setPackage(str2);
                if (z5) {
                    sb.append("pkg=" + str);
                    sb.append("&dl=true");
                } else {
                    intent.addFlags(335544320);
                }
                h.u(jSONObject, "dl", Boolean.valueOf(z5));
                intent.setData(Uri.parse(sb.toString()));
                intent.putExtra("start_only_for_android", true);
                long optLong = com.ss.android.downloadlib.addownload.m.f().optLong("oppo_browser_jump_delay", 1000L);
                if (optLong > 0) {
                    com.ss.android.downloadlib.c.d().s().post(new c());
                }
                com.ss.android.downloadlib.e.c().e(new d(context, intent), optLong);
                com.ss.android.xt.j.xt.b bVar = r5.f37964e;
                if (bVar != null) {
                    bVar.u(true);
                }
                j.g.d("am_kllk3", jSONObject, r5, true);
                Q(r5, jSONObject, -1, 7, sb.toString());
            } catch (Exception unused) {
                com.ss.android.xt.j.xt.b bVar2 = r5.f37964e;
                if (bVar2 != null) {
                    bVar2.u(false);
                }
                j.g.a(j(com.ss.android.downloadlib.addownload.m.getContext(), Uri.parse("market://details?id=" + str), r5), r5, true);
                Q(r5, jSONObject, 2, 7, "market://details?id=" + str);
            }
        }

        public static void w(Context context, String str, long j6, boolean z5) {
            JSONObject jSONObject = new JSONObject();
            o.i r5 = o.f.c().r(j6);
            try {
                JSONObject f6 = com.ss.android.downloadlib.addownload.m.f();
                String optString = f6.optString("s");
                String b6 = com.ss.android.socialbase.appdownloader.m.a.b(f6.optString("aa"), optString);
                String b7 = com.ss.android.socialbase.appdownloader.m.a.b(f6.optString("ac"), optString);
                String b8 = com.ss.android.socialbase.appdownloader.m.a.b(f6.optString("af"), optString);
                boolean g6 = com.ss.android.socialbase.appdownloader.m.b.g(f6, context, b7);
                StringBuilder sb = new StringBuilder(String.format(b6, str, b8, b7));
                Intent intent = new Intent("android.intent.action.VIEW");
                String m6 = com.ss.android.socialbase.appdownloader.m.e.m();
                if (h.G(context, m6)) {
                    intent.setPackage(m6);
                }
                if (z5) {
                    sb.append(com.ss.android.socialbase.appdownloader.m.a.b(f6.optString("ae"), optString));
                } else {
                    intent.addFlags(335544320);
                }
                h.u(jSONObject, "mf", Boolean.valueOf(g6));
                h.u(jSONObject, "if", Boolean.valueOf(z5));
                intent.setData(Uri.parse(sb.toString()));
                intent.putExtra("start_only_for_android", true);
                context.startActivity(intent);
                j.g.d("am_kllk2", jSONObject, r5, true);
                if (g6) {
                    Q(r5, jSONObject, -1, 3, sb.toString());
                } else {
                    Q(r5, jSONObject, 3, 3, sb.toString());
                }
            } catch (Exception unused) {
                j.g.a(i(com.ss.android.downloadlib.addownload.m.getContext(), Uri.parse("market://details?id=" + str)), r5, true);
                Q(r5, jSONObject, 2, 3, "market://details?id=" + str);
            }
        }

        public static boolean z(@NonNull Activity activity, Uri uri) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(uri);
            intent.putExtra("start_only_for_android", true);
            String m6 = com.ss.android.socialbase.appdownloader.m.e.m();
            if (h.G(com.ss.android.downloadlib.addownload.m.getContext(), m6)) {
                intent.setPackage(m6);
            }
            if (!h.x(com.ss.android.downloadlib.addownload.m.getContext(), intent)) {
                return false;
            }
            try {
                activity.startActivity(intent);
                return true;
            } catch (Exception e6) {
                com.ss.android.downloadlib.up.a.a().j(e6, "start v2");
                return false;
            }
        }

        public static boolean B(Context context, o.i iVar, String str, JSONObject jSONObject, boolean z5, int i6) {
            h.u(jSONObject, "download_scene", Integer.valueOf(iVar.kt()));
            com.ss.android.downloadlib.r.b.a().x("market_click_open", jSONObject, iVar);
            o.b i7 = i(context, Uri.parse(str));
            String q5 = h.q(i7.b(), "open_market");
            int type = i7.getType();
            if (type != 5) {
                if (type != 6) {
                    if (type != 7) {
                        return false;
                    }
                } else {
                    h.u(jSONObject, "error_code", Integer.valueOf(i7.a()));
                    h.u(jSONObject, "download_scene", Integer.valueOf(iVar.kt()));
                    com.ss.android.downloadlib.r.b.a().x("market_open_failed", jSONObject, iVar);
                    return false;
                }
            } else {
                j.g.d(q5, jSONObject, iVar, true);
            }
            if (z5) {
                com.ss.android.downloadlib.r.b.a().c(iVar.f37960a, i6);
            }
            return true;
        }

        private static void C(Context context, o.i iVar, String str) {
            com.ss.android.downloadlib.e.c().d(new f(str, context, iVar));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static String F(String str) {
            List<String> pathSegments = Uri.parse(str).getPathSegments();
            if (pathSegments.size() > 0) {
                return pathSegments.get(pathSegments.size() - 1);
            }
            return null;
        }

        private static void G(Context context, o.i iVar, String str) {
            com.ss.android.downloadlib.e.c().d(new g(str, context, iVar));
        }

        private static void H(Context context, o.i iVar, String str) {
            com.ss.android.downloadlib.e.c().d(new e(context, str, iVar));
        }

        static o.b J(Context context, String str) {
            if (TextUtils.isEmpty(str)) {
                return new o.b(4, 11);
            }
            if (context == null) {
                context = com.ss.android.downloadlib.addownload.m.getContext();
            }
            Intent a6 = h.a(context, str);
            if (a6 == null) {
                return new o.b(4, 22);
            }
            a6.putExtra("start_only_for_android", true);
            try {
                context.startActivity(a6);
                return new o.b(3);
            } catch (Exception unused) {
                return new o.b(4, 23);
            }
        }

        static o.b K(String str, com.ss.android.xt.j.xt.a aVar) {
            if (TextUtils.isEmpty(str)) {
                return new o.b(2, 21);
            }
            Context context = com.ss.android.downloadlib.addownload.m.getContext();
            String s5 = aVar.tj().s();
            if (!TextUtils.isEmpty(s5)) {
                o.a().b(f37572a, "tryOpenByUrl", "获取到跳转中转Activity的intent");
                Intent g6 = g(context, aVar, s5, 2, str);
                if (g6 != null) {
                    o.b h6 = h(context, g6, aVar, true, str);
                    if (h6.getType() == 1) {
                        return h6;
                    }
                }
            }
            Uri parse = Uri.parse(str);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(parse);
            intent.addFlags(268435456);
            intent.putExtra("open_url", str);
            intent.putExtra("start_only_for_android", true);
            if (com.ss.android.socialbase.downloader.jy.j.cw().j("fix_app_link_flag")) {
                intent.addFlags(67108864);
            }
            return h(context, intent, aVar, false, str);
        }

        public static void M(@NonNull Activity activity, String str, long j6) {
            o.i r5 = o.f.c().r(j6);
            JSONObject jSONObject = new JSONObject();
            boolean b6 = ((com.ss.android.xt.j.j.b) r5.f37963d).b();
            HashMap hashMap = new HashMap();
            hashMap.put("is_button", Boolean.valueOf(b6));
            h.u(jSONObject, "is_button", Boolean.valueOf(b6));
            Map<String, Object> j7 = ((com.ss.android.xt.j.j.b) r5.f37963d).h().j(hashMap);
            if (j7 != null && j7.get("convert_result") != null && Boolean.parseBoolean(j7.get("convert_result").toString())) {
                Q(r5, jSONObject, -1, 11, "market://details?id=" + str);
                j.g.d("am_kllk4", jSONObject, r5, true);
                return;
            }
            Q(r5, jSONObject, 15, 11, "market://details?id=" + str);
            j.g.a(i(activity, Uri.parse("market://details?id=" + str)), r5, true);
        }

        public static void N(@NonNull Activity activity, String str, long j6, String str2) {
            o.i r5 = o.f.c().r(j6);
            JSONObject jSONObject = new JSONObject();
            JSONObject f6 = com.ss.android.downloadlib.addownload.m.f();
            String optString = f6.optString("s");
            String b6 = com.ss.android.socialbase.appdownloader.m.a.b(f6.optString("bz"), optString);
            String b7 = com.ss.android.socialbase.appdownloader.m.a.b(f6.optString(ConstantHelper.LOG_CATE), optString);
            String b8 = com.ss.android.socialbase.appdownloader.m.a.b(f6.optString("cb"), optString);
            Uri.Builder builder = new Uri.Builder();
            builder.scheme("hiapplink").authority("com.huawei.appmarket");
            if (!TextUtils.isEmpty(b6)) {
                builder.appendQueryParameter(b6, str2);
            }
            if (!TextUtils.isEmpty(b7) && !TextUtils.isEmpty(b8)) {
                builder.appendQueryParameter(b7, b8);
            }
            if (R(activity, builder.build())) {
                Q(r5, jSONObject, -1, 9, "market://details?id=" + str);
                j.g.d("am_hr", jSONObject, r5, true);
                return;
            }
            Q(r5, jSONObject, 2, 9, "market://details?id=" + str);
            j.g.a(i(activity, Uri.parse("market://details?id=" + str)), r5, true);
        }

        private static Intent g(Context context, com.ss.android.xt.j.xt.a aVar, String str, int i6, String str2) {
            if (aVar.cw() && aVar.v() != null && aVar.v().xt() == 2 && aVar.tj() != null && n.k(aVar).j("app_link_market_open_add_info", 0) == 1) {
                String a6 = com.ss.android.downloadlib.addownload.d.a(aVar.tj());
                String j6 = com.ss.android.downloadlib.addownload.d.j(aVar.tj());
                Intent intent = new Intent();
                intent.setClassName(str, "com.bytedance.ads.convert.BDBridgeActivity");
                ResolveInfo resolveActivity = context.getPackageManager().resolveActivity(intent, 0);
                if (!TextUtils.isEmpty(a6) && resolveActivity != null) {
                    intent.putExtra("click_id", a6);
                    if (!(context instanceof Activity)) {
                        intent.setFlags(268435456);
                    }
                    if (!TextUtils.isEmpty(j6)) {
                        intent.putExtra("intent_extra", j6);
                    }
                    if (i6 == 2 && !TextUtils.isEmpty(str2)) {
                        intent.putExtra("open_url", str2);
                    }
                    return intent;
                }
                return null;
            }
            return null;
        }

        public static o.b i(Context context, Uri uri) {
            Intent intent;
            if (!com.ss.android.socialbase.appdownloader.m.e.e() && (context == null || uri == null || !"market".equals(uri.getScheme()))) {
                return new o.b(6, 12);
            }
            try {
                String m6 = com.ss.android.socialbase.appdownloader.m.e.m();
                if (com.ss.android.socialbase.appdownloader.m.e.g() && (TextUtils.isEmpty(m6) || !h.G(context, m6))) {
                    m6 = "com.huawei.appmarket";
                    Uri.Builder buildUpon = uri.buildUpon();
                    buildUpon.scheme("market");
                    intent = new Intent("android.intent.action.VIEW", buildUpon.build());
                } else {
                    intent = new Intent("android.intent.action.VIEW", uri);
                }
                if (!h.x(context, intent)) {
                    return new o.b(6, 13);
                }
                if (h.G(context, m6) && !com.ss.android.socialbase.appdownloader.m.e.a()) {
                    intent.setPackage(m6);
                }
                if (com.ss.android.socialbase.downloader.jy.j.cw().j("fix_jump_market")) {
                    intent.addFlags(335544320);
                } else if (!(context instanceof Activity)) {
                    intent.addFlags(268435456);
                }
                if (com.ss.android.socialbase.downloader.jy.j.cw().xt("test_jump_market_failed") == 1) {
                    com.ss.android.downloadlib.up.a.a().d(false, "jump market error");
                    return new o.b(6, 25);
                }
                intent.putExtra("start_only_for_android", true);
                context.startActivity(intent);
                return new o.b(5);
            } catch (Exception unused) {
                return new o.b(6, 14);
            }
        }

        static o.b o(@NonNull com.ss.android.xt.j.xt.b bVar, String str, String str2) {
            o.b K = K(str, bVar);
            if (!j.h.f(bVar)) {
                return K;
            }
            if (K.getType() == 2) {
                return p(str2, bVar);
            }
            return K;
        }

        static o.b p(String str, com.ss.android.xt.j.xt.a aVar) {
            return m(com.ss.android.downloadlib.addownload.m.getContext(), str, aVar);
        }

        public static void r(@NonNull Activity activity, String str, long j6) {
            o.i r5 = o.f.c().r(j6);
            JSONObject jSONObject = new JSONObject();
            JSONObject f6 = com.ss.android.downloadlib.addownload.m.f();
            String optString = f6.optString("s");
            String b6 = com.ss.android.socialbase.appdownloader.m.a.b(f6.optString(ConstantHelper.LOG_CATE), optString);
            String b7 = com.ss.android.socialbase.appdownloader.m.a.b(f6.optString(com.umeng.ccg.a.f41525a), optString);
            StringBuilder sb = new StringBuilder("market://details?id=");
            if (!TextUtils.isEmpty(b6) && !TextUtils.isEmpty(b7)) {
                sb.append(str);
                sb.append(ContainerUtils.FIELD_DELIMITER);
                sb.append(b6);
                sb.append(ContainerUtils.KEY_VALUE_DELIMITER);
                sb.append(b7);
            }
            if (d(activity, Uri.parse(sb.toString()))) {
                Q(r5, jSONObject, -1, 10, "market://details?id=" + str);
                j.g.d("am_hr2", jSONObject, r5, true);
                return;
            }
            Q(r5, jSONObject, 2, 10, "market://details?id=" + str);
            j.g.a(i(activity, Uri.parse("market://details?id=" + str)), r5, true);
        }

        public static void s(@NonNull Activity activity, String str, long j6, String str2) {
            o.i r5 = o.f.c().r(j6);
            JSONObject jSONObject = new JSONObject();
            JSONObject f6 = com.ss.android.downloadlib.addownload.m.f();
            String b6 = com.ss.android.socialbase.appdownloader.m.a.b(f6.optString("bv"), f6.optString("s"));
            Uri.Builder builder = new Uri.Builder();
            builder.scheme("market").authority("details").appendQueryParameter("id", str);
            if (!TextUtils.isEmpty(b6)) {
                builder.appendQueryParameter(b6, str2);
            }
            if (z(activity, builder.build())) {
                Q(r5, jSONObject, -1, 8, "market://details?id=" + str);
                j.g.d("am_v2", jSONObject, r5, true);
                return;
            }
            Q(r5, jSONObject, 2, 8, "market://details?id=" + str);
            j.g.a(i(activity, Uri.parse("market://details?id=" + str)), r5, true);
        }
    }

    public class n {
        public static boolean z(com.ss.android.socialbase.downloader.jy.j jVar) {
            return jVar != null && jVar.j("kllk_need_rename_apk", 0) == 1;
        }

        public static int i(@NonNull com.ss.android.socialbase.downloader.jy.j jVar) {
            return jVar.j("external_storage_permission_path_type", 0);
        }

        @NonNull
        public static com.ss.android.socialbase.downloader.jy.j k(com.ss.android.xt.j.xt.a aVar) {
            return aVar == null ? com.ss.android.socialbase.downloader.jy.j.cw() : aVar.mi() != 0 ? com.ss.android.socialbase.downloader.jy.j.j(aVar.mi()) : aVar.cw() ? com.ss.android.socialbase.downloader.jy.j.j(l()) : aVar.w() != null ? com.ss.android.socialbase.downloader.jy.j.j(aVar.w()) : com.ss.android.socialbase.downloader.jy.j.cw();
        }

        public static JSONObject m(com.ss.android.j.j.cw.b bVar) {
            if (bVar == null) {
                return null;
            }
            return bVar.x() ? h.t(com.ss.android.downloadlib.addownload.m.f(), bVar.w()) : bVar.w();
        }

        public static boolean A(com.ss.android.xt.j.xt.a aVar) {
            if (k(aVar).j("pause_reserve_on_wifi", 0) != 1 || !aVar.i()) {
                return false;
            }
            return true;
        }

        public static long a(com.ss.android.xt.j.xt.b bVar) {
            return k(bVar).j("ttdownloader_app_install_detect_sum_timestamp", TTAdConstant.AD_MAX_EVENT_TIME);
        }

        public static boolean b(int i6) {
            if (com.ss.android.socialbase.downloader.jy.j.j(i6).j("clean_app_cache_dir", 0) != 1) {
                return false;
            }
            return true;
        }

        public static int c(@NonNull com.ss.android.j.j.cw.b bVar) {
            return i(x(bVar));
        }

        public static long d(int i6) {
            return com.ss.android.socialbase.downloader.jy.j.j(i6).j("clean_fetch_apk_head_time_out", 800L);
        }

        public static boolean e() {
            if (com.ss.android.downloadlib.addownload.m.f().optInt("is_enable_start_install_again") == 1) {
                return true;
            }
            return false;
        }

        public static boolean f(com.ss.android.xt.j.xt.a aVar) {
            if (k(aVar).j("cancel_pause_optimise_wifi_retain_switch", 0) != 1 || !aVar.i()) {
                return false;
            }
            return true;
        }

        public static boolean g(com.ss.android.xt.j.xt.b bVar) {
            if (com.ss.android.downloadlib.addownload.m.f().optInt("market_install_finish_opt_switch", 0) != 1 && k(bVar).j("market_install_finish_opt_switch", 0) != 1) {
                return false;
            }
            return true;
        }

        public static double h(int i6) {
            return com.ss.android.socialbase.downloader.jy.j.j(i6).j("clean_min_install_size", 0.0d);
        }

        public static int j(com.ss.android.xt.j.xt.b bVar) {
            return k(bVar).j("ttdownloader_app_install_detect_count", 15);
        }

        @Nullable
        public static JSONObject l() {
            return com.ss.android.downloadlib.addownload.m.f().optJSONObject(bi.az);
        }

        public static int n(com.ss.android.xt.j.xt.b bVar) {
            return k(bVar).j("app_install_keep_receiver_time_s", 60);
        }

        public static boolean o(int i6) {
            if (com.ss.android.socialbase.downloader.jy.j.j(i6).j("clean_space_switch", 0) != 1) {
                return false;
            }
            return true;
        }

        public static long p() {
            long optLong = com.ss.android.downloadlib.addownload.m.f().optLong("start_install_interval");
            if (optLong == 0) {
                return PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS;
            }
            return optLong;
        }

        public static boolean q(int i6) {
            if (com.ss.android.socialbase.downloader.jy.j.j(i6).j("clean_fetch_apk_switch", 0L) == 1) {
                return true;
            }
            return false;
        }

        public static boolean r(com.ss.android.xt.j.xt.b bVar) {
            if (com.ss.android.downloadlib.addownload.m.f().optInt("market_install_finish_opt_broadcast", 0) != 1 && k(bVar).j("market_install_finish_opt_broadcast", 0) != 1) {
                return false;
            }
            return true;
        }

        public static long s() {
            long optLong = com.ss.android.downloadlib.addownload.m.f().optLong("next_install_min_interval");
            if (optLong == 0) {
                return 10000L;
            }
            return optLong;
        }

        public static boolean t(int i6) {
            if (com.ss.android.socialbase.downloader.jy.j.j(i6).j("clean_space_before_download_switch", 0L) == 1) {
                return true;
            }
            return false;
        }

        public static boolean u(com.ss.android.xt.j.xt.b bVar) {
            if (com.ss.android.downloadlib.addownload.m.f().optInt("market_install_finish_opt_polling_thread", 0) != 1 && k(bVar).j("market_install_finish_opt_polling_thread", 0) != 1) {
                return false;
            }
            return true;
        }

        public static int v(com.ss.android.xt.j.xt.b bVar) {
            return k(bVar).j("ttdownloader_app_install_detect_interval_ms", 20000);
        }

        public static long w(int i6) {
            return com.ss.android.socialbase.downloader.jy.j.j(i6).j("storage_min_size", 0L);
        }

        @NonNull
        public static com.ss.android.socialbase.downloader.jy.j x(com.ss.android.j.j.cw.b bVar) {
            return com.ss.android.socialbase.downloader.jy.j.j(m(bVar));
        }

        public static boolean y() {
            if (com.ss.android.socialbase.downloader.jy.j.cw().j("fix_notification_anr")) {
                return true;
            }
            return false;
        }
    }

    public class o {

        /* renamed from: com.ss.android.downloadlib.a$o$a, reason: collision with other inner class name */
        static /* synthetic */ class C0738a {
        }

        private static class b {

            /* renamed from: a, reason: collision with root package name */
            private static o f37590a = new o(null);
        }

        /* synthetic */ o(C0738a c0738a) {
            this();
        }

        private o() {
        }

        public static o a() {
            return b.f37590a;
        }

        public void b(String str, String str2, String str3) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                String.format("sdk:%s.%s:", str, str2);
            }
        }

        public void c(String str, String str2, String str3) {
            String str4;
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                str4 = String.format("sdk:%s.%s:", str, str2);
            } else {
                str4 = "";
            }
            vl.r("[TTDownloaderLogger]", str4 + str3);
        }
    }

    public class p extends Handler {

        /* renamed from: a, reason: collision with root package name */
        WeakReference<InterfaceC0739a> f37591a;

        /* renamed from: com.ss.android.downloadlib.a$p$a, reason: collision with other inner class name */
        public interface InterfaceC0739a {
            void j(Message message);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            InterfaceC0739a interfaceC0739a = this.f37591a.get();
            if (interfaceC0739a == null || message == null) {
                return;
            }
            interfaceC0739a.j(message);
        }

        public p(Looper looper, InterfaceC0739a interfaceC0739a) {
            super(looper);
            this.f37591a = new WeakReference<>(interfaceC0739a);
        }
    }

    public class q {

        /* renamed from: a, reason: collision with root package name */
        static final b f37592a = new c(null);

        /* renamed from: com.ss.android.downloadlib.a$q$a, reason: collision with other inner class name */
        static /* synthetic */ class C0740a {
        }

        private static class b {
            private b() {
            }

            /* synthetic */ b(C0740a c0740a) {
                this();
            }

            public <T> void a(AsyncTask<T, ?, ?> asyncTask, T... tArr) {
                try {
                    asyncTask.executeOnExecutor(com.bytedance.sdk.component.oq.r.xt.f26666j, tArr);
                } catch (Throwable unused) {
                }
            }
        }

        @TargetApi(11)
        private static class c extends b {
            private c() {
                super(null);
            }

            /* synthetic */ c(C0740a c0740a) {
                this();
            }

            @Override // com.ss.android.downloadlib.a.q.b
            public <T> void a(AsyncTask<T, ?, ?> asyncTask, T... tArr) {
                try {
                    asyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, tArr);
                } catch (Throwable unused) {
                }
            }
        }

        public static <T> void a(AsyncTask<T, ?, ?> asyncTask, T... tArr) {
            f37592a.a(asyncTask, tArr);
        }
    }

    @Override // s2.a
    public s2.a j(String str) {
        com.ss.android.downloadlib.addownload.m.k(str);
        return this;
    }

    public class f {
        public static boolean a(Context context, String str) {
            return m.e(context, str);
        }

        public static o.b b(Context context, Uri uri) {
            return m.i(context, uri);
        }

        public static o.b c(Context context, o.i iVar, String str) {
            return m.k(context, iVar, str);
        }

        public static o.b d(Context context, String str) {
            return m.l(context, str);
        }

        public static o.b e(Context context, String str, com.ss.android.xt.j.xt.a aVar) {
            return m.m(context, str, aVar);
        }

        public static o.b f(@NonNull com.ss.android.xt.j.xt.b bVar, String str, String str2) {
            return m.o(bVar, str, str2);
        }

        public static o.b g(String str) {
            return i(com.ss.android.downloadlib.addownload.m.getContext(), str);
        }

        public static o.b h(String str, @NonNull com.ss.android.xt.j.xt.a aVar) {
            return m.K(str, aVar);
        }

        public static o.b i(Context context, String str) {
            return m.J(context, str);
        }
    }

    public class k {
        public static void b(String str) {
            a(null, str, null);
        }

        public static void c(String str, String str2) {
            a(str, str2, null);
        }

        public static void a(String str, String str2, JSONObject jSONObject) {
            com.ss.android.downloadlib.addownload.m.g();
        }

        public static void d(String str, String str2, JSONObject jSONObject) {
            com.ss.android.downloadlib.addownload.m.g();
        }

        public static void e(String str, String str2, JSONObject jSONObject) {
            com.ss.android.downloadlib.addownload.m.g();
        }
    }

    @Override // s2.a
    public s2.a j(@NonNull y yVar) {
        com.ss.android.downloadlib.addownload.m.t(yVar);
        com.ss.android.socialbase.downloader.j.j.j().j(new C0731a(yVar));
        return this;
    }

    a() {
    }

    @Override // s2.a
    public s2.a a(w2.k kVar) {
        com.ss.android.downloadlib.addownload.m.o(kVar);
        return this;
    }

    @Override // s2.a
    public s2.a b(tl tlVar) {
        if (tlVar.x() == null) {
            tlVar.j(new b());
        }
        tlVar.j(new b.e());
        ae.j(tlVar, true);
        return this;
    }

    @Override // s2.a
    public s2.a c(@NonNull w2.g gVar) {
        com.ss.android.downloadlib.addownload.m.n(gVar);
        return this;
    }

    @Override // s2.a
    public s2.a d(@NonNull com.ss.android.j.j.up.b bVar) {
        com.ss.android.downloadlib.addownload.m.j(bVar);
        return this;
    }

    @Override // s2.a
    public s2.a e(x2.a aVar) {
        com.ss.android.socialbase.appdownloader.f.L().A(aVar);
        return this;
    }

    @Override // s2.a
    public s2.a f(@NonNull w2.n nVar) {
        com.ss.android.downloadlib.addownload.m.p(nVar);
        return this;
    }

    @Override // s2.a
    public s2.a g(@NonNull w2.a aVar) {
        com.ss.android.downloadlib.addownload.m.m(aVar);
        return this;
    }

    @Override // s2.a
    public s2.a h(w2.o oVar) {
        com.ss.android.downloadlib.addownload.m.q(oVar);
        return this;
    }

    @Override // s2.a
    public s2.a i(@NonNull w wVar) {
        com.ss.android.downloadlib.addownload.m.s(wVar);
        return this;
    }

    @Override // s2.a
    public s2.a k(@NonNull u uVar) {
        com.ss.android.downloadlib.addownload.m.r(uVar);
        return this;
    }

    @Override // s2.a
    public s2.a l(x2.d dVar) {
        com.ss.android.downloadlib.addownload.m.u(dVar);
        return this;
    }

    @Override // s2.a
    public void j() {
        if (!com.ss.android.downloadlib.addownload.m.J()) {
            com.ss.android.downloadlib.up.a.a().c("ttdownloader init error");
        }
        com.ss.android.downloadlib.addownload.m.l(com.ss.android.downloadlib.up.a.a());
        try {
            com.ss.android.socialbase.appdownloader.f.L().Z(com.ss.android.downloadlib.addownload.m.F());
        } catch (Exception e6) {
            vl.j(e6);
        }
        com.ss.android.socialbase.appdownloader.f.L().y(com.ss.android.downloadlib.d.d());
        com.ss.android.downloadlib.e.c().k(new c());
    }
}
