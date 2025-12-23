package com.baidu.liantian;

import android.R;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.Window;
import com.baidu.liantian.b.r;
import com.baidu.liantian.core.ApkInfo;
import com.baidu.liantian.core.g;
import com.stub.StubApp;
import com.umeng.analytics.pro.bi;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class LiantianActivity extends Activity {

    /* renamed from: a, reason: collision with root package name */
    protected boolean f10304a = false;

    /* renamed from: b, reason: collision with root package name */
    protected a f10305b = new a();

    /* renamed from: c, reason: collision with root package name */
    protected Activity f10306c = null;

    /* renamed from: d, reason: collision with root package name */
    protected Configuration f10307d = null;

    /* renamed from: e, reason: collision with root package name */
    protected ActivityInfo f10308e = null;

    /* renamed from: q, reason: collision with root package name */
    private Resources f10309q;

    /* renamed from: i, reason: collision with root package name */
    public static Method f10296i = f.a((Class<?>) Activity.class, "onCreate", (Class<?>[]) new Class[]{Bundle.class});

    /* renamed from: j, reason: collision with root package name */
    public static Method f10297j = f.a((Class<?>) Activity.class, "onPostCreate", (Class<?>[]) new Class[]{Bundle.class});

    /* renamed from: k, reason: collision with root package name */
    public static Method f10298k = f.a((Class<?>) Activity.class, "onStart", (Class<?>[]) new Class[0]);

    /* renamed from: l, reason: collision with root package name */
    public static Method f10299l = f.a((Class<?>) Activity.class, "onResume", (Class<?>[]) new Class[0]);

    /* renamed from: m, reason: collision with root package name */
    public static Method f10300m = f.a((Class<?>) Activity.class, "onPostResume", (Class<?>[]) new Class[0]);

    /* renamed from: n, reason: collision with root package name */
    public static Method f10301n = f.a((Class<?>) Activity.class, "onPause", (Class<?>[]) new Class[0]);

    /* renamed from: o, reason: collision with root package name */
    public static Method f10302o = f.a((Class<?>) Activity.class, "onStop", (Class<?>[]) new Class[0]);

    /* renamed from: p, reason: collision with root package name */
    public static Method f10303p = f.a((Class<?>) Activity.class, "onDestroy", (Class<?>[]) new Class[0]);

    /* renamed from: f, reason: collision with root package name */
    public static Field f10293f = f.a((Class<?>) Activity.class, "mCurrentConfig");

    /* renamed from: g, reason: collision with root package name */
    public static Field f10294g = f.a((Class<?>) Activity.class, "mConfigChangeFlags");

    /* renamed from: h, reason: collision with root package name */
    public static Field f10295h = f.a((Class<?>) Activity.class, "mCalled");

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public boolean f10312a = false;

        /* renamed from: b, reason: collision with root package name */
        public String f10313b;

        /* renamed from: c, reason: collision with root package name */
        public String f10314c;

        /* renamed from: d, reason: collision with root package name */
        public String f10315d;

        /* renamed from: e, reason: collision with root package name */
        public Intent f10316e;

        public final String toString() {
            try {
                return a.class.getSimpleName() + ": mode=" + this.f10312a + ", activity=" + this.f10313b + ", path=" + this.f10314c + ",pkgName=" + this.f10315d;
            } catch (Throwable unused) {
                com.baidu.liantian.b.e.a();
                return "";
            }
        }
    }

    private static boolean a(a aVar, Intent intent) {
        try {
            String stringExtra = intent.getStringExtra("from_plugin_package");
            String stringExtra2 = intent.getStringExtra("target_class");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                aVar.f10312a = true;
                aVar.f10315d = stringExtra;
                aVar.f10313b = stringExtra2;
                aVar.f10316e = intent;
                return true;
            }
            return false;
        } catch (Throwable unused) {
            com.baidu.liantian.b.e.a();
            return false;
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        ActivityInfo[] activityInfoArr;
        String str;
        ActivityInfo activityInfo;
        Method method;
        try {
            b.a();
            final Intent intent = getIntent();
            if ("a".equals(intent.getStringExtra(bi.aL))) {
                final Context origApplicationContext = StubApp.getOrigApplicationContext(getApplicationContext());
                r.a().a(new Runnable() { // from class: com.baidu.liantian.LiantianActivity.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            intent.toString();
                            b.a();
                            String stringExtra = intent.getStringExtra("c");
                            Intent intent2 = new Intent();
                            intent2.putExtra(bi.aL, "a");
                            intent2.putExtra("c", stringExtra);
                            com.baidu.liantian.a.a(StubApp.getOrigApplicationContext(origApplicationContext.getApplicationContext()), intent2);
                        } catch (Throwable unused) {
                            com.baidu.liantian.b.e.a();
                        }
                    }
                });
            }
            g a6 = g.a();
            if (a6 == null) {
                b.a();
                super.onCreate(bundle);
                finish();
                return;
            }
            a(this.f10305b, intent);
            this.f10305b.toString();
            b.a();
            if (TextUtils.isEmpty(this.f10305b.f10315d)) {
                b.a();
                super.onCreate(bundle);
                finish();
                return;
            }
            ApkInfo d6 = a6.d(this.f10305b.f10315d);
            if (d6 != null && (activityInfoArr = d6.activities) != null) {
                int length = activityInfoArr.length;
                int i6 = 0;
                while (true) {
                    str = null;
                    if (i6 >= length) {
                        activityInfo = null;
                        break;
                    }
                    activityInfo = activityInfoArr[i6];
                    if (activityInfo.name.equals(this.f10305b.f10313b)) {
                        break;
                    } else {
                        i6++;
                    }
                }
                if (activityInfo == null) {
                    b.a();
                    super.onCreate(bundle);
                    finish();
                    return;
                }
                this.f10308e = activityInfo;
                int i7 = activityInfo.theme;
                if (i7 == 0) {
                    i7 = d6.applicationTheme;
                }
                if (i7 == 0) {
                    i7 = R.style.Theme;
                }
                setTheme(i7);
                this.f10304a = true;
                try {
                    Object newInstance = d6.classLoader.loadClass(this.f10305b.f10313b).newInstance();
                    if (!(newInstance instanceof Activity)) {
                        newInstance.toString();
                        b.a();
                        finish();
                        return;
                    }
                    this.f10306c = (Activity) newInstance;
                    Activity activity = (Activity) newInstance;
                    f.a(this, activity);
                    try {
                        Field a7 = f.a((Class<?>) ContextThemeWrapper.class, "mInflater");
                        Field a8 = f.a((Class<?>) ContextThemeWrapper.class, "mTheme");
                        Field a9 = f.a((Class<?>) ContextThemeWrapper.class, "mResources");
                        if (a7 != null) {
                            try {
                                a7.set(activity, null);
                            } catch (Throwable th) {
                                th.getMessage();
                                b.b();
                            }
                        }
                        if (a8 != null) {
                            a8.set(activity, null);
                        }
                        if (a9 != null) {
                            Resources resources = getResources();
                            AssetManager assetManager = new AssetManager();
                            assetManager.addAssetPath(d6.pkgPath);
                            b.a();
                            this.f10309q = new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
                            Objects.toString(this.f10309q);
                            b.a();
                            if (activityInfo.labelRes > 0) {
                                this.f10309q.getString(activityInfo.labelRes);
                                b.a();
                            }
                            a9.set(activity, this.f10309q);
                        }
                        activity.setTheme(i7);
                        activity.getTheme().applyStyle(i7, true);
                        b.a();
                        Window window = activity.getWindow();
                        Field a10 = f.a(window.getClass(), "mLayoutInflater");
                        if (a10 != null) {
                            a10.setAccessible(true);
                            try {
                                a10.set(window, ((LayoutInflater) a10.get(window)).cloneInContext(activity));
                            } catch (Throwable th2) {
                                th2.getMessage();
                                b.b();
                            }
                        }
                    } catch (Throwable unused) {
                        com.baidu.liantian.b.e.a();
                    }
                    try {
                        Field a11 = f.a((Class<?>) Window.class, "mCallback");
                        if (a11 != null) {
                            try {
                                a11.set(activity.getWindow(), this.f10306c);
                            } catch (IllegalAccessException | IllegalArgumentException unused2) {
                            }
                        }
                    } catch (Throwable unused3) {
                        com.baidu.liantian.b.e.a();
                    }
                    try {
                        Field a12 = f.a((Class<?>) Activity.class, "mActivityInfo");
                        if (a12 != null) {
                            try {
                                a12.set(activity, activityInfo);
                            } catch (Throwable th3) {
                                th3.getMessage();
                                b.b();
                            }
                        }
                        Field a13 = f.a((Class<?>) Activity.class, "mComponent");
                        if (a13 != null) {
                            try {
                                a13.set(activity, new ComponentName(activityInfo.packageName, activityInfo.name));
                            } catch (Throwable th4) {
                                th4.getMessage();
                                b.b();
                            }
                        }
                        Field a14 = f.a((Class<?>) Activity.class, "mTitle");
                        if (a14 != null) {
                            CharSequence charSequence = activityInfo.nonLocalizedLabel;
                            if (charSequence != null) {
                                str = charSequence.toString();
                            } else if (activityInfo.labelRes == 0) {
                                str = activityInfo.name;
                                if (str == null) {
                                    str = activityInfo.packageName;
                                }
                            } else if (this.f10309q != null) {
                                b.a();
                                Objects.toString(this.f10309q);
                                b.a();
                                str = this.f10309q.getString(activityInfo.labelRes);
                            }
                            try {
                                a14.set(activity, str);
                            } catch (Throwable th5) {
                                th5.getMessage();
                                b.b();
                            }
                        }
                    } catch (Throwable unused4) {
                        com.baidu.liantian.b.e.a();
                    }
                    try {
                        Window window2 = activity.getWindow();
                        TypedArray obtainStyledAttributes = activity.obtainStyledAttributes(R.styleable.Window);
                        Field a15 = f.a(activity.getWindow().getClass(), "mWindowStyle");
                        if (a15 != null) {
                            try {
                                a15.set(window2, obtainStyledAttributes);
                            } catch (Throwable th6) {
                                th6.getMessage();
                                b.b();
                            }
                        }
                    } catch (Throwable unused5) {
                        com.baidu.liantian.b.e.a();
                    }
                    this.f10305b.f10316e.setExtrasClassLoader(d6.classLoader);
                    activity.setIntent(this.f10305b.f10316e);
                    if (this.f10304a && (method = f10296i) != null && this.f10306c != null) {
                        try {
                            method.invoke(newInstance, bundle);
                        } catch (Throwable th7) {
                            th7.getMessage();
                            b.b();
                        }
                    }
                    super.onCreate(bundle);
                    b.a();
                    return;
                } catch (Throwable th8) {
                    th8.getMessage();
                    b.b();
                    finish();
                    return;
                }
            }
            b.a();
            super.onCreate(bundle);
            finish();
        } catch (Throwable unused6) {
            com.baidu.liantian.b.e.a();
        }
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        boolean z5;
        boolean z6;
        try {
            super.onConfigurationChanged(configuration);
            if (this.f10304a && this.f10306c != null) {
                if (!a(configuration)) {
                    boolean z7 = true;
                    try {
                        f10295h.setBoolean(this.f10306c, false);
                        z5 = false;
                    } catch (Throwable th) {
                        try {
                            th.getMessage();
                            b.b();
                            z5 = true;
                        } catch (Throwable unused) {
                            com.baidu.liantian.b.e.a();
                        }
                    }
                    this.f10306c.onConfigurationChanged(configuration);
                    try {
                        boolean z8 = z5;
                        z6 = f10295h.getBoolean(this.f10306c);
                        z7 = z8;
                    } catch (Throwable th2) {
                        th2.getMessage();
                        b.b();
                        z6 = false;
                    }
                    if (z7 || z6) {
                        try {
                            f10294g.setInt(this.f10306c, 0);
                        } catch (Throwable th3) {
                            th3.getMessage();
                            b.b();
                        }
                        try {
                            f10293f.set(this.f10306c, new Configuration(configuration));
                        } catch (Throwable th4) {
                            th4.getMessage();
                            b.b();
                        }
                    }
                }
                Configuration configuration2 = this.f10307d;
                if (configuration2 != null) {
                    configuration2.updateFrom(configuration);
                }
            }
        } catch (Throwable unused2) {
            com.baidu.liantian.b.e.a();
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        Method method;
        Activity activity;
        try {
            super.onDestroy();
            if (this.f10304a && (method = f10303p) != null && (activity = this.f10306c) != null) {
                try {
                    method.invoke(activity, null);
                } catch (Throwable th) {
                    th.getMessage();
                    b.b();
                }
            }
        } catch (Throwable unused) {
            com.baidu.liantian.b.e.a();
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        Method method;
        Activity activity;
        try {
            super.onPause();
            if (this.f10304a && (method = f10301n) != null && (activity = this.f10306c) != null) {
                try {
                    method.invoke(activity, null);
                } catch (Throwable th) {
                    th.getMessage();
                    b.b();
                }
            }
        } catch (Throwable unused) {
            com.baidu.liantian.b.e.a();
        }
    }

    @Override // android.app.Activity
    protected void onPostCreate(Bundle bundle) {
        Method method;
        Activity activity;
        try {
            super.onPostCreate(bundle);
            if (this.f10304a && (method = f10297j) != null && (activity = this.f10306c) != null) {
                try {
                    method.invoke(activity, bundle);
                } catch (Throwable th) {
                    th.getMessage();
                    b.b();
                }
            }
        } catch (Throwable unused) {
            com.baidu.liantian.b.e.a();
        }
    }

    @Override // android.app.Activity
    protected void onPostResume() {
        Method method;
        Activity activity;
        try {
            super.onPostResume();
            if (this.f10304a && (method = f10300m) != null && (activity = this.f10306c) != null) {
                try {
                    method.invoke(activity, null);
                } catch (Throwable th) {
                    th.getMessage();
                    b.b();
                }
            }
        } catch (Throwable unused) {
            com.baidu.liantian.b.e.a();
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        Method method;
        Activity activity;
        try {
            super.onResume();
            if (this.f10304a && (method = f10299l) != null && (activity = this.f10306c) != null) {
                try {
                    method.invoke(activity, null);
                } catch (Throwable th) {
                    th.getMessage();
                    b.b();
                }
            }
        } catch (Throwable unused) {
            com.baidu.liantian.b.e.a();
        }
    }

    @Override // android.app.Activity
    protected void onStart() {
        Method method;
        Activity activity;
        try {
            super.onStart();
            if (this.f10304a && (method = f10298k) != null && (activity = this.f10306c) != null) {
                try {
                    method.invoke(activity, null);
                } catch (Throwable th) {
                    th.getMessage();
                    b.b();
                }
            }
        } catch (Throwable unused) {
            com.baidu.liantian.b.e.a();
        }
    }

    @Override // android.app.Activity
    protected void onStop() {
        Method method;
        Activity activity;
        try {
            super.onStop();
            if (this.f10304a && (method = f10302o) != null && (activity = this.f10306c) != null) {
                try {
                    method.invoke(activity, null);
                } catch (Throwable th) {
                    th.getMessage();
                    b.b();
                }
            }
        } catch (Throwable unused) {
            com.baidu.liantian.b.e.a();
        }
    }

    private boolean a(Configuration configuration) {
        try {
            Configuration configuration2 = this.f10307d;
            if (configuration2 == null) {
                return false;
            }
            int i6 = this.f10308e.configChanges;
            int diff = configuration2.diff(configuration);
            return diff != 0 && (diff & i6) == 0;
        } catch (Throwable unused) {
            com.baidu.liantian.b.e.a();
            return false;
        }
    }
}
