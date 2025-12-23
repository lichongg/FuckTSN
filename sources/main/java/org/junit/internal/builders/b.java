package org.junit.internal.builders;

import java.lang.reflect.Modifier;
import org.junit.runner.RunWith;
import org.junit.runners.model.InitializationError;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class b extends org.junit.runners.model.f {

    /* renamed from: c, reason: collision with root package name */
    private static final String f51380c = "Custom runner class %s should have a public constructor with signature %s(Class testClass)";

    /* renamed from: b, reason: collision with root package name */
    private final org.junit.runners.model.f f51381b;

    @Override // org.junit.runners.model.f
    public org.junit.runner.g c(Class<?> cls) throws Exception {
        Class<?> cls2 = cls;
        while (cls2 != null) {
            RunWith runWith = (RunWith) cls2.getAnnotation(RunWith.class);
            if (runWith != null) {
                return h(runWith.value(), cls);
            }
            cls2 = i(cls2);
        }
        return null;
    }

    public org.junit.runner.g h(Class<? extends org.junit.runner.g> cls, Class<?> cls2) throws Exception {
        try {
            return cls.getConstructor(Class.class).newInstance(cls2);
        } catch (NoSuchMethodException unused) {
            try {
                return cls.getConstructor(Class.class, org.junit.runners.model.f.class).newInstance(cls2, this.f51381b);
            } catch (NoSuchMethodException unused2) {
                String simpleName = cls.getSimpleName();
                throw new InitializationError(String.format(f51380c, simpleName, simpleName));
            }
        }
    }

    public b(org.junit.runners.model.f fVar) {
        this.f51381b = fVar;
    }

    private Class<?> i(Class<?> cls) {
        if (cls.isMemberClass() && !Modifier.isStatic(cls.getModifiers())) {
            return cls.getEnclosingClass();
        }
        return null;
    }
}
