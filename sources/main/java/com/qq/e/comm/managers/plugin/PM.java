package com.qq.e.comm.managers.plugin;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.qq.e.comm.constants.Sig;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.GDTLogger;
import com.stub.StubApp;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class PM {
    public static final int CALL_START_BY_DEV = 1;

    /* renamed from: s, reason: collision with root package name */
    private static final Map<Class<?>, String> f36755s = new b();

    /* renamed from: b, reason: collision with root package name */
    private final Context f36757b;

    /* renamed from: c, reason: collision with root package name */
    private String f36758c;

    /* renamed from: d, reason: collision with root package name */
    private File f36759d;

    /* renamed from: e, reason: collision with root package name */
    private volatile int f36760e;

    /* renamed from: f, reason: collision with root package name */
    private DexClassLoader f36761f;

    /* renamed from: g, reason: collision with root package name */
    private RandomAccessFile f36762g;

    /* renamed from: h, reason: collision with root package name */
    private FileLock f36763h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f36764i;

    /* renamed from: j, reason: collision with root package name */
    private volatile POFactory f36765j;

    /* renamed from: k, reason: collision with root package name */
    private int f36766k;

    /* renamed from: l, reason: collision with root package name */
    private int f36767l;

    /* renamed from: m, reason: collision with root package name */
    private Future<Boolean> f36768m;

    /* renamed from: o, reason: collision with root package name */
    private boolean f36770o;

    /* renamed from: p, reason: collision with root package name */
    private String f36771p;

    /* renamed from: q, reason: collision with root package name */
    private JSONObject f36772q;

    /* renamed from: r, reason: collision with root package name */
    private int f36773r;

    /* renamed from: a, reason: collision with root package name */
    final ExecutorService f36756a = Executors.newSingleThreadExecutor();

    /* renamed from: n, reason: collision with root package name */
    private boolean f36769n = false;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements Callable<Boolean> {
        a() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean call() throws Exception {
            long currentTimeMillis = System.currentTimeMillis();
            h.b(PM.this.f36757b);
            PM.this.i();
            if (!PM.this.f36764i) {
                PM pm = PM.this;
                pm.f36764i = pm.tryLockUpdate();
            }
            if (PM.this.h()) {
                PM.this.f36767l = (int) (System.currentTimeMillis() - currentTimeMillis);
                PM.this.e();
            }
            PM.this.f36766k = (int) (System.currentTimeMillis() - currentTimeMillis);
            return Boolean.TRUE;
        }
    }

    private void b() {
    }

    private void g() {
        this.f36769n = false;
        this.f36768m = this.f36756a.submit(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x000e, code lost:
    
        if (d() != false) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean h() {
        /*
            r3 = this;
            r0 = 0
            java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L11
            boolean r1 = r3.f()     // Catch: java.lang.Throwable -> L11
            if (r1 != 0) goto L13
            boolean r1 = r3.d()     // Catch: java.lang.Throwable -> L11
            if (r1 == 0) goto L14
            goto L13
        L11:
            r1 = move-exception
            goto L18
        L13:
            r0 = 1
        L14:
            java.lang.System.currentTimeMillis()
            return r0
        L18:
            java.lang.String r2 = "插件加载出现异常"
            com.qq.e.comm.util.GDTLogger.e(r2, r1)     // Catch: java.lang.Throwable -> L28
            java.lang.String r2 = r1.getMessage()     // Catch: java.lang.Throwable -> L28
            com.qq.e.comm.managers.plugin.a.a(r1, r2)     // Catch: java.lang.Throwable -> L28
            java.lang.System.currentTimeMillis()
            return r0
        L28:
            r0 = move-exception
            java.lang.System.currentTimeMillis()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.managers.plugin.PM.h():boolean");
    }

    public POFactory getPOFactory() throws e {
        return getPOFactory(true, false);
    }

    public boolean tryLockUpdate() {
        try {
            File d6 = h.d(this.f36757b);
            if (!d6.exists()) {
                d6.createNewFile();
                h.a("lock", d6);
            }
            if (!d6.exists()) {
                return false;
            }
            RandomAccessFile randomAccessFile = new RandomAccessFile(d6, "rw");
            this.f36762g = randomAccessFile;
            FileLock tryLock = randomAccessFile.getChannel().tryLock();
            this.f36763h = tryLock;
            if (tryLock == null) {
                return false;
            }
            this.f36762g.writeByte(37);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends HashMap<Class<?>, String> {
        b() {
            put(POFactory.class, "com.qq.e.comm.plugin.POFactoryImpl");
        }
    }

    private ClassLoader c() {
        return Sig.ASSET_PLUGIN_SIG == null ? getClass().getClassLoader() : this.f36761f;
    }

    private boolean d() {
        if (!this.f36764i) {
            return false;
        }
        try {
            this.f36773r = 1;
            Context context = this.f36757b;
            com.qq.e.comm.managers.plugin.b.a(context, h.h(context), h.i(this.f36757b));
            this.f36758c = Sig.ASSET_PLUGIN_SIG;
            this.f36759d = h.h(this.f36757b);
            this.f36760e = SDKStatus.getBuildInPluginVersion();
            return true;
        } catch (Throwable th) {
            GDTLogger.e("插件初始化失败 ");
            com.qq.e.comm.managers.plugin.a.a(th, th.getMessage());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        File file = this.f36759d;
        if (file != null) {
            file.getAbsolutePath();
        }
        if (this.f36758c == null || this.f36759d == null) {
            this.f36761f = null;
            return;
        }
        try {
            this.f36761f = new DexClassLoader(this.f36759d.getAbsolutePath(), h.c(this.f36757b).getAbsolutePath(), null, getClass().getClassLoader());
            j();
        } catch (Throwable th) {
            GDTLogger.e("插件ClassLoader构造发生异常", th);
            b();
            com.qq.e.comm.managers.plugin.a.a(th, th.getMessage());
        }
    }

    private boolean f() {
        if (this.f36770o) {
            return false;
        }
        if (this.f36764i) {
            g gVar = new g(h.e(this.f36757b), h.f(this.f36757b));
            if (gVar.a(this.f36757b, false)) {
                this.f36773r = 3;
                h.a(this.f36757b);
                gVar.a(h.h(this.f36757b), h.i(this.f36757b), this.f36757b);
            }
        }
        g gVar2 = new g(h.h(this.f36757b), h.i(this.f36757b));
        if (!gVar2.a(this.f36757b, true)) {
            return false;
        }
        if (gVar2.b() < SDKStatus.getBuildInPluginVersion()) {
            SDKStatus.getBuildInPluginVersion();
            return false;
        }
        if (this.f36773r == 0) {
            this.f36773r = 2;
        }
        this.f36758c = gVar2.a();
        this.f36760e = gVar2.b();
        this.f36759d = h.h(this.f36757b);
        this.f36771p = gVar2.c();
        this.f36769n = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        SharedPreferences sharedPreferences = this.f36757b.getSharedPreferences("start_crash", 0);
        if (sharedPreferences.getInt("crash_count", 0) >= 2) {
            this.f36770o = true;
            sharedPreferences.edit().remove("crash_count").commit();
            GDTLogger.e("加载本地插件");
        }
    }

    private void k() {
        Future<Boolean> future = this.f36768m;
        if (future != null) {
            try {
                future.get();
            } catch (InterruptedException | ExecutionException unused) {
            }
        }
    }

    public POFactory getPOFactory(boolean z5, boolean z6) throws e {
        if (this.f36765j == null) {
            synchronized (this) {
                if (this.f36765j == null) {
                    try {
                        this.f36765j = (POFactory) getFactory(POFactory.class);
                    } catch (e e6) {
                        if (!this.f36769n) {
                            throw e6;
                        }
                        GDTLogger.e("插件加载错误，回退到内置版本");
                        this.f36770o = true;
                        g();
                        this.f36765j = (POFactory) getFactory(POFactory.class);
                    }
                }
            }
        }
        if (z5 && this.f36765j != null) {
            this.f36765j.start(getStartCaller(z6 ? 0 : 2));
        }
        return this.f36765j;
    }

    public JSONObject getStartCaller(int i6) {
        if (this.f36772q == null) {
            this.f36772q = new JSONObject();
        }
        try {
            this.f36772q.put("scr", i6);
        } catch (JSONException unused) {
        }
        return this.f36772q;
    }

    public PM(Context context, f fVar) {
        this.f36757b = StubApp.getOrigApplicationContext(context.getApplicationContext());
        i.a(context);
        g();
    }

    public <T> T getFactory(Class<T> cls) throws e {
        k();
        Objects.toString(cls);
        ClassLoader c6 = c();
        getClass().getClassLoader();
        if (c6 != null) {
            try {
                String str = f36755s.get(cls);
                if (!TextUtils.isEmpty(str)) {
                    Class<?> loadClass = c6.loadClass(str);
                    T cast = cls.cast(loadClass.getDeclaredMethod("getInstance", Context.class, JSONObject.class).invoke(loadClass, this.f36757b, a()));
                    Objects.toString(cast);
                    return cast;
                }
                throw new e("factory  implemention name is not specified for interface:" + cls.getName());
            } catch (Throwable th) {
                throw new e("Fail to getfactory implement instance for interface:" + cls.getName(), th);
            }
        }
        throw new e("Fail to init GDTADPLugin,PluginClassLoader == null;while loading factory impl for:" + cls);
    }

    public int getPluginVersion() {
        k();
        return this.f36760e;
    }

    private JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            int pluginVersion = getPluginVersion();
            if (pluginVersion > 10000) {
                jSONObject.put("vas", this.f36771p);
            }
            jSONObject.put("pv", pluginVersion);
            jSONObject.put("sig", this.f36758c);
            jSONObject.put("appId", com.qq.e.comm.managers.a.b().a());
            jSONObject.put("pn", i.a(this.f36757b));
            jSONObject.put("ict", this.f36766k);
            jSONObject.put("mup", this.f36764i);
            jSONObject.put("ifg", this.f36773r);
            jSONObject.put("pct", this.f36767l);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    private void j() {
    }
}
