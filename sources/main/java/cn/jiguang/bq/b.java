package cn.jiguang.bq;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jiguang.bb.f;
import cn.jiguang.bg.c;
import cn.jiguang.bi.g;
import cn.jiguang.bi.h;
import cn.jiguang.bt.i;
import cn.jiguang.bz.d;
import cn.jiguang.bz.j;
import cn.jiguang.bz.y;
import cn.jiguang.net.HttpRequest;
import cn.jiguang.net.HttpResponse;
import com.tencent.connect.common.Constants;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes2.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static long f2511a = 314572800;

    /* renamed from: b, reason: collision with root package name */
    public static long f2512b = 7000;

    /* renamed from: c, reason: collision with root package name */
    public static long f2513c = 104857600;

    /* renamed from: d, reason: collision with root package name */
    public static long f2514d = 3000;

    /* renamed from: e, reason: collision with root package name */
    public static String f2515e = "sync_net_monitor";

    /* renamed from: f, reason: collision with root package name */
    private JSONObject f2516f;

    /* renamed from: g, reason: collision with root package name */
    private long f2517g;

    /* renamed from: h, reason: collision with root package name */
    private long f2518h;

    /* renamed from: i, reason: collision with root package name */
    private long f2519i;

    /* renamed from: j, reason: collision with root package name */
    private long f2520j;

    /* renamed from: k, reason: collision with root package name */
    private long f2521k;

    /* renamed from: l, reason: collision with root package name */
    private long f2522l;

    /* renamed from: m, reason: collision with root package name */
    private Context f2523m;

    /* renamed from: n, reason: collision with root package name */
    private Boolean f2524n;

    /* renamed from: o, reason: collision with root package name */
    private long f2525o;

    /* renamed from: p, reason: collision with root package name */
    private long f2526p;

    /* renamed from: q, reason: collision with root package name */
    private long f2527q;

    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        private static final b f2531a = new b();
    }

    private b() {
        this.f2526p = 0L;
        this.f2527q = 3000L;
        this.f2523m = d.a();
        a(false);
    }

    private long a(String str, String str2) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(simpleDateFormat.parse(str));
            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTime(simpleDateFormat.parse(str2));
            return (calendar.getTimeInMillis() - calendar2.getTimeInMillis()) / 86400000;
        } catch (Exception unused) {
            return Long.MAX_VALUE;
        }
    }

    private String c(String str) {
        return str.contains("wi/cjc4sa") ? "1" : str.contains("wi/d8n3hj") ? "2" : str.contains("v1/status") ? "3" : str.contains("tsis") ? "4" : str.contains("ali-stats") ? "6" : str.contains("gd-stats") ? "7" : str.contains("stats") ? "5" : str.contains("v1/version-check") ? "8" : str.contains("wi/plp8j0k") ? "9" : str.contains("wi/spoml") ? Constants.VIA_REPORT_TYPE_SHARE_TO_QQ : str.contains("qiniup") ? Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE : str.contains("1/getEvent") ? Constants.VIA_REPORT_TYPE_SET_AVATAR : str.contains("1/setUserInfo") ? Constants.VIA_REPORT_TYPE_JOININ_GROUP : str.contains("1/setChannel") ? Constants.VIA_REPORT_TYPE_MAKE_FRIEND : str.contains("1/updateUserProperties") ? Constants.VIA_REPORT_TYPE_WPA_STATE : str.contains("1/switcUserProperties") ? Constants.VIA_REPORT_TYPE_START_WAP : str.contains("v1/user") ? Constants.VIA_REPORT_TYPE_START_GROUP : str.contains("wi/qj18op") ? "18" : str.contains("wi/op8jdu") ? Constants.VIA_ACT_TYPE_NINETEEN : str.contains("v1/reqtime") ? "20" : str.contains("appgwc/status") ? "21" : str.contains("appawake/status") ? Constants.VIA_REPORT_TYPE_DATALINE : str.contains("jx/6ae71c") ? Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR : str.contains("wi/swelbv") ? Constants.VIA_REPORT_TYPE_CHAT_AIO : str.contains("wi/ysdiox") ? Constants.VIA_REPORT_TYPE_CHAT_AUDIO : str.startsWith(master.flame.danmaku.danmaku.parser.b.f50154a) ? Constants.DEFAULT_UIN : str;
    }

    private synchronized void h() {
        long longValue = ((Long) cn.jiguang.e.b.a(this.f2523m, cn.jiguang.e.a.y())).longValue();
        long j6 = this.f2525o;
        if (j6 > 0) {
            longValue = j6;
        }
        long a6 = y.a();
        if (longValue == 0 || longValue != a6) {
            f.i("NetDataMonitorManager", "checkCurrentDayTime saveCurrentDayTime " + longValue);
            f.i("NetDataMonitorManager", "checkCurrentDayTime currentDayTime " + a6);
            f.i("NetDataMonitorManager", "recover all data");
            this.f2519i = 0L;
            this.f2517g = 0L;
            this.f2518h = 0L;
            this.f2522l = 0L;
            this.f2520j = 0L;
            this.f2521k = 0L;
            cn.jiguang.e.b.a(this.f2523m, (cn.jiguang.e.a<?>[]) new cn.jiguang.e.a[]{cn.jiguang.e.a.y().a((cn.jiguang.e.a<Long>) Long.valueOf(a6))});
            this.f2525o = a6;
            cn.jiguang.e.b.a(this.f2523m, (cn.jiguang.e.a<?>[]) new cn.jiguang.e.a[]{cn.jiguang.e.a.t().a((cn.jiguang.e.a<Long>) Long.valueOf(this.f2519i))});
            cn.jiguang.e.b.a(this.f2523m, (cn.jiguang.e.a<?>[]) new cn.jiguang.e.a[]{cn.jiguang.e.a.u().a((cn.jiguang.e.a<Long>) Long.valueOf(this.f2518h))});
            cn.jiguang.e.b.a(this.f2523m, (cn.jiguang.e.a<?>[]) new cn.jiguang.e.a[]{cn.jiguang.e.a.s().a((cn.jiguang.e.a<Long>) Long.valueOf(this.f2517g))});
            cn.jiguang.e.b.a(this.f2523m, (cn.jiguang.e.a<?>[]) new cn.jiguang.e.a[]{cn.jiguang.e.a.w().a((cn.jiguang.e.a<Long>) Long.valueOf(this.f2522l))});
            cn.jiguang.e.b.a(this.f2523m, (cn.jiguang.e.a<?>[]) new cn.jiguang.e.a[]{cn.jiguang.e.a.x().a((cn.jiguang.e.a<Long>) Long.valueOf(this.f2521k))});
            cn.jiguang.e.b.a(this.f2523m, (cn.jiguang.e.a<?>[]) new cn.jiguang.e.a[]{cn.jiguang.e.a.v().a((cn.jiguang.e.a<Long>) Long.valueOf(this.f2520j))});
            this.f2516f = null;
            this.f2516f = e();
        }
    }

    public static b a() {
        return a.f2531a;
    }

    private void d() {
        cn.jiguang.by.d.a("FUTURE_TASK", new cn.jiguang.by.b() { // from class: cn.jiguang.bq.b.1
            @Override // cn.jiguang.by.b
            public void a() {
                try {
                    synchronized (b.class) {
                        try {
                            f.c("NetDataMonitorManager", "real start ");
                            JSONObject f6 = b.this.f();
                            f.c("NetDataMonitorManager", "start report lastJson: " + f6);
                            if (f6 != null && f6.has("data")) {
                                f.c("NetDataMonitorManager", "start report net data monitor");
                                cn.jiguang.be.b.a(b.this.f2523m, f6, "sdk_moniter");
                                cn.jiguang.e.b.a(b.this.f2523m, (cn.jiguang.e.a<?>[]) new cn.jiguang.e.a[]{cn.jiguang.e.a.e().a((cn.jiguang.e.a<Long>) Long.valueOf(System.currentTimeMillis()))});
                            }
                        } finally {
                        }
                    }
                } catch (Throwable th) {
                    f.i("NetDataMonitorManager", "save data error:" + th.getMessage());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject e() {
        try {
            if (this.f2516f == null) {
                this.f2516f = new JSONObject(a(this.f2523m, false));
            }
            return this.f2516f;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject f() {
        try {
            return new JSONObject(a(this.f2523m, true));
        } catch (Throwable unused) {
            return null;
        }
    }

    private void g() {
        if (this.f2519i > f2512b || this.f2518h + this.f2517g > f2511a) {
            StringBuilder sb = new StringBuilder();
            sb.append("check business count is more than COUNT= ");
            sb.append(this.f2519i > f2512b);
            f.i("NetDataMonitorManager", sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("check business data length is more than NET_LENGTH_THRESHOLD= ");
            sb2.append(this.f2518h + this.f2517g > f2511a);
            f.i("NetDataMonitorManager", sb2.toString());
            c();
            h.a().a(this.f2523m);
        }
        if (this.f2522l > f2514d || this.f2521k + this.f2520j > f2513c) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("check conn count is more than CONN_COUNT= ");
            sb3.append(this.f2522l > f2514d);
            f.i("NetDataMonitorManager", sb3.toString());
            StringBuilder sb4 = new StringBuilder();
            sb4.append("check conn data length is more than NET_CONN_LENGTH_THRESHOLD= ");
            sb4.append(this.f2521k + this.f2520j > f2513c);
            f.i("NetDataMonitorManager", sb4.toString());
            c();
            g.a().a(this.f2523m, "tcp_a23", null);
        }
    }

    public void b() {
        long longValue = ((Long) cn.jiguang.e.b.a(this.f2523m, cn.jiguang.e.a.e())).longValue();
        if (0 == longValue) {
            longValue = System.currentTimeMillis();
            cn.jiguang.e.b.a(this.f2523m, (cn.jiguang.e.a<?>[]) new cn.jiguang.e.a[]{cn.jiguang.e.a.e().a((cn.jiguang.e.a<Long>) Long.valueOf(longValue))});
        }
        f.c("NetDataMonitorManager", "lastReportTime " + longValue + " BuildConfig.INTERNAL_USE=false");
        long currentTimeMillis = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        sb.append(" currentTimestamp ");
        sb.append(currentTimeMillis);
        f.c("NetDataMonitorManager", sb.toString());
        if (currentTimeMillis - longValue < 86400000) {
            f.c("NetDataMonitorManager", "it not business time, interval: 86400000");
        } else {
            f.c("NetDataMonitorManager", "need to  report");
            d();
        }
    }

    private String a(Context context, boolean z5) {
        try {
            Calendar calendar = Calendar.getInstance();
            if (z5) {
                calendar.add(5, -1);
            }
            String format = new SimpleDateFormat("yyyyMMdd").format(calendar.getTime());
            return j.c(new File(new File(context.getFilesDir() + "/nes"), format + ".l"));
        } catch (Throwable th) {
            f.i("NetDataMonitorManager", "read Throwable " + th);
            return "";
        }
    }

    public void b(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            f.i("NetDataMonitorManager", "syncMessage json=" + jSONObject);
            long optLong = jSONObject.optLong("count");
            if (optLong > 0) {
                this.f2519i = optLong;
            }
            long optLong2 = jSONObject.optLong("res_l");
            if (optLong2 > 0) {
                this.f2518h = optLong2;
            }
            long optLong3 = jSONObject.optLong("req_l");
            if (optLong > 0) {
                this.f2517g = optLong3;
            }
            long optLong4 = jSONObject.optLong("count_th");
            if (optLong4 > 0) {
                f2512b = optLong4;
            }
            long optLong5 = jSONObject.optLong("l_th");
            if (optLong5 > 0) {
                f2511a = optLong5;
            }
            long optLong6 = jSONObject.optLong("conn_count");
            if (optLong6 > 0) {
                this.f2522l = optLong6;
            }
            long optLong7 = jSONObject.optLong("conn_res_l");
            if (optLong7 > 0) {
                this.f2521k = optLong7;
            }
            long optLong8 = jSONObject.optLong("conn_req_l");
            if (optLong8 > 0) {
                this.f2520j = optLong8;
            }
            long optLong9 = jSONObject.optLong("conn_count_th");
            if (optLong9 > 0) {
                f2514d = optLong9;
            }
            long optLong10 = jSONObject.optLong("conn_length_th");
            if (optLong10 > 0) {
                f2513c = optLong10;
            }
        } catch (Throwable unused) {
        }
    }

    public void c() {
        try {
            if (this.f2523m.getPackageName().equals(cn.jiguang.bz.a.a(this.f2523m))) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("count", this.f2519i);
            jSONObject.put("res_l", this.f2518h);
            jSONObject.put("req_l", this.f2517g);
            jSONObject.put("count_th", f2512b);
            jSONObject.put("l_th", f2511a);
            jSONObject.put("conn_count", this.f2522l);
            jSONObject.put("conn_res_l", this.f2521k);
            jSONObject.put("conn_req_l", this.f2520j);
            jSONObject.put("conn_count_th", f2514d);
            jSONObject.put("conn_length_th", f2513c);
            f.i("NetDataMonitorManager", "sendMessageToMain json=" + jSONObject);
            cn.jiguang.bz.a.b(this.f2523m, f2515e, jSONObject.toString());
        } catch (Throwable unused) {
        }
    }

    public void b(String str, String str2, long j6) {
        i iVar = new i(this.f2523m);
        iVar.a(str);
        iVar.b(str2);
        iVar.b(j6);
        iVar.c(1L);
        a(iVar);
    }

    public void c(String str, String str2, long j6) {
        i iVar = new i(this.f2523m);
        iVar.a(str);
        iVar.b(str2);
        iVar.a(j6);
        a(iVar);
    }

    public boolean b(Context context) {
        String str;
        int i6;
        if (!((Boolean) cn.jiguang.e.b.a(this.f2523m, cn.jiguang.e.a.n())).booleanValue()) {
            return true;
        }
        h();
        if (this.f2522l > f2514d) {
            str = "conn count is more than count: " + f2514d + ",so sdk limit";
            f.i("NetDataMonitorManager", str);
            i6 = 1409;
        } else {
            if (this.f2521k + this.f2520j <= f2513c) {
                return true;
            }
            str = "conn data length is more than data threshold: " + f2513c + ",so sdk limit";
            f.i("NetDataMonitorManager", str);
            i6 = 1410;
        }
        c.a.a(context, i6, str);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j6, long j7, long j8, String str) {
        StringBuilder sb;
        long j9;
        h();
        boolean z5 = System.currentTimeMillis() - this.f2526p >= this.f2527q;
        if (TextUtils.isEmpty(str) || !str.contains("conn")) {
            this.f2519i += j8;
            this.f2518h += j7;
            this.f2517g += j6;
            cn.jiguang.e.b.a(this.f2523m, (cn.jiguang.e.a<?>[]) new cn.jiguang.e.a[]{cn.jiguang.e.a.t().a((cn.jiguang.e.a<Long>) Long.valueOf(this.f2519i))});
            cn.jiguang.e.b.a(this.f2523m, (cn.jiguang.e.a<?>[]) new cn.jiguang.e.a[]{cn.jiguang.e.a.u().a((cn.jiguang.e.a<Long>) Long.valueOf(this.f2518h))});
            cn.jiguang.e.b.a(this.f2523m, (cn.jiguang.e.a<?>[]) new cn.jiguang.e.a[]{cn.jiguang.e.a.s().a((cn.jiguang.e.a<Long>) Long.valueOf(this.f2517g))});
            if (!z5) {
                return;
            }
            f.i("NetDataMonitorManager", "current data mAllReqLength, " + this.f2517g);
            f.i("NetDataMonitorManager", "current data mAllResLength, " + this.f2518h);
            sb = new StringBuilder();
            sb.append("current  mAllCount, ");
            j9 = this.f2519i;
        } else {
            this.f2522l += j8;
            this.f2520j += j6;
            this.f2521k += j7;
            cn.jiguang.e.b.a(this.f2523m, (cn.jiguang.e.a<?>[]) new cn.jiguang.e.a[]{cn.jiguang.e.a.w().a((cn.jiguang.e.a<Long>) Long.valueOf(this.f2522l))});
            cn.jiguang.e.b.a(this.f2523m, (cn.jiguang.e.a<?>[]) new cn.jiguang.e.a[]{cn.jiguang.e.a.x().a((cn.jiguang.e.a<Long>) Long.valueOf(this.f2521k))});
            cn.jiguang.e.b.a(this.f2523m, (cn.jiguang.e.a<?>[]) new cn.jiguang.e.a[]{cn.jiguang.e.a.v().a((cn.jiguang.e.a<Long>) Long.valueOf(this.f2520j))});
            if (!z5) {
                return;
            }
            f.i("NetDataMonitorManager", "current conn data mAllReqLength, " + this.f2520j);
            f.i("NetDataMonitorManager", "current conn data mAllResLength, " + this.f2521k);
            sb = new StringBuilder();
            sb.append("current conn mAllCount, ");
            j9 = this.f2522l;
        }
        sb.append(j9);
        f.i("NetDataMonitorManager", sb.toString());
        this.f2526p = System.currentTimeMillis();
        g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, JSONObject jSONObject) {
        try {
            File file = new File(context.getFilesDir() + "/nes");
            if (!file.exists()) {
                file.mkdirs();
            }
            String format = new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime());
            File file2 = new File(file, format + ".l");
            if (!file2.exists()) {
                file2.createNewFile();
            }
            j.b(file2, jSONObject != null ? jSONObject.toString() : "");
            File[] listFiles = file.listFiles();
            if (listFiles == null || listFiles.length <= 15) {
                return;
            }
            for (File file3 : listFiles) {
                if (a(format, file3.getName()) > 15) {
                    j.b(file3);
                }
            }
        } catch (IOException unused) {
        }
    }

    public void a(Bundle bundle) {
        try {
            String string = bundle.getString("url");
            long j6 = bundle.getLong("req");
            long j7 = bundle.getLong("res");
            String string2 = bundle.getString("type");
            i iVar = new i(this.f2523m);
            iVar.a(c(string));
            iVar.b(string2);
            iVar.b(j6);
            iVar.a(j7);
            iVar.c(1L);
            a(iVar);
        } catch (Throwable unused) {
        }
    }

    private void a(cn.jiguang.br.a aVar) {
        try {
            Bundle bundle = new Bundle();
            JSONObject b6 = aVar.b();
            if (!cn.jiguang.bz.a.b(this.f2523m)) {
                a().a(b6.toString());
            } else {
                bundle.putString("save_data", b6.toString());
                cn.jiguang.a.a.a(this.f2523m, "a12", bundle);
            }
        } catch (Throwable unused) {
        }
    }

    public void a(HttpRequest httpRequest, boolean z5) {
        String str;
        long j6;
        try {
            if (z5) {
                str = httpRequest.getUrl();
                j6 = httpRequest.getParas().length;
            } else {
                String[] split = httpRequest.getUrl().split(" \\?");
                String str2 = split[0];
                long length = split.length > 1 ? split[1].getBytes().length : -1L;
                str = str2;
                j6 = length;
            }
            b(c(str), httpRequest.getType(), j6);
        } catch (Throwable unused) {
        }
    }

    public void a(HttpRequest httpRequest, boolean z5, HttpResponse httpResponse) {
        c(c(z5 ? httpRequest.getUrl() : httpRequest.getUrl().split(" \\?")[0]), httpRequest.getType(), !TextUtils.isEmpty(httpResponse.getResponseBody()) ? httpResponse.getResponseBody().getBytes().length : 0L);
    }

    public synchronized void a(final String str) {
        if (((Boolean) cn.jiguang.e.b.a(this.f2523m, cn.jiguang.e.a.n())).booleanValue()) {
            cn.jiguang.by.d.a("FUTURE_TASK", new cn.jiguang.by.b() { // from class: cn.jiguang.bq.b.2
                /* JADX WARN: Removed duplicated region for block: B:15:0x0084 A[Catch: all -> 0x0069, TryCatch #1 {all -> 0x0069, blocks: (B:6:0x0005, B:8:0x0059, B:11:0x0062, B:13:0x007e, B:15:0x0084, B:19:0x00eb, B:20:0x008f, B:24:0x00a0, B:27:0x00a9, B:29:0x00cf, B:32:0x00d5, B:33:0x0103, B:34:0x011c, B:41:0x00f2, B:42:0x006c), top: B:5:0x0005, outer: #0 }] */
                /* JADX WARN: Removed duplicated region for block: B:40:0x00f2 A[SYNTHETIC] */
                @Override // cn.jiguang.by.b
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public void a() {
                    /*
                        Method dump skipped, instructions count: 316
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.bq.b.AnonymousClass2.a():void");
                }
            });
        }
    }

    public void a(String str, String str2, long j6) {
        i iVar = new i(this.f2523m);
        iVar.a(str);
        iVar.b(str2);
        iVar.a(j6);
        iVar.c(1L);
        a(iVar);
    }

    public void a(boolean z5) {
        if (((Boolean) cn.jiguang.e.b.a(this.f2523m, cn.jiguang.e.a.n())).booleanValue()) {
            if (z5 || this.f2524n == null) {
                this.f2524n = Boolean.TRUE;
                long longValue = ((Long) cn.jiguang.e.b.a(this.f2523m, cn.jiguang.e.a.o())).longValue();
                if (longValue > 0) {
                    f2512b = longValue;
                }
                long longValue2 = ((Long) cn.jiguang.e.b.a(this.f2523m, cn.jiguang.e.a.p())).longValue();
                if (longValue2 > 0) {
                    f2511a = longValue2;
                }
                long longValue3 = ((Long) cn.jiguang.e.b.a(this.f2523m, cn.jiguang.e.a.q())).longValue();
                if (longValue3 > 0) {
                    f2514d = longValue3;
                }
                long longValue4 = ((Long) cn.jiguang.e.b.a(this.f2523m, cn.jiguang.e.a.r())).longValue();
                if (longValue4 > 0) {
                    f2513c = longValue4;
                }
                f.c("NetDataMonitorManager", "use count=" + f2512b + " net threshold=" + f2511a);
                f.c("NetDataMonitorManager", "use conn count=" + f2514d + " net conn threshold=" + f2513c);
                this.f2519i = ((Long) cn.jiguang.e.b.a(this.f2523m, cn.jiguang.e.a.t())).longValue();
                this.f2517g = ((Long) cn.jiguang.e.b.a(this.f2523m, cn.jiguang.e.a.s())).longValue();
                this.f2518h = ((Long) cn.jiguang.e.b.a(this.f2523m, cn.jiguang.e.a.u())).longValue();
                this.f2522l = ((Long) cn.jiguang.e.b.a(this.f2523m, cn.jiguang.e.a.w())).longValue();
                this.f2520j = ((Long) cn.jiguang.e.b.a(this.f2523m, cn.jiguang.e.a.v())).longValue();
                this.f2521k = ((Long) cn.jiguang.e.b.a(this.f2523m, cn.jiguang.e.a.x())).longValue();
                f.c("NetDataMonitorManager", "init first mAllCount=" + this.f2519i + " mAllReqLength=" + this.f2517g + " mAllResLength=" + this.f2518h);
                f.c("NetDataMonitorManager", "init first conn mAllCount=" + this.f2522l + " mAllReqLength=" + this.f2520j + " mAllResLength=" + this.f2521k);
                h();
                c();
            }
        }
    }

    public boolean a(Context context) {
        StringBuilder sb;
        long j6;
        if (!((Boolean) cn.jiguang.e.b.a(this.f2523m, cn.jiguang.e.a.n())).booleanValue()) {
            return true;
        }
        h();
        if (this.f2519i > f2512b) {
            sb = new StringBuilder();
            sb.append("business count is more than count: ");
            j6 = f2512b;
        } else {
            if (this.f2518h + this.f2517g <= f2511a) {
                return true;
            }
            sb = new StringBuilder();
            sb.append("business data length is more than data threshold: ");
            j6 = f2511a;
        }
        sb.append(j6);
        sb.append(",so sdk limit");
        f.i("NetDataMonitorManager", sb.toString());
        return false;
    }
}
