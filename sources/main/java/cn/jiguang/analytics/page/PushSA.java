package cn.jiguang.analytics.page;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.bb.f;
import cn.jiguang.by.d;
import cn.jiguang.bz.j;
import cn.jiguang.bz.w;
import com.stub.StubApp;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes2.dex */
public class PushSA {
    public static final String CACHE_PATH = "push_stat_cache.json";
    private static final String KEY_SESSION_ID = "session_id";
    public static final String REPORT_ACTIVE_LAUNCH = "active_launch";
    public static final String REPORT_ACTIVE_TERMINATE = "active_terminate";
    private static final String TAG = "PushSA";
    public static boolean isOnPauseInvoke;
    public static boolean isOnResumeInvoke;
    private boolean activitySwitch;
    private String cur_activity;
    private final Object cur_session_file_lock;
    private String cur_session_id;
    private boolean firstResume;
    private JSONObject flow_cache;
    private long interval;
    private long latestPauseTime;
    private long latestResumeTime;
    private boolean stat_enable;
    private long tempTimelong;

    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        private static final PushSA f1642a = new PushSA();
    }

    static class b extends cn.jiguang.by.b {

        /* renamed from: a, reason: collision with root package name */
        boolean f1643a;

        /* renamed from: b, reason: collision with root package name */
        Context f1644b;

        /* renamed from: c, reason: collision with root package name */
        PushSA f1645c;

        @Override // cn.jiguang.by.b
        public void a() {
            try {
                if (this.f1643a) {
                    this.f1645c.sendLogRoutine(this.f1644b);
                } else {
                    this.f1645c.saveLogRoutine(this.f1644b);
                }
            } catch (Throwable unused) {
            }
        }

        public b(boolean z5, Context context, PushSA pushSA) {
            this.f1643a = z5;
            this.f1644b = context;
            this.f1645c = pushSA;
            this.f2653h = PushSA.TAG;
        }
    }

    private PushSA() {
        this.cur_activity = null;
        this.cur_session_id = null;
        this.interval = 30L;
        this.latestResumeTime = 0L;
        this.latestPauseTime = 0L;
        this.firstResume = true;
        this.activitySwitch = false;
        this.stat_enable = true;
        this.tempTimelong = 0L;
        this.flow_cache = null;
        this.cur_session_file_lock = new Object();
    }

    private void clearCurrentLogFile(Context context) {
        j.d(CACHE_PATH);
    }

    private String generateSessionID(Context context, long j6) {
        StringBuilder sb = new StringBuilder();
        String e6 = cn.jiguang.d.a.e(context);
        if (!TextUtils.isEmpty(e6)) {
            sb.append(e6);
        }
        sb.append(j6);
        return w.d(sb.toString());
    }

    private JSONObject getFlowCache(Context context) {
        if (this.flow_cache == null) {
            this.flow_cache = j.a(CACHE_PATH);
        }
        return this.flow_cache;
    }

    private boolean invokeCheck(Context context, String str) {
        if (!this.stat_enable) {
            f.f(TAG, "stat function has been disabled");
            return false;
        }
        if (context == null) {
            f.f(TAG, "context is null");
            return false;
        }
        if (!(context instanceof Application)) {
            return true;
        }
        f.m(TAG, "Context should be an Activity on this method : " + str);
        return false;
    }

    private boolean isNewSession(Context context) {
        if (!this.firstResume) {
            return this.latestResumeTime - this.latestPauseTime > this.interval * 1000;
        }
        this.firstResume = false;
        f.c(TAG, "statistics start");
        long longValue = ((Long) cn.jiguang.e.b.a(context, cn.jiguang.e.a.T())).longValue();
        f.c(TAG, "lastPause:" + longValue + ",latestResumeTime:" + this.latestResumeTime + ",interval:" + (this.interval * 1000) + ",a:" + (this.latestResumeTime - longValue));
        return longValue <= 0 || this.latestResumeTime - longValue > this.interval * 1000;
    }

    private void saveCurrentLog(Context context, JSONObject jSONObject) {
        j.a(CACHE_PATH, jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveLogRoutine(Context context) {
        if (context == null) {
            return;
        }
        synchronized (this.cur_session_file_lock) {
            cn.jiguang.e.b.a(context, (cn.jiguang.e.a<?>[]) new cn.jiguang.e.a[]{cn.jiguang.e.a.T().a((cn.jiguang.e.a<Long>) Long.valueOf(this.latestPauseTime)), cn.jiguang.e.a.S().a((cn.jiguang.e.a<Long>) Long.valueOf(this.latestPauseTime))});
            if (cn.jiguang.bz.b.d(context)) {
                JSONObject flowCache = getFlowCache(context);
                if (flowCache == null) {
                    flowCache = new JSONObject();
                }
                try {
                    updateFlowInfo(flowCache, context);
                } catch (Exception unused) {
                }
                updateFlowCache(flowCache);
                saveCurrentLog(context, flowCache);
            }
        }
    }

    private void updateFlowCache(JSONObject jSONObject) {
        this.flow_cache = jSONObject;
    }

    public long getInterval() {
        return this.interval;
    }

    public boolean isStatEnable() {
        return this.stat_enable;
    }

    public void onFragmentPause(Context context, String str) {
        if (!this.activitySwitch) {
            f.c(TAG, "JCoreInterface.onPause() must be called after called JCoreInterface.onResume() in this Activity or Fragment");
            return;
        }
        this.activitySwitch = false;
        String str2 = this.cur_activity;
        if (str2 == null || !str2.equals(str)) {
            f.m(TAG, "page name didn't match the last one passed by onResume");
            return;
        }
        this.latestPauseTime = System.currentTimeMillis();
        final Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        try {
            d.a("SCHEDULE_TASK", new cn.jiguang.by.b("PushSA#onFragmentPause") { // from class: cn.jiguang.analytics.page.PushSA.2
                @Override // cn.jiguang.by.b
                public void a() {
                    try {
                        PushSA.this.saveLogRoutine(origApplicationContext);
                    } catch (Throwable unused) {
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }

    public void onFragmentResume(Context context, String str) {
        if (this.activitySwitch) {
            f.c(TAG, "JCoreInterface.onResume() must be called after called JCoreInterface.onPause() in last Activity or Fragment");
            return;
        }
        this.activitySwitch = true;
        this.cur_activity = str;
        this.latestResumeTime = System.currentTimeMillis();
        final Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        try {
            d.a("SCHEDULE_TASK", new cn.jiguang.by.b("PushSA#onFragmentResume") { // from class: cn.jiguang.analytics.page.PushSA.1
                @Override // cn.jiguang.by.b
                public void a() {
                    try {
                        PushSA.this.sendLogRoutine(origApplicationContext);
                    } catch (Throwable unused) {
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }

    public void onKillProcess(Context context) {
        try {
            if (this.cur_activity == null || !this.activitySwitch) {
                return;
            }
            this.latestPauseTime = System.currentTimeMillis();
            final Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
            d.a("SCHEDULE_TASK", new cn.jiguang.by.b("PushSA#onKillProcess") { // from class: cn.jiguang.analytics.page.PushSA.3
                @Override // cn.jiguang.by.b
                public void a() {
                    try {
                        PushSA.this.saveLogRoutine(origApplicationContext);
                    } catch (Throwable unused) {
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }

    public void onPause(Context context) {
        if (invokeCheck(context, "onPause")) {
            isOnPauseInvoke = true;
            try {
                this.activitySwitch = true;
            } catch (ClassCastException | Exception unused) {
            }
            if (this.activitySwitch) {
                this.activitySwitch = false;
                String str = this.cur_activity;
                if (str == null || !str.equals(context.getClass().getName())) {
                    f.f(TAG, "the activity pass by onPause didn't match last one passed by onResume");
                    return;
                }
                this.latestPauseTime = System.currentTimeMillis();
                this.tempTimelong = this.latestResumeTime;
                try {
                    d.a("SCHEDULE_TASK", new b(false, StubApp.getOrigApplicationContext(context.getApplicationContext()), this));
                } catch (Throwable unused2) {
                }
            }
        }
    }

    public void onResume(Context context) {
        if (invokeCheck(context, "onResume")) {
            isOnResumeInvoke = true;
            try {
                this.activitySwitch = false;
            } catch (ClassCastException | Exception unused) {
            }
            if (this.activitySwitch) {
                return;
            }
            this.activitySwitch = true;
            this.latestResumeTime = System.currentTimeMillis();
            this.cur_activity = context.getClass().getName();
            try {
                d.a("SCHEDULE_TASK", new b(true, StubApp.getOrigApplicationContext(context.getApplicationContext()), this));
            } catch (Throwable unused2) {
            }
        }
    }

    public void setInterval(long j6) {
        this.interval = j6;
    }

    public void setStatEnable(boolean z5) {
        this.stat_enable = z5;
    }

    private JSONObject createNewSession(Context context, long j6) {
        this.cur_session_id = generateSessionID(context, j6);
        cn.jiguang.e.b.a(context, (cn.jiguang.e.a<?>[]) new cn.jiguang.e.a[]{cn.jiguang.e.a.R().a((cn.jiguang.e.a<Long>) Long.valueOf(this.latestResumeTime)), cn.jiguang.e.a.U().a((cn.jiguang.e.a<String>) this.cur_session_id)});
        JSONObject jSONObject = new JSONObject();
        try {
            wrapDate(jSONObject);
            cn.jiguang.d.a.a(context, jSONObject, REPORT_ACTIVE_LAUNCH);
            jSONObject.put("session_id", this.cur_session_id);
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    public static PushSA getInstance() {
        return a.f1642a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendLogRoutine(Context context) {
        JSONObject flowCache;
        if (isNewSession(context)) {
            f.f(TAG, "new statistics session");
            JSONArray jSONArray = new JSONArray();
            JSONObject createNewSession = createNewSession(context, this.latestResumeTime);
            if (createNewSession != null) {
                jSONArray.put(createNewSession);
            }
            synchronized (this.cur_session_file_lock) {
                flowCache = getFlowCache(context);
                if (flowCache != null && flowCache.length() > 0) {
                    try {
                        cn.jiguang.d.a.a(context, flowCache, REPORT_ACTIVE_TERMINATE);
                    } catch (Exception unused) {
                    }
                    clearCurrentLogFile(context);
                    this.flow_cache = null;
                }
            }
            if (flowCache != null && flowCache.length() > 0 && cn.jiguang.bz.b.d(context)) {
                jSONArray.put(flowCache);
            }
            cn.jiguang.d.a.a(context, jSONArray);
            return;
        }
        this.cur_session_id = (String) cn.jiguang.e.b.b(context, cn.jiguang.e.a.U());
    }

    private void updateFlowInfo(JSONObject jSONObject, Context context) {
        long j6;
        long longValue = ((Long) cn.jiguang.e.b.a(context, cn.jiguang.e.a.R())).longValue();
        if (longValue <= 0) {
            long j7 = this.latestPauseTime - this.tempTimelong;
            if (j7 > 0) {
                j6 = j7 / 1000;
            } else {
                j6 = 10;
            }
            cn.jiguang.e.b.a(context, (cn.jiguang.e.a<?>[]) new cn.jiguang.e.a[]{cn.jiguang.e.a.R().a((cn.jiguang.e.a<Long>) Long.valueOf(this.tempTimelong))});
        } else {
            j6 = (this.latestPauseTime - longValue) / 1000;
        }
        jSONObject.put("duration", j6);
        jSONObject.put("itime", System.currentTimeMillis() / 1000);
        jSONObject.put("session_id", this.cur_session_id);
        wrapDate(jSONObject);
    }

    private void wrapDate(JSONObject jSONObject) {
        String b6 = cn.jiguang.bz.f.b();
        String str = b6.split("_")[0];
        String str2 = b6.split("_")[1];
        jSONObject.put("date", str);
        jSONObject.put("time", str2);
    }
}
