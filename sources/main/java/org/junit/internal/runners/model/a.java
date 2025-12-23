package org.junit.internal.runners.model;

import java.util.Iterator;
import org.junit.internal.AssumptionViolatedException;
import org.junit.runner.Description;
import org.junit.runner.notification.Failure;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private final org.junit.runner.notification.a f51418a;

    /* renamed from: b, reason: collision with root package name */
    private final Description f51419b;

    public void a(AssumptionViolatedException assumptionViolatedException) {
        this.f51418a.e(new Failure(this.f51419b, assumptionViolatedException));
    }

    public void b(Throwable th) {
        if (th instanceof org.junit.runners.model.MultipleFailureException) {
            c((org.junit.runners.model.MultipleFailureException) th);
        } else {
            this.f51418a.f(new Failure(this.f51419b, th));
        }
    }

    public void d() {
        this.f51418a.h(this.f51419b);
    }

    public void e() {
        this.f51418a.i(this.f51419b);
    }

    public void f() {
        this.f51418a.l(this.f51419b);
    }

    public a(org.junit.runner.notification.a aVar, Description description) {
        this.f51418a = aVar;
        this.f51419b = description;
    }

    private void c(org.junit.runners.model.MultipleFailureException multipleFailureException) {
        Iterator<Throwable> it = multipleFailureException.getFailures().iterator();
        while (it.hasNext()) {
            b(it.next());
        }
    }
}
