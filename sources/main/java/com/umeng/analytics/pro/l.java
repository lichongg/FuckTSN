package com.umeng.analytics.pro;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.umeng.analytics.MobclickAgent;
import com.umeng.analytics.pro.e;
import com.umeng.analytics.pro.i;
import com.umeng.analytics.vshelper.PageNameMonitor;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.utils.UMUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@TargetApi(14)
/* loaded from: D:\Downloads\app\classes7.dex */
public class l {

    /* renamed from: a, reason: collision with root package name */
    public static String f41341a;

    /* renamed from: b, reason: collision with root package name */
    boolean f41350b;

    /* renamed from: c, reason: collision with root package name */
    boolean f41351c;

    /* renamed from: f, reason: collision with root package name */
    com.umeng.analytics.vshelper.a f41352f;

    /* renamed from: g, reason: collision with root package name */
    Application.ActivityLifecycleCallbacks f41353g;

    /* renamed from: h, reason: collision with root package name */
    private final Map<String, Long> f41354h;

    /* renamed from: l, reason: collision with root package name */
    private boolean f41355l;

    /* renamed from: m, reason: collision with root package name */
    private int f41356m;

    /* renamed from: n, reason: collision with root package name */
    private int f41357n;

    /* renamed from: i, reason: collision with root package name */
    private static JSONArray f41344i = new JSONArray();

    /* renamed from: j, reason: collision with root package name */
    private static Object f41345j = new Object();

    /* renamed from: k, reason: collision with root package name */
    private static Application f41346k = null;

    /* renamed from: d, reason: collision with root package name */
    static String f41342d = null;

    /* renamed from: e, reason: collision with root package name */
    static int f41343e = -1;

    /* renamed from: o, reason: collision with root package name */
    private static boolean f41347o = true;

    /* renamed from: p, reason: collision with root package name */
    private static Object f41348p = new Object();

    /* renamed from: q, reason: collision with root package name */
    private static bn f41349q = new com.umeng.analytics.vshelper.b();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final l f41359a = new l();

        private a() {
        }
    }

    static /* synthetic */ int a(l lVar) {
        int i6 = lVar.f41357n;
        lVar.f41357n = i6 - 1;
        return i6;
    }

    static /* synthetic */ int b(l lVar) {
        int i6 = lVar.f41356m;
        lVar.f41356m = i6 - 1;
        return i6;
    }

    static /* synthetic */ int e(l lVar) {
        int i6 = lVar.f41357n;
        lVar.f41357n = i6 + 1;
        return i6;
    }

    static /* synthetic */ int f(l lVar) {
        int i6 = lVar.f41356m;
        lVar.f41356m = i6 + 1;
        return i6;
    }

    private l() {
        this.f41354h = new HashMap();
        this.f41355l = false;
        this.f41350b = false;
        this.f41351c = false;
        this.f41356m = 0;
        this.f41357n = 0;
        this.f41352f = PageNameMonitor.getInstance();
        this.f41353g = new Application.ActivityLifecycleCallbacks() { // from class: com.umeng.analytics.pro.l.1
            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity) {
                if (FieldManager.allow(com.umeng.commonsdk.utils.d.F)) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onActivityPaused: FirstResumeTrigger enabled.");
                    synchronized (l.f41348p) {
                        try {
                            if (l.f41347o) {
                                return;
                            }
                        } finally {
                        }
                    }
                } else {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onActivityPaused: FirstResumeTrigger disabled.");
                }
                if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION != MobclickAgent.PageMode.AUTO) {
                    if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION == MobclickAgent.PageMode.MANUAL) {
                        com.umeng.analytics.b.a().i();
                    }
                } else {
                    l.this.c(activity);
                    com.umeng.analytics.b.a().i();
                    l.this.f41350b = false;
                    l.f41349q.d(activity);
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity activity) {
                if (FieldManager.allow(com.umeng.commonsdk.utils.d.F)) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onActivityResumed: FirstResumeTrigger enabled.");
                    synchronized (l.f41348p) {
                        try {
                            if (l.f41347o) {
                                boolean unused = l.f41347o = false;
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    l.this.a(activity);
                } else {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onActivityResumed: FirstResumeTrigger disabled.");
                    l.this.a(activity);
                }
                l.f41349q.c(activity);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(Activity activity) {
                if (activity != null) {
                    if (l.this.f41356m <= 0) {
                        if (l.f41342d == null) {
                            l.f41342d = UUID.randomUUID().toString();
                        }
                        if (l.f41343e == -1) {
                            l.f41343e = activity.isTaskRoot() ? 1 : 0;
                        }
                        if (l.f41343e == 0 && UMUtils.isMainProgress(activity)) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("activityName", activity.toString());
                            hashMap.put("pid", Integer.valueOf(Process.myPid()));
                            hashMap.put("isMainProcess", Integer.valueOf(UMUtils.isMainProgress(activity) ? 1 : 0));
                            com.umeng.analytics.b a6 = com.umeng.analytics.b.a();
                            if (a6 != null) {
                                a6.a((Context) activity, "$$_onUMengEnterForegroundInitError", (Map<String, Object>) hashMap);
                            }
                            l.f41343e = -2;
                            if (UMConfigure.isDebugLog()) {
                                UMLog.mutlInfo(2, j.ar);
                            }
                        } else if (l.f41343e == 1 || !UMUtils.isMainProgress(activity)) {
                            HashMap hashMap2 = new HashMap();
                            hashMap2.put("pairUUID", l.f41342d);
                            hashMap2.put("pid", Integer.valueOf(Process.myPid()));
                            hashMap2.put("isMainProcess", Integer.valueOf(UMUtils.isMainProgress(activity) ? 1 : 0));
                            hashMap2.put("activityName", activity.toString());
                            if (com.umeng.analytics.b.a() != null) {
                                com.umeng.analytics.b.a().a((Context) activity, "$$_onUMengEnterForeground", (Map<String, Object>) hashMap2);
                            }
                        }
                    }
                    if (l.this.f41357n < 0) {
                        l.e(l.this);
                    } else {
                        l.f(l.this);
                    }
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                MobclickAgent.PageMode pageMode = UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION;
                MobclickAgent.PageMode pageMode2 = MobclickAgent.PageMode.AUTO;
                if (activity != null) {
                    if (activity.isChangingConfigurations()) {
                        l.a(l.this);
                        return;
                    }
                    l.b(l.this);
                    if (l.this.f41356m <= 0) {
                        if (l.f41343e == 0 && UMUtils.isMainProgress(activity)) {
                            return;
                        }
                        int i6 = l.f41343e;
                        if (i6 == 1 || (i6 == 0 && !UMUtils.isMainProgress(activity))) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("pairUUID", l.f41342d);
                            hashMap.put(MediationConstant.KEY_REASON, "Normal");
                            hashMap.put("pid", Integer.valueOf(Process.myPid()));
                            hashMap.put("isMainProcess", Integer.valueOf(UMUtils.isMainProgress(activity) ? 1 : 0));
                            hashMap.put("activityName", activity.toString());
                            com.umeng.analytics.b a6 = com.umeng.analytics.b.a();
                            if (a6 != null) {
                                a6.a((Context) activity, "$$_onUMengEnterBackground", (Map<String, Object>) hashMap);
                            }
                            if (l.f41342d != null) {
                                l.f41342d = null;
                            }
                        }
                    }
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle bundle) {
                l.f41349q.a(activity, bundle);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            }
        };
        synchronized (this) {
            try {
                if (f41346k != null) {
                    g();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void g() {
        if (this.f41355l) {
            return;
        }
        this.f41355l = true;
        if (f41346k != null) {
            f41346k.registerActivityLifecycleCallbacks(this.f41353g);
        }
    }

    public void c() {
        c((Activity) null);
        b();
    }

    public void b(Context context) {
        synchronized (f41348p) {
            if (f41347o) {
                f41347o = false;
                Activity globleActivity = DeviceConfig.getGlobleActivity(context);
                if (globleActivity == null) {
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> init触发onResume: 无前台Activity，直接退出。");
                    return;
                }
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> init触发onResume: 补救成功，前台Activity名：" + globleActivity.getLocalClassName());
                a(globleActivity);
                return;
            }
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> init触发onResume: firstResumeCall = false，直接返回。");
        }
    }

    public static void c(Context context) {
        String jSONArray;
        if (context != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                synchronized (f41345j) {
                    jSONArray = f41344i.toString();
                    f41344i = new JSONArray();
                }
                if (jSONArray.length() > 0) {
                    jSONObject.put(e.d.a.f41265c, new JSONArray(jSONArray));
                    i.a(context).a(u.a().c(), jSONObject, i.a.AUTOPAGE);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public boolean a() {
        return this.f41355l;
    }

    public static synchronized l a(Context context) {
        l lVar;
        synchronized (l.class) {
            try {
                if (f41346k == null && context != null) {
                    if (context instanceof Activity) {
                        f41346k = ((Activity) context).getApplication();
                    } else if (context instanceof Application) {
                        f41346k = (Application) context;
                    }
                }
                lVar = a.f41359a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return lVar;
    }

    public static void a(Context context, String str) {
        if (f41343e == 1 && UMUtils.isMainProgress(context)) {
            HashMap hashMap = new HashMap();
            hashMap.put("pairUUID", f41342d);
            hashMap.put(MediationConstant.KEY_REASON, str);
            if (f41342d != null) {
                f41342d = null;
            }
            if (context != null) {
                hashMap.put("pid", Integer.valueOf(Process.myPid()));
                hashMap.put("isMainProcess", Integer.valueOf(UMUtils.isMainProgress(context) ? 1 : 0));
                hashMap.put("Context", context.toString());
                com.umeng.analytics.b.a().a(context, "$$_onUMengEnterBackground", (Map<String, Object>) hashMap);
            }
        }
    }

    public void b() {
        this.f41355l = false;
        if (f41346k != null) {
            f41346k.unregisterActivityLifecycleCallbacks(this.f41353g);
            f41346k = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Activity activity) {
        long j6;
        long j7;
        try {
            synchronized (this.f41354h) {
                try {
                    if (f41341a == null && activity != null) {
                        f41341a = activity.getPackageName() + "." + activity.getLocalClassName();
                    }
                    if (TextUtils.isEmpty(f41341a) || !this.f41354h.containsKey(f41341a)) {
                        j6 = 0;
                        j7 = 0;
                    } else {
                        j6 = this.f41354h.get(f41341a).longValue();
                        j7 = System.currentTimeMillis() - j6;
                        this.f41354h.remove(f41341a);
                    }
                } finally {
                }
            }
            synchronized (f41345j) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(d.f41203v, f41341a);
                    jSONObject.put("duration", j7);
                    jSONObject.put(d.f41205x, j6);
                    jSONObject.put("type", 0);
                    f41344i.put(jSONObject);
                } catch (Throwable unused) {
                }
            }
        } catch (Throwable unused2) {
        }
    }

    private void b(Activity activity) {
        f41341a = activity.getPackageName() + "." + activity.getLocalClassName();
        synchronized (this.f41354h) {
            this.f41354h.put(f41341a, Long.valueOf(System.currentTimeMillis()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Activity activity) {
        if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION != MobclickAgent.PageMode.AUTO) {
            if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION == MobclickAgent.PageMode.MANUAL) {
                synchronized (f41348p) {
                    com.umeng.analytics.b.a().h();
                }
                return;
            }
            return;
        }
        if (activity != null) {
            String str = activity.getPackageName() + "." + activity.getLocalClassName();
            this.f41352f.activityResume(str);
            if (this.f41350b) {
                this.f41350b = false;
                if (!TextUtils.isEmpty(f41341a)) {
                    if (f41341a.equals(str)) {
                        return;
                    }
                    b(activity);
                    synchronized (f41348p) {
                        com.umeng.analytics.b.a().h();
                    }
                    return;
                }
                f41341a = str;
                return;
            }
            b(activity);
            synchronized (f41348p) {
                com.umeng.analytics.b.a().h();
            }
        }
    }
}
