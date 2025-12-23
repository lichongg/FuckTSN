package com.bytedance.j.xt.up.j;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.tencent.open.SocialConstants;
import com.umeng.analytics.pro.bi;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public class h {

    /* renamed from: t, reason: collision with root package name */
    private static com.bytedance.j.xt.d f24290t;

    /* renamed from: a, reason: collision with root package name */
    private Application f24291a;

    /* renamed from: b, reason: collision with root package name */
    private Context f24292b;

    /* renamed from: g, reason: collision with root package name */
    private String f24297g;

    /* renamed from: h, reason: collision with root package name */
    private long f24298h;

    /* renamed from: i, reason: collision with root package name */
    private String f24299i;

    /* renamed from: j, reason: collision with root package name */
    private long f24300j;

    /* renamed from: k, reason: collision with root package name */
    private String f24301k;

    /* renamed from: l, reason: collision with root package name */
    private long f24302l;

    /* renamed from: m, reason: collision with root package name */
    private String f24303m;

    /* renamed from: n, reason: collision with root package name */
    private long f24304n;

    /* renamed from: o, reason: collision with root package name */
    private String f24305o;

    /* renamed from: p, reason: collision with root package name */
    private long f24306p;

    /* renamed from: c, reason: collision with root package name */
    private List<String> f24293c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    private List<Long> f24294d = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    private List<String> f24295e = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    private List<Long> f24296f = new ArrayList();

    /* renamed from: q, reason: collision with root package name */
    private int f24307q = 0;

    /* renamed from: r, reason: collision with root package name */
    private boolean f24308r = false;

    /* renamed from: s, reason: collision with root package name */
    private final Application.ActivityLifecycleCallbacks f24309s = new a();

    class a implements Application.ActivityLifecycleCallbacks {
        a() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            h.this.f24297g = h.f24290t == null ? activity.getClass().getName() : h.f24290t.j(activity);
            h.this.f24298h = System.currentTimeMillis();
            h.this.f24293c.add(h.this.f24297g);
            h.this.f24294d.add(Long.valueOf(h.this.f24298h));
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            h.this.f24303m = h.f24290t == null ? activity.getClass().getName() : h.f24290t.j(activity);
            h.this.f24304n = System.currentTimeMillis();
            h.n(h.this);
            if (h.this.f24307q <= 0) {
                h.this.f24308r = false;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            h.this.f24301k = h.f24290t == null ? activity.getClass().getName() : h.f24290t.j(activity);
            h.this.f24302l = System.currentTimeMillis();
            h.this.f24308r = true;
            h.u(h.this);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            h.this.f24299i = h.f24290t == null ? activity.getClass().getName() : h.f24290t.j(activity);
            h.this.f24300j = System.currentTimeMillis();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            h.this.f24305o = h.f24290t == null ? activity.getClass().getName() : h.f24290t.j(activity);
            h.this.f24306p = System.currentTimeMillis();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            String j6;
            if (h.f24290t == null) {
                j6 = activity.getClass().getName();
            } else {
                j6 = h.f24290t.j(activity);
            }
            int indexOf = h.this.f24293c.indexOf(j6);
            if (indexOf >= 0 && indexOf < h.this.f24293c.size()) {
                h.this.f24293c.remove(indexOf);
                h.this.f24294d.remove(indexOf);
            }
            h.this.f24295e.add(j6);
            h.this.f24296f.add(Long.valueOf(System.currentTimeMillis()));
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }
    }

    private JSONArray b() {
        JSONArray jSONArray = new JSONArray();
        List<String> list = this.f24295e;
        if (list != null && !list.isEmpty()) {
            for (int i6 = 0; i6 < this.f24295e.size(); i6++) {
                try {
                    jSONArray.put(l(this.f24295e.get(i6), this.f24296f.get(i6).longValue()));
                } catch (Throwable unused) {
                }
            }
        }
        return jSONArray;
    }

    private JSONObject l(String str, long j6) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(CommonNetImpl.NAME, str);
            jSONObject.put("time", j6);
            return jSONObject;
        } catch (JSONException e6) {
            vl.j(e6);
            return jSONObject;
        }
    }

    static /* synthetic */ int n(h hVar) {
        int i6 = hVar.f24307q;
        hVar.f24307q = i6 - 1;
        return i6;
    }

    private JSONArray o() {
        JSONArray jSONArray = new JSONArray();
        List<String> list = this.f24293c;
        if (list != null && !list.isEmpty()) {
            for (int i6 = 0; i6 < this.f24293c.size(); i6++) {
                try {
                    jSONArray.put(l(this.f24293c.get(i6), this.f24294d.get(i6).longValue()));
                } catch (Throwable unused) {
                }
            }
        }
        return jSONArray;
    }

    static /* synthetic */ int u(h hVar) {
        int i6 = hVar.f24307q;
        hVar.f24307q = i6 + 1;
        return i6;
    }

    private void x() {
        Application application = this.f24291a;
        if (application != null) {
            application.registerActivityLifecycleCallbacks(this.f24309s);
        }
    }

    public JSONArray B() {
        List<ActivityManager.RunningTaskInfo> runningTasks;
        ComponentName componentName;
        ComponentName componentName2;
        int i6;
        ComponentName componentName3;
        ComponentName componentName4;
        JSONArray jSONArray = new JSONArray();
        try {
            ActivityManager activityManager = (ActivityManager) this.f24292b.getSystemService(TTDownloadField.TT_ACTIVITY);
            if (activityManager != null && (runningTasks = activityManager.getRunningTasks(5)) != null) {
                for (ActivityManager.RunningTaskInfo runningTaskInfo : runningTasks) {
                    if (runningTaskInfo != null) {
                        componentName = runningTaskInfo.baseActivity;
                        if (componentName != null) {
                            try {
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("id", runningTaskInfo.id);
                                componentName2 = runningTaskInfo.baseActivity;
                                jSONObject.put(bi.f40972o, componentName2.getPackageName());
                                jSONObject.put(SocialConstants.PARAM_COMMENT, runningTaskInfo.description);
                                i6 = runningTaskInfo.numActivities;
                                jSONObject.put("number_of_activities", i6);
                                jSONObject.put("number_of_running_activities", runningTaskInfo.numRunning);
                                componentName3 = runningTaskInfo.topActivity;
                                jSONObject.put("topActivity", componentName3.toString());
                                componentName4 = runningTaskInfo.baseActivity;
                                jSONObject.put("baseActivity", componentName4.toString());
                                jSONArray.put(jSONObject);
                            } catch (JSONException unused) {
                            }
                        }
                    }
                }
            }
        } catch (Exception unused2) {
        }
        return jSONArray;
    }

    public boolean f() {
        return this.f24308r;
    }

    public JSONObject k() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("last_create_activity", l(this.f24297g, this.f24298h));
            jSONObject.put("last_start_activity", l(this.f24299i, this.f24300j));
            jSONObject.put("last_resume_activity", l(this.f24301k, this.f24302l));
            jSONObject.put("last_pause_activity", l(this.f24303m, this.f24304n));
            jSONObject.put("last_stop_activity", l(this.f24305o, this.f24306p));
            jSONObject.put("alive_activities", o());
            jSONObject.put("finish_activities", b());
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    h(@NonNull Context context) {
        this.f24292b = context;
        if (context instanceof Application) {
            this.f24291a = (Application) context;
        }
        x();
    }
}
