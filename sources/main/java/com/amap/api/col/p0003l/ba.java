package com.amap.api.col.p0003l;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.amap.api.col.p0003l.ca;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.mapcore.MapConfig;
import java.lang.ref.WeakReference;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class ba extends Thread {

    /* renamed from: e, reason: collision with root package name */
    private static int f5731e = 0;

    /* renamed from: f, reason: collision with root package name */
    private static int f5732f = 3;

    /* renamed from: g, reason: collision with root package name */
    private static long f5733g = 30000;

    /* renamed from: h, reason: collision with root package name */
    private static boolean f5734h;

    /* renamed from: a, reason: collision with root package name */
    private WeakReference<Context> f5735a;

    /* renamed from: b, reason: collision with root package name */
    private IAMapDelegate f5736b;

    /* renamed from: c, reason: collision with root package name */
    private b f5737c = null;

    /* renamed from: d, reason: collision with root package name */
    private Handler f5738d = new a(Looper.getMainLooper());

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            Context context;
            super.handleMessage(message);
            if (ba.f5734h) {
                return;
            }
            if (ba.this.f5737c == null) {
                ba baVar = ba.this;
                IAMapDelegate iAMapDelegate = baVar.f5736b;
                if (ba.this.f5735a == null) {
                    context = null;
                } else {
                    context = (Context) ba.this.f5735a.get();
                }
                baVar.f5737c = new b(iAMapDelegate, context);
            }
            z2.a().b(ba.this.f5737c);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class b extends b8 {

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<IAMapDelegate> f5740d;

        /* renamed from: e, reason: collision with root package name */
        private WeakReference<Context> f5741e;

        /* renamed from: g, reason: collision with root package name */
        private ca f5742g;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        final class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ IAMapDelegate f5743a;

            a(IAMapDelegate iAMapDelegate) {
                this.f5743a = iAMapDelegate;
            }

            @Override // java.lang.Runnable
            public final void run() {
                IAMapDelegate iAMapDelegate = this.f5743a;
                if (iAMapDelegate == null || iAMapDelegate.getMapConfig() == null) {
                    return;
                }
                MapConfig mapConfig = this.f5743a.getMapConfig();
                mapConfig.setProFunctionAuthEnable(false);
                if (mapConfig.isUseProFunction()) {
                    this.f5743a.setMapCustomEnable(mapConfig.isCustomStyleEnable(), true);
                    this.f5743a.reloadMapCustomStyle();
                    i2.b(b.this.f5741e == null ? null : (Context) b.this.f5741e.get(), "鉴权失败，当前key没有自定义纹理的使用权限，自定义纹理相关内容，将不会呈现！");
                }
            }
        }

        private void a() {
            IAMapDelegate iAMapDelegate;
            WeakReference<IAMapDelegate> weakReference = this.f5740d;
            if (weakReference == null || weakReference.get() == null || (iAMapDelegate = this.f5740d.get()) == null || iAMapDelegate.getMapConfig() == null) {
                return;
            }
            iAMapDelegate.queueEvent(new a(iAMapDelegate));
        }

        public b(IAMapDelegate iAMapDelegate, Context context) {
            this.f5740d = null;
            this.f5741e = null;
            this.f5740d = new WeakReference<>(iAMapDelegate);
            if (context != null) {
                this.f5741e = new WeakReference<>(context);
            }
        }

        @Override // com.amap.api.col.p0003l.b8
        public final void runTask() {
            ca.a m6;
            WeakReference<Context> weakReference;
            try {
                if (!ba.f5734h) {
                    if (this.f5742g == null && (weakReference = this.f5741e) != null && weakReference.get() != null) {
                        this.f5742g = new ca(this.f5741e.get(), "");
                    }
                    ba.d();
                    if (ba.f5731e > ba.f5732f) {
                        ba.i();
                        a();
                        return;
                    }
                    ca caVar = this.f5742g;
                    if (caVar != null && (m6 = caVar.m()) != null) {
                        if (!m6.f5867d) {
                            a();
                        }
                        ba.i();
                    }
                }
            } catch (Throwable th) {
                v5.p(th, "authForPro", "loadConfigData_uploadException");
                d3.l(c3.f5805e, "auth exception get data " + th.getMessage());
            }
        }
    }

    static /* synthetic */ boolean i() {
        f5734h = true;
        return true;
    }

    private static void j() {
        f5731e = 0;
        f5734h = false;
    }

    @Override // java.lang.Thread
    public final void interrupt() {
        this.f5736b = null;
        this.f5735a = null;
        Handler handler = this.f5738d;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        this.f5738d = null;
        this.f5737c = null;
        j();
        super.interrupt();
    }

    static /* synthetic */ int d() {
        int i6 = f5731e;
        f5731e = i6 + 1;
        return i6;
    }

    private void k() {
        if (f5734h) {
            return;
        }
        int i6 = 0;
        while (i6 <= f5732f) {
            i6++;
            this.f5738d.sendEmptyMessageDelayed(0, i6 * f5733g);
        }
    }

    public ba(Context context, IAMapDelegate iAMapDelegate) {
        this.f5735a = null;
        if (context != null) {
            this.f5735a = new WeakReference<>(context);
        }
        this.f5736b = iAMapDelegate;
        j();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        try {
            k();
        } catch (Throwable th) {
            v5.p(th, "AMapDelegateImpGLSurfaceView", "mVerfy");
            th.printStackTrace();
            d3.l(c3.f5805e, "auth pro exception " + th.getMessage());
        }
    }
}
