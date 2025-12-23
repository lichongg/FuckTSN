package org.junit.internal.runners;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Deprecated
/* loaded from: D:\Downloads\app\classes7.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    private final Class<?> f51415a;

    private List<Class<?>> g(Class<?> cls) {
        ArrayList arrayList = new ArrayList();
        while (cls != null) {
            arrayList.add(cls);
            cls = cls.getSuperclass();
        }
        return arrayList;
    }

    private boolean k(Class<? extends Annotation> cls) {
        return cls.equals(Before.class) || cls.equals(BeforeClass.class);
    }

    List<Method> a() {
        return b(AfterClass.class);
    }

    public List<Method> b(Class<? extends Annotation> cls) {
        ArrayList arrayList = new ArrayList();
        Iterator<Class<?>> it = g(this.f51415a).iterator();
        while (it.hasNext()) {
            for (Method method : org.junit.internal.f.a(it.next())) {
                if (method.getAnnotation(cls) != null && !j(method, arrayList)) {
                    arrayList.add(method);
                }
            }
        }
        if (k(cls)) {
            Collections.reverse(arrayList);
        }
        return arrayList;
    }

    List<Method> c() {
        return b(BeforeClass.class);
    }

    public Constructor<?> d() throws SecurityException, NoSuchMethodException {
        return this.f51415a.getConstructor(null);
    }

    public Class<?> e() {
        return this.f51415a;
    }

    public String f() {
        return this.f51415a.getName();
    }

    public List<Method> h() {
        return b(Test.class);
    }

    public i(Class<?> cls) {
        this.f51415a = cls;
    }

    private boolean i(Method method, Method method2) {
        if (!method2.getName().equals(method.getName()) || method2.getParameterTypes().length != method.getParameterTypes().length) {
            return false;
        }
        for (int i6 = 0; i6 < method2.getParameterTypes().length; i6++) {
            if (!method2.getParameterTypes()[i6].equals(method.getParameterTypes()[i6])) {
                return false;
            }
        }
        return true;
    }

    private boolean j(Method method, List<Method> list) {
        Iterator<Method> it = list.iterator();
        while (it.hasNext()) {
            if (i(method, it.next())) {
                return true;
            }
        }
        return false;
    }
}
