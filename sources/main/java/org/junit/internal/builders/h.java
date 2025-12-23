package org.junit.internal.builders;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class h extends org.junit.runners.model.f {
    public boolean h(Class<?> cls) {
        try {
            cls.getMethod(junit.runner.a.f43495b, null);
            return true;
        } catch (NoSuchMethodException unused) {
            return false;
        }
    }

    @Override // org.junit.runners.model.f
    public org.junit.runner.g c(Class<?> cls) throws Throwable {
        if (h(cls)) {
            return new org.junit.internal.runners.h(cls);
        }
        return null;
    }
}
