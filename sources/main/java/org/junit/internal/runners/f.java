package org.junit.internal.runners;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.junit.internal.AssumptionViolatedException;
import org.junit.runner.Description;
import org.junit.runner.notification.Failure;
import org.junit.runners.model.TestTimedOutException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Deprecated
/* loaded from: D:\Downloads\app\classes7.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private final Object f51405a;

    /* renamed from: b, reason: collision with root package name */
    private final org.junit.runner.notification.a f51406b;

    /* renamed from: c, reason: collision with root package name */
    private final Description f51407c;

    /* renamed from: d, reason: collision with root package name */
    private j f51408d;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f51409a;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: org.junit.internal.runners.f$a$a, reason: collision with other inner class name */
        class CallableC0989a implements Callable<Object> {
            CallableC0989a() {
            }

            @Override // java.util.concurrent.Callable
            public Object call() throws Exception {
                f.this.g();
                return null;
            }
        }

        a(long j6) {
            this.f51409a = j6;
        }

        @Override // java.lang.Runnable
        public void run() {
            ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
            Future submit = newSingleThreadExecutor.submit(new CallableC0989a());
            newSingleThreadExecutor.shutdown();
            try {
                long j6 = this.f51409a;
                TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                if (!newSingleThreadExecutor.awaitTermination(j6, timeUnit)) {
                    newSingleThreadExecutor.shutdownNow();
                }
                submit.get(0L, timeUnit);
            } catch (TimeoutException unused) {
                f.this.a(new TestTimedOutException(this.f51409a, TimeUnit.MILLISECONDS));
            } catch (Exception e6) {
                f.this.a(e6);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            f.this.g();
        }
    }

    private void c() {
        Iterator<Method> it = this.f51408d.b().iterator();
        while (it.hasNext()) {
            try {
                it.next().invoke(this.f51405a, null);
            } catch (InvocationTargetException e6) {
                a(e6.getTargetException());
            } catch (Throwable th) {
                a(th);
            }
        }
    }

    private void d() throws c {
        try {
            try {
                Iterator<Method> it = this.f51408d.c().iterator();
                while (it.hasNext()) {
                    it.next().invoke(this.f51405a, null);
                }
            } catch (AssumptionViolatedException unused) {
                throw new c();
            } catch (Throwable th) {
                a(th);
                throw new c();
            }
        } catch (InvocationTargetException e6) {
            throw e6.getTargetException();
        }
    }

    private void h(long j6) {
        e(new a(j6));
    }

    protected void a(Throwable th) {
        this.f51406b.f(new Failure(this.f51407c, th));
    }

    public void b() {
        if (this.f51408d.g()) {
            this.f51406b.i(this.f51407c);
            return;
        }
        this.f51406b.l(this.f51407c);
        try {
            long e6 = this.f51408d.e();
            if (e6 > 0) {
                h(e6);
            } else {
                f();
            }
            this.f51406b.h(this.f51407c);
        } catch (Throwable th) {
            this.f51406b.h(this.f51407c);
            throw th;
        }
    }

    public void f() {
        e(new b());
    }

    protected void g() {
        try {
            this.f51408d.f(this.f51405a);
            if (this.f51408d.a()) {
                a(new AssertionError("Expected exception: " + this.f51408d.d().getName()));
            }
        } catch (InvocationTargetException e6) {
            Throwable targetException = e6.getTargetException();
            if (targetException instanceof AssumptionViolatedException) {
                return;
            }
            if (!this.f51408d.a()) {
                a(targetException);
                return;
            }
            if (this.f51408d.h(targetException)) {
                a(new Exception("Unexpected exception, expected<" + this.f51408d.d().getName() + "> but was<" + targetException.getClass().getName() + ">", targetException));
            }
        } catch (Throwable th) {
            a(th);
        }
    }

    public f(Object obj, j jVar, org.junit.runner.notification.a aVar, Description description) {
        this.f51405a = obj;
        this.f51406b = aVar;
        this.f51407c = description;
        this.f51408d = jVar;
    }

    public void e(Runnable runnable) {
        try {
            try {
                d();
                runnable.run();
                c();
            } catch (c unused) {
                c();
            } catch (Exception unused2) {
                throw new RuntimeException("test should never throw an exception to this level");
            }
        } catch (Throwable th) {
            c();
            throw th;
        }
    }
}
