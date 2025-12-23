package cn.jiguang.bo;

import android.content.Context;
import cn.jiguang.api.ReportCallBack;
import cn.jiguang.bp.i;
import java.io.File;
import java.io.FilenameFilter;
import java.lang.Thread;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes2.dex */
public class h implements Thread.UncaughtExceptionHandler {

    /* renamed from: a, reason: collision with root package name */
    private static h f2422a = new h();

    /* renamed from: c, reason: collision with root package name */
    private String f2424c;

    /* renamed from: b, reason: collision with root package name */
    private Thread.UncaughtExceptionHandler f2423b = null;

    /* renamed from: d, reason: collision with root package name */
    private g f2425d = new g();

    /* JADX INFO: Access modifiers changed from: private */
    public String c() {
        return "sentry" + File.separator + cn.jiguang.bz.f.a() + ".envelope";
    }

    public static h a() {
        return f2422a;
    }

    private Throwable b(Thread thread, Throwable th) {
        cn.jiguang.bp.c cVar = new cn.jiguang.bp.c();
        cVar.a(Boolean.FALSE);
        cVar.a("UncaughtExceptionHandler");
        return new c(cVar, th, thread);
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        cn.jiguang.bb.f.c("SentryCrashHandler", "uncaughtException");
        a(b(thread, th));
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f2423b;
        if (uncaughtExceptionHandler == this || uncaughtExceptionHandler == null) {
            return;
        }
        uncaughtExceptionHandler.uncaughtException(thread, th);
    }

    private h() {
    }

    public void b() {
        cn.jiguang.bb.f.c("SentryCrashHandler", "setUncaughtExceptionHandler");
        if (this.f2423b == null) {
            this.f2423b = Thread.getDefaultUncaughtExceptionHandler();
        }
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    private JSONObject a(Context context, Throwable th) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", "sentry_crash_log");
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject2 = new JSONObject();
            JSONObject a6 = d.a(context, th);
            if (a6 != null && a6.length() != 0) {
                jSONObject2.put("sentry_envelope_item_header", d.a("event"));
                jSONObject2.put("sentry_envelope_item", a6);
                jSONArray.put(jSONObject2);
                jSONObject.put("sentry_envelope_header", d.a(true));
                JSONObject jSONObject3 = new JSONObject();
                cn.jiguang.bp.i a7 = this.f2425d.a();
                a7.a(i.a.Crashed, "", true);
                jSONObject3.put("sentry_envelope_item_header", d.a(com.umeng.analytics.pro.d.aC));
                jSONObject3.put("sentry_envelope_item", d.a(context, a7));
                jSONArray.put(jSONObject3);
                jSONObject.put("sentry_envelope_items", jSONArray);
                return jSONObject;
            }
            return null;
        } catch (Throwable th2) {
            cn.jiguang.bb.f.l("SentryCrashHandler", "generalJSONLog error : " + th2.getMessage());
            return null;
        }
    }

    public void b(final Context context) {
        cn.jiguang.by.d.a("DELAY_TASK", new cn.jiguang.by.b() { // from class: cn.jiguang.bo.h.2
            @Override // cn.jiguang.by.b
            public void a() {
                File file = new File(context.getFilesDir().getAbsolutePath() + File.separator + "sentry");
                if (file.exists() && file.isDirectory() && file.canWrite() && file.canRead()) {
                    for (File file2 : file.listFiles(new FilenameFilter() { // from class: cn.jiguang.bo.h.2.1
                        @Override // java.io.FilenameFilter
                        public boolean accept(File file3, String str) {
                            return str.endsWith(".envelope");
                        }
                    })) {
                        String str = "sentry" + File.separator + file2.getName();
                        JSONObject a6 = cn.jiguang.bz.j.a(str);
                        if (a6 != null) {
                            h.this.a(context, a6, str);
                        }
                    }
                }
            }
        }, 10000);
    }

    public void a(final Context context) {
        cn.jiguang.bb.f.c("SentryCrashHandler", "init");
        this.f2425d.b();
        cn.jiguang.by.d.a("FUTURE_TASK", new cn.jiguang.by.b() { // from class: cn.jiguang.bo.h.1
            @Override // cn.jiguang.by.b
            public void a() {
                try {
                    cn.jiguang.bp.i a6 = h.this.f2425d.a();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("sentry_envelope_header", d.a(false));
                    JSONArray jSONArray = new JSONArray();
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("sentry_envelope_item_header", d.a(com.umeng.analytics.pro.d.aC));
                    jSONObject2.put("sentry_envelope_item", d.a(context, a6));
                    jSONArray.put(jSONObject2);
                    jSONObject.put("sentry_envelope_items", jSONArray);
                    jSONObject.put("type", "sentry_crash_log");
                    cn.jiguang.bb.f.c("SentryCrashHandler", "session is " + jSONObject.toString());
                    h hVar = h.this;
                    hVar.f2424c = hVar.c();
                    cn.jiguang.bz.j.a(h.this.f2424c, jSONObject);
                    h hVar2 = h.this;
                    hVar2.a(context, jSONObject, hVar2.f2424c);
                } catch (Throwable unused) {
                }
            }
        });
    }

    public void a(final Context context, final JSONObject jSONObject, final String str) {
        if (context == null) {
            cn.jiguang.bb.f.i("SentryCrashHandler", "Action - reportCrashLog context is null");
            return;
        }
        if (cn.jiguang.d.b.a(context)) {
            try {
                cn.jiguang.by.d.a("FUTURE_TASK", new cn.jiguang.by.b() { // from class: cn.jiguang.bo.h.3
                    @Override // cn.jiguang.by.b
                    public void a() {
                        cn.jiguang.bd.f.a(context, jSONObject, new ReportCallBack() { // from class: cn.jiguang.bo.h.3.1
                            @Override // cn.jiguang.api.ReportCallBack
                            public void onFinish(int i6) {
                                if (i6 == 0) {
                                    cn.jiguang.bz.j.d(str);
                                }
                            }
                        });
                    }
                });
            } catch (Throwable th) {
                cn.jiguang.bb.f.l("SentryCrashHandler", "report crash e:" + th);
            }
        }
    }

    public void a(Thread thread, Throwable th) {
        cn.jiguang.bb.f.c("SentryCrashHandler", "handleException catch exception");
        a(th);
    }

    public void a(Throwable th) {
        Context a6 = cn.jiguang.bz.d.a(null);
        if (a6 == null) {
            cn.jiguang.bb.f.i("SentryCrashHandler", "handleException context is null");
            return;
        }
        d.b(a6, th);
        if (i.a()) {
            try {
                JSONObject a7 = a(a6, th);
                if (a7 == null) {
                    return;
                }
                cn.jiguang.bb.f.c("SentryCrashHandler", "crash log is : " + a7.toString());
                String c6 = c();
                this.f2424c = c6;
                cn.jiguang.bz.j.a(c6, a7);
                a(a6, a7, this.f2424c);
            } catch (Throwable unused) {
            }
        }
    }
}
