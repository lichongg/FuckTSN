package org.junit.internal.runners;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import org.junit.internal.AssumptionViolatedException;
import org.junit.runner.Description;
import org.junit.runner.notification.Failure;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Deprecated
/* loaded from: D:\Downloads\app\classes7.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private org.junit.runner.notification.a f51391a;

    /* renamed from: b, reason: collision with root package name */
    private i f51392b;

    /* renamed from: c, reason: collision with root package name */
    private Description f51393c;

    /* renamed from: d, reason: collision with root package name */
    private final Runnable f51394d;

    private void b() {
        Iterator<Method> it = this.f51392b.a().iterator();
        while (it.hasNext()) {
            try {
                it.next().invoke(null, null);
            } catch (InvocationTargetException e6) {
                a(e6.getTargetException());
            } catch (Throwable th) {
                a(th);
            }
        }
    }

    private void c() throws c {
        try {
            try {
                Iterator<Method> it = this.f51392b.c().iterator();
                while (it.hasNext()) {
                    it.next().invoke(null, null);
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

    protected void a(Throwable th) {
        this.f51391a.f(new Failure(this.f51393c, th));
    }

    protected void e() {
        this.f51394d.run();
    }

    public a(org.junit.runner.notification.a aVar, i iVar, Description description, Runnable runnable) {
        this.f51391a = aVar;
        this.f51392b = iVar;
        this.f51393c = description;
        this.f51394d = runnable;
    }

    public void d() {
        try {
            c();
            e();
        } catch (c unused) {
        } finally {
            b();
        }
    }
}
