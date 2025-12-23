package com.acse.ottn;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import androidx.annotation.RequiresApi;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.lang.ref.WeakReference;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class h1 {

    /* renamed from: e, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    public static volatile h1 f4580e = null;

    /* renamed from: f, reason: collision with root package name */
    public static String f4581f = "HelpShopActivityManager";

    /* renamed from: a, reason: collision with root package name */
    public Activity f4582a;

    /* renamed from: b, reason: collision with root package name */
    public c f4583b;

    /* renamed from: c, reason: collision with root package name */
    public final BroadcastReceiver f4584c = new a();

    /* renamed from: d, reason: collision with root package name */
    public final BroadcastReceiver f4585d = new b();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class a extends BroadcastReceiver {

        /* renamed from: a, reason: collision with root package name */
        public final String f4586a = MediationConstant.KEY_REASON;

        /* renamed from: b, reason: collision with root package name */
        public final String f4587b = "homekey";

        /* renamed from: c, reason: collision with root package name */
        public final String f4588c = "recentapps";

        public a() {
        }

        @Override // android.content.BroadcastReceiver
        @RequiresApi(api = 21)
        public void onReceive(Context context, Intent intent) {
            String stringExtra;
            String action = intent.getAction();
            c2.a(h1.f4581f, "收到注册广播");
            if (action.equals("android.intent.action.CLOSE_SYSTEM_DIALOGS") && (stringExtra = intent.getStringExtra(MediationConstant.KEY_REASON)) != null) {
                if (h1.this.f4582a != null) {
                    h1 h1Var = h1.this;
                    if (h1Var.a(h1Var.f4582a, true)) {
                        c2.a(h1.f4581f, "结束当前activity1");
                        h1.this.f4582a.finishAndRemoveTask();
                    }
                } else {
                    c2.a(h1.f4581f, "结束当前activity1 ==null");
                }
                if (!stringExtra.equals("homekey")) {
                    stringExtra.equals("recentapps");
                }
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class b extends BroadcastReceiver {
        public b() {
        }

        @Override // android.content.BroadcastReceiver
        @RequiresApi(api = 21)
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            c2.a(h1.f4581f, "收到注册广播2");
            if ("android.intent.action.SCREEN_OFF".equals(action)) {
                if (h1.this.f4582a != null) {
                    c2.a(h1.f4581f, "结束当前activity2");
                    h1.this.f4582a.finishAndRemoveTask();
                } else {
                    c2.a(h1.f4581f, "结束当前activity2 ==null");
                }
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class c implements Application.ActivityLifecycleCallbacks {
        public c() {
        }

        public /* synthetic */ c(h1 h1Var, a aVar) {
            this();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            o.f4969m.add(new WeakReference<>(activity));
            c2.a(h1.f4581f, "onActivityCreated=" + activity.getLocalClassName());
            h1.this.f4582a = activity;
            if (h1.this.a(activity, true)) {
                h1.this.e();
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            for (int size = o.f4969m.size() - 1; size >= 0; size--) {
                if (o.f4969m.get(size).get() == activity) {
                    o.f4969m.remove(size);
                }
            }
            try {
                activity.unregisterReceiver(h1.this.f4584c);
                activity.unregisterReceiver(h1.this.f4585d);
            } catch (Exception e6) {
                c2.a(h1.f4581f, e6.getMessage());
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            h1.this.f4582a = null;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            h1.this.f4582a = activity;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        @RequiresApi(api = 21)
        public void onActivityStopped(Activity activity) {
            if (h1.this.a(activity, false)) {
                c2.a(h1.f4581f, " current activity stop=开始结束");
                activity.finishAndRemoveTask();
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }
    }

    public static h1 c() {
        if (f4580e != null) {
            return f4580e;
        }
        throw new Error("PGYER Analytic SDK init PgyerActivityManager is error.");
    }

    public static boolean d() {
        return f4580e != null;
    }

    public Activity b() {
        return this.f4582a;
    }

    public final void e() {
        this.f4582a.registerReceiver(this.f4584c, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        this.f4582a.registerReceiver(this.f4585d, new IntentFilter("android.intent.action.SCREEN_OFF"));
        c2.a(f4581f, "注册");
    }

    public h1(Application application) {
        c cVar = new c(this, null);
        this.f4583b = cVar;
        application.registerActivityLifecycleCallbacks(cVar);
    }

    public static void a(Application application) {
        if (f4580e == null) {
            synchronized (h1.class) {
                try {
                    if (f4580e == null) {
                        for (int size = o.f4969m.size() - 1; size >= 0; size--) {
                            o.f4969m.remove(size);
                        }
                        f4580e = new h1(application);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public final boolean a(Activity activity, boolean z5) {
        try {
            if ("com.acse.ottn.activity.ExcessActivity".contains(activity.getLocalClassName()) || "com.acse.ottn.activity.SeedingLoadingActivity".contains(activity.getLocalClassName())) {
                return true;
            }
            return "com.acse.ottn.activity.WhiteActivity".contains(activity.getLocalClassName());
        } catch (Exception e6) {
            c2.a(f4581f, e6.getMessage());
            return false;
        }
    }
}
