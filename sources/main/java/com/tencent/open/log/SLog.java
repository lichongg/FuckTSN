package com.tencent.open.log;

import android.os.Environment;
import android.text.TextUtils;
import com.tencent.connect.common.Constants;
import com.tencent.open.log.d;
import java.io.File;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class SLog implements TraceLevel {
    public static final String TAG = "openSDK_LOG";

    /* renamed from: c, reason: collision with root package name */
    private static boolean f40578c;
    public static SLog instance;

    /* renamed from: a, reason: collision with root package name */
    protected a f40579a;

    /* renamed from: b, reason: collision with root package name */
    private Tracer f40580b;

    private void d() {
        this.f40579a = new a(new b(a(), c.f40617m, c.f40611g, c.f40612h, c.f40607c, c.f40613i, 10, c.f40609e, c.f40618n));
    }

    public static final void e(String str, String str2) {
        getInstance().a(16, str, str2, null);
    }

    public static final void i(String str, String str2) {
        getInstance().a(4, str, str2, null);
    }

    public static final void u(String str, String str2) {
        getInstance().a(32, str, str2, null);
    }

    public static final void v(String str, String str2) {
        getInstance().a(1, str, str2, null);
    }

    public static final void w(String str, String str2) {
        getInstance().a(8, str, str2, null);
    }

    protected void a(int i6, String str, String str2, Throwable th) {
        if (f40578c) {
            String b6 = com.tencent.open.utils.g.b();
            if (!TextUtils.isEmpty(b6)) {
                String str3 = b6 + " SDK_VERSION:" + Constants.SDK_VERSION;
                if (this.f40579a == null) {
                    return;
                }
                e.f40623a.a(32, Thread.currentThread(), System.currentTimeMillis(), TAG, str3, null);
                this.f40579a.a(32, Thread.currentThread(), System.currentTimeMillis(), TAG, str3, null);
                f40578c = false;
            }
        }
        e.f40623a.a(i6, Thread.currentThread(), System.currentTimeMillis(), str, str2, th);
        if (d.a.a(c.f40606b, i6)) {
            a aVar = this.f40579a;
            if (aVar == null) {
                return;
            } else {
                aVar.a(i6, Thread.currentThread(), System.currentTimeMillis(), str, str2, th);
            }
        }
        Tracer tracer = this.f40580b;
        if (tracer != null) {
            try {
                tracer.a(i6, Thread.currentThread(), System.currentTimeMillis(), str, a(str2), th);
            } catch (Exception unused) {
            }
        }
    }

    public static final void e(String str, String str2, Throwable th) {
        getInstance().a(16, str, str2, th);
    }

    public static SLog getInstance() {
        if (instance == null) {
            synchronized (SLog.class) {
                try {
                    if (instance == null) {
                        SLog sLog = new SLog();
                        instance = sLog;
                        sLog.d();
                        f40578c = true;
                    }
                } finally {
                }
            }
        }
        return instance;
    }

    public static final void i(String str, String str2, Throwable th) {
        getInstance().a(4, str, str2, th);
    }

    public static void release() {
        synchronized (SLog.class) {
            try {
                getInstance().b();
                if (instance != null) {
                    instance = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static final void u(String str, String str2, Throwable th) {
        getInstance().a(32, str, str2, th);
    }

    public static final void v(String str, String str2, Throwable th) {
        getInstance().a(1, str, str2, th);
    }

    public static final void w(String str, String str2, Throwable th) {
        getInstance().a(8, str, str2, th);
    }

    protected void b() {
        a aVar = this.f40579a;
        if (aVar != null) {
            aVar.a();
            this.f40579a.b();
            this.f40579a = null;
        }
    }

    protected void c() {
        a aVar = this.f40579a;
        if (aVar != null) {
            aVar.a();
        }
    }

    public void setCustomLogger(Tracer tracer) {
        this.f40580b = tracer;
    }

    private SLog() {
    }

    public static final void d(String str, String str2) {
        getInstance().a(2, str, str2, null);
    }

    public static void flushLogs() {
        getInstance().c();
    }

    public static final void d(String str, String str2, Throwable th) {
        getInstance().a(2, str, str2, th);
    }

    private String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return d.a(str) ? "xxxxxx" : str;
    }

    protected static File a() {
        String str = c.f40608d;
        try {
            d.c b6 = d.b.b();
            if (b6 != null && b6.c() > c.f40610f) {
                return new File(Environment.getExternalStorageDirectory(), str);
            }
            return new File(com.tencent.open.utils.g.c(), str);
        } catch (Throwable th) {
            e(TAG, "getLogFilePath:", th);
            return null;
        }
    }
}
