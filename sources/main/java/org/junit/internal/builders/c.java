package org.junit.internal.builders;

import org.junit.Ignore;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class c extends org.junit.runners.model.f {
    @Override // org.junit.runners.model.f
    public org.junit.runner.g c(Class<?> cls) {
        if (cls.getAnnotation(Ignore.class) != null) {
            return new d(cls);
        }
        return null;
    }
}
