package com.huawei.hms.framework.common.hianalytics;

import android.annotation.SuppressLint;
import android.content.Context;
import android.provider.Settings;
import androidx.annotation.NonNull;
import com.huawei.hianalytics.process.HiAnalyticsInstance;
import com.huawei.hianalytics.process.HiAnalyticsManager;
import com.huawei.hms.framework.common.ContextHolder;
import com.huawei.hms.framework.common.ExecutorsUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.support.hianalytics.HiAnalyticsUtils;
import com.huawei.hms.utils.HMSBIInitializer;
import java.security.SecureRandom;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class HianalyticsHelper {

    /* renamed from: l, reason: collision with root package name */
    private static final String f33366l = "HianalyticsHelper";

    /* renamed from: m, reason: collision with root package name */
    private static final String f33367m = "hms_hwid";

    /* renamed from: n, reason: collision with root package name */
    private static final String f33368n = "_default_config_tag";

    /* renamed from: o, reason: collision with root package name */
    private static final String f33369o = "user_experience_involved";

    /* renamed from: p, reason: collision with root package name */
    private static final int f33370p = 1;

    /* renamed from: q, reason: collision with root package name */
    private static final int f33371q = 1;

    /* renamed from: r, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    private static volatile HianalyticsHelper f33372r;

    /* renamed from: a, reason: collision with root package name */
    private boolean f33373a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f33374b;

    /* renamed from: g, reason: collision with root package name */
    private ReportCallBack f33379g;

    /* renamed from: k, reason: collision with root package name */
    private boolean f33383k;

    /* renamed from: c, reason: collision with root package name */
    private String f33375c = f33367m;

    /* renamed from: d, reason: collision with root package name */
    private HiAnalyticsInstance f33376d = null;

    /* renamed from: e, reason: collision with root package name */
    private boolean f33377e = false;

    /* renamed from: f, reason: collision with root package name */
    private ExecutorService f33378f = ExecutorsUtils.newSingleThreadExecutor("report_ha");

    /* renamed from: h, reason: collision with root package name */
    private boolean f33380h = true;

    /* renamed from: i, reason: collision with root package name */
    private boolean f33381i = true;

    /* renamed from: j, reason: collision with root package name */
    private final int f33382j = new SecureRandom().nextInt(1000);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface ReportCallBack {
        void onReport(int i6, String str, LinkedHashMap<String, String> linkedHashMap);
    }

    public boolean isEnableReport(Context context) {
        return a(context, true, false);
    }

    public boolean isEnableReportNoSeed(Context context) {
        return a(context, false, false);
    }

    public boolean isQuicEnableReport(Context context) {
        return a(context, true, true);
    }

    public void onEvent(LinkedHashMap<String, String> linkedHashMap, String str) {
        onEvent(linkedHashMap, str, 1);
    }

    public void setQuicRate(int i6) {
        boolean z5 = true;
        if (i6 < 0 || i6 >= 1000) {
            this.f33381i = true;
            return;
        }
        if (this.f33382j >= i6 && !this.f33383k) {
            z5 = false;
        }
        this.f33381i = z5;
    }

    public void setRate(int i6) {
        boolean z5 = true;
        if (i6 < 0 || i6 >= 1000) {
            this.f33380h = true;
            return;
        }
        if (this.f33382j >= i6 && !this.f33383k) {
            z5 = false;
        }
        this.f33380h = z5;
        Logger.i(f33366l, "bReportable = " + this.f33380h + ", inuser = " + this.f33383k + ", rate = " + i6);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class HianalyticsRunnable implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final HianalyticsBaseData f33384a;

        /* renamed from: b, reason: collision with root package name */
        private final String f33385b;

        HianalyticsRunnable(HianalyticsBaseData hianalyticsBaseData, String str) {
            this.f33384a = hianalyticsBaseData;
            this.f33385b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            HianalyticsHelper.getInstance().onEvent(this.f33384a.get(), this.f33385b);
        }
    }

    private HianalyticsHelper() {
        try {
            HiAnalyticsManager.getInitFlag(f33368n);
            this.f33373a = true;
        } catch (Throwable unused) {
            Logger.i(f33366l, "Hianalytics sdk not found");
            this.f33373a = false;
        }
        if (!this.f33373a) {
            d(ContextHolder.getAppContext());
        }
        try {
            this.f33383k = ContextHolder.getAppContext().getPackageManager().getPackageInfo("com.huawei.works", 0) != null;
        } catch (Exception unused2) {
            this.f33383k = false;
        }
        Logger.v(f33366l, "this time the ha %s, mini %s", Boolean.valueOf(this.f33373a), Boolean.valueOf(this.f33374b));
    }

    private boolean a(@NonNull Context context, boolean z5, boolean z6) {
        if (this.f33379g != null) {
            return true;
        }
        if (z5 && ((z6 && !this.f33381i) || (!z6 && !this.f33380h))) {
            return false;
        }
        if (this.f33374b) {
            return true;
        }
        if (!this.f33373a) {
            return false;
        }
        if (this.f33377e) {
            return b();
        }
        try {
            if (Settings.Secure.getInt(context.getContentResolver(), f33369o, -1) == 1) {
                return b();
            }
        } catch (IllegalStateException unused) {
            Logger.w(f33366l, "the setting has illegalStateException");
        } catch (Throwable unused2) {
            Logger.w(f33366l, "the setting has other error");
        }
        Logger.i(f33366l, "user experience involved needs to be opened");
        return false;
    }

    private boolean b() {
        if (this.f33376d != null) {
            return true;
        }
        if (HiAnalyticsManager.getInitFlag(f33368n)) {
            this.f33376d = HiAnalyticsManager.getInstanceByTag(f33368n);
        } else {
            this.f33376d = HiAnalyticsManager.getInstanceByTag(this.f33375c);
        }
        return this.f33376d != null;
    }

    private void c(Context context, String str, Map map, int i6) {
        if (context == null || map == null) {
            return;
        }
        Logger.v(f33366l, "data = %s", map);
        try {
            HiAnalyticsUtils.getInstance().onNewEvent(context, str, map, i6);
        } catch (NoSuchMethodError unused) {
            Logger.w(f33366l, "may be you need upgrade stats sdk");
        } catch (Throwable unused2) {
            Logger.i(f33366l, "the stats has other error,pls check it");
        }
    }

    private void d(Context context) {
        if (context == null) {
            Logger.i(f33366l, "the appContext hasn't init");
            return;
        }
        try {
            HMSBIInitializer.getInstance(context).initBI();
            this.f33374b = true;
        } catch (NoClassDefFoundError unused) {
            Logger.w(f33366l, "maybe you need add base sdk!");
        } catch (Throwable unused2) {
            Logger.w(f33366l, "the hms base has other error!");
        }
    }

    public static HianalyticsHelper getInstance() {
        if (f33372r == null) {
            synchronized (HianalyticsHelper.class) {
                try {
                    if (f33372r == null) {
                        f33372r = new HianalyticsHelper();
                    }
                } finally {
                }
            }
        }
        return f33372r;
    }

    public void enablePrivacyPolicy(boolean z5) {
        this.f33377e = z5;
    }

    public ExecutorService getReportExecutor() {
        return this.f33378f;
    }

    public boolean inRate() {
        return this.f33380h;
    }

    public void onEvent(LinkedHashMap<String, String> linkedHashMap, String str, int i6) {
        if (linkedHashMap == null) {
            return;
        }
        linkedHashMap.put("in_user", "" + (this.f33383k ? 1 : 0));
        Logger.v(f33366l, "data = %s", linkedHashMap);
        ReportCallBack reportCallBack = this.f33379g;
        if (reportCallBack != null) {
            reportCallBack.onReport(i6, str, linkedHashMap);
            return;
        }
        if (this.f33374b) {
            c(ContextHolder.getAppContext(), str, linkedHashMap, i6);
        } else if (i6 == 0) {
            Logger.v(f33366l, "the base sdk isn't exsit, and reportType is %s", Integer.valueOf(i6));
            return;
        }
        if (this.f33373a) {
            HiAnalyticsInstance hiAnalyticsInstance = this.f33376d;
            if (hiAnalyticsInstance != null) {
                hiAnalyticsInstance.onEvent(1, str, linkedHashMap);
            } else {
                Logger.e(f33366l, "the ha has error,has init but is null!");
            }
        }
    }

    public void reportException(final Throwable th, final String str) {
        if (getInstance().isEnableReportNoSeed(ContextHolder.getAppContext())) {
            final String name = Thread.currentThread().getName();
            try {
                this.f33378f.submit(new Runnable() { // from class: com.huawei.hms.framework.common.hianalytics.HianalyticsHelper.1
                    @Override // java.lang.Runnable
                    public void run() {
                        CrashHianalyticsData crashHianalyticsData = new CrashHianalyticsData();
                        crashHianalyticsData.put("sdk_version", "7.0.2.301");
                        crashHianalyticsData.put(CrashHianalyticsData.CRASH_TYPE, "exception");
                        crashHianalyticsData.put(CrashHianalyticsData.THREAD_NAME, name);
                        crashHianalyticsData.put(CrashHianalyticsData.EXCEPTION_NAME, th.getClass().getName());
                        crashHianalyticsData.put(CrashHianalyticsData.MESSAGE, StringUtils.anonymizeMessage(th.getMessage()));
                        crashHianalyticsData.put(CrashHianalyticsData.STACK_TRACE, StringUtils.getTraceInfo(th));
                        HianalyticsHelper.getInstance().onEvent(crashHianalyticsData.get(), str);
                    }
                });
            } catch (RejectedExecutionException unused) {
                Logger.i(f33366l, "reportException error RejectedExecutionException");
            } catch (Exception unused2) {
                Logger.i(f33366l, "reportException error!", th);
            }
        }
    }

    public void setHaTag(String str) {
        this.f33375c = str;
    }

    public void setReportCallback(ReportCallBack reportCallBack) {
        this.f33379g = reportCallBack;
    }

    public void executeReportHa(HianalyticsBaseData hianalyticsBaseData, String str) {
        getReportExecutor().execute(new HianalyticsRunnable(hianalyticsBaseData, str));
    }

    public void reportData(Context context, LinkedHashMap<String, String> linkedHashMap, String str, int i6) {
        if (!isEnableReportNoSeed(context)) {
            return;
        }
        onEvent(linkedHashMap, str, i6);
    }

    public void onEvent(LinkedHashMap<String, String> linkedHashMap) {
        onEvent(linkedHashMap, HianalyticsBaseData.EVENT_ID);
    }
}
