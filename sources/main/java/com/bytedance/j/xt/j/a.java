package com.bytedance.j.xt.j;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.j.xt.a;
import com.bytedance.j.xt.cw;
import com.bytedance.j.xt.tl.h;
import com.bytedance.j.xt.tl.i;
import com.bytedance.j.xt.tl.k;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.api.plugin.xt;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.hms.framework.common.hianalytics.WiseOpenHianalyticsData;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public class a {

    /* renamed from: g, reason: collision with root package name */
    static volatile boolean f24198g = true;

    /* renamed from: a, reason: collision with root package name */
    private b f24199a;

    /* renamed from: b, reason: collision with root package name */
    private d f24200b;

    /* renamed from: c, reason: collision with root package name */
    private final Context f24201c;

    /* renamed from: d, reason: collision with root package name */
    private volatile long f24202d;

    /* renamed from: e, reason: collision with root package name */
    private volatile boolean f24203e = false;

    /* renamed from: f, reason: collision with root package name */
    private final SharedPreferences f24204f;

    private Object[] f(BufferedReader bufferedReader, Pattern... patternArr) throws IOException {
        if (bufferedReader != null && patternArr != null && patternArr.length > 0) {
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    for (Pattern pattern : patternArr) {
                        if (pattern.matcher(readLine).matches()) {
                            return new Object[]{pattern, readLine};
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        }
        return null;
    }

    boolean e(int i6, String str, int i7) {
        JSONObject jSONObject;
        JSONObject b6;
        try {
            jSONObject = e.b(f24198g);
        } catch (Throwable th) {
            vl.j(th);
            jSONObject = null;
        }
        String a6 = e.a(this.f24201c, i7);
        if (TextUtils.isEmpty(a6)) {
            return false;
        }
        try {
            com.bytedance.j.xt.c f6 = com.bytedance.j.xt.e.l().f();
            if (f6 != null) {
                if (f6.j()) {
                    if (i6 == 200 && (b6 = b(str, Process.myPid(), this.f24201c.getPackageName())) != null && b6.length() > 0) {
                        jSONObject = b6;
                    }
                    if (jSONObject != null && jSONObject.length() > 0) {
                        try {
                            jSONObject.put("pid", Process.myPid());
                            jSONObject.put(WiseOpenHianalyticsData.UNION_PACKAGE, this.f24201c.getPackageName());
                            jSONObject.put("is_remote_process", 0);
                            com.bytedance.j.xt.cw.b bVar = new com.bytedance.j.xt.cw.b(new JSONObject());
                            bVar.l("data", jSONObject.toString());
                            bVar.l("is_anr", 1);
                            bVar.l("timestamp", Long.valueOf(System.currentTimeMillis()));
                            bVar.l("event_type", "anr");
                            bVar.l("anr_time", Long.valueOf(System.currentTimeMillis()));
                            bVar.l("crash_time", Long.valueOf(System.currentTimeMillis()));
                            bVar.l("anr_info", a6);
                            com.bytedance.j.xt.up.j.f c6 = com.bytedance.j.xt.up.j.f.c();
                            cw cwVar = cw.ANR;
                            com.bytedance.j.xt.cw.b a7 = c6.a(cwVar, bVar);
                            k.e(this.f24201c, cwVar.j(), null);
                            a.d.b().d(a7.k());
                            d(a6);
                        } catch (Throwable th2) {
                            i.c(th2);
                        }
                    }
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    private String a(BufferedReader bufferedReader) throws IOException {
        if (bufferedReader == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null || readLine.trim().length() <= 0) {
                break;
            }
            sb.append(readLine);
            sb.append(com.snail.antifake.deviceid.e.f37542d);
        }
        return sb.toString();
    }

    public JSONObject b(String str, int i6, String str2) {
        BufferedReader bufferedReader;
        int i7;
        BufferedReader bufferedReader2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(str);
        if (!file.exists() || !file.canRead()) {
            return null;
        }
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
        } catch (Exception e6) {
            e = e6;
            bufferedReader = null;
        } catch (Throwable th) {
            th = th;
            h.a(bufferedReader2);
            throw th;
        }
        try {
            try {
                Pattern compile = Pattern.compile("-{5}\\spid\\s\\d+\\sat\\s\\d+-\\d+-\\d+\\s\\d{2}:\\d{2}:\\d{2}\\s-{5}");
                Pattern compile2 = Pattern.compile("-{5}\\send\\s\\d+\\s-{5}");
                Pattern compile3 = Pattern.compile("Cmd\\sline:\\s(\\S+)");
                Pattern compile4 = Pattern.compile("\".+\"\\s(daemon\\s){0,1}prio=\\d+\\stid=\\d+\\s.*");
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
                Object[] f6 = f(bufferedReader, compile);
                if (f6 == null) {
                    h.a(bufferedReader);
                    return null;
                }
                long parseLong = Long.parseLong(f6[1].toString().split("\\s")[2]);
                long time = simpleDateFormat.parse(f6[1].toString().split("\\s")[4] + " " + f6[1].toString().split("\\s")[5]).getTime();
                Object[] f7 = f(bufferedReader, compile3);
                if (f7 == null) {
                    h.a(bufferedReader);
                    return null;
                }
                String str3 = f7[1].toString().split("\\s")[2];
                int i8 = 1;
                if (parseLong == i6 && str3.equalsIgnoreCase(str2)) {
                    if (this.f24202d != 0 && Math.abs(this.f24202d - time) < 20000) {
                        h.a(bufferedReader);
                        return null;
                    }
                    this.f24202d = time;
                    SharedPreferences sharedPreferences = this.f24204f;
                    if (sharedPreferences != null) {
                        sharedPreferences.edit().putLong("trace_anr_happen_time", this.f24202d).apply();
                    }
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("anrTime", time);
                    while (true) {
                        Pattern[] patternArr = new Pattern[2];
                        patternArr[0] = compile2;
                        patternArr[i8] = compile4;
                        Object[] f8 = f(bufferedReader, patternArr);
                        if (f8 == null || f8[0] != compile4) {
                            break;
                        }
                        Matcher matcher = Pattern.compile("\".+\"").matcher(f8[i8].toString());
                        String substring = matcher.find() ? matcher.group().substring(i8, matcher.group().length() - i8) : "";
                        Matcher matcher2 = Pattern.compile("tid=\\d+").matcher(f8[1].toString());
                        if (matcher2.find()) {
                            String group = matcher2.group();
                            i7 = Integer.parseInt(group.substring(group.indexOf(ContainerUtils.KEY_VALUE_DELIMITER) + 1));
                        } else {
                            i7 = -1;
                        }
                        String a6 = a(bufferedReader);
                        if (i7 != -1 && !TextUtils.isEmpty(substring) && !TextUtils.isEmpty(a6) && substring.equalsIgnoreCase("main")) {
                            jSONObject.put("mainStackFromTrace", a6);
                            jSONObject.put("thread_number", 1);
                            h.a(bufferedReader);
                            return jSONObject;
                        }
                        i8 = 1;
                    }
                    h.a(bufferedReader);
                    return null;
                }
                h.a(bufferedReader);
                return null;
            } catch (Throwable th2) {
                th = th2;
                bufferedReader2 = bufferedReader;
                h.a(bufferedReader2);
                throw th;
            }
        } catch (Exception e7) {
            e = e7;
            vl.j(e);
            h.a(bufferedReader);
            return null;
        }
    }

    public void c() {
        if (this.f24203e) {
            return;
        }
        this.f24200b = new d(this);
        this.f24203e = true;
    }

    public a(Context context) {
        if (context != null && (context instanceof Application)) {
            this.f24201c = context;
            SharedPreferences xt = xt.xt(context, "anr_monitor_table", 0);
            this.f24204f = xt;
            this.f24202d = xt.getLong("trace_anr_happen_time", 0L);
            return;
        }
        throw new IllegalArgumentException("context must not be null or not application");
    }

    private static void d(String str) {
        Iterator<Object> it = com.bytedance.j.xt.e.l().a().iterator();
        while (it.hasNext()) {
            it.next();
            cw cwVar = cw.ANR;
        }
    }
}
