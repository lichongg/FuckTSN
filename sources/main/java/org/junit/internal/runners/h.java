package org.junit.internal.runners;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class h extends d {
    public static junit.framework.f k(Class<?> cls) throws Throwable {
        try {
            Method method = cls.getMethod(junit.runner.a.f43495b, null);
            if (Modifier.isStatic(method.getModifiers())) {
                return (junit.framework.f) method.invoke(null, null);
            }
            throw new Exception(cls.getName() + ".suite() must be static");
        } catch (InvocationTargetException e6) {
            throw e6.getCause();
        }
    }

    public h(Class<?> cls) throws Throwable {
        super(k(cls));
    }
}
