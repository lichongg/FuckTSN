package org.junit.runners.model;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class b extends c<b> {

    /* renamed from: a, reason: collision with root package name */
    private final Field f51552a;

    @Override // org.junit.runners.model.c
    public Class<?> a() {
        return this.f51552a.getDeclaringClass();
    }

    @Override // org.junit.runners.model.c
    protected int b() {
        return this.f51552a.getModifiers();
    }

    @Override // org.junit.runners.model.a
    public <T extends Annotation> T getAnnotation(Class<T> cls) {
        return (T) this.f51552a.getAnnotation(cls);
    }

    @Override // org.junit.runners.model.a
    public Annotation[] getAnnotations() {
        return this.f51552a.getAnnotations();
    }

    @Override // org.junit.runners.model.c
    public Class<?> getType() {
        return this.f51552a.getType();
    }

    public Object h(Object obj) throws IllegalArgumentException, IllegalAccessException {
        return this.f51552a.get(obj);
    }

    public Field i() {
        return this.f51552a;
    }

    public String toString() {
        return this.f51552a.toString();
    }

    b(Field field) {
        if (field != null) {
            this.f51552a = field;
            return;
        }
        throw new NullPointerException("FrameworkField cannot be created without an underlying field.");
    }

    @Override // org.junit.runners.model.c
    public String c() {
        return i().getName();
    }

    @Override // org.junit.runners.model.c
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public boolean f(b bVar) {
        return bVar.c().equals(c());
    }
}
