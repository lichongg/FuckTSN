package org.hamcrest.internal;

import java.lang.reflect.Method;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private final String f51308a;

    /* renamed from: b, reason: collision with root package name */
    private final int f51309b;

    /* renamed from: c, reason: collision with root package name */
    private final int f51310c;

    public Class<?> c(Class<?> cls) {
        while (cls != Object.class) {
            for (Method method : cls.getDeclaredMethods()) {
                if (a(method)) {
                    return b(method);
                }
            }
            cls = cls.getSuperclass();
        }
        throw new Error("Cannot determine correct type for " + this.f51308a + "() method.");
    }

    public b(String str, int i6, int i7) {
        this.f51308a = str;
        this.f51309b = i6;
        this.f51310c = i7;
    }

    protected boolean a(Method method) {
        if (method.getName().equals(this.f51308a) && method.getParameterTypes().length == this.f51309b && !method.isSynthetic()) {
            return true;
        }
        return false;
    }

    protected Class<?> b(Method method) {
        return method.getParameterTypes()[this.f51310c];
    }
}
