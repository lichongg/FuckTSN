package cn.bluemobi.dylan.uncaughtexception;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import cat.ereza.customactivityoncrash.R;
import cn.bluemobi.dylan.uncaughtexception.activity.DefaultErrorActivity;
import com.stub.StubApp;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.io.StringWriter;
import java.lang.Thread;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.zip.ZipFile;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SuppressLint({"NewApi"})
/* loaded from: D:\Downloads\app\classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static final String f1405a = "cat.ereza.customactivityoncrash.ERROR";

    /* renamed from: b, reason: collision with root package name */
    private static final String f1406b = "cat.ereza.customactivityoncrash.RESTART";

    /* renamed from: c, reason: collision with root package name */
    private static Application f1407c;

    /* renamed from: d, reason: collision with root package name */
    private static WeakReference<Activity> f1408d = new WeakReference<>(null);

    /* renamed from: e, reason: collision with root package name */
    private static boolean f1409e = false;

    /* renamed from: f, reason: collision with root package name */
    private static boolean f1410f = true;

    /* renamed from: g, reason: collision with root package name */
    private static boolean f1411g = true;

    /* renamed from: h, reason: collision with root package name */
    private static boolean f1412h = true;

    /* renamed from: i, reason: collision with root package name */
    private static int f1413i = R.drawable.customactivityoncrash_error_image;

    /* renamed from: j, reason: collision with root package name */
    private static Class<? extends Activity> f1414j = null;

    /* renamed from: k, reason: collision with root package name */
    private static Class<? extends Activity> f1415k = null;

    /* renamed from: l, reason: collision with root package name */
    private static boolean f1416l = true;

    /* renamed from: m, reason: collision with root package name */
    private static String[] f1417m;

    /* renamed from: n, reason: collision with root package name */
    private static String f1418n;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: cn.bluemobi.dylan.uncaughtexception.a$a, reason: collision with other inner class name */
    static class C0019a implements Thread.UncaughtExceptionHandler {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f1419a;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: cn.bluemobi.dylan.uncaughtexception.a$a$a, reason: collision with other inner class name */
        class C0020a extends Thread {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Throwable f1420a;

            C0020a(Throwable th) {
                this.f1420a = th;
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                super.run();
                StringWriter stringWriter = new StringWriter();
                this.f1420a.printStackTrace(new PrintWriter(stringWriter));
                String stringWriter2 = stringWriter.toString();
                if (stringWriter2.length() > 131071) {
                    stringWriter2 = stringWriter2.substring(0, 131047) + " [stack trace too large]";
                }
                if (!TextUtils.isEmpty(a.D())) {
                    a.X(a.D(), "{ \"msgtype\": \"text\", \"text\": {\"content\": \"" + a.v(C0019a.this.f1419a, stringWriter2) + "\"}}");
                }
                j.b.a(a.y(C0019a.this.f1419a), a.v(C0019a.this.f1419a, stringWriter2));
                a.W();
                System.exit(0);
            }
        }

        C0019a(Context context) {
            this.f1419a = context;
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(Thread thread, Throwable th) {
            if (!a.f1416l) {
                new C0020a(th).start();
                return;
            }
            if (a.f1414j == null) {
                Class unused = a.f1414j = a.O(a.f1407c);
            }
            if (!a.V(th, a.f1414j) && (a.f1410f || !a.f1409e)) {
                Intent intent = new Intent(a.f1407c, (Class<?>) a.f1414j);
                StringWriter stringWriter = new StringWriter();
                th.printStackTrace(new PrintWriter(stringWriter));
                String stringWriter2 = stringWriter.toString();
                if (stringWriter2.length() > 131071) {
                    stringWriter2 = stringWriter2.substring(0, 131047) + " [stack trace too large]";
                }
                if (a.f1412h && a.f1415k == null) {
                    Class unused2 = a.f1415k = a.P(a.f1407c);
                } else if (!a.f1412h) {
                    Class unused3 = a.f1415k = null;
                }
                intent.putExtra("cat.ereza.customactivityoncrash.EXTRA_STACK_TRACE", stringWriter2);
                intent.putExtra("cat.ereza.customactivityoncrash.EXTRA_RESTART_ACTIVITY_CLASS", a.f1415k);
                intent.putExtra("cat.ereza.customactivityoncrash.EXTRA_SHOW_ERROR_DETAILS", a.f1411g);
                intent.putExtra("cat.ereza.customactivityoncrash.EXTRA_IMAGE_DRAWABLE_ID", a.f1413i);
                intent.setFlags(268468224);
                a.f1407c.startActivity(intent);
            }
            Activity activity = (Activity) a.f1408d.get();
            if (activity != null) {
                activity.finish();
                a.f1408d.clear();
            }
            a.W();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class b implements Application.ActivityLifecycleCallbacks {

        /* renamed from: a, reason: collision with root package name */
        int f1422a = 0;

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            int i6 = this.f1422a + 1;
            this.f1422a = i6;
            boolean unused = a.f1409e = i6 == 0;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            int i6 = this.f1422a - 1;
            this.f1422a = i6;
            boolean unused = a.f1409e = i6 == 0;
        }

        b() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            if (activity.getClass() != a.f1414j) {
                WeakReference unused = a.f1408d = new WeakReference(activity);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }
    }

    public static String y(Context context) {
        PackageManager packageManager;
        ApplicationInfo applicationInfo = null;
        try {
            packageManager = context.getPackageManager();
            try {
                applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException unused) {
            }
        } catch (PackageManager.NameNotFoundException unused2) {
            packageManager = null;
        }
        return (String) packageManager.getApplicationLabel(applicationInfo);
    }

    public static int A() {
        return f1413i;
    }

    public static int B(Intent intent) {
        return intent.getIntExtra("cat.ereza.customactivityoncrash.EXTRA_IMAGE_DRAWABLE_ID", R.drawable.customactivityoncrash_error_image);
    }

    private static String C() {
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        if (str2.startsWith(str)) {
            return t(str2);
        }
        return t(str) + " " + str2;
    }

    public static String D() {
        return f1418n;
    }

    public static String[] E() {
        return f1417m;
    }

    public static Class<? extends Activity> F() {
        return f1414j;
    }

    private static Class<? extends Activity> G(Context context) {
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(new Intent().setAction(f1405a).setPackage(context.getPackageName()), 64);
        if (queryIntentActivities == null || queryIntentActivities.size() <= 0) {
            return null;
        }
        try {
            return Class.forName(queryIntentActivities.get(0).activityInfo.name);
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public static Class<? extends Activity> I() {
        return f1415k;
    }

    public static Class<? extends Activity> J(Intent intent) {
        Serializable serializableExtra = intent.getSerializableExtra("cat.ereza.customactivityoncrash.EXTRA_RESTART_ACTIVITY_CLASS");
        if (serializableExtra == null || !(serializableExtra instanceof Class)) {
            return null;
        }
        return (Class) serializableExtra;
    }

    private static Class<? extends Activity> K(Context context) {
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(new Intent().setAction(f1406b).setPackage(context.getPackageName()), 64);
        if (queryIntentActivities == null || queryIntentActivities.size() <= 0) {
            return null;
        }
        try {
            return Class.forName(queryIntentActivities.get(0).activityInfo.name);
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public static String L(Intent intent) {
        return intent.getStringExtra("cat.ereza.customactivityoncrash.EXTRA_STACK_TRACE");
    }

    private static String M() {
        return Arrays.toString(Build.SUPPORTED_ABIS);
    }

    public static void Q(Context context) {
        if (context == null) {
            return;
        }
        try {
            Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
            if (defaultUncaughtExceptionHandler == null || !defaultUncaughtExceptionHandler.getClass().getName().startsWith(h.a.f43020b)) {
                if (defaultUncaughtExceptionHandler != null) {
                    defaultUncaughtExceptionHandler.getClass().getName().startsWith("com.android.internal.os");
                }
                f1407c = (Application) StubApp.getOrigApplicationContext(context.getApplicationContext());
                Thread.setDefaultUncaughtExceptionHandler(new C0019a(context));
                f1407c.registerActivityLifecycleCallbacks(new b());
            }
        } catch (Throwable unused) {
        }
    }

    public static boolean R() {
        return f1412h;
    }

    public static boolean S() {
        return f1410f;
    }

    public static boolean T() {
        return f1411g;
    }

    public static boolean U(Intent intent) {
        return intent.getBooleanExtra("cat.ereza.customactivityoncrash.EXTRA_SHOW_ERROR_DETAILS", true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void X(String str, String str2) {
        try {
            System.out.getClass();
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.setReadTimeout(5000);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setInstanceFollowRedirects(true);
            httpURLConnection.setRequestProperty("Content-Type", "application/json");
            httpURLConnection.connect();
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            dataOutputStream.write(str2.getBytes());
            dataOutputStream.flush();
            dataOutputStream.close();
            if (httpURLConnection.getResponseCode() == 200) {
                i0(httpURLConnection.getInputStream());
                System.out.getClass();
            } else {
                System.out.getClass();
            }
            httpURLConnection.disconnect();
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public static void Z(boolean z5) {
        f1416l = z5;
    }

    public static void b0(String str) {
        f1418n = str;
    }

    public static void c0(String[] strArr) {
        f1417m = strArr;
    }

    public static String i0(InputStream inputStream) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    byteArrayOutputStream.close();
                    inputStream.close();
                    return new String(byteArrayOutputStream.toByteArray());
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
        } catch (Exception e6) {
            e6.printStackTrace();
            return null;
        }
    }

    private static String t(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        char charAt = str.charAt(0);
        if (Character.isUpperCase(charAt)) {
            return str;
        }
        return Character.toUpperCase(charAt) + str.substring(1);
    }

    public static String v(Context context, String str) {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
        String x5 = x(context, simpleDateFormat);
        String N = N(context);
        return ((((((("ApplicationName: " + y(context) + " \n") + "Build version: " + N + " \n") + "Build date: " + x5 + " \n") + "Current date: " + simpleDateFormat.format(date) + " \n") + "Device: " + C() + " \n") + "SupportedAbis: " + M() + " \n\n") + "Stack trace:  \n") + str;
    }

    public static String w(Context context, Intent intent) {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
        String x5 = x(context, simpleDateFormat);
        String N = N(context);
        return ((((((("ApplicationName: " + y(context) + " \n") + "Build version: " + N + " \n") + "Build date: " + x5 + " \n") + "Current date: " + simpleDateFormat.format(date) + " \n") + "Device: " + C() + " \n") + "SupportedAbis: " + M() + " \n\n") + "Stack trace:  \n") + L(intent);
    }

    private static Class<? extends Activity> H(Context context) {
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
        if (launchIntentForPackage != null) {
            try {
                return Class.forName(launchIntentForPackage.getComponent().getClassName());
            } catch (ClassNotFoundException unused) {
                return null;
            }
        }
        return null;
    }

    private static String N(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception unused) {
            return "Unknown";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Class<? extends Activity> O(Context context) {
        Class<? extends Activity> G = G(context);
        if (G == null) {
            return DefaultErrorActivity.class;
        }
        return G;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Class<? extends Activity> P(Context context) {
        Class<? extends Activity> K = K(context);
        if (K == null) {
            return H(context);
        }
        return K;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean V(Throwable th, Class<? extends Activity> cls) {
        do {
            for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                if ((stackTraceElement.getClassName().equals("android.app.ActivityThread") && stackTraceElement.getMethodName().equals("handleBindApplication")) || stackTraceElement.getClassName().equals(cls.getName())) {
                    return true;
                }
            }
            th = th.getCause();
        } while (th != null);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void W() {
        Process.killProcess(Process.myPid());
        System.exit(10);
    }

    public static void Y(Activity activity, Intent intent) {
        intent.addFlags(268468224);
        activity.finish();
        activity.startActivity(intent);
        W();
    }

    public static void u(Activity activity) {
        activity.finish();
        W();
    }

    public static String x(Context context, DateFormat dateFormat) {
        long j6;
        try {
            j6 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).lastUpdateTime;
        } catch (PackageManager.NameNotFoundException e6) {
            e6.printStackTrace();
            j6 = 0;
        }
        return dateFormat.format(new Date(j6));
    }

    private static String z(Context context, DateFormat dateFormat) {
        try {
            ZipFile zipFile = new ZipFile(context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).sourceDir);
            String format = dateFormat.format(new Date(zipFile.getEntry("classes.dex").getTime()));
            zipFile.close();
            return format;
        } catch (Exception unused) {
            return "Unknown";
        }
    }

    public static void a0(int i6) {
    }

    public static void d0(boolean z5) {
    }

    public static void e0(Class<? extends Activity> cls) {
    }

    public static void f0(boolean z5) {
    }

    public static void g0(Class<? extends Activity> cls) {
    }

    public static void h0(boolean z5) {
    }
}
