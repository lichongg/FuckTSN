package com.qihoo.bugreport.javacrash;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.qihoo.jiagu.b;
import com.qihoo.jiagu.c;
import com.qihoo.jiagu.e;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.EnumMap;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Locale;
import master.flame.danmaku.danmaku.model.android.d;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes10.dex */
public class ExceptionHandleReporter implements Thread.UncaughtExceptionHandler {

    /* renamed from: a, reason: collision with root package name */
    private static ExceptionHandleReporter f36519a;

    /* renamed from: b, reason: collision with root package name */
    private final Thread.UncaughtExceptionHandler f36520b = Thread.getDefaultUncaughtExceptionHandler();

    /* renamed from: c, reason: collision with root package name */
    private final Context f36521c;

    /* renamed from: d, reason: collision with root package name */
    private final CrashReportDataFactory f36522d;

    /* renamed from: e, reason: collision with root package name */
    private final Thread.UncaughtExceptionHandler f36523e;

    private ExceptionHandleReporter(Context context, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.f36521c = context;
        this.f36523e = uncaughtExceptionHandler;
        this.f36522d = new CrashReportDataFactory(this.f36521c, new GregorianCalendar());
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    public static synchronized ExceptionHandleReporter a(Context context, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        ExceptionHandleReporter exceptionHandleReporter;
        synchronized (ExceptionHandleReporter.class) {
            if (f36519a == null) {
                f36519a = new ExceptionHandleReporter(context, uncaughtExceptionHandler);
            }
            exceptionHandleReporter = f36519a;
        }
        return exceptionHandleReporter;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        uncaughtException(thread, th, false, 0);
    }

    public void uncaughtException(Thread thread, Throwable th, boolean z5) {
        uncaughtException(thread, th, z5, 2);
    }

    public void uncaughtException(Thread thread, Throwable th, boolean z5, int i6) {
        boolean z6 = false;
        try {
            String[] strArr = b.f36533a;
            Context context = this.f36521c;
            int length = strArr.length;
            int i7 = 0;
            while (true) {
                if (i7 < length) {
                    if (!c.a(context, strArr[i7])) {
                        break;
                    } else {
                        i7++;
                    }
                } else {
                    z6 = true;
                    break;
                }
            }
            if (!z6) {
                a(thread, th, z5);
                return;
            }
            CrashReportDataFactory crashReportDataFactory = this.f36522d;
            EnumMap enumMap = new EnumMap(ReportField.class);
            enumMap.put((EnumMap) ReportField.t, (ReportField) "1");
            enumMap.put((EnumMap) ReportField.cpv, (ReportField) "3");
            enumMap.put((EnumMap) ReportField.st, (ReportField) CrashReportDataFactory.a(crashReportDataFactory.f36518a));
            enumMap.put((EnumMap) ReportField.ct, (ReportField) CrashReportDataFactory.a(new GregorianCalendar()));
            String name = th.getClass().getName();
            enumMap.put((EnumMap) ReportField.et, (ReportField) name);
            String message = th.getMessage();
            enumMap.put((EnumMap) ReportField.ec, (ReportField) message);
            enumMap.put((EnumMap) ReportField.jc, (ReportField) String.valueOf(i6));
            ArrayList<String> a6 = CrashReportDataFactory.a(th);
            String a7 = crashReportDataFactory.a(name, message, a6);
            if (a7 != null) {
                enumMap.put((EnumMap) ReportField.me, (ReportField) a7);
            }
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            th.printStackTrace(printWriter);
            String obj = stringWriter.toString();
            printWriter.close();
            String a8 = CrashReportDataFactory.a(obj);
            if (a8 == null) {
                enumMap.put((EnumMap) ReportField.crd, (ReportField) "null");
            } else {
                enumMap.put((EnumMap) ReportField.crd, (ReportField) a8);
            }
            String a9 = CrashReportDataFactory.a(obj, a6);
            if (a9 != null) {
                enumMap.put((EnumMap) ReportField.em, (ReportField) a9);
            }
            String c6 = CrashReportDataFactory.c();
            if (c6 != null) {
                enumMap.put((EnumMap) ReportField.ep, (ReportField) c6);
            }
            HashMap<String, String> a10 = CrashReportDataFactory.a();
            if (a10.get("ed") != null) {
                enumMap.put((EnumMap) ReportField.ed, (ReportField) a10.get("ed"));
            }
            if (a10.get("epd") != null) {
                enumMap.put((EnumMap) ReportField.epd, (ReportField) a10.get("epd"));
            }
            JSONObject a11 = c.a((EnumMap<ReportField, String>) enumMap, crashReportDataFactory.b());
            if (a11 == null) {
                a(thread, th, z5);
                return;
            }
            a11.toString();
            synchronized (ExceptionHandleReporter.class) {
                if (a(a11, th)) {
                    a(thread, th, z5);
                } else {
                    e eVar = new e(this, z5, a11);
                    eVar.start();
                    eVar.join(d.f50003r);
                    a(thread, th, z5);
                }
            }
        } catch (Throwable th2) {
            a(thread, th, z5);
        }
    }

    private synchronized boolean a(JSONObject jSONObject, Throwable th) {
        boolean z5;
        long time;
        if (!jSONObject.has(ReportField.me.name()) || !jSONObject.has(ReportField.ct.name())) {
            z5 = true;
        } else {
            SharedPreferences sharedPreferences = this.f36521c.getSharedPreferences("qihoo_jiagu_crash_report", 0);
            SharedPreferences.Editor edit = sharedPreferences.edit();
            String string = sharedPreferences.getString("last_report_me", "");
            String string2 = sharedPreferences.getString("last_report_time", "0000/00/00 00:00:00");
            String string3 = sharedPreferences.getString("last_exception_info", "");
            String num = Integer.toString(th.hashCode());
            try {
                String string4 = jSONObject.getString(ReportField.me.name());
                String string5 = jSONObject.getString(ReportField.ct.name());
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.ENGLISH);
                Date parse = simpleDateFormat.parse(string5);
                Date parse2 = simpleDateFormat.parse(string2);
                if (parse.getTime() - parse2.getTime() < 0) {
                    edit.putString("last_report_time", jSONObject.getString(ReportField.ct.name()));
                    edit.commit();
                    z5 = true;
                } else {
                    if (string.equals(string4) || num.equals(string3)) {
                        time = (parse.getTime() - parse2.getTime()) - TTAdConstant.AD_MAX_EVENT_TIME;
                    } else {
                        time = (parse.getTime() - parse2.getTime()) - 120000;
                    }
                    if (time < 0) {
                        z5 = true;
                    } else {
                        edit.putString("last_report_me", jSONObject.getString(ReportField.me.name()));
                        edit.putString("last_report_time", jSONObject.getString(ReportField.ct.name()));
                        edit.putString("last_exception_info", num);
                        edit.commit();
                        z5 = false;
                    }
                }
            } catch (ParseException e6) {
                z5 = true;
            } catch (JSONException e7) {
                z5 = true;
            }
        }
        return z5;
    }

    private void a(Thread thread, Throwable th, boolean z5) {
        if (!z5) {
            try {
                if (this.f36520b != null) {
                    this.f36520b.uncaughtException(thread, th);
                } else {
                    b(thread, th, z5);
                }
            } catch (Throwable th2) {
                b(thread, th, z5);
            }
        }
    }

    private void b(Thread thread, Throwable th, boolean z5) {
        if (!z5) {
            try {
                if (this.f36523e != null) {
                    this.f36523e.uncaughtException(thread, th);
                }
            } catch (Throwable th2) {
            }
        }
    }
}
