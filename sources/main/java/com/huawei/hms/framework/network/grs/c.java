package com.huawei.hms.framework.network.grs;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.bn;
import com.huawei.hms.framework.common.ExecutorsUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.network.grs.g.g;
import com.huawei.hms.framework.network.grs.g.h;
import com.stub.StubApp;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class c {

    /* renamed from: i, reason: collision with root package name */
    private static final String f33409i = "c";

    /* renamed from: j, reason: collision with root package name */
    private static final ExecutorService f33410j = ExecutorsUtils.newSingleThreadExecutor("GRS_GrsClient-Init");

    /* renamed from: k, reason: collision with root package name */
    private static long f33411k = 0;

    /* renamed from: a, reason: collision with root package name */
    private GrsBaseInfo f33412a;

    /* renamed from: b, reason: collision with root package name */
    private Context f33413b;

    /* renamed from: c, reason: collision with root package name */
    private g f33414c;

    /* renamed from: d, reason: collision with root package name */
    private o1.a f33415d;

    /* renamed from: e, reason: collision with root package name */
    private o1.c f33416e;

    /* renamed from: f, reason: collision with root package name */
    private o1.c f33417f;

    /* renamed from: g, reason: collision with root package name */
    private com.huawei.hms.framework.network.grs.a f33418g;

    /* renamed from: h, reason: collision with root package name */
    private FutureTask<Boolean> f33419h;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements Callable<Boolean> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f33420a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ GrsBaseInfo f33421b;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Boolean call() {
            c.this.f33414c = new g();
            c.this.f33416e = new o1.c(this.f33420a, GrsApp.getInstance().getBrand("_") + "share_pre_grs_conf_");
            c.this.f33417f = new o1.c(this.f33420a, GrsApp.getInstance().getBrand("_") + "share_pre_grs_services_");
            c cVar = c.this;
            cVar.f33415d = new o1.a(cVar.f33416e, c.this.f33417f, c.this.f33414c);
            c cVar2 = c.this;
            cVar2.f33418g = new com.huawei.hms.framework.network.grs.a(cVar2.f33412a, c.this.f33415d, c.this.f33414c, c.this.f33417f);
            if (com.huawei.hms.framework.network.grs.f.b.a(this.f33420a.getPackageName()) == null) {
                new com.huawei.hms.framework.network.grs.f.b(this.f33420a, true);
            }
            String d6 = new q1.c(this.f33421b, this.f33420a).d();
            Logger.v(c.f33409i, "scan serviceSet is: " + d6);
            String a6 = c.this.f33417f.a("services", "");
            String a7 = h.a(a6, d6);
            if (!TextUtils.isEmpty(a7)) {
                c.this.f33417f.f("services", a7);
                Logger.i(c.f33409i, "postList is:" + StringUtils.anonymizeMessage(a7));
                Logger.d(c.f33409i, "currentServices:" + StringUtils.anonymizeMessage(a6));
                if (!a7.equals(a6)) {
                    c.this.f33414c.f(c.this.f33412a.getGrsParasKey(true, true, this.f33420a));
                    c.this.f33414c.h(new q1.c(this.f33421b, this.f33420a), null, null, c.this.f33417f, c.this.f33412a.getQueryTimeout());
                }
            }
            long elapsedRealtime = SystemClock.elapsedRealtime() - c.f33411k;
            if (c.f33411k == 0 || TimeUnit.MILLISECONDS.toHours(elapsedRealtime) > 24) {
                Logger.i(c.f33409i, "Try to clear unUsed sp data.");
                long unused = c.f33411k = SystemClock.elapsedRealtime();
                c cVar3 = c.this;
                cVar3.n(cVar3.f33416e.b());
            }
            c.this.f33415d.h(this.f33421b, this.f33420a);
            return Boolean.TRUE;
        }

        a(Context context, GrsBaseInfo grsBaseInfo) {
            this.f33420a = context;
            this.f33421b = grsBaseInfo;
        }
    }

    c(Context context, GrsBaseInfo grsBaseInfo) {
        this.f33419h = null;
        this.f33413b = StubApp.getOrigApplicationContext(context.getApplicationContext()) != null ? StubApp.getOrigApplicationContext(context.getApplicationContext()) : context;
        j(grsBaseInfo);
        GrsBaseInfo grsBaseInfo2 = this.f33412a;
        FutureTask<Boolean> futureTask = new FutureTask<>(new a(this.f33413b, grsBaseInfo2));
        this.f33419h = futureTask;
        f33410j.execute(futureTask);
        Logger.i(f33409i, "GrsClient Instance is init, GRS SDK version: %s, GrsBaseInfoParam: app_name=%s, reg_country=%s, ser_country=%s, issue_country=%s ,queryTimeout=%d", r1.a.a(), grsBaseInfo2.getAppName(), grsBaseInfo.getRegCountry(), grsBaseInfo.getSerCountry(), grsBaseInfo.getIssueCountry(), Integer.valueOf(grsBaseInfo.getQueryTimeout()));
    }

    c(GrsBaseInfo grsBaseInfo) {
        this.f33419h = null;
        j(grsBaseInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(Map<String, ?> map) {
        if (map == null || map.isEmpty()) {
            Logger.v(f33409i, "sp's content is empty.");
            return;
        }
        Set<String> keySet = map.keySet();
        for (String str : keySet) {
            if (str.endsWith(this.f33413b.getPackageName() + "time")) {
                String a6 = this.f33416e.a(str, "");
                long j6 = 0;
                if (!TextUtils.isEmpty(a6) && a6.matches("\\d+")) {
                    try {
                        j6 = Long.parseLong(a6);
                    } catch (NumberFormatException e6) {
                        Logger.w(f33409i, "convert expire time from String to Long catch NumberFormatException.", e6);
                    }
                }
                String substring = str.substring(0, str.length() - 4);
                String str2 = substring + "ETag";
                if (!s(j6) || !keySet.contains(substring) || !keySet.contains(str2)) {
                    Logger.i(f33409i, "init interface auto clear some invalid sp's data: " + str);
                    this.f33416e.d(substring);
                    this.f33416e.d(str);
                    this.f33416e.d(str2);
                }
            }
        }
    }

    private boolean y() {
        String str;
        String str2;
        FutureTask<Boolean> futureTask = this.f33419h;
        if (futureTask == null) {
            return false;
        }
        try {
            return futureTask.get(8L, TimeUnit.SECONDS).booleanValue();
        } catch (InterruptedException e6) {
            e = e6;
            str = f33409i;
            str2 = "init compute task interrupted.";
            Logger.w(str, str2, e);
            return false;
        } catch (CancellationException unused) {
            Logger.i(f33409i, "init compute task canceled.");
            return false;
        } catch (ExecutionException e7) {
            e = e7;
            str = f33409i;
            str2 = "init compute task failed.";
            Logger.w(str, str2, e);
            return false;
        } catch (TimeoutException unused2) {
            Logger.w(f33409i, "init compute task timed out");
            return false;
        } catch (Exception e8) {
            e = e8;
            str = f33409i;
            str2 = "init compute task occur unknown Exception";
            Logger.w(str, str2, e);
            return false;
        }
    }

    String e(String str, String str2, int i6) {
        if (this.f33412a == null || str == null || str2 == null) {
            Logger.w(f33409i, "invalid para!");
            return null;
        }
        if (y()) {
            return this.f33418g.d(str, str2, this.f33413b, i6);
        }
        return null;
    }

    Map<String, String> f(String str, int i6) {
        if (this.f33412a != null && str != null) {
            return y() ? this.f33418g.f(str, this.f33413b, i6) : new HashMap();
        }
        Logger.w(f33409i, "invalid para!");
        return new HashMap();
    }

    void l(String str, IQueryUrlsCallBack iQueryUrlsCallBack, int i6) {
        if (iQueryUrlsCallBack == null) {
            Logger.w(f33409i, "IQueryUrlsCallBack is must not null for process continue.");
            return;
        }
        if (this.f33412a == null || str == null) {
            iQueryUrlsCallBack.onCallBackFail(-6);
        } else if (y()) {
            this.f33418g.j(str, iQueryUrlsCallBack, this.f33413b, i6);
        } else {
            Logger.i(f33409i, "grs init task has not completed.");
            iQueryUrlsCallBack.onCallBackFail(-7);
        }
    }

    void m(String str, String str2, IQueryUrlCallBack iQueryUrlCallBack, int i6) {
        if (iQueryUrlCallBack == null) {
            Logger.w(f33409i, "IQueryUrlCallBack is must not null for process continue.");
            return;
        }
        if (this.f33412a == null || str == null || str2 == null) {
            iQueryUrlCallBack.onCallBackFail(-6);
        } else if (y()) {
            this.f33418g.k(str, str2, iQueryUrlCallBack, this.f33413b, i6);
        } else {
            Logger.i(f33409i, "grs init task has not completed.");
            iQueryUrlCallBack.onCallBackFail(-7);
        }
    }

    boolean o(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && c.class == obj.getClass() && (obj instanceof c)) {
            return this.f33412a.compare(((c) obj).f33412a);
        }
        return false;
    }

    private void j(GrsBaseInfo grsBaseInfo) {
        try {
            this.f33412a = grsBaseInfo.m113clone();
        } catch (CloneNotSupportedException e6) {
            Logger.w(f33409i, "GrsClient catch CloneNotSupportedException", e6);
            this.f33412a = grsBaseInfo.copy();
        }
    }

    private boolean s(long j6) {
        if (System.currentTimeMillis() - j6 <= bn.f10748d) {
            return true;
        }
        return false;
    }

    void i() {
        if (!y()) {
            return;
        }
        String grsParasKey = this.f33412a.getGrsParasKey(true, true, this.f33413b);
        this.f33416e.d(grsParasKey);
        this.f33416e.d(grsParasKey + "time");
        this.f33416e.d(grsParasKey + "ETag");
        this.f33414c.f(grsParasKey);
    }

    boolean r() {
        GrsBaseInfo grsBaseInfo;
        Context context;
        if (!y() || (grsBaseInfo = this.f33412a) == null || (context = this.f33413b) == null) {
            return false;
        }
        this.f33415d.c(grsBaseInfo, context);
        return true;
    }
}
