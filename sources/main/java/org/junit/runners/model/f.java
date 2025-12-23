package org.junit.runners.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public abstract class f {

    /* renamed from: a, reason: collision with root package name */
    private final Set<Class<?>> f51558a = new HashSet();

    public abstract org.junit.runner.g c(Class<?> cls) throws Throwable;

    public List<org.junit.runner.g> d(Class<?> cls, List<Class<?>> list) throws InitializationError {
        return e(cls, (Class[]) list.toArray(new Class[0]));
    }

    private List<org.junit.runner.g> f(Class<?>[] clsArr) {
        ArrayList arrayList = new ArrayList();
        for (Class<?> cls : clsArr) {
            org.junit.runner.g g6 = g(cls);
            if (g6 != null) {
                arrayList.add(g6);
            }
        }
        return arrayList;
    }

    Class<?> a(Class<?> cls) throws InitializationError {
        if (this.f51558a.add(cls)) {
            return cls;
        }
        throw new InitializationError(String.format("class '%s' (possibly indirectly) contains itself as a SuiteClass", cls.getName()));
    }

    void b(Class<?> cls) {
        this.f51558a.remove(cls);
    }

    public List<org.junit.runner.g> e(Class<?> cls, Class<?>[] clsArr) throws InitializationError {
        a(cls);
        try {
            return f(clsArr);
        } finally {
            b(cls);
        }
    }

    public org.junit.runner.g g(Class<?> cls) {
        try {
            return c(cls);
        } catch (Throwable th) {
            return new org.junit.internal.runners.b(cls, th);
        }
    }
}
