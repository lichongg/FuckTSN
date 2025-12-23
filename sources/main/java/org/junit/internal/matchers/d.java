package org.junit.internal.matchers;

import java.lang.reflect.Method;
import org.junit.internal.f;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Deprecated
/* loaded from: D:\Downloads\app\classes7.dex */
public abstract class d<T> extends org.hamcrest.b<T> {

    /* renamed from: a, reason: collision with root package name */
    private Class<?> f51390a;

    protected d() {
        this.f51390a = d(getClass());
    }

    public abstract boolean f(T t5);

    private static Class<?> d(Class<?> cls) {
        while (cls != Object.class) {
            for (Method method : f.a(cls)) {
                if (e(method)) {
                    return method.getParameterTypes()[0];
                }
            }
            cls = cls.getSuperclass();
        }
        throw new Error("Cannot determine correct type for matchesSafely() method.");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.hamcrest.j
    public final boolean c(Object obj) {
        return obj != 0 && this.f51390a.isInstance(obj) && f(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected d(Class<T> cls) {
        this.f51390a = cls;
    }

    private static boolean e(Method method) {
        if (method.getName().equals("matchesSafely") && method.getParameterTypes().length == 1 && !method.isSynthetic()) {
            return true;
        }
        return false;
    }
}
