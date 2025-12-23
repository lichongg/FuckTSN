package org.junit.runners.model;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class d extends c<d> {

    /* renamed from: a, reason: collision with root package name */
    private final Method f51553a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends org.junit.internal.runners.model.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f51554a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Object[] f51555b;

        a(Object obj, Object[] objArr) throws InvocationTargetException, IllegalAccessException {
            this.f51554a = obj;
            this.f51555b = objArr;
        }

        @Override // org.junit.internal.runners.model.b
        protected Object b() throws Throwable {
            return d.this.f51553a.invoke(this.f51554a, this.f51555b);
        }
    }

    private Class<?>[] j() {
        return this.f51553a.getParameterTypes();
    }

    @Override // org.junit.runners.model.c
    public Class<?> a() {
        return this.f51553a.getDeclaringClass();
    }

    @Override // org.junit.runners.model.c
    protected int b() {
        return this.f51553a.getModifiers();
    }

    @Override // org.junit.runners.model.c
    public String c() {
        return this.f51553a.getName();
    }

    public boolean equals(Object obj) {
        if (d.class.isInstance(obj)) {
            return ((d) obj).f51553a.equals(this.f51553a);
        }
        return false;
    }

    @Override // org.junit.runners.model.a
    public <T extends Annotation> T getAnnotation(Class<T> cls) {
        return (T) this.f51553a.getAnnotation(cls);
    }

    @Override // org.junit.runners.model.a
    public Annotation[] getAnnotations() {
        return this.f51553a.getAnnotations();
    }

    public int hashCode() {
        return this.f51553a.hashCode();
    }

    public Method i() {
        return this.f51553a;
    }

    public Class<?> k() {
        return this.f51553a.getReturnType();
    }

    public Object l(Object obj, Object... objArr) throws Throwable {
        return new a(obj, objArr).a();
    }

    public void o(List<Throwable> list) {
        new e(this.f51553a).a(list);
    }

    public String toString() {
        return this.f51553a.toString();
    }

    public d(Method method) {
        if (method != null) {
            this.f51553a = method;
            return;
        }
        throw new NullPointerException("FrameworkMethod cannot be created without an underlying method.");
    }

    @Override // org.junit.runners.model.c
    public Class<?> getType() {
        return k();
    }

    @Override // org.junit.runners.model.c
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public boolean f(d dVar) {
        if (!dVar.c().equals(c()) || dVar.j().length != j().length) {
            return false;
        }
        for (int i6 = 0; i6 < dVar.j().length; i6++) {
            if (!dVar.j()[i6].equals(j()[i6])) {
                return false;
            }
        }
        return true;
    }

    @Deprecated
    public boolean n(Type type) {
        if (j().length == 0 && (type instanceof Class) && ((Class) type).isAssignableFrom(this.f51553a.getReturnType())) {
            return true;
        }
        return false;
    }

    public void p(boolean z5, List<Throwable> list) {
        String str;
        if (g() != z5) {
            if (z5) {
                str = "should";
            } else {
                str = "should not";
            }
            list.add(new Exception("Method " + this.f51553a.getName() + "() " + str + " be static"));
        }
        if (!d()) {
            list.add(new Exception("Method " + this.f51553a.getName() + "() should be public"));
        }
        if (this.f51553a.getReturnType() != Void.TYPE) {
            list.add(new Exception("Method " + this.f51553a.getName() + "() should be void"));
        }
    }

    public void q(boolean z5, List<Throwable> list) {
        p(z5, list);
        if (this.f51553a.getParameterTypes().length != 0) {
            list.add(new Exception("Method " + this.f51553a.getName() + " should have no parameters"));
        }
    }
}
