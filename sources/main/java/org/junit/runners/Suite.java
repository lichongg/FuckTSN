package org.junit.runners;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Collections;
import java.util.List;
import org.junit.runner.Description;
import org.junit.runner.g;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.f;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class Suite extends d<g> {

    /* renamed from: f, reason: collision with root package name */
    private final List<g> f51536f;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @Target({ElementType.TYPE})
    @Inherited
    @Retention(RetentionPolicy.RUNTIME)
    public @interface SuiteClasses {
        Class<?>[] value();
    }

    public Suite(Class<?> cls, f fVar) throws InitializationError {
        this(fVar, cls, H(cls));
    }

    public Suite(f fVar, Class<?>[] clsArr) throws InitializationError {
        this((Class<?>) null, fVar.e(null, clsArr));
    }

    public static g G() {
        try {
            return new Suite((Class<?>) null, (Class<?>[]) new Class[0]);
        } catch (InitializationError unused) {
            throw new RuntimeException("This shouldn't be possible");
        }
    }

    private static Class<?>[] H(Class<?> cls) throws InitializationError {
        SuiteClasses suiteClasses = (SuiteClasses) cls.getAnnotation(SuiteClasses.class);
        if (suiteClasses != null) {
            return suiteClasses.value();
        }
        throw new InitializationError(String.format("class '%s' must have a SuiteClasses annotation", cls.getName()));
    }

    @Override // org.junit.runners.d
    protected List<g> o() {
        return this.f51536f;
    }

    protected Suite(Class<?> cls, Class<?>[] clsArr) throws InitializationError {
        this(new org.junit.internal.builders.a(true), cls, clsArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.junit.runners.d
    /* renamed from: F, reason: merged with bridge method [inline-methods] */
    public Description n(g gVar) {
        return gVar.getDescription();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.junit.runners.d
    /* renamed from: I, reason: merged with bridge method [inline-methods] */
    public void u(g gVar, org.junit.runner.notification.a aVar) {
        gVar.a(aVar);
    }

    protected Suite(f fVar, Class<?> cls, Class<?>[] clsArr) throws InitializationError {
        this(cls, fVar.e(cls, clsArr));
    }

    protected Suite(Class<?> cls, List<g> list) throws InitializationError {
        super(cls);
        this.f51536f = Collections.unmodifiableList(list);
    }
}
