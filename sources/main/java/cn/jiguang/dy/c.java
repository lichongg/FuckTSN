package cn.jiguang.dy;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Process;
import android.text.TextUtils;
import cn.jiguang.az.f;
import cn.jiguang.az.g;
import cn.jiguang.az.j;
import cn.jiguang.internal.JConstants;
import com.umeng.analytics.pro.d;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes2.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private Boolean f2918a;

    /* renamed from: b, reason: collision with root package name */
    private Boolean f2919b;

    /* renamed from: c, reason: collision with root package name */
    private Boolean f2920c;

    /* renamed from: d, reason: collision with root package name */
    private SharedPreferences f2921d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f2922e;

    /* renamed from: cn.jiguang.dy.c$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        private static final c f2923a = new c(null);
    }

    private c() {
        this.f2920c = Boolean.TRUE;
        try {
            Class.forName("cn.jiguang.dy.FileLocker");
            this.f2920c = FileLocker.fileLock;
        } catch (Throwable unused) {
            cn.jiguang.ay.b.e("PluginAnalytics", "FileLocker not exist");
        }
    }

    public static c a() {
        return a.f2923a;
    }

    public void b(Context context) {
        f(context).edit().putLong("plugin_report_time_", System.currentTimeMillis()).apply();
    }

    public boolean c(Context context) {
        long j6 = f(context).getLong("plugin_report_time_", 0L);
        boolean z5 = j6 <= 0 || System.currentTimeMillis() > f(context).getLong("plugin_report_interval_", 86400000L) + j6;
        if (!z5) {
            cn.jiguang.ay.b.b("PluginAnalytics", "no need report, last is " + cn.jiguang.az.b.a(j6));
        }
        return z5;
    }

    /* synthetic */ c(AnonymousClass1 anonymousClass1) {
        this();
    }

    private boolean c(Context context, boolean z5) {
        boolean z6 = f(context).getBoolean("first_" + z5, true);
        if (z6) {
            this.f2922e = true;
            f(context).edit().putBoolean("first_" + z5, false).apply();
        }
        return z6;
    }

    private SharedPreferences f(Context context) {
        if (this.f2921d == null) {
            this.f2921d = context.getSharedPreferences("cn.jiguang.prefs", 0);
        }
        return this.f2921d;
    }

    private void g(Context context) {
        String str;
        String str2;
        try {
            cn.jiguang.ay.b.b("PluginAnalytics", "[reportNow]:" + System.currentTimeMillis());
            File file = new File(cn.jiguang.az.c.a(context), "dy_analysis");
            if (file.exists()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null && listFiles.length != 0) {
                    for (File file2 : listFiles) {
                        try {
                            if (!file2.getName().endsWith(".tmp")) {
                                cn.jiguang.ay.b.b("PluginAnalytics", "read event from file:" + file2.getAbsolutePath());
                                String a6 = cn.jiguang.az.c.a(file2);
                                if (!TextUtils.isEmpty(a6)) {
                                    JSONObject jSONObject = new JSONObject();
                                    jSONObject.put("itime", System.currentTimeMillis());
                                    jSONObject.put("type", "sdk_stat");
                                    jSONObject.put(d.ax, new JSONArray(a6));
                                    f.a(context, JConstants.SDK_TYPE, 14, null, null, jSONObject.toString());
                                    cn.jiguang.az.c.a(file2, "");
                                }
                            }
                        } catch (Throwable th) {
                            cn.jiguang.ay.b.b("PluginAnalytics", "report file failed:" + th.getMessage());
                        }
                    }
                    synchronized (this.f2920c) {
                        try {
                            for (File file3 : listFiles) {
                                try {
                                    String name = file3.getName();
                                    if (name.endsWith(".tmp")) {
                                        file3.renameTo(new File(file3.getParentFile(), name.substring(0, name.length() - 4)));
                                    }
                                } catch (Throwable th2) {
                                    cn.jiguang.ay.b.b("PluginAnalytics", "report file failed:" + th2.getMessage());
                                }
                            }
                            b(context);
                        } finally {
                        }
                    }
                    return;
                }
                str = "PluginAnalytics";
                str2 = "not found child event file to report";
            } else {
                str = "PluginAnalytics";
                str2 = "no event file to report";
            }
            cn.jiguang.ay.b.b(str, str2);
        } catch (Throwable th3) {
            cn.jiguang.ay.b.g("PluginAnalytics", "report analysis error:" + th3.getMessage());
        }
    }

    private List<cn.jiguang.aw.b> h(Context context) {
        ArrayList arrayList = null;
        try {
            cn.jiguang.ay.b.b("PluginAnalytics", "loadObjects start");
            String a6 = cn.jiguang.az.c.a(context, (!c(context) || this.f2922e) ? i(context) : i(context) + ".tmp");
            if (TextUtils.isEmpty(a6)) {
                return null;
            }
            ArrayList arrayList2 = new ArrayList();
            try {
                try {
                    JSONArray jSONArray = new JSONArray(a6);
                    for (int i6 = 0; i6 < jSONArray.length(); i6++) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i6);
                        cn.jiguang.aw.b bVar = new cn.jiguang.aw.b();
                        bVar.a(jSONObject);
                        arrayList2.add(bVar);
                    }
                } catch (Throwable unused) {
                    cn.jiguang.az.c.a(context, i(context), "");
                }
                return arrayList2;
            } catch (Throwable th) {
                th = th;
                arrayList = arrayList2;
                cn.jiguang.ay.b.e("PluginAnalytics", "[loadObjects] failed:" + th.getMessage());
                cn.jiguang.az.c.a(context, i(context), "");
                return arrayList;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public void a(Context context) {
        try {
            cn.jiguang.ay.b.b("PluginAnalytics", "will [report]");
            if (d(context)) {
                a(context, null, 1);
            } else {
                cn.jiguang.ay.b.b("PluginAnalytics", "need not report");
            }
        } catch (Throwable th) {
            cn.jiguang.ay.b.b("PluginAnalytics", "[report] failed:" + th.getMessage());
        }
    }

    public void b(Context context, boolean z5) {
        cn.jiguang.ay.b.b("PluginAnalytics", "[setMultiProcessOpen] enable:" + z5);
        this.f2919b = Boolean.valueOf(z5);
        f(context).edit().putBoolean("multi_process", z5).apply();
    }

    private boolean d(Context context) {
        c(context, g.b(context));
        boolean z5 = f(context).getBoolean("plugin_report_switch", false);
        if (z5) {
            return z5;
        }
        Boolean bool = this.f2918a;
        if (bool != null) {
            return bool.booleanValue();
        }
        Boolean valueOf = Boolean.valueOf(f(context).getBoolean("need_report", false));
        this.f2918a = valueOf;
        return valueOf.booleanValue();
    }

    private boolean e(Context context) {
        boolean z5 = f(context).getBoolean("plugin_multi_switch", false);
        if (z5) {
            return z5;
        }
        Boolean bool = this.f2919b;
        if (bool != null) {
            return bool.booleanValue();
        }
        Boolean valueOf = Boolean.valueOf(f(context).getBoolean("multi_process", false));
        this.f2919b = valueOf;
        return valueOf.booleanValue();
    }

    private String i(Context context) {
        String d6 = j.d(g.a(context));
        if (TextUtils.isEmpty(d6)) {
            return "dy_analysis" + File.separator + Process.myPid();
        }
        return "dy_analysis" + File.separator + d6;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0058, code lost:
    
        r1.c();
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x002e A[Catch: all -> 0x002a, TryCatch #1 {all -> 0x002a, blocks: (B:3:0x0002, B:5:0x0008, B:10:0x001e, B:13:0x0026, B:17:0x002e, B:19:0x0039, B:22:0x0040, B:24:0x0058, B:25:0x0068, B:28:0x005e, B:31:0x0065), top: B:2:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(android.content.Context r4, int r5, int r6, cn.jiguang.aw.a r7, int r8, java.lang.String r9) {
        /*
            r3 = this;
            java.lang.String r0 = "PluginAnalytics"
            boolean r1 = r3.d(r4)     // Catch: java.lang.Throwable -> L2a
            if (r1 == 0) goto L6d
            r1 = 4
            java.lang.String r1 = cn.jiguang.av.a.a(r5, r1)     // Catch: java.lang.Throwable -> L2a
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> L2a
            if (r2 != 0) goto L18
            int r1 = java.lang.Integer.parseInt(r1)     // Catch: java.lang.Throwable -> L18
            goto L1b
        L18:
            r1 = 2147483647(0x7fffffff, float:NaN)
        L1b:
            r2 = 1
            if (r6 > r1) goto L2c
            int r1 = r7.f1800k     // Catch: java.lang.Throwable -> L2a
            int r1 = r1 / 1000
            if (r1 != r2) goto L2c
            java.lang.String r4 = "no plugin ,need not save event"
        L26:
            cn.jiguang.ay.b.b(r0, r4)     // Catch: java.lang.Throwable -> L2a
            goto L88
        L2a:
            r4 = move-exception
            goto L70
        L2c:
            if (r7 == 0) goto L88
            cn.jiguang.aw.b r1 = new cn.jiguang.aw.b     // Catch: java.lang.Throwable -> L2a
            r1.<init>(r4, r7, r5, r6)     // Catch: java.lang.Throwable -> L2a
            boolean r5 = r1.b()     // Catch: java.lang.Throwable -> L2a
            if (r5 == 0) goto L56
            boolean r5 = r3.e(r4)     // Catch: java.lang.Throwable -> L2a
            if (r5 == 0) goto L40
            goto L56
        L40:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L2a
            r4.<init>()     // Catch: java.lang.Throwable -> L2a
            java.lang.String r5 = "need not save event in sub process:"
            r4.append(r5)     // Catch: java.lang.Throwable -> L2a
            java.lang.String r5 = r1.f()     // Catch: java.lang.Throwable -> L2a
            r4.append(r5)     // Catch: java.lang.Throwable -> L2a
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L2a
            goto L26
        L56:
            if (r8 != 0) goto L5c
            r1.c()     // Catch: java.lang.Throwable -> L2a
            goto L68
        L5c:
            if (r8 != r2) goto L62
            r1.d()     // Catch: java.lang.Throwable -> L2a
            goto L68
        L62:
            r5 = 2
            if (r8 != r5) goto L68
            r1.a(r9)     // Catch: java.lang.Throwable -> L2a
        L68:
            r5 = 0
            r3.a(r4, r1, r5)     // Catch: java.lang.Throwable -> L2a
            goto L88
        L6d:
            java.lang.String r4 = "need not save event"
            goto L26
        L70:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "onEvent:"
            r5.append(r6)
            java.lang.String r4 = r4.getMessage()
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            cn.jiguang.ay.b.b(r0, r4)
        L88:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.dy.c.a(android.content.Context, int, int, cn.jiguang.aw.a, int, java.lang.String):void");
    }

    private void a(Context context, cn.jiguang.aw.b bVar, int i6) {
        if (context == null) {
            return;
        }
        try {
            if (i6 == 0 && bVar == null) {
                cn.jiguang.ay.b.e("PluginAnalytics", "save event info is null");
                return;
            }
            if (i6 == 1) {
                if (this.f2922e) {
                    cn.jiguang.ay.b.b("PluginAnalytics", "first need not report");
                    return;
                } else {
                    if (c(context)) {
                        g(context);
                        return;
                    }
                    return;
                }
            }
            synchronized (this.f2920c) {
                try {
                    List<cn.jiguang.aw.b> h6 = h(context);
                    if (h6 == null) {
                        h6 = new ArrayList<>();
                    }
                    cn.jiguang.ay.b.b("PluginAnalytics", "will save event info:" + bVar.e());
                    if (h6.contains(bVar)) {
                        cn.jiguang.aw.b bVar2 = h6.get(h6.indexOf(bVar));
                        bVar2.a(bVar);
                        cn.jiguang.ay.b.b("PluginAnalytics", "just update,need not add:" + bVar2.e());
                    } else {
                        h6.add(bVar);
                    }
                    if (h6.size() >= 200) {
                        h6.remove(0);
                    }
                    a(context, h6);
                } finally {
                }
            }
        } catch (Throwable th) {
            cn.jiguang.ay.b.e("PluginAnalytics", "saveAction failed:" + th.getMessage());
        }
    }

    private void a(Context context, List<cn.jiguang.aw.b> list) {
        try {
            JSONArray jSONArray = new JSONArray();
            for (int i6 = 0; i6 < list.size(); i6++) {
                jSONArray.put(new JSONObject(list.get(i6).e()));
            }
            cn.jiguang.az.c.a(context, (!c(context) || this.f2922e) ? i(context) : i(context) + ".tmp", jSONArray.toString());
            cn.jiguang.ay.b.b("PluginAnalytics", "saveObjects finished");
        } catch (Throwable th) {
            cn.jiguang.ay.b.e("PluginAnalytics", "[saveObjects] failed:" + th.getMessage());
        }
    }

    public void a(Context context, boolean z5) {
        cn.jiguang.ay.b.b("PluginAnalytics", "[setNeedReport] enable:" + z5);
        this.f2918a = Boolean.valueOf(z5);
        f(context).edit().putBoolean("need_report", z5).apply();
    }
}
