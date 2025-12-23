package com.bytedance.sdk.openadsdk.core;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.ats.ATSMethod;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\Downloads\app\classes4.dex */
public class tj {

    /* renamed from: j, reason: collision with root package name */
    public static volatile boolean f30204j;

    /* renamed from: m, reason: collision with root package name */
    private static volatile Handler f30205m;
    public static AtomicBoolean xt = new AtomicBoolean(false);
    public static AtomicBoolean cw = new AtomicBoolean(false);

    /* renamed from: r, reason: collision with root package name */
    public static AtomicBoolean f30206r = new AtomicBoolean(false);
    public static final long up = SystemClock.elapsedRealtime();

    private static final class j implements com.bytedance.sdk.component.m.az {
        private j() {
        }

        @Override // com.bytedance.sdk.component.m.az
        @ATSMethod(1)
        public com.bytedance.sdk.component.m.oq j(String str) {
            return com.bytedance.sdk.openadsdk.g.xt.j().j(str);
        }

        @Override // com.bytedance.sdk.component.m.az
        @ATSMethod(3)
        public void xt(double d6) {
            com.bytedance.sdk.openadsdk.g.xt.j().xt(d6);
        }

        @Override // com.bytedance.sdk.component.m.az
        @ATSMethod(2)
        public void j(double d6) {
            com.bytedance.sdk.openadsdk.g.xt.j().j(d6);
        }

        @Override // com.bytedance.sdk.component.m.az
        @ATSMethod(8)
        public boolean xt(String str, String str2, String str3) {
            return com.bytedance.sdk.openadsdk.g.xt.j().xt(str, str2, str3);
        }

        @Override // com.bytedance.sdk.component.m.az
        @ATSMethod(4)
        public void cw(double d6) {
            com.bytedance.sdk.openadsdk.g.xt.j().cw(d6);
        }

        @Override // com.bytedance.sdk.component.m.az
        @ATSMethod(5)
        public void j() {
            com.bytedance.sdk.openadsdk.g.xt.j().j();
        }

        @Override // com.bytedance.sdk.component.m.az
        @ATSMethod(6)
        public InputStream j(String str, String str2) {
            return com.bytedance.sdk.openadsdk.g.xt.j().j(str, str2);
        }

        @Override // com.bytedance.sdk.component.m.az
        @ATSMethod(7)
        public InputStream j(String str, String str2, String str3) {
            return com.bytedance.sdk.openadsdk.g.xt.j().j(str, str2, str3);
        }
    }

    public static void j() {
        Context context;
        if (f30206r.get() || !v.xt().uf() || (context = v.getContext()) == null) {
            return;
        }
        try {
            com.bytedance.sdk.openadsdk.core.v.up.j().xt().j(context, true, new com.bytedance.sdk.openadsdk.core.v.r(context));
        } catch (Exception unused) {
        }
        f30206r.set(true);
    }

    private static void ae() {
        if (Build.VERSION.SDK_INT < 28) {
            return;
        }
        try {
            Class.forName("android.content.pm.PackageParser$Package").getDeclaredConstructor(String.class).setAccessible(true);
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

    public static Handler m() {
        if (f30205m == null) {
            synchronized (tj.class) {
                try {
                    if (f30205m == null) {
                        f30205m = new Handler(Looper.getMainLooper());
                    }
                } finally {
                }
            }
        }
        return f30205m;
    }

    public static void cw() {
        com.bytedance.sdk.component.r.j.xt j6 = xt.j();
        long j7 = 0;
        long xt2 = j6.xt("sdk_first_init_timestamp", 0L);
        if (xt2 == 0) {
            xt2 = System.currentTimeMillis();
            j6.j("sdk_first_init_timestamp", xt2);
        }
        long currentTimeMillis = System.currentTimeMillis();
        String xt3 = com.bytedance.sdk.openadsdk.core.rn.uf.xt(xt2, currentTimeMillis);
        long xt4 = j6.xt("sdk_init_timestamp", 0L);
        StringBuilder sb = new StringBuilder();
        if (xt4 != 0) {
            j7 = (currentTimeMillis - xt4) / 1000;
        }
        sb.append(j7);
        com.bytedance.sdk.openadsdk.core.kt.ws.j().j(xt3, sb.toString());
        j6.j("sdk_init_timestamp", System.currentTimeMillis());
    }

    public static void r() {
        com.bytedance.sdk.component.adexpress.j.j.j.j().j(new com.bytedance.sdk.component.adexpress.j.j.cw() { // from class: com.bytedance.sdk.openadsdk.core.tj.2
            @Override // com.bytedance.sdk.component.adexpress.j.j.cw
            public int ae() {
                return 0;
            }

            @Override // com.bytedance.sdk.component.adexpress.j.j.cw
            public ExecutorService jy() {
                return null;
            }

            @Override // com.bytedance.sdk.component.adexpress.j.j.cw
            public ExecutorService ws() {
                return null;
            }

            @Override // com.bytedance.sdk.component.adexpress.j.j.cw
            public int az() {
                return com.bytedance.sdk.openadsdk.core.rn.ed.r(v.getContext());
            }

            @Override // com.bytedance.sdk.component.adexpress.j.j.cw
            public com.bytedance.sdk.component.adexpress.j.cw.j cw() {
                return v.j().j(1);
            }

            @Override // com.bytedance.sdk.component.adexpress.j.j.cw
            public int g() {
                return v.xt().fp();
            }

            @Override // com.bytedance.sdk.component.adexpress.j.j.cw
            public Context getContext() {
                return v.getContext();
            }

            @Override // com.bytedance.sdk.component.adexpress.j.j.cw
            public int j() {
                if (v.xt() == null) {
                    return 0;
                }
                return v.xt().zs();
            }

            @Override // com.bytedance.sdk.component.adexpress.j.j.cw
            public String m() {
                return oq.i().f();
            }

            @Override // com.bytedance.sdk.component.adexpress.j.j.cw
            public int oq() {
                return oq.i().q();
            }

            @Override // com.bytedance.sdk.component.adexpress.j.j.cw
            public int qv() {
                return v.xt().gr();
            }

            @Override // com.bytedance.sdk.component.adexpress.j.j.cw
            public com.bytedance.sdk.component.g.xt.xt r() {
                return com.bytedance.sdk.openadsdk.core.v.up.j().xt().r();
            }

            @Override // com.bytedance.sdk.component.adexpress.j.j.cw
            public int tl() {
                return v.xt().lx();
            }

            @Override // com.bytedance.sdk.component.adexpress.j.j.cw
            public com.bytedance.sdk.component.g.xt.cw up() {
                return com.bytedance.sdk.openadsdk.core.v.up.j().xt().cw();
            }

            @Override // com.bytedance.sdk.component.adexpress.j.j.cw
            public boolean vl() {
                return com.bytedance.sdk.openadsdk.core.multipro.xt.cw();
            }

            @Override // com.bytedance.sdk.component.adexpress.j.j.cw
            public Handler xt() {
                return tj.m();
            }
        });
    }

    private static void tl() {
        com.bytedance.sdk.openadsdk.core.cw.r.j().r(UUID.randomUUID().toString());
    }

    public static void up() {
        com.bytedance.sdk.component.adexpress.j.j.j.j().j(new com.bytedance.sdk.component.adexpress.j.j.xt() { // from class: com.bytedance.sdk.openadsdk.core.tj.3
            @Override // com.bytedance.sdk.component.adexpress.j.j.xt
            public int delete(String str, String str2, String[] strArr) {
                return com.bytedance.sdk.openadsdk.core.multipro.j.j.delete(v.getContext(), str, str2, strArr);
            }

            @Override // com.bytedance.sdk.component.adexpress.j.j.xt
            public void insert(String str, ContentValues contentValues) {
                com.bytedance.sdk.openadsdk.core.multipro.j.j.insert(v.getContext(), str, contentValues);
            }

            @Override // com.bytedance.sdk.component.adexpress.j.j.xt
            public Cursor query(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
                return com.bytedance.sdk.openadsdk.core.multipro.j.j.query(v.getContext(), str, strArr, str2, strArr2, str3, str4, str5);
            }

            @Override // com.bytedance.sdk.component.adexpress.j.j.xt
            public int update(String str, ContentValues contentValues, String str2, String[] strArr) {
                return com.bytedance.sdk.openadsdk.core.multipro.j.j.update(v.getContext(), str, contentValues, str2, strArr);
            }
        });
        com.bytedance.sdk.component.adexpress.j.j.j.j().j(new com.bytedance.sdk.component.adexpress.j.j.r() { // from class: com.bytedance.sdk.openadsdk.core.tj.4
            @Override // com.bytedance.sdk.component.adexpress.j.j.r
            public void j(final int i6) {
                com.bytedance.sdk.openadsdk.core.kt.ws.j().up(new com.bytedance.sdk.openadsdk.vl.j.j() { // from class: com.bytedance.sdk.openadsdk.core.tj.4.1
                    @Override // com.bytedance.sdk.openadsdk.vl.j.j
                    public com.bytedance.sdk.openadsdk.core.kt.j.j j() throws Exception {
                        return com.bytedance.sdk.openadsdk.core.kt.j.xt.xt().xt(i6).ae(g.j(i6));
                    }
                });
            }
        });
        com.bytedance.sdk.component.adexpress.j.j.j.j().j(new j());
        com.bytedance.sdk.component.adexpress.j.j.j.j().j(new com.bytedance.sdk.component.adexpress.j.j.up() { // from class: com.bytedance.sdk.openadsdk.core.tj.5
            @Override // com.bytedance.sdk.component.adexpress.j.j.up
            public void delete(String str, String str2) {
                com.bytedance.sdk.openadsdk.core.cw.xt.j().j(str, str2);
            }

            @Override // com.bytedance.sdk.component.adexpress.j.j.up
            public void update(String str, com.bytedance.sdk.component.adexpress.j.cw.cw cwVar) {
                com.bytedance.sdk.openadsdk.core.cw.xt.j().j(str, cwVar);
            }
        });
    }

    public static void xt() {
        v.xt().j(1);
        if (!f30206r.get()) {
            j();
        }
        Context context = v.getContext();
        if (context != null) {
            try {
                com.bytedance.sdk.openadsdk.core.v.up.j().xt().j(context, com.bytedance.sdk.openadsdk.core.multipro.xt.cw());
            } catch (Exception unused) {
            }
        }
    }

    public static void j(Context context) {
        xt.set(true);
        cw.set(true);
        ae();
        com.bytedance.sdk.openadsdk.core.rn.ed.j(context);
        tl();
        String cw2 = kt.cw();
        com.bytedance.sdk.component.utils.vl.j("appLogID", cw2);
        if (!TextUtils.isEmpty(cw2)) {
            com.bytedance.sdk.openadsdk.core.kt.xt.j(cw2);
        }
        if (com.bytedance.sdk.openadsdk.j.j.j.j() != null) {
            com.bytedance.sdk.openadsdk.j.j.j.j().j(cw2);
        }
        com.bytedance.sdk.component.adexpress.j.xt.xt.j();
        new com.bytedance.sdk.openadsdk.core.r.xt("playable_engine_init").xt(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.tj.1
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.j.xt.xt.xt();
            }
        });
    }
}
