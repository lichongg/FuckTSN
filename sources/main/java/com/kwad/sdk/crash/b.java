package com.kwad.sdk.crash;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.crash.g;
import com.kwad.sdk.crash.handler.AnrHandler;
import com.kwad.sdk.crash.handler.NativeCrashHandler;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ag;
import java.io.File;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class b {
    private static volatile boolean aOf;
    private static volatile boolean aOg;
    private static volatile boolean aOh;
    private static Handler acR = new Handler(Looper.getMainLooper());
    private static final AtomicBoolean ISLOADED = new AtomicBoolean(false);
    private static final String[] aOi = {"c++_shared", "plt-base", "plt-unwind", "exception-handler"};
    private static boolean aOj = false;
    private static boolean aOk = false;

    private static boolean bZ(Context context) {
        return context == null || ag.cV(context) >= 3;
    }

    public static boolean La() {
        if (ISLOADED.get()) {
            return true;
        }
        try {
            for (String str : aOi) {
                com.kwad.sdk.core.d.c.d("AnrAndNativeExceptionCollector", "loadExceptionLibSo load " + str);
                System.loadLibrary(str);
            }
            ISLOADED.set(true);
            return true;
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
            com.kwad.sdk.core.d.c.w("AnrAndNativeExceptionCollector", "loadExceptionLibSo fail\n" + Log.getStackTraceString(th));
            ISLOADED.set(false);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void Lb() {
        if (Build.VERSION.SDK_INT <= 23) {
            com.kwad.sdk.core.d.c.w("AnrAndNativeExceptionCollector", "initNativeFunc 版本过低, 会有崩溃");
            return;
        }
        com.kwad.sdk.core.d.c.w("AnrAndNativeExceptionCollector", "ExceptionSoLoadHelper.init onLoad：enableAnrReport:" + aOj + " *enableNativeReport" + aOk);
        if (aOj) {
            Lc();
        }
        if (aOk) {
            c(false, "/sdcard/");
        }
    }

    private static synchronized void Ld() {
        synchronized (b.class) {
            if (!aOf) {
                aOf = true;
                com.kwad.sdk.utils.h.schedule(new Runnable() { // from class: com.kwad.sdk.crash.b.8
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            b.Lf();
                        } catch (Throwable unused) {
                        }
                    }
                }, d.aON, TimeUnit.SECONDS);
            }
        }
    }

    public static synchronized void Le() {
        synchronized (b.class) {
            if (!aOg) {
                aOg = true;
                com.kwad.sdk.utils.h.schedule(new Runnable() { // from class: com.kwad.sdk.crash.b.9
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            b.Lg();
                        } catch (Throwable unused) {
                        }
                    }
                }, d.aON, TimeUnit.SECONDS);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void Lg() {
        if (aOj) {
            Li();
        }
        if (aOk) {
            Lj();
        }
    }

    private static void Lh() {
        com.kwad.sdk.core.d.c.d("AnrAndNativeExceptionCollector", "reportJavaException");
        com.kwad.sdk.crash.report.f fVar = new com.kwad.sdk.crash.report.f();
        fVar.a(com.kwad.sdk.crash.handler.c.LG().getUploader());
        fVar.D(com.kwad.sdk.crash.a.a.LB());
    }

    private static void Li() {
        com.kwad.sdk.core.d.c.d("AnrAndNativeExceptionCollector", "reportAnrException");
        com.kwad.sdk.crash.report.b bVar = new com.kwad.sdk.crash.report.b();
        bVar.a(AnrHandler.getInstance().getUploader());
        bVar.D(com.kwad.sdk.crash.a.a.LC());
    }

    private static void Lj() {
        com.kwad.sdk.core.d.c.d("AnrAndNativeExceptionCollector", "reportNativeException");
        com.kwad.sdk.crash.report.g gVar = new com.kwad.sdk.crash.report.g();
        gVar.a(NativeCrashHandler.getInstance().getUploader());
        gVar.D(com.kwad.sdk.crash.a.a.LD());
    }

    public static void a(@NonNull c cVar) {
        if (cVar.context == null || aOh) {
            return;
        }
        aOh = true;
        try {
            com.kwad.sdk.crash.utils.e.init(cVar.context);
            com.kwad.sdk.crash.a.a.init(cVar.context, cVar.aOy);
            e.Lr().a(cVar);
            ca(cVar.context);
            Ld();
        } catch (Throwable unused) {
        }
    }

    public static void b(c cVar) {
        aOj = cVar.aOj;
        aOk = cVar.aOk;
        if (bZ(cVar.context)) {
            return;
        }
        if (aOj || aOk) {
            g.a(cVar, new g.a() { // from class: com.kwad.sdk.crash.b.1
                @Override // com.kwad.sdk.crash.g.a
                public final void Ll() {
                    com.kwad.sdk.core.d.c.w("AnrAndNativeExceptionCollector", "ExceptionSoLoadHelper.init fail");
                }

                @Override // com.kwad.sdk.crash.g.a
                public final void Lk() {
                    GlobalThreadPools.Jy().execute(new Runnable() { // from class: com.kwad.sdk.crash.b.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            try {
                                b.Lb();
                                b.Le();
                            } catch (Throwable th) {
                                ServiceProvider.reportSdkCaughtException(th);
                            }
                        }
                    });
                }
            });
        }
    }

    public static void n(@NonNull final Throwable th) {
        com.kwad.sdk.utils.h.execute(new Runnable() { // from class: com.kwad.sdk.crash.b.2
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    if (com.kwad.sdk.crash.b.a.o(th)) {
                        com.kwad.sdk.crash.handler.a.p(th);
                    }
                } catch (Throwable th2) {
                    com.kwad.sdk.core.d.c.printStackTrace(th2);
                }
            }
        });
    }

    private static void Lc() {
        AnrHandler.getInstance().init(com.kwad.sdk.crash.a.a.LC(), new f() { // from class: com.kwad.sdk.crash.b.5
            @Override // com.kwad.sdk.crash.f
            public final void a(int i6, ExceptionMessage exceptionMessage) {
                e.Lr().b(i6, exceptionMessage);
            }
        }, new com.kwad.sdk.crash.report.c() { // from class: com.kwad.sdk.crash.b.6
            @Override // com.kwad.sdk.crash.report.e
            public final File Lm() {
                return new File(com.kwad.sdk.crash.a.a.LA(), "anr_log/upload");
            }

            @Override // com.kwad.sdk.crash.report.e
            public final void a(ExceptionMessage exceptionMessage, @Nullable CountDownLatch countDownLatch) {
                if (exceptionMessage == null || TextUtils.isEmpty(exceptionMessage.mCrashDetail) || !com.kwad.sdk.crash.b.a.fD(exceptionMessage.mCrashDetail)) {
                    return;
                }
                com.kwad.sdk.core.d.c.e("AnrAndNativeExceptionCollector", "ANR true upload:" + exceptionMessage.mCrashDetail);
                a(exceptionMessage, 3, countDownLatch);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void Lf() {
        Lh();
    }

    private static void c(boolean z5, String str) {
        if (!com.kwad.sdk.crash.a.a.A(com.kwad.sdk.crash.a.a.LD())) {
            return;
        }
        NativeCrashHandler.getInstance().init(com.kwad.sdk.crash.a.a.LD(), false, str, new com.kwad.sdk.crash.report.c() { // from class: com.kwad.sdk.crash.b.7
            @Override // com.kwad.sdk.crash.report.e
            public final File Lm() {
                return new File(com.kwad.sdk.crash.a.a.LA(), "native_crash_log/upload");
            }

            @Override // com.kwad.sdk.crash.report.e
            public final void a(ExceptionMessage exceptionMessage, @Nullable CountDownLatch countDownLatch) {
                try {
                    com.kwad.sdk.core.d.c.d("AnrAndNativeExceptionCollector", "Native upload");
                    if (exceptionMessage == null) {
                        com.kwad.sdk.core.d.c.w("AnrAndNativeExceptionCollector", "Native upload but msg is null");
                        return;
                    }
                    if (com.kwad.sdk.crash.b.a.fC(exceptionMessage.mThreadName) || com.kwad.sdk.crash.b.a.fD(exceptionMessage.mCrashDetail)) {
                        com.kwad.sdk.core.d.c.d("AnrAndNativeExceptionCollector", "true upload msg:" + exceptionMessage.mCrashDetail);
                        a(exceptionMessage, 4, countDownLatch);
                    }
                } catch (Throwable unused) {
                }
            }
        });
    }

    private static void ca(Context context) {
        com.kwad.sdk.crash.handler.c.LG().init(com.kwad.sdk.crash.a.a.LB(), new f() { // from class: com.kwad.sdk.crash.b.3
            @Override // com.kwad.sdk.crash.f
            public final void a(int i6, ExceptionMessage exceptionMessage) {
                e.Lr().b(i6, exceptionMessage);
            }
        }, new com.kwad.sdk.crash.report.c() { // from class: com.kwad.sdk.crash.b.4
            @Override // com.kwad.sdk.crash.report.e
            public final void a(ExceptionMessage exceptionMessage, @Nullable CountDownLatch countDownLatch) {
                a(exceptionMessage, 1, countDownLatch);
            }

            @Override // com.kwad.sdk.crash.report.e
            public final File Lm() {
                return new File(com.kwad.sdk.crash.a.a.LA(), "java_crash/upload");
            }
        });
        Thread.setDefaultUncaughtExceptionHandler(new com.kwad.sdk.crash.handler.d(context));
    }
}
