package com.tencent.open.log;

import com.tencent.open.log.d;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public abstract class Tracer {

    /* renamed from: a, reason: collision with root package name */
    private volatile int f40581a;

    /* renamed from: b, reason: collision with root package name */
    private volatile boolean f40582b;

    /* renamed from: c, reason: collision with root package name */
    private g f40583c;

    public Tracer() {
        this(c.f40605a, true, g.f40626a);
    }

    public void a(int i6, Thread thread, long j6, String str, String str2, Throwable th) {
        if (d() && d.a.a(this.f40581a, i6)) {
            doTrace(i6, thread, j6, str, str2, th);
        }
    }

    protected abstract void doTrace(int i6, Thread thread, long j6, String str, String str2, Throwable th);

    public Tracer(int i6, boolean z5, g gVar) {
        this.f40581a = c.f40605a;
        this.f40582b = true;
        this.f40583c = g.f40626a;
        a(i6);
        a(z5);
        a(gVar);
    }

    public boolean d() {
        return this.f40582b;
    }

    public g e() {
        return this.f40583c;
    }

    public void a(int i6) {
        this.f40581a = i6;
    }

    public void a(boolean z5) {
        this.f40582b = z5;
    }

    public void a(g gVar) {
        this.f40583c = gVar;
    }
}
