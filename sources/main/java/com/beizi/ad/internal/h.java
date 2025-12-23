package com.beizi.ad.internal;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.beizi.ad.internal.i.f;
import com.beizi.ad.lance.a.r;
import com.stub.StubApp;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class h {
    private static boolean F = false;
    private static boolean G = false;

    /* renamed from: g, reason: collision with root package name */
    public static String f11990g = null;

    /* renamed from: h, reason: collision with root package name */
    public static String f11991h = "";

    /* renamed from: i, reason: collision with root package name */
    public static String f11992i = "";

    /* renamed from: m, reason: collision with root package name */
    private static String f11993m = "USED_AD_UNIT_IDS_KEY";

    /* renamed from: n, reason: collision with root package name */
    private static h f11994n = null;

    /* renamed from: o, reason: collision with root package name */
    private static String f11995o = "BeiZiImpl";
    private DisplayMetrics B;
    private com.beizi.ad.internal.i.f E;

    /* renamed from: c, reason: collision with root package name */
    public List<String> f11998c;

    /* renamed from: j, reason: collision with root package name */
    public Context f12002j;

    /* renamed from: k, reason: collision with root package name */
    public float f12003k;

    /* renamed from: l, reason: collision with root package name */
    public float f12004l;

    /* renamed from: w, reason: collision with root package name */
    private boolean f12012w;

    /* renamed from: x, reason: collision with root package name */
    private boolean f12013x;

    /* renamed from: a, reason: collision with root package name */
    public boolean f11996a = false;

    /* renamed from: b, reason: collision with root package name */
    public String f11997b = null;

    /* renamed from: d, reason: collision with root package name */
    public boolean f11999d = false;

    /* renamed from: e, reason: collision with root package name */
    public String f12000e = "";

    /* renamed from: f, reason: collision with root package name */
    public HashMap<String, String> f12001f = new HashMap<>();

    /* renamed from: p, reason: collision with root package name */
    private HashSet<String> f12005p = new HashSet<>();

    /* renamed from: q, reason: collision with root package name */
    private HashSet<String> f12006q = new HashSet<>();

    /* renamed from: r, reason: collision with root package name */
    private HashSet<String> f12007r = new HashSet<>();

    /* renamed from: s, reason: collision with root package name */
    private HashSet<String> f12008s = new HashSet<>();

    /* renamed from: t, reason: collision with root package name */
    private HashSet<String> f12009t = new HashSet<>();

    /* renamed from: u, reason: collision with root package name */
    private HashSet<String> f12010u = new HashSet<>();

    /* renamed from: v, reason: collision with root package name */
    private int f12011v = -1;

    /* renamed from: y, reason: collision with root package name */
    private Handler f12014y = new Handler(Looper.getMainLooper()) { // from class: com.beizi.ad.internal.h.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i6 = message.what;
        }
    };

    /* renamed from: z, reason: collision with root package name */
    private Handler f12015z = null;
    private HandlerThread A = null;
    private boolean C = false;
    private boolean D = false;
    private int H = 0;
    private List<b> I = new ArrayList();

    static /* synthetic */ int a(h hVar) {
        int i6 = hVar.H;
        hVar.H = i6 + 1;
        return i6;
    }

    static /* synthetic */ int c(h hVar) {
        int i6 = hVar.H;
        hVar.H = i6 - 1;
        return i6;
    }

    private void r() {
        try {
            Class.forName("android.content.pm.PackageParser$Package").getDeclaredConstructor(String.class).setAccessible(true);
        } catch (Exception e6) {
            e6.printStackTrace();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Method declaredMethod = cls.getDeclaredMethod("currentActivityThread", null);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(null, null);
            Field declaredField = cls.getDeclaredField("mHiddenApiWarningShown");
            declaredField.setAccessible(true);
            declaredField.setBoolean(invoke, true);
        } catch (Throwable unused) {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.beizi.ad.internal.h$3, reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f12018a;

        static {
            int[] iArr = new int[k.values().length];
            f12018a = iArr;
            try {
                iArr[k.SPLASH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f12018a[k.BANNER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f12018a[k.INTERSTITIAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f12018a[k.NATIVE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f12018a[k.REWARDEDVIDEO.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    private com.beizi.ad.internal.i.f q() {
        Context context = this.f12002j;
        if (context == null) {
            return null;
        }
        return new f.a(context).a(52428800L).a();
    }

    public com.beizi.ad.internal.i.f b() {
        if (this.f12002j == null) {
            return null;
        }
        com.beizi.ad.internal.i.f fVar = this.E;
        if (fVar != null) {
            return fVar;
        }
        com.beizi.ad.internal.i.f q5 = q();
        this.E = q5;
        return q5;
    }

    public Handler c() {
        if (this.f12015z == null) {
            if (this.A == null) {
                HandlerThread handlerThread = new HandlerThread("BackgroundHandler");
                this.A = handlerThread;
                handlerThread.start();
            }
            this.f12015z = new Handler(this.A.getLooper());
        }
        return this.f12015z;
    }

    public String d() {
        return f11990g;
    }

    public Context e() {
        return this.f12002j;
    }

    public String f() {
        String b6 = com.beizi.ad.lance.a.b.b("aHR0cDovL2FwaS5odHAuYWQtc2NvcGUuY29tLmNuOjQ1NjAw");
        return TextUtils.isEmpty(b6) ? "" : this.f11996a ? b6.replace("http:", "https:") : b6;
    }

    public float g() {
        return this.f12003k;
    }

    public float h() {
        return this.f12004l;
    }

    public float i() {
        return Math.max(this.f12003k, this.f12004l);
    }

    public DisplayMetrics j() {
        return this.B;
    }

    public HashSet<String> k() {
        return this.f12010u;
    }

    public String l() {
        if (!TextUtils.isEmpty(this.f11997b)) {
            return this.f11997b;
        }
        return f() + "/mb/sdk0/json";
    }

    public void m() {
        try {
            ((Application) StubApp.getOrigApplicationContext(this.f12002j.getApplicationContext())).registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() { // from class: com.beizi.ad.internal.h.2
                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityDestroyed(Activity activity) {
                    int unused = h.this.H;
                    Objects.toString(activity);
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityResumed(Activity activity) {
                    try {
                        if (h.this.I == null || h.this.I.size() <= 0) {
                            return;
                        }
                        Iterator it = h.this.I.iterator();
                        while (it.hasNext()) {
                            b bVar = (b) it.next();
                            if (bVar != null) {
                                bVar.b();
                            }
                            it.remove();
                        }
                        h.this.I.clear();
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityStarted(Activity activity) {
                    h.a(h.this);
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityStopped(Activity activity) {
                    try {
                        h.c(h.this);
                        if (h.this.H < 0) {
                            h.this.H = 0;
                        }
                        if (h.this.H != 0 || h.this.I == null || h.this.I.size() <= 0) {
                            return;
                        }
                        Iterator it = h.this.I.iterator();
                        while (it.hasNext()) {
                            b bVar = (b) it.next();
                            if (bVar != null) {
                                bVar.a();
                            }
                            it.remove();
                        }
                    } catch (Exception e6) {
                        e6.printStackTrace();
                    }
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityPaused(Activity activity) {
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityCreated(Activity activity, Bundle bundle) {
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                }
            });
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public List<String> n() {
        return this.f11998c;
    }

    public int o() {
        return this.f12011v;
    }

    public boolean p() {
        if (this.f12013x) {
            return this.f12012w;
        }
        this.f12013x = true;
        boolean a6 = r.a();
        this.f12012w = a6;
        return a6;
    }

    public static h a() {
        h hVar;
        synchronized (h.class) {
            try {
                if (f11994n == null) {
                    f11994n = new h();
                }
                hVar = f11994n;
            } catch (Throwable th) {
                throw th;
            }
        }
        return hVar;
    }

    public String b(String str) {
        com.beizi.ad.model.b bVar = new com.beizi.ad.model.b();
        bVar.a(str);
        bVar.b(com.beizi.ad.internal.h.o.a());
        bVar.a(false);
        return new com.beizi.ad.v2.e.b().a(bVar);
    }

    public void a(Context context, String str) {
        synchronized (h.class) {
            try {
                if (context != null) {
                    this.f12002j = StubApp.getOrigApplicationContext(context.getApplicationContext());
                    try {
                        f11990g = str;
                        com.beizi.ad.internal.a.a.a().b();
                        m();
                    } catch (Throwable unused) {
                    }
                    this.B = context.getResources().getDisplayMetrics();
                    this.D = true;
                    if (Build.VERSION.SDK_INT >= 28) {
                        r();
                    }
                } else {
                    throw new IllegalArgumentException("Context cannot be null.");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void a(k kVar, String str) {
        if (com.beizi.ad.internal.h.o.a(str)) {
            return;
        }
        int i6 = AnonymousClass3.f12018a[kVar.ordinal()];
        if (i6 == 1) {
            this.f12005p.add(str);
            return;
        }
        if (i6 == 2) {
            this.f12006q.add(str);
            return;
        }
        if (i6 == 3) {
            this.f12007r.add(str);
        } else if (i6 == 4) {
            this.f12008s.add(str);
        } else {
            if (i6 != 5) {
                return;
            }
            this.f12009t.add(str);
        }
    }

    public void a(String str) {
        this.f11997b = str;
    }

    public void a(b bVar) {
        this.I.add(bVar);
    }

    public void a(List<String> list) {
        this.f11998c = list;
    }

    public void a(Context context) {
        this.f12002j = context;
    }
}
