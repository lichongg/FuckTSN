package com.qq.e.comm.managers;

import android.content.Context;
import android.text.TextUtils;
import com.qq.e.ads.dfa.GDTAppDialogClickListener;
import com.qq.e.comm.managers.GDTAdSdk;
import com.qq.e.comm.managers.devtool.DevTools;
import com.qq.e.comm.managers.plugin.PM;
import com.qq.e.comm.managers.plugin.e;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.GDTLogger;
import com.stub.StubApp;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class a implements IGDTAdManager {

    /* renamed from: g, reason: collision with root package name */
    public static final ExecutorService f36742g = Executors.newSingleThreadExecutor();

    /* renamed from: a, reason: collision with root package name */
    private volatile boolean f36743a;

    /* renamed from: b, reason: collision with root package name */
    private volatile boolean f36744b;

    /* renamed from: c, reason: collision with root package name */
    private volatile Context f36745c;

    /* renamed from: d, reason: collision with root package name */
    private volatile PM f36746d;

    /* renamed from: e, reason: collision with root package name */
    private volatile DevTools f36747e;

    /* renamed from: f, reason: collision with root package name */
    private volatile String f36748f;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.qq.e.comm.managers.a$a, reason: collision with other inner class name */
    class RunnableC0721a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ GDTAdSdk.OnStartListener f36749a;

        RunnableC0721a(GDTAdSdk.OnStartListener onStartListener) {
            this.f36749a = onStartListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                POFactory pOFactory = a.this.f36746d.getPOFactory(false, false);
                if (pOFactory == null) {
                    GDTAdSdk.OnStartListener onStartListener = this.f36749a;
                    if (onStartListener != null) {
                        onStartListener.onStartFailed(new Exception("GDTAdSdk start异常"));
                        return;
                    }
                    return;
                }
                pOFactory.start(a.this.f36746d.getStartCaller(1));
                GDTAdSdk.OnStartListener onStartListener2 = this.f36749a;
                if (onStartListener2 != null) {
                    onStartListener2.onStartSuccess();
                }
            } catch (e e6) {
                GDTLogger.e(e6.getMessage(), e6);
                GDTAdSdk.OnStartListener onStartListener3 = this.f36749a;
                if (onStartListener3 != null) {
                    onStartListener3.onStartFailed(e6);
                }
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f36751a;

        b(boolean z5) {
            this.f36751a = z5;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                a.this.f36746d.getPOFactory(this.f36751a, true);
                a.this.f36744b = true;
            } catch (e e6) {
                GDTLogger.e(e6.getMessage(), e6);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class c {

        /* renamed from: a, reason: collision with root package name */
        private static a f36753a = new a(null);
    }

    private a() {
        this.f36743a = false;
        this.f36744b = false;
    }

    public static a b() {
        return c.f36753a;
    }

    /* synthetic */ a(RunnableC0721a runnableC0721a) {
        this();
    }

    synchronized boolean b(Context context, String str, boolean z5) {
        if (this.f36743a) {
            return true;
        }
        if (context == null || TextUtils.isEmpty(str)) {
            GDTLogger.e("GDTADManager初始化错误，context和appId不能为空");
            return false;
        }
        try {
            a(context, str, z5);
            this.f36743a = true;
            return true;
        } catch (Throwable th) {
            GDTLogger.e("GDTADManager初始化错误", th);
            return false;
        }
    }

    public PM c() {
        return this.f36746d;
    }

    public boolean d() {
        if (this.f36743a) {
            return true;
        }
        GDTLogger.e("SDK 尚未初始化，请在 Application 中调用 GDTAdSdk.initWithoutStart() 初始化");
        return false;
    }

    @Override // com.qq.e.comm.managers.IGDTAdManager
    public DevTools getDevTools() {
        if (this.f36747e == null) {
            this.f36747e = new DevTools();
        }
        return this.f36747e;
    }

    @Override // com.qq.e.comm.managers.IGDTAdManager
    public int showOpenOrInstallAppDialog(GDTAppDialogClickListener gDTAppDialogClickListener) {
        if (!this.f36744b) {
            return 0;
        }
        try {
            return this.f36746d.getPOFactory().showOpenOrInstallAppDialog(gDTAppDialogClickListener);
        } catch (Exception e6) {
            GDTLogger.e("SDK 初始化异常", e6);
            return 0;
        }
    }

    private void a(Context context, String str, boolean z5) {
        this.f36748f = str;
        this.f36745c = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.f36746d = new PM(this.f36745c, null);
        f36742g.submit(new b(z5));
    }

    @Override // com.qq.e.comm.managers.IGDTAdManager
    public String getBuyerId(Map<String, Object> map) {
        if (!d()) {
            return "";
        }
        try {
            return this.f36746d.getPOFactory().getBuyerId(map);
        } catch (Exception e6) {
            GDTLogger.e("SDK 初始化异常", e6);
            return "";
        }
    }

    @Override // com.qq.e.comm.managers.IGDTAdManager
    public String getSDKInfo(String str) {
        if (!d()) {
            return "";
        }
        try {
            return this.f36746d.getPOFactory().getSDKInfo(str);
        } catch (Exception e6) {
            GDTLogger.e("SDK 初始化异常", e6);
            return "";
        }
    }

    public String a() {
        return this.f36748f;
    }

    synchronized void a(GDTAdSdk.OnStartListener onStartListener) {
        if (this.f36743a) {
            f36742g.submit(new RunnableC0721a(onStartListener));
            return;
        }
        GDTLogger.e("在调用start方法前请先调用initWithoutStart方法");
        if (onStartListener != null) {
            onStartListener.onStartFailed(new Exception("在调用start方法前请先调用initWithoutStart方法"));
        }
    }
}
