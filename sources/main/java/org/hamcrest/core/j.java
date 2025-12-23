package org.hamcrest.core;

import org.hamcrest.Factory;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class j extends org.hamcrest.h<Object> {

    /* renamed from: a, reason: collision with root package name */
    private final Class<?> f51293a;

    /* renamed from: b, reason: collision with root package name */
    private final Class<?> f51294b;

    @Override // org.hamcrest.h
    protected boolean d(Object obj, org.hamcrest.g gVar) {
        if (obj == null) {
            gVar.b("null");
            return false;
        }
        if (this.f51294b.isInstance(obj)) {
            return true;
        }
        gVar.c(obj).b(" is a " + obj.getClass().getName());
        return false;
    }

    @Factory
    public static <T> org.hamcrest.j<T> e(Class<T> cls) {
        return new j(cls);
    }

    @Factory
    public static <T> org.hamcrest.j<T> f(Class<?> cls) {
        return new j(cls);
    }

    private static Class<?> g(Class<?> cls) {
        return Boolean.TYPE.equals(cls) ? Boolean.class : Byte.TYPE.equals(cls) ? Byte.class : Character.TYPE.equals(cls) ? Character.class : Double.TYPE.equals(cls) ? Double.class : Float.TYPE.equals(cls) ? Float.class : Integer.TYPE.equals(cls) ? Integer.class : Long.TYPE.equals(cls) ? Long.class : Short.TYPE.equals(cls) ? Short.class : cls;
    }

    @Override // org.hamcrest.l
    public void describeTo(org.hamcrest.g gVar) {
        gVar.b("an instance of ").b(this.f51293a.getName());
    }

    public j(Class<?> cls) {
        this.f51293a = cls;
        this.f51294b = g(cls);
    }
}
