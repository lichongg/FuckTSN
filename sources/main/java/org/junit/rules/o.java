package org.junit.rules;

import java.util.concurrent.TimeUnit;
import org.junit.runner.Description;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class o implements l {

    /* renamed from: a, reason: collision with root package name */
    private final long f51481a;

    /* renamed from: b, reason: collision with root package name */
    private final TimeUnit f51482b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f51483c;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends org.junit.runners.model.h {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Exception f51484a;

        a(Exception exc) {
            this.f51484a = exc;
        }

        @Override // org.junit.runners.model.h
        public void a() throws Throwable {
            throw new RuntimeException("Invalid parameters for Timeout", this.f51484a);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private boolean f51486a = false;

        /* renamed from: b, reason: collision with root package name */
        private long f51487b = 0;

        /* renamed from: c, reason: collision with root package name */
        private TimeUnit f51488c = TimeUnit.SECONDS;

        public o a() {
            return new o(this);
        }

        protected boolean b() {
            return this.f51486a;
        }

        protected TimeUnit c() {
            return this.f51488c;
        }

        protected long d() {
            return this.f51487b;
        }

        public b e(boolean z5) {
            this.f51486a = z5;
            return this;
        }

        public b f(long j6, TimeUnit timeUnit) {
            this.f51487b = j6;
            this.f51488c = timeUnit;
            return this;
        }

        protected b() {
        }
    }

    @Deprecated
    public o(int i6) {
        this(i6, TimeUnit.MILLISECONDS);
    }

    public o(long j6, TimeUnit timeUnit) {
        this.f51481a = j6;
        this.f51482b = timeUnit;
        this.f51483c = false;
    }

    public static b b() {
        return new b();
    }

    public static o f(long j6) {
        return new o(j6, TimeUnit.MILLISECONDS);
    }

    public static o g(long j6) {
        return new o(j6, TimeUnit.SECONDS);
    }

    protected final boolean d() {
        return this.f51483c;
    }

    protected final long e(TimeUnit timeUnit) {
        return timeUnit.convert(this.f51481a, this.f51482b);
    }

    @Override // org.junit.rules.l
    public org.junit.runners.model.h a(org.junit.runners.model.h hVar, Description description) {
        try {
            return c(hVar);
        } catch (Exception e6) {
            return new a(e6);
        }
    }

    protected org.junit.runners.model.h c(org.junit.runners.model.h hVar) throws Exception {
        return org.junit.internal.runners.statements.c.c().f(this.f51481a, this.f51482b).e(this.f51483c).d(hVar);
    }

    protected o(b bVar) {
        this.f51481a = bVar.d();
        this.f51482b = bVar.c();
        this.f51483c = bVar.b();
    }
}
