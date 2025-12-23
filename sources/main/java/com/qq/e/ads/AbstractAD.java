package com.qq.e.ads;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.qq.e.comm.constants.ErrorCode;
import com.qq.e.comm.managers.a;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.GDTLogger;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public abstract class AbstractAD<T> {

    /* renamed from: g, reason: collision with root package name */
    private static final AtomicBoolean f36544g = new AtomicBoolean(true);

    /* renamed from: a, reason: collision with root package name */
    protected T f36545a;

    /* renamed from: e, reason: collision with root package name */
    private volatile boolean f36549e;

    /* renamed from: c, reason: collision with root package name */
    private volatile boolean f36547c = false;

    /* renamed from: d, reason: collision with root package name */
    private volatile boolean f36548d = false;

    /* renamed from: f, reason: collision with root package name */
    private volatile long f36550f = -1;

    /* renamed from: b, reason: collision with root package name */
    private final Handler f36546b = new Handler(Looper.getMainLooper());

    protected abstract T a(Context context, POFactory pOFactory, String str, String str2, String str3);

    protected abstract void a(T t5);

    protected abstract void b(int i6);

    private void b(Context context, String str, String str2) {
        this.f36549e = true;
        if (a.b().d()) {
            a(context, a.b().a(), str, str2);
        } else {
            a(2003);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (this.f36550f > 0) {
            try {
                GlobalSetting.getSettings().putOpt("gdtwict", Long.valueOf(SystemClock.elapsedRealtime() - this.f36550f));
            } catch (Throwable unused) {
            }
        }
    }

    protected final void a(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            b(context, str, "");
        } else {
            GDTLogger.e("初始化错误：参数错误context或posId为空");
            a(2001);
        }
    }

    protected final boolean b() {
        if (!this.f36547c && f36544g.compareAndSet(true, false)) {
            this.f36550f = SystemClock.elapsedRealtime();
        }
        return this.f36547c;
    }

    protected final void a(Context context, String str, String str2) {
        if (context != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            b(context, str, str2);
        } else {
            GDTLogger.e("初始化错误：参数错误，context、posId、token 不可为空");
            a(2001);
        }
    }

    private final void a(final Context context, final String str, final String str2, final String str3) {
        if (com.qq.e.comm.a.a(context)) {
            this.f36548d = true;
            a.f36742g.execute(new Runnable() { // from class: com.qq.e.ads.AbstractAD.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        final POFactory pOFactory = a.b().c().getPOFactory();
                        AbstractAD.this.f36546b.post(new Runnable() { // from class: com.qq.e.ads.AbstractAD.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    POFactory pOFactory2 = pOFactory;
                                    if (pOFactory2 == null) {
                                        AbstractAD.this.f36547c = true;
                                        AbstractAD.this.a(ErrorCode.PLUGIN_INIT_ERROR);
                                        return;
                                    }
                                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                    AbstractAD abstractAD = AbstractAD.this;
                                    abstractAD.f36545a = (T) abstractAD.a(context, pOFactory2, str, str2, str3);
                                    AbstractAD.this.f36547c = true;
                                    AbstractAD abstractAD2 = AbstractAD.this;
                                    if (abstractAD2.f36545a == null) {
                                        abstractAD2.a(ErrorCode.POFACTORY_GET_INTERFACE_ERROR);
                                        return;
                                    }
                                    abstractAD2.c();
                                    AbstractAD abstractAD3 = AbstractAD.this;
                                    abstractAD3.a((AbstractAD) abstractAD3.f36545a);
                                } catch (Throwable th) {
                                    GDTLogger.e("初始化错误：初始化广告实例时发生异常", th);
                                    AbstractAD.this.f36547c = true;
                                    AbstractAD.this.a(2001);
                                }
                            }
                        });
                    } catch (Throwable th) {
                        GDTLogger.e("初始化错误：初始化插件时发生异常", th);
                        AbstractAD.this.f36547c = true;
                        AbstractAD.this.a(ErrorCode.PLUGIN_INIT_ERROR);
                    }
                }
            });
        } else {
            GDTLogger.e("Manifest文件中Activity/Service/Permission的声明有问题或者Permission权限未授予");
            a(4002);
        }
    }

    protected final void a(final int i6) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            b(i6);
        } else {
            this.f36546b.post(new Runnable() { // from class: com.qq.e.ads.AbstractAD.2
                @Override // java.lang.Runnable
                public void run() {
                    AbstractAD.this.b(i6);
                }
            });
        }
    }

    protected final boolean a() {
        return this.f36549e && this.f36548d;
    }

    protected final void a(String str) {
        GDTLogger.e(getClass().getSimpleName() + ":调用方法 " + str + "异常，广告实例还未初始化");
    }
}
