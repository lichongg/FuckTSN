package org.junit.internal.builders;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class e extends org.junit.runners.model.f {
    boolean h(Class<?> cls) {
        return junit.framework.g.class.isAssignableFrom(cls);
    }

    @Override // org.junit.runners.model.f
    public org.junit.runner.g c(Class<?> cls) throws Throwable {
        if (h(cls)) {
            return new org.junit.internal.runners.d(cls);
        }
        return null;
    }
}
