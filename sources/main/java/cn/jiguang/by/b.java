package cn.jiguang.by;

import cn.jiguang.bb.f;
import cn.jiguang.bo.h;
import java.lang.Thread;

/* loaded from: D:\Downloads\app\classes2.dex */
public abstract class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private Thread.UncaughtExceptionHandler f2652a;

    /* renamed from: h, reason: collision with root package name */
    protected String f2653h;

    protected b() {
        this.f2652a = new Thread.UncaughtExceptionHandler() { // from class: cn.jiguang.by.b.1
            @Override // java.lang.Thread.UncaughtExceptionHandler
            public void uncaughtException(Thread thread, Throwable th) {
                String str;
                h.a().a(thread, th);
                StringBuilder sb = new StringBuilder();
                sb.append("name: ");
                sb.append(b.this.f2653h);
                sb.append(", thread id:");
                Object obj = "";
                if (thread == null) {
                    str = "";
                } else {
                    str = thread.getName();
                }
                sb.append(str);
                sb.append("-");
                if (thread != null) {
                    obj = Long.valueOf(thread.getId());
                }
                sb.append(obj);
                sb.append("\n e:");
                sb.append(th);
                f.l("JCoreRunnable", sb.toString());
            }
        };
    }

    public abstract void a();

    protected b(String str) {
        this.f2653h = str;
        this.f2652a = new Thread.UncaughtExceptionHandler() { // from class: cn.jiguang.by.b.2
            @Override // java.lang.Thread.UncaughtExceptionHandler
            public void uncaughtException(Thread thread, Throwable th) {
                String str2;
                h.a().a(thread, th);
                StringBuilder sb = new StringBuilder();
                sb.append("name: ");
                sb.append(b.this.f2653h);
                sb.append(", thread id: ");
                Object obj = "";
                if (thread == null) {
                    str2 = "";
                } else {
                    str2 = thread.getName();
                }
                sb.append(str2);
                sb.append("-");
                if (thread != null) {
                    obj = Long.valueOf(thread.getId());
                }
                sb.append(obj);
                sb.append("\n e:");
                sb.append(th);
                f.l("JCoreRunnable", sb.toString());
            }
        };
    }

    @Override // java.lang.Runnable
    public void run() {
        Thread.currentThread().setUncaughtExceptionHandler(this.f2652a);
        a();
        Thread.currentThread().setUncaughtExceptionHandler(null);
    }
}
