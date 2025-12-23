package com.baidu.mobads.sdk.internal;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.mobads.sdk.api.IXAdContainerFactory;
import com.stub.StubApp;
import java.io.File;
import java.io.FileInputStream;
import java.lang.Thread;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class ca {

    /* renamed from: a, reason: collision with root package name */
    public static final String f10835a = "ApkLoader";

    /* renamed from: b, reason: collision with root package name */
    protected static Thread.UncaughtExceptionHandler f10836b = null;

    /* renamed from: c, reason: collision with root package name */
    public static final String f10837c = "__badApkVersion__9.40";

    /* renamed from: d, reason: collision with root package name */
    public static final String f10838d = "previousProxyVersion";

    /* renamed from: e, reason: collision with root package name */
    protected static final String f10839e = "__xadsdk__remote__final__";

    /* renamed from: f, reason: collision with root package name */
    protected static final String f10840f = "bdxadsdk.jar";

    /* renamed from: g, reason: collision with root package name */
    protected static final String f10841g = "__xadsdk__remote__final__builtin__.jar";

    /* renamed from: h, reason: collision with root package name */
    protected static final String f10842h = "__xadsdk__remote__final__builtinversion__.jar";

    /* renamed from: i, reason: collision with root package name */
    protected static final String f10843i = "__xadsdk__remote__final__downloaded__.jar";

    /* renamed from: j, reason: collision with root package name */
    protected static final String f10844j = "__xadsdk__remote__final__running__.jar";

    /* renamed from: k, reason: collision with root package name */
    public static final String f10845k = "OK";

    /* renamed from: l, reason: collision with root package name */
    public static final String f10846l = "ERROR";

    /* renamed from: m, reason: collision with root package name */
    public static final String f10847m = "APK_INFO";

    /* renamed from: n, reason: collision with root package name */
    public static final String f10848n = "CODE";

    /* renamed from: o, reason: collision with root package name */
    public static final String f10849o = "success";

    /* renamed from: p, reason: collision with root package name */
    protected static volatile bp f10850p = null;

    /* renamed from: q, reason: collision with root package name */
    protected static volatile bp f10851q = null;

    /* renamed from: r, reason: collision with root package name */
    protected static volatile Class f10852r = null;

    /* renamed from: s, reason: collision with root package name */
    protected static String f10853s = null;

    /* renamed from: t, reason: collision with root package name */
    protected static final Handler f10854t = new cb(Looper.getMainLooper());

    /* renamed from: x, reason: collision with root package name */
    private static final String f10855x = "baidu_sdk_remote";
    private boolean A;
    private CopyOnWriteArrayList<c> B;
    private c C;

    /* renamed from: u, reason: collision with root package name */
    protected Handler f10856u;

    /* renamed from: v, reason: collision with root package name */
    @SuppressLint({"HandlerLeak"})
    protected final Handler f10857v;

    /* renamed from: w, reason: collision with root package name */
    private by f10858w;

    /* renamed from: y, reason: collision with root package name */
    private final Context f10859y;

    /* renamed from: z, reason: collision with root package name */
    private bu f10860z;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface c {
        void a(boolean z5);
    }

    public ca(Activity activity) {
        this(StubApp.getOrigApplicationContext(activity.getApplicationContext()));
    }

    private boolean o() {
        try {
            if (bs.a(c())) {
                return true;
            }
            return bs.a(f());
        } catch (Exception e6) {
            this.f10860z.a(e6);
            return false;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a extends Exception {

        /* renamed from: a, reason: collision with root package name */
        private static final long f10861a = 2978543166232984104L;

        public a(String str) {
            bu.a().c(str);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    protected static final class b extends Exception {

        /* renamed from: a, reason: collision with root package name */
        private static final long f10862a = -7838296421993681751L;

        public b(String str) {
            bu.a().c(str);
        }
    }

    public ca(Context context) {
        this.f10860z = bu.a();
        this.A = false;
        this.f10856u = f10854t;
        this.B = new CopyOnWriteArrayList<>();
        this.f10857v = new cc(this, Looper.getMainLooper());
        this.f10859y = context;
        c(context);
        if (f10836b == null) {
            f10836b = co.a(context);
            co.a(context).a(new cd(this));
        }
        if (Thread.getDefaultUncaughtExceptionHandler() instanceof co) {
            return;
        }
        Thread.setDefaultUncaughtExceptionHandler(f10836b);
    }

    protected static String f() {
        if (TextUtils.isEmpty(f10853s)) {
            return "";
        }
        return f10853s + f10843i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        try {
            File[] listFiles = this.f10859y.getFilesDir().listFiles();
            int i6 = 0;
            while (listFiles != null) {
                if (i6 >= listFiles.length) {
                    return;
                }
                if (listFiles[i6].getAbsolutePath().contains(f10839e) && listFiles[i6].getAbsolutePath().endsWith("dex")) {
                    listFiles[i6].delete();
                }
                i6++;
            }
        } catch (Exception e6) {
            bu.a().c(e6);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SharedPreferences m() {
        return this.f10859y.getSharedPreferences(z.aL, 0);
    }

    protected void e() {
        this.f10860z.a(f10835a, "start load assets file");
        d(this.f10859y);
        String c6 = c();
        bt btVar = new bt(c6, this.f10859y);
        if (!bs.a(btVar)) {
            throw new b("loadBuiltInApk failed: " + c6);
        }
        this.f10860z.a(f10835a, "assets file can read ,will use it ");
        if (c(btVar)) {
            b(true);
        }
    }

    protected void g() {
        if (h() != 2 ? p() : false) {
            this.f10860z.a(f10835a, "load downloaded file success,use it");
            b(true);
            return;
        }
        this.f10860z.a(f10835a, "no downloaded file yet, use built-in apk file");
        try {
            e();
        } catch (b e6) {
            this.f10860z.a(f10835a, "loadBuiltInApk failed: " + e6.toString());
            throw new a("load built-in apk failed" + e6.toString());
        }
    }

    public int h() {
        return StubApp.getOrigApplicationContext(this.f10859y.getApplicationContext()).getSharedPreferences("baidu_cloudControlConfig", 0).getInt("baidu_cloudConfig_pktype", 1);
    }

    public IXAdContainerFactory i() {
        return a(f10850p);
    }

    public IXAdContainerFactory j() {
        return a(f10851q);
    }

    protected void k() {
        if (f10850p != null) {
            f10850p.b();
            f10850p = null;
        }
    }

    private static void c(Context context) {
        if (TextUtils.isEmpty(f10853s)) {
            f10853s = context.getDir(f10855x, 0).getAbsolutePath() + "/";
        }
    }

    protected static String d() {
        if (TextUtils.isEmpty(f10853s)) {
            return "";
        }
        return f10853s + f10842h;
    }

    private boolean n() {
        String string = m().getString(f10838d, null);
        String a6 = a();
        if (string == null || !string.equals(a6)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean p() {
        bt btVar = new bt(f(), this.f10859y);
        if (bs.a(btVar)) {
            try {
                if (!n()) {
                    synchronized (this) {
                        try {
                            this.f10860z.a(f10835a, "loadDownloadedOrBuiltInApk len=" + btVar.length() + ", path=" + btVar.getAbsolutePath());
                            b(btVar);
                            double d6 = (double) m().getFloat(f10837c, -1.0f);
                            this.f10860z.a(f10835a, "downloadedApkFile.getApkVersion(): " + btVar.c() + ", badApkVersion: " + d6);
                            if (btVar.c() != d6) {
                                this.f10860z.a(f10835a, "loaded: " + btVar.getPath());
                            } else {
                                throw new a("downloaded file marked bad, drop it and use built-in");
                            }
                        } finally {
                        }
                    }
                    return true;
                }
                throw new a("XAdApkLoader upgraded, drop stale downloaded file, use built-in instead");
            } catch (a e6) {
                this.f10860z.a(f10835a, "load downloaded apk failed: " + e6.toString() + ", fallback to built-in");
                if (btVar.exists()) {
                    btVar.delete();
                }
                k();
                return false;
            }
        }
        return false;
    }

    protected void b() {
        new File(f()).delete();
    }

    private void b(bt btVar) {
        this.f10860z.a(f10835a, "len=" + btVar.length() + ", path=" + btVar.getAbsolutePath());
        if (f10850p == null) {
            String a6 = a(this.f10859y);
            bt btVar2 = new bt(a6, this.f10859y);
            if (btVar2.exists()) {
                btVar2.delete();
            }
            try {
                bs.a(new FileInputStream(btVar), a6);
            } catch (Exception e6) {
                this.f10860z.c(e6);
            }
            f10850p = new bp(btVar2.b(), this.f10859y);
            try {
                IXAdContainerFactory a7 = f10850p.a();
                this.f10860z.a(f10835a, "preloaded apk.version=" + a7.getRemoteVersion());
                return;
            } catch (a e7) {
                this.f10860z.a(f10835a, "preload local apk " + btVar.getAbsolutePath() + " failed, msg:" + e7.getMessage() + ", v=" + f10850p.f10769b);
                a(e7.getMessage());
                throw e7;
            }
        }
        this.f10860z.a(f10835a, "mApkBuilder already initialized, version: " + f10850p.f10769b);
    }

    protected static String c() {
        if (TextUtils.isEmpty(f10853s)) {
            return "";
        }
        return f10853s + f10841g;
    }

    private static synchronized void d(Context context) {
        synchronized (ca.class) {
            try {
                try {
                    String c6 = c();
                    double b6 = b(c6);
                    bu.a().a(f10835a, "copy assets,compare version=" + Double.valueOf("9.40") + "remote=" + b6);
                    if (Double.valueOf("9.40").doubleValue() != b6) {
                        bt btVar = new bt(c6, context);
                        if (btVar.exists()) {
                            btVar.delete();
                        }
                        bs.a(context, f10840f, c6);
                    }
                } catch (Exception e6) {
                    throw new b("loadBuiltInApk failed: " + e6.toString());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final String a() {
        return "9.40";
    }

    @TargetApi(9)
    protected void a(String str) {
        if (f10850p != null) {
            SharedPreferences.Editor edit = m().edit();
            edit.putFloat(f10837c, (float) f10850p.f10769b);
            edit.apply();
        }
    }

    private boolean c(bt btVar) {
        synchronized (this) {
            b(btVar);
            this.f10860z.a(f10835a, "loaded: " + btVar.getPath());
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z5) {
        Message obtainMessage = this.f10856u.obtainMessage();
        Bundle bundle = new Bundle();
        bundle.putBoolean("success", z5);
        obtainMessage.setData(bundle);
        obtainMessage.what = 0;
        this.f10856u.sendMessage(obtainMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z5) {
        double d6;
        if (z5) {
            try {
                d6 = f10850p.f10769b;
            } catch (Exception unused) {
                return;
            }
        } else {
            d6 = 0.0d;
        }
        ao.a(d6, new cg(this, d6), new ch(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(bt btVar) {
        Class<?> b6 = btVar.b();
        synchronized (this) {
            f10851q = new bp(b6, this.f10859y);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(boolean z5, String str) {
        try {
            co.a(this.f10859y).c();
            CopyOnWriteArrayList<c> copyOnWriteArrayList = this.B;
            if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
                for (int i6 = 0; i6 < this.B.size(); i6++) {
                    c cVar = this.B.get(i6);
                    if (cVar != null) {
                        cVar.a(z5);
                    }
                }
            }
            CopyOnWriteArrayList<c> copyOnWriteArrayList2 = this.B;
            if (copyOnWriteArrayList2 != null) {
                copyOnWriteArrayList2.clear();
            }
        } finally {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z5) {
        if (!z5 && !o()) {
            this.A = true;
        } else {
            a(z5, z5 ? "apk Successfully Loaded" : "apk Load Failed");
        }
        if (this.A) {
            be.a().a((j) new ce(this, z5));
        } else {
            be.a().a(new cf(this, z5), 5L, TimeUnit.SECONDS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(c cVar, Handler handler) {
        CopyOnWriteArrayList<c> copyOnWriteArrayList = this.B;
        if (copyOnWriteArrayList != null && !copyOnWriteArrayList.contains(cVar)) {
            this.B.add(cVar);
        }
        this.f10856u = handler;
        if (f10850p == null) {
            g();
        } else {
            b(true);
        }
    }

    public static String a(Context context) {
        if (TextUtils.isEmpty(f10853s)) {
            f10853s = context.getDir(f10855x, 0).getAbsolutePath() + "/";
        }
        if (TextUtils.isEmpty(f10853s)) {
            return "";
        }
        return f10853s + f10844j;
    }

    public static double b(Context context) {
        try {
            c(context);
            double b6 = b(f());
            String d6 = d();
            if (Double.valueOf("9.40").doubleValue() > b(d6)) {
                bt btVar = new bt(d6, context);
                if (btVar.exists()) {
                    btVar.delete();
                }
                bs.a(context, f10840f, d6);
            }
            return Math.max(b6, b(d()));
        } catch (Exception unused) {
            return 0.0d;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(by byVar) {
        if (byVar.a().booleanValue()) {
            bw a6 = bw.a(this.f10859y, byVar, f10853s, this.f10857v);
            if (!a6.isAlive()) {
                this.f10860z.a(f10835a, "XApkDownloadThread starting ...");
                a6.start();
            } else {
                this.f10860z.a(f10835a, "XApkDownloadThread already started");
                a6.a(byVar.c());
            }
        }
    }

    @TargetApi(9)
    public void a(c cVar, Handler handler) {
        be.a().a((j) new ci(this, cVar, handler));
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0067, code lost:
    
        if (r2 == null) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0048, code lost:
    
        r2.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x004c, code lost:
    
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x004d, code lost:
    
        r5.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0046, code lost:
    
        if (r2 != null) goto L39;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static double b(java.lang.String r5) {
        /*
            r0 = 0
            r2 = 0
            java.lang.Boolean r3 = com.baidu.mobads.sdk.internal.cn.f10907d     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L44
            boolean r3 = r3.booleanValue()     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L44
            if (r3 == 0) goto L51
            java.io.File r3 = new java.io.File     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L44
            r3.<init>(r5)     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L44
            boolean r5 = com.baidu.mobads.sdk.internal.bs.a(r3)     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L44
            if (r5 == 0) goto L46
            java.util.jar.JarFile r5 = new java.util.jar.JarFile     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L44
            r5.<init>(r3)     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L44
            java.util.jar.Manifest r2 = r5.getManifest()     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3f
            java.util.jar.Attributes r2 = r2.getMainAttributes()     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3f
            java.lang.String r3 = "Implementation-Version"
            java.lang.String r2 = r2.getValue(r3)     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3f
            double r2 = java.lang.Double.parseDouble(r2)     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3f
            int r4 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r4 <= 0) goto L3a
            r5.close()     // Catch: java.lang.Exception -> L35
            return r2
        L35:
            r5 = move-exception
            r5.printStackTrace()
            return r2
        L3a:
            r2 = r5
            goto L46
        L3c:
            r0 = move-exception
            r2 = r5
            goto L5c
        L3f:
            r2 = r5
            goto L67
        L42:
            r0 = move-exception
            goto L5c
        L44:
            goto L67
        L46:
            if (r2 == 0) goto L6a
        L48:
            r2.close()     // Catch: java.lang.Exception -> L4c
            goto L6a
        L4c:
            r5 = move-exception
            r5.printStackTrace()
            goto L6a
        L51:
            java.lang.String r5 = "9.40"
            java.lang.Double r5 = java.lang.Double.valueOf(r5)     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L44
            double r0 = r5.doubleValue()     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L44
            return r0
        L5c:
            if (r2 == 0) goto L66
            r2.close()     // Catch: java.lang.Exception -> L62
            goto L66
        L62:
            r5 = move-exception
            r5.printStackTrace()
        L66:
            throw r0
        L67:
            if (r2 == 0) goto L6a
            goto L48
        L6a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.sdk.internal.ca.b(java.lang.String):double");
    }

    public void a(c cVar) {
        a(cVar, f10854t);
    }

    private IXAdContainerFactory a(bp bpVar) {
        if (bpVar != null) {
            try {
                return bpVar.a();
            } catch (Exception unused) {
            }
        }
        return null;
    }
}
