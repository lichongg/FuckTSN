package org.junit.internal.runners;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.junit.runner.Description;
import org.junit.runner.notification.Failure;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class b extends org.junit.runner.g {

    /* renamed from: a, reason: collision with root package name */
    private final List<Throwable> f51395a;

    /* renamed from: b, reason: collision with root package name */
    private final Class<?> f51396b;

    private Description e(Throwable th) {
        return Description.createTestDescription(this.f51396b, "initializationError");
    }

    private List<Throwable> f(Throwable th) {
        return th instanceof InvocationTargetException ? f(th.getCause()) : th instanceof org.junit.runners.model.InitializationError ? ((org.junit.runners.model.InitializationError) th).getCauses() : th instanceof InitializationError ? ((InitializationError) th).getCauses() : Arrays.asList(th);
    }

    @Override // org.junit.runner.g
    public void a(org.junit.runner.notification.a aVar) {
        Iterator<Throwable> it = this.f51395a.iterator();
        while (it.hasNext()) {
            g(it.next(), aVar);
        }
    }

    @Override // org.junit.runner.g, org.junit.runner.b
    public Description getDescription() {
        Description createSuiteDescription = Description.createSuiteDescription(this.f51396b);
        Iterator<Throwable> it = this.f51395a.iterator();
        while (it.hasNext()) {
            createSuiteDescription.addChild(e(it.next()));
        }
        return createSuiteDescription;
    }

    public b(Class<?> cls, Throwable th) {
        if (cls != null) {
            this.f51396b = cls;
            this.f51395a = f(th);
            return;
        }
        throw new NullPointerException("Test class cannot be null");
    }

    private void g(Throwable th, org.junit.runner.notification.a aVar) {
        Description e6 = e(th);
        aVar.l(e6);
        aVar.f(new Failure(e6, th));
        aVar.h(e6);
    }
}
