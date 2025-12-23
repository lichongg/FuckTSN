package org.junit.internal.runners;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Deprecated
/* loaded from: D:\Downloads\app\classes7.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private final List<Throwable> f51413a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    private i f51414b;

    private void f(Class<? extends Annotation> cls, boolean z5) {
        for (Method method : this.f51414b.b(cls)) {
            if (Modifier.isStatic(method.getModifiers()) != z5) {
                String str = z5 ? "should" : "should not";
                this.f51413a.add(new Exception("Method " + method.getName() + "() " + str + " be static"));
            }
            if (!Modifier.isPublic(method.getDeclaringClass().getModifiers())) {
                this.f51413a.add(new Exception("Class " + method.getDeclaringClass().getName() + " should be public"));
            }
            if (!Modifier.isPublic(method.getModifiers())) {
                this.f51413a.add(new Exception("Method " + method.getName() + " should be public"));
            }
            if (method.getReturnType() != Void.TYPE) {
                this.f51413a.add(new Exception("Method " + method.getName() + " should be void"));
            }
            if (method.getParameterTypes().length != 0) {
                this.f51413a.add(new Exception("Method " + method.getName() + " should have no parameters"));
            }
        }
    }

    public void a() throws InitializationError {
        if (!this.f51413a.isEmpty()) {
            throw new InitializationError(this.f51413a);
        }
    }

    public void b() {
        f(After.class, false);
        f(Before.class, false);
        f(Test.class, false);
        if (this.f51414b.b(Test.class).size() == 0) {
            this.f51413a.add(new Exception("No runnable methods"));
        }
    }

    public void d() {
        try {
            this.f51414b.d();
        } catch (Exception e6) {
            this.f51413a.add(new Exception("Test class should have public zero-argument constructor", e6));
        }
    }

    public void e() {
        f(BeforeClass.class, true);
        f(AfterClass.class, true);
    }

    public g(i iVar) {
        this.f51414b = iVar;
    }

    public List<Throwable> c() {
        d();
        e();
        b();
        return this.f51413a;
    }
}
