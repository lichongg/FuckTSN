package cn.jpush.android.ad;

import cn.jiguang.api.JCoreManager;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.local.JPushConstants;
import java.lang.Thread;

/* loaded from: D:\Downloads\app\classes2.dex */
public abstract class f implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private Thread.UncaughtExceptionHandler f3442a;

    /* renamed from: e, reason: collision with root package name */
    protected String f3443e;

    protected f() {
        this.f3442a = new Thread.UncaughtExceptionHandler() { // from class: cn.jpush.android.ad.f.1
            @Override // java.lang.Thread.UncaughtExceptionHandler
            public void uncaughtException(Thread thread, Throwable th) {
                JCoreManager.onEvent(null, JPushConstants.SDK_TYPE, 93, null, null, thread, th);
                StringBuilder sb = new StringBuilder();
                sb.append("name: ");
                sb.append(f.this.f3443e);
                sb.append(", thread id:");
                sb.append(thread != null ? thread.getName() : "");
                sb.append("-");
                sb.append(thread != null ? Long.valueOf(thread.getId()) : "");
                sb.append("\n e:");
                sb.append(th);
                Logger.e("JPushRunnable", sb.toString());
            }
        };
    }

    public abstract void a();

    protected f(String str) {
        this.f3443e = str;
        this.f3442a = new Thread.UncaughtExceptionHandler() { // from class: cn.jpush.android.ad.f.2
            @Override // java.lang.Thread.UncaughtExceptionHandler
            public void uncaughtException(Thread thread, Throwable th) {
                JCoreManager.onEvent(null, JPushConstants.SDK_TYPE, 93, null, null, thread, th);
                StringBuilder sb = new StringBuilder();
                sb.append("name: ");
                sb.append(f.this.f3443e);
                sb.append(", thread id: ");
                sb.append(thread != null ? thread.getName() : "");
                sb.append("-");
                sb.append(thread != null ? Long.valueOf(thread.getId()) : "");
                sb.append("\n e:");
                sb.append(th);
                Logger.e("JPushRunnable", sb.toString());
            }
        };
    }

    @Override // java.lang.Runnable
    public void run() {
        Thread.currentThread().setUncaughtExceptionHandler(this.f3442a);
        a();
        Thread.currentThread().setUncaughtExceptionHandler(null);
    }
}
