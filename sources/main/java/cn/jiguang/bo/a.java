package cn.jiguang.bo;

import android.content.Context;
import android.os.Debug;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: D:\Downloads\app\classes2.dex */
final class a extends Thread {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f2401a;

    /* renamed from: b, reason: collision with root package name */
    private final InterfaceC0035a f2402b;

    /* renamed from: c, reason: collision with root package name */
    private final e f2403c;

    /* renamed from: d, reason: collision with root package name */
    private final long f2404d;

    /* renamed from: e, reason: collision with root package name */
    private final AtomicLong f2405e;

    /* renamed from: f, reason: collision with root package name */
    private final AtomicBoolean f2406f;

    /* renamed from: g, reason: collision with root package name */
    private final Context f2407g;

    /* renamed from: h, reason: collision with root package name */
    private final cn.jiguang.by.b f2408h;

    /* renamed from: cn.jiguang.bo.a$a, reason: collision with other inner class name */
    public interface InterfaceC0035a {
        void a(cn.jiguang.bp.a aVar);
    }

    a(long j6, boolean z5, InterfaceC0035a interfaceC0035a, Context context) {
        this(j6, z5, interfaceC0035a, new f(), context);
    }

    a(long j6, boolean z5, InterfaceC0035a interfaceC0035a, e eVar, Context context) {
        this.f2405e = new AtomicLong(0L);
        this.f2406f = new AtomicBoolean(false);
        this.f2408h = new cn.jiguang.by.b() { // from class: cn.jiguang.bo.a.1
            @Override // cn.jiguang.by.b
            public void a() {
                a.this.f2405e.set(0L);
                a.this.f2406f.set(false);
            }
        };
        this.f2401a = z5;
        this.f2402b = interfaceC0035a;
        this.f2404d = j6;
        this.f2403c = eVar;
        this.f2407g = context;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        setName("jg_anr_watchdog");
        long j6 = this.f2404d;
        while (!isInterrupted()) {
            if (!i.a()) {
                cn.jiguang.bb.f.c("ANRWatchDog", "isSentrySample1 false");
                return;
            }
            boolean z5 = this.f2405e.get() == 0;
            this.f2405e.addAndGet(j6);
            if (z5) {
                this.f2403c.a(this.f2408h);
            }
            try {
                Thread.sleep(j6);
                if (this.f2405e.get() != 0 && !this.f2406f.get()) {
                    if (!this.f2401a && (Debug.isDebuggerConnected() || Debug.waitingForDebugger())) {
                        cn.jiguang.bb.f.i("ANRWatchDog", "An ANR was detected but ignored because the debugger is connected.");
                    } else {
                        if (!i.a()) {
                            cn.jiguang.bb.f.c("ANRWatchDog", "isSentrySample2 false");
                            return;
                        }
                        cn.jiguang.bb.f.i("ANRWatchDog", "Raising ANR");
                        this.f2402b.a(new cn.jiguang.bp.a("Application Not Responding for at least " + this.f2404d + " ms.", this.f2403c.a()));
                        j6 = this.f2404d;
                    }
                    this.f2406f.set(true);
                }
            } catch (InterruptedException e6) {
                Thread.currentThread().interrupt();
                cn.jiguang.bb.f.i("ANRWatchDog", String.format("Interrupted: %s", e6.getMessage()));
                return;
            }
        }
    }
}
