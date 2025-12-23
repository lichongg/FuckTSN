package org.junit.rules;

import java.util.concurrent.TimeUnit;
import org.junit.AssumptionViolatedException;
import org.junit.runner.Description;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public abstract class i implements l {

    /* renamed from: a, reason: collision with root package name */
    private final b f51468a;

    /* renamed from: b, reason: collision with root package name */
    private volatile long f51469b;

    /* renamed from: c, reason: collision with root package name */
    private volatile long f51470c;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static /* synthetic */ class a {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class c extends m {
        private c() {
        }

        /* synthetic */ c(i iVar, a aVar) {
            this();
        }

        @Override // org.junit.rules.m
        protected void g(Throwable th, Description description) {
            i.this.k();
            i iVar = i.this;
            iVar.e(iVar.g(), th, description);
        }

        @Override // org.junit.rules.m
        protected void i(Description description) {
            i iVar = i.this;
            iVar.f(iVar.g(), description);
        }

        @Override // org.junit.rules.m
        protected void k(AssumptionViolatedException assumptionViolatedException, Description description) {
            i.this.k();
            i iVar = i.this;
            iVar.i(iVar.g(), assumptionViolatedException, description);
        }

        @Override // org.junit.rules.m
        protected void n(Description description) {
            i.this.j();
        }

        @Override // org.junit.rules.m
        protected void p(Description description) {
            i.this.k();
            i iVar = i.this;
            iVar.l(iVar.g(), description);
        }
    }

    public i() {
        this(new b());
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class b {
        b() {
        }

        public long a() {
            return System.nanoTime();
        }
    }

    i(b bVar) {
        this.f51468a = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long g() {
        if (this.f51469b == 0) {
            throw new IllegalStateException("Test has not started");
        }
        long j6 = this.f51470c;
        if (j6 == 0) {
            j6 = this.f51468a.a();
        }
        return j6 - this.f51469b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        this.f51469b = this.f51468a.a();
        this.f51470c = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        this.f51470c = this.f51468a.a();
    }

    @Override // org.junit.rules.l
    public final org.junit.runners.model.h a(org.junit.runners.model.h hVar, Description description) {
        return new c(this, null).a(hVar, description);
    }

    public long h(TimeUnit timeUnit) {
        return timeUnit.convert(g(), TimeUnit.NANOSECONDS);
    }

    protected void f(long j6, Description description) {
    }

    protected void l(long j6, Description description) {
    }

    protected void e(long j6, Throwable th, Description description) {
    }

    protected void i(long j6, AssumptionViolatedException assumptionViolatedException, Description description) {
    }
}
