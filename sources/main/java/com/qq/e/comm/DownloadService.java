package com.qq.e.comm;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.text.TextUtils;
import com.qq.e.comm.pi.SVSD;
import com.qq.e.comm.util.GDTLogger;
import java.util.LinkedList;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class DownloadService extends Service {

    /* renamed from: a, reason: collision with root package name */
    private SVSD f36709a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f36710b = false;

    /* renamed from: c, reason: collision with root package name */
    private LinkedList<b> f36711c = new LinkedList<>();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.qq.e.comm.managers.a f36712a;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: com.qq.e.comm.DownloadService$a$a, reason: collision with other inner class name */
        class RunnableC0720a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ SVSD f36714a;

            RunnableC0720a(SVSD svsd) {
                this.f36714a = svsd;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f36714a.onCreate();
                while (true) {
                    b bVar = (b) DownloadService.this.f36711c.poll();
                    if (bVar == null) {
                        DownloadService.this.f36709a = this.f36714a;
                        return;
                    }
                    this.f36714a.onStartCommand(bVar.f36716a, bVar.f36717b, bVar.f36718c);
                }
            }
        }

        a(com.qq.e.comm.managers.a aVar) {
            this.f36712a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                SVSD aPKDownloadServiceDelegate = this.f36712a.c().getPOFactory().getAPKDownloadServiceDelegate(DownloadService.this);
                if (aPKDownloadServiceDelegate == null) {
                    GDTLogger.w("DownloadService初始化异常");
                } else {
                    new Handler(Looper.getMainLooper()).post(new RunnableC0720a(aPKDownloadServiceDelegate));
                }
            } catch (Throwable th) {
                GDTLogger.w("DownloadService初始化异常", th);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class b {

        /* renamed from: a, reason: collision with root package name */
        private final Intent f36716a;

        /* renamed from: b, reason: collision with root package name */
        private final int f36717b;

        /* renamed from: c, reason: collision with root package name */
        private final int f36718c;

        private b(Intent intent, int i6, int i7) {
            this.f36716a = intent;
            this.f36717b = i6;
            this.f36718c = i7;
        }

        /* synthetic */ b(Intent intent, int i6, int i7, a aVar) {
            this(intent, i6, i7);
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i6, int i7) {
        if (intent == null) {
            stopSelf(i7);
            return 2;
        }
        if (TextUtils.isEmpty(intent.getStringExtra("GDT_APPID"))) {
            GDTLogger.w("Service onStartCommand 出现异常");
            return 2;
        }
        if (a(false)) {
            return this.f36709a.onStartCommand(intent, i6, i7);
        }
        this.f36711c.add(new b(intent, i6, i7, null));
        return 2;
    }

    public static void enterAPPDownloadListPage(Context context) {
        if (context == null) {
            GDTLogger.e("enterAPPDownloadListPage 调用异常，context为空");
            return;
        }
        Intent intent = new Intent(context, (Class<?>) DownloadService.class);
        intent.putExtra("GDT_APPID", com.qq.e.comm.managers.a.b().a());
        intent.setAction("com.qq.e.comm.ACTION_DOWNLOAD_LIST");
        context.startService(intent);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        SVSD svsd = this.f36709a;
        if (svsd != null) {
            return svsd.onBind(intent);
        }
        if (TextUtils.isEmpty(intent.getStringExtra("GDT_APPID")) || !a(true)) {
            return null;
        }
        return this.f36709a.onBind(intent);
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        SVSD svsd = this.f36709a;
        if (svsd != null) {
            svsd.onConfigurationChanged(configuration);
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        SVSD svsd = this.f36709a;
        if (svsd != null) {
            svsd.onDestroy();
        }
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public void onLowMemory() {
        SVSD svsd = this.f36709a;
        if (svsd != null) {
            svsd.onLowMemory();
        }
    }

    @Override // android.app.Service
    public void onRebind(Intent intent) {
        SVSD svsd = this.f36709a;
        if (svsd != null) {
            svsd.onRebind(intent);
        }
    }

    @Override // android.app.Service
    public void onTaskRemoved(Intent intent) {
        SVSD svsd = this.f36709a;
        if (svsd != null) {
            svsd.onTaskRemoved(intent);
        }
    }

    @Override // android.app.Service, android.content.ComponentCallbacks2
    public void onTrimMemory(int i6) {
        SVSD svsd = this.f36709a;
        if (svsd != null) {
            svsd.onTrimMemory(i6);
        }
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        SVSD svsd = this.f36709a;
        return svsd != null ? svsd.onUnbind(intent) : super.onUnbind(intent);
    }

    private boolean a(boolean z5) {
        if (this.f36709a != null) {
            return true;
        }
        com.qq.e.comm.managers.a b6 = com.qq.e.comm.managers.a.b();
        if (!b6.d()) {
            return false;
        }
        if (!z5) {
            if (this.f36710b) {
                return false;
            }
            this.f36710b = true;
            com.qq.e.comm.managers.a.f36742g.submit(new a(b6));
            return false;
        }
        try {
            SVSD aPKDownloadServiceDelegate = b6.c().getPOFactory().getAPKDownloadServiceDelegate(this);
            this.f36709a = aPKDownloadServiceDelegate;
            aPKDownloadServiceDelegate.onCreate();
            return true;
        } catch (Throwable th) {
            GDTLogger.w("DownloadService初始化异常", th);
            return false;
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
    }
}
