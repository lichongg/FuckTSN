package org.junit.runner.notification;

import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.RunListener;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RunListener.ThreadSafe
/* loaded from: D:\Downloads\app\classes7.dex */
final class b extends RunListener {

    /* renamed from: a, reason: collision with root package name */
    private final RunListener f51531a;

    /* renamed from: b, reason: collision with root package name */
    private final Object f51532b;

    @Override // org.junit.runner.notification.RunListener
    public void a(Failure failure) {
        synchronized (this.f51532b) {
            this.f51531a.a(failure);
        }
    }

    @Override // org.junit.runner.notification.RunListener
    public void b(Failure failure) throws Exception {
        synchronized (this.f51532b) {
            this.f51531a.b(failure);
        }
    }

    @Override // org.junit.runner.notification.RunListener
    public void c(Description description) throws Exception {
        synchronized (this.f51532b) {
            this.f51531a.c(description);
        }
    }

    @Override // org.junit.runner.notification.RunListener
    public void d(Description description) throws Exception {
        synchronized (this.f51532b) {
            this.f51531a.d(description);
        }
    }

    @Override // org.junit.runner.notification.RunListener
    public void e(Result result) throws Exception {
        synchronized (this.f51532b) {
            this.f51531a.e(result);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof b) {
            return this.f51531a.equals(((b) obj).f51531a);
        }
        return false;
    }

    @Override // org.junit.runner.notification.RunListener
    public void f(Description description) throws Exception {
        synchronized (this.f51532b) {
            this.f51531a.f(description);
        }
    }

    @Override // org.junit.runner.notification.RunListener
    public void g(Description description) throws Exception {
        synchronized (this.f51532b) {
            this.f51531a.g(description);
        }
    }

    public int hashCode() {
        return this.f51531a.hashCode();
    }

    public String toString() {
        return this.f51531a.toString() + " (with synchronization wrapper)";
    }

    b(RunListener runListener, Object obj) {
        this.f51531a = runListener;
        this.f51532b = obj;
    }
}
