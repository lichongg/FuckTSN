package cn.jiguang.b;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import cn.jiguang.bb.f;
import cn.jiguang.bz.d;
import cn.jiguang.bz.j;
import cn.jiguang.bz.o;
import cn.jiguang.bz.p;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread;
import java.util.regex.PatternSyntaxException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes2.dex */
public class a implements Thread.UncaughtExceptionHandler {

    /* renamed from: b, reason: collision with root package name */
    private static int f1872b = 1048576;

    /* renamed from: a, reason: collision with root package name */
    public boolean f1873a;

    /* renamed from: c, reason: collision with root package name */
    private Thread.UncaughtExceptionHandler f1874c;

    /* renamed from: d, reason: collision with root package name */
    private final Object f1875d;

    /* renamed from: cn.jiguang.b.a$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* renamed from: cn.jiguang.b.a$a, reason: collision with other inner class name */
    private static final class C0028a {

        /* renamed from: a, reason: collision with root package name */
        private static final a f1876a = new a(null);
    }

    private a() {
        this.f1874c = null;
        this.f1873a = true;
        this.f1875d = new Object();
        this.f1873a = f(d.a(null));
    }

    public static a a() {
        return C0028a.f1876a;
    }

    private String b(Throwable th) {
        String th2 = th.toString();
        try {
            String[] split = th2.split(":");
            if (split.length <= 1) {
                return th2;
            }
            for (int length = split.length - 1; length >= 0; length--) {
                if (!split[length].endsWith("Exception") && !split[length].endsWith("Error")) {
                }
                return split[length];
            }
            return th2;
        } catch (NullPointerException | PatternSyntaxException unused) {
            return th2;
        }
    }

    private static boolean f(Context context) {
        try {
            return context.getSharedPreferences("cn.jiguang.crash", 0).getBoolean("KEY_IS_INIT", true);
        } catch (Throwable unused) {
            return false;
        }
    }

    /* synthetic */ a(AnonymousClass1 anonymousClass1) {
        this();
    }

    private JSONArray a(Context context, Throwable th) {
        String e6 = j.e("jpush_uncaughtexception_file");
        JSONArray jSONArray = null;
        int i6 = 0;
        if (!TextUtils.isEmpty(e6)) {
            try {
                JSONArray jSONArray2 = new JSONArray(e6);
                try {
                    i6 = e6.length();
                } catch (JSONException unused) {
                }
                jSONArray = jSONArray2;
            } catch (JSONException unused2) {
            }
        }
        return a(context, jSONArray, i6, th);
    }

    public static JSONArray c(Context context) {
        return j.b("jpush_uncaughtexception_file");
    }

    public static void d(Context context) {
        j.d("jpush_uncaughtexception_file");
    }

    public void b() {
        if (this.f1874c == null) {
            this.f1874c = Thread.getDefaultUncaughtExceptionHandler();
        }
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    public void e(Context context) {
        if (context == null) {
            f.i("JPushCrashHandler", "Action - reportCrashLog context is null");
            return;
        }
        if (cn.jiguang.d.b.a(context)) {
            try {
                cn.jiguang.by.d.a("FUTURE_TASK", new b());
            } catch (Throwable th) {
                f.l("JPushCrashHandler", "report crash e:" + th);
            }
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        if (this.f1873a) {
            f.a("JPushCrashHandler", "enable crash report");
            a(th);
            try {
                cn.jiguang.by.d.a("FUTURE_TASK", new b());
                a(2000L);
            } catch (Throwable th2) {
                f.l("JPushCrashHandler", "report crash e:" + th2);
            }
        } else {
            f.a("JPushCrashHandler", "disable crash report");
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f1874c;
        if (uncaughtExceptionHandler == this || uncaughtExceptionHandler == null) {
            return;
        }
        uncaughtExceptionHandler.uncaughtException(thread, th);
    }

    private JSONArray a(Context context, JSONArray jSONArray, int i6, Throwable th) {
        JSONObject jSONObject;
        long currentTimeMillis = System.currentTimeMillis() + cn.jiguang.d.b.c(context);
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        String stringWriter2 = stringWriter.toString();
        if (jSONArray == null) {
            jSONArray = new JSONArray();
        }
        int i7 = 0;
        while (true) {
            try {
                if (i7 >= jSONArray.length()) {
                    jSONObject = null;
                    break;
                }
                jSONObject = jSONArray.optJSONObject(i7);
                if (jSONObject != null && stringWriter2.equals(jSONObject.getString("stacktrace"))) {
                    jSONObject.put("count", jSONObject.getInt("count") + 1);
                    jSONObject.put("crashtime", currentTimeMillis);
                    break;
                }
                i7++;
            } catch (Throwable unused) {
            }
        }
        if (jSONObject == null) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("crashtime", currentTimeMillis);
            jSONObject2.put("stacktrace", stringWriter2);
            jSONObject2.put(CrashHianalyticsData.MESSAGE, b(th));
            jSONObject2.put("count", 1);
            jSONObject2.put("networktype", o.c(context));
            PackageInfo a6 = p.a(context, 1);
            if (a6 != null) {
                String str = a6.versionName;
                if (str == null) {
                    str = "null";
                }
                String str2 = a6.versionCode + "";
                jSONObject2.put(com.umeng.analytics.pro.d.aF, str);
                jSONObject2.put("versioncode", str2);
            }
            if (i6 + jSONObject2.toString().length() < f1872b) {
                jSONArray.put(jSONObject2);
                return jSONArray;
            }
            long j6 = -1;
            int i8 = 0;
            for (int i9 = 0; i9 < jSONArray.length(); i9++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i9);
                if (optJSONObject != null) {
                    long optLong = optJSONObject.optLong("crashtime");
                    if (j6 == -1 || optLong < j6) {
                        i8 = i9;
                        j6 = optLong;
                    }
                }
            }
            jSONArray.put(i8, jSONObject2);
        }
        return jSONArray;
    }

    public void b(Context context) {
        if (this.f1873a) {
            f.c("JPushCrashHandler", "stop caughtException");
            this.f1873a = false;
            a(d.a(context), this.f1873a);
        }
    }

    public final void a(long j6) {
        synchronized (this.f1875d) {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                if (j6 < 0) {
                    throw new IllegalArgumentException("timeout value is negative");
                }
                if (j6 == 0) {
                    while (cn.jiguang.by.d.b("FUTURE_TASK")) {
                        this.f1875d.wait(0L);
                    }
                } else {
                    long j7 = 0;
                    while (cn.jiguang.by.d.b("FUTURE_TASK")) {
                        long j8 = j6 - j7;
                        if (j8 > 0) {
                            this.f1875d.wait(j8);
                            j7 = System.currentTimeMillis() - currentTimeMillis;
                        }
                    }
                }
            } finally {
            }
        }
    }

    public void a(Context context) {
        if (this.f1873a) {
            return;
        }
        this.f1873a = true;
        f.c("JPushCrashHandler", "init caughtException");
        a(d.a(context), this.f1873a);
    }

    private static void a(Context context, boolean z5) {
        try {
            context.getSharedPreferences("cn.jiguang.crash", 0).edit().putBoolean("KEY_IS_INIT", z5).apply();
        } catch (Throwable unused) {
        }
    }

    private void a(Throwable th) {
        if (this.f1873a) {
            Context a6 = d.a(null);
            if (a6 != null) {
                j.a("jpush_uncaughtexception_file", a(a6, th));
            } else {
                f.l("JPushCrashHandler", "handleException failed: context is null");
            }
        }
    }
}
