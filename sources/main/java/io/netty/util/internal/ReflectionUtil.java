package io.netty.util.internal;

import java.lang.reflect.AccessibleObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class ReflectionUtil {
    public static Throwable trySetAccessible(AccessibleObject accessibleObject, boolean z5) {
        if (z5 && !PlatformDependent0.isExplicitTryReflectionSetAccessible()) {
            return new UnsupportedOperationException("Reflective setAccessible(true) disabled");
        }
        try {
            accessibleObject.setAccessible(true);
            return null;
        } catch (SecurityException e6) {
            return e6;
        } catch (RuntimeException e7) {
            return handleInaccessibleObjectException(e7);
        }
    }

    private ReflectionUtil() {
    }

    private static RuntimeException handleInaccessibleObjectException(RuntimeException runtimeException) {
        if ("java.lang.reflect.InaccessibleObjectException".equals(runtimeException.getClass().getName())) {
            return runtimeException;
        }
        throw runtimeException;
    }
}
