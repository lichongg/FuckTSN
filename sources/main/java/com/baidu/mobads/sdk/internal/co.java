package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.baidu.mobads.sdk.api.IXAdContainerFactory;
import com.stub.StubApp;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class co implements Thread.UncaughtExceptionHandler {

    /* renamed from: a, reason: collision with root package name */
    public static String f10913a = "";

    /* renamed from: b, reason: collision with root package name */
    private static final String f10914b = "remote";

    /* renamed from: c, reason: collision with root package name */
    private static final String f10915c = "proxy";

    /* renamed from: d, reason: collision with root package name */
    private static final String f10916d = "third-mtj";

    /* renamed from: e, reason: collision with root package name */
    private static final String f10917e = "third-cpu";

    /* renamed from: f, reason: collision with root package name */
    private static final String f10918f = "third-cpu-cyber";

    /* renamed from: g, reason: collision with root package name */
    private static final String f10919g = "third-novel";

    /* renamed from: h, reason: collision with root package name */
    private static final String f10920h = "third-aigc";

    /* renamed from: i, reason: collision with root package name */
    private static final String f10921i = "third-aigc-virtual";

    /* renamed from: j, reason: collision with root package name */
    private static final String f10922j = "third-aigc-speech";

    /* renamed from: k, reason: collision with root package name */
    private static final String f10923k = "third-aigc-image";

    /* renamed from: l, reason: collision with root package name */
    private static Thread.UncaughtExceptionHandler f10924l = null;

    /* renamed from: m, reason: collision with root package name */
    private static volatile co f10925m = null;

    /* renamed from: p, reason: collision with root package name */
    private static final String f10926p = "key_crash_source";

    /* renamed from: q, reason: collision with root package name */
    private static final String f10927q = "key_crash_trace";

    /* renamed from: r, reason: collision with root package name */
    private static final String f10928r = "key_crash_ad";

    /* renamed from: n, reason: collision with root package name */
    private Context f10929n;

    /* renamed from: o, reason: collision with root package name */
    private a f10930o;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    interface a {
        void a(String str);
    }

    public void c() {
        this.f10930o = null;
    }

    private List<String> d() {
        IXAdContainerFactory c6;
        ArrayList arrayList = new ArrayList();
        try {
            aa a6 = aa.a();
            if (a6 != null && (c6 = a6.c()) != null) {
                Object remoteParam = c6.getRemoteParam("appCommonConfig", "getCrashPackage");
                if (remoteParam instanceof List) {
                    arrayList.addAll((List) remoteParam);
                }
            }
        } catch (Throwable unused) {
        }
        return arrayList;
    }

    private SharedPreferences e() {
        return this.f10929n.getSharedPreferences("baidu_mobads_crash", 0);
    }

    public void b() {
        if (Thread.getDefaultUncaughtExceptionHandler() instanceof co) {
            return;
        }
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    private co(Context context) {
        this.f10929n = StubApp.getOrigApplicationContext(context.getApplicationContext());
        f10924l = Thread.getDefaultUncaughtExceptionHandler();
    }

    public static co a(Context context) {
        if (f10925m == null) {
            synchronized (co.class) {
                try {
                    if (f10925m == null) {
                        f10925m = new co(context);
                    }
                } finally {
                }
            }
        }
        return f10925m;
    }

    private SharedPreferences.Editor f() {
        return e().edit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        SharedPreferences.Editor f6 = f();
        f6.clear();
        f6.apply();
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        try {
            String a6 = a(th);
            if (a6 != null) {
                a(a6, Log.getStackTraceString(th));
                a aVar = this.f10930o;
                if (aVar != null) {
                    aVar.a(a6);
                }
            }
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = f10924l;
            if (uncaughtExceptionHandler != null) {
                uncaughtExceptionHandler.uncaughtException(thread, th);
            }
        } catch (Exception e6) {
            bu.a().c(e6);
        }
    }

    public void a() {
        be.a().a((j) new cp(this));
    }

    public void a(a aVar) {
        this.f10930o = aVar;
    }

    private String a(Throwable th) {
        Throwable cause = th.getCause();
        if (cause != null) {
            th = cause;
        }
        StackTraceElement[] stackTrace = th.getStackTrace();
        if (stackTrace != null && stackTrace.length > 0) {
            List<String> d6 = d();
            for (StackTraceElement stackTraceElement : stackTrace) {
                String className = stackTraceElement.getClassName();
                if (className.startsWith("junit.framework")) {
                    return null;
                }
                if (className.startsWith(z.as) || className.startsWith(z.at) || className.startsWith(z.au)) {
                    return f10914b;
                }
                if (!className.startsWith(z.av) && !className.startsWith(z.aw) && !className.startsWith(z.ax)) {
                    if (className.startsWith(z.ay)) {
                        return f10916d;
                    }
                    if (className.startsWith(z.az)) {
                        return f10917e;
                    }
                    if (className.startsWith(z.aA) || className.startsWith(z.aB)) {
                        return f10918f;
                    }
                    if (className.startsWith(z.aJ)) {
                        return f10922j;
                    }
                    if (!className.startsWith(z.aF) && !className.startsWith(z.aG) && !className.startsWith(z.aH) && !className.startsWith(z.aI)) {
                        if (className.startsWith(z.aE)) {
                            return f10920h;
                        }
                        if (!className.startsWith(z.aC) && !className.startsWith(z.aD)) {
                            if (a(className, d6)) {
                                return f10914b;
                            }
                            if (className.startsWith(z.aK)) {
                                return f10923k;
                            }
                        } else if (cn.f10910g.booleanValue()) {
                            return f10919g;
                        }
                    } else {
                        return f10921i;
                    }
                } else {
                    return f10915c;
                }
            }
        }
        return null;
    }

    private boolean a(String str, List<String> list) {
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (str.startsWith(it.next())) {
                return true;
            }
        }
        return false;
    }

    public void a(String str, String str2) {
        SharedPreferences.Editor f6 = f();
        String str3 = "crashtime:" + System.currentTimeMillis() + " ";
        f6.putString(f10926p, str);
        f6.putString(f10927q, str3 + str2);
        f6.putString(f10928r, f10913a);
        f6.commit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(String str) {
        return e().getString(str, "");
    }
}
