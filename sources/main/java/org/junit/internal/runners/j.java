package org.junit.internal.runners;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Deprecated
/* loaded from: D:\Downloads\app\classes7.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    private final Method f51416a;

    /* renamed from: b, reason: collision with root package name */
    private i f51417b;

    List<Method> b() {
        return this.f51417b.b(After.class);
    }

    List<Method> c() {
        return this.f51417b.b(Before.class);
    }

    protected Class<? extends Throwable> d() {
        Test test = (Test) this.f51416a.getAnnotation(Test.class);
        if (test == null || test.expected() == Test.None.class) {
            return null;
        }
        return test.expected();
    }

    public long e() {
        Test test = (Test) this.f51416a.getAnnotation(Test.class);
        if (test == null) {
            return 0L;
        }
        return test.timeout();
    }

    public void f(Object obj) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
        this.f51416a.invoke(obj, null);
    }

    public boolean g() {
        return this.f51416a.getAnnotation(Ignore.class) != null;
    }

    public j(Method method, i iVar) {
        this.f51416a = method;
        this.f51417b = iVar;
    }

    boolean a() {
        if (d() != null) {
            return true;
        }
        return false;
    }

    boolean h(Throwable th) {
        return !d().isAssignableFrom(th.getClass());
    }
}
